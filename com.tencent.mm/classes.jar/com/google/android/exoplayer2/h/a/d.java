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
  private long bus;
  private final boolean bvA;
  private com.google.android.exoplayer2.h.g bvB;
  private boolean bvC;
  private long bvD;
  private g bvE;
  private boolean bvF;
  private boolean bvG;
  private long bvH;
  private final a bvo;
  private final com.google.android.exoplayer2.h.g bvu;
  private final com.google.android.exoplayer2.h.g bvv;
  private final com.google.android.exoplayer2.h.g bvw;
  private final d.a bvx;
  private final boolean bvy;
  private final boolean bvz;
  private int flags;
  private String key;
  private Uri uri;
  
  public d(a parama, com.google.android.exoplayer2.h.g paramg1, com.google.android.exoplayer2.h.g paramg2, f paramf, int paramInt, d.a parama1)
  {
    AppMethodBeat.i(92966);
    this.bvo = parama;
    this.bvu = paramg2;
    boolean bool1;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      this.bvy = bool1;
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
      bool1 = true;
      label48:
      this.bvz = bool1;
      if ((paramInt & 0x4) == 0) {
        break label119;
      }
      bool1 = bool2;
      label65:
      this.bvA = bool1;
      this.bvw = paramg1;
      if (paramf == null) {
        break label125;
      }
    }
    label113:
    label119:
    label125:
    for (this.bvv = new v(paramg1, paramf);; this.bvv = null)
    {
      this.bvx = parama1;
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
    if (this.bvG)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
      this.bvB = this.bvw;
      localObject1 = new j(this.uri, this.bvD, this.bus, this.key, this.flags);
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
        this.bvC = bool;
        bool = false;
        try
        {
          l1 = this.bvB.a((j)localObject1);
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
              if (!this.bvC) {}
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
        if ((this.bvC) && (l1 != -1L))
        {
          this.bus = l1;
          setContentLength(((j)localObject1).position + this.bus);
        }
        AppMethodBeat.o(92971);
        return paramBoolean;
        if (this.bvy) {
          try
          {
            localObject1 = this.bvo.d(this.key, this.bvD);
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject2 = new InterruptedIOException();
            AppMethodBeat.o(92971);
            throw ((Throwable)localObject2);
          }
        }
      }
      localObject2 = this.bvo.e(this.key, this.bvD);
      break;
      label203:
      if (((g)localObject2).bvL)
      {
        localObject3 = Uri.fromFile(((g)localObject2).file);
        l3 = this.bvD - ((g)localObject2).position;
        l2 = ((g)localObject2).length - l3;
        l1 = l2;
        if (this.bus != -1L) {
          l1 = Math.min(l2, this.bus);
        }
        localObject2 = new j((Uri)localObject3, this.bvD, l3, l1, this.key, this.flags);
        this.bvB = this.bvu;
        break label57;
      }
      if (((g)localObject2).vn()) {
        l1 = this.bus;
      }
      for (;;)
      {
        localObject3 = new j(this.uri, this.bvD, l1, this.key, this.flags);
        if (this.bvv == null) {
          break label405;
        }
        this.bvB = this.bvv;
        this.bvE = ((g)localObject2);
        localObject2 = localObject3;
        break;
        l2 = ((g)localObject2).length;
        l1 = l2;
        if (this.bus != -1L) {
          l1 = Math.min(l2, this.bus);
        }
      }
      this.bvB = this.bvw;
      this.bvo.a((g)localObject2);
      localObject2 = localObject3;
      break label57;
    }
  }
  
  private void b(IOException paramIOException)
  {
    if ((this.bvB == this.bvu) || ((paramIOException instanceof a.a))) {
      this.bvF = true;
    }
  }
  
  private void setContentLength(long paramLong)
  {
    AppMethodBeat.i(92972);
    if (this.bvB == this.bvv) {
      this.bvo.f(this.key, paramLong);
    }
    AppMethodBeat.o(92972);
  }
  
  private void vl()
  {
    AppMethodBeat.i(92973);
    if (this.bvB == null)
    {
      AppMethodBeat.o(92973);
      return;
    }
    try
    {
      this.bvB.close();
      this.bvB = null;
      this.bvC = false;
      return;
    }
    finally
    {
      if (this.bvE != null)
      {
        this.bvo.a(this.bvE);
        this.bvE = null;
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
      this.bvD = paramj.position;
      boolean bool1;
      if (this.bvz)
      {
        bool1 = bool2;
        if (this.bvF) {}
      }
      else
      {
        if ((paramj.length != -1L) || (!this.bvA)) {
          break label126;
        }
        bool1 = bool2;
      }
      this.bvG = bool1;
      if ((paramj.length != -1L) || (this.bvG)) {
        this.bus = paramj.length;
      }
      label126:
      do
      {
        do
        {
          aW(true);
          long l = this.bus;
          AppMethodBeat.o(92967);
          return l;
          bool1 = false;
          break;
          this.bus = this.bvo.aw(this.key);
        } while (this.bus == -1L);
        this.bus -= paramj.position;
      } while (this.bus > 0L);
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
    if ((this.bvx != null) && (this.bvH > 0L))
    {
      this.bvx.k(this.bvo.vi(), this.bvH);
      this.bvH = 0L;
    }
    try
    {
      vl();
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
    if (this.bvB == this.bvw)
    {
      localUri = this.bvB.getUri();
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
    if (this.bus == 0L)
    {
      AppMethodBeat.o(92968);
      return -1;
    }
    try
    {
      int i = this.bvB.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i >= 0)
      {
        if (this.bvB == this.bvu) {
          this.bvH += i;
        }
        this.bvD += i;
        if (this.bus != -1L) {
          this.bus -= i;
        }
      }
      do
      {
        AppMethodBeat.o(92968);
        return i;
        if (this.bvC)
        {
          setContentLength(this.bvD);
          this.bus = 0L;
        }
        vl();
      } while (((this.bus <= 0L) && (this.bus != -1L)) || (!aW(false)));
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