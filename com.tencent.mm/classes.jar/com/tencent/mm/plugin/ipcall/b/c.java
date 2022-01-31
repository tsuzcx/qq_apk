package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
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
  private static int Gh(String paramString)
  {
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
        y.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[] { paramString, Integer.valueOf(j) });
        return j;
      }
    }
    catch (UnknownHostException paramString)
    {
      y.printErrStackTrace("MicroMsg.IPCallUtil", paramString, "", new Object[0]);
    }
    return 0;
  }
  
  public static String Gi(String paramString)
  {
    return paramString.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
  }
  
  public static String aA(Context paramContext, String paramString)
  {
    int j = 0;
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
      i = bk.getInt(paramString, 0);
      if (i >= paramContext.size()) {
        return "";
      }
      return (String)paramContext.get(i);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public static cec ab(LinkedList<bfs> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return null;
    }
    cec localcec = new cec();
    localcec.tSS = paramLinkedList.size();
    localcec.tST = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bfs localbfs = (bfs)paramLinkedList.next();
      ceb localceb = new ceb();
      localceb.tNg = Gh(localbfs.tpY);
      localceb.tAA = localbfs.tAA;
      localcec.tST.add(localceb);
    }
    return localcec;
  }
  
  public static int bdq()
  {
    Context localContext = ae.getContext();
    if (aq.is2G(localContext)) {
      return 1;
    }
    if (aq.is3G(localContext)) {
      return 3;
    }
    if (aq.is4G(localContext)) {
      return 5;
    }
    if (aq.isWifi(localContext)) {
      return 4;
    }
    return 0;
  }
  
  public static String bdr()
  {
    String str = ae.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
    if (!bk.bl(str)) {
      return str.replace("+", "");
    }
    return a.bdo();
  }
  
  public static boolean bds()
  {
    boolean bool = false;
    if (com.tencent.mm.m.g.AA().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static ams bdt()
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Dz().get(ac.a.urs, null);
    if (localObject != null)
    {
      ams localams = new ams();
      localObject = bk.ZM(localObject.toString());
      try
      {
        localams.aH((byte[])localObject);
        y.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[] { localams.tiD, localams.lsL, localams.bGw, localams.kRN, localams.tiE, localams.tiF, localams.tiG, localams.tiH, localams.tiO });
        return localams;
      }
      catch (IOException localIOException)
      {
        y.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[] { localIOException.getMessage() });
      }
    }
    return null;
  }
  
  public static void c(MMActivity paramMMActivity, String paramString)
  {
    ((ClipboardManager)paramMMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, paramString));
  }
  
  public static boolean dG(Context paramContext)
  {
    int i;
    if (d.bSm()) {
      i = R.l.in_voip_tip;
    }
    for (;;)
    {
      if (i == 0)
      {
        return true;
        if (d.bSn())
        {
          i = R.l.in_voip_cs_tip;
        }
        else if (com.tencent.mm.bf.e.RT())
        {
          i = R.l.in_share_location_tip;
        }
        else if (com.tencent.mm.r.a.Bv())
        {
          i = R.l.in_multitalk_tip;
        }
        else
        {
          if ((com.tencent.mm.bf.g.eEV != null) && (com.tencent.mm.bf.g.eEV.RF())) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label101;
            }
            i = R.l.in_share_location_tip;
            break;
          }
        }
      }
      else
      {
        h.h(paramContext, i, R.l.app_tip);
        return false;
        label101:
        i = 0;
      }
    }
  }
  
  public static String eY(long paramLong)
  {
    int j = 1;
    Context localContext = ae.getContext();
    if (eZ(paramLong) == 0L) {}
    for (int i = 1; i != 0; i = 0) {
      return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
    }
    if (eZ(paramLong) == -1L) {}
    for (i = j; i != 0; i = 0) {
      return localContext.getString(R.l.ip_call_call_time_yesterday_format);
    }
    return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(paramLong));
  }
  
  private static long eZ(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.add(6, 1);
    l1 = localCalendar.getTimeInMillis() - l1;
    long l2 = Calendar.getInstance().getTimeInMillis();
    return paramLong / l1 - l2 / l1;
  }
  
  public static String fa(long paramLong)
  {
    Context localContext = ae.getContext();
    if (paramLong <= 60.0D) {
      return localContext.getString(R.l.ip_call_duration_second, new Object[] { String.valueOf(paramLong) });
    }
    double d = paramLong / 60.0D;
    int j = (int)(paramLong / 60.0D);
    int i = j;
    if (d - j > 0.0D) {
      i = j + 1;
    }
    return localContext.getString(R.l.ip_call_duration, new Object[] { String.valueOf(i) });
  }
  
  public static CharSequence h(Context paramContext, long paramLong)
  {
    return DateFormat.format(paramContext.getString(R.l.fmt_normal_time_24), paramLong);
  }
  
  public static String sV(int paramInt)
  {
    Context localContext = ae.getContext();
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return localContext.getString(R.l.ip_call_status_cancel);
    case 1: 
      return localContext.getString(R.l.ip_call_status_cancel);
    case 2: 
      return localContext.getString(R.l.ip_call_status_cancel);
    case 6: 
      return localContext.getString(R.l.ip_call_status_call_failed);
    }
    return localContext.getString(R.l.ip_call_status_call_invalid_number);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.b.c
 * JD-Core Version:    0.7.0.1
 */