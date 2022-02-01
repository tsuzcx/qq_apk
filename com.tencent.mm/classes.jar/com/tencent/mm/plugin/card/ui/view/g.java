package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap iAr;
  private ViewGroup nHZ;
  private ab nIa;
  private ViewStub nIb;
  protected b nqp;
  MMActivity nqt;
  private Bitmap nvK;
  private View.OnLongClickListener nvT = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      if (paramAnonymousView.getId() == 2131298408)
      {
        q.CP(g.this.nqp.bHW().code);
        h.cf(g.this.nqt, g.this.getString(2131755702));
      }
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private j nzb;
  
  private static void a(ImageView paramImageView, Bitmap paramBitmap)
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
      paramView = (ImageView)paramView.findViewById(2131298400);
      l.T(this.iAr);
      int j = 1;
      int i = j;
      if (this.nqp != null)
      {
        i = j;
        if (this.nqp.bHV() != null) {
          i = this.nqp.bHV().CSl;
        }
      }
      this.iAr = a.b(this.nqt, paramString, 12, i);
      a(paramView, this.iAr);
      paramView.setOnClickListener(this.nIg.bKx());
      this.nzb.iAr = this.iAr;
      this.nzb.bLn();
      return;
    }
    catch (Exception paramView)
    {
      ad.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void d(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131298384);
      l.T(this.nvK);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.nvK = a.b(this.nqt, paramString, 5, 0);
      }
      a(paramView, this.nvK);
      paramView.setOnClickListener(this.nIg.bKx());
      this.nzb.nvK = this.nvK;
      return;
    }
    catch (Exception paramView)
    {
      ad.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void e(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(2131298408);
    paramView.setText(com.tencent.mm.plugin.card.d.n.Rt(paramString));
    paramView.setOnLongClickListener(this.nvT);
    String str = this.nqp.bHV().gHT;
    if (!bt.isNullOrNil(str)) {
      paramView.setTextColor(l.Rm(str));
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
      ad.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.nqp = paramb;
  }
  
  public final void bMB()
  {
    bMG();
  }
  
  public final void bME()
  {
    if ((this.nIa != null) && (this.nqp != null) && (this.nHZ != null)) {
      this.nIa.a(this.nHZ, this.nqp);
    }
  }
  
  public final void bMF()
  {
    if ((this.nqp != null) && (this.nIa != null) && (this.nHZ != null))
    {
      this.nIa.b(this.nHZ, this.nqp);
      if ((this.nqp.bHW().CPu == 2) && (this.nzb != null))
      {
        j localj = this.nzb;
        if ((localj.iAs != null) && (localj.iAs.isShowing())) {
          localj.iAs.dismiss();
        }
      }
      return;
    }
    ad.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void bMG()
  {
    if (this.nHZ != null) {
      this.nHZ.setVisibility(8);
    }
  }
  
  public abstract ab bMH();
  
  public abstract ab bMI();
  
  public abstract ab bMJ();
  
  public final void d(c paramc)
  {
    if (this.nqp == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.nIa.g(this.nqp))
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      bME();
      return;
    }
    this.nIa.n(this.nHZ);
    ad.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (bt.isNullOrNil(this.code))
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.nqp.bHW().CPu)
    {
    default: 
      return;
    case 0: 
      e(this.nHZ, this.code);
      return;
    case 2: 
      c(this.nHZ, this.code);
      return;
    }
    d(this.nHZ, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.nqt = null;
    this.nzb = null;
    this.nqp = null;
    this.nHZ = null;
    this.nIa = null;
    l.T(this.iAr);
    l.T(this.nvK);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(b paramb);
  
  public final void initView()
  {
    this.nqt = this.nIg.bKw();
    this.nzb = this.nIg.bKC();
    this.nqp = this.nIg.bKt();
    if (this.nqp == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.nqp.bHW().CPu)
    {
    default: 
      this.nIa = bMH();
    }
    while (this.nIa == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.nIa = bMH();
      continue;
      this.nIa = bMI();
      continue;
      this.nIa = bMJ();
    }
    switch (this.nqp.bHW().CPu)
    {
    default: 
      if (this.nIb == null) {
        this.nIb = ((ViewStub)findViewById(2131297882));
      }
      label209:
      if (this.nIb == null) {
        ad.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.nHZ == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.nIb != null) {
        break label209;
      }
      this.nIb = ((ViewStub)findViewById(2131297882));
      break label209;
      if (this.nIb != null) {
        break label209;
      }
      this.nIb = ((ViewStub)findViewById(2131297735));
      break label209;
      if (this.nIb != null) {
        break label209;
      }
      this.nIb = ((ViewStub)findViewById(2131297765));
      break label209;
      if (this.nIa == null)
      {
        ad.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.nIa.getLayoutId() == 0)
      {
        ad.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.nIb.setLayoutResource(this.nIa.getLayoutId());
        if (this.nHZ == null) {
          this.nHZ = ((ViewGroup)this.nIb.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.nqp == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.nIa == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.nHZ == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.nzb.bLl();
    d(c.nJe);
    this.nIa.c(this.nHZ, this.nqp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */