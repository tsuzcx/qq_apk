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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View ijA;
  Bitmap jas;
  View.OnClickListener jax;
  b nTp;
  MMActivity nTt;
  private View nYH;
  private View nYI;
  private View nYJ;
  Bitmap nYK;
  TextView nYL;
  TextView nYM;
  CheckBox nYN;
  String nYO;
  int nYP;
  boolean nYQ;
  a nYR;
  float nYS;
  private View.OnLongClickListener nYT;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.nYP = 1;
    this.nYQ = false;
    this.nYS = 0.0F;
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        if (paramAnonymousView.getId() == 2131302965) {
          if (a.this.nYN.isChecked())
          {
            if (a.this.nYR != null)
            {
              a.this.nYR.zM(1);
              AppMethodBeat.o(113028);
            }
          }
          else if (a.this.nYR != null) {
            a.this.nYR.zM(0);
          }
        }
        AppMethodBeat.o(113028);
      }
    };
    this.nYT = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        if (paramAnonymousView.getId() == 2131298408)
        {
          q.GS(a.this.nTp.bPj().code);
          h.cg(a.this.nTt, a.this.nTt.getString(2131755702));
        }
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.nTt = paramMMActivity;
    this.ijA = paramView;
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
    if (this.nYP != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void dE(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(2131298399);
    if (this.nYP == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.nYP == -1) {
        paramView.setText(2131756926);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void aS(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.nTt.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.nTt.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void bQT()
  {
    AppMethodBeat.i(113032);
    ac.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.nYQ)
    {
      ac.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bs.isNullOrNil(this.nTp.bPj().Eis))
    {
      localObject1 = this.nTp.bPj().Eis;
      ac.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.nTp.bPj().Eif)
      {
      default: 
        if (!bs.isNullOrNil(this.nTp.bPi().iAx)) {
          if (this.nTp.bPi().EkT != null)
          {
            this.nYM.setText(this.nTp.bPi().iAx);
            this.nYM.setVisibility(0);
            this.nYL.setVisibility(8);
            if (this.nYH != null)
            {
              localObject1 = (ImageView)this.nYH.findViewById(2131298400);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cc.a.fromDPToPix(this.nTt, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cc.a.fromDPToPix(this.nTt, 180);
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
          if ((!this.nTp.bOO()) || (TextUtils.isEmpty(this.nTp.bPo())) || (this.nTp.bPo().equals(u.axw()))) {
            break label1203;
          }
          this.nYN.setVisibility(0);
          localObject1 = " " + this.nTt.getString(2131756816, new Object[] { l.VA(this.nTp.bPo()) });
          this.nYN.setText(k.f(this.nTt, (CharSequence)localObject1, this.nTt.getResources().getDimensionPixelOffset(2131165574)));
          AppMethodBeat.o(113032);
          return;
          if (this.nTp.bPc())
          {
            localObject1 = am.bQv().getCode();
            ac.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.nTp.bPj().code;
          ac.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.nYH == null) {
            this.nYH = ((ViewStub)this.ijA.findViewById(2131297764)).inflate();
          }
          localObject3 = this.nYH;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131298400);
          localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
          if (!this.nTp.bOP()) {
            ((TextView)localObject3).setTextColor(l.Vy(this.nTp.bPi().hiu));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.VF((String)localObject1));
            if (this.nTp.bOY())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.nYT);
              label572:
              if (this.nYP != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.T(this.jas);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jas = com.tencent.mm.by.a.a.b(this.nTt, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.jas);
            }
            for (;;)
            {
              dE(this.nYH);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.jas = null;
              ((ImageView)localObject2).setImageBitmap(this.jas);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.nYI == null) {
          this.nYI = ((ViewStub)this.ijA.findViewById(2131297759)).inflate();
        }
        Object localObject3 = this.nYI;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131298384);
        localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
        if (!this.nTp.bOP()) {
          ((TextView)localObject3).setTextColor(l.Vy(this.nTp.bPi().hiu));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.VF(localException1));
          if (this.nTp.bOY())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.nYT);
            label819:
            if (this.nYP != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.T(this.nYK);
          if (!TextUtils.isEmpty(localException1))
          {
            this.nYK = com.tencent.mm.by.a.a.b(this.nTt, localException1, 5, 0);
            a((ImageView)localObject2, this.nYK);
          }
          for (;;)
          {
            dE(this.nYI);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.nYK = null;
            ((ImageView)localObject2).setImageBitmap(this.nYK);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.nYJ == null) {
        this.nYJ = ((ViewStub)this.ijA.findViewById(2131297767)).inflate();
      }
      localObject2 = (TextView)this.nYJ.findViewById(2131298408);
      ((TextView)localObject2).setText(n.VF(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.nYT);
      if (!this.nTp.bOP()) {
        ((TextView)localObject2).setTextColor(l.Vy(this.nTp.bPi().hiu));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dE(this.nYJ);
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
      this.nYL.setText(this.nTp.bPi().iAx);
      this.nYL.setVisibility(0);
      continue;
      this.nYL.setVisibility(8);
      this.nYM.setVisibility(8);
    }
    label1203:
    this.nYN.setChecked(false);
    this.nYN.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void zM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */