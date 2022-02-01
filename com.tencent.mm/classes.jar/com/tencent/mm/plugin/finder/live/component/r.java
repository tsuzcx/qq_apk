package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.f.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "activeFinish", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getAnchorPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setAnchorPluginLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "getFinderLivePageFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "setFinderLivePageFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;)V", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "getLayoutId", "", "getPluginLayout", "initBusiness", "", "initData", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "setupLiveRoomData", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "tryHideFloatBallWhenEnterPage", "tryShowFloatBallWhenExitPage", "uninitBusiness", "uninitBusinessCheck", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class r
  extends UIComponent
{
  private com.tencent.mm.plugin.finder.live.view.f BoD;
  private Runnable CxA;
  private com.tencent.mm.plugin.finder.live.view.a Cxy;
  private boolean Cxz;
  private final String TAG;
  private boolean callOnce;
  private boolean isPaused;
  private i lKz;
  private boolean mJk;
  
  public r(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352880);
    this.TAG = "MicroMsg.FinderLiveAnchorWithoutAffinityUI";
    AppMethodBeat.o(352880);
  }
  
  private static final void a(r paramr)
  {
    AppMethodBeat.i(352920);
    s.u(paramr, "this$0");
    if (paramr.lKz == null)
    {
      paramr.lKz = new i(paramr.getContext());
      i locali = paramr.lKz;
      if (locali != null) {
        locali.afIL = new r..ExternalSyntheticLambda0(paramr);
      }
    }
    paramr = paramr.lKz;
    if (paramr != null) {
      paramr.start();
    }
    AppMethodBeat.o(352920);
  }
  
  private static final void a(r paramr, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(352910);
    s.u(paramr, "this$0");
    Log.i(paramr.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramr.mJk != paramBoolean)
      {
        paramr.mJk = paramBoolean;
        paramr = paramr.Cxy;
        if (paramr != null) {
          paramr.keyboardChange(paramBoolean, paramInt);
        }
      }
      AppMethodBeat.o(352910);
      return;
    }
  }
  
  private static final void b(r paramr)
  {
    AppMethodBeat.i(352928);
    s.u(paramr, "this$0");
    paramr.ehS();
    AppMethodBeat.o(352928);
  }
  
  private final void ehS()
  {
    AppMethodBeat.i(352889);
    if (this.callOnce)
    {
      AppMethodBeat.o(352889);
      return;
    }
    ehT();
    this.callOnce = true;
    AppMethodBeat.o(352889);
  }
  
  private void ehT()
  {
    AppMethodBeat.i(352899);
    Log.i(this.TAG, s.X("[LiveLifecycler]uninitBusiness ", this));
    com.tencent.mm.plugin.finder.live.view.a locala = this.Cxy;
    if (locala != null) {
      locala.unMount();
    }
    AppMethodBeat.o(352899);
  }
  
  public com.tencent.mm.plugin.finder.live.view.a ehM()
  {
    AppMethodBeat.i(353071);
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)new com.tencent.mm.plugin.finder.live.view.b((MMActivity)getActivity(), getFragment());
    AppMethodBeat.o(353071);
    return locala;
  }
  
  public void ehN()
  {
    AppMethodBeat.i(352991);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().getDecorView().setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      getContext().getWindow().setStatusBarColor(0);
      getContext().getWindow().setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(352991);
  }
  
  public void ehO()
  {
    AppMethodBeat.i(353134);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.DOI;
    if (Util.isEqual(com.tencent.mm.plugin.finder.live.view.f.evB(), toString()))
    {
      localObject = aj.CGT;
      localObject = aj.elr();
      if (localObject == null) {
        break label171;
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EcI != true)) {
        break label171;
      }
      i = 1;
      if (i != 0)
      {
        localObject = aj.CGT;
        localObject = aj.elr();
        if (localObject == null) {
          break label176;
        }
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).isLiveStarted() != true)) {
          break label176;
        }
        i = 1;
        label101:
        if (i != 0)
        {
          localObject = aj.CGT;
          localObject = aj.elr();
          if (localObject == null) {
            break label181;
          }
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).eyA())) {
            break label181;
          }
        }
      }
    }
    label171:
    label176:
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.BoD;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhW();
        }
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
      AppMethodBeat.o(353134);
      return;
      i = 0;
      break;
      i = 0;
      break label101;
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a ehP()
  {
    return this.Cxy;
  }
  
  public final com.tencent.mm.plugin.finder.live.view.f ehQ()
  {
    return this.BoD;
  }
  
  public final void ehR()
  {
    AppMethodBeat.i(353093);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.DOI;
    com.tencent.mm.plugin.finder.live.view.f.axX(toString());
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhT();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(353093);
  }
  
  public int getLayoutId()
  {
    return p.f.Cfw;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(353161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.Cxy;
    if (locala != null) {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(353161);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(353153);
    Log.i(this.TAG, s.X("[LiveLifecycler]onBackPressed ", this));
    com.tencent.mm.plugin.finder.live.view.a locala = this.Cxy;
    if (locala == null)
    {
      AppMethodBeat.o(353153);
      return false;
    }
    boolean bool = locala.onBackPress();
    AppMethodBeat.o(353153);
    return bool;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(353165);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      ehT();
    }
    for (;;)
    {
      this.Cxz = true;
      AppMethodBeat.o(353165);
      return;
      this.CxA = new r..ExternalSyntheticLambda1(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(353051);
    Log.i(this.TAG, s.X("[LiveLifecycler]onCreate ", this));
    super.onCreate(paramBundle);
    ehN();
    FinderLiveBundle localFinderLiveBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    paramBundle = aj.CGT;
    paramBundle = aj.elr();
    boolean bool2;
    label76:
    int i;
    label104:
    int j;
    label127:
    boolean bool1;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = aj.CGT;
      localObject1 = aj.elr();
      if (localObject1 != null) {
        break label403;
      }
      bool2 = false;
      localObject1 = aj.CGT;
      if ((aj.elr() != null) || (getIntent().getIntExtra("KEY_PARAMS_SOURCE_TYPE", -1) != 5)) {
        break label437;
      }
      i = 1;
      if (localFinderLiveBundle == null) {
        break label460;
      }
      if (((Collection)localFinderLiveBundle.CFa).isEmpty()) {
        break label442;
      }
      j = 1;
      if (j == 0) {
        break label460;
      }
      localObject1 = (LiveConfig)p.oL((List)localFinderLiveBundle.CFa);
      if (localObject1 != null) {
        break label447;
      }
      localObject1 = null;
      label155:
      if (s.p(localObject1, paramBundle)) {
        break label460;
      }
      localObject1 = (LiveConfig)p.oL((List)localFinderLiveBundle.CFa);
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = LiveConfig.aw("", 0);
      }
      s.s(paramBundle, "configProvider.liveConfi…efaultAnchorConfig(\"\", 0)");
      paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
      bool1 = false;
      label215:
      localObject2 = this.TAG;
      localObject1 = new StringBuilder("onCreate isFromFloat:").append(bool1).append(", externalPost:").append(bool2).append(", finderLiveData:").append(paramBundle).append(", configProvider:").append(localFinderLiveBundle).append(", FinderLiveService.liveData:");
      localObject3 = aj.CGT;
      localObject3 = ((StringBuilder)localObject1).append(aj.egD()).append(", FinderLiveService.liveData?.liveDataList:");
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label769;
      }
    }
    label769:
    for (Object localObject1 = null;; localObject1 = ((g)localObject1).Ebx)
    {
      Log.i((String)localObject2, localObject1);
      if (paramBundle != null) {
        break label779;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      getContext().finish();
      AppMethodBeat.o(353051);
      return;
      paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramBundle.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = paramBundle.liveInfo;
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = Long.valueOf(paramBundle.liveId);
      break;
      label403:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null)
      {
        bool2 = false;
        break label76;
      }
      bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eet;
      break label76;
      label437:
      i = 0;
      break label104;
      label442:
      j = 0;
      break label127;
      label447:
      localObject1 = Long.valueOf(((LiveConfig)localObject1).liveId);
      break label155;
      label460:
      if (paramBundle == null)
      {
        label464:
        paramBundle = aj.CGT;
        paramBundle = aj.egD();
        if (paramBundle != null) {
          break label600;
        }
        localObject1 = null;
        label479:
        if (localObject1 != null)
        {
          if (localFinderLiveBundle != null) {
            break label645;
          }
          paramBundle = "";
          label493:
          ((LiveConfig)localObject1).mIQ = paramBundle;
        }
        if (!bool2) {
          break label715;
        }
        paramBundle = LiveConfig.aw("", 0);
        s.s(paramBundle, "getDefaultAnchorConfig(\"\", 0)");
        paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
        localObject1 = (q)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramBundle.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).business(q.class);
        if (localFinderLiveBundle != null) {
          break label705;
        }
      }
      label645:
      label705:
      for (bool1 = false;; bool1 = localFinderLiveBundle.CEZ)
      {
        ((q)localObject1).sp(bool1);
        bool1 = true;
        break;
        if (paramBundle.longValue() != 0L) {
          break label464;
        }
        Log.w(this.TAG, "unkonwn data source! break onCreate");
        paramBundle = null;
        bool1 = false;
        break;
        label600:
        paramBundle = paramBundle.Ebx;
        if (paramBundle == null)
        {
          localObject1 = null;
          break label479;
        }
        paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)p.oL((List)paramBundle);
        if (paramBundle == null)
        {
          localObject1 = null;
          break label479;
        }
        localObject1 = paramBundle.Ebr;
        break label479;
        paramBundle = localFinderLiveBundle.CFa;
        if (paramBundle == null)
        {
          paramBundle = "";
          break label493;
        }
        paramBundle = (LiveConfig)p.oL((List)paramBundle);
        if (paramBundle == null)
        {
          paramBundle = "";
          break label493;
        }
        localObject2 = paramBundle.mIQ;
        paramBundle = (Bundle)localObject2;
        if (localObject2 != null) {
          break label493;
        }
        paramBundle = "";
        break label493;
      }
      label715:
      paramBundle = aj.CGT;
      paramBundle = aj.egD();
      if (paramBundle == null)
      {
        paramBundle = null;
        bool1 = true;
        break label215;
      }
      paramBundle = paramBundle.Ebx;
      if (paramBundle == null)
      {
        paramBundle = null;
        bool1 = true;
        break label215;
      }
      paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)p.oL((List)paramBundle);
      bool1 = true;
      break label215;
    }
    label779:
    this.Cxy = ehM();
    ((FrameLayout)getContext().findViewById(p.e.BKe)).addView((View)this.Cxy);
    localObject1 = aj.CGT;
    localObject1 = new g();
    ((g)localObject1).an(p.al(new com.tencent.mm.plugin.finder.live.viewmodel.data.f[] { paramBundle }));
    Object localObject2 = ah.aiuX;
    aj.a((g)localObject1);
    localObject1 = getIntent().getByteArrayExtra("KEY_PARAMS_NOTICE");
    if (localObject1 != null)
    {
      paramBundle.BvE = new bkk();
      localObject2 = paramBundle.BvE;
      s.checkNotNull(localObject2);
      ((bkk)localObject2).parseFrom((byte[])localObject1);
    }
    if (bool2)
    {
      localObject1 = aj.CGT;
      localObject2 = aj.elr();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveAnchorUIC");
      }
      if (i != 0)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet = true;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeu = getIntent().getStringExtra("KEY_PARAMS_GAME_APP_ID");
      }
      if (bool1) {
        break label1886;
      }
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localFinderLiveBundle != null) {
        break label1183;
      }
      j = 1;
      label1001:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).CFc = j;
      localObject2 = getIntent().getSerializableExtra("KEY_PARAMS_TAGIFNOS");
      if (!(localObject2 instanceof List)) {
        break label1192;
      }
    }
    Object localObject5;
    label1183:
    label1192:
    for (localObject2 = (List)localObject2;; localObject2 = null)
    {
      if (localObject2 == null) {
        break label1198;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFd = new LinkedList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (byte[])((Iterator)localObject2).next();
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFd;
        if (localObject3 != null)
        {
          localObject4 = new bno();
          ((bno)localObject4).parseFrom((byte[])localObject5);
          localObject5 = ah.aiuX;
          ((LinkedList)localObject3).add(localObject4);
        }
      }
      localObject1 = aj.CGT;
      localObject2 = aj.a(paramBundle);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveAnchorUIC");
      break;
      j = localFinderLiveBundle.CFc;
      break label1001;
    }
    label1198:
    Object localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject4 = getIntent().getByteArrayExtra("KEY_PARAMS_CHOSEN_TAG");
    if (localObject4 == null) {
      localObject2 = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).CFe = ((bno)localObject2);
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class);
      localObject2 = getIntent().getSerializableExtra("KEY_PARAMS_VISITOR_WHITE_LIST");
      if ((localObject2 instanceof List))
      {
        localObject2 = (List)localObject2;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)localObject3).Eiq = ((List)localObject2);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFg = getIntent().getIntExtra("KEY_PARAMS_VISIBLE_ROOM_MAX_COUNT", 0);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFh = getIntent().getIntExtra("KEY_PARAMS_VISIBLE_USER_MAX_COUNT", 0);
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        localObject3 = new bjh();
        localObject4 = (com.tencent.mm.bx.a)localObject3;
        localObject5 = getIntent().getByteArrayExtra("KEY_PARAMS_LUCKY_MONEY_CONFIG");
      }
      try
      {
        ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject5);
        localObject4 = ah.aiuX;
        s.u(localObject3, "<set-?>");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).EdP = ((bjh)localObject3);
        localObject2 = getIntent().getByteArrayExtra("KEY_PARAMS_BG_MUSIC_ID_LIST");
        if (localObject2 != null)
        {
          localObject3 = new bfk();
          ((bfk)localObject3).parseFrom((byte[])localObject2);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.aq(((bfk)localObject3).ZPo);
        }
        localObject3 = getIntent().getByteArrayExtra("KEY_PARAMS_LIVE_TASK_INFO");
        if (localObject3 != null)
        {
          localObject2 = new biz();
          ((biz)localObject2).parseFrom((byte[])localObject3);
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          localObject2 = ((biz)localObject2).ZGA;
          s.s(localObject2, "taskInfo.quest_activities");
          s.u(localObject2, "<set-?>");
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).Eel = ((LinkedList)localObject2);
        }
        localObject4 = getIntent().getByteArrayExtra("KEY_PARAMS_LAYER_SHOW_INFO");
        if (localObject4 != null)
        {
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          localObject3 = new bix();
          ((bix)localObject3).parseFrom((byte[])localObject4);
          localObject4 = ah.aiuX;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).Eeq = ((bix)localObject3);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("setupLiveRoomData set layerShowInfo:");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeq;
          if (localObject2 == null)
          {
            localObject2 = null;
            localObject4 = ((StringBuilder)localObject4).append(localObject2).append(',');
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeq;
            if (localObject2 != null) {
              break label2123;
            }
            localObject2 = null;
            Log.i((String)localObject3, localObject2);
          }
        }
        else
        {
          j = getIntent().getIntExtra("KEY_PARAMS_RANDOM_MIC_MATCH_TIMEOUT", 0);
          if (j > 0)
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfL = j;
            Log.i(this.TAG, s.X("setupLiveRoomData: randomMicMatchTimeout = ", Integer.valueOf(j)));
          }
          localObject4 = getIntent().getByteArrayExtra("KEY_PARAMS_FANS_CLUB");
          if (localObject4 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
            localObject3 = new bgw();
            ((bgw)localObject3).parseFrom((byte[])localObject4);
            localObject4 = ah.aiuX;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)localObject2).a((bgw)localObject3);
          }
          localObject4 = getIntent().getByteArrayExtra("KEY_PARAMS_LIVE_CO_CERT_REWARD_INFO");
          if (localObject4 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            localObject3 = new auy();
            ((auy)localObject3).parseFrom((byte[])localObject4);
            localObject4 = ah.aiuX;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).EcQ = ((auy)localObject3);
          }
          boolean bool3 = getIntent().getBooleanExtra("KEY_PARAMS_LIVE_IS_FROM_SCAN", false);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcP = bool3;
          label1886:
          if ((bool2) || (i != 0))
          {
            s.u(localObject1, "<set-?>");
            paramBundle.BxG = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
          }
          localObject2 = this.Cxy;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.view.a)localObject2).bindData(paramBundle);
          }
          if (!bool2) {
            break label2136;
          }
          localObject1 = aj.CGT;
          localObject1 = this.Cxy;
          s.checkNotNull(localObject1);
          aj.a((com.tencent.mm.plugin.finder.live.view.a)localObject1);
          localObject1 = this.Cxy;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.a)localObject1).activate(paramBundle, bool1, false);
          }
          localObject1 = this.Cxy;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.a)localObject1).mount();
          }
          paramBundle.BvE = new bkk();
          this.BoD = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new com.tencent.mm.plugin.ball.a.e(getContext()));
          localObject1 = this.BoD;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.f)localObject1).J(21, "LiveFloatBall");
          }
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(paramBundle, localFinderLiveBundle);
          AppMethodBeat.o(353051);
          return;
          localObject2 = new bno();
          ((bno)localObject2).parseFrom((byte[])localObject4);
          continue;
          localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          continue;
          localObject2 = Integer.valueOf(((bix)localObject2).show_type);
          continue;
          label2123:
          localObject2 = Integer.valueOf(((bix)localObject2).ZSF);
          continue;
          label2136:
          if (i != 0)
          {
            aj.a(aj.CGT, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, this.Cxy, 1, null, 8);
          }
          else
          {
            localObject2 = aj.CGT;
            localObject3 = this.Cxy;
            s.checkNotNull(localObject3);
            aj.a((aj)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (com.tencent.mm.plugin.finder.live.view.a)localObject3, 0, null, 12);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(353141);
    Log.i(this.TAG, s.X("[LiveLifecycler]onDestroy ", this));
    super.onDestroy();
    com.tencent.mm.plugin.finder.live.view.f localf = this.BoD;
    if (localf != null) {
      localf.onDestroy();
    }
    if (!this.Cxz) {
      ehS();
    }
    AppMethodBeat.o(353141);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(353009);
    super.onNewIntent(paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.Cxy;
    if (locala != null) {
      locala.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(353009);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(353116);
    Log.i(this.TAG, s.X("[LiveLifecycler]onPause ", this));
    super.onPause();
    Object localObject = this.lKz;
    if (localObject != null) {
      ((i)localObject).close();
    }
    localObject = this.Cxy;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).pause();
    }
    this.isPaused = true;
    localObject = this.CxA;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.CxA = null;
    AppMethodBeat.o(353116);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(353171);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Log.i(this.TAG, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if ((paramInt == 64) && (paramArrayOfInt[0] != 0) && (!androidx.core.app.a.a((Activity)getActivity(), "android.permission.ACCESS_FINE_LOCATION")))
    {
      paramArrayOfString = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
      if ((paramArrayOfString instanceof String)) {}
      for (paramArrayOfString = (String)paramArrayOfString; com.tencent.mm.au.b.OE(paramArrayOfString); paramArrayOfString = null)
      {
        AppMethodBeat.o(353171);
        return;
      }
      if (System.currentTimeMillis() - com.tencent.mm.pluginsdk.permission.b.ix("android.permission.ACCESS_FINE_LOCATION", 64) < 300L) {
        com.tencent.mm.pluginsdk.permission.b.lx((Context)getContext());
      }
    }
    AppMethodBeat.o(353171);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(353105);
    Log.i(this.TAG, s.X("[LiveLifecycler]onResume ", this));
    super.onResume();
    com.tencent.mm.plugin.finder.live.view.a locala = this.Cxy;
    if (locala != null) {
      locala.resume();
    }
    locala = this.Cxy;
    if (locala != null) {
      locala.post(new r..ExternalSyntheticLambda2(this));
    }
    Log.i(this.TAG, s.X("[LiveLifecycler]initBusiness ", this));
    AppMethodBeat.o(353105);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(353063);
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = this.TAG;
    Object localObject3 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    aj localaj = aj.CGT;
    Log.i((String)localObject1, aj.elr());
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null)
      {
        localObject3 = new LiveConfig.a();
        ((LiveConfig.a)localObject3).mIy = LiveConfig.mIs;
        ((LiveConfig.a)localObject3).liveId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo.liveId;
        ((LiveConfig.a)localObject3).nonceId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).nonceId;
        ((LiveConfig.a)localObject3).mIH = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
        ((LiveConfig.a)localObject3).mIC = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        ((LiveConfig.a)localObject3).desc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc;
        localObject1 = ((LiveConfig.a)localObject3).bcd();
        s.s(localObject1, "builder.toWhere(LiveConf…\n                .build()");
        localObject3 = new FinderLiveBundle();
        ((FinderLiveBundle)localObject3).CFa.add(localObject1);
        if (paramBundle != null) {
          paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject3);
        }
        if (paramBundle != null)
        {
          localObject1 = ((FinderLiveBundle)localObject3).Bpo;
          if (localObject1 != null) {
            break label273;
          }
          localObject1 = null;
          paramBundle.putByteArray("KEY_PARAMS_NOTICE", (byte[])localObject1);
        }
        if (paramBundle != null)
        {
          localObject1 = ((FinderLiveBundle)localObject3).CFb;
          if (localObject1 != null) {
            break label281;
          }
        }
      }
    }
    label273:
    label281:
    for (localObject1 = localObject2;; localObject1 = ((biz)localObject1).toByteArray())
    {
      paramBundle.putByteArray("KEY_PARAMS_LIVE_TASK_INFO", (byte[])localObject1);
      AppMethodBeat.o(353063);
      return;
      localObject1 = ((bkk)localObject1).toByteArray();
      break;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(353083);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStart ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.DOI;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.f.evB());
    super.onStart();
    localObject = this.Cxy;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).start();
    }
    ehR();
    AppMethodBeat.o(353083);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(353126);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStop ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.DOI;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.f.evB());
    super.onStop();
    localObject = com.tencent.mm.plugin.finder.live.view.f.DOI;
    if (Util.isEqual(com.tencent.mm.plugin.finder.live.view.f.evB(), toString()))
    {
      localObject = this.Cxy;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.a)localObject).stop();
      }
      ehO();
    }
    AppMethodBeat.o(353126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.r
 * JD-Core Version:    0.7.0.1
 */