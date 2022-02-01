package com.tencent.mm.plugin.finder.nearby.person;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
final class b$t
  implements q.g
{
  b$t(b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(201237);
    p.j(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      Object localObject = com.tencent.mm.plugin.finder.nearby.report.c.zJb;
      com.tencent.mm.plugin.finder.nearby.report.c.OE(paramMenuItem.getItemId());
      AppMethodBeat.o(201237);
      return;
      b.a(this.zHO, 4);
      b.j(this.zHO);
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((f)localObject).aHp().i(16386, Integer.valueOf(b.b(this.zHO)));
      b.f(this.zHO);
      continue;
      b.a(this.zHO, 3);
      b.j(this.zHO);
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((f)localObject).aHp().i(16386, Integer.valueOf(b.b(this.zHO)));
      b.f(this.zHO);
      continue;
      b.a(this.zHO, 1);
      b.j(this.zHO);
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((f)localObject).aHp().i(16386, Integer.valueOf(b.b(this.zHO)));
      b.f(this.zHO);
      continue;
      localObject = new Intent((Context)this.zHO.getActivity(), NearbySayHiListUI.class);
      ((Intent)localObject).putExtra("k_say_hi_type", 2);
      this.zHO.getActivity().startActivityForResult((Intent)localObject, 2009);
      localObject = i.xuG;
      localObject = g.Xox;
      i.a.c(2, ((aj)g.b(this.zHO.getActivity()).i(aj.class)).ekY());
      localObject = h.ag(ak.class);
      p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      ((ak)localObject).getRedDotManager().aBd("NearbyPeopleBubble");
      continue;
      this.zHO.zHk = new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", "");
      h.aGY().b((q)this.zHO.zHk);
      b.k(this.zHO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b.t
 * JD-Core Version:    0.7.0.1
 */