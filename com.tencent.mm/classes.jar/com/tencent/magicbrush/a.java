package com.tencent.magicbrush;

import android.util.SparseLongArray;
import com.tencent.magicbrush.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final MBRuntime bJe;
  public SparseLongArray bJf;
  
  a(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(115779);
    this.bJf = new SparseLongArray();
    this.bJe = paramMBRuntime;
    AppMethodBeat.o(115779);
  }
  
  public final float fH(int paramInt)
  {
    AppMethodBeat.i(115780);
    float f = (yl() - paramInt) * 1000.0F / (float)e.av(this.bJf.get(paramInt));
    AppMethodBeat.o(115780);
    return f;
  }
  
  public final a.a getCurrentFps()
  {
    AppMethodBeat.i(115781);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        locala = new a.a(this);
        AppMethodBeat.o(115781);
        return locala;
      }
      a.a locala = new a.a(this);
      float[] arrayOfFloat = this.bJe.nativeGetCurrentFps(this.bJe.mNativeInst);
      locala.bJg = arrayOfFloat[0];
      locala.bJh = arrayOfFloat[1];
      AppMethodBeat.o(115781);
      return locala;
    }
  }
  
  public final float yk()
  {
    AppMethodBeat.i(115782);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        AppMethodBeat.o(115782);
        return -1.0F;
      }
      float f = this.bJe.nativeGetCurrentFpsVariance(this.bJe.mNativeInst);
      AppMethodBeat.o(115782);
      return f;
    }
  }
  
  public final int yl()
  {
    AppMethodBeat.i(115783);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        AppMethodBeat.o(115783);
        return -1;
      }
      int i = this.bJe.nativeGetFrameCounter(this.bJe.mNativeInst);
      AppMethodBeat.o(115783);
      return i;
    }
  }
  
  public final int ym()
  {
    AppMethodBeat.i(115784);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        AppMethodBeat.o(115784);
        return 0;
      }
      int i = this.bJe.nativeGetDrawCalls(this.bJe.mNativeInst);
      AppMethodBeat.o(115784);
      return i;
    }
  }
  
  public final int yn()
  {
    AppMethodBeat.i(115785);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        AppMethodBeat.o(115785);
        return 0;
      }
      int i = this.bJe.nativeGetVertexes(this.bJe.mNativeInst);
      AppMethodBeat.o(115785);
      return i;
    }
  }
  
  public final int yo()
  {
    AppMethodBeat.i(115786);
    synchronized (this.bJe)
    {
      if (this.bJe.mNativeInst == 0L)
      {
        AppMethodBeat.o(115786);
        return 0;
      }
      int i = this.bJe.nativeGetTriangles(this.bJe.mNativeInst);
      AppMethodBeat.o(115786);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */