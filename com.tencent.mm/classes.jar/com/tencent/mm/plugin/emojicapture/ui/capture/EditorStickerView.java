package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.a.m;
import a.f.b.j;
import a.f.b.u.c;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.a.c;
import com.tencent.mm.plugin.emojicapture.model.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "Lkotlin/ParameterName;", "name", "info", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstSelectSticker", "layoutManager", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "selectedPosition", "stickerAdapter", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "stickerCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1;", "stickerRecycler", "Landroid/support/v7/widget/RecyclerView;", "timeEnter", "", "isShow", "", "refreshSelected", "reset", "selectItem", "position", "setOnVisibleChangeCallback", "visible", "setShow", "show", "setup", "selectSticker", "plugin-emojicapture_release"})
public final class EditorStickerView
  extends RelativeLayout
{
  private final String TAG;
  private a.f.a.b<? super com.tencent.mm.plugin.emojicapture.model.a.b, y> evv;
  private long eyh;
  private int lxQ;
  private final RecyclerView lyH;
  private final com.tencent.mm.plugin.emojicapture.ui.a.a lyI;
  private final com.tencent.mm.plugin.emojicapture.ui.c.a lyJ;
  private String lyK;
  private final c lyL;
  
  public EditorStickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(3015);
    AppMethodBeat.o(3015);
  }
  
  public EditorStickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3014);
    this.TAG = "MicroMsg.EditorStickerView";
    this.lxQ = -1;
    View.inflate(paramContext, 2130969363, (ViewGroup)this);
    paramAttributeSet = findViewById(2131823558);
    j.p(paramAttributeSet, "findViewById(R.id.emoji_capture_sticker_recycler)");
    this.lyH = ((RecyclerView)paramAttributeSet);
    this.lyJ = new com.tencent.mm.plugin.emojicapture.ui.c.a(paramContext);
    this.lyH.setLayoutManager((RecyclerView.i)this.lyJ);
    this.lyI = new com.tencent.mm.plugin.emojicapture.ui.a.a();
    new af().i(this.lyH);
    this.lyH.setAdapter((RecyclerView.a)this.lyI);
    this.lyI.lxR = ((m)new EditorStickerView.1(this));
    float f = (am.hQ(paramContext).x - getResources().getDimension(2131428350)) / 2.0F - com.tencent.mm.cb.a.fromDPToPix(paramContext, 8);
    this.lyH.setPadding((int)f, 0, (int)f, 0);
    this.lyL = new c(this);
    AppMethodBeat.o(3014);
  }
  
  public final void bpd()
  {
    AppMethodBeat.i(3012);
    com.tencent.mm.ab.b.a(200L, (a.f.a.a)new EditorStickerView.a(this));
    AppMethodBeat.o(3012);
  }
  
  public final a.f.a.b<com.tencent.mm.plugin.emojicapture.model.a.b, y> getCallback()
  {
    return this.evv;
  }
  
  public final void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(3011);
    this.eyh = paramLong;
    this.lyK = paramString;
    paramString = c.ltQ;
    c.a((c.a)this.lyL);
    AppMethodBeat.o(3011);
  }
  
  public final void setCallback(a.f.a.b<? super com.tencent.mm.plugin.emojicapture.model.a.b, y> paramb)
  {
    this.evv = paramb;
  }
  
  public final void setOnVisibleChangeCallback(a.f.a.b<? super Boolean, y> paramb) {}
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(3013);
    if (paramBoolean)
    {
      if ((getVisibility() == 0) && (getAlpha() == 1.0F))
      {
        AppMethodBeat.o(3013);
        return;
      }
      setVisibility(0);
      animate().cancel();
      animate().alpha(1.0F).start();
      AppMethodBeat.o(3013);
      return;
    }
    if ((getVisibility() != 0) || (getAlpha() == 0.0F))
    {
      AppMethodBeat.o(3013);
      return;
    }
    animate().cancel();
    animate().alpha(0.0F).withEndAction((Runnable)new EditorStickerView.b(this)).start();
    AppMethodBeat.o(3013);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "notifyUpdate", "", "onItemChange", "position", "", "update", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
  public static final class c
    implements c.a
  {
    public final void S(LinkedList<com.tencent.mm.plugin.emojicapture.model.a.b> paramLinkedList)
    {
      AppMethodBeat.i(3008);
      j.q(paramLinkedList, "items");
      ab.i(EditorStickerView.d(this.lyM), "update: " + paramLinkedList.size());
      Object localObject = EditorStickerView.b(this.lyM);
      List localList = (List)paramLinkedList;
      j.q(localList, "audios");
      ab.i(com.tencent.mm.plugin.emojicapture.ui.a.a.TAG, "update: " + localList.size());
      ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).lxP.clear();
      ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).lxP.addAll((Collection)localList);
      int i;
      if (EditorStickerView.a(this.lyM) < 0)
      {
        localObject = new u.c();
        paramLinkedList = ((List)paramLinkedList).iterator();
        i = 0;
        if (!paramLinkedList.hasNext()) {
          break label247;
        }
        if (!j.e(((com.tencent.mm.plugin.emojicapture.model.a.b)paramLinkedList.next()).lsW, EditorStickerView.e(this.lyM))) {
          break label240;
        }
        label174:
        ((u.c)localObject).BNp = i;
        if (EditorStickerView.e(this.lyM) != null) {
          break label252;
        }
        ((u.c)localObject).BNp = 1;
      }
      for (;;)
      {
        EditorStickerView.f(this.lyM).lCm = ((m)new EditorStickerView.c.a(this));
        com.tencent.mm.ab.b.a(200L, (a.f.a.a)new EditorStickerView.c.b(this, (u.c)localObject));
        AppMethodBeat.o(3008);
        return;
        label240:
        i += 1;
        break;
        label247:
        i = -1;
        break label174;
        label252:
        if (((u.c)localObject).BNp < 0) {
          ((u.c)localObject).BNp = 0;
        }
      }
    }
    
    public final void boB()
    {
      AppMethodBeat.i(3009);
      ab.i(EditorStickerView.d(this.lyM), "notifyUpdate: ");
      EditorStickerView.b(this.lyM).notifyDataSetChanged();
      AppMethodBeat.o(3009);
    }
    
    public final void uH(int paramInt)
    {
      AppMethodBeat.i(3010);
      ab.i(EditorStickerView.d(this.lyM), "onItemChange: ".concat(String.valueOf(paramInt)));
      EditorStickerView.b(this.lyM).bR(paramInt);
      AppMethodBeat.o(3010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView
 * JD-Core Version:    0.7.0.1
 */