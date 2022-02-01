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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.al.g
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String dqD;
  private String dvQ;
  private int gIu;
  private String gIv;
  private ImageView nzA;
  private TextView nzB;
  private TextView nzC;
  private ImageView nzD;
  private Button nzE;
  private LinearLayout nzF;
  private TextView nzG;
  private LinearLayout nzH;
  private TextView nzI;
  private ImageView nzJ;
  private ImageView nzK;
  private RelativeLayout nzL;
  private ag nzM;
  private com.tencent.mm.plugin.card.model.q nzN;
  private RelativeLayout nzy;
  private RelativeLayout nzz;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void bKS()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.gIu, this.gIv, this.dqD, Boolean.FALSE);
    com.tencent.mm.kernel.g.afA().gcy.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.nzE.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return 2131493276;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.nzy = ((RelativeLayout)findViewById(2131297796));
    this.nzz = ((RelativeLayout)findViewById(2131297805));
    this.nzA = ((ImageView)findViewById(2131297807));
    this.nzB = ((TextView)findViewById(2131297808));
    this.nzC = ((TextView)findViewById(2131297803));
    this.nzD = ((ImageView)findViewById(2131301218));
    this.nzE = ((Button)findViewById(2131297810));
    this.nzG = ((TextView)findViewById(2131297804));
    this.nzI = ((TextView)findViewById(2131297806));
    this.nzL = ((RelativeLayout)findViewById(2131297809));
    this.nzJ = ((ImageView)findViewById(2131297802));
    this.nzK = ((ImageView)findViewById(2131304477));
    this.nzF = ((LinearLayout)findViewById(2131303111));
    this.nzH = ((LinearLayout)findViewById(2131304478));
    this.nzL.setOnClickListener(this);
    this.nzy.setOnClickListener(this);
    this.nzz.setOnClickListener(this);
    this.nzF.setOnClickListener(this);
    this.nzH.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(113308);
        if ((CardGiftAcceptUI.a(CardGiftAcceptUI.this) != null) && (CardGiftAcceptUI.a(CardGiftAcceptUI.this).isShowing())) {
          CardGiftAcceptUI.a(CardGiftAcceptUI.this).dismiss();
        }
        ad.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        CardGiftAcceptUI.this.finish();
        AppMethodBeat.o(113308);
      }
    });
    ag localag = new ag(this.gIu, this.gIv, this.dqD);
    com.tencent.mm.kernel.g.afA().gcy.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113311);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113314);
    if ((paramView.getId() == 2131297810) || (paramView.getId() == 2131303111))
    {
      if (this.nzE.getVisibility() == 0)
      {
        int i = ai.gO(bt.cB(this.nzM.ntU, getResources().getColor(2131100097)));
        eL(i, i);
        this.nzE.setTextColor(getResources().getColor(2131101182));
      }
      bKS();
      if (!bt.isNullOrNil(this.dvQ))
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(2), this.gIv, com.tencent.mm.b.p.getString(this.gIu), this.dvQ });
        AppMethodBeat.o(113314);
      }
    }
    else
    {
      if (paramView.getId() == 2131297809)
      {
        finish();
        AppMethodBeat.o(113314);
        return;
      }
      if (paramView.getId() == 2131297796)
      {
        finish();
        AppMethodBeat.o(113314);
        return;
      }
      if (paramView.getId() == 2131304478)
      {
        paramView = new com.tencent.mm.plugin.card.model.q(this.gIu, this.gIv, this.dqD, Boolean.TRUE);
        com.tencent.mm.kernel.g.afA().gcy.a(paramView, 0);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
      }
    }
    AppMethodBeat.o(113314);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113309);
    super.onCreate(paramBundle);
    this.gIv = getIntent().getStringExtra("key_order_id");
    this.gIu = getIntent().getIntExtra("key_biz_uin", -1);
    this.dvQ = getIntent().getStringExtra("key_from_user_name");
    this.dqD = getIntent().getStringExtra("key_chatroom_name");
    ad.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.gIv, Integer.valueOf(this.gIu), this.dvQ });
    if (this.gIu == -1)
    {
      ad.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.gIv == null)
    {
      ad.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!bt.isNullOrNil(this.dvQ)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(1), this.gIv, com.tencent.mm.b.p.getString(this.gIu), this.dvQ });
    }
    initView();
    com.tencent.mm.kernel.g.afA().gcy.a(1171, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.g.afA().gcy.b(1171, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1136, this);
    AppMethodBeat.o(113310);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113317);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113317);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113315);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ag))
      {
        this.nzM = ((ag)paramn);
        ad.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.nzM.ntS) });
        if (!this.nzM.ntS)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.nzM == null)
          {
            ad.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.nzz;
            paramn = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
            paramn.setDuration(300L);
            paramn.setInterpolator(new OvershootInterpolator());
            paramn.setFillAfter(true);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(100L);
            localScaleAnimation.setFillAfter(true);
            paramn.setAnimationListener(new n.3(paramString, localScaleAnimation));
            if (paramString != null) {
              paramString.startAnimation(paramn);
            }
            ai.r(this, getResources().getColor(2131099652));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.nzC.setText(this.nzM.content);
          this.nzB.setText(k.b(this, this.nzM.dvQ, this.nzB.getTextSize()));
          if (this.nzM.status == 0) {
            if (!bt.isNullOrNil(this.nzM.ntR))
            {
              this.nzE.setVisibility(0);
              this.nzE.setText(this.nzM.ntR);
              this.nzE.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!bt.isNullOrNil(this.nzM.ntV))
            {
              this.nzE.setVisibility(8);
              this.nzH.setVisibility(8);
              this.nzF.setVisibility(0);
              this.nzG.setText(this.nzM.ntV);
            }
            if (!bt.isNullOrNil(this.nzM.ntW))
            {
              this.nzF.setVisibility(8);
              this.nzH.setVisibility(0);
              this.nzI.setText(this.nzM.ntW);
            }
            if (!bt.isNullOrNil(this.nzM.ntQ))
            {
              paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.aih();
              o.ayK();
              paramString.hkl = null;
              paramString.gjt = m.Qy(this.nzM.ntQ);
              paramString.hjU = true;
              paramString.gkG = true;
              paramString.hkm = paramInt1;
              paramString.hjS = true;
              paramString.hkf = 2131233400;
              paramString = paramString.azc();
              o.ayJ().a(this.nzM.ntQ, this.nzA, paramString);
            }
            if (!bt.isNullOrNil(this.nzM.ntT)) {
              o.ayJ().loadImage(this.nzM.ntT, this.nzD);
            }
            if ((!bt.isNullOrNil(this.nzM.ntU)) && (this.nzE.getVisibility() == 0))
            {
              paramInt1 = ai.gO(bt.cB(this.nzM.ntU, getResources().getColor(2131100097)));
              eL(paramInt1, getResources().getColor(2131099653));
              this.nzE.setTextColor(paramInt1);
            }
            if ((!bt.isNullOrNil(this.nzM.ntU)) && (this.nzG.getVisibility() == 0))
            {
              paramInt1 = ai.gO(bt.cB(this.nzM.ntU, getResources().getColor(2131100097)));
              this.nzG.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bt.isNullOrNil(this.nzM.ntU)) {
                paramInt1 = bt.cB(this.nzM.ntU, paramInt2);
              }
              paramInt1 = ai.gO(paramInt1);
              this.nzJ.setImageDrawable(b(this.nzJ.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!bt.isNullOrNil(this.nzM.ntU)) && (this.nzI.getVisibility() == 0))
            {
              paramInt1 = ai.gO(bt.cB(this.nzM.ntU, getResources().getColor(2131100097)));
              this.nzI.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bt.isNullOrNil(this.nzM.ntU)) {
                paramInt1 = bt.cB(this.nzM.ntU, paramInt2);
              }
              paramInt1 = ai.gO(paramInt1);
              this.nzK.setImageDrawable(b(this.nzK.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.nzE.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cd.a.fromDPToPix(this, 20);
              this.nzE.setLayoutParams(paramString);
            }
            if ((this.nzE.getVisibility() != 0) || (this.nzH.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.nzE.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cd.a.fromDPToPix(this, 28);
            this.nzE.setLayoutParams(paramString);
            break;
            this.nzE.setVisibility(0);
            this.nzE.setText(getResources().getString(2131756847));
            this.nzE.setOnClickListener(this);
            continue;
            if ((this.nzM.status != 1) && (this.nzM.status == 2))
            {
              if (!bt.isNullOrNil(this.nzM.ntR))
              {
                this.nzE.setVisibility(0);
                this.nzE.setBackgroundDrawable(null);
                this.nzE.setText(this.nzM.ntR);
                this.nzE.setTextColor(getResources().getColor(2131100711));
                this.nzE.setTextSize(1, 17.0F);
                this.nzE.setOnClickListener(null);
              }
              else
              {
                this.nzE.setVisibility(8);
                this.nzE.setOnClickListener(null);
              }
            }
            else
            {
              this.nzE.setVisibility(8);
              this.nzE.setOnClickListener(null);
            }
          }
        }
        ad.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        bKS();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        ad.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.nzN = ((com.tencent.mm.plugin.card.model.q)paramn);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.gIv);
        paramString.putExtra("key_biz_uin", this.gIu);
        paramString.putExtra("key_gift_into", this.nzN.ntz);
        if (!bt.isNullOrNil(this.dqD)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lS(0));
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
      if ((paramn instanceof ag))
      {
        ad.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        ad.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI
 * JD-Core Version:    0.7.0.1
 */