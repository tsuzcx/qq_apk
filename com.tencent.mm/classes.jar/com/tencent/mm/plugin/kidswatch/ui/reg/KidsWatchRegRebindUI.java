package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.d;
import com.tencent.mm.plugin.kidswatch.model.d;
import com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "hasSetAvatar", "", "headImgAesKey", "", "headImgFileID", "loginUrl", "mobile", "nickName", "openid", "proDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "regSessionId", "finish", "", "getForceOrientation", "", "getLayoutId", "goBackRegUI", "gotoRegSuccessUI", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startExtReg", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchRegRebindUI
  extends MMActivity
  implements i
{
  public static final KidsWatchRegRebindUI.a yBH;
  private HashMap _$_findViewCache;
  private String dSf;
  private String dZW;
  private com.tencent.mm.ui.base.q kdn;
  private String knu;
  private boolean kpI;
  private String nickName;
  private String openid;
  private String yBA;
  private String yBB;
  
  static
  {
    AppMethodBeat.i(256368);
    yBH = new KidsWatchRegRebindUI.a((byte)0);
    AppMethodBeat.o(256368);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256372);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256372);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256371);
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
    AppMethodBeat.o(256371);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256365);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256365);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495139;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256366);
    setMMTitle("");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    String str1 = getString(2131762070);
    p.g(str1, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle(str1);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new KidsWatchRegRebindUI.b(this));
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.file.id");
    p.g(localObject1, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_FILE_ID)");
    this.yBA = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.head_img.aes.key");
    p.g(localObject1, "intent.getStringExtra(Co…KEY_REG_HEAD_IMG_AES_KEY)");
    this.yBB = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.mobile");
    p.g(localObject1, "intent.getStringExtra(Co…ch.INTENT_KEY_REG_MOBILE)");
    this.dSf = ((String)localObject1);
    localObject1 = getIntent().getStringExtra("intent.key.reg.nickname");
    p.g(localObject1, "intent.getStringExtra(Co….INTENT_KEY_REG_NICKNAME)");
    this.nickName = ((String)localObject1);
    this.knu = getIntent().getStringExtra("intent.key.reg.session.id");
    this.kpI = getIntent().getBooleanExtra("intent.key.hasSetAvatar", false);
    str1 = getIntent().getStringExtra("intent.key.reg.last.nickname");
    String str2 = getIntent().getStringExtra("intent.key.reg.last.head.img.url");
    Object localObject2 = (TextView)_$_findCachedViewById(2131303009);
    p.g(localObject2, "lastNicknameTV");
    if (Util.isNullOrNil(str1)) {}
    for (localObject1 = (CharSequence)"";; localObject1 = (CharSequence)str1)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (!Util.isNullOrNil(str2))
      {
        int i = at.fromDPToPix((Context)getContext(), 16);
        localObject1 = new c.a();
        ((c.a)localObject1).ty(2131231957);
        ((c.a)localObject1).aw(i).bdt();
        com.tencent.mm.av.q.bcV().a(str2, (RoundCornerImageView)_$_findCachedViewById(2131303008), ((c.a)localObject1).bdv());
      }
      localObject1 = new StringBuilder("fileID:");
      localObject2 = this.yBA;
      if (localObject2 == null) {
        p.btv("headImgFileID");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", aeskey:");
      localObject2 = this.yBB;
      if (localObject2 == null) {
        p.btv("headImgAesKey");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", loginUrl:");
      localObject2 = this.dZW;
      if (localObject2 == null) {
        p.btv("loginUrl");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(", nickName:");
      localObject2 = this.nickName;
      if (localObject2 == null) {
        p.btv("nickName");
      }
      Log.i("MicroMsg.KidsWatchRegRebindUI", (String)localObject2 + ", regSessionId:" + this.knu + ", hasSetAvatar:" + this.kpI + ", lastNickName:" + str1 + ", lastImgUrl:" + str2);
      ((Button)_$_findCachedViewById(2131306599)).setOnClickListener((View.OnClickListener)new KidsWatchRegRebindUI.c(this));
      ((Button)_$_findCachedViewById(2131298277)).setOnClickListener((View.OnClickListener)new KidsWatchRegRebindUI.d(this));
      localObject1 = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      localObject1 = getContext();
      p.g(localObject1, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject1, (LinearLayout)_$_findCachedViewById(2131298013), (LinearLayout)_$_findCachedViewById(2131297654));
      AppMethodBeat.o(256366);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256364);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131099846));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(2131099846));
    initView();
    overridePendingTransition(2130772132, 2130771986);
    AppMethodBeat.o(256364);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256367);
    if ((paramq instanceof d))
    {
      Log.i("MicroMsg.KidsWatchRegRebindUI", "errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      Object localObject = this.kdn;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.q)localObject).dismiss();
      }
      g.azz().b(5888, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = ((d)paramq).getUsername();
        this.openid = ((d)paramq).getOpenId();
        paramString = c.yAF;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        c.a(paramString, c.d.yAS, 0);
        paramString = new StringBuilder("gotoRegSuccessUI, nickName:");
        paramq = this.nickName;
        if (paramq == null) {
          p.btv("nickName");
        }
        Log.i("MicroMsg.KidsWatchRegRebindUI", paramq + ", openId:" + this.openid);
        paramString = new Intent((Context)this, KidsWatchRegSuccessUI.class);
        paramq = this.dZW;
        if (paramq == null) {
          p.btv("loginUrl");
        }
        paramString.putExtra("intent.key.login.url", paramq);
        paramq = this.nickName;
        if (paramq == null) {
          p.btv("nickName");
        }
        paramString.putExtra("intent.key.reg.nickname", paramq);
        paramString.putExtra("intent.key.reg.openid", this.openid);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI", "gotoRegSuccessUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256367);
        return;
      }
      paramq = c.yAF;
      c.a("", c.d.yAT, paramInt2);
      paramq = new ae(paramInt1, paramInt2, paramString);
      if (new b().a((Activity)this, paramq))
      {
        AppMethodBeat.o(256367);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null)
      {
        paramString.a((Context)this, null, null);
        AppMethodBeat.o(256367);
        return;
      }
      paramString = getString(2131762086, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      p.g(paramString, "getString(R.string.kids_…or_tip, errType, errCode)");
      h.X((Context)getContext(), paramString, "");
    }
    AppMethodBeat.o(256367);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegRebindUI
 * JD-Core Version:    0.7.0.1
 */