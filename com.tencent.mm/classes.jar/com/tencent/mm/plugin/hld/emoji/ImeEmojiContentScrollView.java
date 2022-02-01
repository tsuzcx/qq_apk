package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "Lcom/tencent/mm/plugin/hld/emoji/IRecentEmojiListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getEmojiList", "()Ljava/util/ArrayList;", "lastY", "getLastY", "()I", "setLastY", "(I)V", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "refreshRecentEmoji", "reset", "setOnKeyboardActionListener", "listener", "updateHideArea", "rect", "Landroid/graphics/Rect;", "Companion", "plugin-hld_release"})
public final class ImeEmojiContentScrollView
  extends RecyclerView
  implements a, c
{
  public static final a DvZ;
  public final ArrayList<k> DvW;
  private com.tencent.mm.plugin.hld.keyboard.d DvX;
  private com.tencent.mm.plugin.hld.a.c DvY;
  private int zDE;
  
  static
  {
    AppMethodBeat.i(215732);
    DvZ = new a((byte)0);
    AppMethodBeat.o(215732);
  }
  
  public ImeEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(215729);
    AppMethodBeat.o(215729);
  }
  
  public ImeEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215731);
    this.DvW = new ArrayList();
    initView();
    AppMethodBeat.o(215731);
  }
  
  private void initView()
  {
    AppMethodBeat.i(215722);
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.ImeEmojiContentScrollView", "initView ".concat(String.valueOf(l1)));
    Object localObject1 = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.DvW;
    Object localObject2 = g.DHh;
    localObject2 = getContext();
    p.j(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)g.be((Context)localObject2, "emoji"));
    localObject1 = g.DHh;
    localObject1 = getRootView();
    p.j(localObject1, "rootView");
    localObject1 = ((View)localObject1).getContext();
    p.j(localObject1, "rootView.context");
    if (g.K((Context)localObject1, "emoji", "recent").MGI.isEmpty()) {
      this.DvW.remove(0);
    }
    localObject1 = getContext();
    p.j(localObject1, "context");
    setAdapter((RecyclerView.a)new d((Context)localObject1, this.DvW, (a)this));
    localObject1 = g.DHh;
    localObject1 = g.aLG("emoji");
    localObject2 = ((List)this.DvW).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!p.h(((k)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      localObject1 = g.DHh;
      g.a((c)this);
      long l2 = System.currentTimeMillis();
      Log.i("WxIme.ImeEmojiContentScrollView", "initView " + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
      AppMethodBeat.o(215722);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void a(fmu paramfmu)
  {
    Object localObject2 = null;
    AppMethodBeat.i(215723);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    Object localObject3 = new StringBuilder("onEmojiClick ");
    if (paramfmu != null) {}
    for (localObject1 = paramfmu.MGH;; localObject1 = null)
    {
      com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeEmojiContentScrollView", (String)localObject1);
      localObject3 = this.DvY;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (paramfmu != null) {
          localObject1 = paramfmu.content;
        }
        ((com.tencent.mm.plugin.hld.a.c)localObject3).aLs((String)localObject1);
      }
      eDj();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      if (!com.tencent.mm.plugin.hld.f.l.eCE())
      {
        localObject1 = g.DHh;
        g.a("emoji", paramfmu);
        paramfmu = com.tencent.mm.plugin.hld.model.k.DDb;
        paramfmu = g.DHh;
        com.tencent.mm.plugin.hld.model.k.n(6, g.aLG("emoji"), 1);
      }
      AppMethodBeat.o(215723);
      return;
    }
  }
  
  public final void eDj()
  {
    AppMethodBeat.i(215725);
    int i = this.DvW.size();
    Object localObject = g.DHh;
    localObject = getContext();
    p.j(localObject, "context");
    if (i < g.be((Context)localObject, "emoji").size())
    {
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      if (!com.tencent.mm.plugin.hld.f.l.eCE())
      {
        localObject = this.DvW;
        String str = getContext().getString(a.j.ime_emoji_subtype_recent);
        p.j(str, "context.getString(R.stri…ime_emoji_subtype_recent)");
        ((ArrayList)localObject).add(0, new k(str, "recent"));
      }
      localObject = getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).cM(0);
      }
      localObject = this.DvX;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.hld.keyboard.d)localObject).aLt("emoji");
        AppMethodBeat.o(215725);
        return;
      }
    }
    AppMethodBeat.o(215725);
  }
  
  public final ArrayList<k> getEmojiList()
  {
    return this.DvW;
  }
  
  public final int getLastY()
  {
    return this.zDE;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.d getRecentSelectedListener()
  {
    return this.DvX;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215726);
    Integer localInteger;
    Object localObject;
    label32:
    int i;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label107;
      }
      localObject = Float.valueOf(paramMotionEvent.getRawY());
      i = (int)((Float)localObject).floatValue();
      Log.v("WxIme.ImeEmojiContentScrollView", "action " + localInteger + ' ' + getX());
      if (localInteger != null) {
        break label116;
      }
      label82:
      if (localInteger != null) {
        break label132;
      }
    }
    label107:
    label116:
    while ((localInteger.intValue() != 2) || (Math.abs(this.zDE - i) <= 20)) {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(215726);
        return bool;
        localInteger = null;
        break;
        localObject = Double.valueOf(0.0D);
        break label32;
        if (localInteger.intValue() != 0) {
          break label82;
        }
        this.zDE = i;
      }
    }
    label132:
    Log.i("WxIme.ImeEmojiContentScrollView", "ImeEmojiGridScrollView onInterceptTouchEvent");
    AppMethodBeat.o(215726);
    return false;
  }
  
  public final void setLastY(int paramInt)
  {
    this.zDE = paramInt;
  }
  
  public final void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(215727);
    p.k(paramc, "listener");
    this.DvY = paramc;
    AppMethodBeat.o(215727);
  }
  
  public final void setRecentSelectedListener(com.tencent.mm.plugin.hld.keyboard.d paramd)
  {
    this.DvX = paramd;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */