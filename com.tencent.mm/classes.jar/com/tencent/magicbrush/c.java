package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class c
{
  private final MBRuntime cvY;
  public SparseLongArray cvZ;
  private a cwa;
  final b cwb;
  private int cwc;
  private int cwd;
  private float cwe;
  private Queue<Float> cwf;
  private float cwg;
  private int cwh;
  private int cwi;
  private boolean cwj;
  private a cwk;
  private a cwl;
  Handler handler;
  private boolean hasInit;
  
  c(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.cvZ = new SparseLongArray();
    this.cwa = new a((byte)0);
    this.cwb = new b((byte)0);
    this.cwf = new LinkedList();
    this.cwk = new a();
    this.cwl = new a();
    this.cvY = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  final void GQ()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.cwb);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a GR()
  {
    synchronized (this.cvY)
    {
      a locala = this.cwa;
      return locala;
    }
  }
  
  public final a GS()
  {
    synchronized (this.cvY)
    {
      this.cwl.cwn = this.cwk.cwn;
      this.cwl.cwm = this.cwk.cwm;
      this.cwk.cwn = 0;
      this.cwk.cwm = 0;
      a locala = this.cwl;
      return locala;
    }
  }
  
  public final int GT()
  {
    synchronized (this.cvY)
    {
      int i = this.cwk.cwm;
      return i;
    }
  }
  
  public final int GU()
  {
    synchronized (this.cvY)
    {
      int i = this.cwk.cwn;
      return i;
    }
  }
  
  public final float GV()
  {
    AppMethodBeat.i(139933);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.cvY.nativeGetCurrentFpsVariance(this.cvY.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void GW()
  {
    AppMethodBeat.i(139934);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.cvY.nativeSetEnableInspectFpsVariance(this.cvY.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int GX()
  {
    AppMethodBeat.i(139935);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.cvY.nativeGetFrameCounter(this.cvY.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int GY()
  {
    AppMethodBeat.i(139936);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.cvY.nativeGetDrawCalls(this.cvY.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int GZ()
  {
    AppMethodBeat.i(139937);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.cvY.nativeGetVertexes(this.cvY.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int Ha()
  {
    AppMethodBeat.i(139938);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.cvY.nativeGetTriangles(this.cvY.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void Hb()
  {
    AppMethodBeat.i(139939);
    synchronized (this.cvY)
    {
      if (this.cvY.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.cvY.nativeGetCurrentFps(this.cvY.mNativeInst);
      this.cwa.cvL = localObject1[0];
      this.cwa.cvM = localObject1[1];
      if (this.hasInit)
      {
        this.cwh += 1;
        if (this.cwh > this.cwi)
        {
          this.cwh = 1;
          if (this.cwj)
          {
            this.cwk.cwn = 0;
            this.cwk.cwm = 0;
          }
        }
        if (this.cwa.cvL < this.cwe)
        {
          localObject1 = this.cwk;
          ((a)localObject1).cwn += 1;
        }
        if ((this.cwf.size() >= this.cwc) && (this.cwc > 0))
        {
          if (this.cwa.cvL * this.cwc + this.cwd < this.cwg)
          {
            localObject1 = this.cwk;
            ((a)localObject1).cwm += 1;
          }
          this.cwg -= ((Float)this.cwf.remove()).floatValue();
        }
        this.cwf.add(Float.valueOf(this.cwa.cvL));
        this.cwg += this.cwa.cvL;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.cvY)
    {
      this.cwc = paramInt1;
      this.cwe = paramFloat;
      this.cwd = (paramInt1 * paramInt2);
      this.cwi = paramInt3;
      this.cwj = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  public final float gQ(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (GX() - paramInt) * 1000.0F / (float)h.aO(this.cvZ.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public int cwm;
    public int cwn;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      c.this.Hb();
      c.this.handler.postDelayed(c.this.cwb, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */