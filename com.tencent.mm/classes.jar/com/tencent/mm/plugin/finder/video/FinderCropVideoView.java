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
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import java.util.Collection;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCurrentPlaySecond", "", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView
  extends FinderVideoView
  implements o
{
  private CropLayout rKu;
  
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
    AppMethodBeat.i(203682);
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      String str1 = paraml.rtl.url;
      k.g(str1, "video.mediaObj.url");
      String str2 = paraml.abW();
      Object localObject = paraml.rtl.rvh;
      if (localObject != null) {}
      for (localObject = ((brc)localObject).Fgk;; localObject = null)
      {
        this.rTu = ((aoz)localObject);
        super.a("", str1, str2, null, paraml, paramFinderItem);
        AppMethodBeat.o(203682);
        return;
      }
    }
    super.a(paraml.getUrl(), paraml.getPath(), paraml.abW(), paraml.rtl, paraml, paramFinderItem);
    AppMethodBeat.o(203682);
  }
  
  public final boolean cBe()
  {
    return false;
  }
  
  public final int cDA()
  {
    return 2131493937;
  }
  
  public final void cDB()
  {
    AppMethodBeat.i(168002);
    Object localObject1 = this.rKu;
    if (localObject1 == null) {
      k.aVY("cropLayout");
    }
    ((CropLayout)localObject1).reset();
    Object localObject2 = getVideoMatrix();
    if (localObject2 != null)
    {
      if (((aoz)localObject2).EHU.size() == 9)
      {
        localObject1 = new Matrix();
        localObject2 = ((aoz)localObject2).EHU;
        k.g(localObject2, "it.value");
        ((Matrix)localObject1).setValues(j.p((Collection)localObject2));
        setRootMatrix((Matrix)localObject1);
      }
      AppMethodBeat.o(168002);
      return;
    }
    AppMethodBeat.o(168002);
  }
  
  public final boolean cDz()
  {
    AppMethodBeat.i(203687);
    boolean bool = get_isPreviewing();
    AppMethodBeat.o(203687);
    return bool;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(203688);
    int i = getCurrPosSec();
    AppMethodBeat.o(203688);
    return i;
  }
  
  public final boolean getIsNeverStart()
  {
    return this.rRZ;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.rRB;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(203690);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(203690);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(203689);
    int i = getVideoDurationSec();
    AppMethodBeat.o(203689);
    return i;
  }
  
  public final p getVideoMediaInfo()
  {
    AppMethodBeat.i(203683);
    p localp = getMediaInfo();
    AppMethodBeat.o(203683);
    return localp;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.rRA;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(168001);
    super.initView();
    Object localObject = findViewById(2131299987);
    k.g(localObject, "findViewById(R.id.finder_crop_layout)");
    this.rKu = ((CropLayout)localObject);
    localObject = this.rKu;
    if (localObject == null) {
      k.aVY("cropLayout");
    }
    ((CropLayout)localObject).setEnableTouch(false);
    localObject = this.rKu;
    if (localObject == null) {
      k.aVY("cropLayout");
    }
    ((CropLayout)localObject).setEnableScale(false);
    localObject = this.rKu;
    if (localObject == null) {
      k.aVY("cropLayout");
    }
    ((CropLayout)localObject).setEnableFling(false);
    localObject = this.rKu;
    if (localObject == null) {
      k.aVY("cropLayout");
    }
    ((CropLayout)localObject).setEnableOverScroll(false);
    AppMethodBeat.o(168001);
  }
  
  public final void onRelease() {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(203684);
    setShouldPlayResume(paramBoolean);
    AppMethodBeat.o(203684);
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(203686);
    set_isPreviewing(paramBoolean);
    AppMethodBeat.o(203686);
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
    Object localObject = c.sTV;
    localObject = getMediaInfo();
    if (localObject == null) {
      k.fOy();
    }
    localObject = c.aeB(((p)localObject).path);
    paramMatrix = new Matrix(paramMatrix);
    CropLayout localCropLayout = this.rKu;
    if (localCropLayout == null) {
      k.aVY("cropLayout");
    }
    RelativeLayout localRelativeLayout = this.kWc;
    k.g(localRelativeLayout, "videoRoot");
    localCropLayout.a((View)localRelativeLayout, ((a)localObject).width, ((a)localObject).height, new Matrix(), CropLayout.e.Jef, (b)new FinderCropVideoView.a(paramMatrix));
    AppMethodBeat.o(168003);
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(203680);
    k.h(paramq, "onMuteListener");
    setMuteListener(paramq);
    AppMethodBeat.o(203680);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(203681);
    k.h(paramu, "videoPlayLifecycle");
    setLifecycle(paramu);
    AppMethodBeat.o(203681);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(203685);
    setViewFocused(paramBoolean);
    AppMethodBeat.o(203685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderCropVideoView
 * JD-Core Version:    0.7.0.1
 */