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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String dAc;
  private String dFE;
  private TextView gMl;
  private int hBe;
  private String hBf;
  private RelativeLayout oFS;
  private RelativeLayout oFT;
  private ImageView oFU;
  private TextView oFV;
  private ImageView oFW;
  private Button oFX;
  private LinearLayout oFY;
  private TextView oFZ;
  private LinearLayout oGa;
  private TextView oGb;
  private ImageView oGc;
  private ImageView oGd;
  private RelativeLayout oGe;
  private ag oGf;
  private com.tencent.mm.plugin.card.model.q oGg;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void bWK()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.hBe, this.hBf, this.dAc, Boolean.FALSE);
    com.tencent.mm.kernel.g.ajB().gAO.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.oFX.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return 2131493276;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.oFS = ((RelativeLayout)findViewById(2131297796));
    this.oFT = ((RelativeLayout)findViewById(2131297805));
    this.oFU = ((ImageView)findViewById(2131297807));
    this.oFV = ((TextView)findViewById(2131297808));
    this.gMl = ((TextView)findViewById(2131297803));
    this.oFW = ((ImageView)findViewById(2131301218));
    this.oFX = ((Button)findViewById(2131297810));
    this.oFZ = ((TextView)findViewById(2131297804));
    this.oGb = ((TextView)findViewById(2131297806));
    this.oGe = ((RelativeLayout)findViewById(2131297809));
    this.oGc = ((ImageView)findViewById(2131297802));
    this.oGd = ((ImageView)findViewById(2131304477));
    this.oFY = ((LinearLayout)findViewById(2131303111));
    this.oGa = ((LinearLayout)findViewById(2131304478));
    this.oGe.setOnClickListener(this);
    this.oFS.setOnClickListener(this);
    this.oFT.setOnClickListener(this);
    this.oFY.setOnClickListener(this);
    this.oGa.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
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
    ag localag = new ag(this.hBe, this.hBf, this.dAc);
    com.tencent.mm.kernel.g.ajB().gAO.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113311);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113314);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getId() == 2131297810) || (paramView.getId() == 2131303111))
    {
      if (this.oFX.getVisibility() == 0)
      {
        int i = al.gD(bt.cJ(this.oGf.oAo, getResources().getColor(2131100097)));
        eS(i, i);
        this.oFX.setTextColor(getResources().getColor(2131101182));
      }
      bWK();
      if (!bt.isNullOrNil(this.dFE)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(2), this.hBf, com.tencent.mm.b.p.getString(this.hBe), this.dFE });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113314);
      return;
      if (paramView.getId() == 2131297809)
      {
        finish();
      }
      else if (paramView.getId() == 2131297796)
      {
        finish();
      }
      else if (paramView.getId() == 2131304478)
      {
        paramView = new com.tencent.mm.plugin.card.model.q(this.hBe, this.hBf, this.dAc, Boolean.TRUE);
        com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
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
    this.hBf = getIntent().getStringExtra("key_order_id");
    this.hBe = getIntent().getIntExtra("key_biz_uin", -1);
    this.dFE = getIntent().getStringExtra("key_from_user_name");
    this.dAc = getIntent().getStringExtra("key_chatroom_name");
    ad.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.hBf, Integer.valueOf(this.hBe), this.dFE });
    if (this.hBe == -1)
    {
      ad.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.hBf == null)
    {
      ad.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!bt.isNullOrNil(this.dFE)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(1), this.hBf, com.tencent.mm.b.p.getString(this.hBe), this.dFE });
    }
    initView();
    com.tencent.mm.kernel.g.ajB().gAO.a(1171, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajB().gAO.b(1171, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1136, this);
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
        this.oGf = ((ag)paramn);
        ad.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.oGf.oAm) });
        if (!this.oGf.oAm)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.oGf == null)
          {
            ad.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.oFT;
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
            al.r(this, getResources().getColor(2131099652));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.gMl.setText(this.oGf.content);
          this.oFV.setText(k.b(this, this.oGf.dFE, this.oFV.getTextSize()));
          if (this.oGf.status == 0) {
            if (!bt.isNullOrNil(this.oGf.oAl))
            {
              this.oFX.setVisibility(0);
              this.oFX.setText(this.oGf.oAl);
              this.oFX.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!bt.isNullOrNil(this.oGf.oAp))
            {
              this.oFX.setVisibility(8);
              this.oGa.setVisibility(8);
              this.oFY.setVisibility(0);
              this.oFZ.setText(this.oGf.oAp);
            }
            if (!bt.isNullOrNil(this.oGf.oAq))
            {
              this.oFY.setVisibility(8);
              this.oGa.setVisibility(0);
              this.oGb.setText(this.oGf.oAq);
            }
            if (!bt.isNullOrNil(this.oGf.oAk))
            {
              paramInt1 = com.tencent.mm.cc.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.arU();
              com.tencent.mm.aw.q.aIK();
              paramString.idJ = null;
              paramString.hdP = m.Yt(this.oGf.oAk);
              paramString.idr = true;
              paramString.hfi = true;
              paramString.idK = paramInt1;
              paramString.idp = true;
              paramString.idD = 2131233400;
              paramString = paramString.aJc();
              com.tencent.mm.aw.q.aIJ().a(this.oGf.oAk, this.oFU, paramString);
            }
            if (!bt.isNullOrNil(this.oGf.oAn)) {
              com.tencent.mm.aw.q.aIJ().loadImage(this.oGf.oAn, this.oFW);
            }
            if ((!bt.isNullOrNil(this.oGf.oAo)) && (this.oFX.getVisibility() == 0))
            {
              paramInt1 = al.gD(bt.cJ(this.oGf.oAo, getResources().getColor(2131100097)));
              eS(paramInt1, getResources().getColor(2131099653));
              this.oFX.setTextColor(paramInt1);
            }
            if ((!bt.isNullOrNil(this.oGf.oAo)) && (this.oFZ.getVisibility() == 0))
            {
              paramInt1 = al.gD(bt.cJ(this.oGf.oAo, getResources().getColor(2131100097)));
              this.oFZ.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bt.isNullOrNil(this.oGf.oAo)) {
                paramInt1 = bt.cJ(this.oGf.oAo, paramInt2);
              }
              paramInt1 = al.gD(paramInt1);
              this.oGc.setImageDrawable(b(this.oGc.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!bt.isNullOrNil(this.oGf.oAo)) && (this.oGb.getVisibility() == 0))
            {
              paramInt1 = al.gD(bt.cJ(this.oGf.oAo, getResources().getColor(2131100097)));
              this.oGb.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bt.isNullOrNil(this.oGf.oAo)) {
                paramInt1 = bt.cJ(this.oGf.oAo, paramInt2);
              }
              paramInt1 = al.gD(paramInt1);
              this.oGd.setImageDrawable(b(this.oGd.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.oFX.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cc.a.fromDPToPix(this, 20);
              this.oFX.setLayoutParams(paramString);
            }
            if ((this.oFX.getVisibility() != 0) || (this.oGa.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.oFX.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cc.a.fromDPToPix(this, 28);
            this.oFX.setLayoutParams(paramString);
            break;
            this.oFX.setVisibility(0);
            this.oFX.setText(getResources().getString(2131756847));
            this.oFX.setOnClickListener(this);
            continue;
            if ((this.oGf.status != 1) && (this.oGf.status == 2))
            {
              if (!bt.isNullOrNil(this.oGf.oAl))
              {
                this.oFX.setVisibility(0);
                this.oFX.setBackgroundDrawable(null);
                this.oFX.setText(this.oGf.oAl);
                this.oFX.setTextColor(getResources().getColor(2131100711));
                this.oFX.setTextSize(1, 17.0F);
                this.oFX.setOnClickListener(null);
              }
              else
              {
                this.oFX.setVisibility(8);
                this.oFX.setOnClickListener(null);
              }
            }
            else
            {
              this.oFX.setVisibility(8);
              this.oFX.setOnClickListener(null);
            }
          }
        }
        ad.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        bWK();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        ad.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.oGg = ((com.tencent.mm.plugin.card.model.q)paramn);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.hBf);
        paramString.putExtra("key_biz_uin", this.hBe);
        paramString.putExtra("key_gift_into", this.oGg.ozT);
        if (!bt.isNullOrNil(this.dAc)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
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