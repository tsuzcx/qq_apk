package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.downloader_app.a.d.a;
import com.tencent.mm.plugin.downloader_app.a.d.b;
import com.tencent.mm.plugin.downloader_app.a.d.d;
import com.tencent.mm.plugin.downloader_app.a.d.e;
import com.tencent.mm.plugin.downloader_app.a.d.f;
import com.tencent.mm.plugin.downloader_app.a.d.g;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> ohU;
  b oka;
  DownloadMainUI.a okb;
  boolean okc;
  private d.d okd;
  private d.a oke;
  private d.b okf;
  private d.f okg;
  private d.e okh;
  private d.g oki;
  private boolean okj;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.ohU = new HashMap();
    this.okd = new d.d()
    {
      public final void L(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.oq(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.oke = new d.a()
    {
      public final void jj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.oka.ojS.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.bRf()) {
            locali.ira = paramAnonymousBoolean;
          }
        }
        localTaskListView.oka.aql.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.ji(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.okf = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        h.d(localTaskListView.getContext(), localTaskListView.getContext().getString(2131758040), "", localTaskListView.getContext().getString(2131764383), localTaskListView.getContext().getString(2131764382), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.okg = new d.f()
    {
      public final void SH(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.okh = new d.e()
    {
      public final void SG(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.oki = new d.g()
    {
      public final void SI(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.okj = true;
    AppMethodBeat.o(9071);
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.oka;
    localb.ojS.remove(parami);
    localb.ojS.c(parami);
    p.y(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void bRt()
  {
    AppMethodBeat.i(9078);
    this.okc = false;
    if (this.okb != null) {
      this.okb.jp(false);
    }
    Object localObject = this.oka.ojS;
    if (this.oka.bRd())
    {
      ((DownloadMainUI)getContext()).jo(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.nrE = false;
      locali.ira = false;
    }
    this.oka.ojY = true;
    this.oka.aql.notifyChanged();
    this.okj = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.oka.ojS.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.okd);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oke);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.okf);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.okg);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.okh);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oki);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.okd);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oke);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.okf);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.okg);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.okh);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oki);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    ad.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.oka = new b(getContext());
    setAdapter(this.oka);
    a(new a(getResources()));
    setOnItemLongClickListener(new MRecyclerView.b()
    {
      public final boolean T(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(9068);
        if (!TaskListView.a(TaskListView.this))
        {
          AppMethodBeat.o(9068);
          return false;
        }
        if ((((ViewGroup)paramAnonymousView).getChildAt(0) instanceof TaskItemView))
        {
          Object localObject = TaskListView.b(TaskListView.this).ojS;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).nrE = true;
            }
            ((TaskItemView)((ViewGroup)paramAnonymousView).getChildAt(0)).setSelected(true);
            TaskListView.c(TaskListView.this);
          }
        }
        AppMethodBeat.o(9068);
        return true;
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void S(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(9069);
        ad.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).ojS;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(9069);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.ojX != true)
          {
            paramAnonymousView.ojX = true;
            paramAnonymousView.aql.notifyChanged();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1004, 101, 2, "", "", "");
          AppMethodBeat.o(9069);
          return;
        }
        if (!TaskListView.a(TaskListView.this))
        {
          if (!((i)localObject).ira) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setSelected(bool);
            AppMethodBeat.o(9069);
            return;
          }
        }
        if (bt.isNullOrNil(((i)localObject).jumpUrl))
        {
          AppMethodBeat.o(9069);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", ((i)localObject).jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskListView.this.getContext(), paramAnonymousView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.zU(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
        AppMethodBeat.o(9069);
      }
    });
    AppMethodBeat.o(9072);
  }
  
  public void setData(LinkedList<i> paramLinkedList)
  {
    AppMethodBeat.i(9075);
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      if (!bt.isNullOrNil(((i)localObject2).appId)) {
        this.ohU.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.oka;
    ((b)localObject1).ojS.clear();
    Object localObject2 = ((b)localObject1).ojS;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).ojS.b(new i(1));
    ((b)localObject1).ojS.b(new i(3));
    ((b)localObject1).ojS.b(new i(5));
    ((b)localObject1).ojS.b(new i(7));
    ((RecyclerView.a)localObject1).aql.notifyChanged();
    AppMethodBeat.o(9075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */