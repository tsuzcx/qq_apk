package com.tencent.d.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
{
  public int Irv;
  public String Irw;
  public String name = "";
  public int pid;
  public int uid;
  
  d$a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.pid = paramInt1;
    this.Irv = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.Irw = paramString2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138363);
    String str = "PID=" + this.pid + " PPID=" + this.Irv + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.Irw;
    AppMethodBeat.o(138363);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.d.b.d.a
 * JD-Core Version:    0.7.0.1
 */