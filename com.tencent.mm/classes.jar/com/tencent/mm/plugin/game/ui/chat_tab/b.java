package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.a;

public final class b
{
  public static GameTabWidget2 b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(202406);
    if ((paramActivity == null) || (!(paramView instanceof FrameLayout)))
    {
      AppMethodBeat.o(202406);
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
      AppMethodBeat.o(202406);
      return paramActivity;
      paramActivity = null;
    }
  }
  
  public static void gE(Context paramContext)
  {
    AppMethodBeat.i(202412);
    paramContext.sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), a.CfL);
    AppMethodBeat.o(202412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.b
 * JD-Core Version:    0.7.0.1
 */