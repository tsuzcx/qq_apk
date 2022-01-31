package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> ejc = null;
  
  public static String Gi(String paramString)
  {
    AppMethodBeat.i(17739);
    if (paramString == null)
    {
      AppMethodBeat.o(17739);
      return "";
    }
    String str2 = g.w(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    paramString = paramString + str1;
    AppMethodBeat.o(17739);
    return paramString;
  }
  
  public static boolean Gk(String paramString)
  {
    AppMethodBeat.i(17743);
    if (paramString == null)
    {
      AppMethodBeat.o(17743);
      return false;
    }
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (br.F(str, "msg") != null)
    {
      AppMethodBeat.o(17743);
      return true;
    }
    AppMethodBeat.o(17743);
    return false;
  }
  
  public static void Gv(String paramString)
  {
    AppMethodBeat.i(17741);
    e.um(paramString);
    e.um(paramString + "backupItem/");
    e.um(paramString + "backupMeida/");
    AppMethodBeat.o(17741);
  }
  
  public static String Gw(String paramString)
  {
    AppMethodBeat.i(17744);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(17744);
      return "";
    }
    paramString = aUR() + "backupMeida/" + Gi(paramString) + paramString;
    AppMethodBeat.o(17744);
    return paramString;
  }
  
  public static String a(gx paramgx, int paramInt)
  {
    AppMethodBeat.i(17747);
    paramgx = a(paramgx, paramInt, null);
    AppMethodBeat.o(17747);
    return paramgx;
  }
  
  public static String a(gx paramgx, int paramInt, String paramString)
  {
    AppMethodBeat.i(17746);
    if ((paramgx.wts == paramInt) && (paramgx.wtq != null))
    {
      paramgx = g.w(paramgx.wtq.getBuffer().pW);
      AppMethodBeat.o(17746);
      return paramgx;
    }
    if ((paramgx.wtp != null) && (paramgx.wto != null))
    {
      Iterator localIterator = paramgx.wtp.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((bwd)localIterator.next()).xJG == paramInt)
        {
          String str = ((bwc)paramgx.wto.get(i)).xJE;
          if ((!bo.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (e.cN(Gw(str)))
            {
              AppMethodBeat.o(17746);
              return str;
            }
            AppMethodBeat.o(17746);
            return null;
          }
        }
        else
        {
          i += 1;
        }
      }
    }
    AppMethodBeat.o(17746);
    return null;
  }
  
  public static boolean a(long paramLong, PLong paramPLong1, PLong paramPLong2, String paramString)
  {
    AppMethodBeat.i(17742);
    Object localObject = new StatFs(h.getExternalStorageDirectory().getPath());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = h.getDataDirectory();
    StatFs localStatFs = new StatFs(((File)localObject).getPath());
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    ab.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
    if (l1 <= 0L)
    {
      AppMethodBeat.o(17742);
      return false;
    }
    if (l1 - l2 < 0L)
    {
      AppMethodBeat.o(17742);
      return false;
    }
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(((File)localObject).getPath()))) {
      paramPLong1.value = 0L;
    }
    if (paramLong > paramPLong2.value)
    {
      AppMethodBeat.o(17742);
      return false;
    }
    AppMethodBeat.o(17742);
    return true;
  }
  
  public static List<String> aSY()
  {
    AppMethodBeat.i(17738);
    if (ejc != null)
    {
      localObject1 = ejc;
      AppMethodBeat.o(17738);
      return localObject1;
    }
    ejc = new LinkedList();
    Object localObject1 = t.fll;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      ejc.add(localObject2);
      i += 1;
    }
    ejc.add("weixin");
    ejc.add("weibo");
    ejc.add("qqmail");
    ejc.add("fmessage");
    ejc.add("tmessage");
    ejc.add("qmessage");
    ejc.add("qqsync");
    ejc.add("floatbottle");
    ejc.add("lbsapp");
    ejc.add("shakeapp");
    ejc.add("medianote");
    ejc.add("qqfriend");
    ejc.add("readerapp");
    ejc.add("newsapp");
    ejc.add("blogapp");
    ejc.add("facebookapp");
    ejc.add("masssendapp");
    ejc.add("meishiapp");
    ejc.add("feedsapp");
    ejc.add("voipapp");
    ejc.add("officialaccounts");
    ejc.add("helper_entry");
    ejc.add("pc_share");
    ejc.add("cardpackage");
    ejc.add("voicevoipapp");
    ejc.add("voiceinputapp");
    ejc.add("linkedinplugin");
    ejc.add("appbrandcustomerservicemsg");
    localObject1 = ejc;
    AppMethodBeat.o(17738);
    return localObject1;
  }
  
  public static String aUR()
  {
    AppMethodBeat.i(17740);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(17740);
    return localObject;
  }
  
  public static boolean b(gx paramgx, int paramInt, String paramString)
  {
    AppMethodBeat.i(17749);
    if ((paramgx.wts == paramInt) && (paramgx.wtq != null))
    {
      paramgx = paramgx.wtq.getBuffer().pW;
      if (paramgx.length <= 0)
      {
        AppMethodBeat.o(17749);
        return false;
      }
      e.b(paramString, paramgx, paramgx.length);
      AppMethodBeat.o(17749);
      return true;
    }
    paramgx = a(paramgx, paramInt, null);
    if (!bo.isNullOrNil(paramgx))
    {
      e.C(Gw(paramgx), paramString);
      AppMethodBeat.o(17749);
      return true;
    }
    AppMethodBeat.o(17749);
    return false;
  }
  
  public static byte[] b(gx paramgx, int paramInt)
  {
    AppMethodBeat.i(17748);
    if ((paramgx.wts == paramInt) && (paramgx.wtq != null))
    {
      paramgx = paramgx.wtq.getBuffer().pW;
      AppMethodBeat.o(17748);
      return paramgx;
    }
    if ((paramgx.wtp != null) && (paramgx.wto != null))
    {
      Iterator localIterator = paramgx.wtp.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((bwd)localIterator.next()).xJG == paramInt)
        {
          paramgx = Gw(((bwc)paramgx.wto.get(i)).xJE);
          paramInt = (int)e.avI(paramgx);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            ab.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(17748);
            return null;
          }
          paramgx = e.i(paramgx, 0, -1);
          AppMethodBeat.o(17748);
          return paramgx;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(17748);
    return null;
  }
  
  public static int bE(String paramString, int paramInt)
  {
    AppMethodBeat.i(17750);
    int i = paramInt;
    if (!bo.isNullOrNil(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(17750);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BakUtil", paramString, "", new Object[0]);
        i = paramInt;
      }
    }
  }
  
  public static int c(gx paramgx, int paramInt)
  {
    AppMethodBeat.i(17745);
    if (paramgx.wts == paramInt)
    {
      if (paramgx.wtq == null)
      {
        AppMethodBeat.o(17745);
        return 0;
      }
      paramInt = paramgx.wtq.getBuffer().pW.length;
      AppMethodBeat.o(17745);
      return paramInt;
    }
    if ((paramgx.wtp != null) && (paramgx.wto != null))
    {
      Iterator localIterator = paramgx.wtp.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((bwd)localIterator.next()).xJG == paramInt)
        {
          paramInt = (int)e.avI(Gw(((bwc)paramgx.wto.get(i)).xJE));
          AppMethodBeat.o(17745);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(17745);
    return 0;
  }
  
  public static boolean d(gx paramgx, int paramInt)
  {
    AppMethodBeat.i(17751);
    if ((paramgx.wts == paramInt) && (paramgx.wtq != null))
    {
      AppMethodBeat.o(17751);
      return true;
    }
    paramgx = paramgx.wtp.iterator();
    while (paramgx.hasNext()) {
      if (((bwd)paramgx.next()).xJG == paramInt)
      {
        AppMethodBeat.o(17751);
        return true;
      }
    }
    AppMethodBeat.o(17751);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */