package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap jtB;
  private Bitmap oCe;
  private View.OnLongClickListener oCn = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      if (paramAnonymousView.getId() == 2131298408)
      {
        q.Kh(g.this.owK.bTO().code);
        h.cl(g.this.owO, g.this.getString(2131755702));
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private j oFv;
  private ViewGroup oOu;
  private ab oOv;
  private ViewStub oOw;
  protected com.tencent.mm.plugin.card.base.b owK;
  MMActivity owO;
  
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
      l.T(this.jtB);
      int j = 1;
      int i = j;
      if (this.owK != null)
      {
        i = j;
        if (this.owK.bTN() != null) {
          i = this.owK.bTN().FSf;
        }
      }
      this.jtB = com.tencent.mm.bz.a.a.b(this.owO, paramString, 12, i);
      a(paramView, this.jtB);
      paramView.setOnClickListener(this.oOB.bWp());
      this.oFv.jtB = this.jtB;
      this.oFv.bXf();
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
      l.T(this.oCe);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.oCe = com.tencent.mm.bz.a.a.b(this.owO, paramString, 5, 0);
      }
      a(paramView, this.oCe);
      paramView.setOnClickListener(this.oOB.bWp());
      this.oFv.oCe = this.oCe;
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
    paramView.setText(com.tencent.mm.plugin.card.d.n.Zo(paramString));
    paramView.setOnLongClickListener(this.oCn);
    String str = this.owK.bTN().hAD;
    if (!bt.isNullOrNil(str)) {
      paramView.setTextColor(l.Zh(str));
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
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    if (paramb == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.owK = paramb;
  }
  
  public final void bYr()
  {
    bYw();
  }
  
  public final void bYu()
  {
    if ((this.oOv != null) && (this.owK != null) && (this.oOu != null)) {
      this.oOv.a(this.oOu, this.owK);
    }
  }
  
  public final void bYv()
  {
    if ((this.owK != null) && (this.oOv != null) && (this.oOu != null))
    {
      this.oOv.b(this.oOu, this.owK);
      if ((this.owK.bTO().FPp == 2) && (this.oFv != null))
      {
        j localj = this.oFv;
        if ((localj.jtC != null) && (localj.jtC.isShowing())) {
          localj.jtC.dismiss();
        }
      }
      return;
    }
    ad.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void bYw()
  {
    if (this.oOu != null) {
      this.oOu.setVisibility(8);
    }
  }
  
  public abstract ab bYx();
  
  public abstract ab bYy();
  
  public abstract ab bYz();
  
  public final void d(c paramc)
  {
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.oOv.g(this.owK))
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      bYu();
      return;
    }
    this.oOv.n(this.oOu);
    ad.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (bt.isNullOrNil(this.code))
    {
      ad.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.owK.bTO().FPp)
    {
    default: 
      return;
    case 0: 
      e(this.oOu, this.code);
      return;
    case 2: 
      c(this.oOu, this.code);
      return;
    }
    d(this.oOu, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.owO = null;
    this.oFv = null;
    this.owK = null;
    this.oOu = null;
    this.oOv = null;
    l.T(this.jtB);
    l.T(this.oCe);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(com.tencent.mm.plugin.card.base.b paramb);
  
  public final void initView()
  {
    this.owO = this.oOB.bWo();
    this.oFv = this.oOB.bWu();
    this.owK = this.oOB.bWl();
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.owK.bTO().FPp)
    {
    default: 
      this.oOv = bYx();
    }
    while (this.oOv == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.oOv = bYx();
      continue;
      this.oOv = bYy();
      continue;
      this.oOv = bYz();
    }
    switch (this.owK.bTO().FPp)
    {
    default: 
      if (this.oOw == null) {
        this.oOw = ((ViewStub)findViewById(2131297882));
      }
      label209:
      if (this.oOw == null) {
        ad.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.oOu == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.oOw != null) {
        break label209;
      }
      this.oOw = ((ViewStub)findViewById(2131297882));
      break label209;
      if (this.oOw != null) {
        break label209;
      }
      this.oOw = ((ViewStub)findViewById(2131297735));
      break label209;
      if (this.oOw != null) {
        break label209;
      }
      this.oOw = ((ViewStub)findViewById(2131297765));
      break label209;
      if (this.oOv == null)
      {
        ad.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.oOv.getLayoutId() == 0)
      {
        ad.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.oOw.setLayoutResource(this.oOv.getLayoutId());
        if (this.oOu == null) {
          this.oOu = ((ViewGroup)this.oOw.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.oOv == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.oOu == null)
    {
      ad.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.oFv.bXd();
    d(c.oPz);
    this.oOv.c(this.oOu, this.owK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */