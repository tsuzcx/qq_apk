package com.tencent.kinda.framework.widget.base;

import android.widget.LinearLayout;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KPayEditText;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.PayEditState;
import com.tencent.kinda.gen.TextAlign;

public class KindaPayEditTextImpl
  extends MMKView<LinearLayout>
  implements KPayEditText
{
  public String encryptWith3Des()
  {
    return "";
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return null;
  }
  
  public PayEditState getEditState()
  {
    return null;
  }
  
  public boolean getEnabled()
  {
    return false;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public String getHint()
  {
    return null;
  }
  
  public long getHintColor()
  {
    return 0L;
  }
  
  public String getInputText()
  {
    return null;
  }
  
  public KeyboardType getKeyboardType()
  {
    return null;
  }
  
  public int getMaxLength()
  {
    return 0;
  }
  
  public String getSalt()
  {
    return null;
  }
  
  public int getSelection()
  {
    return 0;
  }
  
  public String getText()
  {
    return null;
  }
  
  public TextAlign getTextAlign()
  {
    return null;
  }
  
  public long getTextColor()
  {
    return 0L;
  }
  
  public String getTextFont()
  {
    return null;
  }
  
  public float getTextSize()
  {
    return 0.0F;
  }
  
  public long getTintColor()
  {
    return 0L;
  }
  
  public void setClearButtonMode(ClearButtonMode paramClearButtonMode) {}
  
  public void setEditState(PayEditState paramPayEditState) {}
  
  public void setEnabled(boolean paramBoolean) {}
  
  public void setFocus(boolean paramBoolean) {}
  
  public void setHint(String paramString) {}
  
  public void setHintColor(long paramLong) {}
  
  public void setKeyboardType(KeyboardType paramKeyboardType) {}
  
  public void setMaxLength(int paramInt) {}
  
  public void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback paramKEditTextOnTextBeginChangeCallback) {}
  
  public void setOnTextChangedCallback(KEditTextOnTextChangedCallback paramKEditTextOnTextChangedCallback) {}
  
  public void setSalt(String paramString) {}
  
  public void setSelection(int paramInt) {}
  
  public void setText(String paramString) {}
  
  public void setTextAlign(TextAlign paramTextAlign) {}
  
  public void setTextColor(long paramLong) {}
  
  public void setTextFont(String paramString) {}
  
  public void setTextSize(float paramFloat) {}
  
  public void setTintColor(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPayEditTextImpl
 * JD-Core Version:    0.7.0.1
 */