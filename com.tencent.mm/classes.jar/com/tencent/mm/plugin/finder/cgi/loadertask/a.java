package com.tencent.mm.plugin.finder.cgi.loadertask;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datapreloader.a.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Lcom.tencent.mm.plugin.finder.cgi.aq.d;>;
import kotlin.g.b.s;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/loadertask/FinderStreamDataCache;", "Lcom/tencent/mm/plugin/datapreloader/cache/SimpleDataCache;", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "key", "(Ljava/lang/String;)V", "requestCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<String, aq.d>
{
  public a(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(336592);
    AppMethodBeat.o(336592);
  }
  
  public final Object aa(kotlin.d.d<? super aq.d> paramd)
  {
    AppMethodBeat.i(336605);
    if ((paramd instanceof a.a))
    {
      localObject1 = (a.a)paramd;
      if ((((a.a)localObject1).label & 0x80000000) != 0) {
        ((a.a)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super aq.d>)localObject1;; paramd = new a.a(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(336605);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    long l = SystemClock.uptimeMillis();
    Log.i("Finder.FinderStreamLoaderTask", "requestCache: start");
    paramd.Yx = l;
    paramd.label = 1;
    Object localObject2 = super.aa(paramd);
    Object localObject1 = localObject2;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(336605);
      return locala;
      l = paramd.Yx;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject2 = (aq.d)localObject1;
    Log.i("Finder.FinderStreamLoaderTask", s.X("requestCache: value = ", localObject2));
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - (SystemClock.uptimeMillis() - l);
      Log.i("Finder.FinderStreamLoaderTask", s.X("requestCache: loading delay = ", kotlin.d.b.a.b.BF(l)));
      localObject1 = localObject2;
      if (l > 0L)
      {
        paramd.L$0 = localObject2;
        paramd.label = 2;
        localObject1 = localObject2;
        if (bb.e(l, paramd) == locala)
        {
          AppMethodBeat.o(336605);
          return locala;
          paramd = (aq.d)paramd.L$0;
          ResultKt.throwOnFailure(localObject1);
          localObject1 = paramd;
        }
      }
    }
    AppMethodBeat.o(336605);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.loadertask.a
 * JD-Core Version:    0.7.0.1
 */