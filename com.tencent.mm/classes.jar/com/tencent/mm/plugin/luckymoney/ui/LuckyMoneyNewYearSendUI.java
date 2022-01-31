package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.l;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private Dialog ftk = null;
  private View.OnClickListener fvj = new LuckyMoneyNewYearSendUI.1(this);
  private String imageId = "";
  private Button jhV;
  private String lRm;
  private int lRo;
  private int lRt = 0;
  private LinkedList<l> lRu;
  private int lTB;
  private String lTF;
  private int lTG;
  private TextView lWA;
  private ImageView lWB;
  private LinearLayout lWC;
  private String lWD;
  private boolean lWE = true;
  private String lWF = "";
  private int lWG = 0;
  private LuckyMoneyAutoScrollView lWc;
  private TextView lWd;
  private ImageView lWh;
  private View lWi;
  private ImageView lWj;
  private boolean lWl = false;
  private String lWm = "";
  private int lWn;
  private k lWo;
  private View lWx;
  private View lWy;
  private ImageView lWz;
  private TextView lly;
  private Bitmap mBitmap;
  private ah mHandler = new ah();
  
  private void aZ()
  {
    y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
    if ((this.lWl) && (this.lRt == 1))
    {
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
      this.lWy.setVisibility(8);
      this.lWi.setVisibility(0);
      this.lWh.setVisibility(8);
      if ((this.lRu == null) || (this.lRu.size() <= 0)) {
        break label403;
      }
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
      this.lWC.setVisibility(0);
      label87:
      if (this.lRt != 1) {
        break label422;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.lWh.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_word_top_margin_for_picture);
      localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_word_bottom_margin_for_picture);
      this.lWh.setLayoutParams(localLayoutParams);
      this.lWh.invalidate();
    }
    for (;;)
    {
      if (!this.lWl) {
        break label479;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.lly.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_wishing_bottom_margin_for_picture);
      this.lly.setLayoutParams(localLayoutParams);
      this.lly.invalidate();
      this.lly.setTextSize(1, 17.0F);
      this.lWd.setTextSize(1, 16.0F);
      this.lWc.de(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_picture), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_picture));
      localLayoutParams = (LinearLayout.LayoutParams)this.lWc.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_picture);
      this.lWc.setLayoutParams(localLayoutParams);
      this.lWc.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.lWC.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_refresh_layout_top_margin_for_picture);
      this.lWC.setLayoutParams(localLayoutParams);
      this.lWC.invalidate();
      return;
      if (this.lRt == 1)
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
        this.lWy.setVisibility(0);
        this.lWi.setVisibility(8);
        this.lWh.setVisibility(0);
        break;
      }
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
      this.lWy.setVisibility(8);
      this.lWi.setVisibility(8);
      this.lWh.setVisibility(0);
      break;
      label403:
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
      this.lWC.setVisibility(8);
      break label87;
      label422:
      localLayoutParams = (LinearLayout.LayoutParams)this.lWh.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_word_top_margin_for_normal);
      localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_word_bottom_margin_for_normal);
      this.lWh.setLayoutParams(localLayoutParams);
      this.lWh.invalidate();
    }
    label479:
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lly.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_wishing_bottom_margin_for_normal);
    this.lly.setLayoutParams(localLayoutParams);
    this.lly.invalidate();
    this.lly.setTextSize(1, 20.0F);
    this.lWd.setTextSize(1, 18.0F);
    this.lWc.de(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
    localLayoutParams = (LinearLayout.LayoutParams)this.lWc.getLayoutParams();
    localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
    this.lWc.setLayoutParams(localLayoutParams);
    this.lWc.invalidate();
    localLayoutParams = (LinearLayout.LayoutParams)this.lWC.getLayoutParams();
    localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_refresh_layout_top_margin_for_normal);
    this.lWC.setLayoutParams(localLayoutParams);
    this.lWC.invalidate();
  }
  
  private void bgo()
  {
    if (this.ftk != null)
    {
      if (!this.ftk.isShowing()) {
        this.ftk.show();
      }
      return;
    }
    this.ftk = com.tencent.mm.wallet_core.ui.g.a(this.mController.uMN, true, new LuckyMoneyNewYearSendUI.2(this));
  }
  
  private void bgp()
  {
    int i;
    if ((this.lRu != null) && (this.lRu.size() > 0))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DN();
      i = com.tencent.mm.kernel.a.CK();
      int j = this.lRu.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
    }
    for (;;)
    {
      this.lWG = i;
      if ((this.lWG >= 0) && (this.lWG < this.lRu.size()))
      {
        this.lRo = ((l)this.lRu.get(this.lWG)).lQJ;
        this.lRm = ((l)this.lRu.get(this.lWG)).lQK;
      }
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.lWG + " randomAmount:" + this.lRo + " randomWishing:" + this.lRm);
      this.lWc.setFinalText(com.tencent.mm.wallet_core.ui.e.A(this.lRo / 100.0D));
      this.lWc.a(new LuckyMoneyNewYearSendUI.3(this));
      return;
      y.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    if ((paramm instanceof x))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (x)paramm;
        this.lRo = paramString.lRo;
        this.lRm = paramString.lRm;
        this.lRt = paramString.lRt;
        this.lRu = paramString.lRu;
        if (this.lRt == 0) {
          y.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
        }
        for (;;)
        {
          bgp();
          aZ();
          vN(0);
          o.a(this.lWx, null);
          return true;
          y.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
        }
      }
      finish();
    }
    for (;;)
    {
      return false;
      if ((paramm instanceof ae))
      {
        if ((this.ftk != null) && (this.ftk.isShowing())) {
          this.ftk.hide();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          y.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
          paramString = (ae)paramm;
          this.lTF = paramString.lRB;
          paramm = new PayInfo();
          paramm.bMX = paramString.lRA;
          paramm.bUV = 37;
          paramm.bUR = this.lTG;
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
          return true;
        }
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
      }
      else if ((paramm instanceof af))
      {
        if ((this.ftk != null) && (this.ftk.isShowing())) {
          this.ftk.hide();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          y.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
          paramString = (af)paramm;
          this.lTF = paramString.lRB;
          paramm = new PayInfo();
          paramm.bMX = paramString.lRA;
          paramm.bUV = 37;
          paramm.bUR = this.lTG;
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
          return true;
        }
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_new_year_send_ui;
  }
  
  protected final void initView()
  {
    vN(8);
    this.lWx = findViewById(a.f.lucky_money_newyear_send_ll);
    this.lWd = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.lWc = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_new_year_amount));
    this.lly = ((TextView)findViewById(a.f.lucky_money_new_year_wishing));
    this.jhV = ((Button)findViewById(a.f.lucky_money_new_year_send_btn));
    this.jhV.setOnClickListener(this.fvj);
    ((ImageView)findViewById(a.f.lucky_money_new_year_close_btn)).setOnClickListener(this.fvj);
    this.lWy = findViewById(a.f.lucky_money_new_year_camera_layout);
    this.lWz = ((ImageView)findViewById(a.f.lucky_money_new_year_camera_btn));
    this.lWz.setOnClickListener(this.fvj);
    this.lWh = ((ImageView)findViewById(a.f.lucky_money_new_year_word));
    this.lWA = ((TextView)findViewById(a.f.lucky_money_new_year_camera_tips));
    this.lWA.setOnClickListener(this.fvj);
    this.lWi = findViewById(a.f.lucky_money_new_year_picture_layout);
    this.lWj = ((ImageView)findViewById(a.f.lucky_money_new_year_picture_img));
    this.lWj.setOnClickListener(this.fvj);
    this.lWB = ((ImageView)findViewById(a.f.lucky_money_new_year_picture_del_btn));
    this.lWB.setOnClickListener(this.fvj);
    this.lWC = ((LinearLayout)findViewById(a.f.lucky_money_new_year_refresh_layout));
    this.lWC.setOnClickListener(this.fvj);
    com.tencent.mm.kernel.g.DQ();
    this.lWF = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usa, ""));
    com.tencent.mm.kernel.g.DQ();
    this.imageId = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usb, ""));
    com.tencent.mm.kernel.g.DQ();
    this.lWm = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usc, ""));
    com.tencent.mm.kernel.g.DQ();
    this.lWn = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usd, Integer.valueOf(0))).intValue();
    if ((!TextUtils.isEmpty(this.lWF)) && (!TextUtils.isEmpty(this.imageId)) && (!TextUtils.isEmpty(this.lWm)) && (this.lWn > 0))
    {
      this.lWl = true;
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
    }
    while ((this.lWl) && (!TextUtils.isEmpty(this.lWF)))
    {
      Bitmap localBitmap1 = o.aJ(this.lWF, false);
      if (localBitmap1 != null)
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
        Bitmap localBitmap2 = this.mBitmap;
        this.mBitmap = localBitmap1;
        this.lWj.setImageBitmap(this.mBitmap);
        if ((localBitmap2 != null) && (localBitmap2.isRecycled())) {
          localBitmap2.recycle();
        }
        return;
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
      }
      else
      {
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
        return;
      }
    }
    y.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.lWl + ", mImagePath:" + this.lWF);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    label194:
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        paramInt1 = i;
        if (paramIntent != null)
        {
          paramInt1 = i;
          if (paramIntent.hasExtra("key_realname_guide_helper"))
          {
            paramIntent = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
            paramInt1 = i;
            if (paramIntent != null) {
              if (paramIntent.b(this, null, new LuckyMoneyNewYearSendUI.4(this))) {
                break label194;
              }
            }
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
          y.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
          o.C(this.lTF, this.lWD, 3);
          if (paramInt1 != 0) {
            break;
          }
          finish();
          return;
        }
      }
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      return;
    case 2: 
      if (paramIntent == null)
      {
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
        return;
      }
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
        localObject = paramIntent.getStringExtra("CropImage_OutputPath");
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) || ((paramIntent != null) && (paramIntent.size() > 0)))
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
          }
          for (paramIntent = (Intent)localObject;; paramIntent = (String)paramIntent.get(0))
          {
            y.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[] { localObject });
            localObject = new Intent();
            ((Intent)localObject).putExtra("CropImageMode", 1);
            ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dzM + "temp.avatar");
            ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
            ((Intent)localObject).putExtra("CropImage_Filter", false);
            ((Intent)localObject).putExtra("CropImage_from_scene", 1);
            com.tencent.mm.plugin.luckymoney.a.eUR.a(this, (Intent)localObject, 3);
            return;
            y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
          }
        }
        y.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
        return;
      }
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
      return;
    }
    if (paramIntent == null)
    {
      y.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
      return;
    }
    if (paramInt2 == -1)
    {
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + paramIntent);
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals(this.lWF))) {
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
      }
      for (;;)
      {
        this.lWF = paramIntent;
        paramIntent = o.aJ(this.lWF, false);
        if (paramIntent == null) {
          break label615;
        }
        y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
        localObject = this.mBitmap;
        this.mBitmap = paramIntent;
        this.lWj.setImageBitmap(this.mBitmap);
        this.lWl = true;
        aZ();
        if ((localObject == null) || (!((Bitmap)localObject).isRecycled())) {
          break;
        }
        ((Bitmap)localObject).recycle();
        return;
        this.imageId = "";
        this.lWm = "";
        this.lWn = 0;
      }
      label615:
      y.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
      return;
    }
    y.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.lWD = getIntent().getStringExtra("key_username");
    this.lTB = getIntent().getIntExtra("key_way", 0);
    this.lTG = getIntent().getIntExtra("pay_channel", -1);
    if (bk.bl(this.lWD))
    {
      y.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    l(new x("v1.0"));
    com.tencent.mm.plugin.report.service.h.nFQ.f(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usa, this.lWF);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usb, this.imageId);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usc, this.lWm);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usd, Integer.valueOf(this.lWn));
    super.onDestroy();
    if ((this.ftk != null) && (this.ftk.isShowing())) {
      this.ftk.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */