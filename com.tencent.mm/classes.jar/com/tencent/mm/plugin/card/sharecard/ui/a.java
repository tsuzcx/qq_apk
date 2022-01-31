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
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  private final String TAG;
  Bitmap gMJ;
  View.OnClickListener gMO;
  View iCk;
  MMActivity jpX;
  b klk;
  private View kqn;
  private View kqo;
  private View kqp;
  Bitmap kqq;
  TextView kqr;
  TextView kqs;
  CheckBox kqt;
  String kqu;
  int kqv;
  boolean kqw;
  a.a kqx;
  float kqy;
  private View.OnLongClickListener kqz;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(88091);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.kqv = 1;
    this.kqw = false;
    this.kqy = 0.0F;
    this.gMO = new a.1(this);
    this.kqz = new a.2(this);
    this.jpX = paramMMActivity;
    this.iCk = paramView;
    AppMethodBeat.o(88091);
  }
  
  private void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(88096);
    if ((paramImageView == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(88096);
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    if (this.kqv != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(88096);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(88096);
  }
  
  private void de(View paramView)
  {
    AppMethodBeat.i(88097);
    paramView = (Button)paramView.findViewById(2131822012);
    if (this.kqv == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.kqv == -1) {
        paramView.setText(2131297984);
      }
      AppMethodBeat.o(88097);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void aG(float paramFloat)
  {
    AppMethodBeat.i(88093);
    WindowManager.LayoutParams localLayoutParams = this.jpX.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.jpX.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(88093);
  }
  
  public final void bcI()
  {
    AppMethodBeat.i(88095);
    ab.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.kqw)
    {
      ab.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(88095);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bo.isNullOrNil(this.klk.bbe().wEg))
    {
      localObject1 = this.klk.bbe().wEg;
      ab.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.klk.bbe().wDT)
      {
      default: 
        if (!bo.isNullOrNil(this.klk.bbd().kNG)) {
          if (this.klk.bbd().wGD != null)
          {
            this.kqs.setText(this.klk.bbd().kNG);
            this.kqs.setVisibility(0);
            this.kqr.setVisibility(8);
            if (this.kqn != null)
            {
              localObject1 = (ImageView)this.kqn.findViewById(2131822018);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cb.a.fromDPToPix(this.jpX, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cb.a.fromDPToPix(this.jpX, 180);
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
          if ((!this.klk.baK()) || (TextUtils.isEmpty(this.klk.bbj())) || (this.klk.bbj().equals(r.Zn()))) {
            break label1203;
          }
          this.kqt.setVisibility(0);
          localObject1 = " " + this.jpX.getString(2131297884, new Object[] { l.ID(this.klk.bbj()) });
          this.kqt.setText(j.f(this.jpX, (CharSequence)localObject1, this.jpX.getResources().getDimensionPixelOffset(2131427860)));
          AppMethodBeat.o(88095);
          return;
          if (this.klk.baY())
          {
            localObject1 = am.bcq().getCode();
            ab.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.klk.bbe().code;
          ab.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.kqn == null) {
            this.kqn = ((ViewStub)this.iCk.findViewById(2131822037)).inflate();
          }
          localObject3 = this.kqn;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131822018);
          localObject3 = (TextView)((View)localObject3).findViewById(2131822013);
          if (!this.klk.baL()) {
            ((TextView)localObject3).setTextColor(l.IB(this.klk.bbd().color));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(m.II((String)localObject1));
            if (this.klk.baU())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.kqz);
              label572:
              if (this.kqv != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.I(this.gMJ);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.gMJ = com.tencent.mm.by.a.a.b(this.jpX, (String)localObject1, 12, 3);
              b((ImageView)localObject2, this.gMJ);
            }
            for (;;)
            {
              de(this.kqn);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.gMJ = null;
              ((ImageView)localObject2).setImageBitmap(this.gMJ);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.kqo == null) {
          this.kqo = ((ViewStub)this.iCk.findViewById(2131822039)).inflate();
        }
        Object localObject3 = this.kqo;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131822011);
        localObject3 = (TextView)((View)localObject3).findViewById(2131822013);
        if (!this.klk.baL()) {
          ((TextView)localObject3).setTextColor(l.IB(this.klk.bbd().color));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(m.II(localException1));
          if (this.klk.baU())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.kqz);
            label819:
            if (this.kqv != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.I(this.kqq);
          if (!TextUtils.isEmpty(localException1))
          {
            this.kqq = com.tencent.mm.by.a.a.b(this.jpX, localException1, 5, 0);
            b((ImageView)localObject2, this.kqq);
          }
          for (;;)
          {
            de(this.kqo);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.kqq = null;
            ((ImageView)localObject2).setImageBitmap(this.kqq);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.kqp == null) {
        this.kqp = ((ViewStub)this.iCk.findViewById(2131822041)).inflate();
      }
      localObject2 = (TextView)this.kqp.findViewById(2131822013);
      ((TextView)localObject2).setText(m.II(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.kqz);
      if (!this.klk.baL()) {
        ((TextView)localObject2).setTextColor(l.IB(this.klk.bbd().color));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        de(this.kqp);
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
      this.kqr.setText(this.klk.bbd().kNG);
      this.kqr.setVisibility(0);
      continue;
      this.kqr.setVisibility(8);
      this.kqs.setVisibility(8);
    }
    label1203:
    this.kqt.setChecked(false);
    this.kqt.setVisibility(8);
    AppMethodBeat.o(88095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */