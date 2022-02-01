package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;

public class fk
{
  private static fk c;
  public ArrayList<fj> a = new ArrayList();
  private String b = "";
  
  public static fi a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      fi localfi = (fi)localIterator.next();
      if (localfi.c.equals(paramString)) {
        return localfi;
      }
    }
    return null;
  }
  
  public static fk a()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          c = new fk();
          c.d();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static ArrayList<fi> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = a().a.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((fj)localIterator1.next()).f.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add((fi)localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<fi> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = a().a.iterator();
    while (localIterator.hasNext())
    {
      fj localfj = (fj)localIterator.next();
      if (localfj.b.equals(paramString)) {
        return localfj.f;
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
        Object localObject = (fj)localIterator.next();
        if ((((fj)localObject).e) && (((fj)localObject).a()) && (((fj)localObject).b()))
        {
          localObject = ((fj)localObject).f.iterator();
          while (((Iterator)localObject).hasNext())
          {
            fi localfi = (fi)((Iterator)localObject).next();
            if (localfi.a())
            {
              localStringBuilder.append(localfi.c);
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
    fj localfj = ((fi)localObject).a;
    if (localfj == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", company == null");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localfj.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isPlugin == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return true;
    }
    if (!localfj.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isInstalled == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!localfj.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportedChannelId() channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", checkValid == false");
      APLog.i("APOperatorGroup", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!((fi)localObject).a())
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
  
  public static fj d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = a().a.iterator();
    while (localIterator.hasNext())
    {
      fj localfj = (fj)localIterator.next();
      if (localfj.b.equals(paramString)) {
        return localfj;
      }
    }
    return null;
  }
  
  private void d()
  {
    fj localfj = new fj("", "", "", "", false);
    this.a.add(localfj);
    localfj = new fj("中国移动", "gmcc", "MidasOperatorMobile", "com.tencent.midas.operator", true);
    localfj.f.add(new fi(localfj, "咪咕游戏", "9201", "miguGame", "APOperatorActivity", "APOperatorHelper"));
    localfj.f.add(new fi(localfj, "MM基地", "9202", "mm", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfj);
    localfj = new fj("中国联通", "unicom", "MidasOperatorUnicom", "com.tencent.midas.operator", true);
    localfj.f.add(new fi(localfj, "沃商店", "9204", "wo", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfj);
    localfj = new fj("中国电信", "vnet", "MidasOperatorTelecom", "com.tencent.midas.operator", true);
    localfj.f.add(new fi(localfj, "爱游戏", "9203", "aiGame", "APOperatorActivity", "APOperatorHelper"));
    this.a.add(localfj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fk
 * JD-Core Version:    0.7.0.1
 */