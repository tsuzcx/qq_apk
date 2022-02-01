package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bwz;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public final String gnO;
  public final Integer nth;
  public final Integer nti;
  public final Integer ntj;
  public final String ntk;
  public final String ntl;
  public HashMap<Integer, LinkedList<bwz>> tGt;
  public String tGu;
  public String tGv;
  public String tGw;
  public String tGx;
  public String tGy;
  public int versionCode;
  
  public b(cch paramcch)
  {
    AppMethodBeat.i(117514);
    this.tGt = new HashMap();
    if (paramcch == null)
    {
      this.nth = Integer.valueOf(1);
      this.gnO = "";
      this.ntk = "";
      this.nti = Integer.valueOf(-1);
      this.ntj = Integer.valueOf(-1);
      this.ntl = "";
      this.fileSize = 0;
      this.tGu = "";
      this.tGv = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.tGw = "";
      this.tGx = "";
      this.tGy = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramcch.FqL != null)
    {
      this.ntk = paramcch.FqL.MD5;
      this.gnO = paramcch.FqL.Url;
    }
    Object localObject;
    for (this.fileSize = paramcch.FqL.FileSize;; this.fileSize = 0)
    {
      this.nth = Integer.valueOf(paramcch.state);
      this.ntj = Integer.valueOf(paramcch.FqK);
      if ((paramcch.FqI == null) || (paramcch.FqI.isEmpty())) {
        break;
      }
      int j = paramcch.FqI.size();
      int i = 0;
      while (i < j)
      {
        localObject = (ccg)paramcch.FqI.get(i);
        if ((((ccg)localObject).FqH != null) && (!((ccg)localObject).FqH.isEmpty())) {
          this.tGt.put(Integer.valueOf(((ccg)localObject).type), ((ccg)localObject).FqH);
        }
        i += 1;
      }
      this.ntk = "";
      this.gnO = "";
    }
    this.nti = Integer.valueOf(paramcch.FqJ);
    this.ntl = paramcch.vyz;
    if ((paramcch.FqN != null) && (!paramcch.FqN.isEmpty()))
    {
      paramcch = paramcch.FqN.iterator();
      while (paramcch.hasNext())
      {
        localObject = (ccf)paramcch.next();
        if ((localObject != null) && (!bs.isNullOrNil(((ccf)localObject).key))) {
          if (((ccf)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.tGu = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.tGv = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bs.aLy(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((ccf)localObject).value;
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.tGw = c.aiD(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.tGx = c.aiD(((ccf)localObject).value);
          } else if (((ccf)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.tGy = ((ccf)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.tGu = "";
    this.tGv = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.tGw = "";
    this.tGx = "";
    this.tGy = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<bwz>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<bwz>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (bwz)localLinkedList.get(paramInt);
          if (((bwz)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((bwz)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((bwz)localObject1).lang.equalsIgnoreCase(ab.eUO()))
      {
        paramHashMap = new String(Base64.decode(((bwz)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean cTA()
  {
    AppMethodBeat.i(117521);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      ac.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, h.gMJ });
      if (!bs.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(h.gMJ).intValue();
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
          ac.printErrStackTrace("Tinker.TinkerSyncResponse", localException, "isLowerClientVersion", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(117521);
    return false;
  }
  
  public final boolean cTw()
  {
    AppMethodBeat.i(117515);
    Context localContext = ai.getContext();
    if (!ax.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.ntj.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.ntj.intValue() == 3)
    {
      boolean bool = ax.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean cTx()
  {
    AppMethodBeat.i(117516);
    if ((this.nth.intValue() == 2) || (this.nth.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean cTy()
  {
    AppMethodBeat.i(117517);
    if ((this.tGt != null) && (!this.tGt.isEmpty()) && (this.tGt.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String cTz()
  {
    AppMethodBeat.i(117519);
    if (cTy())
    {
      String str = a(this.tGt, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117520);
    String str = "responseState:" + this.nth + "\ncdnUrl:" + this.gnO + "\nfileMd5:" + this.ntk + "\npackageType:" + this.nti + "\nnetworkType:" + this.ntj + "\npatchId:" + this.ntl;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.b
 * JD-Core Version:    0.7.0.1
 */