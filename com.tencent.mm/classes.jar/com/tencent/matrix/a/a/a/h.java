package com.tencent.matrix.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.e.a;

public final class h
  extends a
{
  public final b cWa = new b();
  e.a cWb;
  
  public final void VZ()
  {
    super.VZ();
    if (this.cSI.cUb.cTQ)
    {
      this.cWb = new e.a()
      {
        public final void a(long paramAnonymousLong, float paramAnonymousFloat)
        {
          if (h.this.Wb()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.LocationMonitorFeature", "#onRequestLocationUpdates, time = " + paramAnonymousLong + ", distance = " + paramAnonymousFloat + ", stack = " + str, new Object[0]);
            h.b localb = h.this.cWa;
            if (!TextUtils.isEmpty(str)) {
              localb.cVv = str;
            }
            h.this.cWa.Wo();
            return;
          }
        }
      };
      e.a(this.cWb);
    }
  }
  
  public final void Wa()
  {
    super.Wa();
    e.b(this.cWb);
    this.cWa.cVu = 0;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.LocationMonitorFeature";
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Integer> cVq;
    public String stack;
  }
  
  public static final class b
  {
    int cVu;
    String cVv = "";
    
    public final void Wo()
    {
      this.cVu += 1;
    }
    
    public final h.a Ws()
    {
      h.a locala = new h.a();
      locala.cVq = j.a.c.b.c(Integer.valueOf(this.cVu));
      locala.stack = this.cVv;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */