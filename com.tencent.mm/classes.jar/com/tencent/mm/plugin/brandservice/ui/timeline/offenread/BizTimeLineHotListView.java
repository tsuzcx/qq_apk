package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotListView
  extends MRecyclerView
{
  private float hDb = 0.0F;
  private int hDc = 0;
  List<b> hfb = new ArrayList();
  f ihq;
  BizTimeLineHotListView.a ihr;
  e ihs;
  Context mContext;
  private int mScreenWidth = 0;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    y.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    float f;
    if (paramv != null)
    {
      f = paramv.aie.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2) {
        paramv.aie.setAlpha(0.3F);
      }
    }
    else
    {
      return;
    }
    if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.hDb))
    {
      f = 1.0F - (f - this.hDb) / this.hDc * 0.7F;
      y.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
      paramv.aie.setAlpha(f);
      return;
    }
    paramv.aie.setAlpha(1.0F);
  }
  
  private int getItemPadding()
  {
    return a.cQ(getContext());
  }
  
  public final void aE(List<b> paramList)
  {
    if (this.hfb == null) {
      return;
    }
    b localb = new b((byte)0);
    localb.sxi = "__BizTimeLine.CustomItem__";
    paramList.add(0, localb);
  }
  
  public final boolean ac(int paramInt1, int paramInt2)
  {
    f localf = this.ihq;
    localf.I(localf.nk(localf.mOffsetX + paramInt1), false);
    return super.ac(paramInt1, paramInt2);
  }
  
  protected final boolean atd()
  {
    return false;
  }
  
  public final void aye()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.hfb);
    g.DS().O(new BizTimeLineHotListView.1(this, localArrayList));
  }
  
  public BizTimeLineHotListView.a getAdapter()
  {
    return this.ihr;
  }
  
  public int getCurrentPage()
  {
    if (this.ihq != null) {
      return this.ihq.hxH;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 1;
  }
  
  public int getDataCount()
  {
    return this.hfb.size();
  }
  
  public int getItemWidth()
  {
    return a.cG(this.mContext);
  }
  
  public int getShowCount()
  {
    return 12;
  }
  
  protected float getShowCountPerPage()
  {
    return a.getShowCountPerPage();
  }
  
  public void setOnScrollPageListener(f.a parama)
  {
    if (this.ihq != null) {
      this.ihq.ihN = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */