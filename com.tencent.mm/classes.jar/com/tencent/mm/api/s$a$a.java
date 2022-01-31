package com.tencent.mm.api;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$a$a
{
  public s.c bWf;
  public boolean bWg;
  boolean bWi = false;
  public boolean bWj = true;
  public Rect bWk;
  public String path;
  
  public final a Aw()
  {
    this.bWj = false;
    return this;
  }
  
  public final s.a Ax()
  {
    AppMethodBeat.i(73802);
    s.a locala = new s.a(this.path, this.bWf, this.bWg, this.bWj, this.bWk, this.bWi);
    AppMethodBeat.o(73802);
    return locala;
  }
  
  public final a a(s.c paramc)
  {
    this.bWf = paramc;
    return this;
  }
  
  public final a bm(boolean paramBoolean)
  {
    this.bWg = paramBoolean;
    return this;
  }
  
  public final a bn(boolean paramBoolean)
  {
    this.bWi = paramBoolean;
    return this;
  }
  
  public final a dm(String paramString)
  {
    this.path = paramString;
    return this;
  }
  
  public final a i(Rect paramRect)
  {
    this.bWk = paramRect;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.s.a.a
 * JD-Core Version:    0.7.0.1
 */