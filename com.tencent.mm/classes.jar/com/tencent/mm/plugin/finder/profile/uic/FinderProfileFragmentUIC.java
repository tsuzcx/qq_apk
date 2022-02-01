package com.tencent.mm.plugin.finder.profile.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromUser", "", "kotlin.jvm.PlatformType", "getFromUser", "()Ljava/lang/String;", "fromUser$delegate", "Lkotlin/Lazy;", "hasFinderEntry", "", "getHasFinderEntry", "()Z", "isSelf", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "getUsername", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public class FinderProfileFragmentUIC
  extends UIComponent
{
  private final f tZk;
  private final f tZl;
  private final bbn ttO;
  private final f vag;
  private final boolean vah;
  private final f vbh;
  
  public FinderProfileFragmentUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250263);
    this.tZk = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vag = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vbh = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.vah = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    paramFragment = com.tencent.mm.ui.component.a.PRN;
    this.ttO = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
    AppMethodBeat.o(250263);
  }
  
  public bbn getContextObj()
  {
    return this.ttO;
  }
  
  public String getFromUser()
  {
    AppMethodBeat.i(250261);
    String str = (String)this.vbh.getValue();
    AppMethodBeat.o(250261);
    return str;
  }
  
  public boolean getHasFinderEntry()
  {
    return this.vah;
  }
  
  public com.tencent.mm.plugin.finder.api.g getProfileContact()
  {
    AppMethodBeat.i(250260);
    Object localObject = c.tsp;
    localObject = c.a.asG(getUsername());
    AppMethodBeat.o(250260);
    return localObject;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(250257);
    String str = (String)this.tZk.getValue();
    AppMethodBeat.o(250257);
    return str;
  }
  
  public boolean isSelf()
  {
    AppMethodBeat.i(250259);
    boolean bool = ((Boolean)this.vag.getValue()).booleanValue();
    AppMethodBeat.o(250259);
    return bool;
  }
  
  public boolean isSelfFlag()
  {
    AppMethodBeat.i(250258);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(250258);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250262);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).wyZ;
    if ((i == 1) || (i == 2) || (i == 14) || (i == 15))
    {
      e.Cxv.idkeyStat(1278L, 15L, 1L, false);
      paramBundle = k.vfA;
      String str = getFromUser();
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      str = getUsername();
      p.g(str, "username");
      k.x(i, paramBundle, str);
    }
    AppMethodBeat.o(250262);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<String>
  {
    a(FinderProfileFragmentUIC paramFinderProfileFragmentUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(FinderProfileFragmentUIC paramFinderProfileFragmentUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderProfileFragmentUIC paramFinderProfileFragmentUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(FinderProfileFragmentUIC paramFinderProfileFragmentUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileFragmentUIC
 * JD-Core Version:    0.7.0.1
 */