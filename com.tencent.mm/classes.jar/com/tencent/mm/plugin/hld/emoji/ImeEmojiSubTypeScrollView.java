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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIEmojiSubTypeSelectListener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "typeName", "", "initView", "", "onSubTypeClick", "position", "itemView", "Landroid/view/View;", "setIEmojiSubTypeSelectListener", "listener", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEmojiSubTypeScrollView
  extends RecyclerView
  implements l.a
{
  public static final ImeEmojiSubTypeScrollView.a Jpx;
  private b Jpy;
  private String typeName;
  
  static
  {
    AppMethodBeat.i(312739);
    Jpx = new ImeEmojiSubTypeScrollView.a((byte)0);
    AppMethodBeat.o(312739);
  }
  
  public ImeEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(312717);
    AppMethodBeat.o(312717);
  }
  
  public ImeEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312730);
    this.typeName = "emoji";
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeEmojiSubTypeScrollView, paramInt, 0);
    s.s(paramContext, "context!!.obtainStyledAt…eScrollView, defStyle, 0)");
    switch (paramContext.getInt(a.l.ImeEmojiSubTypeScrollView_emoji_type, 1))
    {
    default: 
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "initView");
      paramContext = new WxLinearLayoutManager(getContext());
      paramContext.setOrientation(0);
      paramAttributeSet = g.Jyo;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      paramContext.bXK = g.bg(paramAttributeSet, this.typeName).size();
      paramContext.setItemPrefetchEnabled(true);
      setLayoutManager((RecyclerView.LayoutManager)paramContext);
      paramContext = g.Jyo;
      paramContext = g.aIz(this.typeName);
      paramAttributeSet = g.Jyo;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      paramAttributeSet = ((List)g.bg(paramAttributeSet, this.typeName)).iterator();
      paramInt = i;
      label190:
      if (paramAttributeSet.hasNext()) {
        if (!s.p(((k)paramAttributeSet.next()).typeName, paramContext)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramAttributeSet = this.typeName;
      Object localObject = g.Jyo;
      localObject = getContext();
      s.s(localObject, "context");
      setAdapter((RecyclerView.a)new j(paramAttributeSet, g.bg((Context)localObject, this.typeName), paramInt, (l.a)this));
      paramAttributeSet = g.Jyo;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      setItemViewCacheSize(g.bg(paramAttributeSet, this.typeName).size());
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "init " + this.typeName + ' ' + paramContext + ' ' + paramInt);
      AppMethodBeat.o(312730);
      return;
      this.typeName = "emoji";
      break;
      this.typeName = "kaoemoji";
      break;
      paramInt += 1;
      break label190;
      paramInt = -1;
    }
  }
  
  public final void r(int paramInt, View paramView)
  {
    AppMethodBeat.i(312748);
    s.u(paramView, "itemView");
    Log.d("WxIme.ImeEmojiSubTypeScrollView", s.X("onSubTypeClick ", Integer.valueOf(paramInt)));
    b localb = this.Jpy;
    if (localb != null) {
      localb.q(paramInt, paramView);
    }
    AppMethodBeat.o(312748);
  }
  
  public final void setIEmojiSubTypeSelectListener(b paramb)
  {
    AppMethodBeat.i(312745);
    s.u(paramb, "listener");
    this.Jpy = paramb;
    AppMethodBeat.o(312745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeScrollView
 * JD-Core Version:    0.7.0.1
 */