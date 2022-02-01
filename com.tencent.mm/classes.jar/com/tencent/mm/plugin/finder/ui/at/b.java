package com.tencent.mm.plugin.finder.ui.at;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.mm.w.a.a.a.d;
import com.tencent.mm.w.a.a.a.e;
import com.tencent.mm.w.a.a.a.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "context", "Landroid/content/Context;", "forceDarkMode", "", "callback", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "(Landroid/content/Context;Ljava/lang/Boolean;Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;)V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getCallback", "()Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "getForceDarkMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getFtsEditTextView", "()Lcom/tencent/mm/ui/search/FTSEditTextView;", "setFtsEditTextView", "(Lcom/tencent/mm/ui/search/FTSEditTextView;)V", "isUseSearch", "", "()J", "setUseSearch", "(J)V", "lastTouchAlphabet", "", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "liveList", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveList;", "liveList$delegate", "onItemClickListener", "com/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog$onItemClickListener$2$1;", "onItemClickListener$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "scrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "getScrollBar", "()Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "setScrollBar", "(Lcom/tencent/mm/ui/base/AlphabetScrollBar;)V", "touchAlphabetCount", "", "getTouchAlphabetCount", "()I", "setTouchAlphabetCount", "(I)V", "at", "", "displayName", "username", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "contactToDisplayName", "ct", "Lcom/tencent/mm/storage/Contact;", "forceViewDarkMode", "getAtDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "getAtSearchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "getLayoutId", "inflateContentView", "Landroid/view/View;", "initContentView", "onClickClearTextBtn", "view", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSearchKeyDown", "onTagClick", "index", "tag", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends com.tencent.mm.ui.f.a
  implements FTSEditTextView.c
{
  private WxRecyclerView AZd;
  public final Boolean DHP;
  private final j EKZ;
  private final a FWf;
  private FTSEditTextView FWg;
  private AlphabetScrollBar FWh;
  private final j FWi;
  private String FWj;
  private long FWk;
  private int FWl;
  private final j FWm;
  private final j xZP;
  
  public b(Context paramContext, Boolean paramBoolean, a parama)
  {
    super(paramContext);
    this.DHP = paramBoolean;
    this.FWf = parama;
    this.FWi = k.cm((kotlin.g.a.a)new d(this));
    this.xZP = k.cm((kotlin.g.a.a)new a(this));
    this.EKZ = k.cm((kotlin.g.a.a)new c(paramContext));
    this.FWj = "";
    this.FWm = k.cm((kotlin.g.a.a)new e(this));
  }
  
  private static final void a(b paramb, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(b paramb, String paramString)
  {
    s.u(paramb, "this$0");
    if (!s.p(paramb.FWj, paramString))
    {
      paramb.FWl += 1;
      s.s(paramString, "it");
      paramb.FWj = paramString;
    }
    if (s.p(paramString, "🔍")) {
      paramb.fcq().bo(0, 0);
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)paramb.fco().pUj).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (g)localObject;
        if ((s.p(((g)localObject).FWw, paramString)) && (((g)localObject).FWu))
        {
          paramb.fcq().bo(i, 0);
          return;
        }
        i += 1;
      }
    }
  }
  
  private static final void a(b paramb, List paramList)
  {
    s.u(paramb, "this$0");
    paramList = paramb.FWh;
    if (paramList != null)
    {
      paramb = ((Collection)paramb.fco().FWy).toArray(new String[0]);
      if (paramb == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramList.setAlphabet((String[])paramb);
    }
  }
  
  private final com.tencent.mm.plugin.mvvmlist.g<g> fcp()
  {
    return (com.tencent.mm.plugin.mvvmlist.g)this.xZP.getValue();
  }
  
  private final WxLinearLayoutManager fcq()
  {
    return (WxLinearLayoutManager)this.EKZ.getValue();
  }
  
  public final boolean aWU()
  {
    return true;
  }
  
  public abstract String ae(au paramau);
  
  public final View bZy()
  {
    View localView = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
    s.s(localView, "from(context).inflate(getLayoutId(), null)");
    return localView;
  }
  
  public final void eeU() {}
  
  public abstract com.tencent.mm.view.recyclerview.g euf();
  
  public abstract com.tencent.mm.plugin.mvvmlist.a.a<g> eug();
  
  public abstract com.tencent.mm.plugin.mvvmlist.a.b<g, String> euh();
  
  protected final FinderAtSomeoneLiveList fco()
  {
    return (FinderAtSomeoneLiveList)this.FWi.getValue();
  }
  
  public final void fq(boolean paramBoolean) {}
  
  public abstract int getLayoutId();
  
  public void initContentView()
  {
    Object localObject2 = null;
    super.initContentView();
    Object localObject1 = jBj();
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(a.e.close_btn);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
    }
    if (getContext().getResources().getConfiguration().orientation == 2)
    {
      localObject1 = jBk();
      if (localObject1 != null) {
        break label746;
      }
      localObject1 = null;
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = c.dip2px(getContext(), 512.0F);
      }
      localObject1 = jBk();
      if (localObject1 != null) {
        break label754;
      }
      localObject1 = null;
      label96:
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label762;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      label108:
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      }
      localObject1 = jBj();
      if (localObject1 != null) {
        break label767;
      }
      localObject1 = null;
      label129:
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = c.dip2px(getContext(), 512.0F);
      }
      localObject1 = jBj();
      if (localObject1 != null) {
        break label775;
      }
      localObject1 = null;
      label158:
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label783;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      label170:
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      }
      localObject1 = getEmptyView();
      if (localObject1 != null) {
        break label788;
      }
      localObject1 = null;
      label191:
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).height = bf.getStatusBarHeight(getContext());
      }
    }
    if (s.p(this.DHP, Boolean.TRUE))
    {
      localObject1 = jBj();
      if (localObject1 == null)
      {
        localObject1 = null;
        label230:
        this.FWg = ((FTSEditTextView)localObject1);
        localObject1 = this.FWg;
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setVisibility(0);
        }
        localObject1 = this.FWg;
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).jBL();
        }
        localObject1 = this.FWg;
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setFtsEditTextListener((FTSEditTextView.c)this);
        }
        localObject1 = this.FWg;
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setHint(getContext().getResources().getString(a.i.app_search));
        }
        localObject1 = this.FWg;
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).jCu();
        }
        localObject1 = jBj();
        if (localObject1 != null) {
          break label838;
        }
        localObject1 = null;
        label329:
        this.AZd = ((WxRecyclerView)localObject1);
        localObject1 = this.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)fcp());
        }
        localObject1 = this.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)fcq());
        }
        fcp().agOO = ((h)this.FWm.getValue());
        localObject1 = jBj();
        if (localObject1 != null) {
          break label852;
        }
        localObject1 = null;
        label407:
        this.FWh = ((AlphabetScrollBar)localObject1);
        localObject1 = this.FWh;
        if (localObject1 != null) {
          ((AlphabetScrollBar)localObject1).setOnScrollBarTouchListener(new b..ExternalSyntheticLambda2(this));
        }
        localObject1 = this.FWh;
        if (localObject1 != null) {
          ((AlphabetScrollBar)localObject1).setAlphabet(new String[] { "🔍", "#" });
        }
        fco().MmR.a((q)this, new b..ExternalSyntheticLambda1(this));
        if (!s.p(this.DHP, Boolean.TRUE)) {
          break label866;
        }
        localObject1 = jBk();
        if (localObject1 != null) {
          ((View)localObject1).setBackground(null);
        }
        localObject1 = jBj();
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(a.d.half_screen_dialog_darkmode_shape);
        }
        localObject1 = jBj();
        if (localObject1 != null)
        {
          localObject1 = (WeImageView)((View)localObject1).findViewById(a.e.close_btn);
          if (localObject1 != null) {
            ((WeImageView)localObject1).setIconColor(getContext().getResources().getColor(a.b.White));
          }
        }
        localObject1 = jBj();
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(a.e.title_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(Color.parseColor("#CCFFFFFF"));
          }
        }
        localObject1 = jBj();
        if (localObject1 != null)
        {
          localObject1 = (WeImageView)((View)localObject1).findViewById(a.e.search_icon);
          if (localObject1 != null) {
            ((WeImageView)localObject1).setIconColor(Color.parseColor("#6B6B6B"));
          }
        }
        localObject1 = jBj();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(a.e.search_bar);
          if (localObject1 != null) {
            ((View)localObject1).setBackgroundResource(a.d.finder_at_dialog_search_shape);
          }
        }
        localObject1 = this.FWh;
        if (localObject1 != null) {
          ((AlphabetScrollBar)localObject1).setTextColor(getContext().getResources().getColor(a.b.BW_100_Alpha_0_2));
        }
        localObject1 = this.FWh;
        if (localObject1 != null) {
          ((AlphabetScrollBar)localObject1).setSearchIconColor(getContext().getResources().getColor(a.b.BW_100_Alpha_0_3));
        }
        label715:
        localObject1 = jBj();
        if (localObject1 != null) {
          break label899;
        }
      }
    }
    label899:
    for (localObject1 = localObject2;; localObject1 = (LiveBottomSheetPanel)((View)localObject1).findViewById(a.e.finder_live_at_root))
    {
      if (localObject1 != null) {
        ((LiveBottomSheetPanel)localObject1).setOnVisibilityListener((kotlin.g.a.b)new b(this));
      }
      return;
      label746:
      localObject1 = ((View)localObject1).getLayoutParams();
      break;
      label754:
      localObject1 = ((View)localObject1).getLayoutParams();
      break label96;
      label762:
      localObject1 = null;
      break label108;
      label767:
      localObject1 = ((View)localObject1).getLayoutParams();
      break label129;
      label775:
      localObject1 = ((View)localObject1).getLayoutParams();
      break label158;
      label783:
      localObject1 = null;
      break label170;
      label788:
      localObject1 = ((View)localObject1).getLayoutParams();
      break label191;
      localObject1 = (FTSEditTextView)((View)localObject1).findViewById(a.e.fts_edittext_night_mode);
      break label230;
      localObject1 = jBj();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label230;
      }
      localObject1 = (FTSEditTextView)((View)localObject1).findViewById(a.e.fts_edittext);
      break label230;
      label838:
      localObject1 = (WxRecyclerView)((View)localObject1).findViewById(a.e.chatroom_member_rv);
      break label329;
      label852:
      localObject1 = (AlphabetScrollBar)((View)localObject1).findViewById(a.e.alphabet_scrollbar);
      break label407;
      label866:
      localObject1 = jBk();
      if (localObject1 != null) {
        ((View)localObject1).setBackground(null);
      }
      localObject1 = jBj();
      if (localObject1 == null) {
        break label715;
      }
      ((View)localObject1).setBackgroundResource(a.d.half_screen_dialog_bg);
      break label715;
    }
  }
  
  public void onClickClearTextBtn(View paramView) {}
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        paramString1 = (b)this;
        paramString1.fco().eui();
        paramString1.fco().gsy();
        paramString1 = paramString1.FWh;
        if (paramString1 != null) {
          paramString1.setVisibility(0);
        }
      }
      return;
      int i;
      if (!n.bp((CharSequence)paramString1))
      {
        i = 1;
        label57:
        if (i == 0) {
          break label77;
        }
      }
      for (;;)
      {
        if (paramString1 != null) {
          break label82;
        }
        paramString1 = null;
        break;
        i = 0;
        break label57;
        label77:
        paramString1 = null;
      }
      label82:
      fco().gd(paramString1);
      paramString1 = this.FWh;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      this.FWk = 1L;
      paramString1 = ah.aiuX;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<g>>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    c(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FinderAtSomeoneLiveList>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/ui/at/BaseFinderAtSomeoneDialog$onItemClickListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<1>
  {
    e(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.b
 * JD-Core Version:    0.7.0.1
 */