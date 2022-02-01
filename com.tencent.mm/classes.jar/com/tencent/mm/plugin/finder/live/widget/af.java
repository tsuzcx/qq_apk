package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
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
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "descContainer", "getDescContainer", "()Landroid/view/View;", "setDescContainer", "(Landroid/view/View;)V", "descTv", "Lcom/tencent/mm/ui/widget/MMEditText;", "getDescTv", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setDescTv", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "emptyArea", "getEmptyArea", "setEmptyArea", "footerContainer", "getFooterContainer", "setFooterContainer", "hintContainer", "Landroid/widget/FrameLayout;", "getHintContainer", "()Landroid/widget/FrameLayout;", "setHintContainer", "(Landroid/widget/FrameLayout;)V", "inputContainer", "getInputContainer", "setInputContainer", "intecerptKeyBoardEvent", "", "getIntecerptKeyBoardEvent", "()Z", "setIntecerptKeyBoardEvent", "(Z)V", "getRoot", "textCountTv", "Landroid/widget/TextView;", "getTextCountTv", "()Landroid/widget/TextView;", "setTextCountTv", "(Landroid/widget/TextView;)V", "textLeft", "getTextLeft", "setTextLeft", "(I)V", "getDesc", "", "hideInput", "", "hideInputAction", "onKeyboardHeightChanged", "height", "show", "setDescTvBigSize", "bigSize", "setInputConfig", "showInput", "showInputAction", "plugin-finder_release"})
public final class af
{
  public final int MAX_INPUT_SIZE;
  public final MMActivity activity;
  final View jac;
  public TextView yOA;
  public View yOC;
  public View ybl;
  public MMEditText zbm;
  final int zbo;
  public int zbp;
  public FrameLayout zqh;
  public FrameLayout zqi;
  private View zqj;
  public boolean zqk;
  
  public af(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(290932);
    this.activity = paramMMActivity;
    this.jac = paramView;
    this.MAX_INPUT_SIZE = 60;
    this.zbo = (this.MAX_INPUT_SIZE * 2);
    this.zbp = this.MAX_INPUT_SIZE;
    paramMMActivity = this.jac.findViewById(b.f.finder_live_post_container);
    p.j(paramMMActivity, "root.findViewById(R.id.finder_live_post_container)");
    this.ybl = paramMMActivity;
    paramMMActivity = this.jac.findViewById(b.f.finder_live_post_input_hint_container);
    p.j(paramMMActivity, "root.findViewById(R.id.f…ost_input_hint_container)");
    this.zqh = ((FrameLayout)paramMMActivity);
    paramMMActivity = this.jac.findViewById(b.f.live_post_desc_et);
    p.j(paramMMActivity, "root.findViewById(R.id.live_post_desc_et)");
    this.zbm = ((MMEditText)paramMMActivity);
    this.zbm.setEnableSendBtn(true);
    this.zbm.setRawInputType(1);
    paramMMActivity = this.jac.findViewById(b.f.input_container);
    p.j(paramMMActivity, "root.findViewById(R.id.input_container)");
    this.yOC = paramMMActivity;
    paramMMActivity = this.jac.findViewById(b.f.finder_live_post_input_container);
    p.j(paramMMActivity, "root.findViewById(R.id.f…ive_post_input_container)");
    this.zqi = ((FrameLayout)paramMMActivity);
    paramMMActivity = this.jac.findViewById(b.f.textcount_hint);
    p.j(paramMMActivity, "root.findViewById(R.id.textcount_hint)");
    this.yOA = ((TextView)paramMMActivity);
    paramMMActivity = this.jac.findViewById(b.f.input_empty_area);
    p.j(paramMMActivity, "root.findViewById(R.id.input_empty_area)");
    this.zqj = paramMMActivity;
    this.zqj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277184);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = this.zql;
        localObject = paramAnonymousView.jac.getContext().getSystemService("input_method");
        if (localObject == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(277184);
          throw paramAnonymousView;
        }
        ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAnonymousView.zbm.getWindowToken(), 0);
        a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277184);
      }
    });
    paramMMActivity = (InputFilter)new a(this);
    paramView = (InputFilter)new b(this, this.zbo, g.a.XSu);
    this.zbm.setFilters(new InputFilter[] { paramMMActivity, paramView });
    paramMMActivity = (TextWatcher)new c(this);
    this.zbm.addTextChangedListener(paramMMActivity);
    getDesc();
    AppMethodBeat.o(290932);
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(290930);
    Object localObject1 = this.zbm.getText();
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
    localObject1 = q.an((String)localObject1, "UTF-8");
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("content", localObject1);
    localObject2 = ((JSONObject)localObject2).toString();
    p.j(localObject2, "jsobject.toString()");
    Object localObject3 = k.yBj;
    k.setDesc((String)localObject2);
    localObject3 = k.yBj;
    localObject3 = k.dDm().yDw;
    p.j(localObject1, "text");
    ((u)localObject3).setDescription((String)localObject1);
    AppMethodBeat.o(290930);
    return localObject2;
  }
  
  public final void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(290929);
    if (paramBoolean)
    {
      this.zbm.setTextSize(0, this.jac.getResources().getDimensionPixelOffset(b.d.HugeTextSize));
      ar.a((Paint)this.zbm.getPaint(), 0.8F);
      this.zbm.setImeOptions(6);
      AppMethodBeat.o(290929);
      return;
    }
    this.zbm.setTextSize(0, this.jac.getResources().getDimensionPixelOffset(b.d.GroupTitleTextSize));
    ar.b((Paint)this.zbm.getPaint());
    this.zbm.setImeOptions(0);
    this.zbm.setOnEditorActionListener(null);
    AppMethodBeat.o(290929);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class a
    implements InputFilter
  {
    a(af paramaf) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(275517);
      this.zql.zbm.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(275517);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(275517);
        return paramCharSequence;
      }
      AppMethodBeat.o(275517);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class b
    extends g
  {
    b(int paramInt, g.a parama)
    {
      super(locala);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(287313);
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
        paramInt2 = g.a(String.valueOf(localCharSequence), g.a.XSu);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label218;
        }
      }
      label197:
      label203:
      label218:
      for (paramInt3 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.XSu);; paramInt3 = 0)
      {
        paramInt4 = g.a(String.valueOf(paramCharSequence), g.a.XSu);
        int i = this.zql.zbo;
        int j = g.bAE(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= this.zql.zbo) {
          break label242;
        }
        paramInt2 = i.ov(i - paramInt2 - paramInt3 - j, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label224;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(287313);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = g.a(String.valueOf(paramSpanned), g.a.XSu);
        break label53;
      }
      label224:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(287313);
      return paramCharSequence;
      label242:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(287313);
        return paramCharSequence;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget$setInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class c
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(232059);
      this.zql.zbp = (g.dq(this.zql.zbo, String.valueOf(paramEditable)) / 2);
      TextView localTextView = this.zql.yOA;
      if (this.zql.zbp >= 0) {}
      for (paramEditable = (CharSequence)(this.zql.zbp + '/' + this.zql.MAX_INPUT_SIZE);; paramEditable = (CharSequence)("0/" + this.zql.MAX_INPUT_SIZE))
      {
        localTextView.setText(paramEditable);
        AppMethodBeat.o(232059);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.af
 * JD-Core Version:    0.7.0.1
 */