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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.m.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.n.6;
import com.tencent.mm.plugin.luckymoney.model.n.7;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.m;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private long fll;
  private ViewGroup kWT;
  private TextView lln;
  private int maxSize;
  private int nYJ;
  private EmojiInfo oBl;
  private c.a owM;
  private String oyM;
  private String rXi;
  private TextView sZS;
  Button sZT;
  private View sZU;
  private ImageView sZV;
  private TextView sZW;
  private ImageView sZc;
  private TextView swB;
  private ImageView tcc;
  private int textSize;
  public int tfQ;
  as tfY;
  private p tipDialog;
  private String tka;
  private String tkm;
  private br tlD;
  private long tlW;
  private int tlY;
  private com.tencent.mm.al.g tlZ;
  private RelativeLayout tlg;
  private BaseEmojiView tlh;
  private TextView tli;
  private LinearLayout tlj;
  private ProgressBar tlk;
  private int tly;
  private int tmb;
  private LinearLayout tnX;
  private TextView tnY;
  private View tnZ;
  private ImageView toa;
  private com.tencent.mm.plugin.wallet_core.model.ad tob;
  private String toc;
  private boolean tod;
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.tob = null;
    this.tfQ = 0;
    this.tod = false;
    this.owM = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65732);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65731);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65730);
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.tml != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).JS().equals(LuckyMoneyNotHookReceiveUI.1.1.this.tml.JS())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.ftA)
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).JS()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.cMG();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.cMG();
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
    this.tlW = 0L;
    this.tlY = 3;
    this.tmb = 0;
    this.tlZ = new LuckyMoneyNotHookReceiveUI.7(this);
    AppMethodBeat.o(65742);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.tmb = 4;
    this.tlh.setEmojiInfo(paramEmojiInfo);
    this.tlD = new br();
    this.tlD.dMW = 8L;
    this.tlD.aBj();
    AppMethodBeat.o(65751);
  }
  
  private static int Gg(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  private void a(final ap paramap)
  {
    AppMethodBeat.i(65754);
    l locall = paramap.teT;
    Object localObject;
    if (locall.dDP == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.tka, paramap.teT);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramap.dDM);
        ((Intent)localObject).putExtra("key_sendid", paramap.sZn);
        at((Intent)localObject);
        if (com.tencent.mm.m.g.Zd().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramap.tac != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.tac);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("key_emoji_switch", paramap.tfi);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.tfg);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.tfh);
        ((Intent)localObject).putExtra("key_msgid", this.fll);
        paramap = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramap.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramap.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (!w.sz(getIntent().getStringExtra("key_username")))
        {
          paramap = new com.tencent.mm.plugin.wallet_core.model.ad();
          paramap.field_mNativeUrl = this.tkm;
          paramap.field_hbType = locall.dDN;
          paramap.field_receiveAmount = locall.dEb;
          paramap.field_receiveTime = System.currentTimeMillis();
          paramap.field_hbStatus = locall.dDO;
          paramap.field_receiveStatus = locall.dDP;
          if (paramap.field_receiveAmount > 0L) {
            s.ebY().a(paramap);
          }
        }
        AppMethodBeat.o(65754);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
        }
      }
    }
    this.sZT.setBackgroundResource(2131233119);
    this.sZT.setText(2131760918);
    this.sZT.setOnClickListener(null);
    this.sZT.setVisibility(8);
    if (!bt.isNullOrNil(locall.taA))
    {
      this.lln.setText(locall.taA);
      this.lln.setVisibility(0);
    }
    for (;;)
    {
      this.swB.setText(locall.tdh);
      localObject = (RelativeLayout.LayoutParams)this.sZU.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
      this.sZU.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.u.aqG().equals(this.rXi)) && (locall.dDN != 1)) {
        break;
      }
      this.sZU.setVisibility(0);
      this.sZU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174383);
          Object localObject = new Intent();
          if (paramap.tac != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.tac);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramap.dDM);
          ((Intent)localObject).putExtra("key_sendid", paramap.sZn);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("key_emoji_switch", paramap.tfi);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.tfg);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.tfh);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          AppMethodBeat.o(174383);
        }
      });
      this.sZV.setVisibility(8);
      AppMethodBeat.o(65754);
      return;
      this.lln.setVisibility(8);
    }
    this.sZU.setVisibility(8);
    this.sZV.setVisibility(0);
    AppMethodBeat.o(65754);
  }
  
  private void at(Intent paramIntent)
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
    paramIntent.putExtra("key_material_flag", this.nYJ);
    AppMethodBeat.o(163761);
  }
  
  private void cLe()
  {
    AppMethodBeat.i(65749);
    if (this.sZT == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.b.ufs.Iy(this.sZT.getId());
    Object localObject = aj.getContext().getSharedPreferences(aj.eFD(), 0);
    aj.getContext();
    localObject = ac.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.sZT.setBackgroundResource(2131233134);
    this.sZT.setText(2131760921);
    AppMethodBeat.o(65749);
  }
  
  private int cMF()
  {
    AppMethodBeat.i(65755);
    if (com.tencent.mm.model.u.aqG().equals(this.rXi))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void mN(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.tli.setVisibility(8);
    this.tmb = 1;
    if (paramBoolean) {
      this.tlY = 3;
    }
    do
    {
      this.oBl = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(this.oyM);
      if (this.oBl == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aMN(this.oBl.gaa()) <= 0L) && (!this.oBl.CZ()) && (!this.oBl.fZQ())) {
        break label218;
      }
      this.tlh.setVisibility(0);
      A(this.oBl);
      AppMethodBeat.o(65750);
      return;
      this.tlY -= 1;
    } while (this.tlY != 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.tlj.setVisibility(8);
    this.tli.setVisibility(0);
    this.tmb = 2;
    AppMethodBeat.o(65750);
    return;
    this.oBl = new EmojiInfo();
    this.oBl.field_md5 = this.oyM;
    this.oBl.field_type = this.tly;
    label218:
    if (paramBoolean)
    {
      this.tlh.setVisibility(8);
      this.tlj.setVisibility(0);
      com.tencent.mm.plugin.emoji.model.k.bUY().owM = this.owM;
    }
    com.tencent.mm.plugin.emoji.model.k.bUY().u(this.oBl);
    com.tencent.mm.kernel.g.afA().gcy.a(697, this.tlZ);
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
    this.tnZ = findViewById(2131301923);
    this.kWT = ((ViewGroup)findViewById(2131301920));
    this.tnX = ((LinearLayout)findViewById(2131301942));
    this.sZc = ((ImageView)findViewById(2131301921));
    this.sZS = ((TextView)findViewById(2131301922));
    this.lln = ((TextView)findViewById(2131301924));
    this.swB = ((TextView)findViewById(2131301928));
    this.tlg = ((RelativeLayout)findViewById(2131301797));
    this.tlh = ((BaseEmojiView)findViewById(2131301793));
    this.tli = ((TextView)findViewById(2131301941));
    this.tlj = ((LinearLayout)findViewById(2131301835));
    this.tlk = ((ProgressBar)findViewById(2131299385));
    this.sZT = ((Button)findViewById(2131301932));
    this.sZW = ((TextView)findViewById(2131301929));
    this.sZU = findViewById(2131301930);
    this.sZV = ((ImageView)findViewById(2131301718));
    this.toa = ((ImageView)findViewById(2131301916));
    this.tnY = ((TextView)findViewById(2131307214));
    this.tcc = ((ImageView)findViewById(2131301931));
    this.tcc.setOnClickListener(new LuckyMoneyNotHookReceiveUI.4(this));
    this.tli.setOnClickListener(new LuckyMoneyNotHookReceiveUI.5(this));
    this.lln.setLines(2);
    TextView localTextView = this.lln;
    if (Build.VERSION.SDK_INT >= 27)
    {
      localTextView.setAutoSizeTextTypeWithDefaults(1);
      this.maxSize = ((int)(com.tencent.mm.cd.a.ap(getContext(), 2131166509) * 1.125F));
      this.textSize = com.tencent.mm.cd.a.ao(getContext(), 2131166509);
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
          LuckyMoneyNotHookReceiveUI.this.tjY.forceCancel();
          if ((LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
            LuckyMoneyNotHookReceiveUI.this.finish();
          }
          AppMethodBeat.o(65737);
        }
      });
      cLe();
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
    this.tkm = getIntent().getStringExtra("key_native_url");
    this.toc = getIntent().getStringExtra("key_cropname");
    this.fll = getIntent().getLongExtra("key_msgid", 0L);
    this.nYJ = getIntent().getIntExtra("key_material_flag", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bt.nullAsNil(this.tkm));
    initView();
    paramBundle = Uri.parse(bt.nullAsNil(this.tkm));
    try
    {
      this.tka = paramBundle.getQueryParameter("sendid");
      label162:
      this.tob = s.ebY().auf(this.tkm);
      if ((this.tob != null) && (this.tob.field_receiveAmount > 0L) && (bt.vM(this.tob.field_receiveTime) < 86400000L))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.tob.field_receiveTime), bt.nullAsNil(this.tkm) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.tob.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.tka);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("key_msgid", this.fll);
        at(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      if (!bt.isNullOrNil(this.tka))
      {
        int i = bt.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.rXi = paramBundle.getQueryParameter("sendusername");
        paramBundle = new as(i, this.tka, this.tkm, getIntent().getIntExtra("key_way", 0), "v1.0");
        String str;
        if (w.sz(getIntent().getStringExtra("key_username")))
        {
          str = getIntent().getStringExtra("key_emoji_md5");
          if (bt.isNullOrNil(str)) {
            break label567;
          }
        }
        label567:
        for (boolean bool = true;; bool = false)
        {
          paramBundle.teK = new n.6(bool, str);
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          AppMethodBeat.o(65743);
          return;
        }
      }
      finish();
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
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
    if ((this.tmb == 1) || (this.tmb == 2))
    {
      this.tlD = new br();
      this.tlD.dMW = 9L;
      this.tlD.aBj();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.k.bUY().owM = null;
    com.tencent.mm.kernel.g.afA().gcy.b(697, this.tlZ);
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.p("LuckyMoneyReceiveUI", this.tlW, bt.aGK());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.tlW = bt.aGK();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65753);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    label379:
    final boolean bool;
    if ((paramn instanceof as))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tfY = ((as)paramn);
        this.tfQ = this.tfY.tfQ;
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(Gg(this.tfY.dDN)), Integer.valueOf(cMF()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new com.tencent.mm.plugin.wallet_core.model.ad();
        paramString.field_mNativeUrl = this.tkm;
        paramString.field_hbType = this.tfY.dDN;
        paramString.field_hbStatus = this.tfY.dDO;
        paramString.field_receiveStatus = this.tfY.dDP;
        s.ebY().a(paramString);
        if (this.tfY.dDP == 2)
        {
          doSceneProgress(new ah(this.tka, 11, 0, this.tkm, "v1.0"), false);
          AppMethodBeat.o(65753);
          return true;
        }
        if (!bt.isNullOrNil(this.tfY.tfg))
        {
          this.tlD = new br();
          this.tlD.dMW = 7L;
          this.tlD.aBj();
        }
        z.b(this.sZc, this.tfY.tdk, this.tfY.tdE);
        paramString = getIntent().getStringExtra("key_username");
        if (w.sz(paramString))
        {
          this.sZS.setText(this.tfY.tfM);
          bool = false;
          if ((this.tfY.dDP == 1) || (this.tfY.dDO == 4) || (this.tfY.dDO == 5) || (this.tfY.dDO == 1)) {
            break label1142;
          }
          if (!bt.isNullOrNil(this.tfY.tdh))
          {
            this.lln.setText(this.tfY.tdh);
            this.lln.setVisibility(0);
          }
          if (!bt.isNullOrNil(this.tfY.sYt))
          {
            z.a(getContext(), this.swB, this.tfY.sYt);
            this.swB.setVisibility(0);
            this.lln.setVisibility(8);
          }
          if ((!bt.isNullOrNil(this.tfY.tfg)) && (bt.iY(this.tfQ, 1)))
          {
            this.oyM = this.tfY.tfg;
            this.tly = this.tfY.tfh;
            this.tlg.setVisibility(0);
            mN(true);
          }
          this.sZT.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163760);
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gf(10, 3);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Gh(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dDN)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
              LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              String str = paramAnonymousView.getIntent().getStringExtra("key_username");
              ap localap = new ap(paramAnonymousView.tfY.msgType, paramAnonymousView.tfY.cJR, paramAnonymousView.tfY.sZn, paramAnonymousView.tfY.dDM, z.cLy(), com.tencent.mm.model.u.aqI(), str, "v1.0", paramAnonymousView.tfY.tfR);
              if (w.sz(str))
              {
                str = paramAnonymousView.getIntent().getStringExtra("key_emoji_md5");
                if (bt.isNullOrNil(str)) {
                  break label240;
                }
              }
              label240:
              for (boolean bool = true;; bool = false)
              {
                localap.teK = new n.7(bool, str);
                com.tencent.mm.plugin.luckymoney.a.d.sw(2);
                paramAnonymousView.doSceneProgress(localap, false);
                z.c(paramAnonymousView.sZT);
                AppMethodBeat.o(163760);
                return;
              }
            }
          });
          if ((!com.tencent.mm.model.u.aqG().equals(this.rXi)) && ((this.tfY.dDN != 1) || (!bool))) {
            break label1295;
          }
          if (this.tfY.dDN == 1) {
            this.sZW.setText(2131760846);
          }
          this.sZU.setVisibility(0);
          this.sZU.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65740);
              if (bool) {
                com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Gh(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dDN)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dDM);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).sZn);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(65740);
            }
          });
          this.sZV.setVisibility(8);
          label667:
          if ((w.sz(paramString)) && (this.tfY.tfS == null)) {
            this.tfY.tfS = new com.tencent.mm.plugin.luckymoney.model.aw();
          }
          if (this.tfY.tfS == null) {
            break label1327;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramn = getIntent().getStringExtra("key_receive_envelope_md5");
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.tfY.tfS.tfW == null) {
              this.tfY.tfS.tfW = new bfu();
            }
            this.tfY.tfS.tfW.DDh = new bfv();
            this.tfY.tfS.tfW.DDh.gsg = paramString;
            this.tfY.tfS.tfW.DDh.DDA = paramn;
          }
          paramn = this.tfY.tfS.tfW;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramn != null)
          {
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.toa, paramn, null);
            this.toa.setVisibility(0);
            this.sZV.setVisibility(8);
            this.tod = true;
            if (this.nYJ != 2) {
              break label1315;
            }
            this.tnY.setVisibility(0);
            label925:
            paramString = (LinearLayout.LayoutParams)this.tnX.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);
            this.tnX.setLayoutParams(paramString);
            z.m(this.swB);
            z.m(this.lln);
            z.m(this.sZS);
            paramString = "";
            if (paramn.DDh != null) {
              paramString = paramn.DDh.gsg;
            }
            com.tencent.mm.plugin.luckymoney.a.c.bi(2, paramString);
          }
          getIntent().getStringExtra("key_username");
          if (!bt.isNullOrNil(this.tfY.tfS.tfW.DDg)) {
            this.toc = this.tfY.tfS.tfW.DDg;
          }
          if (!ai.Eq()) {
            break label1390;
          }
          this.kWT.setBackgroundResource(2131099663);
          ai.r(this, getResources().getColor(2131099663));
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.tnZ.setVisibility(0);
          z.dZ(this.tnZ);
          break;
          z.a(getContext(), this.sZS, getString(2131760982, new Object[] { this.tfY.tfM }));
          break label379;
          label1142:
          this.sZT.setVisibility(8);
          if (!bt.isNullOrNil(this.tfY.taA))
          {
            this.lln.setText(this.tfY.taA);
            this.lln.setVisibility(0);
            label1186:
            if (bt.isNullOrNil(this.tfY.tdh)) {
              break label1283;
            }
            this.swB.setText(this.tfY.tdh);
            this.swB.setVisibility(0);
            this.swB.setSingleLine(false);
          }
          for (;;)
          {
            paramn = (RelativeLayout.LayoutParams)this.sZU.getLayoutParams();
            paramn.bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
            this.sZU.setLayoutParams(paramn);
            bool = true;
            break;
            this.lln.setVisibility(8);
            break label1186;
            label1283:
            this.swB.setVisibility(8);
          }
          label1295:
          this.sZU.setVisibility(8);
          this.sZV.setVisibility(0);
          break label667;
          label1315:
          this.tnY.setVisibility(8);
          break label925;
          label1327:
          paramString = (LinearLayout.LayoutParams)this.tnX.getLayoutParams();
          if (!bt.isNullOrNil(this.oyM)) {}
          for (paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 118.0F))
          {
            this.tnX.setLayoutParams(paramString);
            break;
          }
          label1390:
          this.kWT.setBackgroundResource(2131100582);
          ai.r(this, getResources().getColor(2131100582));
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramn instanceof ap))
    {
      z.d(this.sZT);
      this.sZT.setClickable(true);
      cLe();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramn;
        k.a(this, k.a.tqF);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void cMH()
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
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.tfD))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.Avm = true;
          paramn.b(paramString.tfD);
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.tod) {
          com.tencent.mm.plugin.report.service.h.vKh.dB(991, 13);
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
        this.sZT.setBackgroundResource(2131232316);
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
          com.tencent.mm.plugin.luckymoney.a.b.a(this.tka, paramString.teT);
          paramn.putExtra("key_jump_from", 2);
          paramn.putExtra("key_native_url", this.tkm);
          paramn.putExtra("key_sendid", this.tka);
          paramn.putExtra("key_anim_slide", true);
          paramn.putExtra("key_detail_emoji_md5", paramString.tfg);
          paramn.putExtra("key_detail_emoji_type", paramString.tfh);
          paramn.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramn.putExtra("key_emoji_switch", paramString.tfi);
          paramn.putExtra("key_msgid", this.fll);
          at(paramn);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(65753);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
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