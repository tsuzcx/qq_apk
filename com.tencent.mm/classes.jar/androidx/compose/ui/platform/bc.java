package androidx.compose.ui.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.compose.runtime.aw;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.d.g;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WindowRecomposerFactory;", "", "createRecomposer", "Landroidx/compose/runtime/Recomposer;", "windowRootView", "Landroid/view/View;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bc
{
  public static final a aVJ = a.aVK;
  
  public abstract aw x(View paramView);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WindowRecomposerFactory$Companion;", "", "()V", "LifecycleAware", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getLifecycleAware", "()Landroidx/compose/ui/platform/WindowRecomposerFactory;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final bc aVL;
    
    static
    {
      AppMethodBeat.i(206926);
      aVK = new a();
      aVL = (bc)a.aVM;
      AppMethodBeat.o(206926);
    }
    
    public static bc zx()
    {
      return aVL;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements bc
    {
      public static final a aVM;
      
      static
      {
        AppMethodBeat.i(206754);
        aVM = new a();
        AppMethodBeat.o(206754);
      }
      
      public final aw x(View paramView)
      {
        AppMethodBeat.i(206761);
        s.u(paramView, "rootView");
        Object localObject1 = m.aTa;
        Object localObject2;
        if (n.isMainThread())
        {
          localObject2 = m.a.yP();
          localObject1 = (androidx.compose.runtime.al)((f)localObject2).get((f.c)androidx.compose.runtime.al.aot);
          if (localObject1 != null) {
            break label164;
          }
          localObject1 = null;
          label47:
          if (localObject1 != null) {
            break label180;
          }
        }
        q localq;
        label164:
        label180:
        for (Object localObject3 = (f)g.aiwf;; localObject3 = (f)localObject1)
        {
          localObject3 = ((f)localObject2).plus((f)localObject3);
          localObject2 = new aw((f)localObject3);
          localObject3 = ar.d((f)localObject3);
          localq = androidx.lifecycle.al.be(paramView);
          if (localq != null) {
            break label189;
          }
          paramView = (Throwable)new IllegalStateException(s.X("ViewTreeLifecycleOwner not found from ", paramView).toString());
          AppMethodBeat.o(206761);
          throw paramView;
          localObject2 = (f)m.yO().get();
          if (localObject2 == null)
          {
            paramView = (Throwable)new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
            AppMethodBeat.o(206761);
            throw paramView;
          }
          break;
          localObject1 = new androidx.compose.runtime.aq((androidx.compose.runtime.al)localObject1);
          ((androidx.compose.runtime.aq)localObject1).pause();
          break label47;
        }
        label189:
        paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new be.a(paramView, (aw)localObject2));
        localq.getLifecycle().addObserver((p)new WindowRecomposer_androidKt.createLifecycleAwareViewTreeRecomposer.2((kotlinx.coroutines.aq)localObject3, (androidx.compose.runtime.aq)localObject1, (aw)localObject2));
        AppMethodBeat.o(206761);
        return localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.bc
 * JD-Core Version:    0.7.0.1
 */