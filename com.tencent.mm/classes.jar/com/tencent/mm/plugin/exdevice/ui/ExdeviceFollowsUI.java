package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.a.l;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MAX_SELECT_CONTACT", "", "REQUEST_CODE_ADD_FOLLOWER", "REQUEST_CODE_FROM_PROFILE", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "netSceneAddFollow", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "getNetSceneAddFollow", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "setNetSceneAddFollow", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;)V", "netSceneGetFollowList", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "getNetSceneGetFollowList", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "setNetSceneGetFollowList", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;)V", "netSceneProfileDetail", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "getNetSceneProfileDetail", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "setNetSceneProfileDetail", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startSelectUserToFollower", "mRecentLikeUsers", "", "mWechatSportFollows", "mMyFollows", "syncFollowList", "FollowItem", "FollowItemConvert", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ExdeviceFollowsUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.ui.base.w loadingDialog;
  private final ArrayList<a> pUj;
  private WxRecyclerView yAg;
  private com.tencent.mm.plugin.exdevice.g.a.i yAh;
  private l yAi;
  private com.tencent.mm.plugin.exdevice.g.a.g yAj;
  private final int yAk;
  private final int yAl;
  private final int yAm;
  
  public ExdeviceFollowsUI()
  {
    AppMethodBeat.i(274758);
    this.pUj = new ArrayList();
    this.yAk = 4660;
    this.yAl = 4661;
    this.yAm = 10;
    AppMethodBeat.o(274758);
  }
  
  private static final int a(a parama1, a parama2)
  {
    return parama2.yAn.rBp - parama1.yAn.rBp;
  }
  
  private static final void a(ExdeviceFollowsUI paramExdeviceFollowsUI)
  {
    AppMethodBeat.i(274776);
    kotlin.g.b.s.u(paramExdeviceFollowsUI, "this$0");
    paramExdeviceFollowsUI.dGU();
    AppMethodBeat.o(274776);
  }
  
  private static final void a(ExdeviceFollowsUI paramExdeviceFollowsUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(274767);
    kotlin.g.b.s.u(paramExdeviceFollowsUI, "this$0");
    paramExdeviceFollowsUI = paramExdeviceFollowsUI.yAh;
    if (paramExdeviceFollowsUI != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramExdeviceFollowsUI);
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(274767);
  }
  
  private static final boolean a(ExdeviceFollowsUI paramExdeviceFollowsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(274764);
    kotlin.g.b.s.u(paramExdeviceFollowsUI, "this$0");
    paramExdeviceFollowsUI.finish();
    AppMethodBeat.o(274764);
    return false;
  }
  
  private static final int b(a parama1, a parama2)
  {
    return parama2.yAn.rBp - parama1.yAn.rBp;
  }
  
  private static final boolean b(ExdeviceFollowsUI paramExdeviceFollowsUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(274770);
    kotlin.g.b.s.u(paramExdeviceFollowsUI, "this$0");
    paramMenuItem = (Context)paramExdeviceFollowsUI;
    paramExdeviceFollowsUI.getString(R.l.app_tip);
    paramExdeviceFollowsUI.loadingDialog = com.tencent.mm.ui.base.k.b(paramMenuItem, paramExdeviceFollowsUI.getString(R.l.loading_tips), true, new ExdeviceFollowsUI..ExternalSyntheticLambda0(paramExdeviceFollowsUI));
    paramExdeviceFollowsUI.yAi = new l();
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramExdeviceFollowsUI.yAi, 0);
    AppMethodBeat.o(274770);
    return true;
  }
  
  private final void dGU()
  {
    AppMethodBeat.i(274760);
    this.yAh = new com.tencent.mm.plugin.exdevice.g.a.i((Context)this, z.bAM(), "", null);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.yAh, 0);
    AppMethodBeat.o(274760);
  }
  
  public final int getLayoutId()
  {
    return R.i.gjm;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(274813);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(274813);
      return null;
    }
    localSet = ar.c(localSet, e.class);
    AppMethodBeat.o(274813);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(274817);
    if (paramInt1 == this.yAk)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        kotlin.g.b.s.checkNotNull(paramIntent);
        paramIntent = ((Collection)n.a((CharSequence)paramIntent, new String[] { "," })).toArray(new String[0]);
        if (paramIntent == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(274817);
          throw paramIntent;
        }
        paramIntent = Util.stringsToList((String[])paramIntent);
        if (paramIntent == null)
        {
          AppMethodBeat.o(274817);
          return;
        }
        com.tencent.mm.ui.base.w localw = this.loadingDialog;
        if (localw != null) {
          localw.show();
        }
        this.yAj = new com.tencent.mm.plugin.exdevice.g.a.g((List)paramIntent, null);
        bh.aZW().a((com.tencent.mm.am.p)this.yAj, 0);
        AppMethodBeat.o(274817);
      }
    }
    else if ((paramInt1 == this.yAl) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("KeyNeedUpdateRank", false))) {
      com.tencent.threadpool.h.ahAA.o(new ExdeviceFollowsUI..ExternalSyntheticLambda3(this), 500L);
    }
    AppMethodBeat.o(274817);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(274799);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gGV);
    setBackBtn(new ExdeviceFollowsUI..ExternalSyntheticLambda2(this));
    addIconOptionMenu(0, R.k.icons_outlined_add, new ExdeviceFollowsUI..ExternalSyntheticLambda1(this));
    com.tencent.mm.kernel.h.aZW().a(1043, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(1777, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(1758, (com.tencent.mm.am.h)this);
    this.yAg = ((WxRecyclerView)findViewById(R.h.recycler_view));
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new c(this), this.pUj));
    }
    dGU();
    AppMethodBeat.o(274799);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(274802);
    Object localObject = this.yAh;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject);
    }
    localObject = this.yAi;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject);
    }
    localObject = this.yAj;
    if (localObject != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject);
    }
    com.tencent.mm.kernel.h.aZW().b(1043, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(1777, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(1758, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(274802);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(274811);
    Object localObject;
    long l1;
    if (kotlin.g.b.s.p(paramp, this.yAh))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.pUj.clear();
        paramString = com.tencent.mm.ui.component.k.aeZF;
        paramString = ((e)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(e.class)).yEI;
        if (paramString != null)
        {
          paramString = paramString.YFB;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramp = paramString.next();
              if (paramInt1 < 0) {
                kotlin.a.p.kkW();
              }
              paramp = (bzo)paramp;
              localObject = this.pUj;
              l1 = paramInt1;
              kotlin.g.b.s.s(paramp, "follow");
              ((ArrayList)localObject).add(new a(l1, paramp));
              paramInt1 += 1;
            }
          }
        }
        kotlin.a.p.a((List)this.pUj, ExdeviceFollowsUI..ExternalSyntheticLambda4.INSTANCE);
        paramString = this.yAg;
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.bZE.notifyChanged();
          }
        }
        if (this.pUj.size() != 0) {
          findViewById(R.h.fRt).setVisibility(8);
        }
      }
      for (;;)
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        findViewById(R.h.loading_bar).setVisibility(8);
        this.yAh = null;
        AppMethodBeat.o(274811);
        return;
        findViewById(R.h.fRt).setVisibility(0);
      }
    }
    if (kotlin.g.b.s.p(paramp, this.yAi))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.loadingDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramp = this.yAi;
        if (paramp != null)
        {
          localObject = paramp.yuC;
          kotlin.g.b.s.s(localObject, "it.recentLikeUser");
          paramString = paramp.yuA;
          kotlin.g.b.s.s(paramString, "it.mWechatSportFollows");
          List localList = paramp.yuB;
          kotlin.g.b.s.s(localList, "it.mMyFollows");
          paramp = new Intent();
          localObject = Util.listToString((List)localObject, ",");
          paramp.putExtra("wechat_sport_contact", Util.listToString(paramString, ","));
          paramp.putExtra("wechat_sport_recent_like", (String)localObject);
          paramString = Util.listToString(localList, ",");
          paramp.putExtra("titile", getString(R.l.gFx));
          paramp.putExtra("list_type", 12);
          paramp.putExtra("max_limit_num", this.yAm);
          paramp.putExtra("too_many_member_tip_string", getString(R.l.gFy, new Object[] { Integer.valueOf(this.yAm) }));
          paramp.putExtra("list_attr", com.tencent.mm.ui.contact.w.R(new int[] { 2, 4, 1, 131072, 128, 64, 16384 }));
          paramp.putExtra("always_select_contact", paramString);
          c.d((Context)this, ".ui.contact.SelectContactUI", paramp, this.yAk);
        }
      }
      this.yAi = null;
      AppMethodBeat.o(274811);
      return;
    }
    if (kotlin.g.b.s.p(paramp, this.yAj))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt2 = this.pUj.size();
        paramString = this.yAj;
        if (paramString != null)
        {
          paramString = paramString.ytW;
          if (paramString != null)
          {
            if (!((Collection)paramString).isEmpty())
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label739;
              }
            }
            for (;;)
            {
              if (paramString == null) {
                break label744;
              }
              paramString = (Iterable)paramString;
              paramInt1 = 0;
              paramString = paramString.iterator();
              while (paramString.hasNext())
              {
                paramp = paramString.next();
                if (paramInt1 < 0) {
                  kotlin.a.p.kkW();
                }
                paramp = (bzo)paramp;
                localObject = this.pUj;
                l1 = paramInt2;
                long l2 = paramInt1;
                kotlin.g.b.s.s(paramp, "follow");
                ((ArrayList)localObject).add(new a(l1 + l2, paramp));
                paramInt1 += 1;
              }
              paramInt1 = 0;
              break;
              label739:
              paramString = null;
            }
          }
        }
        label744:
        kotlin.a.p.a((List)this.pUj, ExdeviceFollowsUI..ExternalSyntheticLambda5.INSTANCE);
        paramString = this.yAg;
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.bZE.notifyChanged();
          }
        }
      }
      paramString = this.loadingDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      this.yAj = null;
    }
    AppMethodBeat.o(274811);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "follow", "Lcom/tencent/mm/protocal/protobuf/Follow;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;JLcom/tencent/mm/protocal/protobuf/Follow;)V", "getFollow", "()Lcom/tencent/mm/protocal/protobuf/Follow;", "setFollow", "(Lcom/tencent/mm/protocal/protobuf/Follow;)V", "getId", "()J", "setId", "(J)V", "getItemId", "getItemType", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private long id;
    bzo yAn;
    
    public a(bzo parambzo)
    {
      AppMethodBeat.i(274716);
      this.id = ???;
      this.yAn = localObject;
      AppMethodBeat.o(274716);
    }
    
    public final long bZA()
    {
      return this.id;
    }
    
    public final int bZB()
    {
      return 4;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends f<ExdeviceFollowsUI.a>
  {
    public b()
    {
      AppMethodBeat.i(274717);
      AppMethodBeat.o(274717);
    }
    
    private static final void a(ExdeviceFollowsUI paramExdeviceFollowsUI, ExdeviceFollowsUI.a parama, View paramView)
    {
      AppMethodBeat.i(274719);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramExdeviceFollowsUI);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramExdeviceFollowsUI, "this$0");
      kotlin.g.b.s.u(parama, "$item");
      paramView = new Intent((Context)paramExdeviceFollowsUI, ExdeviceProfileUI.class);
      paramView.putExtra("username", parama.yAn.username);
      paramExdeviceFollowsUI.startActivityForResult(paramView, ExdeviceFollowsUI.b(paramExdeviceFollowsUI));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274719);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(274724);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramj, "holder");
      AppMethodBeat.o(274724);
    }
    
    public final int getLayoutId()
    {
      return R.i.gjl;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    c(ExdeviceFollowsUI paramExdeviceFollowsUI) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(274718);
      f localf = (f)new ExdeviceFollowsUI.b(this.yAo);
      AppMethodBeat.o(274718);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceFollowsUI
 * JD-Core Version:    0.7.0.1
 */