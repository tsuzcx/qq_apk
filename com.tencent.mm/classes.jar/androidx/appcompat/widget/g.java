package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
{
  static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    AppMethodBeat.i(240823);
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null)) {}
    for (paramView = paramView.getParent();; paramView = paramView.getParent()) {
      if ((paramView instanceof View))
      {
        if ((paramView instanceof aj)) {
          paramEditorInfo.hintText = ((aj)paramView).getHint();
        }
      }
      else
      {
        AppMethodBeat.o(240823);
        return paramInputConnection;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.g
 * JD-Core Version:    0.7.0.1
 */