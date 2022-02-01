package com.tencent.mm.plugin.appbrand.r;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends c
{
  private w qxC;
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, w paramw)
  {
    super(parama);
    AppMethodBeat.i(317603);
    this.qxC = paramw;
    Log.i("MicroMsg.AppBrandMultiTaskHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    AppMethodBeat.o(317603);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(317631);
    super.J(paramInt, paramString);
    AppMethodBeat.o(317631);
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(317613);
    cCe();
    paramBoolean = super.af(paramInt, paramBoolean);
    AppMethodBeat.o(317613);
    return paramBoolean;
  }
  
  public final boolean cBZ()
  {
    return false;
  }
  
  public final boolean cCa()
  {
    AppMethodBeat.i(317634);
    if (!this.qxC.getInitConfig().qYd)
    {
      AppMethodBeat.o(317634);
      return true;
    }
    AppMethodBeat.o(317634);
    return false;
  }
  
  public final boolean cCb()
  {
    return false;
  }
  
  public final boolean cCc()
  {
    return true;
  }
  
  public final boolean cCd()
  {
    return true;
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(317628);
    for (;;)
    {
      try
      {
        AppBrandInitConfigWC localAppBrandInitConfigWC = this.qxC.getInitConfig();
        if (localAppBrandInitConfigWC != null)
        {
          this.LCE.gkh().aaXP = localAppBrandInitConfigWC.iconUrl;
          this.LCE.gkh().nickname = localAppBrandInitConfigWC.hEy;
          if (this.qxC.qsh.eul == 1)
          {
            this.LCE.gkh().tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
            fi localfi = new fi();
            localfi.appId = localAppBrandInitConfigWC.appId;
            localfi.username = localAppBrandInitConfigWC.username;
            localfi.euz = localAppBrandInitConfigWC.eul;
            localfi.appServiceType = localAppBrandInitConfigWC.appServiceType;
            Log.i("MicroMsg.AppBrandMultiTaskHelper", "fillMultiTaskInfo username:%s,appid:%s,versionType:%d", new Object[] { localfi.username, localfi.appId, Integer.valueOf(localfi.euz) });
            this.LCE.field_data = localfi.toByteArray();
          }
        }
        else
        {
          AppMethodBeat.o(317628);
          return;
        }
        if (this.qxC.qsh.eul == 2) {
          this.LCE.gkh().tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
        } else {
          this.LCE.gkh().tag = null;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
        AppMethodBeat.o(317628);
        return;
      }
    }
  }
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(317606);
    cCe();
    super.ke(paramBoolean);
    AppMethodBeat.o(317606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b
 * JD-Core Version:    0.7.0.1
 */