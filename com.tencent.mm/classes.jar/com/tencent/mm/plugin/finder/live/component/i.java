package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
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
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.view.f.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "activeFinish", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getAnchorPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setAnchorPluginLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "getFinderLivePageFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "setFinderLivePageFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;)V", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "getLayoutId", "", "getPluginLayout", "initBusiness", "", "initData", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "setupLiveRoomData", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "tryHideFloatBallWhenEnterPage", "tryShowFloatBallWhenExitPage", "uninitBusiness", "uninitBusinessCheck", "plugin-finder_release"})
public class i
  extends UIComponent
{
  final String TAG;
  private boolean isPaused;
  private com.tencent.mm.ui.tools.i jij;
  private boolean kiD;
  private com.tencent.mm.plugin.finder.live.view.f xOE;
  private com.tencent.mm.plugin.finder.live.view.a xZo;
  private boolean xZp;
  private Runnable xZq;
  private boolean xZr;
  
  public i(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(273524);
    this.TAG = "MicroMsg.FinderLiveAnchorWithoutAffinityUI";
    AppMethodBeat.o(273524);
  }
  
  private final void dxl()
  {
    AppMethodBeat.i(273521);
    if (this.xZr)
    {
      AppMethodBeat.o(273521);
      return;
    }
    dxm();
    this.xZr = true;
    AppMethodBeat.o(273521);
  }
  
  private void dxm()
  {
    AppMethodBeat.i(273522);
    Log.i(this.TAG, "[LiveLifecycler]uninitBusiness ".concat(String.valueOf(this)));
    com.tencent.mm.plugin.finder.live.view.a locala = this.xZo;
    if (locala != null)
    {
      locala.unMount();
      AppMethodBeat.o(273522);
      return;
    }
    AppMethodBeat.o(273522);
  }
  
  public com.tencent.mm.plugin.finder.live.view.a dxf()
  {
    AppMethodBeat.i(273509);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(273509);
      throw ((Throwable)localObject);
    }
    localObject = (com.tencent.mm.plugin.finder.live.view.a)new com.tencent.mm.plugin.finder.live.view.b((MMActivity)localObject, getFragment());
    AppMethodBeat.o(273509);
    return localObject;
  }
  
  public void dxg()
  {
    AppMethodBeat.i(273503);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(273503);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      localObject = ((Window)localObject).getDecorView();
      p.j(localObject, "context.window.decorView");
      ((View)localObject).setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(273503);
  }
  
  public void dxh()
  {
    AppMethodBeat.i(273517);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.yVy;
    if (Util.isEqual(com.tencent.mm.plugin.finder.live.view.f.dFl(), toString()))
    {
      localObject = ah.yhC;
      localObject = ah.dzj();
      if (localObject == null) {
        break label81;
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {
        break label81;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfn == true)
      {
        localObject = this.xOE;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOj();
        }
        com.tencent.mm.plugin.ball.f.f.cwA();
      }
    }
    AppMethodBeat.o(273517);
    return;
    label81:
    AppMethodBeat.o(273517);
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a dxi()
  {
    return this.xZo;
  }
  
  public final com.tencent.mm.plugin.finder.live.view.f dxj()
  {
    return this.xOE;
  }
  
  public final void dxk()
  {
    AppMethodBeat.i(273511);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.yVy;
    com.tencent.mm.plugin.finder.live.view.f.aCV(toString());
    localObject = this.xOE;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOf();
    }
    com.tencent.mm.plugin.ball.f.f.cvI();
    AppMethodBeat.o(273511);
  }
  
  public int getLayoutId()
  {
    return b.g.finder_live_root;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273520);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.xZo;
    if (locala != null)
    {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(273520);
      return;
    }
    AppMethodBeat.o(273520);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(273519);
    Log.i(this.TAG, "[LiveLifecycler]onBackPressed ".concat(String.valueOf(this)));
    com.tencent.mm.plugin.finder.live.view.a locala = this.xZo;
    if (locala != null)
    {
      boolean bool = locala.onBackPress();
      AppMethodBeat.o(273519);
      return bool;
    }
    AppMethodBeat.o(273519);
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(273523);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      dxm();
    }
    for (;;)
    {
      this.xZp = true;
      AppMethodBeat.o(273523);
      return;
      this.xZq = ((Runnable)new a(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273507);
    Log.i(this.TAG, "[LiveLifecycler]onCreate ".concat(String.valueOf(this)));
    super.onCreate(paramBundle);
    dxg();
    FinderLiveBundle localFinderLiveBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    paramBundle = ah.yhC;
    paramBundle = ah.dzj();
    boolean bool2;
    label131:
    int i;
    label159:
    label182:
    label217:
    boolean bool1;
    label279:
    Object localObject2;
    if (paramBundle != null)
    {
      paramBundle = (c)paramBundle.business(c.class);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.liveInfo;
        if (paramBundle != null)
        {
          paramBundle = Long.valueOf(paramBundle.liveId);
          localObject1 = ah.yhC;
          localObject1 = ah.dzj();
          if (localObject1 == null) {
            break label431;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localObject1 == null) {
            break label431;
          }
          bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgy;
          localObject1 = ah.yhC;
          if ((ah.dzj() != null) || (getIntent().getIntExtra("KEY_PARAMS_SOURCE_TYPE", -1) != 5)) {
            break label437;
          }
          i = 1;
          if (localFinderLiveBundle == null) {
            break label453;
          }
          if (((Collection)localFinderLiveBundle.yeC).isEmpty()) {
            break label442;
          }
          j = 1;
          if (j == 0) {
            break label453;
          }
          localObject1 = (LiveConfig)kotlin.a.j.lp((List)localFinderLiveBundle.yeC);
          if (localObject1 == null) {
            break label447;
          }
          localObject1 = Long.valueOf(((LiveConfig)localObject1).getLiveId());
          if (!(p.h(localObject1, paramBundle) ^ true)) {
            break label453;
          }
          localObject1 = (LiveConfig)kotlin.a.j.lp((List)localFinderLiveBundle.yeC);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = LiveConfig.an("", 0);
            p.j(paramBundle, "LiveConfig.getDefaultAnchorConfig(\"\", 0)");
          }
          paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
          bool1 = false;
          localObject2 = this.TAG;
          localObject1 = new StringBuilder("onCreate isFromFloat:").append(bool1).append(", externalPost:").append(bool2).append(", finderLiveData:").append(paramBundle).append(", configProvider:").append(localFinderLiveBundle).append(", FinderLiveService.liveData:");
          localObject3 = ah.yhC;
          localObject3 = ((StringBuilder)localObject1).append(ah.dwh()).append(", FinderLiveService.liveData?.liveDataList:");
          localObject1 = ah.yhC;
          localObject1 = ah.dwh();
          if (localObject1 == null) {
            break label715;
          }
        }
      }
    }
    label431:
    label437:
    label442:
    label447:
    label453:
    label457:
    label715:
    for (Object localObject1 = ((g)localObject1).zeA;; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      if (paramBundle != null) {
        break label721;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      getContext().finish();
      AppMethodBeat.o(273507);
      return;
      paramBundle = null;
      break;
      bool2 = false;
      break label131;
      i = 0;
      break label159;
      j = 0;
      break label182;
      localObject1 = null;
      break label217;
      if (paramBundle == null)
      {
        paramBundle = ah.yhC;
        paramBundle = ah.dwh();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.zeA;
          if (paramBundle != null)
          {
            paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)kotlin.a.j.lp((List)paramBundle);
            if (paramBundle != null)
            {
              localObject2 = paramBundle.zey;
              if (localObject2 != null)
              {
                if (localFinderLiveBundle != null)
                {
                  paramBundle = localFinderLiveBundle.yeC;
                  if (paramBundle != null)
                  {
                    paramBundle = (LiveConfig)kotlin.a.j.lp((List)paramBundle);
                    if (paramBundle != null)
                    {
                      localObject1 = paramBundle.aJo();
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 != null) {
                        break label552;
                      }
                    }
                  }
                }
                paramBundle = "";
                ((LiveConfig)localObject2).Nc(paramBundle);
              }
            }
          }
        }
        if (!bool2) {
          break label669;
        }
        paramBundle = LiveConfig.an("", 0);
        p.j(paramBundle, "LiveConfig.getDefaultAnchorConfig(\"\", 0)");
        paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramBundle.xWR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localFinderLiveBundle == null) {
          break label663;
        }
      }
      for (bool1 = localFinderLiveBundle.yeB;; bool1 = false)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).pB(bool1);
        bool1 = true;
        break;
        if (paramBundle.longValue() != 0L) {
          break label457;
        }
        Log.w(this.TAG, "unkonwn data source! break onCreate");
        paramBundle = null;
        bool1 = false;
        break;
      }
      paramBundle = ah.yhC;
      paramBundle = ah.dwh();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.zeA;
        if (paramBundle != null)
        {
          paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)kotlin.a.j.lp((List)paramBundle);
          bool1 = true;
          break label279;
        }
      }
      paramBundle = null;
      bool1 = true;
      break label279;
    }
    label552:
    label721:
    this.xZo = dxf();
    label663:
    label669:
    ((FrameLayout)getContext().findViewById(b.f.finder_live_content_root)).addView((View)this.xZo);
    localObject1 = ah.yhC;
    localObject1 = new g();
    ((g)localObject1).aj(kotlin.a.j.ag(new com.tencent.mm.plugin.finder.live.viewmodel.data.f[] { paramBundle }));
    ah.a((g)localObject1);
    localObject1 = getIntent().getByteArrayExtra("KEY_PARAMS_NOTICE");
    if (localObject1 != null)
    {
      paramBundle.xUD = new bbh();
      localObject2 = paramBundle.xUD;
      if (localObject2 == null) {
        p.iCn();
      }
      ((bbh)localObject2).parseFrom((byte[])localObject1);
    }
    if (bool2)
    {
      localObject1 = ah.yhC;
      localObject2 = ah.dzj();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveAnchorUIC");
      }
      if (i != 0)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy = true;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz = getIntent().getStringExtra("KEY_PARAMS_GAME_APP_ID");
      }
      if (bool1) {
        break label1648;
      }
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localFinderLiveBundle == null) {
        break label1129;
      }
    }
    Object localObject5;
    label1129:
    for (int j = localFinderLiveBundle.yeE;; j = 1)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).yeE = j;
      localObject3 = getIntent().getSerializableExtra("KEY_PARAMS_TAGIFNOS");
      localObject2 = localObject3;
      if (!(localObject3 instanceof List)) {
        localObject2 = null;
      }
      localObject2 = (List)localObject2;
      if (localObject2 == null) {
        break label1134;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeF = new LinkedList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (byte[])((Iterator)localObject2).next();
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeF;
        if (localObject4 != null)
        {
          localObject5 = new bda();
          ((bda)localObject5).parseFrom((byte[])localObject3);
          ((LinkedList)localObject4).add(localObject5);
        }
      }
      localObject1 = ah.yhC;
      localObject2 = ah.a(paramBundle);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a("FinderLiveAnchorUIC");
      break;
    }
    label1134:
    Object localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    Object localObject4 = getIntent().getByteArrayExtra("KEY_PARAMS_CHOSEN_TAG");
    if (localObject4 != null)
    {
      localObject2 = new bda();
      ((bda)localObject2).parseFrom((byte[])localObject4);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject3).yeG = ((bda)localObject2);
      localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      localObject3 = getIntent().getSerializableExtra("KEY_PARAMS_VISITOR_WHITE_LIST");
      localObject2 = localObject3;
      if (!(localObject3 instanceof List)) {
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject4).ziQ = ((List)localObject2);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeI = getIntent().getIntExtra("KEY_PARAMS_VISIBLE_ROOM_MAX_COUNT", 0);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeJ = getIntent().getIntExtra("KEY_PARAMS_VISIBLE_USER_MAX_COUNT", 0);
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject3 = new bap();
      localObject4 = (com.tencent.mm.cd.a)localObject3;
      localObject5 = getIntent().getByteArrayExtra("KEY_PARAMS_LUCKY_MONEY_CONFIG");
      try
      {
        ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject5);
        p.k(localObject3, "<set-?>");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zfZ = ((bap)localObject3);
        localObject2 = getIntent().getByteArrayExtra("KEY_PARAMS_BG_MUSIC_ID_LIST");
        if (localObject2 != null)
        {
          localObject3 = new ayk();
          ((ayk)localObject3).parseFrom((byte[])localObject2);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ak(((ayk)localObject3).SKz);
        }
        localObject3 = getIntent().getByteArrayExtra("KEY_PARAMS_LIVE_TASK_INFO");
        if (localObject3 != null)
        {
          localObject2 = new bai();
          ((bai)localObject2).parseFrom((byte[])localObject3);
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          localObject2 = ((bai)localObject2).SEY;
          p.j(localObject2, "taskInfo.quest_activities");
          p.k(localObject2, "<set-?>");
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject3).zgr = ((LinkedList)localObject2);
        }
        localObject2 = getIntent().getByteArrayExtra("KEY_PARAMS_LAYER_SHOW_INFO");
        if (localObject2 != null)
        {
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          localObject4 = new bag();
          ((bag)localObject4).parseFrom((byte[])localObject2);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject3).zgw = ((bag)localObject4);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("setupLiveRoomData set layerShowInfo:");
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgw;
          if (localObject2 != null)
          {
            localObject2 = Integer.valueOf(((bag)localObject2).CKC);
            localObject4 = ((StringBuilder)localObject4).append(localObject2).append(',');
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgw;
            if (localObject2 == null) {
              break label1866;
            }
            localObject2 = Integer.valueOf(((bag)localObject2).SMj);
            Log.i((String)localObject3, localObject2);
          }
        }
        else
        {
          label1648:
          if ((bool2) || (i != 0))
          {
            p.k(localObject1, "<set-?>");
            paramBundle.xWR = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject1);
          }
          localObject2 = this.xZo;
          if (localObject2 != null) {
            com.tencent.mm.plugin.finder.live.view.a.bindData$default((com.tencent.mm.plugin.finder.live.view.a)localObject2, paramBundle, false, 2, null);
          }
          if (!bool2) {
            break label1872;
          }
          localObject1 = ah.yhC;
          localObject1 = this.xZo;
          if (localObject1 == null) {
            p.iCn();
          }
          ah.a((com.tencent.mm.plugin.finder.live.view.a)localObject1);
          localObject1 = this.xZo;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.a)localObject1).activate(paramBundle, bool1, false);
          }
          localObject1 = this.xZo;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.a)localObject1).mount();
          }
          paramBundle.xUD = new bbh();
          this.xOE = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new e(getContext()));
          localObject1 = this.xOE;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.view.f)localObject1).I(21, com.tencent.mm.plugin.ball.f.b.cwx());
          }
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
          com.tencent.mm.plugin.finder.live.report.k.a(paramBundle, localFinderLiveBundle);
          AppMethodBeat.o(273507);
          return;
          localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          continue;
          localObject2 = null;
          continue;
          label1866:
          localObject2 = null;
          continue;
          label1872:
          if (i != 0)
          {
            ah.a(ah.yhC, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, this.xZo, 0, 1, null, 20);
          }
          else
          {
            localObject2 = ah.yhC;
            localObject3 = this.xZo;
            if (localObject3 == null) {
              p.iCn();
            }
            ah.a((ah)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (com.tencent.mm.plugin.finder.live.view.a)localObject3, 0, 0, null, 24);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(273518);
    Log.i(this.TAG, "[LiveLifecycler]onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    com.tencent.mm.plugin.finder.live.view.f localf = this.xOE;
    if (localf != null) {
      localf.onDestroy();
    }
    if (!this.xZp) {
      dxl();
    }
    AppMethodBeat.o(273518);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(273505);
    super.onNewIntent(paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.xZo;
    if (locala != null)
    {
      locala.onNewIntent(paramIntent);
      AppMethodBeat.o(273505);
      return;
    }
    AppMethodBeat.o(273505);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(273514);
    Log.i(this.TAG, "[LiveLifecycler]onPause ".concat(String.valueOf(this)));
    super.onPause();
    Object localObject = this.jij;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).close();
    }
    localObject = this.xZo;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).pause();
    }
    this.isPaused = true;
    localObject = this.xZq;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.xZq = null;
    AppMethodBeat.o(273514);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(273512);
    Log.i(this.TAG, "[LiveLifecycler]onResume ".concat(String.valueOf(this)));
    super.onResume();
    com.tencent.mm.plugin.finder.live.view.a locala = this.xZo;
    if (locala != null) {
      locala.resume();
    }
    locala = this.xZo;
    if (locala != null) {
      locala.post((Runnable)new b(this));
    }
    Log.i(this.TAG, "[LiveLifecycler]initBusiness ".concat(String.valueOf(this)));
    AppMethodBeat.o(273512);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(273508);
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = this.TAG;
    Object localObject3 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    ah localah = ah.yhC;
    Log.i((String)localObject1, ah.dzj());
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      localObject1 = (c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(c.class);
      if (localObject1 != null)
      {
        localObject1 = new LiveConfig.a().sP(LiveConfig.khW).Fx(((c)localObject1).liveInfo.liveId).Nf(((c)localObject1).nonceId).Fy(((c)localObject1).xbk).Ni(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig).Nk(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).desc).aJw();
        p.j(localObject1, "builder.toWhere(LiveConf…\n                .build()");
        localObject3 = new FinderLiveBundle();
        ((FinderLiveBundle)localObject3).yeC.add(localObject1);
        if (paramBundle != null) {
          paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject3);
        }
        if (paramBundle != null)
        {
          localObject1 = ((FinderLiveBundle)localObject3).xPy;
          if (localObject1 == null) {
            break label268;
          }
        }
        label268:
        for (localObject1 = ((bbh)localObject1).toByteArray();; localObject1 = null)
        {
          paramBundle.putByteArray("KEY_PARAMS_NOTICE", (byte[])localObject1);
          if (paramBundle == null) {
            break;
          }
          localObject3 = ((FinderLiveBundle)localObject3).yeD;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((bai)localObject3).toByteArray();
          }
          paramBundle.putByteArray("KEY_PARAMS_LIVE_TASK_INFO", (byte[])localObject1);
          AppMethodBeat.o(273508);
          return;
        }
        AppMethodBeat.o(273508);
        return;
      }
    }
    AppMethodBeat.o(273508);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(273510);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStart ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.yVy;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.f.dFl());
    super.onStart();
    localObject = this.xZo;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).start();
    }
    dxk();
    AppMethodBeat.o(273510);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(273515);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStop ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.yVy;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.f.dFl());
    super.onStop();
    localObject = com.tencent.mm.plugin.finder.live.view.f.yVy;
    if (Util.isEqual(com.tencent.mm.plugin.finder.live.view.f.dFl(), toString()))
    {
      localObject = this.xZo;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.a)localObject).stop();
      }
      dxh();
    }
    AppMethodBeat.o(273515);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(258969);
      i.b(this.xZs);
      AppMethodBeat.o(258969);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(220823);
      if (i.a(this.xZs) == null)
      {
        localObject = this.xZs;
        Activity localActivity = this.xZs.getContext();
        if (localActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(220823);
          throw ((Throwable)localObject);
        }
        i.a((i)localObject, new com.tencent.mm.ui.tools.i(localActivity));
        localObject = i.a(this.xZs);
        if (localObject != null) {
          ((com.tencent.mm.ui.tools.i)localObject).setKeyboardHeightObserver((h)new h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(286479);
              Log.i(this.xZt.xZs.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              i locali = this.xZt.xZs;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                i.a(locali, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(286479);
                return;
              }
            }
          });
        }
      }
      Object localObject = i.a(this.xZs);
      if (localObject != null)
      {
        ((com.tencent.mm.ui.tools.i)localObject).start();
        AppMethodBeat.o(220823);
        return;
      }
      AppMethodBeat.o(220823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.i
 * JD-Core Version:    0.7.0.1
 */