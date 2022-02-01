package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class bl
{
  private static final Comparator<ScanResult> a = new Comparator() {};
  private ArrayList<ScanResult> b;
  private long c;
  private long d;
  private int e;
  
  private bl()
  {
    this.b = new ArrayList();
    this.c = 0L;
  }
  
  bl(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    this.b = new ArrayList(paramList);
    Collections.sort(this.b, a);
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public static boolean a(bl parambl)
  {
    return (parambl == null) || (parambl.b.size() == 0);
  }
  
  public final ArrayList<ScanResult> a()
  {
    return this.b;
  }
  
  public final void b()
  {
    this.b.clear();
  }
  
  public final boolean b(@NonNull bl parambl)
  {
    return Math.abs(this.d - parambl.d) < 15000L;
  }
  
  public final int c()
  {
    return this.b.size();
  }
  
  public final boolean c(bl parambl)
  {
    if (b.a.a(parambl)) {
      return true;
    }
    return b.a.a(this.b, parambl.b);
  }
  
  public final bl d(bl parambl)
  {
    if (a(parambl)) {
      return new bl(this.b, this.c, this.d);
    }
    Object localObject2;
    Object localObject1;
    bl localbl;
    ArrayList localArrayList;
    int i;
    if (this.d > parambl.d)
    {
      localObject2 = parambl.b;
      localObject1 = this.b;
      localbl = new bl();
      localArrayList = localbl.b;
      i = this.e;
      this.e = (i + 1);
      localbl.e = i;
      localbl.c = Math.max(this.c, parambl.c);
      localbl.d = Math.max(this.d, parambl.d);
      localArrayList.addAll((Collection)localObject1);
      parambl = ((ArrayList)localObject2).iterator();
    }
    label129:
    label228:
    for (;;)
    {
      if (!parambl.hasNext()) {
        break label230;
      }
      localObject1 = (ScanResult)parambl.next();
      localObject2 = ((ScanResult)localObject1).BSSID;
      Iterator localIterator = localbl.b.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((ScanResult)localIterator.next()).BSSID.equals(localObject2));
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label228;
        }
        localArrayList.add(localObject1);
        break label129;
        localObject2 = this.b;
        localObject1 = parambl.b;
        break;
      }
    }
    label230:
    return localbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bl
 * JD-Core Version:    0.7.0.1
 */