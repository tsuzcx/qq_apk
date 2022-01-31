package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private int avatarSize = 0;
  private i lEA = null;
  private MMGridPaper lEB = null;
  private a lEC = null;
  private ViewGroup lED = null;
  private RelativeLayout lEE = null;
  private ArrayList<String> lEF = null;
  private Context mContext = null;
  
  private b(Context paramContext)
  {
    this.mContext = paramContext;
    this.lEA = new i(this.mContext, a.i.trackDialog);
    this.lED = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.f.avatars_dialog, null));
    this.lEB = ((MMGridPaper)this.lED.findViewById(a.e.dialog_content));
    this.lEB.cAI();
    this.lEB.setDialogMode(true);
    this.lEB.cAH();
    this.lEB.setMaxRow(3);
    this.lEB.setMaxCol(3);
    this.lEB.setHeaderView(null);
    this.lEB.cAI();
    this.lEB.setItemWidthInDp(70);
    this.lEB.setItemHeightInDp(70);
    this.lEA.setCanceledOnTouchOutside(true);
    this.lEA.setContentView(this.lED);
    this.lEC = new a();
    this.lEB.setGridPaperAdapter(this.lEC);
  }
  
  public static void b(Context paramContext, ArrayList<String> paramArrayList)
  {
    y.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.lEF = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.lEF.add(str);
    }
    int i;
    if (paramContext.lEF.size() < 3)
    {
      paramContext.lEB.setMaxCol(paramContext.lEF.size());
      paramArrayList = paramContext.lEB.getLayoutParams();
      paramContext.avatarSize = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.lEF.size() <= 0) {
        break label433;
      }
      if (paramContext.lEF.size() >= 3) {
        break label366;
      }
      int j = paramContext.avatarSize;
      int k = paramContext.lEF.size();
      i = i * (paramContext.lEF.size() - 1) + j * k;
    }
    for (;;)
    {
      label187:
      str = BackwardSupportUtil.b.fo(paramContext.mContext);
      y.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.lEF.size()), Integer.valueOf(paramContext.avatarSize), str });
      paramArrayList.width = i;
      paramContext.avatarSize = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.lEF.size() > 0) {
        if (paramContext.lEF.size() <= 3)
        {
          i += paramContext.avatarSize;
          label298:
          y.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.lEB.setLayoutParams(paramArrayList);
        paramContext.lEB.requestLayout();
        paramContext.lEC.E(paramContext.lEF);
        paramContext.lEA.show();
        return;
        paramContext.lEB.setMaxCol(3);
        break;
        label366:
        i = i * 2 + paramContext.avatarSize * 3;
        break label187;
        if (paramContext.lEF.size() <= 6)
        {
          i += paramContext.avatarSize * 2;
          break label298;
        }
        i = i * 2 + paramContext.avatarSize * 3 + com.tencent.mm.cb.a.fromDPToPix(paramContext.mContext, 10);
        break label298;
        i = 0;
      }
      label433:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.b
 * JD-Core Version:    0.7.0.1
 */