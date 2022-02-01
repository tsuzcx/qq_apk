package com.tencent.mm.network;

import android.os.IInterface;
import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public abstract interface f
  extends IInterface
{
  public abstract int a(r paramr, l paraml);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract int a(boolean paramBoolean, List<String> paramList);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(g paramg);
  
  public abstract void a(h paramh);
  
  public abstract void a(o paramo);
  
  public abstract void a(s params);
  
  public abstract void a(ab paramab);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract d aEG();
  
  public abstract void aEH();
  
  public abstract i aEI();
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract boolean auS();
  
  public abstract void avi();
  
  public abstract void avj();
  
  public abstract void c(String paramString1, long paramLong, String paramString2);
  
  public abstract void cancel(int paramInt);
  
  public abstract void d(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void ei(boolean paramBoolean);
  
  public abstract void ej(boolean paramBoolean);
  
  public abstract void ek(boolean paramBoolean);
  
  public abstract void el(boolean paramBoolean);
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract String getNetworkServerIp();
  
  public abstract int i(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setNewDnsDebugHost(String paramString1, String paramString2);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
  
  public abstract void wm(String paramString);
  
  public abstract void wn(String paramString);
  
  public abstract void wo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.f
 * JD-Core Version:    0.7.0.1
 */