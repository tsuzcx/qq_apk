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
  public a jTV;
  private float jTW;
  private String jTX;
  private int jTY;
  private float jTZ;
  private int jUa;
  private int mColor;
  
  public a()
  {
    AppMethodBeat.i(145336);
    this.jTV = a.jUb;
    this.jTZ = 3.4028235E+38F;
    this.jUa = 2147483647;
    init();
    AppMethodBeat.o(145336);
  }
  
  private void init()
  {
    AppMethodBeat.i(145337);
    this.jTW = 0.0F;
    this.mColor = 0;
    this.jTX = null;
    this.jTY = 0;
    if (this.jTZ == 3.4028235E+38F)
    {
      this.jTW = (getAlpha() / 255.0F);
      this.jTZ = this.jTW;
    }
    while (this.jUa == 2147483647)
    {
      this.mColor = getColor();
      this.jUa = this.mColor;
      AppMethodBeat.o(145337);
      return;
      this.jTW = this.jTZ;
    }
    this.mColor = this.jUa;
    AppMethodBeat.o(145337);
  }
  
  public final void MQ(String paramString)
  {
    AppMethodBeat.i(145345);
    this.jTX = paramString;
    setTypeface(Typeface.create(paramString, this.jTY));
    AppMethodBeat.o(145345);
  }
  
  public final void aw(float paramFloat)
  {
    AppMethodBeat.i(145341);
    this.jTW = paramFloat;
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
      parama.jTV = this.jTV;
      AppMethodBeat.o(145340);
      return parama;
    }
  }
  
  public final a bdy()
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
      locala.jTV = this.jTV;
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
    this.jTV = a.jUb;
    AppMethodBeat.o(145343);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(145342);
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.jTW) & 0xFF) << 24 | 0xFFFFFF & paramInt);
    AppMethodBeat.o(145342);
  }
  
  public final void sf(int paramInt)
  {
    AppMethodBeat.i(145346);
    this.jTY = paramInt;
    setTypeface(Typeface.create(this.jTX, paramInt));
    AppMethodBeat.o(145346);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(145335);
      jUb = new a("NORMAL", 0);
      jUc = new a("TOP", 1);
      jUd = new a("BOTTOM", 2);
      jUe = new a("MIDDLE", 3);
      jUf = new a[] { jUb, jUc, jUd, jUe };
      AppMethodBeat.o(145335);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */