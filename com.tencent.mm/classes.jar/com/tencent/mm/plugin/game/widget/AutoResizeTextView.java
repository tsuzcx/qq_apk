package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoResizeTextView
  extends TextView
  implements a.b
{
  private a twA;
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42558);
    i(paramAttributeSet);
    AppMethodBeat.o(42558);
  }
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42559);
    i(paramAttributeSet);
    AppMethodBeat.o(42559);
  }
  
  private void i(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(42560);
    this.twA = a.a(this, paramAttributeSet).a(this);
    AppMethodBeat.o(42560);
  }
  
  public a getAutofitHelper()
  {
    return this.twA;
  }
  
  public float getMaxTextSize()
  {
    return this.twA.twF;
  }
  
  public float getMinTextSize()
  {
    return this.twA.twE;
  }
  
  public float getPrecision()
  {
    return this.twA.twG;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42561);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.twA != null) {
      this.twA.cRN();
    }
    AppMethodBeat.o(42561);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(42563);
    super.setLines(paramInt);
    if (this.twA != null) {
      this.twA.GK(paramInt);
    }
    AppMethodBeat.o(42563);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(42564);
    super.setMaxLines(paramInt);
    if (this.twA != null) {
      this.twA.GK(paramInt);
    }
    AppMethodBeat.o(42564);
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    AppMethodBeat.i(42566);
    a locala = this.twA;
    Context localContext = locala.Up.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(2, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != locala.twF)
    {
      locala.twF = paramFloat;
      locala.cRN();
    }
    AppMethodBeat.o(42566);
  }
  
  public void setMinTextSize(int paramInt)
  {
    AppMethodBeat.i(42567);
    this.twA.p(2, paramInt);
    AppMethodBeat.o(42567);
  }
  
  public void setPrecision(float paramFloat)
  {
    AppMethodBeat.i(42568);
    this.twA.bc(paramFloat);
    AppMethodBeat.o(42568);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    AppMethodBeat.i(42565);
    this.twA.mT(paramBoolean);
    AppMethodBeat.o(42565);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(42562);
    super.setTextSize(paramInt, paramFloat);
    if (this.twA != null)
    {
      a locala = this.twA;
      if (!locala.twH)
      {
        Context localContext = locala.Up.getContext();
        Resources localResources = Resources.getSystem();
        if (localContext != null) {
          localResources = localContext.getResources();
        }
        locala.setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      }
    }
    AppMethodBeat.o(42562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoResizeTextView
 * JD-Core Version:    0.7.0.1
 */