package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.emoji.ImeEmojiView;
import com.tencent.mm.plugin.hld.f.b;
import com.tencent.mm.plugin.hld.f.g;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.symbol.ImeSymbolGridScrollView;
import com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesScrollView;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S5SymbolKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/symbol/ISymbolTypeSelectListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "emojiContainerRv", "Landroid/widget/RelativeLayout;", "getEmojiContainerRv", "()Landroid/widget/RelativeLayout;", "emojiContainerRv$delegate", "Lkotlin/Lazy;", "symbolsContainerRv", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "getSymbolsContainerRv", "()Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "symbolsContainerRv$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCreate", "", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSymbolTypeClick", "typeName", "", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "transparentBg", "transparent", "updateView", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S5SymbolKeyboard
  extends ImeKeyboard
  implements View.OnTouchListener, com.tencent.mm.plugin.hld.symbol.a
{
  public static final S5SymbolKeyboard.a Jsa;
  private final j Jsb;
  private final j Jsc;
  
  static
  {
    AppMethodBeat.i(313045);
    Jsa = new S5SymbolKeyboard.a((byte)0);
    AppMethodBeat.o(313045);
  }
  
  public S5SymbolKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S5SymbolKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S5SymbolKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(313023);
    this.Jsb = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jsc = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(313023);
  }
  
  private final void aIn(String paramString)
  {
    AppMethodBeat.i(313031);
    if (Util.isEqual("emoji", paramString))
    {
      getEmojiContainerRv().setVisibility(0);
      getSymbolsContainerRv().setVisibility(8);
      AppMethodBeat.o(313031);
      return;
    }
    getEmojiContainerRv().setVisibility(8);
    getSymbolsContainerRv().setVisibility(0);
    ((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).aIt(paramString);
    AppMethodBeat.o(313031);
  }
  
  private static final void dEB()
  {
    AppMethodBeat.i(313040);
    Object localObject = com.tencent.mm.kernel.h.baA().Fx("com.tencent.mm.plugin.emoji.PluginEmoji");
    s.s(localObject, "plugins().install(\"com.t…lugin.emoji.PluginEmoji\")");
    ((f)localObject).execute(com.tencent.mm.kernel.h.baB().bad());
    localObject = g.Jyo;
    g.fOm();
    AppMethodBeat.o(313040);
  }
  
  private final RelativeLayout getEmojiContainerRv()
  {
    AppMethodBeat.i(312996);
    Object localObject = this.Jsb.getValue();
    s.s(localObject, "<get-emojiContainerRv>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312996);
    return localObject;
  }
  
  private final ImeSymbolGridScrollView getSymbolsContainerRv()
  {
    AppMethodBeat.i(313003);
    Object localObject = this.Jsc.getValue();
    s.s(localObject, "<get-symbolsContainerRv>(...)");
    localObject = (ImeSymbolGridScrollView)localObject;
    AppMethodBeat.o(313003);
    return localObject;
  }
  
  public final void aIm(String paramString)
  {
    AppMethodBeat.i(313088);
    s.u(paramString, "typeName");
    aIn(paramString);
    paramString = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.YA(501);
    AppMethodBeat.o(313088);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313074);
    super.b(paramc);
    ((ImeSymbolTypesScrollView)findViewById(a.f.s5_symbol_type_container)).reset();
    ((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).reset();
    paramc = getMKeyboardActionListener();
    if (paramc != null)
    {
      ((ImeSymbolTypesScrollView)findViewById(a.f.s5_symbol_type_container)).setOnKeyboardActionListener(paramc);
      ((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).setOnKeyboardActionListener(paramc);
      ((ImeEmojiView)findViewById(a.f.s5_emoji_container)).setOnKeyboardActionListener(paramc);
    }
    paramc = b.Jyf;
    aIn(b.fNN());
    paramc = g.Jyo;
    g.fOm();
    AppMethodBeat.o(313074);
  }
  
  public final c getKeyboardType()
  {
    return c.Jrt;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(313063);
    super.onCreate();
    ((ImeSymbolTypesScrollView)findViewById(a.f.s5_symbol_type_container)).setISymbolTypeSelectListener((com.tencent.mm.plugin.hld.symbol.a)this);
    ((ImeKeyRelativeLayout)((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    ((ImeKeyRelativeLayout)((ImeEmojiView)findViewById(a.f.s5_emoji_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    com.tencent.threadpool.h.ahAA.bm(S5SymbolKeyboard..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(313063);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313102);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      l locall = l.JyV;
      if (l.e((ImeKeyRelativeLayout)paramView)) {
        a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(503));
      }
    }
    AppMethodBeat.o(313102);
    return false;
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313098);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313098);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.ime_keyboard_end_color));
    AppMethodBeat.o(313098);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S5SymbolKeyboard paramS5SymbolKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeSymbolGridScrollView>
  {
    c(S5SymbolKeyboard paramS5SymbolKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S5SymbolKeyboard
 * JD-Core Version:    0.7.0.1
 */