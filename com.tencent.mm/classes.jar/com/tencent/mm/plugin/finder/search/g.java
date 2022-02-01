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
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.cp;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.av;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHotWordClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "container", "Landroid/widget/LinearLayout;", "contentList", "Landroid/widget/ListView;", "header", "Landroid/widget/TextView;", "hintGap", "", "hotWordDataList", "", "hotWordNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "hotWordsAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "textAvailableWidth", "dismissPopularList", "filterHotWords", "hotWords", "Ljava/util/LinkedList;", "getHotWord", "", "position", "getTextAvailableWidth", "isShowing", "", "onCreate", "onDestroy", "onHotWordsChange", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportExpose", "request", "resetBgColor", "showInner", "showPopularList", "refreshUi", "Companion", "HotWordItemHolder", "PopularDataManager", "PopularListAdapter", "plugin-finder_release"})
public final class g
  implements com.tencent.mm.ak.i
{
  public static final a vuP;
  private MMActivity activity;
  LinearLayout tmh;
  private bbv twE;
  private int vuI;
  private int vuJ;
  public cp vuK;
  private TextView vuL;
  private ListView vuM;
  private d vuN;
  private List<? extends bby> vuO;
  
  static
  {
    AppMethodBeat.i(251364);
    vuP = new a((byte)0);
    AppMethodBeat.o(251364);
  }
  
  public g(final MMActivity paramMMActivity, final kotlin.g.a.b<? super bby, x> paramb)
  {
    AppMethodBeat.i(251363);
    this.activity = paramMMActivity;
    View localView = paramMMActivity.findViewById(2131301383);
    p.g(localView, "activity.findViewById(R.…r_popular_list_container)");
    this.tmh = ((LinearLayout)localView);
    localView = paramMMActivity.findViewById(2131301385);
    p.g(localView, "activity.findViewById(R.…nder_popular_list_header)");
    this.vuL = ((TextView)localView);
    localView = paramMMActivity.findViewById(2131301384);
    p.g(localView, "activity.findViewById(R.…der_popular_list_content)");
    this.vuM = ((ListView)localView);
    this.vuN = new d();
    this.vuM.setAdapter((ListAdapter)this.vuN);
    this.vuM.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(251338);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderPopularListLogic$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousAdapterView = g.a(this.vuQ);
        int i;
        if (paramAnonymousAdapterView != null) {
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.size()))
          {
            i = 1;
            if (i == 0) {
              break label197;
            }
            label90:
            if (paramAnonymousAdapterView == null) {
              break label202;
            }
            paramAnonymousAdapterView = (bby)paramAnonymousAdapterView.get(paramAnonymousInt);
            label105:
            if (paramAnonymousAdapterView != null)
            {
              paramAnonymousView = k.vfA;
              paramAnonymousView = paramAnonymousAdapterView.LLa;
              if (paramAnonymousView != null) {
                break label213;
              }
              paramAnonymousView = "";
            }
          }
        }
        label197:
        label202:
        label213:
        for (;;)
        {
          localObject = FinderReporterUIC.wzC;
          localObject = FinderReporterUIC.a.fH((Context)paramMMActivity);
          if (localObject != null) {}
          for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
          {
            k.a(paramAnonymousView, paramAnonymousInt, 2, (bbn)localObject);
            paramb.invoke(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderPopularListLogic$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(251338);
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
    });
    this.tmh.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251339);
        this.nbB.hideVKB();
        AppMethodBeat.o(251339);
        return false;
      }
    });
    this.vuI = (av.az((Context)this.activity).x - com.tencent.mm.cb.a.aG((Context)this.activity, 2131165310));
    this.vuJ = com.tencent.mm.cb.a.aG((Context)paramMMActivity, 2131165289);
    dpI();
    AppMethodBeat.o(251363);
  }
  
  private final String KM(int paramInt)
  {
    AppMethodBeat.i(251356);
    Object localObject = this.vuO;
    if (localObject != null)
    {
      int i;
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        i = 1;
        if (i == 0) {
          break label70;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label75;
        }
        localObject = (bby)((List)localObject).get(paramInt);
        if (localObject == null) {
          break label75;
        }
        localObject = ((bby)localObject).LLa;
        AppMethodBeat.o(251356);
        return localObject;
        i = 0;
        break;
        label70:
        localObject = null;
      }
    }
    label75:
    AppMethodBeat.o(251356);
    return null;
  }
  
  private static void av(LinkedList<bby> paramLinkedList)
  {
    AppMethodBeat.i(251362);
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      p.g(paramLinkedList, "hotWords.iterator()");
      while (paramLinkedList.hasNext())
      {
        Object localObject = paramLinkedList.next();
        p.g(localObject, "iterator.next()");
        if (((bby)localObject).actionType != 1) {
          paramLinkedList.remove();
        }
      }
    }
    AppMethodBeat.o(251362);
  }
  
  private final void eq(List<? extends bby> paramList)
  {
    AppMethodBeat.i(251360);
    Object localObject = c.vuZ;
    c.KN(cl.aWB());
    this.vuO = paramList;
    localObject = new StringBuilder("onHotWordsChange : ").append(paramList).append(" size: ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      Log.i("Finder.FinderPopularListLogic", i);
      if (paramList != null) {
        break;
      }
      this.tmh.setVisibility(8);
      AppMethodBeat.o(251360);
      return;
    }
    if (paramList.isEmpty())
    {
      this.tmh.setVisibility(8);
      this.vuN.notifyDataSetChanged();
      AppMethodBeat.o(251360);
      return;
    }
    this.tmh.setVisibility(0);
    this.vuN.notifyDataSetChanged();
    AppMethodBeat.o(251360);
  }
  
  public final void cnl()
  {
    AppMethodBeat.i(251355);
    int i = this.vuM.getFirstVisiblePosition();
    int j = this.vuM.getLastVisiblePosition();
    if (i <= j)
    {
      String str = KM(i);
      if (str != null)
      {
        localObject = k.vfA;
        localObject = FinderReporterUIC.wzC;
        localObject = FinderReporterUIC.a.fH((Context)this.activity);
        if (localObject == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        k.a(str, i, 1, (bbn)localObject);
        if (i == j) {
          break label92;
        }
        i += 1;
        break;
      }
    }
    label92:
    AppMethodBeat.o(251355);
  }
  
  public final void dpI()
  {
    AppMethodBeat.i(251354);
    if ((this.tmh.getParent() instanceof ViewGroup))
    {
      Object localObject = this.tmh.getParent();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(251354);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setBackgroundColor(this.activity.getResources().getColor(2131099689));
    }
    AppMethodBeat.o(251354);
  }
  
  public final void dpJ()
  {
    AppMethodBeat.i(251358);
    this.tmh.setVisibility(8);
    AppMethodBeat.o(251358);
  }
  
  public final void dpK()
  {
    AppMethodBeat.i(251359);
    Object localObject = c.vuZ;
    localObject = c.dpS();
    if (localObject != null)
    {
      ow(false);
      eq((List)localObject);
      if (localObject != null) {}
    }
    else
    {
      dpJ();
      localObject = x.SXb;
    }
    AppMethodBeat.o(251359);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251353);
    com.tencent.mm.kernel.g.azz().b(4069, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(251353);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(251361);
    LinkedList localLinkedList;
    TextView localTextView;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cp)))
    {
      paramString = new StringBuilder("onSceneEnd getHotWords : ");
      localLinkedList = ((cp)paramq).cZn();
      if (localLinkedList == null) {
        break label205;
      }
      paramInt1 = localLinkedList.size();
      Log.i("Finder.FinderPopularListLogic", paramInt1 + ' ');
      localLinkedList = ((cp)paramq).cZn();
      av(localLinkedList);
      localTextView = this.vuL;
      paramString = ((cp)paramq).twE;
      if (paramString == null) {
        break label210;
      }
      paramString = paramString.LKZ;
      label112:
      if (paramString == null) {
        break label215;
      }
    }
    label205:
    label210:
    label215:
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)this.activity.getResources().getString(2131760525))
    {
      localTextView.setText(paramString);
      eq((List)localLinkedList);
      paramString = c.vuZ;
      paramString = localLinkedList;
      if (localLinkedList == null) {
        paramString = new LinkedList();
      }
      p.h(paramString, "hotWords");
      c.aw(paramString);
      h.RTc.aX((Runnable)g.c.a.vva);
      this.twE = ((cp)paramq).twE;
      cnl();
      AppMethodBeat.o(251361);
      return;
      paramInt1 = -1;
      break;
      paramString = null;
      break label112;
    }
  }
  
  public final boolean ow(boolean paramBoolean)
  {
    AppMethodBeat.i(251357);
    this.tmh.setVisibility(0);
    this.tmh.requestFocus();
    if (paramBoolean) {
      if (this.vuO != null)
      {
        localList = this.vuO;
        if ((localList == null) || (localList.isEmpty() != true)) {}
      }
      else
      {
        dpK();
      }
    }
    List localList = this.vuO;
    if (localList != null)
    {
      paramBoolean = localList.isEmpty();
      AppMethodBeat.o(251357);
      return paramBoolean;
    }
    AppMethodBeat.o(251357);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$Companion;", "", "()V", "ACTION_TYPE_SEARCH", "", "START_REQUEST_UP_LIMIT", "TAG", "", "UI_UPDATE_LIMIT", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "setHintText", "(Landroid/widget/TextView;)V", "lastLineDivider", "getLastLineDivider", "setLastLineDivider", "lastLineText", "getLastLineText", "setLastLineText", "text", "getText", "setText", "plugin-finder_release"})
  public final class b
  {
    public TextView krl;
    public View lrc;
    public TextView vuS;
    public TextView vuT;
    public View vuU;
    
    public final TextView dpL()
    {
      AppMethodBeat.i(251340);
      TextView localTextView = this.krl;
      if (localTextView == null) {
        p.btv("text");
      }
      AppMethodBeat.o(251340);
      return localTextView;
    }
    
    public final TextView dpM()
    {
      AppMethodBeat.i(251341);
      TextView localTextView = this.vuS;
      if (localTextView == null) {
        p.btv("lastLineText");
      }
      AppMethodBeat.o(251341);
      return localTextView;
    }
    
    public final TextView dpN()
    {
      AppMethodBeat.i(251342);
      TextView localTextView = this.vuT;
      if (localTextView == null) {
        p.btv("hintText");
      }
      AppMethodBeat.o(251342);
      return localTextView;
    }
    
    public final View dpO()
    {
      AppMethodBeat.i(251343);
      View localView = this.lrc;
      if (localView == null) {
        p.btv("dividerView");
      }
      AppMethodBeat.o(251343);
      return localView;
    }
    
    public final View dpP()
    {
      AppMethodBeat.i(251344);
      View localView = this.vuU;
      if (localView == null) {
        p.btv("lastLineDivider");
      }
      AppMethodBeat.o(251344);
      return localView;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularDataManager;", "", "()V", "FILE_NAME", "", "INVALID_TIME_LIMIT", "", "TAG", "isLoadFromFile", "", "lastUpdateListTime", "getLastUpdateListTime", "()I", "setLastUpdateListTime", "(I)V", "popularHistory", "Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "getPopularHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;", "setPopularHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderPopularHistory;)V", "startRequestTime", "getStartRequestTime", "setStartRequestTime", "getHotWords", "", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "isHistoryValid", "isShouldUpdateUi", "readFromFile", "", "saveToFile", "hotWords", "Ljava/util/LinkedList;", "setHotWords", "plugin-finder_release"})
  public static final class c
  {
    private static boolean vuV;
    private static int vuW;
    private static int vuX;
    private static bai vuY;
    public static final c vuZ;
    
    static
    {
      AppMethodBeat.i(251349);
      vuZ = new c();
      AppMethodBeat.o(251349);
    }
    
    public static void KN(int paramInt)
    {
      vuW = paramInt;
    }
    
    public static void KO(int paramInt)
    {
      vuX = paramInt;
    }
    
    static void aw(LinkedList<bby> paramLinkedList)
    {
      AppMethodBeat.i(251348);
      bai localbai = new bai();
      localbai.LJY = paramLinkedList;
      localbai.lastUpdateTime = cl.aWB();
      vuY = localbai;
      AppMethodBeat.o(251348);
    }
    
    public static int dpQ()
    {
      return vuX;
    }
    
    public static bai dpR()
    {
      return vuY;
    }
    
    public static List<bby> dpS()
    {
      AppMethodBeat.i(251347);
      Object localObject2;
      if ((vuY == null) && (!vuV))
      {
        if (vuY == null) {
          vuY = new bai();
        }
        localObject1 = new StringBuilder();
        localObject2 = al.waC;
        localObject1 = s.aW(al.dEF() + "popular.info", 0, -1);
      }
      try
      {
        localObject2 = vuY;
        if (localObject2 != null) {
          ((bai)localObject2).parseFrom((byte[])localObject1);
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
        AppMethodBeat.o(251347);
      }
      vuV = true;
      Object localObject1 = vuY;
      if (localObject1 != null)
      {
        localObject2 = vuY;
        if (localObject2 != null) {
          if ((cl.aWB() - ((bai)localObject2).lastUpdateTime < 480L) && (((bai)localObject2).LJY.size() > 0))
          {
            bool = true;
            Log.i("Finder.PopularDataManager", "cur: " + cl.aWB() + "  lastUpdateTime : " + ((bai)localObject2).lastUpdateTime + " isValid: " + bool);
            if (!bool) {
              break label234;
            }
            localObject1 = (List)((bai)localObject1).LJY;
            AppMethodBeat.o(251347);
            return localObject1;
          }
        }
      }
      return null;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a vva;
      
      static
      {
        AppMethodBeat.i(251346);
        vva = new a();
        AppMethodBeat.o(251346);
      }
      
      public final void run()
      {
        AppMethodBeat.i(251345);
        Object localObject1 = new StringBuilder();
        Object localObject2 = al.waC;
        localObject2 = al.dEF() + "popular.info";
        o localo = new o((String)localObject2);
        localObject1 = g.c.vuZ;
        localObject1 = g.c.dpR();
        if (localObject1 != null) {}
        for (localObject1 = ((bai)localObject1).toByteArray();; localObject1 = null)
        {
          if (!s.YS(String.valueOf(localo.heq()))) {
            s.boN(String.valueOf(localo.heq()));
          }
          s.C((String)localObject2, (byte[])localObject1);
          AppMethodBeat.o(251345);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$PopularListAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setHotWord", "", "holder", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic$HotWordItemHolder;", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "hotWordText", "", "recommendReason", "setItemBg", "contentView", "plugin-finder_release"})
  public final class d
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(251352);
      List localList = g.a(this.vuQ);
      if (localList != null)
      {
        int i = localList.size();
        AppMethodBeat.o(251352);
        return i;
      }
      AppMethodBeat.o(251352);
      return 0;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(251351);
      Object localObject = g.a(this.vuQ);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((List)localObject).get(paramInt);
      AppMethodBeat.o(251351);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(251350);
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.hyc();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494560, paramViewGroup, false);
        paramViewGroup = new g.b(this.vuQ);
        localObject1 = paramView.findViewById(2131300850);
        p.g(localObject1, "contentView.findViewById….id.finder_hot_word_text)");
        localObject1 = (TextView)localObject1;
        p.h(localObject1, "<set-?>");
        paramViewGroup.krl = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131300849);
        p.g(localObject1, "contentView.findViewById…inder_hot_word_last_line)");
        localObject1 = (TextView)localObject1;
        p.h(localObject1, "<set-?>");
        paramViewGroup.vuS = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131302328);
        p.g(localObject1, "contentView.findViewById(R.id.hint)");
        localObject1 = (TextView)localObject1;
        p.h(localObject1, "<set-?>");
        paramViewGroup.vuT = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131299715);
        p.g(localObject1, "contentView.findViewById(R.id.divider_view)");
        p.h(localObject1, "<set-?>");
        paramViewGroup.lrc = ((View)localObject1);
        localObject1 = paramView.findViewById(2131300857);
        p.g(localObject1, "contentView.findViewById…finder_last_line_divider)");
        p.h(localObject1, "<set-?>");
        paramViewGroup.vuU = ((View)localObject1);
        p.g(paramView, "contentView");
        paramView.setTag(paramViewGroup);
        localObject1 = g.a(this.vuQ);
        if (localObject1 == null) {
          p.hyc();
        }
        localObject2 = ((bby)((List)localObject1).get(paramInt)).LLa;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = g.a(this.vuQ);
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((bby)((List)localObject2).get(paramInt)).LLc;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label430;
        }
        paramViewGroup.dpL().setVisibility(0);
        paramViewGroup.dpL().setText((CharSequence)localObject1);
        paramViewGroup.dpM().setVisibility(8);
        paramViewGroup.dpN().setVisibility(8);
      }
      label358:
      int j;
      label389:
      label430:
      Object localObject3;
      int k;
      for (;;)
      {
        if (paramInt == getCount() - 1)
        {
          paramViewGroup.dpO().setVisibility(4);
          if (getCount() != 1) {
            break label889;
          }
          if (paramInt == 0) {
            paramView.setBackground(g.b(this.vuQ).getResources().getDrawable(2131234443));
          }
          AppMethodBeat.o(251350);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderPopularListLogic.HotWordItemHolder");
            AppMethodBeat.o(251350);
            throw paramView;
          }
          paramViewGroup = (g.b)paramViewGroup;
          break;
          j = g.c(this.vuQ);
          localObject3 = new StaticLayout((CharSequence)localObject1, 0, ((String)localObject1).length(), paramViewGroup.dpL().getPaint(), j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
          if (((StaticLayout)localObject3).getLineCount() > 0)
          {
            k = ((StaticLayout)localObject3).getLineCount();
            ((StaticLayout)localObject3).getLineEnd(0);
            if (k <= 1) {
              break label980;
            }
          }
        }
      }
      label980:
      for (int i = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 2);; i = 0)
      {
        int m = ((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 1);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(251350);
          throw paramView;
        }
        localObject3 = ((String)localObject1).substring(i, m);
        p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.i("Finder.FinderPopularListLogic", "lastLineText :".concat(String.valueOf(localObject3)));
        Object localObject4 = paramViewGroup.dpM().getPaint();
        float f1;
        if (localObject4 != null)
        {
          f1 = ((TextPaint)localObject4).measureText((String)localObject3, 0, ((String)localObject3).length());
          label618:
          localObject4 = paramViewGroup.dpN().getPaint();
          if (localObject4 == null) {
            break label743;
          }
        }
        label743:
        for (float f2 = ((TextPaint)localObject4).measureText((String)localObject2);; f2 = 0.0F)
        {
          Log.i("Finder.FinderPopularListLogic", "推荐原因不在同一行");
          paramViewGroup.dpN().setVisibility(0);
          if (f1 + f2 + g.d(this.vuQ) <= j) {
            break label749;
          }
          paramViewGroup.dpL().setText((CharSequence)localObject1);
          localObject1 = paramViewGroup.dpM();
          ((TextView)localObject1).setText((CharSequence)"");
          ((TextView)localObject1).setVisibility(4);
          paramViewGroup.dpP().setVisibility(8);
          paramViewGroup.dpN().setText((CharSequence)localObject2);
          break;
          f1 = 0.0F;
          break label618;
        }
        label749:
        Log.i("Finder.FinderPopularListLogic", "推荐原因在同一行");
        if (k == 1) {
          paramViewGroup.dpL().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = paramViewGroup.dpM();
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)localObject3);
          paramViewGroup.dpP().setVisibility(0);
          paramViewGroup.dpN().setText((CharSequence)localObject2);
          break;
          localObject4 = paramViewGroup.dpL();
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251350);
            throw paramView;
          }
          localObject1 = ((String)localObject1).substring(0, i);
          p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        paramViewGroup.dpO().setVisibility(0);
        break label358;
        label889:
        if (getCount() <= 1) {
          break label389;
        }
        if (paramInt == 0)
        {
          paramView.setBackground(g.b(this.vuQ).getResources().getDrawable(2131234445));
          break label389;
        }
        if (paramInt == getCount() - 1)
        {
          paramView.setBackground(g.b(this.vuQ).getResources().getDrawable(2131234444));
          break label389;
        }
        paramView.setBackgroundColor(g.b(this.vuQ).getResources().getColor(2131101424));
        break label389;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */