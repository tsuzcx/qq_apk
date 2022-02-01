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
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.n.6;
import com.tencent.mm.plugin.luckymoney.model.n.7;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.m;
import java.util.LinkedList;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private long fGN;
  private ViewGroup lYb;
  private int maxSize;
  private TextView mkS;
  private c.a pDW;
  private String pFW;
  private EmojiInfo pIn;
  private int pfz;
  private int textSize;
  private p tipDialog;
  private TextView uGZ;
  private String ucQ;
  private TextView vkQ;
  Button vkR;
  private View vkS;
  private ImageView vkT;
  private TextView vkU;
  private ImageView vka;
  private ImageView vmZ;
  public int vqJ;
  as vqR;
  private String vuW;
  private String vvi;
  private long vwS;
  private int vwU;
  private com.tencent.mm.al.f vwV;
  private int vwX;
  private RelativeLayout vwc;
  private BaseEmojiView vwd;
  private TextView vwe;
  private LinearLayout vwf;
  private ProgressBar vwg;
  private int vwu;
  private dy vwz;
  private LinearLayout vyT;
  private TextView vyU;
  private View vyV;
  private ImageView vyW;
  private ae vyX;
  private String vyY;
  private boolean vyZ;
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.vyX = null;
    this.vqJ = 0;
    this.vyZ = false;
    this.pDW = new c.a()
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
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.vxh != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lb().equals(LuckyMoneyNotHookReceiveUI.1.1.this.vxh.Lb())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.fQu)
                  {
                    ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lb()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.djz();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.djz();
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
    this.vwS = 0L;
    this.vwU = 3;
    this.vwX = 0;
    this.vwV = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(65738);
        if ((bt.jx(paramAnonymousn.getType(), 697)) && ((paramAnonymousn instanceof com.tencent.mm.plugin.emoji.f.e)))
        {
          paramAnonymousString = (com.tencent.mm.plugin.emoji.f.e)paramAnonymousn;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.chb();
            if ((paramAnonymousString != null) && (paramAnonymousString.FCm != null) && (paramAnonymousString.FCm.size() > 0) && (bt.lQ(((agb)paramAnonymousString.FCm.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).Lb()))) {
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, false);
            }
          }
        }
        AppMethodBeat.o(65738);
      }
    };
    AppMethodBeat.o(65742);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.vwX = 4;
    this.vwd.setEmojiInfo(paramEmojiInfo);
    this.vwz = new dy();
    this.vwz.ecM = 8L;
    this.vwz.aLk();
    AppMethodBeat.o(65751);
  }
  
  private static int Jx(int paramInt)
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
    l locall = paramap.vpO;
    Object localObject;
    if (locall.dNO == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.vuW, paramap.vpO);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramap.dNL);
        ((Intent)localObject).putExtra("key_sendid", paramap.vkl);
        az((Intent)localObject);
        if (com.tencent.mm.n.g.acA().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramap.vla != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.vla);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("key_emoji_switch", paramap.vqd);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.vqb);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.vqc);
        ((Intent)localObject).putExtra("key_msgid", this.fGN);
        paramap = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramap.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramap.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (!w.zy(getIntent().getStringExtra("key_username")))
        {
          paramap = new ae();
          paramap.field_mNativeUrl = this.vvi;
          paramap.field_hbType = locall.dNM;
          paramap.field_receiveAmount = locall.dOa;
          paramap.field_receiveTime = System.currentTimeMillis();
          paramap.field_hbStatus = locall.dNN;
          paramap.field_receiveStatus = locall.dNO;
          if (paramap.field_receiveAmount > 0L) {
            t.eFu().a(paramap);
          }
        }
        AppMethodBeat.o(65754);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
        }
      }
    }
    this.vkR.setBackgroundResource(2131233119);
    this.vkR.setText(2131760918);
    this.vkR.setOnClickListener(null);
    this.vkR.setVisibility(8);
    if (!bt.isNullOrNil(locall.vlx))
    {
      this.mkS.setText(locall.vlx);
      this.mkS.setVisibility(0);
    }
    for (;;)
    {
      this.uGZ.setText(locall.voc);
      localObject = (RelativeLayout.LayoutParams)this.vkS.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
      this.vkS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.u.aAm().equals(this.ucQ)) && (locall.dNM != 1)) {
        break;
      }
      this.vkS.setVisibility(0);
      this.vkS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174383);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent();
          if (paramap.vla != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramap.vla);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramap.dNL);
          ((Intent)localObject).putExtra("key_sendid", paramap.vkl);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("key_emoji_switch", paramap.vqd);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramap.vqb);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramap.vqc);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174383);
        }
      });
      this.vkT.setVisibility(8);
      AppMethodBeat.o(65754);
      return;
      this.mkS.setVisibility(8);
    }
    this.vkS.setVisibility(8);
    this.vkT.setVisibility(0);
    AppMethodBeat.o(65754);
  }
  
  private void az(Intent paramIntent)
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
    paramIntent.putExtra("key_material_flag", this.pfz);
    AppMethodBeat.o(163761);
  }
  
  private void dhW()
  {
    AppMethodBeat.i(65749);
    if (this.vkR == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.b.wtJ.LZ(this.vkR.getId());
    Object localObject = aj.getContext().getSharedPreferences(aj.fkC(), 0);
    aj.getContext();
    localObject = ac.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.vkR.setBackgroundResource(2131233134);
    this.vkR.setText(2131760921);
    AppMethodBeat.o(65749);
  }
  
  private int djy()
  {
    AppMethodBeat.i(65755);
    if (com.tencent.mm.model.u.aAm().equals(this.ucQ))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.vwe.setVisibility(8);
    this.vwX = 1;
    if (paramBoolean) {
      this.vwU = 3;
    }
    do
    {
      this.pIn = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(this.pFW);
      if (this.pIn == null) {
        break;
      }
      if ((com.tencent.mm.vfs.i.aYo(this.pIn.gzQ()) <= 0L) && (!this.pIn.Eb()) && (!this.pIn.fOy())) {
        break label218;
      }
      this.vwd.setVisibility(0);
      A(this.pIn);
      AppMethodBeat.o(65750);
      return;
      this.vwU -= 1;
    } while (this.vwU != 0);
    ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.vwf.setVisibility(8);
    this.vwe.setVisibility(0);
    this.vwX = 2;
    AppMethodBeat.o(65750);
    return;
    this.pIn = new EmojiInfo();
    this.pIn.field_md5 = this.pFW;
    this.pIn.field_type = this.vwu;
    label218:
    if (paramBoolean)
    {
      this.vwd.setVisibility(8);
      this.vwf.setVisibility(0);
      com.tencent.mm.plugin.emoji.model.k.cgP().pDW = this.pDW;
    }
    com.tencent.mm.plugin.emoji.model.k.cgP().u(this.pIn);
    com.tencent.mm.kernel.g.ajB().gAO.a(697, this.vwV);
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
    this.vyV = findViewById(2131301923);
    this.lYb = ((ViewGroup)findViewById(2131301920));
    this.vyT = ((LinearLayout)findViewById(2131301942));
    this.vka = ((ImageView)findViewById(2131301921));
    this.vkQ = ((TextView)findViewById(2131301922));
    this.mkS = ((TextView)findViewById(2131301924));
    this.uGZ = ((TextView)findViewById(2131301928));
    this.vwc = ((RelativeLayout)findViewById(2131301797));
    this.vwd = ((BaseEmojiView)findViewById(2131301793));
    this.vwe = ((TextView)findViewById(2131301941));
    this.vwf = ((LinearLayout)findViewById(2131301835));
    this.vwg = ((ProgressBar)findViewById(2131299385));
    this.vkR = ((Button)findViewById(2131301932));
    this.vkU = ((TextView)findViewById(2131301929));
    this.vkS = findViewById(2131301930);
    this.vkT = ((ImageView)findViewById(2131301718));
    this.vyW = ((ImageView)findViewById(2131301916));
    this.vyU = ((TextView)findViewById(2131307214));
    this.vmZ = ((ImageView)findViewById(2131301931));
    this.vmZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65735);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNotHookReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65735);
      }
    });
    this.vwe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65736);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65736);
      }
    });
    this.mkS.setLines(2);
    TextView localTextView = this.mkS;
    if (Build.VERSION.SDK_INT >= 27)
    {
      localTextView.setAutoSizeTextTypeWithDefaults(1);
      this.maxSize = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131166509) * 1.125F));
      this.textSize = com.tencent.mm.cc.a.ax(getContext(), 2131166509);
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
          LuckyMoneyNotHookReceiveUI.this.vuU.forceCancel();
          if ((LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
          {
            ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
            LuckyMoneyNotHookReceiveUI.this.finish();
          }
          AppMethodBeat.o(65737);
        }
      });
      dhW();
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
    this.vvi = getIntent().getStringExtra("key_native_url");
    this.vyY = getIntent().getStringExtra("key_cropname");
    this.fGN = getIntent().getLongExtra("key_msgid", 0L);
    this.pfz = getIntent().getIntExtra("key_material_flag", 0);
    ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bt.nullAsNil(this.vvi));
    initView();
    paramBundle = Uri.parse(bt.nullAsNil(this.vvi));
    try
    {
      this.vuW = paramBundle.getQueryParameter("sendid");
      label162:
      this.vyX = t.eFu().aEH(this.vvi);
      if ((this.vyX != null) && (this.vyX.field_receiveAmount > 0L) && (bt.Df(this.vyX.field_receiveTime) < 86400000L))
      {
        ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.vyX.field_receiveTime), bt.nullAsNil(this.vvi) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.vyX.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.vuW);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("key_msgid", this.fGN);
        az(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      if (!bt.isNullOrNil(this.vuW))
      {
        int i = bt.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.ucQ = paramBundle.getQueryParameter("sendusername");
        paramBundle = new as(i, this.vuW, this.vvi, getIntent().getIntExtra("key_way", 0), "v1.0");
        String str;
        if (w.zy(getIntent().getStringExtra("key_username")))
        {
          str = getIntent().getStringExtra("key_emoji_md5");
          if (bt.isNullOrNil(str)) {
            break label570;
          }
        }
        label570:
        for (boolean bool = true;; bool = false)
        {
          paramBundle.vpF = new n.6(bool, str);
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          AppMethodBeat.o(65743);
          return;
        }
      }
      finish();
      ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
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
    if ((this.vwX == 1) || (this.vwX == 2))
    {
      this.vwz = new dy();
      this.vwz.ecM = 9L;
      this.vwz.aLk();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.k.cgP().pDW = null;
    com.tencent.mm.kernel.g.ajB().gAO.b(697, this.vwV);
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyReceiveUI", this.vwS, bt.aQJ());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.vwS = bt.aQJ();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65753);
    ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    label380:
    final boolean bool;
    if ((paramn instanceof as))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vqR = ((as)paramn);
        this.vqJ = this.vqR.vqJ;
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(Jx(this.vqR.dNM)), Integer.valueOf(djy()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new ae();
        paramString.field_mNativeUrl = this.vvi;
        paramString.field_hbType = this.vqR.dNM;
        paramString.field_hbStatus = this.vqR.dNN;
        paramString.field_receiveStatus = this.vqR.dNO;
        t.eFu().a(paramString);
        if (this.vqR.dNO == 2)
        {
          doSceneProgress(new ah(this.vuW, 11, 0, this.vvi, "v1.0"), false);
          AppMethodBeat.o(65753);
          return true;
        }
        if (!bt.isNullOrNil(this.vqR.vqb))
        {
          this.vwz = new dy();
          this.vwz.ecM = 7L;
          this.vwz.aLk();
        }
        z.b(this.vka, this.vqR.vof, this.vqR.voz);
        paramString = getIntent().getStringExtra("key_username");
        if (w.zy(paramString))
        {
          this.vkQ.setText(this.vqR.vqF);
          bool = false;
          if ((this.vqR.dNO == 1) || (this.vqR.dNN == 4) || (this.vqR.dNN == 5) || (this.vqR.dNN == 1)) {
            break label1144;
          }
          if (!bt.isNullOrNil(this.vqR.voc))
          {
            this.mkS.setText(this.vqR.voc);
            this.mkS.setVisibility(0);
          }
          if (!bt.isNullOrNil(this.vqR.vjr))
          {
            z.a(getContext(), this.uGZ, this.vqR.vjr);
            this.uGZ.setVisibility(0);
            this.mkS.setVisibility(8);
          }
          if ((!bt.isNullOrNil(this.vqR.vqb)) && (bt.jx(this.vqJ, 1)))
          {
            this.pFW = this.vqR.vqb;
            this.vwu = this.vqR.vqc;
            this.vwc.setVisibility(0);
            nZ(true);
          }
          this.vkR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163760);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(10, 3);
              com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Jy(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dNM)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
              LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              String str = paramAnonymousView.getIntent().getStringExtra("key_username");
              localObject = new ap(paramAnonymousView.vqR.msgType, paramAnonymousView.vqR.cSc, paramAnonymousView.vqR.vkl, paramAnonymousView.vqR.dNL, z.diq(), com.tencent.mm.model.u.aAo(), str, "v1.0", paramAnonymousView.vqR.vqK);
              if (w.zy(str))
              {
                str = paramAnonymousView.getIntent().getStringExtra("key_emoji_md5");
                if (bt.isNullOrNil(str)) {
                  break label281;
                }
              }
              label281:
              for (boolean bool = true;; bool = false)
              {
                ((ab)localObject).vpF = new n.7(bool, str);
                com.tencent.mm.plugin.luckymoney.a.d.tQ(2);
                paramAnonymousView.doSceneProgress((n)localObject, false);
                z.c(paramAnonymousView.vkR);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163760);
                return;
              }
            }
          });
          if ((!com.tencent.mm.model.u.aAm().equals(this.ucQ)) && ((this.vqR.dNM != 1) || (!bool))) {
            break label1297;
          }
          if (this.vqR.dNM == 1) {
            this.vkU.setText(2131760846);
          }
          this.vkS.setVisibility(0);
          this.vkS.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65740);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              if (bool) {
                com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Jy(LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dNM)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).dNL);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).vkl);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65740);
            }
          });
          this.vkT.setVisibility(8);
          label668:
          if ((w.zy(paramString)) && (this.vqR.vqL == null)) {
            this.vqR.vqL = new aw();
          }
          if (this.vqR.vqL == null) {
            break label1329;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramn = getIntent().getStringExtra("key_receive_envelope_md5");
          if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramn)))
          {
            ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.vqR.vqL.vqP == null) {
              this.vqR.vqL.vqP = new bnu();
            }
            this.vqR.vqL.vqP.GHZ = new bnv();
            this.vqR.vqL.vqP.GHZ.hkP = paramString;
            this.vqR.vqL.vqP.GHZ.GIs = paramn;
          }
          paramn = this.vqR.vqL.vqP;
          ad.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramn != null)
          {
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vyW, paramn, null);
            this.vyW.setVisibility(0);
            this.vkT.setVisibility(8);
            this.vyZ = true;
            if (this.pfz != 2) {
              break label1317;
            }
            this.vyU.setVisibility(0);
            label926:
            paramString = (LinearLayout.LayoutParams)this.vyT.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);
            this.vyT.setLayoutParams(paramString);
            z.m(this.uGZ);
            z.m(this.mkS);
            z.m(this.vkQ);
            paramString = "";
            if (paramn.GHZ != null) {
              paramString = paramn.GHZ.hkP;
            }
            com.tencent.mm.plugin.luckymoney.a.c.br(2, paramString);
          }
          getIntent().getStringExtra("key_username");
          if (!bt.isNullOrNil(this.vqR.vqL.vqP.GHY)) {
            this.vyY = this.vqR.vqL.vqP.GHY;
          }
          if (!al.isDarkMode()) {
            break label1392;
          }
          this.lYb.setBackgroundResource(2131099663);
          al.r(this, getResources().getColor(2131099663));
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.vyV.setVisibility(0);
          z.eq(this.vyV);
          break;
          z.a(getContext(), this.vkQ, getString(2131760982, new Object[] { this.vqR.vqF }));
          break label380;
          label1144:
          this.vkR.setVisibility(8);
          if (!bt.isNullOrNil(this.vqR.vlx))
          {
            this.mkS.setText(this.vqR.vlx);
            this.mkS.setVisibility(0);
            label1188:
            if (bt.isNullOrNil(this.vqR.voc)) {
              break label1285;
            }
            this.uGZ.setText(this.vqR.voc);
            this.uGZ.setVisibility(0);
            this.uGZ.setSingleLine(false);
          }
          for (;;)
          {
            paramn = (RelativeLayout.LayoutParams)this.vkS.getLayoutParams();
            paramn.bottomMargin = BackwardSupportUtil.b.g(getContext(), 30.0F);
            this.vkS.setLayoutParams(paramn);
            bool = true;
            break;
            this.mkS.setVisibility(8);
            break label1188;
            label1285:
            this.uGZ.setVisibility(8);
          }
          label1297:
          this.vkS.setVisibility(8);
          this.vkT.setVisibility(0);
          break label668;
          label1317:
          this.vyU.setVisibility(8);
          break label926;
          label1329:
          paramString = (LinearLayout.LayoutParams)this.vyT.getLayoutParams();
          if (!bt.isNullOrNil(this.pFW)) {}
          for (paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.b.g(getContext(), 118.0F))
          {
            this.vyT.setLayoutParams(paramString);
            break;
          }
          label1392:
          this.lYb.setBackgroundResource(2131100582);
          al.r(this, getResources().getColor(2131100582));
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramn instanceof ap))
    {
      z.d(this.vkR);
      this.vkR.setClickable(true);
      dhW();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramn;
        k.a(this, k.a.vBz);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void djA()
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
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.vqy))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.DnY = true;
          paramn.b(paramString.vqy);
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.vyZ) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(991, 13);
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
        this.vkR.setBackgroundResource(2131232316);
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
          com.tencent.mm.plugin.luckymoney.a.b.a(this.vuW, paramString.vpO);
          paramn.putExtra("key_jump_from", 2);
          paramn.putExtra("key_native_url", this.vvi);
          paramn.putExtra("key_sendid", this.vuW);
          paramn.putExtra("key_anim_slide", true);
          paramn.putExtra("key_detail_emoji_md5", paramString.vqb);
          paramn.putExtra("key_detail_emoji_type", paramString.vqc);
          paramn.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramn.putExtra("key_emoji_switch", paramString.vqd);
          paramn.putExtra("key_msgid", this.fGN);
          az(paramn);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(65753);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.h.cl(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */