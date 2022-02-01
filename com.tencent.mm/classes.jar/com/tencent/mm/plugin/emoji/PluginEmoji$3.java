package com.tencent.mm.plugin.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.SmileyPanelImpl;

final class PluginEmoji$3
  implements ad.a
{
  PluginEmoji$3(PluginEmoji paramPluginEmoji) {}
  
  public final ac aag()
  {
    AppMethodBeat.i(104553);
    k localk = new k();
    AppMethodBeat.o(104553);
    return localk;
  }
  
  public final int bC(Context paramContext)
  {
    AppMethodBeat.i(104552);
    int i = paramContext.getResources().getDimensionPixelOffset(a.e.emoji_panel_max_height);
    int j = paramContext.getResources().getDimensionPixelOffset(a.e.Edge_7A);
    boolean bool1;
    Object localObject;
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      bool1 = true;
      if (!(paramContext instanceof Activity)) {
        break label271;
      }
      localObject = (Activity)paramContext;
      if (!d.qV(24)) {
        break label271;
      }
    }
    label271:
    for (boolean bool2 = ((Activity)localObject).isInMultiWindowMode();; bool2 = false)
    {
      localObject = new Point();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
      if ((bool1) && (!bool2))
      {
        j = ((Point)localObject).y / 2 - j;
        Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if ((j > 0) && (j < i))
        {
          AppMethodBeat.o(104552);
          return j;
          bool1 = false;
          break;
        }
        AppMethodBeat.o(104552);
        return i;
      }
      i = paramContext.getResources().getDimensionPixelOffset(a.e.emoji_panel_height_min);
      Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(((Point)localObject).y) });
      if ((((Point)localObject).y > 0) && (i > ((Point)localObject).y / 2))
      {
        i = ((Point)localObject).y / 2;
        AppMethodBeat.o(104552);
        return i;
      }
      AppMethodBeat.o(104552);
      return i;
    }
  }
  
  public final SmileyPanel bD(Context paramContext)
  {
    AppMethodBeat.i(104550);
    paramContext = n(paramContext, false);
    AppMethodBeat.o(104550);
    return paramContext;
  }
  
  public final SmileyPanel n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(104551);
    paramContext = new SmileyPanelImpl(paramContext, paramBoolean);
    AppMethodBeat.o(104551);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.3
 * JD-Core Version:    0.7.0.1
 */