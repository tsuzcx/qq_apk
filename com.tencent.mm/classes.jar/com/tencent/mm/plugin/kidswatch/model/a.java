package com.tencent.mm.plugin.kidswatch.model;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "()V", "colorConfig", "", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "(ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;)V", "mLastClickTicks", "", "onClick", "", "widget", "Landroid/view/View;", "onClickImp", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends t
{
  public static final a.a JSW = new a.a((byte)0);
  private long JSX = -1L;
  
  public a()
  {
    super(1, null);
  }
  
  public abstract void fSP();
  
  public void onClick(View paramView)
  {
    s.u(paramView, "widget");
    if (Util.ticksToNow(this.JSX) > 1000L)
    {
      super.onClick(paramView);
      fSP();
    }
    for (;;)
    {
      this.JSX = Util.currentTicks();
      return;
      Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.a
 * JD-Core Version:    0.7.0.1
 */