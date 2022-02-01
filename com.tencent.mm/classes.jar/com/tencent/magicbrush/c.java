package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class c
{
  private float coA;
  private Queue<Float> coB;
  private float coC;
  private int coD;
  private int coE;
  private int coF;
  private int coG;
  private final MBRuntime cou;
  public SparseLongArray cov;
  private a cow;
  final a cox;
  private int coy;
  private int coz;
  Handler handler;
  private boolean hasInit;
  
  c(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.cov = new SparseLongArray();
    this.cow = new a((byte)0);
    this.cox = new a((byte)0);
    this.coB = new LinkedList();
    this.cou = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  final void FN()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.cox);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a FO()
  {
    synchronized (this.cou)
    {
      a locala = this.cow;
      return locala;
    }
  }
  
  public final int FP()
  {
    synchronized (this.cou)
    {
      int i = this.coD;
      return i;
    }
  }
  
  public final int FQ()
  {
    synchronized (this.cou)
    {
      int i = this.coE;
      return i;
    }
  }
  
  public final float FR()
  {
    AppMethodBeat.i(139933);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.cou.nativeGetCurrentFpsVariance(this.cou.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void FS()
  {
    AppMethodBeat.i(139934);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.cou.nativeSetEnableInspectFpsVariance(this.cou.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int FT()
  {
    AppMethodBeat.i(139935);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.cou.nativeGetFrameCounter(this.cou.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int FU()
  {
    AppMethodBeat.i(139936);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.cou.nativeGetDrawCalls(this.cou.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int FV()
  {
    AppMethodBeat.i(139937);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.cou.nativeGetVertexes(this.cou.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int FW()
  {
    AppMethodBeat.i(139938);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.cou.nativeGetTriangles(this.cou.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void FX()
  {
    AppMethodBeat.i(139939);
    synchronized (this.cou)
    {
      if (this.cou.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      float[] arrayOfFloat = this.cou.nativeGetCurrentFps(this.cou.mNativeInst);
      this.cow.coh = arrayOfFloat[0];
      this.cow.coi = arrayOfFloat[1];
      if (this.hasInit)
      {
        this.coF += 1;
        if (this.coF > this.coG)
        {
          this.coF = 0;
          this.coD = 0;
          this.coE = 0;
        }
        if (this.cow.coh < this.coA) {
          this.coE += 1;
        }
        if ((this.coB.size() >= this.coy) && (this.coy > 0))
        {
          if (this.cow.coh * this.coy + this.coz < this.coC) {
            this.coD += 1;
          }
          this.coC -= ((Float)this.coB.remove()).floatValue();
        }
        this.coB.add(Float.valueOf(this.cow.coh));
        this.coC += this.cow.coh;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    synchronized (this.cou)
    {
      this.coy = paramInt1;
      this.coA = paramFloat;
      this.coz = (paramInt1 * paramInt2);
      this.coG = paramInt3;
      this.hasInit = true;
      return;
    }
  }
  
  public final float hb(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (FT() - paramInt) * 1000.0F / (float)h.aS(this.cov.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      c.this.FX();
      c.this.handler.postDelayed(c.this.cox, 1000L);
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */