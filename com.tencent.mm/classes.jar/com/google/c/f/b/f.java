package com.google.c.f.b;

import com.google.c.f.a.a;
import com.google.c.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  com.google.c.f.a.b bNp;
  a bNq;
  c bNr;
  int bNs = -1;
  public b bNt;
  
  public final String toString()
  {
    AppMethodBeat.i(12361);
    Object localObject = new StringBuilder(200);
    ((StringBuilder)localObject).append("<<\n");
    ((StringBuilder)localObject).append(" mode: ");
    ((StringBuilder)localObject).append(this.bNp);
    ((StringBuilder)localObject).append("\n ecLevel: ");
    ((StringBuilder)localObject).append(this.bNq);
    ((StringBuilder)localObject).append("\n version: ");
    ((StringBuilder)localObject).append(this.bNr);
    ((StringBuilder)localObject).append("\n maskPattern: ");
    ((StringBuilder)localObject).append(this.bNs);
    if (this.bNt == null) {
      ((StringBuilder)localObject).append("\n matrix: null\n");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(">>\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(12361);
      return localObject;
      ((StringBuilder)localObject).append("\n matrix:\n");
      ((StringBuilder)localObject).append(this.bNt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.f.b.f
 * JD-Core Version:    0.7.0.1
 */