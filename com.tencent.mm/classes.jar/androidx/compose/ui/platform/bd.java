package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.compose.runtime.aw;
import androidx.compose.runtime.aw.f;
import androidx.compose.runtime.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.android.b;
import kotlinx.coroutines.android.c;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WindowRecomposerPolicy;", "", "()V", "factory", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "compareAndSetFactory", "", "expected", "createAndInstallWindowRecomposer", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;", "createAndInstallWindowRecomposer$ui_release", "getAndSetFactory", "setFactory", "", "withFactory", "R", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/WindowRecomposerFactory;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  public static final int Ue;
  public static final bd aVN;
  private static final AtomicReference<bc> aVO;
  
  static
  {
    AppMethodBeat.i(206848);
    aVN = new bd();
    bc.a locala = bc.aVJ;
    aVO = new AtomicReference(bc.a.zx());
    Ue = 8;
    AppMethodBeat.o(206848);
  }
  
  public static aw y(final View paramView)
  {
    AppMethodBeat.i(206839);
    kotlin.g.b.s.u(paramView, "rootView");
    aw localaw = ((bc)aVO.get()).x(paramView);
    be.a(paramView, (l)localaw);
    aq localaq = (aq)bu.ajwo;
    Handler localHandler = paramView.getHandler();
    kotlin.g.b.s.s(localHandler, "rootView.handler");
    paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new a(j.a(localaq, (f)c.a(localHandler, "windowRecomposer cleanup").kCQ(), null, (m)new b(localaw, paramView, null), 2)));
    AppMethodBeat.o(206839);
    return localaw;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/WindowRecomposerPolicy$createAndInstallWindowRecomposer$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(cb paramcb) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(206617);
      kotlin.g.b.s.u(paramView, "v");
      AppMethodBeat.o(206617);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(206623);
      kotlin.g.b.s.u(paramView, "v");
      paramView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
      this.aVP.a(null);
      AppMethodBeat.o(206623);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(aw paramaw, View paramView, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(206628);
      paramObject = (d)new b(this.aVQ, paramView, paramd);
      AppMethodBeat.o(206628);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(206622);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(206622);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.aVQ;
        Object localObject = (d)this;
        this.label = 1;
        localObject = kotlinx.coroutines.b.s.b((g)paramObject.apf, (m)new aw.f(null), (d)localObject);
        paramObject = localObject;
        if (localObject != a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(206622);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        if (be.z(paramView) == this.aVQ) {
          be.a(paramView, null);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(206622);
        return paramObject;
      }
      finally
      {
        if (be.z(paramView) == this.aVQ) {
          be.a(paramView, null);
        }
        AppMethodBeat.o(206622);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.bd
 * JD-Core Version:    0.7.0.1
 */