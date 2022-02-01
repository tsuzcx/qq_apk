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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View jBN;
  Bitmap kuJ;
  View.OnClickListener kuO;
  com.tencent.mm.plugin.card.base.b pQV;
  MMActivity pQZ;
  boolean pWA;
  a pWB;
  float pWC;
  private View.OnLongClickListener pWD;
  private View pWr;
  private View pWs;
  private View pWt;
  Bitmap pWu;
  TextView pWv;
  TextView pWw;
  CheckBox pWx;
  String pWy;
  int pWz;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.pWz = 1;
    this.pWA = false;
    this.pWC = 0.0F;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131305552)
        {
          if (!a.this.pWx.isChecked()) {
            break label97;
          }
          if (a.this.pWB != null) {
            a.this.pWB.Em(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113028);
          return;
          label97:
          if (a.this.pWB != null) {
            a.this.pWB.Em(0);
          }
        }
      }
    };
    this.pWD = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (paramAnonymousView.getId() == 2131298817)
        {
          q.TF(a.this.pQV.csR().code);
          h.cD(a.this.pQZ, a.this.pQZ.getString(2131755773));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
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
    if (this.pWz != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void dz(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(2131298808);
    if (this.pWz == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.pWz == -1) {
        paramView.setText(2131757096);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void bc(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.pQZ.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.pQZ.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void cuE()
  {
    AppMethodBeat.i(113032);
    Log.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.pWA)
    {
      Log.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!Util.isNullOrNil(this.pQV.csR().LcE))
    {
      localObject1 = this.pQV.csR().LcE;
      Log.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.pQV.csR().Lcr)
      {
      default: 
        if (!Util.isNullOrNil(this.pQV.csQ().jTx)) {
          if (this.pQV.csQ().Lfe != null)
          {
            this.pWw.setText(this.pQV.csQ().jTx);
            this.pWw.setVisibility(0);
            this.pWv.setVisibility(8);
            if (this.pWr != null)
            {
              localObject1 = (ImageView)this.pWr.findViewById(2131298809);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cb.a.fromDPToPix(this.pQZ, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cb.a.fromDPToPix(this.pQZ, 180);
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
          if ((!this.pQV.csw()) || (TextUtils.isEmpty(this.pQV.csW())) || (this.pQV.csW().equals(z.aTY()))) {
            break label1203;
          }
          this.pWx.setVisibility(0);
          localObject1 = " " + this.pQZ.getString(2131756981, new Object[] { com.tencent.mm.plugin.card.d.l.akg(this.pQV.csW()) });
          this.pWx.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.pQZ, (CharSequence)localObject1, this.pQZ.getResources().getDimensionPixelOffset(2131165592)));
          AppMethodBeat.o(113032);
          return;
          if (this.pQV.csK())
          {
            localObject1 = am.cud().getCode();
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.pQV.csR().code;
          Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.pWr == null) {
            this.pWr = ((ViewStub)this.jBN.findViewById(2131298078)).inflate();
          }
          localObject3 = this.pWr;
          localObject2 = (ImageView)((View)localObject3).findViewById(2131298809);
          localObject3 = (TextView)((View)localObject3).findViewById(2131298817);
          if (!this.pQV.csx()) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.akl((String)localObject1));
            if (this.pQV.csG())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.pWD);
              label572:
              if (this.pWz != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            com.tencent.mm.plugin.card.d.l.Z(this.kuJ);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.kuJ = com.tencent.mm.by.a.a.b(this.pQZ, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.kuJ);
            }
            for (;;)
            {
              dz(this.pWr);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              ((TextView)localObject3).setVisibility(8);
              break label572;
              this.kuJ = null;
              ((ImageView)localObject2).setImageBitmap(this.kuJ);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.pWs == null) {
          this.pWs = ((ViewStub)this.jBN.findViewById(2131298073)).inflate();
        }
        Object localObject3 = this.pWs;
        localObject2 = (ImageView)((View)localObject3).findViewById(2131298793);
        localObject3 = (TextView)((View)localObject3).findViewById(2131298817);
        if (!this.pQV.csx()) {
          ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.akl(localException1));
          if (this.pQV.csG())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.pWD);
            label819:
            if (this.pWz != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          com.tencent.mm.plugin.card.d.l.Z(this.pWu);
          if (!TextUtils.isEmpty(localException1))
          {
            this.pWu = com.tencent.mm.by.a.a.b(this.pQZ, localException1, 5, 0);
            a((ImageView)localObject2, this.pWu);
          }
          for (;;)
          {
            dz(this.pWs);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            ((TextView)localObject3).setVisibility(8);
            break label819;
            this.pWu = null;
            ((ImageView)localObject2).setImageBitmap(this.pWu);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.pWt == null) {
        this.pWt = ((ViewStub)this.jBN.findViewById(2131298081)).inflate();
      }
      localObject2 = (TextView)this.pWt.findViewById(2131298817);
      ((TextView)localObject2).setText(n.akl(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.pWD);
      if (!this.pQV.csx()) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dz(this.pWt);
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
      this.pWv.setText(this.pQV.csQ().jTx);
      this.pWv.setVisibility(0);
      continue;
      this.pWv.setVisibility(8);
      this.pWw.setVisibility(8);
    }
    label1203:
    this.pWx.setChecked(false);
    this.pWx.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void Em(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */