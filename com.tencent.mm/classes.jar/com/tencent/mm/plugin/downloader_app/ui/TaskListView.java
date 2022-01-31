package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.a;
import com.tencent.mm.plugin.downloader_app.b.d.b;
import com.tencent.mm.plugin.downloader_app.b.d.d;
import com.tencent.mm.plugin.downloader_app.b.d.e;
import com.tencent.mm.plugin.downloader_app.b.d.f;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, j> iSl = new HashMap();
  b iTW;
  DownloadMainUI.a iTX;
  private d.d iTY = new d.d()
  {
    public final void X(int paramAnonymousInt, String paramAnonymousString)
    {
      TaskListView.a(TaskListView.this, paramAnonymousInt, paramAnonymousString);
    }
  };
  private d.a iTZ = new TaskListView.2(this);
  private d.b iUa = new TaskListView.3(this);
  private d.f iUb = new TaskListView.4(this);
  private d.e iUc = new TaskListView.5(this);
  boolean iUd = true;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(j paramj)
  {
    b localb = this.iTW;
    localb.iTQ.remove(paramj);
    h localh = localb.iTQ;
    int i = 0;
    if (i < localh.size())
    {
      e locale = (e)localh.get(i);
      if (paramj.aGm() > locale.aGm()) {}
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = localh.size();
      }
      localh.add(i, paramj);
      l.m(new b.1(localb));
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public int getSize()
  {
    return this.iTW.iTQ.size();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d.a(this.iTY);
    d.a(this.iTZ);
    d.a(this.iUa);
    d.a(this.iUb);
    d.a(this.iUc);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d.b(this.iTY);
    d.b(this.iTZ);
    d.b(this.iUa);
    d.b(this.iUb);
    d.b(this.iUc);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    y.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.iTW = new b(getContext());
    setAdapter(this.iTW);
    a(new a(getResources()));
    setOnItemLongClickListener(new TaskListView.6(this));
    setOnItemClickListener(new TaskListView.7(this));
  }
  
  public void setData(LinkedList<j> paramLinkedList)
  {
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      this.iSl.put(((j)localObject2).appId, localObject2);
    }
    localObject1 = this.iTW;
    ((b)localObject1).iTQ.clear();
    Object localObject2 = ((b)localObject1).iTQ;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((h)localObject2).a((e)paramLinkedList.next());
    }
    ((b)localObject1).iTQ.a(new j(1));
    ((b)localObject1).iTQ.a(new j(3));
    ((b)localObject1).iTQ.a(new j(5));
    ((RecyclerView.a)localObject1).agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */