package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.dw;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bg;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHotWordClickListener", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function3;)V", "container", "Landroid/widget/LinearLayout;", "contentList", "Landroid/widget/ListView;", "header", "Landroid/widget/TextView;", "hintGap", "hotWordDataList", "hotWordNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "hotWordsAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "textAvailableWidth", "dismissPopularList", "getHotWord", "position", "getTextAvailableWidth", "isShowing", "", "onCreate", "onDestroy", "onHotWordsChange", "isFromScene", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportExpose", "request", "resetBgColor", "showInner", "showPopularList", "refreshUi", "Companion", "HotWordItemHolder", "PopularDataManager", "PopularListAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.am.h
{
  public static final a FxD;
  private buu ADG;
  public LinearLayout Api;
  private int FxE;
  private int FxF;
  public dw FxG;
  private TextView FxH;
  private ListView FxI;
  private d FxJ;
  public List<? extends bux> FxK;
  public MMActivity activity;
  
  static
  {
    AppMethodBeat.i(342802);
    FxD = new a((byte)0);
    AppMethodBeat.o(342802);
  }
  
  public i(MMActivity paramMMActivity, q<? super bux, ? super Integer, ? super List<? extends bux>, ah> paramq)
  {
    AppMethodBeat.i(342747);
    this.activity = paramMMActivity;
    View localView = paramMMActivity.findViewById(e.e.finder_popular_list_container);
    s.s(localView, "activity.findViewById(R.…r_popular_list_container)");
    this.Api = ((LinearLayout)localView);
    localView = paramMMActivity.findViewById(e.e.finder_popular_list_header);
    s.s(localView, "activity.findViewById(R.…nder_popular_list_header)");
    this.FxH = ((TextView)localView);
    localView = paramMMActivity.findViewById(e.e.finder_popular_list_content);
    s.s(localView, "activity.findViewById(R.…der_popular_list_content)");
    this.FxI = ((ListView)localView);
    this.FxJ = new d();
    this.FxI.setAdapter((ListAdapter)this.FxJ);
    this.FxI.setOnItemClickListener(new i..ExternalSyntheticLambda1(this, paramMMActivity, paramq));
    this.Api.setOnTouchListener(new i..ExternalSyntheticLambda0(paramMMActivity));
    this.FxE = (bg.bf((Context)this.activity).x - com.tencent.mm.cd.a.br((Context)this.activity, e.c.Edge_7A));
    this.FxF = com.tencent.mm.cd.a.br((Context)paramMMActivity, e.c.Edge_1_5_A);
    eOV();
    AppMethodBeat.o(342747);
  }
  
  private final bux Tf(int paramInt)
  {
    AppMethodBeat.i(342753);
    Object localObject = this.FxK;
    if (localObject == null)
    {
      AppMethodBeat.o(342753);
      return null;
    }
    int i;
    if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label62;
      }
      AppMethodBeat.o(342753);
      return null;
      i = 0;
      break;
      label57:
      localObject = null;
    }
    label62:
    localObject = (bux)((List)localObject).get(paramInt);
    AppMethodBeat.o(342753);
    return localObject;
  }
  
  private static final void a(i parami, MMActivity paramMMActivity, q paramq, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(342773);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(parami);
    ((b)localObject2).cH(paramMMActivity);
    ((b)localObject2).cH(paramq);
    ((b)localObject2).cH(paramAdapterView);
    ((b)localObject2).cH(paramView);
    ((b)localObject2).sc(paramInt);
    ((b)localObject2).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderPopularListLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject1, ((b)localObject2).aYj());
    s.u(parami, "this$0");
    s.u(paramMMActivity, "$activity");
    s.u(paramq, "$onHotWordClickListener");
    paramAdapterView = parami.FxK;
    String str;
    if (paramAdapterView == null)
    {
      paramAdapterView = null;
      if (paramAdapterView != null)
      {
        str = com.tencent.mm.kernel.h.baE().ban().b(at.a.adcK, "");
        paramView = z.FrZ;
        localObject1 = paramAdapterView.aacq;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject2 = paramAdapterView.aacr;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = as.GSQ;
        paramMMActivity = as.a.hu((Context)paramMMActivity);
        if (paramMMActivity != null) {
          break label333;
        }
      }
    }
    label293:
    label313:
    label318:
    label333:
    for (paramMMActivity = null;; paramMMActivity = paramMMActivity.fou())
    {
      z.a(paramView, (String)localObject1, paramInt, 2, paramMMActivity, d.hF(paramAdapterView.aacs), str);
      paramq.invoke(paramAdapterView, Integer.valueOf(paramInt), parami.FxK);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderPopularListLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(342773);
      return;
      int i;
      if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
      {
        i = 1;
        if (i == 0) {
          break label313;
        }
      }
      for (;;)
      {
        if (paramAdapterView != null) {
          break label318;
        }
        paramAdapterView = null;
        break;
        i = 0;
        break label293;
        paramAdapterView = null;
      }
      paramAdapterView = (bux)paramAdapterView.get(paramInt);
      break;
    }
  }
  
  private static final boolean b(MMActivity paramMMActivity, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342779);
    s.u(paramMMActivity, "$activity");
    paramMMActivity.hideVKB();
    AppMethodBeat.o(342779);
    return false;
  }
  
  public final void def()
  {
    AppMethodBeat.i(342827);
    int i = this.FxI.getFirstVisiblePosition();
    int j = this.FxI.getLastVisiblePosition();
    if (i <= j) {}
    for (;;)
    {
      bux localbux = Tf(i);
      String str2;
      String str1;
      Object localObject1;
      if (localbux != null)
      {
        str2 = com.tencent.mm.kernel.h.baE().ban().b(at.a.adcK, "");
        str1 = localbux.aacq;
        if (str1 != null) {
          break label151;
        }
        str1 = null;
        localObject1 = z.FrZ;
        localObject2 = localbux.aacr;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = as.GSQ;
        localObject2 = as.a.hu((Context)this.activity);
        if (localObject2 != null) {
          break label166;
        }
      }
      label151:
      label166:
      for (Object localObject2 = null;; localObject2 = ((as)localObject2).fou())
      {
        z.a(str1, (String)localObject1, i, 1, (bui)localObject2, d.hF(localbux.aacs), str2);
        if (i != j) {
          break label176;
        }
        AppMethodBeat.o(342827);
        return;
        str1 = n.m(str1, ",", "$", false);
        break;
      }
      label176:
      i += 1;
    }
  }
  
  public final void eOV()
  {
    AppMethodBeat.i(342820);
    if ((this.Api.getParent() instanceof ViewGroup))
    {
      Object localObject = this.Api.getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(342820);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setBackgroundColor(this.activity.getResources().getColor(e.b.BW_93));
    }
    AppMethodBeat.o(342820);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(342836);
    LinkedList localLinkedList;
    TextView localTextView;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof dw)))
    {
      paramString = new StringBuilder("onSceneEnd getHotWords : ");
      localLinkedList = ((dw)paramp).dWH();
      if (localLinkedList != null) {
        break label189;
      }
      paramInt1 = -1;
      Log.i("Finder.FinderPopularListLogic", paramInt1 + ' ');
      localLinkedList = ((dw)paramp).dWH();
      a.aU(localLinkedList);
      localTextView = this.FxH;
      paramString = ((dw)paramp).ADG;
      if (paramString != null) {
        break label198;
      }
      paramString = null;
      label105:
      if (paramString != null) {
        break label206;
      }
    }
    label189:
    label198:
    label206:
    for (paramString = (CharSequence)this.activity.getResources().getString(e.h.finder_search_popular_list_title);; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      q((List)localLinkedList, true);
      paramString = c.FxP;
      paramString = localLinkedList;
      if (localLinkedList == null) {
        paramString = new LinkedList();
      }
      c.aV(paramString);
      this.ADG = ((dw)paramp).ADG;
      def();
      AppMethodBeat.o(342836);
      return;
      paramInt1 = localLinkedList.size();
      break;
      paramString = paramString.aacp;
      break label105;
    }
  }
  
  public final void q(List<? extends bux> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(342834);
    Object localObject = c.FxP;
    c.Tg(cn.getSyncServerTimeSecond());
    if (paramBoolean) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcK, UUID.randomUUID().toString());
    }
    this.FxK = paramList;
    localObject = new StringBuilder("onHotWordsChange : ").append(paramList).append(" size: ");
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      Log.i("Finder.FinderPopularListLogic", i);
      if (paramList != null) {
        break;
      }
      this.Api.setVisibility(8);
      AppMethodBeat.o(342834);
      return;
    }
    if (paramList.isEmpty())
    {
      this.Api.setVisibility(8);
      this.FxJ.notifyDataSetChanged();
      AppMethodBeat.o(342834);
      return;
    }
    this.Api.setVisibility(0);
    this.FxJ.notifyDataSetChanged();
    AppMethodBeat.o(342834);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$Companion;", "", "()V", "ACTION_TYPE_SEARCH", "", "START_REQUEST_UP_LIMIT", "TAG", "", "UI_UPDATE_LIMIT", "filterHotWords", "", "hotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void aU(LinkedList<bux> paramLinkedList)
    {
      AppMethodBeat.i(342404);
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.iterator();
        s.s(paramLinkedList, "hotWords.iterator()");
        while (paramLinkedList.hasNext())
        {
          Object localObject = paramLinkedList.next();
          s.s(localObject, "iterator.next()");
          if (((bux)localObject).actionType != 1) {
            paramLinkedList.remove();
          }
        }
      }
      AppMethodBeat.o(342404);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "setHintText", "(Landroid/widget/TextView;)V", "lastLineDivider", "getLastLineDivider", "setLastLineDivider", "lastLineText", "getLastLineText", "setLastLineText", "text", "getText", "setText", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    public TextView FxL;
    public TextView FxM;
    public View FxN;
    public View rpv;
    public TextView wdg;
    
    public b()
    {
      AppMethodBeat.i(342409);
      AppMethodBeat.o(342409);
    }
    
    public final TextView dEJ()
    {
      AppMethodBeat.i(342419);
      TextView localTextView = this.wdg;
      if (localTextView != null)
      {
        AppMethodBeat.o(342419);
        return localTextView;
      }
      s.bIx("text");
      AppMethodBeat.o(342419);
      return null;
    }
    
    public final TextView eOW()
    {
      AppMethodBeat.i(342423);
      TextView localTextView = this.FxL;
      if (localTextView != null)
      {
        AppMethodBeat.o(342423);
        return localTextView;
      }
      s.bIx("lastLineText");
      AppMethodBeat.o(342423);
      return null;
    }
    
    public final TextView eOX()
    {
      AppMethodBeat.i(342434);
      TextView localTextView = this.FxM;
      if (localTextView != null)
      {
        AppMethodBeat.o(342434);
        return localTextView;
      }
      s.bIx("hintText");
      AppMethodBeat.o(342434);
      return null;
    }
    
    public final View eOY()
    {
      AppMethodBeat.i(342444);
      View localView = this.rpv;
      if (localView != null)
      {
        AppMethodBeat.o(342444);
        return localView;
      }
      s.bIx("dividerView");
      AppMethodBeat.o(342444);
      return null;
    }
    
    public final View eOZ()
    {
      AppMethodBeat.i(342455);
      View localView = this.FxN;
      if (localView != null)
      {
        AppMethodBeat.o(342455);
        return localView;
      }
      s.bIx("lastLineDivider");
      AppMethodBeat.o(342455);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularDataManager;", "", "()V", "FILE_NAME", "", "INVALID_TIME_LIMIT", "", "TAG", "isLoadFromFile", "", "lastUpdateListTime", "getLastUpdateListTime", "()I", "setLastUpdateListTime", "(I)V", "popularHistory", "Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "getPopularHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "setPopularHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;)V", "startRequestTime", "getStartRequestTime", "setStartRequestTime", "getHotWords", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "isHistoryValid", "isShouldUpdateUi", "readFromFile", "", "saveToFile", "hotWords", "Ljava/util/LinkedList;", "setHotWords", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final c FxP;
    private static boolean FxQ;
    private static int FxR;
    private static int FxS;
    private static bsl FxT;
    
    static
    {
      AppMethodBeat.i(342445);
      FxP = new c();
      AppMethodBeat.o(342445);
    }
    
    public static void Tg(int paramInt)
    {
      FxR = paramInt;
    }
    
    public static void Th(int paramInt)
    {
      FxS = paramInt;
    }
    
    public static void aV(LinkedList<bux> paramLinkedList)
    {
      AppMethodBeat.i(342432);
      s.u(paramLinkedList, "hotWords");
      bsl localbsl = new bsl();
      localbsl.aaam = paramLinkedList;
      localbsl.lastUpdateTime = cn.getSyncServerTimeSecond();
      FxT = localbsl;
      com.tencent.threadpool.h.ahAA.bm(i.c..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(342432);
    }
    
    public static int ePa()
    {
      return FxS;
    }
    
    public static List<bux> ePb()
    {
      AppMethodBeat.i(342424);
      if ((FxT == null) && (!FxQ))
      {
        if (FxT == null) {
          FxT = new bsl();
        }
        localObject = bm.GlZ;
        localObject = y.bi(s.X(bm.fir(), "popular.info"), 0, -1);
      }
      try
      {
        localbsl = FxT;
        if (localbsl != null) {
          localbsl.parseFrom((byte[])localObject);
        }
        Log.i("Finder.PopularDataManager", "read from File");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bsl localbsl;
          Log.printErrStackTrace("Finder.PopularDataManager", (Throwable)localException, "", new Object[0]);
          continue;
          boolean bool = false;
          continue;
          Log.i("Finder.PopularDataManager", "isValid: false");
          bool = false;
        }
        AppMethodBeat.o(342424);
      }
      FxQ = true;
      Object localObject = FxT;
      if (localObject != null)
      {
        localbsl = FxT;
        if (localbsl != null) {
          if ((cn.getSyncServerTimeSecond() - localbsl.lastUpdateTime < 60L) && (localbsl.aaam.size() > 0))
          {
            bool = true;
            Log.i("Finder.PopularDataManager", "cur: " + cn.getSyncServerTimeSecond() + "  lastUpdateTime : " + localbsl.lastUpdateTime + " isValid: " + bool);
            if (!bool) {
              break label219;
            }
            localObject = (List)((bsl)localObject).aaam;
            AppMethodBeat.o(342424);
            return localObject;
          }
        }
      }
      label219:
      return null;
    }
    
    private static final void ePc()
    {
      AppMethodBeat.i(342438);
      Object localObject = bm.GlZ;
      String str = s.X(bm.fir(), "popular.info");
      u localu = new u(str);
      localObject = FxT;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((bsl)localObject).toByteArray())
      {
        if (!y.ZC(String.valueOf(localu.jKP()))) {
          y.bDX(String.valueOf(localu.jKP()));
        }
        y.f(str, (byte[])localObject, localObject.length);
        AppMethodBeat.o(342438);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setHotWord", "", "holder", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "hotWordText", "", "recommendReason", "setItemBg", "contentView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends BaseAdapter
  {
    public d()
    {
      AppMethodBeat.i(342408);
      AppMethodBeat.o(342408);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(342439);
      List localList = i.b(this.FxO);
      if (localList == null)
      {
        AppMethodBeat.o(342439);
        return 0;
      }
      int i = localList.size();
      AppMethodBeat.o(342439);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(342428);
      Object localObject = i.b(this.FxO);
      s.checkNotNull(localObject);
      localObject = ((List)localObject).get(paramInt);
      AppMethodBeat.o(342428);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(342422);
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        s.checkNotNull(paramViewGroup);
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(e.f.finder_popular_item, paramViewGroup, false);
        paramViewGroup = new i.b(this.FxO);
        localObject1 = paramView.findViewById(e.e.finder_hot_word_text);
        s.s(localObject1, "contentView.findViewById….id.finder_hot_word_text)");
        localObject1 = (TextView)localObject1;
        s.u(localObject1, "<set-?>");
        paramViewGroup.wdg = ((TextView)localObject1);
        localObject1 = paramView.findViewById(e.e.finder_hot_word_last_line);
        s.s(localObject1, "contentView.findViewById…inder_hot_word_last_line)");
        localObject1 = (TextView)localObject1;
        s.u(localObject1, "<set-?>");
        paramViewGroup.FxL = ((TextView)localObject1);
        localObject1 = paramView.findViewById(e.e.hint);
        s.s(localObject1, "contentView.findViewById(R.id.hint)");
        localObject1 = (TextView)localObject1;
        s.u(localObject1, "<set-?>");
        paramViewGroup.FxM = ((TextView)localObject1);
        localObject1 = paramView.findViewById(e.e.divider_view);
        s.s(localObject1, "contentView.findViewById(R.id.divider_view)");
        s.u(localObject1, "<set-?>");
        paramViewGroup.rpv = ((View)localObject1);
        localObject1 = paramView.findViewById(e.e.finder_last_line_divider);
        s.s(localObject1, "contentView.findViewById…finder_last_line_divider)");
        s.u(localObject1, "<set-?>");
        paramViewGroup.FxN = ((View)localObject1);
        paramView.setTag(paramViewGroup);
        localObject1 = i.b(this.FxO);
        s.checkNotNull(localObject1);
        localObject2 = ((bux)((List)localObject1).get(paramInt)).aacq;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = i.b(this.FxO);
        s.checkNotNull(localObject2);
        localObject2 = ((bux)((List)localObject2).get(paramInt)).aacr;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label426;
        }
        paramViewGroup.dEJ().setVisibility(0);
        paramViewGroup.dEJ().setText((CharSequence)localObject1);
        paramViewGroup.eOW().setVisibility(8);
        paramViewGroup.eOX().setVisibility(8);
      }
      label349:
      int j;
      label385:
      label426:
      Object localObject3;
      int k;
      for (;;)
      {
        if (paramInt == getCount() - 1)
        {
          paramViewGroup.eOY().setVisibility(4);
          s.checkNotNull(paramView);
          if (getCount() != 1) {
            break label902;
          }
          if (paramInt == 0) {
            paramView.setBackground(i.c(this.FxO).getResources().getDrawable(e.d.popular_list_bg));
          }
          AppMethodBeat.o(342422);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderPopularListLogic.HotWordItemHolder");
            AppMethodBeat.o(342422);
            throw paramView;
          }
          paramViewGroup = (i.b)paramViewGroup;
          break;
          j = i.d(this.FxO);
          localObject3 = new StaticLayout((CharSequence)localObject1, 0, ((String)localObject1).length(), paramViewGroup.dEJ().getPaint(), j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
          if (((StaticLayout)localObject3).getLineCount() > 0)
          {
            k = ((StaticLayout)localObject3).getLineCount();
            ((StaticLayout)localObject3).getLineEnd(0);
            if (k <= 1) {
              break label993;
            }
          }
        }
      }
      label599:
      label993:
      for (int i = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 2);; i = 0)
      {
        int m = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 1);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(342422);
          throw paramView;
        }
        localObject3 = ((String)localObject1).substring(i, m);
        s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.i("Finder.FinderPopularListLogic", s.X("lastLineText :", localObject3));
        Object localObject4 = paramViewGroup.eOW().getPaint();
        float f1;
        if (localObject4 == null)
        {
          f1 = 0.0F;
          localObject4 = paramViewGroup.eOX().getPaint();
          if (localObject4 != null) {
            break label742;
          }
        }
        label742:
        for (float f2 = 0.0F;; f2 = ((TextPaint)localObject4).measureText((String)localObject2))
        {
          localObject4 = this.FxO;
          Log.i("Finder.FinderPopularListLogic", "推荐原因不在同一行");
          paramViewGroup.eOX().setVisibility(0);
          if (f1 + f2 + i.e((i)localObject4) <= j) {
            break label754;
          }
          paramViewGroup.dEJ().setVisibility(0);
          paramViewGroup.dEJ().setText((CharSequence)localObject1);
          localObject1 = paramViewGroup.eOW();
          ((TextView)localObject1).setText((CharSequence)"");
          ((TextView)localObject1).setVisibility(4);
          paramViewGroup.eOZ().setVisibility(8);
          paramViewGroup.eOX().setText((CharSequence)localObject2);
          break;
          f1 = ((TextPaint)localObject4).measureText((String)localObject3, 0, ((String)localObject3).length());
          break label599;
        }
        label754:
        Log.i("Finder.FinderPopularListLogic", "推荐原因在同一行");
        if (k == 1) {
          paramViewGroup.dEJ().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = paramViewGroup.eOW();
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)localObject3);
          paramViewGroup.eOZ().setVisibility(0);
          paramViewGroup.eOX().setText((CharSequence)localObject2);
          break;
          paramViewGroup.dEJ().setVisibility(0);
          localObject4 = paramViewGroup.dEJ();
          if (localObject1 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(342422);
            throw paramView;
          }
          localObject1 = ((String)localObject1).substring(0, i);
          s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        paramViewGroup.eOY().setVisibility(0);
        break label349;
        if (getCount() <= 1) {
          break label385;
        }
        if (paramInt == 0)
        {
          paramView.setBackground(i.c(this.FxO).getResources().getDrawable(e.d.popular_list_up_bg));
          break label385;
        }
        if (paramInt == getCount() - 1)
        {
          paramView.setBackground(i.c(this.FxO).getResources().getDrawable(e.d.popular_list_down_bg));
          break label385;
        }
        paramView.setBackgroundColor(i.c(this.FxO).getResources().getColor(e.b.white));
        break label385;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.i
 * JD-Core Version:    0.7.0.1
 */