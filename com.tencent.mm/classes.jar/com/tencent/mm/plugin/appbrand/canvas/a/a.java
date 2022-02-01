package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.k;
import java.io.Serializable;

public final class a
  extends Paint
  implements Serializable
{
  public a laj;
  private float lak;
  private String lal;
  private int lam;
  private float lan;
  private int lao;
  private int mColor;
  
  public a()
  {
    AppMethodBeat.i(145336);
    this.laj = a.lap;
    this.lan = 3.4028235E+38F;
    this.lao = 2147483647;
    init();
    AppMethodBeat.o(145336);
  }
  
  private void init()
  {
    AppMethodBeat.i(145337);
    this.lak = 0.0F;
    this.mColor = 0;
    this.lal = null;
    this.lam = 0;
    if (this.lan == 3.4028235E+38F)
    {
      this.lak = (getAlpha() / 255.0F);
      this.lan = this.lak;
    }
    while (this.lao == 2147483647)
    {
      this.mColor = getColor();
      this.lao = this.mColor;
      AppMethodBeat.o(145337);
      return;
      this.lak = this.lan;
    }
    this.mColor = this.lao;
    AppMethodBeat.o(145337);
  }
  
  public final void WF(String paramString)
  {
    AppMethodBeat.i(145345);
    this.lal = paramString;
    setTypeface(Typeface.create(paramString, this.lam));
    AppMethodBeat.o(145345);
  }
  
  public final void aG(float paramFloat)
  {
    AppMethodBeat.i(145341);
    this.lak = paramFloat;
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
      parama.laj = this.laj;
      AppMethodBeat.o(145340);
      return parama;
    }
  }
  
  public final a bzu()
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
      locala.laj = this.laj;
      AppMethodBeat.o(145339);
      return locala;
    }
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(145338);
    Object localObject = super.clone();
    AppMethodBeat.o(145338);
    return localObject;
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
    this.laj = a.lap;
    AppMethodBeat.o(145343);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(145342);
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.lak) & 0xFF) << 24 | 0xFFFFFF & paramInt);
    AppMethodBeat.o(145342);
  }
  
  public final void we(int paramInt)
  {
    AppMethodBeat.i(145346);
    this.lam = paramInt;
    setTypeface(Typeface.create(this.lal, paramInt));
    AppMethodBeat.o(145346);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(145335);
      lap = new a("NORMAL", 0);
      laq = new a("TOP", 1);
      lar = new a("BOTTOM", 2);
      las = new a("MIDDLE", 3);
      lau = new a[] { lap, laq, lar, las };
      AppMethodBeat.o(145335);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */