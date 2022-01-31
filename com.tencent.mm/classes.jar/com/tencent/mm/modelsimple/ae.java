package com.tencent.mm.modelsimple;

import com.tencent.mm.ag.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ae
{
  private static f dmL = null;
  private static boolean eAp = false;
  private static int eAq = 3;
  private static long eAr = 0L;
  
  public static void run()
  {
    if (eAp)
    {
      y.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      return;
    }
    if ((eAr == 0L) || (bk.cp(eAr) > 180000L))
    {
      eAr = bk.UZ();
      eAq = 3;
    }
    if (eAq <= 0)
    {
      y.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      return;
    }
    eAq -= 1;
    Object localObject = com.tencent.mm.compatible.util.e.dzK + "temp.avatar.hd";
    if (!com.tencent.mm.vfs.e.bK((String)localObject))
    {
      y.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      return;
    }
    if (dmL == null) {
      dmL = new ae.1((String)localObject);
    }
    g.Dk().a(157, dmL);
    localObject = new l(1, (String)localObject);
    g.Dk().a((m)localObject, 0);
    eAp = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */