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
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap jww;
  protected com.tencent.mm.plugin.card.base.b oDm;
  MMActivity oDq;
  private Bitmap oIG;
  private View.OnLongClickListener oIP = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      if (paramAnonymousView.getId() == 2131298408)
      {
        q.KG(g.this.oDm.bVd().code);
        h.cm(g.this.oDq, g.this.getString(2131755702));
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private j oLX;
  private ViewGroup oUW;
  private ab oUX;
  private ViewStub oUY;
  
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
      l.U(this.jww);
      int j = 1;
      int i = j;
      if (this.oDm != null)
      {
        i = j;
        if (this.oDm.bVc() != null) {
          i = this.oDm.bVc().GkE;
        }
      }
      this.jww = com.tencent.mm.by.a.a.b(this.oDq, paramString, 12, i);
      a(paramView, this.jww);
      paramView.setOnClickListener(this.oVd.bXE());
      this.oLX.jww = this.jww;
      this.oLX.bYu();
      return;
    }
    catch (Exception paramView)
    {
      ae.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void d(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131298384);
      l.U(this.oIG);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.oIG = com.tencent.mm.by.a.a.b(this.oDq, paramString, 5, 0);
      }
      a(paramView, this.oIG);
      paramView.setOnClickListener(this.oVd.bXE());
      this.oLX.oIG = this.oIG;
      return;
    }
    catch (Exception paramView)
    {
      ae.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void e(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(2131298408);
    paramView.setText(com.tencent.mm.plugin.card.d.n.aaf(paramString));
    paramView.setOnLongClickListener(this.oIP);
    String str = this.oDm.bVc().hDr;
    if (!bu.isNullOrNil(str)) {
      paramView.setTextColor(l.ZY(str));
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
      ae.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.oDm = paramb;
  }
  
  public final void bZG()
  {
    bZL();
  }
  
  public final void bZJ()
  {
    if ((this.oUX != null) && (this.oDm != null) && (this.oUW != null)) {
      this.oUX.a(this.oUW, this.oDm);
    }
  }
  
  public final void bZK()
  {
    if ((this.oDm != null) && (this.oUX != null) && (this.oUW != null))
    {
      this.oUX.b(this.oUW, this.oDm);
      if ((this.oDm.bVd().GhO == 2) && (this.oLX != null))
      {
        j localj = this.oLX;
        if ((localj.jwx != null) && (localj.jwx.isShowing())) {
          localj.jwx.dismiss();
        }
      }
      return;
    }
    ae.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void bZL()
  {
    if (this.oUW != null) {
      this.oUW.setVisibility(8);
    }
  }
  
  public abstract ab bZM();
  
  public abstract ab bZN();
  
  public abstract ab bZO();
  
  public final void d(c paramc)
  {
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.oUX.g(this.oDm))
    {
      ae.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      bZJ();
      return;
    }
    this.oUX.n(this.oUW);
    ae.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (bu.isNullOrNil(this.code))
    {
      ae.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.oDm.bVd().GhO)
    {
    default: 
      return;
    case 0: 
      e(this.oUW, this.code);
      return;
    case 2: 
      c(this.oUW, this.code);
      return;
    }
    d(this.oUW, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.oDq = null;
    this.oLX = null;
    this.oDm = null;
    this.oUW = null;
    this.oUX = null;
    l.U(this.jww);
    l.U(this.oIG);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(com.tencent.mm.plugin.card.base.b paramb);
  
  public final void initView()
  {
    this.oDq = this.oVd.bXD();
    this.oLX = this.oVd.bXJ();
    this.oDm = this.oVd.bXA();
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.oDm.bVd().GhO)
    {
    default: 
      this.oUX = bZM();
    }
    while (this.oUX == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.oUX = bZM();
      continue;
      this.oUX = bZN();
      continue;
      this.oUX = bZO();
    }
    switch (this.oDm.bVd().GhO)
    {
    default: 
      if (this.oUY == null) {
        this.oUY = ((ViewStub)findViewById(2131297882));
      }
      label209:
      if (this.oUY == null) {
        ae.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.oUW == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.oUY != null) {
        break label209;
      }
      this.oUY = ((ViewStub)findViewById(2131297882));
      break label209;
      if (this.oUY != null) {
        break label209;
      }
      this.oUY = ((ViewStub)findViewById(2131297735));
      break label209;
      if (this.oUY != null) {
        break label209;
      }
      this.oUY = ((ViewStub)findViewById(2131297765));
      break label209;
      if (this.oUX == null)
      {
        ae.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.oUX.getLayoutId() == 0)
      {
        ae.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.oUY.setLayoutResource(this.oUX.getLayoutId());
        if (this.oUW == null) {
          this.oUW = ((ViewGroup)this.oUY.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.oUX == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.oUW == null)
    {
      ae.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.oLX.bYs();
    d(c.oWb);
    this.oUX.c(this.oUW, this.oDm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */