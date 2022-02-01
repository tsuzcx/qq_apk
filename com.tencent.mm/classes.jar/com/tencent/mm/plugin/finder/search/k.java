package com.tencent.mm.plugin.finder.search;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.cgi.dd;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "Lcom/tencent/mm/plugin/finder/search/ISearchStateChange;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "editText", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "searchSceneForPull", "", "searchSceneForReport", "isFullEnjoy", "", "forceNightMode", "onSuggestionClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/ui/search/FTSEditTextView;IIZZLkotlin/jvm/functions/Function1;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getEditText", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "getForceNightMode", "()Z", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "query", "searchContent", "getSearchSceneForPull", "()I", "getSearchSceneForReport", "suggestionAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionAdapter;", "suggestionConverter", "Lcom/tencent/mm/plugin/finder/search/SuggestionConverter;", "suggestionLv", "Landroid/widget/ListView;", "suggestionScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneSuggestion;", "suggestions", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Suggestion;", "visibleChangeListener", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "composeSuggestWords", "dismissSuggestion", "onActivityPause", "onActivityResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearch", "onSearchKeyDown", "onSearchText", "text", "refreshSuggestionList", "report", "searchScene", "eventCode", "resetSuggestionList", "setOnVisibleChangeListener", "listener", "showSuggestion", "Companion", "IVisibleChangeListener", "SuggestionAdapter", "SuggestionItemHolder", "plugin-finder_release"})
public final class k
  implements i
{
  public static final a AcC;
  final int Abv;
  final FTSEditTextView AcA;
  final int AcB;
  final boolean Acc;
  private final n Act;
  private ListView Acu;
  private c Acv;
  private LinkedList<epn> Acw;
  private String Acx;
  private dd Acy;
  private b Acz;
  final MMActivity activity;
  private com.tencent.mm.cd.b lastBuffer;
  private String query;
  final boolean zEV;
  
  static
  {
    AppMethodBeat.i(291587);
    AcC = new a((byte)0);
    AppMethodBeat.o(291587);
  }
  
  public k(MMActivity paramMMActivity, FTSEditTextView paramFTSEditTextView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, final kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(291586);
    this.activity = paramMMActivity;
    this.AcA = paramFTSEditTextView;
    this.Abv = paramInt1;
    this.AcB = paramInt2;
    this.Acc = paramBoolean1;
    this.zEV = paramBoolean2;
    this.Act = new n((Context)this.activity, this.Acc, this.zEV);
    paramMMActivity = this.activity.findViewById(b.f.suggestion_lv);
    p.j(paramMMActivity, "activity.findViewById(R.id.suggestion_lv)");
    this.Acu = ((ListView)paramMMActivity);
    this.query = "";
    this.Acx = "";
    this.AcA.a((FTSEditTextView.a)new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.c> paramAnonymousList, FTSEditTextView.c paramAnonymousc)
      {
        AppMethodBeat.i(284588);
        Log.i("Finder.SearchSuggestion", "totalText :" + paramAnonymousString1 + " inEditText:" + paramAnonymousString2 + " tagList.size:" + paramAnonymousList.size() + " textChangeStatus:" + paramAnonymousc);
        if ((!Util.isNullOrNil(k.b(this.AcD))) && (p.h(k.b(this.AcD), paramAnonymousString2)))
        {
          k.c(this.AcD);
          AppMethodBeat.o(284588);
          return;
        }
        k.b(this.AcD, paramAnonymousString2);
        if (Util.isNullOrNil(paramAnonymousString2))
        {
          k.e(this.AcD);
          k.f(this.AcD);
          k.g(this.AcD);
          AppMethodBeat.o(284588);
          return;
        }
        h.aGY().a((q)k.h(this.AcD));
        paramAnonymousList = this.AcD;
        p.j(paramAnonymousString2, "inEditText");
        paramAnonymousc = k.d(this.AcD);
        int i = this.AcD.Abv;
        paramAnonymousString1 = aj.Bnu;
        paramAnonymousString1 = aj.a.fZ((Context)this.AcD.activity);
        if (paramAnonymousString1 != null) {}
        for (paramAnonymousString1 = paramAnonymousString1.ekY();; paramAnonymousString1 = null)
        {
          k.a(paramAnonymousList, new dd(paramAnonymousString2, paramAnonymousc, i, paramAnonymousString1));
          h.aGY().b((q)k.h(this.AcD));
          AppMethodBeat.o(284588);
          return;
        }
      }
    });
    this.Acv = new c();
    this.Acu.setAdapter((ListAdapter)this.Acv);
    this.Acu.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(276983);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        k.a(this.AcD, k.i(this.AcD).getItem(paramAnonymousInt).toString());
        Log.i("Finder.SearchSuggestion", "onItemClick : " + paramAnonymousInt + " query:" + k.b(this.AcD));
        k.a(this.AcD, this.AcD.AcB);
        paramb.invoke(k.b(this.AcD));
        paramAnonymousAdapterView = k.b(this.AcD);
        paramAnonymousView = this.AcD.AcA.getEditText();
        p.j(paramAnonymousView, "editText.editText");
        if (p.h(paramAnonymousAdapterView, paramAnonymousView.getText().toString())) {
          k.c(this.AcD);
        }
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(276983);
      }
    });
    this.Acu.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(280565);
        this.AcD.activity.hideVKB();
        AppMethodBeat.o(280565);
        return false;
      }
    });
    if ((this.Acc) || (this.zEV)) {
      this.Acu.setBackgroundColor(this.activity.getResources().getColor(b.c.full_black));
    }
    AppMethodBeat.o(291586);
  }
  
  private final String dRk()
  {
    int j = 0;
    AppMethodBeat.i(291581);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.Acv.AcF;
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
    p.j(localObject1, "words.toString()");
    AppMethodBeat.o(291581);
    return localObject1;
  }
  
  private final void dRl()
  {
    AppMethodBeat.i(291582);
    Log.i("Finder.SearchSuggestion", "dismissSuggestion");
    this.Acu.animate().cancel();
    this.Acu.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(this)).start();
    b localb = this.Acz;
    if (localb != null)
    {
      localb.MJ(8);
      AppMethodBeat.o(291582);
      return;
    }
    AppMethodBeat.o(291582);
  }
  
  private final void dRm()
  {
    AppMethodBeat.i(291584);
    c localc = this.Acv;
    Object localObject1 = this.Acw;
    if (localObject1 != null)
    {
      localObject1 = (Iterable)localObject1;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      label193:
      while (localIterator.hasNext())
      {
        Object localObject3 = (epn)localIterator.next();
        n localn = this.Act;
        p.k(localObject3, "suggestion");
        if ((Util.isNullOrNil(((epn)localObject3).Usl)) || (Util.isNullOrNil(((epn)localObject3).Usm))) {
          Log.i("Finder.SuggestionConverter", "convertToSpan null");
        }
        int j;
        Object localObject2;
        for (localObject1 = null;; localObject1 = localn.c(i, j, (String)localObject1, (String)localObject2))
        {
          if (localObject1 == null) {
            break label193;
          }
          localCollection.add(localObject1);
          break;
          i = localn.AcO;
          j = localn.AcP;
          localObject2 = ((epn)localObject3).Usl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = ((epn)localObject3).Usm;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
        }
      }
      localObject1 = (List)localCollection;
      localc.AcF = ((List)localObject1);
      localObject1 = this.Acv.AcF;
      if (localObject1 != null) {
        if (((Collection)localObject1).isEmpty()) {
          break label341;
        }
      }
    }
    label341:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.Acu.getVisibility() != 0))
      {
        this.Acu.setVisibility(0);
        this.Acu.animate().cancel();
        this.Acu.setAlpha(0.0F);
        this.Acu.animate().alpha(1.0F).setDuration(300L).setListener(null).start();
        localObject1 = this.Acz;
        if (localObject1 != null) {
          ((b)localObject1).MJ(0);
        }
      }
      this.Acv.notifyDataSetChanged();
      gU(this.AcB, 1);
      AppMethodBeat.o(291584);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private final void dRn()
  {
    AppMethodBeat.i(291585);
    this.Acv.AcF = null;
    this.Acv.notifyDataSetChanged();
    AppMethodBeat.o(291585);
  }
  
  private final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291575);
    Object localObject1 = new JSONObject();
    Object localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
    ((JSONObject)localObject1).put("searchsessionid", com.tencent.mm.plugin.finder.report.n.dPC());
    ((JSONObject)localObject1).put("searchscene", paramInt1);
    ((JSONObject)localObject1).put("keyword", this.query);
    ((JSONObject)localObject1).put("expose_suggestword", dRk());
    localObject1 = ((JSONObject)localObject1).toString();
    p.j(localObject1, "JSONObject().apply {\n   …s())\n        }.toString()");
    localObject2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
    localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.activity);
    if (localObject1 != null) {}
    for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
    {
      com.tencent.mm.plugin.finder.report.n.b(paramInt2, "suggestword_panel", (String)localObject2, (bid)localObject1);
      AppMethodBeat.o(291575);
      return;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(291579);
    p.k(paramb, "listener");
    this.Acz = paramb;
    AppMethodBeat.o(291579);
  }
  
  public final void aEq(String paramString)
  {
    AppMethodBeat.i(291578);
    p.k(paramString, "text");
    this.Acx = paramString;
    AppMethodBeat.o(291578);
  }
  
  public final void dRj()
  {
    AppMethodBeat.i(291580);
    Log.i("Finder.SearchSuggestion", "ignore searchSuggestionContent");
    this.Acx = "";
    this.lastBuffer = null;
    dRn();
    dRl();
    AppMethodBeat.o(291580);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(291576);
    h.aGY().b(6200, (i)this);
    AppMethodBeat.o(291576);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(291577);
    h.aGY().a(6200, (i)this);
    AppMethodBeat.o(291577);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(291583);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof dd)) {
        break label211;
      }
    }
    label195:
    label204:
    label211:
    for (paramString = null;; paramString = paramq)
    {
      paramq = (dd)paramString;
      if (paramq != null)
      {
        paramString = paramq.rr.bhX();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchSuggestRequest");
          AppMethodBeat.o(291583);
          throw paramString;
        }
      }
      for (paramString = ((bit)paramString).query;; paramString = null)
      {
        Log.i("Finder.SearchSuggestion", "query: " + this.query + " scene query:" + paramString);
        if ((Util.isNullOrNil(this.query)) || (!Util.isEqual(this.query, paramString))) {
          break label204;
        }
        paramString = localObject;
        if (paramq == null) {
          break label195;
        }
        paramString = paramq.rr.bhY();
        if (paramString != null) {
          break;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchSuggestResponse");
        AppMethodBeat.o(291583);
        throw paramString;
      }
      paramString = ((biu)paramString).STb;
      p.j(paramString, "(this.rr.responseProtoBu…hSuggestResponse).suggest");
      this.Acw = paramString;
      dRm();
      AppMethodBeat.o(291583);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "", "onVisibleChange", "", "visibility", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void MJ(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;)V", "matchSuggestionSpans", "", "Landroid/text/SpannableString;", "getMatchSuggestionSpans", "()Ljava/util/List;", "setMatchSuggestionSpans", "(Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends BaseAdapter
  {
    List<? extends SpannableString> AcF;
    
    public final int getCount()
    {
      AppMethodBeat.i(289767);
      List localList = this.AcF;
      if (localList != null)
      {
        int i = localList.size();
        AppMethodBeat.o(289767);
        return i;
      }
      AppMethodBeat.o(289767);
      return 0;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(289766);
      Object localObject = this.AcF;
      if (localObject != null) {}
      for (localObject = (SpannableString)((List)localObject).get(paramInt);; localObject = null)
      {
        if (localObject == null) {
          p.iCn();
        }
        AppMethodBeat.o(289766);
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
      AppMethodBeat.i(289765);
      int i;
      Object localObject;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext());
        if (this.AcD.Acc) {
          if (this.AcD.zEV)
          {
            i = b.g.finder_full_search_suggestion_item_night_mode;
            paramView = paramView.inflate(i, paramViewGroup, false);
            paramViewGroup = new k.d(this.AcD);
            localObject = paramView.findViewById(b.f.content_tv);
            p.j(localObject, "contentView.findViewById(R.id.content_tv)");
            localObject = (TextView)localObject;
            p.k(localObject, "<set-?>");
            paramViewGroup.jlh = ((TextView)localObject);
            localObject = paramView.findViewById(b.f.suggestion_iv);
            p.j(localObject, "contentView.findViewById(R.id.suggestion_iv)");
            localObject = (ImageView)localObject;
            p.k(localObject, "<set-?>");
            paramViewGroup.AcG = ((ImageView)localObject);
            p.j(paramView, "contentView");
            paramView.setTag(paramViewGroup);
            label156:
            localObject = paramViewGroup.jlh;
            if (localObject == null) {
              p.bGy("contentTV");
            }
            paramViewGroup = this.AcF;
            if (paramViewGroup == null) {
              break label307;
            }
            i = j;
            if (paramInt < paramViewGroup.size()) {
              i = 1;
            }
            if (i == 0) {
              break label302;
            }
            label203:
            if (paramViewGroup == null) {
              break label307;
            }
          }
        }
      }
      label302:
      label307:
      for (paramViewGroup = (SpannableString)paramViewGroup.get(paramInt);; paramViewGroup = null)
      {
        ((TextView)localObject).setText((CharSequence)paramViewGroup);
        AppMethodBeat.o(289765);
        return paramView;
        i = b.g.finder_full_search_suggestion_item;
        break;
        if (this.AcD.zEV)
        {
          i = b.g.finder_search_suggestion_item_night_mode;
          break;
        }
        i = b.g.finder_search_suggestion_item;
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchSuggestionManager.SuggestionItemHolder");
          AppMethodBeat.o(289765);
          throw paramView;
        }
        paramViewGroup = (k.d)paramViewGroup;
        break label156;
        paramViewGroup = null;
        break label203;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$SuggestionItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "suggestionIv", "Landroid/widget/ImageView;", "getSuggestionIv", "()Landroid/widget/ImageView;", "setSuggestionIv", "(Landroid/widget/ImageView;)V", "plugin-finder_release"})
  public final class d
  {
    public ImageView AcG;
    public TextView jlh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$dismissSuggestion$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(278663);
      Log.i("Finder.SearchSuggestion", "onAnimationCancel");
      AppMethodBeat.o(278663);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(278662);
      Log.i("Finder.SearchSuggestion", "onAnimationEnd");
      k.a(this.AcD).setVisibility(8);
      AppMethodBeat.o(278662);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(278661);
      Log.i("Finder.SearchSuggestion", "onAnimationRepeat");
      AppMethodBeat.o(278661);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(278664);
      Log.i("Finder.SearchSuggestion", "onAnimationStart");
      AppMethodBeat.o(278664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.k
 * JD-Core Version:    0.7.0.1
 */