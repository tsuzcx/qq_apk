package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "", "()V", "value", "", "canSend", "getCanSend", "()Z", "setCanSend", "(Z)V", "hasCapture", "getHasCapture", "setHasCapture", "hasCaptureEntrance", "getHasCaptureEntrance", "setHasCaptureEntrance", "hasCustom", "getHasCustom", "setHasCustom", "hasCustomEntrance", "getHasCustomEntrance", "setHasCustomEntrance", "hasSendBtn", "getHasSendBtn", "setHasSendBtn", "hasSetting", "getHasSetting", "setHasSetting", "hasSmiley", "getHasSmiley", "setHasSmiley", "hasStore", "getHasStore", "setHasStore", "hasSysCustom", "getHasSysCustom", "setHasSysCustom", "scene", "", "getScene", "()I", "setScene", "(I)V", "sendListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "smileyRecentMaxCount", "getSmileyRecentMaxCount", "setSmileyRecentMaxCount", "addSendListener", "listener", "refreshSend", "removeSendListener", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a mix;
  public boolean miA;
  public boolean miB;
  public boolean miC;
  public boolean miD;
  public boolean miE;
  public boolean miF;
  public boolean miG;
  public boolean miH;
  public int miI;
  public final LinkedList<a<ah>> miJ;
  public boolean miy;
  public boolean miz;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105543);
    mix = new i.a((byte)0);
    AppMethodBeat.o(105543);
  }
  
  public i()
  {
    AppMethodBeat.i(105542);
    this.scene = ChatFooterPanel.XYl;
    this.miz = true;
    this.miA = true;
    this.miB = true;
    this.miD = true;
    this.miF = true;
    this.miH = true;
    this.miI = 8;
    this.miJ = new LinkedList();
    AppMethodBeat.o(105542);
  }
  
  public static final boolean rA(int paramInt)
  {
    AppMethodBeat.i(105544);
    if ((((d)h.az(d.class)).getProvider().aUX()) && ((paramInt == ChatFooterPanel.XYm) || (paramInt == ChatFooterPanel.XYr) || (paramInt == ChatFooterPanel.XYs) || (paramInt == ChatFooterPanel.XYt)))
    {
      AppMethodBeat.o(105544);
      return true;
    }
    AppMethodBeat.o(105544);
    return false;
  }
  
  public static final boolean rB(int paramInt)
  {
    return paramInt == ChatFooterPanel.XYm;
  }
  
  public final void aVk()
  {
    AppMethodBeat.i(105541);
    Object localObject;
    if (this.scene == ChatFooterPanel.XYm)
    {
      localObject = h.baE().ban().d(66832, Boolean.FALSE);
      if (!(localObject instanceof Boolean)) {
        break label67;
      }
      localObject = (Boolean)localObject;
      if (localObject != null) {
        break label72;
      }
    }
    label67:
    label72:
    for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
    {
      if (bool != this.miG) {
        fk(bool);
      }
      AppMethodBeat.o(105541);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void fk(boolean paramBoolean)
  {
    AppMethodBeat.i(105539);
    this.miG = paramBoolean;
    Iterator localIterator = ((Iterable)this.miJ).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).invoke();
    }
    AppMethodBeat.o(105539);
  }
  
  public final void y(a<ah> parama)
  {
    AppMethodBeat.i(105540);
    s.u(parama, "listener");
    this.miJ.remove(parama);
    AppMethodBeat.o(105540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.i
 * JD-Core Version:    0.7.0.1
 */