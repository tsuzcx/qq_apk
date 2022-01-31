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
  int Vf = 2130968600;
  ExpandedMenuView Wc;
  int Wd;
  int We = 0;
  a Wf;
  public o.a eN;
  h eq;
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
    if (this.We != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.We);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.eq = paramh;
      if (this.Wf != null) {
        this.Wf.notifyDataSetChanged();
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
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.eq;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.WI = new f(((b.a)localObject1).Os.mContext);
    locali.WI.eN = locali;
    locali.eq.a(locali.WI);
    Object localObject3 = locali.WI.getAdapter();
    ((b.a)localObject1).Os.xw = ((ListAdapter)localObject3);
    ((b.a)localObject1).Os.Oa = locali;
    localObject3 = ((h)localObject2).Ww;
    if (localObject3 != null) {
      ((b.a)localObject1).Os.Ny = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).Os.NY = locali;
      locali.WH = ((b.a)localObject1).eA();
      locali.WH.setOnDismissListener(locali);
      localObject1 = locali.WH.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.WH.show();
      if (this.eN != null) {
        this.eN.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).Wv;
      ((b.a)localObject1).Os.la = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).Wu;
      ((b.a)localObject1).Os.Cv = ((CharSequence)localObject2);
    }
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
  
  public final p e(ViewGroup paramViewGroup)
  {
    if (this.Wc == null)
    {
      this.Wc = ((ExpandedMenuView)this.mInflater.inflate(2130968597, paramViewGroup, false));
      if (this.Wf == null) {
        this.Wf = new a();
      }
      this.Wc.setAdapter(this.Wf);
      this.Wc.setOnItemClickListener(this);
    }
    return this.Wc;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.Wf == null) {
      this.Wf = new a();
    }
    return this.Wf;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void n(boolean paramBoolean)
  {
    if (this.Wf != null) {
      this.Wf.notifyDataSetChanged();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.eq.a(this.Wf.bb(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.Wc.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.Wc == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.Wc != null) {
      this.Wc.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  final class a
    extends BaseAdapter
  {
    private int Wg = -1;
    
    public a()
    {
      fS();
    }
    
    private void fS()
    {
      j localj = f.this.eq.WE;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.eq.ge();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.Wg = i;
            return;
          }
          i += 1;
        }
      }
      this.Wg = -1;
    }
    
    public final j bb(int paramInt)
    {
      ArrayList localArrayList = f.this.eq.ge();
      int i = f.this.Wd + paramInt;
      paramInt = i;
      if (this.Wg >= 0)
      {
        paramInt = i;
        if (i >= this.Wg) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.eq.ge().size() - f.this.Wd;
      if (this.Wg < 0) {
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
        paramView = f.this.mInflater.inflate(f.this.Vf, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bb(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      fS();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */