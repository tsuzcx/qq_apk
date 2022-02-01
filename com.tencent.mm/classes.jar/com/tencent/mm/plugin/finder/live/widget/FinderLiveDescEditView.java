package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.d;
import com.tencent.mm.plugin.finder.live.report.q.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelCallback", "Lkotlin/Function0;", "", "doneCallback", "Lkotlin/Function1;", "", "fromScene", "getFromScene", "()I", "setFromScene", "(I)V", "intecerptKeyBoardEvent", "", "getIntecerptKeyBoardEvent", "()Z", "setIntecerptKeyBoardEvent", "(Z)V", "isAssistant", "setAssistant", "editCancel", "editDone", "getDesc", "hide", "hideKeyBoard", "initEdit", "onBackPressed", "show", "defaultText", "editDoneCallback", "editCancelCallback", "showKeyboardDelay", "showKeyBoard", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveDescEditView
  extends LinearLayout
{
  public static final FinderLiveDescEditView.a Eou;
  private boolean DUe;
  private boolean Eov;
  private kotlin.g.a.b<? super String, ah> Eow;
  private kotlin.g.a.a<ah> Eox;
  private int fromScene;
  
  static
  {
    AppMethodBeat.i(361341);
    Eou = new FinderLiveDescEditView.a((byte)0);
    AppMethodBeat.o(361341);
  }
  
  public FinderLiveDescEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(361258);
    LayoutInflater.from(getContext()).inflate(p.f.Cdy, (ViewGroup)this, true);
    setPadding(getPaddingLeft(), aw.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(p.c.Edge_A), getPaddingRight(), getPaddingBottom());
    setBackgroundColor(getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
    eAv();
    AppMethodBeat.o(361258);
  }
  
  public FinderLiveDescEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(361265);
    LayoutInflater.from(getContext()).inflate(p.f.Cdy, (ViewGroup)this, true);
    setPadding(getPaddingLeft(), aw.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(p.c.Edge_A), getPaddingRight(), getPaddingBottom());
    setBackgroundColor(getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
    eAv();
    AppMethodBeat.o(361265);
  }
  
  public FinderLiveDescEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(361268);
    LayoutInflater.from(getContext()).inflate(p.f.Cdy, (ViewGroup)this, true);
    setPadding(getPaddingLeft(), aw.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(p.c.Edge_A), getPaddingRight(), getPaddingBottom());
    setBackgroundColor(getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
    eAv();
    AppMethodBeat.o(361268);
  }
  
  private static final void a(FinderLiveDescEditView paramFinderLiveDescEditView, View paramView)
  {
    AppMethodBeat.i(361312);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveDescEditView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveDescEditView, "this$0");
    paramFinderLiveDescEditView.eAx();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361312);
  }
  
  private static final void b(FinderLiveDescEditView paramFinderLiveDescEditView, View paramView)
  {
    AppMethodBeat.i(361326);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderLiveDescEditView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderLiveDescEditView, "this$0");
    paramView = paramFinderLiveDescEditView.getDesc();
    paramFinderLiveDescEditView.hide();
    localObject1 = paramFinderLiveDescEditView.Eow;
    if (localObject1 != null) {
      ((kotlin.g.a.b)localObject1).invoke(paramView);
    }
    if (paramFinderLiveDescEditView.DUe) {
      k.Doi.bx(2, paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361326);
      return;
      paramView = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramView), "utf-8");
      if (paramFinderLiveDescEditView.fromScene == 1)
      {
        paramFinderLiveDescEditView = new JSONObject();
        paramFinderLiveDescEditView.put("content", paramView);
        paramFinderLiveDescEditView = paramFinderLiveDescEditView.toString();
        s.s(paramFinderLiveDescEditView, "JSONObject().apply {\n   …\n            }.toString()");
        localObject1 = j.Dob;
        j.setDesc(paramFinderLiveDescEditView);
        localObject1 = j.Dob;
        localObject1 = j.Doc.Dqq;
        s.s(paramView, "reportStr");
        s.u(paramView, "<set-?>");
        ((com.tencent.mm.plugin.finder.live.report.r)localObject1).description = paramView;
        j.Dob.C(q.a.DqK.mwI, paramFinderLiveDescEditView);
      }
      else
      {
        paramFinderLiveDescEditView = j.Dob;
        localObject1 = q.c.DrR;
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put(q.d.Dsa.key, q.e.Dsg.Dsd);
        ((JSONObject)localObject2).put(q.d.Dsb.key, paramView);
        paramView = ah.aiuX;
        paramFinderLiveDescEditView.a((q.c)localObject1, ((JSONObject)localObject2).toString());
      }
    }
  }
  
  private static final void bs(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(361336);
    s.u(parama, "$s");
    parama.invoke();
    AppMethodBeat.o(361336);
  }
  
  private final void eAv()
  {
    AppMethodBeat.i(361282);
    final MMEditText localMMEditText = (MMEditText)findViewById(p.e.BWb);
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.setCursorVisible(true);
    localMMEditText.setRawInputType(1);
    aw.a((Paint)localMMEditText.getPaint(), 0.8F);
    localMMEditText.addTextChangedListener((TextWatcher)new b(this, localMMEditText));
    AppMethodBeat.o(361282);
  }
  
  private final void eAw()
  {
    AppMethodBeat.i(361291);
    Object localObject = getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(361291);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(((MMEditText)findViewById(p.e.BWb)).getWindowToken(), 0);
    AppMethodBeat.o(361291);
  }
  
  private final void eAx()
  {
    AppMethodBeat.i(361299);
    hide();
    kotlin.g.a.a locala = this.Eox;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(361299);
  }
  
  private final void hide()
  {
    AppMethodBeat.i(361304);
    eAw();
    setVisibility(8);
    AppMethodBeat.o(361304);
  }
  
  public final void a(String paramString, boolean paramBoolean1, kotlin.g.a.b<? super String, ah> paramb, kotlin.g.a.a<ah> parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(361407);
    this.Eow = paramb;
    this.Eox = parama;
    this.DUe = paramBoolean1;
    ((TextView)findViewById(p.e.BWa)).setOnClickListener(new FinderLiveDescEditView..ExternalSyntheticLambda0(this));
    ((TextView)findViewById(p.e.BWc)).setOnClickListener(new FinderLiveDescEditView..ExternalSyntheticLambda1(this));
    ((MMEditText)findViewById(p.e.BWb)).requestFocus();
    if (!Util.isNullOrNil(paramString))
    {
      ((MMEditText)findViewById(p.e.BWb)).setText((CharSequence)paramString);
      paramb = (MMEditText)findViewById(p.e.BWb);
      s.checkNotNull(paramString);
      paramb.setSelection(paramString.length());
    }
    setVisibility(0);
    paramString = (kotlin.g.a.a)new c(this);
    if (paramBoolean2)
    {
      ((MMEditText)findViewById(p.e.BWb)).postDelayed(new FinderLiveDescEditView..ExternalSyntheticLambda2(paramString), 300L);
      AppMethodBeat.o(361407);
      return;
    }
    paramString.invoke();
    AppMethodBeat.o(361407);
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(361418);
    Object localObject = ((MMEditText)findViewById(p.e.BWb)).getText().toString();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(361418);
      throw ((Throwable)localObject);
    }
    localObject = n.bq((CharSequence)localObject).toString();
    AppMethodBeat.o(361418);
    return localObject;
  }
  
  public final int getFromScene()
  {
    return this.fromScene;
  }
  
  public final boolean getIntecerptKeyBoardEvent()
  {
    return this.Eov;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(361427);
    if (getVisibility() == 0)
    {
      eAx();
      AppMethodBeat.o(361427);
      return true;
    }
    AppMethodBeat.o(361427);
    return false;
  }
  
  public final void setAssistant(boolean paramBoolean)
  {
    this.DUe = paramBoolean;
  }
  
  public final void setFromScene(int paramInt)
  {
    this.fromScene = paramInt;
  }
  
  public final void setIntecerptKeyBoardEvent(boolean paramBoolean)
  {
    this.Eov = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView$initEdit$1$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(FinderLiveDescEditView paramFinderLiveDescEditView, MMEditText paramMMEditText) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(361225);
      String str1 = String.valueOf(paramEditable);
      if (g.a(str1, g.a.afII) > 120)
      {
        String str2 = g.jd(str1, 120);
        if (paramEditable != null) {}
        try
        {
          paramEditable.replace(str2.length(), str1.length(), (CharSequence)"");
          ((TextView)this.Eoy.findViewById(p.e.BWd)).setText((CharSequence)localMMEditText.getContext().getString(p.h.CjM, new Object[] { Integer.valueOf(60) }));
          ((TextView)this.Eoy.findViewById(p.e.BWd)).setVisibility(0);
          AppMethodBeat.o(361225);
          return;
        }
        catch (Exception paramEditable)
        {
          for (;;)
          {
            Log.e("Finder.FinderLiveDescEditView", s.X("etDesc replace: ", paramEditable.getMessage()));
          }
        }
      }
      ((TextView)this.Eoy.findViewById(p.e.BWd)).setVisibility(8);
      AppMethodBeat.o(361225);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderLiveDescEditView paramFinderLiveDescEditView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveDescEditView
 * JD-Core Version:    0.7.0.1
 */