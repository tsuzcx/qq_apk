package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$a
{
  public String jDN = "";
  public String jDO = "";
  public String jDP = "";
  public String jDQ = "";
  
  public k$a() {}
  
  public k$a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jDN = paramString1;
    this.jDO = paramString2;
    this.jDP = paramString3;
    this.jDQ = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(17472);
    String str = this.jDN + " " + this.jDO + " " + this.jDP + " " + this.jDQ;
    AppMethodBeat.o(17472);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.k.a
 * JD-Core Version:    0.7.0.1
 */