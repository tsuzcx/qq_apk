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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ak.g
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String doo;
  private String dtD;
  private TextView gsA;
  private int hiV;
  private String hiW;
  private RelativeLayout ocA;
  private ImageView ocB;
  private TextView ocC;
  private ImageView ocD;
  private Button ocE;
  private LinearLayout ocF;
  private TextView ocG;
  private LinearLayout ocH;
  private TextView ocI;
  private ImageView ocJ;
  private ImageView ocK;
  private RelativeLayout ocL;
  private ag ocM;
  private com.tencent.mm.plugin.card.model.q ocN;
  private RelativeLayout ocz;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void bSf()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.hiV, this.hiW, this.doo, Boolean.FALSE);
    com.tencent.mm.kernel.g.agQ().ghe.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.ocE.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return 2131493276;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.ocz = ((RelativeLayout)findViewById(2131297796));
    this.ocA = ((RelativeLayout)findViewById(2131297805));
    this.ocB = ((ImageView)findViewById(2131297807));
    this.ocC = ((TextView)findViewById(2131297808));
    this.gsA = ((TextView)findViewById(2131297803));
    this.ocD = ((ImageView)findViewById(2131301218));
    this.ocE = ((Button)findViewById(2131297810));
    this.ocG = ((TextView)findViewById(2131297804));
    this.ocI = ((TextView)findViewById(2131297806));
    this.ocL = ((RelativeLayout)findViewById(2131297809));
    this.ocJ = ((ImageView)findViewById(2131297802));
    this.ocK = ((ImageView)findViewById(2131304477));
    this.ocF = ((LinearLayout)findViewById(2131303111));
    this.ocH = ((LinearLayout)findViewById(2131304478));
    this.ocL.setOnClickListener(this);
    this.ocz.setOnClickListener(this);
    this.ocA.setOnClickListener(this);
    this.ocF.setOnClickListener(this);
    this.ocH.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(113308);
        if ((CardGiftAcceptUI.a(CardGiftAcceptUI.this) != null) && (CardGiftAcceptUI.a(CardGiftAcceptUI.this).isShowing())) {
          CardGiftAcceptUI.a(CardGiftAcceptUI.this).dismiss();
        }
        ac.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
        CardGiftAcceptUI.this.finish();
        AppMethodBeat.o(113308);
      }
    });
    ag localag = new ag(this.hiV, this.hiW, this.doo);
    com.tencent.mm.kernel.g.agQ().ghe.a(localag, 0);
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
      if (this.ocE.getVisibility() == 0)
      {
        int i = aj.gy(bs.cG(this.ocM.nWU, getResources().getColor(2131100097)));
        eO(i, i);
        this.ocE.setTextColor(getResources().getColor(2131101182));
      }
      bSf();
      if (!bs.isNullOrNil(this.dtD))
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(2), this.hiW, com.tencent.mm.b.p.getString(this.hiV), this.dtD });
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
        paramView = new com.tencent.mm.plugin.card.model.q(this.hiV, this.hiW, this.doo, Boolean.TRUE);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramView, 0);
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
    this.hiW = getIntent().getStringExtra("key_order_id");
    this.hiV = getIntent().getIntExtra("key_biz_uin", -1);
    this.dtD = getIntent().getStringExtra("key_from_user_name");
    this.doo = getIntent().getStringExtra("key_chatroom_name");
    ac.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.hiW, Integer.valueOf(this.hiV), this.dtD });
    if (this.hiV == -1)
    {
      ac.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.hiW == null)
    {
      ac.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!bs.isNullOrNil(this.dtD)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(1), this.hiW, com.tencent.mm.b.p.getString(this.hiV), this.dtD });
    }
    initView();
    com.tencent.mm.kernel.g.agQ().ghe.a(1171, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(1171, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1136, this);
    AppMethodBeat.o(113310);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113317);
    if (paramInt == 4)
    {
      ac.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
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
        this.ocM = ((ag)paramn);
        ac.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.ocM.nWS) });
        if (!this.ocM.nWS)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.ocM == null)
          {
            ac.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.ocA;
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
            aj.r(this, getResources().getColor(2131099652));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.gsA.setText(this.ocM.content);
          this.ocC.setText(k.b(this, this.ocM.dtD, this.ocC.getTextSize()));
          if (this.ocM.status == 0) {
            if (!bs.isNullOrNil(this.ocM.nWR))
            {
              this.ocE.setVisibility(0);
              this.ocE.setText(this.ocM.nWR);
              this.ocE.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!bs.isNullOrNil(this.ocM.nWV))
            {
              this.ocE.setVisibility(8);
              this.ocH.setVisibility(8);
              this.ocF.setVisibility(0);
              this.ocG.setText(this.ocM.nWV);
            }
            if (!bs.isNullOrNil(this.ocM.nWW))
            {
              this.ocF.setVisibility(8);
              this.ocH.setVisibility(0);
              this.ocI.setText(this.ocM.nWW);
            }
            if (!bs.isNullOrNil(this.ocM.nWQ))
            {
              paramInt1 = com.tencent.mm.cc.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.aph();
              o.aFC();
              paramString.hKO = null;
              paramString.gKe = m.UK(this.ocM.nWQ);
              paramString.hKx = true;
              paramString.gLt = true;
              paramString.hKP = paramInt1;
              paramString.hKv = true;
              paramString.hKI = 2131233400;
              paramString = paramString.aFT();
              o.aFB().a(this.ocM.nWQ, this.ocB, paramString);
            }
            if (!bs.isNullOrNil(this.ocM.nWT)) {
              o.aFB().loadImage(this.ocM.nWT, this.ocD);
            }
            if ((!bs.isNullOrNil(this.ocM.nWU)) && (this.ocE.getVisibility() == 0))
            {
              paramInt1 = aj.gy(bs.cG(this.ocM.nWU, getResources().getColor(2131100097)));
              eO(paramInt1, getResources().getColor(2131099653));
              this.ocE.setTextColor(paramInt1);
            }
            if ((!bs.isNullOrNil(this.ocM.nWU)) && (this.ocG.getVisibility() == 0))
            {
              paramInt1 = aj.gy(bs.cG(this.ocM.nWU, getResources().getColor(2131100097)));
              this.ocG.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bs.isNullOrNil(this.ocM.nWU)) {
                paramInt1 = bs.cG(this.ocM.nWU, paramInt2);
              }
              paramInt1 = aj.gy(paramInt1);
              this.ocJ.setImageDrawable(b(this.ocJ.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!bs.isNullOrNil(this.ocM.nWU)) && (this.ocI.getVisibility() == 0))
            {
              paramInt1 = aj.gy(bs.cG(this.ocM.nWU, getResources().getColor(2131100097)));
              this.ocI.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131100097);
              paramInt1 = paramInt2;
              if (!bs.isNullOrNil(this.ocM.nWU)) {
                paramInt1 = bs.cG(this.ocM.nWU, paramInt2);
              }
              paramInt1 = aj.gy(paramInt1);
              this.ocK.setImageDrawable(b(this.ocK.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.ocE.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cc.a.fromDPToPix(this, 20);
              this.ocE.setLayoutParams(paramString);
            }
            if ((this.ocE.getVisibility() != 0) || (this.ocH.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.ocE.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cc.a.fromDPToPix(this, 28);
            this.ocE.setLayoutParams(paramString);
            break;
            this.ocE.setVisibility(0);
            this.ocE.setText(getResources().getString(2131756847));
            this.ocE.setOnClickListener(this);
            continue;
            if ((this.ocM.status != 1) && (this.ocM.status == 2))
            {
              if (!bs.isNullOrNil(this.ocM.nWR))
              {
                this.ocE.setVisibility(0);
                this.ocE.setBackgroundDrawable(null);
                this.ocE.setText(this.ocM.nWR);
                this.ocE.setTextColor(getResources().getColor(2131100711));
                this.ocE.setTextSize(1, 17.0F);
                this.ocE.setOnClickListener(null);
              }
              else
              {
                this.ocE.setVisibility(8);
                this.ocE.setOnClickListener(null);
              }
            }
            else
            {
              this.ocE.setVisibility(8);
              this.ocE.setOnClickListener(null);
            }
          }
        }
        ac.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        bSf();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        ac.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.ocN = ((com.tencent.mm.plugin.card.model.q)paramn);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.hiW);
        paramString.putExtra("key_biz_uin", this.hiV);
        paramString.putExtra("key_gift_into", this.ocN.nWz);
        if (!bs.isNullOrNil(this.doo)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
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
        ac.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.q))
      {
        ac.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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