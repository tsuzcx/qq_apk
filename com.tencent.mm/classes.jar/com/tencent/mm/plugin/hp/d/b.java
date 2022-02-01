package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.crl;>;>;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public String clientVersion;
  public final String cri;
  public final int fileSize;
  public final Integer pkH;
  public Integer pkI;
  public final Integer pkJ;
  public final String pkK;
  public final String pkL;
  public int versionCode;
  public HashMap<Integer, LinkedList<crl>> ynu;
  public String ynv;
  public String ynw;
  public String ynx;
  public String yny;
  public String ynz;
  
  public b(cxz paramcxz)
  {
    AppMethodBeat.i(117514);
    this.ynu = new HashMap();
    if (paramcxz == null)
    {
      this.pkH = Integer.valueOf(1);
      this.pkK = "";
      this.pkL = "";
      this.pkI = Integer.valueOf(-1);
      this.pkJ = Integer.valueOf(-1);
      this.cri = "";
      this.fileSize = 0;
      this.ynv = "";
      this.ynw = "";
      this.versionCode = 0;
      this.clientVersion = "";
      this.ynx = "";
      this.yny = "";
      this.ynz = "";
      AppMethodBeat.o(117514);
      return;
    }
    if (paramcxz.MCT != null)
    {
      this.pkL = paramcxz.MCT.MD5;
      this.pkK = paramcxz.MCT.Url;
    }
    Object localObject;
    for (this.fileSize = paramcxz.MCT.FileSize;; this.fileSize = 0)
    {
      this.pkH = Integer.valueOf(paramcxz.state);
      this.pkJ = Integer.valueOf(paramcxz.MCS);
      if ((paramcxz.MCQ == null) || (paramcxz.MCQ.isEmpty())) {
        break;
      }
      int j = paramcxz.MCQ.size();
      int i = 0;
      while (i < j)
      {
        localObject = (cxy)paramcxz.MCQ.get(i);
        if ((((cxy)localObject).MCP != null) && (!((cxy)localObject).MCP.isEmpty())) {
          this.ynu.put(Integer.valueOf(((cxy)localObject).type), ((cxy)localObject).MCP);
        }
        i += 1;
      }
      this.pkL = "";
      this.pkK = "";
    }
    this.pkI = Integer.valueOf(paramcxz.MCR);
    this.cri = paramcxz.APx;
    if ((paramcxz.MCV != null) && (!paramcxz.MCV.isEmpty()))
    {
      paramcxz = paramcxz.MCV.iterator();
      while (paramcxz.hasNext())
      {
        localObject = (cxx)paramcxz.next();
        if ((localObject != null) && (!Util.isNullOrNil(((cxx)localObject).key))) {
          if (((cxx)localObject).key.equalsIgnoreCase("newApkMd5")) {
            this.ynv = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("oldApkMd5")) {
            this.ynw = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("versionCode")) {
            this.versionCode = Util.safeParseInt(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("clientVersion")) {
            this.clientVersion = ((cxx)localObject).value;
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaTitle")) {
            this.ynx = c.aBL(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaContent")) {
            this.yny = c.aBL(((cxx)localObject).value);
          } else if (((cxx)localObject).key.equalsIgnoreCase("alphaUrl")) {
            this.ynz = ((cxx)localObject).value;
          }
        }
      }
      AppMethodBeat.o(117514);
      return;
    }
    this.ynv = "";
    this.ynw = "";
    this.versionCode = 0;
    this.clientVersion = "";
    this.ynx = "";
    this.yny = "";
    this.ynz = "";
    AppMethodBeat.o(117514);
  }
  
  public static String a(HashMap<Integer, LinkedList<crl>> paramHashMap, int paramInt)
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
        paramHashMap = (HashMap<Integer, LinkedList<crl>>)localObject1;
        localObject2 = paramHashMap;
        if (paramInt < i)
        {
          localObject1 = (crl)localLinkedList.get(paramInt);
          if (((crl)localObject1).lang.equalsIgnoreCase("default")) {
            paramHashMap = new String(Base64.decode(((crl)localObject1).content, 0));
          }
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (((crl)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        paramHashMap = new String(Base64.decode(((crl)localObject1).content, 0));
        AppMethodBeat.o(117518);
        return paramHashMap;
        AppMethodBeat.o(117518);
        return localObject2;
      }
    }
  }
  
  public final boolean dZs()
  {
    AppMethodBeat.i(117515);
    Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(localContext))
    {
      AppMethodBeat.o(117515);
      return false;
    }
    if (this.pkJ.intValue() == 1)
    {
      AppMethodBeat.o(117515);
      return true;
    }
    if (this.pkJ.intValue() == 3)
    {
      boolean bool = NetStatusUtil.isWifi(localContext);
      AppMethodBeat.o(117515);
      return bool;
    }
    AppMethodBeat.o(117515);
    return true;
  }
  
  public final boolean dZt()
  {
    AppMethodBeat.i(117516);
    if ((this.pkH.intValue() == 2) || (this.pkH.intValue() == 4))
    {
      AppMethodBeat.o(117516);
      return true;
    }
    AppMethodBeat.o(117516);
    return false;
  }
  
  public final boolean dZu()
  {
    AppMethodBeat.i(117517);
    if ((this.ynu != null) && (!this.ynu.isEmpty()) && (this.ynu.containsKey(Integer.valueOf(4))))
    {
      AppMethodBeat.o(117517);
      return true;
    }
    AppMethodBeat.o(117517);
    return false;
  }
  
  public final String dZv()
  {
    AppMethodBeat.i(117519);
    if (dZu())
    {
      String str = a(this.ynu, 4);
      AppMethodBeat.o(117519);
      return str;
    }
    AppMethodBeat.o(117519);
    return "";
  }
  
  public final boolean dZw()
  {
    AppMethodBeat.i(196799);
    if ((this.pkH.intValue() > 4) || (this.pkH.intValue() <= 0))
    {
      Log.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { this.pkH, Integer.valueOf(1), Integer.valueOf(4) });
      h.CyF.idkeyStat(614L, 24L, 1L, false);
      AppMethodBeat.o(196799);
      return false;
    }
    if (dZt())
    {
      if (TextUtils.isEmpty(this.cri))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
        h.CyF.idkeyStat(614L, 25L, 1L, false);
        AppMethodBeat.o(196799);
        return false;
      }
      if (TextUtils.isEmpty(this.pkK))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
        h.CyF.idkeyStat(614L, 26L, 1L, false);
        AppMethodBeat.o(196799);
        return false;
      }
      if (TextUtils.isEmpty(this.pkL))
      {
        Log.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
        h.CyF.idkeyStat(614L, 27L, 1L, false);
        AppMethodBeat.o(196799);
        return false;
      }
    }
    AppMethodBeat.o(196799);
    return true;
  }
  
  public final boolean dZx()
  {
    AppMethodBeat.i(196800);
    if (this.pkH.intValue() == 3)
    {
      AppMethodBeat.o(196800);
      return true;
    }
    AppMethodBeat.o(196800);
    return false;
  }
  
  public final boolean dZy()
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
    String str = "responseState:" + this.pkH + "\ncdnUrl:" + this.pkK + "\nfileMd5:" + this.pkL + "\npackageType:" + this.pkI + "\nnetworkType:" + this.pkJ + "\npatchId:" + this.cri;
    AppMethodBeat.o(117520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.b
 * JD-Core Version:    0.7.0.1
 */