package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.u;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.google.android.material.a.d;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class g
  implements o
{
  final View.OnClickListener dpY;
  public Drawable dqh;
  public NavigationMenuView dvD;
  public LinearLayout dvE;
  private o.a dvF;
  public b dvG;
  public LayoutInflater dvH;
  int dvI;
  boolean dvJ;
  public ColorStateList dvK;
  public int dvL;
  int dvM;
  public ColorStateList dvy;
  h hP;
  public int id;
  public int itemHorizontalPadding;
  public int itemIconPadding;
  
  public g()
  {
    AppMethodBeat.i(209269);
    this.dpY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209396);
        paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
        g.this.bO(true);
        paramAnonymousView = paramAnonymousView.getItemData();
        boolean bool = g.this.hP.a(paramAnonymousView, g.this, 0);
        if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
          g.this.dvG.h(paramAnonymousView);
        }
        g.this.bO(false);
        g.this.J(false);
        AppMethodBeat.o(209396);
      }
    };
    AppMethodBeat.o(209269);
  }
  
  public final void J(boolean paramBoolean)
  {
    AppMethodBeat.i(209288);
    if (this.dvG != null)
    {
      b localb = this.dvG;
      localb.WP();
      localb.bZE.notifyChanged();
    }
    AppMethodBeat.o(209288);
  }
  
  public final void a(Context paramContext, h paramh)
  {
    AppMethodBeat.i(209280);
    this.dvH = LayoutInflater.from(paramContext);
    this.hP = paramh;
    this.dvM = paramContext.getResources().getDimensionPixelOffset(a.d.design_navigation_separator_vertical_padding);
    AppMethodBeat.o(209280);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(209306);
    if (this.dvF != null) {
      this.dvF.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(209306);
  }
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final void b(o.a parama)
  {
    this.dvF = parama;
  }
  
  public final void bO(boolean paramBoolean)
  {
    if (this.dvG != null) {
      this.dvG.dqn = paramBoolean;
    }
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean cL()
  {
    return false;
  }
  
  public final boolean d(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final void h(j paramj)
  {
    AppMethodBeat.i(209350);
    this.dvG.h(paramj);
    AppMethodBeat.o(209350);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    AppMethodBeat.i(209344);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject1 != null) {
        this.dvD.restoreHierarchyState((SparseArray)localObject1);
      }
      Object localObject2 = paramParcelable.getBundle("android:menu:adapter");
      if (localObject2 != null)
      {
        localObject1 = this.dvG;
        int k = ((Bundle)localObject2).getInt("android:menu:checked", 0);
        int m;
        int i;
        if (k != 0)
        {
          ((b)localObject1).dqn = true;
          m = ((b)localObject1).dvO.size();
          i = 0;
        }
        for (;;)
        {
          Object localObject3;
          if (i < m)
          {
            localObject3 = (d)((b)localObject1).dvO.get(i);
            if ((localObject3 instanceof f))
            {
              localObject3 = ((f)localObject3).dvS;
              if ((localObject3 != null) && (((j)localObject3).getItemId() == k)) {
                ((b)localObject1).h((j)localObject3);
              }
            }
          }
          else
          {
            ((b)localObject1).dqn = false;
            ((b)localObject1).WP();
            localObject2 = ((Bundle)localObject2).getSparseParcelableArray("android:menu:action_views");
            if (localObject2 == null) {
              break;
            }
            k = ((b)localObject1).dvO.size();
            i = j;
            while (i < k)
            {
              localObject3 = (d)((b)localObject1).dvO.get(i);
              if ((localObject3 instanceof f))
              {
                Object localObject4 = ((f)localObject3).dvS;
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
        this.dvE.restoreHierarchyState(paramParcelable);
      }
    }
    AppMethodBeat.o(209344);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(209333);
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray;
    if (this.dvD != null)
    {
      localSparseArray = new SparseArray();
      this.dvD.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (this.dvG != null) {
      localBundle.putBundle("android:menu:adapter", this.dvG.WQ());
    }
    if (this.dvE != null)
    {
      localSparseArray = new SparseArray();
      this.dvE.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
    }
    AppMethodBeat.o(209333);
    return localBundle;
  }
  
  public final void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209390);
    this.dqh = paramDrawable;
    J(false);
    AppMethodBeat.o(209390);
  }
  
  public final void setItemHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(209401);
    this.itemHorizontalPadding = paramInt;
    J(false);
    AppMethodBeat.o(209401);
  }
  
  public final void setItemIconPadding(int paramInt)
  {
    AppMethodBeat.i(209412);
    this.itemIconPadding = paramInt;
    J(false);
    AppMethodBeat.o(209412);
  }
  
  public final void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209360);
    this.dvy = paramColorStateList;
    J(false);
    AppMethodBeat.o(209360);
  }
  
  public final void setItemTextAppearance(int paramInt)
  {
    AppMethodBeat.i(209383);
    this.dvI = paramInt;
    this.dvJ = true;
    J(false);
    AppMethodBeat.o(209383);
  }
  
  public final void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209370);
    this.dvK = paramColorStateList;
    J(false);
    AppMethodBeat.o(209370);
  }
  
  static final class a
    extends g.j
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  public final class b
    extends RecyclerView.a<g.j>
  {
    boolean dqn;
    final ArrayList<g.d> dvO;
    public j dvP;
    
    public b()
    {
      AppMethodBeat.i(209359);
      this.dvO = new ArrayList();
      WP();
      AppMethodBeat.o(209359);
    }
    
    private void cw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209368);
      while (paramInt1 < paramInt2)
      {
        ((g.f)this.dvO.get(paramInt1)).dvv = true;
        paramInt1 += 1;
      }
      AppMethodBeat.o(209368);
    }
    
    final void WP()
    {
      AppMethodBeat.i(209408);
      if (this.dqn)
      {
        AppMethodBeat.o(209408);
        return;
      }
      this.dqn = true;
      this.dvO.clear();
      this.dvO.add(new g.c());
      int j = -1;
      int i = 0;
      boolean bool1 = false;
      int i2 = g.this.hP.db().size();
      int n = 0;
      Object localObject;
      int k;
      boolean bool2;
      for (;;)
      {
        if (n < i2)
        {
          localObject = (j)g.this.hP.db().get(n);
          if (((j)localObject).isChecked()) {
            h((j)localObject);
          }
          if (((j)localObject).isCheckable()) {
            ((j)localObject).M(false);
          }
          if (((j)localObject).hasSubMenu())
          {
            SubMenu localSubMenu = ((j)localObject).getSubMenu();
            if (localSubMenu.hasVisibleItems())
            {
              if (n != 0) {
                this.dvO.add(new g.e(g.this.dvM, 0));
              }
              this.dvO.add(new g.f((j)localObject));
              k = 0;
              int i3 = this.dvO.size();
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
                    localj.M(false);
                  }
                  if (((j)localObject).isChecked()) {
                    h((j)localObject);
                  }
                  this.dvO.add(new g.f(localj));
                }
                i1 += 1;
                k = m;
              }
              if (k != 0) {
                cw(i3, this.dvO.size());
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
              j = this.dvO.size();
              if (((j)localObject).getIcon() != null)
              {
                bool2 = true;
                label396:
                bool1 = bool2;
                i = j;
                if (n != 0)
                {
                  i = j + 1;
                  this.dvO.add(new g.e(g.this.dvM, g.this.dvM));
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = new g.f((j)localObject);
        ((g.f)localObject).dvv = bool1;
        this.dvO.add(localObject);
        j = i;
        i = k;
        break;
        bool2 = false;
        break label396;
        if ((!bool1) && (((j)localObject).getIcon() != null))
        {
          bool1 = true;
          cw(i, this.dvO.size());
          continue;
          this.dqn = false;
          AppMethodBeat.o(209408);
          return;
        }
      }
    }
    
    public final Bundle WQ()
    {
      AppMethodBeat.i(209423);
      Bundle localBundle = new Bundle();
      if (this.dvP != null) {
        localBundle.putInt("android:menu:checked", this.dvP.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int j = this.dvO.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = (g.d)this.dvO.get(i);
        j localj;
        if ((localObject instanceof g.f))
        {
          localj = ((g.f)localObject).dvS;
          if (localj == null) {
            break label136;
          }
        }
        label136:
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
      AppMethodBeat.o(209423);
      return localBundle;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(209382);
      int i = this.dvO.size();
      AppMethodBeat.o(209382);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(209395);
      Object localObject = (g.d)this.dvO.get(paramInt);
      if ((localObject instanceof g.e))
      {
        AppMethodBeat.o(209395);
        return 2;
      }
      if ((localObject instanceof g.c))
      {
        AppMethodBeat.o(209395);
        return 3;
      }
      if ((localObject instanceof g.f))
      {
        if (((g.f)localObject).dvS.hasSubMenu())
        {
          AppMethodBeat.o(209395);
          return 1;
        }
        AppMethodBeat.o(209395);
        return 0;
      }
      localObject = new RuntimeException("Unknown item type.");
      AppMethodBeat.o(209395);
      throw ((Throwable)localObject);
    }
    
    public final void h(j paramj)
    {
      AppMethodBeat.i(209418);
      if ((this.dvP == paramj) || (!paramj.isCheckable()))
      {
        AppMethodBeat.o(209418);
        return;
      }
      if (this.dvP != null) {
        this.dvP.setChecked(false);
      }
      this.dvP = paramj;
      paramj.setChecked(true);
      AppMethodBeat.o(209418);
    }
  }
  
  static final class c
    implements g.d
  {}
  
  static abstract interface d {}
  
  static final class e
    implements g.d
  {
    final int dvQ;
    final int dvR;
    
    public e(int paramInt1, int paramInt2)
    {
      this.dvQ = paramInt1;
      this.dvR = paramInt2;
    }
  }
  
  static final class f
    implements g.d
  {
    final j dvS;
    boolean dvv;
    
    f(j paramj)
    {
      this.dvS = paramj;
    }
  }
  
  static final class g
    extends g.j
  {
    public g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      AppMethodBeat.i(209339);
      this.caK.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(209339);
    }
  }
  
  static final class h
    extends g.j
  {
    public h(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(209345);
      AppMethodBeat.o(209345);
    }
  }
  
  static final class i
    extends g.j
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(209357);
      AppMethodBeat.o(209357);
    }
  }
  
  static abstract class j
    extends RecyclerView.v
  {
    public j(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.g
 * JD-Core Version:    0.7.0.1
 */