package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class ag
{
  private static com.tencent.mm.ak.g callback = null;
  private static boolean hTo = false;
  private static int hTp = 3;
  private static long hTq = 0L;
  
  public static void run()
  {
    AppMethodBeat.i(130965);
    if (hTo)
    {
      ac.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      AppMethodBeat.o(130965);
      return;
    }
    if ((hTq == 0L) || (bs.aO(hTq) > 180000L))
    {
      hTq = bs.Gn();
      hTp = 3;
    }
    if (hTp <= 0)
    {
      ac.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      AppMethodBeat.o(130965);
      return;
    }
    hTp -= 1;
    Object localObject = b.apo() + "temp.avatar.hd";
    if (!i.eA((String)localObject))
    {
      ac.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      AppMethodBeat.o(130965);
      return;
    }
    if (callback == null) {
      callback = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(130964);
          ac.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            i.deleteFile(this.hTr);
          }
          ag.adZ();
          com.tencent.mm.kernel.g.agi().b(157, ag.aHT());
          AppMethodBeat.o(130964);
        }
      };
    }
    com.tencent.mm.kernel.g.agi().a(157, callback);
    localObject = new m((String)localObject);
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    hTo = true;
    AppMethodBeat.o(130965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */