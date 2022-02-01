package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.viewmodel.l;
import com.tencent.mm.plugin.finder.live.viewmodel.l.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.f.i.a;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@com.tencent.mm.ui.base.a(39)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLivePostVerifyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "developerCustomParam", "getDeveloperCustomParam", "developerCustomParam$delegate", "ignoreContinueLive", "", "getIgnoreContinueLive", "()Z", "ignoreContinueLive$delegate", "landscapeType", "", "Ljava/lang/Integer;", "reportInfo", "getReportInfo", "reportInfo$delegate", "versionType", "getVersionType", "()I", "versionType$delegate", "getForceOrientation", "getOrientation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onVerified", "result", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "needContinueLive", "setWindowStyle", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGameLivePostVerifyUI
  extends MMFinderUI
  implements l.b
{
  public static final FinderGameLivePostVerifyUI.a BnW;
  private final j BnX;
  private final j BnY;
  private final j BnZ;
  private final j Boa;
  private Integer Bob;
  private final j vTI;
  
  static
  {
    AppMethodBeat.i(365618);
    BnW = new FinderGameLivePostVerifyUI.a((byte)0);
    AppMethodBeat.o(365618);
  }
  
  public FinderGameLivePostVerifyUI()
  {
    AppMethodBeat.i(365603);
    this.vTI = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.BnX = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.BnY = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.BnZ = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Boa = kotlin.k.cm((kotlin.g.a.a)new e(this));
    Object localObject = getIntent();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.i.a.adwn.ordinal())))
    {
      this.Bob = ((Integer)localObject);
      AppMethodBeat.o(365603);
      return;
    }
  }
  
  private final int getOrientation()
  {
    AppMethodBeat.i(365610);
    Object localObject = getIntent();
    int i;
    if (localObject == null)
    {
      localObject = null;
      this.Bob = ((Integer)localObject);
      localObject = this.Bob;
      i = f.i.a.adwo.ordinal();
      if (localObject != null) {
        break label74;
      }
      label37:
      i = f.i.a.adwp.ordinal();
      if (localObject != null) {
        break label89;
      }
    }
    label74:
    label89:
    while (((Integer)localObject).intValue() != i)
    {
      AppMethodBeat.o(365610);
      return -1;
      localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.i.a.adwn.ordinal()));
      break;
      if (((Integer)localObject).intValue() != i) {
        break label37;
      }
      AppMethodBeat.o(365610);
      return 0;
    }
    AppMethodBeat.o(365610);
    return 8;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(boolean paramBoolean1, awa paramawa, boolean paramBoolean2)
  {
    AppMethodBeat.i(365669);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      if ((!paramBoolean2) || (((Boolean)this.BnY.getValue()).booleanValue())) {
        break label239;
      }
      if (paramawa != null)
      {
        f localf = (f)h.ax(f.class);
        localObject1 = paramawa.ZGo;
        s.checkNotNull(localObject1);
        long l = ((FinderObject)localObject1).id;
        localObject1 = paramawa.ZGo;
        if (localObject1 != null) {
          break label206;
        }
        localObject1 = "";
        localObject2 = paramawa.ZGo;
        s.checkNotNull(localObject2);
        bip localbip = ((FinderObject)localObject2).liveInfo;
        s.checkNotNull(localbip);
        bkk localbkk = paramawa.live_notice_info;
        localObject2 = paramawa.ZGo;
        if (localObject2 != null) {
          break label229;
        }
        localObject2 = null;
        label121:
        LinkedList localLinkedList = paramawa.ZGp;
        bno localbno = paramawa.ZGq;
        paramawa = paramawa.ZGr;
        Intent localIntent = new Intent();
        s.s(localf, "service(IActivityRouter::class.java)");
        Context localContext = (Context)this;
        s.s(localbip, "!!");
        f.a.a(localf, localContext, l, (String)localObject1, localbip, localbkk, null, localLinkedList, localbno, null, (String)localObject2, paramawa, localIntent, 592);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(365669);
      return;
      label206:
      localObject2 = ((FinderObject)localObject1).objectNonceId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label229:
      localObject2 = ((FinderObject)localObject2).sessionBuffer;
      break label121;
      label239:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("TICKET", "");
      localObject1 = (String)this.vTI.getValue();
      paramawa = (awa)localObject1;
      if (localObject1 == null) {
        paramawa = "";
      }
      ((Intent)localObject2).putExtra("APPID", paramawa);
      ((Intent)localObject2).putExtra("VERSION_TYPE", ((Number)this.BnX.getValue()).intValue());
      ((Intent)localObject2).putExtra("POST_FROM_SCENE", 0);
      ((Intent)localObject2).putExtra("IS_FROM_WEAPP", true);
      ((Intent)localObject2).putExtra("MINI_GAME_SCENE", 4);
      paramawa = (String)this.BnZ.getValue();
      if (paramawa != null) {
        ((Intent)localObject2).putExtra("WXA_DEVELOPER_CUSTOM_PARAM", paramawa);
      }
      paramawa = (String)this.Boa.getValue();
      if (paramawa != null) {
        ((Intent)localObject2).putExtra("REPORT_INFO", paramawa);
      }
      paramawa = (f)h.ax(f.class);
      localObject1 = getContext();
      s.s(localObject1, "context");
      paramawa.o((Context)localObject1, (Intent)localObject2);
    }
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(365652);
    int i = getOrientation();
    AppMethodBeat.o(365652);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365656);
    Set localSet = ar.setOf(l.class);
    AppMethodBeat.o(365656);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365634);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    if (((b)h.az(b.class)).isVisitorLiving())
    {
      Log.i("Finder.FinderGameLivePostVerifyUI", "onCreate: isVisitorLiving = true, finish!");
      aa.makeText((Context)getContext(), (CharSequence)getContext().getResources().getString(p.h.finder_can_not_enter_mv_because_living), 0).show();
      finish();
      AppMethodBeat.o(365634);
      return;
    }
    setRequestedOrientation(getOrientation());
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((l)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(l.class)).DZy = ((l.b)this);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((l)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(l.class)).scene = 14;
    AppMethodBeat.o(365634);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(365643);
    super.onCreateBeforeSetContentView();
    this.FVH = true;
    setTheme(p.i.MMTheme_FinderNoTitleTranslucent);
    AppMethodBeat.o(365643);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    b(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    d(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<String>
  {
    e(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostVerifyUI
 * JD-Core Version:    0.7.0.1
 */