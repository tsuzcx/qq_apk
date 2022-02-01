package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private Context mContext;
  private i tYA;
  private MMGridPaper tYB;
  private a tYC;
  private ViewGroup tYD;
  private RelativeLayout tYE;
  private ArrayList<String> tYF;
  private int tYG;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.tYA = null;
    this.tYB = null;
    this.tYC = null;
    this.tYD = null;
    this.tYE = null;
    this.mContext = null;
    this.tYF = null;
    this.tYG = 0;
    this.mContext = paramContext;
    this.tYA = new i(this.mContext, 2131821760);
    this.tYD = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493127, null));
    this.tYB = ((MMGridPaper)this.tYD.findViewById(2131299121));
    this.tYB.fir();
    this.tYB.setDialogMode(true);
    this.tYB.fiq();
    this.tYB.setMaxRow(3);
    this.tYB.setMaxCol(3);
    this.tYB.setHeaderView(null);
    this.tYB.fir();
    this.tYB.setItemWidthInDp(70);
    this.tYB.setItemHeightInDp(70);
    this.tYA.setCanceledOnTouchOutside(true);
    this.tYA.setContentView(this.tYD);
    this.tYC = new a();
    this.tYB.setGridPaperAdapter(this.tYC);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    ac.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.tYF = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.tYF.add(str);
    }
    int i;
    if (paramContext.tYF.size() < 3)
    {
      paramContext.tYB.setMaxCol(paramContext.tYF.size());
      paramArrayList = paramContext.tYB.getLayoutParams();
      paramContext.tYG = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.tYF.size() <= 0) {
        break label443;
      }
      if (paramContext.tYF.size() >= 3) {
        break label376;
      }
      int j = paramContext.tYG;
      int k = paramContext.tYF.size();
      i = i * (paramContext.tYF.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.b.in(paramContext.mContext);
      ac.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.tYF.size()), Integer.valueOf(paramContext.tYG), str });
      paramArrayList.width = i;
      paramContext.tYG = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.tYF.size() > 0) {
        if (paramContext.tYF.size() <= 3)
        {
          i += paramContext.tYG;
          label303:
          ac.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.tYB.setLayoutParams(paramArrayList);
        paramContext.tYB.requestLayout();
        paramContext.tYC.setData(paramContext.tYF);
        paramContext.tYA.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.tYB.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.tYG * 3;
        break label192;
        if (paramContext.tYF.size() <= 6)
        {
          i += paramContext.tYG * 2;
          break label303;
        }
        i = i * 2 + paramContext.tYG * 3 + com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 10);
        break label303;
        i = 0;
      }
      label443:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.b
 * JD-Core Version:    0.7.0.1
 */