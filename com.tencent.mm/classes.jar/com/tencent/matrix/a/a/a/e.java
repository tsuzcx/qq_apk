package com.tencent.matrix.a.a.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.c.a;

public final class e
  extends a
{
  public final b cVl = new b();
  c.a cVm;
  
  public final void VZ()
  {
    super.VZ();
    if (Build.VERSION.SDK_INT < 26) {
      com.tencent.matrix.e.c.w("Matrix.battery.BlueToothMonitorFeature", "only support >= android 8.0 for the moment", new Object[0]);
    }
    while ((!this.cSI.cUb.cTQ) && ((this.cSI.cUb.cTR & 0x1) != 1)) {
      return;
    }
    this.cVm = new c.a()
    {
      public final void Wl()
      {
        if (e.this.Wb()) {}
        for (Object localObject = b.stackTraceToString(new Throwable().getStackTrace());; localObject = "")
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onRegisterScanner, stack = ".concat(String.valueOf(localObject)), new Object[0]);
          e.this.cVl.eU((String)localObject);
          localObject = e.this.cVl;
          ((e.b)localObject).cVs += 1;
          return;
        }
      }
      
      public final void Wm()
      {
        if (e.this.Wb()) {}
        for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartDiscovery, stack = ".concat(String.valueOf(str)), new Object[0]);
          e.this.cVl.eU(str);
          e.this.cVl.Wm();
          return;
        }
      }
      
      public final void Wn()
      {
        com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartScanForIntent", new Object[0]);
        e.this.cVl.Wo();
      }
      
      public final void jt(int paramAnonymousInt)
      {
        com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartScan, id = ".concat(String.valueOf(paramAnonymousInt)), new Object[0]);
        e.this.cVl.Wo();
      }
    };
    com.tencent.matrix.a.b.c.a(this.cVm);
  }
  
  public final void Wa()
  {
    super.Wa();
    com.tencent.matrix.a.b.c.b(this.cVm);
    b localb = this.cVl;
    localb.cVs = 0;
    localb.cVt = 0;
    localb.cVu = 0;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  public final b Wk()
  {
    return this.cVl;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.BlueToothMonitorFeature";
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Integer> cVo;
    public j.a.c.b<Integer> cVp;
    public j.a.c.b<Integer> cVq;
    public String stack;
  }
  
  public static final class b
  {
    int cVs;
    int cVt;
    int cVu;
    private String cVv = "";
    
    public final void Wm()
    {
      this.cVt += 1;
    }
    
    public final void Wo()
    {
      this.cVu += 1;
    }
    
    public final e.a Wp()
    {
      e.a locala = new e.a();
      locala.cVo = j.a.c.b.c(Integer.valueOf(this.cVs));
      locala.cVp = j.a.c.b.c(Integer.valueOf(this.cVt));
      locala.cVq = j.a.c.b.c(Integer.valueOf(this.cVu));
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
 * Qualified Name:     com.tencent.matrix.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */