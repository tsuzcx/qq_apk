package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class ah
{
  private static f callback = null;
  private static boolean ipD = false;
  private static int ipE = 3;
  private static long ipF = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (ipD)
    {
      ae.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((ipF == 0L) || (bu.aO(ipF) > 180000L))
    {
      ipF = bu.HQ();
      ipE = 3;
    }
    if (ipE <= 0)
    {
      ae.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    ipE -= 1;
    Object localObject = b.asr() + "temp.avatar.hd";
    if (!o.fB((String)localObject))
    {
      ae.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(130964);
          ae.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            o.deleteFile(this.ipG);
          }
          ah.JG();
          g.ajj().b(157, ah.aLB());
          AppMethodBeat.o(130964);
        }
      };
    }
    g.ajj().a(157, callback);
    localObject = new m((String)localObject);
    g.ajj().a((n)localObject, 0);
    ipD = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ah
 * JD-Core Version:    0.7.0.1
 */