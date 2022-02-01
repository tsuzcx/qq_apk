package com.tencent.mm.plugin.finder.vlog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.bt.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.e;
import d.g.a.q;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-finder_release"})
public final class d
  implements t
{
  public static final d.a sgt;
  final Context context;
  int gPA;
  private boolean isFinishing;
  RecordConfigProvider rRi;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  com.tencent.mm.api.y sgl;
  com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  e sgn;
  com.tencent.mm.bt.b sgo;
  final HashMap<String, d.b> sgp;
  private boolean sgq;
  g sgr;
  FrameLayout sgs;
  
  static
  {
    AppMethodBeat.i(204803);
    sgt = new d.a((byte)0);
    AppMethodBeat.o(204803);
  }
  
  public d(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(204802);
    this.sgs = paramFrameLayout;
    this.rTT = paramd;
    this.context = this.sgs.getContext();
    this.sgp = new HashMap();
    this.sgr = g.cGy;
    this.gPA = -1;
    AppMethodBeat.o(204802);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(204800);
    if (this.sgr == g.cGD)
    {
      this.sgr = g.cGy;
      com.tencent.mm.bt.b localb = this.sgo;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(g.cGD, 1, null);
      }
      AppMethodBeat.o(204800);
      return true;
    }
    AppMethodBeat.o(204800);
    return false;
  }
  
  public final void awk() {}
  
  public final void b(String paramString, q<? super Boolean, ? super String, ? super Boolean, d.y> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(204796);
    k.h(paramString, "sourcePath");
    k.h(paramq, "callback");
    Object localObject1 = (d.b)this.sgp.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((d.b)localObject1).sgu;; localObject1 = null)
    {
      this.sgl = ((com.tencent.mm.api.y)localObject1);
      if (this.sgl != null) {
        break;
      }
      paramq.d(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(204796);
      return;
    }
    ArtistCacheManager.Vm().rP(paramString);
    com.tencent.mm.cache.c.Vr().rR(bs.bG(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    paramString = this.sgl;
    if (paramString != null)
    {
      paramString = paramString.Iv();
      if (paramString == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.JE()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      paramString = this.sgl;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.Iv();
      label166:
      if (paramString == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.JD()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      paramString = this.sgl;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.Iv();
      label206:
      if (paramString == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.JG()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      paramString = this.sgl;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.Iv();
      label246:
      if (paramString == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.JJ()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      paramString = this.sgl;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.Iv();
      label286:
      if (paramString == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.JF()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      paramString = this.sgl;
      if (paramString == null) {
        break label537;
      }
      paramString = paramString.Iv();
      label326:
      if (paramString == null) {
        k.fOy();
      }
      if (!paramString.JI()) {
        break label542;
      }
    }
    label517:
    label522:
    label527:
    label532:
    label537:
    label542:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.sgl;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((com.tencent.mm.api.y)localObject1).Iv();
      }
      if (paramString == null) {
        k.fOy();
      }
      final boolean bool = paramString.JK();
      paramString = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arW();
      }
      paramString = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asd();
      final long l = bs.Gn();
      ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.sgl;
      if (paramString == null) {
        break label547;
      }
      paramString.a((s)new c(this, l, paramq, bool));
      AppMethodBeat.o(204796);
      return;
      paramString = null;
      break;
      paramString = null;
      break label166;
      paramString = null;
      break label206;
      paramString = null;
      break label246;
      paramString = null;
      break label286;
      paramString = null;
      break label326;
    }
    label547:
    AppMethodBeat.o(204796);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(204798);
    ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.sgp.values();
    k.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.b localb = (d.b)((Iterator)localObject).next();
      localb.sgu.onDestroy();
      localb.sgn.getPresenter().onDestroy();
    }
    this.sgp.clear();
    AppMethodBeat.o(204798);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(204799);
    ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.sgp.values();
    k.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.b localb = (d.b)((Iterator)localObject).next();
      localb.sgu.onDestroy();
      localb.sgn.getPresenter().onDestroy();
    }
    this.sgp.clear();
    this.sgs.removeAllViews();
    this.sgs.setVisibility(8);
    this.sgl = null;
    AppMethodBeat.o(204799);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(204797);
    ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.sgr = g.cGy;
    com.tencent.mm.bt.b localb = this.sgo;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(g.cGy);
    }
    localb = this.sgo;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(g.cGy, -1, null);
      AppMethodBeat.o(204797);
      return;
    }
    AppMethodBeat.o(204797);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204801);
    this.sgs.setVisibility(paramInt);
    AppMethodBeat.o(204801);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-finder_release"})
  public static final class c
    implements s
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(204788);
      ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bs.aO(l));
      Object localObject1 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.pt(bs.aO(l));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asc();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.b.dxd() + paramBitmap.hashCode();
        com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + bs.aO(l) + "  path:" + (String)localObject1);
        d.a(this.sgv);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.wDE;
        paramBitmap = d.b(this.sgv);
        localObject2 = d.c(this.sgv);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbH;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.sgw);
          ac.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + bs.aO(l));
          bool.d(Boolean.TRUE, localObject1, Boolean.valueOf(this.sgw));
          AppMethodBeat.o(204788);
          return;
        }
      }
      AppMethodBeat.o(204788);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(204787);
      k.h(paramException, "e");
      ac.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asb();
      paramException = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.pt(bs.aO(l));
      d.a(this.sgv);
      bool.d(Boolean.FALSE, null, Boolean.valueOf(this.sgw));
      AppMethodBeat.o(204787);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-finder_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(204790);
      k.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gfC);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.sgv.rTT.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.www, localBundle);
      AppMethodBeat.o(204790);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-finder_release"})
  public static final class e
    implements w
  {
    public final void a(g paramg)
    {
      AppMethodBeat.i(204792);
      k.h(paramg, "features");
      ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == g.cGy) {
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.sgv.rTT, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.wxg);
      }
      AppMethodBeat.o(204792);
    }
    
    public final void a(g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(204793);
      k.h(paramg, "features");
      ac.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(204793);
    }
    
    public final void bW(boolean paramBoolean) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class f
    implements b.a
  {
    f(d paramd) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204794);
      d locald = this.sgv;
      k.g(paramMotionEvent, "it");
      d.a(locald, paramMotionEvent);
      AppMethodBeat.o(204794);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class g
    implements b.a
  {
    g(d paramd) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204795);
      d locald = this.sgv;
      k.g(paramMotionEvent, "it");
      d.a(locald, paramMotionEvent);
      AppMethodBeat.o(204795);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.d
 * JD-Core Version:    0.7.0.1
 */