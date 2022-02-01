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
  public NavigationMenuView bCC;
  public LinearLayout bCD;
  private o.a bCE;
  public b bCF;
  int bCG;
  boolean bCH;
  public ColorStateList bCI;
  public int bCJ;
  int bCK;
  public ColorStateList bCx;
  final View.OnClickListener bwV;
  public Drawable bxe;
  h gU;
  public int id;
  public int itemHorizontalPadding;
  public int itemIconPadding;
  public LayoutInflater layoutInflater;
  
  public g()
  {
    AppMethodBeat.i(237973);
    this.bwV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(237825);
        paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
        g.this.bh(true);
        paramAnonymousView = paramAnonymousView.getItemData();
        boolean bool = g.this.gU.a(paramAnonymousView, g.this, 0);
        if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
          g.this.bCF.h(paramAnonymousView);
        }
        g.this.bh(false);
        g.this.F(false);
        AppMethodBeat.o(237825);
      }
    };
    AppMethodBeat.o(237973);
  }
  
  public final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(237977);
    if (this.bCF != null)
    {
      b localb = this.bCF;
      localb.xs();
      localb.alc.notifyChanged();
    }
    AppMethodBeat.o(237977);
  }
  
  public final void a(Context paramContext, h paramh)
  {
    AppMethodBeat.i(237975);
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.gU = paramh;
    this.bCK = paramContext.getResources().getDimensionPixelOffset(a.d.design_navigation_separator_vertical_padding);
    AppMethodBeat.o(237975);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(237980);
    if (this.bCE != null) {
      this.bCE.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(237980);
  }
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final void b(o.a parama)
  {
    this.bCE = parama;
  }
  
  public final boolean bS()
  {
    return false;
  }
  
  public final void bh(boolean paramBoolean)
  {
    if (this.bCF != null) {
      this.bCF.bxk = paramBoolean;
    }
  }
  
  public final boolean c(j paramj)
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
    AppMethodBeat.i(237985);
    this.bCF.h(paramj);
    AppMethodBeat.o(237985);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    AppMethodBeat.i(237984);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject1 != null) {
        this.bCC.restoreHierarchyState((SparseArray)localObject1);
      }
      Object localObject2 = paramParcelable.getBundle("android:menu:adapter");
      if (localObject2 != null)
      {
        localObject1 = this.bCF;
        int k = ((Bundle)localObject2).getInt("android:menu:checked", 0);
        int m;
        int i;
        if (k != 0)
        {
          ((b)localObject1).bxk = true;
          m = ((b)localObject1).bCM.size();
          i = 0;
        }
        for (;;)
        {
          Object localObject3;
          if (i < m)
          {
            localObject3 = (d)((b)localObject1).bCM.get(i);
            if ((localObject3 instanceof f))
            {
              localObject3 = ((f)localObject3).bCQ;
              if ((localObject3 != null) && (((j)localObject3).getItemId() == k)) {
                ((b)localObject1).h((j)localObject3);
              }
            }
          }
          else
          {
            ((b)localObject1).bxk = false;
            ((b)localObject1).xs();
            localObject2 = ((Bundle)localObject2).getSparseParcelableArray("android:menu:action_views");
            if (localObject2 == null) {
              break;
            }
            k = ((b)localObject1).bCM.size();
            i = j;
            while (i < k)
            {
              localObject3 = (d)((b)localObject1).bCM.get(i);
              if ((localObject3 instanceof f))
              {
                Object localObject4 = ((f)localObject3).bCQ;
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
        this.bCD.restoreHierarchyState(paramParcelable);
      }
    }
    AppMethodBeat.o(237984);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(237983);
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray;
    if (this.bCC != null)
    {
      localSparseArray = new SparseArray();
      this.bCC.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (this.bCF != null) {
      localBundle.putBundle("android:menu:adapter", this.bCF.xt());
    }
    if (this.bCD != null)
    {
      localSparseArray = new SparseArray();
      this.bCD.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
    }
    AppMethodBeat.o(237983);
    return localBundle;
  }
  
  public final void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(237990);
    this.bxe = paramDrawable;
    F(false);
    AppMethodBeat.o(237990);
  }
  
  public final void setItemHorizontalPadding(int paramInt)
  {
    AppMethodBeat.i(237991);
    this.itemHorizontalPadding = paramInt;
    F(false);
    AppMethodBeat.o(237991);
  }
  
  public final void setItemIconPadding(int paramInt)
  {
    AppMethodBeat.i(237993);
    this.itemIconPadding = paramInt;
    F(false);
    AppMethodBeat.o(237993);
  }
  
  public final void setItemIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237986);
    this.bCx = paramColorStateList;
    F(false);
    AppMethodBeat.o(237986);
  }
  
  public final void setItemTextAppearance(int paramInt)
  {
    AppMethodBeat.i(237988);
    this.bCG = paramInt;
    this.bCH = true;
    F(false);
    AppMethodBeat.o(237988);
  }
  
  public final void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237987);
    this.bCI = paramColorStateList;
    F(false);
    AppMethodBeat.o(237987);
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
    final ArrayList<g.d> bCM;
    public j bCN;
    boolean bxk;
    
    public b()
    {
      AppMethodBeat.i(237860);
      this.bCM = new ArrayList();
      xs();
      AppMethodBeat.o(237860);
    }
    
    private void bB(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(237872);
      while (paramInt1 < paramInt2)
      {
        ((g.f)this.bCM.get(paramInt1)).bCu = true;
        paramInt1 += 1;
      }
      AppMethodBeat.o(237872);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(237863);
      int i = this.bCM.size();
      AppMethodBeat.o(237863);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(237866);
      Object localObject = (g.d)this.bCM.get(paramInt);
      if ((localObject instanceof g.e))
      {
        AppMethodBeat.o(237866);
        return 2;
      }
      if ((localObject instanceof g.c))
      {
        AppMethodBeat.o(237866);
        return 3;
      }
      if ((localObject instanceof g.f))
      {
        if (((g.f)localObject).bCQ.hasSubMenu())
        {
          AppMethodBeat.o(237866);
          return 1;
        }
        AppMethodBeat.o(237866);
        return 0;
      }
      localObject = new RuntimeException("Unknown item type.");
      AppMethodBeat.o(237866);
      throw ((Throwable)localObject);
    }
    
    public final void h(j paramj)
    {
      AppMethodBeat.i(237874);
      if ((this.bCN == paramj) || (!paramj.isCheckable()))
      {
        AppMethodBeat.o(237874);
        return;
      }
      if (this.bCN != null) {
        this.bCN.setChecked(false);
      }
      this.bCN = paramj;
      paramj.setChecked(true);
      AppMethodBeat.o(237874);
    }
    
    final void xs()
    {
      AppMethodBeat.i(237870);
      if (this.bxk)
      {
        AppMethodBeat.o(237870);
        return;
      }
      this.bxk = true;
      this.bCM.clear();
      this.bCM.add(new g.c());
      int j = -1;
      int i = 0;
      boolean bool1 = false;
      int i2 = g.this.gU.ci().size();
      int n = 0;
      Object localObject;
      int k;
      boolean bool2;
      for (;;)
      {
        if (n < i2)
        {
          localObject = (j)g.this.gU.ci().get(n);
          if (((j)localObject).isChecked()) {
            h((j)localObject);
          }
          if (((j)localObject).isCheckable()) {
            ((j)localObject).I(false);
          }
          if (((j)localObject).hasSubMenu())
          {
            SubMenu localSubMenu = ((j)localObject).getSubMenu();
            if (localSubMenu.hasVisibleItems())
            {
              if (n != 0) {
                this.bCM.add(new g.e(g.this.bCK, 0));
              }
              this.bCM.add(new g.f((j)localObject));
              k = 0;
              int i3 = this.bCM.size();
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
                    localj.I(false);
                  }
                  if (((j)localObject).isChecked()) {
                    h((j)localObject);
                  }
                  this.bCM.add(new g.f(localj));
                }
                i1 += 1;
                k = m;
              }
              if (k != 0) {
                bB(i3, this.bCM.size());
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
              j = this.bCM.size();
              if (((j)localObject).getIcon() != null)
              {
                bool2 = true;
                label396:
                bool1 = bool2;
                i = j;
                if (n != 0)
                {
                  i = j + 1;
                  this.bCM.add(new g.e(g.this.bCK, g.this.bCK));
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
        ((g.f)localObject).bCu = bool1;
        this.bCM.add(localObject);
        j = i;
        i = k;
        break;
        bool2 = false;
        break label396;
        if ((!bool1) && (((j)localObject).getIcon() != null))
        {
          bool1 = true;
          bB(i, this.bCM.size());
          continue;
          this.bxk = false;
          AppMethodBeat.o(237870);
          return;
        }
      }
    }
    
    public final Bundle xt()
    {
      AppMethodBeat.i(237877);
      Bundle localBundle = new Bundle();
      if (this.bCN != null) {
        localBundle.putInt("android:menu:checked", this.bCN.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int j = this.bCM.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = (g.d)this.bCM.get(i);
        j localj;
        if ((localObject instanceof g.f))
        {
          localj = ((g.f)localObject).bCQ;
          if (localj == null) {
            break label138;
          }
        }
        label138:
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
      AppMethodBeat.o(237877);
      return localBundle;
    }
  }
  
  static final class c
    implements g.d
  {}
  
  static abstract interface d {}
  
  static final class e
    implements g.d
  {
    final int bCO;
    final int bCP;
    
    public e(int paramInt1, int paramInt2)
    {
      this.bCO = paramInt1;
      this.bCP = paramInt2;
    }
  }
  
  static final class f
    implements g.d
  {
    final j bCQ;
    boolean bCu;
    
    f(j paramj)
    {
      this.bCQ = paramj;
    }
  }
  
  static final class g
    extends g.j
  {
    public g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      AppMethodBeat.i(237933);
      this.amk.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(237933);
    }
  }
  
  static final class h
    extends g.j
  {
    public h(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(237941);
      AppMethodBeat.o(237941);
    }
  }
  
  static final class i
    extends g.j
  {
    public i(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(237948);
      AppMethodBeat.o(237948);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.g
 * JD-Core Version:    0.7.0.1
 */