package com.tencent.mm.plugin.eggspring.ui;

import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.c.a;
import com.tencent.mm.plugin.eggspring.d.h;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
public final class SpringLuckyEggActivity$g<T>
  implements s<T>
{
  public SpringLuckyEggActivity$g(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
  
  public final void onChanged(T paramT)
  {
    AppMethodBeat.i(249534);
    paramT = (a)paramT;
    if (paramT != null) {
      switch (b.$EnumSwitchMapping$0[paramT.ordinal()])
      {
      }
    }
    for (;;)
    {
      SpringLuckyEggActivity.b(this.uyj).uyI.setValue(null);
      AppMethodBeat.o(249534);
      return;
      paramT = (Context)this.uyj.getContext();
      AppCompatActivity localAppCompatActivity = this.uyj.getContext();
      p.j(localAppCompatActivity, "context");
      w.cR(paramT, localAppCompatActivity.getResources().getString(d.h.uxz));
      continue;
      paramT = (Context)this.uyj.getContext();
      localAppCompatActivity = this.uyj.getContext();
      p.j(localAppCompatActivity, "context");
      w.cS(paramT, localAppCompatActivity.getResources().getString(d.h.uxy));
      continue;
      paramT = (Context)this.uyj.getContext();
      localAppCompatActivity = this.uyj.getContext();
      p.j(localAppCompatActivity, "context");
      w.cS(paramT, localAppCompatActivity.getResources().getString(d.h.uxx));
      continue;
      paramT = (Context)this.uyj.getContext();
      localAppCompatActivity = this.uyj.getContext();
      p.j(localAppCompatActivity, "context");
      w.cS(paramT, localAppCompatActivity.getResources().getString(d.h.uxy));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.g
 * JD-Core Version:    0.7.0.1
 */