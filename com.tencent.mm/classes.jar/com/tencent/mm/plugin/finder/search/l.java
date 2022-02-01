package com.tencent.mm.plugin.finder.search;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.cgi.ed;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.fkm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "Lcom/tencent/mm/plugin/finder/search/ISearchStateChange;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "editText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchSceneForPull", "", "searchSceneForReport", "isFullEnjoy", "", "forceNightMode", "onSuggestionClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/ui/search/FTSEditTextView;IIZZLkotlin/jvm/functions/Function1;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "getForceNightMode", "()Z", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "query", "searchContent", "getSearchSceneForPull", "()I", "getSearchSceneForReport", "suggestionAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionAdapter;", "suggestionConverter", "Lcom/tencent/mm/plugin/finder/search/SuggestionConverter;", "suggestionLv", "Landroid/widget/ListView;", "suggestionScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneSuggestion;", "suggestions", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Suggestion;", "visibleChangeListener", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "composeSuggestWords", "dismissSuggestion", "onActivityPause", "onActivityResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearch", "onSearchKeyDown", "onSearchText", "text", "refreshSuggestionList", "report", "searchScene", "eventCode", "resetSuggestionList", "setOnVisibleChangeListener", "listener", "showSuggestion", "Companion", "IVisibleChangeListener", "SuggestionAdapter", "SuggestionItemHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h
{
  public static final a Fyg;
  final boolean ANb;
  final boolean FxW;
  private final int Fxl;
  private final FTSEditTextView Fyh;
  private final int Fyi;
  private final o Fyj;
  private ListView Fyk;
  private c Fyl;
  private LinkedList<fkm> Fym;
  private String Fyn;
  private ed Fyo;
  private b Fyp;
  private final MMActivity activity;
  private com.tencent.mm.bx.b lastBuffer;
  private String query;
  
  static
  {
    AppMethodBeat.i(342617);
    Fyg = new a((byte)0);
    AppMethodBeat.o(342617);
  }
  
  public l(MMActivity paramMMActivity, FTSEditTextView paramFTSEditTextView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(342524);
    this.activity = paramMMActivity;
    this.Fyh = paramFTSEditTextView;
    this.Fxl = paramInt1;
    this.Fyi = paramInt2;
    this.FxW = paramBoolean1;
    this.ANb = paramBoolean2;
    this.Fyj = new o((Context)this.activity, this.FxW, this.ANb);
    paramMMActivity = this.activity.findViewById(e.e.suggestion_lv);
    kotlin.g.b.s.s(paramMMActivity, "activity.findViewById(R.id.suggestion_lv)");
    this.Fyk = ((ListView)paramMMActivity);
    this.query = "";
    this.Fyn = "";
    paramMMActivity = this.Fyh;
    paramFTSEditTextView = new l..ExternalSyntheticLambda2(this);
    if (!paramMMActivity.afCg.contains(paramFTSEditTextView)) {
      paramMMActivity.afCg.add(paramFTSEditTextView);
    }
    this.Fyl = new c();
    this.Fyk.setAdapter((ListAdapter)this.Fyl);
    this.Fyk.setOnItemClickListener(new l..ExternalSyntheticLambda1(this, paramb));
    this.Fyk.setOnTouchListener(new l..ExternalSyntheticLambda0(this));
    if ((this.FxW) || (this.ANb)) {
      this.Fyk.setBackgroundColor(this.activity.getResources().getColor(e.b.full_black));
    }
    AppMethodBeat.o(342524);
  }
  
  private static final void a(l paraml, String paramString1, String paramString2, List paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(342588);
    kotlin.g.b.s.u(paraml, "this$0");
    Log.i("Finder.SearchSuggestion", "totalText :" + paramString1 + " inEditText:" + paramString2 + " tagList.size:" + paramList.size() + " textChangeStatus:" + paramd);
    if ((!Util.isNullOrNil(paraml.Fyn)) && (kotlin.g.b.s.p(paraml.Fyn, paramString2)))
    {
      paraml.ePg();
      AppMethodBeat.o(342588);
      return;
    }
    paraml.query = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      paraml.lastBuffer = null;
      paraml.ePk();
      paraml.ePi();
      AppMethodBeat.o(342588);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a((p)paraml.Fyo);
    kotlin.g.b.s.s(paramString2, "inEditText");
    paramList = paraml.lastBuffer;
    int i = paraml.Fxl;
    paramString1 = as.GSQ;
    paramString1 = as.a.hu((Context)paraml.activity);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.fou())
    {
      paraml.Fyo = new ed(paramString2, paramList, i, paramString1);
      com.tencent.mm.kernel.h.aZW().a((p)paraml.Fyo, 0);
      AppMethodBeat.o(342588);
      return;
    }
  }
  
  private static final void a(l paraml, kotlin.g.a.b paramb, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(342599);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramb);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramb, "$onSuggestionClickListener");
    paraml.Fyn = paraml.Fyl.getItem(paramInt).toString();
    Log.i("Finder.SearchSuggestion", "onItemClick : " + paramInt + " query:" + paraml.Fyn);
    paraml.ik(paraml.Fyi, 2);
    paramb.invoke(paraml.Fyn);
    if (kotlin.g.b.s.p(paraml.Fyn, paraml.Fyh.getEditText().getText().toString())) {
      paraml.ePg();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(342599);
  }
  
  private static final boolean a(l paraml, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342605);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml.activity.hideVKB();
    AppMethodBeat.o(342605);
    return false;
  }
  
  private final String ePh()
  {
    int j = 0;
    AppMethodBeat.i(342551);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.Fyl.Fyq;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        SpannableString localSpannableString = (SpannableString)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(i + '#' + localSpannableString + '/');
        i += 1;
      }
      i = j;
      if (((CharSequence)localObject1).length() > 0) {
        i = 1;
      }
      if (i != 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    kotlin.g.b.s.s(localObject1, "words.toString()");
    AppMethodBeat.o(342551);
    return localObject1;
  }
  
  private final void ePi()
  {
    AppMethodBeat.i(342561);
    Log.i("Finder.SearchSuggestion", "dismissSuggestion");
    this.Fyk.animate().cancel();
    this.Fyk.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(this)).start();
    b localb = this.Fyp;
    if (localb != null) {
      localb.Oh(8);
    }
    AppMethodBeat.o(342561);
  }
  
  private final void ePj()
  {
    AppMethodBeat.i(342572);
    c localc = this.Fyl;
    Object localObject1 = this.Fym;
    if (localObject1 == null)
    {
      localObject1 = null;
      localc.Fyq = ((List)localObject1);
      localObject1 = this.Fyl.Fyq;
      if (localObject1 != null) {
        if (((Collection)localObject1).isEmpty()) {
          break label341;
        }
      }
    }
    label330:
    label341:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.Fyk.getVisibility() != 0))
      {
        this.Fyk.setVisibility(0);
        this.Fyk.animate().cancel();
        this.Fyk.setAlpha(0.0F);
        this.Fyk.animate().alpha(1.0F).setDuration(300L).setListener(null).start();
        localObject1 = this.Fyp;
        if (localObject1 != null) {
          ((b)localObject1).Oh(0);
        }
      }
      this.Fyl.notifyDataSetChanged();
      ik(this.Fyi, 1);
      AppMethodBeat.o(342572);
      return;
      localObject1 = (Iterable)localObject1;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (fkm)localIterator.next();
        o localo = this.Fyj;
        kotlin.g.b.s.u(localObject3, "suggestion");
        if ((Util.isNullOrNil(((fkm)localObject3).abLo)) || (Util.isNullOrNil(((fkm)localObject3).abLp))) {
          Log.i("Finder.SuggestionConverter", "convertToSpan null");
        }
        int j;
        Object localObject2;
        for (localObject1 = null;; localObject1 = localo.d(i, j, (String)localObject1, (String)localObject2))
        {
          if (localObject1 == null) {
            break label330;
          }
          localCollection.add(localObject1);
          break;
          i = localo.FyB;
          j = localo.FyC;
          localObject2 = ((fkm)localObject3).abLo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = ((fkm)localObject3).abLp;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
        }
      }
      localObject1 = (List)localCollection;
      break;
    }
  }
  
  private final void ePk()
  {
    AppMethodBeat.i(342577);
    this.Fyl.Fyq = null;
    this.Fyl.notifyDataSetChanged();
    AppMethodBeat.o(342577);
  }
  
  private final void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342542);
    Object localObject1 = new JSONObject();
    Object localObject2 = z.FrZ;
    ((JSONObject)localObject1).put("searchsessionid", z.eMW());
    ((JSONObject)localObject1).put("searchscene", paramInt1);
    ((JSONObject)localObject1).put("keyword", this.query);
    ((JSONObject)localObject1).put("expose_suggestword", ePh());
    localObject1 = ((JSONObject)localObject1).toString();
    kotlin.g.b.s.s(localObject1, "JSONObject().apply {\n   …s())\n        }.toString()");
    localObject2 = n.bV((String)localObject1, ",", ";");
    localObject1 = z.FrZ;
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)this.activity);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      z.b(paramInt2, "suggestword_panel", (String)localObject2, (bui)localObject1);
      AppMethodBeat.o(342542);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(342659);
    kotlin.g.b.s.u(paramb, "listener");
    this.Fyp = paramb;
    AppMethodBeat.o(342659);
  }
  
  public final void aAj(String paramString)
  {
    AppMethodBeat.i(342650);
    kotlin.g.b.s.u(paramString, "text");
    this.Fyn = paramString;
    AppMethodBeat.o(342650);
  }
  
  public final void ePg()
  {
    AppMethodBeat.i(342664);
    Log.i("Finder.SearchSuggestion", "ignore searchSuggestionContent");
    this.Fyn = "";
    this.lastBuffer = null;
    ePk();
    ePi();
    AppMethodBeat.o(342664);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(342636);
    com.tencent.mm.kernel.h.aZW().b(6200, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(342636);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(342640);
    com.tencent.mm.kernel.h.aZW().a(6200, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(342640);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(342676);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramp instanceof ed)) {
        break label120;
      }
      paramString = (ed)paramp;
      if (paramString != null) {
        break label125;
      }
      paramp = null;
      label38:
      Log.i("Finder.SearchSuggestion", "query: " + this.query + " scene query:" + paramp);
      if ((!Util.isNullOrNil(this.query)) && (Util.isEqual(this.query, paramp)))
      {
        if (paramString != null) {
          break label174;
        }
        paramString = localObject;
      }
    }
    for (;;)
    {
      this.Fym = paramString;
      ePj();
      AppMethodBeat.o(342676);
      return;
      label120:
      paramString = null;
      break;
      label125:
      paramp = c.b.b(paramString.rr.otB);
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchSuggestRequest");
        AppMethodBeat.o(342676);
        throw paramString;
      }
      paramp = ((bvc)paramp).query;
      break label38;
      label174:
      paramString = c.c.b(paramString.rr.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchSuggestResponse");
        AppMethodBeat.o(342676);
        throw paramString;
      }
      paramString = ((bvd)paramString).aacE;
      kotlin.g.b.s.s(paramString, "this.rr.responseProtoBuf…hSuggestResponse).suggest");
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "", "onVisibleChange", "", "visibility", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void Oh(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;)V", "matchSuggestionSpans", "", "Landroid/text/SpannableString;", "getMatchSuggestionSpans", "()Ljava/util/List;", "setMatchSuggestionSpans", "(Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends BaseAdapter
  {
    List<? extends SpannableString> Fyq;
    
    public c()
    {
      AppMethodBeat.i(342678);
      AppMethodBeat.o(342678);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(342704);
      List localList = this.Fyq;
      if (localList == null)
      {
        AppMethodBeat.o(342704);
        return 0;
      }
      int i = localList.size();
      AppMethodBeat.o(342704);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(342697);
      Object localObject = this.Fyq;
      if (localObject == null) {}
      for (localObject = null;; localObject = (SpannableString)((List)localObject).get(paramInt))
      {
        kotlin.g.b.s.checkNotNull(localObject);
        AppMethodBeat.o(342697);
        return localObject;
      }
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      AppMethodBeat.i(342690);
      int i;
      Object localObject;
      if (paramView == null)
      {
        kotlin.g.b.s.checkNotNull(paramViewGroup);
        paramView = LayoutInflater.from(paramViewGroup.getContext());
        if (this.Fyr.FxW) {
          if (this.Fyr.ANb)
          {
            i = e.f.finder_full_search_suggestion_item_night_mode;
            paramViewGroup = paramView.inflate(i, paramViewGroup, false);
            paramView = new l.d(this.Fyr);
            localObject = paramViewGroup.findViewById(e.e.content_tv);
            kotlin.g.b.s.s(localObject, "contentView.findViewById(R.id.content_tv)");
            localObject = (TextView)localObject;
            kotlin.g.b.s.u(localObject, "<set-?>");
            paramView.lNZ = ((TextView)localObject);
            localObject = paramViewGroup.findViewById(e.e.suggestion_iv);
            kotlin.g.b.s.s(localObject, "contentView.findViewById(R.id.suggestion_iv)");
            localObject = (ImageView)localObject;
            kotlin.g.b.s.u(localObject, "<set-?>");
            paramView.Fys = ((ImageView)localObject);
            paramViewGroup.setTag(paramView);
            localObject = paramView;
            label150:
            localObject = ((l.d)localObject).lNZ;
            if (localObject == null) {
              break label264;
            }
            label162:
            paramView = this.Fyq;
            if (paramView != null) {
              break label275;
            }
            paramView = null;
          }
        }
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)paramView);
        kotlin.g.b.s.checkNotNull(paramViewGroup);
        AppMethodBeat.o(342690);
        return paramViewGroup;
        i = e.f.finder_full_search_suggestion_item;
        break;
        if (this.Fyr.ANb)
        {
          i = e.f.finder_search_suggestion_item_night_mode;
          break;
        }
        i = e.f.finder_search_suggestion_item;
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchSuggestionManager.SuggestionItemHolder");
          AppMethodBeat.o(342690);
          throw paramView;
        }
        localObject = (l.d)paramViewGroup;
        paramViewGroup = paramView;
        break label150;
        label264:
        kotlin.g.b.s.bIx("contentTV");
        localObject = null;
        break label162;
        label275:
        i = j;
        if (paramInt < paramView.size()) {
          i = 1;
        }
        if (i != 0) {}
        for (;;)
        {
          if (paramView != null) {
            break label311;
          }
          paramView = null;
          break;
          paramView = null;
        }
        label311:
        paramView = (SpannableString)paramView.get(paramInt);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "suggestionIv", "Landroid/widget/ImageView;", "getSuggestionIv", "()Landroid/widget/ImageView;", "setSuggestionIv", "(Landroid/widget/ImageView;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
  {
    public ImageView Fys;
    public TextView lNZ;
    
    public d()
    {
      AppMethodBeat.i(342653);
      AppMethodBeat.o(342653);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$dismissSuggestion$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(l paraml) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(342669);
      Log.i("Finder.SearchSuggestion", "onAnimationCancel");
      AppMethodBeat.o(342669);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(342658);
      Log.i("Finder.SearchSuggestion", "onAnimationEnd");
      l.a(this.Fyr).setVisibility(8);
      AppMethodBeat.o(342658);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(342639);
      Log.i("Finder.SearchSuggestion", "onAnimationRepeat");
      AppMethodBeat.o(342639);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(342683);
      Log.i("Finder.SearchSuggestion", "onAnimationStart");
      AppMethodBeat.o(342683);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.l
 * JD-Core Version:    0.7.0.1
 */