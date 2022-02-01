package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.j.a
{
  public static final n.a qfW;
  private int aXs;
  private int aXt;
  public com.tencent.mm.plugin.xlabeffect.b gvS;
  private int mode;
  private com.tencent.mm.media.j.b.a qfP;
  private m qfQ;
  public f qfR;
  private com.tencent.mm.media.g.d qfS;
  private int qfT;
  private int qfU;
  public final Rect qfV;
  
  static
  {
    AppMethodBeat.i(877);
    qfW = new n.a((byte)0);
    AppMethodBeat.o(877);
  }
  
  private n()
  {
    super(0, 0, 1, 2, 15);
    AppMethodBeat.i(876);
    this.mode = 0;
    this.qfV = new Rect();
    AppMethodBeat.o(876);
  }
  
  private final void clX()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.qfT = 160;
      this.qfU = (this.aXt * this.qfT / this.aXs);
      return;
      if (this.gOm > 640)
      {
        this.aXs = 640;
        this.aXt = (this.gOn * 640 / this.gOm);
      }
      else
      {
        this.aXs = this.gOm;
        this.aXt = this.gOn;
        continue;
        this.aXs = 640;
        this.aXt = 1137;
        continue;
        this.aXs = 640;
        this.aXt = 640;
      }
    }
  }
  
  private final void clY()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.qfV.isEmpty())
    {
      localm = this.qfQ;
      if (localm != null)
      {
        localm.C(0, 0, this.gOm, this.gOn);
        AppMethodBeat.o(875);
        return;
        localm = this.qfQ;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.qfQ;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pXB;
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
    m localm = this.qfQ;
    if (localm != null)
    {
      localm.C(this.qfV.left, this.qfV.top, this.qfV.right, this.qfV.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(870);
    this.qfS = com.tencent.mm.media.g.c.a(true, 8L);
    Object localObject1 = this.qfP;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.j.b.c(this.gNs, this.gNt, this.aXs, this.aXt, 2, 2);
    this.qfP = ((com.tencent.mm.media.j.b.a)localObject1);
    Object localObject2 = this.qfP;
    if (localObject2 != null) {
      ((com.tencent.mm.media.j.b.a)localObject2).hqm = true;
    }
    localObject2 = this.qfQ;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.qfQ = new m(this.aXs, this.aXt, this.gOm, this.gOn, (byte)0);
    localObject2 = this.qfQ;
    if (localObject2 != null)
    {
      com.tencent.mm.media.g.d locald = this.qfS;
      if (locald == null) {
        p.gkB();
      }
      ((m)localObject2).gNq = locald.hnc;
    }
    localObject2 = this.gvS;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).destroy();
    }
    this.gvS = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
    localObject2 = this.gvS;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).pX(true);
    }
    localObject2 = this.gvS;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).vJ(false);
    }
    localObject2 = this.gvS;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).a(this.qfR);
    }
    localObject2 = this.gvS;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(this.aXs, this.aXt);
    }
    localObject1 = (com.tencent.mm.media.j.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(871);
    super.amH();
    Object localObject = this.qfP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).hqi;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).hnc;; i = -1)
    {
      localObject = this.gvS;
      if (localObject != null) {
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i);
      }
      localObject = b.qeU;
      localObject = this.qfS;
      if (localObject == null) {
        p.gkB();
      }
      b.a.aa(((com.tencent.mm.media.g.d)localObject).hnc, this.aXs, this.aXt);
      localObject = this.gvS;
      if (localObject != null)
      {
        com.tencent.mm.media.g.d locald = this.qfS;
        if (locald == null) {
          p.gkB();
        }
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i, locald.hnc, false, 60);
      }
      localObject = this.qfQ;
      if (localObject == null) {
        break;
      }
      ((m)localObject).amH();
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
    this.qfV.set(paramRect);
    paramRect = this.qfP;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.qfQ;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.qfS;
    if (paramRect != null) {
      paramRect.close();
    }
    clX();
    this.hpT = amG();
    paramRect = this.qfP;
    if (paramRect != null) {
      paramRect.cU(this.gNs, this.gNt);
    }
    paramRect = this.qfP;
    if (paramRect != null) {
      paramRect.cT(this.aXs, this.aXt);
    }
    paramRect = this.qfP;
    if (paramRect != null) {
      paramRect.ng(this.hpY);
    }
    paramRect = this.qfP;
    if (paramRect != null) {
      paramRect.hpZ = this.hpZ;
    }
    paramRect = this.qfQ;
    if (paramRect != null) {
      paramRect.cU(this.aXs, this.aXt);
    }
    paramRect = this.qfQ;
    if (paramRect != null) {
      paramRect.cT(this.gOm, this.gOn);
    }
    clY();
    AppMethodBeat.o(874);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.cT(paramInt1, paramInt2);
    clX();
    Object localObject = this.qfP;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cT(this.aXs, this.aXt);
    }
    localObject = this.qfQ;
    if (localObject != null) {
      ((m)localObject).cU(this.aXs, this.aXt);
    }
    localObject = this.qfQ;
    if (localObject != null) {
      ((m)localObject).cT(this.gOm, this.gOn);
    }
    clY();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.qfQ;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.gvS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.gvS = null;
    localObject = this.qfS;
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