package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.cgi.f.a;
import com.tencent.mm.plugin.finder.live.cgi.m.a;
import com.tencent.mm.plugin.finder.live.util.r;
import com.tencent.mm.plugin.finder.live.view.adapter.z;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.a;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aliasInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "canModifyAlias", "", "curRoleType", "", "deleteBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableVisitorRoleEntrance", "getEnableVisitorRoleEntrance", "()Z", "setEnableVisitorRoleEntrance", "(Z)V", "fromSetting", "liveVisitorRoleGroup", "Landroid/view/View;", "getLiveVisitorRoleGroup", "()Landroid/view/View;", "setLiveVisitorRoleGroup", "(Landroid/view/View;)V", "loadingProgress", "Landroid/widget/ProgressBar;", "modifyTime", "", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "roleTypeOnEnter", "sourceType", "touchLoc", "", "visitorRoleAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "visitorRv", "Landroidx/recyclerview/widget/RecyclerView;", "visitorTips", "Landroid/widget/TextView;", "doRemoveAliasInfo", "", "getModifyTimeInfo", "goBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "parseData", "refreshLayout", "removeAliasInfo", "setActivityResult", "showAlertDialog", "title", "content", "buttonTitle", "showBottomSheet", "showPopupMenu", "itemView", "aliasInfo", "anchorPosX", "anchorPosY", "updateVisitorRole", "Companion", "plugin-finder_release"})
public final class k
  extends UIComponent
{
  private static final int zdo = 10001;
  public static final a zdp;
  final String TAG;
  private int sourceType;
  private com.tencent.mm.ui.widget.b.a szq;
  private int[] xYT;
  private boolean yvE;
  private RecyclerView yzR;
  private z yzV;
  private int zab;
  private View zdf;
  private TextView zdg;
  private ProgressBar zdh;
  private com.tencent.mm.ui.widget.a.e zdi;
  private boolean zdj;
  private LinkedList<axc> zdk;
  private long zdl;
  private boolean zdm;
  private int zdn;
  
  static
  {
    AppMethodBeat.i(280932);
    zdp = new a((byte)0);
    zdo = 10001;
    AppMethodBeat.o(280932);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(280931);
    this.TAG = "FinderLiveVisitorRoleUIC";
    this.yvE = true;
    this.xYT = new int[2];
    this.zdk = new LinkedList();
    this.zab = 1;
    this.zdl = -9223372036854775808L;
    this.zdm = true;
    this.zdn = 1;
    AppMethodBeat.o(280931);
  }
  
  private final void dGm()
  {
    boolean bool = true;
    AppMethodBeat.i(280925);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("setActivityResult fromSetting:").append(this.zdj).append(", ");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    Log.i((String)localObject1, com.tencent.mm.plugin.finder.live.utils.a.a(this.TAG, this.zdk, this.zab, this.zdl));
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.zdk, this.zab, this.zdl);
    localObject1 = getActivity();
    localObject2 = new Intent();
    if (this.sourceType == 1) {
      p.j(((Intent)localObject2).putExtra("KEY_IS_FROM_SETTING", this.zdj), "putExtra(KEY_IS_FROM_SETTING, fromSetting)");
    }
    while (this.sourceType != 2)
    {
      ((AppCompatActivity)localObject1).setResult(-1, (Intent)localObject2);
      AppMethodBeat.o(280925);
      return;
    }
    if (this.zdn != this.zab) {}
    for (;;)
    {
      ((Intent)localObject2).putExtra("KEY_HAS_CHANGE_ROLE", bool);
      break;
      bool = false;
    }
  }
  
  private final void dGn()
  {
    boolean bool2 = true;
    AppMethodBeat.i(280926);
    boolean bool1;
    Object localObject;
    if (this.zdl - cm.bfF() <= 0L)
    {
      bool1 = true;
      localObject = aj.AGc;
      if (!aj.eej()) {
        break label217;
      }
      bool1 = bool2;
    }
    label217:
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      bool2 = com.tencent.mm.plugin.finder.live.utils.a.ar(this.zdk);
      localObject = this.yzV;
      if (localObject != null) {
        ((z)localObject).a(this.zab, this.zdk, bool1);
      }
      localObject = this.yzV;
      if (localObject != null) {
        ((z)localObject).notifyDataSetChanged();
      }
      if (bool1)
      {
        if (!bool2)
        {
          localObject = this.zdg;
          if (localObject != null)
          {
            Context localContext = MMApplicationContext.getContext();
            p.j(localContext, "MMApplicationContext.getContext()");
            ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.finder_live_visitor_role_create_tips));
            AppMethodBeat.o(280926);
            return;
            bool1 = false;
            break;
          }
          AppMethodBeat.o(280926);
          return;
        }
        localObject = this.zdg;
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)"");
          AppMethodBeat.o(280926);
          return;
        }
        AppMethodBeat.o(280926);
        return;
      }
      localObject = this.zdg;
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)dGp());
        AppMethodBeat.o(280926);
        return;
      }
      AppMethodBeat.o(280926);
      return;
    }
  }
  
  private final void dGo()
  {
    AppMethodBeat.i(280927);
    Log.i(this.TAG, "before removeAliasInfo size:" + this.zdk.size());
    Object localObject1 = this.zdk.iterator();
    p.j(localObject1, "aliasInfoList.iterator()");
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      p.j(localObject2, "iterator.next()");
      localObject2 = (axc)localObject2;
      if (((axc)localObject2).SJy == 2)
      {
        ((Iterator)localObject1).remove();
        Log.i(this.TAG, "removeAliasInfo:" + com.tencent.mm.ae.g.bN(localObject2));
      }
    }
    Log.i(this.TAG, "after removeAliasInfo size:" + this.zdk.size());
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.aq(this.zdk);
    AppMethodBeat.o(280927);
  }
  
  private final String dGp()
  {
    AppMethodBeat.i(280928);
    Object localObject = new Time();
    ((Time)localObject).set(this.zdl * 1000L);
    localObject = com.tencent.mm.pluginsdk.j.e.a((CharSequence)getContext().getString(b.j.fmt_longdate), (Time)localObject);
    localObject = getContext().getResources().getString(b.j.finder_live_visitor_forbidden_edit_dialog_content, new Object[] { localObject });
    p.j(localObject, "context.resources.getStr…_dialog_content, timeStr)");
    AppMethodBeat.o(280928);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280929);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(280929);
      return;
      Log.i(this.TAG, "requestCode:" + paramInt1 + ",resultCode:" + paramInt2 + ",data:" + paramIntent);
    } while (paramInt2 != -1);
    Object localObject1;
    if (paramIntent != null)
    {
      localObject1 = a.a.BuJ;
      localObject1 = paramIntent.getStringExtra(a.a.emM());
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2;
      if (paramIntent != null)
      {
        localObject2 = a.a.BuJ;
        localObject2 = paramIntent.getStringExtra(a.a.emN());
        if (localObject2 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      for (;;)
      {
        if (paramIntent != null)
        {
          localObject3 = a.a.BuJ;
          localObject3 = paramIntent.getStringExtra(a.a.emO());
          paramIntent = (Intent)localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          paramIntent = "";
        }
        Object localObject3 = new axc();
        ((axc)localObject3).nickname = ((String)localObject1);
        ((axc)localObject3).ueX = ((String)localObject2);
        ((axc)localObject3).SJz = paramIntent;
        ((axc)localObject3).SJy = 2;
        dGo();
        if (this.zdk.size() > 0) {
          this.zdk.add(1, localObject3);
        }
        for (;;)
        {
          paramIntent = this.yzV;
          if (paramIntent != null) {
            paramIntent.a(this.zab, this.zdk, true);
          }
          paramIntent = this.yzV;
          if (paramIntent != null) {
            paramIntent.notifyDataSetChanged();
          }
          paramIntent = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          com.tencent.mm.plugin.finder.live.utils.a.aq(this.zdk);
          break;
          this.zdk.add(localObject3);
        }
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(280924);
    if ((this.yvE) && ((this.sourceType == 1) || (this.sourceType == 2))) {
      dGm();
    }
    getActivity().finish();
    getActivity().overridePendingTransition(b.a.anim_not_change, b.a.sight_slide_bottom_out);
    AppMethodBeat.o(280924);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280923);
    super.onCreate(paramBundle);
    this.zdf = findViewById(b.f.live_role_group);
    this.zdh = ((ProgressBar)findViewById(b.f.loading_progress));
    paramBundle = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.yvE = com.tencent.mm.plugin.finder.live.utils.a.dEE();
    Object localObject2;
    Object localObject1;
    if (this.yvE)
    {
      paramBundle = this.zdf;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      if (getIntent().getBooleanExtra("intent_status_from_privacy_to_video_setting", false))
      {
        paramBundle = this.zdf;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
      this.yzR = ((RecyclerView)findViewById(b.f.visitor_rv));
      this.zdg = ((TextView)findViewById(b.f.visitor_tips));
      localObject2 = this.zdg;
      if (localObject2 != null)
      {
        localObject1 = ((TextView)localObject2).getLayoutParams();
        paramBundle = (Bundle)localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          paramBundle = null;
        }
        paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
        if (paramBundle != null) {
          paramBundle.bottomMargin = ax.aB(((TextView)localObject2).getContext());
        }
      }
      this.yzV = new z();
      paramBundle = this.yzV;
      if (paramBundle != null)
      {
        paramBundle.yZZ = ((kotlin.g.a.b)new b(this));
        paramBundle.zaa = ((m)new c(this));
      }
      paramBundle = this.yzR;
      if (paramBundle != null)
      {
        paramBundle.getContext();
        paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        paramBundle.setAdapter((RecyclerView.a)this.yzV);
        paramBundle.a((RecyclerView.k)new d(this));
      }
      this.sourceType = getIntent().getIntExtra("KEY_SOURCE", 0);
      this.zdj = getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", true);
      this.zdm = getIntent().getBooleanExtra("KEY_CAN_MODEI_ALIAS", true);
      if ((!this.zdj) && (this.sourceType != 2)) {
        break label576;
      }
      paramBundle = r.yQS;
      this.zdk = r.dEz();
      paramBundle = h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      this.zab = paramBundle.aHp().getInt(ar.a.VyS, 1);
      paramBundle = h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
    }
    for (this.zdl = paramBundle.aHp().a(ar.a.VyW, -9223372036854775808L);; this.zdl = getIntent().getLongExtra("KEY_MODIFY_TIME", -9223372036854775808L))
    {
      if (this.zdk.size() > 0)
      {
        paramBundle = h.aHG();
        p.j(paramBundle, "MMKernel.storage()");
        paramBundle.aHp().set(ar.a.VyX, Boolean.TRUE);
      }
      this.zdn = this.zab;
      paramBundle = this.TAG;
      localObject1 = new StringBuilder("parseInten fromSetting:").append(this.zdj).append(',');
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      Log.i(paramBundle, com.tencent.mm.plugin.finder.live.utils.a.a(this.TAG, this.zdk, this.zab, this.zdl));
      dGn();
      Log.i(this.TAG, "onCreate enableVisitorRoleEntrance:" + this.yvE);
      AppMethodBeat.o(280923);
      return;
      paramBundle = this.zdf;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.zdh;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label576:
      localObject1 = getIntent().getSerializableExtra("KEY_VISITOR_ROLE_LIST");
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof List)) {
        paramBundle = null;
      }
      paramBundle = (List)paramBundle;
      if (paramBundle != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.b(paramBundle, this.zdk);
      }
      this.zab = getIntent().getIntExtra("KEY_VISITOR_ROLE", 1);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280930);
    super.onResume();
    ((PluginFinder)h.ag(PluginFinder.class)).getFinderSyncExtension().gu(65536, 9);
    AppMethodBeat.o(280930);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$Companion;", "", "()V", "KEY_CAN_MODEI_ALIAS", "", "KEY_IS_FROM_SETTING", "KEY_MODIFY_TIME", "KEY_SOURCE", "KEY_VISITOR_ROLE_LIST", "KEY_VISITOR_ROLE_TYPE", "MENU_ID_DELETE_ROLE", "", "MENU_ID_ITEM_DELETE", "MENU_ID_ITEM_EDIT", "REQUEST_CREATE_FINDER_LIVE_ROLE", "SOURCE_FINDER", "SOURCE_FINDER_CHATTING", "SOURCE_LIVE", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<axc, x>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "itemView", "Landroid/view/View;", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$2"})
  static final class c
    extends q
    implements m<axc, View, x>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$3$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.k
  {
    d(k paramk) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(256565);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramMotionEvent, "motionEvent");
      k.b(this.zdq)[0] = ((int)paramMotionEvent.getRawX());
      k.b(this.zdq)[1] = ((int)paramMotionEvent.getRawY());
      AppMethodBeat.o(256565);
      return false;
    }
    
    public final void ao(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(256561);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$$inlined$apply$lambda$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
      p.k(paramRecyclerView, "p0");
      p.k(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$$inlined$apply$lambda$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(256561);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(k paramk) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(280429);
      Log.i(this.zdq.TAG, "showAlertDialog click bOk:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(280429);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements q.f
  {
    f(k paramk) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(269730);
      paramo.a(k.dGq(), this.zdq.getContext().getResources().getColor(b.c.Red_100), (CharSequence)this.zdq.getContext().getResources().getString(b.j.finder_live_visitor_role_delete));
      AppMethodBeat.o(269730);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(k paramk) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(292182);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == k.dGq()) {
        new com.tencent.mm.plugin.finder.live.cgi.f((f.a)new f.a()
        {
          public final void MZ(final int paramAnonymousInt)
          {
            AppMethodBeat.i(287723);
            d.uiThread((kotlin.g.a.a)new a(this, paramAnonymousInt));
            AppMethodBeat.o(287723);
          }
          
          public final void a(ayu paramAnonymousayu)
          {
            AppMethodBeat.i(287722);
            p.k(paramAnonymousayu, "resp");
            d.uiThread((kotlin.g.a.a)new b(this));
            AppMethodBeat.o(287722);
          }
          
          @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
          static final class a
            extends q
            implements kotlin.g.a.a<x>
          {
            a(k.g.1 param1, int paramInt)
            {
              super();
            }
          }
          
          @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
          static final class b
            extends q
            implements kotlin.g.a.a<x>
          {
            b(k.g.1 param1)
            {
              super();
            }
          }
        }).bhW();
      }
      paramMenuItem = k.n(this.zdq);
      if (paramMenuItem != null)
      {
        paramMenuItem.bYF();
        AppMethodBeat.o(292182);
        return;
      }
      AppMethodBeat.o(292182);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class h
    implements View.OnCreateContextMenuListener
  {
    h(k paramk) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(270542);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.zdq.getContext().getResources().getString(b.j.finder_live_visitor_role_edit));
      paramContextMenu.add(0, 2, 1, (CharSequence)this.zdq.getContext().getResources().getString(b.j.finder_live_visitor_role_delete));
      AppMethodBeat.o(270542);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class i
    implements q.g
  {
    i(k paramk, axc paramaxc) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(289883);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(289883);
        return;
        paramMenuItem = k.j(this.zdq);
        if (paramMenuItem != null) {
          paramMenuItem.cFD();
        }
        paramInt = cm.bfF();
        Log.i(this.zdq.TAG, "showPopupMenu modifyTime:" + k.i(this.zdq) + ",serverTime:" + paramInt);
        paramMenuItem = this.zdq.getContext().getResources().getString(b.j.finder_live_visitor_forbidden_edit_dialog_title);
        p.j(paramMenuItem, "context.resources.getStr…bidden_edit_dialog_title)");
        if (k.i(this.zdq) == -9223372036854775808L)
        {
          w.makeText((Context)this.zdq.getContext(), (CharSequence)paramMenuItem, 0).show();
          AppMethodBeat.o(289883);
          return;
        }
        Object localObject = aj.AGc;
        if ((aj.eej()) || (k.i(this.zdq) - cm.bfF() <= 0L))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
          paramMenuItem = (Activity)this.zdq.getActivity();
          localObject = new Intent();
          a.a locala = a.a.BuJ;
          ((Intent)localObject).putExtra(a.a.emM(), this.zdt.nickname);
          locala = a.a.BuJ;
          ((Intent)localObject).putExtra(a.a.emN(), this.zdt.ueX);
          ((Intent)localObject).putExtra("KEY_SOURCE", this.zdq.getIntent().getIntExtra("KEY_SOURCE", 0));
          com.tencent.mm.plugin.finder.utils.a.i(paramMenuItem, (Intent)localObject);
          AppMethodBeat.o(289883);
          return;
        }
        k.a(this.zdq, paramMenuItem, k.k(this.zdq), "");
        AppMethodBeat.o(289883);
        return;
        paramMenuItem = k.j(this.zdq);
        if (paramMenuItem != null) {
          paramMenuItem.cFD();
        }
        k.l(this.zdq);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$updateVisitorRole$2", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder_release"})
  public static final class j
    implements m.a
  {
    j(int paramInt) {}
    
    public final void a(bcy parambcy)
    {
      AppMethodBeat.i(279013);
      p.k(parambcy, "resp");
      d.uiThread((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(279013);
    }
    
    public final void aBO(final String paramString)
    {
      AppMethodBeat.i(279014);
      d.uiThread((kotlin.g.a.a)new a(this, paramString));
      AppMethodBeat.o(279014);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(k.j paramj, String paramString)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(k.j paramj)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.k
 * JD-Core Version:    0.7.0.1
 */