package com.tencent.mm.plugin.appbrand.q;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends c
{
  private t nAH;
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, t paramt)
  {
    super(parama);
    AppMethodBeat.i(281037);
    this.nAH = paramt;
    Log.i("MicroMsg.AppBrandMultiTaskHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    AppMethodBeat.o(281037);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(281043);
    super.I(paramInt, paramString);
    AppMethodBeat.o(281043);
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(281039);
    cbL();
    paramBoolean = super.Q(paramInt, paramBoolean);
    AppMethodBeat.o(281039);
    return paramBoolean;
  }
  
  public final boolean cbG()
  {
    return false;
  }
  
  public final boolean cbH()
  {
    AppMethodBeat.i(281044);
    if (!this.nAH.bDy().nYb)
    {
      AppMethodBeat.o(281044);
      return true;
    }
    AppMethodBeat.o(281044);
    return false;
  }
  
  public final boolean cbI()
  {
    return false;
  }
  
  public final boolean cbJ()
  {
    return true;
  }
  
  public final boolean cbK()
  {
    return true;
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(281041);
    for (;;)
    {
      try
      {
        AppBrandInitConfigWC localAppBrandInitConfigWC = this.nAH.bDy();
        if (localAppBrandInitConfigWC != null)
        {
          this.FHd.fbc().TIg = localAppBrandInitConfigWC.iconUrl;
          this.FHd.fbc().nickname = localAppBrandInitConfigWC.fzM;
          if (this.nAH.ntz.cBI == 1)
          {
            this.FHd.fbc().tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
            eo localeo = new eo();
            localeo.appId = localAppBrandInitConfigWC.appId;
            localeo.username = localAppBrandInitConfigWC.username;
            localeo.cBU = localAppBrandInitConfigWC.cBI;
            localeo.cwR = localAppBrandInitConfigWC.cwR;
            Log.i("MicroMsg.AppBrandMultiTaskHelper", "fillMultiTaskInfo username:%s,appid:%s,versionType:%d", new Object[] { localeo.username, localeo.appId, Integer.valueOf(localeo.cBU) });
            this.FHd.field_data = localeo.toByteArray();
          }
        }
        else
        {
          AppMethodBeat.o(281041);
          return;
        }
        if (this.nAH.ntz.cBI == 2) {
          this.FHd.fbc().tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
        } else {
          this.FHd.fbc().tag = null;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
        AppMethodBeat.o(281041);
        return;
      }
    }
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(281038);
    cbL();
    super.iW(paramBoolean);
    AppMethodBeat.o(281038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b
 * JD-Core Version:    0.7.0.1
 */