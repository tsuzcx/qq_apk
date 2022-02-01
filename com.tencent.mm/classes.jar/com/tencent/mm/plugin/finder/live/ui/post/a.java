package com.tencent.mm.plugin.finder.live.ui.post;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/post/PostEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "setDescTv", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;)V", "footerContainer", "Landroid/view/View;", "getFooterContainer", "()Landroid/view/View;", "setFooterContainer", "(Landroid/view/View;)V", "oldFooterHeight", "", "getOldFooterHeight", "()I", "setOldFooterHeight", "(I)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "getStyleManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "setStyleManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;)V", "textCountTv", "Landroid/widget/TextView;", "textOk", "", "getTextOk", "()Z", "setTextOk", "(Z)V", "checkNextEnable", "", "initDescText", "initView", "onDestroy", "onSelectContact", "resultCode", "data", "Landroid/content/Intent;", "onTopicClick", "saveDescData", "plugin-finder_release"})
public final class a
  extends UIComponent
  implements FinderPostFooter.b
{
  final String TAG;
  TextView yOA;
  public FinderPostFooter yOB;
  public View yOC;
  boolean yOD;
  int yOE;
  public com.tencent.mm.plugin.finder.view.manager.d yOF;
  final f yOG;
  private final f yOH;
  public FinderPostEditText yOz;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(290664);
    this.TAG = "Finder.FinderPostUI";
    this.yOD = true;
    this.yOG = kotlin.g.ar((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.yOH = kotlin.g.ar((kotlin.g.a.a)new e(paramAppCompatActivity));
    AppMethodBeat.o(290664);
  }
  
  public final FinderPostEditText dDV()
  {
    AppMethodBeat.i(290657);
    FinderPostEditText localFinderPostEditText = this.yOz;
    if (localFinderPostEditText == null) {
      p.bGy("descTv");
    }
    AppMethodBeat.o(290657);
    return localFinderPostEditText;
  }
  
  public final FinderPostFooter dDW()
  {
    AppMethodBeat.i(290658);
    FinderPostFooter localFinderPostFooter = this.yOB;
    if (localFinderPostFooter == null) {
      p.bGy("footer");
    }
    AppMethodBeat.o(290658);
    return localFinderPostFooter;
  }
  
  public final View dDX()
  {
    AppMethodBeat.i(290659);
    View localView = this.yOC;
    if (localView == null) {
      p.bGy("footerContainer");
    }
    AppMethodBeat.o(290659);
    return localView;
  }
  
  public final com.tencent.mm.plugin.finder.view.manager.d dDY()
  {
    AppMethodBeat.i(290660);
    com.tencent.mm.plugin.finder.view.manager.d locald = this.yOF;
    if (locald == null) {
      p.bGy("styleManager");
    }
    AppMethodBeat.o(290660);
    return locald;
  }
  
  public final void dDZ()
  {
    AppMethodBeat.i(290662);
    Object localObject1 = this.yOz;
    if (localObject1 == null) {
      p.bGy("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.yOz;
    if (localObject1 == null) {
      p.bGy("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = ag.AFH;
    localObject2 = ag.edT();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.yOz;
      if (localObject2 == null) {
        p.bGy("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)localObject1));
      localObject1 = this.yOz;
      if (localObject1 == null) {
        p.bGy("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.yOz;
      if (localObject1 == null) {
        p.bGy("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      localObject1 = this.yOC;
      if (localObject1 == null) {
        p.bGy("footerContainer");
      }
      if (((View)localObject1).getVisibility() != 8) {
        break label378;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(290662);
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
          AppMethodBeat.o(290662);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(290662);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).substring(i, j);
        p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject1;
      }
    }
    ((MMActivity)localObject1).showVKB();
    label378:
    AppMethodBeat.o(290662);
  }
  
  public final void dEa()
  {
    AppMethodBeat.i(290663);
    Object localObject1 = this.yOz;
    if (localObject1 == null) {
      p.bGy("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    getIntent().putExtra("saveDesc", (String)localObject1);
    localObject1 = getIntent();
    Object localObject2 = this.yOF;
    if (localObject2 == null) {
      p.bGy("styleManager");
    }
    Object localObject3 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject2).ejT();
    localObject2 = new ArrayList();
    localObject3 = ((Map)((com.tencent.mm.plugin.finder.view.manager.b)localObject3).BeX).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
      ((Map.Entry)localObject4).getKey();
      localObject4 = (cse)((Map.Entry)localObject4).getValue();
      com.tencent.mm.plugin.finder.utils.e locale = com.tencent.mm.plugin.finder.utils.e.ACV;
      ((ArrayList)localObject2).add(com.tencent.mm.plugin.finder.utils.e.c((cse)localObject4));
    }
    ((Intent)localObject1).putExtra("saveDescAt", (Serializable)localObject2);
    AppMethodBeat.o(290663);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290661);
    super.onDestroy();
    if (this.yOF == null) {
      p.bGy("styleManager");
    }
    AppMethodBeat.o(290661);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/ui/post/PostEditUIC$initDescText$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-finder_release"})
  public static final class a
    implements InputFilter
  {
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(272734);
      if (paramCharSequence != null)
      {
        paramSpanned = paramCharSequence.toString();
        if (n.a((CharSequence)paramSpanned, (CharSequence)"\n", false))
        {
          paramCharSequence = (CharSequence)n.l(paramSpanned, "\n", "", false);
          AppMethodBeat.o(272734);
          return paramCharSequence;
        }
      }
      AppMethodBeat.o(272734);
      return paramCharSequence;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(a parama) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(282038);
      if (p.h(paramView, this.yOI.dDV()))
      {
        p.j(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(282038);
        return false;
        a.b(this.yOI).requestDisallowInterceptTouchEvent(true);
        continue;
        a.b(this.yOI).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/ui/post/PostEditUIC$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class c
    implements TextWatcher
  {
    c(int paramInt) {}
    
    @SuppressLint({"SetTextI18n"})
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(289809);
      int i = com.tencent.mm.ui.tools.g.dq(this.yOJ * 2, String.valueOf(paramEditable)) / 2;
      i = this.yOJ - i;
      this.yOI.yOD = true;
      if (i / this.yOJ >= 0.95D)
      {
        a.a(this.yOI).setText((CharSequence)(i + '/' + this.yOJ));
        if (i > this.yOJ)
        {
          a.a(this.yOI).setTextColor(this.yOI.getResources().getColor(b.c.Red_100));
          this.yOI.yOD = false;
          a.a(this.yOI).setVisibility(0);
          label141:
          Object localObject1 = this.yOI;
          Object localObject2 = com.tencent.mm.ui.component.g.Xox;
          ((c)com.tencent.mm.ui.component.g.b(((a)localObject1).getActivity()).i(c.class)).dEi();
          localObject1 = this.yOI.dDY();
          localObject2 = String.valueOf(paramEditable);
          if (paramEditable == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).a((String)localObject2, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (com.tencent.mm.plugin.finder.storage.d.dTd())
          {
            paramEditable = this.yOI.dDY().BfG;
            if (paramEditable == null) {
              p.bGy("topicSuggestManager");
            }
            i = paramEditable.BfK.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (i <= ((Number)com.tencent.mm.plugin.finder.storage.d.dTW().aSr()).intValue()) {
              break label410;
            }
            this.yOI.dDW().rr(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dTe()) {
          break label435;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dUm().aSr()).intValue() == 1000) {
          break label424;
        }
        i = this.yOI.dDY().ejT().ABf.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (i < ((Number)com.tencent.mm.plugin.finder.storage.d.dUm().aSr()).intValue()) {
          break label424;
        }
        this.yOI.dDW().rs(false);
        AppMethodBeat.o(289809);
        return;
        a.a(this.yOI).setTextColor(this.yOI.getResources().getColor(b.c.FG_1));
        break;
        a.a(this.yOI).setText((CharSequence)"");
        a.a(this.yOI).setVisibility(8);
        break label141;
        label410:
        this.yOI.dDW().rr(true);
      }
      label424:
      this.yOI.dDW().rs(true);
      label435:
      AppMethodBeat.o(289809);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.widget.post.c>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ScrollView;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.post.a
 * JD-Core Version:    0.7.0.1
 */