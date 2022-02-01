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
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View hIZ;
  Bitmap iAr;
  View.OnClickListener iAw;
  b nqp;
  MMActivity nqt;
  private View nvH;
  private View nvI;
  private View nvJ;
  Bitmap nvK;
  TextView nvL;
  TextView nvM;
  CheckBox nvN;
  String nvO;
  int nvP;
  boolean nvQ;
  a nvR;
  float nvS;
  private View.OnLongClickListener nvT;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.nvP = 1;
    this.nvQ = false;
    this.nvS = 0.0F;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        if (paramAnonymousView.getId() == 2131302965) {
          if (a.this.nvN.isChecked())
          {
            if (a.this.nvR != null)
            {
              a.this.nvR.yW(1);
              AppMethodBeat.o(113028);
            }
          }
          else if (a.this.nvR != null) {
            a.this.nvR.yW(0);
          }
        }
        AppMethodBeat.o(113028);
      }
    };
    this.nvT = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        if (paramAnonymousView.getId() == 2131298408)
        {
          q.CP(a.this.nqp.bHW().code);
          h.cf(a.this.nqt, a.this.nqt.getString(2131755702));
        }
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
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
    if (this.nvP != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void dC(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(2131298399);
    if (this.nvP == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.nvP == -1) {
        paramView.setText(2131756926);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void aO(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.nqt.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.nqt.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void bJG()
  {
    AppMethodBeat.i(113032);
    ad.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.nvQ)
    {
      ad.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bt.isNullOrNil(this.nqp.bHW().CPH))
    {
      localObject1 = this.nqp.bHW().CPH;
      ad.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.nqp.bHW().CPu)
      {
      default: 
        if (!bt.isNullOrNil(this.nqp.bHV().iau)) {
          if (this.nqp.bHV().CSi != null)
          {
            this.nvM.setText(this.nqp.bHV().iau);
            this.nvM.setVisibility(0);
            this.nvL.setVisibility(8);
            if (this.nvH != null)
            {
              localObject1 = (ImageView)this.nvH.findViewById(2131298400);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cd.a.fromDPToPix(this.nqt, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cd.a.fromDPToPix(this.nqt, 180);
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
          if ((!this.nqp.bHB()) || (TextUtils.isEmpty(this.nqp.bIb())) || (this.nqp.bIb().equals(u.aqG()))) {
            break label1203;
          }
          this.nvN.setVisibility(0);
          localObject1 = " " + this.nqt.getString(2131756816, new Object[] { l.Ro(this.nqp.bIb()) });
          this.nvN.setText(k.e(this.nqt, (CharSequence)localObject1, this.nqt.getResources().getDimensionPixelOffset(2131165574)));
          AppMethodBeat.o(113032);
          return;
          if (this.nqp.bHP())
          {
            localObject1 = am.bJi().getCode();
            ad.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.nqp.bHW().code;
          ad.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.nvH == null) {
            this.nvH = ((ViewStub)this.hIZ.findViewById(2131297764)).inflate();
          }
          localObject3 = this.nvH;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131298400);
          localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
          if (!this.nqp.bHC()) {
            ((TextView)localObject3).setTextColor(l.Rm(this.nqp.bHV().gHT));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.Rt((String)localObject1));
            if (this.nqp.bHL())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.nvT);
              label572:
              if (this.nvP != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.T(this.iAr);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.iAr = com.tencent.mm.bz.a.a.b(this.nqt, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.iAr);
            }
            for (;;)
            {
              dC(this.nvH);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.iAr = null;
              ((ImageView)localObject2).setImageBitmap(this.iAr);
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
        if (this.nvI == null) {
          this.nvI = ((ViewStub)this.hIZ.findViewById(2131297759)).inflate();
        }
        Object localObject3 = this.nvI;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131298384);
        localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
        if (!this.nqp.bHC()) {
          ((TextView)localObject3).setTextColor(l.Rm(this.nqp.bHV().gHT));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.Rt(localException1));
          if (this.nqp.bHL())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.nvT);
            label819:
            if (this.nvP != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.T(this.nvK);
          if (!TextUtils.isEmpty(localException1))
          {
            this.nvK = com.tencent.mm.bz.a.a.b(this.nqt, localException1, 5, 0);
            a((ImageView)localObject2, this.nvK);
          }
          for (;;)
          {
            dC(this.nvI);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.nvK = null;
            ((ImageView)localObject2).setImageBitmap(this.nvK);
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
      if (this.nvJ == null) {
        this.nvJ = ((ViewStub)this.hIZ.findViewById(2131297767)).inflate();
      }
      localObject2 = (TextView)this.nvJ.findViewById(2131298408);
      ((TextView)localObject2).setText(n.Rt(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.nvT);
      if (!this.nqp.bHC()) {
        ((TextView)localObject2).setTextColor(l.Rm(this.nqp.bHV().gHT));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dC(this.nvJ);
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
      this.nvL.setText(this.nqp.bHV().iau);
      this.nvL.setVisibility(0);
      continue;
      this.nvL.setVisibility(8);
      this.nvM.setVisibility(8);
    }
    label1203:
    this.nvN.setChecked(false);
    this.nvN.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void yW(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */