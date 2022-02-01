package com.tencent.d.a.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/IPluginFinderLiveSquare;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "enterFinderLiveEntrance", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveOperationUI", "enterFinderLiveSquare", "getTargetCommentScene", "", "commentScene", "tabId", "getTargetLiveTabId", "isEnableMoreEntrencePlugin", "", "isFinderLiveSquareCommentScene", "isFinderLiveSquareMoreCommentScene", "parseTabCommentScene", "Companion", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends a
{
  public static final d.a ahpU = d.a.ahpV;
  
  public abstract void enterFinderLiveEntrance(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderLiveSquare(Context paramContext, Intent paramIntent);
  
  public abstract int getTargetCommentScene(int paramInt);
  
  public abstract int getTargetCommentScene(int paramInt1, int paramInt2);
  
  public abstract int getTargetLiveTabId();
  
  public abstract boolean isEnableMoreEntrencePlugin(int paramInt);
  
  public abstract boolean isFinderLiveSquareCommentScene(int paramInt);
  
  public abstract boolean isFinderLiveSquareMoreCommentScene(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */