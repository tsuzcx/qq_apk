package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.support.v4.widget.q;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class AppCompatEditText
  extends EditText
  implements s
{
  private final e ahY = new e(this);
  private final l ahZ;
  
  public AppCompatEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968945);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.ahY.a(paramAttributeSet, paramInt);
    this.ahZ = new l(this);
    this.ahZ.a(paramAttributeSet, paramInt);
    this.ahZ.iP();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ahY != null) {
      this.ahY.iH();
    }
    if (this.ahZ != null) {
      this.ahZ.iP();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.ahY != null) {
      return this.ahY.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ahY != null) {
      return this.ahY.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public Editable getText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return super.getText();
    }
    return super.getEditableText();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.ahY != null) {
      this.ahY.iG();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ahY != null) {
      this.ahY.bG(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ahY != null) {
      this.ahY.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ahY != null) {
      this.ahY.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ahZ != null) {
      this.ahZ.u(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatEditText
 * JD-Core Version:    0.7.0.1
 */