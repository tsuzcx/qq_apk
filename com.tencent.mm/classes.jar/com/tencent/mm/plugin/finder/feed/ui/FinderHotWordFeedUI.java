package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderHotWordFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderHotWordFeedLoader;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderHotWordFeedUIContract$HotWordFeedPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderHotWordFeedUIContract$HotWordFeedViewCallback;", "getCommentScene", "", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setIconMenu", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHotWordFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> BlP;
  public static final a Bom;
  private v.a Bon;
  private v.b Boo;
  private FinderHotWordFeedLoader Bop;
  
  static
  {
    AppMethodBeat.i(364744);
    Bom = new a((byte)0);
    BlP = new ConcurrentHashMap();
    AppMethodBeat.o(364744);
  }
  
  private static final Map a(FinderHotWordFeedUI paramFinderHotWordFeedUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364738);
    s.u(paramFinderHotWordFeedUI, "this$0");
    paramString = paramFinderHotWordFeedUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramFinderHotWordFeedUI = paramFinderHotWordFeedUI.getIntent();
      if (paramFinderHotWordFeedUI == null) {}
      for (paramFinderHotWordFeedUI = localObject2;; paramFinderHotWordFeedUI = paramFinderHotWordFeedUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderHotWordFeedUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramFinderHotWordFeedUI)) });
        AppMethodBeat.o(364738);
        return paramFinderHotWordFeedUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private static final boolean a(FinderHotWordFeedUI paramFinderHotWordFeedUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364729);
    s.u(paramFinderHotWordFeedUI, "this$0");
    paramFinderHotWordFeedUI.finish();
    paramMenuItem = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    String str1 = c.dLD().dHN();
    String str2 = paramFinderHotWordFeedUI.getClass().getSimpleName();
    long l1 = System.currentTimeMillis();
    paramMenuItem = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    long l2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKV();
    paramMenuItem = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    long l3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKV();
    long l4 = System.currentTimeMillis();
    Object localObject = paramFinderHotWordFeedUI.Bop;
    paramMenuItem = (MenuItem)localObject;
    if (localObject == null)
    {
      s.bIx("feedLoader");
      paramMenuItem = null;
    }
    paramMenuItem = paramMenuItem.getContextObj();
    String str3;
    int i;
    if (paramMenuItem == null)
    {
      paramMenuItem = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b.zHc.value;
      localObject = paramFinderHotWordFeedUI.Bop;
      paramFinderHotWordFeedUI = (FinderHotWordFeedUI)localObject;
      if (localObject == null)
      {
        s.bIx("feedLoader");
        paramFinderHotWordFeedUI = null;
      }
      paramFinderHotWordFeedUI = paramFinderHotWordFeedUI.getContextObj();
      if (paramFinderHotWordFeedUI != null) {
        break label209;
      }
      paramFinderHotWordFeedUI = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, paramMenuItem, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), paramFinderHotWordFeedUI, 1280));
      AppMethodBeat.o(364729);
      return true;
      localObject = paramMenuItem.zIB;
      paramMenuItem = (MenuItem)localObject;
      if (localObject != null) {
        break;
      }
      paramMenuItem = "";
      break;
      label209:
      localObject = paramFinderHotWordFeedUI.zIO;
      paramFinderHotWordFeedUI = (FinderHotWordFeedUI)localObject;
      if (localObject == null) {
        paramFinderHotWordFeedUI = "";
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 115;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_hot_word_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364780);
    super.onCreate(paramBundle);
    overridePendingTransition(e.a.slide_right_in, e.a.anim_not_change);
    setBackBtn(new FinderHotWordFeedUI..ExternalSyntheticLambda0(this));
    setActionbarColor(getResources().getColor(e.b.BG_2));
    paramBundle = FinderTopicFeedUI.Bst;
    FinderTopicFeedUI.eeA().clear();
    int i = getIntent().getIntExtra("key_topic_type", 10);
    int j = getIntent().getIntExtra("key_jump_scene", -1);
    Object localObject2 = getIntent().getStringExtra("key_hot_word");
    paramBundle = getIntent().getStringExtra("key_pass_by_info");
    Log.i("Finder.FinderHotWordFeedUI", "type:" + i + ", topic:" + localObject2 + "， passByInfo:" + paramBundle);
    setMMTitle((String)localObject2);
    Object localObject1 = k.aeZF;
    localObject1 = new FinderHotWordFeedLoader(i, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    Object localObject3 = getIntent();
    s.s(localObject3, "intent");
    ((FinderHotWordFeedLoader)localObject1).initFromCache((Intent)localObject3);
    ((FinderHotWordFeedLoader)localObject1).sceneType = j;
    ((FinderHotWordFeedLoader)localObject1).BgC = paramBundle;
    paramBundle = ah.aiuX;
    this.Bop = ((FinderHotWordFeedLoader)localObject1);
    localObject3 = (MMActivity)this;
    localObject1 = this.Bop;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("feedLoader");
      paramBundle = null;
    }
    paramBundle = new v.a((MMActivity)localObject3, (BaseFinderFeedLoader)paramBundle);
    paramBundle.type = i;
    paramBundle.topic = ((String)localObject2);
    localObject1 = ah.aiuX;
    this.Bon = paramBundle;
    paramBundle = new v.b((MMActivity)this);
    paramBundle.type = i;
    paramBundle.topic = ((String)localObject2);
    localObject1 = ah.aiuX;
    this.Boo = paramBundle;
    paramBundle = this.Boo;
    if (paramBundle == null)
    {
      s.bIx("viewCallback");
      paramBundle = null;
      localObject2 = this.Bon;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      paramBundle.a((c.a)localObject1);
      paramBundle = this.Bon;
      if (paramBundle != null) {
        break label525;
      }
      s.bIx("presenter");
      paramBundle = null;
    }
    label525:
    for (;;)
    {
      localObject2 = this.Boo;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      paramBundle.a((com.tencent.mm.plugin.finder.feed.c.b)localObject1);
      paramBundle = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.lZ(System.currentTimeMillis());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgy);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderHotWordFeedUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(364780);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364787);
    v.a locala2 = this.Bon;
    v.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("presenter");
      locala1 = null;
    }
    locala1.onDetach();
    super.onDestroy();
    AppMethodBeat.o(364787);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364806);
    super.onPause();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    String str1 = c.dLD().dHN();
    String str2 = getClass().getSimpleName();
    long l1 = System.currentTimeMillis();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    long l2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    long l3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
    long l4 = System.currentTimeMillis();
    Object localObject2 = this.Bop;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedLoader");
      localObject1 = null;
    }
    localObject1 = ((FinderHotWordFeedLoader)localObject1).getContextObj();
    String str3;
    int i;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b.zHb.value;
      localObject3 = this.Bop;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedLoader");
        localObject2 = null;
      }
      localObject2 = ((FinderHotWordFeedLoader)localObject2).getContextObj();
      if (localObject2 != null) {
        break label224;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, (String)localObject1, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), (String)localObject2, 1280));
      AppMethodBeat.o(364806);
      return;
      localObject2 = ((bui)localObject1).zIB;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label224:
      localObject3 = ((bui)localObject2).zIO;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364799);
    super.onResume();
    a.a locala = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.lY(System.currentTimeMillis());
    AppMethodBeat.o(364799);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderHotWordFeedUI$Companion;", "", "()V", "MENU_ID_COMPLAINT", "", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderHotWordFeedUI
 * JD-Core Version:    0.7.0.1
 */