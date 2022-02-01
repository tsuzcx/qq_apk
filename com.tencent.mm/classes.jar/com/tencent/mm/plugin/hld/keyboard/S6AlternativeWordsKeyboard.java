package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.alternative.ImeAlternativePyScrollView;
import com.tencent.mm.plugin.hld.alternative.ImeAlternativeWordGridScrollView;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S6AlternativeWordsKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCreate", "", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "updateCandidateList", "addList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "type", "newList", "hasMoreCandidate", "Companion", "plugin-hld_release"})
public final class S6AlternativeWordsKeyboard
  extends ImeKeyboard
  implements View.OnTouchListener, com.tencent.mm.plugin.hld.candidate.a
{
  public static final a Dzb;
  
  static
  {
    AppMethodBeat.i(217094);
    Dzb = new a((byte)0);
    AppMethodBeat.o(217094);
  }
  
  public S6AlternativeWordsKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S6AlternativeWordsKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S6AlternativeWordsKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217087);
    p.k(paramArrayList, "addList");
    if (paramInt == 1) {
      post((Runnable)b.Dzc);
    }
    AppMethodBeat.o(217087);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(217083);
    super.b(paramc);
    paramc = g.DCm;
    int i;
    if (g.eEg() == c.Dyn.ordinal())
    {
      i = 1;
      if (i == 0) {
        break label187;
      }
      paramc = findViewById(a.f.s6_alternative_pinyin_container);
      p.j(paramc, "findViewById<ImeAlternat…rnative_pinyin_container)");
      ((ImeAlternativePyScrollView)paramc).setVisibility(8);
      paramc = findViewById(a.f.vertical_line_iv);
      p.j(paramc, "findViewById<ImageView>(R.id.vertical_line_iv)");
      ((ImageView)paramc).setVisibility(8);
    }
    for (;;)
    {
      paramc = n.DEn;
      n.a((com.tencent.mm.plugin.hld.candidate.a)this);
      paramc = n.DEn;
      paramc = findViewById(a.f.s6_alternative_word_container);
      p.j(paramc, "findViewById<ImeAlternat…ternative_word_container)");
      n.a((com.tencent.mm.plugin.hld.candidate.a)paramc);
      paramc = n.DEn;
      paramc = findViewById(a.f.s6_alternative_pinyin_container);
      p.j(paramc, "findViewById<ImeAlternat…rnative_pinyin_container)");
      n.a((com.tencent.mm.plugin.hld.alternative.a)paramc);
      paramc = getMKeyboardActionListener();
      if (paramc == null) {
        break label234;
      }
      ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).setOnKeyboardActionListener(paramc);
      ((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).setOnKeyboardActionListener(paramc);
      AppMethodBeat.o(217083);
      return;
      i = 0;
      break;
      label187:
      paramc = findViewById(a.f.s6_alternative_pinyin_container);
      p.j(paramc, "findViewById<ImeAlternat…rnative_pinyin_container)");
      ((ImeAlternativePyScrollView)paramc).setVisibility(0);
      paramc = findViewById(a.f.vertical_line_iv);
      p.j(paramc, "findViewById<ImageView>(R.id.vertical_line_iv)");
      ((ImageView)paramc).setVisibility(0);
    }
    label234:
    AppMethodBeat.o(217083);
  }
  
  public final c getKeyboardType()
  {
    return c.Dyq;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(217081);
    super.onCreate();
    ((ImeKeyRelativeLayout)((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(217081);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(217084);
    super.onReset();
    Object localObject = n.DEn;
    n.b((com.tencent.mm.plugin.hld.candidate.a)this);
    localObject = n.DEn;
    localObject = findViewById(a.f.s6_alternative_word_container);
    p.j(localObject, "findViewById<ImeAlternat…ternative_word_container)");
    n.b((com.tencent.mm.plugin.hld.candidate.a)localObject);
    localObject = n.DEn;
    localObject = findViewById(a.f.s6_alternative_pinyin_container);
    p.j(localObject, "findViewById<ImeAlternat…rnative_pinyin_container)");
    n.b((com.tencent.mm.plugin.hld.alternative.a)localObject);
    ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).reset();
    ((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).reset();
    AppMethodBeat.o(217084);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217091);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView)) {
        a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(703));
      }
    }
    AppMethodBeat.o(217091);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S6AlternativeWordsKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b Dzc;
    
    static
    {
      AppMethodBeat.i(213366);
      Dzc = new b();
      AppMethodBeat.o(213366);
    }
    
    public final void run()
    {
      AppMethodBeat.i(213362);
      g.DCm.Ux(g.eEo());
      AppMethodBeat.o(213362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S6AlternativeWordsKeyboard
 * JD-Core Version:    0.7.0.1
 */