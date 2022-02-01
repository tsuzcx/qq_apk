package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.m.a.f;
import com.tencent.mm.plugin.finder.utils.m.a.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> smf;
  public static final FinderTopicFeedUI.a sqP;
  private final String TAG = "Finder.FinderTopicFeedUI";
  private HashMap _$_findViewCache;
  private final int oyq = 10003;
  private arv rRJ;
  private final int sbX = 10002;
  private int sjg;
  private ap.a sqK;
  private ap.b sqL;
  private FinderTopicFeedLoader sqM;
  private final int sqN = 10001;
  private apb sqO;
  
  static
  {
    AppMethodBeat.i(178306);
    sqP = new FinderTopicFeedUI.a((byte)0);
    smf = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  private final void cEi()
  {
    AppMethodBeat.i(166277);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)this, 0, false);
    locale.a((n.d)new c(this));
    locale.a((n.e)new d(this));
    locale.b((e.b)FinderTopicFeedUI.e.sqR);
    addIconOptionMenu(this.sqN, 2131230845, (MenuItem.OnMenuItemClickListener)new FinderTopicFeedUI.f(locale));
    AppMethodBeat.o(166277);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203380);
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
    AppMethodBeat.o(203380);
    return localView1;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(203378);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(203378);
      return 22;
    }
    AppMethodBeat.o(203378);
    return 26;
  }
  
  public final int cDL()
  {
    return 3;
  }
  
  public final int getLayoutId()
  {
    return 2131494119;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(166276);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772144, 2130771986);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setActionbarColor(getResources().getColor(2131099650));
    smf.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    this.sjg = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    ae.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (com.tencent.mm.bw.a)new arv();
    Object localObject2 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      this.rRJ = ((arv)paramBundle);
      paramBundle = (com.tencent.mm.bw.a)new apb();
      localObject2 = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.sqO = ((apb)paramBundle);
        d.g.b.p.g(str, "topic");
        paramBundle = com.tencent.mm.ui.component.a.KEX;
        paramBundle = new FinderTopicFeedLoader(i, str, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
        localObject2 = getIntent();
        d.g.b.p.g(localObject2, "intent");
        paramBundle.initFromCache((Intent)localObject2);
        this.sqM = paramBundle;
        paramBundle = (MMActivity)this;
        cCL();
        localObject2 = this.sqM;
        if (localObject2 == null) {
          d.g.b.p.bdF("feedLoader");
        }
        paramBundle = new ap.a(paramBundle, (BaseFinderFeedLoader)localObject2);
        cEi();
        d.g.b.p.h(str, "<set-?>");
        paramBundle.dBe = str;
        paramBundle.type = i;
        this.sqK = paramBundle;
        paramBundle = this.sqK;
        if (paramBundle == null) {
          d.g.b.p.bdF("presenter");
        }
        paramBundle.sjg = this.sjg;
        paramBundle = new ap.b((MMActivity)this, cCL(), (byte)0);
        d.g.b.p.h(str, "<set-?>");
        paramBundle.dBe = str;
        paramBundle.type = i;
        this.sqL = paramBundle;
        paramBundle = this.sqL;
        if (paramBundle == null) {
          d.g.b.p.bdF("viewCallback");
        }
        localObject2 = this.sqK;
        if (localObject2 == null) {
          d.g.b.p.bdF("presenter");
        }
        paramBundle.a((b.a)localObject2);
        paramBundle = this.sqL;
        if (paramBundle == null) {
          d.g.b.p.bdF("viewCallback");
        }
        if (this.sqO == null)
        {
          bool = true;
          paramBundle.sjt = bool;
          paramBundle = this.sqK;
          if (paramBundle == null) {
            d.g.b.p.bdF("presenter");
          }
          localObject2 = this.sqL;
          if (localObject2 == null) {
            d.g.b.p.bdF("viewCallback");
          }
          paramBundle.a((b.b)localObject2);
          if ((this.sqO == null) || (this.sqO == null)) {
            break label847;
          }
          localObject2 = this.sqK;
          if (localObject2 == null) {
            d.g.b.p.bdF("presenter");
          }
          apb localapb = this.sqO;
          if (localapb == null) {
            d.g.b.p.gkB();
          }
          localarv = this.rRJ;
          d.g.b.p.h(localapb, "rsp");
          locale = new FinderTopicFeedLoader.e(0, 0, null);
          com.tencent.mm.plugin.finder.feed.model.e locale1 = ((b.a)localObject2).scw.getCache();
          paramBundle = (Bundle)localObject1;
          if (locale1 != null) {
            paramBundle = locale1.lastBuffer;
          }
          locale.setLastBuffer(paramBundle);
          locale.sbT = localapb.sbT;
          paramBundle = com.tencent.mm.plugin.finder.utils.p.sXz;
          paramBundle = ((b.a)localObject2).scw.getCache();
          if (paramBundle == null) {
            break label815;
          }
          paramBundle = paramBundle.jhZ;
          if (paramBundle == null) {
            break label815;
          }
          paramBundle = (List)paramBundle;
          locale.setIncrementList(com.tencent.mm.plugin.finder.utils.p.a(paramBundle, BaseFinderFeed.class));
          locale.setHasMore(true);
          locale.slh = localapb.sjy;
          locale.setPullType(1);
          paramBundle = localapb.GGq;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.HxL;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          locale.nhq = paramBundle;
          paramBundle = ((b.a)localObject2).scw;
          if (paramBundle != null) {
            break label825;
          }
          paramBundle = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(166276);
          throw paramBundle;
          paramBundle = paramBundle;
          ae.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        arv localarv;
        FinderTopicFeedLoader.e locale;
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          boolean bool = false;
          continue;
          label815:
          paramBundle = (List)d.a.v.NhH;
        }
        label825:
        ((FinderTopicFeedLoader)paramBundle).rRJ = localarv;
        ((b.a)localObject2).scw.onFetchDone((IResponse)locale);
        label847:
        cEi();
        int j = getIntent().getIntExtra("key_report_scene", 0);
        if (j != 0)
        {
          localObject1 = getIntent().getStringExtra("key_from_user");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          localObject1 = i.syT;
          i.e(j, paramBundle, str, i);
        }
        AppMethodBeat.o(166276);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    ap.a locala = this.sqK;
    if (locala == null) {
      d.g.b.p.bdF("presenter");
    }
    locala.onDetach();
    smf.clear();
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.sqQ);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements n.d
  {
    c(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(166272);
      d.g.b.p.g(paraml, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paraml.fCR())
      {
        localObject2 = this.sqQ.getContext().getString(2131755893);
        localObject1 = this.sqQ.getContext().getString(2131766851);
        if (!FinderTopicFeedUI.b(this.sqQ)) {
          break label169;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.dC("", 2131759344);
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.dC("", 2131759345);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.c(this.sqQ);
        localObject2 = (CharSequence)localObject2;
        AppCompatActivity localAppCompatActivity = this.sqQ.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        paraml.a(i, (CharSequence)localObject2, 2131691565, localAppCompatActivity.getResources().getColor(2131099699), bool1);
        paraml.a(FinderTopicFeedUI.d(this.sqQ), (CharSequence)localObject1, 2131689817, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label169:
        bool2 = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class d
    implements n.e
  {
    d(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(166273);
      d.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      String str;
      long l;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      if (paramInt == FinderTopicFeedUI.c(this.sqQ))
      {
        if (FinderTopicFeedUI.b(this.sqQ))
        {
          t.makeText((Context)this.sqQ, 2131759344, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = m.sWJ;
        localObject1 = (MMActivity)this.sqQ;
        str = FinderTopicFeedUI.e(this.sqQ).dBe;
        paramInt = FinderTopicFeedUI.e(this.sqQ).type;
        l = FinderTopicFeedUI.e(this.sqQ).sbT;
        localObject3 = FinderTopicFeedUI.e(this.sqQ).getIconUrl();
        localObject4 = this.sqQ.getString(2131759381, new Object[] { h.xE(FinderTopicFeedUI.e(this.sqQ).sbT) });
        localObject5 = FinderTopicFeedUI.f(this.sqQ).slb;
        d.g.b.p.h(localObject1, "context");
        localObject2 = com.tencent.mm.plugin.finder.spam.a.sEK;
        if (!com.tencent.mm.plugin.finder.spam.a.ajm("share"))
        {
          localObject2 = new k.b();
          com.tencent.mm.plugin.i.a.c localc = new com.tencent.mm.plugin.i.a.c();
          localObject3 = m.a.a(str, paramInt, (String)localObject3, (String)localObject4, (apl)localObject5);
          d.g.b.p.h(localObject3, "<set-?>");
          localc.ipX = ((arz)localObject3);
          ((k.b)localObject2).a((f)localc);
          ((k.b)localObject2).type = 59;
          ((k.b)localObject2).title = ak.getContext().getString(2131760809);
          ((k.b)localObject2).url = ak.getContext().getString(2131760810);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("Retr_Msg_Type", 21);
          ((Intent)localObject3).putExtra("Multi_Retr", true);
          ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
          ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
          ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
          d.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, m.a.sWK, (MMActivity.a)new m.a.f(paramMenuItem, str, paramInt, l));
        }
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.d(this.sqQ))
      {
        if (FinderTopicFeedUI.b(this.sqQ))
        {
          t.makeText((Context)this.sqQ, 2131759345, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = m.sWJ;
        paramMenuItem = (MMActivity)this.sqQ;
        localObject1 = FinderTopicFeedUI.e(this.sqQ).dBe;
        paramInt = FinderTopicFeedUI.e(this.sqQ).type;
        l = FinderTopicFeedUI.e(this.sqQ).sbT;
        str = FinderTopicFeedUI.e(this.sqQ).getIconUrl();
        localObject2 = this.sqQ.getString(2131759381, new Object[] { h.xE(FinderTopicFeedUI.e(this.sqQ).sbT) });
        localObject3 = FinderTopicFeedUI.f(this.sqQ).slb;
        d.g.b.p.h(paramMenuItem, "context");
        localObject4 = com.tencent.mm.plugin.finder.spam.a.sEK;
        if (!com.tencent.mm.plugin.finder.spam.a.ajm("share"))
        {
          ae.i(m.a.TAG, "share topic %s to sns", new Object[] { localObject1 });
          localObject4 = new Intent();
          localObject5 = new com.tencent.mm.modelsns.c();
          ((com.tencent.mm.modelsns.c)localObject5).ipX = m.a.a((String)localObject1, paramInt, str, (String)localObject2, (apl)localObject3);
          ((Intent)localObject4).putExtra("ksnsupload_finder_topic_xml", ((com.tencent.mm.modelsns.c)localObject5).aLC());
          ((Intent)localObject4).putExtra("Ksnsupload_type", 18);
          ((Intent)localObject4).putExtra("need_result", true);
          d.a(paramMenuItem, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject4, m.a.sWL, (MMActivity.a)new m.a.g(paramMenuItem, (String)localObject1, paramInt, l));
        }
      }
      AppMethodBeat.o(166273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */