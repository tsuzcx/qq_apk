package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public abstract interface e
{
  public abstract void Dr(String paramString);
  
  public abstract void Ds(String paramString);
  
  public abstract void Dt(String paramString);
  
  public abstract int a(r paramr, l paraml);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(h paramh);
  
  public abstract void a(o paramo);
  
  public abstract void a(ab paramab);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract boolean aEO();
  
  public abstract c aFc();
  
  public abstract i aFd();
  
  public abstract void aFe();
  
  public abstract void aFf();
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void cancel(int paramInt);
  
  public abstract void d(String paramString1, long paramLong, String paramString2);
  
  public abstract void eF(boolean paramBoolean);
  
  public abstract void eG(boolean paramBoolean);
  
  public abstract void eH(boolean paramBoolean);
  
  public abstract void eI(boolean paramBoolean);
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract String getNetworkServerIp();
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.e
 * JD-Core Version:    0.7.0.1
 */