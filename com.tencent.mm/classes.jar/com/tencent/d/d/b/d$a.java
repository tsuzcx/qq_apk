package com.tencent.d.d.b;

public final class d$a
{
  public String name = "";
  public int pid;
  public int uid;
  public int wMT;
  public String wMU;
  
  d$a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.pid = paramInt1;
    this.wMT = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.wMU = paramString2;
  }
  
  public final String toString()
  {
    return "PID=" + this.pid + " PPID=" + this.wMT + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.wMU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.d.a
 * JD-Core Version:    0.7.0.1
 */