package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;

public final class g
{
  private final String dsY;
  private g.a hWx = null;
  
  public g(String paramString)
  {
    this.dsY = paramString;
  }
  
  public final g.a aIx()
  {
    a locala = null;
    AppMethodBeat.i(151078);
    if (this.hWx != null)
    {
      localObject1 = this.hWx;
      AppMethodBeat.o(151078);
      return localObject1;
    }
    String str = this.dsY + "mobileinfo.ini";
    Object localObject2 = new e(str);
    if (!((e)localObject2).exists())
    {
      ac.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.hWx = ((g.a)localObject1);
      if ((this.hWx == null) || (this.hWx.hWz)) {
        break;
      }
      ac.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.hWx;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject3 = new a(str);
      localObject1 = new g.a();
      ((g.a)localObject1).hWy = bs.m(((a)localObject3).aLT("ispCode"));
      ((g.a)localObject1).ispName = ((a)localObject3).getValue("ispName");
      ((g.a)localObject1).subType = bs.m(((a)localObject3).aLT("subType"));
      ((g.a)localObject1).extraInfo = ((a)localObject3).getValue("extraInfo");
      long l2 = ((e)localObject2).lastModified();
      long l1 = l2;
      if (10011 == ab.ivG)
      {
        l1 = l2;
        if (ab.ivH > 0)
        {
          l1 = bs.eWj() - ab.ivH;
          ac.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(ab.ivH), Long.valueOf(l1) });
          ab.ivH = 0;
        }
      }
      if ((l1 > 0L) && (bs.Ap(l1) > 259200000L))
      {
        ac.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(bs.Ap(l1)), str });
        ((g.a)localObject1).hWz = true;
      }
      ac.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((g.a)localObject1).subType), Integer.valueOf(((g.a)localObject1).hWy), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo, Boolean.valueOf(((g.a)localObject1).hWz) });
    }
    localObject2 = ai.getContext();
    if (localObject2 == null)
    {
      ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = locala;
    }
    while (localObject1 == null)
    {
      ac.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      localObject1 = this.hWx;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject1 = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
      if (localObject1 == null)
      {
        ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = locala;
      }
      else
      {
        localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject3 == null)
        {
          ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = locala;
        }
        else if (((NetworkInfo)localObject3).getType() == 1)
        {
          ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = locala;
        }
        else
        {
          localObject1 = new g.a();
          ((g.a)localObject1).subType = ((NetworkInfo)localObject3).getSubtype();
          ((g.a)localObject1).hWy = ax.getISPCode((Context)localObject2);
          ((g.a)localObject1).ispName = ax.getISPName((Context)localObject2);
          ((g.a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          ac.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((g.a)localObject1).subType), Integer.valueOf(((g.a)localObject1).hWy), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo });
        }
      }
    }
    this.hWx = ((g.a)localObject1);
    Object localObject1 = this.hWx;
    if (localObject1 == null) {
      ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.hWx;
      AppMethodBeat.o(151078);
      return localObject1;
      if (bs.isNullOrNil(str))
      {
        ac.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        locala = new a(str);
        locala.fN("ispCode", ((g.a)localObject1).hWy);
        locala.M("ispName", ((g.a)localObject1).ispName);
        locala.fN("subType", ((g.a)localObject1).subType);
        locala.M("extraInfo", ((g.a)localObject1).extraInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */