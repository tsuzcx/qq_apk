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
  h aaQ;
  public o.a afg;
  int afi = 2131492924;
  ExpandedMenuView agg;
  int agh;
  int agi = 0;
  a agj;
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
    if (this.agi != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.agi);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.aaQ = paramh;
      if (this.agj != null) {
        this.agj.notifyDataSetChanged();
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
    if (this.afg != null) {
      this.afg.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.afg = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.aaQ;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.agM = new f(((b.a)localObject1).Yu.mContext);
    locali.agM.afg = locali;
    locali.aaQ.a(locali.agM);
    Object localObject3 = locali.agM.getAdapter();
    ((b.a)localObject1).Yu.GO = ((ListAdapter)localObject3);
    ((b.a)localObject1).Yu.Yc = locali;
    localObject3 = ((h)localObject2).agA;
    if (localObject3 != null) {
      ((b.a)localObject1).Yu.XA = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).Yu.Ya = locali;
      locali.agL = ((b.a)localObject1).gz();
      locali.agL.setOnDismissListener(locali);
      localObject1 = locali.agL.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.agL.show();
      if (this.afg != null) {
        this.afg.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).agz;
      ((b.a)localObject1).Yu.Xw = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).agy;
      ((b.a)localObject1).Yu.Hn = ((CharSequence)localObject2);
    }
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean bF()
  {
    return false;
  }
  
  public final p c(ViewGroup paramViewGroup)
  {
    if (this.agg == null)
    {
      this.agg = ((ExpandedMenuView)this.mInflater.inflate(2131492921, paramViewGroup, false));
      if (this.agj == null) {
        this.agj = new a();
      }
      this.agg.setAdapter(this.agj);
      this.agg.setOnItemClickListener(this);
    }
    return this.agg;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.agj == null) {
      this.agj = new a();
    }
    return this.agj;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.aaQ.a(this.agj.bv(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.agg.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.agg == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.agg != null) {
      this.agg.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.agj != null) {
      this.agj.notifyDataSetChanged();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private int agk = -1;
    
    public a()
    {
      hV();
    }
    
    private void hV()
    {
      j localj = f.this.aaQ.agI;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.aaQ.ih();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.agk = i;
            return;
          }
          i += 1;
        }
      }
      this.agk = -1;
    }
    
    public final j bv(int paramInt)
    {
      ArrayList localArrayList = f.this.aaQ.ih();
      int i = f.this.agh + paramInt;
      paramInt = i;
      if (this.agk >= 0)
      {
        paramInt = i;
        if (i >= this.agk) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.aaQ.ih().size() - f.this.agh;
      if (this.agk < 0) {
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
        paramView = f.this.mInflater.inflate(f.this.afi, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bv(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      hV();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */