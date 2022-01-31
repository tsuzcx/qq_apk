package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WxaBindBizInfoUI$a
  extends RecyclerView.a
{
  private LayoutInflater Lu;
  private final List<WxaAttributes.WxaEntryInfo> heL;
  boolean heM = true;
  
  public WxaBindBizInfoUI$a(LayoutInflater paramLayoutInflater)
  {
    this.Lu = paramLayoutInflater;
    this.heL = new LinkedList();
  }
  
  private boolean contains(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Iterator localIterator = this.heL.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((WxaAttributes.WxaEntryInfo)localIterator.next()).username)) {
        return true;
      }
    }
    return false;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WxaBindBizInfoUI.b(this.Lu.inflate(y.h.app_brand_launcher_recents_item_as_normal, paramViewGroup, false));
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i = 0;
    WxaAttributes.WxaEntryInfo localWxaEntryInfo = mp(paramInt);
    if (localWxaEntryInfo == null) {
      y.i("MicroMsg.WxaBindBizInfoUI", "onBindViewHolder failed, getItem(%d) return null", new Object[] { Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      paramv = (WxaBindBizInfoUI.b)paramv;
      b.JD().a(paramv.heN, localWxaEntryInfo.iconUrl, a.JC(), f.eaL);
      paramv.eXr.setText(bk.pm(localWxaEntryInfo.title));
    } while (!this.heM);
    paramv = paramv.eYp;
    if (this.heL.size() - 1 == paramInt) {
      i = 8;
    }
    paramv.setVisibility(i);
  }
  
  protected final void aA(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)localIterator.next();
      if (!contains(localWxaEntryInfo.username)) {
        localLinkedList.add(localWxaEntryInfo);
      }
    }
    this.heL.addAll(localLinkedList);
    ah(this.heL.size() - paramList.size(), paramList.size());
  }
  
  public final int getItemCount()
  {
    return this.heL.size();
  }
  
  public final WxaAttributes.WxaEntryInfo mp(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getItemCount())) {
      return null;
    }
    return (WxaAttributes.WxaEntryInfo)this.heL.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.a
 * JD-Core Version:    0.7.0.1
 */