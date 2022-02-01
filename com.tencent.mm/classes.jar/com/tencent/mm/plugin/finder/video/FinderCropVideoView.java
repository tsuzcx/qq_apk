package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import java.util.Collection;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCurrentPlaySecond", "", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements o
{
  private CropLayout qTx;
  
  public FinderCropVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FinderCropVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(199697);
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      String str1 = paraml.qCj.url;
      k.g(str1, "video.mediaObj.url");
      String str2 = paraml.aaX();
      Object localObject = paraml.qCj.qDR;
      if (localObject != null) {}
      for (localObject = ((bmm)localObject).DJV;; localObject = null)
      {
        this.qUN = ((alw)localObject);
        super.a("", str1, str2, null, paraml, paramFinderItem);
        AppMethodBeat.o(199697);
        return;
      }
    }
    super.a(paraml.getUrl(), paraml.getPath(), paraml.aaX(), paraml.qCj, paraml, paramFinderItem);
    AppMethodBeat.o(199697);
  }
  
  public final boolean cPP()
  {
    AppMethodBeat.i(199702);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(199702);
    return bool;
  }
  
  public final int csg()
  {
    return 2131493937;
  }
  
  public final void csh()
  {
    AppMethodBeat.i(168002);
    Object localObject1 = this.qTx;
    if (localObject1 == null) {
      k.aPZ("cropLayout");
    }
    ((CropLayout)localObject1).reset();
    Object localObject2 = getVideoMatrix();
    if (localObject2 != null)
    {
      if (((alw)localObject2).DmV.size() == 9)
      {
        localObject1 = new Matrix();
        localObject2 = ((alw)localObject2).DmV;
        k.g(localObject2, "it.value");
        ((Matrix)localObject1).setValues(j.o((Collection)localObject2));
        setRootMatrix((Matrix)localObject1);
      }
      AppMethodBeat.o(168002);
      return;
    }
    AppMethodBeat.o(168002);
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(199703);
    int i = getCurrPosSec();
    AppMethodBeat.o(199703);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    return this.qUQ;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.qUP;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(199705);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(199705);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(199704);
    int i = getVideoDurationSec();
    AppMethodBeat.o(199704);
    return i;
  }
  
  public final p getVideoMediaInfo()
  {
    AppMethodBeat.i(199698);
    p localp = getMediaInfo();
    AppMethodBeat.o(199698);
    return localp;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.qUO;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(2131299987);
    k.g(localObject, "findViewById(R.id.finder_crop_layout)");
    this.qTx = ((CropLayout)localObject);
    localObject = this.qTx;
    if (localObject == null) {
      k.aPZ("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.qTx;
    if (localObject == null) {
      k.aPZ("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.qTx;
    if (localObject == null) {
      k.aPZ("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.qTx;
    if (localObject == null) {
      k.aPZ("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(199699);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(199699);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(199701);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(199701);
  }
  
  public final void setRootMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(168003);
    k.h(paramMatrix, "matrix");
    if (getMediaInfo() == null)
    {
      AppMethodBeat.o(168003);
      return;
    }
    Object localObject = c.rMg;
    localObject = getMediaInfo();
    if (localObject == null) {
      k.fvU();
    }
    localObject = c.ZP(((p)localObject).path);
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.qTx;
    if (localCropLayout == null) {
      k.aPZ("cropLayout");
    }
    RelativeLayout localRelativeLayout = this.kuN;
    k.g(localRelativeLayout, "videoRoot");
    localCropLayout.a((View)localRelativeLayout, ((a)localObject).width, ((a)localObject).height, new Matrix(), CropLayout.c.HDI, (b)new a(paramMatrix));
    AppMethodBeat.o(168003);
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(199695);
    k.h(paramq, "onMuteListener");
    setMuteListener(paramq);
    AppMethodBeat.o(199695);
  }
  
  public final void setVideoPlayLifecycle(t paramt)
  {
    AppMethodBeat.i(199696);
    k.h(paramt, "videoPlayLifecycle");
    setLifecycle(paramt);
    AppMethodBeat.o(199696);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(199700);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(199700);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    a(Matrix paramMatrix)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */