package com.tencent.mm.plugin.finder.view.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "FragmentType", "Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "manager", "Landroidx/fragment/app/FragmentManager;", "pageFragments", "", "(Landroidx/viewpager/widget/ViewPager;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "action", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "isUpdating", "", "getManager", "()Landroidx/fragment/app/FragmentManager;", "pendingAction", "pendingActionRunnable", "Ljava/lang/Runnable;", "pendingFragment", "addPendingActon", "", "fragment", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;Ljava/lang/Object;)V", "checkPendingAction", "finishUpdate", "container", "Landroid/view/ViewGroup;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "handleNextPendingAction", "instantiateItem", "instantiateItemInner", "notifyAddItem", "(ILjava/lang/Object;)V", "notifyDataSetChanged", "notifyItemChange", "notifyRemoveItem", "onDestroy", "removePendingActions", "setPrimaryItem", "startUpdate", "ChangeAction", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<FragmentType>
  extends d
{
  public static final a.b GFR;
  private final FragmentManager GFS;
  private final List<FragmentType> GFT;
  private a GFU;
  public List<a> GFV;
  public List<FragmentType> GFW;
  public Runnable GFX;
  public final ViewPager dyl;
  private boolean mjj;
  
  static
  {
    AppMethodBeat.i(345463);
    GFR = new a.b((byte)0);
    AppMethodBeat.o(345463);
  }
  
  public a(ViewPager paramViewPager, FragmentManager paramFragmentManager, List<FragmentType> paramList)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(345457);
    this.dyl = paramViewPager;
    this.GFS = paramFragmentManager;
    this.GFT = paramList;
    this.GFV = ((List)new ArrayList());
    this.GFW = ((List)new ArrayList());
    AppMethodBeat.o(345457);
  }
  
  public final void a(a parama, FragmentType paramFragmentType)
  {
    AppMethodBeat.i(345525);
    s.u(parama, "action");
    this.GFU = parama;
    Log.i("Finder.DynamicAdapter", "notifyItemChange isAdd:" + parama.rBq + " position " + parama.GFY);
    if (parama.rBq)
    {
      int j = parama.GFY;
      if (paramFragmentType != null)
      {
        if ((j >= 0) && (j <= this.GFT.size()))
        {
          parama = this.GFT;
          if (!this.GFT.contains(paramFragmentType))
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
            AppMethodBeat.o(345525);
            return;
            i = 0;
            break;
            label140:
            parama = null;
          }
        }
        Log.e("Finder.DynamicAdapter", "notifyAddItem index out of range");
      }
      AppMethodBeat.o(345525);
      return;
    }
    int i = parama.GFY;
    if ((i >= 0) && (i < this.GFT.size()))
    {
      this.GFT.remove(i);
      notifyDataSetChanged();
      AppMethodBeat.o(345525);
      return;
    }
    Log.e("Finder.DynamicAdapter", "notifyRemoveItem index out of range");
    AppMethodBeat.o(345525);
  }
  
  public final void finishUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345504);
    s.u(paramViewGroup, "container");
    super.finishUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "finishUpdate");
    this.mjj = false;
    AppMethodBeat.o(345504);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(345473);
    int i = this.GFT.size();
    AppMethodBeat.o(345473);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(345470);
    Object localObject = this.GFT.get(paramInt);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
      AppMethodBeat.o(345470);
      throw ((Throwable)localObject);
    }
    localObject = (Fragment)localObject;
    if ((localObject instanceof FinderHomeTabFragment)) {
      Log.i("Finder.DynamicAdapter", "getItem " + paramInt + " fragment:" + ((FinderHomeTabFragment)localObject).title + " tabType:" + ((FinderHomeTabFragment)localObject).hJx);
    }
    AppMethodBeat.o(345470);
    return localObject;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(345496);
    s.u(paramObject, "object");
    int j = super.getItemPosition(paramObject);
    Log.i("Finder.DynamicAdapter", s.X("getItemPosition : position ", Integer.valueOf(j)));
    int i = j;
    a locala;
    if ((paramObject instanceof Fragment))
    {
      locala = this.GFU;
      i = j;
      if (locala != null)
      {
        i = this.GFT.indexOf(paramObject);
        Log.i("Finder.DynamicAdapter", "getItemPosition : newPosition " + i + " changePosition :" + locala.GFY);
        if (i != -1) {
          break label115;
        }
        i = -2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(345496);
      return i;
      label115:
      if (i >= locala.GFY)
      {
        Log.i("Finder.DynamicAdapter", s.X("use new ", Integer.valueOf(i)));
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
    AppMethodBeat.i(345482);
    s.u(paramViewGroup, "container");
    Log.i("Finder.DynamicAdapter", "instantiateItem " + paramInt + " action:" + this.GFU);
    Object localObject1 = this.GFU;
    if ((localObject1 != null) && (((a)localObject1).rBq))
    {
      if (paramInt == flL().size())
      {
        paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
        AppMethodBeat.o(345482);
        return paramViewGroup;
      }
      Object localObject2 = flL();
      if (paramInt < ((ArrayList)localObject2).size())
      {
        if (flJ() == null) {
          b(flI().beginTransaction());
        }
        localObject1 = getItem(paramInt);
        if (flK().size() > paramInt)
        {
          Fragment.SavedState localSavedState = (Fragment.SavedState)flK().get(paramInt);
          if (localSavedState != null) {
            ((Fragment)localObject1).setInitialSavedState(localSavedState);
          }
        }
        ((Fragment)localObject1).setMenuVisibility(false);
        ((Fragment)localObject1).setUserVisibleHint(false);
        ((ArrayList)localObject2).add(paramInt, localObject1);
        Log.i("Finder.DynamicAdapter", "instantiateItemInner: title:" + ((FinderHomeTabFragment)localObject1).title + " tabType:" + ((FinderHomeTabFragment)localObject1).hJx);
        localObject2 = flJ();
        if (localObject2 != null) {
          ((r)localObject2).a(paramViewGroup.getId(), (Fragment)localObject1);
        }
      }
      while (localObject1 == null)
      {
        paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
        AppMethodBeat.o(345482);
        return paramViewGroup;
        localObject1 = null;
      }
      AppMethodBeat.o(345482);
      return localObject1;
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(345482);
    return paramViewGroup;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(345518);
    this.mjj = true;
    Log.i("Finder.DynamicAdapter", "notifyDataSetChanged");
    super.notifyDataSetChanged();
    AppMethodBeat.o(345518);
  }
  
  public final void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(345488);
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    StringBuilder localStringBuilder = new StringBuilder("setPrimaryItem ").append(paramInt).append("  changePosition ");
    Object localObject = this.GFU;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((a)localObject).GFY))
    {
      Log.i("Finder.DynamicAdapter", localObject + ", obj:" + paramObject + " title:" + ((FinderHomeTabFragment)paramObject).title + " tabType:" + ((FinderHomeTabFragment)paramObject).hJx);
      super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
      paramViewGroup = this.GFU;
      if ((paramViewGroup != null) && (paramViewGroup.GFY == paramInt))
      {
        Log.i("Finder.DynamicAdapter", "setPrimaryItem action null");
        this.GFU = null;
      }
      AppMethodBeat.o(345488);
      return;
    }
  }
  
  public final void startUpdate(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345512);
    s.u(paramViewGroup, "container");
    this.mjj = true;
    super.startUpdate(paramViewGroup);
    Log.i("Finder.DynamicAdapter", "startUpdate");
    AppMethodBeat.o(345512);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "", "isAdd", "", "changePosition", "", "(ZI)V", "getChangePosition", "()I", "()Z", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final int GFY;
    final boolean rBq;
    
    public a(boolean paramBoolean, int paramInt)
    {
      this.rBq = paramBoolean;
      this.GFY = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */