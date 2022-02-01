package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertController.a;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public final class f
  implements o, AdapterView.OnItemClickListener
{
  h XT;
  public o.a aci;
  int ack = 2131492907;
  ExpandedMenuView adi;
  int adj;
  int adk = 0;
  a adl;
  Context mContext;
  private int mId;
  LayoutInflater mInflater;
  
  private f() {}
  
  public f(Context paramContext)
  {
    this();
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public final void a(Context paramContext, h paramh)
  {
    if (this.adk != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.adk);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.XT = paramh;
      if (this.adl != null) {
        this.adl.notifyDataSetChanged();
      }
      return;
      if (this.mContext != null)
      {
        this.mContext = paramContext;
        if (this.mInflater == null) {
          this.mInflater = LayoutInflater.from(this.mContext);
        }
      }
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (this.aci != null) {
      this.aci.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.aci = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.XT;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.adO = new f(((b.a)localObject1).Vx.mContext);
    locali.adO.aci = locali;
    locali.XT.a(locali.adO);
    Object localObject3 = locali.adO.getAdapter();
    ((b.a)localObject1).Vx.DP = ((ListAdapter)localObject3);
    ((b.a)localObject1).Vx.Vf = locali;
    localObject3 = ((h)localObject2).adC;
    if (localObject3 != null) {
      ((b.a)localObject1).Vx.UC = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).Vx.Vd = locali;
      locali.adN = ((b.a)localObject1).fS();
      locali.adN.setOnDismissListener(locali);
      localObject1 = locali.adN.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.adN.show();
      if (this.aci != null) {
        this.aci.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).adB;
      ((b.a)localObject1).Vx.Uy = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).adA;
      ((b.a)localObject1).Vx.Eo = ((CharSequence)localObject2);
    }
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean bh()
  {
    return false;
  }
  
  public final p c(ViewGroup paramViewGroup)
  {
    if (this.adi == null)
    {
      this.adi = ((ExpandedMenuView)this.mInflater.inflate(2131492904, paramViewGroup, false));
      if (this.adl == null) {
        this.adl = new a();
      }
      this.adi.setAdapter(this.adl);
      this.adi.setOnItemClickListener(this);
    }
    return this.adi;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.adl == null) {
      this.adl = new a();
    }
    return this.adl;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.XT.a(this.adl.bu(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.adi.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.adi == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.adi != null) {
      this.adi.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.adl != null) {
      this.adl.notifyDataSetChanged();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private int adm = -1;
    
    public a()
    {
      ho();
    }
    
    private void ho()
    {
      j localj = f.this.XT.adK;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.XT.hz();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.adm = i;
            return;
          }
          i += 1;
        }
      }
      this.adm = -1;
    }
    
    public final j bu(int paramInt)
    {
      ArrayList localArrayList = f.this.XT.hz();
      int i = f.this.adj + paramInt;
      paramInt = i;
      if (this.adm >= 0)
      {
        paramInt = i;
        if (i >= this.adm) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.XT.hz().size() - f.this.adj;
      if (this.adm < 0) {
        return i;
      }
      return i - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = f.this.mInflater.inflate(f.this.ack, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bu(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      ho();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */