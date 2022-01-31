package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private Context mContext;
  private i obN;
  private MMGridPaper obO;
  private a obP;
  private ViewGroup obQ;
  private RelativeLayout obR;
  private ArrayList<String> obS;
  private int obT;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(113423);
    this.obN = null;
    this.obO = null;
    this.obP = null;
    this.obQ = null;
    this.obR = null;
    this.mContext = null;
    this.obS = null;
    this.obT = 0;
    this.mContext = paramContext;
    this.obN = new i(this.mContext, 2131493912);
    this.obQ = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130968798, null));
    this.obO = ((MMGridPaper)this.obQ.findViewById(2131821600));
    this.obO.dDT();
    this.obO.setDialogMode(true);
    this.obO.dDS();
    this.obO.setMaxRow(3);
    this.obO.setMaxCol(3);
    this.obO.setHeaderView(null);
    this.obO.dDT();
    this.obO.setItemWidthInDp(70);
    this.obO.setItemHeightInDp(70);
    this.obN.setCanceledOnTouchOutside(true);
    this.obN.setContentView(this.obQ);
    this.obP = new a();
    this.obO.setGridPaperAdapter(this.obP);
    AppMethodBeat.o(113423);
  }
  
  public static void b(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(113424);
    ab.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.obS = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.obS.add(str);
    }
    int i;
    if (paramContext.obS.size() < 3)
    {
      paramContext.obO.setMaxCol(paramContext.obS.size());
      paramArrayList = paramContext.obO.getLayoutParams();
      paramContext.obT = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.obS.size() <= 0) {
        break label443;
      }
      if (paramContext.obS.size() >= 3) {
        break label376;
      }
      int j = paramContext.obT;
      int k = paramContext.obS.size();
      i = i * (paramContext.obS.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.b.gB(paramContext.mContext);
      ab.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.obS.size()), Integer.valueOf(paramContext.obT), str });
      paramArrayList.width = i;
      paramContext.obT = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.obS.size() > 0) {
        if (paramContext.obS.size() <= 3)
        {
          i += paramContext.obT;
          label303:
          ab.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.obO.setLayoutParams(paramArrayList);
        paramContext.obO.requestLayout();
        paramContext.obP.F(paramContext.obS);
        paramContext.obN.show();
        AppMethodBeat.o(113424);
        return;
        paramContext.obO.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.obT * 3;
        break label192;
        if (paramContext.obS.size() <= 6)
        {
          i += paramContext.obT * 2;
          break label303;
        }
        i = i * 2 + paramContext.obT * 3 + com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 10);
        break label303;
        i = 0;
      }
      label443:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.b
 * JD-Core Version:    0.7.0.1
 */