package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.luckymoney.hk.a.c;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.model.g;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKReceiveUI
  extends LuckyMoneyBaseUI
{
  private static final String KqL;
  private String IEA;
  private TextView JCr;
  private ImageView KmZ;
  private TextView KnP;
  private Button KnQ;
  private ImageView KnR;
  private View KnS;
  private ImageView KnT;
  private TextView KnU;
  private ImageView KpY;
  private String KqM;
  private LinearLayout KqR;
  private TextView KqS;
  private View KqT;
  private ImageView KqU;
  private RelativeLayout KqV;
  private BaseEmojiView KqW;
  private TextView KqX;
  private LinearLayout KqY;
  private ProgressBar KqZ;
  private String Kra;
  private int Krb;
  private ad Krc = null;
  public int Krd = 0;
  private c Kre;
  private long lul;
  private int maxSize = 0;
  private TextView tHK;
  private int textSize = 0;
  private w tipDialog = null;
  private ViewGroup tth;
  
  static
  {
    AppMethodBeat.i(283904);
    KqL = MMApplicationContext.getContext().getResources().getString(a.i.wallet_unknown_err);
    AppMethodBeat.o(283904);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(283853);
    if (this.KnQ == null)
    {
      AppMethodBeat.o(283853);
      return;
    }
    d.MtP.aeR(this.KnQ.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(283853);
      return;
    }
    this.KnQ.setBackgroundResource(a.e.lucky_money_send_btn);
    this.KnQ.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(283853);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(283917);
    this.KqT = findViewById(a.f.lucky_money_receive_test_ll);
    this.tth = ((ViewGroup)findViewById(a.f.lucky_money_receive_root_view));
    this.KqR = ((LinearLayout)findViewById(a.f.lucky_money_sender_detail_ll));
    this.KmZ = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.KnP = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.tHK = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.KqV = ((RelativeLayout)findViewById(a.f.lucky_money_emoji_layout));
    this.KqW = ((BaseEmojiView)findViewById(a.f.lucky_money_emoji));
    this.KqX = ((TextView)findViewById(a.f.lucky_money_reload_emoji));
    this.KqY = ((LinearLayout)findViewById(a.f.lucky_money_loading_emoji_area));
    this.KqZ = ((ProgressBar)findViewById(a.f.emoji_loading_image));
    this.KnQ = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.KnR = ((ImageView)findViewById(a.f.lucky_money_recieve_open_animateview));
    this.KnU = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.KnS = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.KnT = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    this.KqU = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_iv));
    this.KqS = ((TextView)findViewById(a.f.lucky_money_recieve_temp_label_tv));
    this.KpY = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.KpY.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(283832);
        LuckyMoneyHKReceiveUI.this.finish();
        AppMethodBeat.o(283832);
      }
    });
    this.tHK.setLines(2);
    j.c(this.tHK);
    this.maxSize = ((int)(com.tencent.mm.cd.a.bs(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize) * 1.125F));
    this.textSize = com.tencent.mm.cd.a.br(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    if (this.textSize > this.maxSize) {}
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      fWC();
      AppMethodBeat.o(283917);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283909);
    fixStatusbar(true);
    this.KzE = false;
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.transparent));
    }
    this.Kra = getIntent().getStringExtra("key_native_url");
    this.lul = getIntent().getLongExtra("key_msgid", 0L);
    this.Krb = getIntent().getIntExtra("key_way", 0);
    paramBundle = Uri.parse(Util.nullAsNil(this.Kra));
    try
    {
      this.KqM = paramBundle.getQueryParameter("sendid");
      initView();
      Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb: %s, %s", new Object[] { this.Kra, this.KqM });
      if (this.Kre != null) {
        this.Kre.cancel();
      }
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = com.tencent.mm.ui.base.k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(283830);
          if ((LuckyMoneyHKReceiveUI.g(LuckyMoneyHKReceiveUI.this) != null) && (LuckyMoneyHKReceiveUI.g(LuckyMoneyHKReceiveUI.this).isShowing())) {
            LuckyMoneyHKReceiveUI.g(LuckyMoneyHKReceiveUI.this).dismiss();
          }
          LuckyMoneyHKReceiveUI.h(LuckyMoneyHKReceiveUI.this).cancel();
          LuckyMoneyHKReceiveUI.this.finish();
          AppMethodBeat.o(283830);
        }
      });
      this.Kre = new c(this.Kra, this.KqM, this.Krb);
      this.Kre.bFJ().b(new com.tencent.mm.vending.c.a() {}).a(this);
      AppMethodBeat.o(283909);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(283920);
    super.onDestroy();
    AppMethodBeat.o(283920);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI
 * JD-Core Version:    0.7.0.1
 */