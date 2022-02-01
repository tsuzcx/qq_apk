package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.ai;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final i.a glb;
  public boolean gkQ;
  public boolean gkR;
  public boolean gkS;
  public boolean gkT;
  public boolean gkU;
  public boolean gkV;
  public boolean gkW;
  public boolean gkX;
  public boolean gkY;
  public boolean gkZ;
  public final LinkedList<a<z>> gla;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    glb = new i.a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.ESo;
    this.gkR = true;
    this.gkS = true;
    this.gkT = true;
    this.gkV = true;
    this.gkX = true;
    this.gkZ = true;
    this.gla = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean lV(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = g.ad(d.class);
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((com.tencent.mm.pluginsdk.a.e)localObject).afd()) && ((paramInt == ChatFooterPanel.ESp) || (paramInt == ChatFooterPanel.ESu) || (paramInt == ChatFooterPanel.ESv) || (paramInt == ChatFooterPanel.ESw)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean lW(int paramInt)
  {
    return paramInt == ChatFooterPanel.ESp;
  }
  
  public final void afr()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.ESp)
    {
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(66832, Boolean.FALSE);
      localObject1 = localObject2;
      if (!(localObject2 instanceof Boolean)) {
        localObject1 = null;
      }
      localObject1 = (Boolean)localObject1;
      if (localObject1 == null) {
        break label82;
      }
    }
    label82:
    for (boolean bool = ((Boolean)localObject1).booleanValue();; bool = false)
    {
      if (bool != this.gkY) {
        dr(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.gkY = paramBoolean;
    Iterator localIterator = ((Iterable)this.gla).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void f(a<z> parama)
  {
    AppMethodBeat.i(105540);
    p.h(parama, "listener");
    this.gla.remove(parama);
    AppMethodBeat.o(105540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.i
 * JD-Core Version:    0.7.0.1
 */