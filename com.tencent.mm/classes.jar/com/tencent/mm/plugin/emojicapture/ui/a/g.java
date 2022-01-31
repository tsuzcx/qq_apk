package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.a.a;
import a.n;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.PTSegment;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class g
  implements SurfaceTexture.OnFrameAvailableListener
{
  public final String TAG = "MicroMsg.EmojiVideoPlayTextureRenderer";
  public boolean brU;
  public boolean fwM;
  public FloatBuffer fwk;
  public FloatBuffer fwl;
  public float[] fwo = Arrays.copyOf(b.fvS, b.fvS.length);
  public float[] fwp = Arrays.copyOf(b.fvU, b.fvU.length);
  public boolean jll;
  public int jrA;
  public int jrB;
  public int jrC;
  public int jrD;
  public PTSegment jrI;
  public int jsA;
  public int jsB;
  public int jsC;
  public int jsD;
  public int jsE;
  public int jsF;
  public int jsG;
  public final int jsH = 512;
  private FloatBuffer jsI;
  public SurfaceTexture jsJ;
  public a<n> jsK;
  public a.d.a.b<? super Long, n> jsL;
  private long jsM;
  public int jsq;
  public int jsr;
  public int jsu;
  public int jsv;
  public int jsw;
  public int jsx;
  public int jsy;
  public int jsz;
  
  public g()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.fwo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    a.d.b.g.j(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.fwk = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(this.fwp.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    a.d.b.g.j(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.fwl = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    a.d.b.g.j(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.jsI = localFloatBuffer;
    this.jrI = new PTSegment();
    this.jsM = -1L;
  }
  
  public final void cK(int paramInt1, int paramInt2)
  {
    this.jsq = paramInt1;
    this.jsr = paramInt2;
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.fwM = true;
    if ((paramSurfaceTexture instanceof SurfaceTexture)) {}
    for (long l = paramSurfaceTexture.getTimestamp();; l = -1L)
    {
      this.jsM = l;
      paramSurfaceTexture = this.jsL;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.W(Long.valueOf(this.jsM));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.g
 * JD-Core Version:    0.7.0.1
 */