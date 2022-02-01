package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static GameTabWidget2 b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(204243);
    if (!(paramView instanceof FrameLayout))
    {
      AppMethodBeat.o(204243);
      return null;
    }
    Object localObject = (GameTabData2)paramActivity.getIntent().getParcelableExtra("game_tab_data");
    String str = paramActivity.getIntent().getStringExtra("game_tab_key");
    if (localObject != null)
    {
      paramActivity = new GameTabWidget2(paramActivity);
      paramActivity.a((GameTabData2)localObject, str);
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      ((FrameLayout)paramView).addView(paramActivity, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(204243);
      return paramActivity;
      paramActivity = null;
    }
  }
  
  public static void gk(Context paramContext)
  {
    AppMethodBeat.i(204244);
    paramContext.sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
    AppMethodBeat.o(204244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.a
 * JD-Core Version:    0.7.0.1
 */