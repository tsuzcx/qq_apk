package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.config.l;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(45601);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    new OpenWeRunSetting(this, parame, paramInt, bool).bsM();
    AppMethodBeat.o(45601);
  }
  
  static class OpenWeRunSetting
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
    private boolean fZd;
    private int okO;
    private o ovN;
    private e ovO;
    private boolean owC;
    private boolean owD;
    
    static
    {
      AppMethodBeat.i(45600);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45600);
    }
    
    public OpenWeRunSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(45593);
      this.owC = false;
      this.fZd = false;
      f(paramParcel);
      AppMethodBeat.o(45593);
    }
    
    public OpenWeRunSetting(o paramo, e parame, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(45592);
      this.owC = false;
      this.fZd = false;
      Log.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
      this.owD = paramBoolean;
      AppMethodBeat.o(45592);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45594);
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174768);
          JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)h.ae(com.tencent.mm.plugin.sport.a.b.class)).ih(MMApplicationContext.getContext()));
          if ((JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this)) && (!JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this)))
          {
            ((com.tencent.mm.plugin.exdevice.a.b)h.ae(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a()
            {
              public final void z(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
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
      if (h.aHH().kdc.kdw)
      {
        local1.run();
        AppMethodBeat.o(45594);
        return;
      }
      h.aHH().a(new g()
      {
        public final void abB()
        {
          AppMethodBeat.i(174769);
          local1.run();
          AppMethodBeat.o(174769);
        }
        
        public final void dn(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(45594);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45596);
      if ((this.owD) && (!this.owC))
      {
        this.ovO.j(this.okO, this.ovN.h("fail device not support", null));
        bPk();
        AppMethodBeat.o(45596);
        return;
      }
      if (this.fZd)
      {
        this.ovO.j(this.okO, this.ovN.h("ok", null));
        bPk();
        AppMethodBeat.o(45596);
        return;
      }
      Context localContext = this.ovO.getContext();
      if (localContext == null)
      {
        this.ovO.j(this.okO, this.ovN.h("fail:internal error invalid android context", null));
        bPk();
        AppMethodBeat.o(45596);
        return;
      }
      l locall = (l)this.ovO.au(l.class);
      if ((locall == null) || (Util.isNullOrNil(locall.fzM)))
      {
        this.ovO.j(this.okO, this.ovN.h("fail", null));
        bPk();
        AppMethodBeat.o(45596);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("OpenWeRunSettingName", locall.fzM);
      localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
      f.aI(localContext).a(localIntent, new f.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174770);
          if (paramAnonymousInt == -1)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("ok", null));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.bPk();
            AppMethodBeat.o(174770);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("cancel", null));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.bPk();
            AppMethodBeat.o(174770);
            return;
          }
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h("fail", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bPk();
          AppMethodBeat.o(174770);
        }
      });
      bPk();
      AppMethodBeat.o(45596);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45597);
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.owC = bool1;
        if (paramParcel.readByte() == 0) {
          break label60;
        }
        bool1 = true;
        label30:
        this.fZd = bool1;
        if (paramParcel.readByte() == 0) {
          break label65;
        }
      }
      label60:
      label65:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.owD = bool1;
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
      if (this.owC)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.fZd) {
          break label62;
        }
        b1 = 1;
        label31:
        paramParcel.writeByte(b1);
        if (!this.owD) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */