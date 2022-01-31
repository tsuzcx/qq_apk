package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bfl;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public final Integer nKL;
  public HashMap<Integer, LinkedList<bfl>> nKM;
  public final Integer nKN;
  public final Integer nKO;
  public final String nKP;
  public final String nKQ;
  public final String nKR;
  public String nKS;
  public String nKT;
  public String nKU;
  public String nKV;
  public String nKW;
  public int versionCode;
  
  public b(bjy parambjy)
  {
    AppMethodBeat.i(90674);
    this.nKM = new HashMap();
    if (parambjy == null)
    {
      this.nKL = Integer.valueOf(1);
      this.nKP = "";
      this.nKQ = "";
      this.nKN = Integer.valueOf(-1);
      this.nKO = Integer.valueOf(-1);
      this.nKR = "";
      this.fileSize = 0;
      this.nKS = "";
      this.nKT = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.nKU = "";
      this.nKV = "";
      this.nKW = "";
      AppMethodBeat.o(90674);
      return;
    }
    if (parambjy.xyr != null)
    {
      this.nKQ = parambjy.xyr.wQr;
      this.nKP = parambjy.xyr.Url;
    }
    Object localObject;
    for (this.fileSize = parambjy.xyr.FileSize;; this.fileSize = 0)
    {
      this.nKL = Integer.valueOf(parambjy.state);
      this.nKO = Integer.valueOf(parambjy.xyq);
      if ((parambjy.xyo == null) || (parambjy.xyo.isEmpty())) {
        break;
      }
      int j = parambjy.xyo.size();
      int i = 0;
      while (i < j)
      {
        localObject = (bjx)parambjy.xyo.get(i);
        if ((((bjx)localObject).xyn != null) && (!((bjx)localObject).xyn.isEmpty())) {
          this.nKM.put(Integer.valueOf(((bjx)localObject).type), ((bjx)localObject).xyn);
        }
        i += 1;
      }
      this.nKQ = "";
      this.nKP = "";
    }
    this.nKN = Integer.valueOf(parambjy.xyp);
    this.nKR = parambjy.pqD;
    if ((parambjy.xyu != null) && (!parambjy.xyu.isEmpty()))
    {
      parambjy = parambjy.xyu.iterator();
      while (parambjy.hasNext())
      {
        localObject = (bjw)parambjy.next();
        if ((localObject != null) && (!bo.isNullOrNil(((bjw)localObject).key))) {
          if (((bjw)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.nKS = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.nKT = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bo.apV(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bjw)localObject).value;
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.nKU = c.QS(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.nKV = c.QS(((bjw)localObject).value);
          } else if (((bjw)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.nKW = ((bjw)localObject).value;
          }
        }
      }
      AppMethodBeat.o(90674);
      return;
    }
    this.nKS = "";
    this.nKT = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.nKU = "";
    this.nKV = "";
    this.nKW = "";
    AppMethodBeat.o(90674);
  }
  
  public static String a(HashMap<Integer, LinkedList<bfl>> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(90678);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(90678);
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
        paramHashMap = (HashMap<Integer, LinkedList<bfl>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (bfl)localLinkedList.get(paramInt);
          if (((bfl)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((bfl)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((bfl)localObject1).lang.equalsIgnoreCase(aa.dsG()))
      {
        paramHashMap = new String(Base64.decode(((bfl)localObject1).content, 0));
        AppMethodBeat.o(90678);
        return paramHashMap;
        AppMethodBeat.o(90678);
        return localObject2;
      }
    }
  }
  
  public final boolean bIr()
  {
    AppMethodBeat.i(90675);
    Context localContext = ah.getContext();
    if (!at.isConnected(localContext))
    {
      AppMethodBeat.o(90675);
      return false;
    }
    if (this.nKO.intValue() == 1)
    {
      AppMethodBeat.o(90675);
      return true;
    }
    if (this.nKO.intValue() == 3)
    {
      boolean bool = at.isWifi(localContext);
      AppMethodBeat.o(90675);
      return bool;
    }
    AppMethodBeat.o(90675);
    return true;
  }
  
  public final boolean bIs()
  {
    AppMethodBeat.i(90676);
    if ((this.nKL.intValue() == 2) || (this.nKL.intValue() == 4))
    {
      AppMethodBeat.o(90676);
      return true;
    }
    AppMethodBeat.o(90676);
    return false;
  }
  
  public final boolean bIt()
  {
    AppMethodBeat.i(90677);
    if ((this.nKM != null) && (!this.nKM.isEmpty()) && (this.nKM.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(90677);
      return true;
    }
    AppMethodBeat.o(90677);
    return false;
  }
  
  public final String bIu()
  {
    AppMethodBeat.i(90679);
    if (bIt())
    {
      String str = a(this.nKM, 4);
      AppMethodBeat.o(90679);
      return str;
    }
    AppMethodBeat.o(90679);
    return "";
  }
  
  public final boolean bIv()
  {
    AppMethodBeat.i(90681);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      ab.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, f.CLIENT_VERSION });
      if (!bo.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(f.CLIENT_VERSION).intValue();
          if ((i & 0xFFFFFF00) < (j & 0xFFFFFF00))
          {
            AppMethodBeat.o(90681);
            return true;
            str = this.clientVersion;
          }
          else
          {
            AppMethodBeat.o(90681);
            return false;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(90681);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90680);
    String str = "responseState:" + this.nKL + "\ncdnUrl:" + this.nKP + "\nfileMd5:" + this.nKQ + "\npackageType:" + this.nKN + "\nnetworkType:" + this.nKO + "\npatchId:" + this.nKR;
    AppMethodBeat.o(90680);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */