package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.s;
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
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> uml;
  private d.g uoA;
  private boolean uoB;
  private TaskItemView.a uoh;
  b uos;
  DownloadMainUI.a uot;
  boolean uou;
  private d.d uov;
  private d.a uow;
  private d.b uox;
  private d.f uoy;
  private d.e uoz;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.uml = new HashMap();
    this.uov = new d.d()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.uow = new d.a()
    {
      public final void ml(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.uos.uok.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.cQH()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.uos.alc.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.mk(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.uox = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        com.tencent.mm.ui.base.h.c(localTaskListView.getContext(), localTaskListView.getContext().getString(e.h.ukM), "", localTaskListView.getContext().getString(e.h.ulu), localTaskListView.getContext().getString(e.h.ult), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.uoy = new d.f()
    {
      public final void atq(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.uoz = new d.e()
    {
      public final void atp(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.uoA = new d.g()
    {
      public final void atr(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.uoB = true;
    AppMethodBeat.o(9071);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.uos;
    localb.uok.remove(parami);
    localb.uok.c(parami);
    s.y(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void cQW()
  {
    AppMethodBeat.i(9078);
    this.uou = false;
    if (this.uot != null) {
      this.uot.mr(false);
    }
    Object localObject = this.uos.uok;
    if (this.uos.cQF())
    {
      ((DownloadMainUI)getContext()).mq(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.toj = false;
      locali.isSelected = false;
    }
    this.uos.uoq = true;
    this.uos.alc.notifyChanged();
    this.uoB = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.uos.uok.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uov);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uow);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uox);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uoy);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uoz);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.uoA);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uov);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uow);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uox);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uoy);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uoz);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.uoA);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    Log.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.uos = new b(getContext());
    this.uos.uoh = this.uoh;
    setAdapter(this.uos);
    a(new a(getResources()));
    setOnItemLongClickListener(new MRecyclerView.b()
    {
      public final boolean V(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(242802);
        if (!TaskListView.a(TaskListView.this))
        {
          AppMethodBeat.o(242802);
          return false;
        }
        if ((((ViewGroup)paramAnonymousView).getChildAt(0) instanceof TaskItemView))
        {
          Object localObject = TaskListView.b(TaskListView.this).uok;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).toj = true;
            }
            ((TaskItemView)((ViewGroup)paramAnonymousView).getChildAt(0)).setSelected(true);
            TaskListView.c(TaskListView.this);
          }
        }
        AppMethodBeat.o(242802);
        return true;
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void U(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(243033);
        Log.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).uok;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(243033);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.uop != true)
          {
            paramAnonymousView.uop = true;
            paramAnonymousView.alc.notifyChanged();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1004, 101, 2, "", "", "");
          AppMethodBeat.o(243033);
          return;
        }
        if (!TaskListView.a(TaskListView.this))
        {
          if (!((i)localObject).isSelected) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setSelected(bool);
            AppMethodBeat.o(243033);
            return;
          }
        }
        if (Util.isNullOrNil(((i)localObject).jumpUrl))
        {
          AppMethodBeat.o(243033);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", ((i)localObject).jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskListView.this.getContext(), paramAnonymousView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
        AppMethodBeat.o(243033);
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
      if (!Util.isNullOrNil(((i)localObject2).appId)) {
        this.uml.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.uos;
    ((b)localObject1).uok.clear();
    Object localObject2 = ((b)localObject1).uok;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).uok.b(new i(1));
    ((b)localObject1).uok.b(new i(3));
    ((b)localObject1).uok.b(new i(5));
    ((b)localObject1).uok.b(new i(7));
    ((RecyclerView.a)localObject1).alc.notifyChanged();
    AppMethodBeat.o(9075);
  }
  
  public void setOnItemButtonClickListener(TaskItemView.a parama)
  {
    this.uoh = parama;
    if (this.uos != null) {
      this.uos.uoh = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */