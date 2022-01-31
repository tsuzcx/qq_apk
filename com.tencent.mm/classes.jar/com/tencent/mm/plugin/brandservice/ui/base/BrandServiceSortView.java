package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, com.tencent.mm.plugin.brandservice.b.c.a, BaseSortView.a
{
  private boolean Zc;
  private String hcm;
  private boolean idi;
  private int idy = 0;
  private int idz = 0;
  private HashMap<String, SpannableString> iem = new HashMap();
  private c ien = new c();
  private int ieo = 251658241;
  private a iep;
  private boolean ieq = false;
  private ListView ier;
  private BrandServiceSortView.a ies;
  private String iet;
  private View ieu;
  private TextView iev;
  private n.d iew = new BrandServiceSortView.3(this);
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setShowFooterView(false);
    refresh();
    paramContext = this.ien;
    if ((this != null) && (!paramContext.ibV.contains(this)))
    {
      y.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.ibV.add(this);
    }
    this.iep = new a(getContext());
    setDataSetObserver(this);
    setOnItemClickListener(new BrandServiceSortView.1(this));
    setOnItemLongClickListener(this);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    if ((!bk.bl(paramString)) && (paramd != null))
    {
      this.iet = paramString;
      paramd = (jt)paramd.data;
      if ((paramd == null) || (paramd.dnp == null))
      {
        y.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        return false;
      }
      Object localObject = paramd.dnp;
      paramd = ((ad)localObject).Bq();
      String str = ((ad)localObject).vn();
      localObject = ((ad)localObject).vo();
      paramString = paramString.toUpperCase();
      if (((!bk.bl(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bk.bl(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bk.bl((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString)))) {
        return true;
      }
    }
    return false;
  }
  
  public final void aH(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    if ((this.iev != null) && (paramList != null)) {
      this.iev.setText(getContext().getString(b.h.brandservice_count, new Object[] { Integer.valueOf(paramList.size()) }));
    }
  }
  
  public final void axs()
  {
    refresh();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.idy = ((int)paramMotionEvent.getRawX());
      this.idz = ((int)paramMotionEvent.getRawY());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public BrandServiceSortView.a getITransferToChildOnTouchListener()
  {
    return this.ies;
  }
  
  public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator()
  {
    return new BrandServiceSortView.2(this);
  }
  
  public ListView getListView()
  {
    this.ier = ((ListView)findViewById(b.d.listview));
    if (this.ieu == null)
    {
      this.ieu = inflate(getContext(), b.e.count_view, null);
      if ((this.ier != null) && (this.ieu != null))
      {
        this.iev = ((TextView)this.ieu.findViewById(b.d.count_tv));
        this.ier.addFooterView(this.ieu, null, false);
      }
    }
    return this.ier;
  }
  
  public View getNoResultView()
  {
    return findViewById(b.d.no_result);
  }
  
  public VerticalScrollBar getScrollBar()
  {
    return (VerticalScrollBar)findViewById(b.d.sidrbar);
  }
  
  public final View inflate()
  {
    return View.inflate(getContext(), b.e.brand_service_sortview, this);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (paramContextMenuInfo == null) {
      y.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
    }
    do
    {
      return;
      y.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramView = (com.tencent.mm.ui.base.sortview.d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
      if ((paramView == null) || (paramView.data == null))
      {
        y.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
        return;
      }
      paramView = ((jt)paramView.data).dnp;
      if (paramView == null)
      {
        y.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
        return;
      }
      this.hcm = paramView.field_username;
      String str = paramView.Bq();
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), str));
      paramView = com.tencent.mm.ai.f.kX(paramView.field_username);
    } while ((paramView == null) || (paramView.Lx()));
    paramContextMenu.add(paramContextMenuInfo.position, 0, 0, b.h.main_conversation_longclick_delete_biz_service);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ies != null) {
      this.ies.axC();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.iep.wof = paramView;
    this.iep.a(paramAdapterView, paramInt, paramLong, this, this.iew, this.idy, this.idz);
    return true;
  }
  
  public final void refresh()
  {
    this.ien.init();
    Object localObject = this.ien;
    ArrayList localArrayList;
    int i;
    label59:
    com.tencent.mm.ui.base.sortview.d locald;
    int j;
    switch (this.ieo)
    {
    default: 
      localObject = ((c)localObject).ibY;
      if (localObject == null) {
        break label227;
      }
      localArrayList = new ArrayList();
      i = 0;
      if (i >= ((List)localObject).size()) {
        break label212;
      }
      jt localjt = (jt)((List)localObject).get(i);
      if ((localjt != null) && (localjt.dnp != null))
      {
        locald = new com.tencent.mm.ui.base.sortview.d();
        locald.data = localjt;
        int k = localjt.dnp.field_showHead;
        j = k;
        if (k >= 97)
        {
          j = k;
          if (k <= 122) {
            j = k - 32;
          }
        }
        if ((j < 65) || (j > 90)) {
          break label201;
        }
      }
      break;
    }
    label201:
    for (locald.vem = ((char)j);; locald.vem = "#")
    {
      localArrayList.add(locald);
      i += 1;
      break label59;
      localObject = ((c)localObject).ibX;
      break;
    }
    label212:
    label227:
    for (localObject = localArrayList;; localObject = null)
    {
      dM((List)localObject);
      super.refresh();
      return;
    }
  }
  
  public final void release()
  {
    if (g.DK()) {
      z.MI().Ms();
    }
    Object localObject1 = this.ien;
    if (this == null)
    {
      y.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
      ((c)localObject1).ibV.remove(null);
    }
    Object localObject2 = this.ien;
    g.Dk().b(387, (com.tencent.mm.ah.f)localObject2);
    if (((c)localObject2).ibW)
    {
      localObject1 = new ArrayList(((c)localObject2).ibX.size() + ((c)localObject2).ibY.size());
      Iterator localIterator = ((c)localObject2).ibX.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject1).add((jt)localIterator.next());
      }
      localObject2 = ((c)localObject2).ibY.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((jt)((Iterator)localObject2).next());
      }
      g.Dk().a(new com.tencent.mm.plugin.brandservice.b.j((List)localObject1), 0);
    }
  }
  
  public void setITransferToChildOnTouchListener(BrandServiceSortView.a parama)
  {
    this.ies = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.idi = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    this.Zc = paramBoolean;
    q(this.iev, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */