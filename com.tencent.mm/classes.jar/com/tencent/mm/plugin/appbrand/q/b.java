package com.tencent.mm.plugin.appbrand.q;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends c
{
  private q kGW;
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, q paramq)
  {
    super(parama);
    AppMethodBeat.i(227203);
    this.kGW = paramq;
    Log.i("MicroMsg.AppBrandMultiTaskHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    AppMethodBeat.o(227203);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(227207);
    super.G(paramInt, paramString);
    AppMethodBeat.o(227207);
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227205);
    bPu();
    paramBoolean = super.O(paramInt, paramBoolean);
    AppMethodBeat.o(227205);
    return paramBoolean;
  }
  
  public final boolean bPp()
  {
    return false;
  }
  
  public final boolean bPq()
  {
    AppMethodBeat.i(227208);
    if (!this.kGW.bsC().ldN)
    {
      AppMethodBeat.o(227208);
      return true;
    }
    AppMethodBeat.o(227208);
    return false;
  }
  
  public final boolean bPr()
  {
    return false;
  }
  
  public final boolean bPs()
  {
    return true;
  }
  
  public final boolean bPt()
  {
    return true;
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(227206);
    for (;;)
    {
      try
      {
        AppBrandInitConfigWC localAppBrandInitConfigWC = this.kGW.bsC();
        if (localAppBrandInitConfigWC != null)
        {
          this.Abp.erh().MwR = localAppBrandInitConfigWC.iconUrl;
          this.Abp.erh().nickname = localAppBrandInitConfigWC.brandName;
          if (this.kGW.kAq.eix == 1)
          {
            this.Abp.erh().tag = MMApplicationContext.getContext().getString(2131755352);
            er localer = new er();
            localer.appId = localAppBrandInitConfigWC.appId;
            localer.username = localAppBrandInitConfigWC.username;
            localer.iOo = localAppBrandInitConfigWC.eix;
            localer.cyo = localAppBrandInitConfigWC.cyo;
            Log.i("MicroMsg.AppBrandMultiTaskHelper", "fillMultiTaskInfo username:%s,appid:%s,versionType:%d", new Object[] { localer.username, localer.appId, Integer.valueOf(localer.iOo) });
            this.Abp.field_data = localer.toByteArray();
          }
        }
        else
        {
          AppMethodBeat.o(227206);
          return;
        }
        if (this.kGW.kAq.eix == 2) {
          this.Abp.erh().tag = MMApplicationContext.getContext().getString(2131755351);
        } else {
          this.Abp.erh().tag = null;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
        AppMethodBeat.o(227206);
        return;
      }
    }
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(227204);
    bPu();
    super.ic(paramBoolean);
    AppMethodBeat.o(227204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b
 * JD-Core Version:    0.7.0.1
 */