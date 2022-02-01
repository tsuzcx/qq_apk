package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.accessibility.k;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.convert.c;
import com.tencent.mm.plugin.finder.live.view.convert.d;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "()V", "TAG", "", "gameList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lkotlin/collections/ArrayList;", "getGameList", "()Ljava/util/ArrayList;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "searchEdit", "Landroid/widget/EditText;", "searchIcon", "Landroid/widget/ImageView;", "searchViewContainer", "Landroid/widget/RelativeLayout;", "selectedGame", "getSelectedGame", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "setSelectedGame", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;)V", "showSearchLayout", "", "getLayoutId", "", "goPostUI", "", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "goSearchUI", "initData", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGameItemClick", "selectPosition", "position", "setWindowStyle", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGameSelectUI
  extends FinderGameLiveBaseUI
{
  private final ArrayList<d> Boe;
  private d Bof;
  public WxRecyclerView Bog;
  private ImageView Boh;
  private EditText Boi;
  private RelativeLayout Boj;
  private boolean Bok;
  private final String TAG;
  public View lBX;
  
  public FinderGameSelectUI()
  {
    AppMethodBeat.i(364578);
    this.TAG = "Finder.FinderGameSelectUI";
    this.Boe = new ArrayList();
    AppMethodBeat.o(364578);
  }
  
  private static final ah a(FinderGameSelectUI paramFinderGameSelectUI, d paramd, b.a parama)
  {
    AppMethodBeat.i(364662);
    kotlin.g.b.s.u(paramFinderGameSelectUI, "this$0");
    Object localObject1;
    label91:
    label110:
    label127:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bil)parama.ott).ZRA;
      kotlin.g.b.s.s(parama, "it.resp.game_user_info_list");
      Iterator localIterator = ((Iterable)parama).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = (ccb)localObject2;
        parama = ((ccb)localObject1).aals;
        if (parama == null)
        {
          parama = null;
          if (Util.isNullOrNil(parama)) {
            break label208;
          }
          parama = ((ccb)localObject1).aals;
          if (parama != null) {
            break label190;
          }
          parama = null;
          localObject1 = paramd.DUG.aals;
          if (localObject1 != null) {
            break label198;
          }
          localObject1 = null;
          if (!kotlin.g.b.s.p(parama, localObject1)) {
            break label208;
          }
          i = 1;
          label138:
          if (i == 0) {
            break label211;
          }
          parama = localObject2;
          label145:
          parama = (ccb)parama;
          if (parama != null) {
            break label218;
          }
          Log.i(paramFinderGameSelectUI.TAG, "no game match, use default");
          paramFinderGameSelectUI.a(paramd.DUG);
        }
      }
    }
    for (;;)
    {
      paramFinderGameSelectUI = ah.aiuX;
      AppMethodBeat.o(364662);
      return paramFinderGameSelectUI;
      parama = parama.app_id;
      break label91;
      label190:
      parama = parama.app_id;
      break label110;
      label198:
      localObject1 = ((cbb)localObject1).app_id;
      break label127;
      label208:
      i = 0;
      break label138;
      label211:
      break;
      parama = null;
      break label145;
      label218:
      paramFinderGameSelectUI.a(parama);
      continue;
      Log.i(paramFinderGameSelectUI.TAG, "CgiFinderLiveGetUserGameConfig error, toast");
      aa.makeText((Context)paramFinderGameSelectUI.getContext(), (CharSequence)paramFinderGameSelectUI.getString(p.h.finder_live_game_prepare_error), 0).show();
    }
  }
  
  private static final void a(FinderGameSelectUI paramFinderGameSelectUI, View paramView)
  {
    AppMethodBeat.i(364621);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderGameSelectUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderGameSelectUI, "this$0");
    paramFinderGameSelectUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364621);
  }
  
  private final void a(ccb paramccb)
  {
    String str = null;
    AppMethodBeat.i(364602);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("go postui, game:");
    Object localObject1 = paramccb.aals;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", ");
      localObject1 = paramccb.aals;
      if (localObject1 != null) {
        break label248;
      }
      localObject1 = str;
      label62:
      Log.i((String)localObject2, localObject1);
      localObject2 = new Intent();
      localObject1 = paramccb.aalt;
      if (localObject1 != null) {
        break label256;
      }
      localObject1 = "";
      label98:
      ((Intent)localObject2).putExtra("COVER_URL", (String)localObject1);
      localObject1 = paramccb.aalt;
      if (localObject1 != null) {
        break label274;
      }
      localObject1 = "";
      label121:
      ((Intent)localObject2).putExtra("DESC", (String)localObject1);
      ((Intent)localObject2).putExtra("TICKET", "");
      localObject1 = paramccb.aals;
      if (localObject1 != null) {
        break label292;
      }
      localObject1 = "";
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("APPID", (String)localObject1);
      ((Intent)localObject2).putExtra("POST_FROM_SCENE", 0);
      ((Intent)localObject2).putExtra("GameUserInfo", paramccb.toByteArray());
      ((Intent)localObject2).putExtra("MINI_GAME_SCENE", 1);
      paramccb = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      paramccb.o((Context)localObject1, (Intent)localObject2);
      AppMethodBeat.o(364602);
      return;
      localObject1 = ((cbb)localObject1).xlJ;
      break;
      label248:
      localObject1 = ((cbb)localObject1).app_id;
      break label62;
      label256:
      str = ((cbq)localObject1).aabN;
      localObject1 = str;
      if (str != null) {
        break label98;
      }
      localObject1 = "";
      break label98;
      label274:
      str = ((cbq)localObject1).description;
      localObject1 = str;
      if (str != null) {
        break label121;
      }
      localObject1 = "";
      break label121;
      label292:
      str = ((cbb)localObject1).app_id;
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
    }
  }
  
  private static final void b(FinderGameSelectUI paramFinderGameSelectUI, View paramView)
  {
    AppMethodBeat.i(364630);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderGameSelectUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderGameSelectUI, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
    com.tencent.mm.plugin.finder.utils.s.feS();
    paramFinderGameSelectUI.efb();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364630);
  }
  
  private static final void c(FinderGameSelectUI paramFinderGameSelectUI, View paramView)
  {
    AppMethodBeat.i(364639);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderGameSelectUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderGameSelectUI, "this$0");
    paramFinderGameSelectUI.efb();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364639);
  }
  
  private WxRecyclerView efa()
  {
    AppMethodBeat.i(364586);
    WxRecyclerView localWxRecyclerView = this.Bog;
    if (localWxRecyclerView != null)
    {
      AppMethodBeat.o(364586);
      return localWxRecyclerView;
    }
    kotlin.g.b.s.bIx("rv");
    AppMethodBeat.o(364586);
    return null;
  }
  
  private final void efb()
  {
    AppMethodBeat.i(364605);
    com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.s.s(localAppCompatActivity, "context");
    localf.q((Context)localAppCompatActivity, new Intent());
    AppMethodBeat.o(364605);
  }
  
  private static final void fI(View paramView)
  {
    AppMethodBeat.i(364613);
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(localRect.width() * -2, -localRect.width());
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(364613);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(364613);
  }
  
  private static final void l(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364646);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(364646);
  }
  
  private static final void m(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364651);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(364651);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.CcF;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    EditText localEditText = null;
    Object localObject1 = null;
    AppMethodBeat.i(364773);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(p.e.BVi);
    Object localObject2 = t.GgN;
    t.gO(paramBundle);
    paramBundle = (com.tencent.mm.bx.a)new bil();
    localObject2 = getIntent().getByteArrayExtra("APP_LIST");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      localObject2 = (bil)paramBundle;
      if (localObject2 != null)
      {
        paramBundle = this.Boe;
        localObject2 = ((bil)localObject2).ZRA;
        kotlin.g.b.s.s(localObject2, "game_user_info_list");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ccb)((Iterator)localObject3).next();
          kotlin.g.b.s.s(localObject4, "it");
          ((Collection)localObject2).add(new d((ccb)localObject4));
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
      paramBundle.addAll((Collection)localObject2);
      this.Bok = getIntent().getBooleanExtra("SHOW_SEARCH_LAYOUT", false);
      if (this.Boe.isEmpty())
      {
        Log.w(this.TAG, "gameList empty");
        finish();
      }
      paramBundle = ((Iterable)this.Boe).iterator();
      while (paramBundle.hasNext()) {
        ((d)paramBundle.next()).Bvd = false;
      }
      Object localObject3 = com.tencent.mm.kernel.h.baE().ban().b(at.a.adfu, "");
      Object localObject4 = ((Iterable)this.Boe).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject2 = ((Iterator)localObject4).next();
        paramBundle = ((d)localObject2).DUG.aals;
        if (paramBundle == null)
        {
          paramBundle = null;
          label456:
          if (!kotlin.g.b.s.p(paramBundle, localObject3)) {
            break label981;
          }
          paramBundle = (Bundle)localObject2;
          label468:
          paramBundle = (d)paramBundle;
          if (paramBundle != null)
          {
            paramBundle.Bvd = true;
            this.Bof = paramBundle;
          }
          localObject2 = findViewById(p.e.BVj);
          findViewById(p.e.ok_btn);
          paramBundle = findViewById(p.e.BVi);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.game_select_root)");
          setRoot(paramBundle);
          paramBundle = findViewById(p.e.BVg);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.game_rv)");
          paramBundle = (WxRecyclerView)paramBundle;
          kotlin.g.b.s.u(paramBundle, "<set-?>");
          this.Bog = paramBundle;
          paramBundle = findViewById(p.e.BKP);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_live_game_search_icon)");
          this.Boh = ((ImageView)paramBundle);
          paramBundle = findViewById(p.e.BKM);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_live_game_search_edit)");
          this.Boi = ((EditText)paramBundle);
          paramBundle = findViewById(p.e.BKO);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder…e_game_search_group_root)");
          this.Boj = ((RelativeLayout)paramBundle);
          paramBundle = com.tencent.mm.plugin.finder.live.util.g.DIp;
          localObject3 = z.bAW();
          paramBundle = this.lBX;
          if (paramBundle == null) {
            break label988;
          }
          label643:
          com.tencent.mm.plugin.finder.live.util.g.a((String)localObject3, "", paramBundle);
          ((View)localObject2).post(new FinderGameSelectUI..ExternalSyntheticLambda6((View)localObject2));
          ((View)localObject2).setOnClickListener(new FinderGameSelectUI..ExternalSyntheticLambda3(this));
          efa().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
          paramBundle = efa();
          localObject2 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new a(this), this.Boe);
          ((i)localObject2).agOe = ((i.c)new b(this));
          localObject3 = ah.aiuX;
          paramBundle.setAdapter((RecyclerView.a)localObject2);
          com.tencent.mm.view.f.a((RecyclerView)efa(), (e.a)new c());
          if (!this.Bok) {
            break label1007;
          }
          localEditText = this.Boi;
          paramBundle = localEditText;
          if (localEditText == null)
          {
            kotlin.g.b.s.bIx("searchEdit");
            paramBundle = null;
          }
          paramBundle = paramBundle.getLayoutParams();
          if (!(paramBundle instanceof RelativeLayout.LayoutParams)) {
            break label999;
          }
          paramBundle = (RelativeLayout.LayoutParams)paramBundle;
          label820:
          if (paramBundle != null)
          {
            paramBundle.width = -2;
            paramBundle.addRule(13);
          }
          localEditText = this.Boi;
          paramBundle = localEditText;
          if (localEditText == null)
          {
            kotlin.g.b.s.bIx("searchEdit");
            paramBundle = null;
          }
          paramBundle.setOnClickListener(new FinderGameSelectUI..ExternalSyntheticLambda2(this));
          localEditText = this.Boi;
          paramBundle = localEditText;
          if (localEditText == null)
          {
            kotlin.g.b.s.bIx("searchEdit");
            paramBundle = null;
          }
          paramBundle.setInputType(0);
          localEditText = this.Boi;
          paramBundle = localEditText;
          if (localEditText == null)
          {
            kotlin.g.b.s.bIx("searchEdit");
            paramBundle = null;
          }
          paramBundle.setFocusable(false);
          localEditText = this.Boi;
          paramBundle = localEditText;
          if (localEditText == null)
          {
            kotlin.g.b.s.bIx("searchEdit");
            paramBundle = null;
          }
          paramBundle.setFocusableInTouchMode(false);
          paramBundle = this.Boj;
          if (paramBundle != null) {
            break label1004;
          }
          kotlin.g.b.s.bIx("searchViewContainer");
          paramBundle = localObject1;
        }
      }
      label981:
      label988:
      label999:
      label1004:
      for (;;)
      {
        paramBundle.setOnClickListener(new FinderGameSelectUI..ExternalSyntheticLambda4(this));
        AppMethodBeat.o(364773);
        return;
        paramBundle = paramBundle.app_id;
        break label456;
        break;
        paramBundle = null;
        break label468;
        kotlin.g.b.s.bIx("root");
        paramBundle = null;
        break label643;
        paramBundle = null;
        break label820;
      }
      label1007:
      paramBundle = this.Boj;
      if (paramBundle != null) {
        break label1037;
      }
    }
    kotlin.g.b.s.bIx("searchViewContainer");
    paramBundle = localEditText;
    label1037:
    for (;;)
    {
      paramBundle.setVisibility(8);
      AppMethodBeat.o(364773);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(364747);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.lBX = paramView;
    AppMethodBeat.o(364747);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(364778);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(k.class);
    AppMethodBeat.o(364778);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$3", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(FinderGameSelectUI paramFinderGameSelectUI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(365682);
      if (paramInt == d.class.hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new c();
        AppMethodBeat.o(365682);
        return localObject;
      }
      Object localObject = aw.Gjk;
      aw.eY(FinderGameSelectUI.a(this.Bol), paramInt);
      localObject = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUi();
      AppMethodBeat.o(365682);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$4$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(FinderGameSelectUI paramFinderGameSelectUI) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$5", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e.a
  {
    private final HashSet<String> AKl;
    
    c()
    {
      AppMethodBeat.i(365616);
      this.AKl = new HashSet();
      AppMethodBeat.o(365616);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(365630);
      kotlin.g.b.s.u(paramView, "parent");
      kotlin.g.b.s.u(paramList, "exposedHolders");
      paramList = ((Iterable)paramList).iterator();
      label166:
      label168:
      label171:
      label173:
      label176:
      label178:
      label184:
      while (paramList.hasNext())
      {
        paramView = (RecyclerView.v)paramList.next();
        label58:
        label79:
        Object localObject;
        int i;
        if ((paramView instanceof j))
        {
          paramView = (j)paramView;
          if (paramView == null) {
            break label166;
          }
          paramView = paramView.CSA;
          if (!(paramView instanceof d)) {
            break label168;
          }
          paramView = (d)paramView;
          if (paramView == null) {
            break label171;
          }
          localObject = paramView.DUG.aals;
          if ((localObject == null) || (((cbb)localObject).aakj != 1)) {
            break label173;
          }
          i = 1;
          label108:
          if (i == 0) {
            break label176;
          }
          paramView = paramView.DUG.aals;
          if (paramView != null) {
            break label178;
          }
        }
        for (paramView = null;; paramView = paramView.app_id)
        {
          if ((paramView == null) || (this.AKl.contains(paramView))) {
            break label184;
          }
          this.AKl.add(paramView);
          localObject = com.tencent.mm.plugin.finder.utils.s.GgL;
          com.tencent.mm.plugin.finder.utils.s.bG(1, paramView);
          break;
          paramView = null;
          break label58;
          break;
          paramView = null;
          break label79;
          break;
          i = 0;
          break label108;
          break;
        }
      }
      AppMethodBeat.o(365630);
    }
    
    public final boolean dXG()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameSelectUI
 * JD-Core Version:    0.7.0.1
 */