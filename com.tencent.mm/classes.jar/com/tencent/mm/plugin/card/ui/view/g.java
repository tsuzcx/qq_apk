package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap jas;
  protected b nTp;
  MMActivity nTt;
  private Bitmap nYK;
  private View.OnLongClickListener nYT = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(113671);
      if (paramAnonymousView.getId() == 2131298408)
      {
        q.GS(g.this.nTp.bPj().code);
        h.cg(g.this.nTt, g.this.getString(2131755702));
      }
      AppMethodBeat.o(113671);
      return false;
    }
  };
  private j occ;
  private ViewGroup okZ;
  private ab ola;
  private ViewStub olb;
  
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
      l.T(this.jas);
      int j = 1;
      int i = j;
      if (this.nTp != null)
      {
        i = j;
        if (this.nTp.bPi() != null) {
          i = this.nTp.bPi().EkW;
        }
      }
      this.jas = a.b(this.nTt, paramString, 12, i);
      a(paramView, this.jas);
      paramView.setOnClickListener(this.olg.bRK());
      this.occ.jas = this.jas;
      this.occ.bSA();
      return;
    }
    catch (Exception paramView)
    {
      ac.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void d(View paramView, String paramString)
  {
    try
    {
      paramView = (ImageView)paramView.findViewById(2131298384);
      l.T(this.nYK);
      if ((paramString != null) && (paramString.length() > 0)) {
        this.nYK = a.b(this.nTt, paramString, 5, 0);
      }
      a(paramView, this.nYK);
      paramView.setOnClickListener(this.olg.bRK());
      this.occ.nYK = this.nYK;
      return;
    }
    catch (Exception paramView)
    {
      ac.printErrStackTrace("MicroMsg.CardBaseCodeView", paramView, "", new Object[0]);
    }
  }
  
  private void e(View paramView, String paramString)
  {
    paramView = (TextView)paramView.findViewById(2131298408);
    paramView.setText(com.tencent.mm.plugin.card.d.n.VF(paramString));
    paramView.setOnLongClickListener(this.nYT);
    String str = this.nTp.bPi().hiu;
    if (!bs.isNullOrNil(str)) {
      paramView.setTextColor(l.Vy(str));
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
      ac.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.nTp = paramb;
  }
  
  public final void bTM()
  {
    bTR();
  }
  
  public final void bTP()
  {
    if ((this.ola != null) && (this.nTp != null) && (this.okZ != null)) {
      this.ola.a(this.okZ, this.nTp);
    }
  }
  
  public final void bTQ()
  {
    if ((this.nTp != null) && (this.ola != null) && (this.okZ != null))
    {
      this.ola.b(this.okZ, this.nTp);
      if ((this.nTp.bPj().Eif == 2) && (this.occ != null))
      {
        j localj = this.occ;
        if ((localj.jat != null) && (localj.jat.isShowing())) {
          localj.jat.dismiss();
        }
      }
      return;
    }
    ac.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public final void bTR()
  {
    if (this.okZ != null) {
      this.okZ.setVisibility(8);
    }
  }
  
  public abstract ab bTS();
  
  public abstract ab bTT();
  
  public abstract ab bTU();
  
  public final void d(c paramc)
  {
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
      return;
    }
    if (paramc == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
      return;
    }
    if (!this.ola.g(this.nTp))
    {
      ac.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
      bTP();
      return;
    }
    this.ola.n(this.okZ);
    ac.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
    this.code = e(paramc);
    if (bs.isNullOrNil(this.code))
    {
      ac.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
      return;
    }
    switch (this.nTp.bPj().Eif)
    {
    default: 
      return;
    case 0: 
      e(this.okZ, this.code);
      return;
    case 2: 
      c(this.okZ, this.code);
      return;
    }
    d(this.okZ, this.code);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.nTt = null;
    this.occ = null;
    this.nTp = null;
    this.okZ = null;
    this.ola = null;
    l.T(this.jas);
    l.T(this.nYK);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(b paramb);
  
  public final void initView()
  {
    this.nTt = this.olg.bRJ();
    this.occ = this.olg.bRP();
    this.nTp = this.olg.bRG();
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.nTp.bPj().Eif)
    {
    default: 
      this.ola = bTS();
    }
    while (this.ola == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.ola = bTS();
      continue;
      this.ola = bTT();
      continue;
      this.ola = bTU();
    }
    switch (this.nTp.bPj().Eif)
    {
    default: 
      if (this.olb == null) {
        this.olb = ((ViewStub)findViewById(2131297882));
      }
      label209:
      if (this.olb == null) {
        ac.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.okZ == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.olb != null) {
        break label209;
      }
      this.olb = ((ViewStub)findViewById(2131297882));
      break label209;
      if (this.olb != null) {
        break label209;
      }
      this.olb = ((ViewStub)findViewById(2131297735));
      break label209;
      if (this.olb != null) {
        break label209;
      }
      this.olb = ((ViewStub)findViewById(2131297765));
      break label209;
      if (this.ola == null)
      {
        ac.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.ola.getLayoutId() == 0)
      {
        ac.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.olb.setLayoutResource(this.ola.getLayoutId());
        if (this.okZ == null) {
          this.okZ = ((ViewGroup)this.olb.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.ola == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.okZ == null)
    {
      ac.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.occ.bSy();
    d(c.ome);
    this.ola.c(this.okZ, this.nTp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */