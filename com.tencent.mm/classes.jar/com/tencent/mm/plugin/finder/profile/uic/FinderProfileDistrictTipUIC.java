package com.tencent.mm.plugin.finder.profile.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isSelf", "", "()Z", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", "username", "", "kotlin.jvm.PlatformType", "getUsername", "()Ljava/lang/String;", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderProfileDistrictTipUIC
  extends UIComponent
{
  private final f tZk;
  private final f tZl;
  private final f vag;
  
  public FinderProfileDistrictTipUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250137);
    this.vag = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.tZk = kotlin.g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(250137);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(250136);
    super.onCreate(paramBundle);
    if ((((Boolean)this.vag.getValue()).booleanValue()) && (((Boolean)this.tZl.getValue()).booleanValue()))
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.drV() != 1)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drW())
        {
          paramBundle = com.tencent.mm.ui.component.a.PRN;
          paramBundle = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
          if (paramBundle != null)
          {
            Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
            localObject1 = c.a.asG(z.aUg());
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
              if (localObject1 != null)
              {
                if (((p.j(paramBundle.keh, ((app)localObject1).country) ^ true)) || ((p.j(paramBundle.kdZ, ((app)localObject1).fuJ) ^ true)) || ((p.j(paramBundle.kea, ((app)localObject1).fuK) ^ true)))
                {
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  ((e)localObject1).azQ().set(ar.a.Oma, Long.valueOf(1L));
                  localObject1 = com.tencent.mm.ui.component.a.PRN;
                  localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
                  if (localObject1 != null)
                  {
                    Object localObject2 = getActivity();
                    Object localObject3 = y.vXH;
                    localObject3 = ((bme)localObject1).keh;
                    p.g(localObject3, "it.Country");
                    String str1 = ((bme)localObject1).kdZ;
                    p.g(str1, "it.Province");
                    String str2 = ((bme)localObject1).kea;
                    p.g(str2, "it.City");
                    localObject2 = ((AppCompatActivity)localObject2).getString(2131760238, new Object[] { y.al((String)localObject3, str1, str2) });
                    p.g(localObject2, "activity.getString(R.str…y, it.Province, it.City))");
                    h.a((Context)getActivity(), (String)localObject2, "", getString(2131760556), getString(2131755761), true, (DialogInterface.OnClickListener)new c((bme)localObject1, paramBundle, this), (DialogInterface.OnClickListener)new d(paramBundle, this));
                    AppMethodBeat.o(250136);
                    return;
                  }
                }
                AppMethodBeat.o(250136);
                return;
              }
            }
            AppMethodBeat.o(250136);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(250136);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    a(FinderProfileDistrictTipUIC paramFinderProfileDistrictTipUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(FinderProfileDistrictTipUIC paramFinderProfileDistrictTipUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$onCreate$1$1$1$1", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$3"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(bme parambme1, bme parambme2, FinderProfileDistrictTipUIC paramFinderProfileDistrictTipUIC) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(250133);
      paramDialogInterface = k.vfA;
      paramDialogInterface = FinderProfileDistrictTipUIC.a(jdField_this);
      p.g(paramDialogInterface, "username");
      k.dA(paramDialogInterface, 1);
      paramDialogInterface = (x)com.tencent.mm.kernel.g.af(x.class);
      String str1 = this.vaD.keh;
      p.g(str1, "it.Country");
      String str2 = this.vaD.kdZ;
      p.g(str2, "it.Province");
      String str3 = this.vaD.kea;
      p.g(str3, "it.City");
      paramDialogInterface.a(str1, str2, str3, 0, (ai)new ai() {});
      AppMethodBeat.o(250133);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$onCreate$1$1$1$2", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$4"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(bme parambme, FinderProfileDistrictTipUIC paramFinderProfileDistrictTipUIC) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(250134);
      paramDialogInterface = k.vfA;
      paramDialogInterface = FinderProfileDistrictTipUIC.a(jdField_this);
      p.g(paramDialogInterface, "username");
      k.dA(paramDialogInterface, 2);
      AppMethodBeat.o(250134);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<String>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileDistrictTipUIC
 * JD-Core Version:    0.7.0.1
 */