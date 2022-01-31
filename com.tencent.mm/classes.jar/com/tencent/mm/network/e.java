package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.x;
import java.util.List;

public abstract interface e
{
  public abstract boolean KH();
  
  public abstract c KR();
  
  public abstract i KS();
  
  public abstract void KT();
  
  public abstract void KU();
  
  public abstract int a(r paramr, l paraml);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(h paramh);
  
  public abstract void a(o paramo);
  
  public abstract void a(x paramx);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract void bO(boolean paramBoolean);
  
  public abstract void bP(boolean paramBoolean);
  
  public abstract void bQ(boolean paramBoolean);
  
  public abstract void bR(boolean paramBoolean);
  
  public abstract void cancel(int paramInt);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract String getNetworkServerIp();
  
  public abstract void keepSignalling();
  
  public abstract void kt(String paramString);
  
  public abstract void ku(String paramString);
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reset();
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void stopSignalling();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.e
 * JD-Core Version:    0.7.0.1
 */