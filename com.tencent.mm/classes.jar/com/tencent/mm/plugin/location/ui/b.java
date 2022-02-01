package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private Context mContext;
  private i vbj;
  private MMGridPaper vbk;
  private a vbl;
  private ViewGroup vbm;
  private RelativeLayout vbn;
  private ArrayList<String> vbo;
  private int vbp;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.vbj = null;
    this.vbk = null;
    this.vbl = null;
    this.vbm = null;
    this.vbn = null;
    this.mContext = null;
    this.vbo = null;
    this.vbp = 0;
    this.mContext = paramContext;
    this.vbj = new i(this.mContext, 2131821760);
    this.vbm = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493127, null));
    this.vbk = ((MMGridPaper)this.vbm.findViewById(2131299121));
    this.vbk.fyG();
    this.vbk.setDialogMode(true);
    this.vbk.fyF();
    this.vbk.setMaxRow(3);
    this.vbk.setMaxCol(3);
    this.vbk.setHeaderView(null);
    this.vbk.fyG();
    this.vbk.setItemWidthInDp(70);
    this.vbk.setItemHeightInDp(70);
    this.vbj.setCanceledOnTouchOutside(true);
    this.vbj.setContentView(this.vbm);
    this.vbl = new a();
    this.vbk.setGridPaperAdapter(this.vbl);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    ad.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.vbo = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.vbo.add(str);
    }
    int i;
    if (paramContext.vbo.size() < 3)
    {
      paramContext.vbk.setMaxCol(paramContext.vbo.size());
      paramArrayList = paramContext.vbk.getLayoutParams();
      paramContext.vbp = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.vbo.size() <= 0) {
        break label443;
      }
      if (paramContext.vbo.size() >= 3) {
        break label376;
      }
      int j = paramContext.vbp;
      int k = paramContext.vbo.size();
      i = i * (paramContext.vbo.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.b.ix(paramContext.mContext);
      ad.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.vbo.size()), Integer.valueOf(paramContext.vbp), str });
      paramArrayList.width = i;
      paramContext.vbp = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.vbo.size() > 0) {
        if (paramContext.vbo.size() <= 3)
        {
          i += paramContext.vbp;
          label303:
          ad.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.vbk.setLayoutParams(paramArrayList);
        paramContext.vbk.requestLayout();
        paramContext.vbl.setData(paramContext.vbo);
        paramContext.vbj.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.vbk.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.vbp * 3;
        break label192;
        if (paramContext.vbo.size() <= 6)
        {
          i += paramContext.vbp * 2;
          break label303;
        }
        i = i * 2 + paramContext.vbp * 3 + com.tencent.mm.cc.a.fromDPToPix(paramContext.mContext, 10);
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