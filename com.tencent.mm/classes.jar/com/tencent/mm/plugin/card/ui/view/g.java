package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.by.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;

public abstract class g
  extends i
{
  String code;
  private Bitmap fve;
  MMActivity hxN;
  protected b ikk;
  private Bitmap ipj;
  private View.OnLongClickListener ips = new g.1(this);
  private j isE;
  private ViewGroup ixT;
  private ab ixU;
  private ViewStub ixV;
  
  private static void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if ((paramImageView == null) || (paramBitmap == null)) {
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  public final void aCU()
  {
    if (this.ixT != null) {
      this.ixT.setVisibility(8);
    }
  }
  
  public final void aCX()
  {
    if ((this.ixU != null) && (this.ikk != null) && (this.ixT != null)) {
      this.ixU.a(this.ixT, this.ikk);
    }
  }
  
  public final void aCY()
  {
    if ((this.ikk != null) && (this.ixU != null) && (this.ixT != null))
    {
      this.ixU.b(this.ixT, this.ikk);
      if ((this.ikk.azy().sHx == 2) && (this.isE != null))
      {
        j localj = this.isE;
        if ((localj.fvf != null) && (localj.fvf.isShowing())) {
          localj.fvf.dismiss();
        }
      }
      return;
    }
    y.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
  }
  
  public abstract ab aCZ();
  
  public abstract ab aDa();
  
  public abstract ab aDb();
  
  public final void b(b paramb)
  {
    if (paramb == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
      return;
    }
    this.ikk = paramb;
  }
  
  public final void d(c paramc)
  {
    int j = 1;
    if (this.ikk == null) {
      y.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
    }
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        if (paramc == null)
        {
          y.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
          return;
        }
        if (!this.ixU.g(this.ikk))
        {
          y.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
          aCX();
          return;
        }
        this.ixU.k(this.ixT);
        y.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[] { Integer.valueOf(paramc.action) });
        this.code = e(paramc);
        if (bk.bl(this.code))
        {
          y.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
          return;
        }
        switch (this.ikk.azy().sHx)
        {
        default: 
          return;
        case 0: 
          localObject = this.ixT;
          paramc = this.code;
          localObject = (TextView)((View)localObject).findViewById(a.d.code_text);
          ((TextView)localObject).setText(m.yZ(paramc));
          ((TextView)localObject).setOnLongClickListener(this.ips);
          String str = this.ikk.azx().color;
          if (!bk.bl(str)) {
            ((TextView)localObject).setTextColor(l.yR(str));
          }
          if (paramc.length() > 12) {
            break;
          }
          ((TextView)localObject).setTextSize(1, 33.0F);
          return;
        case 2: 
          localObject = this.ixT;
          paramc = this.code;
          try
          {
            localObject = (ImageView)((View)localObject).findViewById(a.d.code_qr_area);
            l.w(this.fve);
            int i = j;
            if (this.ikk != null)
            {
              i = j;
              if (this.ikk.azx() != null) {
                i = this.ikk.azx().sIX;
              }
            }
            this.fve = a.b(this.hxN, paramc, 12, i);
            a((ImageView)localObject, this.fve);
            ((ImageView)localObject).setOnClickListener(this.iya.aBI());
            this.isE.fve = this.fve;
            paramc = this.isE;
            if ((paramc.fvf != null) && (paramc.fvf.isShowing()))
            {
              paramc.fvg.setImageBitmap(paramc.fve);
              return;
            }
          }
          catch (Exception paramc)
          {
            y.printErrStackTrace("MicroMsg.CardBaseCodeView", paramc, "", new Object[0]);
            return;
          }
        }
      }
      localObject = this.ixT;
      paramc = this.code;
      try
      {
        localObject = (ImageView)((View)localObject).findViewById(a.d.code_bar_area);
        l.w(this.ipj);
        if ((paramc != null) && (paramc.length() > 0)) {
          this.ipj = a.b(this.hxN, paramc, 5, 0);
        }
        a((ImageView)localObject, this.ipj);
        ((ImageView)localObject).setOnClickListener(this.iya.aBI());
        this.isE.ipj = this.ipj;
        return;
      }
      catch (Exception paramc)
      {
        y.printErrStackTrace("MicroMsg.CardBaseCodeView", paramc, "", new Object[0]);
        return;
      }
      if ((paramc.length() > 12) && (paramc.length() <= 16))
      {
        ((TextView)localObject).setTextSize(1, 30.0F);
        return;
      }
      if ((paramc.length() > 16) && (paramc.length() <= 20))
      {
        ((TextView)localObject).setTextSize(1, 24.0F);
        return;
      }
      if ((paramc.length() > 20) && (paramc.length() <= 40))
      {
        ((TextView)localObject).setTextSize(1, 18.0F);
        return;
      }
    } while (paramc.length() <= 40);
    ((TextView)localObject).setVisibility(8);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.hxN = null;
    this.isE = null;
    this.ikk = null;
    this.ixT = null;
    this.ixU = null;
    l.w(this.fve);
    l.w(this.ipj);
  }
  
  public abstract String e(c paramc);
  
  public abstract boolean f(b paramb);
  
  public final void initView()
  {
    this.hxN = this.iya.aBH();
    this.isE = this.iya.aBN();
    this.ikk = this.iya.aBE();
    if (this.ikk == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
      return;
    }
    switch (this.ikk.azy().sHx)
    {
    default: 
      this.ixU = aCZ();
    }
    while (this.ixU == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      return;
      this.ixU = aCZ();
      continue;
      this.ixU = aDa();
      continue;
      this.ixU = aDb();
    }
    switch (this.ikk.azy().sHx)
    {
    default: 
      if (this.ixV == null) {
        this.ixV = ((ViewStub)findViewById(a.d.card_qrcode_stub));
      }
      label209:
      if (this.ixV == null) {
        y.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
      }
      break;
    }
    while (this.ixT == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
      return;
      if (this.ixV != null) {
        break label209;
      }
      this.ixV = ((ViewStub)findViewById(a.d.card_qrcode_stub));
      break label209;
      if (this.ixV != null) {
        break label209;
      }
      this.ixV = ((ViewStub)findViewById(a.d.card_barcode_stub));
      break label209;
      if (this.ixV != null) {
        break label209;
      }
      this.ixV = ((ViewStub)findViewById(a.d.card_code_stub));
      break label209;
      if (this.ixU == null)
      {
        y.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
      }
      else if (this.ixU.getLayoutId() == 0)
      {
        y.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
      }
      else
      {
        this.ixV.setLayoutResource(this.ixU.getLayoutId());
        if (this.ixT == null) {
          this.ixT = ((ViewGroup)this.ixV.inflate());
        }
      }
    }
  }
  
  public final void update()
  {
    if (this.ikk == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
      return;
    }
    if (this.ixU == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
      return;
    }
    if (this.ixT == null)
    {
      y.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
      return;
    }
    this.isE.aCe();
    d(c.iyY);
    this.ixU.c(this.ixT, this.ikk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g
 * JD-Core Version:    0.7.0.1
 */