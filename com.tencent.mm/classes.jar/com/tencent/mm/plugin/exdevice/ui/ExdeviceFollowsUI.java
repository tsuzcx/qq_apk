package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MAX_SELECT_CONTACT", "", "REQUEST_CODE_ADD_FOLLOWER", "REQUEST_CODE_FROM_PROFILE", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "netSceneAddFollow", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "getNetSceneAddFollow", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "setNetSceneAddFollow", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;)V", "netSceneGetFollowList", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "getNetSceneGetFollowList", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "setNetSceneGetFollowList", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;)V", "netSceneProfileDetail", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "getNetSceneProfileDetail", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "setNetSceneProfileDetail", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startSelectUserToFollower", "mRecentLikeUsers", "", "mWechatSportFollows", "mMyFollows", "syncFollowList", "FollowItem", "FollowItemConvert", "app_release"})
public final class ExdeviceFollowsUI
  extends MMSecDataActivity
  implements com.tencent.mm.an.i
{
  s loadingDialog;
  private final ArrayList<a> mXB;
  private WxRecyclerView vnF;
  com.tencent.mm.plugin.exdevice.g.a.i vnG;
  com.tencent.mm.plugin.exdevice.g.a.l vnH;
  private com.tencent.mm.plugin.exdevice.g.a.g vnI;
  private final int vnJ;
  private final int vnK;
  private final int vnL;
  
  public ExdeviceFollowsUI()
  {
    AppMethodBeat.i(283139);
    this.mXB = new ArrayList();
    this.vnJ = 4660;
    this.vnK = 4661;
    this.vnL = 10;
    AppMethodBeat.o(283139);
  }
  
  private final void daz()
  {
    AppMethodBeat.i(283127);
    this.vnG = new com.tencent.mm.plugin.exdevice.g.a.i((Context)this, z.bcZ(), "", null);
    com.tencent.mm.kernel.h.aGY().b((q)this.vnG);
    AppMethodBeat.o(283127);
  }
  
  public final int getLayoutId()
  {
    return R.i.egt;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(283133);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.c(localSet, e.class);
      AppMethodBeat.o(283133);
      return localSet;
    }
    AppMethodBeat.o(283133);
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(283136);
    if (paramInt1 == this.vnJ)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("Select_Contact");
          p.j(paramIntent, "userName");
          paramIntent = ((Collection)n.a((CharSequence)paramIntent, new String[] { "," })).toArray(new String[0]);
          if (paramIntent == null)
          {
            paramIntent = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(283136);
            throw paramIntent;
          }
          paramIntent = Util.stringsToList((String[])paramIntent);
          if (paramIntent == null)
          {
            AppMethodBeat.o(283136);
            return;
          }
          s locals = this.loadingDialog;
          if (locals != null) {
            locals.show();
          }
          this.vnI = new com.tencent.mm.plugin.exdevice.g.a.g((List)paramIntent, null);
          bh.aGY().b((q)this.vnI);
          AppMethodBeat.o(283136);
          return;
        }
        AppMethodBeat.o(283136);
      }
    }
    else if ((paramInt1 == this.vnK) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false)) {
        com.tencent.e.h.ZvG.n((Runnable)new d(this), 500L);
      }
      AppMethodBeat.o(283136);
      return;
    }
    AppMethodBeat.o(283136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283122);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eEf);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    addIconOptionMenu(0, R.k.icons_outlined_add, (MenuItem.OnMenuItemClickListener)new f(this));
    com.tencent.mm.kernel.h.aGY().a(1043, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().a(1777, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().a(1758, (com.tencent.mm.an.i)this);
    this.vnF = ((WxRecyclerView)findViewById(R.h.recycler_view));
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new c(this), this.mXB));
    }
    daz();
    AppMethodBeat.o(283122);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(283125);
    Object localObject = this.vnG;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aGY().a((q)localObject);
    }
    localObject = this.vnH;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aGY().a((q)localObject);
    }
    localObject = this.vnI;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aGY().a((q)localObject);
    }
    com.tencent.mm.kernel.h.aGY().b(1043, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(1777, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(1758, (com.tencent.mm.an.i)this);
    super.onDestroy();
    AppMethodBeat.o(283125);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(283131);
    Object localObject;
    long l1;
    if (p.h(paramq, this.vnG))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mXB.clear();
        paramString = com.tencent.mm.ui.component.g.Xox;
        paramString = ((e)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(e.class)).vsB;
        if (paramString != null)
        {
          paramString = paramString.RIz;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramq = paramString.next();
              if (paramInt1 < 0) {
                j.iBO();
              }
              paramq = (blw)paramq;
              localObject = this.mXB;
              l1 = paramInt1;
              p.j(paramq, "follow");
              ((ArrayList)localObject).add(new a(l1, paramq));
              paramInt1 += 1;
            }
          }
        }
        j.a((List)this.mXB, (Comparator)g.vnR);
        paramString = this.vnF;
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
        if (this.mXB.size() != 0)
        {
          paramString = findViewById(R.h.dPs);
          p.j(paramString, "findViewById<View>(R.id.no_result_tip_tv)");
          paramString.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = findViewById(R.h.loading_bar);
        p.j(paramString, "findViewById<View>(R.id.loading_bar)");
        paramString.setVisibility(8);
        this.vnG = null;
        AppMethodBeat.o(283131);
        return;
        paramString = findViewById(R.h.dPs);
        p.j(paramString, "findViewById<View>(R.id.no_result_tip_tv)");
        paramString.setVisibility(0);
      }
    }
    if (p.h(paramq, this.vnH))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramq = this.vnH;
        if (paramq != null)
        {
          localObject = paramq.viD;
          p.j(localObject, "it.recentLikeUser");
          paramString = paramq.viB;
          p.j(paramString, "it.mWechatSportFollows");
          List localList = paramq.viC;
          p.j(localList, "it.mMyFollows");
          paramq = new Intent();
          localObject = Util.listToString((List)localObject, ",");
          paramq.putExtra("wechat_sport_contact", Util.listToString(paramString, ","));
          paramq.putExtra("wechat_sport_recent_like", (String)localObject);
          paramString = Util.listToString(localList, ",");
          paramq.putExtra("titile", getString(R.l.eCJ));
          paramq.putExtra("list_type", 12);
          paramq.putExtra("max_limit_num", this.vnL);
          paramq.putExtra("too_many_member_tip_string", getString(R.l.eCK, new Object[] { Integer.valueOf(this.vnL) }));
          paramq.putExtra("list_attr", w.P(new int[] { 2, 4, 1, 131072, 128, 64, 16384 }));
          paramq.putExtra("always_select_contact", paramString);
          c.d((Context)this, ".ui.contact.SelectContactUI", paramq, this.vnJ);
        }
      }
      this.vnH = null;
      AppMethodBeat.o(283131);
      return;
    }
    if (p.h(paramq, this.vnI))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt2 = this.mXB.size();
        paramString = this.vnI;
        if (paramString != null)
        {
          paramString = paramString.vhV;
          if (paramString != null)
          {
            if (!((Collection)paramString).isEmpty())
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label762;
              }
            }
            for (;;)
            {
              if (paramString == null) {
                break label767;
              }
              paramString = (Iterable)paramString;
              paramInt1 = 0;
              paramString = paramString.iterator();
              while (paramString.hasNext())
              {
                paramq = paramString.next();
                if (paramInt1 < 0) {
                  j.iBO();
                }
                paramq = (blw)paramq;
                localObject = this.mXB;
                l1 = paramInt2;
                long l2 = paramInt1;
                p.j(paramq, "follow");
                ((ArrayList)localObject).add(new a(l1 + l2, paramq));
                paramInt1 += 1;
              }
              paramInt1 = 0;
              break;
              label762:
              paramString = null;
            }
          }
        }
        label767:
        j.a((List)this.mXB, (Comparator)h.vnS);
        paramString = this.vnF;
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
      }
      paramString = this.loadingDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      this.vnI = null;
    }
    AppMethodBeat.o(283131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "follow", "Lcom/tencent/mm/protocal/protobuf/Follow;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;JLcom/tencent/mm/protocal/protobuf/Follow;)V", "getFollow", "()Lcom/tencent/mm/protocal/protobuf/Follow;", "setFollow", "(Lcom/tencent/mm/protocal/protobuf/Follow;)V", "getId", "()J", "setId", "(J)V", "getItemId", "getItemType", "", "app_release"})
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private long id;
    blw vnM;
    
    public a(blw paramblw)
    {
      AppMethodBeat.i(276628);
      this.id = ???;
      this.vnM = localObject;
      AppMethodBeat.o(276628);
    }
    
    public final int bAQ()
    {
      return 2;
    }
    
    public final long mf()
    {
      return this.id;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.e<ExdeviceFollowsUI.a>
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(283698);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      AppMethodBeat.o(283698);
    }
    
    public final int getLayoutId()
    {
      return R.i.egs;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ExdeviceFollowsUI.b paramb, ExdeviceFollowsUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(273553);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = new Intent((Context)this.vnO.vnN, ExdeviceProfileUI.class);
        paramView.putExtra("username", this.vnP.vnM.username);
        this.vnO.vnN.startActivityForResult(paramView, ExdeviceFollowsUI.a(this.vnO.vnN));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(273553);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class c
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(261155);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new ExdeviceFollowsUI.b(this.vnN);
      AppMethodBeat.o(261155);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$onActivityResult$2$1"})
  static final class d
    implements Runnable
  {
    d(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(274842);
      ExdeviceFollowsUI.b(this.vnN);
      AppMethodBeat.o(274842);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(284214);
      this.vnN.finish();
      AppMethodBeat.o(284214);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(279324);
      paramMenuItem = this.vnN;
      Context localContext = (Context)this.vnN;
      this.vnN.getString(R.l.app_tip);
      paramMenuItem.loadingDialog = com.tencent.mm.ui.base.h.b(localContext, this.vnN.getString(R.l.loading_tips), true, (DialogInterface.OnCancelListener)new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(250861);
          com.tencent.mm.plugin.exdevice.g.a.i locali = this.vnQ.vnN.vnG;
          if (locali != null) {
            com.tencent.mm.kernel.h.aGY().a((q)locali);
          }
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(250861);
        }
      });
      this.vnN.vnH = new com.tencent.mm.plugin.exdevice.g.a.l();
      com.tencent.mm.kernel.h.aGY().b((q)this.vnN.vnH);
      AppMethodBeat.o(279324);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class g<T>
    implements Comparator<ExdeviceFollowsUI.a>
  {
    public static final g vnR;
    
    static
    {
      AppMethodBeat.i(282161);
      vnR = new g();
      AppMethodBeat.o(282161);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<ExdeviceFollowsUI.a>
  {
    public static final h vnS;
    
    static
    {
      AppMethodBeat.i(288855);
      vnS = new h();
      AppMethodBeat.o(288855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceFollowsUI
 * JD-Core Version:    0.7.0.1
 */