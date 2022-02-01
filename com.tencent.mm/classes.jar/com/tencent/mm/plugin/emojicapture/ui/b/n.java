package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"})
public final class n
  extends com.tencent.mm.media.j.a
{
  public static final a vcy;
  public e jUF;
  private int mode;
  private int previewHeight;
  public final Rect previewRect;
  private int previewWidth;
  private com.tencent.mm.media.j.b.a vcs;
  private m vct;
  public f vcu;
  private com.tencent.mm.media.g.d vcv;
  private int vcw;
  private int vcx;
  
  static
  {
    AppMethodBeat.i(877);
    vcy = new a((byte)0);
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
  
  private final void cYJ()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.vcw = 160;
      this.vcx = (this.previewHeight * this.vcw / this.previewWidth);
      return;
      if (this.ksu > 640)
      {
        this.previewWidth = 640;
        this.previewHeight = (this.ksv * 640 / this.ksu);
      }
      else
      {
        this.previewWidth = this.ksu;
        this.previewHeight = this.ksv;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 1137;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 640;
      }
    }
  }
  
  private final void cYK()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.previewRect.isEmpty())
    {
      localm = this.vct;
      if (localm != null)
      {
        localm.G(0, 0, this.ksu, this.ksv);
        AppMethodBeat.o(875);
        return;
        localm = this.vct;
        if (localm != null)
        {
          m.a(localm);
          continue;
          localm = this.vct;
          if (localm != null)
          {
            d.a locala = com.tencent.mm.plugin.emojicapture.model.d.uUg;
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
    m localm = this.vct;
    if (localm != null)
    {
      localm.G(this.previewRect.left, this.previewRect.top, this.previewRect.right, this.previewRect.bottom);
      AppMethodBeat.o(875);
      return;
    }
    AppMethodBeat.o(875);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(870);
    this.vcv = com.tencent.mm.media.g.c.a(true, 8L);
    Object localObject1 = this.vcs;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.j.b.c(this.krg, this.krh, this.previewWidth, this.previewHeight, 2, 2);
    this.vcs = ((com.tencent.mm.media.j.b.a)localObject1);
    Object localObject2 = this.vcs;
    if (localObject2 != null) {
      ((com.tencent.mm.media.j.b.a)localObject2).kYB = true;
    }
    localObject2 = this.vct;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.vct = new m(this.previewWidth, this.previewHeight, this.ksu, this.ksv, (byte)0);
    localObject2 = this.vct;
    if (localObject2 != null)
    {
      com.tencent.mm.media.g.d locald = this.vcv;
      if (locald == null) {
        p.iCn();
      }
      ((m)localObject2).kre = locald.kVj;
    }
    localObject2 = this.jUF;
    if (localObject2 != null) {
      ((e)localObject2).destroy();
    }
    this.jUF = new e(0, 0, 0, false, false, 15);
    localObject2 = this.jUF;
    if (localObject2 != null) {
      ((e)localObject2).wE(true);
    }
    localObject2 = this.jUF;
    if (localObject2 != null) {
      ((e)localObject2).DH(false);
    }
    localObject2 = this.jUF;
    if (localObject2 != null) {
      ((e)localObject2).a(this.vcu);
    }
    localObject2 = this.jUF;
    if (localObject2 != null) {
      ((e)localObject2).setSize(this.previewWidth, this.previewHeight);
    }
    localObject1 = (com.tencent.mm.media.j.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void aMU()
  {
    AppMethodBeat.i(871);
    super.aMU();
    Object localObject = this.vcs;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).kYx;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).kVj;; i = -1)
    {
      localObject = this.jUF;
      if (localObject != null) {
        e.a((e)localObject, i);
      }
      localObject = b.vbw;
      localObject = this.vcv;
      if (localObject == null) {
        p.iCn();
      }
      b.a.ac(((com.tencent.mm.media.g.d)localObject).kVj, this.previewWidth, this.previewHeight);
      localObject = this.jUF;
      if (localObject != null)
      {
        com.tencent.mm.media.g.d locald = this.vcv;
        if (locald == null) {
          p.iCn();
        }
        e.a((e)localObject, i, locald.kVj, false, 60);
      }
      localObject = this.vct;
      if (localObject == null) {
        break;
      }
      ((m)localObject).aMU();
      AppMethodBeat.o(871);
      return;
    }
    AppMethodBeat.o(871);
  }
  
  public final void b(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(874);
    p.k(paramRect, "previewRect");
    if (this.mode == paramInt)
    {
      AppMethodBeat.o(874);
      return;
    }
    this.mode = paramInt;
    this.previewRect.set(paramRect);
    paramRect = this.vcs;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.vct;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.vcv;
    if (paramRect != null) {
      paramRect.close();
    }
    cYJ();
    this.kYb = aMT();
    paramRect = this.vcs;
    if (paramRect != null) {
      paramRect.dv(this.krg, this.krh);
    }
    paramRect = this.vcs;
    if (paramRect != null) {
      paramRect.du(this.previewWidth, this.previewHeight);
    }
    paramRect = this.vcs;
    if (paramRect != null) {
      paramRect.tm(this.kYg);
    }
    paramRect = this.vcs;
    if (paramRect != null) {
      paramRect.kYh = this.kYh;
    }
    paramRect = this.vct;
    if (paramRect != null) {
      paramRect.dv(this.previewWidth, this.previewHeight);
    }
    paramRect = this.vct;
    if (paramRect != null) {
      paramRect.du(this.ksu, this.ksv);
    }
    cYK();
    AppMethodBeat.o(874);
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.du(paramInt1, paramInt2);
    cYJ();
    Object localObject = this.vcs;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).du(this.previewWidth, this.previewHeight);
    }
    localObject = this.vct;
    if (localObject != null) {
      ((m)localObject).dv(this.previewWidth, this.previewHeight);
    }
    localObject = this.vct;
    if (localObject != null) {
      ((m)localObject).du(this.ksu, this.ksv);
    }
    cYK();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.vct;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.jUF;
    if (localObject != null) {
      ((e)localObject).destroy();
    }
    this.jUF = null;
    localObject = this.vcv;
    if (localObject != null)
    {
      ((com.tencent.mm.media.g.d)localObject).close();
      AppMethodBeat.o(872);
      return;
    }
    AppMethodBeat.o(872);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender$Companion;", "", "()V", "MAX_FACE_TRACK_WIDTH", "", "MAX_PREVIEW_WIDTH", "plugin-emojicapture_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.n
 * JD-Core Version:    0.7.0.1
 */