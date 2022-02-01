package com.tencent.mm.plugin.findersdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.thumbplayer.a.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.storagebase.h;
import java.util.List;

public abstract interface cn
  extends a
{
  public abstract boolean canEnterMvAndShowToast();
  
  public abstract void clearFinderRedDot(String paramString, ca.a<Integer> parama);
  
  public abstract void createAccount(Context paramContext, Intent paramIntent, String paramString, ca.a<Integer> parama);
  
  public abstract b createMediaInfo(FinderMedia paramFinderMedia, Long paramLong, boolean paramBoolean);
  
  public abstract void dumpAndMarkFinderFolder();
  
  public abstract void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderActivityProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderConversationUI(Context paramContext);
  
  public abstract void enterFinderGallery(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void enterFinderHotWordUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderLiveIncome(Context paramContext, String paramString);
  
  public abstract void enterFinderLiveLottery(Context paramContext, String paramString);
  
  public abstract void enterFinderPoiFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderPostRouterUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderPostUI(Context paramContext, String paramString, int paramInt, bj parambj);
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderSelfProfile(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent, Boolean paramBoolean);
  
  public abstract void enterFinderTopicUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTopicUI(Context paramContext, String paramString);
  
  public abstract void enterFinderTopicUI(Context paramContext, String paramString, ca.a<Integer> parama);
  
  public abstract void enterFinderUI(Context paramContext, String paramString);
  
  public abstract void enterFinderUIFromMiniApp(Context paramContext, String paramString, ca.a<Object> parama, ca.a<Integer> parama1);
  
  public abstract String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract String fillContextIdToIntent(String paramString, Intent paramIntent);
  
  public abstract String genContextId(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract h getDB();
  
  public abstract Context getFinderContext();
  
  public abstract bg getFinderOpenSdkApi();
  
  public abstract void getFinderRedDot(String paramString, ca.a<String> parama);
  
  public abstract bvl getFinderShareObject(FinderObject paramFinderObject, boolean paramBoolean);
  
  public abstract bv getFinderSwitchApi();
  
  public abstract bz getFinderUIApi();
  
  public abstract ca getFinderUtilApi();
  
  public abstract void getIncomePageInfoAndEnterIncome(Context paramContext);
  
  public abstract bl getRedDotManager();
  
  public abstract int getTimelineCommentScene();
  
  public abstract boolean hasFinderPosted();
  
  public abstract boolean isAllowEditFillingFullScreen();
  
  public abstract boolean isDisablePostHalfScreen();
  
  public abstract Boolean isPagEnable();
  
  public abstract void loadImage(String paramString, ImageView paramImageView);
  
  public abstract void loadImageForSns(String paramString, View paramView);
  
  public abstract void loadNotWxUrlImage(String paramString, ImageView paramImageView);
  
  public abstract void loadRingtoneBgImage(String paramString, ImageView paramImageView);
  
  public abstract void openChannelsPostPage(Activity paramActivity);
  
  public abstract void openFinderLiveOperationUI(Context paramContext, Intent paramIntent);
  
  public abstract void report21053(View paramView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, boolean paramBoolean);
  
  public abstract void report21053OnClick(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, String paramString4, long paramLong4, int paramInt5);
  
  public abstract void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public abstract void reportGiftOnReturn();
  
  public abstract void reportPostRedDot(int paramInt);
  
  public abstract void reserveChannelsLive(Activity paramActivity, String paramString, ca.a<Integer> parama1, ca.a<Integer> parama2);
  
  public abstract void sdkShare(String paramString1, String paramString2, String paramString3);
  
  public abstract void set21084CommentScene(String paramString);
  
  public abstract void shareStatsReport(List<Pair<String, String>> paramList, boolean paramBoolean);
  
  public abstract void showFinderEntranceDebugSheet(Activity paramActivity);
  
  public abstract boolean showFinderEntry();
  
  public abstract boolean showPostEntry();
  
  public abstract void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, cn.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cn
 * JD-Core Version:    0.7.0.1
 */