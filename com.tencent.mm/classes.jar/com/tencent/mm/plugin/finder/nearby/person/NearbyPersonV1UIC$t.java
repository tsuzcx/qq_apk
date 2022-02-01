package com.tencent.mm.plugin.finder.nearby.person;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.nearby.report.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
final class NearbyPersonV1UIC$t
  implements o.g
{
  NearbyPersonV1UIC$t(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(249299);
    p.g(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      Object localObject = b.uSZ;
      b.JE(paramMenuItem.getItemId());
      AppMethodBeat.o(249299);
      return;
      NearbyPersonV1UIC.a(this.uSA, 4);
      NearbyPersonV1UIC.j(this.uSA);
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(16386, Integer.valueOf(NearbyPersonV1UIC.b(this.uSA)));
      NearbyPersonV1UIC.f(this.uSA);
      continue;
      NearbyPersonV1UIC.a(this.uSA, 3);
      NearbyPersonV1UIC.j(this.uSA);
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(16386, Integer.valueOf(NearbyPersonV1UIC.b(this.uSA)));
      NearbyPersonV1UIC.f(this.uSA);
      continue;
      NearbyPersonV1UIC.a(this.uSA, 1);
      NearbyPersonV1UIC.j(this.uSA);
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(16386, Integer.valueOf(NearbyPersonV1UIC.b(this.uSA)));
      NearbyPersonV1UIC.f(this.uSA);
      continue;
      localObject = new Intent((Context)this.uSA.getActivity(), NearbySayHiListUI.class);
      ((Intent)localObject).putExtra("k_say_hi_type", 2);
      this.uSA.getActivity().startActivityForResult((Intent)localObject, 2009);
      localObject = i.tLi;
      localObject = a.PRN;
      i.a.c(2, ((FinderReporterUIC)a.b(this.uSA.getActivity()).get(FinderReporterUIC.class)).dIx());
      localObject = g.ah(aj.class);
      p.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      ((aj)localObject).getRedDotManager().asV("NearbyPeopleBubble");
      continue;
      this.uSA.uRW = new c(2, 0.0F, 0.0F, 0, 0, "", "");
      g.azz().b((q)this.uSA.uRW);
      NearbyPersonV1UIC.k(this.uSA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.t
 * JD-Core Version:    0.7.0.1
 */