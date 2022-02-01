package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.cbp;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final int fileSize;
  public final String gHx;
  public final Integer nUd;
  public Integer nUe;
  public final Integer nUf;
  public final String nUg;
  public final String nUh;
  public HashMap<Integer, LinkedList<cbp>> uJg;
  public String uJh;
  public String uJi;
  public String uJj;
  public String uJk;
  public String uJl;
  public int versionCode;
  
  public b(cgy paramcgy)
  {
    AppMethodBeat.i(117514);
    this.uJg = new HashMap();
    if (paramcgy == null)
    {
      this.nUd = Integer.valueOf(1);
      this.gHx = "";
      this.nUg = "";
      this.nUe = Integer.valueOf(-1);
      this.nUf = Integer.valueOf(-1);
      this.nUh = "";
      this.fileSize = 0;
      this.uJh = "";
      this.uJi = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.uJj = "";
      this.uJk = "";
      this.uJl = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramcgy.Hav != null)
    {
      this.nUg = paramcgy.Hav.MD5;
      this.gHx = paramcgy.Hav.Url;
    }
    Object localObject;
    for (this.fileSize = paramcgy.Hav.FileSize;; this.fileSize = 0)
    {
      this.nUd = Integer.valueOf(paramcgy.state);
      this.nUf = Integer.valueOf(paramcgy.Hau);
      if ((paramcgy.Has == null) || (paramcgy.Has.isEmpty())) {
        break;
      }
      int j = paramcgy.Has.size();
      int i = 0;
      while (i < j)
      {
        localObject = (cgx)paramcgy.Has.get(i);
        if ((((cgx)localObject).Har != null) && (!((cgx)localObject).Har.isEmpty())) {
          this.uJg.put(Integer.valueOf(((cgx)localObject).type), ((cgx)localObject).Har);
        }
        i += 1;
      }
      this.nUg = "";
      this.gHx = "";
    }
    this.nUe = Integer.valueOf(paramcgy.Hat);
    this.nUh = paramcgy.wDT;
    if ((paramcgy.Hax != null) && (!paramcgy.Hax.isEmpty()))
    {
      paramcgy = paramcgy.Hax.iterator();
      while (paramcgy.hasNext())
      {
        localObject = (cgw)paramcgy.next();
        if ((localObject != null) && (!bt.isNullOrNil(((cgw)localObject).key))) {
          if (((cgw)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.uJh = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.uJi = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = bt.aRe(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((cgw)localObject).value;
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.uJj = c.anq(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.uJk = c.anq(((cgw)localObject).value);
          } else if (((cgw)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.uJl = ((cgw)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.uJh = "";
    this.uJi = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.uJj = "";
    this.uJk = "";
    this.uJl = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<cbp>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<cbp>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (cbp)localLinkedList.get(paramInt);
          if (((cbp)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((cbp)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((cbp)localObject1).lang.equalsIgnoreCase(ac.fks()))
      {
        paramHashMap = new String(Base64.decode(((cbp)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean dcG()
  {
    AppMethodBeat.i(117515);
    Context localContext = aj.getContext();
    if (!ay.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.nUf.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.nUf.intValue() == 3)
    {
      boolean bool = ay.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean dcH()
  {
    AppMethodBeat.i(117516);
    if ((this.nUd.intValue() == 2) || (this.nUd.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean dcI()
  {
    AppMethodBeat.i(117517);
    if ((this.uJg != null) && (!this.uJg.isEmpty()) && (this.uJg.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String dcJ()
  {
    AppMethodBeat.i(117519);
    if (dcI())
    {
      String str = a(this.uJg, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean dcK()
  {
    AppMethodBeat.i(218924);
    if ((this.nUd.intValue() > 4) || (this.nUd.intValue() <= 0))
    {
      ad.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { this.nUd, Integer.valueOf(1), Integer.valueOf(4) });
      g.yhR.idkeyStat(614L, 24L, 1L, false);
      AppMethodBeat.o(218924);
      return false;
    }
    if (dcH())
    {
      if (TextUtils.isEmpty(this.nUh))
      {
        ad.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
        g.yhR.idkeyStat(614L, 25L, 1L, false);
        AppMethodBeat.o(218924);
        return false;
      }
      if (TextUtils.isEmpty(this.gHx))
      {
        ad.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
        g.yhR.idkeyStat(614L, 26L, 1L, false);
        AppMethodBeat.o(218924);
        return false;
      }
      if (TextUtils.isEmpty(this.nUg))
      {
        ad.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
        g.yhR.idkeyStat(614L, 27L, 1L, false);
        AppMethodBeat.o(218924);
        return false;
      }
    }
    AppMethodBeat.o(218924);
    return true;
  }
  
  public final boolean dcL()
  {
    AppMethodBeat.i(218925);
    if (this.nUd.intValue() == 3)
    {
      AppMethodBeat.o(218925);
      return true;
    }
    AppMethodBeat.o(218925);
    return false;
  }
  
  public final boolean dcM()
  {
    AppMethodBeat.i(117521);
    String str;
    if (this.clientVersion == null) {
      str = "";
    }
    for (;;)
    {
      ad.i("Tinker.TinkerSyncResponse", "clientVersion %s currentVersion %s", new Object[] { str, i.hgG });
      if (!bt.isNullOrNil(this.clientVersion)) {
        try
        {
          int i = Integer.decode(this.clientVersion).intValue();
          int j = Integer.decode(i.hgG).intValue();
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
    String str = "responseState:" + this.nUd + "\ncdnUrl:" + this.gHx + "\nfileMd5:" + this.nUg + "\npackageType:" + this.nUe + "\nnetworkType:" + this.nUf + "\npatchId:" + this.nUh;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */