package androidx.compose.ui.n;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Density", "Landroidx/compose/ui/unit/Density;", "context", "Landroid/content/Context;", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final d W(Context paramContext)
  {
    AppMethodBeat.i(204697);
    s.u(paramContext, "context");
    paramContext = f.H(paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getConfiguration().fontScale);
    AppMethodBeat.o(204697);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.a
 * JD-Core Version:    0.7.0.1
 */