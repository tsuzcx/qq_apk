package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.m.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.n.6;
import com.tencent.mm.plugin.luckymoney.model.n.7;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.m;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private long foF;
  private TextView lLe;
  private ViewGroup lyD;
  private int maxSize;
  private int oCe;
  private c.a pam;
  private String pcm;
  private EmojiInfo peL;
  private TextView tEq;
  private int textSize;
  private String tfa;
  private p tipDialog;
  private ImageView uhq;
  private TextView uih;
  Button uii;
  private View uij;
  private ImageView uik;
  private TextView uil;
  private ImageView ukr;
  public int uof;
  as uon;
  private String usF;
  private String ust;
  private BaseEmojiView utA;
  private TextView utB;
  private LinearLayout utC;
  private ProgressBar utD;
  private int utR;
  private df utW;
  private RelativeLayout utz;
  private long uup;
  private int uur;
  private com.tencent.mm.ak.g uus;
  private int uuu;
  private LinearLayout uwq;
  private TextView uwr;
  private View uws;
  private ImageView uwt;
  private ad uwu;
  private String uwv;
  private boolean uww;
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.uwu = null;
    this.uof = 0;
    this.uww = false;
    this.pam = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65732);
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65731);
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65730);
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.uuE != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).JC().equals(LuckyMoneyNotHookReceiveUI.1.1.this.uuE.JC())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.fxh)
                  {
                    ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).JC()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.dam();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.dam();
                }
                AppMethodBeat.o(65730);
              }
            });
            AppMethodBeat.o(65731);
          }
        });
        AppMethodBeat.o(65732);
      }
    };
    this.uup = 0L;
    this.uur = 3;
    this.uuu = 0;
    this.uus = new LuckyMoneyNotHookReceiveUI.7(this);
    AppMethodBeat.o(65742);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.uuu = 4;
    this.utA.setEmojiInfo(paramEmojiInfo);
    this.utW = new df();
    this.utW.dNx = 8L;
    this.utW.aHZ();
    AppMethodBeat.o(65751);
  }
  
  private static int Ib(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  private void a(final com.tencent.mm.plugin.luckymoney.model.ap paramap)
  {
    AppMethodBeat.i(65754);
    l locall = paramap.uni;
    Object localObject;
    if (locall.dBB == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.ust, paramap.uni);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramap.dBy);
        ((Intent)localObject).putExtra("key_sendid", paramap.uhB);
        au((Intent)localObject);
        if (com.tencent.mm.m.g.ZY().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramap.uis != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.uis);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("key_emoji_switch", paramap.unx);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.unv);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.unw);
        ((Intent)localObject).putExtra("key_msgid", this.foF);
        paramap = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramap.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramap.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (!w.wC(getIntent().getStringExtra("key_username")))
        {
          paramap = new ad();
          paramap.field_mNativeUrl = this.usF;
          paramap.field_hbType = locall.dBz;
          paramap.field_receiveAmount = locall.dBN;
          paramap.field_receiveTime = System.currentTimeMillis();
          paramap.field_hbStatus = locall.dBA;
          paramap.field_receiveStatus = locall.dBB;
          if (paramap.field_receiveAmount > 0L) {
            s.eru().a(paramap);
          }
        }
        AppMethodBeat.o(65754);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
        }
      }
    }
    this.uii.setBackgroundResource(2131233119);
    this.uii.setText(2131760918);
    this.uii.setOnClickListener(null);
    this.uii.setVisibility(8);
    if (!bs.isNullOrNil(locall.uiP))
    {
      this.lLe.setText(locall.uiP);
      this.lLe.setVisibility(0);
    }
    for (;;)
    {
      this.tEq.setText(locall.ulw);
      localObject = (RelativeLayout.LayoutParams)this.uij.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
      this.uij.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.u.axw().equals(this.tfa)) && (locall.dBz != 1)) {
        break;
      }
      this.uij.setVisibility(0);
      this.uij.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174383);
          Object localObject = new Intent();
          if (paramap.uis != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.uis);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramap.dBy);
          ((Intent)localObject).putExtra("key_sendid", paramap.uhB);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("key_emoji_switch", paramap.unx);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.unv);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.unw);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          AppMethodBeat.o(174383);
        }
      });
      this.uik.setVisibility(8);
      AppMethodBeat.o(65754);
      return;
      this.lLe.setVisibility(8);
    }
    this.uij.setVisibility(8);
    this.uik.setVisibility(0);
    AppMethodBeat.o(65754);
  }
  
  private void au(Intent paramIntent)
  {
    AppMethodBeat.i(163761);
    paramIntent.putExtra("key_detail_envelope_url", getIntent().getStringExtra("key_detail_envelope_url"));
    paramIntent.putExtra("key_detail_envelope_md5", getIntent().getStringExtra("key_detail_envelope_md5"));
    paramIntent.putExtra("key_about_url", getIntent().getStringExtra("key_about_url"));
    paramIntent.putExtra("key_store_action_type", getIntent().getStringExtra("key_store_action_type"));
    paramIntent.putExtra("key_story_url", getIntent().getStringExtra("key_story_url"));
    paramIntent.putExtra("key_cropname", getIntent().getStringExtra("key_cropname"));
    paramIntent.putExtra("key_packet_id", getIntent().getStringExtra("key_packet_id"));
    paramIntent.putExtra("key_has_story", getIntent().getBooleanExtra("key_has_story", false));
    paramIntent.putExtra("key_material_flag", this.oCe);
    AppMethodBeat.o(163761);
  }
  
  private void cYK()
  {
    AppMethodBeat.i(65749);
    if (this.uii == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.b.vor.Kx(this.uii.getId());
    Object localObject = ai.getContext().getSharedPreferences(ai.eUX(), 0);
    ai.getContext();
    localObject = com.tencent.mm.sdk.platformtools.ab.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.uii.setBackgroundResource(2131233134);
    this.uii.setText(2131760921);
    AppMethodBeat.o(65749);
  }
  
  private int dal()
  {
    AppMethodBeat.i(65755);
    if (com.tencent.mm.model.u.axw().equals(this.tfa))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.utB.setVisibility(8);
    this.uuu = 1;
    if (paramBoolean) {
      this.uur = 3;
    }
    do
    {
      this.peL = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(this.pcm);
      if (this.peL == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aSp(this.peL.ghd()) <= 0L) && (!this.peL.CC()) && (!this.peL.fxI())) {
        break label218;
      }
      this.utA.setVisibility(0);
      A(this.peL);
      AppMethodBeat.o(65750);
      return;
      this.uur -= 1;
    } while (this.uur != 0);
    ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.utC.setVisibility(8);
    this.utB.setVisibility(0);
    this.uuu = 2;
    AppMethodBeat.o(65750);
    return;
    this.peL = new EmojiInfo();
    this.peL.field_md5 = this.pcm;
    this.peL.field_type = this.utR;
    label218:
    if (paramBoolean)
    {
      this.utA.setVisibility(8);
      this.utC.setVisibility(0);
      com.tencent.mm.plugin.emoji.model.k.ccl().pam = this.pam;
    }
    com.tencent.mm.plugin.emoji.model.k.ccl().u(this.peL);
    com.tencent.mm.kernel.g.agQ().ghe.a(697, this.uus);
    AppMethodBeat.o(65750);
  }
  
  public boolean enableActivityAnimation()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(65747);
    super.finish();
    overridePendingTransition(0, 2130772046);
    AppMethodBeat.o(65747);
  }
  
  public int getLayoutId()
  {
    return 2131494657;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65748);
    this.uws = findViewById(2131301923);
    this.lyD = ((ViewGroup)findViewById(2131301920));
    this.uwq = ((LinearLayout)findViewById(2131301942));
    this.uhq = ((ImageView)findViewById(2131301921));
    this.uih = ((TextView)findViewById(2131301922));
    this.lLe = ((TextView)findViewById(2131301924));
    this.tEq = ((TextView)findViewById(2131301928));
    this.utz = ((RelativeLayout)findViewById(2131301797));
    this.utA = ((BaseEmojiView)findViewById(2131301793));
    this.utB = ((TextView)findViewById(2131301941));
    this.utC = ((LinearLayout)findViewById(2131301835));
    this.utD = ((ProgressBar)findViewById(2131299385));
    this.uii = ((Button)findViewById(2131301932));
    this.uil = ((TextView)findViewById(2131301929));
    this.uij = findViewById(2131301930);
    this.uik = ((ImageView)findViewById(2131301718));
    this.uwt = ((ImageView)findViewById(2131301916));
    this.uwr = ((TextView)findViewById(2131307214));
    this.ukr = ((ImageView)findViewById(2131301931));
    this.ukr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65735);
        LuckyMoneyNotHookReceiveUI.this.finish();
        AppMethodBeat.o(65735);
      }
    });
    this.utB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65736);
        LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
        AppMethodBeat.o(65736);
      }
    });
    this.lLe.setLines(2);
    TextView localTextView = this.lLe;
    if (Build.VERSION.SDK_INT >= 27)
    {
      localTextView.setAutoSizeTextTypeWithDefaults(1);
      this.maxSize = ((int)(com.tencent.mm.cc.a.av(getContext(), 2131166509) * 1.125F));
      this.textSize = com.tencent.mm.cc.a.au(getContext(), 2131166509);
      if (this.textSize <= this.maxSize) {
        break label448;
      }
    }
    label448:
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65737);
          if ((LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this).isShowing())) {
            LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this).dismiss();
          }
          LuckyMoneyNotHookReceiveUI.this.usr.forceCancel();
          if ((LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
          {
            ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
            LuckyMoneyNotHookReceiveUI.this.finish();
          }
          AppMethodBeat.o(65737);
        }
      });
      cYK();
      AppMethodBeat.o(65748);
      return;
      if (!(localTextView instanceof android.support.v4.widget.b)) {
        break;
      }
      ((android.support.v4.widget.b)localTextView).setAutoSizeTextTypeWithDefaults(1);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65743);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131101053));
    }
    this.usF = getIntent().getStringExtra("key_native_url");
    this.uwv = getIntent().getStringExtra("key_cropname");
    this.foF = getIntent().getLongExtra("key_msgid", 0L);
    this.oCe = getIntent().getIntExtra("key_material_flag", 0);
    ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bs.nullAsNil(this.usF));
    initView();
    paramBundle = Uri.parse(bs.nullAsNil(this.usF));
    try
    {
      this.ust = paramBundle.getQueryParameter("sendid");
      label162:
      this.uwu = s.eru().azx(this.usF);
      if ((this.uwu != null) && (this.uwu.field_receiveAmount > 0L) && (bs.Ap(this.uwu.field_receiveTime) < 86400000L))
      {
        ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.uwu.field_receiveTime), bs.nullAsNil(this.usF) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.uwu.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.ust);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("key_msgid", this.foF);
        au(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      if (!bs.isNullOrNil(this.ust))
      {
        int i = bs.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.tfa = paramBundle.getQueryParameter("sendusername");
        paramBundle = new as(i, this.ust, this.usF, getIntent().getIntExtra("key_way", 0), "v1.0");
        String str;
        if (w.wC(getIntent().getStringExtra("key_username")))
        {
          str = getIntent().getStringExtra("key_emoji_md5");
          if (bs.isNullOrNil(str)) {
            break label570;
          }
        }
        label570:
        for (boolean bool = true;; bool = false)
        {
          paramBundle.umZ = new n.6(bool, str);
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          AppMethodBeat.o(65743);
          return;
        }
      }
      finish();
      ac.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
      AppMethodBeat.o(65743);
      return;
    }
    catch (Exception localException)
    {
      break label162;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65744);
    super.onDestroy();
    if ((this.uuu == 1) || (this.uuu == 2))
    {
      this.utW = new df();
      this.utW.dNx = 9L;
      this.utW.aHZ();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.k.ccl().pam = null;
    com.tencent.mm.kernel.g.agQ().ghe.b(697, this.uus);
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyReceiveUI", this.uup, bs.aNx());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.uup = bs.aNx();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65753);
    ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    label380:
    final boolean bool;
    if ((paramn instanceof as))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uon = ((as)paramn);
        this.uof = this.uon.uof;
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(Ib(this.uon.dBz)), Integer.valueOf(dal()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new ad();
        paramString.field_mNativeUrl = this.usF;
        paramString.field_hbType = this.uon.dBz;
        paramString.field_hbStatus = this.uon.dBA;
        paramString.field_receiveStatus = this.uon.dBB;
        s.eru().a(paramString);
        if (this.uon.dBB == 2)
        {
          doSceneProgress(new ah(this.ust, 11, 0, this.usF, "v1.0"), false);
          AppMethodBeat.o(65753);
          return true;
        }
        if (!bs.isNullOrNil(this.uon.unv))
        {
          this.utW = new df();
          this.utW.dNx = 7L;
          this.utW.aHZ();
        }
        z.b(this.uhq, this.uon.ulz, this.uon.ulT);
        paramString = getIntent().getStringExtra("key_username");
        if (w.wC(paramString))
        {
          this.uih.setText(this.uon.uob);
          bool = false;
          if ((this.uon.dBB == 1) || (this.uon.dBA == 4) || (this.uon.dBA == 5) || (this.uon.dBA == 1)) {
            break label1144;
          }
          if (!bs.isNullOrNil(this.uon.ulw))
          {
            this.lLe.setText(this.uon.ulw);
            this.lLe.setVisibility(0);
          }
          if (!bs.isNullOrNil(this.uon.ugH))
          {
            z.a(getContext(), this.tEq, this.uon.ugH);
            this.tEq.setVisibility(0);
            this.lLe.setVisibility(8);
          }
          if ((!bs.isNullOrNil(this.uon.unv)) && (bs.jl(this.uof, 1)))
          {
            this.pcm = this.uon.unv;
            this.utR = this.uon.unw;
            this.utz.setVisibility(0);
            nF(true);
          }
          this.uii.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163760);
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gm(10, 3);
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Ic(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dBz)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
              LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              String str = paramAnonymousView.getIntent().getStringExtra("key_username");
              com.tencent.mm.plugin.luckymoney.model.ap localap = new com.tencent.mm.plugin.luckymoney.model.ap(paramAnonymousView.uon.msgType, paramAnonymousView.uon.cGY, paramAnonymousView.uon.uhB, paramAnonymousView.uon.dBy, z.cZe(), com.tencent.mm.model.u.axy(), str, "v1.0", paramAnonymousView.uon.uog);
              if (w.wC(str))
              {
                str = paramAnonymousView.getIntent().getStringExtra("key_emoji_md5");
                if (bs.isNullOrNil(str)) {
                  break label240;
                }
              }
              label240:
              for (boolean bool = true;; bool = false)
              {
                localap.umZ = new n.7(bool, str);
                com.tencent.mm.plugin.luckymoney.a.d.tn(2);
                paramAnonymousView.doSceneProgress(localap, false);
                z.c(paramAnonymousView.uii);
                AppMethodBeat.o(163760);
                return;
              }
            }
          });
          if ((!com.tencent.mm.model.u.axw().equals(this.tfa)) && ((this.uon.dBz != 1) || (!bool))) {
            break label1297;
          }
          if (this.uon.dBz == 1) {
            this.uil.setText(2131760846);
          }
          this.uij.setVisibility(0);
          this.uij.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65740);
              if (bool) {
                com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Ic(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dBz)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dBy);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).uhB);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(65740);
            }
          });
          this.uik.setVisibility(8);
          label668:
          if ((w.wC(paramString)) && (this.uon.uoh == null)) {
            this.uon.uoh = new aw();
          }
          if (this.uon.uoh == null) {
            break label1329;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramn = getIntent().getStringExtra("key_receive_envelope_md5");
          if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(paramn)))
          {
            ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.uon.uoh.uol == null) {
              this.uon.uoh.uol = new bjm();
            }
            this.uon.uoh.uol.EYD = new bjn();
            this.uon.uoh.uol.EYD.gSO = paramString;
            this.uon.uoh.uol.EYD.EYW = paramn;
          }
          paramn = this.uon.uoh.uol;
          ac.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramn != null)
          {
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.uwt, paramn, null);
            this.uwt.setVisibility(0);
            this.uik.setVisibility(8);
            this.uww = true;
            if (this.oCe != 2) {
              break label1317;
            }
            this.uwr.setVisibility(0);
            label926:
            paramString = (LinearLayout.LayoutParams)this.uwq.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);
            this.uwq.setLayoutParams(paramString);
            z.m(this.tEq);
            z.m(this.lLe);
            z.m(this.uih);
            paramString = "";
            if (paramn.EYD != null) {
              paramString = paramn.EYD.gSO;
            }
            com.tencent.mm.plugin.luckymoney.a.c.bn(2, paramString);
          }
          getIntent().getStringExtra("key_username");
          if (!bs.isNullOrNil(this.uon.uoh.uol.EYC)) {
            this.uwv = this.uon.uoh.uol.EYC;
          }
          if (!aj.DT()) {
            break label1392;
          }
          this.lyD.setBackgroundResource(2131099663);
          aj.r(this, getResources().getColor(2131099663));
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.uws.setVisibility(0);
          z.ei(this.uws);
          break;
          z.a(getContext(), this.uih, getString(2131760982, new Object[] { this.uon.uob }));
          break label380;
          label1144:
          this.uii.setVisibility(8);
          if (!bs.isNullOrNil(this.uon.uiP))
          {
            this.lLe.setText(this.uon.uiP);
            this.lLe.setVisibility(0);
            label1188:
            if (bs.isNullOrNil(this.uon.ulw)) {
              break label1285;
            }
            this.tEq.setText(this.uon.ulw);
            this.tEq.setVisibility(0);
            this.tEq.setSingleLine(false);
          }
          for (;;)
          {
            paramn = (RelativeLayout.LayoutParams)this.uij.getLayoutParams();
            paramn.bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
            this.uij.setLayoutParams(paramn);
            bool = true;
            break;
            this.lLe.setVisibility(8);
            break label1188;
            label1285:
            this.tEq.setVisibility(8);
          }
          label1297:
          this.uij.setVisibility(8);
          this.uik.setVisibility(0);
          break label668;
          label1317:
          this.uwr.setVisibility(8);
          break label926;
          label1329:
          paramString = (LinearLayout.LayoutParams)this.uwq.getLayoutParams();
          if (!bs.isNullOrNil(this.pcm)) {}
          for (paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 118.0F))
          {
            this.uwq.setLayoutParams(paramString);
            break;
          }
          label1392:
          this.lyD.setBackgroundResource(2131100582);
          aj.r(this, getResources().getColor(2131100582));
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ap))
    {
      z.d(this.uii);
      this.uii.setClickable(true);
      cYK();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ap)paramn;
        k.a(this, k.a.uyW);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void dan()
          {
            AppMethodBeat.i(174384);
            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, paramString);
            AppMethodBeat.o(174384);
          }
        })))
        {
          AppMethodBeat.o(65753);
          return true;
        }
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.unS))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.BNG = true;
          paramn.b(paramString.unS);
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.uww) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(991, 13);
        }
        AppMethodBeat.o(65753);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.uii.setBackgroundResource(2131232316);
        new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        };
        bool = z.a(this, paramInt2, paramn, paramString, false, null, 1003);
        AppMethodBeat.o(65753);
        return bool;
      }
    }
    else if ((paramn instanceof ah))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = new Intent();
        paramn.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramn.putExtra("key_lucky_money_can_received", true);
        try
        {
          com.tencent.mm.plugin.luckymoney.a.b.a(this.ust, paramString.uni);
          paramn.putExtra("key_jump_from", 2);
          paramn.putExtra("key_native_url", this.usF);
          paramn.putExtra("key_sendid", this.ust);
          paramn.putExtra("key_anim_slide", true);
          paramn.putExtra("key_detail_emoji_md5", paramString.unv);
          paramn.putExtra("key_detail_emoji_type", paramString.unw);
          paramn.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramn.putExtra("key_emoji_switch", paramString.unx);
          paramn.putExtra("key_msgid", this.foF);
          au(paramn);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(65753);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.h.cg(this, paramString);
      finish();
      AppMethodBeat.o(65753);
      return true;
    }
    AppMethodBeat.o(65753);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */