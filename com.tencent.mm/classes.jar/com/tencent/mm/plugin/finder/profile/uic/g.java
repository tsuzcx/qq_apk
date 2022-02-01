package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "fromUser$delegate", "Lkotlin/Lazy;", "hasFinderEntry", "", "getHasFinderEntry", "()Z", "isSelf", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "getUsername", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  extends UIComponent
{
  private final j AIq;
  private final bui Auc;
  private final j BlK;
  private final j FcC;
  private final boolean FcD;
  private final j FdK;
  
  public g(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348827);
    this.BlK = kotlin.k.cm((a)new d(this));
    this.AIq = kotlin.k.cm((a)new c(this));
    this.FcC = kotlin.k.cm((a)new b(this));
    this.FdK = kotlin.k.cm((a)new a(this));
    this.FcD = ((cn)h.az(cn.class)).showFinderEntry();
    paramFragment = com.tencent.mm.ui.component.k.aeZF;
    this.Auc = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou();
    AppMethodBeat.o(348827);
  }
  
  public bui getContextObj()
  {
    return this.Auc;
  }
  
  public String getFromUser()
  {
    AppMethodBeat.i(348866);
    String str = (String)this.FdK.getValue();
    AppMethodBeat.o(348866);
    return str;
  }
  
  public boolean getHasFinderEntry()
  {
    return this.FcD;
  }
  
  public m getProfileContact()
  {
    AppMethodBeat.i(348859);
    Object localObject = d.AwY;
    localObject = d.a.auT(getUsername());
    AppMethodBeat.o(348859);
    return localObject;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(348832);
    String str = (String)this.BlK.getValue();
    AppMethodBeat.o(348832);
    return str;
  }
  
  public boolean isSelf()
  {
    AppMethodBeat.i(348849);
    boolean bool = ((Boolean)this.FcC.getValue()).booleanValue();
    AppMethodBeat.o(348849);
    return bool;
  }
  
  public boolean isSelfFlag()
  {
    AppMethodBeat.i(348840);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(348840);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348888);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    int i = ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).GSU;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(348888);
      return;
      f.Ozc.idkeyStat(1278L, 15L, 1L, false);
      paramBundle = z.FrZ;
      String str = getFromUser();
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      str = getUsername();
      s.checkNotNull(str);
      s.s(str, "username!!");
      z.G(i, paramBundle, str);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Boolean>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Boolean>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<String>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.g
 * JD-Core Version:    0.7.0.1
 */