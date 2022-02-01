package com.tencent.matrix.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.g;
import com.tencent.matrix.a.b.g.a;

public final class k
  extends a
{
  public final b eRU = new b();
  g.a eRV;
  
  public final void awI()
  {
    super.awI();
    if (this.eNY.ePD.ePs)
    {
      this.eRV = new g.a()
      {
        public final void j(long paramAnonymousLong, float paramAnonymousFloat)
        {
          if (k.this.awK()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.LocationMonitorFeature", "#onRequestLocationUpdates, time = " + paramAnonymousLong + ", distance = " + paramAnonymousFloat + ", stack = " + str, new Object[0]);
            k.b localb = k.this.eRU;
            if (!TextUtils.isEmpty(str)) {
              localb.eQW = str;
            }
            k.this.eRU.awW();
            return;
          }
        }
      };
      g.a(this.eRV);
    }
  }
  
  public final void awJ()
  {
    super.awJ();
    g.b(this.eRV);
    this.eRU.eQV = 0;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.LocationMonitorFeature";
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Integer> eQR;
    public String stack;
  }
  
  public static final class b
  {
    int eQV;
    String eQW = "";
    
    public final void awW()
    {
      this.eQV += 1;
    }
    
    public final k.a axi()
    {
      k.a locala = new k.a();
      locala.eQR = m.a.c.b.c(Integer.valueOf(this.eQV));
      locala.stack = this.eQW;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */