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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S6AlternativeWordsKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCreate", "", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "updateCandidateList", "addList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "type", "newList", "hasMoreCandidate", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S6AlternativeWordsKeyboard
  extends ImeKeyboard
  implements View.OnTouchListener, com.tencent.mm.plugin.hld.candidate.a
{
  public static final S6AlternativeWordsKeyboard.a Jse;
  
  static
  {
    AppMethodBeat.i(312977);
    Jse = new S6AlternativeWordsKeyboard.a((byte)0);
    AppMethodBeat.o(312977);
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
  
  private static final void fLO()
  {
    AppMethodBeat.i(312965);
    g.JuL.Yu(g.fMq());
    AppMethodBeat.o(312965);
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(313053);
    s.u(paramArrayList, "addList");
    if (paramInt == 1) {
      post(S6AlternativeWordsKeyboard..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(313053);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313010);
    super.b(paramc);
    paramc = g.JuL;
    int i;
    if (g.fMi() == c.Jrr.ordinal())
    {
      i = 1;
      if (i == 0) {
        break label171;
      }
      ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).setVisibility(8);
      ((ImageView)findViewById(a.f.vertical_line_iv)).setVisibility(8);
    }
    for (;;)
    {
      paramc = n.JvW;
      n.a((com.tencent.mm.plugin.hld.candidate.a)this);
      paramc = n.JvW;
      paramc = findViewById(a.f.s6_alternative_word_container);
      s.s(paramc, "findViewById<ImeAlternat…ternative_word_container)");
      n.a((com.tencent.mm.plugin.hld.candidate.a)paramc);
      paramc = n.JvW;
      paramc = findViewById(a.f.s6_alternative_pinyin_container);
      s.s(paramc, "findViewById<ImeAlternat…rnative_pinyin_container)");
      n.a((com.tencent.mm.plugin.hld.alternative.a)paramc);
      paramc = getMKeyboardActionListener();
      if (paramc != null)
      {
        ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).setOnKeyboardActionListener(paramc);
        ((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).setOnKeyboardActionListener(paramc);
      }
      AppMethodBeat.o(313010);
      return;
      i = 0;
      break;
      label171:
      ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).setVisibility(0);
      ((ImageView)findViewById(a.f.vertical_line_iv)).setVisibility(0);
    }
  }
  
  public final c getKeyboardType()
  {
    return c.Jru;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312994);
    super.onCreate();
    ((ImeKeyRelativeLayout)((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).findViewById(a.f.button_ikb)).setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(312994);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(313024);
    super.onReset();
    Object localObject = n.JvW;
    n.b((com.tencent.mm.plugin.hld.candidate.a)this);
    localObject = n.JvW;
    localObject = findViewById(a.f.s6_alternative_word_container);
    s.s(localObject, "findViewById<ImeAlternat…ternative_word_container)");
    n.b((com.tencent.mm.plugin.hld.candidate.a)localObject);
    localObject = n.JvW;
    localObject = findViewById(a.f.s6_alternative_pinyin_container);
    s.s(localObject, "findViewById<ImeAlternat…rnative_pinyin_container)");
    n.b((com.tencent.mm.plugin.hld.alternative.a)localObject);
    ((ImeAlternativePyScrollView)findViewById(a.f.s6_alternative_pinyin_container)).reset();
    ((ImeAlternativeWordGridScrollView)findViewById(a.f.s6_alternative_word_container)).reset();
    AppMethodBeat.o(313024);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313070);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      l locall = l.JyV;
      if (l.e((ImeKeyRelativeLayout)paramView)) {
        a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(703));
      }
    }
    AppMethodBeat.o(313070);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S6AlternativeWordsKeyboard
 * JD-Core Version:    0.7.0.1
 */