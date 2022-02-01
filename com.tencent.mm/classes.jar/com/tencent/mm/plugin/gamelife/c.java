package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "dealBlackList", "", "context", "Landroid/content/Context;", "sessionId", "", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "", "isAssociateWithWAGame", "callback", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "userName", "scene", "", "enterSendGift", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "BlackListAssociateCallback", "BlackListSetCallback", "Companion", "plugin-gamelife_release"})
public abstract interface c
  extends a
{
  public static final c.c yaa = c.c.yab;
  
  public abstract void dealBlackList(Context paramContext, String paramString, i<Boolean> parami1, i<Boolean> parami2, b paramb);
  
  public abstract void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt);
  
  public abstract void enterSendGift(Context paramContext, String paramString);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static abstract interface a
  {
    public abstract void U(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "", "onDone", "", "isBlackList", "", "plugin-gamelife_release"})
  public static abstract interface b
  {
    public abstract void mM(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c
 * JD-Core Version:    0.7.0.1
 */