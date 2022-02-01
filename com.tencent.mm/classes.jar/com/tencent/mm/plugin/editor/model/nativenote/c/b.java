package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float dit = -1.0F;
  public float diu = -1.0F;
  public float uuj = -1.0F;
  public float uuk = -1.0F;
  public int uul = -1;
  public float uum = -1.0F;
  public float uun = -1.0F;
  public float uuo = -1.0F;
  public float uup = -1.0F;
  public int uuq = -1;
  public int viewType = 0;
  
  private boolean cSw()
  {
    return (this.uuj >= 0.0F) && (this.uuk >= 0.0F) && (this.dit >= 0.0F) && (this.diu >= 0.0F) && (this.uul >= 0);
  }
  
  private boolean cSx()
  {
    return (this.uum >= 0.0F) && (this.uun >= 0.0F) && (this.uuo >= 0.0F) && (this.uup >= 0.0F) && (this.uuq >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.viewType = paramInt1;
    this.uuj = paramFloat1;
    this.uuk = paramFloat2;
    this.dit = paramFloat3;
    this.diu = paramFloat4;
    if (this.viewType == 1)
    {
      this.uul = paramInt2;
      return;
    }
    this.uul = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(181848);
    if (!cSw())
    {
      AppMethodBeat.o(181848);
      return 0;
    }
    if (!cSx())
    {
      AppMethodBeat.o(181848);
      return 1;
    }
    int i = Math.abs((int)(this.dit - this.uuo));
    int j = Math.abs((int)(this.diu - this.uup));
    if ((i > 30) || (j > 30) || (this.uul != this.uuq))
    {
      AppMethodBeat.o(181848);
      return 3;
    }
    AppMethodBeat.o(181848);
    return 2;
  }
  
  public final void reset()
  {
    this.viewType = 0;
    this.uuj = -1.0F;
    this.uuk = -1.0F;
    this.dit = -1.0F;
    this.diu = -1.0F;
    this.uul = -1;
    this.uum = -1.0F;
    this.uun = -1.0F;
    this.uuo = -1.0F;
    this.uup = -1.0F;
    this.uuq = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */