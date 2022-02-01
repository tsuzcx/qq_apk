package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.b;
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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "kaoemojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getKaoemojiList", "()Ljava/util/ArrayList;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "reset", "Companion", "plugin-hld_release"})
public final class ImeKaoEmojiContentScrollView
  extends RecyclerView
  implements a
{
  public static final a DwE;
  private com.tencent.mm.plugin.hld.keyboard.d DvX;
  private final ArrayList<k> DwD;
  
  static
  {
    AppMethodBeat.i(212296);
    DwE = new a((byte)0);
    AppMethodBeat.o(212296);
  }
  
  public ImeKaoEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212292);
    AppMethodBeat.o(212292);
  }
  
  public ImeKaoEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212294);
    this.DwD = new ArrayList();
    initView();
    AppMethodBeat.o(212294);
  }
  
  private void initView()
  {
    AppMethodBeat.i(212285);
    Object localObject1 = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.DwD;
    Object localObject2 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject2 = getContext();
    p.j(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)com.tencent.mm.plugin.hld.f.g.be((Context)localObject2, "kaoemoji"));
    localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject1 = getRootView();
    p.j(localObject1, "rootView");
    localObject1 = ((View)localObject1).getContext();
    p.j(localObject1, "rootView.context");
    if (com.tencent.mm.plugin.hld.f.g.K((Context)localObject1, "kaoemoji", "recent").MGI.isEmpty()) {
      this.DwD.remove(0);
    }
    localObject1 = getContext();
    p.j(localObject1, "context");
    setAdapter((RecyclerView.a)new m((Context)localObject1, this.DwD, (a)this));
    localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject1 = com.tencent.mm.plugin.hld.f.g.aLG("kaoemoji");
    localObject2 = ((List)this.DwD).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!p.h(((k)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(212285);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void a(fmu paramfmu)
  {
    String str = null;
    AppMethodBeat.i(212290);
    Object localObject2 = new StringBuilder("onEmojiClick ");
    if (paramfmu != null) {}
    for (Object localObject1 = paramfmu.MGH;; localObject1 = null)
    {
      Log.d("WxIme.ImeEmojiContentScrollView", (String)localObject1);
      localObject1 = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.hld.a.d)localObject1).eCD();
        if (localObject1 != null)
        {
          localObject2 = ((b)localObject1).eCr();
          if (localObject2 != null)
          {
            localObject1 = str;
            if (paramfmu != null) {
              localObject1 = paramfmu.content;
            }
            ((com.tencent.mm.plugin.hld.a.c)localObject2).b(new com.tencent.mm.plugin.hld.a.g((String)localObject1));
          }
        }
      }
      int i = this.DwD.size();
      localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
      localObject1 = getContext();
      p.j(localObject1, "context");
      if (i < com.tencent.mm.plugin.hld.f.g.be((Context)localObject1, "kaoemoji").size())
      {
        localObject1 = this.DwD;
        str = getContext().getString(a.j.ime_kaoemoji_subtype_recent);
        p.j(str, "context.getString(R.stri…_kaoemoji_subtype_recent)");
        ((ArrayList)localObject1).add(0, new k(str, "recent"));
        localObject1 = getAdapter();
        if (localObject1 != null) {
          ((RecyclerView.a)localObject1).cM(0);
        }
        localObject1 = this.DvX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.keyboard.d)localObject1).aLt("kaoemoji");
        }
      }
      localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
      com.tencent.mm.plugin.hld.f.g.a("kaoemoji", paramfmu);
      paramfmu = com.tencent.mm.plugin.hld.model.k.DDb;
      paramfmu = com.tencent.mm.plugin.hld.f.g.DHh;
      com.tencent.mm.plugin.hld.model.k.n(7, com.tencent.mm.plugin.hld.f.g.aLG("kaoemoji"), 2);
      AppMethodBeat.o(212290);
      return;
    }
  }
  
  public final ArrayList<k> getKaoemojiList()
  {
    return this.DwD;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.d getRecentSelectedListener()
  {
    return this.DvX;
  }
  
  public final void setRecentSelectedListener(com.tencent.mm.plugin.hld.keyboard.d paramd)
  {
    this.DvX = paramd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeKaoEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */