package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private Context mContext;
  private int vnA;
  private i vnu;
  private MMGridPaper vnv;
  private a vnw;
  private ViewGroup vnx;
  private RelativeLayout vny;
  private ArrayList<String> vnz;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.vnu = null;
    this.vnv = null;
    this.vnw = null;
    this.vnx = null;
    this.vny = null;
    this.mContext = null;
    this.vnz = null;
    this.vnA = 0;
    this.mContext = paramContext;
    this.vnu = new i(this.mContext, 2131821760);
    this.vnx = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493127, null));
    this.vnv = ((MMGridPaper)this.vnx.findViewById(2131299121));
    this.vnv.fCI();
    this.vnv.setDialogMode(true);
    this.vnv.fCH();
    this.vnv.setMaxRow(3);
    this.vnv.setMaxCol(3);
    this.vnv.setHeaderView(null);
    this.vnv.fCI();
    this.vnv.setItemWidthInDp(70);
    this.vnv.setItemHeightInDp(70);
    this.vnu.setCanceledOnTouchOutside(true);
    this.vnu.setContentView(this.vnx);
    this.vnw = new a();
    this.vnv.setGridPaperAdapter(this.vnw);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    ae.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.vnz = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.vnz.add(str);
    }
    int i;
    if (paramContext.vnz.size() < 3)
    {
      paramContext.vnv.setMaxCol(paramContext.vnz.size());
      paramArrayList = paramContext.vnv.getLayoutParams();
      paramContext.vnA = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.vnz.size() <= 0) {
        break label443;
      }
      if (paramContext.vnz.size() >= 3) {
        break label376;
      }
      int j = paramContext.vnA;
      int k = paramContext.vnz.size();
      i = i * (paramContext.vnz.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.b.iC(paramContext.mContext);
      ae.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.vnz.size()), Integer.valueOf(paramContext.vnA), str });
      paramArrayList.width = i;
      paramContext.vnA = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.vnz.size() > 0) {
        if (paramContext.vnz.size() <= 3)
        {
          i += paramContext.vnA;
          label303:
          ae.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.vnv.setLayoutParams(paramArrayList);
        paramContext.vnv.requestLayout();
        paramContext.vnw.setData(paramContext.vnz);
        paramContext.vnu.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.vnv.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.vnA * 3;
        break label192;
        if (paramContext.vnz.size() <= 6)
        {
          i += paramContext.vnA * 2;
          break label303;
        }
        i = i * 2 + paramContext.vnA * 3 + com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 10);
        break label303;
        i = 0;
      }
      label443:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.b
 * JD-Core Version:    0.7.0.1
 */