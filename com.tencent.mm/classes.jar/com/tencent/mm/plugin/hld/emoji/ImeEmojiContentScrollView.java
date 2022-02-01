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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.protocal.protobuf.gjm;
import com.tencent.mm.protocal.protobuf.gjn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "Lcom/tencent/mm/plugin/hld/emoji/IRecentEmojiListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getEmojiList", "()Ljava/util/ArrayList;", "lastY", "getLastY", "()I", "setLastY", "(I)V", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "refreshRecentEmoji", "reset", "setOnKeyboardActionListener", "listener", "updateHideArea", "rect", "Landroid/graphics/Rect;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEmojiContentScrollView
  extends RecyclerView
  implements a, c
{
  public static final ImeEmojiContentScrollView.a Jpc;
  private int EHM;
  public final ArrayList<k> Jpd;
  private com.tencent.mm.plugin.hld.keyboard.d Jpe;
  private com.tencent.mm.plugin.hld.a.c Jpf;
  
  static
  {
    AppMethodBeat.i(312758);
    Jpc = new ImeEmojiContentScrollView.a((byte)0);
    AppMethodBeat.o(312758);
  }
  
  public ImeEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(312740);
    AppMethodBeat.o(312740);
  }
  
  public ImeEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312746);
    this.Jpd = new ArrayList();
    initView();
    AppMethodBeat.o(312746);
  }
  
  private void initView()
  {
    AppMethodBeat.i(312756);
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.ImeEmojiContentScrollView", s.X("initView ", Long.valueOf(l1)));
    Object localObject1 = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.Jpd;
    Object localObject2 = g.Jyo;
    localObject2 = getContext();
    s.s(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)g.bg((Context)localObject2, "emoji"));
    localObject1 = g.Jyo;
    localObject1 = getRootView().getContext();
    s.s(localObject1, "rootView.context");
    if (g.K((Context)localObject1, "emoji", "recent").Trs.isEmpty()) {
      this.Jpd.remove(0);
    }
    localObject1 = getContext();
    s.s(localObject1, "context");
    setAdapter((RecyclerView.a)new d((Context)localObject1, this.Jpd, (a)this));
    localObject1 = g.Jyo;
    localObject1 = g.aIz("emoji");
    localObject2 = ((List)this.Jpd).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!s.p(((k)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      localObject1 = g.Jyo;
      g.a((c)this);
      long l2 = System.currentTimeMillis();
      Log.i("WxIme.ImeEmojiContentScrollView", "initView " + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
      AppMethodBeat.o(312756);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void a(gjm paramgjm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(312776);
    Object localObject1 = l.JyV;
    com.tencent.mm.plugin.hld.a.c localc;
    if (paramgjm == null)
    {
      localObject1 = null;
      l.jC("WxIme.ImeEmojiContentScrollView", s.X("onEmojiClick ", localObject1));
      localc = this.Jpf;
      if (localc != null) {
        if (paramgjm != null) {
          break label113;
        }
      }
    }
    label113:
    for (localObject1 = localObject2;; localObject1 = paramgjm.content)
    {
      localc.aIj((String)localObject1);
      fLj();
      localObject1 = l.JyV;
      if (!l.fKH())
      {
        localObject1 = g.Jyo;
        g.a("emoji", paramgjm);
        paramgjm = com.tencent.mm.plugin.hld.model.k.JvH;
        paramgjm = g.Jyo;
        com.tencent.mm.plugin.hld.model.k.r(6, g.aIz("emoji"), 1);
      }
      AppMethodBeat.o(312776);
      return;
      localObject1 = paramgjm.Trr;
      break;
    }
  }
  
  public final void fLj()
  {
    AppMethodBeat.i(312780);
    int i = this.Jpd.size();
    Object localObject = g.Jyo;
    localObject = getContext();
    s.s(localObject, "context");
    if (i < g.bg((Context)localObject, "emoji").size())
    {
      localObject = l.JyV;
      if (!l.fKH())
      {
        localObject = this.Jpd;
        String str = getContext().getString(a.j.ime_emoji_subtype_recent);
        s.s(str, "context.getString(R.stri…ime_emoji_subtype_recent)");
        ((ArrayList)localObject).add(0, new k(str, "recent"));
      }
      localObject = getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).fW(0);
      }
      localObject = this.Jpe;
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.keyboard.d)localObject).aIk("emoji");
      }
    }
    AppMethodBeat.o(312780);
  }
  
  public final ArrayList<k> getEmojiList()
  {
    return this.Jpd;
  }
  
  public final int getLastY()
  {
    return this.EHM;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.d getRecentSelectedListener()
  {
    return this.Jpe;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312799);
    Object localObject1;
    Object localObject2;
    label23:
    int i;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label104;
      }
      localObject2 = Double.valueOf(0.0D);
      i = (int)((Float)localObject2).floatValue();
      Log.v("WxIme.ImeEmojiContentScrollView", "action " + localObject1 + ' ' + getX());
      if (localObject1 != null) {
        break label116;
      }
      label73:
      if (localObject1 != null) {
        break label132;
      }
    }
    label104:
    label116:
    while ((((Integer)localObject1).intValue() != 2) || (Math.abs(this.EHM - i) <= 20)) {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(312799);
        return bool;
        localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        localObject2 = Float.valueOf(paramMotionEvent.getRawY());
        break label23;
        if (((Integer)localObject1).intValue() != 0) {
          break label73;
        }
        this.EHM = i;
      }
    }
    label132:
    Log.i("WxIme.ImeEmojiContentScrollView", "ImeEmojiGridScrollView onInterceptTouchEvent");
    AppMethodBeat.o(312799);
    return false;
  }
  
  public final void setLastY(int paramInt)
  {
    this.EHM = paramInt;
  }
  
  public final void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(312807);
    s.u(paramc, "listener");
    this.Jpf = paramc;
    AppMethodBeat.o(312807);
  }
  
  public final void setRecentSelectedListener(com.tencent.mm.plugin.hld.keyboard.d paramd)
  {
    this.Jpe = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */