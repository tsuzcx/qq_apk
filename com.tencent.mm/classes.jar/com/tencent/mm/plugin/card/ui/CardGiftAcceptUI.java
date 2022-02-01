package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.am.h
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String hBy;
  private String hYg;
  private TextView mXd;
  private int nSr;
  private String nSs;
  private w tipDialog = null;
  private RelativeLayout wAC;
  private RelativeLayout wAD;
  private ImageView wAE;
  private TextView wAF;
  private ImageView wAG;
  private Button wAH;
  private LinearLayout wAI;
  private TextView wAJ;
  private LinearLayout wAK;
  private TextView wAL;
  private ImageView wAM;
  private ImageView wAN;
  private RelativeLayout wAO;
  private ag wAP;
  private q wAQ;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = androidx.core.graphics.drawable.a.s(paramDrawable);
    androidx.core.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void dmI()
  {
    AppMethodBeat.i(113316);
    q localq = new q(this.nSr, this.nSs, this.hBy, Boolean.FALSE);
    com.tencent.mm.kernel.h.baD().mCm.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void gv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.wAH.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return a.e.wmA;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.wAC = ((RelativeLayout)findViewById(a.d.wgl));
    this.wAD = ((RelativeLayout)findViewById(a.d.wgs));
    this.wAE = ((ImageView)findViewById(a.d.wgu));
    this.wAF = ((TextView)findViewById(a.d.wgv));
    this.mXd = ((TextView)findViewById(a.d.wgq));
    this.wAG = ((ImageView)findViewById(a.d.wkv));
    this.wAH = ((Button)findViewById(a.d.wgx));
    this.wAJ = ((TextView)findViewById(a.d.wgr));
    this.wAL = ((TextView)findViewById(a.d.wgt));
    this.wAO = ((RelativeLayout)findViewById(a.d.wgw));
    this.wAM = ((ImageView)findViewById(a.d.wgp));
    this.wAN = ((ImageView)findViewById(a.d.wlb));
    this.wAI = ((LinearLayout)findViewById(a.d.wkL));
    this.wAK = ((LinearLayout)findViewById(a.d.wlc));
    this.wAO.setOnClickListener(this);
    this.wAC.setOnClickListener(this);
    this.wAD.setOnClickListener(this);
    this.wAI.setOnClickListener(this);
    this.wAK.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = k.a(getContext(), getString(a.g.loading_tips), true, new DialogInterface.OnCancelListener()
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
    ag localag = new ag(this.nSr, this.nSs, this.hBy);
    com.tencent.mm.kernel.h.baD().mCm.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113311);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113314);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getId() == a.d.wgx) || (paramView.getId() == a.d.wkL))
    {
      if (this.wAH.getVisibility() == 0)
      {
        int i = aw.mx(Util.convertStringToRGB(this.wAP.wuW, getResources().getColor(a.a.wdF)));
        gv(i, i);
        this.wAH.setTextColor(getResources().getColor(a.a.white_text_color));
      }
      dmI();
      if (!Util.isNullOrNil(this.hYg)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(2), this.nSs, com.tencent.mm.b.p.getString(this.nSr), this.hYg });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113314);
      return;
      if (paramView.getId() == a.d.wgw)
      {
        finish();
      }
      else if (paramView.getId() == a.d.wgl)
      {
        finish();
      }
      else if (paramView.getId() == a.d.wlc)
      {
        paramView = new q(this.nSr, this.nSs, this.hBy, Boolean.TRUE);
        com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
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
    this.nSs = getIntent().getStringExtra("key_order_id");
    this.nSr = getIntent().getIntExtra("key_biz_uin", -1);
    this.hYg = getIntent().getStringExtra("key_from_user_name");
    this.hBy = getIntent().getStringExtra("key_chatroom_name");
    Log.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.nSs, Integer.valueOf(this.nSr), this.hYg });
    if (this.nSr == -1)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.nSs == null)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!Util.isNullOrNil(this.hYg)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(1), this.nSs, com.tencent.mm.b.p.getString(this.nSr), this.hYg });
    }
    initView();
    com.tencent.mm.kernel.h.baD().mCm.a(1171, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(1171, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1136, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(113315);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ag))
      {
        this.wAP = ((ag)paramp);
        Log.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.wAP.wuU) });
        if (!this.wAP.wuU)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.wAP == null)
          {
            Log.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.wAD;
            paramp = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
            paramp.setDuration(300L);
            paramp.setInterpolator(new OvershootInterpolator());
            paramp.setFillAfter(true);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(100L);
            localScaleAnimation.setFillAfter(true);
            paramp.setAnimationListener(new n.3(paramString, localScaleAnimation));
            if (paramString != null) {
              paramString.startAnimation(paramp);
            }
            aw.t(this, getResources().getColor(a.a.BG_4));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.mXd.setText(this.wAP.content);
          this.wAF.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.wAP.hYg, this.wAF.getTextSize()));
          if (this.wAP.status == 0) {
            if (!Util.isNullOrNil(this.wAP.wuT))
            {
              this.wAH.setVisibility(0);
              this.wAH.setText(this.wAP.wuT);
              this.wAH.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(this.wAP.wuX))
            {
              this.wAH.setVisibility(8);
              this.wAK.setVisibility(8);
              this.wAI.setVisibility(0);
              this.wAJ.setText(this.wAP.wuX);
            }
            if (!Util.isNullOrNil(this.wAP.wuY))
            {
              this.wAI.setVisibility(8);
              this.wAK.setVisibility(0);
              this.wAL.setText(this.wAP.wuY);
            }
            if (!Util.isNullOrNil(this.wAP.wuS))
            {
              paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.i.b.bmz();
              paramString.oKH = r.bKf();
              paramString.fullPath = m.akH(this.wAP.wuS);
              paramString.oKp = true;
              paramString.nrc = true;
              paramString.oKI = paramInt1;
              paramString.oKn = true;
              paramString.oKB = a.c.my_card_package_defaultlogo;
              paramString = paramString.bKx();
              r.bKe().a(this.wAP.wuS, this.wAE, paramString);
            }
            if (!Util.isNullOrNil(this.wAP.wuV)) {
              r.bKe().loadImage(this.wAP.wuV, this.wAG);
            }
            if ((!Util.isNullOrNil(this.wAP.wuW)) && (this.wAH.getVisibility() == 0))
            {
              paramInt1 = aw.mx(Util.convertStringToRGB(this.wAP.wuW, getResources().getColor(a.a.wdF)));
              gv(paramInt1, getResources().getColor(a.a.BG_5));
              this.wAH.setTextColor(paramInt1);
            }
            if ((!Util.isNullOrNil(this.wAP.wuW)) && (this.wAJ.getVisibility() == 0))
            {
              paramInt1 = aw.mx(Util.convertStringToRGB(this.wAP.wuW, getResources().getColor(a.a.wdF)));
              this.wAJ.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(a.a.wdF);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.wAP.wuW)) {
                paramInt1 = Util.convertStringToRGB(this.wAP.wuW, paramInt2);
              }
              paramInt1 = aw.mx(paramInt1);
              this.wAM.setImageDrawable(b(this.wAM.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!Util.isNullOrNil(this.wAP.wuW)) && (this.wAL.getVisibility() == 0))
            {
              paramInt1 = aw.mx(Util.convertStringToRGB(this.wAP.wuW, getResources().getColor(a.a.wdF)));
              this.wAL.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(a.a.wdF);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.wAP.wuW)) {
                paramInt1 = Util.convertStringToRGB(this.wAP.wuW, paramInt2);
              }
              paramInt1 = aw.mx(paramInt1);
              this.wAN.setImageDrawable(b(this.wAN.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.wAH.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cd.a.fromDPToPix(this, 20);
              this.wAH.setLayoutParams(paramString);
            }
            if ((this.wAH.getVisibility() != 0) || (this.wAK.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.wAH.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cd.a.fromDPToPix(this, 28);
            this.wAH.setLayoutParams(paramString);
            break;
            this.wAH.setVisibility(0);
            this.wAH.setText(getResources().getString(a.g.woG));
            this.wAH.setOnClickListener(this);
            continue;
            if ((this.wAP.status != 1) && (this.wAP.status == 2))
            {
              if (!Util.isNullOrNil(this.wAP.wuT))
              {
                this.wAH.setVisibility(0);
                this.wAH.setBackgroundDrawable(null);
                this.wAH.setText(this.wAP.wuT);
                this.wAH.setTextColor(getResources().getColor(a.a.normal_text_color));
                this.wAH.setTextSize(1, 17.0F);
                this.wAH.setOnClickListener(null);
              }
              else
              {
                this.wAH.setVisibility(8);
                this.wAH.setOnClickListener(null);
              }
            }
            else
            {
              this.wAH.setVisibility(8);
              this.wAH.setOnClickListener(null);
            }
          }
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        dmI();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramp instanceof q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.wAQ = ((q)paramp);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.nSs);
        paramString.putExtra("key_biz_uin", this.nSr);
        paramString.putExtra("key_gift_into", this.wAQ.wuB);
        if (!Util.isNullOrNil(this.hBy)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      if ((paramp instanceof ag))
      {
        Log.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramp instanceof q))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI
 * JD-Core Version:    0.7.0.1
 */