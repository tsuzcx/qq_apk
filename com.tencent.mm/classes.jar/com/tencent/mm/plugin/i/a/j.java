package com.tencent.mm.plugin.i.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.kernel.b.a;
import java.util.List;

public abstract interface j
  extends a
{
  public abstract void dumpAndMarkFinderFolder();
  
  public abstract void enterFinderProfileUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderShareFeedUI(Context paramContext, String paramString);
  
  public abstract void enterFinderTimelineUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderTopicUI(Context paramContext, Intent paramIntent);
  
  public abstract h getRedDotManager();
  
  public abstract void loadImage(String paramString, ImageView paramImageView);
  
  public abstract void reportPostRedDot(int paramInt);
  
  public abstract void shareStatsReport(List<String> paramList);
  
  public abstract boolean showFinderEntry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.j
 * JD-Core Version:    0.7.0.1
 */