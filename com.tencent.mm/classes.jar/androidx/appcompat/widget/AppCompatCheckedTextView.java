package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.a.a.a;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] mb = { 16843016 };
  private final k mTextHelper;
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240720);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.du();
    paramContext = ac.a(getContext(), paramAttributeSet, mb, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.wA.recycle();
    AppMethodBeat.o(240720);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240724);
    super.drawableStateChanged();
    if (this.mTextHelper != null) {
      this.mTextHelper.du();
    }
    AppMethodBeat.o(240724);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(240725);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(240725);
    return paramEditorInfo;
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    AppMethodBeat.i(240722);
    setCheckMarkDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(240722);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(240726);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(240726);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(240723);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(240723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */