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
  private a uvM;
  
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
    this.uvM = a.a(this, paramAttributeSet).a(this);
    AppMethodBeat.o(42560);
  }
  
  public a getAutofitHelper()
  {
    return this.uvM;
  }
  
  public float getMaxTextSize()
  {
    return this.uvM.uvR;
  }
  
  public float getMinTextSize()
  {
    return this.uvM.uvQ;
  }
  
  public float getPrecision()
  {
    return this.uvM.uvS;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42561);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.uvM != null) {
      this.uvM.dax();
    }
    AppMethodBeat.o(42561);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(42563);
    super.setLines(paramInt);
    if (this.uvM != null) {
      this.uvM.Id(paramInt);
    }
    AppMethodBeat.o(42563);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(42564);
    super.setMaxLines(paramInt);
    if (this.uvM != null) {
      this.uvM.Id(paramInt);
    }
    AppMethodBeat.o(42564);
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    AppMethodBeat.i(42566);
    a locala = this.uvM;
    Context localContext = locala.Wf.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(2, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != locala.uvR)
    {
      locala.uvR = paramFloat;
      locala.dax();
    }
    AppMethodBeat.o(42566);
  }
  
  public void setMinTextSize(int paramInt)
  {
    AppMethodBeat.i(42567);
    this.uvM.q(2, paramInt);
    AppMethodBeat.o(42567);
  }
  
  public void setPrecision(float paramFloat)
  {
    AppMethodBeat.i(42568);
    this.uvM.bf(paramFloat);
    AppMethodBeat.o(42568);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    AppMethodBeat.i(42565);
    this.uvM.nn(paramBoolean);
    AppMethodBeat.o(42565);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(42562);
    super.setTextSize(paramInt, paramFloat);
    if (this.uvM != null)
    {
      a locala = this.uvM;
      if (!locala.uvT)
      {
        Context localContext = locala.Wf.getContext();
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