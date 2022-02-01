package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.ae;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final i.a fRB;
  public final LinkedList<a<y>> fRA;
  public boolean fRq;
  public boolean fRr;
  public boolean fRs;
  public boolean fRt;
  public boolean fRu;
  public boolean fRv;
  public boolean fRw;
  public boolean fRx;
  public boolean fRy;
  public boolean fRz;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    fRB = new i.a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.Dnj;
    this.fRr = true;
    this.fRs = true;
    this.fRt = true;
    this.fRv = true;
    this.fRx = true;
    this.fRz = true;
    this.fRA = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean lw(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = g.ad(d.class);
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((com.tencent.mm.pluginsdk.a.e)localObject).acz()) && ((paramInt == ChatFooterPanel.Dnk) || (paramInt == ChatFooterPanel.Dnp) || (paramInt == ChatFooterPanel.Dnq) || (paramInt == ChatFooterPanel.Dnr)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean lx(int paramInt)
  {
    return paramInt == ChatFooterPanel.Dnk;
  }
  
  public final void acN()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.Dnk)
    {
      localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).agA().get(66832, Boolean.FALSE);
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
      if (bool != this.fRy) {
        dp(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.fRy = paramBoolean;
    Iterator localIterator = ((Iterable)this.fRA).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void f(a<y> parama)
  {
    AppMethodBeat.i(105540);
    k.h(parama, "listener");
    this.fRA.remove(parama);
    AppMethodBeat.o(105540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.i
 * JD-Core Version:    0.7.0.1
 */