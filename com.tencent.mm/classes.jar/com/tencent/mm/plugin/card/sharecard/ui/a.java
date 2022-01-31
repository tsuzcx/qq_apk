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
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  private final String TAG = "MicroMsg.CardConsumeCodeController";
  Bitmap fve;
  View.OnClickListener fvj = new a.1(this);
  MMActivity hxN;
  b ikk;
  View ipf;
  private View ipg;
  private View iph;
  private View ipi;
  Bitmap ipj;
  TextView ipk;
  TextView ipl;
  CheckBox ipm;
  String ipn;
  int ipo = 1;
  boolean ipp = false;
  a.a ipq;
  float ipr = 0.0F;
  private View.OnLongClickListener ips = new a.2(this);
  
  public a(MMActivity paramMMActivity, View paramView)
  {
    this.hxN = paramMMActivity;
    this.ipf = paramView;
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if ((paramImageView == null) || (paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
    if (this.ipo != 1)
    {
      paramImageView.setAlpha(10);
      return;
    }
    paramImageView.setAlpha(255);
  }
  
  private void cD(View paramView)
  {
    paramView = (Button)paramView.findViewById(a.d.code_mark_btn);
    if (this.ipo == 1) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      if (this.ipo == -1) {
        paramView.setText(a.g.card_mark_failed_tips);
      }
      return;
      paramView.setVisibility(0);
    }
  }
  
  public final void aAW()
  {
    y.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
    if (!this.ipp)
    {
      y.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
      return;
    }
    Object localObject1;
    Object localObject2;
    if (!bk.bl(this.ikk.azy().sHK))
    {
      localObject1 = this.ikk.azy().sHK;
      y.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[] { localObject1 });
      switch (this.ikk.azy().sHx)
      {
      default: 
        if (!bk.bl(this.ikk.azx().iHC)) {
          if (this.ikk.azx().sIU != null)
          {
            this.ipl.setText(this.ikk.azx().iHC);
            this.ipl.setVisibility(0);
            this.ipk.setVisibility(8);
            if (this.ipg != null)
            {
              localObject1 = (ImageView)this.ipg.findViewById(a.d.code_qr_area);
              localObject2 = ((ImageView)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = com.tencent.mm.cb.a.fromDPToPix(this.hxN, 180);
              ((ViewGroup.LayoutParams)localObject2).width = com.tencent.mm.cb.a.fromDPToPix(this.hxN, 180);
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
          if ((!this.ikk.aze()) || (TextUtils.isEmpty(this.ikk.azD())) || (this.ikk.azD().equals(q.Gj()))) {
            break label1191;
          }
          this.ipm.setVisibility(0);
          localObject1 = " " + this.hxN.getString(a.g.card_code_notify_user, new Object[] { l.yU(this.ikk.azD()) });
          this.ipm.setText(j.e(this.hxN, (CharSequence)localObject1, this.hxN.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          return;
          if (this.ikk.azs())
          {
            localObject1 = am.aAF().getCode();
            y.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[] { localObject1 });
            break;
          }
          localObject1 = this.ikk.azy().code;
          y.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[] { localObject1 });
          break;
          if (this.ipg == null) {
            this.ipg = ((ViewStub)this.ipf.findViewById(a.d.card_code_qrcode_stub)).inflate();
          }
          localObject3 = this.ipg;
          localObject2 = (ImageView)((View)localObject3).findViewById(a.d.code_qr_area);
          localObject3 = (TextView)((View)localObject3).findViewById(a.d.code_text);
          if (!this.ikk.azf()) {
            ((TextView)localObject3).setTextColor(l.yR(this.ikk.azx().color));
          }
          if (((String)localObject1).length() <= 40)
          {
            ((TextView)localObject3).setText(m.yZ((String)localObject1));
            if (this.ikk.azo())
            {
              ((TextView)localObject3).setVisibility(0);
              ((TextView)localObject3).setOnLongClickListener(this.ips);
              label560:
              if (this.ipo != 1) {
                ((TextView)localObject3).setVisibility(4);
              }
            }
          }
          try
          {
            l.w(this.fve);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.fve = com.tencent.mm.by.a.a.b(this.hxN, (String)localObject1, 12, 3);
              a((ImageView)localObject2, this.fve);
            }
            for (;;)
            {
              cD(this.ipg);
              break;
              ((TextView)localObject3).setVisibility(8);
              break label560;
              ((TextView)localObject3).setVisibility(8);
              break label560;
              this.fve = null;
              ((ImageView)localObject2).setImageBitmap(this.fve);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException1, "", new Object[0]);
            }
          }
        }
        if (this.iph == null) {
          this.iph = ((ViewStub)this.ipf.findViewById(a.d.card_code_barcode_stub)).inflate();
        }
        Object localObject3 = this.iph;
        localObject2 = (ImageView)((View)localObject3).findViewById(a.d.code_bar_area);
        localObject3 = (TextView)((View)localObject3).findViewById(a.d.code_text);
        if (!this.ikk.azf()) {
          ((TextView)localObject3).setTextColor(l.yR(this.ikk.azx().color));
        }
        if ((!TextUtils.isEmpty(localException1)) && (localException1.length() <= 40))
        {
          ((TextView)localObject3).setText(m.yZ(localException1));
          if (this.ikk.azo())
          {
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setOnLongClickListener(this.ips);
            label807:
            if (this.ipo != 1) {
              ((TextView)localObject3).setVisibility(4);
            }
          }
        }
        try
        {
          l.w(this.ipj);
          if (!TextUtils.isEmpty(localException1))
          {
            this.ipj = com.tencent.mm.by.a.a.b(this.hxN, localException1, 5, 0);
            a((ImageView)localObject2, this.ipj);
          }
          for (;;)
          {
            cD(this.iph);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label807;
            ((TextView)localObject3).setVisibility(8);
            break label807;
            this.ipj = null;
            ((ImageView)localObject2).setImageBitmap(this.ipj);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.CardConsumeCodeController", localException2, "", new Object[0]);
          }
        }
      }
      if (this.ipi == null) {
        this.ipi = ((ViewStub)this.ipf.findViewById(a.d.card_code_text_stub)).inflate();
      }
      localObject2 = (TextView)this.ipi.findViewById(a.d.code_text);
      ((TextView)localObject2).setText(m.yZ(localException2));
      ((TextView)localObject2).setOnLongClickListener(this.ips);
      if (!this.ikk.azf()) {
        ((TextView)localObject2).setTextColor(l.yR(this.ikk.azx().color));
      }
      if (localException2.length() <= 12) {
        ((TextView)localObject2).setTextSize(1, 33.0F);
      }
      for (;;)
      {
        cD(this.ipi);
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
      this.ipk.setText(this.ikk.azx().iHC);
      this.ipk.setVisibility(0);
      continue;
      this.ipk.setVisibility(8);
      this.ipl.setVisibility(8);
    }
    label1191:
    this.ipm.setChecked(false);
    this.ipm.setVisibility(8);
  }
  
  final void ao(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.hxN.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.hxN.getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a
 * JD-Core Version:    0.7.0.1
 */