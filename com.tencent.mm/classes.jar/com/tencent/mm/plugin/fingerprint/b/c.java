package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements com.tencent.mm.pluginsdk.j
{
  public static int a(com.tencent.mm.pluginsdk.wallet.c paramc, boolean paramBoolean)
  {
    return ((k)g.r(k.class)).a(paramc, paramBoolean);
  }
  
  public static boolean aSB()
  {
    boolean bool = ((k)g.r(k.class)).aSF();
    y.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + bool);
    return bool;
  }
  
  public static void aSC()
  {
    ((k)g.r(k.class)).aSC();
  }
  
  public static boolean aSD()
  {
    return ((k)g.r(k.class)).aSG();
  }
  
  public static com.tencent.mm.pluginsdk.wallet.j aSE()
  {
    return ((k)g.r(k.class)).aSE();
  }
  
  public static void abort()
  {
    ((k)g.r(k.class)).aSM();
  }
  
  public static void release()
  {
    ((k)g.r(k.class)).aSL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.c
 * JD-Core Version:    0.7.0.1
 */