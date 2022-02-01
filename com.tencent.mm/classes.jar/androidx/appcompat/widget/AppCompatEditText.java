package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.a.a;
import androidx.core.g.u;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatEditText
  extends EditText
  implements u
{
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  
  public AppCompatEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.editTextStyle);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240802);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.du();
    AppMethodBeat.o(240802);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240814);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.du();
    }
    AppMethodBeat.o(240814);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(240809);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(240809);
      return localColorStateList;
    }
    AppMethodBeat.o(240809);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(240811);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(240811);
      return localMode;
    }
    AppMethodBeat.o(240811);
    return null;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(240803);
    if (Build.VERSION.SDK_INT >= 28)
    {
      localEditable = super.getText();
      AppMethodBeat.o(240803);
      return localEditable;
    }
    Editable localEditable = super.getEditableText();
    AppMethodBeat.o(240803);
    return localEditable;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(240817);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(240817);
    return paramEditorInfo;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240805);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(240805);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240804);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(240804);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(240819);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(240819);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240807);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(240807);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240810);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(240810);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(240816);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(240816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatEditText
 * JD-Core Version:    0.7.0.1
 */