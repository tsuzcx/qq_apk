package com.tencent.mm.plugin.findersdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.kernel.b.a;
import java.util.List;

public abstract interface ak
  extends a
{
  public abstract boolean canEnterMvAndShowToast();
  
  public abstract void dumpAndMarkFinderFolder();
  
  public abstract void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderActivityProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderConversationUI(Context paramContext);
  
  public abstract void enterFinderGallery(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void enterFinderPoiFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderPostRouterUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderSelfProfile(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent, Boolean paramBoolean);
  
  public abstract void enterFinderTopicUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTopicUI(Context paramContext, String paramString);
  
  public abstract void enterFinderUI(Context paramContext, String paramString);
  
  public abstract void enterFinderUIFromMiniApp(Context paramContext, String paramString, ag.a<Object> parama, ag.a<Integer> parama1);
  
  public abstract String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract String fillContextIdToIntent(String paramString, Intent paramIntent);
  
  public abstract String genContextId(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract x getFinderOpenSdkApi();
  
  public abstract ad getFinderSwitchApi();
  
  public abstract af getFinderUIApi();
  
  public abstract ag getFinderUtilApi();
  
  public abstract z getRedDotManager();
  
  public abstract int getTimelineCommentScene();
  
  public abstract boolean hasFinderPosted();
  
  public abstract boolean isAllowEditFillingFullScreen();
  
  public abstract boolean isDisablePostHalfScreen();
  
  public abstract void loadAvatar(String paramString, ImageView paramImageView);
  
  public abstract void loadImage(String paramString, ImageView paramImageView);
  
  public abstract void loadImageForSns(String paramString, View paramView);
  
  public abstract void openChannelsCreateContact(Activity paramActivity, ag.a<Boolean> parama);
  
  public abstract void openChannelsPostPage(Activity paramActivity);
  
  public abstract void openFinderLiveOperationUI(Context paramContext, Intent paramIntent);
  
  public abstract void report21053(View paramView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, boolean paramBoolean);
  
  public abstract void report21053OnClick(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, String paramString4, long paramLong4, int paramInt5);
  
  public abstract void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public abstract void reportGiftOnReturn();
  
  public abstract void reportPostRedDot(int paramInt);
  
  public abstract void sdkShare(String paramString1, String paramString2, String paramString3);
  
  public abstract void set21084CommentScene(String paramString);
  
  public abstract void shareStatsReport(List<Pair<String, String>> paramList, boolean paramBoolean);
  
  public abstract boolean showFinderEntry();
  
  public abstract boolean showPostEntry();
  
  public abstract void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ak.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ak
 * JD-Core Version:    0.7.0.1
 */