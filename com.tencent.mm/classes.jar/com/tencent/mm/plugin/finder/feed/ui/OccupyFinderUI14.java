package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.view.adapter.i;
import com.tencent.mm.plugin.finder.live.view.adapter.i.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.aq;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "setCancelTv", "(Landroid/widget/TextView;)V", "chooseMode", "", "getChooseMode", "()I", "setChooseMode", "(I)V", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "finishTv", "getFinishTv", "setFinishTv", "foldIconOpen", "", "getFoldIconOpen", "()Z", "setFoldIconOpen", "(Z)V", "publicChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPublicChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPublicChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "publicGroup", "Landroid/view/View;", "getPublicGroup", "()Landroid/view/View;", "setPublicGroup", "(Landroid/view/View;)V", "shareChooseIcon", "getShareChooseIcon", "setShareChooseIcon", "shareGroup", "getShareGroup", "setShareGroup", "titleGroup", "getTitleGroup", "setTitleGroup", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListBottomTipsTv", "getWhiteListBottomTipsTv", "setWhiteListBottomTipsTv", "whiteListChooseIcon", "getWhiteListChooseIcon", "setWhiteListChooseIcon", "whiteListContent", "getWhiteListContent", "setWhiteListContent", "whiteListFoldIv", "Landroid/widget/ImageView;", "getWhiteListFoldIv", "()Landroid/widget/ImageView;", "setWhiteListFoldIv", "(Landroid/widget/ImageView;)V", "whiteListGroup", "getWhiteListGroup", "setWhiteListGroup", "whiteListRv", "Landroid/support/v7/widget/RecyclerView;", "getWhiteListRv", "()Landroid/support/v7/widget/RecyclerView;", "setWhiteListRv", "(Landroid/support/v7/widget/RecyclerView;)V", "whiteListTipsTv", "getWhiteListTipsTv", "setWhiteListTipsTv", "whiteListTitleTv", "getWhiteListTitleTv", "setWhiteListTitleTv", "whiteListWrapper", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getWhiteListWrapper", "setWhiteListWrapper", "whitelistAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "getWhitelistAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "setWhitelistAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;)V", "checkWhiteListState", "", "mode", "choosePublicMode", "choose", "chooseShareMode", "chooseWhiteListMode", "finish", "getLayoutId", "goBack", "isCancel", "hideWhiteList", "initLayout", "initLogic", "mergeWhiteList", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "parseInten", "setFinishBtnEnable", "enable", "setWhiteListFoldState", "open", "setWindowStyle", "showWhiteList", "updateChooseList", "whiteListCanChoose", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI14
  extends MMFinderUI
  implements View.OnClickListener
{
  private static String ueA;
  public static final a ueB;
  private static String uey;
  private static String uez;
  private final String TAG;
  private HashMap _$_findViewCache;
  View hRR;
  private TextView ued;
  private TextView uee;
  private View uef;
  private WeImageView ueg;
  private View uei;
  private WeImageView uej;
  private View uek;
  private WeImageView uel;
  private TextView uem;
  private TextView uen;
  private ImageView ueo;
  private View uep;
  private RecyclerView ueq;
  private TextView uer;
  private i ues;
  private int uet;
  private LinkedList<avh> ueu;
  private LinkedList<avh> uev;
  private LinkedList<i.c> uew;
  private boolean uex;
  
  static
  {
    AppMethodBeat.i(245708);
    ueB = new a((byte)0);
    uey = "KEY_PARAMS_VISIBILITY_MODE";
    uez = "KEY_PARAMS_WHITE_LIST";
    ueA = "KEY_PARAMS_CHOOSE_WHITE_LIST";
    AppMethodBeat.o(245708);
  }
  
  public OccupyFinderUI14()
  {
    AppMethodBeat.i(245707);
    this.TAG = "FinderLiveVisitorWhiteListUI";
    this.ueu = new LinkedList();
    this.uev = new LinkedList();
    this.uew = new LinkedList();
    AppMethodBeat.o(245707);
  }
  
  private final void IT(int paramInt)
  {
    AppMethodBeat.i(245687);
    boolean bool = deF();
    Log.i(this.TAG, "chooseMode:" + paramInt + ",whiteListCanChoose:" + bool);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(245687);
      return;
      nf(true);
      ng(false);
      nh(false);
      ne(true);
      k localk = k.vkd;
      k.dpl().a(s.aq.vre);
      AppMethodBeat.o(245687);
      return;
      nf(false);
      ng(true);
      nh(false);
      ne(true);
      localk = k.vkd;
      k.dpl().a(s.aq.vrg);
      AppMethodBeat.o(245687);
      return;
      if (bool)
      {
        nf(false);
        ng(false);
        if (this.uex) {
          nh(false);
        }
        for (;;)
        {
          deB();
          localk = k.vkd;
          k.dpl().a(s.aq.vrf);
          localk = k.vkd;
          k.dpl().vlX = this.uev.size();
          AppMethodBeat.o(245687);
          return;
          nh(true);
        }
      }
      Log.i(this.TAG, "whiteList Can't Choose!");
    }
  }
  
  private final void deB()
  {
    AppMethodBeat.i(245688);
    if (this.uev.size() > 0)
    {
      localWeImageView = this.uel;
      if (localWeImageView != null) {
        localWeImageView.setVisibility(0);
      }
      ne(true);
      AppMethodBeat.o(245688);
      return;
    }
    WeImageView localWeImageView = this.uel;
    if (localWeImageView != null) {
      localWeImageView.setVisibility(8);
    }
    ne(false);
    AppMethodBeat.o(245688);
  }
  
  private final void deC()
  {
    AppMethodBeat.i(245693);
    deE();
    Object localObject = this.ues;
    if (localObject != null) {
      ((i)localObject).ap(this.uew);
    }
    localObject = this.ues;
    if (localObject != null) {
      ((i)localObject).notifyDataSetChanged();
    }
    localObject = this.ueq;
    if (localObject != null)
    {
      ((RecyclerView)localObject).setVisibility(0);
      AppMethodBeat.o(245693);
      return;
    }
    AppMethodBeat.o(245693);
  }
  
  private final void deD()
  {
    AppMethodBeat.i(245694);
    RecyclerView localRecyclerView = this.ueq;
    if (localRecyclerView != null)
    {
      localRecyclerView.setVisibility(8);
      AppMethodBeat.o(245694);
      return;
    }
    AppMethodBeat.o(245694);
  }
  
  private final void deE()
  {
    AppMethodBeat.i(245695);
    this.uew.clear();
    Iterator localIterator1 = ((Iterable)this.ueu).iterator();
    if (localIterator1.hasNext())
    {
      avh localavh = (avh)localIterator1.next();
      Iterator localIterator2 = ((Iterable)this.uev).iterator();
      Object localObject;
      while (localIterator2.hasNext())
      {
        localObject = localIterator2.next();
        if (p.j(((avh)localObject).KRd, localavh.KRd)) {
          label96:
          if (localObject == null) {
            break label128;
          }
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        this.uew.add(new i.c(bool, localavh));
        break;
        localObject = null;
        break label96;
      }
    }
    AppMethodBeat.o(245695);
  }
  
  private final boolean deF()
  {
    AppMethodBeat.i(245697);
    if (this.ueu.size() > 0)
    {
      AppMethodBeat.o(245697);
      return true;
    }
    AppMethodBeat.o(245697);
    return false;
  }
  
  private final void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(245705);
    Log.i(this.TAG, "goBack isCancel:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(245705);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(uey, this.uet);
    String str = ueA;
    Object localObject1 = this.uev;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((avh)((Iterator)localObject2).next()).toByteArray());
      }
      localObject1 = (List)localObject1;
      label148:
      if ((localObject1 instanceof Serializable)) {
        break label182;
      }
      localObject1 = null;
    }
    label182:
    for (;;)
    {
      localIntent.putExtra(str, (Serializable)localObject1);
      setResult(-1, localIntent);
      break;
      localObject1 = null;
      break label148;
    }
  }
  
  private final void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(245689);
    TextView localTextView = this.uee;
    if (localTextView != null) {
      localTextView.setEnabled(paramBoolean);
    }
    Context localContext;
    if (paramBoolean)
    {
      localTextView = this.uee;
      if (localTextView != null)
      {
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localTextView.setTextColor(localContext.getResources().getColor(2131099844));
        AppMethodBeat.o(245689);
        return;
      }
      AppMethodBeat.o(245689);
      return;
    }
    localTextView = this.uee;
    if (localTextView != null)
    {
      localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localTextView.setTextColor(localContext.getResources().getColor(2131099675));
      AppMethodBeat.o(245689);
      return;
    }
    AppMethodBeat.o(245689);
  }
  
  private final void nf(boolean paramBoolean)
  {
    AppMethodBeat.i(245690);
    if (paramBoolean)
    {
      localWeImageView = this.ueg;
      if (localWeImageView != null)
      {
        localWeImageView.setVisibility(0);
        AppMethodBeat.o(245690);
        return;
      }
      AppMethodBeat.o(245690);
      return;
    }
    WeImageView localWeImageView = this.ueg;
    if (localWeImageView != null)
    {
      localWeImageView.setVisibility(8);
      AppMethodBeat.o(245690);
      return;
    }
    AppMethodBeat.o(245690);
  }
  
  private final void ng(boolean paramBoolean)
  {
    AppMethodBeat.i(245691);
    if (paramBoolean)
    {
      localWeImageView = this.uej;
      if (localWeImageView != null)
      {
        localWeImageView.setVisibility(0);
        AppMethodBeat.o(245691);
        return;
      }
      AppMethodBeat.o(245691);
      return;
    }
    WeImageView localWeImageView = this.uej;
    if (localWeImageView != null)
    {
      localWeImageView.setVisibility(8);
      AppMethodBeat.o(245691);
      return;
    }
    AppMethodBeat.o(245691);
  }
  
  private final void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(245692);
    if (paramBoolean)
    {
      localObject = this.uep;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      ni(true);
      deC();
      localObject = this.uer;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        AppMethodBeat.o(245692);
        return;
      }
      AppMethodBeat.o(245692);
      return;
    }
    Object localObject = this.uel;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.uep;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    ni(false);
    deD();
    localObject = this.uer;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(245692);
      return;
    }
    AppMethodBeat.o(245692);
  }
  
  private final void ni(boolean paramBoolean)
  {
    AppMethodBeat.i(245696);
    if (this.uex == paramBoolean)
    {
      Log.i(this.TAG, "setWhiteListFoldState open:" + paramBoolean + " same with foldIconOpen!");
      AppMethodBeat.o(245696);
      return;
    }
    this.uex = paramBoolean;
    if (this.uex)
    {
      localImageView = this.ueo;
      if (localImageView != null)
      {
        localImageView.setRotationX(180.0F);
        AppMethodBeat.o(245696);
        return;
      }
      AppMethodBeat.o(245696);
      return;
    }
    ImageView localImageView = this.ueo;
    if (localImageView != null)
    {
      localImageView.setRotationX(0.0F);
      AppMethodBeat.o(245696);
      return;
    }
    AppMethodBeat.o(245696);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245712);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245712);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245711);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245711);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245704);
    super.finish();
    AppMethodBeat.o(245704);
  }
  
  public final int getLayoutId()
  {
    return 2131494489;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245706);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label99;
      }
      label55:
      if (paramView != null) {
        break label117;
      }
      label59:
      if (paramView != null) {
        break label135;
      }
      label63:
      if (paramView != null) {
        break label161;
      }
      label67:
      if (paramView != null) {
        break label187;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245706);
      return;
      paramView = null;
      break;
      label99:
      if (paramView.intValue() != 2131297972) {
        break label55;
      }
      mD(true);
      continue;
      label117:
      if (paramView.intValue() != 2131301542) {
        break label59;
      }
      mD(false);
      continue;
      label135:
      if (paramView.intValue() != 2131306310) {
        break label63;
      }
      this.uet = 0;
      IT(this.uet);
      continue;
      label161:
      if (paramView.intValue() != 2131307807) {
        break label67;
      }
      this.uet = 2;
      IT(this.uet);
      continue;
      label187:
      if (paramView.intValue() == 2131310498)
      {
        this.uet = 1;
        IT(this.uet);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245686);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle.getWindow().addFlags(2097280);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle.getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle.getWindow().clearFlags(67108864);
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.g(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "context.window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle.getWindow().addFlags(-2147483648);
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.g(paramBundle, "context.window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.g(paramBundle, "context.window");
      paramBundle.setNavigationBarColor(0);
    }
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle.getWindow().setFormat(-3);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle.getWindow().setSoftInputMode(51);
    Log.i(this.TAG, "[onCreate]");
    this.hRR = findViewById(2131309219);
    paramBundle = this.hRR;
    if (paramBundle != null) {
      paramBundle.post((Runnable)new c(this));
    }
    this.ued = ((TextView)findViewById(2131297972));
    paramBundle = this.ued;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.uee = ((TextView)findViewById(2131301542));
    paramBundle = this.uee;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.uef = findViewById(2131306310);
    paramBundle = this.uef;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.ueg = ((WeImageView)findViewById(2131306309));
    this.uei = findViewById(2131307807);
    paramBundle = this.uei;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.uej = ((WeImageView)findViewById(2131307798));
    this.uek = findViewById(2131310498);
    paramBundle = this.uek;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.uel = ((WeImageView)findViewById(2131310492));
    this.uem = ((TextView)findViewById(2131310500));
    this.uen = ((TextView)findViewById(2131310499));
    this.ueo = ((ImageView)findViewById(2131310497));
    this.uep = findViewById(2131310494);
    this.ueq = ((RecyclerView)findViewById(2131310495));
    this.uer = ((TextView)findViewById(2131310493));
    this.ues = new i();
    paramBundle = this.ues;
    if (paramBundle != null) {
      paramBundle.uCb = ((kotlin.g.a.a)new b(this));
    }
    RecyclerView localRecyclerView = this.ueq;
    if (localRecyclerView != null)
    {
      localRecyclerView.getContext();
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localRecyclerView.setAdapter((RecyclerView.a)this.ues);
      localObject = localRecyclerView.getLayoutParams();
      paramBundle = (Bundle)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramBundle = null;
      }
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null) {
        paramBundle.bottomMargin = au.aD(localRecyclerView.getContext());
      }
    }
    Object localObject = getIntent().getSerializableExtra(uez);
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject = m.vVH;
      m.b(paramBundle, this.ueu);
    }
    localObject = getIntent().getSerializableExtra(ueA);
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject = m.vVH;
      m.b(paramBundle, this.uev);
    }
    this.uet = getIntent().getIntExtra(uey, 0);
    boolean bool = deF();
    Log.i(this.TAG, "initLogic chooseMode:" + this.uet + ", visitorWhiteList size:" + this.ueu.size() + ",chooseWhiteList size:" + this.uev.size() + ",whiteListCanChoose:" + bool);
    if (bool)
    {
      paramBundle = this.uen;
      if (paramBundle != null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        paramBundle.setText((CharSequence)((Context)localObject).getResources().getString(2131760217));
      }
      paramBundle = this.ueo;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.uem;
      if (paramBundle != null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        paramBundle.setTextColor(((Context)localObject).getResources().getColor(2131099844));
      }
    }
    for (;;)
    {
      if ((this.uet == 1) && (!bool)) {
        this.uet = 0;
      }
      IT(this.uet);
      AppMethodBeat.o(245686);
      return;
      paramBundle = this.uen;
      if (paramBundle != null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        paramBundle.setText((CharSequence)((Context)localObject).getResources().getString(2131760213));
      }
      paramBundle = this.ueo;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.uem;
      if (paramBundle != null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        paramBundle.setTextColor(((Context)localObject).getResources().getColor(2131099676));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245702);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(245702);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245700);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(245700);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245699);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(245699);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245698);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(245698);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245701);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(245701);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(245703);
    super.onSwipeBack();
    mD(true);
    AppMethodBeat.o(245703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setPublicGroup(View paramView)
  {
    this.uef = paramView;
  }
  
  public final void setShareGroup(View paramView)
  {
    this.uei = paramView;
  }
  
  public final void setTitleGroup(View paramView)
  {
    this.hRR = paramView;
  }
  
  public final void setWhiteListContent(View paramView)
  {
    this.uep = paramView;
  }
  
  public final void setWhiteListGroup(View paramView)
  {
    this.uek = paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14$Companion;", "", "()V", "KEY_PARAMS_CHOOSE_WHITE_LIST", "", "getKEY_PARAMS_CHOOSE_WHITE_LIST", "()Ljava/lang/String;", "setKEY_PARAMS_CHOOSE_WHITE_LIST", "(Ljava/lang/String;)V", "KEY_PARAMS_VISIBILITY_MODE", "getKEY_PARAMS_VISIBILITY_MODE", "setKEY_PARAMS_VISIBILITY_MODE", "KEY_PARAMS_WHITE_LIST", "getKEY_PARAMS_WHITE_LIST", "setKEY_PARAMS_WHITE_LIST", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI14$initLayout$2$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(OccupyFinderUI14 paramOccupyFinderUI14)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(OccupyFinderUI14 paramOccupyFinderUI14) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(245685);
      int i = au.getStatusBarHeight((Context)this.ueC.getContext());
      Object localObject1 = this.ueC.hRR;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject2 != null) {
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
        }
        localObject1 = this.ueC.hRR;
        if (localObject1 == null) {
          break label126;
        }
        localObject1 = ((View)localObject1).getParent();
        label81:
        if ((localObject1 instanceof ViewGroup)) {
          break label137;
        }
        localObject1 = localObject3;
      }
      label137:
      for (;;)
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null)
        {
          ((ViewGroup)localObject1).updateViewLayout(this.ueC.hRR, (ViewGroup.LayoutParams)localObject2);
          AppMethodBeat.o(245685);
          return;
          localObject1 = null;
          break;
          label126:
          localObject1 = null;
          break label81;
        }
        AppMethodBeat.o(245685);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14
 * JD-Core Version:    0.7.0.1
 */