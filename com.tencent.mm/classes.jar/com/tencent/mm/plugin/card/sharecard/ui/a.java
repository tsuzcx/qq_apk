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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View iFK;
  View.OnClickListener jwB;
  Bitmap jww;
  com.tencent.mm.plugin.card.base.b oDm;
  MMActivity oDq;
  private View oID;
  private View oIE;
  private View oIF;
  Bitmap oIG;
  TextView oIH;
  TextView oII;
  CheckBox oIJ;
  String oIK;
  int oIL;
  boolean oIM;
  a oIN;
  float oIO;
  private View.OnLongClickListener oIP;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.oIL = 1;
    this.oIM = false;
    this.oIO = 0.0F;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getId() == 2131302965)
        {
          if (!a.this.oIJ.isChecked()) {
            break label97;
          }
          if (a.this.oIN != null) {
            a.this.oIN.AH(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113028);
          return;
          label97:
          if (a.this.oIN != null) {
            a.this.oIN.AH(0);
          }
        }
      }
    };
    this.oIP = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (paramAnonymousView.getId() == 2131298408)
        {
          q.KG(a.this.oDm.bVd().code);
          h.cm(a.this.oDq, a.this.oDq.getString(2131755702));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.oDq = paramMMActivity;
    this.iFK = paramView;
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
    if (this.oIL != 1)
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
    if (this.oIL == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.oIL == -1) {
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
    WindowManager.LayoutParams localLayoutParams = this.oDq.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.oDq.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void bWN()
  {
    AppMethodBeat.i(113032);
    ae.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.oIM)
    {
      ae.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bu.isNullOrNil(this.oDm.bVd().Gib))
    {
      localObject1 = this.oDm.bVd().Gib;
      ae.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.oDm.bVd().GhO)
      {
      default: 
        if (!bu.isNullOrNil(this.oDm.bVc().iWA)) {
          if (this.oDm.bVc().GkB != null)
          {
            this.oII.setText(this.oDm.bVc().iWA);
            this.oII.setVisibility(0);
            this.oIH.setVisibility(8);
            if (this.oID != null)
            {
              localObject1 = (ImageView)this.oID.findViewById(2131298400);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cb.a.fromDPToPix(this.oDq, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cb.a.fromDPToPix(this.oDq, 180);
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
          if ((!this.oDm.bUI()) || (TextUtils.isEmpty(this.oDm.bVi())) || (this.oDm.bVi().equals(v.aAC()))) {
            break label1203;
          }
          this.oIJ.setVisibility(0);
          localObject1 = " " + this.oDq.getString(2131756816, new Object[] { l.aaa(this.oDm.bVi()) });
          this.oIJ.setText(k.f(this.oDq, (CharSequence)localObject1, this.oDq.getResources().getDimensionPixelOffset(2131165574)));
          AppMethodBeat.o(113032);
          return;
          if (this.oDm.bUW())
          {
            localObject1 = am.bWp().getCode();
            ae.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.oDm.bVd().code;
          ae.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.oID == null) {
            this.oID = ((ViewStub)this.iFK.findViewById(2131297764)).inflate();
          }
          localObject3 = this.oID;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131298400);
          localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
          if (!this.oDm.bUJ()) {
            ((TextView)localObject3).setTextColor(l.ZY(this.oDm.bVc().hDr));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.aaf((String)localObject1));
            if (this.oDm.bUS())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.oIP);
              label572:
              if (this.oIL != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.U(this.jww);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jww = com.tencent.mm.by.a.a.b(this.oDq, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.jww);
            }
            for (;;)
            {
              dH(this.oID);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.jww = null;
              ((ImageView)localObject2).setImageBitmap(this.jww);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.oIE == null) {
          this.oIE = ((ViewStub)this.iFK.findViewById(2131297759)).inflate();
        }
        Object localObject3 = this.oIE;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131298384);
        localObject3 = (TextView)((View)localObject3).findViewById(2131298408);
        if (!this.oDm.bUJ()) {
          ((TextView)localObject3).setTextColor(l.ZY(this.oDm.bVc().hDr));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.aaf(localException1));
          if (this.oDm.bUS())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.oIP);
            label819:
            if (this.oIL != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.U(this.oIG);
          if (!TextUtils.isEmpty(localException1))
          {
            this.oIG = com.tencent.mm.by.a.a.b(this.oDq, localException1, 5, 0);
            a((ImageView)localObject2, this.oIG);
          }
          for (;;)
          {
            dH(this.oIE);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.oIG = null;
            ((ImageView)localObject2).setImageBitmap(this.oIG);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.oIF == null) {
        this.oIF = ((ViewStub)this.iFK.findViewById(2131297767)).inflate();
      }
      localObject2 = (TextView)this.oIF.findViewById(2131298408);
      ((TextView)localObject2).setText(n.aaf(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.oIP);
      if (!this.oDm.bUJ()) {
        ((TextView)localObject2).setTextColor(l.ZY(this.oDm.bVc().hDr));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dH(this.oIF);
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
      this.oIH.setText(this.oDm.bVc().iWA);
      this.oIH.setVisibility(0);
      continue;
      this.oIH.setVisibility(8);
      this.oII.setVisibility(8);
    }
    label1203:
    this.oIJ.setChecked(false);
    this.oIJ.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void AH(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */