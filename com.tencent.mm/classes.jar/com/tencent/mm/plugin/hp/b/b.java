package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.dro;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public class b
{
  public HashMap<Integer, LinkedList<dro>> JEK;
  public String JEL;
  public String JEM;
  public String JEN;
  public String JEO;
  public String JEP;
  public String clientVersion;
  public final String egJ;
  public final int fileSize;
  public String mOI;
  public int versionCode;
  public final Integer vyP;
  public Integer vyQ;
  public final Integer vyR;
  public final String vyS;
  
  public b(dzt paramdzt)
  {
    AppMethodBeat.i(117514);
    this.JEK = new HashMap();
    if (paramdzt == null)
    {
      this.vyP = Integer.valueOf(1);
      this.mOI = "";
      this.vyS = "";
      this.vyQ = Integer.valueOf(-1);
      this.vyR = Integer.valueOf(-1);
      this.egJ = "";
      this.fileSize = 0;
      this.JEL = "";
      this.JEM = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.JEN = "";
      this.JEO = "";
      this.JEP = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramdzt.abeV != null)
    {
      this.vyS = paramdzt.abeV.MD5;
      this.mOI = paramdzt.abeV.Url;
    }
    Object localObject;
    for (this.fileSize = paramdzt.abeV.Nju;; this.fileSize = 0)
    {
      this.vyP = Integer.valueOf(paramdzt.state);
      this.vyR = Integer.valueOf(paramdzt.abeU);
      if ((paramdzt.abeS == null) || (paramdzt.abeS.isEmpty())) {
        break;
      }
      int j = paramdzt.abeS.size();
      int i = 0;
      while (i < j)
      {
        localObject = (dzs)paramdzt.abeS.get(i);
        if ((((dzs)localObject).abeR != null) && (!((dzs)localObject).abeR.isEmpty())) {
          this.JEK.put(Integer.valueOf(((dzs)localObject).type), ((dzs)localObject).abeR);
        }
        i += 1;
      }
      this.vyS = "";
      this.mOI = "";
    }
    this.vyQ = Integer.valueOf(paramdzt.abeT);
    this.egJ = paramdzt.ycW;
    if ((paramdzt.abeX != null) && (!paramdzt.abeX.isEmpty()))
    {
      paramdzt = paramdzt.abeX.iterator();
      while (paramdzt.hasNext())
      {
        localObject = (dzr)paramdzt.next();
        if ((localObject != null) && (!Util.isNullOrNil(((dzr)localObject).key))) {
          if (((dzr)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.JEL = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.JEM = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((dzr)localObject).value;
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.JEN = c.aIM(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.JEO = c.aIM(((dzr)localObject).value);
          } else if (((dzr)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.JEP = ((dzr)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.JEL = "";
    this.JEM = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.JEN = "";
    this.JEO = "";
    this.JEP = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<dro>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<dro>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (dro)localLinkedList.get(paramInt);
          if (((dro)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((dro)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((dro)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        paramHashMap = new String(Base64.decode(((dro)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean fQi()
  {
    AppMethodBeat.i(117515);
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.vyR.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.vyR.intValue() == 3)
    {
      boolean bool = NetStatusUtil.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean fQj()
  {
    AppMethodBeat.i(117516);
    if ((this.vyP.intValue() == 2) || (this.vyP.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean fQk()
  {
    AppMethodBeat.i(117517);
    if ((this.JEK != null) && (!this.JEK.isEmpty()) && (this.JEK.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String fQl()
  {
    AppMethodBeat.i(117519);
    if (fQk())
    {
      String str = a(this.JEK, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean fQm()
  {
    AppMethodBeat.i(261831);
    if ((this.vyP.intValue() > 4) || (this.vyP.intValue() <= 0))
    {
      Log.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { this.vyP, Integer.valueOf(1), Integer.valueOf(4) });
      h.OAn.idkeyStat(614L, 24L, 1L, false);
      AppMethodBeat.o(261831);
      return false;
    }
    if (fQj())
    {
      if (TextUtils.isEmpty(this.egJ))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
        h.OAn.idkeyStat(614L, 25L, 1L, false);
        AppMethodBeat.o(261831);
        return false;
      }
      if (TextUtils.isEmpty(this.mOI))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
        h.OAn.idkeyStat(614L, 26L, 1L, false);
        AppMethodBeat.o(261831);
        return false;
      }
      if (TextUtils.isEmpty(this.vyS))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
        h.OAn.idkeyStat(614L, 27L, 1L, false);
        AppMethodBeat.o(261831);
        return false;
      }
    }
    AppMethodBeat.o(261831);
    return true;
  }
  
  public final boolean fQn()
  {
    AppMethodBeat.i(261837);
    if (this.vyP.intValue() == 3)
    {
      AppMethodBeat.o(261837);
      return true;
    }
    AppMethodBeat.o(261837);
    return false;
  }
  
  public final boolean fQo()
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
  
  public String toString()
  {
    AppMethodBeat.i(117520);
    String str = "responseState:" + this.vyP + "\ncdnUrl:" + this.mOI + "\nfileMd5:" + this.vyS + "\npackageType:" + this.vyQ + "\nnetworkType:" + this.vyR + "\npatchId:" + this.egJ;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b
 * JD-Core Version:    0.7.0.1
 */