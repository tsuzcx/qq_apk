package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.bc.e;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.fzn;
import com.tencent.mm.protocal.protobuf.fzo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
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
  public static String Zv(int paramInt)
  {
    AppMethodBeat.i(26095);
    Object localObject = MMApplicationContext.getContext();
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject = ((Context)localObject).getString(R.l.gLb);
      AppMethodBeat.o(26095);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(R.l.gLb);
      AppMethodBeat.o(26095);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(R.l.gLb);
      AppMethodBeat.o(26095);
      return localObject;
    case 6: 
      localObject = ((Context)localObject).getString(R.l.gKX);
      AppMethodBeat.o(26095);
      return localObject;
    }
    localObject = ((Context)localObject).getString(R.l.gKY);
    AppMethodBeat.o(26095);
    return localObject;
  }
  
  public static String Zw(int paramInt)
  {
    AppMethodBeat.i(26110);
    Object localObject = MMApplicationContext.getContext();
    if (((paramInt & 0x1) > 0) && ((paramInt & 0x2) <= 0))
    {
      localObject = ((Context)localObject).getString(R.l.gLV) + " ";
      AppMethodBeat.o(26110);
      return localObject;
    }
    if ((paramInt & 0x8) > 0)
    {
      localObject = ((Context)localObject).getString(R.l.gLW) + " ";
      AppMethodBeat.o(26110);
      return localObject;
    }
    AppMethodBeat.o(26110);
    return "";
  }
  
  private static int aJE(String paramString)
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
        Log.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(26092);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      Log.printErrStackTrace("MicroMsg.IPCallUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(26092);
    }
    return 0;
  }
  
  public static void aJF(String paramString)
  {
    AppMethodBeat.i(26105);
    ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramString);
    AppMethodBeat.o(26105);
  }
  
  public static fzo bC(LinkedList<ehs> paramLinkedList)
  {
    AppMethodBeat.i(26091);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(26091);
      return null;
    }
    fzo localfzo = new fzo();
    localfzo.abXf = paramLinkedList.size();
    localfzo.abXg = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      ehs localehs = (ehs)paramLinkedList.next();
      fzn localfzn = new fzn();
      localfzn.abMm = aJE(localehs.abmM);
      localfzn.abmN = localehs.abmN;
      localfzn.abMn = localehs.abmM;
      localfzo.abXg.add(localfzn);
    }
    AppMethodBeat.o(26091);
    return localfzo;
  }
  
  public static String bt(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(26097);
    String[] arrayOfString = paramContext.getResources().getStringArray(R.c.time_month);
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
      i = Util.getInt(paramString, 0);
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
  
  private static long fSK()
  {
    AppMethodBeat.i(26101);
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.add(6, 1);
    long l2 = localCalendar.getTimeInMillis();
    AppMethodBeat.o(26101);
    return l2 - l1;
  }
  
  public static String fSL()
  {
    AppMethodBeat.i(26106);
    String str = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
    if (!Util.isNullOrNil(str))
    {
      str = str.replace("+", "");
      AppMethodBeat.o(26106);
      return str;
    }
    str = a.fSI();
    AppMethodBeat.o(26106);
    return str;
  }
  
  public static boolean fSM()
  {
    AppMethodBeat.i(26107);
    if (i.aRC().getInt("WCOSecondPurchaseSwitch", 0) > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(26107);
      return true;
    }
    AppMethodBeat.o(26107);
    return false;
  }
  
  public static boolean fSN()
  {
    AppMethodBeat.i(26108);
    if (i.aRC().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0)
    {
      AppMethodBeat.o(26108);
      return true;
    }
    AppMethodBeat.o(26108);
    return false;
  }
  
  public static cwc fSO()
  {
    AppMethodBeat.i(26109);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.ban().get(at.a.acLN, null);
    if (localObject != null)
    {
      cwc localcwc = new cwc();
      localObject = Util.decodeHexString(localObject.toString());
      try
      {
        localcwc.parseFrom((byte[])localObject);
        Log.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[] { localcwc.aaBn, localcwc.IHZ, localcwc.hAP, localcwc.IGG, localcwc.aaBo, localcwc.aaBp, localcwc.aaBq, localcwc.aaBr, localcwc.aaBy });
        AppMethodBeat.o(26109);
        return localcwc;
      }
      catch (IOException localIOException)
      {
        Log.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(26109);
    return null;
  }
  
  public static boolean iI(Context paramContext)
  {
    AppMethodBeat.i(26104);
    int i;
    if (m.isVoipStarted()) {
      i = R.l.in_voip_tip;
    }
    for (;;)
    {
      if (i == 0)
      {
        AppMethodBeat.o(26104);
        return true;
        if (m.ice())
        {
          i = R.l.in_voip_cs_tip;
          continue;
        }
        if (e.bNC())
        {
          i = R.l.in_share_location_tip;
          continue;
        }
        if (com.tencent.mm.n.a.aTe())
        {
          i = R.l.in_multitalk_tip;
          continue;
        }
        if (e.bNB())
        {
          i = R.l.in_share_location_tip;
          continue;
        }
        if (com.tencent.mm.n.a.aTi())
        {
          i = R.l.in_voip_cs_tip;
          continue;
        }
        if (com.tencent.mm.n.a.aTh()) {
          i = R.l.in_multitalk_tip;
        }
      }
      else
      {
        k.s(paramContext, i, R.l.app_tip);
        AppMethodBeat.o(26104);
        return false;
      }
      i = 0;
    }
  }
  
  public static CharSequence l(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(26096);
    paramContext = DateFormat.format(paramContext.getString(R.l.fmt_normal_time_24), paramLong);
    AppMethodBeat.o(26096);
    return paramContext;
  }
  
  public static String se(long paramLong)
  {
    AppMethodBeat.i(26098);
    Object localObject = MMApplicationContext.getContext();
    if (sf(paramLong))
    {
      localObject = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
      AppMethodBeat.o(26098);
      return localObject;
    }
    if (sg(paramLong))
    {
      localObject = ((Context)localObject).getString(R.l.gKj);
      AppMethodBeat.o(26098);
      return localObject;
    }
    localObject = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(paramLong));
    AppMethodBeat.o(26098);
    return localObject;
  }
  
  private static boolean sf(long paramLong)
  {
    AppMethodBeat.i(26099);
    if (sh(paramLong) == 0L)
    {
      AppMethodBeat.o(26099);
      return true;
    }
    AppMethodBeat.o(26099);
    return false;
  }
  
  private static boolean sg(long paramLong)
  {
    AppMethodBeat.i(26100);
    if (sh(paramLong) == -1L)
    {
      AppMethodBeat.o(26100);
      return true;
    }
    AppMethodBeat.o(26100);
    return false;
  }
  
  private static long sh(long paramLong)
  {
    AppMethodBeat.i(26102);
    long l1 = fSK();
    long l2 = Calendar.getInstance().getTimeInMillis();
    paramLong /= l1;
    l1 = l2 / l1;
    AppMethodBeat.o(26102);
    return paramLong - l1;
  }
  
  public static String si(long paramLong)
  {
    AppMethodBeat.i(26103);
    Object localObject = MMApplicationContext.getContext();
    if (paramLong <= 60.0D)
    {
      localObject = ((Context)localObject).getString(R.l.gKo, new Object[] { String.valueOf(paramLong) });
      AppMethodBeat.o(26103);
      return localObject;
    }
    double d = paramLong / 60.0D;
    int j = (int)(paramLong / 60.0D);
    int i = j;
    if (d - j > 0.0D) {
      i = j + 1;
    }
    localObject = ((Context)localObject).getString(R.l.gKn, new Object[] { String.valueOf(i) });
    AppMethodBeat.o(26103);
    return localObject;
  }
  
  public static String trimPhoneNumber(String paramString)
  {
    AppMethodBeat.i(26094);
    paramString = paramString.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    AppMethodBeat.o(26094);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c
 * JD-Core Version:    0.7.0.1
 */