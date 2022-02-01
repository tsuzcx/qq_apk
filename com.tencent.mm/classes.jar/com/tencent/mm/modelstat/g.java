package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;

public final class g
{
  private final String dvm;
  private a hvW = null;
  
  public g(String paramString)
  {
    this.dvm = paramString;
  }
  
  public final a aBH()
  {
    a locala = null;
    AppMethodBeat.i(151078);
    if (this.hvW != null)
    {
      localObject1 = this.hvW;
      AppMethodBeat.o(151078);
      return localObject1;
    }
    String str = this.dvm + "mobileinfo.ini";
    Object localObject2 = new e(str);
    if (!((e)localObject2).exists())
    {
      ad.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.hvW = ((a)localObject1);
      if ((this.hvW == null) || (this.hvW.hvY)) {
        break;
      }
      ad.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.hvW;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject3 = new a(str);
      localObject1 = new a();
      ((a)localObject1).hvX = bt.l(((a)localObject3).aGC("ispCode"));
      ((a)localObject1).ispName = ((a)localObject3).getValue("ispName");
      ((a)localObject1).subType = bt.l(((a)localObject3).aGC("subType"));
      ((a)localObject1).extraInfo = ((a)localObject3).getValue("extraInfo");
      long l2 = ((e)localObject2).lastModified();
      long l1 = l2;
      if (10011 == ab.hVC)
      {
        l1 = l2;
        if (ab.hVD > 0)
        {
          l1 = bt.eGO() - ab.hVD;
          ad.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(ab.hVD), Long.valueOf(l1) });
          ab.hVD = 0;
        }
      }
      if ((l1 > 0L) && (bt.vM(l1) > 259200000L))
      {
        ad.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(bt.vM(l1)), str });
        ((a)localObject1).hvY = true;
      }
      ad.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).hvX), ((a)localObject1).ispName, ((a)localObject1).extraInfo, Boolean.valueOf(((a)localObject1).hvY) });
    }
    localObject2 = aj.getContext();
    if (localObject2 == null)
    {
      ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = locala;
    }
    while (localObject1 == null)
    {
      ad.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      localObject1 = this.hvW;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject1 = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
      if (localObject1 == null)
      {
        ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = locala;
      }
      else
      {
        localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject3 == null)
        {
          ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = locala;
        }
        else if (((NetworkInfo)localObject3).getType() == 1)
        {
          ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = locala;
        }
        else
        {
          localObject1 = new a();
          ((a)localObject1).subType = ((NetworkInfo)localObject3).getSubtype();
          ((a)localObject1).hvX = ay.getISPCode((Context)localObject2);
          ((a)localObject1).ispName = ay.getISPName((Context)localObject2);
          ((a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          ad.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).hvX), ((a)localObject1).ispName, ((a)localObject1).extraInfo });
        }
      }
    }
    this.hvW = ((a)localObject1);
    Object localObject1 = this.hvW;
    if (localObject1 == null) {
      ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.hvW;
      AppMethodBeat.o(151078);
      return localObject1;
      if (bt.isNullOrNil(str))
      {
        ad.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        locala = new a(str);
        locala.fI("ispCode", ((a)localObject1).hvX);
        locala.L("ispName", ((a)localObject1).ispName);
        locala.fI("subType", ((a)localObject1).subType);
        locala.L("extraInfo", ((a)localObject1).extraInfo);
      }
    }
  }
  
  public static final class a
  {
    public String extraInfo = "";
    public int hvX = 0;
    boolean hvY = false;
    public String ispName = "";
    public int subType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */