package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.by.a.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap gMJ;
  MMActivity jpX;
  private ViewGroup kBa;
  private ab kBb;
  private ViewStub kBc;
  protected b klk;
  private Bitmap kqq;
  private View.OnLongClickListener kqz = new g.1(this);
  private j ktL;
  
  private void b(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131822018);
      l.I(this.gMJ);
      int j = 1;
      int i = j;
      if (this.klk != null)
      {
        i = j;
        if (this.klk.bbd() != null) {
          i = this.klk.bbd().wGG;
        }
      }
      this.gMJ = a.b(this.jpX, paramString, 12, i);
      b(paramView, this.gMJ);
      paramView.setOnClickListener(this.kBh.bdz());
      this.ktL.gMJ = this.gMJ;
      this.ktL.beq();
      return;
    }
    catch (Exception paramView)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private static void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    if ((paramImageView == null) || (paramBitmap == null)) {
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  private void c(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131822011);
      l.I(this.kqq);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.kqq = a.b(this.jpX, paramString, 5, 0);
      }
      b(paramView, this.kqq);
      paramView.setOnClickListener(this.kBh.bdz());
      this.ktL.kqq = this.kqq;
      return;
    }
    catch (Exception paramView)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void d(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(2131822013);
    paramView.setText(m.II(paramString));
    paramView.setOnLongClickListener(this.kqz);
    String str = this.klk.bbd().color;
    if (!bo.isNullOrNil(str)) {
      paramView.setTextColor(l.IB(str));
    }
    if (paramString.length() <= 12) {
      paramView.setTextSize(1, 33.0F);
    }
    do
    {
      return;
      if ((paramString.length() > 12) && (paramString.length() <= 16))
      {
        paramView.setTextSize(1, 30.0F);
        return;
      }
      if ((paramString.length() > 16) && (paramString.length() <= 20))
      {
        paramView.setTextSize(1, 24.0F);
        return;
      }
      if ((paramString.length() > 20) && (paramString.length() <= 40))
      {
        paramView.setTextSize(1, 18.0F);
        return;
      }
    } while (paramString.length() <= 40);
    paramView.setVisibility(8);
  }
  
  public final void b(b paramb)
  {
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.klk = paramb;
  }
  
  public final void bfq()
  {
    bfv();
  }
  
  public final void bft()
  {
    if ((this.kBb != null) && (this.klk != null) && (this.kBa != null)) {
      this.kBb.a(this.kBa, this.klk);
    }
  }
  
  public final void bfu()
  {
    if ((this.klk != null) && (this.kBb != null) && (this.kBa != null))
    {
      this.kBb.b(this.kBa, this.klk);
      if ((this.klk.bbe().wDT == 2) && (this.ktL != null))
      {
        j localj = this.ktL;
        if ((localj.gMK != null) && (localj.gMK.isShowing())) {
          localj.gMK.dismiss();
        }
      }
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void bfv()
  {
    if (this.kBa != null) {
      this.kBa.setVisibility(8);
    }
  }
  
  public abstract ab bfw();
  
  public abstract ab bfx();
  
  public abstract ab bfy();
  
  public final void d(c paramc)
  {
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.kBb.g(this.klk))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      bft();
      return;
    }
    this.kBb.l(this.kBa);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (bo.isNullOrNil(this.code))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.klk.bbe().wDT)
    {
    default: 
      return;
    case 0: 
      d(this.kBa, this.code);
      return;
    case 2: 
      b(this.kBa, this.code);
      return;
    }
    c(this.kBa, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.jpX = null;
    this.ktL = null;
    this.klk = null;
    this.kBa = null;
    this.kBb = null;
    l.I(this.gMJ);
    l.I(this.kqq);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(b paramb);
  
  public final void initView()
  {
    this.jpX = this.kBh.bdy();
    this.ktL = this.kBh.bdE();
    this.klk = this.kBh.bdv();
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.klk.bbe().wDT)
    {
    default: 
      this.kBb = bfw();
    }
    while (this.kBb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.kBb = bfw();
      continue;
      this.kBb = bfx();
      continue;
      this.kBb = bfy();
    }
    switch (this.klk.bbe().wDT)
    {
    default: 
      if (this.kBc == null) {
        this.kBc = ((ViewStub)findViewById(2131822087));
      }
      label209:
      if (this.kBc == null) {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.kBa == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.kBc != null) {
        break label209;
      }
      this.kBc = ((ViewStub)findViewById(2131822087));
      break label209;
      if (this.kBc != null) {
        break label209;
      }
      this.kBc = ((ViewStub)findViewById(2131822088));
      break label209;
      if (this.kBc != null) {
        break label209;
      }
      this.kBc = ((ViewStub)findViewById(2131822089));
      break label209;
      if (this.kBb == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.kBb.getLayoutId() == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.kBc.setLayoutResource(this.kBb.getLayoutId());
        if (this.kBa == null) {
          this.kBa = ((ViewGroup)this.kBc.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.kBb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.kBa == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.ktL.beo();
    d(c.kCf);
    this.kBb.c(this.kBa, this.klk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */