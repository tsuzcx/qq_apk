package com.tencent.matrix.a.a.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.c.a;

public final class e
  extends a
{
  public final b eQM = new b();
  c.a eQN;
  
  public final void awI()
  {
    super.awI();
    if (Build.VERSION.SDK_INT < 26) {
      com.tencent.matrix.e.c.w("Matrix.battery.BlueToothMonitorFeature", "only support >= android 8.0 for the moment", new Object[0]);
    }
    while ((!this.eNY.ePD.ePs) && ((this.eNY.ePD.ePt & 0x1) != 1)) {
      return;
    }
    this.eQN = new c.a()
    {
      public final void awT()
      {
        if (e.this.awK()) {}
        for (Object localObject = b.stackTraceToString(new Throwable().getStackTrace());; localObject = "")
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onRegisterScanner, stack = ".concat(String.valueOf(localObject)), new Object[0]);
          e.this.eQM.gs((String)localObject);
          localObject = e.this.eQM;
          ((e.b)localObject).eQT += 1;
          return;
        }
      }
      
      public final void awU()
      {
        if (e.this.awK()) {}
        for (String str = b.stackTraceToString(new Throwable().getStackTrace());; str = "")
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartDiscovery, stack = ".concat(String.valueOf(str)), new Object[0]);
          e.this.eQM.gs(str);
          e.this.eQM.awU();
          return;
        }
      }
      
      public final void awV()
      {
        com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartScanForIntent", new Object[0]);
        e.this.eQM.awW();
      }
      
      public final void mV(int paramAnonymousInt)
      {
        com.tencent.matrix.e.c.i("Matrix.battery.BlueToothMonitorFeature", "#onStartScan, id = ".concat(String.valueOf(paramAnonymousInt)), new Object[0]);
        e.this.eQM.awW();
      }
    };
    com.tencent.matrix.a.b.c.a(this.eQN);
  }
  
  public final void awJ()
  {
    super.awJ();
    com.tencent.matrix.a.b.c.b(this.eQN);
    b localb = this.eQM;
    localb.eQT = 0;
    localb.eQU = 0;
    localb.eQV = 0;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.BlueToothMonitorFeature";
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Integer> eQP;
    public m.a.c.b<Integer> eQQ;
    public m.a.c.b<Integer> eQR;
    public String stack;
  }
  
  public static final class b
  {
    int eQT;
    int eQU;
    int eQV;
    private String eQW = "";
    
    public final void awU()
    {
      this.eQU += 1;
    }
    
    public final void awW()
    {
      this.eQV += 1;
    }
    
    public final e.a awX()
    {
      e.a locala = new e.a();
      locala.eQP = m.a.c.b.c(Integer.valueOf(this.eQT));
      locala.eQQ = m.a.c.b.c(Integer.valueOf(this.eQU));
      locala.eQR = m.a.c.b.c(Integer.valueOf(this.eQV));
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
 * Qualified Name:     com.tencent.matrix.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */