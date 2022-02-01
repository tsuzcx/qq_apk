package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class d
  implements com.google.android.exoplayer2.h.g
{
  private long bwt;
  private final a bxF;
  private final com.google.android.exoplayer2.h.g bxL;
  private final com.google.android.exoplayer2.h.g bxM;
  private final com.google.android.exoplayer2.h.g bxN;
  private final d.a bxO;
  private final boolean bxP;
  private final boolean bxQ;
  private final boolean bxR;
  private com.google.android.exoplayer2.h.g bxS;
  private boolean bxT;
  private long bxU;
  private g bxV;
  private boolean bxW;
  private boolean bxX;
  private long bxY;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, d.a parama1)
  {
    AppMethodBeat.i(92966);
    this.bxF = parama;
    this.bxL = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.bxP = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.bxQ = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.bxR = bool1;
      this.bxN = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.bxM = new w(paramg1, paramf);; this.bxM = null)
    {
      this.bxO = parama1;
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
  
  private boolean aX(boolean paramBoolean)
  {
    AppMethodBeat.i(92971);
    Object localObject1;
    if (this.bxX)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.bxS = this.bxN;
      localObject1 = new j(this.uri, this.bxU, this.bwt, this.key, this.flags);
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
        this.bxT = bool;
        bool = false;
        try
        {
          l1 = this.bxS.a((j)localObject1);
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
              if (!this.bxT) {}
            }
            for (Object localObject4 = localIOException1;; localObject4 = ((Throwable)localObject4).getCause())
            {
              localIOException2 = localIOException1;
              if (localObject4 != null)
              {
                if (((localObject4 instanceof com.google.android.exoplayer2.h.h)) && (((com.google.android.exoplayer2.h.h)localObject4).bvJ == 0)) {
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
        if ((this.bxT) && (l1 != -1L))
        {
          this.bwt = l1;
          setContentLength(((j)localObject1).position + this.bwt);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.bxP) {
          try
          {
            localObject1 = this.bxF.d(this.key, this.bxU);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.bxF.e(this.key, this.bxU);
      break;
      label203:
      if (((g)localObject2).byc)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.bxU - ((g)localObject2).position;
        l2 = ((g)localObject2).length - l3;
        l1 = l2;
        if (this.bwt != -1L) {
          l1 = Math.min(l2, this.bwt);
        }
        localObject2 = new j((Uri)localObject3, this.bxU, l3, l1, this.key, this.flags);
        this.bxS = this.bxL;
        break label57;
      }
      if (((g)localObject2).vw()) {
        l1 = this.bwt;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.bxU, l1, this.key, this.flags);
        if (this.bxM == null) {
          break label405;
        }
        this.bxS = this.bxM;
        this.bxV = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).length;
        l1 = l2;
        if (this.bwt != -1L) {
          l1 = Math.min(l2, this.bwt);
        }
      }
      this.bxS = this.bxN;
      this.bxF.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.bxS == this.bxL) || ((paramIOException instanceof a.a))) {
      this.bxW = true;
    }
  }
  
  private void setContentLength(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.bxS == this.bxM) {
      this.bxF.f(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  private void vu()
  {
    AppMethodBeat.i(92973);
    if (this.bxS == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.bxS.close();
      this.bxS = null;
      this.bxT = false;
      return;
    }
    finally
    {
      if (this.bxV != null)
      {
        this.bxF.a(this.bxV);
        this.bxV = null;
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
      this.bxU = paramj.position;
      boolean bool1;
      if (this.bxQ)
      {
        bool1 = bool2;
        if (this.bxW) {}
      }
      else
      {
        if ((paramj.length != -1L) || (!this.bxR)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.bxX = bool1;
      if ((paramj.length != -1L) || (this.bxX)) {
        this.bwt = paramj.length;
      }
      label126:
      do
      {
        do
        {
          aX(true);
          long l = this.bwt;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.bwt = this.bxF.aB(this.key);
        } while (this.bwt == -1L);
        this.bwt -= paramj.position;
      } while (this.bwt > 0L);
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
    if ((this.bxO != null) && (this.bxY > 0L))
    {
      this.bxO.m(this.bxF.vr(), this.bxY);
      this.bxY = 0L;
    }
    try
    {
      vu();
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
    if (this.bxS == this.bxN)
    {
      localUri = this.bxS.getUri();
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
    if (this.bwt == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.bxS.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.bxS == this.bxL) {
          this.bxY += i;
        }
        this.bxU += i;
        if (this.bwt != -1L) {
          this.bwt -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.bxT)
        {
          setContentLength(this.bxU);
          this.bwt = 0L;
        }
        vu();
      } while (((this.bwt <= 0L) && (this.bwt != -1L)) || (!aX(false)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.d
 * JD-Core Version:    0.7.0.1
 */