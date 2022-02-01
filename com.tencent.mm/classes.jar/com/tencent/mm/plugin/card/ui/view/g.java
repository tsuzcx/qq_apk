package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

public abstract class g
  extends i
{
  String code;
  private Bitmap nmx;
  private ViewGroup tFM;
  private ab tFN;
  private ViewStub tFO;
  protected com.tencent.mm.plugin.card.base.b tmU;
  MMActivity tmY;
  private View.OnLongClickListener tsA = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      if (paramAnonymousView.getId() == a.d.tfp)
      {
        q.abo(g.this.tmU.cGt().code);
        h.cO(g.this.tmY, g.this.getString(a.g.app_copy_ok));
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private Bitmap tsr;
  private j tvH;
  
  private static void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if ((paramImageView == null) || (paramBitmap == null)) {
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  private void e(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(a.d.tfi);
      l.X(this.nmx);
      int j = 1;
      int i = j;
      if (this.tmU != null)
      {
        i = j;
        if (this.tmU.cGs() != null) {
          i = this.tmU.cGs().Sgv;
        }
      }
      this.nmx = com.tencent.mm.cf.a.a.c(this.tmY, paramString, 12, i);
      a(paramView, this.nmx);
      paramView.setOnClickListener(this.tFT.cIW());
      this.tvH.nmx = this.nmx;
      this.tvH.cJM();
      return;
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void f(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(a.d.teZ);
      l.X(this.tsr);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.tsr = com.tencent.mm.cf.a.a.c(this.tmY, paramString, 5, 0);
      }
      a(paramView, this.tsr);
      paramView.setOnClickListener(this.tFT.cIW());
      this.tvH.tsr = this.tsr;
      return;
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void g(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(a.d.tfp);
    paramView.setText(com.tencent.mm.plugin.card.d.n.arY(paramString));
    paramView.setOnLongClickListener(this.tsA);
    String str = this.tmU.cGs().lmL;
    if (!Util.isNullOrNil(str)) {
      paramView.setTextColor(l.arR(str));
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
      Log.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.tmU = paramb;
  }
  
  public final void cAE()
  {
    if ((this.tmU != null) && (this.tFN != null) && (this.tFM != null))
    {
      this.tFN.b(this.tFM, this.tmU);
      if ((this.tmU.cGt().SdE == 2) && (this.tvH != null))
      {
        j localj = this.tvH;
        if ((localj.nmy != null) && (localj.nmy.isShowing())) {
          localj.nmy.dismiss();
        }
      }
      return;
    }
    Log.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void cKY()
  {
    cLc();
  }
  
  public final void cLb()
  {
    if ((this.tFN != null) && (this.tmU != null) && (this.tFM != null)) {
      this.tFN.a(this.tFM, this.tmU);
    }
  }
  
  public final void cLc()
  {
    if (this.tFM != null) {
      this.tFM.setVisibility(8);
    }
  }
  
  public abstract ab cLd();
  
  public abstract ab cLe();
  
  public abstract ab cLf();
  
  public final void d(c paramc)
  {
    if (this.tmU == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.tFN.g(this.tmU))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      cLb();
      return;
    }
    this.tFN.o(this.tFM);
    Log.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (Util.isNullOrNil(this.code))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.tmU.cGt().SdE)
    {
    default: 
      return;
    case 0: 
      g(this.tFM, this.code);
      return;
    case 2: 
      e(this.tFM, this.code);
      return;
    }
    f(this.tFM, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.tmY = null;
    this.tvH = null;
    this.tmU = null;
    this.tFM = null;
    this.tFN = null;
    l.X(this.nmx);
    l.X(this.tsr);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(com.tencent.mm.plugin.card.base.b paramb);
  
  public final void initView()
  {
    this.tmY = this.tFT.cIV();
    this.tvH = this.tFT.cJb();
    this.tmU = this.tFT.cIS();
    if (this.tmU == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.tmU.cGt().SdE)
    {
    default: 
      this.tFN = cLd();
    }
    while (this.tFN == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.tFN = cLd();
      continue;
      this.tFN = cLe();
      continue;
      this.tFN = cLf();
    }
    switch (this.tmU.cGt().SdE)
    {
    default: 
      if (this.tFO == null) {
        this.tFO = ((ViewStub)findViewById(a.d.tdk));
      }
      label209:
      if (this.tFO == null) {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.tFM == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.tFO != null) {
        break label209;
      }
      this.tFO = ((ViewStub)findViewById(a.d.tdk));
      break label209;
      if (this.tFO != null) {
        break label209;
      }
      this.tFO = ((ViewStub)findViewById(a.d.tbj));
      break label209;
      if (this.tFO != null) {
        break label209;
      }
      this.tFO = ((ViewStub)findViewById(a.d.tbD));
      break label209;
      if (this.tFN == null)
      {
        Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.tFN.getLayoutId() == 0)
      {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.tFO.setLayoutResource(this.tFN.getLayoutId());
        if (this.tFM == null) {
          this.tFM = ((ViewGroup)this.tFO.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.tmU == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.tFN == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.tFM == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.tvH.cJK();
    d(c.tGR);
    this.tFN.c(this.tFM, this.tmU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */