package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> lMF = null;
  
  public static String a(jd paramjd, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramjd = a(paramjd, paramInt, null);
    AppMethodBeat.o(21804);
    return paramjd;
  }
  
  public static String a(jd paramjd, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramjd.YLc == paramInt) && (paramjd.YLa != null))
    {
      paramjd = com.tencent.mm.b.g.getMessageDigest(paramjd.YLa.aaxD.Op);
      AppMethodBeat.o(21803);
      return paramjd;
    }
    if ((paramjd.YKZ != null) && (paramjd.YKY != null))
    {
      Iterator localIterator = paramjd.YKZ.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((etm)localIterator.next()).abwO == paramInt)
        {
          String str = ((etl)paramjd.YKY.get(i)).abwM;
          if ((!Util.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (y.ZC(ahN(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.i.b.bmz());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = u.V(com.tencent.mm.compatible.util.g.aQa());
    StatFs localStatFs = new StatFs(ah.v(((u)localObject).mUri));
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
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(ah.v(((u)localObject).mUri)))) {
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
  
  public static boolean ahC(String paramString)
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
  
  public static String ahL(String paramString)
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
  
  public static void ahM(String paramString)
  {
    AppMethodBeat.i(21798);
    y.bDX(paramString);
    y.bDX(paramString + "backupItem/");
    y.bDX(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String ahN(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = cWR() + "backupMeida/" + ahL(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static boolean b(jd paramjd, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramjd.YLc == paramInt) && (paramjd.YLa != null))
    {
      paramjd = paramjd.YLa.aaxD.Op;
      if (paramjd.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      y.f(paramString, paramjd, paramjd.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramjd = a(paramjd, paramInt, null);
    if (!Util.isNullOrNil(paramjd))
    {
      y.O(ahN(paramjd), paramString, false);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(jd paramjd, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramjd.YLc == paramInt) && (paramjd.YLa != null))
    {
      paramjd = paramjd.YLa.aaxD.Op;
      AppMethodBeat.o(21805);
      return paramjd;
    }
    if ((paramjd.YKZ != null) && (paramjd.YKY != null))
    {
      Iterator localIterator = paramjd.YKZ.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((etm)localIterator.next()).abwO == paramInt)
        {
          paramjd = ahN(((etl)paramjd.YKY.get(i)).abwM);
          paramInt = (int)y.bEl(paramjd);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            Log.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramjd = y.bi(paramjd, 0, -1);
          AppMethodBeat.o(21805);
          return paramjd;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static int c(jd paramjd, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramjd.YLc == paramInt)
    {
      if (paramjd.YLa == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramjd.YLa.aaxD.Op.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramjd.YKZ != null) && (paramjd.YKY != null))
    {
      Iterator localIterator = paramjd.YKZ.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((etm)localIterator.next()).abwO == paramInt)
        {
          paramInt = (int)y.bEl(ahN(((etl)paramjd.YKY.get(i)).abwM));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static List<String> cVa()
  {
    AppMethodBeat.i(21795);
    if (lMF != null)
    {
      localObject1 = lMF;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    lMF = new LinkedList();
    Object localObject1 = ab.oko;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      lMF.add(localObject2);
      i += 1;
    }
    lMF.add("weixin");
    lMF.add("weibo");
    lMF.add("qqmail");
    lMF.add("fmessage");
    lMF.add("tmessage");
    lMF.add("qmessage");
    lMF.add("qqsync");
    lMF.add("floatbottle");
    lMF.add("lbsapp");
    lMF.add("shakeapp");
    lMF.add("medianote");
    lMF.add("qqfriend");
    lMF.add("readerapp");
    lMF.add("newsapp");
    lMF.add("blogapp");
    lMF.add("facebookapp");
    lMF.add("masssendapp");
    lMF.add("meishiapp");
    lMF.add("feedsapp");
    lMF.add("voipapp");
    lMF.add("officialaccounts");
    lMF.add("helper_entry");
    lMF.add("pc_share");
    lMF.add("cardpackage");
    lMF.add("voicevoipapp");
    lMF.add("voiceinputapp");
    lMF.add("linkedinplugin");
    lMF.add("appbrandcustomerservicemsg");
    localObject1 = lMF;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String cWR()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static boolean d(jd paramjd, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramjd.YLc == paramInt) && (paramjd.YLa != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramjd = paramjd.YKZ.iterator();
    while (paramjd.hasNext()) {
      if (((etm)paramjd.next()).abwO == paramInt)
      {
        AppMethodBeat.o(21808);
        return true;
      }
    }
    AppMethodBeat.o(21808);
    return false;
  }
  
  public static int dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = Util.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */