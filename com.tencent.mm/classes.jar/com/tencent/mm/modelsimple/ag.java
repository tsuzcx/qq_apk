package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class ag
{
  private static com.tencent.mm.al.g callback = null;
  private static boolean hsM = false;
  private static int hsN = 3;
  private static long hsO = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (hsM)
    {
      ad.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((hsO == 0L) || (bt.aS(hsO) > 180000L))
    {
      hsO = bt.GC();
      hsN = 3;
    }
    if (hsN <= 0)
    {
      ad.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    hsN -= 1;
    Object localObject = b.aio() + "temp.avatar.hd";
    if (!i.eK((String)localObject))
    {
      ad.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(130964);
          ad.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            i.deleteFile(this.hsP);
          }
          ag.acT();
          com.tencent.mm.kernel.g.aeS().b(157, ag.aBd());
          AppMethodBeat.o(130964);
        }
      };
    }
    com.tencent.mm.kernel.g.aeS().a(157, callback);
    localObject = new m((String)localObject);
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    hsM = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */