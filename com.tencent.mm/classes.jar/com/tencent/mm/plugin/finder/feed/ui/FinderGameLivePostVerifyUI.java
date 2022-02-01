package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.live.viewmodel.j;
import com.tencent.mm.plugin.finder.live.viewmodel.j.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.f.h.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@com.tencent.mm.ui.base.a(39)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLivePostVerifyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "ignoreContinueLive", "", "getIgnoreContinueLive", "()Z", "ignoreContinueLive$delegate", "landscapeType", "", "Ljava/lang/Integer;", "versionType", "getVersionType", "()I", "versionType$delegate", "getForceOrientation", "getOrientation", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onVerified", "result", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "needContinueLive", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class FinderGameLivePostVerifyUI
  extends MMFinderUI
  implements j.b
{
  public static final a xNZ;
  private HashMap _$_findViewCache;
  private final f sOf;
  private final f xNW;
  private final f xNX;
  private Integer xNY;
  
  static
  {
    AppMethodBeat.i(271840);
    xNZ = new a((byte)0);
    AppMethodBeat.o(271840);
  }
  
  public FinderGameLivePostVerifyUI()
  {
    AppMethodBeat.i(271838);
    this.sOf = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.xNW = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.xNX = kotlin.g.ar((kotlin.g.a.a)new c(this));
    Object localObject = getIntent();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.h.a.VSf.ordinal()));; localObject = null)
    {
      this.xNY = ((Integer)localObject);
      AppMethodBeat.o(271838);
      return;
    }
  }
  
  private final int getOrientation()
  {
    AppMethodBeat.i(271835);
    Object localObject = getIntent();
    int i;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((Intent)localObject).getIntExtra("LANDSCAPE_TYPE", f.h.a.VSf.ordinal()));
      this.xNY = ((Integer)localObject);
      localObject = this.xNY;
      i = f.h.a.VSg.ordinal();
      if (localObject != null) {
        break label74;
      }
      label51:
      i = f.h.a.VSh.ordinal();
      if (localObject != null) {
        break label89;
      }
    }
    label74:
    label89:
    while (((Integer)localObject).intValue() != i)
    {
      AppMethodBeat.o(271835);
      return -1;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != i) {
        break label51;
      }
      AppMethodBeat.o(271835);
      return 0;
    }
    AppMethodBeat.o(271835);
    return 8;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(271842);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(271842);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(271841);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(271841);
    return localView1;
  }
  
  public final void a(boolean paramBoolean1, arr paramarr, boolean paramBoolean2)
  {
    AppMethodBeat.i(271837);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      if ((!paramBoolean2) || (((Boolean)this.xNX.getValue()).booleanValue())) {
        break label213;
      }
      if (paramarr != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        Context localContext = (Context)this;
        localObject1 = paramarr.SEM;
        if (localObject1 == null) {
          p.iCn();
        }
        long l = ((FinderObject)localObject1).id;
        localObject1 = paramarr.SEM;
        if (localObject1 != null)
        {
          localObject2 = ((FinderObject)localObject1).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localObject2 = paramarr.SEM;
        if (localObject2 == null) {
          p.iCn();
        }
        bac localbac = ((FinderObject)localObject2).liveInfo;
        if (localbac == null) {
          p.iCn();
        }
        p.j(localbac, "it.recover_live_object!!.liveInfo!!");
        bbh localbbh = paramarr.live_notice_info;
        localObject2 = paramarr.SEM;
        if (localObject2 == null) {
          break label207;
        }
        localObject2 = ((FinderObject)localObject2).sessionBuffer;
        com.tencent.mm.plugin.finder.utils.a.a(localContext, l, (String)localObject1, localbac, localbbh, null, paramarr.SEN, paramarr.SEO, null, (String)localObject2, paramarr.SEP, new Intent(), 592);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(271837);
      return;
      label207:
      localObject2 = null;
      break;
      label213:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("TICKET", "");
      localObject1 = (String)this.sOf.getValue();
      paramarr = (arr)localObject1;
      if (localObject1 == null) {
        paramarr = "";
      }
      ((Intent)localObject2).putExtra("APPID", paramarr);
      ((Intent)localObject2).putExtra("VERSION_TYPE", ((Number)this.xNW.getValue()).intValue());
      ((Intent)localObject2).putExtra("POST_FROM_SCENE", 0);
      ((Intent)localObject2).putExtra("IS_FROM_WEAPP", true);
      paramarr = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramarr = getContext();
      p.j(paramarr, "context");
      com.tencent.mm.plugin.finder.utils.a.af((Context)paramarr, (Intent)localObject2);
    }
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(271834);
    int i = getOrientation();
    AppMethodBeat.o(271834);
    return i;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(271836);
    Set localSet = ak.setOf(j.class);
    AppMethodBeat.o(271836);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271832);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setRequestedOrientation(getOrientation());
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((j)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(j.class)).zda = ((j.b)this);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((j)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(j.class)).scene = 14;
    AppMethodBeat.o(271832);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(271833);
    super.onCreateBeforeSetContentView();
    this.AwU = true;
    setTheme(b.k.MMTheme_FinderNoTitleTranslucent);
    AppMethodBeat.o(271833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLivePostVerifyUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<String>
  {
    b(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderGameLivePostVerifyUI paramFinderGameLivePostVerifyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostVerifyUI
 * JD-Core Version:    0.7.0.1
 */