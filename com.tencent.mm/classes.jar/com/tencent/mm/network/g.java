package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public abstract interface g
{
  public abstract void Mb(String paramString);
  
  public abstract void Mc(String paramString);
  
  public abstract void Md(String paramString);
  
  public abstract String[] Me(String paramString);
  
  public abstract int a(t paramt, n paramn);
  
  public abstract int a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract int a(int[] paramArrayOfInt, boolean paramBoolean, long paramLong, String paramString);
  
  public abstract void a(b paramb);
  
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(q paramq);
  
  public abstract void a(ab paramab);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract int ackActionNotify(String paramString, long paramLong, int paramInt);
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void bFP();
  
  public abstract boolean bFR();
  
  public abstract e bGg();
  
  public abstract k bGh();
  
  public abstract void bGi();
  
  public abstract void bGj();
  
  public abstract String[] bGk();
  
  public abstract void cancel(int paramInt);
  
  public abstract void clearMMtlsForbidenHostAndPsk();
  
  public abstract int doLiveSpeedTest(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, u paramu);
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract int getMMtlsRegion();
  
  public abstract long getMarsTimestamp();
  
  public abstract String getNetworkServerIp();
  
  public abstract void ha(boolean paramBoolean);
  
  public abstract void hb(boolean paramBoolean);
  
  public abstract void hc(boolean paramBoolean);
  
  public abstract void hd(boolean paramBoolean);
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setDebugHost(String paramString);
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setMMtlsRegion(int paramInt);
  
  public abstract void setNetIdAndIsp(String paramString1, String paramString2, String paramString3);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void simpleTestCommand(String paramString);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.g
 * JD-Core Version:    0.7.0.1
 */