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
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener qqo;
  String query;
  private HashMap<String, Boolean> vtH = new HashMap();
  e xaG;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> xaH;
  long xaI;
  a xaJ;
  
  public d(e parame)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.xaG = parame;
    this.xaH = new SparseArray();
  }
  
  private com.tencent.mm.plugin.fts.a.d.a.a Nq(int paramInt)
  {
    Object localObject2 = null;
    if (this.xaH.indexOfKey(paramInt) >= 0) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.xaH.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = No(paramInt);
      }
    }
    if (localObject1 == null) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.xaH.get(0);
    }
    this.xaH.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt);
  
  protected void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    if ((parama instanceof r)) {
      this.vtH.put(((r)parama).username, Boolean.TRUE);
    }
    do
    {
      int i;
      do
      {
        return;
        if ((parama instanceof q))
        {
          this.vtH.put(((q)parama).username, Boolean.TRUE);
          return;
        }
        if ((parama instanceof m))
        {
          this.vtH.put(((m)parama).username, Boolean.TRUE);
          return;
        }
        if (!(parama instanceof j)) {
          break;
        }
        i = ((j)parama).xdl.field_featureId;
        if (i == 23)
        {
          this.vtH.put("qqmail", Boolean.TRUE);
          return;
        }
        if (i == 27)
        {
          this.vtH.put("masssendapp", Boolean.TRUE);
          return;
        }
        if (i == 28)
        {
          this.vtH.put("newsapp", Boolean.TRUE);
          return;
        }
        if (i == 39)
        {
          this.vtH.put("filehelper", Boolean.TRUE);
          return;
        }
        if (i == 43)
        {
          this.vtH.put("gh_43f2581f6fd6", Boolean.TRUE);
          return;
        }
        if (i == 71)
        {
          this.vtH.put("appbrand_notify_message", Boolean.TRUE);
          return;
        }
        if (i == 69)
        {
          this.vtH.put("appbrandcustomerservicemsg", Boolean.TRUE);
          return;
        }
      } while ((i != 50) && (i != 63) && (i != 67));
      this.vtH.put("officialaccounts", Boolean.TRUE);
      return;
    } while (!(parama instanceof c));
    this.vtH.put(((c)parama).getUserName(), Boolean.TRUE);
  }
  
  protected abstract boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean);
  
  public final void auV(String paramString)
  {
    stopSearch();
    this.xaI = System.currentTimeMillis();
    this.query = paramString;
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    dPb();
  }
  
  protected final void ax(int paramInt, boolean paramBoolean)
  {
    if (this.xaJ != null) {
      this.xaJ.ay(paramInt, paramBoolean);
    }
  }
  
  protected void clearCache()
  {
    this.xaH.clear();
  }
  
  protected int dOI()
  {
    return getCount();
  }
  
  protected abstract void dPb();
  
  public final e dPg()
  {
    return this.xaG;
  }
  
  public void finish()
  {
    stopSearch();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.vtH.keySet());
    localObject = ((l)g.af(l.class)).aST().a((ArrayList)localObject, ab.iCF, null, "hidden_conv_parent");
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        az localaz = new az();
        localaz.convertFrom((Cursor)localObject);
        h.CyF.a(21170, new Object[] { Integer.valueOf(1), localaz.field_username, Integer.valueOf(ac.JT(localaz.field_username)) });
      }
      ((Cursor)localObject).close();
    }
  }
  
  public final Context getContext()
  {
    return this.xaG.getContext();
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
    if (Nq(paramInt) != null) {
      return Nq(paramInt).qcr;
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
    com.tencent.mm.plugin.fts.a.d.a.a locala = Nq(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.axc().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.wXJ)
    {
      locala.a(getContext(), paramView, new Object[0]);
      a(getContext(), locala);
      locala.wXJ = true;
    }
    locala.axc().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    this.xaG.hideVKB();
    paramAdapterView = Nq(paramInt - this.xaG.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.axc().a(getContext(), paramView, paramAdapterView));
      this.xaG.a(paramAdapterView, bool);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.qqo != null) {
      this.qqo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.qqo != null) {
      this.qqo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public void stopSearch()
  {
    this.count = 0;
    this.query = "";
    clearCache();
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void ay(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */