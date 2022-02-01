package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "smileyRecentMaxCount", "getSmileyRecentMaxCount", "setSmileyRecentMaxCount", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"})
public final class i
{
  public static final a jJr;
  public boolean jJf;
  public boolean jJg;
  public boolean jJh;
  public boolean jJi;
  public boolean jJj;
  public boolean jJk;
  public boolean jJl;
  public boolean jJm;
  public boolean jJn;
  public boolean jJo;
  public int jJp;
  public final LinkedList<a<x>> jJq;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    jJr = new a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.Rcg;
    this.jJg = true;
    this.jJh = true;
    this.jJi = true;
    this.jJk = true;
    this.jJm = true;
    this.jJo = true;
    this.jJp = 8;
    this.jJq = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean ry(int paramInt)
  {
    AppMethodBeat.i(105544);
    Object localObject = h.ag(d.class);
    p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider();
    p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    if ((((e)localObject).aCa()) && ((paramInt == ChatFooterPanel.Rch) || (paramInt == ChatFooterPanel.Rcm) || (paramInt == ChatFooterPanel.Rcn) || (paramInt == ChatFooterPanel.Rco)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean rz(int paramInt)
  {
    return paramInt == ChatFooterPanel.Rch;
  }
  
  public final void aCo()
  {
    AppMethodBeat.i(105541);
    Object localObject1;
    if (this.scene == ChatFooterPanel.Rch)
    {
      localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject2 = ((f)localObject1).aHp().b(66832, Boolean.FALSE);
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
      if (bool != this.jJn) {
        ey(bool);
      }
      AppMethodBeat.o(105541);
      return;
    }
  }
  
  public final void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.jJn = paramBoolean;
    Iterator localIterator = ((Iterable)this.jJq).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void g(a<x> parama)
  {
    AppMethodBeat.i(105540);
    p.k(parama, "listener");
    this.jJq.remove(parama);
    AppMethodBeat.o(105540);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig$Companion;", "", "()V", "convertScene", "", "panelScene", "isShowCaptureEntrance", "", "scene", "isShowCustomEntrance", "plugin-emojisdk_release"})
  public static final class a
  {
    public static int rA(int paramInt)
    {
      if (paramInt != ChatFooterPanel.Rch)
      {
        if (paramInt == ChatFooterPanel.Rcm) {
          return 3;
        }
        if (paramInt == ChatFooterPanel.Rcn) {
          return 4;
        }
        if (paramInt == ChatFooterPanel.Rco) {
          return 5;
        }
      }
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.i
 * JD-Core Version:    0.7.0.1
 */