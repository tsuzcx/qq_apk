package com.google.b.f.b;

import com.google.b.f.a.a;
import com.google.b.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  com.google.b.f.a.b blv;
  a blw;
  c blx;
  int bly = -1;
  public b blz;
  
  public final String toString()
  {
    AppMethodBeat.i(57296);
    Object localObject = new StringBuilder(200);
    ((StringBuilder)localObject).append("<<\n");
    ((StringBuilder)localObject).append(" mode: ");
    ((StringBuilder)localObject).append(this.blv);
    ((StringBuilder)localObject).append("\n ecLevel: ");
    ((StringBuilder)localObject).append(this.blw);
    ((StringBuilder)localObject).append("\n version: ");
    ((StringBuilder)localObject).append(this.blx);
    ((StringBuilder)localObject).append("\n maskPattern: ");
    ((StringBuilder)localObject).append(this.bly);
    if (this.blz == null) {
      ((StringBuilder)localObject).append("\n matrix: null\n");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(">>\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(57296);
      return localObject;
      ((StringBuilder)localObject).append("\n matrix:\n");
      ((StringBuilder)localObject).append(this.blz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.f.b.f
 * JD-Core Version:    0.7.0.1
 */