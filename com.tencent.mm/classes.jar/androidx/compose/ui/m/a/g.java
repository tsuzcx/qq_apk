package androidx.compose.ui.m.a;

import android.os.Build.VERSION;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  implements j
{
  public final StaticLayout a(l paraml)
  {
    AppMethodBeat.i(205184);
    s.u(paraml, "params");
    StaticLayout.Builder localBuilder = StaticLayout.Builder.obtain(paraml.bba, paraml.start, paraml.end, paraml.bbb, paraml.width);
    localBuilder.setTextDirection(paraml.bbc);
    localBuilder.setAlignment(paraml.bbd);
    localBuilder.setMaxLines(paraml.maxLines);
    localBuilder.setEllipsize(paraml.bbe);
    localBuilder.setEllipsizedWidth(paraml.bbf);
    localBuilder.setLineSpacing(paraml.bbh, paraml.bbg);
    localBuilder.setIncludePad(paraml.bbj);
    localBuilder.setBreakStrategy(paraml.bbl);
    localBuilder.setHyphenationFrequency(paraml.bbm);
    localBuilder.setIndents(paraml.bbn, paraml.bbo);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject = h.baV;
      s.s(localBuilder, "this");
      h.a(localBuilder, paraml.bbi);
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = i.baW;
      s.s(localBuilder, "this");
      i.a(localBuilder, paraml.bbk);
    }
    paraml = localBuilder.build();
    s.s(paraml, "obtain(params.text, para…  }\n            }.build()");
    AppMethodBeat.o(205184);
    return paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.m.a.g
 * JD-Core Version:    0.7.0.1
 */