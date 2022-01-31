package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.mm.plugin.appbrand.u.m;
import java.io.Serializable;

public final class a
  extends Paint
  implements Serializable
{
  public a.a fMs = a.a.fMy;
  private float fMt;
  private String fMu;
  private int fMv;
  private float fMw = 3.4028235E+38F;
  private int fMx = 2147483647;
  private int mColor;
  
  public a()
  {
    init();
  }
  
  private void init()
  {
    this.fMt = 0.0F;
    this.mColor = 0;
    this.fMu = null;
    this.fMv = 0;
    if (this.fMw == 3.4028235E+38F)
    {
      this.fMt = (getAlpha() / 255.0F);
      this.fMw = this.fMt;
    }
    while (this.fMx == 2147483647)
    {
      this.mColor = getColor();
      this.fMx = this.mColor;
      return;
      this.fMt = this.fMw;
    }
    this.mColor = this.fMx;
  }
  
  public final void ad(float paramFloat)
  {
    this.fMt = paramFloat;
    setColor(this.mColor);
  }
  
  public final a adP()
  {
    a locala = new a();
    locala.setColor(getColor());
    locala.setFlags(getFlags());
    locala.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = m.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
      if ((localObject == null) || (!(localObject instanceof Shader))) {
        break label155;
      }
      localShader = (Shader)localObject;
    }
    label155:
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
      locala.fMs = this.fMs;
      return locala;
    }
  }
  
  public final a b(a parama)
  {
    parama.setColor(getColor());
    parama.setFlags(getFlags());
    parama.setDither(isDither());
    Shader localShader = getShader();
    if (localShader != null)
    {
      Object localObject = m.a(Shader.class, "copy", localShader, new Class[0], new Object[0]);
      if ((localObject == null) || (!(localObject instanceof Shader))) {
        break label147;
      }
      localShader = (Shader)localObject;
    }
    label147:
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
      parama.fMs = this.fMs;
      return parama;
    }
  }
  
  protected final Object clone()
  {
    return super.clone();
  }
  
  public final void kC(int paramInt)
  {
    this.fMv = paramInt;
    setTypeface(Typeface.create(this.fMu, paramInt));
  }
  
  public final void rN(String paramString)
  {
    this.fMu = paramString;
    setTypeface(Typeface.create(paramString, this.fMv));
  }
  
  public final void release()
  {
    reset();
    init();
  }
  
  public final void reset()
  {
    super.reset();
    this.fMs = a.a.fMy;
  }
  
  public final void setColor(int paramInt)
  {
    this.mColor = paramInt;
    super.setColor(((int)(Color.alpha(paramInt) * this.fMt) & 0xFF) << 24 | 0xFFFFFF & paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.a.a
 * JD-Core Version:    0.7.0.1
 */