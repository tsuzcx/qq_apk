package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.j;
import com.tencent.mm.plugin.fts.ui.b.m;
import com.tencent.mm.plugin.fts.ui.b.t;
import com.tencent.mm.plugin.fts.ui.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private HashMap<String, Boolean> FvE = new HashMap();
  private e HxC;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> HxD;
  private long HxE;
  a HxF;
  private int count;
  private String query;
  private AbsListView.OnScrollListener wSm;
  
  public d(e parame)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.HxC = parame;
    this.HxD = new SparseArray();
  }
  
  private com.tencent.mm.plugin.fts.a.d.a.a Wl(int paramInt)
  {
    Object localObject2 = null;
    if (this.HxD.indexOfKey(paramInt) >= 0) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.HxD.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = Wj(paramInt);
      }
    }
    if (localObject1 == null) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.HxD.get(0);
    }
    this.HxD.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt);
  
  protected void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    if ((parama instanceof u)) {
      this.FvE.put(((u)parama).username, Boolean.TRUE);
    }
    do
    {
      int i;
      do
      {
        return;
        if ((parama instanceof t))
        {
          this.FvE.put(((t)parama).username, Boolean.TRUE);
          return;
        }
        if ((parama instanceof m))
        {
          this.FvE.put(((m)parama).username, Boolean.TRUE);
          return;
        }
        if (!(parama instanceof j)) {
          break;
        }
        i = ((j)parama).HAY.field_featureId;
        if (i == 23)
        {
          this.FvE.put("qqmail", Boolean.TRUE);
          return;
        }
        if (i == 27)
        {
          this.FvE.put("masssendapp", Boolean.TRUE);
          return;
        }
        if (i == 28)
        {
          this.FvE.put("newsapp", Boolean.TRUE);
          return;
        }
        if (i == 39)
        {
          this.FvE.put("filehelper", Boolean.TRUE);
          return;
        }
        if (i == 43)
        {
          this.FvE.put("gh_43f2581f6fd6", Boolean.TRUE);
          return;
        }
        if (i == 71)
        {
          this.FvE.put("appbrand_notify_message", Boolean.TRUE);
          return;
        }
        if (i == 69)
        {
          this.FvE.put("appbrandcustomerservicemsg", Boolean.TRUE);
          return;
        }
        if ((i == 50) || (i == 63) || (i == 67))
        {
          this.FvE.put("officialaccounts", Boolean.TRUE);
          return;
        }
      } while (i != 74);
      this.FvE.put("opencustomerservicemsg", Boolean.TRUE);
      return;
    } while (!(parama instanceof com.tencent.mm.plugin.brandservice.api.d));
    this.FvE.put(((com.tencent.mm.plugin.brandservice.api.d)parama).getUserName(), Boolean.TRUE);
  }
  
  protected abstract boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean);
  
  protected final void aZ(int paramInt, boolean paramBoolean)
  {
    if (this.HxF != null) {
      this.HxF.ba(paramInt, paramBoolean);
    }
  }
  
  public final void awg(String paramString)
  {
    eui();
    this.HxE = System.currentTimeMillis();
    this.query = paramString;
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    fyd();
  }
  
  protected void clearCache()
  {
    this.HxD.clear();
  }
  
  public void eui()
  {
    this.count = 0;
    this.query = "";
    clearCache();
    notifyDataSetChanged();
  }
  
  public void finish()
  {
    eui();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.FvE.keySet());
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().b((ArrayList)localObject, null, "hidden_conv_parent");
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        bb localbb = new bb();
        localbb.convertFrom((Cursor)localObject);
        com.tencent.mm.plugin.report.service.h.OAn.b(21170, new Object[] { Integer.valueOf(1), localbb.field_username, Integer.valueOf(ac.Jj(localbb.field_username)) });
      }
      ((Cursor)localObject).close();
    }
  }
  
  protected int fxI()
  {
    return getCount();
  }
  
  protected abstract void fyd();
  
  public final e fyi()
  {
    return this.HxC;
  }
  
  protected final long fyj()
  {
    return this.HxE;
  }
  
  public final Context getContext()
  {
    return this.HxC.getContext();
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (Wl(paramInt) != null) {
      return Wl(paramInt).viewType;
    }
    Log.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = Wl(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aXA().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.Huo)
    {
      locala.a(getContext(), paramView, new Object[0]);
      a(getContext(), locala);
      locala.Huo = true;
    }
    locala.aXA().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 18;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    this.HxC.hideVKB();
    paramAdapterView = Wl(paramInt - this.HxC.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.aXA().a(getContext(), paramView, paramAdapterView));
      this.HxC.a(paramAdapterView, bool);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.wSm != null) {
      this.wSm.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.wSm != null) {
      this.wSm.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void ba(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */