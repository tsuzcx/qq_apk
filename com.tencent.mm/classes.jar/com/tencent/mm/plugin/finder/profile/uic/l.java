package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.profile.servicemenu.b;
import com.tencent.mm.plugin.finder.profile.servicemenu.c;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileServiceMenuUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/profile/servicemenu/ProfileJumpInfo;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hasCover", "", "getHasCover", "()Z", "setHasCover", "(Z)V", "menuRecyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getMenuRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "menuRecyclerView$delegate", "Lkotlin/Lazy;", "msgBtn", "Landroid/view/View;", "getMsgBtn", "()Landroid/view/View;", "msgBtn$delegate", "serviceLayout", "getServiceLayout", "serviceLayout$delegate", "handleServiceMenu", "", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "notifyCoverChange", "refreshMenu", "jumpInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
{
  private WxRecyclerAdapter<com.tencent.mm.plugin.finder.profile.servicemenu.a> ALE;
  private final j Ffn;
  private final j Ffo;
  private final j Ffp;
  public boolean Ffq;
  private final ArrayList<com.tencent.mm.plugin.finder.profile.servicemenu.a> pUj;
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348845);
    this.Ffn = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.Ffo = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.Ffp = kotlin.k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.pUj = new ArrayList();
    AppMethodBeat.o(348845);
  }
  
  private final void a(List<? extends FinderJumpInfo> paramList, m paramm)
  {
    AppMethodBeat.i(348907);
    this.pUj.clear();
    Object localObject1 = this.pUj;
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (FinderJumpInfo)((Iterator)localObject2).next();
      com.tencent.mm.plugin.finder.feed.jumper.k localk = new com.tencent.mm.plugin.finder.feed.jumper.k((FinderJumpInfo)localObject3);
      localk.contact = paramm;
      if (((FinderJumpInfo)localObject3).jumpinfo_type == 1)
      {
        localk.hzx = paramm.getUsername();
        localObject3 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).qAT = new HalfScreenConfig(true, 0, null, false, null, false, null, HalfScreenConfig.c.rao, false, false, null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16777086);
        ah localah = ah.aiuX;
        localk.Beb = ((com.tencent.mm.plugin.appbrand.api.g)localObject3);
      }
      localObject3 = ah.aiuX;
      paramList.add(new com.tencent.mm.plugin.finder.profile.servicemenu.a(localk));
    }
    ((ArrayList)localObject1).addAll((Collection)paramList);
    paramm = ((Iterable)this.pUj).iterator();
    int i;
    if (paramm.hasNext())
    {
      paramList = paramm.next();
      localObject1 = ((com.tencent.mm.plugin.finder.profile.servicemenu.a)paramList).Fcp.hVf.native_info;
      if ((localObject1 != null) && (((NativeInfo)localObject1).native_type == 7))
      {
        i = 1;
        label267:
        if (i == 0) {
          break label455;
        }
        label271:
        if ((com.tencent.mm.plugin.finder.profile.servicemenu.a)paramList != null) {
          break label462;
        }
        paramList = null;
        label280:
        if (paramList == null)
        {
          paramList = (l)this;
          paramm = paramList.eKh();
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          if (!((h)com.tencent.mm.ui.component.k.d(paramList.getActivity()).q(h.class)).eJG()) {
            break label478;
          }
          i = 0;
          label323:
          paramm.setVisibility(i);
        }
        paramList = this.ALE;
        if (paramList != null) {
          break label484;
        }
      }
    }
    for (paramList = null;; paramList = ah.aiuX)
    {
      if (paramList == null)
      {
        paramList = (l)this;
        paramList.ALE = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new c(), paramList.pUj);
        paramList.eKg().setAdapter((RecyclerView.a)paramList.ALE);
        paramList.eKg().setNestedScrollingEnabled(false);
        paramList.eKg().setLayoutManager((RecyclerView.LayoutManager)new FinderProfileServiceMenuUIC.refreshMenu.6.2(paramList.getContext()));
        paramList.eKg().a((RecyclerView.h)new c(paramList.getContext().getResources().getDimensionPixelOffset(e.c.Edge_A)));
      }
      AppMethodBeat.o(348907);
      return;
      i = 0;
      break label267;
      label455:
      break;
      paramList = null;
      break label271;
      label462:
      eKh().setVisibility(8);
      paramList = ah.aiuX;
      break label280;
      label478:
      i = 8;
      break label323;
      label484:
      paramList.bZE.notifyChanged();
    }
  }
  
  private final View eKf()
  {
    AppMethodBeat.i(348863);
    View localView = (View)this.Ffn.getValue();
    AppMethodBeat.o(348863);
    return localView;
  }
  
  private final WxRecyclerView eKg()
  {
    AppMethodBeat.i(348875);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.Ffo.getValue();
    AppMethodBeat.o(348875);
    return localWxRecyclerView;
  }
  
  private final View eKh()
  {
    AppMethodBeat.i(348886);
    View localView = (View)this.Ffp.getValue();
    AppMethodBeat.o(348886);
    return localView;
  }
  
  public final void i(m paramm)
  {
    AppMethodBeat.i(348934);
    if (paramm == null)
    {
      AppMethodBeat.o(348934);
      return;
    }
    Object localObject = paramm.field_jumpInfoList;
    if (localObject == null) {
      paramm = null;
    }
    for (;;)
    {
      if (paramm == null) {
        ((l)this).eKf().setVisibility(8);
      }
      AppMethodBeat.o(348934);
      return;
      localObject = ((bcf)localObject).jump_info;
      if (localObject == null)
      {
        paramm = null;
      }
      else
      {
        int i;
        if (!((Collection)localObject).isEmpty())
        {
          i = 1;
          label79:
          if (i == 0) {
            break label97;
          }
        }
        for (;;)
        {
          if (localObject != null) {
            break label102;
          }
          paramm = null;
          break;
          i = 0;
          break label79;
          label97:
          localObject = null;
        }
        label102:
        eKf().setVisibility(0);
        a((List)localObject, paramm);
        paramm = ah.aiuX;
      }
    }
  }
  
  public final void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(348924);
    this.Ffq = paramBoolean;
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.bZE.notifyChanged();
    }
    AppMethodBeat.o(348924);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileServiceMenuUIC$refreshMenu$6$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(348703);
      f localf = (f)new b();
      AppMethodBeat.o(348703);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.l
 * JD-Core Version:    0.7.0.1
 */