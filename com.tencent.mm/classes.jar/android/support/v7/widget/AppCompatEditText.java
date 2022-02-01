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
  private final e ajP = new e(this);
  private final l ajQ;
  
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
    super(aw.ad(paramContext), paramAttributeSet, paramInt);
    this.ajP.a(paramAttributeSet, paramInt);
    this.ajQ = new l(this);
    this.ajQ.a(paramAttributeSet, paramInt);
    this.ajQ.jf();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ajP != null) {
      this.ajP.iX();
    }
    if (this.ajQ != null) {
      this.ajQ.jf();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.ajP != null) {
      return this.ajP.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ajP != null) {
      return this.ajP.getSupportBackgroundTintMode();
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
    if (this.ajP != null) {
      this.ajP.iW();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ajP != null) {
      this.ajP.bG(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ajP != null) {
      this.ajP.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ajP != null) {
      this.ajP.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ajQ != null) {
      this.ajQ.u(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatEditText
 * JD-Core Version:    0.7.0.1
 */