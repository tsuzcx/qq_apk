package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class dy
{
  private static List<String> a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add("mobile");
    a.add("16wifi");
    a.add("cmcc");
    a.add("360wifi");
    a.add("androidap");
    a.add("htcphone");
    a.add("xiaomi");
    a.add("lenovo");
    a.add("macbook");
  }
  
  public static void a(List<ScanResult> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((ScanResult)paramList.next()).BSSID;
      if ((str == null) || (str.equals("000000000000")) || (str.equals("00-00-00-00-00-00")) || (str.equals("00:00:00:00:00:00"))) {
        paramList.remove();
      } else if (localHashSet.contains(str)) {
        paramList.remove();
      } else {
        localHashSet.add(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.dy
 * JD-Core Version:    0.7.0.1
 */