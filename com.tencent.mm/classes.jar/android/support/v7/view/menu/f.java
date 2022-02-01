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
  h aaD;
  public o.a aeT;
  int aeV = 2131492907;
  ExpandedMenuView afT;
  int afU;
  int afV = 0;
  a afW;
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
    if (this.afV != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.afV);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.aaD = paramh;
      if (this.afW != null) {
        this.afW.notifyDataSetChanged();
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
    if (this.aeT != null) {
      this.aeT.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.aeT = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.aaD;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.agz = new f(((b.a)localObject1).Yh.mContext);
    locali.agz.aeT = locali;
    locali.aaD.a(locali.agz);
    Object localObject3 = locali.agz.getAdapter();
    ((b.a)localObject1).Yh.GE = ((ListAdapter)localObject3);
    ((b.a)localObject1).Yh.XP = locali;
    localObject3 = ((h)localObject2).agn;
    if (localObject3 != null) {
      ((b.a)localObject1).Yh.Xn = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).Yh.XN = locali;
      locali.agy = ((b.a)localObject1).gs();
      locali.agy.setOnDismissListener(locali);
      localObject1 = locali.agy.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.agy.show();
      if (this.aeT != null) {
        this.aeT.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).agm;
      ((b.a)localObject1).Yh.Xj = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).agl;
      ((b.a)localObject1).Yh.Hd = ((CharSequence)localObject2);
    }
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean bD()
  {
    return false;
  }
  
  public final p c(ViewGroup paramViewGroup)
  {
    if (this.afT == null)
    {
      this.afT = ((ExpandedMenuView)this.mInflater.inflate(2131492904, paramViewGroup, false));
      if (this.afW == null) {
        this.afW = new a();
      }
      this.afT.setAdapter(this.afW);
      this.afT.setOnItemClickListener(this);
    }
    return this.afT;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.afW == null) {
      this.afW = new a();
    }
    return this.afW;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.aaD.a(this.afW.bu(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.afT.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.afT == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.afT != null) {
      this.afT.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final void p(boolean paramBoolean)
  {
    if (this.afW != null) {
      this.afW.notifyDataSetChanged();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private int afX = -1;
    
    public a()
    {
      hM();
    }
    
    private void hM()
    {
      j localj = f.this.aaD.agv;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.aaD.hX();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.afX = i;
            return;
          }
          i += 1;
        }
      }
      this.afX = -1;
    }
    
    public final j bu(int paramInt)
    {
      ArrayList localArrayList = f.this.aaD.hX();
      int i = f.this.afU + paramInt;
      paramInt = i;
      if (this.afX >= 0)
      {
        paramInt = i;
        if (i >= this.afX) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.aaD.hX().size() - f.this.afU;
      if (this.afX < 0) {
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
        paramView = f.this.mInflater.inflate(f.this.aeV, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bu(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      hM();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */