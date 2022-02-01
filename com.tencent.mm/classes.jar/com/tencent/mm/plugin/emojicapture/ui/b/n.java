package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sticker.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.i.a
{
  public static final n.a oSB;
  private int aMk;
  private int aMl;
  public XLabEffect fVU;
  private int mode;
  public final Rect oSA;
  private com.tencent.mm.media.i.b.a oSu;
  private m oSv;
  public e oSw;
  private com.tencent.mm.media.f.d oSx;
  private int oSy;
  private int oSz;
  
  static
  {
    AppMethodBeat.i(877);
    oSB = new n.a((byte)0);
    AppMethodBeat.o(877);
  }
  
  private n()
  {
    super(0, 0, 1, 2, 15);
    AppMethodBeat.i(876);
    this.mode = 0;
    this.oSA = new Rect();
    AppMethodBeat.o(876);
  }
  
  private final void bYU()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.oSy = 160;
      this.oSz = (this.aMl * this.oSy / this.aMk);
      return;
      if (this.guK > 640)
      {
        this.aMk = 640;
        this.aMl = (this.guL * 640 / this.guK);
      }
      else
      {
        this.aMk = this.guK;
        this.aMl = this.guL;
        continue;
        this.aMk = 640;
        this.aMl = 1137;
        continue;
        this.aMk = 640;
        this.aMl = 640;
      }
    }
  }
  
  private final void bYV()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.oSA.isEmpty())
    {
      localm = this.oSv;
      if (localm != null)
      {
        localm.B(0, 0, this.guK, this.guL);
        AppMethodBeat.o(875);
        return;
        localm = this.oSv;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.oSv;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.oJY;
            localm.a(true, this.aMk * 0.0666667F);
          }
        }
      }
      else
      {
        AppMethodBeat.o(875);
        return;
      }
    }
    m localm = this.oSv;
    if (localm != null)
    {
      localm.B(this.oSA.left, this.oSA.top, this.oSA.right, this.oSA.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(870);
    this.oSx = com.tencent.mm.media.f.c.a(true, 8L);
    Object localObject1 = this.oSu;
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.i.b.c(this.guI, this.guJ, this.aMk, this.aMl, 2, 2);
    this.oSu = ((com.tencent.mm.media.i.b.a)localObject1);
    Object localObject2 = this.oSu;
    if (localObject2 != null) {
      ((com.tencent.mm.media.i.b.a)localObject2).guY = true;
    }
    localObject2 = this.oSv;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.oSv = new m(this.aMk, this.aMl, this.guK, this.guL, (byte)0);
    localObject2 = this.oSv;
    if (localObject2 != null)
    {
      com.tencent.mm.media.f.d locald = this.oSx;
      if (locald == null) {
        k.fvU();
      }
      ((m)localObject2).guC = locald.gro;
    }
    localObject2 = this.fVU;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).destroy();
    }
    this.fVU = new XLabEffect(0, 0, 0, false, 15);
    localObject2 = this.fVU;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).tN(true);
    }
    localObject2 = this.fVU;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).tP(false);
    }
    localObject2 = this.fVU;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).a(this.oSw);
    }
    localObject2 = this.fVU;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).setSize(this.aMk, this.aMl);
    }
    localObject1 = (com.tencent.mm.media.i.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void akk()
  {
    AppMethodBeat.i(871);
    super.akk();
    Object localObject = this.oSu;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.i.b.a)localObject).guU;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.f.d)localObject).gro;; i = -1)
    {
      localObject = this.fVU;
      if (localObject != null) {
        XLabEffect.a((XLabEffect)localObject, i);
      }
      localObject = b.oRy;
      localObject = this.oSx;
      if (localObject == null) {
        k.fvU();
      }
      b.a.X(((com.tencent.mm.media.f.d)localObject).gro, this.aMk, this.aMl);
      localObject = this.fVU;
      if (localObject != null)
      {
        com.tencent.mm.media.f.d locald = this.oSx;
        if (locald == null) {
          k.fvU();
        }
        XLabEffect.a((XLabEffect)localObject, i, locald.gro, 0L, false, 60);
      }
      localObject = this.oSv;
      if (localObject == null) {
        break;
      }
      ((m)localObject).akk();
      AppMethodBeat.o(871);
      return;
    }
    AppMethodBeat.o(871);
  }
  
  public final void b(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(874);
    k.h(paramRect, "previewRect");
    if (this.mode == paramInt)
    {
      AppMethodBeat.o(874);
      return;
    }
    this.mode = paramInt;
    this.oSA.set(paramRect);
    paramRect = this.oSu;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.oSv;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.oSx;
    if (paramRect != null) {
      paramRect.close();
    }
    bYU();
    this.gux = akj();
    paramRect = this.oSu;
    if (paramRect != null) {
      paramRect.cS(this.guI, this.guJ);
    }
    paramRect = this.oSu;
    if (paramRect != null) {
      paramRect.cT(this.aMk, this.aMl);
    }
    paramRect = this.oSu;
    if (paramRect != null) {
      paramRect.mz(this.guD);
    }
    paramRect = this.oSu;
    if (paramRect != null) {
      paramRect.guE = this.guE;
    }
    paramRect = this.oSv;
    if (paramRect != null) {
      paramRect.cS(this.aMk, this.aMl);
    }
    paramRect = this.oSv;
    if (paramRect != null) {
      paramRect.cT(this.guK, this.guL);
    }
    bYV();
    AppMethodBeat.o(874);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.cT(paramInt1, paramInt2);
    bYU();
    Object localObject = this.oSu;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cT(this.aMk, this.aMl);
    }
    localObject = this.oSv;
    if (localObject != null) {
      ((m)localObject).cS(this.aMk, this.aMl);
    }
    localObject = this.oSv;
    if (localObject != null) {
      ((m)localObject).cT(this.guK, this.guL);
    }
    bYV();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.oSv;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fVU = null;
    localObject = this.oSx;
    if (localObject != null)
    {
      ((com.tencent.mm.media.f.d)localObject).close();
      AppMethodBeat.o(872);
      return;
    }
    AppMethodBeat.o(872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.n
 * JD-Core Version:    0.7.0.1
 */