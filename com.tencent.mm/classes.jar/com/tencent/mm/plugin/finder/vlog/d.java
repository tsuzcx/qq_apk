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
import com.tencent.mm.bu.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.e;
import d.g.a.q;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-finder_release"})
public final class d
  implements t
{
  public static final a LkF;
  final HashMap<String, b> LkE;
  final Context context;
  int goS;
  private boolean isFinishing;
  com.tencent.mm.api.y tJO;
  RecordConfigProvider vcC;
  com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  e vjT;
  com.tencent.mm.bu.b vjU;
  private boolean vjV;
  g vjW;
  FrameLayout vjX;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  static
  {
    AppMethodBeat.i(200672);
    LkF = new a((byte)0);
    AppMethodBeat.o(200672);
  }
  
  public d(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(200671);
    this.vjX = paramFrameLayout;
    this.vjo = paramd;
    this.context = this.vjX.getContext();
    this.LkE = new HashMap();
    this.vjW = g.cJr;
    this.goS = -1;
    AppMethodBeat.o(200671);
  }
  
  public final void apt() {}
  
  public final void b(String paramString, q<? super Boolean, ? super String, ? super Boolean, d.y> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200665);
    k.h(paramString, "sourcePath");
    k.h(paramq, "callback");
    Object localObject1 = (b)this.LkE.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((b)localObject1).LkG;; localObject1 = null)
    {
      this.tJO = ((com.tencent.mm.api.y)localObject1);
      if (this.tJO != null) {
        break;
      }
      paramq.d(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(200665);
      return;
    }
    ArtistCacheManager.Ur().aTR(paramString);
    c.Uw().aTT(bt.by(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    paramString = this.tJO;
    if (paramString != null)
    {
      paramString = paramString.IM();
      if (paramString == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.JU()));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      paramString = this.tJO;
      if (paramString == null) {
        break label512;
      }
      paramString = paramString.IM();
      label162:
      if (paramString == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.JT()));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      paramString = this.tJO;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.IM();
      label202:
      if (paramString == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.JW()));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      paramString = this.tJO;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.IM();
      label242:
      if (paramString == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.JZ()));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      paramString = this.tJO;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.IM();
      label282:
      if (paramString == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.JV()));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      paramString = this.tJO;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.IM();
      label322:
      if (paramString == null) {
        k.fvU();
      }
      if (!paramString.JY()) {
        break label537;
      }
    }
    label512:
    label517:
    label522:
    label527:
    label532:
    label537:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.tJO;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((com.tencent.mm.api.y)localObject1).IM();
      }
      if (paramString == null) {
        k.fvU();
      }
      final boolean bool = paramString.Ka();
      paramString = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.alc();
      }
      paramString = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alj();
      final long l = bt.GC();
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.tJO;
      if (paramString == null) {
        break label542;
      }
      paramString.a((s)new c(this, l, paramq, bool));
      AppMethodBeat.o(200665);
      return;
      paramString = null;
      break;
      paramString = null;
      break label162;
      paramString = null;
      break label202;
      paramString = null;
      break label242;
      paramString = null;
      break label282;
      paramString = null;
      break label322;
    }
    label542:
    AppMethodBeat.o(200665);
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(200669);
    if (this.vjW == g.cJw)
    {
      this.vjW = g.cJr;
      com.tencent.mm.bu.b localb = this.vjU;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(g.cJw, 1, null);
      }
      AppMethodBeat.o(200669);
      return true;
    }
    AppMethodBeat.o(200669);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(200667);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.LkE.values();
    k.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.LkG.onDestroy();
      localb.vjT.getPresenter().onDestroy();
    }
    this.LkE.clear();
    AppMethodBeat.o(200667);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(200668);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.LkE.values();
    k.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.LkG.onDestroy();
      localb.vjT.getPresenter().onDestroy();
    }
    this.LkE.clear();
    this.vjX.removeAllViews();
    this.vjX.setVisibility(8);
    this.tJO = null;
    AppMethodBeat.o(200668);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(200666);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.vjW = g.cJr;
    com.tencent.mm.bu.b localb = this.vjU;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(g.cJr);
    }
    localb = this.vjU;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(g.cJr, -1, null);
      AppMethodBeat.o(200666);
      return;
    }
    AppMethodBeat.o(200666);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200670);
    this.vjX.setVisibility(paramInt);
    AppMethodBeat.o(200670);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  static final class b
  {
    final com.tencent.mm.api.y LkG;
    final e vjT;
    
    public b(com.tencent.mm.api.y paramy, e parame)
    {
      AppMethodBeat.i(200652);
      this.LkG = paramy;
      this.vjT = parame;
      AppMethodBeat.o(200652);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200655);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!k.g(this.LkG, paramObject.LkG)) || (!k.g(this.vjT, paramObject.vjT))) {}
        }
      }
      else
      {
        AppMethodBeat.o(200655);
        return true;
      }
      AppMethodBeat.o(200655);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(200654);
      Object localObject = this.LkG;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.vjT;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(200654);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200653);
      String str = "PhotoEditorViewData(editor=" + this.LkG + ", drawingView=" + this.vjT + ")";
      AppMethodBeat.o(200653);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-finder_release"})
  public static final class c
    implements s
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(200657);
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bt.aS(l));
      Object localObject1 = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.lF(bt.aS(l));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.ali();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.b.dje() + paramBitmap.hashCode();
        com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + bt.aS(l) + "  path:" + (String)localObject1);
        d.a(this.LkH);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        paramBitmap = d.b(this.LkH);
        localObject2 = d.c(this.LkH);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBl;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.vka);
          ad.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + bt.aS(l));
          bool.d(Boolean.TRUE, localObject1, Boolean.valueOf(this.vka));
          AppMethodBeat.o(200657);
          return;
        }
      }
      AppMethodBeat.o(200657);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(200656);
      k.h(paramException, "e");
      ad.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alh();
      paramException = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.lF(bt.aS(l));
      d.a(this.LkH);
      bool.d(Boolean.FALSE, null, Boolean.valueOf(this.vka));
      AppMethodBeat.o(200656);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-finder_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(com.tencent.mm.aa.f paramf)
    {
      AppMethodBeat.i(200659);
      k.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gaW);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.LkH.vjo.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.vnP, localBundle);
      AppMethodBeat.o(200659);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-finder_release"})
  public static final class e
    implements w
  {
    public final void a(g paramg)
    {
      AppMethodBeat.i(200661);
      k.h(paramg, "features");
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == g.cJr) {
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.LkH.vjo, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.voz);
      }
      AppMethodBeat.o(200661);
    }
    
    public final void a(g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(200662);
      k.h(paramg, "features");
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(200662);
    }
    
    public final void bV(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class f
    implements b.a
  {
    f(d paramd) {}
    
    public final boolean p(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200663);
      d locald = this.LkH;
      k.g(paramMotionEvent, "it");
      d.a(locald, paramMotionEvent);
      AppMethodBeat.o(200663);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class g
    implements b.a
  {
    g(d paramd) {}
    
    public final boolean p(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200664);
      d locald = this.LkH;
      k.g(paramMotionEvent, "it");
      d.a(locald, paramMotionEvent);
      AppMethodBeat.o(200664);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.d
 * JD-Core Version:    0.7.0.1
 */