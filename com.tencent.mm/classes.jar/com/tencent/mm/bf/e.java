package com.tencent.mm.bf;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.app.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.vfs.j;

public final class e
{
  private static e fRl = null;
  private j.a appForegroundListener;
  private byte[] eFQ;
  az fBI;
  private String fRm;
  private f onSceneEndCallback;
  
  private e()
  {
    AppMethodBeat.i(116559);
    this.appForegroundListener = new e.1(this);
    this.fBI = new az(1, "speex_worker");
    this.eFQ = new byte[0];
    this.onSceneEndCallback = new e.4(this);
    this.appForegroundListener.alive();
    AppMethodBeat.o(116559);
  }
  
  public static e aks()
  {
    AppMethodBeat.i(116560);
    if (fRl == null) {
      fRl = new e();
    }
    e locale = fRl;
    AppMethodBeat.o(116560);
    return locale;
  }
  
  private static com.tencent.mm.vfs.b cF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116563);
    Object localObject1 = new com.tencent.mm.vfs.b(b.aki());
    if ((!((com.tencent.mm.vfs.b)localObject1).exists()) || (!((com.tencent.mm.vfs.b)localObject1).isDirectory()))
    {
      AppMethodBeat.o(116563);
      return null;
    }
    com.tencent.mm.vfs.b[] arrayOfb = ((com.tencent.mm.vfs.b)localObject1).dQL();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfb != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfb.length)
      {
        localObject2 = arrayOfb[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.vfs.b)localObject2).isFile())
          {
            ab.d("MicroMsg.SpeexUploadCore", "file " + j.p(((com.tencent.mm.vfs.b)localObject2).mUri));
            localObject1 = j.p(((com.tencent.mm.vfs.b)localObject2).mUri);
            l = ((com.tencent.mm.vfs.b)localObject2).length();
            if (((com.tencent.mm.vfs.b)localObject2).getName().endsWith(".spx")) {
              break label169;
            }
          }
        }
        for (localObject1 = null;; localObject1 = null)
        {
          i += 1;
          break;
          label169:
          if ((l >= paramInt1) && (l <= paramInt2)) {
            break label226;
          }
          ab.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          com.tencent.mm.vfs.e.deleteFile((String)localObject1);
        }
      }
    }
    label226:
    AppMethodBeat.o(116563);
    return localObject2;
  }
  
  public final void b(az.a parama)
  {
    AppMethodBeat.i(116561);
    ab.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.fBI.e(parama);
    AppMethodBeat.o(116561);
  }
  
  public final void start()
  {
    AppMethodBeat.i(116562);
    if (!at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(116562);
      return;
    }
    new ak(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145807);
        Looper.myQueue().addIdleHandler(new e.3.1(this));
        AppMethodBeat.o(145807);
      }
    }, 100L);
    AppMethodBeat.o(116562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bf.e
 * JD-Core Version:    0.7.0.1
 */