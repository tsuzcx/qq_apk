package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ec;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDaWangReporter;", "", "()V", "IOS_NET_TYPE_5G", "", "TAG", "", "report24022", "", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g Foo;
  
  static
  {
    AppMethodBeat.i(331425);
    Foo = new g();
    AppMethodBeat.o(331425);
  }
  
  public static void gN(Context paramContext)
  {
    AppMethodBeat.i(331422);
    s.u(paramContext, "context");
    j.a(ar.d((f)bg.kCi()), null, null, (m)new a(paramContext, null), 3);
    AppMethodBeat.o(331422);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(Context paramContext, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(331459);
      paramObject = (d)new a(this.$context, paramd);
      AppMethodBeat.o(331459);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(331452);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(331452);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      int i = ((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class)).gbv();
      long l1;
      if (i == 3)
      {
        l1 = 1L;
        if (!NetStatusUtil.is5G(this.$context)) {
          break label162;
        }
      }
      label162:
      for (long l2 = 5L;; l2 = NetStatusUtil.getIOSNetType(this.$context))
      {
        paramObject = new ec();
        paramObject.iBW = l1;
        paramObject.iBX = l2;
        paramObject.bMH();
        Log.i("FinderDaWangReporter", "[report24022] simType:" + i + ", info:" + paramObject.aIF());
        paramObject = ah.aiuX;
        AppMethodBeat.o(331452);
        return paramObject;
        l1 = 0L;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */