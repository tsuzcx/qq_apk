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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String dBh;
  private String dGJ;
  private TextView gOU;
  private int hDS;
  private String hDT;
  private LinearLayout oMA;
  private TextView oMB;
  private LinearLayout oMC;
  private TextView oMD;
  private ImageView oME;
  private ImageView oMF;
  private RelativeLayout oMG;
  private ag oMH;
  private com.tencent.mm.plugin.card.model.q oMI;
  private RelativeLayout oMu;
  private RelativeLayout oMv;
  private ImageView oMw;
  private TextView oMx;
  private ImageView oMy;
  private Button oMz;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void bXZ()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.hDS, this.hDT, this.dBh, Boolean.FALSE);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void eT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.oMz.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return 2131493276;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.oMu = ((RelativeLayout)findViewById(2131297796));
    this.oMv = ((RelativeLayout)findViewById(2131297805));
    this.oMw = ((ImageView)findViewById(2131297807));
    this.oMx = ((TextView)findViewById(2131297808));
    this.gOU = ((TextView)findViewById(2131297803));
    this.oMy = ((ImageView)findViewById(2131301218));
    this.oMz = ((Button)findViewById(2131297810));
    this.oMB = ((TextView)findViewById(2131297804));
    this.oMD = ((TextView)findViewById(2131297806));
    this.oMG = ((RelativeLayout)findViewById(2131297809));
    this.oME = ((ImageView)findViewById(2131297802));
    this.oMF = ((ImageView)findViewById(2131304477));
    this.oMA = ((LinearLayout)findViewById(2131303111));
    this.oMC = ((LinearLayout)findViewById(2131304478));
    this.oMG.setOnClickListener(this);
    this.oMu.setOnClickListener(this);
    this.oMv.setOnClickListener(this);
    this.oMA.setOnClickListener(this);
    this.oMC.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(113308);
        if ((CardGiftAcceptUI.a(CardGiftAcceptUI.this) != null) && (CardGiftAcceptUI.a(CardGiftAcceptUI.this).isShowing())) {
          CardGiftAcceptUI.a(CardGiftAcceptUI.this).dismiss();
        }
        ae.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        CardGiftAcceptUI.this.finish();
        AppMethodBeat.o(113308);
      }
    });
    ag localag = new ag(this.hDS, this.hDT, this.dBh);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localag, 0);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getId() == 2131297810) || (paramView.getId() == 2131303111))
    {
      if (this.oMz.getVisibility() == 0)
      {
        int i = al.gE(bu.cN(this.oMH.oGQ, getResources().getColor(2131100097)));
        eT(i, i);
        this.oMz.setTextColor(getResources().getColor(2131101182));
      }
      bXZ();
      if (!bu.isNullOrNil(this.dGJ)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(2), this.hDT, com.tencent.mm.b.p.getString(this.hDS), this.dGJ });
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
        paramView = new com.tencent.mm.plugin.card.model.q(this.hDS, this.hDT, this.dBh, Boolean.TRUE);
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
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
    this.hDT = getIntent().getStringExtra("key_order_id");
    this.hDS = getIntent().getIntExtra("key_biz_uin", -1);
    this.dGJ = getIntent().getStringExtra("key_from_user_name");
    this.dBh = getIntent().getStringExtra("key_chatroom_name");
    ae.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.hDT, Integer.valueOf(this.hDS), this.dGJ });
    if (this.hDS == -1)
    {
      ae.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.hDT == null)
    {
      ae.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!bu.isNullOrNil(this.dGJ)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(1), this.hDT, com.tencent.mm.b.p.getString(this.hDS), this.dGJ });
    }
    initView();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1171, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1171, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1136, this);
    AppMethodBeat.o(113310);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113317);
    if (paramInt == 4)
    {
      ae.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
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
        this.oMH = ((ag)paramn);
        ae.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.oMH.oGO) });
        if (!this.oMH.oGO)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.oMH == null)
          {
            ae.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.oMv;
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
          this.gOU.setText(this.oMH.content);
          this.oMx.setText(k.b(this, this.oMH.dGJ, this.oMx.getTextSize()));
          if (this.oMH.status == 0) {
            if (!bu.isNullOrNil(this.oMH.oGN))
            {
              this.oMz.setVisibility(0);
              this.oMz.setText(this.oMH.oGN);
              this.oMz.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!bu.isNullOrNil(this.oMH.oGR))
            {
              this.oMz.setVisibility(8);
              this.oMC.setVisibility(8);
              this.oMA.setVisibility(0);
              this.oMB.setText(this.oMH.oGR);
            }
            if (!bu.isNullOrNil(this.oMH.oGS))
            {
              this.oMA.setVisibility(8);
              this.oMC.setVisibility(0);
              this.oMD.setText(this.oMH.oGS);
            }
            if (!bu.isNullOrNil(this.oMH.oGM))
            {
              paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.asj();
              com.tencent.mm.av.q.aJc();
              paramString.igB = null;
              paramString.hgD = m.Zk(this.oMH.oGM);
              paramString.igk = true;
              paramString.hhW = true;
              paramString.igC = paramInt1;
              paramString.igi = true;
              paramString.igv = 2131233400;
              paramString = paramString.aJu();
              com.tencent.mm.av.q.aJb().a(this.oMH.oGM, this.oMw, paramString);
            }
            if (!bu.isNullOrNil(this.oMH.oGP)) {
              com.tencent.mm.av.q.aJb().loadImage(this.oMH.oGP, this.oMy);
            }
            if ((!bu.isNullOrNil(this.oMH.oGQ)) && (this.oMz.getVisibility() == 0))
            {
              paramInt1 = al.gE(bu.cN(this.oMH.oGQ, getResources().getColor(2131100097)));
              eT(paramInt1, getResources().getColor(2131099653));
              this.oMz.setTextColor(paramInt1);
            }
            if ((!bu.isNullOrNil(this.oMH.oGQ)) && (this.oMB.getVisibility() == 0))
            {
              paramInt1 = al.gE(bu.cN(this.oMH.oGQ, getResources().getColor(2131100097)));
              this.oMB.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bu.isNullOrNil(this.oMH.oGQ)) {
                paramInt1 = bu.cN(this.oMH.oGQ, paramInt2);
              }
              paramInt1 = al.gE(paramInt1);
              this.oME.setImageDrawable(b(this.oME.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!bu.isNullOrNil(this.oMH.oGQ)) && (this.oMD.getVisibility() == 0))
            {
              paramInt1 = al.gE(bu.cN(this.oMH.oGQ, getResources().getColor(2131100097)));
              this.oMD.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bu.isNullOrNil(this.oMH.oGQ)) {
                paramInt1 = bu.cN(this.oMH.oGQ, paramInt2);
              }
              paramInt1 = al.gE(paramInt1);
              this.oMF.setImageDrawable(b(this.oMF.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.oMz.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cb.a.fromDPToPix(this, 20);
              this.oMz.setLayoutParams(paramString);
            }
            if ((this.oMz.getVisibility() != 0) || (this.oMC.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.oMz.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(this, 28);
            this.oMz.setLayoutParams(paramString);
            break;
            this.oMz.setVisibility(0);
            this.oMz.setText(getResources().getString(2131756847));
            this.oMz.setOnClickListener(this);
            continue;
            if ((this.oMH.status != 1) && (this.oMH.status == 2))
            {
              if (!bu.isNullOrNil(this.oMH.oGN))
              {
                this.oMz.setVisibility(0);
                this.oMz.setBackgroundDrawable(null);
                this.oMz.setText(this.oMH.oGN);
                this.oMz.setTextColor(getResources().getColor(2131100711));
                this.oMz.setTextSize(1, 17.0F);
                this.oMz.setOnClickListener(null);
              }
              else
              {
                this.oMz.setVisibility(8);
                this.oMz.setOnClickListener(null);
              }
            }
            else
            {
              this.oMz.setVisibility(8);
              this.oMz.setOnClickListener(null);
            }
          }
        }
        ae.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        bXZ();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        ae.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.oMI = ((com.tencent.mm.plugin.card.model.q)paramn);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.hDT);
        paramString.putExtra("key_biz_uin", this.hDS);
        paramString.putExtra("key_gift_into", this.oMI.oGv);
        if (!bu.isNullOrNil(this.dBh)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
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
        ae.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        ae.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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