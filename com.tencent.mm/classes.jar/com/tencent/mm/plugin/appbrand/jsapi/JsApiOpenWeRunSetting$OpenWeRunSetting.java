package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class JsApiOpenWeRunSetting$OpenWeRunSetting
  extends MainProcessTask
{
  public static final Parcelable.Creator<OpenWeRunSetting> CREATOR = new JsApiOpenWeRunSetting.OpenWeRunSetting.3();
  private boolean cce = false;
  private i gfG;
  private int gfg;
  private boolean ggP = false;
  private boolean ggQ;
  private c ggu;
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(i parami, c paramc, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
    this.ggQ = paramBoolean;
  }
  
  private void ahQ()
  {
    if ((!this.ggQ) || (this.ggP))
    {
      this.cce = ((b)g.r(b.class)).bKY();
      if ((this.ggQ) && (this.cce)) {
        ((b)g.r(b.class)).bKX();
      }
    }
    ahI();
  }
  
  public final void Zu()
  {
    this.ggP = ((b)g.r(b.class)).ej(ae.getContext());
    if ((this.ggQ) && (!this.ggP))
    {
      ((a)g.r(a.class)).a(new JsApiOpenWeRunSetting.OpenWeRunSetting.1(this));
      return;
    }
    ahQ();
  }
  
  public final void Zv()
  {
    if ((this.ggQ) && (!this.ggP))
    {
      this.ggu.C(this.gfg, this.gfG.h("fail device not support", null));
      ahD();
      return;
    }
    if (this.cce)
    {
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
      ahD();
      return;
    }
    Context localContext = this.ggu.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      this.ggu.C(this.gfg, this.gfG.h("fail", null));
      ahD();
      return;
    }
    com.tencent.mm.plugin.appbrand.config.i locali = (com.tencent.mm.plugin.appbrand.config.i)this.ggu.D(com.tencent.mm.plugin.appbrand.config.i.class);
    if ((locali == null) || (bk.bl(locali.bJw)))
    {
      this.ggu.C(this.gfg, this.gfG.h("fail", null));
      ahD();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("OpenWeRunSettingName", locali.bJw);
    ((MMActivity)localContext).gJb = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        if (paramAnonymousInt1 != (JsApiOpenWeRunSetting.OpenWeRunSetting.this.hashCode() & 0xFFFF))
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.ahD();
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).C(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("ok", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.ahD();
          return;
        }
        if (paramAnonymousInt2 == 0)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).C(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("cancel", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.ahD();
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).C(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("fail", null));
        JsApiOpenWeRunSetting.OpenWeRunSetting.this.ahD();
      }
    };
    d.a(localContext, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", localIntent, hashCode() & 0xFFFF, false);
    ahD();
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ggP = bool1;
      if (paramParcel.readByte() == 0) {
        break label50;
      }
      bool1 = true;
      label25:
      this.cce = bool1;
      if (paramParcel.readByte() == 0) {
        break label55;
      }
    }
    label50:
    label55:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ggQ = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.ggP)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cce) {
        break label52;
      }
      b1 = 1;
      label26:
      paramParcel.writeByte(b1);
      if (!this.ggQ) {
        break label57;
      }
    }
    label52:
    label57:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */