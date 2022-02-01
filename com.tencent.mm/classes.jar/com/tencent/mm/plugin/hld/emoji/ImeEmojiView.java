package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.keyboard.d;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentEmojiType", "", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "emojiContentContainerRv$delegate", "Lkotlin/Lazy;", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper;", "pageSelectedListener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "initView", "", "onEmojiSubTypeClick", "position", "itemView", "Landroid/view/View;", "onReset", "setOnKeyboardActionListener", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setTabSelected", "groupIndex", "Companion", "plugin-hld_release"})
public final class ImeEmojiView
  extends RelativeLayout
  implements b
{
  public static final a Dwz;
  private final d DvX;
  private String Dwu;
  private final f Dwv;
  private final f Dww;
  private final i Dwx;
  private final i.a Dwy;
  
  static
  {
    AppMethodBeat.i(209168);
    Dwz = new a((byte)0);
    AppMethodBeat.o(209168);
  }
  
  public ImeEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(209165);
    this.Dwu = "emoji";
    this.Dwv = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.Dww = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dwx = new i();
    this.Dwy = ((i.a)new d(this));
    this.DvX = ((d)new e(this));
    Log.d("WxIme.ImeEmojiView", "initView");
    ad.kS(getContext()).inflate(a.h.ime_symbol_grid_emoji_item, (ViewGroup)this, true);
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.DvX);
    this.Dwx.Dwl = this.Dwy;
    this.Dwx.a((RecyclerView)getEmojiContentContainerRv());
    AppMethodBeat.o(209165);
  }
  
  private final ImeEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(209152);
    ImeEmojiContentScrollView localImeEmojiContentScrollView = (ImeEmojiContentScrollView)this.Dww.getValue();
    AppMethodBeat.o(209152);
    return localImeEmojiContentScrollView;
  }
  
  private final ImeEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(209151);
    ImeEmojiSubTypeScrollView localImeEmojiSubTypeScrollView = (ImeEmojiSubTypeScrollView)this.Dwv.getValue();
    AppMethodBeat.o(209151);
    return localImeEmojiSubTypeScrollView;
  }
  
  public final void j(int paramInt, View paramView)
  {
    AppMethodBeat.i(209160);
    p.k(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = com.tencent.mm.plugin.hld.f.g.DHh;
    paramView = getRootView();
    p.j(paramView, "rootView");
    paramView = paramView.getContext();
    p.j(paramView, "rootView.context");
    if (com.tencent.mm.plugin.hld.f.g.K(paramView, this.Dwu, "recent").MGI.isEmpty()) {}
    for (int i = paramInt - 1;; i = paramInt)
    {
      paramView = getEmojiContentContainerRv();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      paramView.scrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      paramView = k.DDb;
      paramView = com.tencent.mm.plugin.hld.f.g.DHh;
      k.n(4, com.tencent.mm.plugin.hld.f.g.UH(paramInt), 1);
      AppMethodBeat.o(209160);
      return;
    }
  }
  
  public final void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(209154);
    p.k(paramc, "listener");
    ImeEmojiContentScrollView localImeEmojiContentScrollView = getEmojiContentContainerRv();
    if (localImeEmojiContentScrollView != null)
    {
      localImeEmojiContentScrollView.setOnKeyboardActionListener(paramc);
      AppMethodBeat.o(209154);
      return;
    }
    AppMethodBeat.o(209154);
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(209157);
    Log.i("WxIme.ImeEmojiView", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject1 = getContext();
    p.j(localObject1, "context");
    localObject1 = com.tencent.mm.plugin.hld.f.g.be((Context)localObject1, this.Dwu);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = getEmojiSubTypeContainerRv().getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
        AppMethodBeat.o(209157);
        throw ((Throwable)localObject1);
      }
      localObject1 = (j)localObject1;
      Object localObject2 = getContext();
      p.j(localObject2, "context");
      ((j)localObject1).au((Context)localObject2, paramInt);
      localObject1 = getEmojiSubTypeContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(209157);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImeEmojiContentScrollView>
  {
    b(ImeEmojiView paramImeEmojiView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    c(ImeEmojiView paramImeEmojiView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/emoji/ImeEmojiView$pageSelectedListener$1", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-hld_release"})
  public static final class d
    implements i.a
  {
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(214189);
      if ((paramInt < 0) || (paramInt >= ImeEmojiView.a(this.DwA).getEmojiList().size()))
      {
        AppMethodBeat.o(214189);
        return;
      }
      Object localObject = com.tencent.mm.plugin.hld.f.g.DHh;
      localObject = this.DwA.getRootView();
      p.j(localObject, "rootView");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "rootView.context");
      if (com.tencent.mm.plugin.hld.f.g.K((Context)localObject, ImeEmojiView.b(this.DwA), "recent").MGI.isEmpty()) {}
      for (int i = paramInt + 1;; i = paramInt)
      {
        this.DwA.setTabSelected(i);
        localObject = k.DDb;
        localObject = com.tencent.mm.plugin.hld.f.g.DHh;
        k.n(8, com.tencent.mm.plugin.hld.f.g.UH(paramInt), 1);
        AppMethodBeat.o(214189);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/emoji/ImeEmojiView$recentSelectedListener$1", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-hld_release"})
  public static final class e
    implements d
  {
    public final void aLt(String paramString)
    {
      AppMethodBeat.i(215866);
      p.k(paramString, "typeName");
      paramString = ImeEmojiView.c(this.DwA).getAdapter();
      if (paramString != null)
      {
        paramString.cL(0);
        AppMethodBeat.o(215866);
        return;
      }
      AppMethodBeat.o(215866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiView
 * JD-Core Version:    0.7.0.1
 */