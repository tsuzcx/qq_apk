package androidx.compose.ui.platform;

import androidx.compose.runtime.ai;
import androidx.compose.runtime.al;
import androidx.compose.runtime.am;
import androidx.compose.runtime.aw;
import androidx.compose.runtime.aw.i;
import androidx.compose.runtime.aw.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.as;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2
  implements o
{
  WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2(kotlinx.coroutines.aq paramaq, androidx.compose.runtime.aq paramaq1, aw paramaw) {}
  
  public final void onStateChanged(androidx.lifecycle.q arg1, j.a parama)
  {
    AppMethodBeat.i(206614);
    s.u(???, "lifecycleOwner");
    s.u(parama, "event");
    Object localObject;
    switch (a.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        AppMethodBeat.o(206614);
        return;
        kotlinx.coroutines.j.a(this.aVU, null, as.ajvN, (m)new b(this.aVT, ???, this, null), 1);
        AppMethodBeat.o(206614);
        return;
        ??? = this.aVV;
      } while (??? == null);
      localObject = ???.aoy;
    }
    for (;;)
    {
      int j;
      synchronized (((ai)localObject).lock)
      {
        boolean bool = ((ai)localObject).isOpen();
        if (bool)
        {
          AppMethodBeat.o(206614);
          return;
        }
        parama = ((ai)localObject).alt;
        ((ai)localObject).alt = ((ai)localObject).alu;
        ((ai)localObject).alu = parama;
        ((ai)localObject).aop = true;
        i = 0;
        int k = parama.size();
        if (k > 0)
        {
          j = i + 1;
          localObject = (d)parama.get(i);
          ah localah = ah.aiuX;
          Result.Companion localCompanion = Result.Companion;
          ((d)localObject).resumeWith(Result.constructor-impl(localah));
          if (j < k) {
            break label287;
          }
        }
        parama.clear();
        parama = ah.aiuX;
        AppMethodBeat.o(206614);
        return;
      }
      ??? = this.aVV;
      if (??? == null) {
        break;
      }
      ???.pause();
      AppMethodBeat.o(206614);
      return;
      this.aVT.cancel();
      break;
      label287:
      int i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<kotlinx.coroutines.aq, d<? super ah>, Object>
  {
    int label;
    
    b(aw paramaw, androidx.lifecycle.q paramq, WindowRecomposer_androidKt.createLifecycleAwareViewTreeRecomposer.2 param2, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(206667);
      paramObject = (d)new b(this.aVT, paramq, jdField_this, paramd);
      AppMethodBeat.o(206667);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(206664);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(206664);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.aVT;
        Object localObject = (d)this;
        this.label = 1;
        kotlin.g.a.q localq = (kotlin.g.a.q)new aw.j(paramObject, null);
        al localal = am.a(((d)localObject).getContext());
        localObject = l.a((f)paramObject.aoT, (m)new aw.i(paramObject, localq, localal, null), (d)localObject);
        paramObject = localObject;
        if (localObject != a.aiwj) {
          paramObject = ah.aiuX;
        }
        localObject = paramObject;
        if (paramObject != a.aiwj) {
          localObject = ah.aiuX;
        }
        if (localObject == locala)
        {
          AppMethodBeat.o(206664);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramq.getLifecycle().removeObserver((p)jdField_this);
        paramObject = ah.aiuX;
        AppMethodBeat.o(206664);
        return paramObject;
      }
      finally
      {
        paramq.getLifecycle().removeObserver((p)jdField_this);
        AppMethodBeat.o(206664);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.WindowRecomposer_androidKt.createLifecycleAwareViewTreeRecomposer.2
 * JD-Core Version:    0.7.0.1
 */