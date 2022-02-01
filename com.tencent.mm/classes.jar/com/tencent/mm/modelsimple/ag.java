package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class ag
{
  private static f callback = null;
  private static boolean imJ = false;
  private static int imK = 3;
  private static long imL = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (imJ)
    {
      ad.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((imL == 0L) || (bt.aO(imL) > 180000L))
    {
      imL = bt.HI();
      imK = 3;
    }
    if (imK <= 0)
    {
      ad.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    imK -= 1;
    Object localObject = b.asc() + "temp.avatar.hd";
    if (!i.fv((String)localObject))
    {
      ad.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(130964);
          ad.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            i.deleteFile(this.imM);
          }
          ag.Jy();
          g.aiU().b(157, ag.aLe());
          AppMethodBeat.o(130964);
        }
      };
    }
    g.aiU().a(157, callback);
    localObject = new m((String)localObject);
    g.aiU().a((n)localObject, 0);
    imJ = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */