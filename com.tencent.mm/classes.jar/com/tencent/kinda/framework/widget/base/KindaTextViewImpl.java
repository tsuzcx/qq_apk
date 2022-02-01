package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KindaTextViewImpl
  extends TextView
{
  private static final String TAG = "KindaButtonImpl";
  private boolean hasLastPressed = false;
  private KindaButtonImpl mKindaButton;
  
  public KindaTextViewImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public KindaTextViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KindaTextViewImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(18972);
    if ((this.mKindaButton.isEnabled()) || (this.mKindaButton.isKindaPressed()) || (this.hasLastPressed))
    {
      super.drawableStateChanged();
      this.hasLastPressed = this.mKindaButton.isKindaPressed();
    }
    AppMethodBeat.o(18972);
  }
  
  public void setKindaButton(KindaButtonImpl paramKindaButtonImpl)
  {
    this.mKindaButton = paramKindaButtonImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaTextViewImpl
 * JD-Core Version:    0.7.0.1
 */