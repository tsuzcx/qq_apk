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
  h YO;
  public o.a adc;
  int ade = 2131492907;
  ExpandedMenuView aec;
  int aed;
  int aee = 0;
  a aef;
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
    if (this.aee != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.aee);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.YO = paramh;
      if (this.aef != null) {
        this.aef.notifyDataSetChanged();
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
    if (this.adc != null) {
      this.adc.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.adc = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.YO;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.aeI = new f(((b.a)localObject1).Ws.mContext);
    locali.aeI.adc = locali;
    locali.YO.a(locali.aeI);
    Object localObject3 = locali.aeI.getAdapter();
    ((b.a)localObject1).Ws.EN = ((ListAdapter)localObject3);
    ((b.a)localObject1).Ws.Wa = locali;
    localObject3 = ((h)localObject2).aew;
    if (localObject3 != null) {
      ((b.a)localObject1).Ws.Vy = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).Ws.VY = locali;
      locali.aeH = ((b.a)localObject1).ga();
      locali.aeH.setOnDismissListener(locali);
      localObject1 = locali.aeH.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.aeH.show();
      if (this.adc != null) {
        this.adc.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).aev;
      ((b.a)localObject1).Ws.Vu = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).aeu;
      ((b.a)localObject1).Ws.Fm = ((CharSequence)localObject2);
    }
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean bo()
  {
    return false;
  }
  
  public final p c(ViewGroup paramViewGroup)
  {
    if (this.aec == null)
    {
      this.aec = ((ExpandedMenuView)this.mInflater.inflate(2131492904, paramViewGroup, false));
      if (this.aef == null) {
        this.aef = new a();
      }
      this.aec.setAdapter(this.aef);
      this.aec.setOnItemClickListener(this);
    }
    return this.aec;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.aef == null) {
      this.aef = new a();
    }
    return this.aef;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.YO.a(this.aef.bu(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.aec.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.aec == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.aec != null) {
      this.aec.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.aef != null) {
      this.aef.notifyDataSetChanged();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private int aeg = -1;
    
    public a()
    {
      hw();
    }
    
    private void hw()
    {
      j localj = f.this.YO.aeE;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.YO.hH();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.aeg = i;
            return;
          }
          i += 1;
        }
      }
      this.aeg = -1;
    }
    
    public final j bu(int paramInt)
    {
      ArrayList localArrayList = f.this.YO.hH();
      int i = f.this.aed + paramInt;
      paramInt = i;
      if (this.aeg >= 0)
      {
        paramInt = i;
        if (i >= this.aeg) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.YO.hH().size() - f.this.aed;
      if (this.aeg < 0) {
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
        paramView = f.this.mInflater.inflate(f.this.ade, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bu(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      hw();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */