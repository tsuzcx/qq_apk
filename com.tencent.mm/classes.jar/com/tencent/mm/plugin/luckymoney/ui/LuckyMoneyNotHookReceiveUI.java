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
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.n.6;
import com.tencent.mm.plugin.luckymoney.model.n.7;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.c.m;
import java.util.LinkedList;

@i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private long fIR;
  private int maxSize;
  private ViewGroup mcI;
  private TextView mpP;
  private c.a pKA;
  private String pMA;
  private EmojiInfo pOS;
  private int pmf;
  private int textSize;
  private p tipDialog;
  private TextView uSM;
  private String unV;
  public int vCO;
  as vCW;
  private String vHa;
  private String vHm;
  private ea vID;
  private long vIW;
  private int vIY;
  private com.tencent.mm.ak.f vIZ;
  private RelativeLayout vIg;
  private BaseEmojiView vIh;
  private TextView vIi;
  private LinearLayout vIj;
  private ProgressBar vIk;
  private int vIy;
  private int vJb;
  private LinearLayout vKX;
  private TextView vKY;
  private View vKZ;
  private ImageView vLa;
  private com.tencent.mm.plugin.wallet_core.model.ae vLb;
  private String vLc;
  private boolean vLd;
  private TextView vwV;
  Button vwW;
  private View vwX;
  private ImageView vwY;
  private TextView vwZ;
  private ImageView vwf;
  private ImageView vze;
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.vLb = null;
    this.vCO = 0;
    this.vLd = false;
    this.pKA = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65732);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65731);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65730);
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.vJl != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lj().equals(LuckyMoneyNotHookReceiveUI.1.1.this.vJl.Lj())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.fSA)
                  {
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lj()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.dmy();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.dmy();
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
    this.vIW = 0L;
    this.vIY = 3;
    this.vJb = 0;
    this.vIZ = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(65738);
        if ((bu.jB(paramAnonymousn.getType(), 697)) && ((paramAnonymousn instanceof com.tencent.mm.plugin.emoji.f.e)))
        {
          paramAnonymousString = (com.tencent.mm.plugin.emoji.f.e)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.cir();
            if ((paramAnonymousString != null) && (paramAnonymousString.FUH != null) && (paramAnonymousString.FUH.size() > 0) && (bu.lX(((agk)paramAnonymousString.FUH.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lj()))) {
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, false);
            }
          }
        }
        AppMethodBeat.o(65738);
      }
    };
    AppMethodBeat.o(65742);
  }
  
  private void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.vJb = 4;
    this.vIh.setEmojiInfo(paramEmojiInfo);
    this.vID = new ea();
    this.vID.eeh = 8L;
    this.vID.aLH();
    AppMethodBeat.o(65751);
  }
  
  private static int JW(int paramInt)
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
    l locall = paramap.vBT;
    Object localObject;
    if (locall.dPe == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.vHa, paramap.vBT);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramap.dPb);
        ((Intent)localObject).putExtra("key_sendid", paramap.vwq);
        aA((Intent)localObject);
        if (com.tencent.mm.n.g.acL().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramap.vxf != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.vxf);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("key_emoji_switch", paramap.vCi);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.vCg);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.vCh);
        ((Intent)localObject).putExtra("key_msgid", this.fIR);
        paramap = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramap.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramap.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (!x.Ai(getIntent().getStringExtra("key_username")))
        {
          paramap = new com.tencent.mm.plugin.wallet_core.model.ae();
          paramap.field_mNativeUrl = this.vHm;
          paramap.field_hbType = locall.dPc;
          paramap.field_receiveAmount = locall.dPq;
          paramap.field_receiveTime = System.currentTimeMillis();
          paramap.field_hbStatus = locall.dPd;
          paramap.field_receiveStatus = locall.dPe;
          if (paramap.field_receiveAmount > 0L) {
            t.eJb().a(paramap);
          }
        }
        AppMethodBeat.o(65754);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
        }
      }
    }
    this.vwW.setBackgroundResource(2131233119);
    this.vwW.setText(2131760918);
    this.vwW.setOnClickListener(null);
    this.vwW.setVisibility(8);
    if (!bu.isNullOrNil(locall.vxC))
    {
      this.mpP.setText(locall.vxC);
      this.mpP.setVisibility(0);
    }
    for (;;)
    {
      this.uSM.setText(locall.vAh);
      localObject = (RelativeLayout.LayoutParams)this.vwX.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.h(getContext(), 30.0F);
      this.vwX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!v.aAC().equals(this.unV)) && (locall.dPc != 1)) {
        break;
      }
      this.vwX.setVisibility(0);
      this.vwX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174383);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent();
          if (paramap.vxf != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.vxf);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramap.dPb);
          ((Intent)localObject).putExtra("key_sendid", paramap.vwq);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("key_emoji_switch", paramap.vCi);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.vCg);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.vCh);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174383);
        }
      });
      this.vwY.setVisibility(8);
      AppMethodBeat.o(65754);
      return;
      this.mpP.setVisibility(8);
    }
    this.vwX.setVisibility(8);
    this.vwY.setVisibility(0);
    AppMethodBeat.o(65754);
  }
  
  private void aA(Intent paramIntent)
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
    paramIntent.putExtra("key_material_flag", this.pmf);
    AppMethodBeat.o(163761);
  }
  
  private void dkV()
  {
    AppMethodBeat.i(65749);
    if (this.vwW == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.b.wJt.ME(this.vwW.getId());
    Object localObject = ak.getContext().getSharedPreferences(ak.fow(), 0);
    ak.getContext();
    localObject = ad.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.vwW.setBackgroundResource(2131233134);
    this.vwW.setText(2131760921);
    AppMethodBeat.o(65749);
  }
  
  private int dmx()
  {
    AppMethodBeat.i(65755);
    if (v.aAC().equals(this.unV))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.vIi.setVisibility(8);
    this.vJb = 1;
    if (paramBoolean) {
      this.vIY = 3;
    }
    do
    {
      this.pOS = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(this.pMA);
      if (this.pOS == null) {
        break;
      }
      if ((o.aZR(this.pOS.fSQ()) <= 0L) && (!this.pOS.Ee()) && (!this.pOS.fxr())) {
        break label218;
      }
      this.vIh.setVisibility(0);
      B(this.pOS);
      AppMethodBeat.o(65750);
      return;
      this.vIY -= 1;
    } while (this.vIY != 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.vIj.setVisibility(8);
    this.vIi.setVisibility(0);
    this.vJb = 2;
    AppMethodBeat.o(65750);
    return;
    this.pOS = new EmojiInfo();
    this.pOS.field_md5 = this.pMA;
    this.pOS.field_type = this.vIy;
    label218:
    if (paramBoolean)
    {
      this.vIh.setVisibility(8);
      this.vIj.setVisibility(0);
      com.tencent.mm.plugin.emoji.model.k.cif().pKA = this.pKA;
    }
    com.tencent.mm.plugin.emoji.model.k.cif().u(this.pOS);
    com.tencent.mm.kernel.g.ajQ().gDv.a(697, this.vIZ);
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
    this.vKZ = findViewById(2131301923);
    this.mcI = ((ViewGroup)findViewById(2131301920));
    this.vKX = ((LinearLayout)findViewById(2131301942));
    this.vwf = ((ImageView)findViewById(2131301921));
    this.vwV = ((TextView)findViewById(2131301922));
    this.mpP = ((TextView)findViewById(2131301924));
    this.uSM = ((TextView)findViewById(2131301928));
    this.vIg = ((RelativeLayout)findViewById(2131301797));
    this.vIh = ((BaseEmojiView)findViewById(2131301793));
    this.vIi = ((TextView)findViewById(2131301941));
    this.vIj = ((LinearLayout)findViewById(2131301835));
    this.vIk = ((ProgressBar)findViewById(2131299385));
    this.vwW = ((Button)findViewById(2131301932));
    this.vwZ = ((TextView)findViewById(2131301929));
    this.vwX = findViewById(2131301930);
    this.vwY = ((ImageView)findViewById(2131301718));
    this.vLa = ((ImageView)findViewById(2131301916));
    this.vKY = ((TextView)findViewById(2131307214));
    this.vze = ((ImageView)findViewById(2131301931));
    this.vze.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65735);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNotHookReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65735);
      }
    });
    this.vIi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65736);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65736);
      }
    });
    this.mpP.setLines(2);
    TextView localTextView = this.mpP;
    if (Build.VERSION.SDK_INT >= 27)
    {
      localTextView.setAutoSizeTextTypeWithDefaults(1);
      this.maxSize = ((int)(com.tencent.mm.cb.a.ay(getContext(), 2131166509) * 1.125F));
      this.textSize = com.tencent.mm.cb.a.ax(getContext(), 2131166509);
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
          LuckyMoneyNotHookReceiveUI.this.vGY.forceCancel();
          if ((LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
            LuckyMoneyNotHookReceiveUI.this.finish();
          }
          AppMethodBeat.o(65737);
        }
      });
      dkV();
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
    this.vHm = getIntent().getStringExtra("key_native_url");
    this.vLc = getIntent().getStringExtra("key_cropname");
    this.fIR = getIntent().getLongExtra("key_msgid", 0L);
    this.pmf = getIntent().getIntExtra("key_material_flag", 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bu.nullAsNil(this.vHm));
    initView();
    paramBundle = Uri.parse(bu.nullAsNil(this.vHm));
    try
    {
      this.vHa = paramBundle.getQueryParameter("sendid");
      label162:
      this.vLb = t.eJb().aGb(this.vHm);
      if ((this.vLb != null) && (this.vLb.field_receiveAmount > 0L) && (bu.DD(this.vLb.field_receiveTime) < 86400000L))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.vLb.field_receiveTime), bu.nullAsNil(this.vHm) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.vLb.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.vHa);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("key_msgid", this.fIR);
        aA(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      if (!bu.isNullOrNil(this.vHa))
      {
        int i = bu.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.unV = paramBundle.getQueryParameter("sendusername");
        paramBundle = new as(i, this.vHa, this.vHm, getIntent().getIntExtra("key_way", 0), "v1.0");
        String str;
        if (x.Ai(getIntent().getStringExtra("key_username")))
        {
          str = getIntent().getStringExtra("key_emoji_md5");
          if (bu.isNullOrNil(str)) {
            break label570;
          }
        }
        label570:
        for (boolean bool = true;; bool = false)
        {
          paramBundle.vBK = new n.6(bool, str);
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          AppMethodBeat.o(65743);
          return;
        }
      }
      finish();
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
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
    if ((this.vJb == 1) || (this.vJb == 2))
    {
      this.vID = new ea();
      this.vID.eeh = 9L;
      this.vID.aLH();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.k.cif().pKA = null;
    com.tencent.mm.kernel.g.ajQ().gDv.b(697, this.vIZ);
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyReceiveUI", this.vIW, bu.aRi());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.vIW = bu.aRi();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65753);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    label380:
    final boolean bool;
    if ((paramn instanceof as))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vCW = ((as)paramn);
        this.vCO = this.vCW.vCO;
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(JW(this.vCW.dPc)), Integer.valueOf(dmx()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new com.tencent.mm.plugin.wallet_core.model.ae();
        paramString.field_mNativeUrl = this.vHm;
        paramString.field_hbType = this.vCW.dPc;
        paramString.field_hbStatus = this.vCW.dPd;
        paramString.field_receiveStatus = this.vCW.dPe;
        t.eJb().a(paramString);
        if (this.vCW.dPe == 2)
        {
          doSceneProgress(new ah(this.vHa, 11, 0, this.vHm, "v1.0"), false);
          AppMethodBeat.o(65753);
          return true;
        }
        if (!bu.isNullOrNil(this.vCW.vCg))
        {
          this.vID = new ea();
          this.vID.eeh = 7L;
          this.vID.aLH();
        }
        z.b(this.vwf, this.vCW.vAk, this.vCW.vAE);
        paramString = getIntent().getStringExtra("key_username");
        if (x.Ai(paramString))
        {
          this.vwV.setText(this.vCW.vCK);
          bool = false;
          if ((this.vCW.dPe == 1) || (this.vCW.dPd == 4) || (this.vCW.dPd == 5) || (this.vCW.dPd == 1)) {
            break label1144;
          }
          if (!bu.isNullOrNil(this.vCW.vAh))
          {
            this.mpP.setText(this.vCW.vAh);
            this.mpP.setVisibility(0);
          }
          if (!bu.isNullOrNil(this.vCW.vvw))
          {
            z.a(getContext(), this.uSM, this.vCW.vvw);
            this.uSM.setVisibility(0);
            this.mpP.setVisibility(8);
          }
          if ((!bu.isNullOrNil(this.vCW.vCg)) && (bu.jB(this.vCO, 1)))
          {
            this.pMA = this.vCW.vCg;
            this.vIy = this.vCW.vCh;
            this.vIg.setVisibility(0);
            oe(true);
          }
          this.vwW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163760);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(10, 3);
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.JX(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dPc)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
              LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              String str = paramAnonymousView.getIntent().getStringExtra("key_username");
              localObject = new ap(paramAnonymousView.vCW.msgType, paramAnonymousView.vCW.cSM, paramAnonymousView.vCW.vwq, paramAnonymousView.vCW.dPb, z.dlp(), v.aAE(), str, "v1.0", paramAnonymousView.vCW.vCP);
              if (x.Ai(str))
              {
                str = paramAnonymousView.getIntent().getStringExtra("key_emoji_md5");
                if (bu.isNullOrNil(str)) {
                  break label281;
                }
              }
              label281:
              for (boolean bool = true;; bool = false)
              {
                ((ab)localObject).vBK = new n.7(bool, str);
                com.tencent.mm.plugin.luckymoney.a.d.tW(2);
                paramAnonymousView.doSceneProgress((n)localObject, false);
                z.c(paramAnonymousView.vwW);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163760);
                return;
              }
            }
          });
          if ((!v.aAC().equals(this.unV)) && ((this.vCW.dPc != 1) || (!bool))) {
            break label1297;
          }
          if (this.vCW.dPc == 1) {
            this.vwZ.setText(2131760846);
          }
          this.vwX.setVisibility(0);
          this.vwX.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65740);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              if (bool) {
                com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.JX(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dPc)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dPb);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).vwq);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65740);
            }
          });
          this.vwY.setVisibility(8);
          label668:
          if ((x.Ai(paramString)) && (this.vCW.vCQ == null)) {
            this.vCW.vCQ = new aw();
          }
          if (this.vCW.vCQ == null) {
            break label1329;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramn = getIntent().getStringExtra("key_receive_envelope_md5");
          if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramn)))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.vCW.vCQ.vCU == null) {
              this.vCW.vCQ.vCU = new bom();
            }
            this.vCW.vCQ.vCU.HbB = new bon();
            this.vCW.vCQ.vCU.HbB.hnD = paramString;
            this.vCW.vCQ.vCU.HbB.HbU = paramn;
          }
          paramn = this.vCW.vCQ.vCU;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramn != null)
          {
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vLa, paramn, null);
            this.vLa.setVisibility(0);
            this.vwY.setVisibility(8);
            this.vLd = true;
            if (this.pmf != 2) {
              break label1317;
            }
            this.vKY.setVisibility(0);
            label926:
            paramString = (LinearLayout.LayoutParams)this.vKX.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.h(getContext(), 88.0F);
            this.vKX.setLayoutParams(paramString);
            z.l(this.uSM);
            z.l(this.mpP);
            z.l(this.vwV);
            paramString = "";
            if (paramn.HbB != null) {
              paramString = paramn.HbB.hnD;
            }
            com.tencent.mm.plugin.luckymoney.a.c.bq(2, paramString);
          }
          getIntent().getStringExtra("key_username");
          if (!bu.isNullOrNil(this.vCW.vCQ.vCU.HbA)) {
            this.vLc = this.vCW.vCQ.vCU.HbA;
          }
          if (!al.isDarkMode()) {
            break label1392;
          }
          this.mcI.setBackgroundResource(2131099663);
          al.r(this, getResources().getColor(2131099663));
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.vKZ.setVisibility(0);
          z.eq(this.vKZ);
          break;
          z.a(getContext(), this.vwV, getString(2131760982, new Object[] { this.vCW.vCK }));
          break label380;
          label1144:
          this.vwW.setVisibility(8);
          if (!bu.isNullOrNil(this.vCW.vxC))
          {
            this.mpP.setText(this.vCW.vxC);
            this.mpP.setVisibility(0);
            label1188:
            if (bu.isNullOrNil(this.vCW.vAh)) {
              break label1285;
            }
            this.uSM.setText(this.vCW.vAh);
            this.uSM.setVisibility(0);
            this.uSM.setSingleLine(false);
          }
          for (;;)
          {
            paramn = (RelativeLayout.LayoutParams)this.vwX.getLayoutParams();
            paramn.bottomMargin = BackwardSupportUtil.b.h(getContext(), 30.0F);
            this.vwX.setLayoutParams(paramn);
            bool = true;
            break;
            this.mpP.setVisibility(8);
            break label1188;
            label1285:
            this.uSM.setVisibility(8);
          }
          label1297:
          this.vwX.setVisibility(8);
          this.vwY.setVisibility(0);
          break label668;
          label1317:
          this.vKY.setVisibility(8);
          break label926;
          label1329:
          paramString = (LinearLayout.LayoutParams)this.vKX.getLayoutParams();
          if (!bu.isNullOrNil(this.pMA)) {}
          for (paramString.topMargin = BackwardSupportUtil.b.h(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.b.h(getContext(), 118.0F))
          {
            this.vKX.setLayoutParams(paramString);
            break;
          }
          label1392:
          this.mcI.setBackgroundResource(2131100582);
          al.r(this, getResources().getColor(2131100582));
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramn instanceof ap))
    {
      z.d(this.vwW);
      this.vwW.setClickable(true);
      dkV();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramn;
        k.a(this, k.a.vND);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void dmz()
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
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.vCD))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.DFD = true;
          paramn.b(paramString.vCD);
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.vLd) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(991, 13);
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
        this.vwW.setBackgroundResource(2131232316);
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
          com.tencent.mm.plugin.luckymoney.a.b.a(this.vHa, paramString.vBT);
          paramn.putExtra("key_jump_from", 2);
          paramn.putExtra("key_native_url", this.vHm);
          paramn.putExtra("key_sendid", this.vHa);
          paramn.putExtra("key_anim_slide", true);
          paramn.putExtra("key_detail_emoji_md5", paramString.vCg);
          paramn.putExtra("key_detail_emoji_type", paramString.vCh);
          paramn.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramn.putExtra("key_emoji_switch", paramString.vCi);
          paramn.putExtra("key_msgid", this.fIR);
          aA(paramn);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(65753);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.h.cm(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */