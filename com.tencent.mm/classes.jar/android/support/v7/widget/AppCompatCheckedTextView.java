package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.q;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] afE = { 16843016 };
  private final l ajQ = new l(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.ajQ.a(paramAttributeSet, paramInt);
    this.ajQ.jf();
    paramContext = az.a(getContext(), paramAttributeSet, afE, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.ayA.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ajQ != null) {
      this.ajQ.jf();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.l(getContext(), paramInt));
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ajQ != null) {
      this.ajQ.u(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */