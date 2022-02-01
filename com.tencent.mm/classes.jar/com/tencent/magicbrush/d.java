package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class d
{
  private final MBRuntime cKJ;
  public SparseLongArray cKL;
  private a cKM;
  final b cKN;
  private int cKO;
  private int cKP;
  private float cKQ;
  private Queue<Float> cKR;
  private float cKS;
  private int cKT;
  private int cKU;
  private boolean cKV;
  private a cKW;
  private a cKX;
  Handler handler;
  private boolean hasInit;
  
  d(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.cKL = new SparseLongArray();
    this.cKM = new a((byte)0);
    this.cKN = new b((byte)0);
    this.cKR = new LinkedList();
    this.cKW = new a();
    this.cKX = new a();
    this.cKJ = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  final void QO()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.cKN);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a QP()
  {
    synchronized (this.cKJ)
    {
      a locala = this.cKM;
      return locala;
    }
  }
  
  public final a QQ()
  {
    synchronized (this.cKJ)
    {
      this.cKX.cKZ = this.cKW.cKZ;
      this.cKX.cKY = this.cKW.cKY;
      this.cKW.cKZ = 0;
      this.cKW.cKY = 0;
      a locala = this.cKX;
      return locala;
    }
  }
  
  public final int QR()
  {
    synchronized (this.cKJ)
    {
      int i = this.cKW.cKY;
      return i;
    }
  }
  
  public final int QS()
  {
    synchronized (this.cKJ)
    {
      int i = this.cKW.cKZ;
      return i;
    }
  }
  
  public final float QT()
  {
    AppMethodBeat.i(139933);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.cKJ.nativeGetCurrentFpsVariance(this.cKJ.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void QU()
  {
    AppMethodBeat.i(139934);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.cKJ.nativeSetEnableInspectFpsVariance(this.cKJ.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int QV()
  {
    AppMethodBeat.i(139935);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.cKJ.nativeGetFrameCounter(this.cKJ.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int QW()
  {
    AppMethodBeat.i(139936);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.cKJ.nativeGetDrawCalls(this.cKJ.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int QX()
  {
    AppMethodBeat.i(139937);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.cKJ.nativeGetVertexes(this.cKJ.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int QY()
  {
    AppMethodBeat.i(139938);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.cKJ.nativeGetTriangles(this.cKJ.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void QZ()
  {
    AppMethodBeat.i(139939);
    synchronized (this.cKJ)
    {
      if (this.cKJ.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.cKJ.nativeGetCurrentFps(this.cKJ.mNativeInst);
      this.cKM.cKu = localObject1[0];
      this.cKM.cKv = localObject1[1];
      if (this.hasInit)
      {
        this.cKT += 1;
        if (this.cKT > this.cKU)
        {
          this.cKT = 1;
          if (this.cKV)
          {
            this.cKW.cKZ = 0;
            this.cKW.cKY = 0;
          }
        }
        if (this.cKM.cKu < this.cKQ)
        {
          localObject1 = this.cKW;
          ((a)localObject1).cKZ += 1;
        }
        if ((this.cKR.size() >= this.cKO) && (this.cKO > 0))
        {
          if (this.cKM.cKu * this.cKO + this.cKP < this.cKS)
          {
            localObject1 = this.cKW;
            ((a)localObject1).cKY += 1;
          }
          this.cKS -= ((Float)this.cKR.remove()).floatValue();
        }
        this.cKR.add(Float.valueOf(this.cKM.cKu));
        this.cKS += this.cKM.cKu;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.cKJ)
    {
      this.cKO = paramInt1;
      this.cKQ = paramFloat;
      this.cKP = (paramInt1 * paramInt2);
      this.cKU = paramInt3;
      this.cKV = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  public final float ii(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (QV() - paramInt) * 1000.0F / (float)h.ticksToNow(this.cKL.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public int cKY;
    public int cKZ;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      d.this.QZ();
      d.this.handler.postDelayed(d.this.cKN, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */