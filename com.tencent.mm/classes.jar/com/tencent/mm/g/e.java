package com.tencent.mm.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends g
{
  public int appType = -1;
  public int fileType = 0;
  public String host;
  public boolean isColdSnsData;
  public String lwD;
  public String[] lwE;
  public String[] lwF;
  public int lwG;
  public int lwH;
  public String referer;
  public String signalQuality;
  public String snsCipherKey = "";
  public String snsScene;
  public String url;
  
  public e()
  {
    this.lwX = true;
  }
  
  private static String f(String[] paramArrayOfString)
  {
    AppMethodBeat.i(120676);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(120676);
      return "";
    }
    String str1 = "";
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      str1 = str1 + str2 + ",";
      i += 1;
    }
    AppMethodBeat.o(120676);
    return str1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(120675);
    String str = String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[] { this.field_mediaId, this.url, this.host, this.referer, this.lwD, f(this.lwE), f(this.lwF), Integer.valueOf(this.lwG), Integer.valueOf(this.lwH), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene });
    AppMethodBeat.o(120675);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.e
 * JD-Core Version:    0.7.0.1
 */