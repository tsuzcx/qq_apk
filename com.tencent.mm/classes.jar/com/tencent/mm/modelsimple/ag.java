package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ag
{
  private static f callback = null;
  private static boolean fQi = false;
  private static int fQj = 3;
  private static long fQk = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(108300);
    if (fQi)
    {
      ab.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(108300);
      return;
    }
    if ((fQk == 0L) || (bo.av(fQk) > 180000L))
    {
      fQk = bo.yB();
      fQj = 3;
    }
    if (fQj <= 0)
    {
      ab.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(108300);
      return;
    }
    fQj -= 1;
    Object localObject = com.tencent.mm.compatible.util.e.esy + "temp.avatar.hd";
    if (!com.tencent.mm.vfs.e.cN((String)localObject))
    {
      ab.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(108300);
      return;
    }
    if (callback == null) {
      callback = new ag.1((String)localObject);
    }
    g.Rc().a(157, callback);
    localObject = new l((String)localObject);
    g.Rc().a((m)localObject, 0);
    fQi = true;
    AppMethodBeat.o(108300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */