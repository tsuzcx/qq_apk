package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
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
  private boolean dLH;
  private int kje;
  private m kry;
  private boolean ktJ;
  private boolean ktK;
  private c ktc;
  
  static
  {
    AppMethodBeat.i(45600);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45600);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(45593);
    this.ktJ = false;
    this.dLH = false;
    e(paramParcel);
    AppMethodBeat.o(45593);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(m paramm, c paramc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45592);
    this.ktJ = false;
    this.dLH = false;
    ad.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
    this.kry = paramm;
    this.ktc = paramc;
    this.kje = paramInt;
    this.ktK = paramBoolean;
    AppMethodBeat.o(45592);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(45594);
    final Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174768);
        JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).gq(aj.getContext()));
        if ((JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this)) && (!JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this)))
        {
          ((com.tencent.mm.plugin.exdevice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a()
          {
            public final void w(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
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
    if (com.tencent.mm.kernel.g.ajD().gBM.gCg)
    {
      local1.run();
      AppMethodBeat.o(45594);
      return;
    }
    com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
    {
      public final void MP()
      {
        AppMethodBeat.i(174769);
        local1.run();
        AppMethodBeat.o(174769);
      }
      
      public final void cg(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(45594);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(45596);
    if ((this.ktK) && (!this.ktJ))
    {
      this.ktc.h(this.kje, this.kry.e("fail device not support", null));
      bhO();
      AppMethodBeat.o(45596);
      return;
    }
    if (this.dLH)
    {
      this.ktc.h(this.kje, this.kry.e("ok", null));
      bhO();
      AppMethodBeat.o(45596);
      return;
    }
    Context localContext = this.ktc.getContext();
    if (localContext == null)
    {
      this.ktc.h(this.kje, this.kry.e("fail:internal error invalid android context", null));
      bhO();
      AppMethodBeat.o(45596);
      return;
    }
    k localk = (k)this.ktc.ar(k.class);
    if ((localk == null) || (bt.isNullOrNil(localk.doD)))
    {
      this.ktc.h(this.kje, this.kry.e("fail", null));
      bhO();
      AppMethodBeat.o(45596);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("OpenWeRunSettingName", localk.doD);
    localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
    e.aA(localContext).a(localIntent, new e.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174770);
        if (paramAnonymousInt == -1)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("ok", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bhO();
          AppMethodBeat.o(174770);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("cancel", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bhO();
          AppMethodBeat.o(174770);
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("fail", null));
        JsApiOpenWeRunSetting.OpenWeRunSetting.this.bhO();
        AppMethodBeat.o(174770);
      }
    });
    bhO();
    AppMethodBeat.o(45596);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(45597);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ktJ = bool1;
      if (paramParcel.readByte() == 0) {
        break label60;
      }
      bool1 = true;
      label30:
      this.dLH = bool1;
      if (paramParcel.readByte() == 0) {
        break label65;
      }
    }
    label60:
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ktK = bool1;
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
    if (this.ktJ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.dLH) {
        break label62;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      if (!this.ktK) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */