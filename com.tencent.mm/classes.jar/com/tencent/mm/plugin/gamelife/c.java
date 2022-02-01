package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.appbrand.af.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "dealBlackList", "", "context", "Landroid/content/Context;", "sessionId", "", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "", "isAssociateWithWAGame", "callback", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "userName", "scene", "", "enterSendGift", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "BlackListAssociateCallback", "BlackListSetCallback", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends a
{
  public static final c.c IYY = c.c.IYZ;
  
  public abstract void dealBlackList(Context paramContext, String paramString, k<Boolean> paramk1, k<Boolean> paramk2, c.b paramb);
  
  public abstract void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt);
  
  public abstract void enterSendGift(Context paramContext, String paramString);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void au(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c
 * JD-Core Version:    0.7.0.1
 */