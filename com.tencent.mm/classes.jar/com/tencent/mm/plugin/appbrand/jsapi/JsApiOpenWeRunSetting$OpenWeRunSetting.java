package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI;
import com.tencent.mm.plugin.exdevice.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

class JsApiOpenWeRunSetting$OpenWeRunSetting
  extends MainProcessTask
{
  public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
  private boolean dBH;
  private int joH;
  private m jwG;
  private boolean jyQ;
  private boolean jyR;
  private c jyl;
  
  static
  {
    AppMethodBeat.i(45600);
    CREATOR = new JsApiOpenWeRunSetting.OpenWeRunSetting.4();
    AppMethodBeat.o(45600);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(45593);
    this.jyQ = false;
    this.dBH = false;
    e(paramParcel);
    AppMethodBeat.o(45593);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(m paramm, c paramc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45592);
    this.jyQ = false;
    this.dBH = false;
    ad.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
    this.jwG = paramm;
    this.jyl = paramc;
    this.joH = paramInt;
    this.jyR = paramBoolean;
    AppMethodBeat.o(45592);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(45596);
    if ((this.jyR) && (!this.jyQ))
    {
      this.jyl.h(this.joH, this.jwG.e("fail device not support", null));
      aXn();
      AppMethodBeat.o(45596);
      return;
    }
    if (this.dBH)
    {
      this.jyl.h(this.joH, this.jwG.e("ok", null));
      aXn();
      AppMethodBeat.o(45596);
      return;
    }
    Context localContext = this.jyl.getContext();
    if (localContext == null)
    {
      this.jyl.h(this.joH, this.jwG.e("fail:internal error invalid android context", null));
      aXn();
      AppMethodBeat.o(45596);
      return;
    }
    k localk = (k)this.jyl.ar(k.class);
    if ((localk == null) || (bt.isNullOrNil(localk.dfM)))
    {
      this.jyl.h(this.joH, this.jwG.e("fail", null));
      aXn();
      AppMethodBeat.o(45596);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("OpenWeRunSettingName", localk.dfM);
    localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
    e.az(localContext).a(localIntent, new e.a()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174770);
        if (paramAnonymousInt == -1)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("ok", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.aXn();
          AppMethodBeat.o(174770);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("cancel", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.aXn();
          AppMethodBeat.o(174770);
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("fail", null));
        JsApiOpenWeRunSetting.OpenWeRunSetting.this.aXn();
        AppMethodBeat.o(174770);
      }
    });
    aXn();
    AppMethodBeat.o(45596);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(45594);
    final Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174768);
        JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).gb(aj.getContext()));
        if ((JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this)) && (!JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this)))
        {
          ((com.tencent.mm.plugin.exdevice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a()
          {
            public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(174767);
              JsApiOpenWeRunSetting.OpenWeRunSetting localOpenWeRunSetting = JsApiOpenWeRunSetting.OpenWeRunSetting.this;
              if ((paramAnonymous2Boolean1) && (paramAnonymous2Boolean2)) {}
              for (boolean bool = true;; bool = false)
              {
                JsApiOpenWeRunSetting.OpenWeRunSetting.a(localOpenWeRunSetting, bool);
                ad.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
                JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this);
                AppMethodBeat.o(174767);
                return;
              }
            }
          });
          AppMethodBeat.o(174768);
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this);
        AppMethodBeat.o(174768);
      }
    };
    if (com.tencent.mm.kernel.g.afC().gdw.gdQ)
    {
      local1.run();
      AppMethodBeat.o(45594);
      return;
    }
    com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
    {
      public final void Lk()
      {
        AppMethodBeat.i(174769);
        local1.run();
        AppMethodBeat.o(174769);
      }
      
      public final void ce(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(45594);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(45597);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jyQ = bool1;
      if (paramParcel.readByte() == 0) {
        break label60;
      }
      bool1 = true;
      label30:
      this.dBH = bool1;
      if (paramParcel.readByte() == 0) {
        break label65;
      }
    }
    label60:
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jyR = bool1;
      AppMethodBeat.o(45597);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(45598);
    if (this.jyQ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.dBH) {
        break label62;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      if (!this.jyR) {
        break label67;
      }
    }
    label62:
    label67:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(45598);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */