package com.tencent.mm.plugin.appbrand;

import android.support.v4.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class m
{
  private static final Map<String, m> dGN = new a();
  private static final m fzs = new m();
  public volatile boolean fzA;
  public volatile String fzt;
  public final AtomicInteger fzu = new AtomicInteger();
  public final AtomicBoolean fzv = new AtomicBoolean(false);
  public int fzw = 0;
  public volatile String fzx;
  public volatile String fzy;
  public volatile boolean fzz;
  
  static m qE(String paramString)
  {
    return qF(paramString);
  }
  
  private static m qF(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    synchronized (dGN)
    {
      m localm2 = (m)dGN.get(paramString);
      m localm1 = localm2;
      if (localm2 == null)
      {
        localm1 = new m();
        dGN.put(paramString, localm1);
      }
      return localm1;
    }
  }
  
  private static m qG(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    synchronized (dGN)
    {
      paramString = (m)dGN.get(paramString);
      return paramString;
    }
  }
  
  public static m qH(String paramString)
  {
    m localm = qG(paramString);
    paramString = localm;
    if (localm == null) {
      paramString = fzs;
    }
    return paramString;
  }
  
  public static m qI(String paramString)
  {
    return qF(paramString);
  }
  
  static void remove(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    synchronized (dGN)
    {
      dGN.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */