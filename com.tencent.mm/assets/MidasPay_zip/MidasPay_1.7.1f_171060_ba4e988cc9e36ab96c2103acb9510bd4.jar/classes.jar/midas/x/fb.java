package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;

public class fb
{
  private static fb c;
  public ArrayList<fa> a = new ArrayList();
  private String b = "";
  
  public static ez a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      ez localez = (ez)localIterator.next();
      if (localez.c.equals(paramString)) {
        return localez;
      }
    }
    return null;
  }
  
  public static fb a()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          c = new fb();
          c.d();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static ArrayList<ez> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = a().a.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((fa)localIterator1.next()).f.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add((ez)localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<ez> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = a().a.iterator();
    while (localIterator.hasNext())
    {
      fa localfa = (fa)localIterator.next();
      if (localfa.b.equals(paramString)) {
        return localfa.f;
      }
    }
    return localArrayList;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(a().b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = a().a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (fa)localIterator.next();
        if ((((fa)localObject).e) && (((fa)localObject).a()) && (((fa)localObject).b()))
        {
          localObject = ((fa)localObject).f.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ez localez = (ez)((Iterator)localObject).next();
            if (localez.a())
            {
              localStringBuilder.append(localez.c);
              localStringBuilder.append("|");
            }
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        a().b = localStringBuilder.substring(0, localStringBuilder.length() - 1).toString();
      }
    }
    return a().b;
  }
  
  public static boolean c(String paramString)
  {
    Object localObject = b().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((ez)((Iterator)localObject).next()).c))
      {
        bool = true;
        break label42;
      }
    }
    boolean bool = false;
    label42:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isIdentifiedChannelId() channelId = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", isIdentified = ");
    ((StringBuilder)localObject).append(bool);
    APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void d()
  {
    fa localfa = new fa("", "", "", "", false);
    localfa.f.add(new ez(localfa, "短代", "0010", "", "", ""));
    localfa.f.add(new ez(localfa, "短验", "0020", "", "", ""));
    localfa.f.add(new ez(localfa, "咪咕游戏H5", "9018", "miguGameH5", "", ""));
    localfa.f.add(new ez(localfa, "联通H5_包月按次预付费", "7021", "unicomH5", "", ""));
    localfa.f.add(new ez(localfa, "联通H5_游戏", "8021", "unicomH5", "", ""));
    localfa.f.add(new ez(localfa, "联通H5_包月后付费", "9021", "unicomH5", "", ""));
    this.a.add(localfa);
    localfa = new fa("中国移动", "gmcc", "MidasOperatorMobile", "com.tencent.midas.operator", true);
    localfa.f.add(new ez(localfa, "咪咕游戏", "9201", "miguGame", "APOperatorActivity", "APOperatorHelper"));
    localfa.f.add(new ez(localfa, "MM基地", "9202", "mm", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfa);
    localfa = new fa("中国联通", "unicom", "MidasOperatorUnicom", "com.tencent.midas.operator", true);
    localfa.f.add(new ez(localfa, "沃商店", "9204", "wo", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfa);
    localfa = new fa("中国电信", "vnet", "MidasOperatorTelecom", "com.tencent.midas.operator", true);
    localfa.f.add(new ez(localfa, "爱游戏", "9203", "aiGame", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfa);
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
    fa localfa = ((ez)localObject).a;
    if (localfa == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", company == null");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localfa.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isPlugin == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return true;
    }
    if (!localfa.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isInstalled == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localfa.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", checkValid == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!((ez)localObject).a())
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
  
  public static fa e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = a().a.iterator();
    while (localIterator.hasNext())
    {
      fa localfa = (fa)localIterator.next();
      if (localfa.b.equals(paramString)) {
        return localfa;
      }
    }
    return null;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("0010");
  }
  
  public static boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("0020");
  }
  
  public static boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("9018");
  }
  
  public static boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ("7021".equals(paramString)) || ("8021".equals(paramString)) || ("9021".equals(paramString));
  }
  
  public static boolean j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("9203");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fb
 * JD-Core Version:    0.7.0.1
 */