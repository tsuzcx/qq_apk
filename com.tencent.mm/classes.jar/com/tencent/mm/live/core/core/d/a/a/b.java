package com.tencent.mm.live.core.core.d.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public final class b
{
  public int mQM;
  public int mQN;
  public float mQO;
  public int[] mQP;
  private SparseArray<ShortBuffer> mQR;
  public SparseArray<FloatBuffer> mQS;
  public SparseArray<FloatBuffer> mQT;
  private int mQU;
  private int mQV;
  private float mQW;
  private float mQX;
  private float mQY;
  private float mQZ;
  
  public b()
  {
    AppMethodBeat.i(248095);
    this.mQM = 36;
    this.mQN = 72;
    this.mQO = 10.0F;
    this.mQP = new int[4];
    this.mQR = new SparseArray(4);
    this.mQS = new SparseArray(4);
    this.mQT = new SparseArray(4);
    this.mQU = 30;
    this.mQV = 30;
    this.mQW = -0.068F;
    this.mQX = 0.32F;
    this.mQY = -0.2F;
    this.mQZ = 0.95F;
    AppMethodBeat.o(248095);
  }
  
  public final void a(int paramInt, ShortBuffer paramShortBuffer)
  {
    AppMethodBeat.i(248109);
    this.mQR.put(paramInt, paramShortBuffer);
    AppMethodBeat.o(248109);
  }
  
  public final void b(int paramInt, FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(248116);
    this.mQT.put(paramInt, paramFloatBuffer);
    AppMethodBeat.o(248116);
  }
  
  public final ShortBuffer beJ()
  {
    AppMethodBeat.i(248104);
    ShortBuffer localShortBuffer = (ShortBuffer)this.mQR.get(0);
    AppMethodBeat.o(248104);
    return localShortBuffer;
  }
  
  public final void c(int paramInt, FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(248121);
    this.mQS.put(paramInt, paramFloatBuffer);
    AppMethodBeat.o(248121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */