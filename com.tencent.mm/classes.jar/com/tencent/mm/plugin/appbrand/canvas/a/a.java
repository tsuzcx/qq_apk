package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.l;
import java.io.Serializable;

public final class a
  extends Paint
  implements Serializable
{
  public a.a hfC;
  private float hfD;
  private String hfE;
  private int hfF;
  private float hfG;
  private int hfH;
  private int mColor;
  
  public a()
  {
    AppMethodBeat.i(103653);
    this.hfC = a.a.hfI;
    this.hfG = 3.4028235E+38F;
    this.hfH = 2147483647;
    init();
    AppMethodBeat.o(103653);
  }
  
  private void init()
  {
    AppMethodBeat.i(103654);
    this.hfD = 0.0F;
    this.mColor = 0;
    this.hfE = null;
    this.hfF = 0;
    if (this.hfG == 3.4028235E+38F)
    {
      this.hfD = (getAlpha() / 255.0F);
      this.hfG = this.hfD;
    }
    while (this.hfH == 2147483647)
    {
      this.mColor = getColor();
      this.hfH = this.mColor;
      AppMethodBeat.o(103654);
      return;
      this.hfD = this.hfG;
    }
    this.mColor = this.hfH;
    AppMethodBeat.o(103654);
  }
  
  public final void ao(float paramFloat)
  {
    AppMethodBeat.i(103658);
    this.hfD = paramFloat;
    setColor(this.mColor);
    AppMethodBeat.o(103658);
  }
  
  public final a ayh()
  {
    AppMethodBeat.i(103656);
    a locala = new a();
    locala.setColor(getColor());
    locala.setFlags(getFlags());
    locala.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = l.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
      if ((localObject == null) || (!(localObject instanceof Shader))) {
        break label165;
      }
      localShader = (Shader)localObject;
    }
    label165:
    for (;;)
    {
      locala.setShader(localShader);
      locala.setStrokeJoin(getStrokeJoin());
      locala.setStrokeMiter(getStrokeMiter());
      locala.setStrokeWidth(getStrokeWidth());
      locala.setStrokeCap(getStrokeCap());
      locala.setStyle(getStyle());
      locala.setTextSize(getTextSize());
      locala.setTextAlign(getTextAlign());
      locala.setTypeface(getTypeface());
      locala.hfC = this.hfC;
      AppMethodBeat.o(103656);
      return locala;
    }
  }
  
  public final a b(a parama)
  {
    AppMethodBeat.i(103657);
    parama.setColor(getColor());
    parama.setFlags(getFlags());
    parama.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = l.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
      if ((localObject == null) || (!(localObject instanceof Shader))) {
        break label157;
      }
      localShader = (Shader)localObject;
    }
    label157:
    for (;;)
    {
      parama.setShader(localShader);
      parama.setStrokeJoin(getStrokeJoin());
      parama.setStrokeMiter(getStrokeMiter());
      parama.setStrokeWidth(getStrokeWidth());
      parama.setStrokeCap(getStrokeCap());
      parama.setStyle(getStyle());
      parama.setTextSize(getTextSize());
      parama.setTextAlign(getTextAlign());
      parama.setTypeface(getTypeface());
      parama.hfC = this.hfC;
      AppMethodBeat.o(103657);
      return parama;
    }
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(103655);
    Object localObject = super.clone();
    AppMethodBeat.o(103655);
    return localObject;
  }
  
  public final void ny(int paramInt)
  {
    AppMethodBeat.i(103663);
    this.hfF = paramInt;
    setTypeface(Typeface.create(this.hfE, paramInt));
    AppMethodBeat.o(103663);
  }
  
  public final void release()
  {
    AppMethodBeat.i(103661);
    reset();
    init();
    AppMethodBeat.o(103661);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103660);
    super.reset();
    this.hfC = a.a.hfI;
    AppMethodBeat.o(103660);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(103659);
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.hfD) & 0xFF) << 24 | 0xFFFFFF & paramInt);
    AppMethodBeat.o(103659);
  }
  
  public final void zD(String paramString)
  {
    AppMethodBeat.i(103662);
    this.hfE = paramString;
    setTypeface(Typeface.create(paramString, this.hfF));
    AppMethodBeat.o(103662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */