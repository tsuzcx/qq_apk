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
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class a
{
  private final String TAG;
  View mrI;
  View.OnClickListener nmC;
  Bitmap nmx;
  com.tencent.mm.plugin.card.base.b tmU;
  MMActivity tmY;
  private View.OnLongClickListener tsA;
  private View tso;
  private View tsp;
  private View tsq;
  Bitmap tsr;
  TextView tss;
  TextView tst;
  CheckBox tsu;
  String tsv;
  int tsw;
  boolean tsx;
  a tsy;
  float tsz;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.tsw = 1;
    this.tsx = false;
    this.tsz = 0.0F;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == a.d.tgm)
        {
          if (!a.this.tsu.isChecked()) {
            break label98;
          }
          if (a.this.tsy != null) {
            a.this.tsy.HN(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113028);
          return;
          label98:
          if (a.this.tsy != null) {
            a.this.tsy.HN(0);
          }
        }
      }
    };
    this.tsA = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (paramAnonymousView.getId() == a.d.tfp)
        {
          q.abo(a.this.tmU.cGt().code);
          h.cO(a.this.tmY, a.this.tmY.getString(a.g.app_copy_ok));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.tmY = paramMMActivity;
    this.mrI = paramView;
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
    if (this.tsw != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void dX(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(a.d.tfh);
    if (this.tsw == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.tsw == -1) {
        paramView.setText(a.g.tkT);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void bb(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.tmY.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.tmY.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void cIg()
  {
    AppMethodBeat.i(113032);
    Log.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.tsx)
    {
      Log.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!Util.isNullOrNil(this.tmU.cGt().SdR))
    {
      localObject1 = this.tmU.cGt().SdR;
      Log.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.tmU.cGt().SdE)
      {
      default: 
        if (!Util.isNullOrNil(this.tmU.cGs().mKL)) {
          if (this.tmU.cGs().Sgs != null)
          {
            this.tst.setText(this.tmU.cGs().mKL);
            this.tst.setVisibility(0);
            this.tss.setVisibility(8);
            if (this.tso != null)
            {
              localObject1 = (ImageView)this.tso.findViewById(a.d.tfi);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.ci.a.fromDPToPix(this.tmY, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.ci.a.fromDPToPix(this.tmY, 180);
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
          if ((!this.tmU.cFX()) || (TextUtils.isEmpty(this.tmU.cGy())) || (this.tmU.cGy().equals(z.bcZ()))) {
            break label1205;
          }
          this.tsu.setVisibility(0);
          localObject1 = " " + this.tmY.getString(a.g.tjS, new Object[] { com.tencent.mm.plugin.card.d.l.arT(this.tmU.cGy()) });
          this.tsu.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.tmY, (CharSequence)localObject1, this.tmY.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          AppMethodBeat.o(113032);
          return;
          if (this.tmU.cGl())
          {
            localObject1 = am.cHF().getCode();
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.tmU.cGt().code;
          Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.tso == null) {
            this.tso = ((ViewStub)this.mrI.findViewById(a.d.tbC)).inflate();
          }
          localObject3 = this.tso;
          localObject2 = (ImageView)((View)localObject3).findViewById(a.d.tfi);
          localObject3 = (TextView)((View)localObject3).findViewById(a.d.tfp);
          if (!this.tmU.cFY()) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.arY((String)localObject1));
            if (this.tmU.cGh())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.tsA);
              label574:
              if (this.tsw != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            com.tencent.mm.plugin.card.d.l.X(this.nmx);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.nmx = com.tencent.mm.cf.a.a.c(this.tmY, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.nmx);
            }
            for (;;)
            {
              dX(this.tso);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label574;
              ((TextView)localObject3).setVisibility(8);
              break label574;
              this.nmx = null;
              ((ImageView)localObject2).setImageBitmap(this.nmx);
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
        if (this.tsp == null) {
          this.tsp = ((ViewStub)this.mrI.findViewById(a.d.tby)).inflate();
        }
        Object localObject3 = this.tsp;
        localObject2 = (ImageView)((View)localObject3).findViewById(a.d.teZ);
        localObject3 = (TextView)((View)localObject3).findViewById(a.d.tfp);
        if (!this.tmU.cFY()) {
          ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.arY(localException1));
          if (this.tmU.cGh())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.tsA);
            label821:
            if (this.tsw != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          com.tencent.mm.plugin.card.d.l.X(this.tsr);
          if (!TextUtils.isEmpty(localException1))
          {
            this.tsr = com.tencent.mm.cf.a.a.c(this.tmY, localException1, 5, 0);
            a((ImageView)localObject2, this.tsr);
          }
          for (;;)
          {
            dX(this.tsp);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label821;
            ((TextView)localObject3).setVisibility(8);
            break label821;
            this.tsr = null;
            ((ImageView)localObject2).setImageBitmap(this.tsr);
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
      if (this.tsq == null) {
        this.tsq = ((ViewStub)this.mrI.findViewById(a.d.tbE)).inflate();
      }
      localObject2 = (TextView)this.tsq.findViewById(a.d.tfp);
      ((TextView)localObject2).setText(n.arY(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.tsA);
      if (!this.tmU.cFY()) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        dX(this.tsq);
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
      this.tss.setText(this.tmU.cGs().mKL);
      this.tss.setVisibility(0);
      continue;
      this.tss.setVisibility(8);
      this.tst.setVisibility(8);
    }
    label1205:
    this.tsu.setChecked(false);
    this.tsu.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void HN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */