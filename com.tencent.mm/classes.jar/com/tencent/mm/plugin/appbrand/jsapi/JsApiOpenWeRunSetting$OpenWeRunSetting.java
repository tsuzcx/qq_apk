package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class JsApiOpenWeRunSetting$OpenWeRunSetting
  extends MainProcessTask
{
  public static final Parcelable.Creator<OpenWeRunSetting> CREATOR;
  private boolean cKK;
  private int hry;
  private m hxs;
  private c hyO;
  private boolean hzp;
  private boolean hzq;
  
  static
  {
    AppMethodBeat.i(130539);
    CREATOR = new JsApiOpenWeRunSetting.OpenWeRunSetting.3();
    AppMethodBeat.o(130539);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(130532);
    this.hzp = false;
    this.cKK = false;
    f(paramParcel);
    AppMethodBeat.o(130532);
  }
  
  public JsApiOpenWeRunSetting$OpenWeRunSetting(m paramm, c paramc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(130531);
    this.hzp = false;
    this.cKK = false;
    ab.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt;
    this.hzq = paramBoolean;
    AppMethodBeat.o(130531);
  }
  
  private void aBA()
  {
    AppMethodBeat.i(130534);
    if ((!this.hzq) || (this.hzp))
    {
      this.cKK = ((b)g.E(b.class)).cyu();
      if ((this.hzq) && (this.cKK)) {
        ((b)g.E(b.class)).cyt();
      }
    }
    aBp();
    AppMethodBeat.o(130534);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130533);
    this.hzp = ((b)g.E(b.class)).fa(ah.getContext());
    if ((this.hzq) && (!this.hzp))
    {
      ((a)g.E(a.class)).a(new a.a()
      {
        public final void q(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(130528);
          JsApiOpenWeRunSetting.OpenWeRunSetting localOpenWeRunSetting = JsApiOpenWeRunSetting.OpenWeRunSetting.this;
          if ((paramAnonymousBoolean1) && (paramAnonymousBoolean2)) {}
          for (boolean bool = true;; bool = false)
          {
            JsApiOpenWeRunSetting.OpenWeRunSetting.a(localOpenWeRunSetting, bool);
            ab.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
            JsApiOpenWeRunSetting.OpenWeRunSetting.a(JsApiOpenWeRunSetting.OpenWeRunSetting.this);
            AppMethodBeat.o(130528);
            return;
          }
        }
      });
      AppMethodBeat.o(130533);
      return;
    }
    aBA();
    AppMethodBeat.o(130533);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130535);
    if ((this.hzq) && (!this.hzp))
    {
      this.hyO.h(this.hry, this.hxs.j("fail device not support", null));
      aBk();
      AppMethodBeat.o(130535);
      return;
    }
    if (this.cKK)
    {
      this.hyO.h(this.hry, this.hxs.j("ok", null));
      aBk();
      AppMethodBeat.o(130535);
      return;
    }
    Context localContext = this.hyO.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      this.hyO.h(this.hry, this.hxs.j("fail", null));
      aBk();
      AppMethodBeat.o(130535);
      return;
    }
    h localh = (h)this.hyO.U(h.class);
    if ((localh == null) || (bo.isNullOrNil(localh.cqQ)))
    {
      this.hyO.h(this.hry, this.hxs.j("fail", null));
      aBk();
      AppMethodBeat.o(130535);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("OpenWeRunSettingName", localh.cqQ);
    ((MMActivity)localContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(130529);
        if (paramAnonymousInt1 != (JsApiOpenWeRunSetting.OpenWeRunSetting.this.hashCode() & 0xFFFF))
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.aBk();
          AppMethodBeat.o(130529);
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j("ok", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.aBk();
          AppMethodBeat.o(130529);
          return;
        }
        if (paramAnonymousInt2 == 0)
        {
          JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j("cancel", null));
          JsApiOpenWeRunSetting.OpenWeRunSetting.this.aBk();
          AppMethodBeat.o(130529);
          return;
        }
        JsApiOpenWeRunSetting.OpenWeRunSetting.d(JsApiOpenWeRunSetting.OpenWeRunSetting.this).h(JsApiOpenWeRunSetting.OpenWeRunSetting.b(JsApiOpenWeRunSetting.OpenWeRunSetting.this), JsApiOpenWeRunSetting.OpenWeRunSetting.c(JsApiOpenWeRunSetting.OpenWeRunSetting.this).j("fail", null));
        JsApiOpenWeRunSetting.OpenWeRunSetting.this.aBk();
        AppMethodBeat.o(130529);
      }
    });
    d.a(localContext, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", localIntent, hashCode() & 0xFFFF, false);
    aBk();
    AppMethodBeat.o(130535);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(130536);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hzp = bool1;
      if (paramParcel.readByte() == 0) {
        break label60;
      }
      bool1 = true;
      label30:
      this.cKK = bool1;
      if (paramParcel.readByte() == 0) {
        break label65;
      }
    }
    label60:
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hzq = bool1;
      AppMethodBeat.o(130536);
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
    AppMethodBeat.i(130537);
    if (this.hzp)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.cKK) {
        break label62;
      }
      b1 = 1;
      label31:
      paramParcel.writeByte(b1);
      if (!this.hzq) {
        break label67;
      }
    }
    label62:
    label67:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(130537);
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