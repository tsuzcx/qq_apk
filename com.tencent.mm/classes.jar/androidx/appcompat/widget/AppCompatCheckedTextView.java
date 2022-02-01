package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.a.a.a;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] na = { 16843016 };
  private final k mTextHelper;
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(200105);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.et();
    paramContext = ac.a(getContext(), paramAttributeSet, na, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.xv.recycle();
    AppMethodBeat.o(200105);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200150);
    super.drawableStateChanged();
    if (this.mTextHelper != null) {
      this.mTextHelper.et();
    }
    AppMethodBeat.o(200150);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(200164);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(200164);
    return paramEditorInfo;
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    AppMethodBeat.i(200128);
    setCheckMarkDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(200128);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(200176);
    super.setCustomSelectionActionModeCallback(j.a(this, paramCallback));
    AppMethodBeat.o(200176);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200139);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(200139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */