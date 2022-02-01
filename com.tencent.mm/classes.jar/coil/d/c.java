package coil.d;

import android.content.Context;
import androidx.compose.runtime.as;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.j;
import coil.a;
import coil.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/compose/ImageLoaderProvidableCompositionLocal;", "", "delegate", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil/ImageLoader;", "constructor-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "current", "getCurrent", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Landroidx/compose/runtime/Composer;I)Lcoil/ImageLoader;", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;)I", "provides", "Landroidx/compose/runtime/ProvidedValue;", "value", "provides-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Lcoil/ImageLoader;)Landroidx/compose/runtime/ProvidedValue;", "providesDefault", "providesDefault-impl", "toString", "", "toString-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;)Ljava/lang/String;", "coil-compose-singleton_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final d a(as<d> paramas, h paramh)
  {
    AppMethodBeat.i(188023);
    s.u(paramas, "arg0");
    paramh.bx(380256078);
    paramas = (d)paramh.a((p)paramas);
    if (paramas == null)
    {
      paramh.bx(380256127);
      paramas = a.aw((Context)paramh.a((p)j.yJ()));
      paramh.od();
    }
    for (;;)
    {
      paramh.od();
      AppMethodBeat.o(188023);
      return paramas;
      paramh.bx(380256086);
      paramh.od();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d.c
 * JD-Core Version:    0.7.0.1
 */