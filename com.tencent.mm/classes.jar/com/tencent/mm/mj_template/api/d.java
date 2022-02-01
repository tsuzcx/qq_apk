package com.tencent.mm.mj_template.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.fxr;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/api/IPluginMaasTemplate;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "creationBySameTemplate", "", "context", "Landroid/app/Activity;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "originIntent", "Landroid/content/Intent;", "entranceType", "", "destroyEngine", "enterAlubmTemplatePreviewUI", "requestCode", "mediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "enterMultiTemplatePreviewUI", "getFinderMaasConfig", "Lcom/tencent/mm/mj_template/api/IFinderMaasXConfig;", "getMaasPermissionChecker", "Lcom/tencent/mm/mj_template/api/IMaasUserPermissoinChecker;", "getPreloadedTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "templateId", "", "getSnsMaasConfig", "Lcom/tencent/mm/mj_template/api/ISnsMaasConfig;", "isDeviceSupportAlbumTemplate", "", "jumpToTemplateUI", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "intent", "launchTemplateSquare", "Landroid/content/Context;", "eventTopicId", "", "api", "Lcom/tencent/mm/mj_template/api/IFinderModuleApi;", "preload", "preloadMaas", "preloadTemplateInfo", "isFinder", "releaseMaas", "plugin-mj-template.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends com.tencent.mm.kernel.b.a
{
  public abstract void creationBySameTemplate(Activity paramActivity, byy parambyy, Intent paramIntent, int paramInt);
  
  public abstract void destroyEngine();
  
  public abstract void enterAlubmTemplatePreviewUI(Activity paramActivity, int paramInt, List<? extends GalleryItem.MediaItem> paramList, Intent paramIntent);
  
  public abstract void enterMultiTemplatePreviewUI(Activity paramActivity, int paramInt, List<? extends GalleryItem.MediaItem> paramList, Intent paramIntent);
  
  public abstract a getFinderMaasConfig();
  
  public abstract c getMaasPermissionChecker();
  
  public abstract fxr getPreloadedTemplateInfo(String paramString);
  
  public abstract e getSnsMaasConfig();
  
  public abstract void jumpToTemplateUI(Activity paramActivity, int paramInt, ArrayList<GalleryItem.MediaItem> paramArrayList, Intent paramIntent);
  
  public abstract void launchTemplateSquare(Context paramContext, long paramLong, Intent paramIntent, b paramb);
  
  public abstract void preload(long paramLong);
  
  public abstract void preloadMaas();
  
  public abstract void preloadTemplateInfo(String paramString, boolean paramBoolean);
  
  public abstract void releaseMaas();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.api.d
 * JD-Core Version:    0.7.0.1
 */