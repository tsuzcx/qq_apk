package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatRadioButton
  extends RadioButton
  implements j
{
  private final k mTextHelper;
  private final e qt;
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.radioButtonStyle);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240938);
    this.qt = new e(this);
    this.qt.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240938);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(240943);
    int i = super.getCompoundPaddingLeft();
    if (this.qt != null)
    {
      i = this.qt.as(i);
      AppMethodBeat.o(240943);
      return i;
    }
    AppMethodBeat.o(240943);
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
    AppMethodBeat.i(240942);
    setButtonDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(240942);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240941);
    super.setButtonDrawable(paramDrawable);
    if (this.qt != null) {
      this.qt.jdMethod_do();
    }
    AppMethodBeat.o(240941);
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240944);
    if (this.qt != null) {
      this.qt.setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(240944);
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240945);
    if (this.qt != null) {
      this.qt.setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(240945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatRadioButton
 * JD-Core Version:    0.7.0.1
 */