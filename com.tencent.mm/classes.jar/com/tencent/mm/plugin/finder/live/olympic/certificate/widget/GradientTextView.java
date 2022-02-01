package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attri", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "endColor", "", "getEndColor", "()I", "setEndColor", "(I)V", "middleColor", "getMiddleColor", "setMiddleColor", "startColor", "getStartColor", "setStartColor", "changeEndGradient", "", "changeMiddleGradient", "changeNormalGradient", "changeStartGradient", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GradientTextView
  extends AppCompatTextView
{
  private int CRt;
  private int endColor;
  int fhI;
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(360895);
    this.CRt = Color.parseColor("#996431");
    this.fhI = Color.parseColor("#D1A05B");
    this.endColor = Color.parseColor("#C28E4A");
    eoc();
    AppMethodBeat.o(360895);
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(360925);
    float f1 = getPaint().getTextSize();
    float f2 = getText().length();
    float f3 = getPaint().getTextSize();
    int i = this.CRt;
    int j = this.fhI;
    int k = this.endColor;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(0.0F, 0.0F, f1 * f2, f3, new int[] { i, j, k }, new float[] { 0.0F, 0.6666667F, 1.0F }, (Shader.TileMode)localObject);
    getPaint().setShader((Shader)localObject);
    AppMethodBeat.o(360925);
  }
  
  public final void eod()
  {
    AppMethodBeat.i(360928);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, getPaint().getTextSize() * getText().length(), getPaint().getTextSize(), this.CRt, this.fhI, Shader.TileMode.CLAMP);
    getPaint().setShader((Shader)localLinearGradient);
    invalidate();
    AppMethodBeat.o(360928);
  }
  
  public final void eoe()
  {
    AppMethodBeat.i(360934);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, getPaint().getTextSize() * getText().length(), getPaint().getTextSize(), this.fhI, this.endColor, Shader.TileMode.CLAMP);
    getPaint().setShader((Shader)localLinearGradient);
    invalidate();
    AppMethodBeat.o(360934);
  }
  
  public final int getEndColor()
  {
    return this.endColor;
  }
  
  public final int getMiddleColor()
  {
    return this.fhI;
  }
  
  public final int getStartColor()
  {
    return this.CRt;
  }
  
  public final void setEndColor(int paramInt)
  {
    this.endColor = paramInt;
  }
  
  public final void setMiddleColor(int paramInt)
  {
    this.fhI = paramInt;
  }
  
  public final void setStartColor(int paramInt)
  {
    this.CRt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.GradientTextView
 * JD-Core Version:    0.7.0.1
 */