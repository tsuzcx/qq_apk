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
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public abstract class g
  extends i
{
  String code;
  private Bitmap kuJ;
  protected com.tencent.mm.plugin.card.base.b pQV;
  MMActivity pQZ;
  private View.OnLongClickListener pWD = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      if (paramAnonymousView.getId() == 2131298817)
      {
        q.TF(g.this.pQV.csR().code);
        h.cD(g.this.pQZ, g.this.getString(2131755773));
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private Bitmap pWu;
  private j pZL;
  private ViewGroup qjQ;
  private ab qjR;
  private ViewStub qjS;
  
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
      paramView = (ImageView)paramView.findViewById(2131298809);
      l.Z(this.kuJ);
      int j = 1;
      int i = j;
      if (this.pQV != null)
      {
        i = j;
        if (this.pQV.csQ() != null) {
          i = this.pQV.csQ().Lfh;
        }
      }
      this.kuJ = com.tencent.mm.by.a.a.b(this.pQZ, paramString, 12, i);
      a(paramView, this.kuJ);
      paramView.setOnClickListener(this.qjX.cvu());
      this.pZL.kuJ = this.kuJ;
      this.pZL.cwk();
      return;
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void d(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131298793);
      l.Z(this.pWu);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.pWu = com.tencent.mm.by.a.a.b(this.pQZ, paramString, 5, 0);
      }
      a(paramView, this.pWu);
      paramView.setOnClickListener(this.qjX.cvu());
      this.pZL.pWu = this.pWu;
      return;
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void e(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(2131298817);
    paramView.setText(com.tencent.mm.plugin.card.d.n.akl(paramString));
    paramView.setOnLongClickListener(this.pWD);
    String str = this.pQV.csQ().ixw;
    if (!Util.isNullOrNil(str)) {
      paramView.setTextColor(l.ake(str));
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
    this.pQV = paramb;
  }
  
  public final void cmW()
  {
    if ((this.pQV != null) && (this.qjR != null) && (this.qjQ != null))
    {
      this.qjR.b(this.qjQ, this.pQV);
      if ((this.pQV.csR().Lcr == 2) && (this.pZL != null))
      {
        j localj = this.pZL;
        if ((localj.kuK != null) && (localj.kuK.isShowing())) {
          localj.kuK.dismiss();
        }
      }
      return;
    }
    Log.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void cxA()
  {
    if (this.qjQ != null) {
      this.qjQ.setVisibility(8);
    }
  }
  
  public abstract ab cxB();
  
  public abstract ab cxC();
  
  public abstract ab cxD();
  
  public final void cxw()
  {
    cxA();
  }
  
  public final void cxz()
  {
    if ((this.qjR != null) && (this.pQV != null) && (this.qjQ != null)) {
      this.qjR.a(this.qjQ, this.pQV);
    }
  }
  
  public final void d(c paramc)
  {
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.qjR.g(this.pQV))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      cxz();
      return;
    }
    this.qjR.n(this.qjQ);
    Log.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (Util.isNullOrNil(this.code))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.pQV.csR().Lcr)
    {
    default: 
      return;
    case 0: 
      e(this.qjQ, this.code);
      return;
    case 2: 
      c(this.qjQ, this.code);
      return;
    }
    d(this.qjQ, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.pQZ = null;
    this.pZL = null;
    this.pQV = null;
    this.qjQ = null;
    this.qjR = null;
    l.Z(this.kuJ);
    l.Z(this.pWu);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(com.tencent.mm.plugin.card.base.b paramb);
  
  public final void initView()
  {
    this.pQZ = this.qjX.cvt();
    this.pZL = this.qjX.cvz();
    this.pQV = this.qjX.cvq();
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.pQV.csR().Lcr)
    {
    default: 
      this.qjR = cxB();
    }
    while (this.qjR == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.qjR = cxB();
      continue;
      this.qjR = cxC();
      continue;
      this.qjR = cxD();
    }
    switch (this.pQV.csR().Lcr)
    {
    default: 
      if (this.qjS == null) {
        this.qjS = ((ViewStub)findViewById(2131298199));
      }
      label209:
      if (this.qjS == null) {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.qjQ == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.qjS != null) {
        break label209;
      }
      this.qjS = ((ViewStub)findViewById(2131298199));
      break label209;
      if (this.qjS != null) {
        break label209;
      }
      this.qjS = ((ViewStub)findViewById(2131298047));
      break label209;
      if (this.qjS != null) {
        break label209;
      }
      this.qjS = ((ViewStub)findViewById(2131298079));
      break label209;
      if (this.qjR == null)
      {
        Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.qjR.getLayoutId() == 0)
      {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.qjS.setLayoutResource(this.qjR.getLayoutId());
        if (this.qjQ == null) {
          this.qjQ = ((ViewGroup)this.qjS.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.qjR == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.qjQ == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.pZL.cwi();
    d(c.qkV);
    this.qjR.c(this.qjQ, this.pQV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */