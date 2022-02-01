package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.c.a.b.a;
import androidx.camera.core.ae;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.b.d;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.k.a;
import androidx.camera.core.impl.k.b;
import androidx.camera.core.impl.k.c;
import androidx.camera.core.impl.k.d;
import androidx.camera.core.impl.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class l
{
  int Am;
  final az BA;
  final boolean BB;
  final f By;
  final androidx.camera.camera2.b.a.c.l Bz;
  final Executor mExecutor;
  
  l(f paramf, androidx.camera.camera2.b.a.h paramh, az paramaz, Executor paramExecutor)
  {
    AppMethodBeat.i(197596);
    this.Am = 1;
    this.By = paramf;
    paramf = (Integer)paramh.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if ((paramf != null) && (paramf.intValue() == 2)) {}
    for (boolean bool = true;; bool = false)
    {
      this.BB = bool;
      this.mExecutor = paramExecutor;
      this.BA = paramaz;
      this.Bz = new androidx.camera.camera2.b.a.c.l(paramaz);
      AppMethodBeat.o(197596);
      return;
    }
  }
  
  static boolean a(int paramInt, TotalCaptureResult paramTotalCaptureResult)
  {
    AppMethodBeat.i(197613);
    switch (paramInt)
    {
    default: 
      paramTotalCaptureResult = new AssertionError(paramInt);
      AppMethodBeat.o(197613);
      throw paramTotalCaptureResult;
    case 1: 
      AppMethodBeat.o(197613);
      return true;
    case 0: 
      if (paramTotalCaptureResult != null) {}
      for (paramTotalCaptureResult = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AE_STATE); (paramTotalCaptureResult != null) && (paramTotalCaptureResult.intValue() == 4); paramTotalCaptureResult = null)
      {
        AppMethodBeat.o(197613);
        return true;
      }
      AppMethodBeat.o(197613);
      return false;
    }
    AppMethodBeat.o(197613);
    return false;
  }
  
  static final class a
    implements l.d
  {
    private final int Ah;
    private final androidx.camera.camera2.b.a.c.h BC;
    private boolean BD = false;
    private final f By;
    
    a(f paramf, int paramInt, androidx.camera.camera2.b.a.c.h paramh)
    {
      this.By = paramf;
      this.Ah = paramInt;
      this.BC = paramh;
    }
    
    public final com.google.b.b.a.f<Boolean> c(TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197373);
      if (l.a(this.Ah, paramTotalCaptureResult))
      {
        al.O("Camera2CapturePipeline");
        this.BD = true;
        paramTotalCaptureResult = d.c(androidx.c.a.b.a(new l.a..ExternalSyntheticLambda1(this))).a(l.a..ExternalSyntheticLambda0.INSTANCE, androidx.camera.core.impl.a.a.b.kP());
        AppMethodBeat.o(197373);
        return paramTotalCaptureResult;
      }
      paramTotalCaptureResult = androidx.camera.core.impl.a.b.e.v(Boolean.FALSE);
      AppMethodBeat.o(197373);
      return paramTotalCaptureResult;
    }
    
    public final boolean hc()
    {
      return this.Ah == 0;
    }
    
    public final void hd()
    {
      AppMethodBeat.i(197387);
      if (this.BD)
      {
        al.O("Camera2CapturePipeline");
        this.By.zZ.e(false, true);
        this.BC.FW = false;
      }
      AppMethodBeat.o(197387);
    }
  }
  
  static final class b
    implements l.d
  {
    private boolean BD = false;
    private final f By;
    
    b(f paramf)
    {
      this.By = paramf;
    }
    
    public final com.google.b.b.a.f<Boolean> c(TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197353);
      com.google.b.b.a.f localf = androidx.camera.core.impl.a.b.e.v(Boolean.TRUE);
      if (paramTotalCaptureResult == null)
      {
        AppMethodBeat.o(197353);
        return localf;
      }
      Integer localInteger = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
      if (localInteger == null)
      {
        AppMethodBeat.o(197353);
        return localf;
      }
      switch (localInteger.intValue())
      {
      }
      do
      {
        AppMethodBeat.o(197353);
        return localf;
        al.O("Camera2CapturePipeline");
        paramTotalCaptureResult = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      } while ((paramTotalCaptureResult == null) || (paramTotalCaptureResult.intValue() != 0));
      al.O("Camera2CapturePipeline");
      this.BD = true;
      this.By.zZ.ac(false);
      AppMethodBeat.o(197353);
      return localf;
    }
    
    public final boolean hc()
    {
      return true;
    }
    
    public final void hd()
    {
      AppMethodBeat.i(197366);
      if (this.BD)
      {
        al.O("Camera2CapturePipeline");
        this.By.zZ.e(true, false);
      }
      AppMethodBeat.o(197366);
    }
  }
  
  static final class c
  {
    private static final long BF;
    private static final long BG;
    private final int Am;
    private final boolean BB;
    private final androidx.camera.camera2.b.a.c.h BC;
    private long BH;
    final List<l.d> BI;
    private final l.d BJ;
    private final f By;
    private final Executor mExecutor;
    
    static
    {
      AppMethodBeat.i(197454);
      BF = TimeUnit.SECONDS.toNanos(1L);
      BG = TimeUnit.SECONDS.toNanos(5L);
      AppMethodBeat.o(197454);
    }
    
    c(int paramInt, Executor paramExecutor, f paramf, boolean paramBoolean, androidx.camera.camera2.b.a.c.h paramh)
    {
      AppMethodBeat.i(197380);
      this.BH = BF;
      this.BI = new ArrayList();
      this.BJ = new l.d()
      {
        public final com.google.b.b.a.f<Boolean> c(TotalCaptureResult paramAnonymousTotalCaptureResult)
        {
          AppMethodBeat.i(197696);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = l.c.this.BI.iterator();
          while (localIterator.hasNext()) {
            localArrayList.add(((l.d)localIterator.next()).c(paramAnonymousTotalCaptureResult));
          }
          paramAnonymousTotalCaptureResult = androidx.camera.core.impl.a.b.e.a(androidx.camera.core.impl.a.b.e.j(localArrayList), l.c.1..ExternalSyntheticLambda0.INSTANCE, androidx.camera.core.impl.a.a.b.kP());
          AppMethodBeat.o(197696);
          return paramAnonymousTotalCaptureResult;
        }
        
        public final boolean hc()
        {
          AppMethodBeat.i(197702);
          Iterator localIterator = l.c.this.BI.iterator();
          while (localIterator.hasNext()) {
            if (((l.d)localIterator.next()).hc())
            {
              AppMethodBeat.o(197702);
              return true;
            }
          }
          AppMethodBeat.o(197702);
          return false;
        }
        
        public final void hd()
        {
          AppMethodBeat.i(197708);
          Iterator localIterator = l.c.this.BI.iterator();
          while (localIterator.hasNext()) {
            ((l.d)localIterator.next()).hd();
          }
          AppMethodBeat.o(197708);
        }
      };
      this.Am = paramInt;
      this.mExecutor = paramExecutor;
      this.By = paramf;
      this.BB = paramBoolean;
      this.BC = paramh;
      AppMethodBeat.o(197380);
    }
    
    private com.google.b.b.a.f<TotalCaptureResult> a(long paramLong, l.e.a parama)
    {
      AppMethodBeat.i(197389);
      parama = new l.e(paramLong, parama);
      this.By.b(parama);
      parama = parama.BM;
      AppMethodBeat.o(197389);
      return parama;
    }
    
    private boolean d(TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197396);
      if (paramTotalCaptureResult == null)
      {
        AppMethodBeat.o(197396);
        return false;
      }
      paramTotalCaptureResult = new e(paramTotalCaptureResult);
      int i;
      int j;
      if ((paramTotalCaptureResult.gj() == k.b.KT) || (paramTotalCaptureResult.gj() == k.b.KS) || (paramTotalCaptureResult.gk() == k.c.La) || (paramTotalCaptureResult.gk() == k.c.Lb) || (paramTotalCaptureResult.gk() == k.c.Lc) || (paramTotalCaptureResult.gk() == k.c.Ld))
      {
        i = 1;
        if ((paramTotalCaptureResult.gl() != k.a.KP) && (paramTotalCaptureResult.gl() != k.a.KO) && (paramTotalCaptureResult.gl() != k.a.KL)) {
          break label220;
        }
        j = 1;
        label121:
        if ((paramTotalCaptureResult.gm() != k.d.Li) && (paramTotalCaptureResult.gm() != k.d.Lf)) {
          break label225;
        }
      }
      label220:
      label225:
      for (int k = 1;; k = 0)
      {
        new StringBuilder("checkCaptureResult, AE=").append(paramTotalCaptureResult.gl()).append(" AF =").append(paramTotalCaptureResult.gk()).append(" AWB=").append(paramTotalCaptureResult.gm());
        al.O("Camera2CapturePipeline");
        if ((i == 0) || (j == 0) || (k == 0)) {
          break label231;
        }
        AppMethodBeat.o(197396);
        return true;
        i = 0;
        break;
        j = 0;
        break label121;
      }
      label231:
      AppMethodBeat.o(197396);
      return false;
    }
    
    final void a(l.d paramd)
    {
      AppMethodBeat.i(197492);
      this.BI.add(paramd);
      AppMethodBeat.o(197492);
    }
    
    final com.google.b.b.a.f<List<Void>> c(List<z> paramList, int paramInt)
    {
      AppMethodBeat.i(197498);
      Object localObject = androidx.camera.core.impl.a.b.e.v(null);
      if (!this.BI.isEmpty()) {
        if (!this.BJ.hc()) {
          break label126;
        }
      }
      label126:
      for (localObject = a(0L, null);; localObject = androidx.camera.core.impl.a.b.e.v(null))
      {
        localObject = d.c((com.google.b.b.a.f)localObject).a(new l.c..ExternalSyntheticLambda3(this, paramInt), this.mExecutor).a(new l.c..ExternalSyntheticLambda2(this), this.mExecutor);
        paramList = d.c((com.google.b.b.a.f)localObject).a(new l.c..ExternalSyntheticLambda4(this, paramList, paramInt), this.mExecutor);
        paramList.a(new l.c..ExternalSyntheticLambda5(this), this.mExecutor);
        AppMethodBeat.o(197498);
        return paramList;
      }
    }
  }
  
  static abstract interface d
  {
    public abstract com.google.b.b.a.f<Boolean> c(TotalCaptureResult paramTotalCaptureResult);
    
    public abstract boolean hc();
    
    public abstract void hd();
  }
  
  static final class e
    implements f.c
  {
    private b.a<TotalCaptureResult> BL;
    final com.google.b.b.a.f<TotalCaptureResult> BM;
    private final long BN;
    private final a BO;
    private volatile Long BP;
    
    e(long paramLong, a parama)
    {
      AppMethodBeat.i(197378);
      this.BM = androidx.c.a.b.a(new l.e..ExternalSyntheticLambda0(this));
      this.BP = null;
      this.BN = paramLong;
      this.BO = parama;
      AppMethodBeat.o(197378);
    }
    
    public final boolean onCaptureResult(TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197397);
      Long localLong1 = (Long)paramTotalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
      if ((localLong1 != null) && (this.BP == null)) {
        this.BP = localLong1;
      }
      Long localLong2 = this.BP;
      if ((0L != this.BN) && (localLong2 != null) && (localLong1 != null) && (localLong1.longValue() - localLong2.longValue() > this.BN))
      {
        this.BL.ap(null);
        new StringBuilder("Wait for capture result timeout, current:").append(localLong1).append(" first: ").append(localLong2);
        al.O("Camera2CapturePipeline");
        AppMethodBeat.o(197397);
        return true;
      }
      if ((this.BO != null) && (!this.BO.check(paramTotalCaptureResult)))
      {
        AppMethodBeat.o(197397);
        return false;
      }
      this.BL.ap(paramTotalCaptureResult);
      AppMethodBeat.o(197397);
      return true;
    }
    
    static abstract interface a
    {
      public abstract boolean check(TotalCaptureResult paramTotalCaptureResult);
    }
  }
  
  static final class f
    implements l.d
  {
    private final int Ah;
    private boolean BD = false;
    private final f By;
    
    f(f paramf, int paramInt)
    {
      this.By = paramf;
      this.Ah = paramInt;
    }
    
    public final com.google.b.b.a.f<Boolean> c(TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197426);
      if (l.a(this.Ah, paramTotalCaptureResult))
      {
        if (this.By.Ag) {
          al.O("Camera2CapturePipeline");
        }
      }
      else
      {
        paramTotalCaptureResult = androidx.camera.core.impl.a.b.e.v(Boolean.FALSE);
        AppMethodBeat.o(197426);
        return paramTotalCaptureResult;
      }
      al.O("Camera2CapturePipeline");
      this.BD = true;
      paramTotalCaptureResult = d.c(androidx.c.a.b.a(new l.f..ExternalSyntheticLambda1(this))).a(l.f..ExternalSyntheticLambda0.INSTANCE, androidx.camera.core.impl.a.a.b.kP());
      AppMethodBeat.o(197426);
      return paramTotalCaptureResult;
    }
    
    public final boolean hc()
    {
      return this.Ah == 0;
    }
    
    public final void hd()
    {
      AppMethodBeat.i(197441);
      if (this.BD)
      {
        this.By.Ab.a(null, false);
        al.O("Camera2CapturePipeline");
      }
      AppMethodBeat.o(197441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.l
 * JD-Core Version:    0.7.0.1
 */