package com.tencent.mm.plugin.i.a;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.kernel.b.a;
import java.util.List;
import java.util.Map;

public abstract interface aj
  extends a
{
  public abstract void batchGetLiveStatus(List<Pair<Long, String>> paramList, a parama);
  
  public abstract boolean canEnterMvAndShowToast();
  
  public abstract void checkInsertLiveNewReddot();
  
  public abstract void checkLastLiveObject();
  
  public abstract void cleatLiveStatusCache(Long paramLong);
  
  public abstract void dumpAndMarkFinderFolder();
  
  public abstract void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderActivityProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderConversationUI(Context paramContext);
  
  public abstract void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderLiveAnchorUI(Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void enterFinderLiveInvitedUI(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderLiveVisitorUI(Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void enterFinderPoiFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderPostRouterUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderSelfProfile(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent, Boolean paramBoolean);
  
  public abstract void enterFinderTopicUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderUI(Context paramContext, String paramString);
  
  public abstract void enterFinderUIFromMiniApp(Context paramContext, String paramString, af.a<Object> parama, af.a<Integer> parama1);
  
  public abstract String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract String fillContextIdToIntent(String paramString, Intent paramIntent);
  
  public abstract ac getFinderSwitchApi();
  
  public abstract ae getFinderUIApi();
  
  public abstract af getFinderUtilApi();
  
  public abstract void getLiveInfo(Long paramLong, b paramb);
  
  public abstract z getRedDotManager();
  
  public abstract int getTimelineCommentScene();
  
  public abstract boolean hasFinderPosted();
  
  public abstract boolean isAnchorLiving();
  
  public abstract boolean isDisablePostHalfScreen();
  
  public abstract void loadImage(String paramString, ImageView paramImageView);
  
  public abstract void loadImageForSns(String paramString, View paramView);
  
  public abstract void refreshLiveStatus(Long paramLong, b paramb);
  
  public abstract void report21053(View paramView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, boolean paramBoolean);
  
  public abstract void report21053OnClick(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, String paramString4, long paramLong4, int paramInt5);
  
  public abstract void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public abstract void reportGiftOnReturn();
  
  public abstract void reportPostRedDot(int paramInt);
  
  public abstract void sdkShare(String paramString1, String paramString2, String paramString3);
  
  public abstract void shareStatsReport(List<Pair<String, String>> paramList, boolean paramBoolean);
  
  public abstract boolean showFinderEntry();
  
  public abstract boolean showPostEntry();
  
  public abstract void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract void e(Map<Long, Integer> paramMap, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.aj
 * JD-Core Version:    0.7.0.1
 */