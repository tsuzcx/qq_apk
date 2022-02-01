package com.tencent.mm.plugin.finder.view.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "FragmentType", "Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "manager", "Landroidx/fragment/app/FragmentManager;", "pageFragments", "", "(Landroidx/viewpager/widget/ViewPager;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "action", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "isUpdating", "", "getManager", "()Landroidx/fragment/app/FragmentManager;", "pendingAction", "pendingActionRunnable", "Ljava/lang/Runnable;", "pendingFragment", "addPendingActon", "", "fragment", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;Ljava/lang/Object;)V", "checkPendingAction", "finishUpdate", "container", "Landroid/view/ViewGroup;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "handleNextPendingAction", "instantiateItem", "instantiateItemInner", "notifyAddItem", "(ILjava/lang/Object;)V", "notifyDataSetChanged", "notifyItemChange", "notifyRemoveItem", "onDestroy", "removePendingActions", "setPrimaryItem", "startUpdate", "ChangeAction", "Companion", "plugin-finder_release"})
public final class a<FragmentType>
  extends d
{
  public static final b Bdk;
  private a Bde;
  public List<a> Bdf;
  public List<FragmentType> Bdg;
  public Runnable Bdh;
  private final e Bdi;
  private final List<FragmentType> Bdj;
  public final ViewPager bFl;
  private boolean jJQ;
  
  static
  {
    AppMethodBeat.i(288107);
    Bdk = new b((byte)0);
    AppMethodBeat.o(288107);
  }
  
  public a(ViewPager paramViewPager, e parame, List<FragmentType> paramList)
  {
    super(parame);
    AppMethodBeat.i(288106);
    this.bFl = paramViewPager;
    this.Bdi = parame;
    this.Bdj = paramList;
    this.Bdf = ((List)new ArrayList());
    this.Bdg = ((List)new ArrayList());
    AppMethodBeat.o(288106);
  }
  
  public final void a(a parama, FragmentType paramFragmentType)
  {
    AppMethodBeat.i(288105);
    p.k(parama, "action");
    this.Bde = parama;
    Log.i("Finder.DynamicAdapter", "notifyItemChange isAdd:" + parama.oxR + " position " + parama.Bdl);
    if (parama.oxR)
    {
      int j = parama.Bdl;
      if (paramFragmentType != null)
      {
        if ((j >= 0) && (j <= this.Bdj.size()))
        {
          parama = this.Bdj;
          if (!this.Bdj.contains(paramFragmentType))
          {
            i = 1;
            if (i == 0) {
              break label140;
            }
          }
          for (;;)
          {
            if (parama != null) {
              parama.add(j, paramFragmentType);
            }
            notifyDataSetChanged();
            AppMethodBeat.o(288105);
            return;
            i = 0;
            break;
            label140:
            parama = null;
          }
        }
        Log.e("Finder.DynamicAdapter", "notifyAddItem index out of range");
      }
      AppMethodBeat.o(288105);
      return;
    }
    int i = parama.Bdl;
    if ((i >= 0) && (i < this.Bdj.size()))
    {
      this.Bdj.remove(i);
      notifyDataSetChanged();
      AppMethodBeat.o(288105);
      return;
    }
    Log.e("Finder.DynamicAdapter", "notifyRemoveItem index out of range");
    AppMethodBeat.o(288105);
  }
  
  public final void finishUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(288102);
    p.k(paramViewGroup, "container");
    super.finishUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "finishUpdate");
    this.jJQ = false;
    AppMethodBeat.o(288102);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(288098);
    int i = this.Bdj.size();
    AppMethodBeat.o(288098);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(288097);
    Object localObject = this.Bdj.get(paramInt);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type androidx.fragment.app.Fragment");
      AppMethodBeat.o(288097);
      throw ((Throwable)localObject);
    }
    localObject = (Fragment)localObject;
    if ((localObject instanceof FinderHomeTabFragment)) {
      Log.i("Finder.DynamicAdapter", "getItem " + paramInt + " fragment:" + ((FinderHomeTabFragment)localObject).title + " tabType:" + ((FinderHomeTabFragment)localObject).fEH);
    }
    AppMethodBeat.o(288097);
    return localObject;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(288101);
    p.k(paramObject, "object");
    int j = super.getItemPosition(paramObject);
    Log.i("Finder.DynamicAdapter", "getItemPosition : position ".concat(String.valueOf(j)));
    int i = j;
    a locala;
    if ((paramObject instanceof Fragment))
    {
      locala = this.Bde;
      i = j;
      if (locala != null)
      {
        i = this.Bdj.indexOf(paramObject);
        Log.i("Finder.DynamicAdapter", "getItemPosition : newPosition " + i + " changePosition :" + locala.Bdl);
        if (i != -1) {
          break label115;
        }
        i = -2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(288101);
      return i;
      label115:
      if (i >= locala.Bdl)
      {
        Log.i("Finder.DynamicAdapter", "use new ".concat(String.valueOf(i)));
      }
      else
      {
        Log.i("Finder.DynamicAdapter", "unchanged");
        i = -1;
      }
    }
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(288099);
    p.k(paramViewGroup, "container");
    Log.i("Finder.DynamicAdapter", "instantiateItem " + paramInt + " action:" + this.Bde);
    Object localObject1 = this.Bde;
    if ((localObject1 != null) && (((a)localObject1).oxR))
    {
      if (paramInt == ejx().size())
      {
        paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
        AppMethodBeat.o(288099);
        return paramViewGroup;
      }
      Object localObject2 = ejx();
      if (paramInt < ((ArrayList)localObject2).size())
      {
        if (ejv() == null) {
          b(ejy().beginTransaction());
        }
        localObject1 = getItem(paramInt);
        if (ejw().size() > paramInt)
        {
          Fragment.SavedState localSavedState = (Fragment.SavedState)ejw().get(paramInt);
          if (localSavedState != null) {
            ((Fragment)localObject1).setInitialSavedState(localSavedState);
          }
        }
        ((Fragment)localObject1).setMenuVisibility(false);
        ((Fragment)localObject1).setUserVisibleHint(false);
        ((ArrayList)localObject2).add(paramInt, localObject1);
        localObject2 = new StringBuilder("instantiateItemInner: title:");
        if (localObject1 == null)
        {
          paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
          AppMethodBeat.o(288099);
          throw paramViewGroup;
        }
        Log.i("Finder.DynamicAdapter", ((FinderHomeTabFragment)localObject1).title + " tabType:" + ((FinderHomeTabFragment)localObject1).fEH);
        localObject2 = ejv();
        if (localObject2 != null) {
          ((i)localObject2).a(paramViewGroup.getId(), (Fragment)localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = super.instantiateItem(paramViewGroup, paramInt);
        }
        AppMethodBeat.o(288099);
        return localObject2;
        localObject1 = null;
      }
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(288099);
    return paramViewGroup;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(288104);
    this.jJQ = true;
    Log.i("Finder.DynamicAdapter", "notifyDataSetChanged");
    super.notifyDataSetChanged();
    AppMethodBeat.o(288104);
  }
  
  public final void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(288100);
    p.k(paramViewGroup, "container");
    p.k(paramObject, "object");
    StringBuilder localStringBuilder = new StringBuilder("setPrimaryItem ").append(paramInt).append("  changePosition ");
    Object localObject = this.Bde;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((a)localObject).Bdl);; localObject = null)
    {
      Log.i("Finder.DynamicAdapter", localObject + ", obj:" + paramObject + ' ' + "title:" + ((FinderHomeTabFragment)paramObject).title + " tabType:" + ((FinderHomeTabFragment)paramObject).fEH);
      super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
      paramViewGroup = this.Bde;
      if (paramViewGroup == null) {
        break;
      }
      if (paramViewGroup.Bdl == paramInt)
      {
        Log.i("Finder.DynamicAdapter", "setPrimaryItem action null");
        this.Bde = null;
      }
      AppMethodBeat.o(288100);
      return;
    }
    AppMethodBeat.o(288100);
  }
  
  public final void startUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(288103);
    p.k(paramViewGroup, "container");
    this.jJQ = true;
    super.startUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "startUpdate");
    AppMethodBeat.o(288103);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "", "isAdd", "", "changePosition", "", "(ZI)V", "getChangePosition", "()I", "()Z", "plugin-finder_release"})
  public static final class a
  {
    final int Bdl;
    final boolean oxR;
    
    public a(boolean paramBoolean, int paramInt)
    {
      this.oxR = paramBoolean;
      this.Bdl = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$Companion;", "", "()V", "IS_ENABLE_PENDING", "", "PENDING_LIMIT", "", "PENDING_TIME_LIMIT", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */