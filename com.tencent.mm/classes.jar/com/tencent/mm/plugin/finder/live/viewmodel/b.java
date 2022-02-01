package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "appInfo", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getAppInfo", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setAppInfo", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "appid", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "fromScan", "", "getFromScan", "()Z", "setFromScan", "(Z)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "ticket", "getTicket", "setTicket", "dealError", "", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "doAuth", "agree", "hide", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "showDefaultError", "case", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  private boolean DXp;
  private fby DXq;
  private final String TAG;
  private String appid;
  private String hFb;
  public View lBX;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356307);
    this.TAG = "Finder.FinderGameLiveAccountUIC";
    this.appid = "";
    this.hFb = "";
    AppMethodBeat.o(356307);
  }
  
  private static final Object a(boolean paramBoolean, b paramb, b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(356380);
    s.u(paramb, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject1 = (bhh)parama.ott;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (Util.isNullOrNil((String)localObject1)) {
          break label301;
        }
        if (!paramBoolean) {
          break label198;
        }
        parama = (bhh)parama.ott;
        if (parama != null) {
          break label173;
        }
        parama = "";
        label72:
        s.u(parama, "<set-?>");
        paramb.appid = parama;
        if (!paramb.DXp) {
          break label193;
        }
      }
      label173:
      label193:
      for (i = 1;; i = 0)
      {
        paramb = new com.tencent.mm.plugin.finder.live.cgi.p(paramb.appid, i).e((Context)paramb.getActivity(), paramb.getResources().getString(p.h.finder_waiting), 500L).bFJ().a((com.tencent.mm.vending.e.b)paramb.getActivity()).g(new b..ExternalSyntheticLambda2(paramb, i));
        AppMethodBeat.o(356380);
        return paramb;
        localObject1 = ((bhh)localObject1).app_id;
        break;
        localObject1 = parama.app_id;
        parama = (b.a)localObject1;
        if (localObject1 != null) {
          break label72;
        }
        parama = "";
        break label72;
      }
      label198:
      if (!paramb.DXp)
      {
        parama = paramb.DXq;
        if (parama != null) {
          break label266;
        }
        parama = "";
      }
      for (;;)
      {
        localObject2 = paramb.appid;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        n.d(parama, "", (String)localObject1, -1, "");
        paramb.getActivity().finish();
        paramb = ah.aiuX;
        AppMethodBeat.o(356380);
        return paramb;
        label266:
        parama = parama.abBz;
        if (parama == null)
        {
          parama = "";
        }
        else
        {
          localObject1 = parama.businessType;
          parama = (b.a)localObject1;
          if (localObject1 == null) {
            parama = "";
          }
        }
      }
    }
    label301:
    int i = parama.errCode;
    Object localObject1 = parama.errMsg;
    parama = (bhh)parama.ott;
    String str = paramb.TAG;
    StringBuilder localStringBuilder = new StringBuilder("dealError ").append(i).append(", appid:");
    if (parama == null)
    {
      parama = (b.a)localObject2;
      label353:
      Log.i(str, parama);
      parama = com.tencent.mm.ui.component.k.aeZF;
      parama = com.tencent.mm.ui.component.k.nq((Context)paramb.getContext()).q(a.class);
      s.s(parama, "UICProvider.of(context).…ameFinishUIC::class.java)");
      localObject2 = (a)parama;
    }
    switch (i)
    {
    default: 
      parama = paramb.getResources().getString(p.h.Cup);
      s.s(parama, "resources.getString(R.st…elive_authfailpage_title)");
      localObject1 = paramb.getResources().getString(p.h.Cuo);
      s.s(localObject1, "resources.getString(R.st…ve_authfailpage_subtitle)");
      ((a)localObject2).e(false, parama, (String)localObject1);
    case -200035: 
    case -200091: 
    case -200093: 
    case -200095: 
    case -200096: 
      for (;;)
      {
        paramb.hide();
        ((a)localObject2).show();
        if (i != -200093) {
          break;
        }
        parama = ((a)localObject2).getDescTv();
        localObject1 = t.GgN;
        parama.setText((CharSequence)t.d((Context)paramb.getContext(), p.h.Cuu, false));
        break;
        parama = parama.app_id;
        break label353;
        parama = paramb.getResources().getString(p.h.Cuj);
        s.s(parama, "resources.getString(R.st…authfailexpirepage_title)");
        localObject1 = paramb.getResources().getString(p.h.Cuo);
        s.s(localObject1, "resources.getString(R.st…ve_authfailpage_subtitle)");
        ((a)localObject2).e(false, parama, (String)localObject1);
        continue;
        parama = paramb.getResources().getString(p.h.Cui);
        s.s(parama, "resources.getString(R.st…hfailalreadyinlive_title)");
        localObject1 = paramb.getResources().getString(p.h.Cuo);
        s.s(localObject1, "resources.getString(R.st…ve_authfailpage_subtitle)");
        ((a)localObject2).e(false, parama, (String)localObject1);
        continue;
        parama = paramb.getResources().getString(p.h.Cuh);
        s.s(parama, "resources.getString(R.st…ortitlelabel_generalinfo)");
        localObject1 = t.GgN;
        localObject1 = t.d((Context)paramb.getContext(), p.h.Cuu, false).toString();
        s.s(localObject1, "FinderGameLiveUtil.getLi…iGame = false).toString()");
        ((a)localObject2).e(false, parama, (String)localObject1);
        continue;
        parama = paramb.getResources().getString(p.h.Cul);
        s.s(parama, "resources.getString(R.st…_authfailpage_retrytitle)");
        localObject1 = paramb.getResources().getString(p.h.Cuk);
        s.s(localObject1, "resources.getString(R.st…thfailpage_retrysubtitle)");
        ((a)localObject2).e(false, parama, (String)localObject1);
        continue;
        parama = paramb.getResources().getString(p.h.Cun);
        s.s(parama, "resources.getString(R.st…thfailpage_scanfailtitle)");
        localObject1 = paramb.getResources().getString(p.h.Cum);
        s.s(localObject1, "resources.getString(R.st…ailpage_scanfailsubtitle)");
        ((a)localObject2).e(false, parama, (String)localObject1);
      }
    }
    str = paramb.getResources().getString(p.h.Cup);
    s.s(str, "resources.getString(R.st…elive_authfailpage_title)");
    if (localObject1 == null)
    {
      parama = paramb.getResources().getString(p.h.Cuo);
      s.s(parama, "resources.getString(R.st…ve_authfailpage_subtitle)");
    }
    for (;;)
    {
      ((a)localObject2).e(false, str, parama);
      break;
      parama = (b.a)localObject1;
    }
  }
  
  private static final ah a(b paramb, int paramInt, b.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(356355);
    s.u(paramb, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (bil)parama.ott;
      if (parama == null)
      {
        parama = null;
        if (parama != null) {
          break label183;
        }
        label46:
        if (localObject1 != null) {
          break label191;
        }
        Log.w(paramb.TAG, "detail null");
        aa.makeText((Context)paramb.getContext(), p.h.finder_live_game_prepare_error, 0).show();
      }
    }
    for (;;)
    {
      paramb = ah.aiuX;
      AppMethodBeat.o(356355);
      return paramb;
      parama = parama.ZRA;
      if (parama == null)
      {
        parama = null;
        break;
      }
      Object localObject3 = ((Iterable)parama).iterator();
      label114:
      Object localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        parama = ((ccb)localObject2).aals;
        if (parama == null)
        {
          parama = null;
          label148:
          if (!s.p(parama, paramb.appid)) {
            break label176;
          }
        }
      }
      for (parama = (b.a)localObject2;; parama = null)
      {
        parama = (ccb)parama;
        break;
        parama = parama.app_id;
        break label148;
        label176:
        break label114;
      }
      label183:
      localObject1 = parama.aalt;
      break label46;
      label191:
      localObject1 = parama.aalt;
      if (localObject1 == null)
      {
        localObject1 = "";
        label203:
        localObject2 = parama.aalt;
        if (localObject2 != null) {
          break label350;
        }
        localObject2 = "";
      }
      for (;;)
      {
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("COVER_URL", (String)localObject1);
        ((Intent)localObject3).putExtra("DESC", (String)localObject2);
        ((Intent)localObject3).putExtra("TICKET", paramb.hFb);
        ((Intent)localObject3).putExtra("APPID", paramb.appid);
        ((Intent)localObject3).putExtra("POST_FROM_SCENE", paramInt);
        ((Intent)localObject3).putExtra("GameUserInfo", parama.toByteArray());
        ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).o((Context)paramb.getContext(), (Intent)localObject3);
        paramb.getActivity().finish();
        break;
        localObject2 = ((cbq)localObject1).aabN;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label203;
        }
        localObject1 = "";
        break label203;
        label350:
        localObject3 = ((cbq)localObject2).description;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
      }
      Log.w(paramb.TAG, "CgiFinderLiveGetUserGameConfig failed.");
      aa.makeText((Context)paramb.getContext(), p.h.finder_live_game_prepare_error, 0).show();
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(356328);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.se(true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356328);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(356337);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.se(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356337);
  }
  
  private View getRoot()
  {
    AppMethodBeat.i(356311);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(356311);
      return localView;
    }
    s.bIx("root");
    AppMethodBeat.o(356311);
    return null;
  }
  
  private final void se(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(356319);
    String str1 = this.appid;
    if (this.DXp) {}
    for (int i = 2;; i = 1)
    {
      String str2 = this.hFb;
      if (paramBoolean) {
        j = 0;
      }
      new com.tencent.mm.plugin.finder.live.cgi.k(str1, i, str2, j).e((Context)getActivity(), getResources().getString(p.h.finder_waiting), 500L).bFJ().a((com.tencent.mm.vending.e.b)getActivity()).g(new b..ExternalSyntheticLambda3(paramBoolean, this));
      AppMethodBeat.o(356319);
      return;
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(356470);
    getRoot().setVisibility(8);
    AppMethodBeat.o(356470);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356421);
    super.onCreate(paramBundle);
    paramBundle = findViewById(p.e.BUW);
    s.s(paramBundle, "findViewById(R.id.game_live_account_area)");
    s.u(paramBundle, "<set-?>");
    this.lBX = paramBundle;
    paramBundle = (com.tencent.mm.bx.a)new fby();
    Object localObject = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.DXq = ((fby)paramBundle);
      localObject = getIntent().getStringExtra("KEY_APPID");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.appid = paramBundle;
      localObject = getIntent().getStringExtra("KEY_TICKET");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.hFb = paramBundle;
      this.DXp = getIntent().getBooleanExtra("KEY_FROM_SCAN", false);
      AppMethodBeat.o(356421);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(356463);
    getRoot().setVisibility(0);
    Object localObject3 = (ImageView)findViewById(p.e.BBl);
    TextView localTextView2 = (TextView)findViewById(p.e.BBn);
    ImageView localImageView = (ImageView)findViewById(p.e.auth_icon_iv);
    TextView localTextView1 = (TextView)findViewById(p.e.BBm);
    View localView1 = findViewById(p.e.BBo);
    View localView2 = findViewById(p.e.BBp);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    m localm = d.a.auT(z.bAW());
    localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    com.tencent.mm.loader.d locald = com.tencent.mm.plugin.finder.loader.p.eCp();
    Object localObject2;
    label161:
    int i;
    if (localm == null)
    {
      localObject1 = "";
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      s.s(localObject3, "avatarIv");
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      locald.a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject3 = (Context)getContext();
      if (localm != null) {
        break label352;
      }
      localObject1 = "";
      localTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)localObject1));
      if (localm != null) {
        break label370;
      }
      i = 0;
      label185:
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject2 = (com.tencent.mm.plugin.h)localObject1;
      s.s(localImageView, "iconIv");
      if (localm != null) {
        break label393;
      }
      localObject1 = null;
      label219:
      h.a.a((com.tencent.mm.plugin.h)localObject2, localImageView, (FinderAuthInfo)localObject1, 0, null, 12);
      switch (i)
      {
      default: 
        localImageView.setVisibility(8);
        localTextView1.setText((CharSequence)"");
        label269:
        localObject1 = localTextView1.getText();
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          label290:
          if (i == 0) {
            break label497;
          }
          localTextView1.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      localView1.setOnClickListener(new b..ExternalSyntheticLambda0(this));
      localView2.setOnClickListener(new b..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(356463);
      return;
      localObject2 = localm.amx();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label352:
      localObject2 = localm.getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label161;
      }
      localObject1 = "";
      break label161;
      label370:
      localObject1 = localm.field_authInfo;
      if (localObject1 == null)
      {
        i = 0;
        break label185;
      }
      i = ((FinderAuthInfo)localObject1).authIconType;
      break label185;
      label393:
      localObject1 = localm.field_authInfo;
      break label219;
      localImageView.setVisibility(0);
      if (localm == null) {
        localObject1 = (CharSequence)"";
      }
      for (;;)
      {
        localTextView1.setText((CharSequence)localObject1);
        break;
        localObject1 = localm.field_authInfo;
        if (localObject1 == null)
        {
          localObject1 = (CharSequence)"";
        }
        else
        {
          localObject1 = ((FinderAuthInfo)localObject1).authProfession;
          if (localObject1 == null) {
            localObject1 = (CharSequence)"";
          } else {
            localObject1 = (CharSequence)localObject1;
          }
        }
      }
      localImageView.setVisibility(0);
      localTextView1.setText((CharSequence)"");
      break label269;
      i = 0;
      break label290;
      label497:
      localTextView1.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */