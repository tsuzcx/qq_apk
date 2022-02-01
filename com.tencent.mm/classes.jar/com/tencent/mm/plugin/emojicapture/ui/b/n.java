package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.j.a
{
  public static final n.a pZr;
  private int aXs;
  private int aXt;
  public com.tencent.mm.plugin.xlabeffect.b gtl;
  private int mode;
  private com.tencent.mm.media.j.b.a pZk;
  private m pZl;
  public f pZm;
  private com.tencent.mm.media.g.d pZn;
  private int pZo;
  private int pZp;
  public final Rect pZq;
  
  static
  {
    AppMethodBeat.i(877);
    pZr = new n.a((byte)0);
    AppMethodBeat.o(877);
  }
  
  private n()
  {
    super(0, 0, 1, 2, 15);
    AppMethodBeat.i(876);
    this.mode = 0;
    this.pZq = new Rect();
    AppMethodBeat.o(876);
  }
  
  private final void ckH()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.pZo = 160;
      this.pZp = (this.aXt * this.pZo / this.aXs);
      return;
      if (this.gLD > 640)
      {
        this.aXs = 640;
        this.aXt = (this.gLE * 640 / this.gLD);
      }
      else
      {
        this.aXs = this.gLD;
        this.aXt = this.gLE;
        continue;
        this.aXs = 640;
        this.aXt = 1137;
        continue;
        this.aXs = 640;
        this.aXt = 640;
      }
    }
  }
  
  private final void ckI()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.pZq.isEmpty())
    {
      localm = this.pZl;
      if (localm != null)
      {
        localm.C(0, 0, this.gLD, this.gLE);
        AppMethodBeat.o(875);
        return;
        localm = this.pZl;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.pZl;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
            localm.a(true, this.aXs * 0.0666667F);
          }
        }
      }
      else
      {
        AppMethodBeat.o(875);
        return;
      }
    }
    m localm = this.pZl;
    if (localm != null)
    {
      localm.C(this.pZq.left, this.pZq.top, this.pZq.right, this.pZq.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(870);
    this.pZn = com.tencent.mm.media.g.c.a(true, 8L);
    Object localObject1 = this.pZk;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.j.b.c(this.gKJ, this.gKK, this.aXs, this.aXt, 2, 2);
    this.pZk = ((com.tencent.mm.media.j.b.a)localObject1);
    Object localObject2 = this.pZk;
    if (localObject2 != null) {
      ((com.tencent.mm.media.j.b.a)localObject2).hny = true;
    }
    localObject2 = this.pZl;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.pZl = new m(this.aXs, this.aXt, this.gLD, this.gLE, (byte)0);
    localObject2 = this.pZl;
    if (localObject2 != null)
    {
      com.tencent.mm.media.g.d locald = this.pZn;
      if (locald == null) {
        p.gfZ();
      }
      ((m)localObject2).gKH = locald.hko;
    }
    localObject2 = this.gtl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).destroy();
    }
    this.gtl = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
    localObject2 = this.gtl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).pP(true);
    }
    localObject2 = this.gtl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).vB(false);
    }
    localObject2 = this.gtl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).a(this.pZm);
    }
    localObject2 = this.gtl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(this.aXs, this.aXt);
    }
    localObject1 = (com.tencent.mm.media.j.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void ams()
  {
    AppMethodBeat.i(871);
    super.ams();
    Object localObject = this.pZk;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).hnu;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).hko;; i = -1)
    {
      localObject = this.gtl;
      if (localObject != null) {
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i);
      }
      localObject = b.pYp;
      localObject = this.pZn;
      if (localObject == null) {
        p.gfZ();
      }
      b.a.aa(((com.tencent.mm.media.g.d)localObject).hko, this.aXs, this.aXt);
      localObject = this.gtl;
      if (localObject != null)
      {
        com.tencent.mm.media.g.d locald = this.pZn;
        if (locald == null) {
          p.gfZ();
        }
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i, locald.hko, false, 60);
      }
      localObject = this.pZl;
      if (localObject == null) {
        break;
      }
      ((m)localObject).ams();
      AppMethodBeat.o(871);
      return;
    }
    AppMethodBeat.o(871);
  }
  
  public final void b(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(874);
    p.h(paramRect, "previewRect");
    if (this.mode == paramInt)
    {
      AppMethodBeat.o(874);
      return;
    }
    this.mode = paramInt;
    this.pZq.set(paramRect);
    paramRect = this.pZk;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.pZl;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.pZn;
    if (paramRect != null) {
      paramRect.close();
    }
    ckH();
    this.hnf = amr();
    paramRect = this.pZk;
    if (paramRect != null) {
      paramRect.cU(this.gKJ, this.gKK);
    }
    paramRect = this.pZk;
    if (paramRect != null) {
      paramRect.cT(this.aXs, this.aXt);
    }
    paramRect = this.pZk;
    if (paramRect != null) {
      paramRect.nd(this.hnk);
    }
    paramRect = this.pZk;
    if (paramRect != null) {
      paramRect.hnl = this.hnl;
    }
    paramRect = this.pZl;
    if (paramRect != null) {
      paramRect.cU(this.aXs, this.aXt);
    }
    paramRect = this.pZl;
    if (paramRect != null) {
      paramRect.cT(this.gLD, this.gLE);
    }
    ckI();
    AppMethodBeat.o(874);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.cT(paramInt1, paramInt2);
    ckH();
    Object localObject = this.pZk;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cT(this.aXs, this.aXt);
    }
    localObject = this.pZl;
    if (localObject != null) {
      ((m)localObject).cU(this.aXs, this.aXt);
    }
    localObject = this.pZl;
    if (localObject != null) {
      ((m)localObject).cT(this.gLD, this.gLE);
    }
    ckI();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.pZl;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.gtl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.gtl = null;
    localObject = this.pZn;
    if (localObject != null)
    {
      ((com.tencent.mm.media.g.d)localObject).close();
      AppMethodBeat.o(872);
      return;
    }
    AppMethodBeat.o(872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.n
 * JD-Core Version:    0.7.0.1
 */