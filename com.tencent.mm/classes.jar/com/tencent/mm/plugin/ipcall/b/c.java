package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  private static int RJ(String paramString)
  {
    AppMethodBeat.i(22469);
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
        ab.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        AppMethodBeat.o(22469);
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      ab.printErrStackTrace("MicroMsg.IPCallUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(22469);
    }
    return 0;
  }
  
  public static String RK(String paramString)
  {
    AppMethodBeat.i(22471);
    paramString = paramString.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    AppMethodBeat.o(22471);
    return paramString;
  }
  
  public static void RL(String paramString)
  {
    AppMethodBeat.i(22482);
    ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
    AppMethodBeat.o(22482);
  }
  
  public static String aJ(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(22474);
    String[] arrayOfString = paramContext.getResources().getStringArray(2131755061);
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
      i = bo.getInt(paramString, 0);
      if (i >= paramContext.size())
      {
        AppMethodBeat.o(22474);
        return "";
      }
      paramContext = (String)paramContext.get(i);
      AppMethodBeat.o(22474);
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
  
  public static crn aj(LinkedList<bny> paramLinkedList)
  {
    AppMethodBeat.i(22468);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(22468);
      return null;
    }
    crn localcrn = new crn();
    localcrn.yak = paramLinkedList.size();
    localcrn.yal = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bny localbny = (bny)paramLinkedList.next();
      crm localcrm = new crm();
      localcrm.xTC = RJ(localbny.xpV);
      localcrm.xCi = localbny.xCi;
      localcrn.yal.add(localcrm);
    }
    AppMethodBeat.o(22468);
    return localcrn;
  }
  
  public static int bKK()
  {
    AppMethodBeat.i(22470);
    Context localContext = ah.getContext();
    if (at.is2G(localContext))
    {
      AppMethodBeat.o(22470);
      return 1;
    }
    if (at.is3G(localContext))
    {
      AppMethodBeat.o(22470);
      return 3;
    }
    if (at.is4G(localContext))
    {
      AppMethodBeat.o(22470);
      return 5;
    }
    if (at.isWifi(localContext))
    {
      AppMethodBeat.o(22470);
      return 4;
    }
    AppMethodBeat.o(22470);
    return 0;
  }
  
  private static long bKL()
  {
    AppMethodBeat.i(22478);
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.add(6, 1);
    long l2 = localCalendar.getTimeInMillis();
    AppMethodBeat.o(22478);
    return l2 - l1;
  }
  
  public static String bKM()
  {
    AppMethodBeat.i(22483);
    String str = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
    if (!bo.isNullOrNil(str))
    {
      str = str.replace("+", "");
      AppMethodBeat.o(22483);
      return str;
    }
    str = a.bKI();
    AppMethodBeat.o(22483);
    return str;
  }
  
  public static boolean bKN()
  {
    AppMethodBeat.i(22484);
    if (g.Nq().getInt("WCOSecondPurchaseSwitch", 0) > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(22484);
      return true;
    }
    AppMethodBeat.o(22484);
    return false;
  }
  
  public static boolean bKO()
  {
    AppMethodBeat.i(22485);
    if (g.Nq().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0)
    {
      AppMethodBeat.o(22485);
      return true;
    }
    AppMethodBeat.o(22485);
    return false;
  }
  
  public static ash bKP()
  {
    AppMethodBeat.i(22486);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.Ru().get(ac.a.yBr, null);
    if (localObject != null)
    {
      ash localash = new ash();
      localObject = bo.apQ(localObject.toString());
      try
      {
        localash.parseFrom((byte[])localObject);
        ab.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[] { localash.xhp, localash.nQe, localash.Title, localash.Desc, localash.xhq, localash.xhr, localash.xhs, localash.xht, localash.xhA });
        AppMethodBeat.o(22486);
        return localash;
      }
      catch (IOException localIOException)
      {
        ab.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(22486);
    return null;
  }
  
  public static boolean es(Context paramContext)
  {
    int j = 2131300733;
    AppMethodBeat.i(22481);
    int i;
    if (d.isVoipStarted()) {
      i = 2131300735;
    }
    while (i == 0)
    {
      AppMethodBeat.o(22481);
      return true;
      if (d.cPv())
      {
        i = 2131300734;
      }
      else
      {
        i = j;
        if (!com.tencent.mm.bg.e.ald()) {
          if (com.tencent.mm.r.a.Ok())
          {
            i = 2131300730;
          }
          else
          {
            i = j;
            if (!com.tencent.mm.bg.e.alc()) {
              i = 0;
            }
          }
        }
      }
    }
    h.h(paramContext, i, 2131297087);
    AppMethodBeat.o(22481);
    return false;
  }
  
  public static CharSequence i(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(22473);
    paramContext = DateFormat.format(paramContext.getString(2131300062), paramLong);
    AppMethodBeat.o(22473);
    return paramContext;
  }
  
  public static String ku(long paramLong)
  {
    AppMethodBeat.i(22475);
    Object localObject = ah.getContext();
    if (kv(paramLong))
    {
      localObject = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
      AppMethodBeat.o(22475);
      return localObject;
    }
    if (kw(paramLong))
    {
      localObject = ((Context)localObject).getString(2131300834);
      AppMethodBeat.o(22475);
      return localObject;
    }
    localObject = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(paramLong));
    AppMethodBeat.o(22475);
    return localObject;
  }
  
  private static boolean kv(long paramLong)
  {
    AppMethodBeat.i(22476);
    if (kx(paramLong) == 0L)
    {
      AppMethodBeat.o(22476);
      return true;
    }
    AppMethodBeat.o(22476);
    return false;
  }
  
  private static boolean kw(long paramLong)
  {
    AppMethodBeat.i(22477);
    if (kx(paramLong) == -1L)
    {
      AppMethodBeat.o(22477);
      return true;
    }
    AppMethodBeat.o(22477);
    return false;
  }
  
  private static long kx(long paramLong)
  {
    AppMethodBeat.i(22479);
    long l1 = bKL();
    long l2 = Calendar.getInstance().getTimeInMillis();
    paramLong /= l1;
    l1 = l2 / l1;
    AppMethodBeat.o(22479);
    return paramLong - l1;
  }
  
  public static String ky(long paramLong)
  {
    AppMethodBeat.i(22480);
    Object localObject = ah.getContext();
    if (paramLong <= 60.0D)
    {
      localObject = ((Context)localObject).getString(2131300843, new Object[] { String.valueOf(paramLong) });
      AppMethodBeat.o(22480);
      return localObject;
    }
    double d = paramLong / 60.0D;
    int j = (int)(paramLong / 60.0D);
    int i = j;
    if (d - j > 0.0D) {
      i = j + 1;
    }
    localObject = ((Context)localObject).getString(2131300842, new Object[] { String.valueOf(i) });
    AppMethodBeat.o(22480);
    return localObject;
  }
  
  public static String xX(int paramInt)
  {
    AppMethodBeat.i(22472);
    Object localObject = ah.getContext();
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject = ((Context)localObject).getString(2131300897);
      AppMethodBeat.o(22472);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(2131300897);
      AppMethodBeat.o(22472);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(2131300897);
      AppMethodBeat.o(22472);
      return localObject;
    case 6: 
      localObject = ((Context)localObject).getString(2131300893);
      AppMethodBeat.o(22472);
      return localObject;
    }
    localObject = ((Context)localObject).getString(2131300894);
    AppMethodBeat.o(22472);
    return localObject;
  }
  
  public static String xY(int paramInt)
  {
    AppMethodBeat.i(22487);
    Object localObject = ah.getContext();
    if (((paramInt & 0x1) > 0) && ((paramInt & 0x2) <= 0))
    {
      localObject = ((Context)localObject).getString(2131300964) + " ";
      AppMethodBeat.o(22487);
      return localObject;
    }
    if ((paramInt & 0x8) > 0)
    {
      localObject = ((Context)localObject).getString(2131300965) + " ";
      AppMethodBeat.o(22487);
      return localObject;
    }
    AppMethodBeat.o(22487);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.b.c
 * JD-Core Version:    0.7.0.1
 */