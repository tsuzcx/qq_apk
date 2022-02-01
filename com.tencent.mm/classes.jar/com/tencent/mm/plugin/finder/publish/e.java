package com.tencent.mm.plugin.finder.publish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.findersdk.a.bj;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/IPublishRouterApi;", "", "enterCropAvatarUI", "", "context", "Landroid/app/Activity;", "i", "Landroid/content/Intent;", "rc", "", "enterCropAvatarUIFromProfile", "intent", "filePath", "", "resultFileName", "requestCode", "enterCropProfileBgUI", "enterFinderPostAlbumUI", "Landroid/content/Context;", "mediaType", "maxCount", "forResult", "", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderSharePostUI", "enterFinderTemplateAlbumUI", "enterFinderTemplateRecordUI", "enterPostUI", "json", "fromType", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;", "enterPreviewAtTimelineUI", "enterSelectCoverUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "reqCode", "postLongVideo", "plugin-finder-publish-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void R(Context paramContext, Intent paramIntent);
  
  public abstract void S(Context paramContext, Intent paramIntent);
  
  public abstract void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2);
  
  public abstract void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, djh paramdjh, int paramInt, boolean paramBoolean);
  
  public abstract void a(Context paramContext, Intent paramIntent, Boolean paramBoolean, Integer paramInteger);
  
  public abstract void a(Context paramContext, String paramString, int paramInt, bj parambj);
  
  public abstract void c(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void c(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void d(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void enterFinderPostRouterUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderPostUI(Context paramContext, Intent paramIntent);
  
  public abstract void m(Activity paramActivity, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.e
 * JD-Core Version:    0.7.0.1
 */