package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.vfs.u;

public final class f
{
  private final String dataPath;
  private a oWi = null;
  
  public f(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public final a bNc()
  {
    ConfigFile localConfigFile = null;
    AppMethodBeat.i(151078);
    if (this.oWi != null)
    {
      localObject1 = this.oWi;
      AppMethodBeat.o(151078);
      return localObject1;
    }
    String str = this.dataPath + "mobileinfo.ini";
    Object localObject2 = new u(str);
    if (!((u)localObject2).jKS())
    {
      Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[] { str });
      localObject1 = null;
    }
    Object localObject3;
    for (;;)
    {
      this.oWi = ((a)localObject1);
      if ((this.oWi == null) || (this.oWi.oWk)) {
        break;
      }
      Log.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
      localObject1 = this.oWi;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject3 = new ConfigFile(str);
      localObject1 = new a();
      ((a)localObject1).oWj = Util.nullAsNil(((ConfigFile)localObject3).getIntegerValue("ispCode"));
      ((a)localObject1).ispName = ((ConfigFile)localObject3).getValue("ispName");
      ((a)localObject1).subType = Util.nullAsNil(((ConfigFile)localObject3).getIntegerValue("subType"));
      ((a)localObject1).extraInfo = ((ConfigFile)localObject3).getValue("extraInfo");
      long l2 = ((u)localObject2).lastModified();
      long l1 = l2;
      if (10011 == z.pCm)
      {
        l1 = l2;
        if (z.pCn > 0)
        {
          l1 = Util.nowMilliSecond() - z.pCn;
          Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[] { Integer.valueOf(z.pCn), Long.valueOf(l1) });
          z.pCn = 0;
        }
      }
      if ((l1 > 0L) && (Util.milliSecondsToNow(l1) > 259200000L))
      {
        Log.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), str });
        ((a)localObject1).oWk = true;
      }
      Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).oWj), ((a)localObject1).ispName, ((a)localObject1).extraInfo, Boolean.valueOf(((a)localObject1).oWk) });
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
      localObject1 = this.oWi;
      AppMethodBeat.o(151078);
      return localObject1;
      localObject1 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
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
          ((a)localObject1).oWj = NetStatusUtil.getISPCode((Context)localObject2);
          ((a)localObject1).ispName = NetStatusUtil.getISPName((Context)localObject2);
          ((a)localObject1).extraInfo = ((NetworkInfo)localObject3).getExtraInfo();
          Log.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[] { Integer.valueOf(((a)localObject1).subType), Integer.valueOf(((a)localObject1).oWj), ((a)localObject1).ispName, ((a)localObject1).extraInfo });
        }
      }
    }
    this.oWi = ((a)localObject1);
    Object localObject1 = this.oWi;
    if (localObject1 == null) {
      Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
    }
    for (;;)
    {
      localObject1 = this.oWi;
      AppMethodBeat.o(151078);
      return localObject1;
      if (Util.isNullOrNil(str))
      {
        Log.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
      }
      else
      {
        localConfigFile = new ConfigFile(str);
        localConfigFile.saveValue("ispCode", ((a)localObject1).oWj);
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
    public int oWj = 0;
    boolean oWk = false;
    public int subType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */