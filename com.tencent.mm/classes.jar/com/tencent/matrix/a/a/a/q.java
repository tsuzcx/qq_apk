package com.tencent.matrix.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.p;
import com.tencent.matrix.a.b.p.a;

public final class q
  extends a
{
  public final b eTm = new b();
  p.a eTn;
  
  public final void awI()
  {
    super.awI();
    if (this.eNY.ePD.ePs)
    {
      this.eTn = new p.a()
      {
        public final void awW()
        {
          if (q.this.awK()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.WifiMonitorFeature", "#onStartScan, stack = ".concat(String.valueOf(str)), new Object[0]);
            q.this.eTm.gs(str);
            q.this.eTm.awW();
            return;
          }
        }
        
        public final void axn()
        {
          if (q.this.awK()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.WifiMonitorFeature", "#onGetScanResults, stack = ".concat(String.valueOf(str)), new Object[0]);
            q.this.eTm.gs(str);
            q.this.eTm.axn();
            return;
          }
        }
      };
      p.a(this.eTn);
    }
  }
  
  public final void awJ()
  {
    super.awJ();
    p.b(this.eTn);
    b localb = this.eTm;
    localb.eQV = 0;
    localb.eTr = 0;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.WifiMonitorFeature";
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Integer> eQR;
    public m.a.c.b<Integer> eTp;
    public String stack;
  }
  
  public static final class b
  {
    int eQV;
    private String eQW = "";
    int eTr;
    
    public final void awW()
    {
      this.eQV += 1;
    }
    
    public final void axn()
    {
      this.eTr += 1;
    }
    
    public final q.a axo()
    {
      q.a locala = new q.a();
      locala.eQR = m.a.c.b.c(Integer.valueOf(this.eQV));
      locala.eTp = m.a.c.b.c(Integer.valueOf(this.eTr));
      locala.stack = this.eQW;
      return locala;
    }
    
    public final void gs(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.eQW = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */