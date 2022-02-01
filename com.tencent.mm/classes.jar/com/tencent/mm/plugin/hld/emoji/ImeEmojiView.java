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
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.plugin.hld.keyboard.d;
import com.tencent.mm.protocal.protobuf.gjn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiSubTypeSelectListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentEmojiType", "", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "emojiContentContainerRv$delegate", "Lkotlin/Lazy;", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper;", "pageSelectedListener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "initView", "", "onEmojiSubTypeClick", "position", "itemView", "Landroid/view/View;", "onReset", "setOnKeyboardActionListener", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setTabSelected", "groupIndex", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEmojiView
  extends RelativeLayout
  implements b
{
  public static final ImeEmojiView.a JpA;
  private String JpB;
  private final kotlin.j JpC;
  private final kotlin.j JpD;
  private final i JpE;
  private final i.a JpF;
  private final d Jpe;
  
  static
  {
    AppMethodBeat.i(312784);
    JpA = new ImeEmojiView.a((byte)0);
    AppMethodBeat.o(312784);
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
    AppMethodBeat.i(312759);
    this.JpB = "emoji";
    this.JpC = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.JpD = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.JpE = new i();
    this.JpF = ((i.a)new d(this));
    this.Jpe = ((d)new e(this));
    Log.d("WxIme.ImeEmojiView", "initView");
    af.mU(getContext()).inflate(a.h.ime_symbol_grid_emoji_item, (ViewGroup)this, true);
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.Jpe);
    this.JpE.Jpr = this.JpF;
    this.JpE.a((RecyclerView)getEmojiContentContainerRv());
    AppMethodBeat.o(312759);
  }
  
  private final ImeEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(312769);
    Object localObject = this.JpD.getValue();
    s.s(localObject, "<get-emojiContentContainerRv>(...)");
    localObject = (ImeEmojiContentScrollView)localObject;
    AppMethodBeat.o(312769);
    return localObject;
  }
  
  private final ImeEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(312763);
    Object localObject = this.JpC.getValue();
    s.s(localObject, "<get-emojiSubTypeContainerRv>(...)");
    localObject = (ImeEmojiSubTypeScrollView)localObject;
    AppMethodBeat.o(312763);
    return localObject;
  }
  
  public final void q(int paramInt, View paramView)
  {
    AppMethodBeat.i(312810);
    s.u(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = g.Jyo;
    paramView = getRootView().getContext();
    s.s(paramView, "rootView.context");
    if (g.K(paramView, this.JpB, "recent").Trs.isEmpty()) {}
    for (int i = paramInt - 1;; i = paramInt)
    {
      paramView = getEmojiContentContainerRv();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      paramView.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      paramView = g.Jyo;
      com.tencent.mm.plugin.hld.model.k.r(4, g.YF(paramInt), 1);
      AppMethodBeat.o(312810);
      return;
    }
  }
  
  public final void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(312792);
    s.u(paramc, "listener");
    ImeEmojiContentScrollView localImeEmojiContentScrollView = getEmojiContentContainerRv();
    if (localImeEmojiContentScrollView != null) {
      localImeEmojiContentScrollView.setOnKeyboardActionListener(paramc);
    }
    AppMethodBeat.o(312792);
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(312800);
    Log.i("WxIme.ImeEmojiView", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = g.Jyo;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = g.bg((Context)localObject1, this.JpB);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = getEmojiSubTypeContainerRv().getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.emoji.ImeEmojiSubTypeAdapter");
        AppMethodBeat.o(312800);
        throw ((Throwable)localObject1);
      }
      localObject1 = (j)localObject1;
      Object localObject2 = getContext();
      s.s(localObject2, "context");
      ((j)localObject1).aH((Context)localObject2, paramInt);
      localObject1 = getEmojiSubTypeContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((ImeEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(312800);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImeEmojiContentScrollView>
  {
    b(ImeEmojiView paramImeEmojiView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeEmojiSubTypeScrollView>
  {
    c(ImeEmojiView paramImeEmojiView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/emoji/ImeEmojiView$pageSelectedListener$1", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements i.a
  {
    d(ImeEmojiView paramImeEmojiView) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(312694);
      if ((paramInt < 0) || (paramInt >= ImeEmojiView.a(this.JpG).getEmojiList().size()))
      {
        AppMethodBeat.o(312694);
        return;
      }
      Object localObject = g.Jyo;
      localObject = this.JpG.getRootView().getContext();
      s.s(localObject, "rootView.context");
      if (g.K((Context)localObject, ImeEmojiView.b(this.JpG), "recent").Trs.isEmpty()) {}
      for (int i = paramInt + 1;; i = paramInt)
      {
        this.JpG.setTabSelected(i);
        localObject = com.tencent.mm.plugin.hld.model.k.JvH;
        localObject = g.Jyo;
        com.tencent.mm.plugin.hld.model.k.r(8, g.YF(paramInt), 1);
        AppMethodBeat.o(312694);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/emoji/ImeEmojiView$recentSelectedListener$1", "Lcom/tencent/mm/plugin/hld/keyboard/OnEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements d
  {
    e(ImeEmojiView paramImeEmojiView) {}
    
    public final void aIk(String paramString)
    {
      AppMethodBeat.i(312674);
      s.u(paramString, "typeName");
      paramString = ImeEmojiView.c(this.JpG).getAdapter();
      if (paramString != null) {
        paramString.fV(0);
      }
      AppMethodBeat.o(312674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiView
 * JD-Core Version:    0.7.0.1
 */