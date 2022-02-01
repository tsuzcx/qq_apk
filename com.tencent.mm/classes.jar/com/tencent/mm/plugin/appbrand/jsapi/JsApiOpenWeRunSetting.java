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
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI;
import com.tencent.mm.plugin.exdevice.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting
  extends a
{
  public static final int CTRL_INDEX = 228;
  public static final String NAME = "openWeRunSetting";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(45601);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("checkSupport", true);
    }
    paramc = new OpenWeRunSetting(this, paramc, paramInt, bool);
    paramc.bej();
    AppBrandMainProcessService.a(paramc);
    AppMethodBeat.o(45601);
  }
  
  static class OpenWeRunSetting
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
    private boolean dzv;
    private int jOT;
    private m jXc;
    private c jYG;
    private boolean jZn;
    private boolean jZo;
    
    static
    {
      AppMethodBeat.i(45600);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45600);
    }
    
    public OpenWeRunSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(45593);
      this.jZn = false;
      this.dzv = false;
      e(paramParcel);
      AppMethodBeat.o(45593);
    }
    
    public OpenWeRunSetting(m paramm, c paramc, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(45592);
      this.jZn = false;
      this.dzv = false;
      ac.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
      this.jZo = paramBoolean;
      AppMethodBeat.o(45592);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45594);
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174768);
          JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this, ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).gn(ai.getContext()));
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
                  ac.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
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
      if (com.tencent.mm.kernel.g.agS().gic.giw)
      {
        local1.run();
        AppMethodBeat.o(45594);
        return;
      }
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(174769);
          local1.run();
          AppMethodBeat.o(174769);
        }
        
        public final void cf(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(45594);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45596);
      if ((this.jZo) && (!this.jZn))
      {
        this.jYG.h(this.jOT, this.jXc.e("fail device not support", null));
        bek();
        AppMethodBeat.o(45596);
        return;
      }
      if (this.dzv)
      {
        this.jYG.h(this.jOT, this.jXc.e("ok", null));
        bek();
        AppMethodBeat.o(45596);
        return;
      }
      Context localContext = this.jYG.getContext();
      if (localContext == null)
      {
        this.jYG.h(this.jOT, this.jXc.e("fail:internal error invalid android context", null));
        bek();
        AppMethodBeat.o(45596);
        return;
      }
      k localk = (k)this.jYG.ar(k.class);
      if ((localk == null) || (bs.isNullOrNil(localk.ddh)))
      {
        this.jYG.h(this.jOT, this.jXc.e("fail", null));
        bek();
        AppMethodBeat.o(45596);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("OpenWeRunSettingName", localk.ddh);
      localIntent.setClass(localContext, AppBrandOpenWeRunSettingUI.class);
      e.aA(localContext).a(localIntent, new e.a()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174770);
          if (paramAnonymousInt == -1)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("ok", null));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.bek();
            AppMethodBeat.o(174770);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("cancel", null));
            JsApiOpenWeRunSetting.OpenWeRunSetting.this.bek();
            AppMethodBeat.o(174770);
            return;
          }
          JsApiOpenWeRunSetting.OpenWeRunSetting.f(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.e(JsApiOpenWeRunSetting.OpenWeRunSetting.this).e("fail", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.bek();
          AppMethodBeat.o(174770);
        }
      });
      bek();
      AppMethodBeat.o(45596);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45597);
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.jZn = bool1;
        if (paramParcel.readByte() == 0) {
          break label60;
        }
        bool1 = true;
        label30:
        this.dzv = bool1;
        if (paramParcel.readByte() == 0) {
          break label65;
        }
      }
      label60:
      label65:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jZo = bool1;
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
      if (this.jZn)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.dzv) {
          break label62;
        }
        b1 = 1;
        label31:
        paramParcel.writeByte(b1);
        if (!this.jZo) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting
 * JD-Core Version:    0.7.0.1
 */