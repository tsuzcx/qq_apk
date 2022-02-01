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
import com.tencent.mm.plugin.card.c.c;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.v;

public abstract class g
  extends i
{
  String code;
  private Bitmap qjG;
  private j wAf;
  private ViewGroup wJl;
  private ab wJm;
  private ViewStub wJn;
  protected com.tencent.mm.plugin.card.base.b wru;
  MMActivity wry;
  private Bitmap wwO;
  private View.OnLongClickListener wwX = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
      if (paramAnonymousView.getId() == a.d.wjG)
      {
        q.TF(g.this.wru.djL().code);
        k.cZ(g.this.wry, g.this.getString(a.g.app_copy_ok));
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(113671);
      return false;
    }
  };
  
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
      paramView = (ImageView)paramView.findViewById(a.d.wjz);
      l.ah(this.qjG);
      int j = 1;
      int i = j;
      if (this.wru != null)
      {
        i = j;
        if (this.wru.djK() != null) {
          i = this.wru.djK().Zeq;
        }
      }
      this.qjG = com.tencent.mm.bz.a.a.d(this.wry, paramString, 12, i);
      a(paramView, this.qjG);
      if (doM()) {
        paramView.setOnClickListener(this.wJs.dmo());
      }
      this.wAf.qjG = this.qjG;
      this.wAf.dnc();
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
      paramView = (ImageView)paramView.findViewById(a.d.wjq);
      l.ah(this.wwO);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.wwO = com.tencent.mm.bz.a.a.d(this.wry, paramString, 5, 0);
      }
      a(paramView, this.wwO);
      paramView.setOnClickListener(this.wJs.dmo());
      this.wAf.wwO = this.wwO;
      return;
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void g(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(a.d.wjG);
    paramView.setText(com.tencent.mm.plugin.card.c.n.alC(paramString));
    paramView.setOnLongClickListener(this.wwX);
    String str = this.wru.djK().nRQ;
    if (!Util.isNullOrNil(str)) {
      paramView.setTextColor(l.alv(str));
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
    this.wru = paramb;
  }
  
  public final void d(c paramc)
  {
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.wJm.g(this.wru))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      doH();
      return;
    }
    this.wJm.s(this.wJl);
    Log.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (Util.isNullOrNil(this.code))
    {
      Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.wru.djL().Zby)
    {
    default: 
      return;
    case 0: 
      g(this.wJl, this.code);
      return;
    case 2: 
      e(this.wJl, this.code);
      return;
    }
    f(this.wJl, this.code);
  }
  
  public final void ddE()
  {
    if ((this.wru != null) && (this.wJm != null) && (this.wJl != null))
    {
      this.wJm.b(this.wJl, this.wru);
      if ((this.wru.djL().Zby == 2) && (this.wAf != null))
      {
        j localj = this.wAf;
        if ((localj.qjH != null) && (localj.qjH.isShowing())) {
          localj.qjH.dismiss();
        }
      }
      return;
    }
    Log.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void destroy()
  {
    super.destroy();
    this.wry = null;
    this.wAf = null;
    this.wru = null;
    this.wJl = null;
    this.wJm = null;
    l.ah(this.qjG);
    l.ah(this.wwO);
  }
  
  public final void doE()
  {
    doI();
  }
  
  public final void doH()
  {
    if ((this.wJm != null) && (this.wru != null) && (this.wJl != null)) {
      this.wJm.a(this.wJl, this.wru);
    }
  }
  
  public final void doI()
  {
    if (this.wJl != null) {
      this.wJl.setVisibility(8);
    }
  }
  
  public abstract ab doJ();
  
  public abstract ab doK();
  
  public abstract ab doL();
  
  public boolean doM()
  {
    return true;
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(com.tencent.mm.plugin.card.base.b paramb);
  
  public final void initView()
  {
    this.wry = this.wJs.dmn();
    this.wAf = this.wJs.dmt();
    this.wru = this.wJs.dmk();
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.wru.djL().Zby)
    {
    default: 
      this.wJm = doJ();
    }
    while (this.wJm == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.wJm = doJ();
      continue;
      this.wJm = doK();
      continue;
      this.wJm = doL();
    }
    switch (this.wru.djL().Zby)
    {
    default: 
      if (this.wJn == null) {
        this.wJn = ((ViewStub)findViewById(a.d.why));
      }
      label209:
      if (this.wJn == null) {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.wJl == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.wJn != null) {
        break label209;
      }
      this.wJn = ((ViewStub)findViewById(a.d.why));
      break label209;
      if (this.wJn != null) {
        break label209;
      }
      this.wJn = ((ViewStub)findViewById(a.d.wft));
      break label209;
      if (this.wJn != null) {
        break label209;
      }
      this.wJn = ((ViewStub)findViewById(a.d.wfQ));
      break label209;
      if (this.wJm == null)
      {
        Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.wJm.getLayoutId() == 0)
      {
        Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.wJn.setLayoutResource(this.wJm.getLayoutId());
        if (this.wJl == null) {
          this.wJl = ((ViewGroup)this.wJn.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.wJm == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.wJl == null)
    {
      Log.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.wAf.dna();
    d(c.wKq);
    this.wJm.c(this.wJl, this.wru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */