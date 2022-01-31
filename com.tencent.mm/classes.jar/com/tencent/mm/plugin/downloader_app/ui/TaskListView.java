package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.a;
import com.tencent.mm.plugin.downloader_app.b.d.b;
import com.tencent.mm.plugin.downloader_app.b.d.d;
import com.tencent.mm.plugin.downloader_app.b.d.e;
import com.tencent.mm.plugin.downloader_app.b.d.f;
import com.tencent.mm.plugin.downloader_app.b.d.g;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> laS;
  b lcX;
  DownloadMainUI.a lcY;
  boolean lcZ;
  private d.d lda;
  private d.a ldb;
  private d.b ldc;
  private d.f ldd;
  private d.e lde;
  private d.g ldf;
  private boolean ldg;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136301);
    this.laS = new HashMap();
    this.lda = new TaskListView.1(this);
    this.ldb = new TaskListView.3(this);
    this.ldc = new TaskListView.4(this);
    this.ldd = new TaskListView.5(this);
    this.lde = new TaskListView.6(this);
    this.ldf = new TaskListView.7(this);
    this.ldg = true;
    AppMethodBeat.o(136301);
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(136306);
    b localb = this.lcX;
    localb.lcP.remove(parami);
    h localh = localb.lcP;
    int i = 0;
    if (i < localh.size())
    {
      e locale = (e)localh.get(i);
      if (parami.bjP() > locale.bjP()) {}
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = localh.size();
      }
      localh.add(i, parami);
      l.q(new b.1(localb));
      AppMethodBeat.o(136306);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public final void bka()
  {
    AppMethodBeat.i(136308);
    this.lcZ = false;
    if (this.lcY != null) {
      this.lcY.gC(false);
    }
    Object localObject = this.lcX.lcP;
    if (this.lcX.bjQ())
    {
      ((DownloadMainUI)getContext()).gB(true);
      AppMethodBeat.o(136308);
      return;
    }
    localObject = ((h)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.kmz = false;
      locali.gDG = false;
    }
    this.lcX.lcV = true;
    this.lcX.ajb.notifyChanged();
    this.ldg = true;
    AppMethodBeat.o(136308);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(136307);
    int i = this.lcX.lcP.size();
    AppMethodBeat.o(136307);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(136303);
    super.onAttachedToWindow();
    d.a(this.lda);
    d.a(this.ldb);
    d.a(this.ldc);
    d.a(this.ldd);
    d.a(this.lde);
    d.a(this.ldf);
    AppMethodBeat.o(136303);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(136304);
    super.onDetachedFromWindow();
    d.b(this.lda);
    d.b(this.ldb);
    d.b(this.ldc);
    d.b(this.ldd);
    d.b(this.lde);
    d.b(this.ldf);
    AppMethodBeat.o(136304);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136302);
    super.onFinishInflate();
    ab.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.lcX = new b(getContext());
    setAdapter(this.lcX);
    a(new a(getResources()));
    setOnItemLongClickListener(new TaskListView.8(this));
    setOnItemClickListener(new TaskListView.9(this));
    AppMethodBeat.o(136302);
  }
  
  public void setData(LinkedList<i> paramLinkedList)
  {
    AppMethodBeat.i(136305);
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      if (!bo.isNullOrNil(((i)localObject2).appId)) {
        this.laS.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.lcX;
    ((b)localObject1).lcP.clear();
    Object localObject2 = ((b)localObject1).lcP;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((h)localObject2).a((e)paramLinkedList.next());
    }
    ((b)localObject1).lcP.a(new i(1));
    ((b)localObject1).lcP.a(new i(3));
    ((b)localObject1).lcP.a(new i(5));
    ((b)localObject1).lcP.a(new i(7));
    ((RecyclerView.a)localObject1).ajb.notifyChanged();
    AppMethodBeat.o(136305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */