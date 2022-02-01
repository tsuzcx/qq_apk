package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  public int ahtK;
  public String ahtL;
  public String name = "";
  public int pid;
  public int uid;
  
  e$a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.pid = paramInt1;
    this.ahtK = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.ahtL = paramString2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138363);
    String str = "PID=" + this.pid + " PPID=" + this.ahtK + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.ahtL;
    AppMethodBeat.o(138363);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.b.e.a
 * JD-Core Version:    0.7.0.1
 */