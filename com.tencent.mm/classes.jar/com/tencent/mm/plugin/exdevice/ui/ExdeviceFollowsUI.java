package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MAX_SELECT_CONTACT", "", "REQUEST_CODE_ADD_FOLLOWER", "REQUEST_CODE_FROM_PROFILE", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "netSceneAddFollow", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "getNetSceneAddFollow", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "setNetSceneAddFollow", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;)V", "netSceneGetFollowList", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "getNetSceneGetFollowList", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "setNetSceneGetFollowList", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;)V", "netSceneProfileDetail", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "getNetSceneProfileDetail", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "setNetSceneProfileDetail", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startSelectUserToFollower", "mRecentLikeUsers", "", "mWechatSportFollows", "mMyFollows", "syncFollowList", "FollowItem", "FollowItemConvert", "app_release"})
public final class ExdeviceFollowsUI
  extends MMSecDataActivity
  implements com.tencent.mm.ak.i
{
  private final ArrayList<a> kgc;
  com.tencent.mm.ui.base.q loadingDialog;
  private WxRecyclerView rHX;
  com.tencent.mm.plugin.exdevice.g.a.i rHY;
  com.tencent.mm.plugin.exdevice.g.a.l rHZ;
  private com.tencent.mm.plugin.exdevice.g.a.g rIa;
  private final int rIb;
  private final int rIc;
  private final int rId;
  
  public ExdeviceFollowsUI()
  {
    AppMethodBeat.i(230619);
    this.kgc = new ArrayList();
    this.rIb = 4660;
    this.rIc = 4661;
    this.rId = 10;
    AppMethodBeat.o(230619);
  }
  
  private final void cLM()
  {
    AppMethodBeat.i(230615);
    this.rHY = new com.tencent.mm.plugin.exdevice.g.a.i((Context)this, z.aTY(), "", null);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)this.rHY);
    AppMethodBeat.o(230615);
  }
  
  public final int getLayoutId()
  {
    return 2131494022;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(230617);
    Object localObject = new HashSet((Collection)super.importUIComponents());
    ((HashSet)localObject).add(SportProfileUIC.class);
    localObject = (Set)localObject;
    AppMethodBeat.o(230617);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(230618);
    if (paramInt1 == this.rIb)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("Select_Contact");
          p.g(paramIntent, "userName");
          paramIntent = ((Collection)n.a((CharSequence)paramIntent, new String[] { "," })).toArray(new String[0]);
          if (paramIntent == null)
          {
            paramIntent = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(230618);
            throw paramIntent;
          }
          paramIntent = Util.stringsToList((String[])paramIntent);
          if (paramIntent == null)
          {
            AppMethodBeat.o(230618);
            return;
          }
          com.tencent.mm.ui.base.q localq = this.loadingDialog;
          if (localq != null) {
            localq.show();
          }
          this.rIa = new com.tencent.mm.plugin.exdevice.g.a.g((List)paramIntent, null);
          bg.azz().b((com.tencent.mm.ak.q)this.rIa);
          AppMethodBeat.o(230618);
          return;
        }
        AppMethodBeat.o(230618);
      }
    }
    else if ((paramInt1 == this.rIc) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false)) {
        com.tencent.f.h.RTc.n((Runnable)new d(this), 500L);
      }
      AppMethodBeat.o(230618);
      return;
    }
    AppMethodBeat.o(230618);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230613);
    super.onCreate(paramBundle);
    setMMTitle(2131758909);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    addIconOptionMenu(0, 2131690727, (MenuItem.OnMenuItemClickListener)new f(this));
    com.tencent.mm.kernel.g.azz().a(1043, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().a(1777, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().a(1758, (com.tencent.mm.ak.i)this);
    this.rHX = ((WxRecyclerView)findViewById(2131306757));
    paramBundle = this.rHX;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.rHX;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new c(this), this.kgc));
    }
    cLM();
    AppMethodBeat.o(230613);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(230614);
    Object localObject = this.rHY;
    if (localObject != null) {
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject);
    }
    localObject = this.rHZ;
    if (localObject != null) {
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject);
    }
    localObject = this.rIa;
    if (localObject != null) {
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject);
    }
    com.tencent.mm.kernel.g.azz().b(1043, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().b(1777, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().b(1758, (com.tencent.mm.ak.i)this);
    super.onDestroy();
    AppMethodBeat.o(230614);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(230616);
    Object localObject;
    long l1;
    if (p.j(paramq, this.rHY))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kgc.clear();
        paramString = com.tencent.mm.ui.component.a.PRN;
        paramString = ((SportProfileUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(SportProfileUIC.class)).rMR;
        if (paramString != null)
        {
          paramString = paramString.KHh;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramq = paramString.next();
              if (paramInt1 < 0) {
                j.hxH();
              }
              paramq = (bes)paramq;
              localObject = this.kgc;
              l1 = paramInt1;
              p.g(paramq, "follow");
              ((ArrayList)localObject).add(new a(l1, paramq));
              paramInt1 += 1;
            }
          }
        }
        j.a((List)this.kgc, (Comparator)g.rIj);
        paramString = this.rHX;
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
        if (this.kgc.size() != 0)
        {
          paramString = findViewById(2131305460);
          p.g(paramString, "findViewById<View>(R.id.no_result_tip_tv)");
          paramString.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = findViewById(2131303694);
        p.g(paramString, "findViewById<View>(R.id.loading_bar)");
        paramString.setVisibility(8);
        this.rHY = null;
        AppMethodBeat.o(230616);
        return;
        paramString = findViewById(2131305460);
        p.g(paramString, "findViewById<View>(R.id.no_result_tip_tv)");
        paramString.setVisibility(0);
      }
    }
    if (p.j(paramq, this.rHZ))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramq = this.rHZ;
        if (paramq != null)
        {
          localObject = paramq.rCT;
          p.g(localObject, "it.recentLikeUser");
          paramString = paramq.rCR;
          p.g(paramString, "it.mWechatSportFollows");
          List localList = paramq.rCS;
          p.g(localList, "it.mMyFollows");
          paramq = new Intent();
          localObject = Util.listToString((List)localObject, ",");
          paramq.putExtra("wechat_sport_contact", Util.listToString(paramString, ","));
          paramq.putExtra("wechat_sport_recent_like", (String)localObject);
          paramString = Util.listToString(localList, ",");
          paramq.putExtra("titile", getString(2131758768));
          paramq.putExtra("list_type", 12);
          paramq.putExtra("max_limit_num", this.rId);
          paramq.putExtra("too_many_member_tip_string", getString(2131758771, new Object[] { Integer.valueOf(this.rId) }));
          paramq.putExtra("list_attr", u.Q(new int[] { 2, 4, 1, 131072, 128, 64, 16384 }));
          paramq.putExtra("always_select_contact", paramString);
          c.c((Context)this, ".ui.contact.SelectContactUI", paramq, this.rIb);
        }
      }
      this.rHZ = null;
      AppMethodBeat.o(230616);
      return;
    }
    if (p.j(paramq, this.rIa))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt2 = this.kgc.size();
        paramString = this.rIa;
        if (paramString != null)
        {
          paramString = paramString.rCn;
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
                  j.hxH();
                }
                paramq = (bes)paramq;
                localObject = this.kgc;
                l1 = paramInt2;
                long l2 = paramInt1;
                p.g(paramq, "follow");
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
        j.a((List)this.kgc, (Comparator)h.rIk);
        paramString = this.rHX;
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
      this.rIa = null;
    }
    AppMethodBeat.o(230616);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "follow", "Lcom/tencent/mm/protocal/protobuf/Follow;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;JLcom/tencent/mm/protocal/protobuf/Follow;)V", "getFollow", "()Lcom/tencent/mm/protocal/protobuf/Follow;", "setFollow", "(Lcom/tencent/mm/protocal/protobuf/Follow;)V", "getId", "()J", "setId", "(J)V", "getItemId", "getItemType", "", "app_release"})
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private long id;
    bes rIe;
    
    public a(bes parambes)
    {
      AppMethodBeat.i(230602);
      this.id = ???;
      this.rIe = localObject;
      AppMethodBeat.o(230602);
    }
    
    public final int cxn()
    {
      return 2;
    }
    
    public final long lT()
    {
      return this.id;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
  public final class b
    extends e<ExdeviceFollowsUI.a>
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
    {
      AppMethodBeat.i(230604);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(230604);
    }
    
    public final int getLayoutId()
    {
      return 2131494021;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ExdeviceFollowsUI.b paramb, ExdeviceFollowsUI.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(230603);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = new Intent((Context)this.rIg.rIf, ExdeviceProfileUI.class);
        paramView.putExtra("username", this.rIh.rIe.username);
        this.rIg.rIf.startActivityForResult(paramView, ExdeviceFollowsUI.a(this.rIg.rIf));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230603);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class c
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(230606);
      e locale = (e)new ExdeviceFollowsUI.b(this.rIf);
      AppMethodBeat.o(230606);
      return locale;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$onActivityResult$2$1"})
  static final class d
    implements Runnable
  {
    d(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(230607);
      ExdeviceFollowsUI.b(this.rIf);
      AppMethodBeat.o(230607);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230608);
      this.rIf.finish();
      AppMethodBeat.o(230608);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230610);
      paramMenuItem = this.rIf;
      Context localContext = (Context)this.rIf;
      this.rIf.getString(2131755998);
      paramMenuItem.loadingDialog = com.tencent.mm.ui.base.h.b(localContext, this.rIf.getString(2131762446), true, (DialogInterface.OnCancelListener)new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(230609);
          com.tencent.mm.plugin.exdevice.g.a.i locali = this.rIi.rIf.rHY;
          if (locali != null) {
            com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)locali);
          }
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(230609);
        }
      });
      this.rIf.rHZ = new com.tencent.mm.plugin.exdevice.g.a.l();
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)this.rIf.rHZ);
      AppMethodBeat.o(230610);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class g<T>
    implements Comparator<ExdeviceFollowsUI.a>
  {
    public static final g rIj;
    
    static
    {
      AppMethodBeat.i(230611);
      rIj = new g();
      AppMethodBeat.o(230611);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<ExdeviceFollowsUI.a>
  {
    public static final h rIk;
    
    static
    {
      AppMethodBeat.i(230612);
      rIk = new h();
      AppMethodBeat.o(230612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceFollowsUI
 * JD-Core Version:    0.7.0.1
 */