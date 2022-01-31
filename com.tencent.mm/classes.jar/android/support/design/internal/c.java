package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;

public final class c
  implements o
{
  public ColorStateList eG;
  public NavigationMenuView eL;
  public LinearLayout eM;
  private o.a eN;
  public c.b eO;
  int eP;
  boolean eQ;
  public ColorStateList eR;
  public Drawable eS;
  public int eT;
  int eU;
  h eq;
  public int mId;
  public LayoutInflater mLayoutInflater;
  final View.OnClickListener mOnClickListener = new c.1(this);
  
  public final void a(Context paramContext, h paramh)
  {
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.eq = paramh;
    this.eU = paramContext.getResources().getDimensionPixelOffset(2131428299);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (this.eN != null) {
      this.eN.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.eN = parama;
  }
  
  public final boolean a(u paramu)
  {
    return false;
  }
  
  public final boolean aG()
  {
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void n(boolean paramBoolean)
  {
    if (this.eO != null)
    {
      c.b localb = this.eO;
      localb.aH();
      localb.ajb.notifyChanged();
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.eO != null) {
      this.eO.et = paramBoolean;
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject1 != null) {
        this.eL.restoreHierarchyState((SparseArray)localObject1);
      }
      Object localObject2 = paramParcelable.getBundle("android:menu:adapter");
      if (localObject2 != null)
      {
        localObject1 = this.eO;
        int k = ((Bundle)localObject2).getInt("android:menu:checked", 0);
        int m;
        int i;
        if (k != 0)
        {
          ((c.b)localObject1).et = true;
          m = ((c.b)localObject1).mItems.size();
          i = 0;
        }
        for (;;)
        {
          Object localObject3;
          if (i < m)
          {
            localObject3 = (c.d)((c.b)localObject1).mItems.get(i);
            if ((localObject3 instanceof c.f))
            {
              localObject3 = ((c.f)localObject3).eX;
              if ((localObject3 != null) && (((j)localObject3).getItemId() == k)) {
                ((c.b)localObject1).d((j)localObject3);
              }
            }
          }
          else
          {
            ((c.b)localObject1).et = false;
            ((c.b)localObject1).aH();
            localObject2 = ((Bundle)localObject2).getSparseParcelableArray("android:menu:action_views");
            if (localObject2 == null) {
              break;
            }
            k = ((c.b)localObject1).mItems.size();
            i = j;
            while (i < k)
            {
              localObject3 = (c.d)((c.b)localObject1).mItems.get(i);
              if ((localObject3 instanceof c.f))
              {
                Object localObject4 = ((c.f)localObject3).eX;
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
        this.eM.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Bundle localBundle = new Bundle();
      SparseArray localSparseArray;
      if (this.eL != null)
      {
        localSparseArray = new SparseArray();
        this.eL.saveHierarchyState(localSparseArray);
        localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
      }
      if (this.eO != null) {
        localBundle.putBundle("android:menu:adapter", this.eO.aI());
      }
      if (this.eM != null)
      {
        localSparseArray = new SparseArray();
        this.eM.saveHierarchyState(localSparseArray);
        localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
      }
      return localBundle;
    }
    return null;
  }
  
  public final void setItemBackground(Drawable paramDrawable)
  {
    this.eS = paramDrawable;
    n(false);
  }
  
  public final void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.eG = paramColorStateList;
    n(false);
  }
  
  public final void setItemTextAppearance(int paramInt)
  {
    this.eP = paramInt;
    this.eQ = true;
    n(false);
  }
  
  public final void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.eR = paramColorStateList;
    n(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.c
 * JD-Core Version:    0.7.0.1
 */