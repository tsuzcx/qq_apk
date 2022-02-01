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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.plugin.finder.feed.ai.a;
import com.tencent.mm.plugin.finder.feed.ai.b;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.feed.aj.a.a;
import com.tencent.mm.plugin.finder.feed.model.n.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.utils.k.a.d;
import com.tencent.mm.plugin.finder.utils.k.a.e;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.y;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "cacheId", "", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> roF;
  public static final FinderTopicFeedUI.a rsI;
  private final String TAG = "Finder.FinderTopicFeedUI";
  private HashMap _$_findViewCache;
  private final int nPj = 10003;
  private anu qYj;
  private final int rfH = 10002;
  private long rhr;
  private ai.b rlJ;
  private int rlK;
  private ai.a rlS;
  private final int rsG = 10001;
  private alj rsH;
  
  static
  {
    AppMethodBeat.i(178306);
    rsI = new FinderTopicFeedUI.a((byte)0);
    roF = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  private final void cwi()
  {
    AppMethodBeat.i(166277);
    e locale = new e((Context)this, 0, false);
    locale.a((n.c)new d(this));
    locale.a((n.d)new e(this));
    locale.b((e.b)f.rsK);
    addIconOptionMenu(this.rsG, 2131230845, (MenuItem.OnMenuItemClickListener)new g(locale));
    AppMethodBeat.o(166277);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202518);
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
    AppMethodBeat.o(202518);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(202517);
    if (getIntent().getIntExtra("key_topic_type", 1) == 1)
    {
      AppMethodBeat.o(202517);
      return 22;
    }
    AppMethodBeat.o(202517);
    return 26;
  }
  
  public final int cvJ()
  {
    return 3;
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
    roF.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    this.rlK = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    ac.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (MMActivity)this;
    d.g.b.k.g(str, "topic");
    this.rlS = new ai.a(paramBundle, i, str, (d.g.a.a)new c(this));
    paramBundle = this.rlS;
    if (paramBundle == null) {
      d.g.b.k.aVY("presenter");
    }
    paramBundle.rlK = this.rlK;
    paramBundle = (MMActivity)this;
    Object localObject = (MMActivity)this;
    ai.a locala = this.rlS;
    if (locala == null) {
      d.g.b.k.aVY("presenter");
    }
    this.rlJ = new ai.b(paramBundle, i, str, (MMActivity)localObject, locala);
    paramBundle = this.rlS;
    if (paramBundle == null) {
      d.g.b.k.aVY("presenter");
    }
    localObject = this.rlJ;
    if (localObject == null) {
      d.g.b.k.aVY("viewCallback");
    }
    paramBundle.a((ai.b)localObject);
    this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    paramBundle = (com.tencent.mm.bw.a)new anu();
    localObject = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.qYj = ((anu)paramBundle);
      paramBundle = (com.tencent.mm.bw.a)new alj();
      localObject = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject);
        this.rsH = ((alj)paramBundle);
        if ((this.rhr == 0L) || (this.rsH == null))
        {
          paramBundle = this.rlS;
          if (paramBundle == null) {
            d.g.b.k.aVY("presenter");
          }
          paramBundle.requestRefresh();
          cwi();
          int j = getIntent().getIntExtra("key_report_scene", 0);
          if (j != 0)
          {
            localObject = getIntent().getStringExtra("key_from_user");
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localObject = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.e(j, paramBundle, str, i);
          }
          AppMethodBeat.o(166276);
          return;
          paramBundle = paramBundle;
          ac.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          if (this.rsH != null)
          {
            paramBundle = aj.rmg;
            paramBundle = aj.a.uj(this.rhr);
            locala = this.rlS;
            if (locala == null) {
              d.g.b.k.aVY("presenter");
            }
            localObject = this.rsH;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            anu localanu = this.qYj;
            d.g.b.k.h(paramBundle, "cache");
            d.g.b.k.h(localObject, "rsp");
            n.f localf = new n.f(0, 0, null);
            localf.setLastBuffer(paramBundle.lastBuffer);
            localf.rfD = ((alj)localObject).rfD;
            localf.setIncrementList(paramBundle.dataList);
            localf.setHasMore(true);
            localf.rnr = ((alj)localObject).rmj;
            localf.setPullType(1);
            paramBundle = ((alj)localObject).EFe;
            if (paramBundle != null)
            {
              localObject = paramBundle.Fug;
              paramBundle = (Bundle)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramBundle = "";
            }
            localf.mBH = paramBundle;
            locala.rlI.qYj = localanu;
            locala.a(localf);
          }
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    Object localObject = aj.rmg;
    aj.a.ui(this.rhr);
    localObject = this.rlS;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    ((ai.a)localObject).onDetach();
    roF.clear();
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202515);
    super.onResume();
    Object localObject = this.rlS;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    if (localObject != null)
    {
      localObject = ((ai.a)localObject).rlI;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.feed.model.n)localObject).onAlive();
        AppMethodBeat.o(202515);
        return;
      }
      AppMethodBeat.o(202515);
      return;
    }
    AppMethodBeat.o(202515);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(202516);
    super.onStop();
    Object localObject = this.rlS;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    if (localObject != null)
    {
      localObject = ((ai.a)localObject).rlI;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.feed.model.n)localObject).onDead();
        AppMethodBeat.o(202516);
        return;
      }
      AppMethodBeat.o(202516);
      return;
    }
    AppMethodBeat.o(202516);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.rsJ);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(FinderTopicFeedUI paramFinderTopicFeedUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.c
  {
    d(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(166272);
      d.g.b.k.g(paraml, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paraml.fiA())
      {
        localObject2 = this.rsJ.getContext().getString(2131755893);
        localObject1 = this.rsJ.getContext().getString(2131755892);
        if (!FinderTopicFeedUI.c(this.rsJ)) {
          break label169;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
        localObject2 = com.tencent.mm.plugin.finder.utils.n.dh("", 2131759344);
        localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
        localObject1 = com.tencent.mm.plugin.finder.utils.n.dh("", 2131759345);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.d(this.rsJ);
        localObject2 = (CharSequence)localObject2;
        AppCompatActivity localAppCompatActivity = this.rsJ.getContext();
        d.g.b.k.g(localAppCompatActivity, "context");
        paraml.a(i, (CharSequence)localObject2, 2131690478, localAppCompatActivity.getResources().getColor(2131099699), bool1);
        paraml.a(FinderTopicFeedUI.e(this.rsJ), (CharSequence)localObject1, 2131689817, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label169:
        bool2 = false;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.d
  {
    e(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(166273);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      String str;
      long l;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      if (paramInt == FinderTopicFeedUI.d(this.rsJ))
      {
        if (FinderTopicFeedUI.c(this.rsJ))
        {
          t.makeText((Context)this.rsJ, 2131759344, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.k.rPa;
        localObject1 = (MMActivity)this.rsJ;
        str = FinderTopicFeedUI.f(this.rsJ).dol;
        paramInt = FinderTopicFeedUI.f(this.rsJ).type;
        l = FinderTopicFeedUI.f(this.rsJ).rfD;
        localObject3 = FinderTopicFeedUI.f(this.rsJ).cvw();
        localObject4 = this.rsJ.getString(2131759381, new Object[] { g.vk(FinderTopicFeedUI.f(this.rsJ).rfD) });
        localObject5 = FinderTopicFeedUI.f(this.rsJ).rlI.rnp;
        d.g.b.k.h(localObject1, "context");
        localObject2 = com.tencent.mm.plugin.finder.spam.a.rBD;
        if (!com.tencent.mm.plugin.finder.spam.a.aed("share"))
        {
          localObject2 = new k.b();
          com.tencent.mm.plugin.i.a.c localc = new com.tencent.mm.plugin.i.a.c();
          localObject3 = k.a.a(str, paramInt, (String)localObject3, (String)localObject4, (alt)localObject5);
          d.g.b.k.h(localObject3, "<set-?>");
          localc.hTJ = ((any)localObject3);
          ((k.b)localObject2).a((f)localc);
          ((k.b)localObject2).type = 59;
          ((k.b)localObject2).title = ai.getContext().getString(2131760809);
          ((k.b)localObject2).url = ai.getContext().getString(2131760810);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("Retr_Msg_Type", 21);
          ((Intent)localObject3).putExtra("Multi_Retr", true);
          ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
          ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
          ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
          com.tencent.mm.br.d.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, k.a.rPb, (MMActivity.a)new k.a.d(paramMenuItem, str, paramInt, l));
        }
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.e(this.rsJ))
      {
        if (FinderTopicFeedUI.c(this.rsJ))
        {
          t.makeText((Context)this.rsJ, 2131759345, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.k.rPa;
        paramMenuItem = (MMActivity)this.rsJ;
        localObject1 = FinderTopicFeedUI.f(this.rsJ).dol;
        paramInt = FinderTopicFeedUI.f(this.rsJ).type;
        l = FinderTopicFeedUI.f(this.rsJ).rfD;
        str = FinderTopicFeedUI.f(this.rsJ).cvw();
        localObject2 = this.rsJ.getString(2131759381, new Object[] { g.vk(FinderTopicFeedUI.f(this.rsJ).rfD) });
        localObject3 = FinderTopicFeedUI.f(this.rsJ).rlI.rnp;
        d.g.b.k.h(paramMenuItem, "context");
        localObject4 = com.tencent.mm.plugin.finder.spam.a.rBD;
        if (!com.tencent.mm.plugin.finder.spam.a.aed("share"))
        {
          ac.i(k.a.TAG, "share topic %s to sns", new Object[] { localObject1 });
          localObject4 = new Intent();
          localObject5 = new com.tencent.mm.modelsns.c();
          ((com.tencent.mm.modelsns.c)localObject5).hTJ = k.a.a((String)localObject1, paramInt, str, (String)localObject2, (alt)localObject3);
          ((Intent)localObject4).putExtra("ksnsupload_finder_topic_xml", ((com.tencent.mm.modelsns.c)localObject5).aHU());
          ((Intent)localObject4).putExtra("Ksnsupload_type", 18);
          ((Intent)localObject4).putExtra("need_result", true);
          com.tencent.mm.br.d.a(paramMenuItem, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject4, k.a.rPc, (MMActivity.a)new k.a.e(paramMenuItem, (String)localObject1, paramInt, l));
        }
      }
      AppMethodBeat.o(166273);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    public static final f rsK;
    
    static
    {
      AppMethodBeat.i(166274);
      rsK = new f();
      AppMethodBeat.o(166274);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166275);
      this.rsL.cED();
      AppMethodBeat.o(166275);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */