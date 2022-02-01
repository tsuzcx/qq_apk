package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float cNg = -1.0F;
  public float cNh = -1.0F;
  public int oIb = 0;
  public float pwh = -1.0F;
  public float pwi = -1.0F;
  public int pwj = -1;
  public float pwk = -1.0F;
  public float pwl = -1.0F;
  public float pwm = -1.0F;
  public float pwn = -1.0F;
  public int pwo = -1;
  
  private boolean ceM()
  {
    return (this.pwh >= 0.0F) && (this.pwi >= 0.0F) && (this.cNg >= 0.0F) && (this.cNh >= 0.0F) && (this.pwj >= 0);
  }
  
  private boolean ceN()
  {
    return (this.pwk >= 0.0F) && (this.pwl >= 0.0F) && (this.pwm >= 0.0F) && (this.pwn >= 0.0F) && (this.pwo >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.oIb = paramInt1;
    this.pwh = paramFloat1;
    this.pwi = paramFloat2;
    this.cNg = paramFloat3;
    this.cNh = paramFloat4;
    if (this.oIb == 1)
    {
      this.pwj = paramInt2;
      return;
    }
    this.pwj = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(181848);
    if (!ceM())
    {
      AppMethodBeat.o(181848);
      return 0;
    }
    if (!ceN())
    {
      AppMethodBeat.o(181848);
      return 1;
    }
    int i = Math.abs((int)(this.cNg - this.pwm));
    int j = Math.abs((int)(this.cNh - this.pwn));
    if ((i > 30) || (j > 30) || (this.pwj != this.pwo))
    {
      AppMethodBeat.o(181848);
      return 3;
    }
    AppMethodBeat.o(181848);
    return 2;
  }
  
  public final void reset()
  {
    this.oIb = 0;
    this.pwh = -1.0F;
    this.pwi = -1.0F;
    this.cNg = -1.0F;
    this.cNh = -1.0F;
    this.pwj = -1;
    this.pwk = -1.0F;
    this.pwl = -1.0F;
    this.pwm = -1.0F;
    this.pwn = -1.0F;
    this.pwo = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */