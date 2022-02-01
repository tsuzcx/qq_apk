package com.tencent.mm.plugin.eggspring.ui;

import android.widget.Button;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.d.h;
import com.tencent.mm.t.a.n;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
public final class SpringLuckyEggActivity$h<T>
  implements s<T>
{
  public SpringLuckyEggActivity$h(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
  
  public final void onChanged(T paramT)
  {
    AppMethodBeat.i(249347);
    paramT = (Boolean)paramT;
    if ((paramT != null) && (!p.h(paramT, Boolean.FALSE)) && (a.a((n)SpringLuckyEggActivity.b(this.uyj).uyM.getValue())))
    {
      SpringLuckyEggActivity.a(this.uyj).uyz.setText((CharSequence)this.uyj.getString(d.h.uxA));
      SpringLuckyEggActivity.a(this.uyj).uyz.setEnabled(false);
    }
    AppMethodBeat.o(249347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.h
 * JD-Core Version:    0.7.0.1
 */