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
  private Map<String, i> ppc;
  b pri;
  DownloadMainUI.a prj;
  boolean prk;
  private d.d prl;
  private d.a prm;
  private d.b prn;
  private d.f pro;
  private d.e prp;
  private d.g prq;
  private boolean prr;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.ppc = new HashMap();
    this.prl = new d.d()
    {
      public final void M(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ua(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.prm = new d.a()
    {
      public final void jX(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.pri.pra.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.ccY()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.pri.asY.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.jW(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.prn = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        h.e(localTaskListView.getContext(), localTaskListView.getContext().getString(2131758040), "", localTaskListView.getContext().getString(2131764383), localTaskListView.getContext().getString(2131764382), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.pro = new d.f()
    {
      public final void aaA(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.prp = new d.e()
    {
      public final void aaz(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.prq = new d.g()
    {
      public final void aaB(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.prr = true;
    AppMethodBeat.o(9071);
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.pri;
    localb.pra.remove(parami);
    localb.pra.c(parami);
    p.z(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void cdm()
  {
    AppMethodBeat.i(9078);
    this.prk = false;
    if (this.prj != null) {
      this.prj.kd(false);
    }
    Object localObject = this.pri.pra;
    if (this.pri.ccW())
    {
      ((DownloadMainUI)getContext()).kc(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.oxZ = false;
      locali.isSelected = false;
    }
    this.pri.prg = true;
    this.pri.asY.notifyChanged();
    this.prr = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.pri.pra.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.prl);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.prm);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.prn);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pro);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.prp);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.prq);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.prl);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.prm);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.prn);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pro);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.prp);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.prq);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    ad.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.pri = new b(getContext());
    setAdapter(this.pri);
    a(new a(getResources()));
    setOnItemLongClickListener(new MRecyclerView.b()
    {
      public final boolean U(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(9068);
        if (!TaskListView.a(TaskListView.this))
        {
          AppMethodBeat.o(9068);
          return false;
        }
        if ((((ViewGroup)paramAnonymousView).getChildAt(0) instanceof TaskItemView))
        {
          Object localObject = TaskListView.b(TaskListView.this).pra;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).oxZ = true;
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
      public final void T(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(9069);
        ad.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).pra;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(9069);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.prf != true)
          {
            paramAnonymousView.prf = true;
            paramAnonymousView.asY.notifyChanged();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1004, 101, 2, "", "", "");
          AppMethodBeat.o(9069);
          return;
        }
        if (!TaskListView.a(TaskListView.this))
        {
          if (!((i)localObject).isSelected) {}
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
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Bu(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
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
        this.ppc.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.pri;
    ((b)localObject1).pra.clear();
    Object localObject2 = ((b)localObject1).pra;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).pra.b(new i(1));
    ((b)localObject1).pra.b(new i(3));
    ((b)localObject1).pra.b(new i(5));
    ((b)localObject1).pra.b(new i(7));
    ((RecyclerView.a)localObject1).asY.notifyChanged();
    AppMethodBeat.o(9075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */