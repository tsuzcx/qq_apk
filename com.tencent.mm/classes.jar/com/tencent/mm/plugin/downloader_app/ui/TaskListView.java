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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> qKZ;
  b qNf;
  DownloadMainUI.a qNg;
  boolean qNh;
  private d.d qNi;
  private d.a qNj;
  private d.b qNk;
  private d.f qNl;
  private d.e qNm;
  private d.g qNn;
  private boolean qNo;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.qKZ = new HashMap();
    this.qNi = new d.d()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Cw(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.qNj = new d.a()
    {
      public final void kZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.qNf.qMX.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.cCd()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.qNf.atj.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.kY(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.qNk = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        h.c(localTaskListView.getContext(), localTaskListView.getContext().getString(2131758292), "", localTaskListView.getContext().getString(2131766644), localTaskListView.getContext().getString(2131766643), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.qNl = new d.f()
    {
      public final void alx(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.qNm = new d.e()
    {
      public final void alw(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.qNn = new d.g()
    {
      public final void aly(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.qNo = true;
    AppMethodBeat.o(9071);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.qNf;
    localb.qMX.remove(parami);
    localb.qMX.c(parami);
    p.y(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void cCr()
  {
    AppMethodBeat.i(9078);
    this.qNh = false;
    if (this.qNg != null) {
      this.qNg.lf(false);
    }
    Object localObject = this.qNf.qMX;
    if (this.qNf.cCb())
    {
      ((DownloadMainUI)getContext()).le(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.pSk = false;
      locali.isSelected = false;
    }
    this.qNf.qNd = true;
    this.qNf.atj.notifyChanged();
    this.qNo = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.qNf.qMX.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNi);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNj);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNk);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNl);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNm);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.qNn);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNi);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNj);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNk);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNl);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNm);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.qNn);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    Log.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.qNf = new b(getContext());
    setAdapter(this.qNf);
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
          Object localObject = TaskListView.b(TaskListView.this).qMX;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).pSk = true;
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
        Log.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).qMX;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(9069);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.qNc != true)
          {
            paramAnonymousView.qNc = true;
            paramAnonymousView.atj.notifyChanged();
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
        if (Util.isNullOrNil(((i)localObject).jumpUrl))
        {
          AppMethodBeat.o(9069);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", ((i)localObject).jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskListView.this.getContext(), paramAnonymousView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
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
      if (!Util.isNullOrNil(((i)localObject2).appId)) {
        this.qKZ.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.qNf;
    ((b)localObject1).qMX.clear();
    Object localObject2 = ((b)localObject1).qMX;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).qMX.b(new i(1));
    ((b)localObject1).qMX.b(new i(3));
    ((b)localObject1).qMX.b(new i(5));
    ((b)localObject1).qMX.b(new i(7));
    ((RecyclerView.a)localObject1).atj.notifyChanged();
    AppMethodBeat.o(9075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */