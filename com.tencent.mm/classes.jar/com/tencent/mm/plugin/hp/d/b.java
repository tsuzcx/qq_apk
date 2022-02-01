package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.ccj;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public final String gKg;
  public final Integer nZJ;
  public Integer nZK;
  public final Integer nZL;
  public final String nZM;
  public final String nZN;
  public HashMap<Integer, LinkedList<ccj>> uUT;
  public String uUU;
  public String uUV;
  public String uUW;
  public String uUX;
  public String uUY;
  public int versionCode;
  
  public b(chs paramchs)
  {
    AppMethodBeat.i(117514);
    this.uUT = new HashMap();
    if (paramchs == null)
    {
      this.nZJ = Integer.valueOf(1);
      this.gKg = "";
      this.nZM = "";
      this.nZK = Integer.valueOf(-1);
      this.nZL = Integer.valueOf(-1);
      this.nZN = "";
      this.fileSize = 0;
      this.uUU = "";
      this.uUV = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.uUW = "";
      this.uUX = "";
      this.uUY = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramchs.HtV != null)
    {
      this.nZM = paramchs.HtV.MD5;
      this.gKg = paramchs.HtV.Url;
    }
    Object localObject;
    for (this.fileSize = paramchs.HtV.FileSize;; this.fileSize = 0)
    {
      this.nZJ = Integer.valueOf(paramchs.state);
      this.nZL = Integer.valueOf(paramchs.HtU);
      if ((paramchs.HtS == null) || (paramchs.HtS.isEmpty())) {
        break;
      }
      int j = paramchs.HtS.size();
      int i = 0;
      while (i < j)
      {
        localObject = (chr)paramchs.HtS.get(i);
        if ((((chr)localObject).HtR != null) && (!((chr)localObject).HtR.isEmpty())) {
          this.uUT.put(Integer.valueOf(((chr)localObject).type), ((chr)localObject).HtR);
        }
        i += 1;
      }
      this.nZM = "";
      this.gKg = "";
    }
    this.nZK = Integer.valueOf(paramchs.HtT);
    this.nZN = paramchs.wTE;
    if ((paramchs.HtX != null) && (!paramchs.HtX.isEmpty()))
    {
      paramchs = paramchs.HtX.iterator();
      while (paramchs.hasNext())
      {
        localObject = (chq)paramchs.next();
        if ((localObject != null) && (!bu.isNullOrNil(((chq)localObject).key))) {
          if (((chq)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.uUU = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.uUV = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bu.aSB(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((chq)localObject).value;
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.uUW = c.aos(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.uUX = c.aos(((chq)localObject).value);
          } else if (((chq)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.uUY = ((chq)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.uUU = "";
    this.uUV = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.uUW = "";
    this.uUX = "";
    this.uUY = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<ccj>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<ccj>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (ccj)localLinkedList.get(paramInt);
          if (((ccj)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((ccj)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((ccj)localObject1).lang.equalsIgnoreCase(ad.fom()))
      {
        paramHashMap = new String(Base64.decode(((ccj)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean dfA()
  {
    AppMethodBeat.i(117517);
    if ((this.uUT != null) && (!this.uUT.isEmpty()) && (this.uUT.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String dfB()
  {
    AppMethodBeat.i(117519);
    if (dfA())
    {
      String str = a(this.uUT, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean dfC()
  {
    AppMethodBeat.i(196791);
    if ((this.nZJ.intValue() > 4) || (this.nZJ.intValue() <= 0))
    {
      ae.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { this.nZJ, Integer.valueOf(1), Integer.valueOf(4) });
      g.yxI.idkeyStat(614L, 24L, 1L, false);
      AppMethodBeat.o(196791);
      return false;
    }
    if (dfz())
    {
      if (TextUtils.isEmpty(this.nZN))
      {
        ae.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
        g.yxI.idkeyStat(614L, 25L, 1L, false);
        AppMethodBeat.o(196791);
        return false;
      }
      if (TextUtils.isEmpty(this.gKg))
      {
        ae.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
        g.yxI.idkeyStat(614L, 26L, 1L, false);
        AppMethodBeat.o(196791);
        return false;
      }
      if (TextUtils.isEmpty(this.nZM))
      {
        ae.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
        g.yxI.idkeyStat(614L, 27L, 1L, false);
        AppMethodBeat.o(196791);
        return false;
      }
    }
    AppMethodBeat.o(196791);
    return true;
  }
  
  public final boolean dfD()
  {
    AppMethodBeat.i(196792);
    if (this.nZJ.intValue() == 3)
    {
      AppMethodBeat.o(196792);
      return true;
    }
    AppMethodBeat.o(196792);
    return false;
  }
  
  public final boolean dfE()
  {
    AppMethodBeat.i(117521);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      ae.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, j.hju });
      if (!bu.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(j.hju).intValue();
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
          ae.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(117521);
    return false;
  }
  
  public final boolean dfy()
  {
    AppMethodBeat.i(117515);
    Context localContext = ak.getContext();
    if (!az.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.nZL.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.nZL.intValue() == 3)
    {
      boolean bool = az.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean dfz()
  {
    AppMethodBeat.i(117516);
    if ((this.nZJ.intValue() == 2) || (this.nZJ.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117520);
    String str = "responseState:" + this.nZJ + "\ncdnUrl:" + this.gKg + "\nfileMd5:" + this.nZM + "\npackageType:" + this.nZK + "\nnetworkType:" + this.nZL + "\npatchId:" + this.nZN;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */