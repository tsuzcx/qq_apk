package androidx.camera.camera2.b;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build.VERSION;
import android.util.Rational;
import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.core.an;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.p.a;
import androidx.camera.core.impl.z.a;
import androidx.camera.core.k.a;
import androidx.camera.core.y;
import androidx.camera.core.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

final class ah
{
  private static final MeteringRectangle[] CV = new MeteringRectangle[0];
  int Am;
  final f By;
  volatile Rational CU;
  boolean CW;
  Integer CX;
  private ScheduledFuture<?> CY;
  long CZ;
  boolean Da;
  boolean Db;
  private f.c Dc;
  private f.c Dd;
  MeteringRectangle[] De;
  MeteringRectangle[] Df;
  MeteringRectangle[] Dg;
  b.a<z> Dh;
  b.a<Void> Di;
  final Executor mExecutor;
  volatile boolean mIsActive;
  private final ScheduledExecutorService mScheduler;
  
  ah(f paramf, ScheduledExecutorService paramScheduledExecutorService, Executor paramExecutor)
  {
    AppMethodBeat.i(197404);
    this.mIsActive = false;
    this.CU = null;
    this.CW = false;
    this.CX = Integer.valueOf(0);
    this.CZ = 0L;
    this.Da = false;
    this.Db = false;
    this.Am = 1;
    this.Dc = null;
    this.Dd = null;
    this.De = CV;
    this.Df = CV;
    this.Dg = CV;
    this.Dh = null;
    this.Di = null;
    this.By = paramf;
    this.mExecutor = paramExecutor;
    this.mScheduler = paramScheduledExecutorService;
    AppMethodBeat.o(197404);
  }
  
  private void D(String paramString)
  {
    AppMethodBeat.i(197452);
    this.By.a(this.Dc);
    if (this.Dh != null)
    {
      this.Dh.h(new k.a(paramString));
      this.Dh = null;
    }
    AppMethodBeat.o(197452);
  }
  
  private void E(String paramString)
  {
    AppMethodBeat.i(197457);
    this.By.a(this.Dd);
    if (this.Di != null)
    {
      this.Di.h(new k.a(paramString));
      this.Di = null;
    }
    AppMethodBeat.o(197457);
  }
  
  private static List<MeteringRectangle> a(List<an> paramList, int paramInt, Rational paramRational, Rect paramRect)
  {
    AppMethodBeat.i(197435);
    if ((paramList.isEmpty()) || (paramInt == 0))
    {
      paramList = Collections.emptyList();
      AppMethodBeat.o(197435);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Rational localRational = new Rational(paramRect.width(), paramRect.height());
    Iterator localIterator = paramList.iterator();
    an localan;
    int i;
    if (localIterator.hasNext())
    {
      localan = (an)localIterator.next();
      if (localArrayList.size() != paramInt) {
        if ((localan.Iv >= 0.0F) && (localan.Iv <= 1.0F) && (localan.Iw >= 0.0F) && (localan.Iw <= 1.0F))
        {
          i = 1;
          label139:
          if (i == 0) {
            break label468;
          }
          if (localan.Ix == null) {
            break label533;
          }
        }
      }
    }
    label533:
    for (paramList = localan.Ix;; paramList = paramRational)
    {
      PointF localPointF = new PointF(localan.Iv, localan.Iw);
      float f1;
      float f2;
      float f3;
      if (!paramList.equals(localRational))
      {
        if (paramList.compareTo(localRational) <= 0) {
          break label470;
        }
        f1 = (float)(paramList.doubleValue() / localRational.doubleValue());
        f2 = (float)((f1 - 1.0D) / 2.0D);
        f3 = localPointF.y;
        localPointF.y = (1.0F / f1 * (f2 + f3));
      }
      for (;;)
      {
        i = (int)(paramRect.left + localPointF.x * paramRect.width());
        f1 = paramRect.top;
        int j = (int)(localPointF.y * paramRect.height() + f1);
        int k = (int)(localan.mSize * paramRect.width());
        int m = (int)(localan.mSize * paramRect.height());
        paramList = new Rect(i - k / 2, j - m / 2, i + k / 2, m / 2 + j);
        paramList.left = c(paramList.left, paramRect.right, paramRect.left);
        paramList.right = c(paramList.right, paramRect.right, paramRect.left);
        paramList.top = c(paramList.top, paramRect.bottom, paramRect.top);
        paramList.bottom = c(paramList.bottom, paramRect.bottom, paramRect.top);
        paramList = new MeteringRectangle(paramList, 1000);
        if ((paramList.getWidth() == 0) || (paramList.getHeight() == 0)) {
          break;
        }
        localArrayList.add(paramList);
        break;
        i = 0;
        break label139;
        label468:
        break;
        label470:
        f1 = (float)(localRational.doubleValue() / paramList.doubleValue());
        f2 = (float)((f1 - 1.0D) / 2.0D);
        f3 = localPointF.x;
        localPointF.x = (1.0F / f1 * (f2 + f3));
      }
      paramList = Collections.unmodifiableList(localArrayList);
      AppMethodBeat.o(197435);
      return paramList;
    }
  }
  
  private static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197412);
    paramInt1 = Math.min(Math.max(paramInt1, paramInt3), paramInt2);
    AppMethodBeat.o(197412);
    return paramInt1;
  }
  
  private void ht()
  {
    AppMethodBeat.i(197442);
    if (this.CY != null)
    {
      this.CY.cancel(true);
      this.CY = null;
    }
    AppMethodBeat.o(197442);
  }
  
  private boolean hv()
  {
    return this.De.length > 0;
  }
  
  final com.google.b.b.a.f<z> a(y paramy)
  {
    AppMethodBeat.i(197539);
    paramy = b.a(new ah..ExternalSyntheticLambda0(this, paramy));
    AppMethodBeat.o(197539);
    return paramy;
  }
  
  final void ac(boolean paramBoolean)
  {
    AppMethodBeat.i(197548);
    if (!this.mIsActive)
    {
      AppMethodBeat.o(197548);
      return;
    }
    z.a locala = new z.a();
    locala.LW = this.Am;
    locala.LX = true;
    a.a locala1 = new a.a();
    locala1.a(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    if (paramBoolean) {
      locala1.a(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.By.aG(1)));
    }
    locala.j(locala1.fV());
    locala.b(new h()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(197421);
        if (this.val$completer != null) {
          this.val$completer.h(new p.a(paramAnonymousj));
        }
        AppMethodBeat.o(197421);
      }
      
      public final void a(l paramAnonymousl)
      {
        AppMethodBeat.i(197410);
        if (this.val$completer != null) {
          this.val$completer.ap(paramAnonymousl);
        }
        AppMethodBeat.o(197410);
      }
      
      public final void gB()
      {
        AppMethodBeat.i(197428);
        if (this.val$completer != null) {
          this.val$completer.h(new k.a("Camera is closed"));
        }
        AppMethodBeat.o(197428);
      }
    });
    this.By.i(Collections.singletonList(locala.kc()));
    AppMethodBeat.o(197548);
  }
  
  final void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197557);
    if (!this.mIsActive)
    {
      AppMethodBeat.o(197557);
      return;
    }
    z.a locala = new z.a();
    locala.LX = true;
    locala.LW = this.Am;
    a.a locala1 = new a.a();
    if (paramBoolean1) {
      locala1.a(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean2)) {
      locala1.a(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(2));
    }
    locala.j(locala1.fV());
    this.By.i(Collections.singletonList(locala.kc()));
    AppMethodBeat.o(197557);
  }
  
  final int hu()
  {
    switch (this.Am)
    {
    default: 
      return 4;
    }
    return 3;
  }
  
  final void hw()
  {
    AppMethodBeat.i(197576);
    E("Cancelled by another cancelFocusAndMetering()");
    D("Cancelled by cancelFocusAndMetering()");
    this.Di = null;
    ht();
    if (hv()) {
      e(true, false);
    }
    this.De = CV;
    this.Df = CV;
    this.Dg = CV;
    this.CW = false;
    long l = this.By.gw();
    if (this.Di != null)
    {
      this.Dd = new ah..ExternalSyntheticLambda1(this, this.By.aF(hu()), l);
      this.By.b(this.Dd);
    }
    AppMethodBeat.o(197576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ah
 * JD-Core Version:    0.7.0.1
 */