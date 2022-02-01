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
  private long bom;
  private final com.google.android.exoplayer2.h.g bpD;
  private final com.google.android.exoplayer2.h.g bpE;
  private final com.google.android.exoplayer2.h.g bpF;
  private final d.a bpG;
  private final boolean bpH;
  private final boolean bpI;
  private final boolean bpJ;
  private com.google.android.exoplayer2.h.g bpK;
  private boolean bpL;
  private long bpM;
  private g bpN;
  private boolean bpO;
  private boolean bpP;
  private long bpQ;
  private final a bpx;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, d.a parama1)
  {
    AppMethodBeat.i(92966);
    this.bpx = parama;
    this.bpD = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.bpH = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.bpI = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.bpJ = bool1;
      this.bpF = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.bpE = new v(paramg1, paramf);; this.bpE = null)
    {
      this.bpG = parama1;
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
  
  private boolean aU(boolean paramBoolean)
  {
    AppMethodBeat.i(92971);
    Object localObject1;
    if (this.bpP)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.bpK = this.bpF;
      localObject1 = new j(this.uri, this.bpM, this.bom, this.key, this.flags);
      label57:
      if (((j)localObject1).aFL != -1L) {
        break label431;
      }
    }
    label405:
    label431:
    for (bool = true;; bool = false)
    {
      for (;;)
      {
        this.bpL = bool;
        bool = false;
        try
        {
          l1 = this.bpK.a((j)localObject1);
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
              if (!this.bpL) {}
            }
            for (Object localObject4 = localIOException1;; localObject4 = ((Throwable)localObject4).getCause())
            {
              localIOException2 = localIOException1;
              if (localObject4 != null)
              {
                if (((localObject4 instanceof com.google.android.exoplayer2.h.h)) && (((com.google.android.exoplayer2.h.h)localObject4).bnA == 0)) {
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
        if ((this.bpL) && (l1 != -1L))
        {
          this.bom = l1;
          ap(((j)localObject1).position + this.bom);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.bpH) {
          try
          {
            localObject1 = this.bpx.e(this.key, this.bpM);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.bpx.f(this.key, this.bpM);
      break;
      label203:
      if (((g)localObject2).bpU)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.bpM - ((g)localObject2).position;
        l2 = ((g)localObject2).aFL - l3;
        l1 = l2;
        if (this.bom != -1L) {
          l1 = Math.min(l2, this.bom);
        }
        localObject2 = new j((Uri)localObject3, this.bpM, l3, l1, this.key, this.flags);
        this.bpK = this.bpD;
        break label57;
      }
      if (((g)localObject2).uU()) {
        l1 = this.bom;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.bpM, l1, this.key, this.flags);
        if (this.bpE == null) {
          break label405;
        }
        this.bpK = this.bpE;
        this.bpN = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).aFL;
        l1 = l2;
        if (this.bom != -1L) {
          l1 = Math.min(l2, this.bom);
        }
      }
      this.bpK = this.bpF;
      this.bpx.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void ap(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.bpK == this.bpE) {
      this.bpx.g(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.bpK == this.bpD) || ((paramIOException instanceof a.a))) {
      this.bpO = true;
    }
  }
  
  private void uS()
  {
    AppMethodBeat.i(92973);
    if (this.bpK == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.bpK.close();
      this.bpK = null;
      this.bpL = false;
      return;
    }
    finally
    {
      if (this.bpN != null)
      {
        this.bpx.a(this.bpN);
        this.bpN = null;
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
      this.bpM = paramj.position;
      boolean bool1;
      if (this.bpI)
      {
        bool1 = bool2;
        if (this.bpO) {}
      }
      else
      {
        if ((paramj.aFL != -1L) || (!this.bpJ)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.bpP = bool1;
      if ((paramj.aFL != -1L) || (this.bpP)) {
        this.bom = paramj.aFL;
      }
      label126:
      do
      {
        do
        {
          aU(true);
          long l = this.bom;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.bom = this.bpx.bA(this.key);
        } while (this.bom == -1L);
        this.bom -= paramj.position;
      } while (this.bom > 0L);
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
    if ((this.bpG != null) && (this.bpQ > 0L))
    {
      this.bpG.l(this.bpx.uP(), this.bpQ);
      this.bpQ = 0L;
    }
    try
    {
      uS();
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
    if (this.bpK == this.bpF)
    {
      localUri = this.bpK.getUri();
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
    if (this.bom == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.bpK.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.bpK == this.bpD) {
          this.bpQ += i;
        }
        this.bpM += i;
        if (this.bom != -1L) {
          this.bom -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.bpL)
        {
          ap(this.bpM);
          this.bom = 0L;
        }
        uS();
      } while (((this.bom <= 0L) && (this.bom != -1L)) || (!aU(false)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.d
 * JD-Core Version:    0.7.0.1
 */