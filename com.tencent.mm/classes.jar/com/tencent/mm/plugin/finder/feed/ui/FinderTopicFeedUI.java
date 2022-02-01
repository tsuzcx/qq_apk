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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.m.a.f;
import com.tencent.mm.plugin.finder.utils.m.a.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> sdo;
  public static final a shU;
  private final String TAG = "Finder.FinderTopicFeedUI";
  private HashMap _$_findViewCache;
  private final int orP = 10003;
  private arg rJv;
  private final int rTt = 10002;
  private int sar;
  private ap.a shP;
  private ap.b shQ;
  private FinderTopicFeedLoader shR;
  private final int shS = 10001;
  private aoo shT;
  
  static
  {
    AppMethodBeat.i(178306);
    shU = new a((byte)0);
    sdo = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  private final void cCw()
  {
    AppMethodBeat.i(166277);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)this, 0, false);
    locale.a((n.d)new c(this));
    locale.a((n.e)new d(this));
    locale.b((e.b)e.shW);
    addIconOptionMenu(this.shS, 2131230845, (MenuItem.OnMenuItemClickListener)new f(locale));
    AppMethodBeat.o(166277);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202901);
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
    AppMethodBeat.o(202901);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(202899);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(202899);
      return 22;
    }
    AppMethodBeat.o(202899);
    return 26;
  }
  
  public final int cBZ()
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
    sdo.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    this.sar = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    ad.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (com.tencent.mm.bx.a)new arg();
    Object localObject2 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      this.rJv = ((arg)paramBundle);
      paramBundle = (com.tencent.mm.bx.a)new aoo();
      localObject2 = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.shT = ((aoo)paramBundle);
        d.g.b.p.g(str, "topic");
        paramBundle = com.tencent.mm.ui.component.a.KiD;
        paramBundle = new FinderTopicFeedLoader(i, str, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
        localObject2 = getIntent();
        d.g.b.p.g(localObject2, "intent");
        paramBundle.initFromCache((Intent)localObject2);
        this.shR = paramBundle;
        paramBundle = (MMActivity)this;
        cAZ();
        localObject2 = this.shR;
        if (localObject2 == null) {
          d.g.b.p.bcb("feedLoader");
        }
        paramBundle = new ap.a(paramBundle, (BaseFinderFeedLoader)localObject2);
        cCw();
        d.g.b.p.h(str, "<set-?>");
        paramBundle.dzZ = str;
        paramBundle.type = i;
        this.shP = paramBundle;
        paramBundle = this.shP;
        if (paramBundle == null) {
          d.g.b.p.bcb("presenter");
        }
        paramBundle.sar = this.sar;
        paramBundle = new ap.b((MMActivity)this, cAZ(), (byte)0);
        d.g.b.p.h(str, "<set-?>");
        paramBundle.dzZ = str;
        paramBundle.type = i;
        this.shQ = paramBundle;
        paramBundle = this.shQ;
        if (paramBundle == null) {
          d.g.b.p.bcb("viewCallback");
        }
        localObject2 = this.shP;
        if (localObject2 == null) {
          d.g.b.p.bcb("presenter");
        }
        paramBundle.a((b.a)localObject2);
        paramBundle = this.shQ;
        if (paramBundle == null) {
          d.g.b.p.bcb("viewCallback");
        }
        if (this.shT == null)
        {
          bool = true;
          paramBundle.saE = bool;
          paramBundle = this.shP;
          if (paramBundle == null) {
            d.g.b.p.bcb("presenter");
          }
          localObject2 = this.shQ;
          if (localObject2 == null) {
            d.g.b.p.bcb("viewCallback");
          }
          paramBundle.a((b.b)localObject2);
          if ((this.shT == null) || (this.shT == null)) {
            break label847;
          }
          localObject2 = this.shP;
          if (localObject2 == null) {
            d.g.b.p.bcb("presenter");
          }
          aoo localaoo = this.shT;
          if (localaoo == null) {
            d.g.b.p.gfZ();
          }
          localarg = this.rJv;
          d.g.b.p.h(localaoo, "rsp");
          locale = new FinderTopicFeedLoader.e(0, 0, null);
          com.tencent.mm.plugin.finder.feed.model.e locale1 = ((b.a)localObject2).rTS.getCache();
          paramBundle = (Bundle)localObject1;
          if (locale1 != null) {
            paramBundle = locale1.lastBuffer;
          }
          locale.setLastBuffer(paramBundle);
          locale.rTp = localaoo.rTp;
          paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
          paramBundle = ((b.a)localObject2).rTS.getCache();
          if (paramBundle == null) {
            break label815;
          }
          paramBundle = paramBundle.jfg;
          if (paramBundle == null) {
            break label815;
          }
          paramBundle = (List)paramBundle;
          locale.setIncrementList(com.tencent.mm.plugin.finder.utils.p.a(paramBundle, BaseFinderFeed.class));
          locale.setHasMore(true);
          locale.scq = localaoo.saJ;
          locale.setPullType(1);
          paramBundle = localaoo.Gnk;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.Hel;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          locale.nch = paramBundle;
          paramBundle = ((b.a)localObject2).rTS;
          if (paramBundle != null) {
            break label825;
          }
          paramBundle = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(166276);
          throw paramBundle;
          paramBundle = paramBundle;
          ad.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        arg localarg;
        FinderTopicFeedLoader.e locale;
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          boolean bool = false;
          continue;
          label815:
          paramBundle = (List)d.a.v.MKE;
        }
        label825:
        ((FinderTopicFeedLoader)paramBundle).rJv = localarg;
        ((b.a)localObject2).rTS.onFetchDone((IResponse)locale);
        label847:
        cCw();
        int j = getIntent().getIntExtra("key_report_scene", 0);
        if (j != 0)
        {
          localObject1 = getIntent().getStringExtra("key_from_user");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
          com.tencent.mm.plugin.finder.report.h.e(j, paramBundle, str, i);
        }
        AppMethodBeat.o(166276);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    ap.a locala = this.shP;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    locala.onDetach();
    sdo.clear();
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.shV);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
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
      if (paraml.fyP())
      {
        localObject2 = this.shV.getContext().getString(2131755893);
        localObject1 = this.shV.getContext().getString(2131766851);
        if (!FinderTopicFeedUI.b(this.shV)) {
          break label169;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.dx("", 2131759344);
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.dx("", 2131759345);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.c(this.shV);
        localObject2 = (CharSequence)localObject2;
        AppCompatActivity localAppCompatActivity = this.shV.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        paraml.a(i, (CharSequence)localObject2, 2131691565, localAppCompatActivity.getResources().getColor(2131099699), bool1);
        paraml.a(FinderTopicFeedUI.d(this.shV), (CharSequence)localObject1, 2131689817, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label169:
        bool2 = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
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
      if (paramInt == FinderTopicFeedUI.c(this.shV))
      {
        if (FinderTopicFeedUI.b(this.shV))
        {
          t.makeText((Context)this.shV, 2131759344, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = m.sLy;
        localObject1 = (MMActivity)this.shV;
        str = FinderTopicFeedUI.e(this.shV).dzZ;
        paramInt = FinderTopicFeedUI.e(this.shV).type;
        l = FinderTopicFeedUI.e(this.shV).rTp;
        localObject3 = FinderTopicFeedUI.e(this.shV).getIconUrl();
        localObject4 = this.shV.getString(2131759381, new Object[] { com.tencent.mm.plugin.finder.utils.h.xn(FinderTopicFeedUI.e(this.shV).rTp) });
        localObject5 = FinderTopicFeedUI.f(this.shV).sck;
        d.g.b.p.h(localObject1, "context");
        localObject2 = com.tencent.mm.plugin.finder.spam.a.suA;
        if (!com.tencent.mm.plugin.finder.spam.a.aip("share"))
        {
          localObject2 = new k.b();
          com.tencent.mm.plugin.i.a.c localc = new com.tencent.mm.plugin.i.a.c();
          localObject3 = m.a.a(str, paramInt, (String)localObject3, (String)localObject4, (aoy)localObject5);
          d.g.b.p.h(localObject3, "<set-?>");
          localc.ind = ((ark)localObject3);
          ((k.b)localObject2).a((f)localc);
          ((k.b)localObject2).type = 59;
          ((k.b)localObject2).title = aj.getContext().getString(2131760809);
          ((k.b)localObject2).url = aj.getContext().getString(2131760810);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("Retr_Msg_Type", 21);
          ((Intent)localObject3).putExtra("Multi_Retr", true);
          ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
          ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
          ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
          d.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, m.a.sLz, (MMActivity.a)new m.a.f(paramMenuItem, str, paramInt, l));
        }
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.d(this.shV))
      {
        if (FinderTopicFeedUI.b(this.shV))
        {
          t.makeText((Context)this.shV, 2131759345, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = m.sLy;
        paramMenuItem = (MMActivity)this.shV;
        localObject1 = FinderTopicFeedUI.e(this.shV).dzZ;
        paramInt = FinderTopicFeedUI.e(this.shV).type;
        l = FinderTopicFeedUI.e(this.shV).rTp;
        str = FinderTopicFeedUI.e(this.shV).getIconUrl();
        localObject2 = this.shV.getString(2131759381, new Object[] { com.tencent.mm.plugin.finder.utils.h.xn(FinderTopicFeedUI.e(this.shV).rTp) });
        localObject3 = FinderTopicFeedUI.f(this.shV).sck;
        d.g.b.p.h(paramMenuItem, "context");
        localObject4 = com.tencent.mm.plugin.finder.spam.a.suA;
        if (!com.tencent.mm.plugin.finder.spam.a.aip("share"))
        {
          ad.i(m.a.TAG, "share topic %s to sns", new Object[] { localObject1 });
          localObject4 = new Intent();
          localObject5 = new com.tencent.mm.modelsns.c();
          ((com.tencent.mm.modelsns.c)localObject5).ind = m.a.a((String)localObject1, paramInt, str, (String)localObject2, (aoy)localObject3);
          ((Intent)localObject4).putExtra("ksnsupload_finder_topic_xml", ((com.tencent.mm.modelsns.c)localObject5).aLf());
          ((Intent)localObject4).putExtra("Ksnsupload_type", 18);
          ((Intent)localObject4).putExtra("need_result", true);
          d.a(paramMenuItem, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject4, m.a.sLA, (MMActivity.a)new m.a.g(paramMenuItem, (String)localObject1, paramInt, l));
        }
      }
      AppMethodBeat.o(166273);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e shW;
    
    static
    {
      AppMethodBeat.i(166274);
      shW = new e();
      AppMethodBeat.o(166274);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166275);
      this.shX.cMW();
      AppMethodBeat.o(166275);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */