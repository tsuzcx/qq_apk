package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIEmojiSubTypeSelectListener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "typeName", "", "initView", "", "onSubTypeClick", "position", "itemView", "Landroid/view/View;", "setIEmojiSubTypeSelectListener", "listener", "Companion", "plugin-hld_release"})
public final class ImeEmojiSubTypeScrollView
  extends RecyclerView
  implements l.a
{
  public static final a Dws;
  private b Dwr;
  private String typeName;
  
  static
  {
    AppMethodBeat.i(216571);
    Dws = new a((byte)0);
    AppMethodBeat.o(216571);
  }
  
  public ImeEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216569);
    AppMethodBeat.o(216569);
  }
  
  public ImeEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216570);
    this.typeName = "emoji";
    switch (paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeEmojiSubTypeScrollView, paramInt, 0).getInt(a.l.ImeEmojiSubTypeScrollView_emoji_type, 1))
    {
    default: 
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "initView");
      paramContext = new WxLinearLayoutManager(getContext());
      paramContext.setOrientation(0);
      paramAttributeSet = g.DHh;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramContext.cC(g.be(paramAttributeSet, this.typeName).size());
      paramContext.setItemPrefetchEnabled(true);
      setLayoutManager((RecyclerView.LayoutManager)paramContext);
      paramContext = g.DHh;
      paramContext = g.aLG(this.typeName);
      paramAttributeSet = g.DHh;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramAttributeSet = ((List)g.be(paramAttributeSet, this.typeName)).iterator();
      paramInt = i;
      label182:
      if (paramAttributeSet.hasNext()) {
        if (!p.h(((k)paramAttributeSet.next()).typeName, paramContext)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramAttributeSet = this.typeName;
      Object localObject = g.DHh;
      localObject = getContext();
      p.j(localObject, "context");
      setAdapter((RecyclerView.a)new j(paramAttributeSet, g.be((Context)localObject, this.typeName), paramInt, (l.a)this));
      paramAttributeSet = g.DHh;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      setItemViewCacheSize(g.be(paramAttributeSet, this.typeName).size());
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "init " + this.typeName + ' ' + paramContext + ' ' + paramInt);
      AppMethodBeat.o(216570);
      return;
      this.typeName = "emoji";
      break;
      this.typeName = "kaoemoji";
      break;
      paramInt += 1;
      break label182;
      paramInt = -1;
    }
  }
  
  public final void k(int paramInt, View paramView)
  {
    AppMethodBeat.i(216568);
    p.k(paramView, "itemView");
    Log.d("WxIme.ImeEmojiSubTypeScrollView", "onSubTypeClick ".concat(String.valueOf(paramInt)));
    b localb = this.Dwr;
    if (localb != null)
    {
      localb.j(paramInt, paramView);
      AppMethodBeat.o(216568);
      return;
    }
    AppMethodBeat.o(216568);
  }
  
  public final void setIEmojiSubTypeSelectListener(b paramb)
  {
    AppMethodBeat.i(216567);
    p.k(paramb, "listener");
    this.Dwr = paramb;
    AppMethodBeat.o(216567);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeScrollView
 * JD-Core Version:    0.7.0.1
 */