package com.tencent.mm.media.j.b;

import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "hwPixelFormat", "", "hwProgramId", "mInputTexture", "needUpdateMatrix", "rotateIdxMap", "", "[[Ljava/lang/Integer;", "softProgramId", "surfaceHeight", "surfaceWidth", "textureBottom", "", "textureLeft", "textureRight", "textureTop", "uniformFlipX", "uniformFlipY", "uniformTexLeft", "uniformTexture", "uniformUseY", "uniformXOffset", "uniformYOffset", "initDrawCoordBuffer", "", "refreshToHwProgram", "refreshToSoftProgram", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateSurfaceSize", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends a
{
  public static final a lab;
  public final int kZL;
  public final int kZM;
  public int kZN;
  public int kZO;
  public int kZP;
  public int kZQ;
  public int kZR;
  public int kZS;
  public int kZT;
  private boolean kZU;
  private float kZV;
  private float kZW;
  private float kZX;
  private float kZY;
  public boolean kZZ;
  private final int ksD;
  private final int ksE;
  public int ksF;
  private final Integer[][] laa;
  public int surfaceHeight;
  public int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(260345);
    lab = new a((byte)0);
    AppMethodBeat.o(260345);
  }
  
  public g()
  {
    this(0, 31);
  }
  
  private g(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(260341);
    this.kZT = -1;
    this.kZU = true;
    this.kZW = 1.0F;
    this.kZY = 1.0F;
    this.kZZ = true;
    Object localObject1 = c.lar;
    localObject1 = com.tencent.mm.media.c.a.kSv;
    localObject1 = com.tencent.mm.media.c.a.aUh();
    Object localObject2 = com.tencent.mm.media.c.a.kSv;
    this.kZL = c.a.aE((String)localObject1, com.tencent.mm.media.c.a.aUi());
    localObject1 = c.lar;
    localObject1 = com.tencent.mm.media.c.a.kSv;
    localObject1 = com.tencent.mm.media.c.a.aUj();
    localObject2 = com.tencent.mm.media.c.a.kSv;
    this.kZM = c.a.aE((String)localObject1, com.tencent.mm.media.c.a.aUk());
    this.ksD = 0;
    this.ksE = 1;
    tm(0);
    localObject1 = new Integer[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(1) };
    localObject2 = new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0) };
    Integer[] arrayOfInteger = { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(2) };
    this.laa = ((Integer[][])new Integer[][] { { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }, localObject1, localObject2, arrayOfInteger });
    AppMethodBeat.o(260341);
  }
  
  protected final void aVt()
  {
    AppMethodBeat.i(260337);
    if (!this.kZU)
    {
      AppMethodBeat.o(260337);
      return;
    }
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = this.kZV;
    arrayOfFloat1[1] = this.kZX;
    arrayOfFloat1[2] = this.kZW;
    arrayOfFloat1[3] = this.kZX;
    arrayOfFloat1[4] = this.kZV;
    arrayOfFloat1[5] = this.kZY;
    arrayOfFloat1[6] = this.kZW;
    arrayOfFloat1[7] = this.kZY;
    Integer[] arrayOfInteger = this.laa[(aVp() / 90 % 4)];
    float[] arrayOfFloat2 = new float[8];
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFloat2[(i * 2)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2)];
      arrayOfFloat2[(i * 2 + 1)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2 + 1)];
      i += 1;
    }
    aVl().put(arrayOfFloat2).position(0);
    aVm().position(0);
    aVm().put(c.laj);
    aVm().position(0);
    this.kZU = false;
    AppMethodBeat.o(260337);
  }
  
  protected final void aVw()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(260339);
    if (this.kZT == -1)
    {
      AppMethodBeat.o(260339);
      return;
    }
    GLES30.glViewport(0, this.surfaceHeight - getDrawHeight(), getDrawWidth(), getDrawHeight());
    int i;
    if (this.kZZ)
    {
      GLES30.glUseProgram(this.kZL);
      GLES30.glActiveTexture(33984);
      GLES30.glBindTexture(3553, this.kZT);
      GLES30.glTexParameteri(3553, 10241, 9729);
      GLES30.glTexParameteri(3553, 10240, 9729);
      GLES30.glTexParameteri(3553, 10242, 33071);
      GLES30.glTexParameteri(3553, 10243, 33071);
      GLES30.glUniform1i(this.ksF, 0);
      GLES30.glUniform1f(this.kZS, this.kZV);
      GLES30.glUniform1f(this.kZN, 1.0F / getDrawWidth() / 4.0F);
      i = this.kZP;
      if ((Math.abs(aVp()) != 90) && (Math.abs(aVp()) != 270)) {
        break label382;
      }
      f1 = 0.0F;
      label185:
      GLES30.glUniform1f(i, f1);
      i = this.kZQ;
      if ((aVp() != -90) && (aVp() != 270)) {
        break label387;
      }
      f1 = 1.0F;
      label216:
      GLES30.glUniform1f(i, f1);
      i = this.kZR;
      if (Math.abs(aVp()) != 180) {
        break label392;
      }
    }
    label387:
    label392:
    for (float f1 = f2;; f1 = 0.0F)
    {
      GLES30.glUniform1f(i, f1);
      aVm().position(0);
      GLES30.glVertexAttribPointer(this.ksD, 2, 5126, false, 0, (Buffer)aVm());
      GLES30.glEnableVertexAttribArray(this.ksD);
      aVl().position(0);
      GLES30.glVertexAttribPointer(this.ksE, 2, 5126, false, 0, (Buffer)aVl());
      GLES30.glEnableVertexAttribArray(this.ksE);
      GLES30.glDrawArrays(5, 0, 4);
      GLES30.glDisableVertexAttribArray(this.ksD);
      GLES30.glDisableVertexAttribArray(this.ksE);
      GLES30.glBindTexture(3553, 0);
      GLES30.glBindTexture(36197, 0);
      AppMethodBeat.o(260339);
      return;
      GLES30.glUseProgram(this.kZM);
      GLES30.glUniform1f(this.kZO, 2.0F / getDrawHeight());
      break;
      label382:
      f1 = 1.0F;
      break label185;
      f1 = 0.0F;
      break label216;
    }
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260332);
    int i = paramInt2 / 4;
    int j = paramInt1 * 3 / 2;
    if ((i == getDrawWidth()) && (j == getDrawHeight()))
    {
      AppMethodBeat.o(260332);
      return;
    }
    float f1 = paramInt2 / aVy();
    float f2 = paramInt1 / aVx();
    super.du(i, j);
    if (f1 > f2)
    {
      this.kZV = ((1.0F - f2 / f1) / 2.0F);
      this.kZW = (1.0F - this.kZV);
    }
    for (;;)
    {
      Log.i("RGB2YUVRenderProc", "Crop Texture Coordinate: " + this.kZV + ", " + this.kZW + ", " + this.kZX + ", " + this.kZY);
      this.kZU = true;
      AppMethodBeat.o(260332);
      return;
      this.kZX = ((1.0F - f1 / f2) / 2.0F);
      this.kZY = (1.0F - this.kZX);
    }
  }
  
  public final void tm(int paramInt)
  {
    AppMethodBeat.i(260334);
    paramInt = (paramInt + 360 - 90) % 360;
    if (paramInt != aVp()) {
      this.kZU = true;
    }
    super.tm(paramInt);
    AppMethodBeat.o(260334);
  }
  
  public final void ua(int paramInt)
  {
    this.kZT = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.g
 * JD-Core Version:    0.7.0.1
 */