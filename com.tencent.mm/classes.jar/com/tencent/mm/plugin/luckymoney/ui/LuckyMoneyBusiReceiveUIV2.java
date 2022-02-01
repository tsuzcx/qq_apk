package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.e.a;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class LuckyMoneyBusiReceiveUIV2
  extends LuckyMoneyBaseUI
{
  private static final String KqL;
  private String IEA;
  private TextView JCr;
  private int KAo;
  private int KAq = 0;
  private an KAr;
  private WeImageView KAx;
  private ImageView KAy;
  private ImageView KmZ;
  private TextView KnP;
  private Button KnQ;
  private ImageView KnR;
  private View KnS;
  private TextView KnU;
  private String KqM = null;
  private LinearLayout KqR;
  private TextView KqS;
  private View KqT;
  private ImageView KqU;
  private String Kra = null;
  private int KzV = 0;
  private long lul;
  private TextView tHK;
  private w tipDialog = null;
  private ViewGroup tth;
  private int xdN;
  
  static
  {
    AppMethodBeat.i(284492);
    KqL = MMApplicationContext.getContext().getResources().getString(a.i.wallet_unknown_err);
    AppMethodBeat.o(284492);
  }
  
  private void b(czi paramczi)
  {
    AppMethodBeat.i(284466);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "render envelope");
    ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.KqU, paramczi, null);
    this.KqU.setVisibility(0);
    if (this.xdN == 2) {
      this.KqS.setVisibility(0);
    }
    for (;;)
    {
      Object localObject = (LinearLayout.LayoutParams)this.KqR.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);
      this.KqR.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ah.z(this.JCr);
      ah.z(this.tHK);
      ah.z(this.KnP);
      localObject = "";
      if (paramczi.aaEq != null) {
        localObject = paramczi.aaEq.nBe;
      }
      com.tencent.mm.plugin.luckymoney.a.c.cg(2, (String)localObject);
      if ((Util.isNullOrNil(paramczi.aaEq.aaEP)) || (Util.isNullOrNil(paramczi.aaEq.aaEQ))) {
        break;
      }
      this.KAy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284487);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LuckyMoneyBusiReceiveUIV2.h(LuckyMoneyBusiReceiveUIV2.this).getLayoutParams();
          localLayoutParams.width = ((int)(LuckyMoneyBusiReceiveUIV2.i(LuckyMoneyBusiReceiveUIV2.this).getWidth() * 1.1F));
          localLayoutParams.height = ((int)(localLayoutParams.width * 1.72F));
          LuckyMoneyBusiReceiveUIV2.h(LuckyMoneyBusiReceiveUIV2.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(284487);
        }
      });
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).b(this.KAy, paramczi, null);
      this.KAy.setVisibility(0);
      ah.hZ(this.KAy);
      paramczi = (ViewGroup.MarginLayoutParams)this.KAx.getLayoutParams();
      if (paramczi != null)
      {
        paramczi.topMargin = 0;
        this.KAx.setLayoutParams(paramczi);
      }
      AppMethodBeat.o(284466);
      return;
      this.KqS.setVisibility(8);
    }
    this.KAy.setVisibility(8);
    paramczi = (ViewGroup.MarginLayoutParams)this.KAx.getLayoutParams();
    if (paramczi != null)
    {
      paramczi.topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
      this.KAx.setLayoutParams(paramczi);
    }
    AppMethodBeat.o(284466);
  }
  
  private void ck(int paramInt, String paramString)
  {
    AppMethodBeat.i(284461);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "finishByResult resultCode: %d  errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(284461);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(284451);
    if (this.KnQ == null)
    {
      AppMethodBeat.o(284451);
      return;
    }
    d.MtP.aeR(this.KnQ.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(284451);
      return;
    }
    this.KnQ.setBackgroundResource(a.e.lucky_money_send_btn);
    this.KnQ.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(284451);
  }
  
  private void fYj()
  {
    AppMethodBeat.i(284447);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "do receive hb");
    fWC();
    if (this.KAr == null)
    {
      Log.e("MicroMsg.LuckyMoneyBusiReceiveUIV2", "ReceiveScene == null");
      ck(0, "");
      AppMethodBeat.o(284447);
      return;
    }
    if (this.KAr.ihA == 2)
    {
      doSceneProgress(new aq(this.KqM, 11, 0, this.Kra, "v1.0"), false);
      AppMethodBeat.o(284447);
      return;
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.hide();
    }
    ah.s(this.KmZ, this.KAr.KtX);
    ah.a(getContext(), this.KnP, this.KAr.KtM);
    int i;
    label357:
    Object localObject;
    if ((this.KAr.ihA != 1) && (this.KAr.ihz != 4) && (this.KAr.ihz != 5) && (this.KAr.ihz != 1))
    {
      if (!Util.isNullOrNil(this.KAr.KrL))
      {
        this.tHK.setText(this.KAr.KrL);
        this.tHK.setVisibility(0);
      }
      if (!Util.isNullOrNil(this.KAr.KtY))
      {
        ah.a(getContext(), this.JCr, this.KAr.KtY);
        this.JCr.setVisibility(0);
        this.tHK.setVisibility(8);
      }
      this.KnQ.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284472);
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "open btn click");
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          LuckyMoneyBusiReceiveUIV2.e(LuckyMoneyBusiReceiveUIV2.this).setClickable(false);
          LuckyMoneyBusiReceiveUIV2.f(LuckyMoneyBusiReceiveUIV2.this);
          AppMethodBeat.o(284472);
        }
      });
      i = 0;
      if ((!z.bAM().equals(this.IEA)) && ((this.KAq != 1) || (i == 0))) {
        break label669;
      }
      if (this.KAq == 1) {
        this.KnU.setText(a.i.lucky_money_detail_luck);
      }
      this.KnS.setVisibility(0);
      this.KnS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284499);
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "go luckymoney detail - receive");
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          paramAnonymousView = LuckyMoneyBusiReceiveUIV2.this.getIntent();
          if (paramAnonymousView == null) {
            paramAnonymousView = new Intent();
          }
          for (;;)
          {
            paramAnonymousView.setClass(LuckyMoneyBusiReceiveUIV2.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            paramAnonymousView.putExtra("key_native_url", LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this));
            paramAnonymousView.putExtra("key_sendid", LuckyMoneyBusiReceiveUIV2.g(LuckyMoneyBusiReceiveUIV2.this).CAf);
            paramAnonymousView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUIV2.b(LuckyMoneyBusiReceiveUIV2.this));
            paramAnonymousView.putExtra("key_lucky_money_can_received", true);
            paramAnonymousView.putExtra("key_username", LuckyMoneyBusiReceiveUIV2.c(LuckyMoneyBusiReceiveUIV2.this));
            paramAnonymousView.putExtra("key_msgid", LuckyMoneyBusiReceiveUIV2.d(LuckyMoneyBusiReceiveUIV2.this));
            paramAnonymousView.putExtra("key_hb_kind", 2);
            LuckyMoneyBusiReceiveUIV2 localLuckyMoneyBusiReceiveUIV2 = LuckyMoneyBusiReceiveUIV2.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyBusiReceiveUIV2, paramAnonymousView.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2$7", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLuckyMoneyBusiReceiveUIV2.startActivity((Intent)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyBusiReceiveUIV2, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2$7", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this, -1, "");
            AppMethodBeat.o(284499);
            return;
          }
        }
      });
      localObject = getIntent().getStringExtra("key_receive_envelope_url");
      String str1 = getIntent().getStringExtra("key_receive_envelope_md5");
      String str2 = getIntent().getStringExtra("key_receive_envelope_widget_url");
      String str3 = getIntent().getStringExtra("key_receive_envelope_widget_md5");
      if (Util.isNullOrNil((String)localObject)) {
        break label681;
      }
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "has envelopeUrl");
      czi localczi = new czi();
      localczi.aaEq = new czj();
      localczi.aaEq.nBe = ((String)localObject);
      localczi.aaEq.aaEM = str1;
      localczi.aaEq.aaEP = str2;
      localczi.aaEq.aaEQ = str3;
      b(localczi);
    }
    for (;;)
    {
      fYk();
      this.KqT.setVisibility(0);
      ah.hZ(this.KqT);
      AppMethodBeat.o(284447);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
      this.KnQ.setVisibility(8);
      this.KnR.setVisibility(8);
      if (!Util.isNullOrNil(this.KAr.KrL))
      {
        this.JCr.setText(this.KAr.KrL);
        this.JCr.setVisibility(0);
        this.JCr.setSingleLine(false);
      }
      for (;;)
      {
        localObject = (RelativeLayout.LayoutParams)this.KnS.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
        this.KnS.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = 1;
        break;
        this.JCr.setVisibility(8);
      }
      label669:
      this.KnS.setVisibility(8);
      break label357;
      label681:
      localObject = (LinearLayout.LayoutParams)this.KqR.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 118.0F);
      this.KqR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void fYk()
  {
    AppMethodBeat.i(284455);
    if (aw.isDarkMode())
    {
      this.tth.setBackgroundResource(a.c.BW_0_Alpha_0_8);
      aw.t(this, getResources().getColor(a.c.BW_0_Alpha_0_8));
    }
    for (;;)
    {
      getContentView().setVisibility(0);
      AppMethodBeat.o(284455);
      return;
      this.tth.setBackgroundResource(a.c.lucky_money_goldstyle_receive_bg_color_new);
      aw.t(this, getResources().getColor(a.c.lucky_money_goldstyle_receive_bg_color_new));
    }
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(284510);
    this.KqT = findViewById(a.f.lucky_money_receive_test_ll);
    this.tth = ((ViewGroup)findViewById(a.f.lucky_money_receive_root_view));
    this.KqR = ((LinearLayout)findViewById(a.f.lucky_money_sender_detail_ll));
    this.KmZ = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.KnP = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.tHK = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.KnU = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.KnS = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.KnQ = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.KnR = ((ImageView)findViewById(a.f.lucky_money_recieve_open_animateview));
    this.KAx = ((WeImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.KAx.setEnableColorFilter(false);
    this.KAx.setImageResource(a.e.lucky_money_close_btn);
    this.KAx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284512);
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "click close btn");
        LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this, 0, "click close btn");
        AppMethodBeat.o(284512);
      }
    });
    this.KqU = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_iv));
    this.KqS = ((TextView)findViewById(a.f.lucky_money_recieve_temp_label_tv));
    this.KAy = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_widget));
    this.tHK.setLines(2);
    androidx.core.widget.j.c(this.tHK);
    getContentView().setVisibility(8);
    AppMethodBeat.o(284510);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284502);
    fixStatusbar(true);
    this.KzE = false;
    overridePendingTransition(0, 0);
    setTheme(a.j.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.transparent));
    this.Kra = getIntent().getStringExtra("key_native_url");
    this.lul = getIntent().getLongExtra("key_msgid", 0L);
    this.KAo = getIntent().getIntExtra("key_way", 5);
    this.KzV = getIntent().getIntExtra("key_static_from_scene", 0);
    this.IEA = getIntent().getStringExtra("key_username");
    this.KqM = getIntent().getStringExtra("key_sendid");
    this.KAq = getIntent().getIntExtra("key_type", 0);
    this.xdN = getIntent().getIntExtra("key_material_flag", 0);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "mSendId：%s, nativeurl：%s  mWay：%s mSenderName：%s", new Object[] { this.KqM, this.Kra, Integer.valueOf(this.KAo), this.IEA });
    paramBundle = getIntent().getStringExtra("key_lucky_money_busi_receive_resp");
    if (Util.isNullOrNil(paramBundle))
    {
      Log.e("MicroMsg.LuckyMoneyBusiReceiveUIV2", "respStr is null");
      ck(0, "");
    }
    for (;;)
    {
      initView();
      fYj();
      AppMethodBeat.o(284502);
      return;
      try
      {
        this.KAr = ae.by(new JSONObject(paramBundle));
        this.KAr.ihx = this.Kra;
        this.KAr.KtW = this.KAo;
        this.KAr.CAf = this.KqM;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          Log.e("MicroMsg.LuckyMoneyBusiReceiveUIV2", "parse failed :%s", new Object[] { paramBundle.toString() });
          ck(0, "");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(284536);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(284536);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(284531);
    if ((paramIntent != null) && (paramIntent.hasExtra("key_is_realname_verify_process")))
    {
      if (paramIntent.getIntExtra("realname_verify_process_ret", 0) == -1)
      {
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "new intent from realname verify process：succ");
        fYj();
        AppMethodBeat.o(284531);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "new intent from realname verify process：cancel");
      ck(-1, "");
    }
    AppMethodBeat.o(284531);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(284528);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "onsceneend, errtype: %s, errcode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof an))
    {
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "do receive hb resp");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (Util.isNullOrNil(paramString)) {
          break label1397;
        }
        paramp = paramString;
        label70:
        com.tencent.mm.ui.base.k.cZ(this, paramp);
        if (Util.isNullOrNil(paramString)) {
          break label1405;
        }
      }
    }
    for (;;)
    {
      ck(2, paramString);
      AppMethodBeat.o(284528);
      return false;
      if ((paramp instanceof am))
      {
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "do open hb resp");
        this.KnQ.setVisibility(0);
        ah.o(this.KnR);
        this.KnQ.setClickable(true);
        fWC();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          l.play(getContext(), a.i.lucky_cashrecivedrevised);
          final am localam = (am)paramp;
          paramString = new ad();
          paramString.field_mNativeUrl = this.Kra;
          paramString.field_hbType = localam.KtU.ihy;
          paramString.field_receiveAmount = localam.KtU.ihV;
          paramString.field_receiveTime = System.currentTimeMillis();
          paramString.field_hbStatus = localam.KtU.ihz;
          paramString.field_receiveStatus = localam.KtU.ihA;
          if (paramString.field_receiveAmount > 0L) {
            u.iiy().a(paramString);
          }
          if (com.tencent.mm.plugin.wallet_core.utils.j.a(localam.KtV))
          {
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "should intercept");
            setContentViewVisibility(8);
            new com.tencent.mm.plugin.wallet_core.utils.j(this).a(localam.KtV, new j.a()
            {
              public final void a(dfc paramAnonymousdfc)
              {
                AppMethodBeat.i(284498);
                Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "click intercept button");
                LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this, -1, "");
                AppMethodBeat.o(284498);
              }
            });
            AppMethodBeat.o(284528);
            return true;
          }
          if (localam.ihA == 2)
          {
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "go luckymoney detail - open");
            paramp = getIntent();
            paramString = paramp;
            if (paramp == null) {
              paramString = new Intent();
            }
            paramString.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
            paramString.putExtra("key_lucky_money_can_received", true);
            b.a(this.KqM, localam.KtU);
            paramString.putExtra("key_jump_from", 2);
            paramString.putExtra("key_native_url", this.Kra);
            paramString.putExtra("key_sendid", localam.CAf);
            paramString.putExtra("key_static_from_scene", this.KzV);
            paramString.putExtra("key_hb_kind", 2);
            if (i.aRC().getInt("PlayCoinSound", 0) > 0) {
              paramString.putExtra("play_sound", true);
            }
            if (localam.Koa != null) {
              paramString.putExtra("key_realname_guide_helper", localam.Koa);
            }
            paramString.putExtra("key_username", this.IEA);
            paramString.putExtra("key_msgid", this.lul);
            com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ck(-1, "");
          }
          for (;;)
          {
            AppMethodBeat.o(284528);
            return true;
            this.KnQ.setBackgroundResource(a.e.lucky_money_receive_open_disabled_btn);
            this.KnQ.setText(a.i.lucky_money_open);
            this.KnQ.setOnClickListener(null);
            this.KnQ.setVisibility(8);
            this.KnR.setVisibility(8);
            if (!Util.isNullOrNil(localam.KtU.Kov))
            {
              this.tHK.setText(localam.KtU.Kov);
              this.tHK.setVisibility(0);
            }
            for (;;)
            {
              this.JCr.setText(localam.KtU.KrL);
              paramString = (RelativeLayout.LayoutParams)this.KnS.getLayoutParams();
              paramString.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
              this.KnS.setLayoutParams(paramString);
              if ((!z.bAM().equals(this.IEA)) && (this.KAq != 1)) {
                break label833;
              }
              this.KnS.setVisibility(0);
              this.KnS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymousView)
                {
                  AppMethodBeat.i(284527);
                  Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "go luckymoney detail mCheckDetailLl");
                  paramAnonymousView = LuckyMoneyBusiReceiveUIV2.this.getIntent();
                  if (paramAnonymousView == null) {
                    paramAnonymousView = new Intent();
                  }
                  for (;;)
                  {
                    paramAnonymousView.setClass(LuckyMoneyBusiReceiveUIV2.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                    paramAnonymousView.putExtra("key_lucky_money_can_received", true);
                    paramAnonymousView.putExtra("key_native_url", LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this));
                    paramAnonymousView.putExtra("key_sendid", localam.CAf);
                    paramAnonymousView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUIV2.b(LuckyMoneyBusiReceiveUIV2.this));
                    paramAnonymousView.putExtra("key_username", LuckyMoneyBusiReceiveUIV2.c(LuckyMoneyBusiReceiveUIV2.this));
                    paramAnonymousView.putExtra("key_hb_kind", 2);
                    paramAnonymousView.putExtra("key_msgid", LuckyMoneyBusiReceiveUIV2.d(LuckyMoneyBusiReceiveUIV2.this));
                    LuckyMoneyBusiReceiveUIV2 localLuckyMoneyBusiReceiveUIV2 = LuckyMoneyBusiReceiveUIV2.this;
                    paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyBusiReceiveUIV2, paramAnonymousView.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2$3", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    localLuckyMoneyBusiReceiveUIV2.startActivity((Intent)paramAnonymousView.sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyBusiReceiveUIV2, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2$3", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    LuckyMoneyBusiReceiveUIV2.a(LuckyMoneyBusiReceiveUIV2.this, -1, "");
                    AppMethodBeat.o(284527);
                    return;
                  }
                }
              });
              break;
              this.tHK.setVisibility(8);
            }
            label833:
            this.KnS.setVisibility(8);
          }
        }
        if (paramInt2 == 416)
        {
          Log.e("MicroMsg.LuckyMoneyBusiReceiveUIV2", "go to real name");
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUPayUI");
          paramString.putString("realname_verify_process_jump_plugin", "wallet_payu");
          this.KnQ.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
          boolean bool = ah.a(this, paramInt2, paramp, paramString, false, new DialogInterface.OnClickListener()new e.a
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(284520);
              Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "click btn");
              AppMethodBeat.o(284520);
            }
          }, new e.a()
          {
            public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              AppMethodBeat.i(284478);
              Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "click onProcessEnd");
              AppMethodBeat.o(284478);
              return null;
            }
          }, 1005);
          AppMethodBeat.o(284528);
          return bool;
        }
        Log.e("MicroMsg.LuckyMoneyBusiReceiveUIV2", "do open hb fail", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (!Util.isNullOrNil(paramString))
        {
          paramp = paramString;
          com.tencent.mm.ui.base.k.cZ(this, paramp);
          if (Util.isNullOrNil(paramString)) {
            break label1033;
          }
        }
        for (;;)
        {
          ck(2, paramString);
          AppMethodBeat.o(284528);
          return true;
          paramp = KqL;
          break;
          label1033:
          paramString = KqL;
        }
      }
      if (!(paramp instanceof aq)) {
        break;
      }
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "do detail hb resp");
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUIV2", "go luckymoney detail - detail");
        paramString = (aq)paramp;
        b.a(this.KqM, paramString.KtU);
        paramp = getIntent();
        paramString = paramp;
        if (paramp == null) {
          paramString = new Intent();
        }
        paramString.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramString.putExtra("key_lucky_money_can_received", true);
        paramString.putExtra("key_jump_from", 2);
        paramString.putExtra("key_native_url", this.Kra);
        paramString.putExtra("key_sendid", this.KqM);
        paramString.putExtra("key_anim_slide", true);
        paramString.putExtra("key_username", this.IEA);
        paramString.putExtra("key_way", this.KAo);
        paramString.putExtra("key_msgid", this.lul);
        paramString.putExtra("key_static_from_scene", this.KzV);
        paramString.putExtra("key_hb_kind", 2);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUIV2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramInt1 = -1;
        paramp = "";
        ck(paramInt1, paramp);
        AppMethodBeat.o(284528);
        return true;
      }
      if (!Util.isNullOrNil(paramString)) {}
      for (paramp = paramString;; paramp = KqL)
      {
        com.tencent.mm.ui.base.k.cZ(this, paramp);
        paramInt2 = 2;
        paramInt1 = paramInt2;
        paramp = paramString;
        if (!Util.isNullOrNil(paramString)) {
          break;
        }
        paramp = KqL;
        paramInt1 = paramInt2;
        break;
      }
      label1397:
      paramp = KqL;
      break label70;
      label1405:
      paramString = KqL;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUIV2
 * JD-Core Version:    0.7.0.1
 */