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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "kaoemojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getKaoemojiList", "()Ljava/util/ArrayList;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiData", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "reset", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeKaoEmojiContentScrollView
  extends RecyclerView
  implements a
{
  public static final ImeKaoEmojiContentScrollView.a JpJ;
  private final ArrayList<k> JpK;
  private com.tencent.mm.plugin.hld.keyboard.d Jpe;
  
  static
  {
    AppMethodBeat.i(312755);
    JpJ = new ImeKaoEmojiContentScrollView.a((byte)0);
    AppMethodBeat.o(312755);
  }
  
  public ImeKaoEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(312734);
    AppMethodBeat.o(312734);
  }
  
  public ImeKaoEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312743);
    this.JpK = new ArrayList();
    initView();
    AppMethodBeat.o(312743);
  }
  
  private void initView()
  {
    AppMethodBeat.i(312750);
    Object localObject1 = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.JpK;
    Object localObject2 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject2 = getContext();
    s.s(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)com.tencent.mm.plugin.hld.f.g.bg((Context)localObject2, "kaoemoji"));
    localObject1 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject1 = getRootView().getContext();
    s.s(localObject1, "rootView.context");
    if (com.tencent.mm.plugin.hld.f.g.K((Context)localObject1, "kaoemoji", "recent").Trs.isEmpty()) {
      this.JpK.remove(0);
    }
    localObject1 = getContext();
    s.s(localObject1, "context");
    setAdapter((RecyclerView.a)new m((Context)localObject1, this.JpK, (a)this));
    localObject1 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject1 = com.tencent.mm.plugin.hld.f.g.aIz("kaoemoji");
    localObject2 = ((List)this.JpK).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!s.p(((k)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(312750);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void a(gjm paramgjm)
  {
    String str = null;
    AppMethodBeat.i(312775);
    com.tencent.mm.plugin.hld.a.c localc;
    if (paramgjm == null)
    {
      localObject = null;
      Log.d("WxIme.ImeEmojiContentScrollView", s.X("onEmojiClick ", localObject));
      localObject = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
        if (localObject != null)
        {
          localc = ((b)localObject).fKC();
          if (localc != null) {
            if (paramgjm != null) {
              break label236;
            }
          }
        }
      }
    }
    label236:
    for (Object localObject = str;; localObject = paramgjm.content)
    {
      localc.b(new com.tencent.mm.plugin.hld.a.g((String)localObject));
      int i = this.JpK.size();
      localObject = com.tencent.mm.plugin.hld.f.g.Jyo;
      localObject = getContext();
      s.s(localObject, "context");
      if (i < com.tencent.mm.plugin.hld.f.g.bg((Context)localObject, "kaoemoji").size())
      {
        localObject = this.JpK;
        str = getContext().getString(a.j.ime_kaoemoji_subtype_recent);
        s.s(str, "context.getString(R.stri…_kaoemoji_subtype_recent)");
        ((ArrayList)localObject).add(0, new k(str, "recent"));
        localObject = getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).fW(0);
        }
        localObject = this.Jpe;
        if (localObject != null) {
          ((com.tencent.mm.plugin.hld.keyboard.d)localObject).aIk("kaoemoji");
        }
      }
      localObject = com.tencent.mm.plugin.hld.f.g.Jyo;
      com.tencent.mm.plugin.hld.f.g.a("kaoemoji", paramgjm);
      paramgjm = com.tencent.mm.plugin.hld.model.k.JvH;
      paramgjm = com.tencent.mm.plugin.hld.f.g.Jyo;
      com.tencent.mm.plugin.hld.model.k.r(7, com.tencent.mm.plugin.hld.f.g.aIz("kaoemoji"), 2);
      AppMethodBeat.o(312775);
      return;
      localObject = paramgjm.Trr;
      break;
    }
  }
  
  public final ArrayList<k> getKaoemojiList()
  {
    return this.JpK;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.d getRecentSelectedListener()
  {
    return this.Jpe;
  }
  
  public final void setRecentSelectedListener(com.tencent.mm.plugin.hld.keyboard.d paramd)
  {
    this.Jpe = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeKaoEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */