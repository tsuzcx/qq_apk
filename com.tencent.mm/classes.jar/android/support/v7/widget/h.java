package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

final class h
{
  static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null)) {}
    for (paramView = paramView.getParent();; paramView = paramView.getParent()) {
      if ((paramView instanceof View))
      {
        if ((paramView instanceof bi)) {
          paramEditorInfo.hintText = ((bi)paramView).getHint();
        }
      }
      else {
        return paramInputConnection;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.h
 * JD-Core Version:    0.7.0.1
 */