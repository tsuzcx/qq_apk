package com.tencent.c.a.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.b.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/nearby/api/IPluginFinderLiveSquare;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "enterFinderLiveOperationUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveSquare", "getTargetCommentScene", "", "commentScene", "getTargetLiveTabId", "isEnableMoreEntrencePlugin", "", "isFinderLiveSquareCommentScene", "isFinderLiveSquareMoreCommentScene", "parseTabCommentScene", "tabId", "Companion", "plugin-finder-nearby-api_release"})
public abstract interface d
  extends a
{
  public static final d.a ZlX = d.a.ZlY;
  
  public abstract void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterFinderLiveSquare(Context paramContext, Intent paramIntent);
  
  public abstract int getTargetCommentScene(int paramInt);
  
  public abstract int getTargetLiveTabId();
  
  public abstract boolean isEnableMoreEntrencePlugin(int paramInt);
  
  public abstract boolean isFinderLiveSquareCommentScene(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */