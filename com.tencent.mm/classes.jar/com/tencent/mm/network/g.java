package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public abstract interface g
{
  public abstract void Uc(String paramString);
  
  public abstract void Ud(String paramString);
  
  public abstract void Ue(String paramString);
  
  public abstract String[] Uf(String paramString);
  
  public abstract int a(t paramt, n paramn);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(j paramj);
  
  public abstract void a(q paramq);
  
  public abstract void a(ab paramab);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void b(String paramString1, long paramLong, String paramString2);
  
  public abstract String[] biA();
  
  public abstract boolean bii();
  
  public abstract e biw();
  
  public abstract k bix();
  
  public abstract void biy();
  
  public abstract void biz();
  
  public abstract void cancel(int paramInt);
  
  public abstract void clearMMtlsForbidenHostAndPsk();
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract int getMMtlsRegion();
  
  public abstract String getNetworkServerIp();
  
  public abstract void gj(boolean paramBoolean);
  
  public abstract void gk(boolean paramBoolean);
  
  public abstract void gl(boolean paramBoolean);
  
  public abstract void gm(boolean paramBoolean);
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setDebugHost(String paramString);
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setMMtlsRegion(int paramInt);
  
  public abstract void setNetIdAndIsp(String paramString1, String paramString2, String paramString3);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.g
 * JD-Core Version:    0.7.0.1
 */