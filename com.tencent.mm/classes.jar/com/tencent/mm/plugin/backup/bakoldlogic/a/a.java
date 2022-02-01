package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> jkb = null;
  
  public static String a(ih paramih, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramih = a(paramih, paramInt, null);
    AppMethodBeat.o(21804);
    return paramih;
  }
  
  public static String a(ih paramih, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramih.RNO == paramInt) && (paramih.RNM != null))
    {
      paramih = com.tencent.mm.b.g.getMessageDigest(paramih.RNM.Tkb.UH);
      AppMethodBeat.o(21803);
      return paramih;
    }
    if ((paramih.RNL != null) && (paramih.RNK != null))
    {
      Iterator localIterator = paramih.RNL.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((eag)localIterator.next()).UfA == paramInt)
        {
          String str = ((eaf)paramih.RNK.get(i)).Ufy;
          if ((!Util.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (u.agG(aoq(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.aSL());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = q.Q(com.tencent.mm.compatible.util.g.avG());
    StatFs localStatFs = new StatFs(((q)localObject).getPath());
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
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(((q)localObject).getPath()))) {
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
  
  public static boolean aof(String paramString)
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
  
  public static String aoo(String paramString)
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
  
  public static void aop(String paramString)
  {
    AppMethodBeat.i(21798);
    u.bBD(paramString);
    u.bBD(paramString + "backupItem/");
    u.bBD(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String aoq(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = cuh() + "backupMeida/" + aoo(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static boolean b(ih paramih, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramih.RNO == paramInt) && (paramih.RNM != null))
    {
      paramih = paramih.RNM.Tkb.UH;
      if (paramih.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      u.f(paramString, paramih, paramih.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramih = a(paramih, paramInt, null);
    if (!Util.isNullOrNil(paramih))
    {
      u.on(aoq(paramih), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(ih paramih, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramih.RNO == paramInt) && (paramih.RNM != null))
    {
      paramih = paramih.RNM.Tkb.UH;
      AppMethodBeat.o(21805);
      return paramih;
    }
    if ((paramih.RNL != null) && (paramih.RNK != null))
    {
      Iterator localIterator = paramih.RNL.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((eag)localIterator.next()).UfA == paramInt)
        {
          paramih = aoq(((eaf)paramih.RNK.get(i)).Ufy);
          paramInt = (int)u.bBQ(paramih);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            Log.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramih = u.aY(paramih, 0, -1);
          AppMethodBeat.o(21805);
          return paramih;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static int c(ih paramih, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramih.RNO == paramInt)
    {
      if (paramih.RNM == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramih.RNM.Tkb.UH.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramih.RNL != null) && (paramih.RNK != null))
    {
      Iterator localIterator = paramih.RNL.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((eag)localIterator.next()).UfA == paramInt)
        {
          paramInt = (int)u.bBQ(aoq(((eaf)paramih.RNK.get(i)).Ufy));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static int cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = Util.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static List<String> csq()
  {
    AppMethodBeat.i(21795);
    if (jkb != null)
    {
      localObject1 = jkb;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    jkb = new LinkedList();
    Object localObject1 = ab.lsO;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      jkb.add(localObject2);
      i += 1;
    }
    jkb.add("weixin");
    jkb.add("weibo");
    jkb.add("qqmail");
    jkb.add("fmessage");
    jkb.add("tmessage");
    jkb.add("qmessage");
    jkb.add("qqsync");
    jkb.add("floatbottle");
    jkb.add("lbsapp");
    jkb.add("shakeapp");
    jkb.add("medianote");
    jkb.add("qqfriend");
    jkb.add("readerapp");
    jkb.add("newsapp");
    jkb.add("blogapp");
    jkb.add("facebookapp");
    jkb.add("masssendapp");
    jkb.add("meishiapp");
    jkb.add("feedsapp");
    jkb.add("voipapp");
    jkb.add("officialaccounts");
    jkb.add("helper_entry");
    jkb.add("pc_share");
    jkb.add("cardpackage");
    jkb.add("voicevoipapp");
    jkb.add("voiceinputapp");
    jkb.add("linkedinplugin");
    jkb.add("appbrandcustomerservicemsg");
    localObject1 = jkb;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String cuh()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static boolean d(ih paramih, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramih.RNO == paramInt) && (paramih.RNM != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramih = paramih.RNL.iterator();
    while (paramih.hasNext()) {
      if (((eag)paramih.next()).UfA == paramInt)
      {
        AppMethodBeat.o(21808);
        return true;
      }
    }
    AppMethodBeat.o(21808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */