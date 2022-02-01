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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView
  extends MRecyclerView
{
  private Map<String, i> oLu;
  b oNA;
  DownloadMainUI.a oNB;
  boolean oNC;
  private d.d oND;
  private d.a oNE;
  private d.b oNF;
  private d.f oNG;
  private d.e oNH;
  private d.g oNI;
  private boolean oNJ;
  
  public TaskListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9071);
    this.oLu = new HashMap();
    this.oND = new d.d()
    {
      public final void K(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(9062);
        com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramAnonymousLong);
        if (locala != null) {
          TaskListView.a(TaskListView.this, paramAnonymousInt, locala.field_appId);
        }
        AppMethodBeat.o(9062);
      }
    };
    this.oNE = new d.a()
    {
      public final void jM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9063);
        TaskListView localTaskListView = TaskListView.this;
        Iterator localIterator = localTaskListView.oNA.oNs.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (locali.bYu()) {
            locali.isSelected = paramAnonymousBoolean;
          }
        }
        localTaskListView.oNA.arg.notifyChanged();
        com.tencent.mm.plugin.downloader_app.a.d.jL(paramAnonymousBoolean);
        AppMethodBeat.o(9063);
      }
    };
    this.oNF = new d.b()
    {
      public final void onClick()
      {
        AppMethodBeat.i(9064);
        TaskListView localTaskListView = TaskListView.this;
        h.d(localTaskListView.getContext(), localTaskListView.getContext().getString(2131758040), "", localTaskListView.getContext().getString(2131764383), localTaskListView.getContext().getString(2131764382), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
        AppMethodBeat.o(9064);
      }
    };
    this.oNG = new d.f()
    {
      public final void WT(String paramAnonymousString)
      {
        AppMethodBeat.i(9065);
        TaskListView.a(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9065);
      }
    };
    this.oNH = new d.e()
    {
      public final void WS(String paramAnonymousString)
      {
        AppMethodBeat.i(9066);
        TaskListView.b(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9066);
      }
    };
    this.oNI = new d.g()
    {
      public final void WU(String paramAnonymousString)
      {
        AppMethodBeat.i(9067);
        TaskListView.c(TaskListView.this, paramAnonymousString);
        AppMethodBeat.o(9067);
      }
    };
    this.oNJ = true;
    AppMethodBeat.o(9071);
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(9076);
    b localb = this.oNA;
    localb.oNs.remove(parami);
    localb.oNs.c(parami);
    p.z(new b.1(localb));
    AppMethodBeat.o(9076);
  }
  
  public final void bYI()
  {
    AppMethodBeat.i(9078);
    this.oNC = false;
    if (this.oNB != null) {
      this.oNB.jS(false);
    }
    Object localObject = this.oNA.oNs;
    if (this.oNA.bYs())
    {
      ((DownloadMainUI)getContext()).jR(true);
      AppMethodBeat.o(9078);
      return;
    }
    localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.nUE = false;
      locali.isSelected = false;
    }
    this.oNA.oNy = true;
    this.oNA.arg.notifyChanged();
    this.oNJ = true;
    AppMethodBeat.o(9078);
  }
  
  public int getSize()
  {
    AppMethodBeat.i(9077);
    int i = this.oNA.oNs.size();
    AppMethodBeat.o(9077);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9073);
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oND);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oNE);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oNF);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oNG);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oNH);
    com.tencent.mm.plugin.downloader_app.a.d.a(this.oNI);
    AppMethodBeat.o(9073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9074);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oND);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oNE);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oNF);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oNG);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oNH);
    com.tencent.mm.plugin.downloader_app.a.d.b(this.oNI);
    AppMethodBeat.o(9074);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9072);
    super.onFinishInflate();
    ac.d("MicroMsg.TaskListView", "onFinishInflate");
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.oNA = new b(getContext());
    setAdapter(this.oNA);
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
          Object localObject = TaskListView.b(TaskListView.this).oNs;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.game.commlib.c.c)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((i)((Iterator)localObject).next()).nUE = true;
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
        ac.d("MicroMsg.TaskListView", "onItemClick");
        paramAnonymousView = ((ViewGroup)paramAnonymousView).getChildAt(0);
        Object localObject = TaskListView.b(TaskListView.this).oNs;
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ((com.tencent.mm.plugin.game.commlib.c.c)localObject).size()))
        {
          AppMethodBeat.o(9069);
          return;
        }
        localObject = (i)((com.tencent.mm.plugin.game.commlib.c.c)localObject).get(paramAnonymousInt);
        if (((i)localObject).type == 7)
        {
          paramAnonymousView = TaskListView.b(TaskListView.this);
          if (paramAnonymousView.oNx != true)
          {
            paramAnonymousView.oNx = true;
            paramAnonymousView.arg.notifyChanged();
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
        if (bs.isNullOrNil(((i)localObject).jumpUrl))
        {
          AppMethodBeat.o(9069);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", ((i)localObject).jumpUrl);
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskListView.this.getContext(), paramAnonymousView);
        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.AM(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
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
      if (!bs.isNullOrNil(((i)localObject2).appId)) {
        this.oLu.put(((i)localObject2).appId, localObject2);
      }
    }
    localObject1 = this.oNA;
    ((b)localObject1).oNs.clear();
    Object localObject2 = ((b)localObject1).oNs;
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      ((com.tencent.mm.plugin.game.commlib.c.c)localObject2).b((com.tencent.mm.plugin.game.commlib.c.b)paramLinkedList.next());
    }
    ((b)localObject1).oNs.b(new i(1));
    ((b)localObject1).oNs.b(new i(3));
    ((b)localObject1).oNs.b(new i(5));
    ((b)localObject1).oNs.b(new i(7));
    ((RecyclerView.a)localObject1).arg.notifyChanged();
    AppMethodBeat.o(9075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView
 * JD-Core Version:    0.7.0.1
 */