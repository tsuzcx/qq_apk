package com.google.b.f.b;

import com.google.b.f.a.a;
import com.google.b.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  com.google.b.f.a.b cfK;
  a cfL;
  c cfM;
  int cfN = -1;
  public b cfO;
  
  public final String toString()
  {
    AppMethodBeat.i(12361);
    Object localObject = new StringBuilder(200);
    ((StringBuilder)localObject).append("<<\n");
    ((StringBuilder)localObject).append(" mode: ");
    ((StringBuilder)localObject).append(this.cfK);
    ((StringBuilder)localObject).append("\n ecLevel: ");
    ((StringBuilder)localObject).append(this.cfL);
    ((StringBuilder)localObject).append("\n version: ");
    ((StringBuilder)localObject).append(this.cfM);
    ((StringBuilder)localObject).append("\n maskPattern: ");
    ((StringBuilder)localObject).append(this.cfN);
    if (this.cfO == null) {
      ((StringBuilder)localObject).append("\n matrix: null\n");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(">>\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(12361);
      return localObject;
      ((StringBuilder)localObject).append("\n matrix:\n");
      ((StringBuilder)localObject).append(this.cfO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.f.b.f
 * JD-Core Version:    0.7.0.1
 */