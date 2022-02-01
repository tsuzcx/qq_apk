package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, i
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String dSW;
  private String dYs;
  private TextView hFg;
  private int ixX;
  private String ixY;
  private RelativeLayout qai;
  private RelativeLayout qaj;
  private ImageView qak;
  private TextView qal;
  private ImageView qam;
  private Button qan;
  private LinearLayout qao;
  private TextView qap;
  private LinearLayout qaq;
  private TextView qar;
  private ImageView qas;
  private ImageView qat;
  private RelativeLayout qau;
  private ag qav;
  private com.tencent.mm.plugin.card.model.q qaw;
  private com.tencent.mm.ui.base.q tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void cvP()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.ixX, this.ixY, this.dSW, Boolean.FALSE);
    g.aAg().hqi.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.qan.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return 2131493365;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.qai = ((RelativeLayout)findViewById(2131298111));
    this.qaj = ((RelativeLayout)findViewById(2131298120));
    this.qak = ((ImageView)findViewById(2131298122));
    this.qal = ((TextView)findViewById(2131298123));
    this.hFg = ((TextView)findViewById(2131298118));
    this.qam = ((ImageView)findViewById(2131302902));
    this.qan = ((Button)findViewById(2131298125));
    this.qap = ((TextView)findViewById(2131298119));
    this.qar = ((TextView)findViewById(2131298121));
    this.qau = ((RelativeLayout)findViewById(2131298124));
    this.qas = ((ImageView)findViewById(2131298117));
    this.qat = ((ImageView)findViewById(2131307473));
    this.qao = ((LinearLayout)findViewById(2131305742));
    this.qaq = ((LinearLayout)findViewById(2131307474));
    this.qau.setOnClickListener(this);
    this.qai.setOnClickListener(this);
    this.qaj.setOnClickListener(this);
    this.qao.setOnClickListener(this);
    this.qaq.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(113308);
        if ((CardGiftAcceptUI.a(CardGiftAcceptUI.this) != null) && (CardGiftAcceptUI.a(CardGiftAcceptUI.this).isShowing())) {
          CardGiftAcceptUI.a(CardGiftAcceptUI.this).dismiss();
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        CardGiftAcceptUI.this.finish();
        AppMethodBeat.o(113308);
      }
    });
    ag localag = new ag(this.ixX, this.ixY, this.dSW);
    g.aAg().hqi.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113311);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113314);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView.getId() == 2131298125) || (paramView.getId() == 2131305742))
    {
      if (this.qan.getVisibility() == 0)
      {
        int i = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(2131100128)));
        fg(i, i);
        this.qan.setTextColor(getResources().getColor(2131101427));
      }
      cvP();
      if (!Util.isNullOrNil(this.dYs)) {
        com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(2), this.ixY, p.getString(this.ixX), this.dYs });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113314);
      return;
      if (paramView.getId() == 2131298124)
      {
        finish();
      }
      else if (paramView.getId() == 2131298111)
      {
        finish();
      }
      else if (paramView.getId() == 2131307474)
      {
        paramView = new com.tencent.mm.plugin.card.model.q(this.ixX, this.ixY, this.dSW, Boolean.TRUE);
        g.aAg().hqi.a(paramView, 0);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113309);
    super.onCreate(paramBundle);
    this.ixY = getIntent().getStringExtra("key_order_id");
    this.ixX = getIntent().getIntExtra("key_biz_uin", -1);
    this.dYs = getIntent().getStringExtra("key_from_user_name");
    this.dSW = getIntent().getStringExtra("key_chatroom_name");
    Log.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.ixY, Integer.valueOf(this.ixX), this.dYs });
    if (this.ixX == -1)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.ixY == null)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!Util.isNullOrNil(this.dYs)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(1), this.ixY, p.getString(this.ixX), this.dYs });
    }
    initView();
    g.aAg().hqi.a(1171, this);
    g.aAg().hqi.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    g.aAg().hqi.b(1171, this);
    g.aAg().hqi.b(1136, this);
    AppMethodBeat.o(113310);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113317);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113317);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113315);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ag))
      {
        this.qav = ((ag)paramq);
        Log.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.qav.pUu) });
        if (!this.qav.pUu)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.qav == null)
          {
            Log.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.qaj;
            paramq = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
            paramq.setDuration(300L);
            paramq.setInterpolator(new OvershootInterpolator());
            paramq.setFillAfter(true);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(100L);
            localScaleAnimation.setFillAfter(true);
            paramq.setAnimationListener(new n.3(paramString, localScaleAnimation));
            if (paramString != null) {
              paramString.startAnimation(paramq);
            }
            ao.q(this, getResources().getColor(2131099652));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.hFg.setText(this.qav.content);
          this.qal.setText(l.b(this, this.qav.dYs, this.qal.getTextSize()));
          if (this.qav.status == 0) {
            if (!Util.isNullOrNil(this.qav.pUt))
            {
              this.qan.setVisibility(0);
              this.qan.setText(this.qav.pUt);
              this.qan.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(this.qav.pUx))
            {
              this.qan.setVisibility(8);
              this.qaq.setVisibility(8);
              this.qao.setVisibility(0);
              this.qap.setText(this.qav.pUx);
            }
            if (!Util.isNullOrNil(this.qav.pUy))
            {
              this.qao.setVisibility(8);
              this.qaq.setVisibility(0);
              this.qar.setText(this.qav.pUy);
            }
            if (!Util.isNullOrNil(this.qav.pUs))
            {
              paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.aKJ();
              com.tencent.mm.av.q.bcW();
              paramString.jbw = null;
              paramString.fullPath = m.ajp(this.qav.pUs);
              paramString.jbf = true;
              paramString.iaT = true;
              paramString.jbx = paramInt1;
              paramString.jbd = true;
              paramString.jbq = 2131234198;
              paramString = paramString.bdv();
              com.tencent.mm.av.q.bcV().a(this.qav.pUs, this.qak, paramString);
            }
            if (!Util.isNullOrNil(this.qav.pUv)) {
              com.tencent.mm.av.q.bcV().loadImage(this.qav.pUv, this.qam);
            }
            if ((!Util.isNullOrNil(this.qav.pUw)) && (this.qan.getVisibility() == 0))
            {
              paramInt1 = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(2131100128)));
              fg(paramInt1, getResources().getColor(2131099653));
              this.qan.setTextColor(paramInt1);
            }
            if ((!Util.isNullOrNil(this.qav.pUw)) && (this.qap.getVisibility() == 0))
            {
              paramInt1 = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(2131100128)));
              this.qap.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100128);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.qav.pUw)) {
                paramInt1 = Util.convertStringToRGB(this.qav.pUw, paramInt2);
              }
              paramInt1 = ao.hT(paramInt1);
              this.qas.setImageDrawable(b(this.qas.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!Util.isNullOrNil(this.qav.pUw)) && (this.qar.getVisibility() == 0))
            {
              paramInt1 = ao.hT(Util.convertStringToRGB(this.qav.pUw, getResources().getColor(2131100128)));
              this.qar.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100128);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.qav.pUw)) {
                paramInt1 = Util.convertStringToRGB(this.qav.pUw, paramInt2);
              }
              paramInt1 = ao.hT(paramInt1);
              this.qat.setImageDrawable(b(this.qat.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.qan.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cb.a.fromDPToPix(this, 20);
              this.qan.setLayoutParams(paramString);
            }
            if ((this.qan.getVisibility() != 0) || (this.qaq.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.qan.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(this, 28);
            this.qan.setLayoutParams(paramString);
            break;
            this.qan.setVisibility(0);
            this.qan.setText(getResources().getString(2131757012));
            this.qan.setOnClickListener(this);
            continue;
            if ((this.qav.status != 1) && (this.qav.status == 2))
            {
              if (!Util.isNullOrNil(this.qav.pUt))
              {
                this.qan.setVisibility(0);
                this.qan.setBackgroundDrawable(null);
                this.qan.setText(this.qav.pUt);
                this.qan.setTextColor(getResources().getColor(2131100904));
                this.qan.setTextSize(1, 17.0F);
                this.qan.setOnClickListener(null);
              }
              else
              {
                this.qan.setVisibility(8);
                this.qan.setOnClickListener(null);
              }
            }
            else
            {
              this.qan.setVisibility(8);
              this.qan.setOnClickListener(null);
            }
          }
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        cvP();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.qaw = ((com.tencent.mm.plugin.card.model.q)paramq);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.ixY);
        paramString.putExtra("key_biz_uin", this.ixX);
        paramString.putExtra("key_gift_into", this.qaw.pUb);
        if (!Util.isNullOrNil(this.dSW)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(113315);
          return;
        }
      }
    }
    else
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramq instanceof ag))
      {
        Log.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.q))
      {
        Log.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
      }
    }
    AppMethodBeat.o(113315);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI
 * JD-Core Version:    0.7.0.1
 */