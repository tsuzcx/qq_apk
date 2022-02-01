package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.FinderSurveyView;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.bu;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSurveyUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "isFocusing", "", "targetIndex", "", "timeout", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowCount", "contentLayout", "Landroid/view/View;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCurrWeekBegin", "", "headerLayout", "hideContentLayout", "", "onHideEnd", "Lkotlin/Function0;", "hideHeaderLayout", "hideSurveyLayout", "initContentData", "surveyContent", "leafList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyLeaf;", "initContentLayout", "initHeaderLayout", "surveyHeader", "isSameWeek", "millis1", "millis2", "leafIconToString", "", "icon", "needShowSurvey", "nodeIconToString", "onDestroy", "onFeedFocused", "parseLeafToItemList", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSurveyItem;", "popupContentLayout", "dislikeLayout", "likeLayout", "onPopupEnd", "popupHeaderLayout", "popupSurvey", "popupWholeSurvey", "pullDownOtherViews", "height", "", "duration", "onAnimationEnd", "pullUpOtherViews", "recordSurveyShow", "report21875", "feedId", "wording", "isExpose", "question", "resetHeaderLayout", "safeGetBadNode", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;", "callback", "Lkotlin/Function1;", "safeGetFeedObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "safeGetGoodNode", "safeGetHolder", "safeGetTitleLeaf", "safeGetTitleNode", "showSurveyLayout", "stringifyQuestion", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyQuestion;", "surveyEnd", "surveyGet", "surveyGetCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyGetResponse;", "tryReportLeaf", "tryReportNode", "isBad", "updateHeaderBtn", "layout", "select", "getHeightInAdvance", "getMeasurements", "Landroid/graphics/Point;", "parent", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends UIComponent
  implements bu
{
  public static final a GUF;
  private static final at.a GUJ;
  private static final Set<Long> GUK;
  private static final ConcurrentHashMap<Long, bwr> GUL;
  public int GUG;
  public boolean GUH;
  public boolean GUI;
  public final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(338486);
    GUF = new a((byte)0);
    GUJ = at.a.adfn;
    GUK = (Set)new LinkedHashSet();
    GUL = new ConcurrentHashMap();
    AppMethodBeat.o(338486);
  }
  
  public ax(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338048);
    this.mRi = new MMHandler(Looper.getMainLooper());
    paramAppCompatActivity = d.FAy;
    this.GUG = (((Number)d.eXY().bmg()).intValue() - 1);
    AppMethodBeat.o(338048);
  }
  
  public ax(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338055);
    this.mRi = new MMHandler(Looper.getMainLooper());
    paramFragment = d.FAy;
    this.GUG = (((Number)d.eXY().bmg()).intValue() - 1);
    AppMethodBeat.o(338055);
  }
  
  public static void Y(j paramj)
  {
    AppMethodBeat.i(338064);
    s.u(paramj, "holder");
    View localView = paramj.UH(e.e.finder_seek_bar_footer_layout);
    if (localView != null) {
      localView.setTranslationY(0.0F);
    }
    localView = paramj.UH(e.e.fake_float_play_icon);
    if (localView != null) {
      localView.setTranslationY(0.0F);
    }
    localView = paramj.UH(e.e.finder_feed_full_footer_layout);
    if (localView != null) {
      localView.setTranslationY(0.0F);
    }
    localView = paramj.UH(e.e.finder_survey_header_layout);
    if (localView != null) {
      localView.setVisibility(8);
    }
    paramj = paramj.UH(e.e.finder_survey_content_layout);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    AppMethodBeat.o(338064);
  }
  
  private final View Z(j paramj)
  {
    AppMethodBeat.i(338077);
    Object localObject1 = (ViewStub)paramj.UH(e.e.finder_survey_header_layout_stub);
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramj.UH(e.e.finder_survey_header_layout);
      }
      AppMethodBeat.o(338077);
      return localObject2;
      localObject1 = ((ViewStub)localObject1).inflate();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        ((View)localObject1).setVisibility(8);
        localObject2 = (TextView)((View)localObject1).findViewById(e.e.finder_survey_title);
        View localView1 = ((View)localObject1).findViewById(e.e.finder_survey_dislike);
        View localView2 = ((View)localObject1).findViewById(e.e.finder_survey_like);
        ((TextView)localObject2).setTextSize(1, 15.0F);
        s.s(localView1, "dislikeLayout");
        v(localView1, false);
        localView1.setOnClickListener(new ax..ExternalSyntheticLambda1(this, paramj, localView1, localView2, (TextView)localObject2));
        s.s(localView2, "likeLayout");
        v(localView2, false);
        localView2.setOnClickListener(new ax..ExternalSyntheticLambda0(this, paramj, localView2, localView1, (TextView)localObject2));
      }
    }
  }
  
  private static bwq a(j paramj, kotlin.g.a.b<? super bwq, ah> paramb)
  {
    AppMethodBeat.i(338165);
    paramj = d(paramj, null);
    int i;
    if (paramj != null)
    {
      paramj = (bwr)GUL.get(Long.valueOf(paramj.bZA()));
      if (paramj != null)
      {
        paramj = paramj.aafH;
        s.s(paramj, "question.nodes");
        localObject = ((Iterable)paramj).iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramj = ((Iterator)localObject).next();
          if (((bwq)paramj).icon == 2)
          {
            i = 1;
            label88:
            if (i == 0) {
              break label130;
            }
            label92:
            localObject = paramj;
            if (paramj != null)
            {
              localObject = paramj;
              if (paramb != null) {
                paramb.invoke(paramj);
              }
            }
          }
        }
      }
    }
    for (Object localObject = paramj;; localObject = null)
    {
      paramj = (bwq)localObject;
      AppMethodBeat.o(338165);
      return paramj;
      i = 0;
      break label88;
      label130:
      break;
      paramj = null;
      break label92;
    }
  }
  
  private static String a(bwr parambwr)
  {
    AppMethodBeat.i(338313);
    for (;;)
    {
      StringBuilder localStringBuilder1;
      try
      {
        localStringBuilder1 = new StringBuilder();
        Object localObject2 = parambwr.aafI;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = localStringBuilder1.append(s.X("[FinderSurveyQuestion] surveyId = ", localObject1));
        s.s(localObject1, "append(value)");
        s.s(((StringBuilder)localObject1).append('\n'), "append('\\n')");
        if (Util.isNullOrNil((List)parambwr.aafH)) {
          break label389;
        }
        localObject1 = parambwr.aafH.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label389;
        }
        localObject2 = (bwq)((Iterator)localObject1).next();
        Object localObject3 = new StringBuilder("\t[Node] nodeId = ").append(((bwq)localObject2).aafG).append(" icon = ");
        switch (((bwq)localObject2).icon)
        {
        case 3: 
          parambwr = localStringBuilder1.append(parambwr + " wording = " + ((bwq)localObject2).aafF + ' ');
          s.s(parambwr, "append(value)");
          s.s(parambwr.append('\n'), "append('\\n')");
          if (Util.isNullOrNil((List)((bwq)localObject2).aafE)) {
            continue;
          }
          localObject2 = ((bwq)localObject2).aafE.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (bwp)((Iterator)localObject2).next();
          StringBuilder localStringBuilder2 = new StringBuilder("\t\t[Leaf] leafId = ").append(((bwp)localObject3).aafC).append(" icon = ");
          switch (((bwp)localObject3).icon)
          {
          case 1: 
            parambwr = localStringBuilder1.append(parambwr + " wording = " + ((bwp)localObject3).aafB);
            s.s(parambwr, "append(value)");
            s.s(parambwr.append('\n'), "append('\\n')");
            continue;
            parambwr = "TITLE";
          }
          break;
        }
      }
      finally
      {
        Log.e("Finder.FinderSurveyUIC", "stringifyQuestion failed", new Object[] { parambwr });
        AppMethodBeat.o(338313);
        return "";
      }
      continue;
      label389:
      parambwr = localStringBuilder1.toString();
      s.s(parambwr, "sb.toString()");
      AppMethodBeat.o(338313);
      return parambwr;
      parambwr = "OTHER";
      continue;
      parambwr = "OTHER";
      continue;
      parambwr = "BAD";
      continue;
      parambwr = "GOOD";
      continue;
      parambwr = "TITLE";
      continue;
      parambwr = "NORMAL";
    }
  }
  
  private static final ah a(long paramLong, ax paramax, b.a parama)
  {
    AppMethodBeat.i(338341);
    s.u(paramax, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bwo)parama.ott).aafA;
      if (parama == null)
      {
        AppMethodBeat.o(338341);
        return null;
      }
      ((Map)GUL).put(Long.valueOf(paramLong), parama);
      Log.i("Finder.FinderSurveyUIC", "surveyGet succeed feedId = " + com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramLong) + " isFocusing = " + paramax.GUH + " timeout = " + paramax.GUI + '\n' + a(parama));
      paramax.a(paramLong, (kotlin.g.a.b)new n(paramax));
      paramax = ah.aiuX;
      AppMethodBeat.o(338341);
      return paramax;
    }
    Log.i("Finder.FinderSurveyUIC", "surveyGet CgiFinderGetSurvey failed, errType = " + parama.errType + ", errCode = " + parama.errCode);
    paramax = ah.aiuX;
    AppMethodBeat.o(338341);
    return paramax;
  }
  
  private final void a(long paramLong, kotlin.g.a.b<? super j, ah> paramb)
  {
    AppMethodBeat.i(338227);
    Object localObject = k.aeZF;
    localObject = (FinderHomeUIC)k.d(getActivity()).cp(FinderHomeUIC.class);
    if (localObject != null)
    {
      localObject = ((FinderHomeUIC)localObject).Vi(4);
      if (localObject != null)
      {
        k localk = k.aeZF;
        localObject = (bd)k.y((Fragment)localObject).cp(bd.class);
        if (localObject == null)
        {
          localObject = null;
          if (!(localObject instanceof WxRecyclerAdapter)) {
            break label134;
          }
        }
        label134:
        for (localObject = (WxRecyclerAdapter)localObject;; localObject = null)
        {
          if (localObject != null) {
            break label140;
          }
          AppMethodBeat.o(338227);
          return;
          localObject = ((bd)localObject).getRecyclerView();
          if (localObject == null)
          {
            localObject = null;
            break;
          }
          localObject = ((RecyclerView)localObject).getAdapter();
          break;
        }
        label140:
        localObject = (j)i.c((i)localObject, paramLong);
        if (localObject != null) {
          paramb.invoke(localObject);
        }
      }
    }
    AppMethodBeat.o(338227);
  }
  
  private static void a(View paramView, LinkedList<bwp> paramLinkedList)
  {
    AppMethodBeat.i(338131);
    paramView.setAlpha(1.0F);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (bwp)paramLinkedList.next();
      if (((bwp)localObject).icon != 2)
      {
        long l = ((bwp)localObject).aafC;
        localObject = ((bwp)localObject).aafB;
        if (localObject != null) {
          localLinkedList.add(new m(l, (String)localObject));
        }
      }
    }
    paramLinkedList = (List)localLinkedList;
    ((FinderSurveyView)paramView.findViewById(e.e.survey_view)).setSurveyList((Collection)paramLinkedList);
    AppMethodBeat.o(338131);
  }
  
  private static void a(View paramView, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(338099);
    Context localContext = paramView.getContext();
    WeImageView localWeImageView = (WeImageView)paramView.findViewById(e.e.finder_survey_btn_icon);
    TextView localTextView = (TextView)paramView.findViewById(e.e.finder_survey_btn_title);
    com.tencent.mm.plugin.finder.accessibility.a locala = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    com.tencent.mm.plugin.finder.accessibility.a.fk(paramView);
    locala = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    s.s(localWeImageView, "icon");
    com.tencent.mm.plugin.finder.accessibility.a.fk((View)localWeImageView);
    localTextView.setTextSize(1, 12.0F);
    if (paramBoolean)
    {
      localWeImageView.setIconColor(localContext.getResources().getColor(e.b.orange_100));
      localTextView.setTextColor(localContext.getResources().getColor(e.b.orange_100));
      paramView.setBackgroundResource(e.d.finder_feed_survey_btn_bg_selected);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString)) {
        localTextView.setText((CharSequence)paramString);
      }
      AppMethodBeat.o(338099);
      return;
      localWeImageView.setIconColor(localContext.getResources().getColor(e.b.BW_100_Alpha_0_8));
      localTextView.setTextColor(localContext.getResources().getColor(e.b.BW_100_Alpha_0_8));
      paramView.setBackgroundResource(e.d.finder_feed_survey_btn_bg);
    }
  }
  
  private static final void a(ax paramax, final j paramj, final View paramView1, final View paramView2, final TextView paramTextView, View paramView3)
  {
    AppMethodBeat.i(338322);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramax);
    localb.cH(paramj);
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramTextView);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramax, "this$0");
    s.u(paramj, "$holder");
    paramax.a(paramj, true, false);
    a(paramj, (kotlin.g.a.b)new f(paramax, paramView1, paramView2, paramj, paramTextView));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338322);
  }
  
  private static void a(j paramj, float paramFloat)
  {
    AppMethodBeat.i(338255);
    Object localObject2 = paramj.UH(e.e.finder_feed_full_footer_layout);
    Object localObject1 = paramj.UH(e.e.finder_seek_bar_footer_layout);
    paramj = paramj.UH(e.e.fake_float_play_icon);
    if (localObject2 != null)
    {
      localObject2 = ((View)localObject2).animate();
      if (localObject2 != null)
      {
        localObject2 = ((ViewPropertyAnimator)localObject2).translationYBy(paramFloat);
        if (localObject2 != null)
        {
          localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(300L);
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new j(null));
            if (localObject2 != null) {
              ((ViewPropertyAnimator)localObject2).start();
            }
          }
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).translationYBy(paramFloat);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
          if (localObject1 != null) {
            ((ViewPropertyAnimator)localObject1).start();
          }
        }
      }
    }
    if (paramj != null)
    {
      paramj = paramj.animate();
      if (paramj != null)
      {
        paramj = paramj.translationYBy(paramFloat);
        if (paramj != null)
        {
          paramj = paramj.setDuration(300L);
          if (paramj != null) {
            paramj.start();
          }
        }
      }
    }
    AppMethodBeat.o(338255);
  }
  
  private static void a(j paramj, float paramFloat, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(338263);
    Object localObject = paramj.UH(e.e.finder_feed_full_footer_layout);
    View localView = paramj.UH(e.e.finder_seek_bar_footer_layout);
    paramj = paramj.UH(e.e.fake_float_play_icon);
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationYBy(-paramFloat);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            parama = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new k(parama));
            if (parama != null) {
              parama.start();
            }
          }
        }
      }
    }
    if (localView != null)
    {
      parama = localView.animate();
      if (parama != null)
      {
        parama = parama.translationYBy(-paramFloat);
        if (parama != null)
        {
          parama = parama.setDuration(300L);
          if (parama != null) {
            parama.start();
          }
        }
      }
    }
    if (paramj != null)
    {
      paramj = paramj.animate();
      if (paramj != null)
      {
        paramj = paramj.translationYBy(-paramFloat);
        if (paramj != null)
        {
          paramj = paramj.setDuration(300L);
          if (paramj != null) {
            paramj.start();
          }
        }
      }
    }
    AppMethodBeat.o(338263);
  }
  
  private final void a(j paramj, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(338299);
    final ah.f localf = new ah.f();
    String str = paramj.context.getString(e.h.do_you_like_this_video);
    s.s(str, "holder.context.getString…g.do_you_like_this_video)");
    localf.aqH = str;
    c(paramj, (kotlin.g.a.b)new o(localf));
    d(paramj, (kotlin.g.a.b)new p(this, paramString, paramBoolean, localf));
    AppMethodBeat.o(338299);
  }
  
  private final void a(j paramj, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(338291);
    final String str;
    final ah.f localf;
    if (paramBoolean1)
    {
      str = getContext().getString(e.h.finder_survey_dislike);
      s.s(str, "if (isBad) {\n           …er_survey_like)\n        }");
      localf = new ah.f();
      localObject = paramj.context.getString(e.h.do_you_like_this_video);
      s.s(localObject, "holder.context.getString…g.do_you_like_this_video)");
      localf.aqH = localObject;
      c(paramj, (kotlin.g.a.b)new q(localf));
      if (!paramBoolean1) {
        break label144;
      }
    }
    label144:
    for (Object localObject = a(paramj, null);; localObject = b(paramj, null))
    {
      if (localObject != null) {
        d(paramj, (kotlin.g.a.b)new r(this, (bwq)localObject, str, paramBoolean2, localf));
      }
      AppMethodBeat.o(338291);
      return;
      str = getContext().getString(e.h.finder_survey_like);
      break;
    }
  }
  
  private static boolean aC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(338246);
    if (Math.abs(paramLong1 - paramLong2) < 604800000L)
    {
      AppMethodBeat.o(338246);
      return true;
    }
    AppMethodBeat.o(338246);
    return false;
  }
  
  private final View aa(final j paramj)
  {
    AppMethodBeat.i(338118);
    Object localObject1 = (ViewStub)paramj.UH(e.e.finder_survey_content_layout_stub);
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramj.UH(e.e.finder_survey_content_layout);
      }
      AppMethodBeat.o(338118);
      return localObject2;
      localObject1 = ((ViewStub)localObject1).inflate();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        ((View)localObject1).setVisibility(8);
        localObject2 = (FinderSurveyView)((View)localObject1).findViewById(e.e.survey_view);
        if (localObject2 != null) {
          ((FinderSurveyView)localObject2).setItemClickListener((i.c)new e(this, paramj, (FinderSurveyView)localObject2));
        }
      }
    }
  }
  
  private static bwq b(j paramj, kotlin.g.a.b<? super bwq, ah> paramb)
  {
    AppMethodBeat.i(338177);
    paramj = d(paramj, null);
    int i;
    if (paramj != null)
    {
      paramj = (bwr)GUL.get(Long.valueOf(paramj.bZA()));
      if (paramj != null)
      {
        paramj = paramj.aafH;
        s.s(paramj, "question.nodes");
        localObject = ((Iterable)paramj).iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramj = ((Iterator)localObject).next();
          if (((bwq)paramj).icon == 1)
          {
            i = 1;
            label88:
            if (i == 0) {
              break label130;
            }
            label92:
            localObject = paramj;
            if (paramj != null)
            {
              localObject = paramj;
              if (paramb != null) {
                paramb.invoke(paramj);
              }
            }
          }
        }
      }
    }
    for (Object localObject = paramj;; localObject = null)
    {
      paramj = (bwq)localObject;
      AppMethodBeat.o(338177);
      return paramj;
      i = 0;
      break label88;
      label130:
      break;
      paramj = null;
      break label92;
    }
  }
  
  private static final void b(ax paramax, final j paramj, final View paramView1, final View paramView2, final TextView paramTextView, View paramView3)
  {
    AppMethodBeat.i(338328);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramax);
    localb.cH(paramj);
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramTextView);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramax, "this$0");
    s.u(paramj, "$holder");
    paramax.a(paramj, false, false);
    b(paramj, (kotlin.g.a.b)new g(paramax, paramView1, paramView2, paramj, paramTextView));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338328);
  }
  
  private static bwq c(j paramj, kotlin.g.a.b<? super bwq, ah> paramb)
  {
    AppMethodBeat.i(338201);
    paramj = d(paramj, null);
    int i;
    if (paramj != null)
    {
      paramj = (bwr)GUL.get(Long.valueOf(paramj.bZA()));
      if (paramj != null)
      {
        paramj = paramj.aafH;
        s.s(paramj, "question.nodes");
        localObject = ((Iterable)paramj).iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramj = ((Iterator)localObject).next();
          if (((bwq)paramj).icon == 3)
          {
            i = 1;
            label88:
            if (i == 0) {
              break label130;
            }
            label92:
            localObject = paramj;
            if (paramj != null)
            {
              localObject = paramj;
              if (paramb != null) {
                paramb.invoke(paramj);
              }
            }
          }
        }
      }
    }
    for (Object localObject = paramj;; localObject = null)
    {
      paramj = (bwq)localObject;
      AppMethodBeat.o(338201);
      return paramj;
      i = 0;
      break label88;
      label130:
      break;
      paramj = null;
      break label92;
    }
  }
  
  public static BaseFinderFeed d(j paramj, kotlin.g.a.b<? super BaseFinderFeed, ah> paramb)
  {
    AppMethodBeat.i(338215);
    paramj = paramj.CSA;
    if ((paramj instanceof BaseFinderFeed)) {}
    for (paramj = (BaseFinderFeed)paramj; paramj != null; paramj = null)
    {
      if (paramb != null) {
        paramb.invoke(paramj);
      }
      AppMethodBeat.o(338215);
      return paramj;
    }
    AppMethodBeat.o(338215);
    return null;
  }
  
  private static boolean foY()
  {
    AppMethodBeat.i(338238);
    Object localObject = new JSONObject(h.baE().ban().b(GUJ, "{}"));
    for (;;)
    {
      try
      {
        if (((JSONObject)localObject).has("count") != true) {
          continue;
        }
        i = 1;
        if (i == 0) {
          break label269;
        }
        i = ((JSONObject)localObject).getInt("count");
      }
      catch (Exception localException2)
      {
        Log.printDebugStack("safeGetInt", "", new Object[] { localException2 });
        i = 0;
        continue;
        j = 0;
        continue;
      }
      long l2 = 0L;
      try
      {
        if (((JSONObject)localObject).has("weak_begin") != true) {
          continue;
        }
        j = 1;
        l1 = l2;
        if (j != 0) {
          l1 = ((JSONObject)localObject).getLong("weak_begin");
        }
      }
      catch (Exception localException1)
      {
        Log.printDebugStack("safeGetInt", "", new Object[] { localException1 });
        long l1 = l2;
        continue;
        AppMethodBeat.o(338238);
        return false;
      }
      localObject = d.FAy;
      int j = ((Number)d.eXZ().bmg()).intValue();
      if (aC(cn.bDu(), l1))
      {
        Log.i("Finder.FinderSurveyUIC", "checkShowCount same week, count = " + i + ", limit = " + j);
        if (i < j)
        {
          AppMethodBeat.o(338238);
          return true;
          i = 0;
          continue;
        }
      }
      Log.i("Finder.FinderSurveyUIC", s.X("checkShowCount different week, count = 0, limit = ", Integer.valueOf(j)));
      if (j > 0)
      {
        AppMethodBeat.o(338238);
        return true;
      }
      AppMethodBeat.o(338238);
      return false;
      label269:
      int i = 0;
    }
  }
  
  private static int hk(View paramView)
  {
    AppMethodBeat.i(338274);
    int i = paramView.getHeight();
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      if ((i > 0) || (localObject == null)) {
        break label58;
      }
      i = p(paramView, (View)localObject).y;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(338274);
      return i;
      localObject = null;
      break;
    }
  }
  
  private final void l(j paramj, final View paramView)
  {
    AppMethodBeat.i(338089);
    Object localObject1 = a(paramj, null);
    Object localObject2;
    label34:
    label54:
    label69:
    TextView localTextView;
    View localView2;
    View localView1;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label215;
      }
      localObject2 = getContext().getString(e.h.finder_survey_dislike);
      s.s(localObject2, "safeGetBadNode(holder)?.…ng.finder_survey_dislike)");
      localObject1 = b(paramj, null);
      if (localObject1 != null) {
        break label221;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label229;
      }
      localObject1 = getContext().getString(e.h.finder_survey_like);
      s.s(localObject1, "safeGetGoodNode(holder)?…tring.finder_survey_like)");
      paramView.setAlpha(1.0F);
      localTextView = (TextView)paramView.findViewById(e.e.finder_survey_title);
      localView2 = paramView.findViewById(e.e.finder_survey_dislike);
      localView1 = paramView.findViewById(e.e.finder_survey_like);
      if (a(paramj, null) != null) {
        break label232;
      }
      paramView = null;
      label121:
      if (paramView == null) {
        localView2.setVisibility(8);
      }
      if (b(paramj, null) != null) {
        break label273;
      }
    }
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null) {
        localView1.setVisibility(8);
      }
      paramView = paramj.context.getString(e.h.do_you_like_this_video);
      s.s(paramView, "holder.context.getString…g.do_you_like_this_video)");
      if (c(paramj, (kotlin.g.a.b)new l(localTextView, paramView)) == null) {
        localTextView.setText((CharSequence)paramView);
      }
      AppMethodBeat.o(338089);
      return;
      localObject1 = ((bwq)localObject1).aafF;
      break;
      label215:
      localObject2 = localObject1;
      break label34;
      label221:
      localObject1 = ((bwq)localObject1).aafF;
      break label54;
      label229:
      break label69;
      label232:
      localView2.setEnabled(true);
      s.s(localView2, "dislikeLayout");
      a(localView2, false, (String)localObject2);
      localView2.setAlpha(1.0F);
      localView2.setVisibility(0);
      paramView = ah.aiuX;
      break label121;
      label273:
      localView1.setEnabled(true);
      s.s(localView1, "likeLayout");
      a(localView1, false, (String)localObject1);
      localView1.setAlpha(1.0F);
      localView1.setVisibility(0);
    }
  }
  
  private static Point p(View paramView1, View paramView2)
  {
    AppMethodBeat.i(338283);
    paramView1.measure(View.MeasureSpec.makeMeasureSpec(paramView2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramView2.getHeight(), 0));
    paramView1 = new Point(paramView1.getMeasuredWidth(), paramView1.getMeasuredHeight());
    AppMethodBeat.o(338283);
    return paramView1;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338510);
    super.onDestroy();
    this.mRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(338510);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$Companion;", "", "()V", "KEY_COUNT", "", "KEY_WEEK_BEGIN", "TAG", "shownList", "", "", "stgKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getStgKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "surveyCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyQuestion;", "of", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC;", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ax hv(Context paramContext)
    {
      AppMethodBeat.i(337575);
      s.u(paramContext, "context");
      k localk = k.aeZF;
      paramContext = (ax)k.nq(paramContext).cp(ax.class);
      AppMethodBeat.o(337575);
      return paramContext;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$hideContentLayout$1$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.animation.a
  {
    b(View paramView1, int paramInt, View paramView2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337572);
      paramAnimator = this.Gaa;
      paramAnimator.setTranslationY(paramAnimator.getTranslationY() - this.aMQ);
      this.Fap.setVisibility(8);
      paramAnimator = this.GUM;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(337572);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$hideContentLayout$1$1$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.animation.a
  {
    c(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337568);
      this.GUN.setVisibility(8);
      AppMethodBeat.o(337568);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$hideHeaderLayout$1$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.animation.a
  {
    d(View paramView1, int paramInt, View paramView2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337582);
      paramAnimator = this.Gaa;
      paramAnimator.setTranslationY(paramAnimator.getTranslationY() - this.aMQ);
      this.DjW.setVisibility(8);
      paramAnimator = this.GUM;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(337582);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$initContentLayout$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "itemHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<j>
  {
    e(ax paramax, j paramj, FinderSurveyView paramFinderSurveyView) {}
    
    private static final void f(ax paramax, j paramj)
    {
      AppMethodBeat.i(337579);
      s.u(paramax, "this$0");
      s.u(paramj, "$holder");
      ax.b(paramax, paramj);
      AppMethodBeat.o(337579);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<bwq, ah>
    {
      a(j paramj1, ax paramax, j paramj2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<bwq, ah>
    {
      b(j paramj1, ax paramax, j paramj2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "badNode", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    f(ax paramax, View paramView1, View paramView2, j paramj, TextView paramTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "goodNode", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    g(ax paramax, View paramView1, View paramView2, j paramj, TextView paramTextView)
    {
      super();
    }
    
    private static final void g(ax paramax, j paramj)
    {
      AppMethodBeat.i(337554);
      s.u(paramax, "this$0");
      s.u(paramj, "$holder");
      ax.a(paramax, paramj);
      AppMethodBeat.o(337554);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.b<BaseFinderFeed, ah>
  {
    public h(ax paramax, j paramj)
    {
      super();
    }
    
    private static final void a(BaseFinderFeed paramBaseFinderFeed, ax paramax, j paramj)
    {
      AppMethodBeat.i(337565);
      s.u(paramBaseFinderFeed, "$it");
      s.u(paramax, "this$0");
      s.u(paramj, "$holder");
      if (ax.foZ().get(Long.valueOf(paramBaseFinderFeed.bZA())) != null) {
        ax.e(paramax, paramj);
      }
      ax.b(paramax);
      AppMethodBeat.o(337565);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "titleNode", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    i(ax paramax, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$pullDownOtherViews$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends com.tencent.mm.plugin.finder.animation.a
  {
    j(kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337550);
      paramAnimator = this.GUX;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(337550);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSurveyUIC$pullUpOtherViews$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends com.tencent.mm.plugin.finder.animation.a
  {
    k(kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337545);
      paramAnimator = this.GUX;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(337545);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    l(TextView paramTextView, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<BaseFinderFeed, ah>
  {
    public static final m GUY;
    
    static
    {
      AppMethodBeat.i(337551);
      GUY = new m();
      AppMethodBeat.o(337551);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<j, ah>
  {
    n(ax paramax)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    o(ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<BaseFinderFeed, ah>
  {
    p(ax paramax, String paramString, boolean paramBoolean, ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<bwq, ah>
  {
    q(ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<BaseFinderFeed, ah>
  {
    r(ax paramax, bwq parambwq, String paramString, boolean paramBoolean, ah.f<String> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ax
 * JD-Core Version:    0.7.0.1
 */