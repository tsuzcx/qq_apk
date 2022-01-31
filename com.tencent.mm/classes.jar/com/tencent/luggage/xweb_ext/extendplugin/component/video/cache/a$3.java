package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.c;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.a.f.a;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(139881);
    Object localObject2 = Uri.parse(this.val$url);
    Object localObject3 = ((Uri)localObject2).toString();
    localObject2 = new j((Uri)localObject2, this.bHZ, this.bIa, (String)localObject3);
    f.a locala = new f.a();
    a.a(this.bHX).a((String)localObject3, new a.3.1(this));
    long l3;
    long l1;
    long l2;
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(this.bHZ), Long.valueOf(this.bIa), this.val$url });
        localObject3 = a.a(this.bHX);
        c localc = a.b(this.bHX);
        byte[] arrayOfByte = new byte[131072];
        com.google.android.exoplayer2.i.a.checkNotNull(localc);
        com.google.android.exoplayer2.i.a.checkNotNull(arrayOfByte);
        String str = f.c((j)localObject2);
        l3 = ((j)localObject2).aYy;
        if (((j)localObject2).aPF != -1L)
        {
          l1 = ((j)localObject2).aPF;
          locala.bad = l1;
          locala.bab = 0L;
          locala.bac = 0L;
          break label407;
          Object localObject1;
          l2 = ((com.google.android.exoplayer2.h.a.a)localObject3).g(str, l3, localObject1);
          if (l2 <= 0L) {
            break label458;
          }
          locala.bab += l2;
          break;
        }
        else
        {
          l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).ay(str);
          continue;
          label248:
          str = f.c((j)localObject2);
          l3 = ((j)localObject2).aYy;
          if (((j)localObject2).aPF != -1L)
          {
            l1 = ((j)localObject2).aPF;
            break label477;
            l4 = ((com.google.android.exoplayer2.h.a.a)localObject3).g(str, l3, l2);
            l2 = l4;
            if (l4 > 0L) {
              break label496;
            }
            l2 = -l4;
            if (f.a((j)localObject2, l3, l2, localc, arrayOfByte, locala) >= l2) {
              break label496;
            }
          }
          else
          {
            l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).ay(str);
            break label477;
            label346:
            l2 = 9223372036854775807L;
            continue;
            label353:
            l4 = l2;
            break label507;
          }
          label359:
          AppMethodBeat.o(139881);
          return;
        }
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIOException, "cache IOException", new Object[0]);
        AppMethodBeat.o(139881);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localInterruptedException, "cache InterruptedException", new Object[0]);
        AppMethodBeat.o(139881);
        return;
      }
      label407:
      if (l1 == 0L) {
        break label449;
      }
      if (l1 == -1L) {
        break label451;
      }
      l2 = l1;
    }
    label426:
    if (l1 == -1L) {}
    for (long l4 = 0L;; l4 = l2)
    {
      l1 -= l4;
      l3 += l2;
      break label407;
      label449:
      break label248;
      label451:
      l2 = 9223372036854775807L;
      break;
      label458:
      l4 = -l2;
      l2 = l4;
      if (l4 != 9223372036854775807L) {
        break label426;
      }
      break label248;
      for (;;)
      {
        label477:
        if (l1 == 0L) {
          break label519;
        }
        if (l1 == -1L) {
          break label346;
        }
        l2 = l1;
        break;
        label496:
        if (l1 != -1L) {
          break label353;
        }
        l4 = 0L;
        label507:
        l1 -= l4;
        l3 += l2;
      }
      label519:
      break label359;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.3
 * JD-Core Version:    0.7.0.1
 */