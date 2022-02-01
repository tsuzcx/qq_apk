package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.core.g.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatMultiAutoCompleteTextView
  extends MultiAutoCompleteTextView
  implements x
{
  private static final int[] na = { 16843126 };
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(200194);
    paramContext = ac.a(getContext(), paramAttributeSet, na, paramInt, 0);
    if (paramContext.az(0)) {
      setDropDownBackgroundDrawable(paramContext.getDrawable(0));
    }
    paramContext.xv.recycle();
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.et();
    AppMethodBeat.o(200194);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200247);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.et();
    }
    AppMethodBeat.o(200247);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(200226);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(200226);
      return localColorStateList;
    }
    AppMethodBeat.o(200226);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(200240);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(200240);
      return localMode;
    }
    AppMethodBeat.o(200240);
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(200260);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(200260);
    return paramEditorInfo;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200214);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(200214);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(200208);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(200208);
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(200204);
    setDropDownBackgroundDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(200204);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200219);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(200219);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200233);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(200233);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200253);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(200253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */