package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class n
  extends android.support.v4.view.n
{
  private final j wr;
  private o ws = null;
  private Fragment wt = null;
  private ArrayList<Fragment.SavedState> wv = new ArrayList();
  private ArrayList<Fragment> ww = new ArrayList();
  
  public n(j paramj)
  {
    this.wr = paramj;
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.wv.clear();
      this.ww.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.wv.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        Object localObject = (String)paramClassLoader.next();
        if (((String)localObject).startsWith("f"))
        {
          i = Integer.parseInt(((String)localObject).substring(1));
          localObject = this.wr.d(paramParcelable, (String)localObject);
          if (localObject != null)
          {
            while (this.ww.size() <= i) {
              this.ww.add(null);
            }
            ((Fragment)localObject).setMenuVisibility(false);
            this.ww.set(i, localObject);
          }
        }
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (this.ws == null) {
      this.ws = this.wr.bP();
    }
    while (this.wv.size() <= paramInt) {
      this.wv.add(null);
    }
    ArrayList localArrayList = this.wv;
    if (paramObject.isAdded()) {}
    for (paramViewGroup = this.wr.e(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.ww.set(paramInt, null);
      this.ws.a(paramObject);
      return;
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public abstract Fragment ae(int paramInt);
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.ww.size() > paramInt)
    {
      localFragment = (Fragment)this.ww.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.ws == null) {
      this.ws = this.wr.bP();
    }
    Fragment localFragment = ae(paramInt);
    if (this.wv.size() > paramInt)
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)this.wv.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    while (this.ww.size() <= paramInt) {
      this.ww.add(null);
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    this.ww.set(paramInt, localFragment);
    this.ws.a(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public final void cc()
  {
    if (this.ws != null)
    {
      this.ws.commitNowAllowingStateLoss();
      this.ws = null;
    }
  }
  
  public final Parcelable cd()
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.wv.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.wv.size()];
      this.wv.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    while (i < this.ww.size())
    {
      Fragment localFragment = (Fragment)this.ww.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = "f" + i;
          this.wr.a((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public final void e(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
  
  public final void j(Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (paramObject != this.wt)
    {
      if (this.wt != null)
      {
        this.wt.setMenuVisibility(false);
        this.wt.setUserVisibleHint(false);
      }
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(true);
        paramObject.setUserVisibleHint(true);
      }
      this.wt = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.n
 * JD-Core Version:    0.7.0.1
 */