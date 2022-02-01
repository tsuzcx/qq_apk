package com.tencent.mm.media.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "croppedTextureHeight", "croppedTextureWidth", "exchangeXY", "", "hwPixelFormat", "i420RenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVI420RenderProc;", "mInputTexture", "nv12RenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVNV12RenderProc;", "scaleRotateRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "flipUpsideDown", "", "flip", "frameMirror", "mirror", "release", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public static final g.a nER;
  private final e nES;
  private final h nET;
  private final i nEU;
  private boolean nEV;
  public int nEW;
  private int nEX;
  private int nEY;
  public boolean nEZ;
  
  static
  {
    AppMethodBeat.i(237761);
    nER = new g.a((byte)0);
    AppMethodBeat.o(237761);
  }
  
  public g()
  {
    this(0, 31);
  }
  
  private g(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 1);
    AppMethodBeat.i(237754);
    this.nES = new e(0, 0, 0, 0, 2, 2, 12);
    this.nET = new h(paramInt, 15);
    this.nEU = new i(paramInt, 15);
    this.nEW = -1;
    this.nEZ = true;
    th(0);
    AppMethodBeat.o(237754);
  }
  
  protected final void bqg()
  {
    AppMethodBeat.i(237781);
    if (this.nEW == -1)
    {
      AppMethodBeat.o(237781);
      return;
    }
    Object localObject = this.nES;
    ((e)localObject).mVb = this.nEW;
    ((e)localObject).bgE();
    localObject = ((a)localObject).nDF;
    if (localObject != null)
    {
      i = ((d)localObject).nAF;
      if (this.nEZ)
      {
        localObject = this.nEU;
        ((i)localObject).nEW = i;
        ((i)localObject).el(this.nEX, this.nEY);
        ((i)localObject).ek(getDrawWidth(), getDrawHeight());
        if (this.nEV) {}
        for (i = bpT();; i = bpU())
        {
          ((i)localObject).nFm = ((i - this.nEY) / 2 * 3);
          ((i)localObject).bgE();
          AppMethodBeat.o(237781);
          return;
        }
      }
      localObject = this.nET;
      ((h)localObject).nEW = i;
      ((h)localObject).el(this.nEX, this.nEY);
      ((h)localObject).ek(getDrawWidth(), getDrawHeight());
      if (!this.nEV) {
        break label205;
      }
    }
    label205:
    for (int i = bpT();; i = bpU())
    {
      ((h)localObject).nFm = ((i - this.nEY) / 2 * 3);
      ((h)localObject).bgE();
      AppMethodBeat.o(237781);
      return;
    }
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237766);
    if (this.nEV)
    {
      this.nEX = paramInt2;
      this.nEY = paramInt1;
      this.nES.ek(paramInt2, paramInt1);
    }
    for (;;)
    {
      paramInt1 /= 4;
      paramInt2 = paramInt2 * 3 / 2;
      if ((paramInt1 != getDrawWidth()) || (paramInt2 != getDrawHeight())) {
        break;
      }
      AppMethodBeat.o(237766);
      return;
      this.nEX = paramInt1;
      this.nEY = paramInt2;
      this.nES.ek(paramInt1, paramInt2);
    }
    super.ek(paramInt1, paramInt2);
    AppMethodBeat.o(237766);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237767);
    super.el(paramInt1, paramInt2);
    this.nES.el(paramInt1, paramInt2);
    AppMethodBeat.o(237767);
  }
  
  public final void gq(boolean paramBoolean)
  {
    AppMethodBeat.i(237777);
    super.gq(paramBoolean);
    this.nES.gq(paramBoolean);
    AppMethodBeat.o(237777);
  }
  
  public final void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(237772);
    super.gr(paramBoolean);
    this.nES.gr(paramBoolean);
    AppMethodBeat.o(237772);
  }
  
  public final void release()
  {
    AppMethodBeat.i(237785);
    super.release();
    this.nES.release();
    this.nET.release();
    this.nEU.release();
    AppMethodBeat.o(237785);
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(237770);
    paramInt %= 360;
    this.nES.th(paramInt);
    paramInt = Math.abs(paramInt);
    if ((paramInt == 90) || (paramInt == 270)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nEV = bool;
      AppMethodBeat.o(237770);
      return;
    }
  }
  
  public final void uc(int paramInt)
  {
    this.nEW = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.g
 * JD-Core Version:    0.7.0.1
 */