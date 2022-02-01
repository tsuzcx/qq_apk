package com.tencent.matrix.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.l;
import com.tencent.matrix.a.b.l.a;

public final class n
  extends a
{
  public final b cXf = new b();
  l.a cXg;
  
  public final void VZ()
  {
    super.VZ();
    if (this.cSI.cUb.cTQ)
    {
      this.cXg = new l.a()
      {
        public final void Wo()
        {
          if (n.this.Wb()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.WifiMonitorFeature", "#onStartScan, stack = ".concat(String.valueOf(str)), new Object[0]);
            n.this.cXf.eU(str);
            n.this.cXf.Wo();
            return;
          }
        }
        
        public final void Wy()
        {
          if (n.this.Wb()) {}
          for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
          {
            com.tencent.matrix.e.c.i("Matrix.battery.WifiMonitorFeature", "#onGetScanResults, stack = ".concat(String.valueOf(str)), new Object[0]);
            n.this.cXf.eU(str);
            n.this.cXf.Wy();
            return;
          }
        }
      };
      l.a(this.cXg);
    }
  }
  
  public final void Wa()
  {
    super.Wa();
    l.b(this.cXg);
    b localb = this.cXf;
    localb.cVu = 0;
    localb.cXk = 0;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  public final b Wx()
  {
    return this.cXf;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.WifiMonitorFeature";
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Integer> cVq;
    public j.a.c.b<Integer> cXi;
    public String stack;
  }
  
  public static final class b
  {
    int cVu;
    private String cVv = "";
    int cXk;
    
    public final void Wo()
    {
      this.cVu += 1;
    }
    
    public final void Wy()
    {
      this.cXk += 1;
    }
    
    public final n.a Wz()
    {
      n.a locala = new n.a();
      locala.cVq = j.a.c.b.c(Integer.valueOf(this.cVu));
      locala.cXi = j.a.c.b.c(Integer.valueOf(this.cXk));
      locala.stack = this.cVv;
      return locala;
    }
    
    public final void eU(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.cVv = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */