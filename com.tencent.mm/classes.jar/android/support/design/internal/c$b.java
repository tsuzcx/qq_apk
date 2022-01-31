package android.support.design.internal;

import android.os.Bundle;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.widget.RecyclerView.a;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;

public final class c$b
  extends RecyclerView.a<c.j>
{
  private j eW;
  boolean et;
  final ArrayList<c.d> mItems = new ArrayList();
  
  public c$b(c paramc)
  {
    aH();
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      ((c.f)this.mItems.get(paramInt1)).eY = true;
      paramInt1 += 1;
    }
  }
  
  final void aH()
  {
    if (this.et) {
      return;
    }
    this.et = true;
    this.mItems.clear();
    this.mItems.add(new c.c());
    int j = -1;
    int i = 0;
    boolean bool1 = false;
    int i2 = this.eV.eq.gb().size();
    int n = 0;
    Object localObject;
    int k;
    boolean bool2;
    for (;;)
    {
      if (n < i2)
      {
        localObject = (j)this.eV.eq.gb().get(n);
        if (((j)localObject).isChecked()) {
          d((j)localObject);
        }
        if (((j)localObject).isCheckable()) {
          ((j)localObject).W(false);
        }
        if (((j)localObject).hasSubMenu())
        {
          SubMenu localSubMenu = ((j)localObject).getSubMenu();
          if (localSubMenu.hasVisibleItems())
          {
            if (n != 0) {
              this.mItems.add(new c.e(this.eV.eU, 0));
            }
            this.mItems.add(new c.f((j)localObject));
            k = 0;
            int i3 = this.mItems.size();
            int i4 = localSubMenu.size();
            int i1 = 0;
            while (i1 < i4)
            {
              j localj = (j)localSubMenu.getItem(i1);
              int m = k;
              if (localj.isVisible())
              {
                m = k;
                if (k == 0)
                {
                  m = k;
                  if (localj.getIcon() != null) {
                    m = 1;
                  }
                }
                if (localj.isCheckable()) {
                  localj.W(false);
                }
                if (((j)localObject).isChecked()) {
                  d((j)localObject);
                }
                this.mItems.add(new c.f(localj));
              }
              i1 += 1;
              k = m;
            }
            if (k != 0) {
              f(i3, this.mItems.size());
            }
          }
          k = j;
          j = i;
          i = k;
          n += 1;
          k = i;
          i = j;
          j = k;
        }
        else
        {
          k = ((j)localObject).getGroupId();
          if (k != j)
          {
            j = this.mItems.size();
            if (((j)localObject).getIcon() != null)
            {
              bool2 = true;
              label386:
              bool1 = bool2;
              i = j;
              if (n != 0)
              {
                i = j + 1;
                this.mItems.add(new c.e(this.eV.eU, this.eV.eU));
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new c.f((j)localObject);
      ((c.f)localObject).eY = bool1;
      this.mItems.add(localObject);
      j = i;
      i = k;
      break;
      bool2 = false;
      break label386;
      if ((!bool1) && (((j)localObject).getIcon() != null))
      {
        bool1 = true;
        f(i, this.mItems.size());
        continue;
        this.et = false;
        return;
      }
    }
  }
  
  public final Bundle aI()
  {
    Bundle localBundle = new Bundle();
    if (this.eW != null) {
      localBundle.putInt("android:menu:checked", this.eW.getItemId());
    }
    SparseArray localSparseArray = new SparseArray();
    int j = this.mItems.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (c.d)this.mItems.get(i);
      j localj;
      if ((localObject instanceof c.f))
      {
        localj = ((c.f)localObject).eX;
        if (localj == null) {
          break label132;
        }
      }
      label132:
      for (localObject = localj.getActionView();; localObject = null)
      {
        if (localObject != null)
        {
          ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
          ((View)localObject).saveHierarchyState(localParcelableSparseArray);
          localSparseArray.put(localj.getItemId(), localParcelableSparseArray);
        }
        i += 1;
        break;
      }
    }
    localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
    return localBundle;
  }
  
  public final void d(j paramj)
  {
    if ((this.eW == paramj) || (!paramj.isCheckable())) {
      return;
    }
    if (this.eW != null) {
      this.eW.setChecked(false);
    }
    this.eW = paramj;
    paramj.setChecked(true);
  }
  
  public final int getItemCount()
  {
    return this.mItems.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    c.d locald = (c.d)this.mItems.get(paramInt);
    if ((locald instanceof c.e)) {
      return 2;
    }
    if ((locald instanceof c.c)) {
      return 3;
    }
    if ((locald instanceof c.f))
    {
      if (((c.f)locald).eX.hasSubMenu()) {
        return 1;
      }
      return 0;
    }
    throw new RuntimeException("Unknown item type.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.c.b
 * JD-Core Version:    0.7.0.1
 */