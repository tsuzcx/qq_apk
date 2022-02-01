package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "dealBlackList", "", "context", "Landroid/content/Context;", "sessionId", "", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "", "isAssociateWithWAGame", "callback", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "userName", "scene", "", "enterSendGift", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "BlackListAssociateCallback", "BlackListSetCallback", "Companion", "plugin-gamelife_release"})
public abstract interface c
  extends a
{
  public static final c.c DeH = c.c.DeI;
  
  public abstract void dealBlackList(Context paramContext, String paramString, i<Boolean> parami1, i<Boolean> parami2, c.b paramb);
  
  public abstract void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt);
  
  public abstract void enterSendGift(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c
 * JD-Core Version:    0.7.0.1
 */