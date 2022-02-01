package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.core.widget.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatCheckBox
  extends CheckBox
  implements k
{
  private final e rp;
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(200303);
    this.rp = new e(this);
    this.rp.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(200303);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(200337);
    int i = super.getCompoundPaddingLeft();
    if (this.rp != null)
    {
      i = this.rp.aq(i);
      AppMethodBeat.o(200337);
      return i;
    }
    AppMethodBeat.o(200337);
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
    AppMethodBeat.i(200330);
    setButtonDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(200330);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200323);
    super.setButtonDrawable(paramDrawable);
    if (this.rp != null) {
      this.rp.en();
    }
    AppMethodBeat.o(200323);
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200344);
    if (this.rp != null) {
      this.rp.setSupportButtonTintList(paramColorStateList);
    }
    AppMethodBeat.o(200344);
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200364);
    if (this.rp != null) {
      this.rp.setSupportButtonTintMode(paramMode);
    }
    AppMethodBeat.o(200364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */