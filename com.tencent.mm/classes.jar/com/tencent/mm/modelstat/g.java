package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class g
{
  private final String dataPath;
  private g.a eDw = null;
  
  public g(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public final g.a Rt()
  {
    a locala = null;
    if (this.eDw != null) {
      return this.eDw;
    }
    String str = this.dataPath + "mobileinfo.ini";
    Object localObject2 = new File(str);
    if (!((File)localObject2).exists())
    {
      y.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.eDw = ((g.a)localObject1);
      if ((this.eDw == null) || (this.eDw.eDy)) {
        break;
      }
      y.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      return this.eDw;
      localObject3 = new a(str);
      localObject1 = new g.a();
      ((g.a)localObject1).eDx = bk.g(((a)localObject3).aal("ispCode"));
      ((g.a)localObject1).ispName = ((a)localObject3).getValue("ispName");
      ((g.a)localObject1).brC = bk.g(((a)localObject3).aal("subType"));
      ((g.a)localObject1).extraInfo = ((a)localObject3).getValue("extraInfo");
      long l2 = ((File)localObject2).lastModified();
      long l1 = l2;
      if (10011 == com.tencent.mm.platformtools.ae.eSP)
      {
        l1 = l2;
        if (com.tencent.mm.platformtools.ae.eSQ > 0)
        {
          l1 = bk.UY() - com.tencent.mm.platformtools.ae.eSQ;
          y.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ), Long.valueOf(l1) });
          com.tencent.mm.platformtools.ae.eSQ = 0;
        }
      }
      if ((l1 > 0L) && (bk.co(l1) > 259200000L))
      {
        y.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(bk.co(l1)), str });
        ((g.a)localObject1).eDy = true;
      }
      y.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((g.a)localObject1).brC), Integer.valueOf(((g.a)localObject1).eDx), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo, Boolean.valueOf(((g.a)localObject1).eDy) });
    }
    localObject2 = com.tencent.mm.sdk.platformtools.ae.getContext();
    if (localObject2 == null)
    {
      y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = locala;
    }
    while (localObject1 == null)
    {
      y.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      return this.eDw;
      localObject1 = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
      if (localObject1 == null)
      {
        y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = locala;
      }
      else
      {
        localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject3 == null)
        {
          y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = locala;
        }
        else if (((NetworkInfo)localObject3).getType() == 1)
        {
          y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = locala;
        }
        else
        {
          localObject1 = new g.a();
          ((g.a)localObject1).brC = ((NetworkInfo)localObject3).getSubtype();
          ((g.a)localObject1).eDx = aq.getISPCode((Context)localObject2);
          ((g.a)localObject1).ispName = aq.getISPName((Context)localObject2);
          ((g.a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          y.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((g.a)localObject1).brC), Integer.valueOf(((g.a)localObject1).eDx), ((g.a)localObject1).ispName, ((g.a)localObject1).extraInfo });
        }
      }
    }
    this.eDw = ((g.a)localObject1);
    Object localObject1 = this.eDw;
    if (localObject1 == null) {
      y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      return this.eDw;
      if (bk.bl(str))
      {
        y.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        locala = new a(str);
        locala.dq("ispCode", ((g.a)localObject1).eDx);
        locala.gi("ispName", ((g.a)localObject1).ispName);
        locala.dq("subType", ((g.a)localObject1).brC);
        locala.gi("extraInfo", ((g.a)localObject1).extraInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */