package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.k;
import java.io.Serializable;

public final class a
  extends Paint
  implements Serializable
{
  public a jAa;
  private float jAb;
  private String jAc;
  private int jAd;
  private float jAe;
  private int jAf;
  private int mColor;
  
  public a()
  {
    AppMethodBeat.i(145336);
    this.jAa = a.jAg;
    this.jAe = 3.4028235E+38F;
    this.jAf = 2147483647;
    init();
    AppMethodBeat.o(145336);
  }
  
  private void init()
  {
    AppMethodBeat.i(145337);
    this.jAb = 0.0F;
    this.mColor = 0;
    this.jAc = null;
    this.jAd = 0;
    if (this.jAe == 3.4028235E+38F)
    {
      this.jAb = (getAlpha() / 255.0F);
      this.jAe = this.jAb;
    }
    while (this.jAf == 2147483647)
    {
      this.mColor = getColor();
      this.jAf = this.mColor;
      AppMethodBeat.o(145337);
      return;
      this.jAb = this.jAe;
    }
    this.mColor = this.jAf;
    AppMethodBeat.o(145337);
  }
  
  public final void Jx(String paramString)
  {
    AppMethodBeat.i(145345);
    this.jAc = paramString;
    setTypeface(Typeface.create(paramString, this.jAd));
    AppMethodBeat.o(145345);
  }
  
  public final a aZZ()
  {
    AppMethodBeat.i(145339);
    a locala = new a();
    locala.setColor(getColor());
    locala.setFlags(getFlags());
    locala.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = k.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
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
      locala.jAa = this.jAa;
      AppMethodBeat.o(145339);
      return locala;
    }
  }
  
  public final void at(float paramFloat)
  {
    AppMethodBeat.i(145341);
    this.jAb = paramFloat;
    setColor(this.mColor);
    AppMethodBeat.o(145341);
  }
  
  public final a b(a parama)
  {
    AppMethodBeat.i(145340);
    parama.setColor(getColor());
    parama.setFlags(getFlags());
    parama.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = k.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
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
      parama.jAa = this.jAa;
      AppMethodBeat.o(145340);
      return parama;
    }
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(145338);
    Object localObject = super.clone();
    AppMethodBeat.o(145338);
    return localObject;
  }
  
  public final void rF(int paramInt)
  {
    AppMethodBeat.i(145346);
    this.jAd = paramInt;
    setTypeface(Typeface.create(this.jAc, paramInt));
    AppMethodBeat.o(145346);
  }
  
  public final void release()
  {
    AppMethodBeat.i(145344);
    reset();
    init();
    AppMethodBeat.o(145344);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145343);
    super.reset();
    this.jAa = a.jAg;
    AppMethodBeat.o(145343);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(145342);
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.jAb) & 0xFF) << 24 | 0xFFFFFF & paramInt);
    AppMethodBeat.o(145342);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(145335);
      jAg = new a("NORMAL", 0);
      jAh = new a("TOP", 1);
      jAi = new a("BOTTOM", 2);
      jAj = new a("MIDDLE", 3);
      jAk = new a[] { jAg, jAh, jAi, jAj };
      AppMethodBeat.o(145335);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */