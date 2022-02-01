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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.hk.a.c;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.g;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKReceiveUI
  extends LuckyMoneyBaseUI
{
  private static final String yUb;
  private long gof;
  private int maxSize = 0;
  private TextView nAB;
  private ViewGroup nmW;
  private int textSize = 0;
  private com.tencent.mm.ui.base.q tipDialog = null;
  private String xGm;
  private ImageView yQt;
  private TextView yRk;
  private Button yRl;
  private View yRm;
  private ImageView yRn;
  private TextView yRo;
  private ImageView yTs;
  private String yUc;
  private LinearLayout yUh;
  private TextView yUi;
  private View yUj;
  private ImageView yUk;
  private RelativeLayout yUl;
  private BaseEmojiView yUm;
  private TextView yUn;
  private LinearLayout yUo;
  private ProgressBar yUp;
  private String yUq;
  private int yUr;
  private ae yUs = null;
  public int yUt = 0;
  private c yUu;
  private TextView yln;
  
  static
  {
    AppMethodBeat.i(213300);
    yUb = MMApplicationContext.getContext().getResources().getString(2131768354);
    AppMethodBeat.o(213300);
  }
  
  private void eeN()
  {
    AppMethodBeat.i(213293);
    if (this.yRl == null)
    {
      AppMethodBeat.o(213293);
      return;
    }
    d.AEF.TL(this.yRl.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(213293);
      return;
    }
    this.yRl.setBackgroundResource(2131233788);
    this.yRl.setText(2131762695);
    AppMethodBeat.o(213293);
  }
  
  public int getLayoutId()
  {
    return 2131495382;
  }
  
  public void initView()
  {
    AppMethodBeat.i(213291);
    this.yUj = findViewById(2131304246);
    this.nmW = ((ViewGroup)findViewById(2131304243));
    this.yUh = ((LinearLayout)findViewById(2131304267));
    this.yQt = ((ImageView)findViewById(2131304244));
    this.yRk = ((TextView)findViewById(2131304245));
    this.nAB = ((TextView)findViewById(2131304247));
    this.yln = ((TextView)findViewById(2131304251));
    this.yUl = ((RelativeLayout)findViewById(2131304102));
    this.yUm = ((BaseEmojiView)findViewById(2131304098));
    this.yUn = ((TextView)findViewById(2131304266));
    this.yUo = ((LinearLayout)findViewById(2131304151));
    this.yUp = ((ProgressBar)findViewById(2131299998));
    this.yRl = ((Button)findViewById(2131304255));
    this.yRo = ((TextView)findViewById(2131304252));
    this.yRm = findViewById(2131304253);
    this.yRn = ((ImageView)findViewById(2131304018));
    this.yUk = ((ImageView)findViewById(2131304238));
    this.yUi = ((TextView)findViewById(2131304256));
    this.yTs = ((ImageView)findViewById(2131304254));
    this.yTs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213281);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyHKReceiveUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213281);
      }
    });
    this.nAB.setLines(2);
    android.support.v4.widget.q.d(this.nAB);
    this.maxSize = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131166624) * 1.125F));
    this.textSize = com.tencent.mm.cb.a.aG(getContext(), 2131166624);
    if (this.textSize > this.maxSize) {}
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      eeN();
      AppMethodBeat.o(213291);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213290);
    fixStatusbar(true);
    this.zbY = false;
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131101287));
    }
    this.yUq = getIntent().getStringExtra("key_native_url");
    this.gof = getIntent().getLongExtra("key_msgid", 0L);
    this.yUr = getIntent().getIntExtra("key_way", 0);
    paramBundle = Uri.parse(Util.nullAsNil(this.yUq));
    try
    {
      this.yUc = paramBundle.getQueryParameter("sendid");
      initView();
      Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb: %s, %s", new Object[] { this.yUq, this.yUc });
      if (this.yUu != null) {
        this.yUu.cancel();
      }
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(getContext(), 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(213286);
          if ((LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this) != null) && (LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this).isShowing())) {
            LuckyMoneyHKReceiveUI.f(LuckyMoneyHKReceiveUI.this).dismiss();
          }
          LuckyMoneyHKReceiveUI.g(LuckyMoneyHKReceiveUI.this).cancel();
          LuckyMoneyHKReceiveUI.this.finish();
          AppMethodBeat.o(213286);
        }
      });
      this.yUu = new c(this.yUq, this.yUc, this.yUr);
      this.yUu.aYI().b(new com.tencent.mm.vending.c.a() {}).a(this);
      AppMethodBeat.o(213290);
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
    AppMethodBeat.i(213292);
    super.onDestroy();
    AppMethodBeat.o(213292);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI
 * JD-Core Version:    0.7.0.1
 */