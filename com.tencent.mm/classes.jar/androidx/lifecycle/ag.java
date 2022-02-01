package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.cx;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"JOB_KEY", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel-ktx_release"}, k=2, mv={1, 4, 1})
public final class ag
{
  public static final aq b(af paramaf)
  {
    AppMethodBeat.i(194439);
    s.u(paramaf, "$this$viewModelScope");
    aq localaq = (aq)paramaf.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
    if (localaq != null)
    {
      AppMethodBeat.o(194439);
      return localaq;
    }
    paramaf = paramaf.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new c(cx.g(null).plus((f)bg.kCh().kCK())));
    s.s(paramaf, "setTagIfAbsent(\n        …Main.immediate)\n        )");
    paramaf = (aq)paramaf;
    AppMethodBeat.o(194439);
    return paramaf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ag
 * JD-Core Version:    0.7.0.1
 */