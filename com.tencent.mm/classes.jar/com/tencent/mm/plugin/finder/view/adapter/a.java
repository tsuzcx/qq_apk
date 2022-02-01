package com.tencent.mm.plugin.finder.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "FragmentType", "Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "viewPager", "Landroid/support/v4/view/ViewPager;", "manager", "Landroid/support/v4/app/FragmentManager;", "pageFragments", "", "(Landroid/support/v4/view/ViewPager;Landroid/support/v4/app/FragmentManager;Ljava/util/List;)V", "action", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "isUpdating", "", "getManager", "()Landroid/support/v4/app/FragmentManager;", "pendingAction", "pendingActionRunnable", "Ljava/lang/Runnable;", "pendingFragment", "addPendingActon", "", "fragment", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;Ljava/lang/Object;)V", "checkPendingAction", "finishUpdate", "container", "Landroid/view/ViewGroup;", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "position", "getItemPosition", "object", "", "handleNextPendingAction", "instantiateItem", "instantiateItemInner", "notifyAddItem", "(ILjava/lang/Object;)V", "notifyDataSetChanged", "notifyItemChange", "notifyRemoveItem", "onDestroy", "removePendingActions", "setPrimaryItem", "startUpdate", "ChangeAction", "Companion", "plugin-finder_release"})
public final class a<FragmentType>
  extends d
{
  public static final b wrf;
  private boolean gYQ;
  public final ViewPager uO;
  private a wqZ;
  public List<a> wra;
  public List<FragmentType> wrb;
  public Runnable wrc;
  private final g wrd;
  private final List<FragmentType> wre;
  
  static
  {
    AppMethodBeat.i(255143);
    wrf = new b((byte)0);
    AppMethodBeat.o(255143);
  }
  
  public a(ViewPager paramViewPager, g paramg, List<FragmentType> paramList)
  {
    super(paramg);
    AppMethodBeat.i(255142);
    this.uO = paramViewPager;
    this.wrd = paramg;
    this.wre = paramList;
    this.wra = ((List)new ArrayList());
    this.wrb = ((List)new ArrayList());
    AppMethodBeat.o(255142);
  }
  
  public final void a(a parama, FragmentType paramFragmentType)
  {
    AppMethodBeat.i(255141);
    p.h(parama, "action");
    this.wqZ = parama;
    Log.i("Finder.DynamicAdapter", "notifyItemChange isAdd:" + parama.lCr + " position " + parama.wrg);
    if (parama.lCr)
    {
      int j = parama.wrg;
      if (paramFragmentType != null)
      {
        if ((j >= 0) && (j <= this.wre.size()))
        {
          parama = this.wre;
          if (!this.wre.contains(paramFragmentType))
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
            AppMethodBeat.o(255141);
            return;
            i = 0;
            break;
            label140:
            parama = null;
          }
        }
        Log.e("Finder.DynamicAdapter", "notifyAddItem index out of range");
      }
      AppMethodBeat.o(255141);
      return;
    }
    int i = parama.wrg;
    if ((i >= 0) && (i < this.wre.size()))
    {
      this.wre.remove(i);
      notifyDataSetChanged();
      AppMethodBeat.o(255141);
      return;
    }
    Log.e("Finder.DynamicAdapter", "notifyRemoveItem index out of range");
    AppMethodBeat.o(255141);
  }
  
  public final void finishUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255138);
    p.h(paramViewGroup, "container");
    super.finishUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "finishUpdate");
    this.gYQ = false;
    AppMethodBeat.o(255138);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(255134);
    int i = this.wre.size();
    AppMethodBeat.o(255134);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(255133);
    Object localObject = this.wre.get(paramInt);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.support.v4.app.Fragment");
      AppMethodBeat.o(255133);
      throw ((Throwable)localObject);
    }
    localObject = (Fragment)localObject;
    if ((localObject instanceof FinderHomeTabFragment)) {
      Log.i("Finder.DynamicAdapter", "getItem " + paramInt + " fragment:" + ((FinderHomeTabFragment)localObject).title + " tabType:" + ((FinderHomeTabFragment)localObject).dLS);
    }
    AppMethodBeat.o(255133);
    return localObject;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(255137);
    p.h(paramObject, "object");
    int j = super.getItemPosition(paramObject);
    Log.i("Finder.DynamicAdapter", "getItemPosition : position ".concat(String.valueOf(j)));
    int i = j;
    a locala;
    if ((paramObject instanceof Fragment))
    {
      locala = this.wqZ;
      i = j;
      if (locala != null)
      {
        i = this.wre.indexOf(paramObject);
        Log.i("Finder.DynamicAdapter", "getItemPosition : newPosition " + i + " changePosition :" + locala.wrg);
        if (i != -1) {
          break label115;
        }
        i = -2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(255137);
      return i;
      label115:
      if (i >= locala.wrg)
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
    AppMethodBeat.i(255135);
    p.h(paramViewGroup, "container");
    Log.i("Finder.DynamicAdapter", "instantiateItem " + paramInt + " action:" + this.wqZ);
    Object localObject1 = this.wqZ;
    if ((localObject1 != null) && (((a)localObject1).lCr))
    {
      if (paramInt == this.mFragments.size())
      {
        paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
        AppMethodBeat.o(255135);
        return paramViewGroup;
      }
      Object localObject2 = this.mFragments;
      if (paramInt < ((ArrayList)localObject2).size())
      {
        if (this.mCurTransaction == null) {
          this.mCurTransaction = this.wrt.beginTransaction();
        }
        localObject1 = getItem(paramInt);
        if (this.mSavedState.size() > paramInt)
        {
          Fragment.SavedState localSavedState = (Fragment.SavedState)this.mSavedState.get(paramInt);
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
          AppMethodBeat.o(255135);
          throw paramViewGroup;
        }
        Log.i("Finder.DynamicAdapter", ((FinderHomeTabFragment)localObject1).title + " tabType:" + ((FinderHomeTabFragment)localObject1).dLS);
        localObject2 = this.mCurTransaction;
        if (localObject2 != null) {
          ((k)localObject2).a(paramViewGroup.getId(), (Fragment)localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = super.instantiateItem(paramViewGroup, paramInt);
        }
        AppMethodBeat.o(255135);
        return localObject2;
        localObject1 = null;
      }
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(255135);
    return paramViewGroup;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(255140);
    this.gYQ = true;
    Log.i("Finder.DynamicAdapter", "notifyDataSetChanged");
    super.notifyDataSetChanged();
    AppMethodBeat.o(255140);
  }
  
  public final void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(255136);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "object");
    StringBuilder localStringBuilder = new StringBuilder("setPrimaryItem ").append(paramInt).append("  changePosition ");
    Object localObject = this.wqZ;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((a)localObject).wrg);; localObject = null)
    {
      Log.i("Finder.DynamicAdapter", localObject + ", obj:" + paramObject + ' ' + "title:" + ((FinderHomeTabFragment)paramObject).title + " tabType:" + ((FinderHomeTabFragment)paramObject).dLS);
      super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
      paramViewGroup = this.wqZ;
      if (paramViewGroup == null) {
        break;
      }
      if (paramViewGroup.wrg == paramInt)
      {
        Log.i("Finder.DynamicAdapter", "setPrimaryItem action null");
        this.wqZ = null;
      }
      AppMethodBeat.o(255136);
      return;
    }
    AppMethodBeat.o(255136);
  }
  
  public final void startUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255139);
    p.h(paramViewGroup, "container");
    this.gYQ = true;
    super.startUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "startUpdate");
    AppMethodBeat.o(255139);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "", "isAdd", "", "changePosition", "", "(ZI)V", "getChangePosition", "()I", "()Z", "plugin-finder_release"})
  public static final class a
  {
    final boolean lCr;
    final int wrg;
    
    public a(boolean paramBoolean, int paramInt)
    {
      this.lCr = paramBoolean;
      this.wrg = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$Companion;", "", "()V", "IS_ENABLE_PENDING", "", "PENDING_LIMIT", "", "PENDING_TIME_LIMIT", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */