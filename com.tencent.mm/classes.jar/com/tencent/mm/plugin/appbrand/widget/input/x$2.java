package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.mm.sdk.platformtools.ah;

final class x$2
  extends InputConnectionWrapper
{
  x$2(x paramx, InputConnection paramInputConnection)
  {
    super(paramInputConnection, false);
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.hvy.hvx = paramCharSequence.charAt(paramCharSequence.length() - 1);
    }
    return super.commitText(paramCharSequence, paramInt);
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    this.hvy.hvx = '\b';
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
  
  public final boolean finishComposingText()
  {
    boolean bool = super.finishComposingText();
    y localy = x.a(this.hvy);
    localy.hcZ.removeCallbacks(localy.hvG);
    localy.hvG.run();
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.hvy.hvx = paramCharSequence.charAt(paramCharSequence.length() - 1);
    }
    return super.setComposingText(paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x.2
 * JD-Core Version:    0.7.0.1
 */