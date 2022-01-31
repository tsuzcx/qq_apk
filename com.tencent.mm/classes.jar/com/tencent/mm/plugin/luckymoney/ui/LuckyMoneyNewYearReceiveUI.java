package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.io.File;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView gSp;
  private ImageView iIS;
  private String imageId = "";
  private String imagePath = "";
  private View lMR;
  private int lRt = 0;
  private String lUy;
  private LuckyMoneyAutoScrollView lWc;
  private TextView lWd;
  private TextView lWe;
  private LinearLayout lWf;
  private ImageView lWg;
  private ImageView lWh;
  private View lWi;
  private ImageView lWj;
  private boolean lWk = false;
  private boolean lWl = false;
  private String lWm = "";
  private int lWn;
  private k lWo;
  private boolean lWp = false;
  private TextView lly;
  private ah mHandler = new ah();
  private p tipDialog = null;
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    b(new ad(paramInt1, paramInt2, paramString1, paramString2, o.bfL(), q.Gl(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
  }
  
  private void bgn()
  {
    g.DS().O(new LuckyMoneyNewYearReceiveUI.5(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof ag))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ag)paramm;
        this.lRt = paramString.lRt;
        if (this.lRt == 1)
        {
          y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
          if (TextUtils.isEmpty(this.lWm)) {
            y.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
          }
          if ((TextUtils.isEmpty(this.imageId)) || (TextUtils.isEmpty(this.lWm)) || (this.lWn <= 0))
          {
            y.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
            if (!paramString.bfO()) {
              break label826;
            }
            this.lWk = true;
            y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
            a.b.n(this.iIS, q.Gj());
            findViewById(a.f.lucky_money_newyear_receive_senderdesc).setVisibility(8);
            findViewById(a.f.lucky_money_new_year_word).setVisibility(0);
            if ((paramString.bfO()) || (paramString.ced != 0) || (paramString.cec == 4) || (paramString.cec == 5) || (paramString.cec == 1)) {
              break label946;
            }
            if (!"0".equals(paramString.lRe)) {
              break label919;
            }
            paramm = this.lUq;
            String str1 = paramString.lRf;
            String str2 = paramString.lRg;
            String str3 = paramString.lRh;
            String str4 = paramString.lRi;
            LuckyMoneyNewYearReceiveUI.6 local6 = new LuckyMoneyNewYearReceiveUI.6(this, paramString);
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramm, str1, str2, str3, str4, local6, true, 1005);
            label267:
            y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.lRt + ", imageId:" + this.imageId + ", imageLength:" + this.lWn);
            if ((this.lRt != 1) || (TextUtils.isEmpty(this.imageId)) || (TextUtils.isEmpty(this.lWm)) || (this.lWn <= 0)) {
              break label1178;
            }
            this.lWl = true;
            y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            label366:
            boolean bool = true;
            if ((paramString.cec == 5) || (paramString.cec == 1)) {
              bool = false;
            }
            y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.cec + ", isValidStatus is " + bool);
            if ((!this.lWl) || (!bool)) {
              break label1194;
            }
            this.lWi.setVisibility(0);
            this.lWh.setVisibility(8);
            label453:
            if ((!this.lWl) || (!bool)) {
              break label1214;
            }
            paramString = (LinearLayout.LayoutParams)this.lly.getLayoutParams();
            paramString.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_wishing_bottom_margin_for_picture);
            this.lly.setLayoutParams(paramString);
            this.lly.invalidate();
            this.lly.setTextSize(1, 17.0F);
            this.lWd.setTextSize(1, 16.0F);
            this.lWc.de(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_picture), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_picture));
            paramString = (LinearLayout.LayoutParams)this.lWc.getLayoutParams();
            paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_picture);
            this.lWc.setLayoutParams(paramString);
            this.lWc.invalidate();
            label594:
            if (!this.lWk) {
              break label1363;
            }
            paramString = (LinearLayout.LayoutParams)this.lWf.getLayoutParams();
            if (!this.lWl) {
              break label1346;
            }
            paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_sender_has_pic);
            label633:
            this.lWf.setLayoutParams(paramString);
            this.lWf.invalidate();
            this.gSp.setTextSize(1, 18.0F);
          }
        }
        for (;;)
        {
          return true;
          y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
          if (this.lWo == null) {
            this.lWo = new k();
          }
          this.imagePath = (o.GO(this.imageId) + ".temp");
          if (!new File(this.imagePath).exists())
          {
            y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
            this.lWo.a(this.imageId, this.lWm, this.lWn, this.imagePath, new LuckyMoneyNewYearReceiveUI.4(this));
            break;
          }
          y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
          bgn();
          break;
          y.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
          break;
          label826:
          y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
            a.b.n(this.iIS, getIntent().getStringExtra("key_username"));
          }
          for (;;)
          {
            o.a(this.mController.uMN, this.lWe, paramString.lRI);
            this.lWk = false;
            break;
            if (!TextUtils.isEmpty(paramString.lPV)) {
              o.a(this.iIS, paramString.lPV, paramString.lQp);
            }
          }
          label919:
          a(paramString.msgType, paramString.bvj, paramString.lMg, paramString.ceb, paramString.lRM);
          break label267;
          label946:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if (paramString.cec != 5)
          {
            this.lWc.setFinalText(e.A(paramString.lRJ / 100.0D));
            paramm = this.lWc;
            paramm.lUe.setVisibility(8);
            paramm.lUf.setVisibility(8);
            paramm.lUg.setVisibility(8);
            paramm.lUh.setVisibility(0);
            paramm.lUi.setVisibility(0);
            paramm.lUj.setVisibility(0);
            o.a(this.mController.uMN, this.lly, paramString.lLm);
            this.gSp.setText(paramString.lPS);
            if ((paramString.cec == 4) && (!TextUtils.isEmpty(paramString.lPS))) {
              this.lWg.setVisibility(8);
            }
          }
          for (;;)
          {
            vN(0);
            o.a(this.lMR, null);
            break;
            findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.lPS);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
          }
          label1178:
          this.lWl = false;
          y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
          break label366;
          label1194:
          this.lWi.setVisibility(8);
          this.lWh.setVisibility(0);
          break label453;
          label1214:
          paramString = (LinearLayout.LayoutParams)this.lly.getLayoutParams();
          paramString.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_wishing_bottom_margin_for_normal);
          this.lly.setLayoutParams(paramString);
          this.lly.invalidate();
          this.lly.setTextSize(1, 20.0F);
          this.lWd.setTextSize(1, 18.0F);
          this.lWc.de(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
          paramString = (LinearLayout.LayoutParams)this.lWc.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
          this.lWc.setLayoutParams(paramString);
          this.lWc.invalidate();
          break label594;
          label1346:
          paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_sender_no_pic);
          break label633;
          label1363:
          paramString = (LinearLayout.LayoutParams)this.lWf.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_receiver);
          this.lWf.setLayoutParams(paramString);
          this.lWf.invalidate();
          this.gSp.setTextSize(1, 12.0F);
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      return false;
    }
    if ((paramm instanceof ad))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ad)paramm;
        paramm = paramString.lQZ;
        this.gSp.setText(paramString.lQZ.lPS);
        this.lWc.setFinalText(e.A(paramString.lQZ.ceq / 100.0D));
        this.lWc.a(new LuckyMoneyNewYearReceiveUI.7(this, paramString));
        if ((paramm.cec == 4) && (!TextUtils.isEmpty(paramString.lQZ.lPS))) {
          this.lWg.setVisibility(8);
        }
        vN(0);
        o.a(this.lMR, null);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        this.lWp = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        return o.a(this, paramInt2, paramm, paramString, true, null, 1004);
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_newyear_receive_ui;
  }
  
  protected final void initView()
  {
    this.lMR = findViewById(a.f.lucky_money_newyear_receive_ll);
    this.lWc = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_newyear_receive_amount));
    this.lWd = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.lly = ((TextView)findViewById(a.f.lucky_money_newyear_receive_wishing));
    this.iIS = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_avatar));
    this.lWf = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_status_layout));
    this.gSp = ((TextView)findViewById(a.f.lucky_money_newyear_receive_status));
    this.lWg = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_status_icon));
    this.lWe = ((TextView)findViewById(a.f.lucky_money_newyear_receive_title));
    this.lWh = ((ImageView)findViewById(a.f.lucky_money_new_year_word));
    this.lWi = findViewById(a.f.lucky_money_new_year_picture_layout);
    this.lWj = ((ImageView)findViewById(a.f.lucky_money_new_year_picture_img));
    this.lWj.setOnClickListener(new LuckyMoneyNewYearReceiveUI.1(this));
    ((ImageView)findViewById(a.f.lucky_money_newyear_receive_close_btn)).setOnClickListener(new LuckyMoneyNewYearReceiveUI.2(this));
    vN(8);
    this.tipDialog = h.b(this.mController.uMN, getString(a.i.loading_tips), true, new LuckyMoneyNewYearReceiveUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_native_url");
    this.imageId = getIntent().getStringExtra("key_image_id");
    this.lWm = getIntent().getStringExtra("key_image_aes_key");
    this.lWn = getIntent().getIntExtra("key_image_length", 0);
    y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.imageId + ", imageLength:" + this.lWn);
    Uri localUri = Uri.parse(bk.pm(paramBundle));
    try
    {
      this.lUy = localUri.getQueryParameter("sendid");
      label116:
      initView();
      if (!bk.bl(this.lUy))
      {
        b(new ag(bk.getInt(localUri.getQueryParameter("channelid"), 1), this.lUy, paramBundle, 1, "v1.0"), false);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
        return;
      }
      finish();
      y.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
      return;
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.lWp) {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */