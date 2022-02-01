package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.if;
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
  private static List<String> fSL = null;
  
  public static boolean VT(String paramString)
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
    if (bw.M(str, "msg") != null)
    {
      AppMethodBeat.o(21800);
      return true;
    }
    AppMethodBeat.o(21800);
    return false;
  }
  
  public static String We(String paramString)
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
  
  public static void Wf(String paramString)
  {
    AppMethodBeat.i(21798);
    i.aYg(paramString);
    i.aYg(paramString + "backupItem/");
    i.aYg(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String Wg(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = bJf() + "backupMeida/" + We(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static String a(if paramif, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramif = a(paramif, paramInt, null);
    AppMethodBeat.o(21804);
    return paramif;
  }
  
  public static String a(if paramif, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramif.FAP == paramInt) && (paramif.FAN != null))
    {
      paramif = com.tencent.mm.b.g.getMessageDigest(paramif.FAN.getBuffer().zr);
      AppMethodBeat.o(21803);
      return paramif;
    }
    if ((paramif.FAM != null) && (paramif.FAL != null))
    {
      Iterator localIterator = paramif.FAM.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((cwu)localIterator.next()).HoD == paramInt)
        {
          String str = ((cwt)paramif.FAL.get(i)).HoB;
          if ((!bt.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (i.fv(Wg(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.arU());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = e.X(com.tencent.mm.compatible.util.g.getDataDirectory());
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
  
  public static boolean b(if paramif, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramif.FAP == paramInt) && (paramif.FAN != null))
    {
      paramif = paramif.FAN.getBuffer().zr;
      if (paramif.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      i.f(paramString, paramif, paramif.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramif = a(paramif, paramInt, null);
    if (!bt.isNullOrNil(paramif))
    {
      i.mz(Wg(paramif), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(if paramif, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramif.FAP == paramInt) && (paramif.FAN != null))
    {
      paramif = paramif.FAN.getBuffer().zr;
      AppMethodBeat.o(21805);
      return paramif;
    }
    if ((paramif.FAM != null) && (paramif.FAL != null))
    {
      Iterator localIterator = paramif.FAM.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cwu)localIterator.next()).HoD == paramInt)
        {
          paramif = Wg(((cwt)paramif.FAL.get(i)).HoB);
          paramInt = (int)i.aYo(paramif);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            ad.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramif = i.aY(paramif, 0, -1);
          AppMethodBeat.o(21805);
          return paramif;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static List<String> bHo()
  {
    AppMethodBeat.i(21795);
    if (fSL != null)
    {
      localObject1 = fSL;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    fSL = new LinkedList();
    Object localObject1 = w.hFm;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      fSL.add(localObject2);
      i += 1;
    }
    fSL.add("weixin");
    fSL.add("weibo");
    fSL.add("qqmail");
    fSL.add("fmessage");
    fSL.add("tmessage");
    fSL.add("qmessage");
    fSL.add("qqsync");
    fSL.add("floatbottle");
    fSL.add("lbsapp");
    fSL.add("shakeapp");
    fSL.add("medianote");
    fSL.add("qqfriend");
    fSL.add("readerapp");
    fSL.add("newsapp");
    fSL.add("blogapp");
    fSL.add("facebookapp");
    fSL.add("masssendapp");
    fSL.add("meishiapp");
    fSL.add("feedsapp");
    fSL.add("voipapp");
    fSL.add("officialaccounts");
    fSL.add("helper_entry");
    fSL.add("pc_share");
    fSL.add("cardpackage");
    fSL.add("voicevoipapp");
    fSL.add("voiceinputapp");
    fSL.add("linkedinplugin");
    fSL.add("appbrandcustomerservicemsg");
    localObject1 = fSL;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String bJf()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static int c(if paramif, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramif.FAP == paramInt)
    {
      if (paramif.FAN == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramif.FAN.getBuffer().zr.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramif.FAM != null) && (paramif.FAL != null))
    {
      Iterator localIterator = paramif.FAM.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cwu)localIterator.next()).HoD == paramInt)
        {
          paramInt = (int)i.aYo(Wg(((cwt)paramif.FAL.get(i)).HoB));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static int cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = bt.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static boolean d(if paramif, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramif.FAP == paramInt) && (paramif.FAN != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramif = paramif.FAM.iterator();
    while (paramif.hasNext()) {
      if (((cwu)paramif.next()).HoD == paramInt)
      {
        AppMethodBeat.o(21808);
        return true;
      }
    }
    AppMethodBeat.o(21808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */