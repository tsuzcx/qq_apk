package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromUser", "", "kotlin.jvm.PlatformType", "getFromUser", "()Ljava/lang/String;", "fromUser$delegate", "Lkotlin/Lazy;", "hasFinderEntry", "", "getHasFinderEntry", "()Z", "isSelf", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "getUsername", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public class i
  extends UIComponent
{
  private final kotlin.f xLz;
  private final bid xbu;
  private final kotlin.f xjx;
  private final kotlin.f zQp;
  private final boolean zQq;
  private final kotlin.f zRo;
  
  public i(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(227378);
    this.xLz = kotlin.g.ar((a)new d(this));
    this.xjx = kotlin.g.ar((a)new c(this));
    this.zQp = kotlin.g.ar((a)new b(this));
    this.zRo = kotlin.g.ar((a)new a(this));
    this.zQq = ((ak)h.ag(ak.class)).showFinderEntry();
    paramFragment = com.tencent.mm.ui.component.g.Xox;
    this.xbu = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).ekY();
    AppMethodBeat.o(227378);
  }
  
  public bid getContextObj()
  {
    return this.xbu;
  }
  
  public String getFromUser()
  {
    AppMethodBeat.i(227368);
    String str = (String)this.zRo.getValue();
    AppMethodBeat.o(227368);
    return str;
  }
  
  public boolean getHasFinderEntry()
  {
    return this.zQq;
  }
  
  public com.tencent.mm.plugin.finder.api.i getProfileContact()
  {
    AppMethodBeat.i(227366);
    Object localObject = d.wZQ;
    localObject = d.a.aAK(getUsername());
    AppMethodBeat.o(227366);
    return localObject;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(227361);
    String str = (String)this.xLz.getValue();
    AppMethodBeat.o(227361);
    return str;
  }
  
  public boolean isSelf()
  {
    AppMethodBeat.i(227365);
    boolean bool = ((Boolean)this.zQp.getValue()).booleanValue();
    AppMethodBeat.o(227365);
    return bool;
  }
  
  public boolean isSelfFlag()
  {
    AppMethodBeat.i(227363);
    boolean bool = ((Boolean)this.xjx.getValue()).booleanValue();
    AppMethodBeat.o(227363);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227373);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    int i = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).BmR;
    if ((i == 1) || (i == 2) || (i == 14) || (i == 15))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1278L, 15L, 1L, false);
      paramBundle = n.zWF;
      String str = getFromUser();
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      str = getUsername();
      p.j(str, "username");
      n.C(i, paramBundle, str);
    }
    AppMethodBeat.o(227373);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Boolean>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.i
 * JD-Core Version:    0.7.0.1
 */