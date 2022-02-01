package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.camera.camera2.b.a.n;
import androidx.camera.core.al;
import androidx.camera.core.ba;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.s;
import androidx.camera.core.r;
import androidx.camera.core.r.b;
import androidx.lifecycle.LiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class i
  implements s
{
  final String AW;
  private final n Au;
  final androidx.camera.camera2.b.a.h Bm;
  private final androidx.camera.camera2.c.b Bn;
  private f Bo;
  private i.a<Integer> Bp;
  private i.a<ba> Bq;
  final i.a<r> Br;
  private List<Pair<androidx.camera.core.impl.h, Executor>> Bs;
  final az Bt;
  private final g Bu;
  private final Object mLock;
  
  i(String paramString, n paramn)
  {
    AppMethodBeat.i(197554);
    this.mLock = new Object();
    this.Bp = null;
    this.Bq = null;
    this.Bs = null;
    this.AW = ((String)androidx.core.f.f.checkNotNull(paramString));
    this.Au = paramn;
    this.Bm = paramn.H(this.AW);
    this.Bn = new androidx.camera.camera2.c.b(this);
    this.Bt = androidx.camera.camera2.b.a.b.f.d(this.Bm);
    this.Bu = new d(paramString, this.Bm);
    this.Br = new i.a(r.a(r.b.Gy, null));
    AppMethodBeat.o(197554);
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(197566);
    synchronized (this.mLock)
    {
      this.Bo = paramf;
      if (this.Bq != null) {
        this.Bq.a(this.Bo.Aa.EL);
      }
      if (this.Bp != null) {
        this.Bp.a(this.Bo.Ab.EG);
      }
      if (this.Bs == null) {
        break label143;
      }
      paramf = this.Bs.iterator();
      if (paramf.hasNext())
      {
        Pair localPair = (Pair)paramf.next();
        this.Bo.a((Executor)localPair.second, (androidx.camera.core.impl.h)localPair.first);
      }
    }
    this.Bs = null;
    label143:
    int i = gX();
    switch (i)
    {
    default: 
      paramf = "Unknown value: ".concat(String.valueOf(i));
    }
    for (;;)
    {
      "Device Level: ".concat(String.valueOf(paramf));
      al.Q("Camera2CameraInfo");
      AppMethodBeat.o(197566);
      return;
      paramf = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
      continue;
      paramf = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
      continue;
      paramf = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
      continue;
      paramf = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
      continue;
      paramf = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
    }
  }
  
  public final int aI(int paramInt)
  {
    AppMethodBeat.i(197588);
    Integer localInteger = (Integer)this.Bm.a(CameraCharacteristics.SENSOR_ORIENTATION);
    androidx.core.f.f.checkNotNull(localInteger);
    int i = localInteger.intValue();
    paramInt = androidx.camera.core.impl.a.b.aY(paramInt);
    localInteger = gW();
    if ((localInteger != null) && (1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = androidx.camera.core.impl.a.b.c(paramInt, Integer.valueOf(i).intValue(), bool);
      AppMethodBeat.o(197588);
      return paramInt;
    }
  }
  
  public final String gV()
  {
    return this.AW;
  }
  
  public final Integer gW()
  {
    AppMethodBeat.i(197580);
    Integer localInteger = (Integer)this.Bm.a(CameraCharacteristics.LENS_FACING);
    androidx.core.f.f.checkNotNull(localInteger);
    switch (localInteger.intValue())
    {
    default: 
      AppMethodBeat.o(197580);
      return null;
    case 0: 
      AppMethodBeat.o(197580);
      return Integer.valueOf(0);
    }
    AppMethodBeat.o(197580);
    return Integer.valueOf(1);
  }
  
  final int gX()
  {
    AppMethodBeat.i(197594);
    Integer localInteger = (Integer)this.Bm.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    androidx.core.f.f.checkNotNull(localInteger);
    int i = localInteger.intValue();
    AppMethodBeat.o(197594);
    return i;
  }
  
  public final int gY()
  {
    AppMethodBeat.i(197599);
    int i = aI(0);
    AppMethodBeat.o(197599);
    return i;
  }
  
  public final LiveData<ba> gZ()
  {
    AppMethodBeat.i(197609);
    synchronized (this.mLock)
    {
      if (this.Bo == null)
      {
        if (this.Bq == null)
        {
          localObject2 = as.a(this.Bm);
          localObject2 = new at(((as.a)localObject2).getMaxZoom(), ((as.a)localObject2).getMinZoom());
          ((at)localObject2).i(1.0F);
          this.Bq = new i.a(androidx.camera.core.a.d.b((ba)localObject2));
        }
        localObject2 = this.Bq;
        AppMethodBeat.o(197609);
        return localObject2;
      }
      if (this.Bq != null)
      {
        localObject2 = this.Bq;
        AppMethodBeat.o(197609);
        return localObject2;
      }
      Object localObject2 = this.Bo.Aa.EL;
      AppMethodBeat.o(197609);
      return localObject2;
    }
  }
  
  public final LiveData<r> ha()
  {
    return this.Br;
  }
  
  public final az hb()
  {
    return this.Bt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.i
 * JD-Core Version:    0.7.0.1
 */