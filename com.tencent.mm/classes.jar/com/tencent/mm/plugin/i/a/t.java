package com.tencent.mm.plugin.i.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.kernel.b.a;
import java.util.List;

public abstract interface t
  extends a
{
  public abstract void dumpAndMarkFinderFolder();
  
  public abstract void enterFinderConversationUI(Context paramContext);
  
  public abstract void enterFinderPostRouterUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTopicUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderUI(Context paramContext, String paramString);
  
  public abstract String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract o getRedDotManager();
  
  public abstract int getTimelineCommentScene();
  
  public abstract boolean hasFinderPosted();
  
  public abstract void loadImage(String paramString, ImageView paramImageView);
  
  public abstract void reportPostRedDot(int paramInt);
  
  public abstract void shareStatsReport(List<String> paramList);
  
  public abstract boolean showFinderEntry();
  
  public abstract void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract Object tryGetFinderObject(long paramLong, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.t
 * JD-Core Version:    0.7.0.1
 */