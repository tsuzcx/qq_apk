package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.core.g.x;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatAutoCompleteTextView
  extends AutoCompleteTextView
  implements x
{
  private static final int[] na = { 16843126 };
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
  }
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(199473);
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
    AppMethodBeat.o(199473);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(199575);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.et();
    }
    AppMethodBeat.o(199575);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(199543);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(199543);
      return localColorStateList;
    }
    AppMethodBeat.o(199543);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(199562);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(199562);
      return localMode;
    }
    AppMethodBeat.o(199562);
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(199596);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(199596);
    return paramEditorInfo;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199517);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(199517);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(199504);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(199504);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(199611);
    super.setCustomSelectionActionModeCallback(j.a(this, paramCallback));
    AppMethodBeat.o(199611);
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(199491);
    setDropDownBackgroundDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(199491);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199529);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(199529);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199554);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(199554);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199585);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(199585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */