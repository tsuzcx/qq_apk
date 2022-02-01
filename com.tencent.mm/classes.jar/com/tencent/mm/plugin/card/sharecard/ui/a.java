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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.c.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public final class a
{
  private final String TAG;
  View plc;
  Bitmap qjG;
  View.OnClickListener qjL;
  com.tencent.mm.plugin.card.base.b wru;
  MMActivity wry;
  private View wwL;
  private View wwM;
  private View wwN;
  Bitmap wwO;
  TextView wwP;
  TextView wwQ;
  CheckBox wwR;
  String wwS;
  int wwT;
  boolean wwU;
  a wwV;
  float wwW;
  private View.OnLongClickListener wwX;
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113030);
    this.TAG = "MicroMsg.CardConsumeCodeController";
    this.wwT = 1;
    this.wwU = false;
    this.wwW = 0.0F;
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.d.wkI)
        {
          if (!a.this.wwR.isChecked()) {
            break label98;
          }
          if (a.this.wwV != null) {
            a.this.wwV.Io(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113028);
          return;
          label98:
          if (a.this.wwV != null) {
            a.this.wwV.Io(0);
          }
        }
      }
    };
    this.wwX = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (paramAnonymousView.getId() == a.d.wjG)
        {
          q.TF(a.this.wru.djL().code);
          k.cZ(a.this.wry, a.this.wry.getString(a.g.app_copy_ok));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeController$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(113029);
        return false;
      }
    };
    this.wry = paramMMActivity;
    this.plc = paramView;
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
    if (this.wwT != 1)
    {
      paramImageView.setAlpha(10);
      AppMethodBeat.o(113033);
      return;
    }
    paramImageView.setAlpha(255);
    AppMethodBeat.o(113033);
  }
  
  private void eL(View paramView)
  {
    AppMethodBeat.i(113034);
    paramView = (Button)paramView.findViewById(a.d.wjy);
    if (this.wwT == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.wwT == -1) {
        paramView.setText(a.g.wps);
      }
      AppMethodBeat.o(113034);
      return;
      paramView.setVisibility(0);
    }
  }
  
  final void ce(float paramFloat)
  {
    AppMethodBeat.i(113031);
    WindowManager.LayoutParams localLayoutParams = this.wry.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.wry.getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(113031);
  }
  
  public final void dlx()
  {
    AppMethodBeat.i(113032);
    Log.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.wwU)
    {
      Log.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      AppMethodBeat.o(113032);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!Util.isNullOrNil(this.wru.djL().ZbL))
    {
      localObject1 = this.wru.djL().ZbL;
      Log.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.wru.djL().Zby)
      {
      default: 
        if (!Util.isNullOrNil(this.wru.djK().pHt)) {
          if (this.wru.djK().Zen != null)
          {
            this.wwQ.setText(this.wru.djK().pHt);
            this.wwQ.setVisibility(0);
            this.wwP.setVisibility(8);
            if (this.wwL != null)
            {
              localObject1 = (ImageView)this.wwL.findViewById(a.d.wjz);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cd.a.fromDPToPix(this.wry, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cd.a.fromDPToPix(this.wry, 180);
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
          if ((!this.wru.djp()) || (TextUtils.isEmpty(this.wru.djQ())) || (this.wru.djQ().equals(z.bAM()))) {
            break label1205;
          }
          this.wwR.setVisibility(0);
          localObject1 = " " + this.wry.getString(a.g.wop, new Object[] { l.alx(this.wru.djQ()) });
          this.wwR.setText(p.h(this.wry, (CharSequence)localObject1, this.wry.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          AppMethodBeat.o(113032);
          return;
          if (this.wru.djD())
          {
            localObject1 = am.dkW().getCode();
            Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.wru.djL().code;
          Log.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.wwL == null) {
            this.wwL = ((ViewStub)this.plc.findViewById(a.d.wfP)).inflate();
          }
          localObject3 = this.wwL;
          localObject2 = (ImageView)((View)localObject3).findViewById(a.d.wjz);
          localObject3 = (TextView)((View)localObject3).findViewById(a.d.wjG);
          if (!this.wru.djq()) {
            ((TextView)localObject3).setTextColor(l.alv(this.wru.djK().nRQ));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(n.alC((String)localObject1));
            if (this.wru.djz())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.wwX);
              label574:
              if (this.wwT != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.ah(this.qjG);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.qjG = com.tencent.mm.bz.a.a.d(this.wry, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.qjG);
            }
            for (;;)
            {
              eL(this.wwL);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label574;
              ((TextView)localObject3).setVisibility(8);
              break label574;
              this.qjG = null;
              ((ImageView)localObject2).setImageBitmap(this.qjG);
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
        if (this.wwM == null) {
          this.wwM = ((ViewStub)this.plc.findViewById(a.d.wfL)).inflate();
        }
        Object localObject3 = this.wwM;
        localObject2 = (ImageView)((View)localObject3).findViewById(a.d.wjq);
        localObject3 = (TextView)((View)localObject3).findViewById(a.d.wjG);
        if (!this.wru.djq()) {
          ((TextView)localObject3).setTextColor(l.alv(this.wru.djK().nRQ));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(n.alC(localException1));
          if (this.wru.djz())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.wwX);
            label821:
            if (this.wwT != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.ah(this.wwO);
          if (!TextUtils.isEmpty(localException1))
          {
            this.wwO = com.tencent.mm.bz.a.a.d(this.wry, localException1, 5, 0);
            a((ImageView)localObject2, this.wwO);
          }
          for (;;)
          {
            eL(this.wwM);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label821;
            ((TextView)localObject3).setVisibility(8);
            break label821;
            this.wwO = null;
            ((ImageView)localObject2).setImageBitmap(this.wwO);
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
      if (this.wwN == null) {
        this.wwN = ((ViewStub)this.plc.findViewById(a.d.wfR)).inflate();
      }
      localObject2 = (TextView)this.wwN.findViewById(a.d.wjG);
      ((TextView)localObject2).setText(n.alC(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.wwX);
      if (!this.wru.djq()) {
        ((TextView)localObject2).setTextColor(l.alv(this.wru.djK().nRQ));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        eL(this.wwN);
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
      this.wwP.setText(this.wru.djK().pHt);
      this.wwP.setVisibility(0);
      continue;
      this.wwP.setVisibility(8);
      this.wwQ.setVisibility(8);
    }
    label1205:
    this.wwR.setChecked(false);
    this.wwR.setVisibility(8);
    AppMethodBeat.o(113032);
  }
  
  public static abstract interface a
  {
    public abstract void Io(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */