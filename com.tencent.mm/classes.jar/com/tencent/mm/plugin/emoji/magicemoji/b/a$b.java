package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$b
{
  public String appId;
  public int iOo;
  public String userName;
  
  public a$b(String paramString1, String paramString2, int paramInt)
  {
    this.appId = paramString1;
    this.userName = paramString2;
    this.iOo = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258019);
    String str = "AppIdBundle{appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", versionType=" + this.iOo + '}';
    AppMethodBeat.o(258019);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.a.b
 * JD-Core Version:    0.7.0.1
 */