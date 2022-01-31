package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.m.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String bSP;
  private String bXl;
  private int dRO;
  private String dRP;
  private RelativeLayout itb;
  private RelativeLayout itc;
  private ImageView itd;
  private TextView ite;
  private TextView itf;
  private ImageView itg;
  private Button ith;
  private LinearLayout iti;
  private TextView itj;
  private LinearLayout itk;
  private TextView itl;
  private ImageView itm;
  private ImageView itn;
  private RelativeLayout ito;
  private ag itp;
  private q itq;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void aBQ()
  {
    q localq = new q(this.dRO, this.dRP, this.bSP, Boolean.valueOf(false));
    g.DO().dJT.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
  }
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    paramDrawable = android.support.v4.a.a.a.f(paramDrawable);
    android.support.v4.a.a.a.a(paramDrawable, paramColorStateList);
    return paramDrawable;
  }
  
  private void cu(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.ith.setBackground(localGradientDrawable);
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_gift_accept_ui_new;
  }
  
  protected final void initView()
  {
    this.itb = ((RelativeLayout)findViewById(a.d.card_gift_accept_root));
    this.itc = ((RelativeLayout)findViewById(a.d.card_gift_receive_rl));
    this.itd = ((ImageView)findViewById(a.d.card_gift_receive_sender_avatar));
    this.ite = ((TextView)findViewById(a.d.card_gift_receive_sender_nickname));
    this.itf = ((TextView)findViewById(a.d.card_gift_receive_content));
    this.itg = ((ImageView)findViewById(a.d.iv_package_card));
    this.ith = ((Button)findViewById(a.d.card_gift_recieve_open));
    this.itj = ((TextView)findViewById(a.d.card_gift_receive_outOfCardWording));
    this.itl = ((TextView)findViewById(a.d.card_gift_receive_seeOtherWording));
    this.ito = ((RelativeLayout)findViewById(a.d.card_gift_recieve_close_btn));
    this.itm = ((ImageView)findViewById(a.d.card_gift_receive_arrow));
    this.itn = ((ImageView)findViewById(a.d.see_other_arrow));
    this.iti = ((LinearLayout)findViewById(a.d.out_of_card_wording_layout));
    this.itk = ((LinearLayout)findViewById(a.d.see_other_wording_layout));
    this.ito.setOnClickListener(this);
    this.itb.setOnClickListener(this);
    this.itc.setOnClickListener(this);
    this.iti.setOnClickListener(this);
    this.itk.setOnClickListener(this);
    this.mController.contentView.setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(a.g.loading_tips), true, new CardGiftAcceptUI.1(this));
    ag localag = new ag(this.dRO, this.dRP, this.bSP);
    g.DO().dJT.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == a.d.card_gift_recieve_open) || (paramView.getId() == a.d.out_of_card_wording_layout))
    {
      if (this.ith.getVisibility() == 0)
      {
        int i = bk.bq(this.itp.inM, getResources().getColor(a.a.card_gift_accept_button_default_border_color));
        cu(i, i);
        this.ith.setTextColor(getResources().getColor(a.a.white));
      }
      aBQ();
      if (!bk.bl(this.bXl)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(2), this.dRP, com.tencent.mm.a.o.getString(this.dRO), this.bXl });
      }
    }
    do
    {
      do
      {
        return;
        if (paramView.getId() == a.d.card_gift_recieve_close_btn)
        {
          finish();
          return;
        }
        if (paramView.getId() == a.d.card_gift_accept_root)
        {
          finish();
          return;
        }
      } while (paramView.getId() != a.d.see_other_wording_layout);
      paramView = new q(this.dRO, this.dRP, this.bSP, Boolean.valueOf(true));
      g.DO().dJT.a(paramView, 0);
    } while (this.tipDialog == null);
    this.tipDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dRP = getIntent().getStringExtra("key_order_id");
    this.dRO = getIntent().getIntExtra("key_biz_uin", -1);
    this.bXl = getIntent().getStringExtra("key_from_user_name");
    this.bSP = getIntent().getStringExtra("key_chatroom_name");
    y.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.dRP, Integer.valueOf(this.dRO), this.bXl });
    if (this.dRO == -1)
    {
      y.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      return;
    }
    if (this.dRP == null)
    {
      y.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      return;
    }
    if (!bk.bl(this.bXl)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13866, new Object[] { Integer.valueOf(1), this.dRP, com.tencent.mm.a.o.getString(this.dRO), this.bXl });
    }
    initView();
    g.DO().dJT.a(1171, this);
    g.DO().dJT.a(1136, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.DO().dJT.b(1171, this);
    g.DO().dJT.b(1136, this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof ag))
      {
        this.itp = ((ag)paramm);
        y.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.itp.hkG) });
        if (!this.itp.hkG)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.itp == null)
          {
            y.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.itc;
            paramm = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
            paramm.setDuration(300L);
            paramm.setInterpolator(new OvershootInterpolator());
            paramm.setFillAfter(true);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(100L);
            localScaleAnimation.setFillAfter(true);
            paramm.setAnimationListener(new m.3(paramString, localScaleAnimation));
            if (paramString != null) {
              paramString.startAnimation(paramm);
            }
            this.mController.contentView.setVisibility(0);
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        this.itf.setText(this.itp.content);
        this.ite.setText(j.a(this, this.itp.bXl, this.ite.getTextSize()));
        if (this.itp.status == 0) {
          if (!bk.bl(this.itp.inK))
          {
            this.ith.setVisibility(0);
            this.ith.setText(this.itp.inK);
            this.ith.setOnClickListener(this);
          }
        }
        for (;;)
        {
          if (!bk.bl(this.itp.inN))
          {
            this.ith.setVisibility(8);
            this.itk.setVisibility(8);
            this.iti.setVisibility(0);
            this.itj.setText(this.itp.inN);
          }
          if (!bk.bl(this.itp.inO))
          {
            this.iti.setVisibility(8);
            this.itk.setVisibility(0);
            this.itl.setText(this.itp.inO);
          }
          if (!bk.bl(this.itp.inJ))
          {
            paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this, 15);
            paramString = new c.a();
            paramString.eri = e.bkH;
            com.tencent.mm.as.o.OO();
            paramString.erB = null;
            paramString.erh = com.tencent.mm.plugin.card.model.m.yn(this.itp.inJ);
            paramString.erf = true;
            paramString.erD = true;
            paramString.erE = paramInt1;
            paramString.erd = true;
            paramString.eru = a.c.my_card_package_defaultlogo;
            paramString = paramString.OV();
            com.tencent.mm.as.o.ON().a(this.itp.inJ, this.itd, paramString);
          }
          if (!bk.bl(this.itp.inL)) {
            com.tencent.mm.as.o.ON().a(this.itp.inL, this.itg);
          }
          if ((!bk.bl(this.itp.inM)) && (this.ith.getVisibility() == 0))
          {
            paramInt1 = bk.bq(this.itp.inM, getResources().getColor(a.a.card_gift_accept_button_default_border_color));
            cu(paramInt1, getResources().getColor(a.a.card_gift_accept_button_default_bg_color));
            this.ith.setTextColor(paramInt1);
          }
          if ((!bk.bl(this.itp.inM)) && (this.itj.getVisibility() == 0))
          {
            paramInt1 = bk.bq(this.itp.inM, getResources().getColor(a.a.card_gift_accept_button_default_border_color));
            this.itj.setTextColor(paramInt1);
            paramInt2 = getResources().getColor(a.a.card_gift_accept_button_default_border_color);
            paramInt1 = paramInt2;
            if (!bk.bl(this.itp.inM)) {
              paramInt1 = bk.bq(this.itp.inM, paramInt2);
            }
            this.itm.setImageDrawable(b(this.itm.getDrawable(), ColorStateList.valueOf(paramInt1)));
          }
          if ((!bk.bl(this.itp.inM)) && (this.itl.getVisibility() == 0))
          {
            paramInt1 = bk.bq(this.itp.inM, getResources().getColor(a.a.card_gift_accept_button_default_border_color));
            this.itl.setTextColor(paramInt1);
            paramInt2 = getResources().getColor(a.a.card_gift_accept_button_default_border_color);
            paramInt1 = paramInt2;
            if (!bk.bl(this.itp.inM)) {
              paramInt1 = bk.bq(this.itp.inM, paramInt2);
            }
            this.itn.setImageDrawable(b(this.itn.getDrawable(), ColorStateList.valueOf(paramInt1)));
            paramString = (ViewGroup.MarginLayoutParams)this.ith.getLayoutParams();
            paramString.topMargin -= com.tencent.mm.cb.a.fromDPToPix(this, 20);
            this.ith.setLayoutParams(paramString);
          }
          if ((this.ith.getVisibility() != 0) || (this.itk.getVisibility() != 8)) {
            break;
          }
          paramString = (ViewGroup.MarginLayoutParams)this.ith.getLayoutParams();
          paramString.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(this, 28);
          this.ith.setLayoutParams(paramString);
          break;
          this.ith.setVisibility(0);
          this.ith.setText(getResources().getString(a.g.card_gift_accepted_title));
          this.ith.setOnClickListener(this);
          continue;
          if ((this.itp.status != 1) && (this.itp.status == 2))
          {
            if (!bk.bl(this.itp.inK))
            {
              this.ith.setVisibility(0);
              this.ith.setBackgroundDrawable(null);
              this.ith.setText(this.itp.inK);
              this.ith.setTextColor(getResources().getColor(a.a.black));
              this.ith.setTextSize(1, 17.0F);
              this.ith.setOnClickListener(null);
            }
            else
            {
              this.ith.setVisibility(8);
              this.ith.setOnClickListener(null);
            }
          }
          else
          {
            this.ith.setVisibility(8);
            this.ith.setOnClickListener(null);
          }
        }
        y.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        aBQ();
        return;
      } while (!(paramm instanceof q));
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      y.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
      this.itq = ((q)paramm);
      paramString = new Intent(this, CardGiftReceiveUI.class);
      paramString.putExtra("key_order_id", this.dRP);
      paramString.putExtra("key_biz_uin", this.dRO);
      paramString.putExtra("key_gift_into", this.itq.inq);
      if (!bk.bl(this.bSP)) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.putExtra("key_from_group_chat_room", bool);
        startActivity(paramString);
        finish();
        return;
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramm instanceof ag))
      {
        y.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        return;
      }
    } while (!(paramm instanceof q));
    y.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    d.a(this, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI
 * JD-Core Version:    0.7.0.1
 */