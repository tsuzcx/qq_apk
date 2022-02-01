package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.app.Activity;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cw.f;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.hk.a.c;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.g;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKReceiveUI
  extends LuckyMoneyBaseUI
{
  private static final String ExY;
  private String CKp;
  private TextView DLp;
  private ImageView Eus;
  private TextView Evi;
  private Button Evj;
  private View Evk;
  private ImageView Evl;
  private TextView Evm;
  private String ExZ;
  private ImageView Exp;
  private LinearLayout Eye;
  private TextView Eyf;
  private View Eyg;
  private ImageView Eyh;
  private RelativeLayout Eyi;
  private BaseEmojiView Eyj;
  private TextView Eyk;
  private LinearLayout Eyl;
  private ProgressBar Eym;
  private String Eyn;
  private int Eyo;
  private af Eyp = null;
  public int Eyq = 0;
  private c Eyr;
  private long iSo;
  private int maxSize = 0;
  private TextView qCM;
  private ViewGroup qoE;
  private int textSize = 0;
  private s tipDialog = null;
  
  static
  {
    AppMethodBeat.i(247123);
    ExY = MMApplicationContext.getContext().getResources().getString(a.i.wallet_unknown_err);
    AppMethodBeat.o(247123);
  }
  
  private void eOi()
  {
    AppMethodBeat.i(247086);
    if (this.Evj == null)
    {
      AppMethodBeat.o(247086);
      return;
    }
    d.GxJ.aay(this.Evj.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(247086);
      return;
    }
    this.Evj.setBackgroundResource(a.e.lucky_money_send_btn);
    this.Evj.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(247086);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(247081);
    this.Eyg = findViewById(a.f.lucky_money_receive_test_ll);
    this.qoE = ((ViewGroup)findViewById(a.f.lucky_money_receive_root_view));
    this.Eye = ((LinearLayout)findViewById(a.f.lucky_money_sender_detail_ll));
    this.Eus = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.Evi = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.qCM = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.DLp = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.Eyi = ((RelativeLayout)findViewById(a.f.lucky_money_emoji_layout));
    this.Eyj = ((BaseEmojiView)findViewById(a.f.lucky_money_emoji));
    this.Eyk = ((TextView)findViewById(a.f.lucky_money_reload_emoji));
    this.Eyl = ((LinearLayout)findViewById(a.f.lucky_money_loading_emoji_area));
    this.Eym = ((ProgressBar)findViewById(a.f.emoji_loading_image));
    this.Evj = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.Evm = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.Evk = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.Evl = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    this.Eyh = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_iv));
    this.Eyf = ((TextView)findViewById(a.f.lucky_money_recieve_temp_label_tv));
    this.Exp = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.Exp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277438);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LuckyMoneyHKReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277438);
      }
    });
    this.qCM.setLines(2);
    i.c(this.qCM);
    this.maxSize = ((int)(com.tencent.mm.ci.a.aZ(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize) * 1.125F));
    this.textSize = com.tencent.mm.ci.a.aY(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    if (this.textSize > this.maxSize) {}
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      eOi();
      AppMethodBeat.o(247081);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(247078);
    fixStatusbar(true);
    this.EGv = false;
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.transparent));
    }
    this.Eyn = getIntent().getStringExtra("key_native_url");
    this.iSo = getIntent().getLongExtra("key_msgid", 0L);
    this.Eyo = getIntent().getIntExtra("key_way", 0);
    paramBundle = Uri.parse(Util.nullAsNil(this.Eyn));
    try
    {
      this.ExZ = paramBundle.getQueryParameter("sendid");
      initView();
      Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb: %s, %s", new Object[] { this.Eyn, this.ExZ });
      if (this.Eyr != null) {
        this.Eyr.cancel();
      }
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(276407);
          if ((LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this) != null) && (LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this).isShowing())) {
            LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this).dismiss();
          }
          LuckyMoneyHKReceiveUI.g(LuckyMoneyHKReceiveUI.this).cancel();
          LuckyMoneyHKReceiveUI.this.finish();
          AppMethodBeat.o(276407);
        }
      });
      this.Eyr = new c(this.Eyn, this.ExZ, this.Eyo);
      this.Eyr.bhW().b(new com.tencent.mm.vending.c.a() {}).a(this);
      AppMethodBeat.o(247078);
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
    AppMethodBeat.i(247083);
    super.onDestroy();
    AppMethodBeat.o(247083);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI
 * JD-Core Version:    0.7.0.1
 */