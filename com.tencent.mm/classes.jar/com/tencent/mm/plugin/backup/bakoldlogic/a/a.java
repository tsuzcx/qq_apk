package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> fUR = null;
  
  public static boolean WF(String paramString)
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
    if (bx.M(str, "msg") != null)
    {
      AppMethodBeat.o(21800);
      return true;
    }
    AppMethodBeat.o(21800);
    return false;
  }
  
  public static String WQ(String paramString)
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
  
  public static void WR(String paramString)
  {
    AppMethodBeat.i(21798);
    o.aZI(paramString);
    o.aZI(paramString + "backupItem/");
    o.aZI(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String WS(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = bKd() + "backupMeida/" + WQ(paramString) + paramString;
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
    if ((paramif.FTl == paramInt) && (paramif.FTj != null))
    {
      paramif = com.tencent.mm.b.g.getMessageDigest(paramif.FTj.getBuffer().zr);
      AppMethodBeat.o(21803);
      return paramif;
    }
    if ((paramif.FTi != null) && (paramif.FTh != null))
    {
      Iterator localIterator = paramif.FTi.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((cxo)localIterator.next()).HIf == paramInt)
        {
          String str = ((cxn)paramif.FTh.get(i)).HId;
          if ((!bu.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (o.fB(WS(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.asj());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = k.W(com.tencent.mm.compatible.util.g.getDataDirectory());
    StatFs localStatFs = new StatFs(w.B(((k)localObject).mUri));
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    ae.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
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
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(w.B(((k)localObject).mUri)))) {
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
    if ((paramif.FTl == paramInt) && (paramif.FTj != null))
    {
      paramif = paramif.FTj.getBuffer().zr;
      if (paramif.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      o.f(paramString, paramif, paramif.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramif = a(paramif, paramInt, null);
    if (!bu.isNullOrNil(paramif))
    {
      o.mF(WS(paramif), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(if paramif, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramif.FTl == paramInt) && (paramif.FTj != null))
    {
      paramif = paramif.FTj.getBuffer().zr;
      AppMethodBeat.o(21805);
      return paramif;
    }
    if ((paramif.FTi != null) && (paramif.FTh != null))
    {
      Iterator localIterator = paramif.FTi.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cxo)localIterator.next()).HIf == paramInt)
        {
          paramif = WS(((cxn)paramif.FTh.get(i)).HId);
          paramInt = (int)o.aZR(paramif);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            ae.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramif = o.bb(paramif, 0, -1);
          AppMethodBeat.o(21805);
          return paramif;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static List<String> bIm()
  {
    AppMethodBeat.i(21795);
    if (fUR != null)
    {
      localObject1 = fUR;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    fUR = new LinkedList();
    Object localObject1 = x.hIe;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      fUR.add(localObject2);
      i += 1;
    }
    fUR.add("weixin");
    fUR.add("weibo");
    fUR.add("qqmail");
    fUR.add("fmessage");
    fUR.add("tmessage");
    fUR.add("qmessage");
    fUR.add("qqsync");
    fUR.add("floatbottle");
    fUR.add("lbsapp");
    fUR.add("shakeapp");
    fUR.add("medianote");
    fUR.add("qqfriend");
    fUR.add("readerapp");
    fUR.add("newsapp");
    fUR.add("blogapp");
    fUR.add("facebookapp");
    fUR.add("masssendapp");
    fUR.add("meishiapp");
    fUR.add("feedsapp");
    fUR.add("voipapp");
    fUR.add("officialaccounts");
    fUR.add("helper_entry");
    fUR.add("pc_share");
    fUR.add("cardpackage");
    fUR.add("voicevoipapp");
    fUR.add("voiceinputapp");
    fUR.add("linkedinplugin");
    fUR.add("appbrandcustomerservicemsg");
    localObject1 = fUR;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String bKd()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static int c(if paramif, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramif.FTl == paramInt)
    {
      if (paramif.FTj == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramif.FTj.getBuffer().zr.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramif.FTi != null) && (paramif.FTh != null))
    {
      Iterator localIterator = paramif.FTi.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((cxo)localIterator.next()).HIf == paramInt)
        {
          paramInt = (int)o.aZR(WS(((cxn)paramif.FTh.get(i)).HId));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static int cn(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = bu.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static boolean d(if paramif, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramif.FTl == paramInt) && (paramif.FTj != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramif = paramif.FTi.iterator();
    while (paramif.hasNext()) {
      if (((cxo)paramif.next()).HIf == paramInt)
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