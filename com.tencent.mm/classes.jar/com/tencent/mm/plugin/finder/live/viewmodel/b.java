package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "appInfo", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getAppInfo", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setAppInfo", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "appid", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "fromScan", "", "getFromScan", "()Z", "setFromScan", "(Z)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "ticket", "getTicket", "setTicket", "dealError", "", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "doAuth", "agree", "hide", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "showDefaultError", "case", "plugin-finder_release"})
public final class b
  extends UIComponent
{
  private final String TAG;
  String appid;
  String fAo;
  public View jac;
  boolean zbg;
  ehy zbh;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(280026);
    this.TAG = "Finder.FinderGameLiveAccountUIC";
    this.appid = "";
    this.fAo = "";
    AppMethodBeat.o(280026);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(280025);
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(280025);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280023);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.game_live_account_area);
    p.j(paramBundle, "findViewById(R.id.game_live_account_area)");
    this.jac = paramBundle;
    paramBundle = (com.tencent.mm.cd.a)new ehy();
    Object localObject = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.zbh = ((ehy)paramBundle);
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
      this.fAo = paramBundle;
      this.zbg = getIntent().getBooleanExtra("KEY_FROM_SCAN", false);
      AppMethodBeat.o(280023);
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
    AppMethodBeat.i(280024);
    Object localObject1 = this.jac;
    if (localObject1 == null) {
      p.bGy("root");
    }
    ((View)localObject1).setVisibility(0);
    ImageView localImageView2 = (ImageView)findViewById(b.f.account_avatar_iv);
    TextView localTextView2 = (TextView)findViewById(b.f.account_nickname_tv);
    ImageView localImageView1 = (ImageView)findViewById(b.f.auth_icon_iv);
    TextView localTextView1 = (TextView)findViewById(b.f.account_desc_tv);
    View localView1 = findViewById(b.f.account_ok_btn);
    View localView2 = findViewById(b.f.account_reject_btn);
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    i locali = d.a.aAK(z.bdh());
    localObject1 = t.ztT;
    com.tencent.mm.loader.d locald = t.dJh();
    if (locali != null)
    {
      localObject2 = locali.Mm();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = new e((String)localObject1);
    p.j(localImageView2, "avatarIv");
    Object localObject2 = t.ztT;
    locald.a(localObject1, localImageView2, t.a(t.a.ztX));
    p.j(localTextView2, "nickTv");
    localObject2 = (Context)getContext();
    int i;
    if (locali != null)
    {
      localObject1 = locali.getNickname();
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        localTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1));
        if (locali == null) {
          break label393;
        }
        localObject1 = locali.field_authInfo;
        if (localObject1 == null) {
          break label393;
        }
        i = ((FinderAuthInfo)localObject1).authIconType;
        label237:
        localObject1 = aj.AGc;
        p.j(localImageView1, "iconIv");
        if (locali == null) {
          break label398;
        }
        localObject1 = locali.field_authInfo;
        label260:
        aj.a(localImageView1, (FinderAuthInfo)localObject1);
        switch (i)
        {
        default: 
          localImageView1.setVisibility(8);
          p.j(localTextView1, "descTv");
          localTextView1.setText((CharSequence)"");
          label313:
          localObject1 = localTextView1.getText();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
          {
            i = 1;
            label334:
            if (i == 0) {
              break label496;
            }
            localTextView1.setVisibility(8);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localView1.setOnClickListener((View.OnClickListener)new b(this));
      localView2.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(280024);
      return;
      localObject1 = (CharSequence)"";
      break;
      label393:
      i = 0;
      break label237;
      label398:
      localObject1 = null;
      break label260;
      localImageView1.setVisibility(0);
      p.j(localTextView1, "descTv");
      if (locali != null)
      {
        localObject1 = locali.field_authInfo;
        if (localObject1 != null)
        {
          localObject1 = ((FinderAuthInfo)localObject1).authProfession;
          if (localObject1 == null) {}
        }
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        localTextView1.setText((CharSequence)localObject1);
        break;
      }
      localImageView1.setVisibility(0);
      p.j(localTextView1, "descTv");
      localTextView1.setText((CharSequence)"");
      break label313;
      i = 0;
      break label334;
      label496:
      localTextView1.setVisibility(0);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(b paramb, boolean paramBoolean) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289015);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.zbi, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289015);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(262252);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC$show$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.zbi, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveAccountUIC$show$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */