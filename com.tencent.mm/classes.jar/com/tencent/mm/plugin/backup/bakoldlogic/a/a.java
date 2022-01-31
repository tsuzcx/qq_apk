package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static List<String> dru = null;
  
  public static String a(fo paramfo, int paramInt)
  {
    return a(paramfo, paramInt, null);
  }
  
  public static String a(fo paramfo, int paramInt, String paramString)
  {
    if ((paramfo.szr == paramInt) && (paramfo.szp != null))
    {
      paramfo = g.o(paramfo.szp.tFM.oY);
      return paramfo;
    }
    if ((paramfo.szo != null) && (paramfo.szn != null))
    {
      Iterator localIterator = paramfo.szo.iterator();
      int i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label147;
        }
        if (((bmm)localIterator.next()).tFQ == paramInt)
        {
          String str = ((bml)paramfo.szn.get(i)).tFO;
          if ((!bk.bl(paramString)) && (!str.endsWith(paramString)))
          {
            i = i + 1 + 1;
            continue;
          }
          paramfo = str;
          if (e.bK(xD(str))) {
            break;
          }
          return null;
        }
        i += 1;
      }
    }
    label147:
    return null;
  }
  
  public static boolean a(long paramLong, PLong paramPLong1, PLong paramPLong2, String paramString)
  {
    Object localObject = new StatFs(h.getExternalStorageDirectory().getPath());
    long l1 = ((StatFs)localObject).getBlockSize();
    paramPLong1.value = (((StatFs)localObject).getAvailableBlocks() * l1);
    localObject = h.getDataDirectory();
    StatFs localStatFs = new StatFs(((File)localObject).getPath());
    l1 = localStatFs.getBlockCount();
    long l2 = localStatFs.getAvailableBlocks();
    paramPLong2.value = (localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    y.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[] { Long.valueOf(paramPLong1.value), Long.valueOf(paramPLong2.value), Long.valueOf(paramLong) });
    if (l1 <= 0L) {
      return false;
    }
    if (l1 - l2 < 0L) {
      return false;
    }
    if ((paramPLong1.value == paramPLong2.value) || (paramString.startsWith(((File)localObject).getPath()))) {
      paramPLong1.value = 0L;
    }
    return paramLong <= paramPLong2.value;
  }
  
  public static List<String> atA()
  {
    if (dru != null) {
      return dru;
    }
    dru = new LinkedList();
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      dru.add(str);
      i += 1;
    }
    dru.add("weixin");
    dru.add("weibo");
    dru.add("qqmail");
    dru.add("fmessage");
    dru.add("tmessage");
    dru.add("qmessage");
    dru.add("qqsync");
    dru.add("floatbottle");
    dru.add("lbsapp");
    dru.add("shakeapp");
    dru.add("medianote");
    dru.add("qqfriend");
    dru.add("readerapp");
    dru.add("newsapp");
    dru.add("blogapp");
    dru.add("facebookapp");
    dru.add("masssendapp");
    dru.add("meishiapp");
    dru.add("feedsapp");
    dru.add("voipapp");
    dru.add("officialaccounts");
    dru.add("helper_entry");
    dru.add("pc_share");
    dru.add("cardpackage");
    dru.add("voicevoipapp");
    dru.add("voiceinputapp");
    dru.add("linkedinplugin");
    dru.add("appbrandcustomerservicemsg");
    return dru;
  }
  
  public static String avo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return c.FU() + "backup/";
  }
  
  public static boolean b(fo paramfo, int paramInt, String paramString)
  {
    if ((paramfo.szr == paramInt) && (paramfo.szp != null))
    {
      paramfo = paramfo.szp.tFM.oY;
      if (paramfo.length > 0) {}
    }
    do
    {
      return false;
      e.b(paramString, paramfo, paramfo.length);
      return true;
      paramfo = a(paramfo, paramInt, null);
    } while (bk.bl(paramfo));
    e.r(xD(paramfo), paramString);
    return true;
  }
  
  public static byte[] b(fo paramfo, int paramInt)
  {
    if ((paramfo.szr == paramInt) && (paramfo.szp != null)) {
      return paramfo.szp.tFM.oY;
    }
    if ((paramfo.szo != null) && (paramfo.szn != null))
    {
      Iterator localIterator = paramfo.szo.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        if (((bmm)localIterator.next()).tFQ == paramInt)
        {
          paramfo = xD(((bml)paramfo.szn.get(i)).tFO);
          paramInt = (int)e.aeQ(paramfo);
          if ((paramInt == 0) || (paramInt > 1048576))
          {
            y.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
            return null;
          }
          return e.c(paramfo, 0, -1);
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static int be(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!bk.bl(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.BakUtil", paramString, "", new Object[0]);
    }
    return paramInt;
  }
  
  public static int c(fo paramfo, int paramInt)
  {
    if (paramfo.szr == paramInt) {
      if (paramfo.szp != null) {}
    }
    for (;;)
    {
      return 0;
      return paramfo.szp.tFM.oY.length;
      if ((paramfo.szo != null) && (paramfo.szn != null))
      {
        Iterator localIterator = paramfo.szo.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          if (((bmm)localIterator.next()).tFQ == paramInt) {
            return (int)e.aeQ(xD(((bml)paramfo.szn.get(i)).tFO));
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean d(fo paramfo, int paramInt)
  {
    if ((paramfo.szr == paramInt) && (paramfo.szp != null)) {
      return true;
    }
    paramfo = paramfo.szo.iterator();
    while (paramfo.hasNext()) {
      if (((bmm)paramfo.next()).tFQ == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public static void xC(String paramString)
  {
    e.nb(paramString);
    e.nb(paramString + "backupItem/");
    e.nb(paramString + "backupMeida/");
  }
  
  public static String xD(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    return avo() + "backupMeida/" + xq(paramString) + paramString;
  }
  
  public static String xq(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str2 = g.o(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    return paramString + str1;
  }
  
  public static boolean xr(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return false;
      int i = paramString.indexOf('<');
      str = paramString;
      if (i > 0) {
        str = paramString.substring(i);
      }
    } while (bn.s(str, "msg") == null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.a.a
 * JD-Core Version:    0.7.0.1
 */