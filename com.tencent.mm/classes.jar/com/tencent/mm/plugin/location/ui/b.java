package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private Context mContext;
  private i yHl;
  private MMGridPaper yHm;
  private a yHn;
  private ViewGroup yHo;
  private RelativeLayout yHp;
  private ArrayList<String> yHq;
  private int yHr;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.yHl = null;
    this.yHm = null;
    this.yHn = null;
    this.yHo = null;
    this.yHp = null;
    this.mContext = null;
    this.yHq = null;
    this.yHr = 0;
    this.mContext = paramContext;
    this.yHl = new i(this.mContext, 2131821814);
    this.yHo = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493170, null));
    this.yHm = ((MMGridPaper)this.yHo.findViewById(2131299645));
    this.yHm.gKH();
    this.yHm.setDialogMode(true);
    this.yHm.gKG();
    this.yHm.setMaxRow(3);
    this.yHm.setMaxCol(3);
    this.yHm.setHeaderView(null);
    this.yHm.gKH();
    this.yHm.setItemWidthInDp(70);
    this.yHm.setItemHeightInDp(70);
    this.yHl.setCanceledOnTouchOutside(true);
    this.yHl.setContentView(this.yHo);
    this.yHn = new a();
    this.yHm.setGridPaperAdapter(this.yHn);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    Log.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.yHq = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.yHq.add(str);
    }
    int i;
    if (paramContext.yHq.size() < 3)
    {
      paramContext.yHm.setMaxCol(paramContext.yHq.size());
      paramArrayList = paramContext.yHm.getLayoutParams();
      paramContext.yHr = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.yHq.size() <= 0) {
        break label443;
      }
      if (paramContext.yHq.size() >= 3) {
        break label376;
      }
      int j = paramContext.yHr;
      int k = paramContext.yHq.size();
      i = i * (paramContext.yHq.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.BitmapFactory.getDisplayDensityType(paramContext.mContext);
      Log.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.yHq.size()), Integer.valueOf(paramContext.yHr), str });
      paramArrayList.width = i;
      paramContext.yHr = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.yHq.size() > 0) {
        if (paramContext.yHq.size() <= 3)
        {
          i += paramContext.yHr;
          label303:
          Log.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.yHm.setLayoutParams(paramArrayList);
        paramContext.yHm.requestLayout();
        paramContext.yHn.setData(paramContext.yHq);
        paramContext.yHl.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.yHm.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.yHr * 3;
        break label192;
        if (paramContext.yHq.size() <= 6)
        {
          i += paramContext.yHr * 2;
          break label303;
        }
        i = i * 2 + paramContext.yHr * 3 + com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 10);
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