package com.tencent.mm.plugin.kidswatch.model;

import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "()V", "colorConfig", "", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "(ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;)V", "mLastClickTicks", "", "onClick", "", "widget", "Landroid/view/View;", "onClickImp", "Companion", "plugin-kidswatch_release"})
public abstract class a
  extends com.tencent.mm.pluginsdk.ui.span.p
{
  public static final a yAA = new a((byte)0);
  private long yAz = -1L;
  
  public a()
  {
    super(1, null);
  }
  
  public abstract void ebS();
  
  public void onClick(View paramView)
  {
    kotlin.g.b.p.h(paramView, "widget");
    if (Util.ticksToNow(this.yAz) > 1000L)
    {
      super.onClick(paramView);
      ebS();
    }
    for (;;)
    {
      this.yAz = Util.currentTicks();
      return;
      Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan$Companion;", "", "()V", "MIN_TWEEN", "", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.a
 * JD-Core Version:    0.7.0.1
 */