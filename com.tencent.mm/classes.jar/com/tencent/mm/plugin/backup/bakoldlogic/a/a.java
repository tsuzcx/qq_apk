package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> fvP = null;
  
  public static boolean Ol(String paramString)
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
    if (bw.K(str, "msg") != null)
    {
      AppMethodBeat.o(21800);
      return true;
    }
    AppMethodBeat.o(21800);
    return false;
  }
  
  public static String Ow(String paramString)
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
  
  public static void Ox(String paramString)
  {
    AppMethodBeat.i(21798);
    i.aMF(paramString);
    i.aMF(paramString + "backupItem/");
    i.aMF(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String Oy(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = bya() + "backupMeida/" + Ow(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static String a(hu paramhu, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramhu = a(paramhu, paramInt, null);
    AppMethodBeat.o(21804);
    return paramhu;
  }
  
  public static String a(hu paramhu, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramhu.CCX == paramInt) && (paramhu.CCV != null))
    {
      paramhu = com.tencent.mm.b.g.getMessageDigest(paramhu.CCV.getBuffer().wA);
      AppMethodBeat.o(21803);
      return paramhu;
    }
    if ((paramhu.CCU != null) && (paramhu.CCT != null))
    {
      Iterator localIterator = paramhu.CCU.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((cmg)localIterator.next()).Ehp == paramInt)
        {
          String str = ((cmf)paramhu.CCT.get(i)).Ehn;
          if ((!bt.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (i.eK(Oy(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.aih());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = e.R(com.tencent.mm.compatible.util.g.getDataDirectory());
    StatFs localStatFs = new StatFs(q.B(((e)localObject).mUri));
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    ad.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
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
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(q.B(((e)localObject).mUri)))) {
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
  
  public static boolean b(hu paramhu, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramhu.CCX == paramInt) && (paramhu.CCV != null))
    {
      paramhu = paramhu.CCV.getBuffer().wA;
      if (paramhu.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      i.f(paramString, paramhu, paramhu.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramhu = a(paramhu, paramInt, null);
    if (!bt.isNullOrNil(paramhu))
    {
      i.lC(Oy(paramhu), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(hu paramhu, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramhu.CCX == paramInt) && (paramhu.CCV != null))
    {
      paramhu = paramhu.CCV.getBuffer().wA;
      AppMethodBeat.o(21805);
      return paramhu;
    }
    if ((paramhu.CCU != null) && (paramhu.CCT != null))
    {
      Iterator localIterator = paramhu.CCU.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cmg)localIterator.next()).Ehp == paramInt)
        {
          paramhu = Oy(((cmf)paramhu.CCT.get(i)).Ehn);
          paramInt = (int)i.aMN(paramhu);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            ad.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramhu = i.aR(paramhu, 0, -1);
          AppMethodBeat.o(21805);
          return paramhu;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static List<String> bwk()
  {
    AppMethodBeat.i(21795);
    if (fvP != null)
    {
      localObject1 = fvP;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    fvP = new LinkedList();
    Object localObject1 = w.gMw;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      fvP.add(localObject2);
      i += 1;
    }
    fvP.add("weixin");
    fvP.add("weibo");
    fvP.add("qqmail");
    fvP.add("fmessage");
    fvP.add("tmessage");
    fvP.add("qmessage");
    fvP.add("qqsync");
    fvP.add("floatbottle");
    fvP.add("lbsapp");
    fvP.add("shakeapp");
    fvP.add("medianote");
    fvP.add("qqfriend");
    fvP.add("readerapp");
    fvP.add("newsapp");
    fvP.add("blogapp");
    fvP.add("facebookapp");
    fvP.add("masssendapp");
    fvP.add("meishiapp");
    fvP.add("feedsapp");
    fvP.add("voipapp");
    fvP.add("officialaccounts");
    fvP.add("helper_entry");
    fvP.add("pc_share");
    fvP.add("cardpackage");
    fvP.add("voicevoipapp");
    fvP.add("voiceinputapp");
    fvP.add("linkedinplugin");
    fvP.add("appbrandcustomerservicemsg");
    localObject1 = fvP;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String bya()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    az.arV();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static int c(hu paramhu, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramhu.CCX == paramInt)
    {
      if (paramhu.CCV == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramhu.CCV.getBuffer().wA.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramhu.CCU != null) && (paramhu.CCT != null))
    {
      Iterator localIterator = paramhu.CCU.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cmg)localIterator.next()).Ehp == paramInt)
        {
          paramInt = (int)i.aMN(Oy(((cmf)paramhu.CCT.get(i)).Ehn));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static int cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = bt.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static boolean d(hu paramhu, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramhu.CCX == paramInt) && (paramhu.CCV != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramhu = paramhu.CCU.iterator();
    while (paramhu.hasNext()) {
      if (((cmg)paramhu.next()).Ehp == paramInt)
      {
        AppMethodBeat.o(21808);
        return true;
      }
    }
    AppMethodBeat.o(21808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */