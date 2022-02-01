package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.a.a;
import com.tencent.mm.plugin.finder.feed.model.i.f;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.plugin.finder.utils.g.a.d;
import com.tencent.mm.plugin.finder.utils.g.a.e;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "cacheId", "", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> qBG;
  public static final a qBH;
  private dzq KJJ;
  private int KPs;
  private aji KTd;
  private final String TAG = "Finder.FinderTopicFeedUI";
  private HashMap _$_findViewCache;
  private final int nmj = 10003;
  private final int qBF = 10001;
  private final int qtU = 10002;
  private l.b qxA;
  private l.a qxF;
  private long qxT;
  
  static
  {
    AppMethodBeat.i(178306);
    qBH = new a((byte)0);
    qBG = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  private final void cmP()
  {
    AppMethodBeat.i(166277);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)this, 0, false);
    locale.a((n.c)new d(this));
    locale.a((n.d)new e(this));
    locale.b((e.b)f.qBJ);
    addIconOptionMenu(this.qBF, 2131230845, (MenuItem.OnMenuItemClickListener)new g(locale));
    AppMethodBeat.o(166277);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198594);
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
    AppMethodBeat.o(198594);
    return localView1;
  }
  
  public final int fTB()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(198593);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(198593);
      return 22;
    }
    AppMethodBeat.o(198593);
    return 26;
  }
  
  public final int getLayoutId()
  {
    return 2131494119;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166276);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772144, 2130771986);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setActionbarColor(getResources().getColor(2131099650));
    qBG.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    this.KPs = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    ad.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (MMActivity)this;
    k.g(str, "topic");
    this.qxF = new l.a(paramBundle, i, str, (d.g.a.a)new c(this));
    paramBundle = this.qxF;
    if (paramBundle == null) {
      k.aPZ("presenter");
    }
    paramBundle.KPs = this.KPs;
    paramBundle = (MMActivity)this;
    Object localObject = (MMActivity)this;
    l.a locala = this.qxF;
    if (locala == null) {
      k.aPZ("presenter");
    }
    this.qxA = new l.b(paramBundle, i, str, (MMActivity)localObject, locala);
    paramBundle = this.qxF;
    if (paramBundle == null) {
      k.aPZ("presenter");
    }
    localObject = this.qxA;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    paramBundle.a((l.b)localObject);
    this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    paramBundle = (com.tencent.mm.bx.a)new dzq();
    localObject = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.KJJ = ((dzq)paramBundle);
      paramBundle = (com.tencent.mm.bx.a)new aji();
      localObject = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject);
        this.KTd = ((aji)paramBundle);
        if ((this.qxT == 0L) || (this.KTd == null))
        {
          paramBundle = this.qxF;
          if (paramBundle == null) {
            k.aPZ("presenter");
          }
          paramBundle.requestRefresh();
          cmP();
          int j = getIntent().getIntExtra("key_report_scene", 0);
          if (j != 0)
          {
            localObject = getIntent().getStringExtra("key_from_user");
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localObject = b.qFq;
            b.e(j, paramBundle, str, i);
          }
          AppMethodBeat.o(166276);
          return;
          paramBundle = paramBundle;
          ad.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          if (this.KTd != null)
          {
            paramBundle = m.qxS;
            paramBundle = m.a.qb(this.qxT);
            locala = this.qxF;
            if (locala == null) {
              k.aPZ("presenter");
            }
            localObject = this.KTd;
            if (localObject == null) {
              k.fvU();
            }
            dzq localdzq = this.KJJ;
            k.h(paramBundle, "cache");
            k.h(localObject, "rsp");
            i.f localf = new i.f(0, 0, null);
            localf.setLastBuffer(paramBundle.lastBuffer);
            localf.qxB = ((aji)localObject).qxB;
            localf.setIncrementList(paramBundle.dataList);
            localf.setHasMore(true);
            localf.KQr = ((aji)localObject).KPE;
            localf.setPullType(1);
            paramBundle = ((aji)localObject).LxD;
            if (paramBundle != null)
            {
              localObject = paramBundle.LAj;
              paramBundle = (Bundle)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramBundle = "";
            }
            localf.lZG = paramBundle;
            locala.qxz.KJJ = localdzq;
            locala.a(localf);
          }
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    Object localObject = m.qxS;
    m.a.BI(this.qxT);
    localObject = this.qxF;
    if (localObject == null) {
      k.aPZ("presenter");
    }
    ((l.a)localObject).onDetach();
    qBG.clear();
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(198591);
    super.onResume();
    Object localObject = this.qxF;
    if (localObject == null) {
      k.aPZ("presenter");
    }
    if (localObject != null)
    {
      localObject = ((l.a)localObject).qxz;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.feed.model.i)localObject).onAlive();
        AppMethodBeat.o(198591);
        return;
      }
      AppMethodBeat.o(198591);
      return;
    }
    AppMethodBeat.o(198591);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(198592);
    super.onStop();
    Object localObject = this.qxF;
    if (localObject == null) {
      k.aPZ("presenter");
    }
    if (localObject != null)
    {
      localObject = ((l.a)localObject).qxz;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.feed.model.i)localObject).onDead();
        AppMethodBeat.o(198592);
        return;
      }
      AppMethodBeat.o(198592);
      return;
    }
    AppMethodBeat.o(198592);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.qBI);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(FinderTopicFeedUI paramFinderTopicFeedUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.c
  {
    d(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(166272);
      k.g(paraml, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paraml.eSQ())
      {
        localObject2 = this.qBI.getContext().getString(2131755893);
        localObject1 = this.qBI.getContext().getString(2131755892);
        if (!FinderTopicFeedUI.c(this.qBI)) {
          break label169;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject2 = com.tencent.mm.plugin.finder.utils.i.dc("", 2131759344);
        localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject1 = com.tencent.mm.plugin.finder.utils.i.dc("", 2131759345);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.d(this.qBI);
        localObject2 = (CharSequence)localObject2;
        AppCompatActivity localAppCompatActivity = this.qBI.getContext();
        k.g(localAppCompatActivity, "context");
        paraml.a(i, (CharSequence)localObject2, 2131690478, localAppCompatActivity.getResources().getColor(2131099699), bool1);
        paraml.a(FinderTopicFeedUI.e(this.qBI), (CharSequence)localObject1, 2131689817, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label169:
        bool2 = false;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.d
  {
    e(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(166273);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      String str;
      long l;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      if (paramInt == FinderTopicFeedUI.d(this.qBI))
      {
        if (FinderTopicFeedUI.c(this.qBI))
        {
          t.makeText((Context)this.qBI, 2131759344, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = g.qSw;
        localObject1 = (MMActivity)this.qBI;
        str = FinderTopicFeedUI.f(this.qBI).dqA;
        paramInt = FinderTopicFeedUI.f(this.qBI).type;
        l = FinderTopicFeedUI.f(this.qBI).qxB;
        localObject3 = FinderTopicFeedUI.f(this.qBI).cmt();
        localObject4 = this.qBI.getString(2131759381, new Object[] { com.tencent.mm.plugin.finder.utils.e.qN(FinderTopicFeedUI.f(this.qBI).qxB) });
        localObject5 = FinderTopicFeedUI.f(this.qBI).qxz.qyK;
        k.h(localObject1, "context");
        localObject2 = com.tencent.mm.plugin.finder.spam.a.qIC;
        if (!com.tencent.mm.plugin.finder.spam.a.Zv("share"))
        {
          localObject2 = new k.b();
          com.tencent.mm.plugin.i.a.c localc = new com.tencent.mm.plugin.i.a.c();
          localObject3 = g.a.a(str, paramInt, (String)localObject3, (String)localObject4, (ajq)localObject5);
          k.h(localObject3, "<set-?>");
          localc.hth = ((ale)localObject3);
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
          d.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, g.a.qSx, (MMActivity.a)new g.a.d(paramMenuItem, str, paramInt, l));
        }
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.e(this.qBI))
      {
        if (FinderTopicFeedUI.c(this.qBI))
        {
          t.makeText((Context)this.qBI, 2131759345, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = g.qSw;
        paramMenuItem = (MMActivity)this.qBI;
        localObject1 = FinderTopicFeedUI.f(this.qBI).dqA;
        paramInt = FinderTopicFeedUI.f(this.qBI).type;
        l = FinderTopicFeedUI.f(this.qBI).qxB;
        str = FinderTopicFeedUI.f(this.qBI).cmt();
        localObject2 = this.qBI.getString(2131759381, new Object[] { com.tencent.mm.plugin.finder.utils.e.qN(FinderTopicFeedUI.f(this.qBI).qxB) });
        localObject3 = FinderTopicFeedUI.f(this.qBI).qxz.qyK;
        k.h(paramMenuItem, "context");
        localObject4 = com.tencent.mm.plugin.finder.spam.a.qIC;
        if (!com.tencent.mm.plugin.finder.spam.a.Zv("share"))
        {
          ad.i(g.a.TAG, "share topic %s to sns", new Object[] { localObject1 });
          localObject4 = new Intent();
          localObject5 = new com.tencent.mm.modelsns.c();
          ((com.tencent.mm.modelsns.c)localObject5).hth = g.a.a((String)localObject1, paramInt, str, (String)localObject2, (ajq)localObject3);
          ((Intent)localObject4).putExtra("ksnsupload_finder_topic_xml", ((com.tencent.mm.modelsns.c)localObject5).aBe());
          ((Intent)localObject4).putExtra("Ksnsupload_type", 18);
          ((Intent)localObject4).putExtra("need_result", true);
          d.a(paramMenuItem, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject4, g.a.qSy, (MMActivity.a)new g.a.e(paramMenuItem, (String)localObject1, paramInt, l));
        }
      }
      AppMethodBeat.o(166273);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    public static final f qBJ;
    
    static
    {
      AppMethodBeat.i(166274);
      qBJ = new f();
      AppMethodBeat.o(166274);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166275);
      this.qBK.csG();
      AppMethodBeat.o(166275);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */