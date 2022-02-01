package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI;
import com.tencent.mm.plugin.exdevice.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

class JsApiOpenWeRunSetting$OpenWeRunSetting
  extends MainProcessTask
{
  public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
  private boolean eeO;
  private p lAw;
  private f lAx;
  private boolean lBm;
  private boolean lBn;
  private int lqe;
  
  static
  {
    AppMethodBeat.i(45600);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45600);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(45593);
    this.lBm = false;
    this.eeO = false;
    f(paramParcel);
    AppMethodBeat.o(45593);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(p paramp, f paramf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45592);
    this.lBm = false;
    this.eeO = false;
    Log.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
    this.lAw = paramp;
    this.lAx = paramf;
    this.lqe = paramInt;
    this.lBn = paramBoolean;
    AppMethodBeat.o(45592);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(45594);
    final Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174768);
        JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sport.a.b.class)).hg(MMApplicationContext.getContext()));
        if ((JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this)) && (!JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this)))
        {
          ((com.tencent.mm.plugin.exdevice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a()
          {
            public final void w(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(174767);
              JsApiOpenWeRunSetting.OpenWeRunSetting localOpenWeRunSetting = JsApiOpenWeRunSetting.OpenWeRunSetting.this;
              if ((paramAnonymous2Boolean1) && (paramAnonymous2Boolean2)) {}
              for (boolean bool = true;; bool = false)
              {
                JsApiOpenWeRunSetting.OpenWeRunSetting.a(localOpenWeRunSetting, bool);
                Log.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
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
    if (com.tencent.mm.kernel.g.aAi().hrh.hrB)
    {
      local1.run();
      AppMethodBeat.o(45594);
      return;
    }
    com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
    {
      public final void WY()
      {
        AppMethodBeat.i(174769);
        local1.run();
        AppMethodBeat.o(174769);
      }
      
      public final void cQ(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(45594);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(45596);
    if ((this.lBn) && (!this.lBm))
    {
      this.lAx.i(this.lqe, this.lAw.h("fail device not support", null));
      bDK();
      AppMethodBeat.o(45596);
      return;
    }
    if (this.eeO)
    {
      this.lAx.i(this.lqe, this.lAw.h("ok", null));
      bDK();
      AppMethodBeat.o(45596);
      return;
    }
    Context localContext = this.lAx.getContext();
    if (localContext == null)
    {
      this.lAx.i(this.lqe, this.lAw.h("fail:internal error invalid android context", null));
      bDK();
      AppMethodBeat.o(45596);
      return;
    }
    l locall = (l)this.lAx.av(l.class);
    if ((locall == null) || (Util.isNullOrNil(locall.brandName)))
    {
      this.lAx.i(this.lqe, this.lAw.h("fail", null));
      bDK();
      AppMethodBeat.o(45596);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("OpenWeRunSettingName", locall.brandName);
    localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
    com.tencent.luggage.h.f.aK(localContext).a(localIntent, new f.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174770);
        if (paramAnonymousInt == -1)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).i(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("ok", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bDK();
          AppMethodBeat.o(174770);
          return;
        }
        if (paramAnonymousInt == 0)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).i(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("cancel", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bDK();
          AppMethodBeat.o(174770);
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).i(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("fail", null));
        JsApiOpenWeRunSetting.OpenWeRunSetting.this.bDK();
        AppMethodBeat.o(174770);
      }
    });
    bDK();
    AppMethodBeat.o(45596);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(45597);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.lBm = bool1;
      if (paramParcel.readByte() == 0) {
        break label60;
      }
      bool1 = true;
      label30:
      this.eeO = bool1;
      if (paramParcel.readByte() == 0) {
        break label65;
      }
    }
    label60:
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lBn = bool1;
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
    if (this.lBm)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.eeO) {
        break label62;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      if (!this.lBn) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */