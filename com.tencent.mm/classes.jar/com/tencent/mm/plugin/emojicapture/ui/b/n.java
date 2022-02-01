package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sticker.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.i.a
{
  public static final n.a pvM;
  private int aNa;
  private int aNb;
  public XLabEffect fZP;
  private int mode;
  private com.tencent.mm.media.i.b.a pvF;
  private m pvG;
  public f pvH;
  private com.tencent.mm.media.f.d pvI;
  private int pvJ;
  private int pvK;
  public final Rect pvL;
  
  static
  {
    AppMethodBeat.i(877);
    pvM = new n.a((byte)0);
    AppMethodBeat.o(877);
  }
  
  private n()
  {
    super(0, 0, 1, 2, 15);
    AppMethodBeat.i(876);
    this.mode = 0;
    this.pvL = new Rect();
    AppMethodBeat.o(876);
  }
  
  private final void cgd()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.pvJ = 160;
      this.pvK = (this.aNb * this.pvJ / this.aNa);
      return;
      if (this.grV > 640)
      {
        this.aNa = 640;
        this.aNb = (this.grW * 640 / this.grV);
      }
      else
      {
        this.aNa = this.grV;
        this.aNb = this.grW;
        continue;
        this.aNa = 640;
        this.aNb = 1137;
        continue;
        this.aNa = 640;
        this.aNb = 640;
      }
    }
  }
  
  private final void cge()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.pvL.isEmpty())
    {
      localm = this.pvG;
      if (localm != null)
      {
        localm.B(0, 0, this.grV, this.grW);
        AppMethodBeat.o(875);
        return;
        localm = this.pvG;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.pvG;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pnw;
            localm.a(true, this.aNa * 0.0666667F);
          }
        }
      }
      else
      {
        AppMethodBeat.o(875);
        return;
      }
    }
    m localm = this.pvG;
    if (localm != null)
    {
      localm.B(this.pvL.left, this.pvL.top, this.pvL.right, this.pvL.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(870);
    this.pvI = com.tencent.mm.media.f.c.a(true, 8L);
    Object localObject1 = this.pvF;
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.i.b.c(this.gqZ, this.gra, this.aNa, this.aNb, 2, 2);
    this.pvF = ((com.tencent.mm.media.i.b.a)localObject1);
    Object localObject2 = this.pvF;
    if (localObject2 != null) {
      ((com.tencent.mm.media.i.b.a)localObject2).gVv = true;
    }
    localObject2 = this.pvG;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.pvG = new m(this.aNa, this.aNb, this.grV, this.grW, (byte)0);
    localObject2 = this.pvG;
    if (localObject2 != null)
    {
      com.tencent.mm.media.f.d locald = this.pvI;
      if (locald == null) {
        k.fOy();
      }
      ((m)localObject2).gqX = locald.gRW;
    }
    localObject2 = this.fZP;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).destroy();
    }
    this.fZP = new XLabEffect(0, 0, 0, false, 15);
    localObject2 = this.fZP;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).pt(true);
    }
    localObject2 = this.fZP;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).uQ(false);
    }
    localObject2 = this.fZP;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).a(this.pvH);
    }
    localObject2 = this.fZP;
    if (localObject2 != null) {
      ((XLabEffect)localObject2).setSize(this.aNa, this.aNb);
    }
    localObject1 = (com.tencent.mm.media.i.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void ajG()
  {
    AppMethodBeat.i(871);
    super.ajG();
    Object localObject = this.pvF;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.i.b.a)localObject).gVr;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.f.d)localObject).gRW;; i = -1)
    {
      localObject = this.fZP;
      if (localObject != null) {
        XLabEffect.a((XLabEffect)localObject, i);
      }
      localObject = b.puK;
      localObject = this.pvI;
      if (localObject == null) {
        k.fOy();
      }
      b.a.Y(((com.tencent.mm.media.f.d)localObject).gRW, this.aNa, this.aNb);
      localObject = this.fZP;
      if (localObject != null)
      {
        com.tencent.mm.media.f.d locald = this.pvI;
        if (locald == null) {
          k.fOy();
        }
        XLabEffect.a((XLabEffect)localObject, i, locald.gRW, 0L, false, 60);
      }
      localObject = this.pvG;
      if (localObject == null) {
        break;
      }
      ((m)localObject).ajG();
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
    this.pvL.set(paramRect);
    paramRect = this.pvF;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.pvG;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.pvI;
    if (paramRect != null) {
      paramRect.close();
    }
    cgd();
    this.gVc = ajF();
    paramRect = this.pvF;
    if (paramRect != null) {
      paramRect.cS(this.gqZ, this.gra);
    }
    paramRect = this.pvF;
    if (paramRect != null) {
      paramRect.cR(this.aNa, this.aNb);
    }
    paramRect = this.pvF;
    if (paramRect != null) {
      paramRect.mE(this.gVh);
    }
    paramRect = this.pvF;
    if (paramRect != null) {
      paramRect.gVi = this.gVi;
    }
    paramRect = this.pvG;
    if (paramRect != null) {
      paramRect.cS(this.aNa, this.aNb);
    }
    paramRect = this.pvG;
    if (paramRect != null) {
      paramRect.cR(this.grV, this.grW);
    }
    cge();
    AppMethodBeat.o(874);
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.cR(paramInt1, paramInt2);
    cgd();
    Object localObject = this.pvF;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cR(this.aNa, this.aNb);
    }
    localObject = this.pvG;
    if (localObject != null) {
      ((m)localObject).cS(this.aNa, this.aNb);
    }
    localObject = this.pvG;
    if (localObject != null) {
      ((m)localObject).cR(this.grV, this.grW);
    }
    cge();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.pvG;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.fZP;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fZP = null;
    localObject = this.pvI;
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