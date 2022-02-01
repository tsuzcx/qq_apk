package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> fzw = null;
  
  public static String SG(String paramString)
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
  
  public static void SH(String paramString)
  {
    AppMethodBeat.i(21798);
    i.aSh(paramString);
    i.aSh(paramString + "backupItem/");
    i.aSh(paramString + "backupMeida/");
    AppMethodBeat.o(21798);
  }
  
  public static String SI(String paramString)
  {
    AppMethodBeat.i(21801);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(21801);
      return "";
    }
    paramString = bEW() + "backupMeida/" + SG(paramString) + paramString;
    AppMethodBeat.o(21801);
    return paramString;
  }
  
  public static boolean Sv(String paramString)
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
    if (bv.L(str, "msg") != null)
    {
      AppMethodBeat.o(21800);
      return true;
    }
    AppMethodBeat.o(21800);
    return false;
  }
  
  public static String a(hy paramhy, int paramInt)
  {
    AppMethodBeat.i(21804);
    paramhy = a(paramhy, paramInt, null);
    AppMethodBeat.o(21804);
    return paramhy;
  }
  
  public static String a(hy paramhy, int paramInt, String paramString)
  {
    AppMethodBeat.i(21803);
    if ((paramhy.DVu == paramInt) && (paramhy.DVs != null))
    {
      paramhy = com.tencent.mm.b.g.getMessageDigest(paramhy.DVs.getBuffer().xy);
      AppMethodBeat.o(21803);
      return paramhy;
    }
    if ((paramhy.DVr != null) && (paramhy.DVq != null))
    {
      Iterator localIterator = paramhy.DVr.iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        if (((crn)localIterator.next()).FEo == paramInt)
        {
          String str = ((crm)paramhy.DVq.get(i)).FEm;
          if ((!bs.isNullOrNil(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
          }
          else
          {
            if (i.eA(SI(str)))
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
    Object localObject = new StatFs(com.tencent.mm.loader.j.b.aph());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = e.U(com.tencent.mm.compatible.util.g.getDataDirectory());
    StatFs localStatFs = new StatFs(q.B(((e)localObject).mUri));
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    ac.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
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
  
  public static boolean b(hy paramhy, int paramInt, String paramString)
  {
    AppMethodBeat.i(21806);
    if ((paramhy.DVu == paramInt) && (paramhy.DVs != null))
    {
      paramhy = paramhy.DVs.getBuffer().xy;
      if (paramhy.length <= 0)
      {
        AppMethodBeat.o(21806);
        return false;
      }
      i.f(paramString, paramhy, paramhy.length);
      AppMethodBeat.o(21806);
      return true;
    }
    paramhy = a(paramhy, paramInt, null);
    if (!bs.isNullOrNil(paramhy))
    {
      i.lZ(SI(paramhy), paramString);
      AppMethodBeat.o(21806);
      return true;
    }
    AppMethodBeat.o(21806);
    return false;
  }
  
  public static byte[] b(hy paramhy, int paramInt)
  {
    AppMethodBeat.i(21805);
    if ((paramhy.DVu == paramInt) && (paramhy.DVs != null))
    {
      paramhy = paramhy.DVs.getBuffer().xy;
      AppMethodBeat.o(21805);
      return paramhy;
    }
    if ((paramhy.DVr != null) && (paramhy.DVq != null))
    {
      Iterator localIterator = paramhy.DVr.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((crn)localIterator.next()).FEo == paramInt)
        {
          paramhy = SI(((crm)paramhy.DVq.get(i)).FEm);
          paramInt = (int)i.aSp(paramhy);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            ac.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            AppMethodBeat.o(21805);
            return null;
          }
          paramhy = i.aU(paramhy, 0, -1);
          AppMethodBeat.o(21805);
          return paramhy;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21805);
    return null;
  }
  
  public static List<String> bDg()
  {
    AppMethodBeat.i(21795);
    if (fzw != null)
    {
      localObject1 = fzw;
      AppMethodBeat.o(21795);
      return localObject1;
    }
    fzw = new LinkedList();
    Object localObject1 = w.hmW;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      fzw.add(localObject2);
      i += 1;
    }
    fzw.add("weixin");
    fzw.add("weibo");
    fzw.add("qqmail");
    fzw.add("fmessage");
    fzw.add("tmessage");
    fzw.add("qmessage");
    fzw.add("qqsync");
    fzw.add("floatbottle");
    fzw.add("lbsapp");
    fzw.add("shakeapp");
    fzw.add("medianote");
    fzw.add("qqfriend");
    fzw.add("readerapp");
    fzw.add("newsapp");
    fzw.add("blogapp");
    fzw.add("facebookapp");
    fzw.add("masssendapp");
    fzw.add("meishiapp");
    fzw.add("feedsapp");
    fzw.add("voipapp");
    fzw.add("officialaccounts");
    fzw.add("helper_entry");
    fzw.add("pc_share");
    fzw.add("cardpackage");
    fzw.add("voicevoipapp");
    fzw.add("voiceinputapp");
    fzw.add("linkedinplugin");
    fzw.add("appbrandcustomerservicemsg");
    localObject1 = fzw;
    AppMethodBeat.o(21795);
    return localObject1;
  }
  
  public static String bEW()
  {
    AppMethodBeat.i(21797);
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = c.getAccPath() + "backup/";
    AppMethodBeat.o(21797);
    return localObject;
  }
  
  public static int c(hy paramhy, int paramInt)
  {
    AppMethodBeat.i(21802);
    if (paramhy.DVu == paramInt)
    {
      if (paramhy.DVs == null)
      {
        AppMethodBeat.o(21802);
        return 0;
      }
      paramInt = paramhy.DVs.getBuffer().xy.length;
      AppMethodBeat.o(21802);
      return paramInt;
    }
    if ((paramhy.DVr != null) && (paramhy.DVq != null))
    {
      Iterator localIterator = paramhy.DVr.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((crn)localIterator.next()).FEo == paramInt)
        {
          paramInt = (int)i.aSp(SI(((crm)paramhy.DVq.get(i)).FEm));
          AppMethodBeat.o(21802);
          return paramInt;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(21802);
    return 0;
  }
  
  public static int cg(String paramString, int paramInt)
  {
    AppMethodBeat.i(21807);
    paramInt = bs.getInt(paramString, paramInt);
    AppMethodBeat.o(21807);
    return paramInt;
  }
  
  public static boolean d(hy paramhy, int paramInt)
  {
    AppMethodBeat.i(21808);
    if ((paramhy.DVu == paramInt) && (paramhy.DVs != null))
    {
      AppMethodBeat.o(21808);
      return true;
    }
    paramhy = paramhy.DVr.iterator();
    while (paramhy.hasNext()) {
      if (((crn)paramhy.next()).FEo == paramInt)
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