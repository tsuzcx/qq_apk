package com.tencent.mm.plugin.finder.ui.post;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.manager.e;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/PostEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "setDescTv", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;)V", "footerContainer", "Landroid/view/View;", "getFooterContainer", "()Landroid/view/View;", "setFooterContainer", "(Landroid/view/View;)V", "oldFooterHeight", "", "getOldFooterHeight", "()I", "setOldFooterHeight", "(I)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "getStyleManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "setStyleManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;)V", "textCountTv", "Landroid/widget/TextView;", "textOk", "", "getTextOk", "()Z", "setTextOk", "(Z)V", "checkNextEnable", "", "initDescText", "initView", "onDestroy", "onSelectContact", "resultCode", "data", "Landroid/content/Intent;", "onTopicClick", "saveDescData", "plugin-finder_release"})
public final class PostEditUIC
  extends UIComponent
  implements FinderPostFooter.b
{
  final String TAG;
  public View uGQ;
  TextView uGS;
  public FinderPostEditText vQR;
  public FinderPostFooter vQS;
  boolean vQT;
  int vQU;
  public com.tencent.mm.plugin.finder.view.manager.d vQV;
  final kotlin.f vQW;
  private final kotlin.f vQX;
  
  public PostEditUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(252951);
    this.TAG = "Finder.FinderPostUI";
    this.vQT = true;
    this.vQW = g.ah((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.vQX = g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    AppMethodBeat.o(252951);
  }
  
  public final com.tencent.mm.plugin.finder.view.manager.d dAA()
  {
    AppMethodBeat.i(252947);
    com.tencent.mm.plugin.finder.view.manager.d locald = this.vQV;
    if (locald == null) {
      p.btv("styleManager");
    }
    AppMethodBeat.o(252947);
    return locald;
  }
  
  public final void dAB()
  {
    AppMethodBeat.i(252949);
    Object localObject1 = this.vQR;
    if (localObject1 == null) {
      p.btv("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.vQR;
    if (localObject1 == null) {
      p.btv("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = w.vXp;
    localObject2 = w.dCx();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.vQR;
      if (localObject2 == null) {
        p.btv("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)localObject1));
      localObject1 = this.vQR;
      if (localObject1 == null) {
        p.btv("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.vQR;
      if (localObject1 == null) {
        p.btv("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      localObject1 = this.uGQ;
      if (localObject1 == null) {
        p.btv("footerContainer");
      }
      if (((View)localObject1).getVisibility() != 8) {
        break label377;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252949);
      throw ((Throwable)localObject1);
      if (i == ((String)localObject1).length())
      {
        localObject1 = (String)localObject1 + (String)localObject2;
      }
      else
      {
        localObject3 = new StringBuilder();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252949);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252949);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).substring(i, j);
        p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject1;
      }
    }
    ((MMActivity)localObject1).showVKB();
    label377:
    AppMethodBeat.o(252949);
  }
  
  public final void dAC()
  {
    AppMethodBeat.i(252950);
    Object localObject1 = this.vQR;
    if (localObject1 == null) {
      p.btv("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    getIntent().putExtra("saveDesc", (String)localObject1);
    localObject1 = getIntent();
    Object localObject2 = this.vQV;
    if (localObject2 == null) {
      p.btv("styleManager");
    }
    Object localObject3 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject2).dHI();
    localObject2 = new ArrayList();
    localObject3 = ((Map)((com.tencent.mm.plugin.finder.view.manager.b)localObject3).wsG).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
      ((Map.Entry)localObject4).getKey();
      localObject4 = (cjj)((Map.Entry)localObject4).getValue();
      com.tencent.mm.plugin.finder.utils.d locald = com.tencent.mm.plugin.finder.utils.d.vVg;
      ((ArrayList)localObject2).add(com.tencent.mm.plugin.finder.utils.d.c((cjj)localObject4));
    }
    ((Intent)localObject1).putExtra("saveDescAt", (Serializable)localObject2);
    AppMethodBeat.o(252950);
  }
  
  public final FinderPostEditText dAx()
  {
    AppMethodBeat.i(252944);
    FinderPostEditText localFinderPostEditText = this.vQR;
    if (localFinderPostEditText == null) {
      p.btv("descTv");
    }
    AppMethodBeat.o(252944);
    return localFinderPostEditText;
  }
  
  public final FinderPostFooter dAy()
  {
    AppMethodBeat.i(252945);
    FinderPostFooter localFinderPostFooter = this.vQS;
    if (localFinderPostFooter == null) {
      p.btv("footer");
    }
    AppMethodBeat.o(252945);
    return localFinderPostFooter;
  }
  
  public final View dAz()
  {
    AppMethodBeat.i(252946);
    View localView = this.uGQ;
    if (localView == null) {
      p.btv("footerContainer");
    }
    AppMethodBeat.o(252946);
    return localView;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252948);
    super.onDestroy();
    if (this.vQV == null) {
      p.btv("styleManager");
    }
    AppMethodBeat.o(252948);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/post/PostEditUIC$initDescText$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-finder_release"})
  public static final class a
    implements InputFilter
  {
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(252939);
      if (paramCharSequence != null)
      {
        paramSpanned = paramCharSequence.toString();
        if (n.a((CharSequence)paramSpanned, (CharSequence)"\n", false))
        {
          paramCharSequence = (CharSequence)n.j(paramSpanned, "\n", "", false);
          AppMethodBeat.o(252939);
          return paramCharSequence;
        }
      }
      AppMethodBeat.o(252939);
      return paramCharSequence;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(PostEditUIC paramPostEditUIC) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252940);
      if (p.j(paramView, this.vQY.dAx()))
      {
        p.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(252940);
        return false;
        PostEditUIC.b(this.vQY).requestDisallowInterceptTouchEvent(true);
        continue;
        PostEditUIC.b(this.vQY).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/post/PostEditUIC$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class c
    implements TextWatcher
  {
    c(int paramInt) {}
    
    @SuppressLint({"SetTextI18n"})
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(252941);
      int i = com.tencent.mm.ui.tools.f.dp(this.vQZ * 2, String.valueOf(paramEditable)) / 2;
      i = this.vQZ - i;
      this.vQY.vQT = true;
      if (i / this.vQZ >= 0.95D)
      {
        PostEditUIC.a(this.vQY).setText((CharSequence)(i + '/' + this.vQZ));
        if (i > this.vQZ)
        {
          PostEditUIC.a(this.vQY).setTextColor(this.vQY.getResources().getColor(2131099819));
          this.vQY.vQT = false;
          PostEditUIC.a(this.vQY).setVisibility(0);
          label140:
          Object localObject1 = this.vQY;
          Object localObject2 = com.tencent.mm.ui.component.a.PRN;
          ((PostMainUIC)com.tencent.mm.ui.component.a.b(((PostEditUIC)localObject1).getActivity()).get(PostMainUIC.class)).dAJ();
          localObject1 = this.vQY.dAA();
          localObject2 = String.valueOf(paramEditable);
          if (paramEditable == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).a((String)localObject2, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (com.tencent.mm.plugin.finder.storage.c.drN())
          {
            paramEditable = this.vQY.dAA().wtp;
            if (paramEditable == null) {
              p.btv("topicSuggestManager");
            }
            i = paramEditable.wtt.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (i <= ((Number)com.tencent.mm.plugin.finder.storage.c.dsC().value()).intValue()) {
              break label408;
            }
            this.vQY.dAy().oX(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drO()) {
          break label433;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dsT().value()).intValue() == 1000) {
          break label422;
        }
        i = this.vQY.dAA().dHI().vTC.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (i < ((Number)com.tencent.mm.plugin.finder.storage.c.dsT().value()).intValue()) {
          break label422;
        }
        this.vQY.dAy().oY(false);
        AppMethodBeat.o(252941);
        return;
        PostEditUIC.a(this.vQY).setTextColor(this.vQY.getResources().getColor(2131099748));
        break;
        PostEditUIC.a(this.vQY).setText((CharSequence)"");
        PostEditUIC.a(this.vQY).setVisibility(8);
        break label140;
        label408:
        this.vQY.dAy().oX(true);
      }
      label422:
      this.vQY.dAy().oY(true);
      label433:
      AppMethodBeat.o(252941);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.widget.post.c>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ScrollView;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ScrollView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.post.PostEditUIC
 * JD-Core Version:    0.7.0.1
 */