package com.tencent.mm.j;

public final class e
  extends f
{
  public int cCI = -1;
  public String dlJ;
  public String[] dlK;
  public String[] dlL;
  public int dlM;
  public int dlN;
  public int dlO = -1;
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
    this.dlZ = true;
  }
  
  private static String f(String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject = "";
      return localObject;
    }
    String str = "";
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= j) {
        break;
      }
      localObject = paramArrayOfString[i];
      str = str + (String)localObject + ",";
      i += 1;
    }
  }
  
  public final String toString()
  {
    return String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[] { this.field_mediaId, this.url, this.host, this.referer, this.dlJ, f(this.dlK), f(this.dlL), Integer.valueOf(this.dlM), Integer.valueOf(this.dlN), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.j.e
 * JD-Core Version:    0.7.0.1
 */