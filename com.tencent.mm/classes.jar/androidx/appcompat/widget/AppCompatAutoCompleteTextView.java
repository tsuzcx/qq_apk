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
import androidx.core.g.u;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatAutoCompleteTextView
  extends AutoCompleteTextView
  implements u
{
  private static final int[] mb = { 16843126 };
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
  }
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240652);
    paramContext = ac.a(getContext(), paramAttributeSet, mb, paramInt, 0);
    if (paramContext.aC(0)) {
      setDropDownBackgroundDrawable(paramContext.getDrawable(0));
    }
    paramContext.wA.recycle();
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.du();
    AppMethodBeat.o(240652);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240662);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.du();
    }
    AppMethodBeat.o(240662);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(240659);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(240659);
      return localColorStateList;
    }
    AppMethodBeat.o(240659);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(240661);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(240661);
      return localMode;
    }
    AppMethodBeat.o(240661);
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(240664);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(240664);
    return paramEditorInfo;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240657);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(240657);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240656);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(240656);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(240665);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(240665);
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240654);
    setDropDownBackgroundDrawable(a.m(getContext(), paramInt));
    AppMethodBeat.o(240654);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240658);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(240658);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240660);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(240660);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(240663);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(240663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */