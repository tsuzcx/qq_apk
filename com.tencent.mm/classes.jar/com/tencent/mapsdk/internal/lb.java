package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lb
{
  public int a;
  public int b;
  public int c;
  public Object d;
  
  public final String toString()
  {
    AppMethodBeat.i(222723);
    Object localObject = new StringBuffer("DownloadEntry{");
    ((StringBuffer)localObject).append("identify=").append(this.a);
    ((StringBuffer)localObject).append(", source=").append(this.b);
    ((StringBuffer)localObject).append(", priority=").append(this.c);
    ((StringBuffer)localObject).append(", data=").append(this.d);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222723);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lb
 * JD-Core Version:    0.7.0.1
 */