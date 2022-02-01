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
  h jo;
  Context mContext;
  private int mId;
  LayoutInflater mInflater;
  public o.a ml;
  int mn;
  ExpandedMenuView np;
  int nq;
  int nr;
  a ns;
  
  private f(int paramInt)
  {
    this.mn = paramInt;
    this.nr = 0;
  }
  
  public f(Context paramContext, int paramInt)
  {
    this(paramInt);
    AppMethodBeat.i(200930);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(200930);
  }
  
  public final void J(boolean paramBoolean)
  {
    AppMethodBeat.i(201005);
    if (this.ns != null) {
      this.ns.notifyDataSetChanged();
    }
    AppMethodBeat.o(201005);
  }
  
  public final p a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200979);
    if (this.np == null)
    {
      this.np = ((ExpandedMenuView)this.mInflater.inflate(a.g.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.ns == null) {
        this.ns = new a();
      }
      this.np.setAdapter(this.ns);
      this.np.setOnItemClickListener(this);
    }
    paramViewGroup = this.np;
    AppMethodBeat.o(200979);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    AppMethodBeat.i(200962);
    if (this.nr != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, this.nr);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    for (;;)
    {
      this.jo = paramh;
      if (this.ns != null) {
        this.ns.notifyDataSetChanged();
      }
      AppMethodBeat.o(200962);
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
    AppMethodBeat.i(201050);
    if (this.ml != null) {
      this.ml.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(201050);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(201041);
    if (!paramu.hasVisibleItems())
    {
      AppMethodBeat.o(201041);
      return false;
    }
    i locali = new i(paramu);
    Object localObject2 = locali.jo;
    Object localObject1 = new b.a(((h)localObject2).mContext);
    locali.nV = new f(((b.a)localObject1).gK.mContext, a.g.abc_list_menu_item_layout);
    locali.nV.ml = locali;
    locali.jo.a(locali.nV);
    Object localObject3 = locali.nV.getAdapter();
    ((b.a)localObject1).gK.fR = ((ListAdapter)localObject3);
    ((b.a)localObject1).gK.gr = locali;
    localObject3 = ((h)localObject2).nJ;
    if (localObject3 != null) {
      ((b.a)localObject1).gK.fQ = ((View)localObject3);
    }
    for (;;)
    {
      ((b.a)localObject1).gK.gp = locali;
      locali.nU = ((b.a)localObject1).bA();
      locali.nU.setOnDismissListener(locali);
      localObject1 = locali.nU.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).type = 1003;
      ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
      locali.nU.show();
      if (this.ml != null) {
        this.ml.c(paramu);
      }
      AppMethodBeat.o(201041);
      return true;
      localObject3 = ((h)localObject2).nI;
      ((b.a)localObject1).gK.fM = ((Drawable)localObject3);
      localObject2 = ((h)localObject2).nH;
      ((b.a)localObject1).gK.cZ = ((CharSequence)localObject2);
    }
  }
  
  public final void b(o.a parama)
  {
    this.ml = parama;
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
  
  public final ListAdapter getAdapter()
  {
    AppMethodBeat.i(200992);
    if (this.ns == null) {
      this.ns = new a();
    }
    a locala = this.ns;
    AppMethodBeat.o(200992);
    return locala;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(201063);
    this.jo.a(this.ns.ag(paramInt), this, 0);
    AppMethodBeat.o(201063);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(201126);
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      this.np.restoreHierarchyState(paramParcelable);
    }
    AppMethodBeat.o(201126);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(201113);
    if (this.np == null)
    {
      AppMethodBeat.o(201113);
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (this.np != null) {
      this.np.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    AppMethodBeat.o(201113);
    return localBundle;
  }
  
  final class a
    extends BaseAdapter
  {
    private int nt;
    
    public a()
    {
      AppMethodBeat.i(201046);
      this.nt = -1;
      cS();
      AppMethodBeat.o(201046);
    }
    
    private void cS()
    {
      AppMethodBeat.i(201056);
      j localj = f.this.jo.nR;
      if (localj != null)
      {
        ArrayList localArrayList = f.this.jo.dd();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.nt = i;
            AppMethodBeat.o(201056);
            return;
          }
          i += 1;
        }
      }
      this.nt = -1;
      AppMethodBeat.o(201056);
    }
    
    public final j ag(int paramInt)
    {
      AppMethodBeat.i(201071);
      Object localObject = f.this.jo.dd();
      int i = f.this.nq + paramInt;
      paramInt = i;
      if (this.nt >= 0)
      {
        paramInt = i;
        if (i >= this.nt) {
          paramInt = i + 1;
        }
      }
      localObject = (j)((ArrayList)localObject).get(paramInt);
      AppMethodBeat.o(201071);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(201066);
      int i = f.this.jo.dd().size() - f.this.nq;
      if (this.nt < 0)
      {
        AppMethodBeat.o(201066);
        return i;
      }
      AppMethodBeat.o(201066);
      return i - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(201081);
      if (paramView == null) {
        paramView = f.this.mInflater.inflate(f.this.mn, paramViewGroup, false);
      }
      for (;;)
      {
        ((p.a)paramView).a(ag(paramInt));
        AppMethodBeat.o(201081);
        return paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(201088);
      cS();
      super.notifyDataSetChanged();
      AppMethodBeat.o(201088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.f
 * JD-Core Version:    0.7.0.1
 */