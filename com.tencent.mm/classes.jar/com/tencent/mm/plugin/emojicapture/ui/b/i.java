package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "removeBgEnable", "", "(Z)V", "TAG", "", "afterDrawCallback", "Lkotlin/Function0;", "", "canDraw", "cubeArray", "", "kotlin.jvm.PlatformType", "cubeBuffer", "Ljava/nio/FloatBuffer;", "frameTimestamp", "", "init", "isDrawing", "onFrameAvailable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pts", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "ptFaceDetector", "Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "ptFaceFrame", "Lcom/tencent/filter/Frame;", "ptSegment", "Lcom/tencent/ttpic/PTSegment;", "removeBackground", "getRemoveBgEnable", "()Z", "renderAttributePosition", "", "renderAttributeTextureCoord", "renderProgramId", "renderUniformCalcRoundCorner", "renderUniformExternalTexture", "renderUniformNormalTexture", "renderUniformRadius", "renderUniformSize", "renderUniformUseNormalTexture", "segmentInit", "segmentOutputTexture", "sizeBuff", "stickerOutTexture", "textureCoordArray", "textureCoordBuff", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureFramebuffer", "toTextureOutputTexture", "toTextureProgramId", "toTextureUniformExternalTexture", "videoPlayRenderDepthBuffer", "videoPlayRenderFramebuffer", "videoPlayRenderOutputTexture", "videoPlayRenderTextureSize", "videoPlaySurface", "Landroid/graphics/SurfaceTexture;", "videoPlayTexture", "viewHeight", "viewWidth", "afterDraw", "callback", "checkInit", "currentFrameTimestamp", "drawFrame", "drawImpl", "drawVideoContent", "videoTexture", "drawWidth", "drawHeight", "externalTarget", "calcRoundCorner", "verticalFlip", "drawWithRemoveBackground", "drawWithStickerAndRemoveBackground", "getVideoPlaySurface", "initSegment", "surfaceTexture", "pauseDraw", "pause", "release", "releaseSegment", "setRemoveBackground", "remove", "setViewSize", "width", "height", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class i
  implements SurfaceTexture.OnFrameAvailableListener
{
  public final String TAG;
  public boolean eLc;
  public FloatBuffer eYu;
  public FloatBuffer eYv;
  public float[] gNF;
  public float[] gNG;
  public boolean gNN;
  public boolean gNz;
  public int jgD;
  public int jgE;
  public int lBR;
  public int lBS;
  public int lBT;
  public int lBU;
  public int lBV;
  public int lBW;
  public int lBX;
  public int lBY;
  public int lBZ;
  public int lBa;
  public int lBb;
  public int lBc;
  public int lBd;
  public com.tencent.mm.bw.a lBi;
  public PTSegment lBj;
  public h lBk;
  public int lBl;
  public int lCa;
  public int lCb;
  public int lCc;
  public final int lCd;
  private FloatBuffer lCe;
  public SurfaceTexture lCf;
  public a.f.a.a<y> lCg;
  public b<? super Long, y> lCh;
  private long lCi;
  public boolean lCj;
  public boolean lva;
  public final boolean lxJ;
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(3180);
    this.lxJ = paramBoolean;
    this.TAG = "MicroMsg.EmojiVideoPlayTextureRenderer";
    Object localObject = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    this.lCd = com.tencent.mm.plugin.emojicapture.model.c.bnP();
    localObject = c.eZq;
    this.gNF = Arrays.copyOf((float[])localObject, localObject.length);
    localObject = c.eZr;
    this.gNG = Arrays.copyOf((float[])localObject, localObject.length);
    localObject = ByteBuffer.allocateDirect(this.gNF.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYv = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(this.gNG.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYu = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.lCe = ((FloatBuffer)localObject);
    this.lCi = -1L;
    AppMethodBeat.o(3180);
  }
  
  private final void bpn()
  {
    AppMethodBeat.i(3179);
    ab.i(this.TAG, "releaseSegment: ".concat(String.valueOf(this)));
    try
    {
      this.lCj = false;
      Object localObject = this.lBj;
      if (localObject != null) {
        ((PTSegment)localObject).destroy();
      }
      localObject = this.lBi;
      if (localObject != null) {
        ((com.tencent.mm.bw.a)localObject).destroy();
      }
      GamePlaySDK.getInstance().clear();
      PTModule.getInstance().destroy();
      this.lBj = null;
      this.lBi = null;
      AppMethodBeat.o(3179);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "release segment error", new Object[0]);
      d locald = d.ltx;
      d.bom();
      AppMethodBeat.o(3179);
    }
  }
  
  public final void eh(int paramInt1, int paramInt2)
  {
    this.jgD = paramInt1;
    this.jgE = paramInt2;
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(3176);
    this.gNN = true;
    if ((paramSurfaceTexture instanceof SurfaceTexture)) {}
    for (long l = paramSurfaceTexture.getTimestamp();; l = -1L)
    {
      this.lCi = l;
      paramSurfaceTexture = this.lCh;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.S(Long.valueOf(this.lCi));
      AppMethodBeat.o(3176);
      return;
    }
    AppMethodBeat.o(3176);
  }
  
  public final void release()
  {
    AppMethodBeat.i(3178);
    if (!this.eLc)
    {
      AppMethodBeat.o(3178);
      return;
    }
    this.eLc = false;
    ab.i(this.TAG, "release: ".concat(String.valueOf(this)));
    try
    {
      GLES20.glDeleteTextures(3, new int[] { this.lBR, this.lCc, this.lBl }, 0);
      GLES20.glDeleteProgram(this.lBS);
      GLES20.glDeleteProgram(this.lBa);
      GLES20.glDeleteFramebuffers(1, new int[] { this.lCb }, 0);
      bpn();
      Object localObject = this.lCf;
      if (localObject != null) {
        ((SurfaceTexture)localObject).release();
      }
      localObject = this.lBk;
      if (localObject == null) {
        j.ays("ptFaceFrame");
      }
      ((h)localObject).clear();
      AppMethodBeat.o(3178);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "release error " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(3178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.i
 * JD-Core Version:    0.7.0.1
 */