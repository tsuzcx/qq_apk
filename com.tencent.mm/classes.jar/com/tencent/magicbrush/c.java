package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class c
{
  private int clA;
  private int clB;
  private float clC;
  private Queue<Float> clD;
  private float clE;
  private int clF;
  private int clG;
  private boolean clH;
  private a clI;
  private a clJ;
  private final MBRuntime clw;
  public SparseLongArray clx;
  private a cly;
  final b clz;
  Handler handler;
  private boolean hasInit;
  
  c(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.clx = new SparseLongArray();
    this.cly = new a((byte)0);
    this.clz = new b((byte)0);
    this.clD = new LinkedList();
    this.clI = new a();
    this.clJ = new a();
    this.clw = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  public final int FA()
  {
    synchronized (this.clw)
    {
      int i = this.clI.clL;
      return i;
    }
  }
  
  public final float FB()
  {
    AppMethodBeat.i(139933);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.clw.nativeGetCurrentFpsVariance(this.clw.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void FC()
  {
    AppMethodBeat.i(139934);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.clw.nativeSetEnableInspectFpsVariance(this.clw.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int FD()
  {
    AppMethodBeat.i(139935);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.clw.nativeGetFrameCounter(this.clw.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int FE()
  {
    AppMethodBeat.i(139936);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.clw.nativeGetDrawCalls(this.clw.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int FF()
  {
    AppMethodBeat.i(139937);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.clw.nativeGetVertexes(this.clw.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int FG()
  {
    AppMethodBeat.i(139938);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.clw.nativeGetTriangles(this.clw.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void FH()
  {
    AppMethodBeat.i(139939);
    synchronized (this.clw)
    {
      if (this.clw.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.clw.nativeGetCurrentFps(this.clw.mNativeInst);
      this.cly.clj = localObject1[0];
      this.cly.clk = localObject1[1];
      if (this.hasInit)
      {
        this.clF += 1;
        if (this.clF > this.clG)
        {
          this.clF = 1;
          if (this.clH)
          {
            this.clI.clL = 0;
            this.clI.clK = 0;
          }
        }
        if (this.cly.clj < this.clC)
        {
          localObject1 = this.clI;
          ((a)localObject1).clL += 1;
        }
        if ((this.clD.size() >= this.clA) && (this.clA > 0))
        {
          if (this.cly.clj * this.clA + this.clB < this.clE)
          {
            localObject1 = this.clI;
            ((a)localObject1).clK += 1;
          }
          this.clE -= ((Float)this.clD.remove()).floatValue();
        }
        this.clD.add(Float.valueOf(this.cly.clj));
        this.clE += this.cly.clj;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  final void Fw()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.clz);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a Fx()
  {
    synchronized (this.clw)
    {
      a locala = this.cly;
      return locala;
    }
  }
  
  public final a Fy()
  {
    synchronized (this.clw)
    {
      this.clJ.clL = this.clI.clL;
      this.clJ.clK = this.clI.clK;
      this.clI.clL = 0;
      this.clI.clK = 0;
      a locala = this.clJ;
      return locala;
    }
  }
  
  public final int Fz()
  {
    synchronized (this.clw)
    {
      int i = this.clI.clK;
      return i;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.clw)
    {
      this.clA = paramInt1;
      this.clC = paramFloat;
      this.clB = (paramInt1 * paramInt2);
      this.clG = paramInt3;
      this.clH = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  public final float gL(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (FD() - paramInt) * 1000.0F / (float)h.aO(this.clx.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public int clK;
    public int clL;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      c.this.FH();
      c.this.handler.postDelayed(c.this.clz, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */