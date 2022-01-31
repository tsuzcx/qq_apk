package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.h;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class c
  implements g
{
  private long aYs;
  private final a aZF;
  private final g aZL;
  private final g aZM;
  private final g aZN;
  private final c.a aZO;
  private final boolean aZP;
  private final boolean aZQ;
  private final boolean aZR;
  private g aZS;
  private boolean aZT;
  private long aZU;
  private e aZV;
  private boolean aZW;
  private boolean aZX;
  private long aZY;
  private int flags;
  private String key;
  private Uri uri;
  
  public c(a parama, g paramg1, g paramg2, com.google.android.exoplayer2.h.f paramf, c.a parama1)
  {
    AppMethodBeat.i(151947);
    this.aZF = parama;
    this.aZL = paramg2;
    this.aZP = true;
    this.aZQ = true;
    this.aZR = false;
    this.aZN = paramg1;
    this.aZM = new v(paramg1, paramf);
    this.aZO = parama1;
    AppMethodBeat.o(151947);
  }
  
  private boolean aK(boolean paramBoolean)
  {
    AppMethodBeat.i(151952);
    Object localObject1;
    if (this.aZX)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.aZS = this.aZN;
      localObject1 = new j(this.uri, this.aZU, this.aYs, this.key, this.flags);
      label57:
      if (((j)localObject1).aPF != -1L) {
        break label431;
      }
    }
    label405:
    label431:
    for (bool = true;; bool = false)
    {
      for (;;)
      {
        this.aZT = bool;
        bool = false;
        try
        {
          l1 = this.aZS.a((j)localObject1);
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
              if (!this.aZT) {}
            }
            for (Object localObject4 = localIOException1;; localObject4 = ((Throwable)localObject4).getCause())
            {
              localIOException2 = localIOException1;
              if (localObject4 != null)
              {
                if (((localObject4 instanceof h)) && (((h)localObject4).aXG == 0)) {
                  localIOException2 = null;
                }
              }
              else
              {
                if (localIOException2 == null) {
                  break;
                }
                AppMethodBeat.o(151952);
                throw localIOException2;
              }
            }
            long l1 = 0L;
            paramBoolean = bool;
          }
        }
        if ((this.aZT) && (l1 != -1L))
        {
          this.aYs = l1;
          setContentLength(((j)localObject1).position + this.aYs);
        }
        AppMethodBeat.o(151952);
        return paramBoolean;
        if (this.aZP) {
          try
          {
            localObject1 = this.aZF.d(this.key, this.aZU);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(151952);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.aZF.e(this.key, this.aZU);
      break;
      label203:
      if (((e)localObject2).aZZ)
      {
        localObject3 = Uri.fromFile(((e)localObject2).file);
        l3 = this.aZU - ((e)localObject2).position;
        l2 = ((e)localObject2).aPF - l3;
        l1 = l2;
        if (this.aYs != -1L) {
          l1 = Math.min(l2, this.aYs);
        }
        localObject2 = new j((Uri)localObject3, this.aZU, l3, l1, this.key, this.flags);
        this.aZS = this.aZL;
        break label57;
      }
      if (((e)localObject2).qA()) {
        l1 = this.aYs;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.aZU, l1, this.key, this.flags);
        if (this.aZM == null) {
          break label405;
        }
        this.aZS = this.aZM;
        this.aZV = ((e)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((e)localObject2).aPF;
        l1 = l2;
        if (this.aYs != -1L) {
          l1 = Math.min(l2, this.aYs);
        }
      }
      this.aZS = this.aZN;
      this.aZF.a((e)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.aZS == this.aZL) || ((paramIOException instanceof a.a))) {
      this.aZW = true;
    }
  }
  
  private void qz()
  {
    AppMethodBeat.i(151954);
    if (this.aZS == null)
    {
      AppMethodBeat.o(151954);
      return;
    }
    try
    {
      this.aZS.close();
      this.aZS = null;
      this.aZT = false;
      return;
    }
    finally
    {
      if (this.aZV != null)
      {
        this.aZF.a(this.aZV);
        this.aZV = null;
      }
      AppMethodBeat.o(151954);
    }
    AppMethodBeat.o(151954);
  }
  
  private void setContentLength(long paramLong)
  {
    AppMethodBeat.i(151953);
    if (this.aZS == this.aZM) {
      this.aZF.f(this.key, paramLong);
    }
    AppMethodBeat.o(151953);
  }
  
  public final long a(j paramj)
  {
    boolean bool2 = true;
    AppMethodBeat.i(151948);
    try
    {
      this.uri = paramj.uri;
      this.flags = paramj.flags;
      this.key = f.c(paramj);
      this.aZU = paramj.position;
      boolean bool1;
      if (this.aZQ)
      {
        bool1 = bool2;
        if (this.aZW) {}
      }
      else
      {
        if ((paramj.aPF != -1L) || (!this.aZR)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.aZX = bool1;
      if ((paramj.aPF != -1L) || (this.aZX)) {
        this.aYs = paramj.aPF;
      }
      label126:
      do
      {
        do
        {
          aK(true);
          long l = this.aYs;
          AppMethodBeat.o(151948);
          return l;
          bool1 = false;
          break;
          this.aYs = this.aZF.ay(this.key);
        } while (this.aYs == -1L);
        this.aYs -= paramj.position;
      } while (this.aYs > 0L);
      paramj = new h();
      AppMethodBeat.o(151948);
      throw paramj;
    }
    catch (IOException paramj)
    {
      b(paramj);
      AppMethodBeat.o(151948);
      throw paramj;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(151951);
    this.uri = null;
    if ((this.aZO != null) && (this.aZY > 0L))
    {
      this.aZO.l(this.aZF.qw(), this.aZY);
      this.aZY = 0L;
    }
    try
    {
      qz();
      AppMethodBeat.o(151951);
      return;
    }
    catch (IOException localIOException)
    {
      b(localIOException);
      AppMethodBeat.o(151951);
      throw localIOException;
    }
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(151950);
    if (this.aZS == this.aZN)
    {
      localUri = this.aZS.getUri();
      AppMethodBeat.o(151950);
      return localUri;
    }
    Uri localUri = this.uri;
    AppMethodBeat.o(151950);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151949);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(151949);
      return 0;
    }
    if (this.aYs == 0L)
    {
      AppMethodBeat.o(151949);
      return -1;
    }
    try
    {
      int i = this.aZS.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.aZS == this.aZL) {
          this.aZY += i;
        }
        this.aZU += i;
        if (this.aYs != -1L) {
          this.aYs -= i;
        }
      }
      do
      {
        AppMethodBeat.o(151949);
        return i;
        if (this.aZT)
        {
          setContentLength(this.aZU);
          this.aYs = 0L;
        }
        qz();
      } while (((this.aYs <= 0L) && (this.aYs != -1L)) || (!aK(false)));
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(151949);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(151949);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.c
 * JD-Core Version:    0.7.0.1
 */