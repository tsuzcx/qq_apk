package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends g
{
  public int dqS = -1;
  public String edg;
  public String[] edh;
  public String[] edi;
  public int edj;
  public int edk;
  public int edl = -1;
  public int fileType = 0;
  public String host;
  public boolean isColdSnsData;
  public String referer;
  public String signalQuality;
  public String snsCipherKey = "";
  public String snsScene;
  public String url;
  
  public e()
  {
    this.edB = true;
  }
  
  private static String f(String[] paramArrayOfString)
  {
    AppMethodBeat.i(128595);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(128595);
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
    AppMethodBeat.o(128595);
    return str1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(128594);
    String str = String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[] { this.field_mediaId, this.url, this.host, this.referer, this.edg, f(this.edh), f(this.edi), Integer.valueOf(this.edj), Integer.valueOf(this.edk), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene });
    AppMethodBeat.o(128594);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.i.e
 * JD-Core Version:    0.7.0.1
 */