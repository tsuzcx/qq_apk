package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.autogen.mmdata.rpt.cr;
import com.tencent.mm.autogen.mmdata.rpt.cs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.LiveEntranceFragment;
import com.tencent.mm.plugin.finder.nearby.report.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.n.n;

@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "liveEntranceFragment", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragment;", "checkRedDotEnterLive", "", "getLayoutId", "", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "showLiveEntranceFragment", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI15
  extends MMFinderUI
{
  public static final a BsL;
  private final LiveEntranceFragment BsM;
  
  static
  {
    AppMethodBeat.i(364509);
    BsL = new a((byte)0);
    AppMethodBeat.o(364509);
  }
  
  public OccupyFinderUI15()
  {
    AppMethodBeat.i(364490);
    this.BsM = new LiveEntranceFragment();
    AppMethodBeat.o(364490);
  }
  
  private static final void a(OccupyFinderUI15 paramOccupyFinderUI15, View paramView)
  {
    AppMethodBeat.i(364500);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOccupyFinderUI15);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramOccupyFinderUI15, "this$0");
    paramOccupyFinderUI15.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364500);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "LiveEntranceUI-OccupyFinderUI15";
  }
  
  public final int getLayoutId()
  {
    return f.e.EGJ;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364548);
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.plugin.finder.nearby.b.class, l.a(ai.cz(by.class)), f.class, as.class });
    AppMethodBeat.o(364548);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364569);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setNavigationBarColor(0);
      getWindow().addFlags(134217728);
    }
    ((as)component(as.class)).AJo = 135;
    ((f)component(f.class)).Dol = "135";
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    getController().setActionbarColor(getContext().getResources().getColor(f.a.Dark_0));
    setBackGroundColorResource(f.a.Dark_0);
    findViewById(f.d.EFG).setOnClickListener(new OccupyFinderUI15..ExternalSyntheticLambda0(this));
    paramBundle = (TextView)findViewById(f.d.EFS);
    float f = com.tencent.mm.cd.a.bs((Context)getContext(), a.e.ActionBarTextSize);
    paramBundle.setTextSize(0, com.tencent.mm.cd.a.jO((Context)getContext()) * f);
    Object localObject1 = this.BsM;
    paramBundle = getIntent();
    Object localObject3;
    label301:
    int j;
    label317:
    long l;
    label333:
    label350:
    label370:
    Object localObject2;
    label390:
    label410:
    Object localObject4;
    if (paramBundle == null)
    {
      paramBundle = null;
      ((LiveEntranceFragment)localObject1).setArguments(paramBundle);
      getSupportFragmentManager().beginTransaction().a(f.d.EFU, (Fragment)this.BsM).c((Fragment)this.BsM).FX();
      localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      Bundle localBundle = new Bundle();
      paramBundle = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).Su("FinderLiveEntrance");
      if ((paramBundle == null) || (paramBundle.avK("FinderLiveEntrance") == null) || (paramBundle.field_ctrInfo.type != 16)) {
        break label991;
      }
      ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).e(paramBundle);
      paramBundle = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (paramBundle != null) {
        break label862;
      }
      i = 0;
      paramBundle = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (paramBundle != null) {
        break label870;
      }
      j = 0;
      paramBundle = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (paramBundle != null) {
        break label879;
      }
      l = 0L;
      paramBundle = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (paramBundle != null) {
        break label888;
      }
      paramBundle = "";
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (localObject1 != null) {
        break label909;
      }
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (localObject2 != null) {
        break label932;
      }
      localObject2 = "";
      localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject3).avs("NearbyLiveTab");
      if (localObject3 != null) {
        break label955;
      }
      localObject3 = "";
      Log.i("LiveEntranceUI-OccupyFinderUI15", "checkRedDotEnterLive targetTabId:" + i + " enterLiveAction:" + j + " targetObjectId:" + l);
      localObject4 = Integer.valueOf(j);
      ((Number)localObject4).intValue();
      if (j != 1) {
        break label979;
      }
      j = 1;
      label479:
      if (j == 0) {
        break label985;
      }
      label484:
      if (localObject4 == null) {
        break label991;
      }
      ((Number)localObject4).intValue();
      if (l == 0L) {
        break label991;
      }
      localBundle.putLong("nearby_live_target_object_id_params_key", l);
      localBundle.putInt("nearby_live_target_tab_id_params_key", i);
      localBundle.putString("nearby_live_target_nonce_id_params_key", paramBundle);
      localBundle.putString("nearby_live_target_user_name_params_key", (String)localObject1);
      localBundle.putString("nearby_live_target_nick_name_params_key", (String)localObject2);
      localBundle.putString("nearby_live_target_cover_url_params_key", (String)localObject3);
      com.tencent.mm.plugin.finder.nearby.live.base.b.EJG.a(l, paramBundle, getCommentScene(), null);
      localObject4 = com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
      com.tencent.mm.plugin.finder.nearby.live.base.b.a((Activity)this, i, l, paramBundle, (String)localObject1, (String)localObject2, (String)localObject3);
    }
    label862:
    label991:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        paramBundle = k.aeZF;
        ((by)k.d((AppCompatActivity)this).cq(by.class)).fpm();
      }
      paramBundle = k.aeZF;
      ((com.tencent.mm.plugin.finder.nearby.b)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.nearby.b.class)).eEa();
      paramBundle = k.aeZF;
      localObject2 = (f)k.d((AppCompatActivity)this).q(f.class);
      localObject4 = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject4).n("is_new_square", Integer.valueOf(1));
      localObject3 = new cr();
      ((cr)localObject3).ixo = cn.bDw();
      ((cr)localObject3).mu("1001");
      localObject1 = ((d)h.ax(d.class)).dHN();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      ((cr)localObject3).mx(paramBundle);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      ((cr)localObject3).my(paramBundle);
      localObject1 = ((f)localObject2).Dol;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      ((cr)localObject3).mD(paramBundle);
      paramBundle = ((com.tencent.mm.ad.i)localObject4).toString();
      s.s(paramBundle, "pgUdfKv.toString()");
      ((cr)localObject3).mB(n.bV(paramBundle, ",", ";"));
      ((cr)localObject3).bMH();
      ((f)localObject2).akic = cn.bDw();
      AppMethodBeat.o(364569);
      return;
      paramBundle = paramBundle.getExtras();
      break;
      i = paramBundle.aabK;
      break label301;
      label870:
      j = paramBundle.aabL;
      break label317;
      label879:
      l = paramBundle.object_id;
      break label333;
      label888:
      localObject1 = paramBundle.object_nonce_id;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break label350;
      }
      paramBundle = "";
      break label350;
      localObject1 = ((btx)localObject1).YIZ;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label370;
      }
      break label370;
      localObject2 = ((btx)localObject2).aabM;
      if (localObject2 == null)
      {
        localObject2 = "";
        break label390;
      }
      break label390;
      localObject4 = ((btx)localObject3).aabN;
      localObject3 = localObject4;
      if (localObject4 != null) {
        break label410;
      }
      localObject3 = "";
      break label410;
      j = 0;
      break label479;
      localObject4 = null;
      break label484;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(370895);
    super.onDestroy();
    Object localObject = k.aeZF;
    f localf = (f)k.d((AppCompatActivity)this).q(f.class);
    cs localcs = new cs();
    localcs.ixo = cn.bDw();
    localcs.mE("1001");
    String str = ((d)h.ax(d.class)).dHN();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localcs.mH((String)localObject);
    str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localcs.mI((String)localObject);
    str = localf.Dol;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localcs.mM((String)localObject);
    if (localf.akic <= 0L) {
      localObject = "";
    }
    for (;;)
    {
      localcs.mL((String)localObject);
      localcs.bMH();
      AppMethodBeat.o(370895);
      return;
      long l1 = cn.bDw();
      long l2 = localf.akic;
      localObject = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject).t("staytime", l1 - l2);
      ((com.tencent.mm.ad.i)localObject).n("is_new_square", Integer.valueOf(1));
      localObject = ((com.tencent.mm.ad.i)localObject).toString();
      s.s(localObject, "pgUdfKv.toString()");
      str = n.m((String)localObject, ",", ";", false);
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(364538);
    super.onNewIntent(paramIntent);
    LiveEntranceFragment localLiveEntranceFragment = this.BsM;
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getExtras())
    {
      localLiveEntranceFragment.setArguments(paramIntent);
      AppMethodBeat.o(364538);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI15$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15
 * JD-Core Version:    0.7.0.1
 */