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
  private long bEJ;
  private final a bFT;
  private final com.google.android.exoplayer2.h.g bFZ;
  private final com.google.android.exoplayer2.h.g bGa;
  private final com.google.android.exoplayer2.h.g bGb;
  private final a bGc;
  private final boolean bGd;
  private final boolean bGe;
  private final boolean bGf;
  private com.google.android.exoplayer2.h.g bGg;
  private boolean bGh;
  private long bGi;
  private g bGj;
  private boolean bGk;
  private boolean bGl;
  private long bGm;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, a parama1)
  {
    AppMethodBeat.i(92966);
    this.bFT = parama;
    this.bFZ = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.bGd = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.bGe = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.bGf = bool1;
      this.bGb = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.bGa = new v(paramg1, paramf);; this.bGa = null)
    {
      this.bGc = parama1;
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
  
  private boolean aW(boolean paramBoolean)
  {
    AppMethodBeat.i(92971);
    Object localObject1;
    if (this.bGl)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.bGg = this.bGb;
      localObject1 = new j(this.uri, this.bGi, this.bEJ, this.key, this.flags);
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
        this.bGh = bool;
        bool = false;
        try
        {
          l1 = this.bGg.a((j)localObject1);
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
              if (!this.bGh) {}
            }
            for (Object localObject4 = localIOException1;; localObject4 = ((Throwable)localObject4).getCause())
            {
              localIOException2 = localIOException1;
              if (localObject4 != null)
              {
                if (((localObject4 instanceof com.google.android.exoplayer2.h.h)) && (((com.google.android.exoplayer2.h.h)localObject4).bDZ == 0)) {
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
        if ((this.bGh) && (l1 != -1L))
        {
          this.bEJ = l1;
          setContentLength(((j)localObject1).position + this.bEJ);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.bGd) {
          try
          {
            localObject1 = this.bFT.e(this.key, this.bGi);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.bFT.f(this.key, this.bGi);
      break;
      label203:
      if (((g)localObject2).bGq)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.bGi - ((g)localObject2).position;
        l2 = ((g)localObject2).length - l3;
        l1 = l2;
        if (this.bEJ != -1L) {
          l1 = Math.min(l2, this.bEJ);
        }
        localObject2 = new j((Uri)localObject3, this.bGi, l3, l1, this.key, this.flags);
        this.bGg = this.bFZ;
        break label57;
      }
      if (((g)localObject2).wS()) {
        l1 = this.bEJ;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.bGi, l1, this.key, this.flags);
        if (this.bGa == null) {
          break label405;
        }
        this.bGg = this.bGa;
        this.bGj = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).length;
        l1 = l2;
        if (this.bEJ != -1L) {
          l1 = Math.min(l2, this.bEJ);
        }
      }
      this.bGg = this.bGb;
      this.bFT.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.bGg == this.bFZ) || ((paramIOException instanceof a.a))) {
      this.bGk = true;
    }
  }
  
  private void setContentLength(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.bGg == this.bGa) {
      this.bFT.g(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  private void wQ()
  {
    AppMethodBeat.i(92973);
    if (this.bGg == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.bGg.close();
      this.bGg = null;
      this.bGh = false;
      return;
    }
    finally
    {
      if (this.bGj != null)
      {
        this.bFT.a(this.bGj);
        this.bGj = null;
      }
      AppMethodBeat.o(92973);
    }
    AppMethodBeat.o(92973);
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
      this.bGi = paramj.position;
      boolean bool1;
      if (this.bGe)
      {
        bool1 = bool2;
        if (this.bGk) {}
      }
      else
      {
        if ((paramj.length != -1L) || (!this.bGf)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.bGl = bool1;
      if ((paramj.length != -1L) || (this.bGl)) {
        this.bEJ = paramj.length;
      }
      label126:
      do
      {
        do
        {
          aW(true);
          long l = this.bEJ;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.bEJ = this.bFT.bp(this.key);
        } while (this.bEJ == -1L);
        this.bEJ -= paramj.position;
      } while (this.bEJ > 0L);
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
    if ((this.bGc != null) && (this.bGm > 0L))
    {
      this.bGc.k(this.bFT.wN(), this.bGm);
      this.bGm = 0L;
    }
    try
    {
      wQ();
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
    if (this.bGg == this.bGb)
    {
      localUri = this.bGg.getUri();
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
    if (this.bEJ == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.bGg.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.bGg == this.bFZ) {
          this.bGm += i;
        }
        this.bGi += i;
        if (this.bEJ != -1L) {
          this.bEJ -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.bGh)
        {
          setContentLength(this.bGi);
          this.bEJ = 0L;
        }
        wQ();
      } while (((this.bEJ <= 0L) && (this.bEJ != -1L)) || (!aW(false)));
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
  
  public static abstract interface a
  {
    public abstract void k(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.d
 * JD-Core Version:    0.7.0.1
 */