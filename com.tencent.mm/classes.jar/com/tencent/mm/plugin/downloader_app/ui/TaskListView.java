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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> pvI;
  b pxO;
  DownloadMainUI.a pxP;
  boolean pxQ;
  private d.d pxR;
  private d.a pxS;
  private d.b pxT;
  private d.f pxU;
  private d.e pxV;
  private d.g pxW;
  private boolean pxX;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.pvI = new HashMap();
    this.pxR = new d.d()
    {
      public final void L(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.pxS = new d.a()
    {
      public final void jW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.pxO.pxG.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.cen()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.pxO.asY.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.jV(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.pxT = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        h.e(localTaskListView.getContext(), localTaskListView.getContext().getString(2131758040), "", localTaskListView.getContext().getString(2131764383), localTaskListView.getContext().getString(2131764382), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.pxU = new d.f()
    {
      public final void abr(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.pxV = new d.e()
    {
      public final void abq(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.pxW = new d.g()
    {
      public final void abs(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.pxX = true;
    AppMethodBeat.o(9071);
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.pxO;
    localb.pxG.remove(parami);
    localb.pxG.c(parami);
    p.x(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void ceB()
  {
    AppMethodBeat.i(9078);
    this.pxQ = false;
    if (this.pxP != null) {
      this.pxP.kc(false);
    }
    Object localObject = this.pxO.pxG;
    if (this.pxO.cel())
    {
      ((DownloadMainUI)getContext()).kb(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.oEB = false;
      locali.isSelected = false;
    }
    this.pxO.pxM = true;
    this.pxO.asY.notifyChanged();
    this.pxX = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.pxO.pxG.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxR);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxS);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxT);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxU);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxV);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.pxW);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxR);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxS);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxT);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxU);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxV);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.pxW);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    ae.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.pxO = new b(getContext());
    setAdapter(this.pxO);
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
          Object localObject = TaskListView.b(TaskListView.this).pxG;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).oEB = true;
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
        ae.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).pxG;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(9069);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.pxL != true)
          {
            paramAnonymousView.pxL = true;
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
        if (bu.isNullOrNil(((i)localObject).jumpUrl))
        {
          AppMethodBeat.o(9069);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", ((i)localObject).jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskListView.this.getContext(), paramAnonymousView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
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
      if (!bu.isNullOrNil(((i)localObject2).appId)) {
        this.pvI.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.pxO;
    ((b)localObject1).pxG.clear();
    Object localObject2 = ((b)localObject1).pxG;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).pxG.b(new i(1));
    ((b)localObject1).pxG.b(new i(3));
    ((b)localObject1).pxG.b(new i(5));
    ((b)localObject1).pxG.b(new i(7));
    ((RecyclerView.a)localObject1).asY.notifyChanged();
    AppMethodBeat.o(9075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */