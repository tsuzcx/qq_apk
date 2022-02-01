package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> gzY = null;
  
  public static String a(is paramis, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramis = a(paramis, paramInt, null);
    AppMethodBeat.o(21804);
    return paramis;
  }
  
  public static String a(is paramis, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramis.KMU == paramInt) && (paramis.KMS != null))
    {
      paramis = com.tencent.mm.b.g.getMessageDigest(paramis.KMS.getBuffer().zy);
      AppMethodBeat.o(21803);
      return paramis;
    }
    if ((paramis.KMR != null) && (paramis.KMQ != null))
    {
      Iterator localIterator = paramis.KMR.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((dqj)localIterator.next()).MTq == paramInt)
        {
          String str = ((dqi)paramis.KMQ.get(i)).MTo;
          if ((!Util.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (s.YS(agM(str)))
            {
              AppMethodBeat.o(21803);
              return str;
            }
            AppMethodBeat.o(21803);
            return null;
          }
        }
        else
        {
          i += 1;
        }
      }
    }
    AppMethodBeat.o(21803);
    return null;
  }
  
  public static boolean a(long paramLong, PLong paramPLong1, PLong paramPLong2, String paramString)
  {
    AppMethodBeat.i(21799);
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.aKJ());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = o.X(com.tencent.mm.compatible.util.g.getDataDirectory());
    StatFs localStatFs = new StatFs(aa.z(((o)localObject).mUri));
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    Log.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
    if (l1 <= 0L)
    {
      AppMethodBeat.o(21799);
      return false;
    }
    if (l1 - l2 < 0L)
    {
      AppMethodBeat.o(21799);
      return false;
    }
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(aa.z(((o)localObject).mUri)))) {
      paramPLong1.value = 0L;
    }
    if (paramLong > paramPLong2.value)
    {
      AppMethodBeat.o(21799);
      return false;
    }
    AppMethodBeat.o(21799);
    return true;
  }
  
  public static boolean agB(String paramString)
  {
    AppMethodBeat.i(21800);
    if (paramString == null)
    {
      AppMethodBeat.o(21800);
      return false;
    }
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (XmlParser.parseXml(str, "msg", null) != null)
    {
      AppMethodBeat.o(21800);
      return true;
    }
    AppMethodBeat.o(21800);
    return false;
  }
  
  public static String agK(String paramString)
  {
    AppMethodBeat.i(21796);
    if (paramString == null)
    {
      AppMethodBeat.o(21796);
      return "";
    }
    String str2 = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    paramString = paramString + str1;
    AppMethodBeat.o(21796);
    return paramString;
  }
  
  public static void agL(String paramString)
  {
    AppMethodBeat.i(21798);
    s.boN(paramString);
    s.boN(paramString + "backupItem/");
    s.boN(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String agM(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = cgW() + "backupMeida/" + agK(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static boolean b(is paramis, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramis.KMU == paramInt) && (paramis.KMS != null))
    {
      paramis = paramis.KMS.getBuffer().zy;
      if (paramis.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      s.f(paramString, paramis, paramis.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramis = a(paramis, paramInt, null);
    if (!Util.isNullOrNil(paramis))
    {
      s.nw(agM(paramis), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(is paramis, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramis.KMU == paramInt) && (paramis.KMS != null))
    {
      paramis = paramis.KMS.getBuffer().zy;
      AppMethodBeat.o(21805);
      return paramis;
    }
    if ((paramis.KMR != null) && (paramis.KMQ != null))
    {
      Iterator localIterator = paramis.KMR.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((dqj)localIterator.next()).MTq == paramInt)
        {
          paramis = agM(((dqi)paramis.KMQ.get(i)).MTo);
          paramInt = (int)s.boW(paramis);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            Log.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramis = s.aW(paramis, 0, -1);
          AppMethodBeat.o(21805);
          return paramis;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static int c(is paramis, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramis.KMU == paramInt)
    {
      if (paramis.KMS == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramis.KMS.getBuffer().zy.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramis.KMR != null) && (paramis.KMQ != null))
    {
      Iterator localIterator = paramis.KMR.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((dqj)localIterator.next()).MTq == paramInt)
        {
          paramInt = (int)s.boW(agM(((dqi)paramis.KMQ.get(i)).MTo));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static List<String> cfd()
  {
    AppMethodBeat.i(21795);
    if (gzY != null)
    {
      localObject1 = gzY;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    gzY = new LinkedList();
    Object localObject1 = ab.iCO;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      gzY.add(localObject2);
      i += 1;
    }
    gzY.add("weixin");
    gzY.add("weibo");
    gzY.add("qqmail");
    gzY.add("fmessage");
    gzY.add("tmessage");
    gzY.add("qmessage");
    gzY.add("qqsync");
    gzY.add("floatbottle");
    gzY.add("lbsapp");
    gzY.add("shakeapp");
    gzY.add("medianote");
    gzY.add("qqfriend");
    gzY.add("readerapp");
    gzY.add("newsapp");
    gzY.add("blogapp");
    gzY.add("facebookapp");
    gzY.add("masssendapp");
    gzY.add("meishiapp");
    gzY.add("feedsapp");
    gzY.add("voipapp");
    gzY.add("officialaccounts");
    gzY.add("helper_entry");
    gzY.add("pc_share");
    gzY.add("cardpackage");
    gzY.add("voicevoipapp");
    gzY.add("voiceinputapp");
    gzY.add("linkedinplugin");
    gzY.add("appbrandcustomerservicemsg");
    localObject1 = gzY;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String cgW()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static int cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = Util.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static boolean d(is paramis, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramis.KMU == paramInt) && (paramis.KMS != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramis = paramis.KMR.iterator();
    while (paramis.hasNext()) {
      if (((dqj)paramis.next()).MTq == paramInt)
      {
        AppMethodBeat.o(21808);
        return true;
      }
    }
    AppMethodBeat.o(21808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */