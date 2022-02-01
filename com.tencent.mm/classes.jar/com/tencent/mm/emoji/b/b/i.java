package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "smileyRecentMaxCount", "getSmileyRecentMaxCount", "setSmileyRecentMaxCount", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final i.a gYr;
  public boolean gYf;
  public boolean gYg;
  public boolean gYh;
  public boolean gYi;
  public boolean gYj;
  public boolean gYk;
  public boolean gYl;
  public boolean gYm;
  public boolean gYn;
  public boolean gYo;
  public int gYp;
  public final LinkedList<a<x>> gYq;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    gYr = new i.a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.KbB;
    this.gYg = true;
    this.gYh = true;
    this.gYi = true;
    this.gYk = true;
    this.gYm = true;
    this.gYo = true;
    this.gYp = 8;
    this.gYq = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean pf(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = g.ah(d.class);
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((com.tencent.mm.pluginsdk.a.e)localObject).avf()) && ((paramInt == ChatFooterPanel.KbC) || (paramInt == ChatFooterPanel.KbH) || (paramInt == ChatFooterPanel.KbI) || (paramInt == ChatFooterPanel.KbJ)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean pg(int paramInt)
  {
    return paramInt == ChatFooterPanel.KbC;
  }
  
  public final void avt()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.KbC)
    {
      localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(66832, Boolean.FALSE);
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
      if (bool != this.gYn) {
        eb(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.gYn = paramBoolean;
    Iterator localIterator = ((Iterable)this.gYq).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void g(a<x> parama)
  {
    AppMethodBeat.i(105540);
    p.h(parama, "listener");
    this.gYq.remove(parama);
    AppMethodBeat.o(105540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.i
 * JD-Core Version:    0.7.0.1
 */