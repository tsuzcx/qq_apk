package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.live.ui.livepost.c;
import com.tencent.mm.plugin.finder.live.ui.livepost.c.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.e.b;
import kotlin.g;
import kotlin.g.a.r;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "TAG", "", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "getLivePostHelper", "()Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "livePostHelper$delegate", "Lkotlin/Lazy;", "onNoticeOpSceneEndCallBack", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "scene", "", "getOnNoticeOpSceneEndCallBack", "()Lkotlin/jvm/functions/Function4;", "setOnNoticeOpSceneEndCallBack", "(Lkotlin/jvm/functions/Function4;)V", "reportReport", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportReport", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportReport$delegate", "doDelFinderNotice", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "handleLiveMenuItemSelected", "menuId", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onLivePostBtnClick", "onResume", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "showLiveBottomSheet", "showOrDimissLoading", "show", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-finder_release"})
public final class d
  extends UIComponent
  implements i
{
  private final String TAG;
  s oTk;
  private final int zdW;
  private final int zdX;
  private e zdY;
  private final kotlin.f zdZ;
  public r<? super Integer, ? super Integer, ? super String, ? super ax, x> zea;
  private final kotlin.f zeb;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289364);
    this.TAG = "FinderLivePostUIC";
    this.zdW = 10001;
    this.zdX = 10002;
    this.zdZ = g.ar((kotlin.g.a.a)new c(this));
    this.zeb = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(289364);
  }
  
  private final void a(final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(289362);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramBoolean, paramOnCancelListener));
    AppMethodBeat.o(289362);
  }
  
  public final c dGx()
  {
    AppMethodBeat.i(289355);
    c localc = (c)this.zeb.getValue();
    AppMethodBeat.o(289355);
    return localc;
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(289360);
    Object localObject1 = aj.AGc;
    Object localObject2;
    if (aj.at((Activity)getActivity()))
    {
      localObject1 = aj.AGc;
      if (aj.eei() == 2)
      {
        Log.i(this.TAG, "[onLivePostBtnClick] USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_create_scene", 3);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.w((Context)getActivity(), (Intent)localObject1);
        AppMethodBeat.o(289360);
      }
    }
    else
    {
      Log.i(this.TAG, "[onLivePostBtnClick] checkHasRealname false");
      AppMethodBeat.o(289360);
      return;
    }
    Log.i(this.TAG, "FinderLive.entrance,live btn click!");
    if (NetStatusUtil.isConnected((Context)getActivity()))
    {
      localObject1 = dGx();
      if (localObject1 != null)
      {
        Log.i(((c)localObject1).TAG, "prepareLive");
        ((c)localObject1).yjR = System.currentTimeMillis();
        ((c)localObject1).bwZ = -1;
        ((c)localObject1).yOv = null;
        localObject2 = ao.xcj;
        localObject2 = new ae(ao.dnO(), z.bdh(), ((c)localObject1).yjR, (ae.a)new c.b((c)localObject1), (byte)0).bhW();
        localObject1 = ((c)localObject1).fDf;
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(289360);
          throw ((Throwable)localObject1);
        }
        ((com.tencent.mm.cw.f)localObject2).a((b)localObject1);
      }
      this.zdY = new e((Context)getActivity(), 1, false);
      localObject1 = this.zdY;
      if (localObject1 != null) {
        ((e)localObject1).a((q.f)new d(this));
      }
      localObject1 = this.zdY;
      if (localObject1 != null) {
        ((e)localObject1).a((q.g)new e(this));
      }
      localObject1 = this.zdY;
      if (localObject1 != null) {
        ((e)localObject1).b((e.b)new f(this));
      }
      localObject1 = this.zdY;
      if (localObject1 != null)
      {
        ((e)localObject1).eik();
        AppMethodBeat.o(289360);
        return;
      }
      AppMethodBeat.o(289360);
      return;
    }
    new f.a((Context)getActivity()).icD().bBl(getActivity().getResources().getString(b.j.finder_live_jump_tip_network_unavailable)).bBp(getActivity().getResources().getString(b.j.app_i_know)).b((f.c)b.zef).show();
    AppMethodBeat.o(289360);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(289358);
    switch (paramInt1)
    {
    }
    Object localObject3;
    do
    {
      AppMethodBeat.o(289358);
      return;
      localObject3 = this.zdY;
      if (localObject3 != null) {
        ((e)localObject3).bYF();
      }
      localObject3 = dGx();
    } while (localObject3 == null);
    Log.i(((c)localObject3).TAG, "onActivityResult,requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    if (paramInt1 == 10000)
    {
      if (paramIntent != null) {
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));
      }
      Log.i(((c)localObject3).TAG, "face verify result:".concat(String.valueOf(localObject1)));
      if (paramInt2 == -1)
      {
        if (localObject1 == null)
        {
          AppMethodBeat.o(289358);
          return;
        }
        if (((Integer)localObject1).intValue() == 1)
        {
          ((c)localObject3).b(((c)localObject3).yOv);
          AppMethodBeat.o(289358);
        }
      }
    }
    else if (paramInt1 == 10001)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0));
      }
      Log.i(((c)localObject3).TAG, "precheck result:".concat(String.valueOf(localObject1)));
      if (paramInt2 == -1)
      {
        if (localObject1 == null)
        {
          AppMethodBeat.o(289358);
          return;
        }
        if (((Integer)localObject1).intValue() == 1) {
          ((c)localObject3).b(((c)localObject3).yOv);
        }
      }
    }
    AppMethodBeat.o(289358);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(289356);
    super.onResume();
    h.aGY().a(6653, (i)this);
    a(false, null);
    AppMethodBeat.o(289356);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(289361);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    a(false, null);
    r localr = this.zea;
    if (localr != null)
    {
      if ((paramq instanceof ax)) {
        break label118;
      }
      paramq = localObject;
    }
    label118:
    for (;;)
    {
      localr.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, (ax)paramq);
      AppMethodBeat.o(289361);
      return;
      AppMethodBeat.o(289361);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(289357);
    super.onStop();
    h.aGY().b(6653, (i)this);
    AppMethodBeat.o(289357);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    public static final b zef;
    
    static
    {
      AppMethodBeat.i(270236);
      zef = new b();
      AppMethodBeat.o(270236);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<bid>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(d paramd) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(285360);
      StringBuilder localStringBuilder = new StringBuilder("live bottom sheet:");
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(d.b(this.zec), b.j.finder_create_live);
        localStringBuilder.append(this.zec.getString(b.j.finder_create_live) + ',');
        paramo.mn(d.c(this.zec), b.j.finder_create_live_notice);
        localStringBuilder.append(String.valueOf(this.zec.getString(b.j.finder_create_live_notice)));
      }
      Log.i(d.d(this.zec), String.valueOf(localStringBuilder.toString()));
      AppMethodBeat.o(285360);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(d paramd) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(287702);
      Object localObject1 = this.zec.dGx();
      if (localObject1 != null) {}
      for (localObject1 = ((c)localObject1).yOv;; localObject1 = null)
      {
        Object localObject2 = this.zec.dGx();
        if (localObject2 != null)
        {
          p.j(paramMenuItem, "menuItem");
          ((c)localObject2).bwZ = paramMenuItem.getItemId();
        }
        if (localObject1 == null) {
          break;
        }
        localObject2 = this.zec;
        p.j(paramMenuItem, "menuItem");
        d.a((d)localObject2, paramMenuItem.getItemId(), (arr)localObject1);
        AppMethodBeat.o(287702);
        return;
      }
      d.a(this.zec, (DialogInterface.OnCancelListener)new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(272634);
          paramAnonymousDialogInterface = this.zeg.zec.dGx();
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.dDU();
            AppMethodBeat.o(272634);
            return;
          }
          AppMethodBeat.o(272634);
        }
      });
      AppMethodBeat.o(287702);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    f(d paramd) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(258885);
      c localc = this.zec.dGx();
      if (localc != null)
      {
        localc.dDU();
        AppMethodBeat.o(258885);
        return;
      }
      AppMethodBeat.o(258885);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(d paramd, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.d
 * JD-Core Version:    0.7.0.1
 */