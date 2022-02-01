package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.life.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "()V", "DEBUG", "", "getDEBUG", "()Z", "dispatcher", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$DispatcherMachine;", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$Element;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "insertIndex", "", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "findMergeIndex", "", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "needCleanWhenRefresh", "onActionEnd", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "onAlive", "", "onDead", "printList", "tag", "", "mmlist", "register", "callback", "Lcom/tencent/mm/view/IViewActionCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "unregister", "DispatcherMachine", "Element", "MergeResult", "STATUS", "plugin-finder_release"})
public abstract class b<T extends h>
  extends DataStore<T>
{
  private final boolean DEBUG;
  private final a<T> dispatcher = new a(this.viewCallbacks, (d.g.a.b)new d(this));
  private final LinkedList<b> viewCallbacks = new LinkedList();
  
  public b()
  {
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cAi() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.DEBUG = bool;
      return;
    }
  }
  
  private final c onActionEnd(k<T> paramk)
  {
    return mergeDataAndNotify(paramk.CW, paramk.roA, paramk.isNeedClear, paramk.request);
  }
  
  public final a<T> dispatcher()
  {
    return this.dispatcher;
  }
  
  public boolean finallyHandleMergeList(ArrayList<T> paramArrayList, LinkedList<T> paramLinkedList, int paramInt1, int paramInt2, i parami)
  {
    d.g.b.k.h(paramArrayList, "srcList");
    d.g.b.k.h(paramLinkedList, "newList");
    return false;
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, i parami)
  {
    d.g.b.k.h(paramArrayList, "srcList");
    d.g.b.k.h(paramList, "newList");
    return 0;
  }
  
  public final boolean getDEBUG()
  {
    return this.DEBUG;
  }
  
  protected final c merge(List<? extends T> paramList, int paramInt, i parami)
  {
    d.g.b.k.h(paramList, "newList");
    printList("newList", paramInt, paramList);
    DataBuffer localDataBuffer = getDataList();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    int i;
    while (paramList.hasNext())
    {
      h localh = (h)paramList.next();
      Object localObject = (List)localDataBuffer;
      i = 0;
      localObject = ((List)localObject).iterator();
      label87:
      label120:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((h)((Iterator)localObject).next()).a(localh) == 0)
        {
          j = 1;
          if (j == 0) {
            break label215;
          }
          j = i;
          label129:
          localObject = (List)localLinkedList1;
          i = 0;
          localObject = ((List)localObject).iterator();
          label148:
          if (!((Iterator)localObject).hasNext()) {
            break label245;
          }
          if (((h)((Iterator)localObject).next()).a(localh) != 0) {
            break label230;
          }
          k = 1;
          label181:
          if (k == 0) {
            break label236;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label251;
        }
        localLinkedList1.add(localh);
        break;
        j = 0;
        break label120;
        label215:
        i += 1;
        break label87;
        j = -1;
        break label129;
        label230:
        k = 0;
        break label181;
        label236:
        i += 1;
        break label148;
        label245:
        i = -1;
      }
      label251:
      if (j != -1)
      {
        localDataBuffer.set(j, localh);
        localLinkedList2.add(Integer.valueOf(j));
      }
      else
      {
        ac.w(getTAG(), "newList exist a same feed[" + (h)localLinkedList1.get(i) + "], just ignore this feed=" + localh + " existIndex=" + j + " existIndexInIncrementList=" + i);
      }
    }
    printList("incrementList", paramInt, (List)localLinkedList1);
    int j = 0;
    boolean bool = false;
    if (localLinkedList1.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label532;
      }
    }
    label532:
    for (paramList = localLinkedList1;; paramList = null)
    {
      i = j;
      if (paramList != null)
      {
        i = findMergeIndex((ArrayList)localDataBuffer, (List)localLinkedList1, paramInt, parami);
        bool = finallyHandleMergeList((ArrayList)localDataBuffer, localLinkedList1, i, paramInt, parami);
        ac.i(getTAG(), "merge list index " + i + " incrementList:" + localLinkedList1.size() + " cmd=" + paramInt);
        localDataBuffer.addAll(i, (Collection)localLinkedList1);
      }
      paramList = new c(i, localLinkedList1.size(), localLinkedList2, bool);
      printList("dataList", paramInt, (List)getDataList());
      return paramList;
      i = 0;
      break;
    }
  }
  
  public abstract c mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, i parami);
  
  public boolean needCleanWhenRefresh(List<? extends T> paramList)
  {
    d.g.b.k.h(paramList, "newList");
    return true;
  }
  
  public abstract void onAlive();
  
  public abstract void onDead();
  
  public final void printList(String paramString, int paramInt, List<? extends T> paramList)
  {
    d.g.b.k.h(paramString, "tag");
    d.g.b.k.h(paramList, "mmlist");
    if (this.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          j.fOc();
        }
        localObject = (h)localObject;
        String str = getTAG();
        StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
        k.a locala = k.roB;
        ac.i(str, k.a.DL(paramInt) + ' ' + localObject);
        i += 1;
      }
    }
  }
  
  public final void register(d paramd, MMActivity paramMMActivity)
  {
    d.g.b.k.h(paramd, "callback");
    d.g.b.k.h(paramMMActivity, "activity");
    paramMMActivity = new b(paramd, paramMMActivity);
    this.viewCallbacks.add(paramMMActivity);
    ac.i(getTAG(), "register callback " + paramd + " size:" + this.viewCallbacks.size() + " from " + bs.eWi() + '}');
    if (this.viewCallbacks.size() == 1) {
      onAlive();
    }
  }
  
  public final void unregister(d paramd, MMActivity arg2)
  {
    d.g.b.k.h(paramd, "callback");
    d.g.b.k.h(???, "activity");
    synchronized ((Iterable)this.viewCallbacks)
    {
      localObject = ???.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (d.g.b.k.g(localb.rnQ, paramd)) {
          this.viewCallbacks.remove(localb);
        }
      }
    }
    Object localObject = y.KTp;
    ac.i(getTAG(), "unregister callback " + paramd + " size " + this.viewCallbacks.size() + " from " + bs.eWi() + '}');
    if (this.viewCallbacks.size() == 0) {
      onDead();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$Element;", "func", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "Lkotlin/ParameterName;", "name", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "(Ljava/util/LinkedList;Lkotlin/jvm/functions/Function1;)V", "getFunc", "()Lkotlin/jvm/functions/Function1;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a<R extends h>
  {
    final d.g.a.b<k<R>, b.c> rnK;
    final LinkedList<b.b> viewCallbacks;
    
    public a(LinkedList<b.b> paramLinkedList, d.g.a.b<? super k<R>, b.c> paramb)
    {
      AppMethodBeat.i(166115);
      this.viewCallbacks = paramLinkedList;
      this.rnK = paramb;
      AppMethodBeat.o(166115);
    }
    
    public final void a(final k<R> paramk, final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(166113);
      d.g.b.k.h(paramk, "op");
      d.g.b.k.h(paramc, "reason");
      c.g((d.g.a.a)new g(this, paramk, paramc));
      AppMethodBeat.o(166113);
    }
    
    public final void au(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(166112);
      c.g((d.g.a.a)new d(this, paramInt1, paramInt2));
      AppMethodBeat.o(166112);
    }
    
    public final void b(final k<R> paramk, final RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(166114);
      d.g.b.k.h(paramk, "op");
      d.g.b.k.h(paramc, "reason");
      c.g((d.g.a.a)new f(this, paramk, paramc));
      AppMethodBeat.o(166114);
    }
    
    public final void m(final int paramInt, final Object paramObject)
    {
      AppMethodBeat.i(166111);
      c.g((d.g.a.a)new b(this, paramInt, paramObject));
      AppMethodBeat.o(166111);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(166110);
      c.g((d.g.a.a)new a(this));
      AppMethodBeat.o(166110);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(b.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(b.a parama, int paramInt, Object paramObject)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(b.a parama, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(b.a parama, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      e(b.a parama, k paramk)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      f(b.a parama, k paramk, RefreshLoadMoreLayout.c paramc)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      g(b.a parama, k paramk, RefreshLoadMoreLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$Element;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "callback", "Lcom/tencent/mm/view/IViewActionCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "state", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "(Lcom/tencent/mm/view/IViewActionCallback;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "isActivate", "", "()Z", "getState", "()Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "setState", "(Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.life.a
  {
    private final MMActivity activity;
    final d rnQ;
    private a.a rnR;
    
    private b(d paramd, MMActivity paramMMActivity, a.a parama)
    {
      AppMethodBeat.i(166116);
      this.rnQ = paramd;
      this.activity = paramMMActivity;
      this.rnR = parama;
      a(this.activity, null);
      AppMethodBeat.o(166116);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "", "insertIndex", "", "insertCount", "changeIndex", "Ljava/util/LinkedList;", "isRemoveBeforeInsert", "", "(IILjava/util/LinkedList;Z)V", "getChangeIndex", "()Ljava/util/LinkedList;", "getInsertCount", "()I", "getInsertIndex", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class c
  {
    final int rnS;
    final int rnT;
    final LinkedList<Integer> rnU;
    final boolean rnV;
    
    public c(int paramInt1, int paramInt2, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
    {
      AppMethodBeat.i(202260);
      this.rnS = paramInt1;
      this.rnT = paramInt2;
      this.rnU = paramLinkedList;
      this.rnV = paramBoolean;
      AppMethodBeat.o(202260);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166121);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.rnS != paramObject.rnS) || (this.rnT != paramObject.rnT) || (!d.g.b.k.g(this.rnU, paramObject.rnU)) || (this.rnV != paramObject.rnV)) {}
        }
      }
      else
      {
        AppMethodBeat.o(166121);
        return true;
      }
      AppMethodBeat.o(166121);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166119);
      String str = "MergeResult(insertIndex=" + this.rnS + ", insertCount=" + this.rnT + ", changeIndex=" + this.rnU + ", isRemoveBeforeInsert=" + this.rnV + ")";
      AppMethodBeat.o(166119);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<k<T>, b.c>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */