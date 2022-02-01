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
  private static final int[] afR = { 16843016 };
  private final l akd = new l(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ae(paramContext), paramAttributeSet, paramInt);
    this.akd.a(paramAttributeSet, paramInt);
    this.akd.jo();
    paramContext = az.a(getContext(), paramAttributeSet, afR, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.ayy.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.akd != null) {
      this.akd.jo();
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
    if (this.akd != null) {
      this.akd.u(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */