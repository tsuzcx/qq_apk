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
  private i sQn;
  private MMGridPaper sQo;
  private a sQp;
  private ViewGroup sQq;
  private RelativeLayout sQr;
  private ArrayList<String> sQs;
  private int sQt;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.sQn = null;
    this.sQo = null;
    this.sQp = null;
    this.sQq = null;
    this.sQr = null;
    this.mContext = null;
    this.sQs = null;
    this.sQt = 0;
    this.mContext = paramContext;
    this.sQn = new i(this.mContext, 2131821760);
    this.sQq = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493127, null));
    this.sQo = ((MMGridPaper)this.sQq.findViewById(2131299121));
    this.sQo.eSH();
    this.sQo.setDialogMode(true);
    this.sQo.eSG();
    this.sQo.setMaxRow(3);
    this.sQo.setMaxCol(3);
    this.sQo.setHeaderView(null);
    this.sQo.eSH();
    this.sQo.setItemWidthInDp(70);
    this.sQo.setItemHeightInDp(70);
    this.sQn.setCanceledOnTouchOutside(true);
    this.sQn.setContentView(this.sQq);
    this.sQp = new a();
    this.sQo.setGridPaperAdapter(this.sQp);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    ad.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.sQs = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.sQs.add(str);
    }
    int i;
    if (paramContext.sQs.size() < 3)
    {
      paramContext.sQo.setMaxCol(paramContext.sQs.size());
      paramArrayList = paramContext.sQo.getLayoutParams();
      paramContext.sQt = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.sQs.size() <= 0) {
        break label443;
      }
      if (paramContext.sQs.size() >= 3) {
        break label376;
      }
      int j = paramContext.sQt;
      int k = paramContext.sQs.size();
      i = i * (paramContext.sQs.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.b.ic(paramContext.mContext);
      ad.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.sQs.size()), Integer.valueOf(paramContext.sQt), str });
      paramArrayList.width = i;
      paramContext.sQt = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.sQs.size() > 0) {
        if (paramContext.sQs.size() <= 3)
        {
          i += paramContext.sQt;
          label303:
          ad.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.sQo.setLayoutParams(paramArrayList);
        paramContext.sQo.requestLayout();
        paramContext.sQp.setData(paramContext.sQs);
        paramContext.sQn.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.sQo.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.sQt * 3;
        break label192;
        if (paramContext.sQs.size() <= 6)
        {
          i += paramContext.sQt * 2;
          break label303;
        }
        i = i * 2 + paramContext.sQt * 3 + com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 10);
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