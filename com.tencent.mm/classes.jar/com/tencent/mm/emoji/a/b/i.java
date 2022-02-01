package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.aj;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final i.a gnw;
  public boolean gnl;
  public boolean gnm;
  public boolean gnn;
  public boolean gno;
  public boolean gnp;
  public boolean gnq;
  public boolean gnr;
  public boolean gns;
  public boolean gnt;
  public boolean gnu;
  public final LinkedList<a<z>> gnv;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    gnw = new i.a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.FkJ;
    this.gnm = true;
    this.gnn = true;
    this.gno = true;
    this.gnq = true;
    this.gns = true;
    this.gnu = true;
    this.gnv = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean lX(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = g.ad(d.class);
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((com.tencent.mm.pluginsdk.a.e)localObject).afr()) && ((paramInt == ChatFooterPanel.FkK) || (paramInt == ChatFooterPanel.FkP) || (paramInt == ChatFooterPanel.FkQ) || (paramInt == ChatFooterPanel.FkR)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean lY(int paramInt)
  {
    return paramInt == ChatFooterPanel.FkK;
  }
  
  public final void afF()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.FkK)
    {
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(66832, Boolean.FALSE);
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
      if (bool != this.gnt) {
        dr(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.gnt = paramBoolean;
    Iterator localIterator = ((Iterable)this.gnv).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void g(a<z> parama)
  {
    AppMethodBeat.i(105540);
    p.h(parama, "listener");
    this.gnv.remove(parama);
    AppMethodBeat.o(105540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.i
 * JD-Core Version:    0.7.0.1
 */