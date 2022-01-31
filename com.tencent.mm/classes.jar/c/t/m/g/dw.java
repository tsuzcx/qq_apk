package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class dw
{
  private int a = 10;
  private int b = 4;
  private LinkedList<dw.a> c = new LinkedList();
  private dm d = new dm();
  
  private boolean a(dw.a parama, dg paramdg, boolean paramBoolean)
  {
    if (paramdg != null) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        if (this.c != null)
        {
          i = this.c.size();
          if (i != 0) {}
        }
        else
        {
          paramBoolean = true;
          return paramBoolean;
        }
        if (parama.d == 3)
        {
          paramBoolean = true;
          continue;
        }
        if ((parama.d == 1) && (!es.a(paramdg)) && (!es.b(paramdg)) && (!paramBoolean))
        {
          paramBoolean = true;
          continue;
        }
        if (parama.c - ((dw.a)this.c.getLast()).c > 120000L)
        {
          this.c.clear();
          paramBoolean = true;
          continue;
        }
        if (this.c.size() >= this.b)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          i = 0;
          paramdg = this.c.listIterator(this.c.size());
          int j = 0;
          if (!paramdg.hasPrevious()) {
            break label284;
          }
          dw.a locala = (dw.a)paramdg.previous();
          if (j.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D) > 100.0D)
          {
            k = 0;
            break label293;
            j += 1;
            k = this.b;
            if (j <= k) {
              break label287;
            }
            if (i <= 1) {
              continue;
            }
            paramBoolean = false;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = 1;
        break label293;
        paramBoolean = true;
        continue;
        continue;
      }
      finally {}
      label284:
      label287:
      continue;
      label293:
      do
      {
        break;
      } while (k != 0);
      i += 1;
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      this.d.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(em paramem)
  {
    label1278:
    for (;;)
    {
      dm localdm;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (paramem.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = de.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localdm = this.d;
        d2 = paramem.getLatitude();
        d3 = paramem.getLongitude();
        d1 = paramem.getAccuracy();
        l3 = paramem.getTime();
        if (d1 >= 1.0D) {
          break label1278;
        }
        d1 = 1.0D;
        j.a("a", 6, "lat_me:" + d2 + ",lng_me:" + d3 + ",accuracy:" + d1 + ",time:" + l3 + ",lat:" + localdm.d + ",lng:" + localdm.e);
        if (l3 - localdm.c >= 20000L)
        {
          localdm.a();
          j.a("a", 6, "Time:" + l3 + ",last_time:" + localdm.c);
        }
        localdm.a = ((float)(Math.abs(d2 - localdm.d) * 1000000.0D));
        localdm.b = ((float)(Math.abs(d3 - localdm.e) * 1000000.0D));
        j.a("a", 6, "Q:" + localdm.a + ",QLng:" + localdm.b);
        if (localdm.f < 0.0D)
        {
          localdm.c = l3;
          localdm.d = d2;
          localdm.e = d3;
          localdm.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          paramem.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          paramem.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localdm.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdm.f += l1;
        localdm.g += l1;
      }
      double d4 = localdm.f / (localdm.f + d1 * d1 + localdm.a * 5.0F);
      double d5 = localdm.g / (localdm.g + d1 * d1 + localdm.b * 5.0F);
      j.a("a", 6, "K:" + d4 + ",KLng:" + d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdm.d;
        if (((localdm.h > 0.0D) && (d2 - localdm.d > 0.0D)) || ((localdm.h < 0.0D) && (d2 - localdm.d < 0.0D))) {
          localdm.d += localdm.h * (l1 / 1000L);
        }
        localdm.d += (d2 - localdm.d) * d4;
        j.a("a", 6, "lat:" + localdm.d + ",tmp:" + d6 + ",timeInc:" + l1);
        localdm.h = ((localdm.d - d6) / (l1 / 1000L));
        d6 = localdm.e;
        if (((localdm.i > 0.0D) && (d3 - localdm.e > 0.0D)) || ((localdm.i < 0.0D) && (d3 - localdm.e < 0.0D))) {
          localdm.e += localdm.i * (l1 / 1000L);
        }
        localdm.e += (d3 - localdm.e) * d5;
        j.a("a", 6, "lng:" + localdm.e + ",tmp:" + d6 + ",timeInc:" + l1);
        localdm.i = ((localdm.e - d6) / (l1 / 1000L));
        localdm.f = ((1.0D - d4) * localdm.f);
        localdm.g = ((1.0D - d5) * localdm.g);
        localdm.c = l3;
        j.a("a", 6, "last_metres_per_second:" + localdm.h + ",last_metres_per_second_lng:" + localdm.i);
      }
      for (;;)
      {
        j.a("a", 6, "variance:" + localdm.f + ",vaLng:" + localdm.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdm.d = d2;
        localdm.e = d3;
        localdm.h = 0.0D;
        localdm.i = 0.0D;
        localdm.c = l3;
        localdm.f = (d1 * d1);
        break;
        if (((localdm.h > 0.0D) && (d2 - localdm.d > 0.0D)) || ((localdm.h < 0.0D) && (d2 - localdm.d < 0.0D))) {
          localdm.d += localdm.h * (l1 / 1000L);
        }
        if (((localdm.i > 0.0D) && (d3 - localdm.e > 0.0D)) || ((localdm.i < 0.0D) && (d3 - localdm.e < 0.0D))) {
          localdm.e += localdm.i * (l1 / 1000L);
        }
        localdm.f -= l1;
        localdm.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(dw.a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final boolean a(TencentLocation paramTencentLocation, dg paramdg, boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(dw.a.a(paramTencentLocation), paramdg, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.dw
 * JD-Core Version:    0.7.0.1
 */