package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.vfs.o;

public final class g
{
  private final String dataPath;
  private a joa = null;
  
  public g(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public final a bgh()
  {
    ConfigFile localConfigFile = null;
    AppMethodBeat.i(151078);
    if (this.joa != null)
    {
      localObject1 = this.joa;
      AppMethodBeat.o(151078);
      return localObject1;
    }
    String str = this.dataPath + "mobileinfo.ini";
    Object localObject2 = new o(str);
    if (!((o)localObject2).exists())
    {
      Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.joa = ((a)localObject1);
      if ((this.joa == null) || (this.joa.joc)) {
        break;
      }
      Log.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.joa;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject3 = new ConfigFile(str);
      localObject1 = new a();
      ((a)localObject1).job = Util.nullAsNil(((ConfigFile)localObject3).getIntegerValue("ispCode"));
      ((a)localObject1).ispName = ((ConfigFile)localObject3).getValue("ispName");
      ((a)localObject1).subType = Util.nullAsNil(((ConfigFile)localObject3).getIntegerValue("subType"));
      ((a)localObject1).extraInfo = ((ConfigFile)localObject3).getValue("extraInfo");
      long l2 = ((o)localObject2).lastModified();
      long l1 = l2;
      if (10011 == ac.jOC)
      {
        l1 = l2;
        if (ac.jOD > 0)
        {
          l1 = Util.nowMilliSecond() - ac.jOD;
          Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(ac.jOD), Long.valueOf(l1) });
          ac.jOD = 0;
        }
      }
      if ((l1 > 0L) && (Util.milliSecondsToNow(l1) > 259200000L))
      {
        Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), str });
        ((a)localObject1).joc = true;
      }
      Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).job), ((a)localObject1).ispName, ((a)localObject1).extraInfo, Boolean.valueOf(((a)localObject1).joc) });
    }
    localObject2 = MMApplicationContext.getContext();
    if (localObject2 == null)
    {
      Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
      localObject1 = localConfigFile;
    }
    while (localObject1 == null)
    {
      Log.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
      localObject1 = this.joa;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject1 = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
      if (localObject1 == null)
      {
        Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
        localObject1 = localConfigFile;
      }
      else
      {
        localObject3 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject3 == null)
        {
          Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
          localObject1 = localConfigFile;
        }
        else if (((NetworkInfo)localObject3).getType() == 1)
        {
          Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
          localObject1 = localConfigFile;
        }
        else
        {
          localObject1 = new a();
          ((a)localObject1).subType = ((NetworkInfo)localObject3).getSubtype();
          ((a)localObject1).job = NetStatusUtil.getISPCode((Context)localObject2);
          ((a)localObject1).ispName = NetStatusUtil.getISPName((Context)localObject2);
          ((a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).job), ((a)localObject1).ispName, ((a)localObject1).extraInfo });
        }
      }
    }
    this.joa = ((a)localObject1);
    Object localObject1 = this.joa;
    if (localObject1 == null) {
      Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.joa;
      AppMethodBeat.o(151078);
      return localObject1;
      if (Util.isNullOrNil(str))
      {
        Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        localConfigFile = new ConfigFile(str);
        localConfigFile.saveValue("ispCode", ((a)localObject1).job);
        localConfigFile.saveValue("ispName", ((a)localObject1).ispName);
        localConfigFile.saveValue("subType", ((a)localObject1).subType);
        localConfigFile.saveValue("extraInfo", ((a)localObject1).extraInfo);
      }
    }
  }
  
  public static final class a
  {
    public String extraInfo = "";
    public String ispName = "";
    public int job = 0;
    boolean joc = false;
    public int subType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */