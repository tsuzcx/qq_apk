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
  private long bEH;
  private final a bFC;
  private final com.google.android.exoplayer2.h.g bFI;
  private final com.google.android.exoplayer2.h.g bFJ;
  private final com.google.android.exoplayer2.h.g bFK;
  private final d.a bFL;
  private final boolean bFM;
  private final boolean bFN;
  private final boolean bFO;
  private com.google.android.exoplayer2.h.g bFP;
  private boolean bFQ;
  private long bFR;
  private g bFS;
  private boolean bFT;
  private boolean bFU;
  private long bFV;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, d.a parama1)
  {
    AppMethodBeat.i(92966);
    this.bFC = parama;
    this.bFI = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.bFM = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.bFN = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.bFO = bool1;
      this.bFK = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.bFJ = new v(paramg1, paramf);; this.bFJ = null)
    {
      this.bFL = parama1;
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
    if (this.bFU)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.bFP = this.bFK;
      localObject1 = new j(this.uri, this.bFR, this.bEH, this.key, this.flags);
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
        this.bFQ = bool;
        bool = false;
        try
        {
          l1 = this.bFP.a((j)localObject1);
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
              if (!this.bFQ) {}
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
        if ((this.bFQ) && (l1 != -1L))
        {
          this.bEH = l1;
          setContentLength(((j)localObject1).position + this.bEH);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.bFM) {
          try
          {
            localObject1 = this.bFC.d(this.key, this.bFR);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.bFC.e(this.key, this.bFR);
      break;
      label203:
      if (((g)localObject2).bFZ)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.bFR - ((g)localObject2).position;
        l2 = ((g)localObject2).length - l3;
        l1 = l2;
        if (this.bEH != -1L) {
          l1 = Math.min(l2, this.bEH);
        }
        localObject2 = new j((Uri)localObject3, this.bFR, l3, l1, this.key, this.flags);
        this.bFP = this.bFI;
        break label57;
      }
      if (((g)localObject2).wK()) {
        l1 = this.bEH;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.bFR, l1, this.key, this.flags);
        if (this.bFJ == null) {
          break label405;
        }
        this.bFP = this.bFJ;
        this.bFS = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).length;
        l1 = l2;
        if (this.bEH != -1L) {
          l1 = Math.min(l2, this.bEH);
        }
      }
      this.bFP = this.bFK;
      this.bFC.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.bFP == this.bFI) || ((paramIOException instanceof a.a))) {
      this.bFT = true;
    }
  }
  
  private void setContentLength(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.bFP == this.bFJ) {
      this.bFC.f(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  private void wI()
  {
    AppMethodBeat.i(92973);
    if (this.bFP == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.bFP.close();
      this.bFP = null;
      this.bFQ = false;
      return;
    }
    finally
    {
      if (this.bFS != null)
      {
        this.bFC.a(this.bFS);
        this.bFS = null;
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
      this.bFR = paramj.position;
      boolean bool1;
      if (this.bFN)
      {
        bool1 = bool2;
        if (this.bFT) {}
      }
      else
      {
        if ((paramj.length != -1L) || (!this.bFO)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.bFU = bool1;
      if ((paramj.length != -1L) || (this.bFU)) {
        this.bEH = paramj.length;
      }
      label126:
      do
      {
        do
        {
          aX(true);
          long l = this.bEH;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.bEH = this.bFC.bp(this.key);
        } while (this.bEH == -1L);
        this.bEH -= paramj.position;
      } while (this.bEH > 0L);
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
    if ((this.bFL != null) && (this.bFV > 0L))
    {
      this.bFL.k(this.bFC.wF(), this.bFV);
      this.bFV = 0L;
    }
    try
    {
      wI();
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
    if (this.bFP == this.bFK)
    {
      localUri = this.bFP.getUri();
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
    if (this.bEH == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.bFP.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.bFP == this.bFI) {
          this.bFV += i;
        }
        this.bFR += i;
        if (this.bEH != -1L) {
          this.bEH -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.bFQ)
        {
          setContentLength(this.bFR);
          this.bEH = 0L;
        }
        wI();
      } while (((this.bEH <= 0L) && (this.bEH != -1L)) || (!aX(false)));
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