package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelavatar.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class ai
{
  private static com.tencent.mm.am.h callback = null;
  private static boolean oTC = false;
  private static int oTD = 3;
  private static long oTE = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (oTC)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((oTE == 0L) || (Util.ticksToNow(oTE) > 180000L))
    {
      oTE = Util.currentTicks();
      oTD = 3;
    }
    if (oTD <= 0)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    oTD -= 1;
    Object localObject = b.bmH() + "temp.avatar.hd";
    if (!y.ZC((String)localObject))
    {
      Log.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(130964);
          Log.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            y.deleteFile(ai.this);
          }
          ai.aAs();
          com.tencent.mm.kernel.h.aZW().b(157, ai.bMB());
          AppMethodBeat.o(130964);
        }
      };
    }
    com.tencent.mm.kernel.h.aZW().a(157, callback);
    localObject = new n(1, (String)localObject);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    oTC = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ai
 * JD-Core Version:    0.7.0.1
 */