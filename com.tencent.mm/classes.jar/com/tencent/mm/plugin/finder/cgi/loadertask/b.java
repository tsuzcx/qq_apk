package com.tencent.mm.plugin.finder.cgi.loadertask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Lcom.tencent.mm.plugin.finder.cgi.aq.d;>;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/loadertask/FinderStreamLoaderTask;", "Lcom/tencent/mm/plugin/datapreloader/FutureTask;", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "initTask", "Lkotlin/Function0;", "parentJob", "Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/Job;Landroidx/lifecycle/LifecycleOwner;)V", "generateDataStore", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "preload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCache", "", "needRecycle", "", "run", "checkCache", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.datapreloader.a<String, aq.d, aq>
{
  public static final a AFf;
  
  static
  {
    AppMethodBeat.i(336613);
    AFf = new a((byte)0);
    AppMethodBeat.o(336613);
  }
  
  private b(kotlin.g.a.a<aq> parama, cb paramcb)
  {
    super(parama, paramcb, null, null, 8);
    AppMethodBeat.i(336602);
    AppMethodBeat.o(336602);
  }
  
  public final Object X(kotlin.d.d<? super aq.d> paramd)
  {
    AppMethodBeat.i(336618);
    Log.i("Finder.FinderStreamLoaderTask", "preload: start");
    paramd = super.X(paramd);
    AppMethodBeat.o(336618);
    return paramd;
  }
  
  public final com.tencent.mm.plugin.datapreloader.a.b<String, aq.d> dtg()
  {
    AppMethodBeat.i(336615);
    com.tencent.mm.plugin.datapreloader.a.b localb = (com.tencent.mm.plugin.datapreloader.a.b)new a((String)getKey());
    AppMethodBeat.o(336615);
    return localb;
  }
  
  public final Object e(boolean paramBoolean, kotlin.d.d<? super aq.d> paramd)
  {
    AppMethodBeat.i(336627);
    if ((paramd instanceof b))
    {
      localObject = (b)paramd;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super aq.d>)localObject;; paramd = new b(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(336627);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    paramd.L$0 = this;
    paramd.YF = paramBoolean;
    paramd.label = 1;
    Object localObject = this;
    if (Y(paramd) == locala)
    {
      AppMethodBeat.o(336627);
      return locala;
      paramBoolean = paramd.YF;
      b localb = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      localObject = localb;
    }
    s.a(s.Fqv, ((aq)((b)localObject).dte()).hJx, true, null, 12);
    if (paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramd.L$0 = null;
      paramd.label = 2;
      localObject = ((com.tencent.mm.plugin.datapreloader.a)localObject).e(paramBoolean, paramd);
      paramd = (kotlin.d.d<? super aq.d>)localObject;
      if (localObject != locala) {
        break;
      }
      AppMethodBeat.o(336627);
      return locala;
    }
    ResultKt.throwOnFailure(localObject);
    paramd = (kotlin.d.d<? super aq.d>)localObject;
    AppMethodBeat.o(336627);
    return paramd;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/loadertask/FinderStreamLoaderTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336611);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.AFg.e(false, (kotlin.d.d)this);
      AppMethodBeat.o(336611);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.loadertask.b
 * JD-Core Version:    0.7.0.1
 */