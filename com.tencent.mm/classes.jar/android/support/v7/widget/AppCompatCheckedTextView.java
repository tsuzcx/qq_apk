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
  private static final int[] VO = { 16843016 };
  private final l aaa = new l(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.Z(paramContext), paramAttributeSet, paramInt);
    this.aaa.a(paramAttributeSet, paramInt);
    this.aaa.hk();
    paramContext = az.a(getContext(), paramAttributeSet, VO, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.aoo.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.aaa != null) {
      this.aaa.hk();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.k(getContext(), paramInt));
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.aaa != null) {
      this.aaa.t(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */