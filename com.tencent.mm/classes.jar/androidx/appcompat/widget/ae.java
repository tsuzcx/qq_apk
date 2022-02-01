package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242432);
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      AppMethodBeat.o(242432);
      return;
    }
    af.a(paramView, paramCharSequence);
    AppMethodBeat.o(242432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ae
 * JD-Core Version:    0.7.0.1
 */