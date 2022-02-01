package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.emoji.ImeEmojiView;
import com.tencent.mm.plugin.hld.f.b;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.symbol.ImeSymbolGridScrollView;
import com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesScrollView;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S5SymbolKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/symbol/ISymbolTypeSelectListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "emojiContainerRv", "Landroid/widget/RelativeLayout;", "getEmojiContainerRv", "()Landroid/widget/RelativeLayout;", "emojiContainerRv$delegate", "Lkotlin/Lazy;", "symbolsContainerRv", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "getSymbolsContainerRv", "()Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "symbolsContainerRv$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCreate", "", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSymbolTypeClick", "typeName", "", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "transparentBg", "transparent", "updateView", "Companion", "plugin-hld_release"})
public final class S5SymbolKeyboard
  extends ImeKeyboard
  implements View.OnTouchListener, com.tencent.mm.plugin.hld.symbol.a
{
  public static final a DyY;
  private final kotlin.f DyW;
  private final kotlin.f DyX;
  
  static
  {
    AppMethodBeat.i(210609);
    DyY = new a((byte)0);
    AppMethodBeat.o(210609);
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
    AppMethodBeat.i(210608);
    this.DyW = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.DyX = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(210608);
  }
  
  private final void aLw(String paramString)
  {
    AppMethodBeat.i(210604);
    if (Util.isEqual("emoji", paramString))
    {
      getEmojiContainerRv().setVisibility(0);
      getSymbolsContainerRv().setVisibility(8);
      AppMethodBeat.o(210604);
      return;
    }
    getEmojiContainerRv().setVisibility(8);
    getSymbolsContainerRv().setVisibility(0);
    ((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).aLB(paramString);
    AppMethodBeat.o(210604);
  }
  
  private final RelativeLayout getEmojiContainerRv()
  {
    AppMethodBeat.i(210589);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DyW.getValue();
    AppMethodBeat.o(210589);
    return localRelativeLayout;
  }
  
  private final ImeSymbolGridScrollView getSymbolsContainerRv()
  {
    AppMethodBeat.i(210590);
    ImeSymbolGridScrollView localImeSymbolGridScrollView = (ImeSymbolGridScrollView)this.DyX.getValue();
    AppMethodBeat.o(210590);
    return localImeSymbolGridScrollView;
  }
  
  public final void aLv(String paramString)
  {
    AppMethodBeat.i(210598);
    p.k(paramString, "typeName");
    aLw(paramString);
    paramString = k.DDb;
    k.hO(501, 1);
    AppMethodBeat.o(210598);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(210595);
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
    paramc = b.DGL;
    aLw(b.eFU());
    paramc = com.tencent.mm.plugin.hld.f.g.DHh;
    com.tencent.mm.plugin.hld.f.g.eGy();
    AppMethodBeat.o(210595);
  }
  
  public final c getKeyboardType()
  {
    return c.Dyp;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(210593);
    super.onCreate();
    ((ImeSymbolTypesScrollView)findViewById(a.f.s5_symbol_type_container)).setISymbolTypeSelectListener((com.tencent.mm.plugin.hld.symbol.a)this);
    ((ImeKeyRelativeLayout)((ImeSymbolGridScrollView)findViewById(a.f.s5_symbols_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    ((ImeKeyRelativeLayout)((ImeEmojiView)findViewById(a.f.s5_emoji_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    com.tencent.e.h.ZvG.be((Runnable)c.Dza);
    AppMethodBeat.o(210593);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(210602);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView)) {
        a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(503));
      }
    }
    AppMethodBeat.o(210602);
    return false;
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(210600);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(210600);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.ime_keyboard_end_color));
    AppMethodBeat.o(210600);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S5SymbolKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S5SymbolKeyboard paramS5SymbolKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c Dza;
    
    static
    {
      AppMethodBeat.i(209653);
      Dza = new c();
      AppMethodBeat.o(209653);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209652);
      Object localObject = com.tencent.mm.kernel.h.aHC().MO("com.tencent.mm.plugin.emoji.PluginEmoji");
      p.j(localObject, "MMKernel.plugins().insta…lugin.emoji.PluginEmoji\")");
      ((com.tencent.mm.kernel.b.f)localObject).execute(com.tencent.mm.kernel.h.aHD().aHf());
      localObject = com.tencent.mm.plugin.hld.f.g.DHh;
      com.tencent.mm.plugin.hld.f.g.eGy();
      AppMethodBeat.o(209652);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImeSymbolGridScrollView>
  {
    d(S5SymbolKeyboard paramS5SymbolKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S5SymbolKeyboard
 * JD-Core Version:    0.7.0.1
 */