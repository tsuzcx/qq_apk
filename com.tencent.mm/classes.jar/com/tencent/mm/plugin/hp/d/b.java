package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.dag;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String DNA;
  public String DNB;
  public HashMap<Integer, LinkedList<dag>> DNw;
  public String DNx;
  public String DNy;
  public String DNz;
  public String clientVersion;
  public final String coY;
  public final int fileSize;
  public final Integer smQ;
  public Integer smR;
  public final Integer smS;
  public final String smT;
  public final String smU;
  public int versionCode;
  
  public b(dhk paramdhk)
  {
    AppMethodBeat.i(117514);
    this.DNw = new HashMap();
    if (paramdhk == null)
    {
      this.smQ = Integer.valueOf(1);
      this.smT = "";
      this.smU = "";
      this.smR = Integer.valueOf(-1);
      this.smS = Integer.valueOf(-1);
      this.coY = "";
      this.fileSize = 0;
      this.DNx = "";
      this.DNy = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.DNz = "";
      this.DNA = "";
      this.DNB = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramdhk.TOz != null)
    {
      this.smU = paramdhk.TOz.MD5;
      this.smT = paramdhk.TOz.Url;
    }
    Object localObject;
    for (this.fileSize = paramdhk.TOz.HlG;; this.fileSize = 0)
    {
      this.smQ = Integer.valueOf(paramdhk.state);
      this.smS = Integer.valueOf(paramdhk.TOy);
      if ((paramdhk.TOw == null) || (paramdhk.TOw.isEmpty())) {
        break;
      }
      int j = paramdhk.TOw.size();
      int i = 0;
      while (i < j)
      {
        localObject = (dhj)paramdhk.TOw.get(i);
        if ((((dhj)localObject).TOv != null) && (!((dhj)localObject).TOv.isEmpty())) {
          this.DNw.put(Integer.valueOf(((dhj)localObject).type), ((dhj)localObject).TOv);
        }
        i += 1;
      }
      this.smU = "";
      this.smT = "";
    }
    this.smR = Integer.valueOf(paramdhk.TOx);
    this.coY = paramdhk.GIL;
    if ((paramdhk.TOB != null) && (!paramdhk.TOB.isEmpty()))
    {
      paramdhk = paramdhk.TOB.iterator();
      while (paramdhk.hasNext())
      {
        localObject = (dhi)paramdhk.next();
        if ((localObject != null) && (!Util.isNullOrNil(((dhi)localObject).key))) {
          if (((dhi)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.DNx = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.DNy = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((dhi)localObject).value;
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.DNz = c.aLS(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.DNA = c.aLS(((dhi)localObject).value);
          } else if (((dhi)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.DNB = ((dhi)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.DNx = "";
    this.DNy = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.DNz = "";
    this.DNA = "";
    this.DNB = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<dag>> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(117518);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(117518);
      return "";
    }
    Object localObject1 = "";
    LinkedList localLinkedList = (LinkedList)paramHashMap.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localLinkedList != null)
    {
      localObject2 = localObject1;
      if (!localLinkedList.isEmpty())
      {
        int i = localLinkedList.size();
        paramInt = 0;
        paramHashMap = (HashMap<Integer, LinkedList<dag>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (dag)localLinkedList.get(paramInt);
          if (((dag)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((dag)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((dag)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        paramHashMap = new String(Base64.decode(((dag)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean eIp()
  {
    AppMethodBeat.i(117515);
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.smS.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.smS.intValue() == 3)
    {
      boolean bool = NetStatusUtil.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean eIq()
  {
    AppMethodBeat.i(117516);
    if ((this.smQ.intValue() == 2) || (this.smQ.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean eIr()
  {
    AppMethodBeat.i(117517);
    if ((this.DNw != null) && (!this.DNw.isEmpty()) && (this.DNw.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String eIs()
  {
    AppMethodBeat.i(117519);
    if (eIr())
    {
      String str = a(this.DNw, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean eIt()
  {
    AppMethodBeat.i(195958);
    if ((this.smQ.intValue() > 4) || (this.smQ.intValue() <= 0))
    {
      Log.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { this.smQ, Integer.valueOf(1), Integer.valueOf(4) });
      h.IzE.idkeyStat(614L, 24L, 1L, false);
      AppMethodBeat.o(195958);
      return false;
    }
    if (eIq())
    {
      if (TextUtils.isEmpty(this.coY))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
        h.IzE.idkeyStat(614L, 25L, 1L, false);
        AppMethodBeat.o(195958);
        return false;
      }
      if (TextUtils.isEmpty(this.smT))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
        h.IzE.idkeyStat(614L, 26L, 1L, false);
        AppMethodBeat.o(195958);
        return false;
      }
      if (TextUtils.isEmpty(this.smU))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
        h.IzE.idkeyStat(614L, 27L, 1L, false);
        AppMethodBeat.o(195958);
        return false;
      }
    }
    AppMethodBeat.o(195958);
    return true;
  }
  
  public final boolean eIu()
  {
    AppMethodBeat.i(195959);
    if (this.smQ.intValue() == 3)
    {
      AppMethodBeat.o(195959);
      return true;
    }
    AppMethodBeat.o(195959);
    return false;
  }
  
  public final boolean eIv()
  {
    AppMethodBeat.i(117521);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      Log.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, BuildInfo.CLIENT_VERSION });
      if (!Util.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(BuildInfo.CLIENT_VERSION).intValue();
          if ((i & 0xFFFFFF00) < (j & 0xFFFFFF00))
          {
            AppMethodBeat.o(117521);
            return true;
            str = this.clientVersion;
          }
          else
          {
            AppMethodBeat.o(117521);
            return false;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(117521);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117520);
    String str = "responseState:" + this.smQ + "\ncdnUrl:" + this.smT + "\nfileMd5:" + this.smU + "\npackageType:" + this.smR + "\nnetworkType:" + this.smS + "\npatchId:" + this.coY;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */