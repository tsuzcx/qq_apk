package com.tencent.mm.plugin.emoji.ui.v3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2PersonFragment;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backBtn", "Landroid/widget/ImageView;", "currentPageIndex", "", "emojiStorePageAdapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomePagerAdapter;", "enablePersonTab", "", "entranceScene", "fragmentCacheMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/ui/MMFragment;", "fragmentRequest", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "getFragmentRequest", "()Lkotlin/jvm/functions/Function1;", "hasReportOriginal", "optionBtn", "pageChangedListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "getPageChangedListener", "()Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "searchBtn", "tabItems", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI$EmojiStoreHomeTabItem;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "addActiveToolsProcessIdleHanlder", "", "changeViewPage", "pos", "fromViewPager", "cleanPersonPoint", "createFragment", "enterMine", "getForceOrientation", "getHomeTabItems", "getLayoutId", "initContentView", "initData", "initTabLayout", "initTitleBar", "initViewPager", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setRequestedOrientation", "requestedOrientation", "startWebSearch", "updateEmojiNewOrFree", "updatePersonPoint", "Companion", "EmojiStoreEmptyFragment", "EmojiStoreHomeTabItem", "UpdateEmojiBadgeRunnable", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3HomeUI
  extends MMActivity
{
  public static final EmojiStoreV3HomeUI.a yad;
  private ImageView nfU;
  private int xYX;
  boolean xZZ;
  private final kotlin.g.a.b<Integer, MMFragment> yaa;
  private ImageView yae;
  private ImageView yaf;
  private int yag;
  private boolean yah;
  private final HashMap<Integer, MMFragment> yai;
  TabLayout yaj;
  CustomViewPager yak;
  List<b> yal;
  private c yam;
  private final ViewPager.OnPageChangeListener yan;
  
  static
  {
    AppMethodBeat.i(270556);
    yad = new EmojiStoreV3HomeUI.a((byte)0);
    AppMethodBeat.o(270556);
  }
  
  public EmojiStoreV3HomeUI()
  {
    AppMethodBeat.i(270502);
    this.xYX = -1;
    this.yai = new HashMap();
    this.xZZ = true;
    this.yaa = ((kotlin.g.a.b)new d(this));
    this.yan = ((ViewPager.OnPageChangeListener)new f(this));
    AppMethodBeat.o(270502);
  }
  
  private static final void a(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI)
  {
    AppMethodBeat.i(270529);
    s.u(paramEmojiStoreV3HomeUI, "this$0");
    Intent localIntent = aj.ipS();
    if (paramEmojiStoreV3HomeUI.xYX == 17)
    {
      i = 50;
      aj.f(localIntent, i);
      localIntent.putExtra("ftsneedkeyboard", true);
      localIntent.putExtra("key_load_js_without_delay", true);
      localIntent.putExtra("ftsInitToSearch", true);
      com.tencent.mm.br.c.b((Context)paramEmojiStoreV3HomeUI.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      if (paramEmojiStoreV3HomeUI.yag != 0) {
        break label124;
      }
    }
    label124:
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13054, new Object[] { Integer.valueOf(i), Integer.valueOf(0), "" });
      AppMethodBeat.o(270529);
      return;
      i = 24;
      break;
    }
  }
  
  private static final void a(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI, View paramView)
  {
    AppMethodBeat.i(270512);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramEmojiStoreV3HomeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEmojiStoreV3HomeUI, "this$0");
    Log.i("MicroMsg.EmojiStoreV3HomeUI", "finish");
    paramEmojiStoreV3HomeUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270512);
  }
  
  private static final void b(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI, View paramView)
  {
    AppMethodBeat.i(270518);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramEmojiStoreV3HomeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEmojiStoreV3HomeUI, "this$0");
    paramView = new Intent();
    paramView.setClass((Context)paramEmojiStoreV3HomeUI, EmojiMineUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramEmojiStoreV3HomeUI, paramView.aYi(), "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "enterMine", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmojiStoreV3HomeUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramEmojiStoreV3HomeUI, "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "enterMine", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270518);
  }
  
  private static final void c(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI, View paramView)
  {
    AppMethodBeat.i(270523);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramEmojiStoreV3HomeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEmojiStoreV3HomeUI, "this$0");
    ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new EmojiStoreV3HomeUI..ExternalSyntheticLambda4(paramEmojiStoreV3HomeUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270523);
  }
  
  private static final boolean dCP()
  {
    AppMethodBeat.i(270533);
    Log.i("MicroMsg.EmojiStoreV3HomeUI", "now try to activity the tools process");
    com.tencent.mm.xwebutil.c.jQF();
    AppMethodBeat.o(270533);
    return false;
  }
  
  public final MMFragment KC(int paramInt)
  {
    AppMethodBeat.i(270643);
    MMFragment localMMFragment;
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.EmojiStoreV3HomeUI", "create fragment failed.");
      localMMFragment = (MMFragment)new EmojiStoreEmptyFragment();
    }
    for (;;)
    {
      Log.d("MicroMsg.EmojiStoreV3HomeUI", "create fragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      localMMFragment.setParent((AppCompatActivity)this);
      AppMethodBeat.o(270643);
      return localMMFragment;
      localMMFragment = (MMFragment)Fragment.instantiate((Context)this, EmojiStoreV3HomeMainFragment.class.getName(), null);
      continue;
      localMMFragment = (MMFragment)Fragment.instantiate((Context)this, EmojiStoreV2PersonFragment.class.getName(), null);
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return h.f.emoji_store_v3_home_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(270628);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.EmojiStoreV3HomeUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    Object localObject = this.yam;
    if (localObject != null)
    {
      localObject = ((c)localObject).KB(this.yag);
      if (localObject != null) {
        ((MMFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    AppMethodBeat.o(270628);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270613);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.EmojiStoreV3HomeUI", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg((Context)this);
      finish();
      AppMethodBeat.o(270613);
      return;
    }
    this.xYX = getIntent().getIntExtra("download_entrance_scene", -1);
    paramBundle = com.tencent.mm.k.i.aRC().getValue("ShowPersonalEmotion");
    Log.i("MicroMsg.EmojiStoreV3HomeUI", "get dynamic config value:%s", new Object[] { paramBundle });
    boolean bool;
    Object localObject1;
    if ((!Util.isNullOrNil(paramBundle)) && (Util.safeParseInt(paramBundle) == 1))
    {
      bool = true;
      this.xZZ = bool;
      if (this.xZZ) {
        this.yag = getIntent().getIntExtra("emoji_tab", 0);
      }
      this.yak = ((CustomViewPager)findViewById(h.e.emoji_store_v3_pager));
      paramBundle = this.yak;
      if (paramBundle != null)
      {
        paramBundle.setOffscreenPageLimit(0);
        this.yam = new c((FragmentActivity)this, this.yag, this.yan, (WxViewPager)paramBundle, this.xZZ, this.yaa);
      }
      this.yae = ((ImageView)findViewById(h.e.action_menu_icon));
      this.nfU = ((ImageView)findViewById(h.e.actionbar_up_indicator_btn));
      this.yaf = ((ImageView)findViewById(h.e.action_search_icon));
      paramBundle = this.nfU;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new EmojiStoreV3HomeUI..ExternalSyntheticLambda2(this));
      }
      paramBundle = this.yae;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new EmojiStoreV3HomeUI..ExternalSyntheticLambda3(this));
      }
      paramBundle = this.yaf;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new EmojiStoreV3HomeUI..ExternalSyntheticLambda1(this));
      }
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      this.yaj = ((TabLayout)findViewById(h.e.tabLayout));
      paramBundle = this.yaj;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      localObject1 = (List)new ArrayList();
      if (!this.xZZ) {
        break label490;
      }
    }
    Object localObject2;
    label490:
    for (paramBundle = p.mutableListOf(new String[] { getContext().getResources().getString(h.h.emoji_store_main_tab), getContext().getResources().getString(h.h.emoji_store_person_tab_more) });; paramBundle = p.mutableListOf(new String[] { getContext().getResources().getString(h.h.emoji_store_title) }))
    {
      paramBundle = ((Iterable)paramBundle).iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (String)paramBundle.next();
        s.s(localObject2, "it");
        ((List)localObject1).add(new b((String)localObject2));
      }
      bool = false;
      break;
    }
    this.yal = ((List)localObject1);
    paramBundle = this.yal;
    label576:
    label732:
    int i;
    if (paramBundle != null)
    {
      localObject1 = ((Iterable)paramBundle).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        paramBundle = this.yaj;
        if (paramBundle == null)
        {
          paramBundle = null;
          ((b)localObject2).dyQ = paramBundle;
          paramBundle = ((b)localObject2).dyQ;
          if (paramBundle != null) {
            paramBundle.jw(h.f.emoji_store_v3_home_tab_item);
          }
          paramBundle = ((b)localObject2).dyQ;
          if (paramBundle != null)
          {
            View localView = paramBundle.dyK;
            if (localView != null)
            {
              ((b)localObject2).yap = ((EmojiStoreV3TabView)localView.findViewById(h.e.tv_tab_title));
              paramBundle = ((b)localObject2).yap;
              if (paramBundle != null) {
                paramBundle.setTitleText(((b)localObject2).wording);
              }
              paramBundle = ((b)localObject2).yap;
              if (paramBundle != null) {
                paramBundle.setTitleTextSize(com.tencent.mm.view.d.e((Context)getContext(), 15.0F));
              }
              paramBundle = ((b)localObject2).yap;
              if (paramBundle != null) {
                paramBundle.setTitleTextColor(getContext().getResources().getColor(h.b.FG_1));
              }
              paramBundle = ((b)localObject2).yap;
              if (paramBundle != null)
              {
                paramBundle = paramBundle.pJJ;
                if (paramBundle != null) {
                  break label875;
                }
                paramBundle = null;
                aw.d((Paint)paramBundle);
              }
              paramBundle = this.yal;
              if (paramBundle != null) {
                break label883;
              }
              i = 0;
              label750:
              if (i > 1) {
                ((b)localObject2).yaq = localView.findViewById(h.e.tab_indicator);
              }
            }
          }
          paramBundle = ((b)localObject2).dyQ;
          if (paramBundle != null) {
            break label893;
          }
          paramBundle = null;
        }
        for (;;)
        {
          ((b)localObject2).yao = paramBundle;
          paramBundle = ((b)localObject2).yao;
          if (paramBundle != null) {
            paramBundle.setPadding((int)getContext().getResources().getDimension(h.c.emoji_store_v3_tab_padding), paramBundle.getPaddingTop(), (int)getContext().getResources().getDimension(h.c.emoji_store_v3_tab_padding), paramBundle.getPaddingBottom());
          }
          paramBundle = ((b)localObject2).dyQ;
          if (paramBundle == null) {
            break;
          }
          localObject2 = this.yaj;
          if (localObject2 == null) {
            break;
          }
          ((TabLayout)localObject2).a(paramBundle, false);
          break;
          paramBundle = paramBundle.WW();
          break label576;
          label875:
          paramBundle = paramBundle.getPaint();
          break label732;
          label883:
          i = paramBundle.size();
          break label750;
          label893:
          paramBundle = paramBundle.dyK;
          if (paramBundle == null) {
            paramBundle = null;
          } else {
            paramBundle = paramBundle.findViewById(h.e.emoji_store_home_ui_tabitem_container);
          }
        }
      }
    }
    paramBundle = this.yaj;
    if (paramBundle != null) {
      paramBundle.a((TabLayout.b)new e(this));
    }
    paramBundle = this.yal;
    if (paramBundle != null)
    {
      paramBundle = (b)paramBundle.get(0);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.yap;
        if (paramBundle != null)
        {
          if (Util.isNullOrNil(j.dzN().xMJ)) {
            break label1132;
          }
          localObject1 = j.dzN().xMJ;
          s.s(localObject1, "getInstance().mainTabWording");
          paramBundle.setTitleText((String)localObject1);
          if (!this.xZZ) {
            paramBundle.setTitleText(h.h.emoji_store_title);
          }
        }
      }
    }
    paramBundle = this.yaj;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.js(0);
      if (paramBundle != null) {
        paramBundle.Xf();
      }
    }
    com.tencent.mm.kernel.h.baH().postToWorker((Runnable)new EmojiStoreV3HomeUI.c());
    if ((this.xZZ) && (this.yaj != null))
    {
      paramBundle = this.yal;
      if (paramBundle == null) {
        i = 0;
      }
      for (;;)
      {
        if (i > 1)
        {
          paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.acIc, Boolean.FALSE);
          if (paramBundle == null)
          {
            paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(270613);
            throw paramBundle;
            label1132:
            if (j.dzN().xMI)
            {
              paramBundle.setTitleText(h.h.emoji_store_main_tab_friends);
              break;
            }
            paramBundle.setTitleText(h.h.emoji_store_main_tab);
            break;
            i = paramBundle.size();
            continue;
          }
          bool = ((Boolean)paramBundle).booleanValue();
          Log.i("MicroMsg.EmojiStoreV3HomeUI", s.X("updatePersonPoint: ", Boolean.valueOf(bool)));
          paramBundle = this.yal;
          if (paramBundle != null)
          {
            paramBundle = (b)paramBundle.get(1);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.yap;
              if (paramBundle != null) {
                paramBundle.ol(bool);
              }
            }
          }
        }
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 0L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 2L, System.currentTimeMillis() - l, false);
    AppMethodBeat.o(270613);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(270635);
    Log.i("MicroMsg.EmojiStoreV3HomeUI", "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(270635);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(270616);
    super.onResume();
    Log.d("MicroMsg.EmojiStoreV3HomeUI", "onResume");
    Looper.myQueue().addIdleHandler(EmojiStoreV3HomeUI..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(270616);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(270658);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(270658);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI$EmojiStoreEmptyFragment;", "Lcom/tencent/mm/ui/MMFragment;", "()V", "getLayoutId", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class EmojiStoreEmptyFragment
    extends MMFragment
  {
    public final int getLayoutId()
    {
      return -1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI$EmojiStoreHomeTabItem;", "", "wording", "", "(Ljava/lang/String;)V", "indicatorView", "Landroid/view/View;", "getIndicatorView", "()Landroid/view/View;", "setIndicatorView", "(Landroid/view/View;)V", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabView", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3TabView;", "getTabView", "()Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3TabView;", "setTabView", "(Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3TabView;)V", "viewContainer", "getViewContainer", "setViewContainer", "getWording", "()Ljava/lang/String;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    TabLayout.e dyQ;
    final String wording;
    View yao;
    EmojiStoreV3TabView yap;
    View yaq;
    
    public b(String paramString)
    {
      AppMethodBeat.i(270443);
      this.wording = paramString;
      AppMethodBeat.o(270443);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/MMFragment;", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Integer, MMFragment>
  {
    d(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI$initTabLayout$2", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "selectedTab", "onTabUnselected", "unSelectedTab", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.google.android.material.tabs.a
  {
    e(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(270448);
      Object localObject1 = EmojiStoreV3HomeUI.b(this.yar);
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = this.yar;
        Iterator localIterator = ((Iterable)localObject2).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          if (i < 0) {
            p.kkW();
          }
          localObject2 = (EmojiStoreV3HomeUI.b)localObject2;
          TabLayout.e locale = ((EmojiStoreV3HomeUI.b)localObject2).dyQ;
          if ((locale != null) && (locale.equals(parame) == true)) {}
          for (int j = 1; j != 0; j = 0)
          {
            Log.d("MicroMsg.EmojiStoreV3HomeUI", s.X("onTabSelected , ", ((EmojiStoreV3HomeUI.b)localObject2).wording));
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yap;
            if (parame != null) {
              parame.setTitleTextColor(((EmojiStoreV3HomeUI)localObject1).getContext().getResources().getColor(h.b.FG_0));
            }
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yaq;
            if (parame != null) {
              parame.setVisibility(0);
            }
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yaq;
            if (parame != null) {
              parame.setBackgroundColor(((EmojiStoreV3HomeUI)localObject1).getContext().getResources().getColor(h.b.FG_0));
            }
            parame = ((EmojiStoreV3HomeUI)localObject1).yak;
            if (parame != null) {
              parame.setCurrentItem(i, true);
            }
            AppMethodBeat.o(270448);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(270448);
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(270451);
      Object localObject1 = EmojiStoreV3HomeUI.b(this.yar);
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = this.yar;
        Iterator localIterator = ((Iterable)localObject2).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          localObject2 = localIterator.next();
          if (i < 0) {
            p.kkW();
          }
          localObject2 = (EmojiStoreV3HomeUI.b)localObject2;
          TabLayout.e locale = ((EmojiStoreV3HomeUI.b)localObject2).dyQ;
          if ((locale != null) && (locale.equals(parame) == true)) {}
          for (int j = 1; j != 0; j = 0)
          {
            Log.d("MicroMsg.EmojiStoreV3HomeUI", s.X("onTabUnselected , ", ((EmojiStoreV3HomeUI.b)localObject2).wording));
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yap;
            if (parame != null) {
              parame.setTitleTextColor(((EmojiStoreV3HomeUI)localObject1).getContext().getResources().getColor(h.b.FG_1));
            }
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yaq;
            if (parame != null) {
              parame.setBackgroundColor(((EmojiStoreV3HomeUI)localObject1).getContext().getResources().getColor(h.b.transparent));
            }
            parame = ((EmojiStoreV3HomeUI.b)localObject2).yaq;
            if (parame != null) {
              parame.setVisibility(4);
            }
            AppMethodBeat.o(270451);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(270451);
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(270456);
      if (parame == null) {}
      for (parame = null;; parame = parame.bba)
      {
        Log.d("MicroMsg.EmojiStoreV3HomeUI", s.X("onTabReselected ", parame));
        AppMethodBeat.o(270456);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeUI$pageChangedListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ViewPager.OnPageChangeListener
  {
    f(EmojiStoreV3HomeUI paramEmojiStoreV3HomeUI) {}
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(270462);
      Log.d("MicroMsg.EmojiStoreV3HomeUI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(270462);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(270458);
      Log.d("MicroMsg.EmojiStoreV3HomeUI", "onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
      EmojiStoreV3HomeUI.a(this.yar, paramInt);
      Object localObject = EmojiStoreV3HomeUI.d(this.yar);
      if (localObject != null)
      {
        localObject = ((TabLayout)localObject).js(paramInt);
        if (localObject != null) {
          ((TabLayout.e)localObject).Xf();
        }
      }
      List localList;
      if ((EmojiStoreV3HomeUI.e(this.yar) == 1) && (!EmojiStoreV3HomeUI.f(this.yar)))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(12090, new Object[0]);
        localObject = this.yar;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIc, Boolean.FALSE);
        if ((((EmojiStoreV3HomeUI)localObject).xZZ) && (((EmojiStoreV3HomeUI)localObject).yaj != null))
        {
          localList = ((EmojiStoreV3HomeUI)localObject).yal;
          if (localList != null) {
            break label199;
          }
        }
      }
      label199:
      for (paramInt = 0;; paramInt = localList.size())
      {
        if (paramInt > 1)
        {
          Log.i("MicroMsg.EmojiStoreV3HomeUI", "cleanPersonPoint");
          localObject = ((EmojiStoreV3HomeUI)localObject).yal;
          if (localObject != null)
          {
            localObject = (EmojiStoreV3HomeUI.b)((List)localObject).get(1);
            if (localObject != null)
            {
              localObject = ((EmojiStoreV3HomeUI.b)localObject).yap;
              if (localObject != null) {
                ((EmojiStoreV3TabView)localObject).ol(false);
              }
            }
          }
        }
        EmojiStoreV3HomeUI.g(this.yar);
        AppMethodBeat.o(270458);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3HomeUI
 * JD-Core Version:    0.7.0.1
 */