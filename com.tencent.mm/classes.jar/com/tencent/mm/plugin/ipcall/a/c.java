package com.tencent.mm.plugin.ipcall.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public static String IQ(int paramInt)
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
  
  public static String IR(int paramInt)
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
  
  public static dwt aH(LinkedList<cmq> paramLinkedList)
  {
    AppMethodBeat.i(26091);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(26091);
      return null;
    }
    dwt localdwt = new dwt();
    localdwt.HJs = paramLinkedList.size();
    localdwt.HJt = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cmq localcmq = (cmq)paramLinkedList.next();
      dws localdws = new dws();
      localdws.HAw = aoi(localcmq.GPW);
      localdws.HfV = localcmq.HfV;
      localdws.HAx = localcmq.GPW;
      localdwt.HJt.add(localdws);
    }
    AppMethodBeat.o(26091);
    return localdwt;
  }
  
  public static String aQ(Context paramContext, String paramString)
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
  
  private static int aoi(String paramString)
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
  
  public static String aoj(String paramString)
  {
    AppMethodBeat.i(26094);
    paramString = paramString.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    AppMethodBeat.o(26094);
    return paramString;
  }
  
  public static void aok(String paramString)
  {
    AppMethodBeat.i(26105);
    ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
    AppMethodBeat.o(26105);
  }
  
  public static int dfd()
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
  
  private static long dfe()
  {
    AppMethodBeat.i(26101);
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.add(6, 1);
    long l2 = localCalendar.getTimeInMillis();
    AppMethodBeat.o(26101);
    return l2 - l1;
  }
  
  public static String dff()
  {
    AppMethodBeat.i(26106);
    String str = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
    if (!bt.isNullOrNil(str))
    {
      str = str.replace("+", "");
      AppMethodBeat.o(26106);
      return str;
    }
    str = a.dfb();
    AppMethodBeat.o(26106);
    return str;
  }
  
  public static boolean dfg()
  {
    AppMethodBeat.i(26107);
    if (g.acA().getInt("WCOSecondPurchaseSwitch", 0) > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(26107);
      return true;
    }
    AppMethodBeat.o(26107);
    return false;
  }
  
  public static boolean dfh()
  {
    AppMethodBeat.i(26108);
    if (g.acA().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0)
    {
      AppMethodBeat.o(26108);
      return true;
    }
    AppMethodBeat.o(26108);
    return false;
  }
  
  public static blc dfi()
  {
    AppMethodBeat.i(26109);
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.ajl().get(al.a.ItU, null);
    if (localObject != null)
    {
      blc localblc = new blc();
      localObject = bt.aRa(localObject.toString());
      try
      {
        localblc.parseFrom((byte[])localObject);
        ad.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[] { localblc.GFm, localblc.uOt, localblc.Title, localblc.Desc, localblc.GFn, localblc.GFo, localblc.GFp, localblc.GFq, localblc.GFx });
        AppMethodBeat.o(26109);
        return localblc;
      }
      catch (IOException localIOException)
      {
        ad.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(26109);
    return null;
  }
  
  public static boolean fF(Context paramContext)
  {
    int j = 2131760335;
    AppMethodBeat.i(26104);
    int i;
    if (n.isVoipStarted()) {
      i = 2131760336;
    }
    for (;;)
    {
      if (i == 0)
      {
        AppMethodBeat.o(26104);
        return true;
        i = j;
        if (n.eAf()) {
          continue;
        }
        if (com.tencent.mm.bi.e.aMj())
        {
          i = 2131760334;
          continue;
        }
        if (com.tencent.mm.s.a.adC())
        {
          i = 2131760331;
          continue;
        }
        if (com.tencent.mm.bi.e.aMi())
        {
          i = 2131760334;
          continue;
        }
        i = j;
        if (com.tencent.mm.s.a.adF()) {
          continue;
        }
        if (com.tencent.mm.s.a.adE()) {
          i = 2131760331;
        }
      }
      else
      {
        h.l(paramContext, i, 2131755906);
        AppMethodBeat.o(26104);
        return false;
      }
      i = 0;
    }
  }
  
  public static CharSequence m(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(26096);
    paramContext = DateFormat.format(paramContext.getString(2131759529), paramLong);
    AppMethodBeat.o(26096);
    return paramContext;
  }
  
  public static String xR(long paramLong)
  {
    AppMethodBeat.i(26098);
    Object localObject = aj.getContext();
    if (xS(paramLong))
    {
      localObject = new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
      AppMethodBeat.o(26098);
      return localObject;
    }
    if (xT(paramLong))
    {
      localObject = ((Context)localObject).getString(2131760435);
      AppMethodBeat.o(26098);
      return localObject;
    }
    localObject = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(paramLong));
    AppMethodBeat.o(26098);
    return localObject;
  }
  
  private static boolean xS(long paramLong)
  {
    AppMethodBeat.i(26099);
    if (xU(paramLong) == 0L)
    {
      AppMethodBeat.o(26099);
      return true;
    }
    AppMethodBeat.o(26099);
    return false;
  }
  
  private static boolean xT(long paramLong)
  {
    AppMethodBeat.i(26100);
    if (xU(paramLong) == -1L)
    {
      AppMethodBeat.o(26100);
      return true;
    }
    AppMethodBeat.o(26100);
    return false;
  }
  
  private static long xU(long paramLong)
  {
    AppMethodBeat.i(26102);
    long l1 = dfe();
    long l2 = Calendar.getInstance().getTimeInMillis();
    paramLong /= l1;
    l1 = l2 / l1;
    AppMethodBeat.o(26102);
    return paramLong - l1;
  }
  
  public static String xV(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c
 * JD-Core Version:    0.7.0.1
 */