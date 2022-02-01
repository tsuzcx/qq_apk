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
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private i Elf;
  private MMGridPaper Elg;
  private a Elh;
  private ViewGroup Eli;
  private RelativeLayout Elj;
  private ArrayList<String> Elk;
  private int avatarSize;
  private Context mContext;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(55799);
    this.Elf = null;
    this.Elg = null;
    this.Elh = null;
    this.Eli = null;
    this.Elj = null;
    this.mContext = null;
    this.Elk = null;
    this.avatarSize = 0;
    this.mContext = paramContext;
    this.Elf = new i(this.mContext, a.j.trackDialog);
    this.Eli = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.f.avatars_dialog, null));
    this.Elg = ((MMGridPaper)this.Eli.findViewById(a.e.dialog_content));
    this.Elg.hJF();
    this.Elg.setDialogMode(true);
    this.Elg.hJE();
    this.Elg.setMaxRow(3);
    this.Elg.setMaxCol(3);
    this.Elg.setHeaderView(null);
    this.Elg.hJF();
    this.Elg.setItemWidthInDp(70);
    this.Elg.setItemHeightInDp(70);
    this.Elf.setCanceledOnTouchOutside(true);
    this.Elf.setContentView(this.Eli);
    this.Elh = new a();
    this.Elg.setGridPaperAdapter(this.Elh);
    AppMethodBeat.o(55799);
  }
  
  public static void d(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55800);
    Log.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    paramContext = new b(paramContext);
    paramContext.Elk = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str;
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      paramContext.Elk.add(str);
    }
    int i;
    if (paramContext.Elk.size() < 3)
    {
      paramContext.Elg.setMaxCol(paramContext.Elk.size());
      paramArrayList = paramContext.Elg.getLayoutParams();
      paramContext.avatarSize = com.tencent.mm.ci.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.ci.a.fromDPToPix(paramContext.mContext, 8);
      if (paramContext.Elk.size() <= 0) {
        break label443;
      }
      if (paramContext.Elk.size() >= 3) {
        break label376;
      }
      int j = paramContext.avatarSize;
      int k = paramContext.Elk.size();
      i = i * (paramContext.Elk.size() - 1) + j * k;
    }
    for (;;)
    {
      label192:
      str = BackwardSupportUtil.BitmapFactory.getDisplayDensityType(paramContext.mContext);
      Log.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.Elk.size()), Integer.valueOf(paramContext.avatarSize), str });
      paramArrayList.width = i;
      paramContext.avatarSize = com.tencent.mm.ci.a.fromDPToPix(paramContext.mContext, 70);
      i = com.tencent.mm.ci.a.fromDPToPix(paramContext.mContext, 15);
      if (paramContext.Elk.size() > 0) {
        if (paramContext.Elk.size() <= 3)
        {
          i += paramContext.avatarSize;
          label303:
          Log.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramArrayList.height = i;
        paramContext.Elg.setLayoutParams(paramArrayList);
        paramContext.Elg.requestLayout();
        paramContext.Elh.setData(paramContext.Elk);
        paramContext.Elf.show();
        AppMethodBeat.o(55800);
        return;
        paramContext.Elg.setMaxCol(3);
        break;
        label376:
        i = i * 2 + paramContext.avatarSize * 3;
        break label192;
        if (paramContext.Elk.size() <= 6)
        {
          i += paramContext.avatarSize * 2;
          break label303;
        }
        i = i * 2 + paramContext.avatarSize * 3 + com.tencent.mm.ci.a.fromDPToPix(paramContext.mContext, 10);
        break label303;
        i = 0;
      }
      label443:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.b
 * JD-Core Version:    0.7.0.1
 */