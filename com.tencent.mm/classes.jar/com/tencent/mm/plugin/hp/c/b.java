package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bsi;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public final Integer syD;
  public HashMap<Integer, LinkedList<bsi>> syE;
  public final Integer syF;
  public final Integer syG;
  public final String syH;
  public final String syI;
  public final String syJ;
  public String syK;
  public String syL;
  public String syM;
  public String syN;
  public String syO;
  public int versionCode;
  
  public b(bxm parambxm)
  {
    AppMethodBeat.i(117514);
    this.syE = new HashMap();
    if (parambxm == null)
    {
      this.syD = Integer.valueOf(1);
      this.syH = "";
      this.syI = "";
      this.syF = Integer.valueOf(-1);
      this.syG = Integer.valueOf(-1);
      this.syJ = "";
      this.fileSize = 0;
      this.syK = "";
      this.syL = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.syM = "";
      this.syN = "";
      this.syO = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (parambxm.DTY != null)
    {
      this.syI = parambxm.DTY.MD5;
      this.syH = parambxm.DTY.Url;
    }
    Object localObject;
    for (this.fileSize = parambxm.DTY.FileSize;; this.fileSize = 0)
    {
      this.syD = Integer.valueOf(parambxm.state);
      this.syG = Integer.valueOf(parambxm.DTX);
      if ((parambxm.DTV == null) || (parambxm.DTV.isEmpty())) {
        break;
      }
      int j = parambxm.DTV.size();
      int i = 0;
      while (i < j)
      {
        localObject = (bxl)parambxm.DTV.get(i);
        if ((((bxl)localObject).DTU != null) && (!((bxl)localObject).DTU.isEmpty())) {
          this.syE.put(Integer.valueOf(((bxl)localObject).type), ((bxl)localObject).DTU);
        }
        i += 1;
      }
      this.syI = "";
      this.syH = "";
    }
    this.syF = Integer.valueOf(parambxm.DTW);
    this.syJ = parambxm.upD;
    if ((parambxm.DUa != null) && (!parambxm.DUa.isEmpty()))
    {
      parambxm = parambxm.DUa.iterator();
      while (parambxm.hasNext())
      {
        localObject = (bxk)parambxm.next();
        if ((localObject != null) && (!bt.isNullOrNil(((bxk)localObject).key))) {
          if (((bxk)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.syK = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.syL = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bt.aGh(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bxk)localObject).value;
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.syM = c.adL(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.syN = c.adL(((bxk)localObject).value);
          } else if (((bxk)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.syO = ((bxk)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.syK = "";
    this.syL = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.syM = "";
    this.syN = "";
    this.syO = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<bsi>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<bsi>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (bsi)localLinkedList.get(paramInt);
          if (((bsi)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((bsi)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((bsi)localObject1).lang.equalsIgnoreCase(ac.eFu()))
      {
        paramHashMap = new String(Base64.decode(((bsi)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean cGm()
  {
    AppMethodBeat.i(117515);
    Context localContext = aj.getContext();
    if (!ay.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.syG.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.syG.intValue() == 3)
    {
      boolean bool = ay.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean cGn()
  {
    AppMethodBeat.i(117516);
    if ((this.syD.intValue() == 2) || (this.syD.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean cGo()
  {
    AppMethodBeat.i(117517);
    if ((this.syE != null) && (!this.syE.isEmpty()) && (this.syE.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String cGp()
  {
    AppMethodBeat.i(117519);
    if (cGo())
    {
      String str = a(this.syE, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean cGq()
  {
    AppMethodBeat.i(117521);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      ad.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, h.glW });
      if (!bt.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(h.glW).intValue();
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
          ad.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(117521);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117520);
    String str = "responseState:" + this.syD + "\ncdnUrl:" + this.syH + "\nfileMd5:" + this.syI + "\npackageType:" + this.syF + "\nnetworkType:" + this.syG + "\npatchId:" + this.syJ;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.b
 * JD-Core Version:    0.7.0.1
 */