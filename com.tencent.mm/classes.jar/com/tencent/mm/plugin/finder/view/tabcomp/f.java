package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "finderTabLayout", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "addTab", "", "finderTab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "position", "", "index", "adjustIndicator", "adjustTabIndicator", "buildTab", "getIndicatorView", "Landroid/view/ViewGroup;", "getSelectedTabPosition", "initOtherNormalRefs", "initOtherViewRefs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeTabAt", "selectTab", "isForceSelect", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends FinderTabUIC
{
  private FinderTabLayout GJg;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private static final void a(f paramf)
  {
    s.u(paramf, "this$0");
    Log.i("Finder.FinderTabUIC", "adjust align");
    Object localObject = paramf.GJg;
    if (localObject != null) {
      ((FinderTabLayout)localObject).setVisibility(0);
    }
    localObject = paramf.fpd();
    if (localObject != null) {
      ((o)localObject).a(paramf.GJg);
    }
  }
  
  private static final void b(f paramf)
  {
    s.u(paramf, "this$0");
    paramf.fmx();
  }
  
  public final void UQ(int paramInt)
  {
    FinderTabLayout localFinderTabLayout = this.GJg;
    if (localFinderTabLayout != null)
    {
      if (localFinderTabLayout.GJs != null) {}
      for (int i = localFinderTabLayout.GJs.position;; i = 0)
      {
        localFinderTabLayout.ju(paramInt);
        locale = (FinderTabLayout.e)localFinderTabLayout.dxP.remove(paramInt);
        if (locale != null)
        {
          locale.reset();
          FinderTabLayout.d(locale);
        }
        int k = localFinderTabLayout.dxP.size();
        int j = paramInt;
        while (j < k)
        {
          ((FinderTabLayout.e)localFinderTabLayout.dxP.get(j)).position = j;
          j += 1;
        }
      }
      if (i == paramInt) {
        if (!localFinderTabLayout.dxP.isEmpty()) {
          break label138;
        }
      }
    }
    label138:
    for (FinderTabLayout.e locale = null;; locale = (FinderTabLayout.e)localFinderTabLayout.dxP.get(Math.max(0, paramInt - 1)))
    {
      localFinderTabLayout.b(locale, true);
      return;
    }
  }
  
  public final void a(g paramg, int paramInt)
  {
    FinderTabLayout localFinderTabLayout = this.GJg;
    FinderTabLayout.e locale;
    if (localFinderTabLayout != null)
    {
      locale = localFinderTabLayout.fmE();
      s.s(locale, "tabLayout.newTab()");
      if (paramg != null)
      {
        locale.US(paramg.getLayoutId());
        paramg.H((ViewGroup)locale.dyK);
        paramg.vg(false);
        if ((paramg instanceof i)) {
          locale.ah((CharSequence)((i)paramg).ht((Context)getContext()));
        }
      }
      locale.tag = paramg;
      if (paramInt >= 0) {
        localFinderTabLayout.a(locale, paramInt, localFinderTabLayout.dxP.isEmpty());
      }
    }
    else
    {
      return;
    }
    localFinderTabLayout.c(locale);
  }
  
  public final void aV(int paramInt, boolean paramBoolean)
  {
    super.aV(paramInt, paramBoolean);
    Object localObject = this.GJg;
    int i;
    if (localObject != null)
    {
      if ((paramInt < 0) || (paramInt >= ((FinderTabLayout)localObject).getTabCount())) {
        break label86;
      }
      i = 1;
      if (i == 0) {
        break label91;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((FinderTabLayout)localObject).UR(paramInt);
        if ((localObject != null) && ((paramBoolean) || (!((FinderTabLayout.e)localObject).isSelected())))
        {
          Log.i("Finder.FinderTabUIC", s.X("select :", Integer.valueOf(paramInt)));
          ((FinderTabLayout.e)localObject).Xf();
        }
      }
      return;
      label86:
      i = 0;
      break;
      label91:
      localObject = null;
    }
  }
  
  public final void fmt()
  {
    this.GJg = getTabContainer().fmA();
    FinderTabLayout localFinderTabLayout = this.GJg;
    if (localFinderTabLayout != null) {
      localFinderTabLayout.dyf = false;
    }
  }
  
  public final void fmu()
  {
    Object localObject = fpe();
    if ((localObject instanceof e)) {}
    for (localObject = (e)localObject;; localObject = null)
    {
      if (localObject != null) {
        a(((e)localObject).GJf);
      }
      return;
    }
  }
  
  public final void fmv()
  {
    Object localObject1 = this.GJg;
    if (localObject1 != null)
    {
      ((FinderTabLayout)localObject1).a((FinderTabLayout.b)new a(this, (FinderTabLayout)localObject1));
      localObject1 = (Iterable)getTabs();
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (g)localObject2;
        ((g)localObject2).index = i;
        a((g)localObject2, -1);
        i += 1;
      }
      fmw();
    }
  }
  
  public final void fmw()
  {
    FinderTabLayout localFinderTabLayout = this.GJg;
    if (localFinderTabLayout != null)
    {
      Log.i("Finder.FinderTabUIC", s.X("ajustIndicator:", Integer.valueOf(localFinderTabLayout.getTabCount())));
      if (localFinderTabLayout.getTabCount() > 1) {}
    }
    else
    {
      return;
    }
    localFinderTabLayout.post(new f..ExternalSyntheticLambda1(this));
  }
  
  public final void fmx()
  {
    Object localObject = this.GJg;
    ViewGroup localViewGroup;
    int j;
    int i;
    int k;
    if (localObject != null)
    {
      int m = ((FinderTabLayout)localObject).getTabCount();
      localViewGroup = fmy();
      if (localViewGroup != null)
      {
        if (m <= 0) {
          break label181;
        }
        j = 0;
        i = 0;
        k = j + 1;
        localObject = this.GJg;
        if (localObject == null) {
          localObject = null;
        }
        while (localObject == null)
        {
          throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          localObject = ((FinderTabLayout)localObject).UR(j);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((FinderTabLayout.e)localObject).tag;
          }
        }
        localObject = ((g)localObject).dTO();
        if ((localObject[0] <= 0) && (localObject[1] <= 0)) {
          break label178;
        }
        b(localViewGroup, j, a.fromDPToPix(localViewGroup.getContext(), localObject[0]), a.fromDPToPix(localViewGroup.getContext(), localObject[1]));
        i = 1;
        label157:
        if (k < m) {
          break label173;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        localViewGroup.requestLayout();
      }
      return;
      label173:
      j = k;
      break;
      label178:
      break label157;
      label181:
      i = 0;
    }
  }
  
  public final ViewGroup fmy()
  {
    Object localObject = this.GJg;
    if (localObject == null) {
      return null;
    }
    localObject = ((FinderTabLayout)localObject).getChildAt(0);
    if (localObject == null) {
      return null;
    }
    return (ViewGroup)localObject;
  }
  
  public final int getSelectedTabPosition()
  {
    Object localObject = this.GJg;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((FinderTabLayout)localObject).getSelectedTabPosition())) {
      return this.lastIndex;
    }
    return ((Integer)localObject).intValue();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.GJg;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.GJg;
    if (paramBundle != null) {
      paramBundle.post(new f..ExternalSyntheticLambda0(this));
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabUIC$buildTab$1$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout$BaseOnTabSelectedListener;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout$Tab;", "onTabReselected", "", "tab", "onTabSelected", "onTabUnselected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements FinderTabLayout.b<FinderTabLayout.e>
  {
    a(f paramf, FinderTabLayout paramFinderTabLayout) {}
    
    public final void a(FinderTabLayout.e parame)
    {
      AppMethodBeat.i(345576);
      if (parame != null)
      {
        Object localObject1 = this.GJh;
        Object localObject2 = this.GJi;
        if ((parame.tag instanceof g))
        {
          localObject1 = ((f)localObject1).getTabViewAction();
          localObject2 = ((FinderTabLayout)localObject2).getContext();
          s.s(localObject2, "context");
          Object localObject3 = parame.tag;
          if (localObject3 == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(345576);
            throw parame;
          }
          ((m)localObject1).b((Context)localObject2, (g)localObject3);
          localObject1 = parame.tag;
          if (localObject1 == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(345576);
            throw parame;
          }
          localObject1 = (g)localObject1;
          parame = parame.dyK;
          if (parame == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(345576);
            throw parame;
          }
          ((g)localObject1).a(false, (ViewGroup)parame);
        }
      }
      AppMethodBeat.o(345576);
    }
    
    public final void b(FinderTabLayout.e parame)
    {
      AppMethodBeat.i(345581);
      if (parame != null)
      {
        f localf = this.GJh;
        Object localObject2 = this.GJi;
        Object localObject1 = localf.getTabViewAction();
        localObject2 = ((FinderTabLayout)localObject2).getContext();
        s.s(localObject2, "context");
        Object localObject3 = parame.tag;
        if (localObject3 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(345581);
          throw parame;
        }
        ((m)localObject1).a((Context)localObject2, (g)localObject3);
        localObject1 = parame.tag;
        if (localObject1 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(345581);
          throw parame;
        }
        localObject1 = (g)localObject1;
        localObject2 = parame.dyK;
        if (localObject2 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(345581);
          throw parame;
        }
        ((g)localObject1).a(true, (ViewGroup)localObject2);
        parame = parame.tag;
        if (parame == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(345581);
          throw parame;
        }
        int j = f.a(localf, (g)parame);
        Log.i("Finder.FinderTabUIC", s.X("setCurrentPage:", Integer.valueOf(j)));
        int i = j;
        if (j == -1) {
          i = 0;
        }
        f.a(localf, i);
      }
      AppMethodBeat.o(345581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.f
 * JD-Core Version:    0.7.0.1
 */