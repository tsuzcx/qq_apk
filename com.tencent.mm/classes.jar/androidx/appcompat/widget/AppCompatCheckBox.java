package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatCheckBox
  extends CheckBox
  implements j
{
  private final e qt;
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240713);
    this.qt = new e(this);
    this.qt.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240713);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(240716);
    int i = super.getCompoundPaddingLeft();
    if (this.qt != null)
    {
      i = this.qt.as(i);
      AppMethodBeat.o(240716);
      return i;
    }
    AppMethodBeat.o(240716);
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    if (this.qt != null) {
      return this.qt.qv;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    if (this.qt != null) {
      return this.qt.qw;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    AppMethodBeat.i(240715);
    setButtonDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(240715);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240714);
    super.setButtonDrawable(paramDrawable);
    if (this.qt != null) {
      this.qt.jdMethod_do();
    }
    AppMethodBeat.o(240714);
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240717);
    if (this.qt != null) {
      this.qt.setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(240717);
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240718);
    if (this.qt != null) {
      this.qt.setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(240718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */