package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class g
{
  private final String dataPath;
  private g.a fTn = null;
  
  public g(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public final g.a akC()
  {
    a locala = null;
    AppMethodBeat.i(78734);
    if (this.fTn != null)
    {
      localObject1 = this.fTn;
      AppMethodBeat.o(78734);
      return localObject1;
    }
    String str = this.dataPath + "mobileinfo.ini";
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists())
    {
      ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.fTn = ((g.a)localObject1);
      if ((this.fTn == null) || (this.fTn.fTp)) {
        break;
      }
      ab.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.fTn;
      AppMethodBeat.o(78734);
      return localObject1;
      localObject3 = new a(str);
      localObject1 = new g.a();
      ((g.a)localObject1).fTo = bo.g(((a)localObject3).aqp("ispCode"));
      ((g.a)localObject1).ispName = ((a)localObject3).getValue("ispName");
      ((g.a)localObject1).subType = bo.g(((a)localObject3).aqp("subType"));
      ((g.a)localObject1).extraInfo = ((a)localObject3).getValue("extraInfo");
      long l2 = ((File)localObject2).lastModified();
      long l1 = l2;
      if (10011 == ae.gkK)
      {
        l1 = l2;
        if (ae.gkL > 0)
        {
          l1 = bo.aoy() - ae.gkL;
          ab.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(ae.gkL), Long.valueOf(l1) });
          ae.gkL = 0;
        }
      }
      if ((l1 > 0L) && (bo.hl(l1) > 259200000L))
      {
        ab.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(bo.hl(l1)), str });
        ((g.a)localObject1).fTp = true;
      }
      ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((g.a)localObject1).subType), Integer.valueOf(((g.a)localObject1).fTo), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo, Boolean.valueOf(((g.a)localObject1).fTp) });
    }
    localObject2 = ah.getContext();
    if (localObject2 == null)
    {
      ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = locala;
    }
    while (localObject1 == null)
    {
      ab.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      localObject1 = this.fTn;
      AppMethodBeat.o(78734);
      return localObject1;
      localObject1 = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
      if (localObject1 == null)
      {
        ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = locala;
      }
      else
      {
        localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject3 == null)
        {
          ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = locala;
        }
        else if (((NetworkInfo)localObject3).getType() == 1)
        {
          ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = locala;
        }
        else
        {
          localObject1 = new g.a();
          ((g.a)localObject1).subType = ((NetworkInfo)localObject3).getSubtype();
          ((g.a)localObject1).fTo = at.getISPCode((Context)localObject2);
          ((g.a)localObject1).ispName = at.getISPName((Context)localObject2);
          ((g.a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((g.a)localObject1).subType), Integer.valueOf(((g.a)localObject1).fTo), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo });
        }
      }
    }
    this.fTn = ((g.a)localObject1);
    Object localObject1 = this.fTn;
    if (localObject1 == null) {
      ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.fTn;
      AppMethodBeat.o(78734);
      return localObject1;
      if (bo.isNullOrNil(str))
      {
        ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        locala = new a(str);
        locala.ex("ispCode", ((g.a)localObject1).fTo);
        locala.ij("ispName", ((g.a)localObject1).ispName);
        locala.ex("subType", ((g.a)localObject1).subType);
        locala.ij("extraInfo", ((g.a)localObject1).extraInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */