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
  private a IYv;
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42558);
    j(paramAttributeSet);
    AppMethodBeat.o(42558);
  }
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42559);
    j(paramAttributeSet);
    AppMethodBeat.o(42559);
  }
  
  private void j(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(42560);
    this.IYv = a.a(this, paramAttributeSet).a(this);
    AppMethodBeat.o(42560);
  }
  
  public a getAutofitHelper()
  {
    return this.IYv;
  }
  
  public float getMaxTextSize()
  {
    return this.IYv.IYA;
  }
  
  public float getMinTextSize()
  {
    return this.IYv.IYz;
  }
  
  public float getPrecision()
  {
    return this.IYv.IYB;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42561);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.IYv != null) {
      this.IYv.fId();
    }
    AppMethodBeat.o(42561);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(42563);
    super.setLines(paramInt);
    if (this.IYv != null) {
      this.IYv.XS(paramInt);
    }
    AppMethodBeat.o(42563);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(42564);
    super.setMaxLines(paramInt);
    if (this.IYv != null) {
      this.IYv.XS(paramInt);
    }
    AppMethodBeat.o(42564);
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    AppMethodBeat.i(42566);
    a locala = this.IYv;
    Context localContext = locala.sQ.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(2, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != locala.IYA)
    {
      locala.IYA = paramFloat;
      locala.fId();
    }
    AppMethodBeat.o(42566);
  }
  
  public void setMinTextSize(int paramInt)
  {
    AppMethodBeat.i(42567);
    this.IYv.v(2, paramInt);
    AppMethodBeat.o(42567);
  }
  
  public void setPrecision(float paramFloat)
  {
    AppMethodBeat.i(42568);
    this.IYv.cu(paramFloat);
    AppMethodBeat.o(42568);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    AppMethodBeat.i(42565);
    this.IYv.wA(paramBoolean);
    AppMethodBeat.o(42565);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(42562);
    super.setTextSize(paramInt, paramFloat);
    if (this.IYv != null)
    {
      a locala = this.IYv;
      if (!locala.IYC)
      {
        Context localContext = locala.sQ.getContext();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoResizeTextView
 * JD-Core Version:    0.7.0.1
 */