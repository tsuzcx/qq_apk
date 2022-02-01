package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.k;
import java.io.Serializable;

public final class a
  extends Paint
  implements Serializable
{
  public a iZN;
  private float iZO;
  private String iZP;
  private int iZQ;
  private float iZR;
  private int iZS;
  private int mColor;
  
  public a()
  {
    AppMethodBeat.i(145336);
    this.iZN = a.iZT;
    this.iZR = 3.4028235E+38F;
    this.iZS = 2147483647;
    init();
    AppMethodBeat.o(145336);
  }
  
  private void init()
  {
    AppMethodBeat.i(145337);
    this.iZO = 0.0F;
    this.mColor = 0;
    this.iZP = null;
    this.iZQ = 0;
    if (this.iZR == 3.4028235E+38F)
    {
      this.iZO = (getAlpha() / 255.0F);
      this.iZR = this.iZO;
    }
    while (this.iZS == 2147483647)
    {
      this.mColor = getColor();
      this.iZS = this.mColor;
      AppMethodBeat.o(145337);
      return;
      this.iZO = this.iZR;
    }
    this.mColor = this.iZS;
    AppMethodBeat.o(145337);
  }
  
  public final void Ft(String paramString)
  {
    AppMethodBeat.i(145345);
    this.iZP = paramString;
    setTypeface(Typeface.create(paramString, this.iZQ));
    AppMethodBeat.o(145345);
  }
  
  public final a aTa()
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
      locala.iZN = this.iZN;
      AppMethodBeat.o(145339);
      return locala;
    }
  }
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(145341);
    this.iZO = paramFloat;
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
      parama.iZN = this.iZN;
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
  
  public final void qS(int paramInt)
  {
    AppMethodBeat.i(145346);
    this.iZQ = paramInt;
    setTypeface(Typeface.create(this.iZP, paramInt));
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
    this.iZN = a.iZT;
    AppMethodBeat.o(145343);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(145342);
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.iZO) & 0xFF) << 24 | 0xFFFFFF & paramInt);
    AppMethodBeat.o(145342);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(145335);
      iZT = new a("NORMAL", 0);
      iZU = new a("TOP", 1);
      iZV = new a("BOTTOM", 2);
      iZW = new a("MIDDLE", 3);
      iZX = new a[] { iZT, iZU, iZV, iZW };
      AppMethodBeat.o(145335);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */