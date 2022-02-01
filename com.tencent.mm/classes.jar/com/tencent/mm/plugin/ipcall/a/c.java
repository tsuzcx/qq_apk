package com.tencent.mm.plugin.ipcall.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c
{
  public static String FA(int paramInt)
  {
    AppMethodBeat.i(26110);
    Object localObject = aj.getContext();
    if (((paramInt & 0x1) > 0) && ((paramInt & 0x2) <= 0))
    {
      localObject = ((Context)localObject).getString(2131760565) + " ";
      AppMethodBeat.o(26110);
      return localObject;
    }
    if ((paramInt & 0x8) > 0)
    {
      localObject = ((Context)localObject).getString(2131760566) + " ";
      AppMethodBeat.o(26110);
      return localObject;
    }
    AppMethodBeat.o(26110);
    return "";
  }
  
  public static String Fz(int paramInt)
  {
    AppMethodBeat.i(26095);
    Object localObject = aj.getContext();
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject = ((Context)localObject).getString(2131760498);
      AppMethodBeat.o(26095);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(2131760498);
      AppMethodBeat.o(26095);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(2131760498);
      AppMethodBeat.o(26095);
      return localObject;
    case 6: 
      localObject = ((Context)localObject).getString(2131760494);
      AppMethodBeat.o(26095);
      return localObject;
    }
    localObject = ((Context)localObject).getString(2131760495);
    AppMethodBeat.o(26095);
    return localObject;
  }
  
  public static String aM(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(26097);
    String[] arrayOfString = paramContext.getResources().getStringArray(2130903094);
    paramContext = new ArrayList();
    paramContext.add("");
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramContext.add(arrayOfString[i]);
      i += 1;
    }
    try
    {
      i = bt.getInt(paramString, 0);
      if (i >= paramContext.size())
      {
        AppMethodBeat.o(26097);
        return "";
      }
      paramContext = (String)paramContext.get(i);
      AppMethodBeat.o(26097);
      return paramContext;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private static int aeD(String paramString)
  {
    AppMethodBeat.i(26092);
    try
    {
      byte[] arrayOfByte = InetAddress.getByName(paramString).getAddress();
      if (arrayOfByte != null)
      {
        int i = 0;
        int j = 0;
        while (i < arrayOfByte.length)
        {
          j = j << 8 | arrayOfByte[i] & 0xFF;
          i += 1;
        }
        ad.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(26092);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      ad.printErrStackTrace("MicroMsg.IPCallUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(26092);
    }
    return 0;
  }
  
  public static String aeE(String paramString)
  {
    AppMethodBeat.i(26094);
    paramString = paramString.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    AppMethodBeat.o(26094);
    return paramString;
  }
  
  public static void aeF(String paramString)
  {
    AppMethodBeat.i(26105);
    ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
    AppMethodBeat.o(26105);
  }
  
  public static dli ay(LinkedList<ccn> paramLinkedList)
  {
    AppMethodBeat.i(26091);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(26091);
      return null;
    }
    dli localdli = new dli();
    localdli.EBj = paramLinkedList.size();
    localdli.EBk = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      ccn localccn = (ccn)paramLinkedList.next();
      dlh localdlh = new dlh();
      localdlh.EsP = aeD(localccn.DKe);
      localdlh.DYT = localccn.DYT;
      localdlh.EsQ = localccn.DKe;
      localdli.EBk.add(localdlh);
    }
    AppMethodBeat.o(26091);
    return localdli;
  }
  
  public static int cIH()
  {
    AppMethodBeat.i(26093);
    Context localContext = aj.getContext();
    if (ay.is2G(localContext))
    {
      AppMethodBeat.o(26093);
      return 1;
    }
    if (ay.is3G(localContext))
    {
      AppMethodBeat.o(26093);
      return 3;
    }
    if (ay.is4G(localContext))
    {
      AppMethodBeat.o(26093);
      return 5;
    }
    if (ay.isWifi(localContext))
    {
      AppMethodBeat.o(26093);
      return 4;
    }
    AppMethodBeat.o(26093);
    return 0;
  }
  
  private static long cII()
  {
    AppMethodBeat.i(26101);
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.add(6, 1);
    long l2 = localCalendar.getTimeInMillis();
    AppMethodBeat.o(26101);
    return l2 - l1;
  }
  
  public static String cIJ()
  {
    AppMethodBeat.i(26106);
    String str = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
    if (!bt.isNullOrNil(str))
    {
      str = str.replace("+", "");
      AppMethodBeat.o(26106);
      return str;
    }
    str = a.cIF();
    AppMethodBeat.o(26106);
    return str;
  }
  
  public static boolean cIK()
  {
    AppMethodBeat.i(26107);
    if (g.Zd().getInt("WCOSecondPurchaseSwitch", 0) > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(26107);
      return true;
    }
    AppMethodBeat.o(26107);
    return false;
  }
  
  public static boolean cIL()
  {
    AppMethodBeat.i(26108);
    if (g.Zd().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0)
    {
      AppMethodBeat.o(26108);
      return true;
    }
    AppMethodBeat.o(26108);
    return false;
  }
  
  public static bdc cIM()
  {
    AppMethodBeat.i(26109);
    az.arV();
    Object localObject = com.tencent.mm.model.c.afk().get(ae.a.FjN, null);
    if (localObject != null)
    {
      bdc localbdc = new bdc();
      localObject = bt.aGd(localObject.toString());
      try
      {
        localbdc.parseFrom((byte[])localObject);
        ad.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[] { localbdc.DAt, localbdc.sDZ, localbdc.Title, localbdc.Desc, localbdc.DAu, localbdc.DAv, localbdc.DAw, localbdc.DAx, localbdc.DAE });
        AppMethodBeat.o(26109);
        return localbdc;
      }
      catch (IOException localIOException)
      {
        ad.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(26109);
    return null;
  }
  
  public static boolean fn(Context paramContext)
  {
    int j = 2131760334;
    AppMethodBeat.i(26104);
    int i;
    if (k.isVoipStarted()) {
      i = 2131760336;
    }
    while (i == 0)
    {
      AppMethodBeat.o(26104);
      return true;
      if (k.dWQ())
      {
        i = 2131760335;
      }
      else
      {
        i = j;
        if (!com.tencent.mm.bi.e.aCj()) {
          if (com.tencent.mm.r.a.aad())
          {
            i = 2131760331;
          }
          else
          {
            i = j;
            if (!com.tencent.mm.bi.e.aCi()) {
              i = 0;
            }
          }
        }
      }
    }
    h.j(paramContext, i, 2131755906);
    AppMethodBeat.o(26104);
    return false;
  }
  
  public static CharSequence l(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(26096);
    paramContext = DateFormat.format(paramContext.getString(2131759529), paramLong);
    AppMethodBeat.o(26096);
    return paramContext;
  }
  
  public static String re(long paramLong)
  {
    AppMethodBeat.i(26098);
    Object localObject = aj.getContext();
    if (rf(paramLong))
    {
      localObject = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
      AppMethodBeat.o(26098);
      return localObject;
    }
    if (rg(paramLong))
    {
      localObject = ((Context)localObject).getString(2131760435);
      AppMethodBeat.o(26098);
      return localObject;
    }
    localObject = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(paramLong));
    AppMethodBeat.o(26098);
    return localObject;
  }
  
  private static boolean rf(long paramLong)
  {
    AppMethodBeat.i(26099);
    if (rh(paramLong) == 0L)
    {
      AppMethodBeat.o(26099);
      return true;
    }
    AppMethodBeat.o(26099);
    return false;
  }
  
  private static boolean rg(long paramLong)
  {
    AppMethodBeat.i(26100);
    if (rh(paramLong) == -1L)
    {
      AppMethodBeat.o(26100);
      return true;
    }
    AppMethodBeat.o(26100);
    return false;
  }
  
  private static long rh(long paramLong)
  {
    AppMethodBeat.i(26102);
    long l1 = cII();
    long l2 = Calendar.getInstance().getTimeInMillis();
    paramLong /= l1;
    l1 = l2 / l1;
    AppMethodBeat.o(26102);
    return paramLong - l1;
  }
  
  public static String ri(long paramLong)
  {
    AppMethodBeat.i(26103);
    Object localObject = aj.getContext();
    if (paramLong <= 60.0D)
    {
      localObject = ((Context)localObject).getString(2131760444, new Object[] { String.valueOf(paramLong) });
      AppMethodBeat.o(26103);
      return localObject;
    }
    double d = paramLong / 60.0D;
    int j = (int)(paramLong / 60.0D);
    int i = j;
    if (d - j > 0.0D) {
      i = j + 1;
    }
    localObject = ((Context)localObject).getString(2131760443, new Object[] { String.valueOf(i) });
    AppMethodBeat.o(26103);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c
 * JD-Core Version:    0.7.0.1
 */