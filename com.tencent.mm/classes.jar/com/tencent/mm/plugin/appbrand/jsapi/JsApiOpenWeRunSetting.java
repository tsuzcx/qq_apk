package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI;
import com.tencent.mm.plugin.exdevice.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting
  extends c
{
  public static final int CTRL_INDEX = 228;
  public static final String NAME = "openWeRunSetting";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(45601);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    new OpenWeRunSetting(this, paramf, paramInt, bool).bQt();
    AppMethodBeat.o(45601);
  }
  
  static class OpenWeRunSetting
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
    private boolean hAJ;
    private boolean rAa;
    private boolean rAb;
    private int ror;
    private p rzh;
    private f rzi;
    
    static
    {
      AppMethodBeat.i(45600);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45600);
    }
    
    public OpenWeRunSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(45593);
      this.rAa = false;
      this.hAJ = false;
      h(paramParcel);
      AppMethodBeat.o(45593);
    }
    
    public OpenWeRunSetting(p paramp, f paramf, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(45592);
      this.rAa = false;
      this.hAJ = false;
      Log.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
      this.rAb = paramBoolean;
      AppMethodBeat.o(45592);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45594);
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174768);
          JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)h.ax(com.tencent.mm.plugin.sport.a.b.class)).jX(MMApplicationContext.getContext()));
          if ((JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this)) && (!JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this)))
          {
            ((com.tencent.mm.plugin.exdevice.a.b)h.ax(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a()
            {
              public final void D(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
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
      if (h.baF().mDl.mDG)
      {
        local1.run();
        AppMethodBeat.o(45594);
        return;
      }
      h.baF().a(new g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(174769);
          local1.run();
          AppMethodBeat.o(174769);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(45594);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45596);
      if ((this.rAb) && (!this.rAa))
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail device not support"));
        cpx();
        AppMethodBeat.o(45596);
        return;
      }
      if (this.hAJ)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("ok"));
        cpx();
        AppMethodBeat.o(45596);
        return;
      }
      Context localContext = this.rzi.getContext();
      if (localContext == null)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail:internal error invalid android context"));
        cpx();
        AppMethodBeat.o(45596);
        return;
      }
      n localn = (n)this.rzi.aN(n.class);
      if ((localn == null) || (Util.isNullOrNil(localn.hEy)))
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail"));
        cpx();
        AppMethodBeat.o(45596);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("OpenWeRunSettingName", localn.hEy);
      localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
      e.bt(localContext).a(localIntent, new e.b()
      {
        public final void onResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174770);
          if (paramAnonymousInt == -1)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).callback(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).ZP("ok"));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.cpx();
            AppMethodBeat.o(174770);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).callback(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).ZP("cancel"));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.cpx();
            AppMethodBeat.o(174770);
            return;
          }
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).callback(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).ZP("fail"));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.cpx();
          AppMethodBeat.o(174770);
        }
      });
      cpx();
      AppMethodBeat.o(45596);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45597);
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.rAa = bool1;
        if (paramParcel.readByte() == 0) {
          break label60;
        }
        bool1 = true;
        label30:
        this.hAJ = bool1;
        if (paramParcel.readByte() == 0) {
          break label65;
        }
      }
      label60:
      label65:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rAb = bool1;
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
      if (this.rAa)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.hAJ) {
          break label62;
        }
        b1 = 1;
        label31:
        paramParcel.writeByte(b1);
        if (!this.rAb) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */