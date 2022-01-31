package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public String lnA;
  public String lnB;
  public String lnC;
  public String lnD;
  public final Integer lns;
  public HashMap<Integer, LinkedList<ayo>> lnt = new HashMap();
  public final Integer lnu;
  public final Integer lnv;
  public final String lnw;
  public final String lnx;
  public final String lny;
  public String lnz;
  public int versionCode;
  
  public b(bxv parambxv)
  {
    if (parambxv == null)
    {
      this.lns = Integer.valueOf(1);
      this.lnw = "";
      this.lnx = "";
      this.lnu = Integer.valueOf(-1);
      this.lnv = Integer.valueOf(-1);
      this.lny = "";
      this.fileSize = 0;
      this.lnz = "";
      this.lnA = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.lnB = "";
      this.lnC = "";
      this.lnD = "";
    }
    for (;;)
    {
      return;
      if (parambxv.tNQ != null)
      {
        this.lnx = parambxv.tNQ.sRE;
        this.lnw = parambxv.tNQ.kSC;
      }
      Object localObject;
      for (this.fileSize = parambxv.tNQ.ndo;; this.fileSize = 0)
      {
        this.lns = Integer.valueOf(parambxv.state);
        this.lnv = Integer.valueOf(parambxv.tNP);
        if ((parambxv.tNN == null) || (parambxv.tNN.isEmpty())) {
          break;
        }
        int j = parambxv.tNN.size();
        int i = 0;
        while (i < j)
        {
          localObject = (bxu)parambxv.tNN.get(i);
          if ((((bxu)localObject).tNM != null) && (!((bxu)localObject).tNM.isEmpty())) {
            this.lnt.put(Integer.valueOf(((bxu)localObject).type), ((bxu)localObject).tNM);
          }
          i += 1;
        }
        this.lnx = "";
        this.lnw = "";
      }
      this.lnu = Integer.valueOf(parambxv.tNO);
      this.lny = parambxv.sNz;
      if ((parambxv.tNS == null) || (parambxv.tNS.isEmpty())) {
        break;
      }
      parambxv = parambxv.tNS.iterator();
      while (parambxv.hasNext())
      {
        localObject = (bxt)parambxv.next();
        if ((localObject != null) && (!bk.bl(((bxt)localObject).key))) {
          if (((bxt)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.lnz = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.lnA = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bk.ZR(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((bxt)localObject).value;
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.lnB = c.Fu(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.lnC = c.Fu(((bxt)localObject).value);
          } else if (((bxt)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.lnD = ((bxt)localObject).value;
          }
        }
      }
    }
    this.lnz = "";
    this.lnA = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.lnB = "";
    this.lnC = "";
    this.lnD = "";
  }
  
  public static String a(HashMap<Integer, LinkedList<ayo>> paramHashMap, int paramInt)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      localObject = "";
    }
    LinkedList localLinkedList;
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          str = "";
          localLinkedList = (LinkedList)paramHashMap.get(Integer.valueOf(paramInt));
          localObject = str;
        } while (localLinkedList == null);
        localObject = str;
      } while (localLinkedList.isEmpty());
      i = localLinkedList.size();
      paramInt = 0;
      paramHashMap = str;
      localObject = paramHashMap;
    } while (paramInt >= i);
    Object localObject = (ayo)localLinkedList.get(paramInt);
    if (((ayo)localObject).lang.equalsIgnoreCase("default")) {
      paramHashMap = new String(Base64.decode(((ayo)localObject).content, 0));
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((ayo)localObject).lang.equalsIgnoreCase(x.cqJ())) {
        return new String(Base64.decode(((ayo)localObject).content, 0));
      }
    }
  }
  
  public final boolean bbm()
  {
    boolean bool2 = true;
    Context localContext = ae.getContext();
    boolean bool1;
    if (!aq.isConnected(localContext)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.lnv.intValue() == 1);
      bool1 = bool2;
    } while (this.lnv.intValue() != 3);
    return aq.isWifi(localContext);
  }
  
  public final boolean bbn()
  {
    return (this.lns.intValue() == 2) || (this.lns.intValue() == 4);
  }
  
  public final boolean bbo()
  {
    return (this.lnt != null) && (!this.lnt.isEmpty()) && (this.lnt.containsKey(Integer.valueOf(4)));
  }
  
  public final String bbp()
  {
    if (bbo()) {
      return a(this.lnt, 4);
    }
    return "";
  }
  
  public final boolean bbq()
  {
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      y.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, d.CLIENT_VERSION });
      if (!bk.bl(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(d.CLIENT_VERSION).intValue();
          if ((i & 0xFFFFFF00) < (j & 0xFFFFFF00))
          {
            return true;
            str = this.clientVersion;
          }
          else
          {
            return false;
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    return false;
  }
  
  public final String toString()
  {
    return "responseState:" + this.lns + "\ncdnUrl:" + this.lnw + "\nfileMd5:" + this.lnx + "\npackageType:" + this.lnu + "\nnetworkType:" + this.lnv + "\npatchId:" + this.lny;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */