package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout llC;
  private ImageView llD;
  private RelativeLayout llE;
  private Button llF;
  private LinearLayout llG;
  private TextView llH;
  private ArrayList<HoneyPayCardLayout> llI = new ArrayList();
  
  private void H(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    y.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      b(str, true, paramIntent);
    }
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    y.i(this.TAG, "go to card manager: %s", new Object[] { paramString1 });
    Intent localIntent = new Intent(this, HoneyPayCardManagerUI.class);
    localIntent.putExtra("key_card_no", paramString1);
    localIntent.putExtra("key_scene", 0);
    localIntent.putExtra("key_is_create", paramBoolean);
    localIntent.putExtra("key_card_type", paramString2);
    startActivityForResult(localIntent, 3);
  }
  
  private void gL(boolean paramBoolean)
  {
    y.i(this.TAG, "get payer list");
    f localf = new f();
    localf.m(this);
    a(localf, paramBoolean, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof f))
    {
      paramString = (f)paramm;
      paramString.a(new HoneyPayMainUI.10(this, paramString)).b(new HoneyPayMainUI.9(this)).c(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          h.nFQ.h(875L, 1L, 1L);
        }
      });
    }
    for (;;)
    {
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.a))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.a)paramm;
        paramString.a(new HoneyPayMainUI.13(this, paramString)).b(new HoneyPayMainUI.12(this, paramString)).c(new HoneyPayMainUI.11(this));
      }
      else if ((paramm instanceof b))
      {
        paramString = (b)paramm;
        paramString.a(new HoneyPayMainUI.3(this, paramString)).b(new HoneyPayMainUI.2(this)).c(new HoneyPayMainUI.14(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_main_ui;
  }
  
  protected final void initView()
  {
    this.llG = ((LinearLayout)findViewById(a.f.hpmu_content_layout));
    this.llE = ((RelativeLayout)findViewById(a.f.hpou_empty_header_layout));
    this.llD = ((ImageView)findViewById(a.f.hpou_empty_header_iv));
    this.llF = ((Button)findViewById(a.f.hpou_empty_add_friend_btn));
    this.llH = ((TextView)findViewById(a.f.hpou_empty_header_tv));
    this.llC = ((LinearLayout)findViewById(a.f.hpou_add_friend_layout));
    this.llC.setOnClickListener(new HoneyPayMainUI.1(this));
    this.llF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
      }
    });
    ti localti = new ti();
    localti.ccU.bso = "14";
    localti.bFJ = new HoneyPayMainUI.4(this, localti);
    com.tencent.mm.sdk.b.a.udP.m(localti);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3) {
      gL(false);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    kh(2725);
    kh(2618);
    kh(2926);
    H(getIntent());
    initView();
    gL(true);
    setMMTitle("");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2725);
    ki(2618);
    ki(2926);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i(this.TAG, "on new intent");
    H(paramIntent);
    super.onNewIntent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */