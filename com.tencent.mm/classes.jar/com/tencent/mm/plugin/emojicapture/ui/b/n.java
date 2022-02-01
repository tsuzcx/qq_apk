package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sticker.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewRender;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "mode", "", "(I)V", "faceTrackHeight", "faceTrackWidth", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "lastSticker", "Lcom/tencent/mm/sticker/StickerPack;", "outputRenderProc", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "previewHeight", "previewRect", "Landroid/graphics/Rect;", "previewWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "doInitRenderProc", "release", "shouldDestroySurfaceTexture", "", "render", "resizeContent", "resizePreview", "setInitPreviewRect", "updateDrawViewSize", "width", "height", "updateMode", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends com.tencent.mm.media.j.a
{
  public static final n.a yol;
  private int mode;
  public k muW;
  private int previewHeight;
  public final Rect previewRect;
  private int previewWidth;
  private com.tencent.mm.media.j.b.a yom;
  private m yon;
  public f yoo;
  private com.tencent.mm.media.g.d yop;
  private int yoq;
  private int yor;
  
  static
  {
    AppMethodBeat.i(877);
    yol = new n.a((byte)0);
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
  
  private final void dFa()
  {
    switch (this.mode)
    {
    }
    for (;;)
    {
      this.yoq = 160;
      this.yor = (this.previewHeight * this.yoq / this.previewWidth);
      return;
      if (this.mWn > 640)
      {
        this.previewWidth = 640;
        this.previewHeight = (this.mWo * 640 / this.mWn);
      }
      else
      {
        this.previewWidth = this.mWn;
        this.previewHeight = this.mWo;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 1137;
        continue;
        this.previewWidth = 640;
        this.previewHeight = 640;
      }
    }
  }
  
  private final void dFb()
  {
    AppMethodBeat.i(875);
    switch (this.mode)
    {
    }
    while (this.previewRect.isEmpty())
    {
      localm = this.yon;
      if (localm == null) {
        break label162;
      }
      localm.M(0, 0, this.mWn, this.mWo);
      AppMethodBeat.o(875);
      return;
      localm = this.yon;
      if (localm != null)
      {
        m.a(localm);
        continue;
        localm = this.yon;
        if (localm != null)
        {
          d.a locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
          localm.a(true, this.previewWidth * 0.0666667F);
        }
      }
    }
    m localm = this.yon;
    if (localm != null) {
      localm.M(this.previewRect.left, this.previewRect.top, this.previewRect.right, this.previewRect.bottom);
    }
    label162:
    AppMethodBeat.o(875);
  }
  
  public final void b(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(874);
    s.u(paramRect, "previewRect");
    if (this.mode == paramInt)
    {
      AppMethodBeat.o(874);
      return;
    }
    this.mode = paramInt;
    this.previewRect.set(paramRect);
    paramRect = this.yom;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.yon;
    if (paramRect != null) {
      paramRect.release();
    }
    paramRect = this.yop;
    if (paramRect != null) {
      paramRect.close();
    }
    dFa();
    this.nDm = bgD();
    paramRect = this.yom;
    if (paramRect != null) {
      paramRect.el(this.mVd, this.mVe);
    }
    paramRect = this.yom;
    if (paramRect != null) {
      paramRect.ek(this.previewWidth, this.previewHeight);
    }
    paramRect = this.yom;
    if (paramRect != null) {
      paramRect.th(this.nDr);
    }
    paramRect = this.yom;
    if (paramRect != null) {
      paramRect.gr(this.nvG);
    }
    paramRect = this.yon;
    if (paramRect != null) {
      paramRect.el(this.previewWidth, this.previewHeight);
    }
    paramRect = this.yon;
    if (paramRect != null) {
      paramRect.ek(this.mWn, this.mWo);
    }
    dFb();
    AppMethodBeat.o(874);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(870);
    this.yop = com.tencent.mm.media.g.c.d(true, 8L);
    Object localObject1 = this.yom;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.previewWidth, this.previewHeight, 2, 2);
    this.yom = ((com.tencent.mm.media.j.b.a)localObject1);
    Object localObject2 = this.yom;
    if (localObject2 != null) {
      ((com.tencent.mm.media.j.b.a)localObject2).gq(true);
    }
    localObject2 = this.yon;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    this.yon = new m(this.previewWidth, this.previewHeight, this.mWn, this.mWo, (byte)0);
    localObject2 = this.yon;
    if (localObject2 != null)
    {
      com.tencent.mm.media.g.d locald = this.yop;
      s.checkNotNull(locald);
      ((m)localObject2).mVb = locald.nAF;
    }
    localObject2 = this.muW;
    if (localObject2 != null) {
      ((k)localObject2).destroy();
    }
    this.muW = new k(0, 0, 0, false, false, 47);
    localObject2 = this.muW;
    if (localObject2 != null) {
      ((k)localObject2).Be(true);
    }
    localObject2 = this.muW;
    if (localObject2 != null) {
      ((k)localObject2).Jo(false);
    }
    localObject2 = this.muW;
    if (localObject2 != null) {
      ((k)localObject2).a(this.yoo);
    }
    localObject2 = this.muW;
    if (localObject2 != null) {
      ((k)localObject2).setSize(this.previewWidth, this.previewHeight);
    }
    localObject1 = (com.tencent.mm.media.j.b.a)localObject1;
    AppMethodBeat.o(870);
    return localObject1;
  }
  
  public final void bgE()
  {
    int i = -1;
    AppMethodBeat.i(871);
    super.bgE();
    Object localObject = this.yom;
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.muW;
      if (localObject != null) {
        k.a((k)localObject, i);
      }
      localObject = b.ynr;
      localObject = this.yop;
      s.checkNotNull(localObject);
      b.a.at(((com.tencent.mm.media.g.d)localObject).nAF, this.previewWidth, this.previewHeight);
      localObject = this.muW;
      if (localObject != null)
      {
        com.tencent.mm.media.g.d locald = this.yop;
        s.checkNotNull(locald);
        k.a((k)localObject, i, locald.nAF, false, 60);
      }
      localObject = this.yon;
      if (localObject != null) {
        ((m)localObject).bgE();
      }
      AppMethodBeat.o(871);
      return;
      localObject = ((com.tencent.mm.media.j.b.a)localObject).nDF;
      if (localObject != null) {
        i = ((com.tencent.mm.media.g.d)localObject).nAF;
      }
    }
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(873);
    super.ek(paramInt1, paramInt2);
    dFa();
    Object localObject = this.yom;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).ek(this.previewWidth, this.previewHeight);
    }
    localObject = this.yon;
    if (localObject != null) {
      ((m)localObject).el(this.previewWidth, this.previewHeight);
    }
    localObject = this.yon;
    if (localObject != null) {
      ((m)localObject).ek(this.mWn, this.mWo);
    }
    dFb();
    AppMethodBeat.o(873);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(872);
    super.release(paramBoolean);
    Object localObject = this.yon;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = this.muW;
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    this.muW = null;
    localObject = this.yop;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    AppMethodBeat.o(872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.n
 * JD-Core Version:    0.7.0.1
 */