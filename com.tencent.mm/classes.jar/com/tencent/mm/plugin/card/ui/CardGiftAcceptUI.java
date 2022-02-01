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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.n.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;

@com.tencent.mm.ui.base.a(7)
public class CardGiftAcceptUI
  extends MMActivity
  implements View.OnClickListener, i
{
  private final String TAG = "MicroMsg.CardGiftAcceptUI";
  private String fSj;
  private String fwY;
  private TextView ktl;
  private int lnn;
  private String lno;
  private s tipDialog = null;
  private RelativeLayout twe;
  private RelativeLayout twf;
  private ImageView twg;
  private TextView twh;
  private ImageView twi;
  private Button twj;
  private LinearLayout twk;
  private TextView twl;
  private LinearLayout twm;
  private TextView twn;
  private ImageView twp;
  private ImageView twq;
  private RelativeLayout twr;
  private ag tws;
  private com.tencent.mm.plugin.card.model.q twt;
  
  private static Drawable b(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(113312);
    paramDrawable = androidx.core.graphics.drawable.a.p(paramDrawable);
    androidx.core.graphics.drawable.a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(113312);
    return paramDrawable;
  }
  
  private void cJr()
  {
    AppMethodBeat.i(113316);
    com.tencent.mm.plugin.card.model.q localq = new com.tencent.mm.plugin.card.model.q(this.lnn, this.lno, this.fwY, Boolean.FALSE);
    com.tencent.mm.kernel.h.aHF().kcd.a(localq, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113316);
  }
  
  private void fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113313);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt2);
    localGradientDrawable.setStroke(2, paramInt1);
    localGradientDrawable.setCornerRadius(6.0F);
    this.twj.setBackground(localGradientDrawable);
    AppMethodBeat.o(113313);
  }
  
  public int getLayoutId()
  {
    return a.e.tib;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113311);
    this.twe = ((RelativeLayout)findViewById(a.d.tbY));
    this.twf = ((RelativeLayout)findViewById(a.d.tcf));
    this.twg = ((ImageView)findViewById(a.d.tch));
    this.twh = ((TextView)findViewById(a.d.tci));
    this.ktl = ((TextView)findViewById(a.d.tcd));
    this.twi = ((ImageView)findViewById(a.d.tfZ));
    this.twj = ((Button)findViewById(a.d.tck));
    this.twl = ((TextView)findViewById(a.d.tce));
    this.twn = ((TextView)findViewById(a.d.tcg));
    this.twr = ((RelativeLayout)findViewById(a.d.tcj));
    this.twp = ((ImageView)findViewById(a.d.tcc));
    this.twq = ((ImageView)findViewById(a.d.tgC));
    this.twk = ((LinearLayout)findViewById(a.d.tgp));
    this.twm = ((LinearLayout)findViewById(a.d.tgD));
    this.twr.setOnClickListener(this);
    this.twe.setOnClickListener(this);
    this.twf.setOnClickListener(this);
    this.twk.setOnClickListener(this);
    this.twm.setOnClickListener(this);
    getContentView().setVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.g.loading_tips), true, new DialogInterface.OnCancelListener()
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
    ag localag = new ag(this.lnn, this.lno, this.fwY);
    com.tencent.mm.kernel.h.aHF().kcd.a(localag, 0);
    if (this.tipDialog != null) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(113311);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113314);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getId() == a.d.tck) || (paramView.getId() == a.d.tgp))
    {
      if (this.twj.getVisibility() == 0)
      {
        int i = ar.iV(Util.convertStringToRGB(this.tws.tqx, getResources().getColor(a.a.sZw)));
        fD(i, i);
        this.twj.setTextColor(getResources().getColor(a.a.white_text_color));
      }
      cJr();
      if (!Util.isNullOrNil(this.fSj)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(2), this.lno, p.getString(this.lnn), this.fSj });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113314);
      return;
      if (paramView.getId() == a.d.tcj)
      {
        finish();
      }
      else if (paramView.getId() == a.d.tbY)
      {
        finish();
      }
      else if (paramView.getId() == a.d.tgD)
      {
        paramView = new com.tencent.mm.plugin.card.model.q(this.lnn, this.lno, this.fwY, Boolean.TRUE);
        com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
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
    this.lno = getIntent().getStringExtra("key_order_id");
    this.lnn = getIntent().getIntExtra("key_biz_uin", -1);
    this.fSj = getIntent().getStringExtra("key_from_user_name");
    this.fwY = getIntent().getStringExtra("key_chatroom_name");
    Log.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[] { this.lno, Integer.valueOf(this.lnn), this.fSj });
    if (this.lnn == -1)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (this.lno == null)
    {
      Log.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
      d.a(this, "", true);
      AppMethodBeat.o(113309);
      return;
    }
    if (!Util.isNullOrNil(this.fSj)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(1), this.lno, p.getString(this.lnn), this.fSj });
    }
    initView();
    com.tencent.mm.kernel.h.aHF().kcd.a(1171, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1136, this);
    AppMethodBeat.o(113309);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113310);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHF().kcd.b(1171, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1136, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(113315);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ag))
      {
        this.tws = ((ag)paramq);
        Log.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[] { Boolean.valueOf(this.tws.tqv) });
        if (!this.tws.tqv)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (this.tws == null)
          {
            Log.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            paramString = this.twf;
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
            ar.r(this, getResources().getColor(a.a.BG_4));
            getContentView().setVisibility(0);
            AppMethodBeat.o(113315);
            return;
          }
          this.ktl.setText(this.tws.content);
          this.twh.setText(l.b(this, this.tws.fSj, this.twh.getTextSize()));
          if (this.tws.status == 0) {
            if (!Util.isNullOrNil(this.tws.tqu))
            {
              this.twj.setVisibility(0);
              this.twj.setText(this.tws.tqu);
              this.twj.setOnClickListener(this);
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(this.tws.tqy))
            {
              this.twj.setVisibility(8);
              this.twm.setVisibility(8);
              this.twk.setVisibility(0);
              this.twl.setText(this.tws.tqy);
            }
            if (!Util.isNullOrNil(this.tws.tqz))
            {
              this.twk.setVisibility(8);
              this.twm.setVisibility(0);
              this.twn.setText(this.tws.tqz);
            }
            if (!Util.isNullOrNil(this.tws.tqt))
            {
              paramInt1 = com.tencent.mm.ci.a.fromDPToPix(this, 15);
              paramString = new c.a();
              paramString.prefixPath = com.tencent.mm.loader.j.b.aSL();
              com.tencent.mm.ay.q.bmm();
              paramString.lRV = null;
              paramString.fullPath = m.arc(this.tws.tqt);
              paramString.lRD = true;
              paramString.kPz = true;
              paramString.lRW = paramInt1;
              paramString.lRB = true;
              paramString.lRP = a.c.my_card_package_defaultlogo;
              paramString = paramString.bmL();
              com.tencent.mm.ay.q.bml().a(this.tws.tqt, this.twg, paramString);
            }
            if (!Util.isNullOrNil(this.tws.tqw)) {
              com.tencent.mm.ay.q.bml().loadImage(this.tws.tqw, this.twi);
            }
            if ((!Util.isNullOrNil(this.tws.tqx)) && (this.twj.getVisibility() == 0))
            {
              paramInt1 = ar.iV(Util.convertStringToRGB(this.tws.tqx, getResources().getColor(a.a.sZw)));
              fD(paramInt1, getResources().getColor(a.a.BG_5));
              this.twj.setTextColor(paramInt1);
            }
            if ((!Util.isNullOrNil(this.tws.tqx)) && (this.twl.getVisibility() == 0))
            {
              paramInt1 = ar.iV(Util.convertStringToRGB(this.tws.tqx, getResources().getColor(a.a.sZw)));
              this.twl.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(a.a.sZw);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.tws.tqx)) {
                paramInt1 = Util.convertStringToRGB(this.tws.tqx, paramInt2);
              }
              paramInt1 = ar.iV(paramInt1);
              this.twp.setImageDrawable(b(this.twp.getDrawable(), ColorStateList.valueOf(paramInt1)));
            }
            if ((!Util.isNullOrNil(this.tws.tqx)) && (this.twn.getVisibility() == 0))
            {
              paramInt1 = ar.iV(Util.convertStringToRGB(this.tws.tqx, getResources().getColor(a.a.sZw)));
              this.twn.setTextColor(paramInt1);
              paramInt2 = getResources().getColor(a.a.sZw);
              paramInt1 = paramInt2;
              if (!Util.isNullOrNil(this.tws.tqx)) {
                paramInt1 = Util.convertStringToRGB(this.tws.tqx, paramInt2);
              }
              paramInt1 = ar.iV(paramInt1);
              this.twq.setImageDrawable(b(this.twq.getDrawable(), ColorStateList.valueOf(paramInt1)));
              paramString = (ViewGroup.MarginLayoutParams)this.twj.getLayoutParams();
              paramString.topMargin -= com.tencent.mm.ci.a.fromDPToPix(this, 20);
              this.twj.setLayoutParams(paramString);
            }
            if ((this.twj.getVisibility() != 0) || (this.twm.getVisibility() != 8)) {
              break;
            }
            paramString = (ViewGroup.MarginLayoutParams)this.twj.getLayoutParams();
            paramString.bottomMargin += com.tencent.mm.ci.a.fromDPToPix(this, 28);
            this.twj.setLayoutParams(paramString);
            break;
            this.twj.setVisibility(0);
            this.twj.setText(getResources().getString(a.g.tki));
            this.twj.setOnClickListener(this);
            continue;
            if ((this.tws.status != 1) && (this.tws.status == 2))
            {
              if (!Util.isNullOrNil(this.tws.tqu))
              {
                this.twj.setVisibility(0);
                this.twj.setBackgroundDrawable(null);
                this.twj.setText(this.tws.tqu);
                this.twj.setTextColor(getResources().getColor(a.a.normal_text_color));
                this.twj.setTextSize(1, 17.0F);
                this.twj.setOnClickListener(null);
              }
              else
              {
                this.twj.setVisibility(8);
                this.twj.setOnClickListener(null);
              }
            }
            else
            {
              this.twj.setVisibility(8);
              this.twj.setOnClickListener(null);
            }
          }
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
        cJr();
        AppMethodBeat.o(113315);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.q))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        Log.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
        this.twt = ((com.tencent.mm.plugin.card.model.q)paramq);
        paramString = new Intent(this, CardGiftReceiveUI.class);
        paramString.putExtra("key_order_id", this.lno);
        paramString.putExtra("key_biz_uin", this.lnn);
        paramString.putExtra("key_gift_into", this.twt.tqc);
        if (!Util.isNullOrNil(this.fwY)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putExtra("key_from_group_chat_room", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/card/ui/CardGiftAcceptUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI
 * JD-Core Version:    0.7.0.1
 */