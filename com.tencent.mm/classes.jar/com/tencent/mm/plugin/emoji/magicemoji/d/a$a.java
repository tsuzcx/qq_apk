package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public String appId;
  public int euz;
  public String userName;
  
  public a$a(String paramString1, String paramString2, int paramInt)
  {
    this.appId = paramString1;
    this.userName = paramString2;
    this.euz = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(270009);
    String str = "AppIdBundle{appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", versionType=" + this.euz + '}';
    AppMethodBeat.o(270009);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.a.a
 * JD-Core Version:    0.7.0.1
 */