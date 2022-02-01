package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.appcompat.a.g;
import androidx.appcompat.app.AlertController.a;
import androidx.appcompat.app.b;
import androidx.appcompat.app.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class f
  implements AdapterView.OnItemClickListener, o
{
  h is;
  public o.a lp;
  int lr;
  Context mContext;
  private int mId;
  LayoutInflater mInflater;
  ExpandedMenuView mq;
  int mr;
  int ms;
  a mt;
  
  private f(int paramInt)
  {
    this.lr = paramInt;
    this.ms = 0;
  }
  
  public f(Context paramContext, int paramInt)
  {
    this(paramInt);
    AppMethodBeat.i(239286);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(239286);
  }
  
  public final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(239295);
    if (this.mt != null) {
      this.mt.notifyDataSetChanged();
    }
    AppMethodBeat.o(239295);
  }
  
  public final p a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(239291);
    if (this.mq == null)
    {
      this.mq = ((ExpandedMenuView)this.mInflater.inflate(a.g.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.mt == null) {
        this.mt = new a();
      }
      this.mq.setAdapter(this.mt);
      this.mq.setOnItemClickListener(this);
    }
    paramViewGroup = this.mq;
    AppMethodBeat.o(239291);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    AppMethodBeat.i(239289);
    if (this.ms != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.ms);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.is = paramh;
      if (this.mt != null) {
        this.mt.notifyDataSetChanged();
      }
      AppMethodBeat.o(239289);
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
    AppMethodBeat.i(239299);
    if (this.lp != null) {
      this.lp.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(239299);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(239298);
    if (!paramu.hasVisibleItems())
    {
      AppMethodBeat.o(239298);
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.is;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.mZ = new f(((b.a)localObject1).fP.mContext, a.g.abc_list_menu_item_layout);
    locali.mZ.lp = locali;
    locali.is.a(locali.mZ);
    Object localObject3 = locali.mZ.getAdapter();
    ((b.a)localObject1).fP.eP = ((ListAdapter)localObject3);
    ((b.a)localObject1).fP.fw = locali;
    localObject3 = ((h)localObject2).mL;
    if (localObject3 != null) {
      ((b.a)localObject1).fP.eO = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).fP.fu = locali;
      locali.mW = ((b.a)localObject1).aH();
      locali.mW.setOnDismissListener(locali);
      localObject1 = locali.mW.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.mW.show();
      if (this.lp != null) {
        this.lp.c(paramu);
      }
      AppMethodBeat.o(239298);
      return true;
      localObject3 = ((h)localObject2).mK;
      ((b.a)localObject1).fP.eK = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).mJ;
      ((b.a)localObject1).fP.cZ = ((CharSequence)localObject2);
    }
  }
  
  public final void b(o.a parama)
  {
    this.lp = parama;
  }
  
  public final boolean bS()
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean d(j paramj)
  {
    return false;
  }
  
  public final ListAdapter getAdapter()
  {
    AppMethodBeat.i(239293);
    if (this.mt == null) {
      this.mt = new a();
    }
    a locala = this.mt;
    AppMethodBeat.o(239293);
    return locala;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(239301);
    this.is.a(this.mt.ai(paramInt), this, 0);
    AppMethodBeat.o(239301);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(239305);
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.mq.restoreHierarchyState(paramParcelable);
    }
    AppMethodBeat.o(239305);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(239303);
    if (this.mq == null)
    {
      AppMethodBeat.o(239303);
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.mq != null) {
      this.mq.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    AppMethodBeat.o(239303);
    return localBundle;
  }
  
  final class a
    extends BaseAdapter
  {
    private int mu;
    
    public a()
    {
      AppMethodBeat.i(239270);
      this.mu = -1;
      bZ();
      AppMethodBeat.o(239270);
    }
    
    private void bZ()
    {
      AppMethodBeat.i(239279);
      j localj = f.this.is.mT;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.is.ck();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.mu = i;
            AppMethodBeat.o(239279);
            return;
          }
          i += 1;
        }
      }
      this.mu = -1;
      AppMethodBeat.o(239279);
    }
    
    public final j ai(int paramInt)
    {
      AppMethodBeat.i(239275);
      Object localObject = f.this.is.ck();
      int i = f.this.mr + paramInt;
      paramInt = i;
      if (this.mu >= 0)
      {
        paramInt = i;
        if (i >= this.mu) {
          paramInt = i + 1;
        }
      }
      localObject = (j)((ArrayList)localObject).get(paramInt);
      AppMethodBeat.o(239275);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(239272);
      int i = f.this.is.ck().size() - f.this.mr;
      if (this.mu < 0)
      {
        AppMethodBeat.o(239272);
        return i;
      }
      AppMethodBeat.o(239272);
      return i - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(239278);
      if (paramView == null) {
        paramView = f.this.mInflater.inflate(f.this.lr, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(ai(paramInt));
        AppMethodBeat.o(239278);
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(239280);
      bZ();
      super.notifyDataSetChanged();
      AppMethodBeat.o(239280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.f
 * JD-Core Version:    0.7.0.1
 */