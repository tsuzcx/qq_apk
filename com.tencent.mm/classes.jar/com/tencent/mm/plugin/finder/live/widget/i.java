package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "descContainer", "getDescContainer", "()Landroid/view/View;", "setDescContainer", "(Landroid/view/View;)V", "descTv", "Lcom/tencent/mm/ui/widget/MMEditText;", "getDescTv", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setDescTv", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "emptyArea", "getEmptyArea", "setEmptyArea", "footerContainer", "getFooterContainer", "setFooterContainer", "hintContainer", "Landroid/widget/FrameLayout;", "getHintContainer", "()Landroid/widget/FrameLayout;", "setHintContainer", "(Landroid/widget/FrameLayout;)V", "inputContainer", "getInputContainer", "setInputContainer", "getRoot", "textCountTv", "Landroid/widget/TextView;", "getTextCountTv", "()Landroid/widget/TextView;", "setTextCountTv", "(Landroid/widget/TextView;)V", "textLeft", "getTextLeft", "setTextLeft", "(I)V", "getDesc", "", "hideInput", "", "hideInputAction", "onKeyboardHeightChanged", "height", "show", "", "setInputConfig", "showInput", "showInputAction", "plugin-finder_release"})
public final class i
{
  public final int MAX_INPUT_SIZE;
  public final MMActivity activity;
  final View gvQ;
  public FrameLayout uGO;
  public MMEditText uGP;
  public View uGQ;
  public FrameLayout uGR;
  public TextView uGS;
  private View uGT;
  final int uGU;
  public int uGV;
  public View uhh;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(248114);
    this.activity = paramMMActivity;
    this.gvQ = paramView;
    this.MAX_INPUT_SIZE = 60;
    this.uGU = (this.MAX_INPUT_SIZE * 2);
    this.uGV = this.MAX_INPUT_SIZE;
    paramMMActivity = this.gvQ.findViewById(2131301220);
    p.g(paramMMActivity, "root.findViewById(R.id.finder_live_post_container)");
    this.uhh = paramMMActivity;
    paramMMActivity = this.gvQ.findViewById(2131301228);
    p.g(paramMMActivity, "root.findViewById(R.id.f…ost_input_hint_container)");
    this.uGO = ((FrameLayout)paramMMActivity);
    paramMMActivity = this.gvQ.findViewById(2131303503);
    p.g(paramMMActivity, "root.findViewById(R.id.live_post_desc_et)");
    this.uGP = ((MMEditText)paramMMActivity);
    this.uGP.setInputType(131072);
    this.uGP.setSingleLine(false);
    paramMMActivity = this.gvQ.findViewById(2131302671);
    p.g(paramMMActivity, "root.findViewById(R.id.input_container)");
    this.uGQ = paramMMActivity;
    paramMMActivity = this.gvQ.findViewById(2131301227);
    p.g(paramMMActivity, "root.findViewById(R.id.f…ive_post_input_container)");
    this.uGR = ((FrameLayout)paramMMActivity);
    paramMMActivity = this.gvQ.findViewById(2131309020);
    p.g(paramMMActivity, "root.findViewById(R.id.textcount_hint)");
    this.uGS = ((TextView)paramMMActivity);
    paramMMActivity = this.gvQ.findViewById(2131302672);
    p.g(paramMMActivity, "root.findViewById(R.id.input_empty_area)");
    this.uGT = paramMMActivity;
    this.uGT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248109);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = this.uGW;
        localObject = paramAnonymousView.gvQ.getContext().getSystemService("input_method");
        if (localObject == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(248109);
          throw paramAnonymousView;
        }
        ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAnonymousView.uGP.getWindowToken(), 0);
        a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248109);
      }
    });
    paramMMActivity = (InputFilter)new a(this);
    paramView = (InputFilter)new b(this, this.uGU, f.a.Qui);
    this.uGP.setFilters(new InputFilter[] { paramMMActivity, paramView });
    paramMMActivity = (TextWatcher)new c(this);
    this.uGP.addTextChangedListener(paramMMActivity);
    getDesc();
    AppMethodBeat.o(248114);
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(248113);
    Object localObject1 = this.uGP.getText();
    if (localObject1 != null)
    {
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = q.encode((String)localObject1, "UTF-8");
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("content", localObject1);
    localObject2 = ((JSONObject)localObject2).toString();
    p.g(localObject2, "jsobject.toString()");
    Object localObject3 = k.vkd;
    k.setDesc((String)localObject2);
    localObject3 = k.vkd;
    localObject3 = k.dpl().vmj;
    p.g(localObject1, "text");
    ((u)localObject3).setDescription((String)localObject1);
    AppMethodBeat.o(248113);
    return localObject2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class a
    implements InputFilter
  {
    a(i parami) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248110);
      this.uGW.uGP.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(248110);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(248110);
        return paramCharSequence;
      }
      AppMethodBeat.o(248110);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class b
    extends f
  {
    b(int paramInt, f.a parama)
    {
      super(locala);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248111);
      CharSequence localCharSequence;
      if (paramSpanned != null)
      {
        paramInt2 = paramSpanned.length();
        if (paramInt2 <= paramInt3) {
          break label203;
        }
        if (paramSpanned == null) {
          break label197;
        }
        localCharSequence = paramSpanned.subSequence(0, paramInt3);
        label41:
        paramInt2 = f.a(String.valueOf(localCharSequence), f.a.Qui);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label218;
        }
      }
      label197:
      label203:
      label218:
      for (paramInt3 = f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), f.a.Qui);; paramInt3 = 0)
      {
        paramInt4 = f.a(String.valueOf(paramCharSequence), f.a.Qui);
        int i = this.uGW.uGU;
        int j = f.bnR(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= this.uGW.uGU) {
          break label242;
        }
        paramInt2 = j.mZ(i - paramInt2 - paramInt3 - j, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label224;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(248111);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = f.a(String.valueOf(paramSpanned), f.a.Qui);
        break label53;
      }
      label224:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(248111);
      return paramCharSequence;
      label242:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(248111);
        return paramCharSequence;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class c
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(248112);
      this.uGW.uGV = (f.dp(this.uGW.uGU, String.valueOf(paramEditable)) / 2);
      TextView localTextView = this.uGW.uGS;
      if (this.uGW.uGV >= 0) {}
      for (paramEditable = (CharSequence)(this.uGW.uGV + '/' + this.uGW.MAX_INPUT_SIZE);; paramEditable = (CharSequence)("0/" + this.uGW.MAX_INPUT_SIZE))
      {
        localTextView.setText(paramEditable);
        AppMethodBeat.o(248112);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.i
 * JD-Core Version:    0.7.0.1
 */