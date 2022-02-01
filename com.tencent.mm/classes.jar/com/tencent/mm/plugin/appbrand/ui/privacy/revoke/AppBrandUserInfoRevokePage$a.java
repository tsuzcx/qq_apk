package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$Companion;", "", "()V", "INTENT_KEY_APP_ID", "", "start", "", "srcActivity", "Landroidx/appcompat/app/AppCompatActivity;", "appId", "dstActivityClass", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandUserInfoRevokePage$a
{
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(String paramString, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(322882);
      paramObject = (d)new a(this.eug, paramd);
      AppMethodBeat.o(322882);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322873);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322873);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = j.ukr;
        String str = this.eug;
        d locald = (d)this;
        this.label = 1;
        paramObject = paramObject.i(str, locald);
        if (paramObject != locala) {
          break label101;
        }
        AppMethodBeat.o(322873);
        return locala;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          label101:
          Log.w("MicroMsg.AppBrandUserInfoRevokePage", s.X("start, getUsageInfo fail since ", paramObject));
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(322873);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.AppBrandUserInfoRevokePage.a
 * JD-Core Version:    0.7.0.1
 */