package androidx.compose.ui.platform;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/platform/ClipboardManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clipboardManager", "Landroid/content/ClipboardManager;", "convertAnnotatedStringToCharSequence", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "convertCharSequenceToAnnotatedString", "charSequence", "getText", "hasText", "", "setText", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements s
{
  final ClipboardManager aQR;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(206874);
    paramContext = paramContext.getSystemService("clipboard");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(206874);
      throw paramContext;
    }
    this.aQR = ((ClipboardManager)paramContext);
    AppMethodBeat.o(206874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.e
 * JD-Core Version:    0.7.0.1
 */