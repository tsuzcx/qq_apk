package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.c;
import com.tencent.mm.plugin.finder.live.view.adapter.c.a;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.gfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "cancelTv", "Landroid/view/View;", "clearIcon", "closeIcon", "editText", "Landroid/widget/EditText;", "emptyTv", "Landroid/widget/TextView;", "gameSearchList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "Lkotlin/collections/ArrayList;", "hasNext", "", "loadingView", "netSceneSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "offset", "", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "root", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter;", "clearSearchList", "", "configRecentPlayContainer", "show", "getLayoutId", "", "getQuery", "gotoPostUI", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "fromRecentPlay", "initView", "loadSearchData", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
  implements View.OnClickListener, com.tencent.mm.am.h
{
  public static final g.a DYb;
  private RefreshLoadMoreLayout ATx;
  private cc DXX;
  private View DYc;
  private View DYd;
  private View DYe;
  private String DYf;
  private final ArrayList<cby> DYg;
  private final c DYh;
  private boolean aqS;
  EditText dzv;
  private View lBX;
  private TextView lNm;
  private RecyclerView mkw;
  private View njN;
  private String query;
  
  static
  {
    AppMethodBeat.i(356413);
    DYb = new g.a((byte)0);
    AppMethodBeat.o(356413);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356238);
    this.query = "";
    this.DYf = "";
    this.DYg = new ArrayList();
    this.DYh = new c();
    AppMethodBeat.o(356238);
  }
  
  private static final void a(g paramg)
  {
    AppMethodBeat.i(356259);
    kotlin.g.b.s.u(paramg, "this$0");
    Rect localRect = new Rect();
    Object localObject = paramg.DYc;
    if (localObject != null) {
      ((View)localObject).getHitRect(localRect);
    }
    localRect.inset(localRect.width() * -2, -localRect.width());
    localObject = paramg.DYc;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof View)) {
        break label106;
      }
    }
    label106:
    for (localObject = (View)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, paramg.DYc));
      }
      AppMethodBeat.o(356259);
      return;
      localObject = ((View)localObject).getParent();
      break;
    }
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(356274);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    paramg.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356274);
  }
  
  private static final boolean a(g paramg, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(356283);
    kotlin.g.b.s.u(paramg, "this$0");
    if ((3 == paramInt) || (paramKeyEvent.getAction() == 66))
    {
      Log.i("Finder.FinderGameLiveSearchUIC", kotlin.g.b.s.X("loadSearchData query:", paramg.query));
      paramTextView = paramg.lNm;
      if (paramTextView != null) {
        paramTextView.setVisibility(8);
      }
      paramTextView = paramg.njN;
      if (paramTextView != null) {
        paramTextView.setVisibility(0);
      }
      paramg.DYg.clear();
      paramg.DYf = "";
      paramg.aqS = false;
      paramTextView = (CharSequence)paramg.query;
      if ((paramTextView != null) && (paramTextView.length() != 0)) {
        break label196;
      }
    }
    label196:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramTextView = com.tencent.mm.plugin.finder.utils.s.GgL;
        com.tencent.mm.plugin.finder.utils.s.bG(6, paramg.query);
        paramg.DXX = new cc(paramg.query, paramg.DYf, (byte)0);
        com.tencent.mm.kernel.h.aZW().a((p)paramg.DXX, 0);
        com.tencent.mm.kernel.h.aZW().a(4140, (com.tencent.mm.am.h)paramg);
      }
      Util.hideVKB((View)paramg.dzv);
      AppMethodBeat.o(356283);
      return true;
    }
  }
  
  private static final void b(g paramg)
  {
    AppMethodBeat.i(356288);
    kotlin.g.b.s.u(paramg, "this$0");
    EditText localEditText = paramg.dzv;
    if (localEditText != null) {
      localEditText.requestFocus();
    }
    paramg = paramg.getActivity();
    if ((paramg instanceof MMActivity)) {}
    for (paramg = (MMActivity)paramg;; paramg = null)
    {
      if (paramg != null) {
        paramg.showVKB();
      }
      AppMethodBeat.o(356288);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.convert.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(356475);
    kotlin.g.b.s.u(paramb, "gameSearchItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("TICKET", "");
    Object localObject = paramb.DUE.aall;
    if (localObject == null)
    {
      localObject = "";
      localIntent.putExtra("APPID", (String)localObject);
      paramb = paramb.DUE.aall;
      if (paramb != null) {
        break label165;
      }
      i = 0;
      label76:
      localIntent.putExtra("VERSION_TYPE", i);
      localIntent.putExtra("POST_FROM_SCENE", 0);
      if (!paramBoolean) {
        break label187;
      }
    }
    label165:
    label187:
    for (int i = 2;; i = 3)
    {
      localIntent.putExtra("MINI_GAME_SCENE", i);
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).o((Context)getContext(), localIntent);
      AppMethodBeat.o(356475);
      return;
      String str = ((cbx)localObject).appid;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      paramb = paramb.aakk;
      if (paramb == null)
      {
        i = 0;
        break label76;
      }
      i = paramb.Tqb;
      break label76;
    }
  }
  
  public final int getLayoutId()
  {
    return p.f.CcD;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(356496);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BKL;
      if (paramView != null) {
        break label79;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356496);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label79:
      if (paramView.intValue() == i)
      {
        paramView = this.dzv;
        if (paramView != null) {
          paramView.setText((CharSequence)"");
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356461);
    super.onCreate(paramBundle);
    this.lBX = getActivity().findViewById(p.e.BVh);
    this.DYc = getActivity().findViewById(p.e.BVj);
    this.ATx = ((RefreshLoadMoreLayout)getActivity().findViewById(p.e.rl_layout));
    this.mkw = ((RecyclerView)getActivity().findViewById(p.e.BKR));
    this.DYd = getActivity().findViewById(p.e.BKK);
    this.DYe = getActivity().findViewById(p.e.BKL);
    this.dzv = ((EditText)getActivity().findViewById(p.e.BKM));
    this.lNm = ((TextView)getActivity().findViewById(p.e.BKN));
    this.njN = getActivity().findViewById(p.e.BKQ);
    paramBundle = t.GgN;
    t.gO(this.lBX);
    paramBundle = this.DYc;
    if (paramBundle != null) {
      paramBundle.post(new g..ExternalSyntheticLambda3(this));
    }
    paramBundle = this.DYc;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new g..ExternalSyntheticLambda0(this));
    }
    paramBundle = this.ATx;
    if (paramBundle != null) {
      paramBundle.setEnablePullDownHeader(false);
    }
    paramBundle = this.lBX;
    if (paramBundle != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.live.util.g.DIp;
      com.tencent.mm.plugin.finder.live.util.g.a(z.bAW(), "", paramBundle);
      localObject = af.mU(paramBundle.getContext()).inflate(p.f.load_more_footer, null);
      TextView localTextView = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
      if (localTextView != null) {
        localTextView.setTextColor(paramBundle.getContext().getResources().getColor(p.b.half_alpha_white));
      }
      paramBundle = this.ATx;
      if (paramBundle != null)
      {
        kotlin.g.b.s.s(localObject, "footer");
        paramBundle.setLoadMoreFooter((View)localObject);
      }
    }
    paramBundle = this.ATx;
    if (paramBundle != null) {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new b(this));
    }
    paramBundle = this.mkw;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.mkw;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.DYh);
    }
    paramBundle = this.mkw;
    if (paramBundle != null) {
      com.tencent.mm.view.f.a(paramBundle, (e.a)new c());
    }
    paramBundle = this.dzv;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener((TextWatcher)new d(this));
    }
    paramBundle = this.dzv;
    if (paramBundle != null) {
      paramBundle.setOnEditorActionListener(new g..ExternalSyntheticLambda1(this));
    }
    paramBundle = this.dzv;
    if (paramBundle != null) {
      paramBundle.postDelayed(new g..ExternalSyntheticLambda2(this), 128L);
    }
    paramBundle = this.DYd;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    paramBundle = this.DYe;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.DYh.DPH = ((kotlin.g.a.b)new e(this));
    AppMethodBeat.o(356461);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(356489);
    com.tencent.mm.kernel.h.aZW().b(4140, (com.tencent.mm.am.h)this);
    final int i = this.DYg.size();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (!(paramp instanceof cc)) {
        break label205;
      }
    }
    label205:
    for (paramString = (cc)paramp;; paramString = null)
    {
      if (paramString != null)
      {
        bmk localbmk = paramString.ACd;
        if (localbmk != null)
        {
          this.DYg.addAll((Collection)localbmk.ZVd);
          paramp = localbmk.ZVc;
          paramString = paramp;
          if (paramp == null) {
            paramString = "";
          }
          this.DYf = paramString;
          this.aqS = localbmk.has_next;
        }
      }
      paramInt1 = this.DYg.size();
      Log.i("Finder.FinderGameLiveSearchUIC", "originSize:" + i + ", currentSize:" + paramInt1 + ", offset:" + this.DYf + ", hasNext:" + this.aqS);
      d.uiThread((kotlin.g.a.a)new f(this, i, paramInt1));
      AppMethodBeat.o(356489);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    b(g paramg) {}
    
    public final void qI(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(356488);
      Log.i("Finder.FinderGameLiveSearchUIC", kotlin.g.b.s.X("loadMoreSearchData query:", g.c(this.DYi)));
      Object localObject1 = g.c(this.DYi);
      Object localObject3 = this.DYi;
      if (g.d((g)localObject3))
      {
        g.a((g)localObject3, new cc((String)localObject1, g.e((g)localObject3), (byte)0));
        com.tencent.mm.kernel.h.aZW().a((p)g.f((g)localObject3), 0);
        com.tencent.mm.kernel.h.aZW().a(4140, (com.tencent.mm.am.h)localObject3);
        localObject1 = g.g((g)localObject3);
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
          if (localObject1 != null)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
            if (localObject1 != null) {
              ((TextView)localObject1).setText(p.h.finder_load_more_footer_tip);
            }
          }
        }
        localObject1 = g.g((g)localObject3);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = g.g((g)localObject3);
          if (localObject1 != null) {
            break label213;
          }
          localObject1 = localObject2;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label322;
          }
          ((View)localObject1).setVisibility(8);
          AppMethodBeat.o(356488);
          return;
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
          break;
          label213:
          localObject3 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((View)localObject3).findViewById(p.e.load_more_footer_end_layout);
          }
        }
      }
      localObject1 = g.g((g)localObject3);
      if (localObject1 != null)
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setText(p.h.finder_load_more_no_result_tip);
          }
        }
      }
      localObject1 = g.g((g)localObject3);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = g.g((g)localObject3);
        if (localObject1 != null) {
          break label356;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        label322:
        AppMethodBeat.o(356488);
        return;
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
        break;
        label356:
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((View)localObject1).findViewById(p.e.load_more_footer_end_layout);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$5", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e.a
  {
    private final HashSet<String> AKl;
    
    c()
    {
      AppMethodBeat.i(356479);
      this.AKl = new HashSet();
      AppMethodBeat.o(356479);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(356486);
      kotlin.g.b.s.u(paramView, "parent");
      kotlin.g.b.s.u(paramList, "exposedHolders");
      paramList = ((Iterable)paramList).iterator();
      label155:
      label157:
      label160:
      label162:
      label168:
      while (paramList.hasNext())
      {
        paramView = (RecyclerView.v)paramList.next();
        label58:
        Object localObject;
        int i;
        if ((paramView instanceof c.a))
        {
          paramView = (c.a)paramView;
          if (paramView == null) {
            break label155;
          }
          paramView = paramView.DPJ;
          if (paramView == null) {
            continue;
          }
          localObject = paramView.DUE.aall;
          if ((localObject == null) || (((cbx)localObject).aakj != 1)) {
            break label157;
          }
          i = 1;
          label96:
          if (i == 0) {
            break label160;
          }
          paramView = paramView.DUE.aall;
          if (paramView != null) {
            break label162;
          }
        }
        for (paramView = null;; paramView = paramView.appid)
        {
          if ((paramView == null) || (this.AKl.contains(paramView))) {
            break label168;
          }
          this.AKl.add(paramView);
          localObject = com.tencent.mm.plugin.finder.utils.s.GgL;
          com.tencent.mm.plugin.finder.utils.s.bG(7, paramView);
          break;
          paramView = null;
          break label58;
          break;
          i = 0;
          break label96;
          break;
        }
      }
      AppMethodBeat.o(356486);
    }
    
    public final boolean dXG()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements TextWatcher
  {
    d(g paramg) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      paramEditable = null;
      AppMethodBeat.i(356497);
      Object localObject = g.h(this.DYi);
      int i;
      if (localObject == null)
      {
        localObject = (CharSequence)paramEditable;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label120;
        }
        i = 1;
        label39:
        if (i == 0) {
          break label125;
        }
        localObject = g.i(this.DYi);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        g.j(this.DYi);
        g.a(this.DYi, true);
      }
      for (;;)
      {
        g localg = this.DYi;
        localObject = paramEditable;
        if (paramEditable == null) {
          localObject = "";
        }
        g.a(localg, (String)localObject);
        AppMethodBeat.o(356497);
        return;
        localObject = ((EditText)localObject).getText();
        if (localObject == null) {
          break;
        }
        paramEditable = localObject.toString();
        break;
        label120:
        i = 0;
        break label39;
        label125:
        localObject = g.i(this.DYi);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        g.a(this.DYi, false);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.view.convert.b, ah>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(g paramg, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.g
 * JD-Core Version:    0.7.0.1
 */