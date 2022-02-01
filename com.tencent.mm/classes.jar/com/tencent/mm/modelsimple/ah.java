package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class ah
{
  private static i callback = null;
  private static boolean maL = false;
  private static int maM = 3;
  private static long maN = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (maL)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((maN == 0L) || (Util.ticksToNow(maN) > 180000L))
    {
      maN = Util.currentTicks();
      maM = 3;
    }
    if (maM <= 0)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    maM -= 1;
    Object localObject = b.aST() + "temp.avatar.hd";
    if (!u.agG((String)localObject))
    {
      Log.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(130964);
          Log.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            u.deleteFile(this.maO);
          }
          ah.Yy();
          h.aGY().b(157, ah.boU());
          AppMethodBeat.o(130964);
        }
      };
    }
    h.aGY().a(157, callback);
    localObject = new n(1, (String)localObject);
    h.aGY().a((q)localObject, 0);
    maL = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ah
 * JD-Core Version:    0.7.0.1
 */