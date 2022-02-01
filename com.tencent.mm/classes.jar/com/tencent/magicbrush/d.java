package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class d
{
  private Queue<Float> cLA;
  private float cLB;
  private int cLC;
  private int cLD;
  private boolean cLE;
  private a cLF;
  private a cLG;
  private final MBRuntime cLt;
  public SparseLongArray cLu;
  private a cLv;
  final b cLw;
  private int cLx;
  private int cLy;
  private float cLz;
  Handler handler;
  private boolean hasInit;
  
  d(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.cLu = new SparseLongArray();
    this.cLv = new a((byte)0);
    this.cLw = new b((byte)0);
    this.cLA = new LinkedList();
    this.cLF = new a();
    this.cLG = new a();
    this.cLt = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  public final float UA()
  {
    AppMethodBeat.i(139933);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.cLt.nativeGetCurrentFpsVariance(this.cLt.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void UB()
  {
    AppMethodBeat.i(139934);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.cLt.nativeSetEnableInspectFpsVariance(this.cLt.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int UC()
  {
    AppMethodBeat.i(139935);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.cLt.nativeGetFrameCounter(this.cLt.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int UD()
  {
    AppMethodBeat.i(139936);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.cLt.nativeGetDrawCalls(this.cLt.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int UE()
  {
    AppMethodBeat.i(139937);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.cLt.nativeGetVertexes(this.cLt.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int UF()
  {
    AppMethodBeat.i(139938);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.cLt.nativeGetTriangles(this.cLt.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void UG()
  {
    AppMethodBeat.i(139939);
    synchronized (this.cLt)
    {
      if (this.cLt.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.cLt.nativeGetCurrentFps(this.cLt.mNativeInst);
      this.cLv.cLa = localObject1[0];
      this.cLv.cLb = localObject1[1];
      this.cLv.cLc = ((int)localObject1[2]);
      this.cLv.cLd = ((int)localObject1[3]);
      this.cLv.cLe = localObject1[4];
      this.cLv.cLf = ((int)localObject1[5]);
      this.cLv.cLg = ((int)localObject1[6]);
      localObject1 = this.cLF;
      ((a)localObject1).cLJ += this.cLv.cLc;
      localObject1 = this.cLF;
      ((a)localObject1).cLK += this.cLv.cLd;
      localObject1 = this.cLF;
      ((a)localObject1).cLf += this.cLv.cLf;
      localObject1 = this.cLF;
      ((a)localObject1).cLg += this.cLv.cLg;
      if (this.hasInit)
      {
        this.cLC += 1;
        if (this.cLC > this.cLD)
        {
          this.cLC = 1;
          if (this.cLE)
          {
            this.cLF.cLI = 0;
            this.cLF.cLH = 0;
          }
        }
        if (this.cLv.cLa < this.cLz)
        {
          localObject1 = this.cLF;
          ((a)localObject1).cLI += 1;
        }
        if ((this.cLA.size() >= this.cLx) && (this.cLx > 0))
        {
          if (this.cLv.cLa * this.cLx + this.cLy < this.cLB)
          {
            localObject1 = this.cLF;
            ((a)localObject1).cLH += 1;
          }
          this.cLB -= ((Float)this.cLA.remove()).floatValue();
        }
        this.cLA.add(Float.valueOf(this.cLv.cLa));
        this.cLB += this.cLv.cLa;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  final void Uv()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.cLw);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a Uw()
  {
    synchronized (this.cLt)
    {
      a locala = this.cLv;
      return locala;
    }
  }
  
  public final a Ux()
  {
    synchronized (this.cLt)
    {
      this.cLG.cLI = this.cLF.cLI;
      this.cLG.cLH = this.cLF.cLH;
      this.cLG.cLJ = this.cLF.cLJ;
      this.cLG.cLK = this.cLF.cLK;
      this.cLG.cLe = (this.cLF.cLf / this.cLF.cLg);
      this.cLF.cLI = 0;
      this.cLF.cLH = 0;
      this.cLF.cLJ = 0;
      this.cLF.cLK = 0;
      this.cLF.cLf = 0;
      this.cLF.cLg = 0;
      a locala = this.cLG;
      return locala;
    }
  }
  
  public final int Uy()
  {
    synchronized (this.cLt)
    {
      int i = this.cLF.cLH;
      return i;
    }
  }
  
  public final int Uz()
  {
    synchronized (this.cLt)
    {
      int i = this.cLF.cLI;
      return i;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.cLt)
    {
      this.cLx = paramInt1;
      this.cLz = paramFloat;
      this.cLy = (paramInt1 * paramInt2);
      this.cLD = paramInt3;
      this.cLE = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  public final float jl(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (UC() - paramInt) * 1000.0F / (float)i.ticksToNow(this.cLu.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public int cLH;
    public int cLI;
    public int cLJ;
    public int cLK;
    public float cLe;
    int cLf;
    int cLg;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      d.this.UG();
      d.this.handler.postDelayed(d.this.cLw, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */