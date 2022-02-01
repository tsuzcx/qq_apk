package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class d
{
  private final MBRuntime eGN;
  public SparseLongArray eGO;
  private a eGP;
  final b eGQ;
  private int eGR;
  private int eGS;
  private float eGT;
  private Queue<Float> eGU;
  private float eGV;
  private int eGW;
  private int eGX;
  private boolean eGY;
  private a eGZ;
  private a eHa;
  Handler handler;
  private boolean hasInit;
  
  d(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(139930);
    this.eGO = new SparseLongArray();
    this.eGP = new a((byte)0);
    this.eGQ = new b((byte)0);
    this.eGU = new LinkedList();
    this.eGZ = new a();
    this.eHa = new a();
    this.eGN = paramMBRuntime;
    this.hasInit = false;
    AppMethodBeat.o(139930);
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.eGN)
    {
      this.eGR = paramInt1;
      this.eGT = paramFloat;
      this.eGS = (paramInt1 * paramInt2);
      this.eGX = paramInt3;
      this.eGY = paramBoolean;
      this.hasInit = true;
      return;
    }
  }
  
  final void auY()
  {
    AppMethodBeat.i(139931);
    if (this.handler != null)
    {
      this.handler.removeCallbacks(this.eGQ);
      this.handler = null;
    }
    AppMethodBeat.o(139931);
  }
  
  public final a auZ()
  {
    synchronized (this.eGN)
    {
      a locala = this.eGP;
      return locala;
    }
  }
  
  public final a ava()
  {
    synchronized (this.eGN)
    {
      this.eHa.eHc = this.eGZ.eHc;
      this.eHa.eHb = this.eGZ.eHb;
      this.eHa.eHd = this.eGZ.eHd;
      this.eHa.eHe = this.eGZ.eHe;
      this.eHa.eGA = (this.eGZ.eGB / this.eGZ.eGC);
      this.eGZ.eHc = 0;
      this.eGZ.eHb = 0;
      this.eGZ.eHd = 0;
      this.eGZ.eHe = 0;
      this.eGZ.eGB = 0;
      this.eGZ.eGC = 0;
      a locala = this.eHa;
      return locala;
    }
  }
  
  public final int avb()
  {
    synchronized (this.eGN)
    {
      int i = this.eGZ.eHb;
      return i;
    }
  }
  
  public final int avc()
  {
    synchronized (this.eGN)
    {
      int i = this.eGZ.eHc;
      return i;
    }
  }
  
  public final float avd()
  {
    AppMethodBeat.i(139933);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139933);
        return -1.0F;
      }
      float f = this.eGN.nativeGetCurrentFpsVariance(this.eGN.mNativeInst);
      AppMethodBeat.o(139933);
      return f;
    }
  }
  
  public final void ave()
  {
    AppMethodBeat.i(139934);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139934);
        return;
      }
      this.eGN.nativeSetEnableInspectFpsVariance(this.eGN.mNativeInst, true);
      AppMethodBeat.o(139934);
      return;
    }
  }
  
  public final int avf()
  {
    AppMethodBeat.i(139935);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139935);
        return -1;
      }
      int i = this.eGN.nativeGetFrameCounter(this.eGN.mNativeInst);
      AppMethodBeat.o(139935);
      return i;
    }
  }
  
  public final int avg()
  {
    AppMethodBeat.i(139936);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139936);
        return 0;
      }
      int i = this.eGN.nativeGetDrawCalls(this.eGN.mNativeInst);
      AppMethodBeat.o(139936);
      return i;
    }
  }
  
  public final int avh()
  {
    AppMethodBeat.i(139937);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139937);
        return 0;
      }
      int i = this.eGN.nativeGetVertexes(this.eGN.mNativeInst);
      AppMethodBeat.o(139937);
      return i;
    }
  }
  
  public final int avi()
  {
    AppMethodBeat.i(139938);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139938);
        return 0;
      }
      int i = this.eGN.nativeGetTriangles(this.eGN.mNativeInst);
      AppMethodBeat.o(139938);
      return i;
    }
  }
  
  public final void avj()
  {
    AppMethodBeat.i(139939);
    synchronized (this.eGN)
    {
      if (this.eGN.mNativeInst == 0L)
      {
        AppMethodBeat.o(139939);
        return;
      }
      Object localObject1 = this.eGN.nativeGetCurrentFps(this.eGN.mNativeInst);
      this.eGP.eGw = localObject1[0];
      this.eGP.eGx = localObject1[1];
      this.eGP.eGy = ((int)localObject1[2]);
      this.eGP.eGz = ((int)localObject1[3]);
      this.eGP.eGA = localObject1[4];
      this.eGP.eGB = ((int)localObject1[5]);
      this.eGP.eGC = ((int)localObject1[6]);
      localObject1 = this.eGZ;
      ((a)localObject1).eHd += this.eGP.eGy;
      localObject1 = this.eGZ;
      ((a)localObject1).eHe += this.eGP.eGz;
      localObject1 = this.eGZ;
      ((a)localObject1).eGB += this.eGP.eGB;
      localObject1 = this.eGZ;
      ((a)localObject1).eGC += this.eGP.eGC;
      if (this.hasInit)
      {
        this.eGW += 1;
        if (this.eGW > this.eGX)
        {
          this.eGW = 1;
          if (this.eGY)
          {
            this.eGZ.eHc = 0;
            this.eGZ.eHb = 0;
          }
        }
        if (this.eGP.eGw < this.eGT)
        {
          localObject1 = this.eGZ;
          ((a)localObject1).eHc += 1;
        }
        if ((this.eGU.size() >= this.eGR) && (this.eGR > 0))
        {
          if (this.eGP.eGw * this.eGR + this.eGS < this.eGV)
          {
            localObject1 = this.eGZ;
            ((a)localObject1).eHb += 1;
          }
          this.eGV -= ((Float)this.eGU.remove()).floatValue();
        }
        this.eGU.add(Float.valueOf(this.eGP.eGw));
        this.eGV += this.eGP.eGw;
      }
      AppMethodBeat.o(139939);
      return;
    }
  }
  
  public final float mO(int paramInt)
  {
    AppMethodBeat.i(139932);
    float f = (avf() - paramInt) * 1000.0F / (float)i.ticksToNow(this.eGO.get(paramInt));
    AppMethodBeat.o(139932);
    return f;
  }
  
  public final class a
  {
    public float eGA;
    int eGB;
    int eGC;
    public int eHb;
    public int eHc;
    public int eHd;
    public int eHe;
    
    public a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(139929);
      d.this.avj();
      Handler localHandler = d.this.handler;
      if (localHandler != null) {
        localHandler.postDelayed(d.this.eGQ, 1000L);
      }
      AppMethodBeat.o(139929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.d
 * JD-Core Version:    0.7.0.1
 */