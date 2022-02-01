package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class c
{
  private final MBRuntime cwC;
  public SparseLongArray cwD;
  private a cwE;
  final b cwF;
  private int cwG;
  private int cwH;
  private float cwI;
  private Queue<Float> cwJ;
  private float cwK;
  private int cwL;
  private int cwM;
  private boolean cwN;
  private a cwO;
  private a cwP;
  Handler handler;
  private boolean hasInit;
  
  c(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.cwD = new SparseLongArray();
    this.cwE = new a((byte)0);
    this.cwF = new b((byte)0);
    this.cwJ = new LinkedList();
    this.cwO = new a();
    this.cwP = new a();
    this.cwC = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  final void GW()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.cwF);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a GX()
  {
    synchronized (this.cwC)
    {
      a locala = this.cwE;
      return locala;
    }
  }
  
  public final a GY()
  {
    synchronized (this.cwC)
    {
      this.cwP.cwR = this.cwO.cwR;
      this.cwP.cwQ = this.cwO.cwQ;
      this.cwO.cwR = 0;
      this.cwO.cwQ = 0;
      a locala = this.cwP;
      return locala;
    }
  }
  
  public final int GZ()
  {
    synchronized (this.cwC)
    {
      int i = this.cwO.cwQ;
      return i;
    }
  }
  
  public final int Ha()
  {
    synchronized (this.cwC)
    {
      int i = this.cwO.cwR;
      return i;
    }
  }
  
  public final float Hb()
  {
    AppMethodBeat.i(139933);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.cwC.nativeGetCurrentFpsVariance(this.cwC.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void Hc()
  {
    AppMethodBeat.i(139934);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.cwC.nativeSetEnableInspectFpsVariance(this.cwC.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int Hd()
  {
    AppMethodBeat.i(139935);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.cwC.nativeGetFrameCounter(this.cwC.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int He()
  {
    AppMethodBeat.i(139936);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.cwC.nativeGetDrawCalls(this.cwC.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int Hf()
  {
    AppMethodBeat.i(139937);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.cwC.nativeGetVertexes(this.cwC.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int Hg()
  {
    AppMethodBeat.i(139938);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.cwC.nativeGetTriangles(this.cwC.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void Hh()
  {
    AppMethodBeat.i(139939);
    synchronized (this.cwC)
    {
      if (this.cwC.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.cwC.nativeGetCurrentFps(this.cwC.mNativeInst);
      this.cwE.cwp = localObject1[0];
      this.cwE.cwq = localObject1[1];
      if (this.hasInit)
      {
        this.cwL += 1;
        if (this.cwL > this.cwM)
        {
          this.cwL = 1;
          if (this.cwN)
          {
            this.cwO.cwR = 0;
            this.cwO.cwQ = 0;
          }
        }
        if (this.cwE.cwp < this.cwI)
        {
          localObject1 = this.cwO;
          ((a)localObject1).cwR += 1;
        }
        if ((this.cwJ.size() >= this.cwG) && (this.cwG > 0))
        {
          if (this.cwE.cwp * this.cwG + this.cwH < this.cwK)
          {
            localObject1 = this.cwO;
            ((a)localObject1).cwQ += 1;
          }
          this.cwK -= ((Float)this.cwJ.remove()).floatValue();
        }
        this.cwJ.add(Float.valueOf(this.cwE.cwp));
        this.cwK += this.cwE.cwp;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.cwC)
    {
      this.cwG = paramInt1;
      this.cwI = paramFloat;
      this.cwH = (paramInt1 * paramInt2);
      this.cwM = paramInt3;
      this.cwN = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  public final float gR(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (Hd() - paramInt) * 1000.0F / (float)h.aO(this.cwD.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public int cwQ;
    public int cwR;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      c.this.Hh();
      c.this.handler.postDelayed(c.this.cwF, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */