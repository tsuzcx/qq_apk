package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;

public class n5
{
  public static n5 c;
  public ArrayList<m5> a = new ArrayList();
  public String b = "";
  
  public static l5 a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      l5 locall5 = (l5)localIterator.next();
      if (locall5.b.equals(paramString)) {
        return locall5;
      }
    }
    return null;
  }
  
  public static ArrayList<l5> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = d().a.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((m5)localIterator1.next()).f.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add((l5)localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<l5> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = d().a.iterator();
    while (localIterator.hasNext())
    {
      m5 localm5 = (m5)localIterator.next();
      if (localm5.a.equals(paramString)) {
        return localm5.f;
      }
    }
    return localArrayList;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(d().b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = d().a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (m5)localIterator.next();
        if ((((m5)localObject).d) && (((m5)localObject).b()) && (((m5)localObject).a()))
        {
          localObject = ((m5)localObject).f.iterator();
          while (((Iterator)localObject).hasNext())
          {
            l5 locall5 = (l5)((Iterator)localObject).next();
            if (locall5.a())
            {
              localStringBuilder.append(locall5.b);
              localStringBuilder.append("|");
            }
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        d().b = localStringBuilder.substring(0, localStringBuilder.length() - 1).toString();
      }
    }
    return d().b;
  }
  
  public static m5 c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = d().a.iterator();
    while (localIterator.hasNext())
    {
      m5 localm5 = (m5)localIterator.next();
      if (localm5.a.equals(paramString)) {
        return localm5;
      }
    }
    return null;
  }
  
  public static n5 d()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          c = new n5();
          c.a();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", channelId is isEmpty");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", channel == null");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    m5 localm5 = ((l5)localObject).a;
    if (localm5 == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", company == null");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localm5.d)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isPlugin == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return true;
    }
    if (!localm5.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isInstalled == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localm5.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", checkValid == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!((l5)localObject).a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isEmbedded == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", all == true");
    APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
    return true;
  }
  
  public final void a()
  {
    m5 localm5 = new m5("", "", "", "", false);
    this.a.add(localm5);
    localm5 = new m5("中国移动", "gmcc", "MidasOperatorMobile", "com.tencent.midas.operator", true);
    localm5.f.add(new l5(localm5, "咪咕游戏", "9201", "miguGame", "APOperatorActivity", "APOperatorHelper"));
    localm5.f.add(new l5(localm5, "MM基地", "9202", "mm", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localm5);
    localm5 = new m5("中国联通", "unicom", "MidasOperatorUnicom", "com.tencent.midas.operator", true);
    localm5.f.add(new l5(localm5, "沃商店", "9204", "wo", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localm5);
    localm5 = new m5("中国电信", "vnet", "MidasOperatorTelecom", "com.tencent.midas.operator", true);
    localm5.f.add(new l5(localm5, "爱游戏", "9203", "aiGame", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localm5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n5
 * JD-Core Version:    0.7.0.1
 */