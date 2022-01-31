package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
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
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.m.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String cAu;
  private String cFh;
  private int fhN;
  private String fhO;
  private RelativeLayout kui;
  private RelativeLayout kuj;
  private ImageView kuk;
  private TextView kul;
  private TextView kum;
  private ImageView kun;
  private Button kuo;
  private LinearLayout kup;
  private TextView kuq;
  private LinearLayout kur;
  private TextView kus;
  private ImageView kut;
  private ImageView kuu;
  private RelativeLayout kuv;
  private ag kuw;
  private q kux;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(88386);
    paramDrawable = android.support.v4.graphics.drawable.a.e(paramDrawable);
    android.support.v4.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(88386);
    return paramDrawable;
  }
  
  private void bdU()
  {
    AppMethodBeat.i(88391);
    q localq = new q(this.fhN, this.fhO, this.cAu, Boolean.FALSE);
    g.RK().eHt.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(88391);
  }
  
  private void dO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88387);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.kuo.setBackground(localGradientDrawable);
    AppMethodBeat.o(88387);
  }
  
  public int getLayoutId()
  {
    return 2130968934;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88390);
    this.kui = ((RelativeLayout)findViewById(2131822114));
    this.kuj = ((RelativeLayout)findViewById(2131822108));
    this.kuk = ((ImageView)findViewById(2131822109));
    this.kul = ((TextView)findViewById(2131822110));
    this.kum = ((TextView)findViewById(2131822111));
    this.kun = ((ImageView)findViewById(2131822115));
    this.kuo = ((Button)findViewById(2131822112));
    this.kuq = ((TextView)findViewById(2131822120));
    this.kus = ((TextView)findViewById(2131822117));
    this.kuv = ((RelativeLayout)findViewById(2131822113));
    this.kut = ((ImageView)findViewById(2131822121));
    this.kuu = ((ImageView)findViewById(2131822118));
    this.kup = ((LinearLayout)findViewById(2131822119));
    this.kur = ((LinearLayout)findViewById(2131822116));
    this.kuv.setOnClickListener(this);
    this.kui.setOnClickListener(this);
    this.kuj.setOnClickListener(this);
    this.kup.setOnClickListener(this);
    this.kur.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131301086), true, new CardGiftAcceptUI.1(this));
    ag localag = new ag(this.fhN, this.fhO, this.cAu);
    g.RK().eHt.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(88390);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(88388);
    if ((paramView.getId() == 2131822112) || (paramView.getId() == 2131822119))
    {
      if (this.kuo.getVisibility() == 0)
      {
        int i = bo.bS(this.kuw.koH, getResources().getColor(2131689837));
        dO(i, i);
        this.kuo.setTextColor(getResources().getColor(2131690709));
      }
      bdU();
      if (!bo.isNullOrNil(this.cFh))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(2), this.fhO, com.tencent.mm.a.p.getString(this.fhN), this.cFh });
        AppMethodBeat.o(88388);
      }
    }
    else
    {
      if (paramView.getId() == 2131822113)
      {
        finish();
        AppMethodBeat.o(88388);
        return;
      }
      if (paramView.getId() == 2131822114)
      {
        finish();
        AppMethodBeat.o(88388);
        return;
      }
      if (paramView.getId() == 2131822116)
      {
        paramView = new q(this.fhN, this.fhO, this.cAu, Boolean.TRUE);
        g.RK().eHt.a(paramView, 0);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
      }
    }
    AppMethodBeat.o(88388);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88383);
    super.onCreate(paramBundle);
    this.fhO = getIntent().getStringExtra("key_order_id");
    this.fhN = getIntent().getIntExtra("key_biz_uin", -1);
    this.cFh = getIntent().getStringExtra("key_from_user_name");
    this.cAu = getIntent().getStringExtra("key_chatroom_name");
    ab.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.fhO, Integer.valueOf(this.fhN), this.cFh });
    if (this.fhN == -1)
    {
      ab.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(88383);
      return;
    }
    if (this.fhO == null)
    {
      ab.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(88383);
      return;
    }
    if (!bo.isNullOrNil(this.cFh)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(1), this.fhO, com.tencent.mm.a.p.getString(this.fhN), this.cFh });
    }
    initView();
    g.RK().eHt.a(1171, this);
    g.RK().eHt.a(1136, this);
    AppMethodBeat.o(88383);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88384);
    super.onDestroy();
    g.RK().eHt.b(1171, this);
    g.RK().eHt.b(1136, this);
    AppMethodBeat.o(88384);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88392);
    if (paramInt == 4)
    {
      ab.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88392);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88389);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof ag))
      {
        this.kuw = ((ag)paramm);
        ab.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.kuw.koF) });
        if (!this.kuw.koF)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.kuw == null)
          {
            ab.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.kuj;
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
            getContentView().setVisibility(0);
            AppMethodBeat.o(88389);
            return;
          }
          this.kum.setText(this.kuw.content);
          this.kul.setText(j.b(this, this.kuw.cFh, this.kul.getTextSize()));
          if (this.kuw.status == 0) {
            if (!bo.isNullOrNil(this.kuw.koE))
            {
              this.kuo.setVisibility(0);
              this.kuo.setText(this.kuw.koE);
              this.kuo.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!bo.isNullOrNil(this.kuw.koI))
            {
              this.kuo.setVisibility(8);
              this.kur.setVisibility(8);
              this.kup.setVisibility(0);
              this.kuq.setText(this.kuw.koI);
            }
            if (!bo.isNullOrNil(this.kuw.koJ))
            {
              this.kup.setVisibility(8);
              this.kur.setVisibility(0);
              this.kus.setText(this.kuw.koJ);
            }
            if (!bo.isNullOrNil(this.kuw.koD))
            {
              paramInt1 = com.tencent.mm.cb.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.eNP = e.eQz;
              o.ahH();
              paramString.eOd = null;
              paramString.eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuw.koD);
              paramString.eNM = true;
              paramString.eOk = true;
              paramString.eOl = paramInt1;
              paramString.eNK = true;
              paramString.eNY = 2130839758;
              paramString = paramString.ahY();
              o.ahG().a(this.kuw.koD, this.kuk, paramString);
            }
            if (!bo.isNullOrNil(this.kuw.koG)) {
              o.ahG().a(this.kuw.koG, this.kun);
            }
            if ((!bo.isNullOrNil(this.kuw.koH)) && (this.kuo.getVisibility() == 0))
            {
              paramInt1 = bo.bS(this.kuw.koH, getResources().getColor(2131689837));
              dO(paramInt1, getResources().getColor(2131689836));
              this.kuo.setTextColor(paramInt1);
            }
            if ((!bo.isNullOrNil(this.kuw.koH)) && (this.kuq.getVisibility() == 0))
            {
              paramInt1 = bo.bS(this.kuw.koH, getResources().getColor(2131689837));
              this.kuq.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131689837);
              paramInt1 = paramInt2;
              if (!bo.isNullOrNil(this.kuw.koH)) {
                paramInt1 = bo.bS(this.kuw.koH, paramInt2);
              }
              this.kut.setImageDrawable(b(this.kut.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!bo.isNullOrNil(this.kuw.koH)) && (this.kus.getVisibility() == 0))
            {
              paramInt1 = bo.bS(this.kuw.koH, getResources().getColor(2131689837));
              this.kus.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(2131689837);
              paramInt1 = paramInt2;
              if (!bo.isNullOrNil(this.kuw.koH)) {
                paramInt1 = bo.bS(this.kuw.koH, paramInt2);
              }
              this.kuu.setImageDrawable(b(this.kuu.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.kuo.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.cb.a.fromDPToPix(this, 20);
              this.kuo.setLayoutParams(paramString);
            }
            if ((this.kuo.getVisibility() != 0) || (this.kur.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.kuo.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(this, 28);
            this.kuo.setLayoutParams(paramString);
            break;
            this.kuo.setVisibility(0);
            this.kuo.setText(getResources().getString(2131297915));
            this.kuo.setOnClickListener(this);
            continue;
            if ((this.kuw.status != 1) && (this.kuw.status == 2))
            {
              if (!bo.isNullOrNil(this.kuw.koE))
              {
                this.kuo.setVisibility(0);
                this.kuo.setBackgroundDrawable(null);
                this.kuo.setText(this.kuw.koE);
                this.kuo.setTextColor(getResources().getColor(2131689763));
                this.kuo.setTextSize(1, 17.0F);
                this.kuo.setOnClickListener(null);
              }
              else
              {
                this.kuo.setVisibility(8);
                this.kuo.setOnClickListener(null);
              }
            }
            else
            {
              this.kuo.setVisibility(8);
              this.kuo.setOnClickListener(null);
            }
          }
        }
        ab.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        bdU();
        AppMethodBeat.o(88389);
        return;
      }
      if ((paramm instanceof q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        ab.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.kux = ((q)paramm);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.fhO);
        paramString.putExtra("key_biz_uin", this.fhN);
        paramString.putExtra("key_gift_into", this.kux.kol);
        if (!bo.isNullOrNil(this.cAu)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          startActivity(paramString);
          finish();
          AppMethodBeat.o(88389);
          return;
        }
      }
    }
    else
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramm instanceof ag))
      {
        ab.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(88389);
        return;
      }
      if ((paramm instanceof q))
      {
        ab.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
      }
    }
    AppMethodBeat.o(88389);
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