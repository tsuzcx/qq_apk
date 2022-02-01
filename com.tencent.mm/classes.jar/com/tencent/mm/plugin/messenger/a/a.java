package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
  extends p
{
  private long yAz = -1L;
  
  public a()
  {
    super(1, null);
  }
  
  public void onClick(View paramView)
  {
    if (Util.ticksToNow(this.yAz) > 1000L)
    {
      super.onClick(paramView);
      onClickImp(paramView);
    }
    for (;;)
    {
      this.yAz = Util.currentTicks();
      return;
      Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
  
  public abstract void onClickImp(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.a
 * JD-Core Version:    0.7.0.1
 */