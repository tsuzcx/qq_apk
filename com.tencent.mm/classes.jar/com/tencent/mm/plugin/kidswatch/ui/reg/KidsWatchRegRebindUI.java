package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.d;
import com.tencent.mm.plugin.kidswatch.model.d;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "finish", "", "getForceOrientation", "", "getLayoutId", "goBackRegUI", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startExtReg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegRebindUI
  extends MMActivity
  implements i
{
  public static final KidsWatchRegRebindUI.a EcX;
  private String EcQ;
  private String EcR;
  private HashMap _$_findViewCache;
  private String fLC;
  private String fTQ;
  private s mUN;
  private String nfm;
  private boolean nhv;
  private String nickName;
  private String openid;
  
  static
  {
    AppMethodBeat.i(252012);
    EcX = new KidsWatchRegRebindUI.a((byte)0);
    AppMethodBeat.o(252012);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252017);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252017);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252016);
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
    AppMethodBeat.o(252016);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252004);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(252004);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebp;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252007);
    setMMTitle("");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    String str1 = getString(b.h.Eby);
    p.j(str1, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle(str1);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    p.j(localObject1, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
    this.EcQ = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    p.j(localObject1, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
    this.EcR = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.mobile");
    p.j(localObject1, "intent.getStringExtra(Co…ch.INTENT_KEY_REG_MOBILE)");
    this.fLC = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.nickname");
    p.j(localObject1, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickName = ((String)localObject1);
    this.nfm = getIntent().getStringExtra("intent.key.reg.session.id");
    this.nhv = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    str1 = getIntent().getStringExtra("intent.key.reg.last.nickname");
    String str2 = getIntent().getStringExtra("intent.key.reg.last.head.img.url");
    Object localObject2 = (TextView)_$_findCachedViewById(b.e.EaM);
    p.j(localObject2, "lastNicknameTV");
    if (Util.isNullOrNil(str1)) {}
    for (localObject1 = (CharSequence)"";; localObject1 = (CharSequence)str1)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (!Util.isNullOrNil(str2))
      {
        int i = aw.fromDPToPix((Context)getContext(), 16);
        localObject1 = new c.a();
        ((c.a)localObject1).wy(b.d.default_avatar);
        ((c.a)localObject1).aw(i).bmJ();
        com.tencent.mm.ay.q.bml().a(str2, (RoundCornerImageView)_$_findCachedViewById(b.e.EaL), ((c.a)localObject1).bmL());
      }
      localObject1 = new StringBuilder("fileID:");
      localObject2 = this.EcQ;
      if (localObject2 == null) {
        p.bGy("headImgFileID");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", aeskey:");
      localObject2 = this.EcR;
      if (localObject2 == null) {
        p.bGy("headImgAesKey");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", loginUrl:");
      localObject2 = this.fTQ;
      if (localObject2 == null) {
        p.bGy("loginUrl");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", nickName:");
      localObject2 = this.nickName;
      if (localObject2 == null) {
        p.bGy("nickName");
      }
      Log.i("MicroMsg.KidsWatchRegRebindUI", (String)localObject2 + ", regSessionId:" + this.nfm + ", hasSetAvatar:" + this.nhv + ", lastNickName:" + str1 + ", lastImgUrl:" + str2);
      ((Button)_$_findCachedViewById(b.e.EaZ)).setOnClickListener((View.OnClickListener)new c(this));
      ((Button)_$_findCachedViewById(b.e.Eay)).setOnClickListener((View.OnClickListener)new d(this));
      localObject1 = com.tencent.mm.plugin.kidswatch.b.a.Edb;
      localObject1 = getContext();
      p.j(localObject1, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(b.e.Eax), (LinearLayout)_$_findCachedViewById(b.e.Eav));
      AppMethodBeat.o(252007);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252003);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.Eap));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(b.b.Eap));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(252003);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(252010);
    if ((paramq instanceof d))
    {
      Log.i("MicroMsg.KidsWatchRegRebindUI", "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      Object localObject = this.mUN;
      if (localObject != null) {
        ((s)localObject).dismiss();
      }
      com.tencent.mm.kernel.h.aGY().b(5888, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ((d)paramq).getUsername();
        this.openid = ((d)paramq).getOpenId();
        paramString = c.EbU;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        c.a(paramString, c.d.Ech, 0);
        paramString = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramq = this.nickName;
        if (paramq == null) {
          p.bGy("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegRebindUI", paramq + ", openId:" + this.openid);
        paramString = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramq = this.fTQ;
        if (paramq == null) {
          p.bGy("loginUrl");
        }
        paramString.putExtra("intent.key.login.url", paramq);
        paramq = this.nickName;
        if (paramq == null) {
          p.bGy("nickName");
        }
        paramString.putExtra("intent.key.reg.nickname", paramq);
        paramString.putExtra("intent.key.reg.openid", this.openid);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(252010);
        return;
      }
      paramq = c.EbU;
      c.a("", c.d.Eci, paramInt2);
      paramq = new ad(paramInt1, paramInt2, paramString);
      if (new com.tencent.mm.platformtools.b().a((Activity)this, paramq))
      {
        AppMethodBeat.o(252010);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(252010);
        return;
      }
      paramString = getString(b.h.EbE, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      p.j(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
      com.tencent.mm.ui.base.h.af((Context)getContext(), paramString, "");
    }
    AppMethodBeat.o(252010);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(KidsWatchRegRebindUI paramKidsWatchRegRebindUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchRegRebindUI paramKidsWatchRegRebindUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251572);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      KidsWatchRegRebindUI.a(this.EcY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251572);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchRegRebindUI paramKidsWatchRegRebindUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251844);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      KidsWatchRegRebindUI.b(this.EcY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251844);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(KidsWatchRegRebindUI paramKidsWatchRegRebindUI, d paramd) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(251399);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.EcW);
      com.tencent.mm.kernel.h.aGY().b(5888, (i)this.EcY);
      AppMethodBeat.o(251399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegRebindUI
 * JD-Core Version:    0.7.0.1
 */