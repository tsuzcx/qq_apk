package com.tencent.mm.plugin.appbrand.ui.privacy.use_record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.gkh;
import com.tencent.mm.protocal.protobuf.gnf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage;", "Lcom/tencent/mm/ui/MMFragment;", "()V", "username", "", "checkContextOnCreateEarly", "", "getLayoutId", "", "initActivityBarArea", "", "initContentArea", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "getNextFetchToken", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetWxaUseUserInfoRecordListResp;", "(Lcom/tencent/mm/protocal/protobuf/WxaAppGetWxaUseUserInfoRecordListResp;)Ljava/lang/Integer;", "hasMoreInfo", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandPrivacyUseRecordPage
  extends MMFragment
{
  public static final AppBrandPrivacyUseRecordPage.a ukU;
  private String username;
  
  static
  {
    AppMethodBeat.i(322930);
    ukU = new AppBrandPrivacyUseRecordPage.a((byte)0);
    AppMethodBeat.o(322930);
  }
  
  public AppBrandPrivacyUseRecordPage()
  {
    super(true);
  }
  
  public static final void a(AppCompatActivity paramAppCompatActivity, String paramString, Class<? extends MMActivity> paramClass)
  {
    AppMethodBeat.i(322872);
    s.u(paramAppCompatActivity, "srcActivity");
    s.u(paramClass, "dstActivityClass");
    Log.i("MicroMsg.AppBrandPrivacyUseRecordPage", s.X("start, username: ", paramString));
    if (paramString != null)
    {
      paramClass = new Intent((Context)paramAppCompatActivity, paramClass);
      com.tencent.mm.plugin.appbrand.ui.privacy.d.a(paramClass, AppBrandPrivacyUseRecordPage.class);
      paramClass.putExtra("username", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(paramAppCompatActivity, paramString.aYi(), "com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramAppCompatActivity.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramAppCompatActivity, "com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(322872);
  }
  
  private static final void a(final com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, final AppBrandPrivacyUseRecordPage paramAppBrandPrivacyUseRecordPage, ah.f paramf, final c paramc1, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(322851);
    s.u(paramc, "$footerViewController");
    s.u(paramAppBrandPrivacyUseRecordPage, "this$0");
    s.u(paramf, "$fetchToken");
    s.u(paramc1, "$adapter");
    if (!paramc.isLoading)
    {
      Log.i("MicroMsg.AppBrandPrivacyUseRecordPage", "onLoadMore, loading is not shown");
      AppMethodBeat.o(322851);
      return;
    }
    j.a((aq)r.g((q)paramAppBrandPrivacyUseRecordPage), null, null, (m)new b(paramf, paramAppBrandPrivacyUseRecordPage, paramc, paramc1, null), 3);
    AppMethodBeat.o(322851);
  }
  
  private static final boolean a(AppBrandPrivacyUseRecordPage paramAppBrandPrivacyUseRecordPage, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322821);
    s.u(paramAppBrandPrivacyUseRecordPage, "this$0");
    paramAppBrandPrivacyUseRecordPage.finish();
    AppMethodBeat.o(322821);
    return true;
  }
  
  private static boolean a(gkh paramgkh)
  {
    return 1 == paramgkh.status;
  }
  
  private static Integer b(gkh paramgkh)
  {
    AppMethodBeat.i(322811);
    if (a(paramgkh))
    {
      paramgkh = paramgkh.acgj;
      s.s(paramgkh, "record_list");
      paramgkh = (gnf)p.oN((List)paramgkh);
      if (paramgkh != null)
      {
        int i = paramgkh.HTK;
        AppMethodBeat.o(322811);
        return Integer.valueOf(i);
      }
    }
    AppMethodBeat.o(322811);
    return null;
  }
  
  private static final void b(LoadMoreRecyclerView paramLoadMoreRecyclerView)
  {
    AppMethodBeat.i(322834);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramLoadMoreRecyclerView, locala.aYi(), "com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage", "initContentArea$onFirstTimesFetched$lambda-3", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
    paramLoadMoreRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramLoadMoreRecyclerView, "com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage", "initContentArea$onFirstTimesFetched$lambda-3", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
    paramLoadMoreRecyclerView.showLoading(true);
    AppMethodBeat.o(322834);
  }
  
  private static final void b(w paramw)
  {
    AppMethodBeat.i(322857);
    paramw.dismiss();
    AppMethodBeat.o(322857);
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_privacy_manage_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322982);
    super.onCreate(paramBundle);
    this.username = getStringExtra("username");
    paramBundle = (CharSequence)this.username;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
      Log.w("MicroMsg.AppBrandPrivacyUseRecordPage", "checkContextOnCreateEarly, username is empty");
      finish();
    }
    label78:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label83;
      }
      AppMethodBeat.o(322982);
      return;
      i = 0;
      break;
    }
    label83:
    AppMethodBeat.o(322982);
  }
  
  public final void onViewCreated(final View paramView, final Bundle paramBundle)
  {
    AppMethodBeat.i(323006);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    setBackBtn(new AppBrandPrivacyUseRecordPage..ExternalSyntheticLambda0(this));
    setMMTitle(ba.i.appbrand_privacy_use_record_title);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.c((MMFragment)this);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this, androidx.core.content.a.w(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.c.BG_2));
    com.tencent.mm.plugin.appbrand.ui.privacy.d.a((MMFragment)this, androidx.core.content.a.w(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.c.BG_2));
    paramView = findViewById(ba.f.content_area);
    if ((paramView instanceof LoadMoreRecyclerView)) {}
    for (paramView = (LoadMoreRecyclerView)paramView; paramView == null; paramView = null)
    {
      Log.w("MicroMsg.AppBrandPrivacyUseRecordPage", "initContentArea, useRecordContentArea is null");
      finish();
      AppMethodBeat.o(323006);
      return;
    }
    paramView.setPadding(0, com.tencent.mm.cd.a.bs(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.d.Edge_2A), 0, 0);
    paramBundle = new com.tencent.mm.plugin.appbrand.ui.privacy.c((ViewGroup)paramView, ba.i.appbrand_privacy_use_record_footer);
    paramView.setLoadingView(paramBundle.uiF);
    paramView.showLoading(false);
    Object localObject = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)paramView, null, null, true, null, null, null, 8182);
    localObject = new c();
    paramView.setAdapter((RecyclerView.a)localObject);
    final ah.f localf = new ah.f();
    paramView.setOnLoadingStateChangedListener(new AppBrandPrivacyUseRecordPage..ExternalSyntheticLambda1(paramBundle, this, localf, (c)localObject));
    final w localw = com.tencent.mm.ui.base.k.a(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), null, false, null);
    MMActivity localMMActivity = com.tencent.mm.plugin.appbrand.ui.privacy.d.a((MMFragment)this);
    if (localMMActivity != null) {
      localMMActivity.keep(new AppBrandPrivacyUseRecordPage..ExternalSyntheticLambda2(localw));
    }
    j.a((aq)r.g((q)this), null, null, (m)new c(this, localw, paramBundle, localf, (c)localObject, paramView, null), 3);
    AppMethodBeat.o(323006);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    Object bNS;
    Object bNT;
    int label;
    
    b(ah.f<Integer> paramf, AppBrandPrivacyUseRecordPage paramAppBrandPrivacyUseRecordPage, com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, c paramc1, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(322779);
      paramObject = (kotlin.d.d)new b(this.uja, paramAppBrandPrivacyUseRecordPage, paramc, paramc1, paramd);
      AppMethodBeat.o(322779);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322772);
      localObject8 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322772);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject10 = (Integer)this.uja.aqH;
        if (localObject10 == null)
        {
          Log.i("MicroMsg.AppBrandPrivacyUseRecordPage", "onLoadMore, fetchToken is null, not need");
          paramObject = ah.aiuX;
          AppMethodBeat.o(322772);
          return paramObject;
        }
        localObject2 = paramc;
        paramObject = this.uja;
        localObject9 = paramAppBrandPrivacyUseRecordPage;
        localObject1 = paramc1;
      }
      try
      {
        localObject3 = b.ukY;
        localObject6 = AppBrandPrivacyUseRecordPage.a(paramAppBrandPrivacyUseRecordPage);
        localObject3 = localObject6;
        if (localObject6 == null) {
          localObject3 = "";
        }
        int i = ((Integer)localObject10).intValue();
        localObject6 = (kotlin.d.d)this;
        this.L$0 = localObject2;
        this.Uf = paramObject;
        this.VC = localObject9;
        this.VD = localObject1;
        this.Ze = localObject2;
        this.aqc = paramObject;
        this.bNS = localObject9;
        this.bNT = localObject1;
        this.label = 1;
        localObject10 = b.a((String)localObject3, i, 0, (kotlin.d.d)localObject6, 4);
        if (localObject10 != localObject8) {
          break label410;
        }
        AppMethodBeat.o(322772);
        return localObject8;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            c localc;
            ResultKt.throwOnFailure(paramObject);
            localObject9 = paramObject;
            paramObject = localObject3;
            Object localObject6 = localObject2;
            localObject2 = localObject8;
            localObject3 = localObject10;
            localObject8 = localc;
            localObject10 = localObject9;
          }
          catch (Exception localException3)
          {
            Object localObject3;
            paramObject = localObject1;
            localObject1 = localObject4;
            Object localObject4 = localException3;
            continue;
          }
          try
          {
            localObject9 = (gkh)localObject10;
            localObject1 = localObject2;
            localObject2 = localObject9;
            paramObject = localObject3;
            AppBrandPrivacyUseRecordPage.a((com.tencent.mm.plugin.appbrand.ui.privacy.c)localObject1, paramObject, (c)localObject8, (gkh)localObject2);
            paramObject = ah.aiuX;
            AppMethodBeat.o(322772);
            return paramObject;
          }
          catch (Exception localException2)
          {
            localObject2 = localException3;
            localObject7 = localObject1;
            localObject1 = paramObject;
            paramObject = localObject7;
            continue;
          }
          localException1 = localException1;
          Log.w("MicroMsg.AppBrandPrivacyUseRecordPage", s.X("onLoadMore, fetch fail since ", localException1));
          localObject4 = null;
          localObject8 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
          Object localObject7 = localObject2;
          Object localObject5 = paramObject;
          localObject8 = localObject1;
          localObject9 = localObject2;
          localObject2 = paramObject;
          paramObject = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject7;
          localObject7 = localObject9;
        }
      }
      localc = (c)this.bNT;
      localObject10 = (ah.f)this.aqc;
      localObject8 = (com.tencent.mm.plugin.appbrand.ui.privacy.c)this.Ze;
      localObject3 = (c)this.VD;
      localObject1 = (ah.f)this.Uf;
      localObject2 = (com.tencent.mm.plugin.appbrand.ui.privacy.c)this.L$0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    Object bNS;
    Object bNT;
    Object bNU;
    Object bNV;
    int label;
    
    c(AppBrandPrivacyUseRecordPage paramAppBrandPrivacyUseRecordPage, w paramw, com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, ah.f<Integer> paramf, c paramc1, LoadMoreRecyclerView paramLoadMoreRecyclerView, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(322784);
      paramObject = (kotlin.d.d)new c(this.ukV, localw, paramBundle, localf, this.ukW, paramView, paramd);
      AppMethodBeat.o(322784);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 106
      //   2: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 112	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 7
      //   10: aload_0
      //   11: getfield 114	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:label	I
      //   14: tableswitch	default:+22 -> 36, 0:+39->53, 1:+189->203
      //   37: nop
      //   38: ineg
      //   39: dup
      //   40: ldc 118
      //   42: invokespecial 121	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   45: astore_1
      //   46: ldc 106
      //   48: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: aload_1
      //   54: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   57: aload_0
      //   58: getfield 57	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ujb	Lcom/tencent/mm/plugin/appbrand/ui/privacy/c;
      //   61: astore_3
      //   62: aload_0
      //   63: getfield 53	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ukV	Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage;
      //   66: astore_2
      //   67: aload_0
      //   68: getfield 59	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:uja	Lkotlin/g/b/ah$f;
      //   71: astore_1
      //   72: aload_0
      //   73: getfield 61	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ukW	Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/c;
      //   76: astore 4
      //   78: aload_0
      //   79: getfield 63	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ukX	Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;
      //   82: astore 5
      //   84: getstatic 133	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/b:ukY	Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/b;
      //   87: astore 6
      //   89: aload_0
      //   90: getfield 53	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ukV	Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage;
      //   93: invokestatic 137	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage:a	(Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage;)Ljava/lang/String;
      //   96: astore 6
      //   98: aload 6
      //   100: ifnonnull +100 -> 200
      //   103: ldc 138
      //   105: astore 6
      //   107: aload_0
      //   108: checkcast 82	kotlin/d/d
      //   111: astore 8
      //   113: aload_0
      //   114: aload_3
      //   115: putfield 140	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:L$0	Ljava/lang/Object;
      //   118: aload_0
      //   119: aload_2
      //   120: putfield 142	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:Uf	Ljava/lang/Object;
      //   123: aload_0
      //   124: aload_1
      //   125: putfield 144	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:VC	Ljava/lang/Object;
      //   128: aload_0
      //   129: aload 4
      //   131: putfield 146	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:VD	Ljava/lang/Object;
      //   134: aload_0
      //   135: aload 5
      //   137: putfield 148	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:Ze	Ljava/lang/Object;
      //   140: aload_0
      //   141: aload_3
      //   142: putfield 150	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:aqc	Ljava/lang/Object;
      //   145: aload_0
      //   146: aload_2
      //   147: putfield 152	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNS	Ljava/lang/Object;
      //   150: aload_0
      //   151: aload_1
      //   152: putfield 154	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNT	Ljava/lang/Object;
      //   155: aload_0
      //   156: aload 4
      //   158: putfield 156	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNU	Ljava/lang/Object;
      //   161: aload_0
      //   162: aload 5
      //   164: putfield 158	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNV	Ljava/lang/Object;
      //   167: aload_0
      //   168: iconst_1
      //   169: putfield 114	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:label	I
      //   172: aload 6
      //   174: iconst_0
      //   175: iconst_0
      //   176: aload 8
      //   178: bipush 6
      //   180: invokestatic 161	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/b:a	(Ljava/lang/String;IILkotlin/d/d;I)Ljava/lang/Object;
      //   183: astore 12
      //   185: aload 12
      //   187: aload 7
      //   189: if_acmpne +265 -> 454
      //   192: ldc 106
      //   194: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload 7
      //   199: areturn
      //   200: goto -93 -> 107
      //   203: aload_0
      //   204: getfield 158	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNV	Ljava/lang/Object;
      //   207: checkcast 163	com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView
      //   210: astore 10
      //   212: aload_0
      //   213: getfield 156	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNU	Ljava/lang/Object;
      //   216: checkcast 165	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/c
      //   219: astore 9
      //   221: aload_0
      //   222: getfield 154	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNT	Ljava/lang/Object;
      //   225: checkcast 167	kotlin/g/b/ah$f
      //   228: astore 11
      //   230: aload_0
      //   231: getfield 152	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:bNS	Ljava/lang/Object;
      //   234: checkcast 9	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage
      //   237: astore 7
      //   239: aload_0
      //   240: getfield 150	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:aqc	Ljava/lang/Object;
      //   243: checkcast 169	com/tencent/mm/plugin/appbrand/ui/privacy/c
      //   246: astore 5
      //   248: aload_0
      //   249: getfield 148	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:Ze	Ljava/lang/Object;
      //   252: checkcast 163	com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView
      //   255: astore_2
      //   256: aload_0
      //   257: getfield 146	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:VD	Ljava/lang/Object;
      //   260: checkcast 165	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/c
      //   263: astore_3
      //   264: aload_0
      //   265: getfield 144	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:VC	Ljava/lang/Object;
      //   268: checkcast 167	kotlin/g/b/ah$f
      //   271: astore 4
      //   273: aload_0
      //   274: getfield 142	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:Uf	Ljava/lang/Object;
      //   277: checkcast 9	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage
      //   280: astore 6
      //   282: aload_0
      //   283: getfield 140	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:L$0	Ljava/lang/Object;
      //   286: checkcast 169	com/tencent/mm/plugin/appbrand/ui/privacy/c
      //   289: astore 8
      //   291: aload_1
      //   292: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   295: aload_1
      //   296: astore 12
      //   298: aload 11
      //   300: astore_1
      //   301: aload 12
      //   303: checkcast 171	com/tencent/mm/protocal/protobuf/gkh
      //   306: astore 11
      //   308: aload 10
      //   310: astore 6
      //   312: aload 9
      //   314: astore 4
      //   316: aload 11
      //   318: astore 8
      //   320: aload_1
      //   321: astore_3
      //   322: aload 7
      //   324: astore_2
      //   325: aload 5
      //   327: astore_1
      //   328: aload_1
      //   329: aload_2
      //   330: aload_3
      //   331: aload 4
      //   333: aload 6
      //   335: aload 8
      //   337: invokestatic 174	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage:a	(Lcom/tencent/mm/plugin/appbrand/ui/privacy/c;Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage;Lkotlin/g/b/ah$f;Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/c;Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;Lcom/tencent/mm/protocal/protobuf/gkh;)V
      //   340: aload_0
      //   341: getfield 55	com/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordPage$c:ujd	Lcom/tencent/mm/ui/base/w;
      //   344: invokevirtual 180	com/tencent/mm/ui/base/w:dismiss	()V
      //   347: getstatic 99	kotlin/ah:aiuX	Lkotlin/ah;
      //   350: astore_1
      //   351: ldc 106
      //   353: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   356: aload_1
      //   357: areturn
      //   358: astore 6
      //   360: aload_3
      //   361: astore 7
      //   363: aload_1
      //   364: astore_3
      //   365: aload 7
      //   367: astore_1
      //   368: ldc 182
      //   370: ldc 184
      //   372: aload 6
      //   374: invokestatic 190	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   377: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   380: aconst_null
      //   381: astore 8
      //   383: aload 5
      //   385: astore 6
      //   387: goto -59 -> 328
      //   390: astore 9
      //   392: aload 8
      //   394: astore_1
      //   395: aload_3
      //   396: astore 5
      //   398: aload_2
      //   399: astore 7
      //   401: aload 6
      //   403: astore_2
      //   404: aload 4
      //   406: astore_3
      //   407: aload 5
      //   409: astore 4
      //   411: aload 7
      //   413: astore 5
      //   415: aload 9
      //   417: astore 6
      //   419: goto -51 -> 368
      //   422: astore 7
      //   424: aload 8
      //   426: astore_1
      //   427: aload_3
      //   428: astore 5
      //   430: aload_2
      //   431: astore 8
      //   433: aload 6
      //   435: astore_2
      //   436: aload 4
      //   438: astore_3
      //   439: aload 5
      //   441: astore 4
      //   443: aload 8
      //   445: astore 5
      //   447: aload 7
      //   449: astore 6
      //   451: goto -83 -> 368
      //   454: aload_3
      //   455: astore 6
      //   457: aload_2
      //   458: astore 7
      //   460: aload_1
      //   461: astore 14
      //   463: aload 4
      //   465: astore 9
      //   467: aload 5
      //   469: astore 10
      //   471: aload_3
      //   472: astore 8
      //   474: aload_1
      //   475: astore 11
      //   477: aload 4
      //   479: astore_3
      //   480: aload 5
      //   482: astore 13
      //   484: aload 14
      //   486: astore_1
      //   487: aload 6
      //   489: astore 5
      //   491: aload_2
      //   492: astore 6
      //   494: aload 11
      //   496: astore 4
      //   498: aload 13
      //   500: astore_2
      //   501: goto -200 -> 301
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	504	0	this	c
      //   0	504	1	paramObject	Object
      //   66	435	2	localObject1	Object
      //   61	419	3	localObject2	Object
      //   76	421	4	localObject3	Object
      //   82	408	5	localObject4	Object
      //   87	247	6	localObject5	Object
      //   358	15	6	localException1	Exception
      //   385	108	6	localObject6	Object
      //   8	404	7	localObject7	Object
      //   422	26	7	localException2	Exception
      //   458	1	7	localObject8	Object
      //   111	362	8	localObject9	Object
      //   219	94	9	localc	c
      //   390	26	9	localException3	Exception
      //   465	1	9	localObject10	Object
      //   210	260	10	localObject11	Object
      //   228	267	11	localObject12	Object
      //   183	119	12	localObject13	Object
      //   482	17	13	localObject14	Object
      //   461	24	14	localObject15	Object
      // Exception table:
      //   from	to	target	type
      //   84	98	358	java/lang/Exception
      //   107	185	358	java/lang/Exception
      //   291	295	390	java/lang/Exception
      //   301	308	422	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.use_record.AppBrandPrivacyUseRecordPage
 * JD-Core Version:    0.7.0.1
 */