package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotView
  extends LinearLayout
  implements m.b
{
  private int hrb = 0;
  private TextView hrg;
  public e ihs = new e();
  private BizTimeLineHotListView ihw;
  private boolean ihx = false;
  private List<b> ihy = new ArrayList();
  public com.tencent.mm.sdk.b.c ihz = new BizTimeLineHotView.2(this);
  private Context mContext;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void a(bxp parambxp)
  {
    if (parambxp != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.cP(parambxp.tNI * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.cQ(parambxp.tNG);
    }
    if ((parambxp == null) || (bk.dk(parambxp.tNF)))
    {
      if (bk.dk(this.ihy)) {
        setVisibility(8);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      return;
    }
    if (com.tencent.mm.plugin.brandservice.ui.b.a.oF(4))
    {
      setVisibility(8);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(parambxp.tNF.size()), Integer.valueOf(parambxp.tNH), Integer.valueOf(parambxp.tNG) });
    g.DS().O(new BizTimeLineHotView.5(this, parambxp));
  }
  
  public static boolean a(b paramb)
  {
    Object localObject1 = z.ME().aaJ(paramb.sxi);
    if (localObject1 == null) {
      return false;
    }
    paramb.hFF = ((q)localObject1).field_createTime;
    localObject1 = ((j)g.r(j.class)).FB().abv(paramb.sxi);
    boolean bool = paramb.ihG;
    paramb.ihG = false;
    Object localObject2;
    if ((localObject1 != null) && (((as)localObject1).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.hFF < com.tencent.mm.plugin.brandservice.ui.b.a.ayC()))
    {
      localObject2 = z.MF();
      String str = paramb.sxi;
      str = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talker = '" + str + "' ";
      localObject2 = ((t)localObject2).dXo.a(str, null, 0);
      if (!((Cursor)localObject2).moveToFirst()) {
        break label182;
      }
    }
    label182:
    for (int i = ((Cursor)localObject2).getInt(0);; i = 0)
    {
      ((Cursor)localObject2).close();
      if (((as)localObject1).field_unReadCount > i) {
        paramb.ihG = true;
      }
      if (bool == paramb.ihG) {
        break;
      }
      return true;
    }
  }
  
  private void getLocalOftenReadData()
  {
    if (!bk.dk(this.ihy)) {
      return;
    }
    a(d.ayg());
  }
  
  private void getOftenRead()
  {
    g.DS().O(new BizTimeLineHotView.3(this));
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    a.init(this.mContext);
    this.hrb = getItemPadding();
    paramContext = com.tencent.mm.ui.y.gt(this.mContext).inflate(b.e.biz_time_line_hot_view, this);
    this.ihw = ((BizTimeLineHotListView)paramContext.findViewById(b.d.biz_time_line_hot_list_view));
    this.hrg = ((TextView)paramContext.findViewById(b.d.biz_time_line_hot_view_title));
    this.ihw.a(new c(this.hrb));
    paramContext = this.ihw;
    Context localContext = this.mContext;
    Object localObject = this.ihy;
    paramContext.ihs = this.ihs;
    paramContext.hfb.addAll((Collection)localObject);
    paramContext.aE(paramContext.hfb);
    paramContext.ihr = new BizTimeLineHotListView.a(paramContext, localContext);
    localObject = paramContext.mContext;
    localObject = new BizTimeLineHotListView.2(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(0);
    paramContext.setLayoutManager((RecyclerView.i)localObject);
    paramContext.setAdapter(paramContext.ihr);
    paramContext.ihq = new f(paramContext.getCustomItemCount());
    localObject = paramContext.ihq;
    int i = a.getCompletelyCountPerPage();
    ((f)localObject).mContext = localContext;
    ((f)localObject).ihL = paramContext;
    ((f)localObject).hDt = i;
    ((f)localObject).ihL.b((RecyclerView.m)localObject);
    ((f)localObject).ihL.a((RecyclerView.m)localObject);
    ((f)localObject).hDw = ((LinearLayoutManager)((f)localObject).ihL.getLayoutManager());
    ((f)localObject).agY = new f.1((f)localObject, ((f)localObject).ihL.getContext());
    ((f)localObject).hDs = new f.2((f)localObject, ((f)localObject).ihL.getContext());
    paramContext.setOnScrollPageListener(new BizTimeLineHotListView.4(paramContext));
    paramContext.setOnItemClickListener(new BizTimeLineHotListView.3(paramContext));
    getLocalOftenReadData();
    getOftenRead();
    ((j)g.r(j.class)).FB().a(this);
    com.tencent.mm.sdk.b.a.udP.c(this.ihz);
  }
  
  private void xT(String paramString)
  {
    g.DS().O(new BizTimeLineHotView.1(this, paramString));
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    xT((String)paramObject);
  }
  
  public final void aye()
  {
    if ((getVisibility() != 0) || (bk.dk(this.ihy))) {
      return;
    }
    this.ihw.aye();
  }
  
  public final void ayf()
  {
    if (bk.dk(this.ihy)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.ihy.iterator();
      while (localIterator.hasNext()) {
        a((b)localIterator.next());
      }
    }
  }
  
  public final void d(q paramq)
  {
    if (paramq != null)
    {
      q localq = z.ME().aaJ(paramq.field_talker);
      if ((localq != null) && (localq.field_msgId == paramq.field_msgId))
      {
        ((j)g.r(j.class)).FB().abx(paramq.field_talker);
        xT(paramq.field_talker);
      }
    }
  }
  
  public int getItemPadding()
  {
    return a.cQ(getContext());
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    if (this.hrg != null) {
      this.hrg.setPadding(paramInt, this.hrg.getPaddingTop(), this.hrg.getPaddingRight(), this.hrg.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */