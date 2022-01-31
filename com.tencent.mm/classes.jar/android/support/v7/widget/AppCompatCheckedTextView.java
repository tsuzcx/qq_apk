package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] Vb = { 16843016 };
  private final m Zp = m.d(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(au.V(paramContext), paramAttributeSet, paramInt);
    this.Zp.b(paramAttributeSet, paramInt);
    this.Zp.gm();
    paramContext = ax.a(getContext(), paramAttributeSet, Vb, paramInt, 0);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.alZ.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Zp != null) {
      this.Zp.gm();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return i.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(b.g(getContext(), paramInt));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.Zp != null) {
      this.Zp.p(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */