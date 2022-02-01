package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.ui.m.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements c.a
{
  private final Context context;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(206888);
    this.context = paramContext;
    AppMethodBeat.o(206888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.k
 * JD-Core Version:    0.7.0.1
 */