package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.widget.a.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private i KdO;
  private MMGridPaper KdP;
  private a KdQ;
  private ViewGroup KdR;
  private RelativeLayout KdS;
  private ArrayList<String> KdT;
  private int avatarSize;
  private Context mContext;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.KdO = null;
    this.KdP = null;
    this.KdQ = null;
    this.KdR = null;
    this.KdS = null;
    this.mContext = null;
    this.KdT = null;
    this.avatarSize = 0;
    this.mContext = paramContext;
    this.KdO = new i(this.mContext, a.j.trackDialog);
    this.KdR = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.f.avatars_dialog, null));
    this.KdP = ((MMGridPaper)this.KdR.findViewById(a.e.dialog_content));
    this.KdP.jmk();
    this.KdP.setDialogMode(true);
    this.KdP.jmj();
    this.KdP.setMaxRow(3);
    this.KdP.setMaxCol(3);
    this.KdP.setHeaderView(null);
    this.KdP.jmk();
    this.KdP.setItemWidthInDp(70);
    this.KdP.setItemHeightInDp(70);
    this.KdO.setCanceledOnTouchOutside(true);
    this.KdO.setContentView(this.KdR);
    this.KdQ = new a();
    this.KdP.setGridPaperAdapter(this.KdQ);
    AppMethodBeat.o(55799);
  }
  
  public static void e(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    Log.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.KdT = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.KdT.add(str);
    }
    int i;
    if (paramContext.KdT.size() < 3)
    {
      paramContext.KdP.setMaxCol(paramContext.KdT.size());
      paramArrayList = paramContext.KdP.getLayoutParams();
      paramContext.avatarSize = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.KdT.size() <= 0) {
        break label443;
      }
      if (paramContext.KdT.size() >= 3) {
        break label376;
      }
      int j = paramContext.avatarSize;
      int k = paramContext.KdT.size();
      i = i * (paramContext.KdT.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.BitmapFactory.getDisplayDensityType(paramContext.mContext);
      Log.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.KdT.size()), Integer.valueOf(paramContext.avatarSize), str });
      paramArrayList.width = i;
      paramContext.avatarSize = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.KdT.size() > 0) {
        if (paramContext.KdT.size() <= 3)
        {
          i += paramContext.avatarSize;
          label303:
          Log.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.KdP.setLayoutParams(paramArrayList);
        paramContext.KdP.requestLayout();
        paramContext.KdQ.setData(paramContext.KdT);
        paramContext.KdO.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.KdP.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.avatarSize * 3;
        break label192;
        if (paramContext.KdT.size() <= 6)
        {
          i += paramContext.avatarSize * 2;
          break label303;
        }
        i = i * 2 + paramContext.avatarSize * 3 + com.tencent.mm.cd.a.fromDPToPix(paramContext.mContext, 10);
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