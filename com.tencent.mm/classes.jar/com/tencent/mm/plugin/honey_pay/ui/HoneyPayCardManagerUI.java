package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private int fzn;
  private ImageView iIS;
  private ViewGroup jds;
  private WalletTextView lkC;
  private ListView lkF;
  private ViewGroup lkG;
  private ViewGroup lkH;
  private ViewGroup lkI;
  private TextView lkJ;
  private MMSwitchBtn lkK;
  private LinearLayout lkL;
  private TextView lkM;
  private TextView lkN;
  private TextView lkO;
  private View lkP;
  private View lkQ;
  private HoneyPayCardManagerUI.a lkR;
  private List<bda> lkS = new ArrayList();
  private Bankcard lkT;
  private bek lkU;
  private bek lkV;
  private long lkW;
  private long lkX;
  private boolean lkY;
  private String lkZ;
  private String lki;
  private bya lkj;
  private TextView lkm;
  private TextView lko;
  private TextView lkp;
  private TextView lkq;
  private TextView lkr;
  
  private static Bankcard Fp(String paramString)
  {
    Object localObject1 = o.bVs();
    Object localObject2;
    if (((ag)localObject1).qjX != null)
    {
      localObject2 = ((ag)localObject1).qjX.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (Bankcard)((Iterator)localObject2).next();
      } while (!((Bankcard)localObject1).field_bindSerial.equals(paramString));
    }
    while (localObject1 == null)
    {
      localObject2 = o.bVs().qzj;
      if ((localObject2 == null) || (!((Bankcard)localObject2).field_bindSerial.equals(paramString))) {
        break;
      }
      return localObject2;
      localObject1 = null;
    }
    return localObject1;
  }
  
  private void a(bhg parambhg)
  {
    this.lkj = parambhg.tcF;
    this.lkS.clear();
    this.lkR.notifyDataSetChanged();
    Object localObject1;
    boolean bool;
    int i;
    if (parambhg.sQe != null)
    {
      setMMTitle(parambhg.sQe.imz);
      this.lkW = parambhg.sMA;
      this.lkX = parambhg.sMz;
      if (parambhg.sQe.tll != null)
      {
        this.lkT = Fp(parambhg.sQe.tll.tzu);
        this.lkU = parambhg.sQe.tll;
      }
      localObject1 = parambhg.sQe;
      Object localObject2 = e.dQ(((apg)localObject1).sMy, 6) + getString(a.i.honey_pay_max_quota_monthly);
      this.lkM.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, (CharSequence)localObject2, this.lkM.getTextSize()));
      a.b.a(this.iIS, ((apg)localObject1).sMy, 0.06F, false);
      this.lkC.setText(c.eR(((apg)localObject1).sQd));
      localObject2 = this.lkK;
      if (((apg)localObject1).qlX == 0) {
        break label513;
      }
      bool = true;
      ((MMSwitchBtn)localObject2).setCheck(bool);
      baY();
      i = parambhg.sQe.state;
      y.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      y.d(this.TAG, "state title: %s", new Object[] { parambhg.sQe.tlo });
      if (bk.bl(parambhg.sQe.tlo)) {
        break label518;
      }
      this.lkm.setText(parambhg.sQe.tlo);
      this.lkm.setVisibility(0);
      label301:
      if (bk.bl(parambhg.sQe.tlk)) {
        break label530;
      }
      this.lkO.setText(parambhg.sQe.tlk);
      this.lkO.setVisibility(0);
      label336:
      if (i != 1) {
        break label542;
      }
      this.lkm.setTextColor(Color.parseColor("#FA9D3B"));
      this.lkC.setTextColor(Color.parseColor("#B2B2B2"));
      findViewById(a.f.hpcs_date_layout).setVisibility(8);
      this.lkF.removeFooterView(this.lkG);
      this.lkG.setVisibility(8);
      this.lkP.setVisibility(8);
      if (this.lkY)
      {
        this.lkI = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_finish_layout, null));
        ((Button)this.lkI.findViewById(a.f.hpcs_finish_btn)).setOnClickListener(new HoneyPayCardManagerUI.7(this));
        this.lkF.addFooterView(this.lkI);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.lkQ.setVisibility(8);
      c.a(this, parambhg.tle, this.lki, 2, this.lkj);
      return;
      label513:
      bool = false;
      break;
      label518:
      this.lkm.setVisibility(8);
      break label301;
      label530:
      this.lkO.setVisibility(8);
      break label336;
      label542:
      if (i == 2)
      {
        if ((parambhg.ssi != null) && (!parambhg.ssi.isEmpty()))
        {
          this.lkS = parambhg.ssi;
          this.lkR.notifyDataSetChanged();
          this.lkF.removeFooterView(this.lkG);
          this.lkG.setVisibility(8);
          if (parambhg.tBP != null)
          {
            localObject1 = parambhg.tBP;
            this.lkH = ((ViewGroup)View.inflate(this, a.g.honey_pay_card_setting_footer_more_layout, null));
            ((TextView)this.lkH.findViewById(a.f.hpcm_title_tv)).setText(((ayj)localObject1).title);
            this.lkH.setOnClickListener(new HoneyPayCardManagerUI.8(this, (ayj)localObject1));
            this.lkF.addFooterView(this.lkH);
          }
          findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.honey_pay_grey_bg_1);
        }
        this.lkJ.setVisibility(0);
        this.lkC.setVisibility(0);
        this.lkP.setVisibility(0);
        findViewById(a.f.hpcs_date_layout).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.lko.setText(a.i.honey_pay_create_date_title_text);
        this.lkp.setText(a.i.honey_pay_return_date_title_text);
        this.lkq.setText(c.eS(parambhg.sQe.create_time));
        this.lkr.setText(c.eS(parambhg.sQe.ild));
        this.lkF.removeFooterView(this.lkG);
        this.lkG.setVisibility(8);
        this.lkP.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
      }
      else if (i == 4)
      {
        this.lkJ.setVisibility(8);
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.lko.setText(a.i.honey_pay_release_date_title_text);
        this.lkq.setText(c.eS(parambhg.sQe.tlm));
        findViewById(a.f.hpcs_second_date_layout).setVisibility(8);
        this.lkF.removeFooterView(this.lkG);
        this.lkG.setVisibility(8);
        this.lkP.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
        findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.white);
      }
      else
      {
        y.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private void baX()
  {
    y.i(this.TAG, "do qry detail");
    l locall = new l(this.lki);
    locall.m(this);
    a(locall, true, false);
  }
  
  private void baY()
  {
    if (this.lkU != null)
    {
      this.lkN.setText(this.lkU.tzs);
      if (!bk.bl(this.lkU.tzt))
      {
        this.lkN.setTextColor(Color.parseColor(this.lkU.tzt));
        return;
      }
      this.lkN.setTextColor(getResources().getColor(a.c.normal_text_color));
      return;
    }
    y.i(this.TAG, "reset payway view for null");
    this.lkN.setText("");
    this.lkN.setTextColor(getResources().getColor(a.c.normal_text_color));
  }
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new HoneyPayCardManagerUI.11(this, paramString)).b(new HoneyPayCardManagerUI.10(this)).c(new HoneyPayCardManagerUI.9(this));
    }
    for (;;)
    {
      return true;
      if ((paramm instanceof i))
      {
        paramString = (i)paramm;
        paramString.a(new HoneyPayCardManagerUI.14(this)).b(new HoneyPayCardManagerUI.13(this, paramString)).c(new HoneyPayCardManagerUI.12(this, paramString));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.j))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.j)paramm;
        paramString.a(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm)
          {
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.ljP.tur);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.Fq(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).tzu));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
          }
        }).b(new HoneyPayCardManagerUI.16(this)).c(new HoneyPayCardManagerUI.15(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_card_setting_ui;
  }
  
  protected final void initView()
  {
    this.jds = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_header_layout, null));
    this.lkK = ((MMSwitchBtn)this.jds.findViewById(a.f.hpcs_notify_sb));
    this.lkL = ((LinearLayout)this.jds.findViewById(a.f.hpcs_payway_layout));
    this.lkN = ((TextView)this.jds.findViewById(a.f.hpcs_payway_tv));
    this.iIS = ((ImageView)this.jds.findViewById(a.f.hpcs_avatar_iv));
    this.lkC = ((WalletTextView)this.jds.findViewById(a.f.hpcs_quota_tv));
    this.lkM = ((TextView)this.jds.findViewById(a.f.hpcs_user_name_tv));
    this.lkJ = ((TextView)this.jds.findViewById(a.f.hpcs_modify_quota_tv));
    this.lkm = ((TextView)this.jds.findViewById(a.f.hpcs_state_tv));
    this.lkO = ((TextView)this.jds.findViewById(a.f.hpcs_state_desc_tv));
    this.lko = ((TextView)this.jds.findViewById(a.f.hpcs_first_date_title_tv));
    this.lkq = ((TextView)this.jds.findViewById(a.f.hpcs_first_date_tv));
    this.lkp = ((TextView)this.jds.findViewById(a.f.hpcs_second_date_title_tv));
    this.lkr = ((TextView)this.jds.findViewById(a.f.hpcs_second_date_tv));
    this.lkP = this.jds.findViewById(a.f.hpcs_bottom_logo_iv);
    this.lkC.setPrefix(ab.cML());
    this.lkK.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void cr(boolean paramAnonymousBoolean)
      {
        int i = 1;
        y.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        HoneyPayCardManagerUI localHoneyPayCardManagerUI = HoneyPayCardManagerUI.this;
        if (paramAnonymousBoolean) {}
        for (;;)
        {
          HoneyPayCardManagerUI.a(localHoneyPayCardManagerUI, i);
          return;
          i = 0;
        }
      }
    });
    this.lkL.setOnClickListener(new HoneyPayCardManagerUI.4(this));
    String str = getString(a.i.honey_pay_max_quota_monthly);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(a.i.honey_pay_max_quota_monthly_modify));
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.m(new HoneyPayCardManagerUI.5(this)), str.length(), localSpannableStringBuilder.length(), 18);
    this.lkJ.setClickable(true);
    this.lkJ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.lkJ.setText(localSpannableStringBuilder);
    this.lkG = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_layout, null));
    this.lkQ = findViewById(a.f.hpcs_block_view);
    this.lkF = ((ListView)findViewById(a.f.hpcs_lv));
    this.lkF.addHeaderView(this.jds);
    this.lkF.addFooterView(this.lkG, null, false);
    this.lkR = new HoneyPayCardManagerUI.a(this, (byte)0);
    this.lkF.setAdapter(this.lkR);
    this.lkF.setOnItemClickListener(new HoneyPayCardManagerUI.1(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
      {
        long l = paramIntent.getLongExtra("key_credit_line", 0L);
        this.lkC.setText(c.eR(l));
        setResult(-1);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        this.mController.removeAllOptionMenu();
        setResult(-1);
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(2876);
    kh(2742);
    kh(2941);
    this.lki = getIntent().getStringExtra("key_card_no");
    this.fzn = getIntent().getIntExtra("key_scene", 0);
    this.lkY = getIntent().getBooleanExtra("key_is_create", false);
    this.lkZ = getIntent().getStringExtra("key_card_type");
    initView();
    y.d(this.TAG, "cardtype: %s", new Object[] { this.lkZ });
    setMMTitle(a.i.honey_pay_main_title);
    if (this.fzn == 1)
    {
      paramBundle = new bhg();
      try
      {
        paramBundle.aH(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        return;
      }
      catch (IOException paramBundle)
      {
        y.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        baX();
        return;
      }
    }
    baX();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2876);
    ki(2742);
    ki(2941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */