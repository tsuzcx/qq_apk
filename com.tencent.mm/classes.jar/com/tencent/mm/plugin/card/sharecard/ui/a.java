package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View iCR;
  Bitmap jtB;
  View.OnClickListener jtG;
  private View oCb;
  private View oCc;
  private View oCd;
  Bitmap oCe;
  TextView oCf;
  TextView oCg;
  CheckBox oCh;
  String oCi;
  int oCj;
  boolean oCk;
  a oCl;
  float oCm;
  private View.OnLongClickListener oCn;
  com.tencent.mm.plugin.card.base.b owK;
  MMActivity owO;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.oCj = 1;
    this.oCk = false;
    this.oCm = 0.0F;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131302965)
        {
          if (!a.this.oCh.isChecked()) {
            break label97;
          }
          if (a.this.oCl != null) {
            a.this.oCl.Av(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113028);
          return;
          label97:
          if (a.this.oCl != null) {
            a.this.oCl.Av(0);
          }
        }
      }
    };
    this.oCn = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131298408)
        {
          q.Kh(a.this.owK.bTO().code);
          h.cl(a.this.owO, a.this.owO.getString(2131755702));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.owO = paramMMActivity;
    this.iCR = paramView;
    AppMethodBeat.o(113030);
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(113033);
    if ((paramImageView == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    if (this.oCj != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void dH(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(2131298399);
    if (this.oCj == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.oCj == -1) {
        paramView.setText(2131756926);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void aV(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.owO.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.owO.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void bVy()
  {
    AppMethodBeat.i(113032);
    ad.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.oCk)
    {
      ad.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bt.isNullOrNil(this.owK.bTO().FPC))
    {
      localObject1 = this.owK.bTO().FPC;
      ad.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.owK.bTO().FPp)
      {
      default: 
        if (!bt.isNullOrNil(this.owK.bTN().iTH)) {
          if (this.owK.bTN().FSc != null)
          {
            this.oCg.setText(this.owK.bTN().iTH);
            this.oCg.setVisibility(0);
            this.oCf.setVisibility(8);
            if (this.oCb != null)
            {
              localObject1 = (ImageView)this.oCb.findViewById(2131298400);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cc.a.fromDPToPix(this.owO, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cc.a.fromDPToPix(this.owO, 180);
              ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          if ((!this.owK.bTt()) || (TextUtils.isEmpty(this.owK.bTT())) || (this.owK.bTT().equals(u.aAm()))) {
            break label1203;
          }
          this.oCh.setVisibility(0);
          localObject1 = " " + this.owO.getString(2131756816, new Object[] { l.Zj(this.owK.bTT()) });
          this.oCh.setText(k.f(this.owO, (CharSequence)localObject1, this.owO.getResources().getDimensionPixelOffset(2131165574)));
          AppMethodBeat.o(113032);
          return;
          if (this.owK.bTH())
          {
            localObject1 = am.bVa().getCode();
            ad.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.owK.bTO().code;
          ad.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.oCb == null) {
            this.oCb = ((ViewStub)this.iCR.findViewById(2131297764)).inflate();
          }
          localObject3 = this.oCb;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131298400);
          localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
          if (!this.owK.bTu()) {
            ((TextView)localObject3).setTextColor(l.Zh(this.owK.bTN().hAD));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.Zo((String)localObject1));
            if (this.owK.bTD())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.oCn);
              label572:
              if (this.oCj != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.T(this.jtB);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jtB = com.tencent.mm.bz.a.a.b(this.owO, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.jtB);
            }
            for (;;)
            {
              dH(this.oCb);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.jtB = null;
              ((ImageView)localObject2).setImageBitmap(this.jtB);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.oCc == null) {
          this.oCc = ((ViewStub)this.iCR.findViewById(2131297759)).inflate();
        }
        Object localObject3 = this.oCc;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131298384);
        localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
        if (!this.owK.bTu()) {
          ((TextView)localObject3).setTextColor(l.Zh(this.owK.bTN().hAD));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.Zo(localException1));
          if (this.owK.bTD())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.oCn);
            label819:
            if (this.oCj != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.T(this.oCe);
          if (!TextUtils.isEmpty(localException1))
          {
            this.oCe = com.tencent.mm.bz.a.a.b(this.owO, localException1, 5, 0);
            a((ImageView)localObject2, this.oCe);
          }
          for (;;)
          {
            dH(this.oCc);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.oCe = null;
            ((ImageView)localObject2).setImageBitmap(this.oCe);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.oCd == null) {
        this.oCd = ((ViewStub)this.iCR.findViewById(2131297767)).inflate();
      }
      localObject2 = (TextView)this.oCd.findViewById(2131298408);
      ((TextView)localObject2).setText(n.Zo(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.oCn);
      if (!this.owK.bTu()) {
        ((TextView)localObject2).setTextColor(l.Zh(this.owK.bTN().hAD));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dH(this.oCd);
        break;
        if ((localException2.length() > 12) && (localException2.length() <= 16)) {
          ((TextView)localObject2).setTextSize(1, 30.0F);
        } else if ((localException2.length() > 16) && (localException2.length() <= 20)) {
          ((TextView)localObject2).setTextSize(1, 24.0F);
        } else if ((localException2.length() > 20) && (localException2.length() <= 40)) {
          ((TextView)localObject2).setTextSize(1, 18.0F);
        } else if (localException2.length() > 40) {
          ((TextView)localObject2).setVisibility(8);
        }
      }
      this.oCf.setText(this.owK.bTN().iTH);
      this.oCf.setVisibility(0);
      continue;
      this.oCf.setVisibility(8);
      this.oCg.setVisibility(8);
    }
    label1203:
    this.oCh.setChecked(false);
    this.oCh.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void Av(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */