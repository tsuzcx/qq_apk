package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.g;
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
  public LayoutInflater Lu;
  int Uu;
  public ExpandedMenuView Vm;
  int Vn;
  int Vo;
  public a Vp;
  public o.a dL;
  h dm;
  Context mContext;
  private int mId;
  
  private f(int paramInt)
  {
    this.Uu = paramInt;
    this.Vo = 0;
  }
  
  public f(Context paramContext, int paramInt)
  {
    this(paramInt);
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(this.mContext);
  }
  
  public final boolean V()
  {
    return false;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    if (this.Vo != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.Vo);
      this.Lu = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.dm = paramh;
      if (this.Vp != null) {
        this.Vp.notifyDataSetChanged();
      }
      return;
      if (this.mContext != null)
      {
        this.mContext = paramContext;
        if (this.Lu == null) {
          this.Lu = LayoutInflater.from(this.mContext);
        }
      }
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    if (this.dL != null) {
      this.dL.a(paramh, paramBoolean);
    }
  }
  
  public final void a(o.a parama)
  {
    this.dL = parama;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.dm;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.VS = new f(((b.a)localObject1).OE.mContext, a.g.abc_list_menu_item_layout);
    locali.VS.dL = locali;
    locali.dm.a(locali.VS);
    Object localObject3 = locali.VS.getAdapter();
    ((b.a)localObject1).OE.NK = ((ListAdapter)localObject3);
    ((b.a)localObject1).OE.Om = locali;
    localObject3 = ((h)localObject2).VH;
    if (localObject3 != null) {
      ((b.a)localObject1).OE.NJ = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).OE.Ok = locali;
      locali.VR = ((b.a)localObject1).ee();
      locali.VR.setOnDismissListener(locali);
      localObject1 = locali.VR.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.VR.show();
      if (this.dL != null) {
        this.dL.d(paramu);
      }
      return true;
      localObject3 = ((h)localObject2).VG;
      ((b.a)localObject1).OE.kc = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).VF;
      ((b.a)localObject1).OE.BM = ((CharSequence)localObject2);
    }
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    if (this.Vp == null) {
      this.Vp = new a();
    }
    return this.Vp;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.Vp != null) {
      this.Vp.notifyDataSetChanged();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.dm.a(this.Vp.bd(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.Vm.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.Vm == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.Vm != null) {
      this.Vm.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  private final class a
    extends BaseAdapter
  {
    private int Vq = -1;
    
    public a()
    {
      fd();
    }
    
    private void fd()
    {
      j localj = f.this.dm.VP;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.dm.fn();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.Vq = i;
            return;
          }
          i += 1;
        }
      }
      this.Vq = -1;
    }
    
    public final j bd(int paramInt)
    {
      ArrayList localArrayList = f.this.dm.fn();
      int i = f.this.Vn + paramInt;
      paramInt = i;
      if (this.Vq >= 0)
      {
        paramInt = i;
        if (i >= this.Vq) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = f.this.dm.fn().size() - f.this.Vn;
      if (this.Vq < 0) {
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
        paramView = f.this.Lu.inflate(f.this.Uu, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(bd(paramInt));
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      fd();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.f
 * JD-Core Version:    0.7.0.1
 */