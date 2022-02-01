package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class d
  implements com.google.android.exoplayer2.h.g
{
  private long die;
  private final a dja;
  private final com.google.android.exoplayer2.h.g djh;
  private final com.google.android.exoplayer2.h.g dji;
  private final com.google.android.exoplayer2.h.g djj;
  private final d.a djk;
  private final boolean djl;
  private final boolean djm;
  private final boolean djn;
  private com.google.android.exoplayer2.h.g djo;
  private boolean djp;
  private long djq;
  private g djr;
  private boolean djs;
  private boolean djt;
  private long dju;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, d.a parama1)
  {
    AppMethodBeat.i(92966);
    this.dja = parama;
    this.djh = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.djl = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.djm = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.djn = bool1;
      this.djj = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.dji = new v(paramg1, paramf);; this.dji = null)
    {
      this.djk = parama1;
      AppMethodBeat.o(92966);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label48;
      bool1 = false;
      break label65;
    }
  }
  
  private void Ur()
  {
    AppMethodBeat.i(92973);
    if (this.djo == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.djo.close();
      this.djo = null;
      this.djp = false;
      return;
    }
    finally
    {
      if (this.djr != null)
      {
        this.dja.a(this.djr);
        this.djr = null;
      }
      AppMethodBeat.o(92973);
    }
    AppMethodBeat.o(92973);
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.djo == this.djh) || ((paramIOException instanceof a.a))) {
      this.djs = true;
    }
  }
  
  private boolean bC(boolean paramBoolean)
  {
    AppMethodBeat.i(92971);
    Object localObject1;
    if (this.djt)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.djo = this.djj;
      localObject1 = new j(this.uri, this.djq, this.die, this.key, this.flags);
      label57:
      if (((j)localObject1).length != -1L) {
        break label431;
      }
    }
    label405:
    label431:
    for (bool = true;; bool = false)
    {
      for (;;)
      {
        this.djp = bool;
        bool = false;
        try
        {
          l1 = this.djo.a((j)localObject1);
          paramBoolean = true;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            long l3;
            long l2;
            IOException localIOException2 = localIOException1;
            if (!paramBoolean)
            {
              localIOException2 = localIOException1;
              if (!this.djp) {}
            }
            for (Object localObject4 = localIOException1;; localObject4 = ((Throwable)localObject4).getCause())
            {
              localIOException2 = localIOException1;
              if (localObject4 != null)
              {
                if (((localObject4 instanceof com.google.android.exoplayer2.h.h)) && (((com.google.android.exoplayer2.h.h)localObject4).reason == 0)) {
                  localIOException2 = null;
                }
              }
              else
              {
                if (localIOException2 == null) {
                  break;
                }
                AppMethodBeat.o(92971);
                throw localIOException2;
              }
            }
            long l1 = 0L;
            paramBoolean = bool;
          }
        }
        if ((this.djp) && (l1 != -1L))
        {
          this.die = l1;
          cD(((j)localObject1).position + this.die);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.djl) {
          try
          {
            localObject1 = this.dja.e(this.key, this.djq);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.dja.f(this.key, this.djq);
      break;
      label203:
      if (((g)localObject2).djy)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.djq - ((g)localObject2).position;
        l2 = ((g)localObject2).length - l3;
        l1 = l2;
        if (this.die != -1L) {
          l1 = Math.min(l2, this.die);
        }
        localObject2 = new j((Uri)localObject3, this.djq, l3, l1, this.key, this.flags);
        this.djo = this.djh;
        break label57;
      }
      if (((g)localObject2).Ut()) {
        l1 = this.die;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.djq, l1, this.key, this.flags);
        if (this.dji == null) {
          break label405;
        }
        this.djo = this.dji;
        this.djr = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).length;
        l1 = l2;
        if (this.die != -1L) {
          l1 = Math.min(l2, this.die);
        }
      }
      this.djo = this.djj;
      this.dja.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void cD(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.djo == this.dji) {
      this.dja.g(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  public final long a(j paramj)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92967);
    try
    {
      this.uri = paramj.uri;
      this.flags = paramj.flags;
      this.key = h.c(paramj);
      this.djq = paramj.position;
      boolean bool1;
      if (this.djm)
      {
        bool1 = bool2;
        if (this.djs) {}
      }
      else
      {
        if ((paramj.length != -1L) || (!this.djn)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.djt = bool1;
      if ((paramj.length != -1L) || (this.djt)) {
        this.die = paramj.length;
      }
      label126:
      do
      {
        do
        {
          bC(true);
          long l = this.die;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.die = this.dja.cS(this.key);
        } while (this.die == -1L);
        this.die -= paramj.position;
      } while (this.die > 0L);
      paramj = new com.google.android.exoplayer2.h.h();
      AppMethodBeat.o(92967);
      throw paramj;
    }
    catch (IOException paramj)
    {
      b(paramj);
      AppMethodBeat.o(92967);
      throw paramj;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(92970);
    this.uri = null;
    if ((this.djk != null) && (this.dju > 0L))
    {
      this.djk.H(this.dja.Uo(), this.dju);
      this.dju = 0L;
    }
    try
    {
      Ur();
      AppMethodBeat.o(92970);
      return;
    }
    catch (IOException localIOException)
    {
      b(localIOException);
      AppMethodBeat.o(92970);
      throw localIOException;
    }
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(92969);
    if (this.djo == this.djj)
    {
      localUri = this.djo.getUri();
      AppMethodBeat.o(92969);
      return localUri;
    }
    Uri localUri = this.uri;
    AppMethodBeat.o(92969);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92968);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(92968);
      return 0;
    }
    if (this.die == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.djo.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.djo == this.djh) {
          this.dju += i;
        }
        this.djq += i;
        if (this.die != -1L) {
          this.die -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.djp)
        {
          cD(this.djq);
          this.die = 0L;
        }
        Ur();
      } while (((this.die <= 0L) && (this.die != -1L)) || (!bC(false)));
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92968);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(92968);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.d
 * JD-Core Version:    0.7.0.1
 */