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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ay;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHotWordClickListener", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function3;)V", "container", "Landroid/widget/LinearLayout;", "contentList", "Landroid/widget/ListView;", "header", "Landroid/widget/TextView;", "hintGap", "hotWordDataList", "hotWordNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "hotWordsAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "textAvailableWidth", "dismissPopularList", "getHotWord", "position", "getTextAvailableWidth", "isShowing", "", "onCreate", "onDestroy", "onHotWordsChange", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportExpose", "request", "resetBgColor", "showInner", "showPopularList", "refreshUi", "Companion", "HotWordItemHolder", "PopularDataManager", "PopularListAdapter", "plugin-finder_release"})
public final class h
  implements com.tencent.mm.an.i
{
  public static final a AbN;
  private int AbG;
  private int AbH;
  public cu AbI;
  private TextView AbJ;
  private ListView AbK;
  private d AbL;
  public List<? extends bio> AbM;
  public MMActivity activity;
  public LinearLayout wSF;
  private bil xet;
  
  static
  {
    AppMethodBeat.i(289709);
    AbN = new a((byte)0);
    AppMethodBeat.o(289709);
  }
  
  public h(final MMActivity paramMMActivity, final kotlin.g.a.q<? super bio, ? super Integer, ? super List<? extends bio>, x> paramq)
  {
    AppMethodBeat.i(289708);
    this.activity = paramMMActivity;
    View localView = paramMMActivity.findViewById(b.f.finder_popular_list_container);
    p.j(localView, "activity.findViewById(R.…r_popular_list_container)");
    this.wSF = ((LinearLayout)localView);
    localView = paramMMActivity.findViewById(b.f.finder_popular_list_header);
    p.j(localView, "activity.findViewById(R.…nder_popular_list_header)");
    this.AbJ = ((TextView)localView);
    localView = paramMMActivity.findViewById(b.f.finder_popular_list_content);
    p.j(localView, "activity.findViewById(R.…der_popular_list_content)");
    this.AbK = ((ListView)localView);
    this.AbL = new d();
    this.AbK.setAdapter((ListAdapter)this.AbL);
    this.AbK.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(286121);
        Object localObject1 = new b();
        ((b)localObject1).bn(paramAnonymousAdapterView);
        ((b)localObject1).bn(paramAnonymousView);
        ((b)localObject1).sg(paramAnonymousInt);
        ((b)localObject1).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderPopularListLogic$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).aFi());
        paramAnonymousAdapterView = h.b(this.AbO);
        int i;
        if (paramAnonymousAdapterView != null) {
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.size()))
          {
            i = 1;
            if (i == 0) {
              break label225;
            }
            label90:
            if (paramAnonymousAdapterView == null) {
              break label230;
            }
            paramAnonymousAdapterView = (bio)paramAnonymousAdapterView.get(paramAnonymousInt);
            label105:
            if (paramAnonymousAdapterView != null)
            {
              paramAnonymousView = com.tencent.mm.plugin.finder.report.n.zWF;
              paramAnonymousView = paramAnonymousAdapterView.SSO;
              if (paramAnonymousView != null) {
                break label244;
              }
              paramAnonymousView = "";
            }
          }
        }
        label225:
        label230:
        label244:
        for (;;)
        {
          localObject1 = paramAnonymousAdapterView.SSQ;
          if (localObject1 == null) {
            localObject1 = "";
          }
          for (;;)
          {
            Object localObject2 = aj.Bnu;
            localObject2 = aj.a.fZ((Context)paramMMActivity);
            if (localObject2 != null) {}
            for (localObject2 = ((aj)localObject2).ekY();; localObject2 = null)
            {
              com.tencent.mm.plugin.finder.report.n.a(paramAnonymousView, (String)localObject1, paramAnonymousInt, 2, (bid)localObject2);
              paramq.c(paramAnonymousAdapterView, Integer.valueOf(paramAnonymousInt), h.b(this.AbO));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderPopularListLogic$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(286121);
              return;
              i = 0;
              break;
              paramAnonymousAdapterView = null;
              break label90;
              paramAnonymousAdapterView = null;
              break label105;
            }
          }
        }
      }
    });
    this.wSF.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(291088);
        this.mpU.hideVKB();
        AppMethodBeat.o(291088);
        return false;
      }
    });
    this.AbG = (ay.au((Context)this.activity).x - com.tencent.mm.ci.a.aY((Context)this.activity, b.d.Edge_7A));
    this.AbH = com.tencent.mm.ci.a.aY((Context)paramMMActivity, b.d.Edge_1_5_A);
    dQU();
    AppMethodBeat.o(289708);
  }
  
  private final bio PX(int paramInt)
  {
    AppMethodBeat.i(289704);
    Object localObject = this.AbM;
    if (localObject != null)
    {
      int i;
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        i = 1;
        if (i == 0) {
          break label61;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label66;
        }
        localObject = (bio)((List)localObject).get(paramInt);
        AppMethodBeat.o(289704);
        return localObject;
        i = 0;
        break;
        label61:
        localObject = null;
      }
    }
    label66:
    AppMethodBeat.o(289704);
    return null;
  }
  
  public final void cBa()
  {
    AppMethodBeat.i(289703);
    int i = this.AbK.getFirstVisiblePosition();
    int j = this.AbK.getLastVisiblePosition();
    Object localObject1;
    String str;
    label61:
    Object localObject2;
    if (i <= j)
    {
      localObject1 = PX(i);
      if (localObject1 != null)
      {
        str = ((bio)localObject1).SSO;
        if (str == null) {
          break label134;
        }
        str = kotlin.n.n.l(str, ",", "$", false);
        localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = ((bio)localObject1).SSQ;
        if (localObject1 != null) {
          break label152;
        }
        localObject1 = "";
      }
    }
    label134:
    label145:
    label152:
    for (;;)
    {
      localObject2 = aj.Bnu;
      localObject2 = aj.a.fZ((Context)this.activity);
      if (localObject2 != null) {}
      for (localObject2 = ((aj)localObject2).ekY();; localObject2 = null)
      {
        com.tencent.mm.plugin.finder.report.n.a(str, (String)localObject1, i, 1, (bid)localObject2);
        if (i == j) {
          break label145;
        }
        i += 1;
        break;
        str = null;
        break label61;
      }
      AppMethodBeat.o(289703);
      return;
    }
  }
  
  public final void dQU()
  {
    AppMethodBeat.i(289701);
    if ((this.wSF.getParent() instanceof ViewGroup))
    {
      Object localObject = this.wSF.getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(289701);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setBackgroundColor(this.activity.getResources().getColor(b.c.BW_93));
    }
    AppMethodBeat.o(289701);
  }
  
  public final void eH(List<? extends bio> paramList)
  {
    AppMethodBeat.i(289706);
    Object localObject = c.AbX;
    c.PY(cm.bfF());
    this.AbM = paramList;
    localObject = new StringBuilder("onHotWordsChange : ").append(paramList).append(" size: ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      Log.i("Finder.FinderPopularListLogic", i);
      if (paramList != null) {
        break;
      }
      this.wSF.setVisibility(8);
      AppMethodBeat.o(289706);
      return;
    }
    if (paramList.isEmpty())
    {
      this.wSF.setVisibility(8);
      this.AbL.notifyDataSetChanged();
      AppMethodBeat.o(289706);
      return;
    }
    this.wSF.setVisibility(0);
    this.AbL.notifyDataSetChanged();
    AppMethodBeat.o(289706);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(289707);
    LinkedList localLinkedList;
    TextView localTextView;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cu)))
    {
      paramString = new StringBuilder("onSceneEnd getHotWords : ");
      localLinkedList = ((cu)paramq).dpg();
      if (localLinkedList == null) {
        break label205;
      }
      paramInt1 = localLinkedList.size();
      Log.i("Finder.FinderPopularListLogic", paramInt1 + ' ');
      localLinkedList = ((cu)paramq).dpg();
      a.aN(localLinkedList);
      localTextView = this.AbJ;
      paramString = ((cu)paramq).xet;
      if (paramString == null) {
        break label210;
      }
      paramString = paramString.SSN;
      label112:
      if (paramString == null) {
        break label215;
      }
    }
    label205:
    label210:
    label215:
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)this.activity.getResources().getString(b.j.finder_search_popular_list_title))
    {
      localTextView.setText(paramString);
      eH((List)localLinkedList);
      paramString = c.AbX;
      paramString = localLinkedList;
      if (localLinkedList == null) {
        paramString = new LinkedList();
      }
      p.k(paramString, "hotWords");
      c.aO(paramString);
      com.tencent.e.h.ZvG.be((Runnable)h.c.a.AbY);
      this.xet = ((cu)paramq).xet;
      cBa();
      AppMethodBeat.o(289707);
      return;
      paramInt1 = -1;
      break;
      paramString = null;
      break label112;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$Companion;", "", "()V", "ACTION_TYPE_SEARCH", "", "START_REQUEST_UP_LIMIT", "TAG", "", "UI_UPDATE_LIMIT", "filterHotWords", "", "hotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "plugin-finder_release"})
  public static final class a
  {
    public static void aN(LinkedList<bio> paramLinkedList)
    {
      AppMethodBeat.i(279855);
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.iterator();
        p.j(paramLinkedList, "hotWords.iterator()");
        while (paramLinkedList.hasNext())
        {
          Object localObject = paramLinkedList.next();
          p.j(localObject, "iterator.next()");
          if (((bio)localObject).actionType != 1) {
            paramLinkedList.remove();
          }
        }
      }
      AppMethodBeat.o(279855);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "setHintText", "(Landroid/widget/TextView;)V", "lastLineDivider", "getLastLineDivider", "setLastLineDivider", "lastLineText", "getLastLineText", "setLastLineText", "text", "getText", "setText", "plugin-finder_release"})
  public final class b
  {
    public TextView AbQ;
    public TextView AbR;
    public View AbS;
    public View olM;
    public TextView sYQ;
    
    public final TextView cYr()
    {
      AppMethodBeat.i(285274);
      TextView localTextView = this.sYQ;
      if (localTextView == null) {
        p.bGy("text");
      }
      AppMethodBeat.o(285274);
      return localTextView;
    }
    
    public final TextView dQV()
    {
      AppMethodBeat.i(285275);
      TextView localTextView = this.AbQ;
      if (localTextView == null) {
        p.bGy("lastLineText");
      }
      AppMethodBeat.o(285275);
      return localTextView;
    }
    
    public final TextView dQW()
    {
      AppMethodBeat.i(285276);
      TextView localTextView = this.AbR;
      if (localTextView == null) {
        p.bGy("hintText");
      }
      AppMethodBeat.o(285276);
      return localTextView;
    }
    
    public final View dQX()
    {
      AppMethodBeat.i(285277);
      View localView = this.olM;
      if (localView == null) {
        p.bGy("dividerView");
      }
      AppMethodBeat.o(285277);
      return localView;
    }
    
    public final View dQY()
    {
      AppMethodBeat.i(285278);
      View localView = this.AbS;
      if (localView == null) {
        p.bGy("lastLineDivider");
      }
      AppMethodBeat.o(285278);
      return localView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularDataManager;", "", "()V", "FILE_NAME", "", "INVALID_TIME_LIMIT", "", "TAG", "isLoadFromFile", "", "lastUpdateListTime", "getLastUpdateListTime", "()I", "setLastUpdateListTime", "(I)V", "popularHistory", "Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "getPopularHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "setPopularHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;)V", "startRequestTime", "getStartRequestTime", "setStartRequestTime", "getHotWords", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "isHistoryValid", "isShouldUpdateUi", "readFromFile", "", "saveToFile", "hotWords", "Ljava/util/LinkedList;", "setHotWords", "plugin-finder_release"})
  public static final class c
  {
    private static boolean AbT;
    private static int AbU;
    private static int AbV;
    private static bgt AbW;
    public static final c AbX;
    
    static
    {
      AppMethodBeat.i(280103);
      AbX = new c();
      AppMethodBeat.o(280103);
    }
    
    public static void PY(int paramInt)
    {
      AbU = paramInt;
    }
    
    public static void PZ(int paramInt)
    {
      AbV = paramInt;
    }
    
    static void aO(LinkedList<bio> paramLinkedList)
    {
      AppMethodBeat.i(280102);
      bgt localbgt = new bgt();
      localbgt.SRt = paramLinkedList;
      localbgt.lastUpdateTime = cm.bfF();
      AbW = localbgt;
      AppMethodBeat.o(280102);
    }
    
    public static int dQZ()
    {
      return AbV;
    }
    
    public static bgt dRa()
    {
      return AbW;
    }
    
    public static List<bio> dRb()
    {
      AppMethodBeat.i(280101);
      Object localObject2;
      if ((AbW == null) && (!AbT))
      {
        if (AbW == null) {
          AbW = new bgt();
        }
        localObject1 = new StringBuilder();
        localObject2 = av.AJz;
        localObject1 = u.aY(av.egs() + "popular.info", 0, -1);
      }
      try
      {
        localObject2 = AbW;
        if (localObject2 != null) {
          ((bgt)localObject2).parseFrom((byte[])localObject1);
        }
        Log.i("Finder.PopularDataManager", "read from File");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Finder.PopularDataManager", (Throwable)localException, "", new Object[0]);
          continue;
          boolean bool = false;
          continue;
          Log.i("Finder.PopularDataManager", "isValid: false");
          bool = false;
        }
        label234:
        AppMethodBeat.o(280101);
      }
      AbT = true;
      Object localObject1 = AbW;
      if (localObject1 != null)
      {
        localObject2 = AbW;
        if (localObject2 != null) {
          if ((cm.bfF() - ((bgt)localObject2).lastUpdateTime < 480L) && (((bgt)localObject2).SRt.size() > 0))
          {
            bool = true;
            Log.i("Finder.PopularDataManager", "cur: " + cm.bfF() + "  lastUpdateTime : " + ((bgt)localObject2).lastUpdateTime + " isValid: " + bool);
            if (!bool) {
              break label234;
            }
            localObject1 = (List)((bgt)localObject1).SRt;
            AppMethodBeat.o(280101);
            return localObject1;
          }
        }
      }
      return null;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a AbY;
      
      static
      {
        AppMethodBeat.i(274356);
        AbY = new a();
        AppMethodBeat.o(274356);
      }
      
      public final void run()
      {
        AppMethodBeat.i(274355);
        Object localObject1 = new StringBuilder();
        Object localObject2 = av.AJz;
        localObject2 = av.egs() + "popular.info";
        com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject2);
        localObject1 = h.c.AbX;
        localObject1 = h.c.dRa();
        if (localObject1 != null) {}
        for (localObject1 = ((bgt)localObject1).toByteArray();; localObject1 = null)
        {
          if (!u.agG(String.valueOf(localq.ifB()))) {
            u.bBD(String.valueOf(localq.ifB()));
          }
          u.H((String)localObject2, (byte[])localObject1);
          AppMethodBeat.o(274355);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setHotWord", "", "holder", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "hotWordText", "", "recommendReason", "setItemBg", "contentView", "plugin-finder_release"})
  public final class d
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(287610);
      List localList = h.b(this.AbO);
      if (localList != null)
      {
        int i = localList.size();
        AppMethodBeat.o(287610);
        return i;
      }
      AppMethodBeat.o(287610);
      return 0;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(287608);
      Object localObject = h.b(this.AbO);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((List)localObject).get(paramInt);
      AppMethodBeat.o(287608);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(287607);
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.finder_popular_item, paramViewGroup, false);
        paramViewGroup = new h.b(this.AbO);
        localObject1 = paramView.findViewById(b.f.finder_hot_word_text);
        p.j(localObject1, "contentView.findViewById….id.finder_hot_word_text)");
        localObject1 = (TextView)localObject1;
        p.k(localObject1, "<set-?>");
        paramViewGroup.sYQ = ((TextView)localObject1);
        localObject1 = paramView.findViewById(b.f.finder_hot_word_last_line);
        p.j(localObject1, "contentView.findViewById…inder_hot_word_last_line)");
        localObject1 = (TextView)localObject1;
        p.k(localObject1, "<set-?>");
        paramViewGroup.AbQ = ((TextView)localObject1);
        localObject1 = paramView.findViewById(b.f.hint);
        p.j(localObject1, "contentView.findViewById(R.id.hint)");
        localObject1 = (TextView)localObject1;
        p.k(localObject1, "<set-?>");
        paramViewGroup.AbR = ((TextView)localObject1);
        localObject1 = paramView.findViewById(b.f.divider_view);
        p.j(localObject1, "contentView.findViewById(R.id.divider_view)");
        p.k(localObject1, "<set-?>");
        paramViewGroup.olM = ((View)localObject1);
        localObject1 = paramView.findViewById(b.f.finder_last_line_divider);
        p.j(localObject1, "contentView.findViewById…finder_last_line_divider)");
        p.k(localObject1, "<set-?>");
        paramViewGroup.AbS = ((View)localObject1);
        p.j(paramView, "contentView");
        paramView.setTag(paramViewGroup);
        localObject1 = h.b(this.AbO);
        if (localObject1 == null) {
          p.iCn();
        }
        localObject2 = ((bio)((List)localObject1).get(paramInt)).SSO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = h.b(this.AbO);
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((bio)((List)localObject2).get(paramInt)).SSQ;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label437;
        }
        paramViewGroup.cYr().setVisibility(0);
        paramViewGroup.cYr().setText((CharSequence)localObject1);
        paramViewGroup.dQV().setVisibility(8);
        paramViewGroup.dQW().setVisibility(8);
      }
      label364:
      int j;
      label396:
      label437:
      Object localObject3;
      int k;
      for (;;)
      {
        if (paramInt == getCount() - 1)
        {
          paramViewGroup.dQX().setVisibility(4);
          if (getCount() != 1) {
            break label896;
          }
          if (paramInt == 0) {
            paramView.setBackground(h.c(this.AbO).getResources().getDrawable(b.e.popular_list_bg));
          }
          AppMethodBeat.o(287607);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderPopularListLogic.HotWordItemHolder");
            AppMethodBeat.o(287607);
            throw paramView;
          }
          paramViewGroup = (h.b)paramViewGroup;
          break;
          j = h.d(this.AbO);
          localObject3 = new StaticLayout((CharSequence)localObject1, 0, ((String)localObject1).length(), paramViewGroup.cYr().getPaint(), j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
          if (((StaticLayout)localObject3).getLineCount() > 0)
          {
            k = ((StaticLayout)localObject3).getLineCount();
            ((StaticLayout)localObject3).getLineEnd(0);
            if (k <= 1) {
              break label987;
            }
          }
        }
      }
      label896:
      label987:
      for (int i = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 2);; i = 0)
      {
        int m = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 1);
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(287607);
          throw paramView;
        }
        localObject3 = ((String)localObject1).substring(i, m);
        p.j(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.i("Finder.FinderPopularListLogic", "lastLineText :".concat(String.valueOf(localObject3)));
        Object localObject4 = paramViewGroup.dQV().getPaint();
        float f1;
        if (localObject4 != null)
        {
          f1 = ((TextPaint)localObject4).measureText((String)localObject3, 0, ((String)localObject3).length());
          label625:
          localObject4 = paramViewGroup.dQW().getPaint();
          if (localObject4 == null) {
            break label750;
          }
        }
        label750:
        for (float f2 = ((TextPaint)localObject4).measureText((String)localObject2);; f2 = 0.0F)
        {
          Log.i("Finder.FinderPopularListLogic", "推荐原因不在同一行");
          paramViewGroup.dQW().setVisibility(0);
          if (f1 + f2 + h.e(this.AbO) <= j) {
            break label756;
          }
          paramViewGroup.cYr().setText((CharSequence)localObject1);
          localObject1 = paramViewGroup.dQV();
          ((TextView)localObject1).setText((CharSequence)"");
          ((TextView)localObject1).setVisibility(4);
          paramViewGroup.dQY().setVisibility(8);
          paramViewGroup.dQW().setText((CharSequence)localObject2);
          break;
          f1 = 0.0F;
          break label625;
        }
        label756:
        Log.i("Finder.FinderPopularListLogic", "推荐原因在同一行");
        if (k == 1) {
          paramViewGroup.cYr().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = paramViewGroup.dQV();
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)localObject3);
          paramViewGroup.dQY().setVisibility(0);
          paramViewGroup.dQW().setText((CharSequence)localObject2);
          break;
          localObject4 = paramViewGroup.cYr();
          if (localObject1 == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(287607);
            throw paramView;
          }
          localObject1 = ((String)localObject1).substring(0, i);
          p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        paramViewGroup.dQX().setVisibility(0);
        break label364;
        if (getCount() <= 1) {
          break label396;
        }
        if (paramInt == 0)
        {
          paramView.setBackground(h.c(this.AbO).getResources().getDrawable(b.e.popular_list_up_bg));
          break label396;
        }
        if (paramInt == getCount() - 1)
        {
          paramView.setBackground(h.c(this.AbO).getResources().getDrawable(b.e.popular_list_down_bg));
          break label396;
        }
        paramView.setBackgroundColor(h.c(this.AbO).getResources().getColor(b.c.white));
        break label396;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */