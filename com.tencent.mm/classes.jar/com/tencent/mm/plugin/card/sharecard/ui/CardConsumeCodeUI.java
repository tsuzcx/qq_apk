package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class CardConsumeCodeUI
  extends DrawStatusBarActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int drX = 3;
  private Vibrator ibr;
  private com.tencent.mm.plugin.card.base.b ikk;
  private LinearLayout ipA;
  private ImageView ipB;
  private View ipC;
  private LinearLayout ipD;
  private View ipE;
  private TextView ipF;
  private TextView ipG;
  private TextView ipH;
  private boolean ipI = false;
  private String ipu;
  private int ipv = 3;
  private int ipw = 0;
  private a ipx;
  private TextView ipy;
  private TextView ipz;
  
  public final void azP()
  {
    this.ipx.aAW();
  }
  
  public final void azU()
  {
    this.ibr.vibrate(300L);
  }
  
  public final void azV()
  {
    y.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    y.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.azB() != null) && (paramb.azB().equals(this.ikk.azB())))
    {
      this.ikk = paramb;
      this.ipx.ikk = this.ikk;
      this.ipx.aAW();
    }
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_consume_code_ui;
  }
  
  protected final void initView()
  {
    Object localObject1;
    label420:
    int i;
    if (this.ikk.azf())
    {
      if (!TextUtils.isEmpty(this.ikk.azx().imz)) {
        setMMTitle(getString(a.g.card_consume_code_ui_title, new Object[] { this.ikk.azx().imz }));
      }
    }
    else
    {
      setBackBtn(new CardConsumeCodeUI.1(this));
      if (this.ipx == null)
      {
        this.ipx = new a(this, this.mController.contentView);
        localObject1 = this.ipx;
        ((a)localObject1).ipr = ((a)localObject1).hxN.getWindow().getAttributes().screenBrightness;
        localObject1 = this.ipx;
        ((a)localObject1).ipk = ((TextView)((a)localObject1).ipf.findViewById(a.d.card_notice));
        ((a)localObject1).ipl = ((TextView)((a)localObject1).ipf.findViewById(a.d.card_pay_and_qrcode_notice));
        ((a)localObject1).ipm = ((CheckBox)((a)localObject1).ipf.findViewById(a.d.notify_checkbox));
        ((a)localObject1).ipm.setChecked(true);
        ((a)localObject1).ipm.setOnClickListener(((a)localObject1).fvj);
        if (((a)localObject1).ipr < 0.8F) {
          ((a)localObject1).ao(0.8F);
        }
        this.ipx.ipq = new CardConsumeCodeUI.2(this);
      }
      this.ipx.ikk = this.ikk;
      this.ipx.ipp = true;
      Object localObject2;
      if (this.ikk.aze())
      {
        localObject1 = this.ipx;
        localObject2 = this.ipu;
        ((a)localObject1).ipo = 1;
        ((a)localObject1).ipn = ((String)localObject2);
      }
      this.ibr = ((Vibrator)getSystemService("vibrator"));
      this.ipy = ((TextView)findViewById(a.d.brand_name));
      this.ipz = ((TextView)findViewById(a.d.title));
      this.ipA = ((LinearLayout)findViewById(a.d.app_logo_layout));
      this.ipB = ((ImageView)findViewById(a.d.app_logo));
      this.ipC = findViewById(a.d.dash_line);
      this.ipD = ((LinearLayout)findViewById(a.d.code_layout));
      if (!this.ikk.azf()) {
        break label1012;
      }
      findViewById(a.d.card_consumed_code_ui).setBackgroundColor(getResources().getColor(a.a.card_bg_color));
      m.c(this);
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
      if ((!this.ikk.azf()) || (TextUtils.isEmpty(this.ikk.azx().ilp))) {
        break label1062;
      }
      this.ipA.setVisibility(0);
      this.ipy.setVisibility(8);
      this.ipz.setVisibility(8);
      this.ipC.setVisibility(8);
      i = getResources().getDimensionPixelSize(a.b.card_coupon_widget_logo_size);
      m.a(this.ipB, this.ikk.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
      label520:
      if (this.ikk.azx().sIU != null)
      {
        localObject1 = this.ikk.azx().sIU;
        if (!TextUtils.isEmpty(((ra)localObject1).title))
        {
          if (this.ipE == null) {
            this.ipE = ((ViewStub)findViewById(a.d.card_pay_and_qrcode_stub)).inflate();
          }
          this.ipE.setOnClickListener(this);
          this.ipF = ((TextView)this.ipE.findViewById(a.d.card_pay_and_qrcode_title));
          this.ipG = ((TextView)this.ipE.findViewById(a.d.card_pay_and_qrcode_sub_title));
          this.ipH = ((TextView)this.ipE.findViewById(a.d.card_pay_and_qrcode_aux_title));
          this.ipF.setVisibility(0);
          this.ipF.setText(((ra)localObject1).title);
          localObject2 = getResources().getDrawable(a.c.card_continue_arrow);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.yR(this.ikk.azx().color), PorterDuff.Mode.SRC_IN);
          this.ipF.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.ipF.setTextColor(com.tencent.mm.plugin.card.d.l.yR(this.ikk.azx().color));
          this.ipF.setOnClickListener(this);
          if (TextUtils.isEmpty(((ra)localObject1).ilq)) {
            break label1103;
          }
          this.ipG.setVisibility(0);
          this.ipG.setText(((ra)localObject1).ilq);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((ra)localObject1).ilr))
      {
        this.ipH.setVisibility(0);
        this.ipH.setText(((ra)localObject1).ilr);
      }
      localObject1 = this.ipB.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(a.b.card_coupon_widget_small_logo_size);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(a.b.card_coupon_widget_small_logo_size);
      this.ipB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.ipA.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      this.ipA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(a.b.card_coupon_widget_small_logo_size);
      m.a(this.ipB, this.ikk.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
      this.ipD.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 10), 0, com.tencent.mm.cb.a.fromDPToPix(this, 30));
      am.aAD().a(this);
      if (this.ikk.azs())
      {
        am.aAF().a(this);
        if (am.aAF().isEmpty()) {
          break label1128;
        }
        am.aAF().azN();
      }
      return;
      setMMTitle(getString(a.g.card_consume_code_ui_title, new Object[] { getString(a.g.card_membership) }));
      break;
      label1012:
      i = com.tencent.mm.plugin.card.d.l.yR(this.ikk.azx().color);
      findViewById(a.d.card_consumed_code_ui).setBackgroundColor(i);
      m.a(this, this.ikk);
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, i, true);
      break label420;
      label1062:
      this.ipy.setText(this.ikk.azx().imA);
      this.ipz.setText(this.ikk.azx().title);
      break label520;
      label1103:
      this.ipG.setVisibility(0);
      this.ipG.setText(getString(a.g.card_membership_continue_tip));
    }
    label1128:
    y.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.aAF().xY(this.ikk.azB());
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == a.d.card_pay_and_qrcode_title) || (paramView.getId() == a.d.card_pay_and_qrcode))
    {
      if (!this.ikk.azr()) {
        break label62;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.ild, paramView.ile, false, this.ikk);
    }
    for (;;)
    {
      finish();
      return;
      label62:
      Object localObject = this.ikk.azx().sIU;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.ikk.azB(), (ra)localObject, this.ipv, this.ipw)) && (localObject != null) && (!TextUtils.isEmpty(((ra)localObject).url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.y(((ra)localObject).url, ((ra)localObject).sJq), 1);
        h.nFQ.f(11941, new Object[] { Integer.valueOf(9), this.ikk.azB(), this.ikk.azC(), "", ((ra)localObject).title });
        if (com.tencent.mm.plugin.card.d.l.a((ra)localObject, this.ikk.azB()))
        {
          paramView = this.ikk.azB();
          localObject = ((ra)localObject).title;
          com.tencent.mm.plugin.card.d.l.yX(paramView);
          com.tencent.mm.plugin.card.d.b.a(this, this.ikk.azx().imA);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.ikk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.drX = getIntent().getIntExtra("key_from_scene", 3);
    this.ipv = getIntent().getIntExtra("key_previous_scene", 3);
    this.ipu = getIntent().getStringExtra("key_mark_user");
    this.ipw = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.ikk == null) || (this.ikk.azx() == null) || (this.ikk.azy() == null))
    {
      y.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      return;
    }
    initView();
    am.aAy().r("", "", 3);
  }
  
  protected void onDestroy()
  {
    a locala = this.ipx;
    locala.ao(locala.ipr);
    com.tencent.mm.plugin.card.d.l.w(locala.fve);
    com.tencent.mm.plugin.card.d.l.w(locala.ipj);
    locala.ipq = null;
    locala.hxN = null;
    am.aAD().c(this);
    am.aAD().b(this);
    if (this.ikk.azs())
    {
      am.aAF().b(this);
      am.aAF().azO();
    }
    this.ibr.cancel();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
      setResult(-1);
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    am.aAD().a(this, false);
    super.onPause();
  }
  
  protected void onResume()
  {
    this.ipx.aAW();
    am.aAD().a(this, true);
    super.onResume();
  }
  
  public final void onSuccess()
  {
    this.ipx.aAW();
  }
  
  public final void xX(String paramString)
  {
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
  }
  
  public final void ya(String paramString)
  {
    y.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.ipI)
    {
      y.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      return;
    }
    y.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.ipI = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.ikk.azB());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.ikk.azx().color);
    localIntent.putExtra("key_stastic_scene", this.drX);
    localIntent.putExtra("key_from_scene", 0);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */