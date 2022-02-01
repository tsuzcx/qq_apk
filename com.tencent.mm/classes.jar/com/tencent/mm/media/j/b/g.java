package com.tencent.mm.media.j.b;

import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "hwPixelFormat", "", "hwProgramId", "mInputTexture", "needUpdateMatrix", "rotateIdxMap", "", "[[Ljava/lang/Integer;", "softProgramId", "surfaceHeight", "surfaceWidth", "textureBottom", "", "textureLeft", "textureRight", "textureTop", "uniformFlipX", "uniformFlipY", "uniformTexLeft", "uniformTexture", "uniformUseY", "uniformXOffset", "uniformYOffset", "initDrawCoordBuffer", "", "refreshToHwProgram", "refreshToSoftProgram", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateSurfaceSize", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends a
{
  public static final g.a ilh;
  public int hEA;
  private final int hEy;
  private final int hEz;
  public final int ikR;
  public final int ikS;
  public int ikT;
  public int ikU;
  public int ikV;
  public int ikW;
  public int ikX;
  public int ikY;
  public int ikZ;
  private boolean ila;
  private float ilb;
  private float ilc;
  private float ild;
  private float ile;
  public boolean ilf;
  private final Integer[][] ilg;
  public int surfaceHeight;
  public int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(218776);
    ilh = new g.a((byte)0);
    AppMethodBeat.o(218776);
  }
  
  public g()
  {
    this(0, 31);
  }
  
  private g(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(218774);
    this.ikZ = -1;
    this.ila = true;
    this.ilc = 1.0F;
    this.ile = 1.0F;
    this.ilf = true;
    Object localObject = c.ilt;
    localObject = com.tencent.mm.media.c.a.idP;
    localObject = com.tencent.mm.media.c.a.aLY();
    a.a locala = com.tencent.mm.media.c.a.idP;
    this.ikR = c.a.aB((String)localObject, com.tencent.mm.media.c.a.aLZ());
    localObject = c.ilt;
    localObject = com.tencent.mm.media.c.a.idP;
    localObject = com.tencent.mm.media.c.a.aMa();
    locala = com.tencent.mm.media.c.a.idP;
    this.ikS = c.a.aB((String)localObject, com.tencent.mm.media.c.a.aMb());
    this.hEy = 0;
    this.hEz = 1;
    qx(0);
    this.ilg = ((Integer[][])new Integer[][] { { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }, { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(1) }, { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0) }, { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(2) } });
    AppMethodBeat.o(218774);
  }
  
  protected final void aMS()
  {
    AppMethodBeat.i(218772);
    if (!this.ila)
    {
      AppMethodBeat.o(218772);
      return;
    }
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = this.ilb;
    arrayOfFloat1[1] = this.ild;
    arrayOfFloat1[2] = this.ilc;
    arrayOfFloat1[3] = this.ild;
    arrayOfFloat1[4] = this.ilb;
    arrayOfFloat1[5] = this.ile;
    arrayOfFloat1[6] = this.ilc;
    arrayOfFloat1[7] = this.ile;
    Integer[] arrayOfInteger = this.ilg[(this.ijt / 90 % 4)];
    float[] arrayOfFloat2 = new float[8];
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFloat2[(i * 2)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2)];
      arrayOfFloat2[(i * 2 + 1)] = arrayOfFloat1[(arrayOfInteger[i].intValue() * 2 + 1)];
      i += 1;
    }
    this.hDT.put(arrayOfFloat2).position(0);
    this.hDU.position(0);
    this.hDU.put(c.ilm);
    this.hDU.position(0);
    this.ila = false;
    AppMethodBeat.o(218772);
  }
  
  protected final void aMV()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(218773);
    if (this.ikZ == -1)
    {
      AppMethodBeat.o(218773);
      return;
    }
    GLES30.glViewport(0, this.surfaceHeight - this.hEq, this.hEp, this.hEq);
    int i;
    if (this.ilf)
    {
      GLES30.glUseProgram(this.ikR);
      GLES30.glActiveTexture(33984);
      GLES30.glBindTexture(3553, this.ikZ);
      GLES30.glTexParameteri(3553, 10241, 9729);
      GLES30.glTexParameteri(3553, 10240, 9729);
      GLES30.glTexParameteri(3553, 10242, 33071);
      GLES30.glTexParameteri(3553, 10243, 33071);
      GLES30.glUniform1i(this.hEA, 0);
      GLES30.glUniform1f(this.ikY, this.ilb);
      GLES30.glUniform1f(this.ikT, 1.0F / this.hEp / 4.0F);
      i = this.ikV;
      if ((Math.abs(this.ijt) != 90) && (Math.abs(this.ijt) != 270)) {
        break label382;
      }
      f1 = 0.0F;
      label185:
      GLES30.glUniform1f(i, f1);
      i = this.ikW;
      if ((this.ijt != -90) && (this.ijt != 270)) {
        break label387;
      }
      f1 = 1.0F;
      label216:
      GLES30.glUniform1f(i, f1);
      i = this.ikX;
      if (Math.abs(this.ijt) != 180) {
        break label392;
      }
    }
    label387:
    label392:
    for (float f1 = f2;; f1 = 0.0F)
    {
      GLES30.glUniform1f(i, f1);
      this.hDU.position(0);
      GLES30.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer)this.hDU);
      GLES30.glEnableVertexAttribArray(this.hEy);
      this.hDT.position(0);
      GLES30.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer)this.hDT);
      GLES30.glEnableVertexAttribArray(this.hEz);
      GLES30.glDrawArrays(5, 0, 4);
      GLES30.glDisableVertexAttribArray(this.hEy);
      GLES30.glDisableVertexAttribArray(this.hEz);
      GLES30.glBindTexture(3553, 0);
      GLES30.glBindTexture(36197, 0);
      AppMethodBeat.o(218773);
      return;
      GLES30.glUseProgram(this.ikS);
      GLES30.glUniform1f(this.ikU, 2.0F / this.hEq);
      break;
      label382:
      f1 = 1.0F;
      break label185;
      f1 = 0.0F;
      break label216;
    }
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218770);
    int i = paramInt2 / 4;
    int j = paramInt1 * 3 / 2;
    if ((i == this.hEp) && (j == this.hEq))
    {
      AppMethodBeat.o(218770);
      return;
    }
    float f1 = paramInt2 / this.hDo;
    float f2 = paramInt1 / this.hDn;
    super.cY(i, j);
    if (f1 > f2)
    {
      this.ilb = ((1.0F - f2 / f1) / 2.0F);
      this.ilc = (1.0F - this.ilb);
    }
    for (;;)
    {
      Log.i("RGB2YUVRenderProc", "Crop Texture Coordinate: " + this.ilb + ", " + this.ilc + ", " + this.ild + ", " + this.ile);
      this.ila = true;
      AppMethodBeat.o(218770);
      return;
      this.ild = ((1.0F - f1 / f2) / 2.0F);
      this.ile = (1.0F - this.ild);
    }
  }
  
  public final void qx(int paramInt)
  {
    AppMethodBeat.i(218771);
    paramInt = (paramInt + 360 - 90) % 360;
    if (paramInt != this.ijt) {
      this.ila = true;
    }
    super.qx(paramInt);
    AppMethodBeat.o(218771);
  }
  
  public final void rl(int paramInt)
  {
    this.ikZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.g
 * JD-Core Version:    0.7.0.1
 */