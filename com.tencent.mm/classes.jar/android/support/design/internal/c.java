package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

public final class c
  implements o
{
  public int id;
  h kC;
  public ColorStateList kR;
  public NavigationMenuView kW;
  public LinearLayout kX;
  private o.a kY;
  public b kZ;
  final View.OnClickListener km = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      c.this.q(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      boolean bool = c.this.kC.a(paramAnonymousView, c.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        c.this.kZ.d(paramAnonymousView);
      }
      c.this.q(false);
      c.this.p(false);
    }
  };
  public Drawable ky;
  boolean la;
  public LayoutInflater layoutInflater;
  public ColorStateList lb;
  public int lc;
  public int ld;
  public int le;
  int lf;
  int textAppearance;
  
  public final void a(Context paramContext, h paramh)
  {
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.kC = paramh;
    this.lf = paramContext.getResources().getDimensionPixelOffset(2131166120);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (this.kY != null) {
      this.kY.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.kY = parama;
  }
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean bD()
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final void d(j paramj)
  {
    this.kZ.d(paramj);
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject1 != null) {
        this.kW.restoreHierarchyState((SparseArray)localObject1);
      }
      Object localObject2 = paramParcelable.getBundle("android:menu:adapter");
      if (localObject2 != null)
      {
        localObject1 = this.kZ;
        int k = ((Bundle)localObject2).getInt("android:menu:checked", 0);
        int m;
        int i;
        if (k != 0)
        {
          ((b)localObject1).kF = true;
          m = ((b)localObject1).lh.size();
          i = 0;
        }
        for (;;)
        {
          Object localObject3;
          if (i < m)
          {
            localObject3 = (d)((b)localObject1).lh.get(i);
            if ((localObject3 instanceof f))
            {
              localObject3 = ((f)localObject3).lj;
              if ((localObject3 != null) && (((j)localObject3).getItemId() == k)) {
                ((b)localObject1).d((j)localObject3);
              }
            }
          }
          else
          {
            ((b)localObject1).kF = false;
            ((b)localObject1).bE();
            localObject2 = ((Bundle)localObject2).getSparseParcelableArray("android:menu:action_views");
            if (localObject2 == null) {
              break;
            }
            k = ((b)localObject1).lh.size();
            i = j;
            while (i < k)
            {
              localObject3 = (d)((b)localObject1).lh.get(i);
              if ((localObject3 instanceof f))
              {
                Object localObject4 = ((f)localObject3).lj;
                if (localObject4 != null)
                {
                  localObject3 = ((j)localObject4).getActionView();
                  if (localObject3 != null)
                  {
                    localObject4 = (ParcelableSparseArray)((SparseArray)localObject2).get(((j)localObject4).getItemId());
                    if (localObject4 != null) {
                      ((View)localObject3).restoreHierarchyState((SparseArray)localObject4);
                    }
                  }
                }
              }
              i += 1;
            }
          }
          i += 1;
        }
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.kX.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray;
    if (this.kW != null)
    {
      localSparseArray = new SparseArray();
      this.kW.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (this.kZ != null) {
      localBundle.putBundle("android:menu:adapter", this.kZ.bF());
    }
    if (this.kX != null)
    {
      localSparseArray = new SparseArray();
      this.kX.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
    }
    return localBundle;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.kZ != null)
    {
      b localb = this.kZ;
      localb.bE();
      localb.asY.notifyChanged();
    }
  }
  
  public final void q(boolean paramBoolean)
  {
    if (this.kZ != null) {
      this.kZ.kF = paramBoolean;
    }
  }
  
  public final void setItemBackground(Drawable paramDrawable)
  {
    this.ky = paramDrawable;
    p(false);
  }
  
  public final void setItemHorizontalPadding(int paramInt)
  {
    this.lc = paramInt;
    p(false);
  }
  
  public final void setItemIconPadding(int paramInt)
  {
    this.ld = paramInt;
    p(false);
  }
  
  public final void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.kR = paramColorStateList;
    p(false);
  }
  
  public final void setItemTextAppearance(int paramInt)
  {
    this.textAppearance = paramInt;
    this.la = true;
    p(false);
  }
  
  public final void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.lb = paramColorStateList;
    p(false);
  }
  
  static final class a
    extends c.j
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  public final class b
    extends RecyclerView.a<c.j>
  {
    boolean kF;
    final ArrayList<c.d> lh = new ArrayList();
    public j li;
    
    public b()
    {
      bE();
    }
    
    private void n(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((c.f)this.lh.get(paramInt1)).kO = true;
        paramInt1 += 1;
      }
    }
    
    final void bE()
    {
      if (this.kF) {
        return;
      }
      this.kF = true;
      this.lh.clear();
      this.lh.add(new c.c());
      int j = -1;
      int i = 0;
      boolean bool1 = false;
      int i2 = c.this.kC.hV().size();
      int n = 0;
      Object localObject;
      int k;
      boolean bool2;
      for (;;)
      {
        if (n < i2)
        {
          localObject = (j)c.this.kC.hV().get(n);
          if (((j)localObject).isChecked()) {
            d((j)localObject);
          }
          if (((j)localObject).isCheckable()) {
            ((j)localObject).ac(false);
          }
          if (((j)localObject).hasSubMenu())
          {
            SubMenu localSubMenu = ((j)localObject).getSubMenu();
            if (localSubMenu.hasVisibleItems())
            {
              if (n != 0) {
                this.lh.add(new c.e(c.this.lf, 0));
              }
              this.lh.add(new c.f((j)localObject));
              k = 0;
              int i3 = this.lh.size();
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
                    localj.ac(false);
                  }
                  if (((j)localObject).isChecked()) {
                    d((j)localObject);
                  }
                  this.lh.add(new c.f(localj));
                }
                i1 += 1;
                k = m;
              }
              if (k != 0) {
                n(i3, this.lh.size());
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
              j = this.lh.size();
              if (((j)localObject).getIcon() != null)
              {
                bool2 = true;
                label386:
                bool1 = bool2;
                i = j;
                if (n != 0)
                {
                  i = j + 1;
                  this.lh.add(new c.e(c.this.lf, c.this.lf));
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
        ((c.f)localObject).kO = bool1;
        this.lh.add(localObject);
        j = i;
        i = k;
        break;
        bool2 = false;
        break label386;
        if ((!bool1) && (((j)localObject).getIcon() != null))
        {
          bool1 = true;
          n(i, this.lh.size());
          continue;
          this.kF = false;
          return;
        }
      }
    }
    
    public final Bundle bF()
    {
      Bundle localBundle = new Bundle();
      if (this.li != null) {
        localBundle.putInt("android:menu:checked", this.li.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int j = this.lh.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = (c.d)this.lh.get(i);
        j localj;
        if ((localObject instanceof c.f))
        {
          localj = ((c.f)localObject).lj;
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
      if ((this.li == paramj) || (!paramj.isCheckable())) {
        return;
      }
      if (this.li != null) {
        this.li.setChecked(false);
      }
      this.li = paramj;
      paramj.setChecked(true);
    }
    
    public final int getItemCount()
    {
      return this.lh.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      c.d locald = (c.d)this.lh.get(paramInt);
      if ((locald instanceof c.e)) {
        return 2;
      }
      if ((locald instanceof c.c)) {
        return 3;
      }
      if ((locald instanceof c.f))
      {
        if (((c.f)locald).lj.hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
  }
  
  static final class c
    implements c.d
  {}
  
  static abstract interface d {}
  
  static final class e
    implements c.d
  {
    final int paddingBottom;
    final int paddingTop;
    
    public e(int paramInt1, int paramInt2)
    {
      this.paddingTop = paramInt1;
      this.paddingBottom = paramInt2;
    }
  }
  
  static final class f
    implements c.d
  {
    boolean kO;
    final j lj;
    
    f(j paramj)
    {
      this.lj = paramj;
    }
  }
  
  static final class g
    extends c.j
  {
    public g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.auu.setOnClickListener(paramOnClickListener);
    }
  }
  
  static final class h
    extends c.j
  {
    public h(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  static final class i
    extends c.j
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  static abstract class j
    extends RecyclerView.w
  {
    public j(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.c
 * JD-Core Version:    0.7.0.1
 */