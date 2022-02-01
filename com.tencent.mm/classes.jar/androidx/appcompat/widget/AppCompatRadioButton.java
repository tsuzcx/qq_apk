package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatRadioButton
  extends RadioButton
  implements androidx.core.widget.k
{
  private final k mTextHelper;
  private final e rp;
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.radioButtonStyle);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(199351);
    this.rp = new e(this);
    this.rp.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(199351);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(199374);
    int i = super.getCompoundPaddingLeft();
    if (this.rp != null)
    {
      i = this.rp.aq(i);
      AppMethodBeat.o(199374);
      return i;
    }
    AppMethodBeat.o(199374);
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    if (this.rp != null) {
      return this.rp.rs;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    if (this.rp != null) {
      return this.rp.rt;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    AppMethodBeat.i(199368);
    setButtonDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(199368);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199360);
    super.setButtonDrawable(paramDrawable);
    if (this.rp != null) {
      this.rp.en();
    }
    AppMethodBeat.o(199360);
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199384);
    if (this.rp != null) {
      this.rp.setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(199384);
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199400);
    if (this.rp != null) {
      this.rp.setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(199400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatRadioButton
 * JD-Core Version:    0.7.0.1
 */