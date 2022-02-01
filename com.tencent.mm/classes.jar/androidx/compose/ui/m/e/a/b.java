package androidx.compose.ui.m.e.a;

import android.os.LocaleList;
import android.text.style.LocaleSpan;
import androidx.compose.ui.m.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b bdV;
  
  static
  {
    AppMethodBeat.i(205388);
    bdV = new b();
    AppMethodBeat.o(205388);
  }
  
  public final Object a(e parame)
  {
    AppMethodBeat.i(205405);
    s.u(parame, "localeList");
    Object localObject = (Iterable)parame;
    parame = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parame.add(a.a((androidx.compose.ui.m.d.d)((Iterator)localObject).next()));
    }
    parame = ((Collection)parame).toArray(new Locale[0]);
    if (parame == null)
    {
      parame = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(205405);
      throw parame;
    }
    parame = (Locale[])parame;
    parame = new LocaleSpan(new LocaleList((Locale[])Arrays.copyOf(parame, parame.length)));
    AppMethodBeat.o(205405);
    return parame;
  }
  
  public final void a(androidx.compose.ui.m.e.d paramd, e parame)
  {
    AppMethodBeat.i(205414);
    s.u(paramd, "textPaint");
    s.u(parame, "localeList");
    Object localObject = (Iterable)parame;
    parame = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parame.add(a.a((androidx.compose.ui.m.d.d)((Iterator)localObject).next()));
    }
    parame = ((Collection)parame).toArray(new Locale[0]);
    if (parame == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(205414);
      throw paramd;
    }
    parame = (Locale[])parame;
    paramd.setTextLocales(new LocaleList((Locale[])Arrays.copyOf(parame, parame.length)));
    AppMethodBeat.o(205414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.a.b
 * JD-Core Version:    0.7.0.1
 */