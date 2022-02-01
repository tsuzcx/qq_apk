package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "TAG", "", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "getLivePostHelper", "()Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "livePostHelper$delegate", "Lkotlin/Lazy;", "onNoticeOpSceneEndCallBack", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "scene", "", "getOnNoticeOpSceneEndCallBack", "()Lkotlin/jvm/functions/Function4;", "setOnNoticeOpSceneEndCallBack", "(Lkotlin/jvm/functions/Function4;)V", "reportReport", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportReport", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportReport$delegate", "doCreateFinderNotice", "startTime", "doDelFinderNotice", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "handleLiveMenuItemSelected", "menuId", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "onCreateLiveNote", "onLivePostBtnClick", "onResume", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "showLiveBottomSheet", "showOrDimissLoading", "show", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-finder_release"})
public final class FinderLivePostBtnUIC
  extends UIComponent
  implements i
{
  private final String TAG;
  private com.tencent.mm.ui.base.q nUq;
  private final int wyj;
  private final int wyk;
  private e wyl;
  private final f wym;
  public kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super au, x> wyn;
  private final f wyo;
  
  public FinderLivePostBtnUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255778);
    this.TAG = "FinderLivePostUIC";
    this.wyj = 10001;
    this.wyk = 10002;
    this.wym = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wyo = kotlin.g.ah((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(255778);
  }
  
  private final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(255776);
    if (paramBoolean)
    {
      if (this.nUq == null)
      {
        this.nUq = com.tencent.mm.ui.base.q.a((Context)getActivity(), (CharSequence)getActivity().getString(2131760677), true, 2, paramOnCancelListener);
        AppMethodBeat.o(255776);
        return;
      }
      com.tencent.mm.ui.base.q localq = this.nUq;
      if (localq != null)
      {
        if (!localq.isShowing())
        {
          localq = this.nUq;
          if (localq != null) {
            localq.setOnCancelListener(paramOnCancelListener);
          }
          paramOnCancelListener = this.nUq;
          if (paramOnCancelListener != null)
          {
            paramOnCancelListener.show();
            AppMethodBeat.o(255776);
          }
        }
      }
      else
      {
        AppMethodBeat.o(255776);
        return;
      }
      AppMethodBeat.o(255776);
      return;
    }
    paramOnCancelListener = this.nUq;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(255776);
      return;
    }
    AppMethodBeat.o(255776);
  }
  
  private final void dIo()
  {
    AppMethodBeat.i(255774);
    this.wyl = new e((Context)getActivity(), 1, false);
    e locale = this.wyl;
    if (locale != null) {
      locale.a((o.f)new e(this));
    }
    locale = this.wyl;
    if (locale != null) {
      locale.a((o.g)new f(this));
    }
    locale = this.wyl;
    if (locale != null) {
      locale.b((e.b)new g(this));
    }
    locale = this.wyl;
    if (locale != null)
    {
      locale.dGm();
      AppMethodBeat.o(255774);
      return;
    }
    AppMethodBeat.o(255774);
  }
  
  public final com.tencent.mm.plugin.finder.ui.g dIm()
  {
    AppMethodBeat.i(255770);
    com.tencent.mm.plugin.finder.ui.g localg = (com.tencent.mm.plugin.finder.ui.g)this.wyo.getValue();
    AppMethodBeat.o(255770);
    return localg;
  }
  
  public final void dIn()
  {
    AppMethodBeat.i(255773);
    Object localObject = y.vXH;
    if (y.an((Activity)getActivity()))
    {
      localObject = y.vXH;
      if (y.dCL() == 2)
      {
        Log.i(this.TAG, "[onLivePostBtnClick] USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_create_scene", 3);
        ((Intent)localObject).putExtra("scene", 2);
        com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.w((Context)getActivity(), (Intent)localObject);
        AppMethodBeat.o(255773);
      }
    }
    else
    {
      Log.i(this.TAG, "[onLivePostBtnClick] checkHasRealname false");
      AppMethodBeat.o(255773);
      return;
    }
    Log.i(this.TAG, "FinderLive.entrance,live btn click!");
    if (NetStatusUtil.isConnected((Context)getActivity()))
    {
      localObject = dIm();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.ui.g)localObject).dzD();
      }
      dIo();
      AppMethodBeat.o(255773);
      return;
    }
    new f.a((Context)getActivity()).hbu().bow(getActivity().getResources().getString(2131759962)).boA(getActivity().getResources().getString(2131755873)).b((f.c)c.wyu).show();
    AppMethodBeat.o(255773);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255771);
    super.onResume();
    com.tencent.mm.kernel.g.azz().a(6653, (i)this);
    a(false, null);
    AppMethodBeat.o(255771);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(255775);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    a(false, null);
    kotlin.g.a.r localr = this.wyn;
    if (localr != null)
    {
      if ((paramq instanceof au)) {
        break label118;
      }
      paramq = localObject;
    }
    label118:
    for (;;)
    {
      localr.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, (au)paramq);
      AppMethodBeat.o(255775);
      return;
      AppMethodBeat.o(255775);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(255772);
    super.onStop();
    com.tencent.mm.kernel.g.azz().b(6653, (i)this);
    AppMethodBeat.o(255772);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.ui.g>
  {
    a(FinderLivePostBtnUIC paramFinderLivePostBtnUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "hasSetResult", "", "result", "", "kotlin.jvm.PlatformType", "secondResult", "thirdResult", "onResult"})
  static final class b<T>
    implements c.a<Object>
  {
    b(FinderLivePostBtnUIC paramFinderLivePostBtnUIC, c paramc, z.f paramf) {}
    
    public final void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      AppMethodBeat.i(255763);
      this.wys.hide();
      List localList;
      if (paramBoolean)
      {
        try
        {
          localList = (List)((kotlin.r)this.wyt.SYG).first;
          if (paramObject1 != null) {
            break label76;
          }
          paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(255763);
          throw paramObject1;
        }
        catch (Throwable paramObject1)
        {
          Log.i(FinderLivePostBtnUIC.c(this.wyp), paramObject1.getMessage());
        }
      }
      else
      {
        AppMethodBeat.o(255763);
        return;
      }
      label76:
      int i = j.a(localList, (CharSequence)paramObject1);
      paramObject1 = ((ArrayList)((kotlin.r)this.wyt.SYG).second).get(i);
      p.g(paramObject1, "triple.second[firstChosenIndex]");
      paramObject1 = (List)paramObject1;
      if (paramObject2 == null)
      {
        paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(255763);
        throw paramObject1;
      }
      int j = j.a(paramObject1, (CharSequence)paramObject2);
      paramObject1 = ((ArrayList)((kotlin.r)this.wyt.SYG).SWY).get(j);
      p.g(paramObject1, "triple.third[secChosenIndex]");
      paramObject1 = (List)paramObject1;
      if (paramObject3 == null)
      {
        paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(255763);
        throw paramObject1;
      }
      int k = j.a(paramObject1, (CharSequence)paramObject3);
      paramObject1 = y.vXH;
      paramObject1 = new Date(y.dCO());
      paramObject2 = Calendar.getInstance();
      p.g(paramObject2, "date");
      paramObject2.setTime(paramObject1);
      paramObject2.set(5, paramObject2.get(5) + i);
      paramObject2.set(11, 24 - ((List)((ArrayList)((kotlin.r)this.wyt.SYG).second).get(i)).size() + j);
      paramObject2.set(12, (12 - ((List)((ArrayList)((kotlin.r)this.wyt.SYG).SWY).get(j)).size() + k) * 5);
      paramObject2.set(13, 0);
      Log.i(FinderLivePostBtnUIC.c(this.wyp), "chosen time:" + paramObject2.getTime() + ",timeInMills:" + paramObject2.getTimeInMillis());
      FinderLivePostBtnUIC.a(this.wyp, true);
      FinderLivePostBtnUIC.a(this.wyp, (int)(paramObject2.getTimeInMillis() / 1000L));
      AppMethodBeat.o(255763);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c wyu;
    
    static
    {
      AppMethodBeat.i(255764);
      wyu = new c();
      AppMethodBeat.o(255764);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<bbn>
  {
    d(FinderLivePostBtnUIC paramFinderLivePostBtnUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    e(FinderLivePostBtnUIC paramFinderLivePostBtnUIC) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255766);
      StringBuilder localStringBuilder = new StringBuilder("live bottom sheet:");
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(FinderLivePostBtnUIC.a(this.wyp), 2131759641);
        localStringBuilder.append(this.wyp.getString(2131759641) + ',');
        paramm.kV(FinderLivePostBtnUIC.b(this.wyp), 2131759642);
        localStringBuilder.append(String.valueOf(this.wyp.getString(2131759642)));
      }
      Log.i(FinderLivePostBtnUIC.c(this.wyp), String.valueOf(localStringBuilder.toString()));
      AppMethodBeat.o(255766);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements o.g
  {
    f(FinderLivePostBtnUIC paramFinderLivePostBtnUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255768);
      Object localObject1 = this.wyp.dIm();
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.finder.ui.g)localObject1).vKV;; localObject1 = null)
      {
        Object localObject2 = this.wyp.dIm();
        if (localObject2 != null)
        {
          p.g(paramMenuItem, "menuItem");
          ((com.tencent.mm.plugin.finder.ui.g)localObject2).ks = paramMenuItem.getItemId();
        }
        if (localObject1 == null) {
          break;
        }
        localObject2 = this.wyp;
        p.g(paramMenuItem, "menuItem");
        FinderLivePostBtnUIC.a((FinderLivePostBtnUIC)localObject2, paramMenuItem.getItemId(), (aqb)localObject1);
        AppMethodBeat.o(255768);
        return;
      }
      FinderLivePostBtnUIC.a(this.wyp, (DialogInterface.OnCancelListener)new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(255767);
          paramAnonymousDialogInterface = this.wyv.wyp.dIm();
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.dzE();
            AppMethodBeat.o(255767);
            return;
          }
          AppMethodBeat.o(255767);
        }
      });
      AppMethodBeat.o(255768);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    g(FinderLivePostBtnUIC paramFinderLivePostBtnUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(255769);
      com.tencent.mm.plugin.finder.ui.g localg = this.wyp.dIm();
      if (localg != null)
      {
        localg.dzE();
        AppMethodBeat.o(255769);
        return;
      }
      AppMethodBeat.o(255769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC
 * JD-Core Version:    0.7.0.1
 */