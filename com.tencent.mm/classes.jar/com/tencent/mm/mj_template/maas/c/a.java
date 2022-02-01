package com.tencent.mm.mj_template.maas.c;

import android.view.SurfaceView;
import androidx.lifecycle.LiveData;
import com.tencent.maas.instamovie.MJExportSettings;
import com.tencent.maas.model.MJChannelEventConfig;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.ui.component.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC;", "Lcom/tencent/mm/ui/component/ApiUIC;", "export", "Lkotlinx/coroutines/flow/Flow;", "", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterLocalTemplate", "", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "templateList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentLyricInfo", "Lcom/tencent/maas/model/MJLyricInfo;", "getPlaybackDurationMs", "", "getPlayingState", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IPlayingState;", "getRecommendCategoryListLivedata", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/maas/model/MJTemplateCategory;", "getRecommendResultLiveData", "Lcom/tencent/mm/mj_template/maas/MaasRecommendResult;", "getRecommendTemplateListLivedata", "Lcom/tencent/maas/model/MJTemplateInfo;", "getTemplateEventInfo", "Lcom/tencent/maas/model/MJChannelEventConfig;", "recreateWithBlankTemplate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recreateWithMusicID", "musicId", "recreateWithTemplateID", "templateId", "registerUICallback", "", "callback", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$UICallback;", "setCreationTemplateIdAndMusicId", "setMaasMovieSessionConfigProvider", "provider", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IMaasMovieSessionConfigProvider;", "setMaasMovieSessionInitialParams", "params", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$MaasMovieSessionInitialParams;", "setMediaList", "mediaList", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setNeedRecommend", "autoRecommend", "", "setUseBlankForRecommend", "useBlank", "switchMovieOption", "musicMuted", "originMuted", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unRegisterUICallback", "IMaasMovieSessionConfigProvider", "IPlayingState", "MaasMovieSessionInitialParams", "UICallback", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends c
{
  public abstract Object H(d<? super kotlinx.coroutines.b.g<Float>> paramd);
  
  public abstract Object a(List<? extends fxr> paramList, d<? super List<? extends fxr>> paramd);
  
  public abstract void a(a parama);
  
  public abstract void a(a.c paramc);
  
  public abstract void a(d paramd);
  
  public abstract void aR(String paramString1, String paramString2);
  
  public abstract void byc();
  
  public abstract void byd();
  
  public abstract b bye();
  
  public abstract LiveData<com.tencent.mm.mj_template.maas.g> byf();
  
  public abstract LiveData<List<MJTemplateInfo>> byg();
  
  public abstract MJChannelEventConfig byh();
  
  public abstract long byi();
  
  public abstract List<MJLyricInfo> byj();
  
  public abstract Object c(boolean paramBoolean1, boolean paramBoolean2, d<? super ah> paramd);
  
  public abstract Object d(String paramString, d<? super kotlinx.coroutines.b.g<Float>> paramd);
  
  public abstract Object e(String paramString, d<? super kotlinx.coroutines.b.g<Float>> paramd);
  
  public abstract Object f(String paramString, d<? super kotlinx.coroutines.b.g<Float>> paramd);
  
  public abstract void gO(boolean paramBoolean);
  
  public abstract void setMediaList(List<? extends GalleryItem.MediaItem> paramList);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IMaasMovieSessionConfigProvider;", "", "provideExportSettings", "Lcom/tencent/maas/instamovie/MJExportSettings;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract MJExportSettings bwB();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IPlayingState;", "", "getCurrentMusicInfo", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/maas/model/MJMusicInfo;", "getCurrentMusicInfoList", "", "getMusicMuted", "", "getOriginMuted", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract LiveData<List<MJMusicInfo>> byk();
    
    public abstract LiveData<MJMusicInfo> byl();
    
    public abstract LiveData<Boolean> bym();
    
    public abstract LiveData<Boolean> byn();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$UICallback;", "", "beforeInitMovieSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreview", "onPreviewProgress", "progress", "", "onPreviewViewCreated", "previewView", "Landroid/view/SurfaceView;", "onSdkError", "msg", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void Hz(String paramString);
    
    public abstract void a(SurfaceView paramSurfaceView);
    
    public abstract void br(float paramFloat);
    
    public abstract void bwM();
    
    public abstract Object w(d<? super ah> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.c.a
 * JD-Core Version:    0.7.0.1
 */