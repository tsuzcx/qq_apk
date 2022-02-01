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
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private e BMG;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> BMH;
  private long BMI;
  a BMJ;
  private int count;
  private String query;
  private AbsListView.OnScrollListener tOW;
  private HashMap<String, Boolean> zZV = new HashMap();
  
  public d(e parame)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.BMG = parame;
    this.BMH = new SparseArray();
  }
  
  private com.tencent.mm.plugin.fts.a.d.a.a SE(int paramInt)
  {
    Object localObject2 = null;
    if (this.BMH.indexOfKey(paramInt) >= 0) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.BMH.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = SC(paramInt);
      }
    }
    if (localObject1 == null) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.BMH.get(0);
    }
    this.BMH.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt);
  
  protected void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama)
  {
    if ((parama instanceof r)) {
      this.zZV.put(((r)parama).username, Boolean.TRUE);
    }
    do
    {
      int i;
      do
      {
        return;
        if ((parama instanceof q))
        {
          this.zZV.put(((q)parama).username, Boolean.TRUE);
          return;
        }
        if ((parama instanceof m))
        {
          this.zZV.put(((m)parama).username, Boolean.TRUE);
          return;
        }
        if (!(parama instanceof j)) {
          break;
        }
        i = ((j)parama).BPj.field_featureId;
        if (i == 23)
        {
          this.zZV.put("qqmail", Boolean.TRUE);
          return;
        }
        if (i == 27)
        {
          this.zZV.put("masssendapp", Boolean.TRUE);
          return;
        }
        if (i == 28)
        {
          this.zZV.put("newsapp", Boolean.TRUE);
          return;
        }
        if (i == 39)
        {
          this.zZV.put("filehelper", Boolean.TRUE);
          return;
        }
        if (i == 43)
        {
          this.zZV.put("gh_43f2581f6fd6", Boolean.TRUE);
          return;
        }
        if (i == 71)
        {
          this.zZV.put("appbrand_notify_message", Boolean.TRUE);
          return;
        }
        if (i == 69)
        {
          this.zZV.put("appbrandcustomerservicemsg", Boolean.TRUE);
          return;
        }
      } while ((i != 50) && (i != 63) && (i != 67));
      this.zZV.put("officialaccounts", Boolean.TRUE);
      return;
    } while (!(parama instanceof com.tencent.mm.plugin.brandservice.a.d));
    this.zZV.put(((com.tencent.mm.plugin.brandservice.a.d)parama).getUserName(), Boolean.TRUE);
  }
  
  protected abstract boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean);
  
  protected final void aB(int paramInt, boolean paramBoolean)
  {
    if (this.BMJ != null) {
      this.BMJ.aC(paramInt, paramBoolean);
    }
  }
  
  public final void aEi(String paramString)
  {
    erx();
    this.BMI = System.currentTimeMillis();
    this.query = paramString;
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    erv();
  }
  
  protected void clearCache()
  {
    this.BMH.clear();
  }
  
  public final e erB()
  {
    return this.BMG;
  }
  
  protected final long erC()
  {
    return this.BMI;
  }
  
  protected int erb()
  {
    return getCount();
  }
  
  protected abstract void erv();
  
  public void erx()
  {
    this.count = 0;
    this.query = "";
    clearCache();
    notifyDataSetChanged();
  }
  
  public void finish()
  {
    erx();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.zZV.keySet());
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().b((ArrayList)localObject, null, "hidden_conv_parent");
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        az localaz = new az();
        localaz.convertFrom((Cursor)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(21170, new Object[] { Integer.valueOf(1), localaz.field_username, Integer.valueOf(ac.Rl(localaz.field_username)) });
      }
      ((Cursor)localObject).close();
    }
  }
  
  public final Context getContext()
  {
    return this.BMG.getContext();
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
    if (SE(paramInt) != null) {
      return SE(paramInt).viewType;
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
    com.tencent.mm.plugin.fts.a.d.a.a locala = SE(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aEw().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.BJF)
    {
      locala.a(getContext(), paramView, new Object[0]);
      a(getContext(), locala);
      locala.BJF = true;
    }
    locala.aEw().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    this.BMG.hideVKB();
    paramAdapterView = SE(paramInt - this.BMG.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.aEw().a(getContext(), paramView, paramAdapterView));
      this.BMG.a(paramAdapterView, bool);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.tOW != null) {
      this.tOW.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.tOW != null) {
      this.tOW.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    Log.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void aC(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */