package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.ab;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final a fNQ;
  public boolean fNF;
  public boolean fNG;
  public boolean fNH;
  public boolean fNI;
  public boolean fNJ;
  public boolean fNK;
  public boolean fNL;
  public boolean fNM;
  public boolean fNN;
  public boolean fNO;
  public final LinkedList<a<y>> fNP;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    fNQ = new a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.BUT;
    this.fNG = true;
    this.fNH = true;
    this.fNI = true;
    this.fNK = true;
    this.fNM = true;
    this.fNO = true;
    this.fNP = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean lA(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = g.ad(d.class);
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((com.tencent.mm.pluginsdk.a.e)localObject).abA()) && ((paramInt == ChatFooterPanel.BUU) || (paramInt == ChatFooterPanel.BUZ) || (paramInt == ChatFooterPanel.BVa) || (paramInt == ChatFooterPanel.BVb)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean lB(int paramInt)
  {
    return paramInt == ChatFooterPanel.BUU;
  }
  
  public final void abN()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.BUU)
    {
      localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).afk().get(66832, Boolean.FALSE);
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
      if (bool != this.fNN) {
        dq(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void dq(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.fNN = paramBoolean;
    Iterator localIterator = ((Iterable)this.fNP).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void f(a<y> parama)
  {
    AppMethodBeat.i(105540);
    k.h(parama, "listener");
    this.fNP.remove(parama);
    AppMethodBeat.o(105540);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig$Companion;", "", "()V", "convertScene", "", "panelScene", "isShowCaptureEntrance", "", "scene", "isShowCustomEntrance", "plugin-emojisdk_release"})
  public static final class a
  {
    public static int lC(int paramInt)
    {
      if (paramInt != ChatFooterPanel.BUU)
      {
        if (paramInt == ChatFooterPanel.BUZ) {
          return 3;
        }
        if (paramInt == ChatFooterPanel.BVa) {
          return 4;
        }
        if (paramInt == ChatFooterPanel.BVb) {
          return 5;
        }
      }
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.i
 * JD-Core Version:    0.7.0.1
 */