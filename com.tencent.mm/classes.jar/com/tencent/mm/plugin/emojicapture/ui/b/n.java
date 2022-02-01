package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.j.a
{
  public static final n.a rwS;
  public com.tencent.mm.plugin.xlabeffect.b hiH;
  private int mode;
  private int previewHeight;
  public final Rect previewRect;
  private int previewWidth;
  private com.tencent.mm.media.j.b.a rwM;
  private m rwN;
  public f rwO;
  private com.tencent.mm.media.g.d rwP;
  private int rwQ;
  private int rwR;
  
  static
  {
    AppMethodBeat.i(877);
    rwS = new n.a((byte)0);
    AppMethodBeat.o(877);
  }
  
  private n()
  {
    super(0, 0, 1, 2, 15);
    AppMethodBeat.i(876);
    this.mode = 0;
    this.previewRect = new Rect();
    AppMethodBeat.o(876);
  }
  
  private final void cJZ()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.rwQ = 160;
      this.rwR = (this.previewHeight * this.rwQ / this.previewWidth);
      return;
      if (this.hEp > 640)
      {
        this.previewWidth = 640;
        this.previewHeight = (this.hEq * 640 / this.hEp);
      }
      else
      {
        this.previewWidth = this.hEp;
        this.previewHeight = this.hEq;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 1137;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 640;
      }
    }
  }
  
  private final void cKa()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.previewRect.isEmpty())
    {
      localm = this.rwN;
      if (localm != null)
      {
        localm.C(0, 0, this.hEp, this.hEq);
        AppMethodBeat.o(875);
        return;
        localm = this.rwN;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.rwN;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.roA;
            localm.a(true, this.previewWidth * 0.0666667F);
          }
        }
      }
      else
      {
        AppMethodBeat.o(875);
        return;
      }
    }
    m localm = this.rwN;
    if (localm != null)
    {
      localm.C(this.previewRect.left, this.previewRect.top, this.previewRect.right, this.previewRect.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(870);
    this.rwP = com.tencent.mm.media.g.c.a(true, 8L);
    Object localObject1 = this.rwM;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.previewWidth, this.previewHeight, 2, 2);
    this.rwM = ((com.tencent.mm.media.j.b.a)localObject1);
    Object localObject2 = this.rwM;
    if (localObject2 != null) {
      ((com.tencent.mm.media.j.b.a)localObject2).ijH = true;
    }
    localObject2 = this.rwN;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.rwN = new m(this.previewWidth, this.previewHeight, this.hEp, this.hEq, (byte)0);
    localObject2 = this.rwN;
    if (localObject2 != null)
    {
      com.tencent.mm.media.g.d locald = this.rwP;
      if (locald == null) {
        p.hyc();
      }
      ((m)localObject2).hDl = locald.igv;
    }
    localObject2 = this.hiH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).destroy();
    }
    this.hiH = new com.tencent.mm.plugin.xlabeffect.b((byte)0);
    localObject2 = this.hiH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).ti(true);
    }
    localObject2 = this.hiH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).zG(false);
    }
    localObject2 = this.hiH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).a(this.rwO);
    }
    localObject2 = this.hiH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(this.previewWidth, this.previewHeight);
    }
    localObject1 = (com.tencent.mm.media.j.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void aED()
  {
    AppMethodBeat.i(871);
    super.aED();
    Object localObject = this.rwM;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).ijD;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).igv;; i = -1)
    {
      localObject = this.hiH;
      if (localObject != null) {
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i);
      }
      localObject = b.rvS;
      localObject = this.rwP;
      if (localObject == null) {
        p.hyc();
      }
      b.a.ab(((com.tencent.mm.media.g.d)localObject).igv, this.previewWidth, this.previewHeight);
      localObject = this.hiH;
      if (localObject != null)
      {
        com.tencent.mm.media.g.d locald = this.rwP;
        if (locald == null) {
          p.hyc();
        }
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i, locald.igv, false, 60);
      }
      localObject = this.rwN;
      if (localObject == null) {
        break;
      }
      ((m)localObject).aED();
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
    this.previewRect.set(paramRect);
    paramRect = this.rwM;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.rwN;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.rwP;
    if (paramRect != null) {
      paramRect.close();
    }
    cJZ();
    this.ijo = aEC();
    paramRect = this.rwM;
    if (paramRect != null) {
      paramRect.cZ(this.hDn, this.hDo);
    }
    paramRect = this.rwM;
    if (paramRect != null) {
      paramRect.cY(this.previewWidth, this.previewHeight);
    }
    paramRect = this.rwM;
    if (paramRect != null) {
      paramRect.qx(this.ijt);
    }
    paramRect = this.rwM;
    if (paramRect != null) {
      paramRect.iju = this.iju;
    }
    paramRect = this.rwN;
    if (paramRect != null) {
      paramRect.cZ(this.previewWidth, this.previewHeight);
    }
    paramRect = this.rwN;
    if (paramRect != null) {
      paramRect.cY(this.hEp, this.hEq);
    }
    cKa();
    AppMethodBeat.o(874);
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.cY(paramInt1, paramInt2);
    cJZ();
    Object localObject = this.rwM;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cY(this.previewWidth, this.previewHeight);
    }
    localObject = this.rwN;
    if (localObject != null) {
      ((m)localObject).cZ(this.previewWidth, this.previewHeight);
    }
    localObject = this.rwN;
    if (localObject != null) {
      ((m)localObject).cY(this.hEp, this.hEq);
    }
    cKa();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.rwN;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.hiH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.hiH = null;
    localObject = this.rwP;
    if (localObject != null)
    {
      ((com.tencent.mm.media.g.d)localObject).close();
      AppMethodBeat.o(872);
      return;
    }
    AppMethodBeat.o(872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.n
 * JD-Core Version:    0.7.0.1
 */