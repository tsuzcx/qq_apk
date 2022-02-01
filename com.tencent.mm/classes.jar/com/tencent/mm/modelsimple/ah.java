package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class ah
{
  private static i callback = null;
  private static boolean jkK = false;
  private static int jkL = 3;
  private static long jkM = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (jkK)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((jkM == 0L) || (Util.ticksToNow(jkM) > 180000L))
    {
      jkM = Util.currentTicks();
      jkL = 3;
    }
    if (jkL <= 0)
    {
      Log.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    jkL -= 1;
    Object localObject = b.aKR() + "temp.avatar.hd";
    if (!s.YS((String)localObject))
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
            s.deleteFile(this.jkN);
          }
          ah.TT();
          g.azz().b(157, ah.bfE());
          AppMethodBeat.o(130964);
        }
      };
    }
    g.azz().a(157, callback);
    localObject = new m(1, (String)localObject);
    g.azz().a((q)localObject, 0);
    jkK = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ah
 * JD-Core Version:    0.7.0.1
 */