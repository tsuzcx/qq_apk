package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fs
{
  public ft a;
  public ft[] b;
  public float c;
  
  public fs(ft paramft, ft[] paramArrayOfft, float paramFloat)
  {
    this.a = paramft;
    this.b = paramArrayOfft;
    this.c = paramFloat;
  }
  
  private ft b()
  {
    return this.a;
  }
  
  private ft[] c()
  {
    return this.b;
  }
  
  private float d()
  {
    return this.c;
  }
  
  public final fs a()
  {
    AppMethodBeat.i(222077);
    fs localfs = new fs(this.a, this.b, this.c);
    AppMethodBeat.o(222077);
    return localfs;
  }
  
  public final void a(ft paramft, ft[] paramArrayOfft, float paramFloat)
  {
    this.a = paramft;
    this.b = paramArrayOfft;
    this.c = paramFloat;
  }
  
  public final boolean a(fs paramfs)
  {
    AppMethodBeat.i(222069);
    if (paramfs == null)
    {
      AppMethodBeat.o(222069);
      return true;
    }
    if (Float.compare(paramfs.c, this.c) > 0)
    {
      AppMethodBeat.o(222069);
      return true;
    }
    if ((this.a != null) && (paramfs.a != null) && (kr.a(this.a, paramfs.a) > 50.0D))
    {
      AppMethodBeat.o(222069);
      return true;
    }
    if ((this.b != null) && (paramfs.b != null) && (this.b.length == paramfs.b.length))
    {
      int i = 0;
      while (i < this.b.length)
      {
        if (kr.a(this.b[i], paramfs.b[i]) > 50.0D)
        {
          AppMethodBeat.o(222069);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(222069);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fs
 * JD-Core Version:    0.7.0.1
 */