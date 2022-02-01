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
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.ui.base.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> xsx;
  private TaskItemView.a xuE;
  b xuP;
  DownloadMainUI.a xuQ;
  boolean xuR;
  private d.d xuS;
  private d.a xuT;
  private d.b xuU;
  private d.f xuV;
  private d.e xuW;
  private d.g xuX;
  private boolean xuY;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.xsx = new HashMap();
    this.xuS = new d.d()
    {
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.xuT = new d.a()
    {
      public final void nH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.xuP.xuH.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.dva()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.xuP.bZE.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.nG(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.xuU = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        k.b(localTaskListView.getContext(), localTaskListView.getContext().getString(e.h.xqY), "", localTaskListView.getContext().getString(e.h.xrG), localTaskListView.getContext().getString(e.h.xrF), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.xuV = new d.f()
    {
      public final void anf(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.xuW = new d.e()
    {
      public final void ane(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.xuX = new d.g()
    {
      public final void ang(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.xuY = true;
    AppMethodBeat.o(9071);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.xuP;
    localb.xuH.remove(parami);
    localb.xuH.c(parami);
    s.D(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void dvp()
  {
    AppMethodBeat.i(9078);
    this.xuR = false;
    if (this.xuQ != null) {
      this.xuQ.nN(false);
    }
    Object localObject = this.xuP.xuH;
    if (this.xuP.duY())
    {
      ((DownloadMainUI)getContext()).nM(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.wsK = false;
      locali.isSelected = false;
    }
    this.xuP.xuN = true;
    this.xuP.bZE.notifyChanged();
    this.xuY = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.xuP.xuH.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuS);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuT);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuU);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuV);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuW);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.xuX);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuS);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuT);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuU);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuV);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuW);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.xuX);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    Log.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.xuP = new b(getContext());
    this.xuP.xuE = this.xuE;
    setAdapter(this.xuP);
    a(new a(getResources()));
    setOnItemLongClickListener(new MRecyclerView.b()
    {
      public final boolean onItemLongClick(RecyclerView paramAnonymousRecyclerView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(269719);
        if (!TaskListView.a(TaskListView.this))
        {
          AppMethodBeat.o(269719);
          return false;
        }
        if ((((ViewGroup)paramAnonymousView).getChildAt(0) instanceof TaskItemView))
        {
          paramAnonymousRecyclerView = TaskListView.b(TaskListView.this).xuH;
          if (paramAnonymousRecyclerView != null)
          {
            paramAnonymousRecyclerView = paramAnonymousRecyclerView.iterator();
            while (paramAnonymousRecyclerView.hasNext()) {
              ((i)paramAnonymousRecyclerView.next()).wsK = true;
            }
            ((TaskItemView)((ViewGroup)paramAnonymousView).getChildAt(0)).setSelected(true);
            TaskListView.c(TaskListView.this);
          }
        }
        AppMethodBeat.o(269719);
        return true;
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void onItemClick(RecyclerView paramAnonymousRecyclerView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(269720);
        Log.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousRecyclerView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        paramAnonymousView = TaskListView.b(TaskListView.this).xuH;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousView.size()))
        {
          AppMethodBeat.o(269720);
          return;
        }
        paramAnonymousView = (i)paramAnonymousView.get(paramAnonymousInt);
        if (paramAnonymousView.type == 7)
        {
          paramAnonymousRecyclerView = TaskListView.b(TaskListView.this);
          if (paramAnonymousRecyclerView.xuM != true)
          {
            paramAnonymousRecyclerView.xuM = true;
            paramAnonymousRecyclerView.bZE.notifyChanged();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1004, 101, 2, "", "", "");
          AppMethodBeat.o(269720);
          return;
        }
        if (!TaskListView.a(TaskListView.this))
        {
          if (!paramAnonymousView.isSelected) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousRecyclerView.setSelected(bool);
            AppMethodBeat.o(269720);
            return;
          }
        }
        if (Util.isNullOrNil(paramAnonymousView.jumpUrl))
        {
          AppMethodBeat.o(269720);
          return;
        }
        paramAnonymousRecyclerView = new Bundle();
        paramAnonymousRecyclerView.putString("rawUrl", paramAnonymousView.jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskListView.this.getContext(), paramAnonymousRecyclerView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(paramAnonymousView.type), paramAnonymousView.position, 40, paramAnonymousView.appId, "", "");
        AppMethodBeat.o(269720);
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
        this.xsx.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.xuP;
    ((b)localObject1).xuH.clear();
    Object localObject2 = ((b)localObject1).xuH;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).xuH.b(new i(1));
    ((b)localObject1).xuH.b(new i(3));
    ((b)localObject1).xuH.b(new i(5));
    ((b)localObject1).xuH.b(new i(7));
    ((RecyclerView.a)localObject1).bZE.notifyChanged();
    AppMethodBeat.o(9075);
  }
  
  public void setOnItemButtonClickListener(TaskItemView.a parama)
  {
    this.xuE = parama;
    if (this.xuP != null) {
      this.xuP.xuE = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */