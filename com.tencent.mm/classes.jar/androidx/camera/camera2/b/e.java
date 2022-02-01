package androidx.camera.camera2.b;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build.VERSION;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.g.a;
import androidx.camera.core.impl.a.g.b;
import androidx.camera.core.impl.a.j;
import androidx.camera.core.impl.bi;
import androidx.camera.core.impl.k.a;
import androidx.camera.core.impl.k.b;
import androidx.camera.core.impl.k.c;
import androidx.camera.core.impl.k.d;
import androidx.camera.core.impl.k.e;
import androidx.camera.core.impl.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class e
  extends l.a
{
  private final bi zU;
  private final CaptureResult zV;
  
  public e(CaptureResult paramCaptureResult)
  {
    this(bi.kA(), paramCaptureResult);
    AppMethodBeat.i(197542);
    AppMethodBeat.o(197542);
  }
  
  public e(bi parambi, CaptureResult paramCaptureResult)
  {
    this.zU = parambi;
    this.zV = paramCaptureResult;
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(197606);
    super.a(parama);
    Object localObject = (Rect)this.zV.get(CaptureResult.SCALER_CROP_REGION);
    if (localObject != null) {
      parama.bc(((Rect)localObject).width()).bd(((Rect)localObject).height());
    }
    localObject = (Integer)this.zV.get(CaptureResult.JPEG_ORIENTATION);
    if (localObject != null) {
      parama.be(((Integer)localObject).intValue());
    }
    localObject = (Long)this.zV.get(CaptureResult.SENSOR_EXPOSURE_TIME);
    if (localObject != null) {
      parama.l("ExposureTime", String.valueOf(((Long)localObject).longValue() / TimeUnit.SECONDS.toNanos(1L)));
    }
    localObject = (Float)this.zV.get(CaptureResult.LENS_APERTURE);
    if (localObject != null) {
      parama.l("FNumber", String.valueOf(((Float)localObject).floatValue()));
    }
    Integer localInteger1 = (Integer)this.zV.get(CaptureResult.SENSOR_SENSITIVITY);
    if (localInteger1 != null)
    {
      localObject = localInteger1;
      if (Build.VERSION.SDK_INT >= 24)
      {
        Integer localInteger2 = (Integer)this.zV.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
        localObject = localInteger1;
        if (localInteger2 != null) {
          localObject = Integer.valueOf(localInteger1.intValue() * (int)(localInteger2.intValue() / 100.0F));
        }
      }
      int i = ((Integer)localObject).intValue();
      parama.l("SensitivityType", "3").l("PhotographicSensitivity", String.valueOf(Math.min(65535, i)));
    }
    localObject = (Float)this.zV.get(CaptureResult.LENS_FOCAL_LENGTH);
    if (localObject != null) {
      parama.l("FocalLength", new j((((Float)localObject).floatValue() * 1000.0F), 1000L).toString());
    }
    localInteger1 = (Integer)this.zV.get(CaptureResult.CONTROL_AWB_MODE);
    if (localInteger1 != null)
    {
      localObject = g.b.OI;
      if (localInteger1.intValue() != 0) {
        break label388;
      }
      localObject = g.b.OJ;
    }
    label388:
    for (;;)
    {
      switch (androidx.camera.core.impl.a.g.1.OA[localObject.ordinal()])
      {
      default: 
        localObject = null;
      }
      for (;;)
      {
        parama.l("WhiteBalance", (String)localObject);
        AppMethodBeat.o(197606);
        return;
        localObject = "0";
        continue;
        localObject = "1";
      }
    }
  }
  
  public final long getTimestamp()
  {
    AppMethodBeat.i(197586);
    Long localLong = (Long)this.zV.get(CaptureResult.SENSOR_TIMESTAMP);
    if (localLong == null)
    {
      AppMethodBeat.o(197586);
      return -1L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(197586);
    return l;
  }
  
  public final k.b gj()
  {
    AppMethodBeat.i(197547);
    Object localObject = (Integer)this.zV.get(CaptureResult.CONTROL_AF_MODE);
    if (localObject == null)
    {
      localObject = k.b.KS;
      AppMethodBeat.o(197547);
      return localObject;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      "Undefined af mode: ".concat(String.valueOf(localObject));
      al.T("C2CameraCaptureResult");
      localObject = k.b.KS;
      AppMethodBeat.o(197547);
      return localObject;
    case 0: 
    case 5: 
      localObject = k.b.KT;
      AppMethodBeat.o(197547);
      return localObject;
    case 1: 
    case 2: 
      localObject = k.b.KU;
      AppMethodBeat.o(197547);
      return localObject;
    }
    localObject = k.b.KV;
    AppMethodBeat.o(197547);
    return localObject;
  }
  
  public final k.c gk()
  {
    AppMethodBeat.i(197555);
    Object localObject = (Integer)this.zV.get(CaptureResult.CONTROL_AF_STATE);
    if (localObject == null)
    {
      localObject = k.c.KX;
      AppMethodBeat.o(197555);
      return localObject;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      "Undefined af state: ".concat(String.valueOf(localObject));
      al.T("C2CameraCaptureResult");
      localObject = k.c.KX;
      AppMethodBeat.o(197555);
      return localObject;
    case 0: 
      localObject = k.c.KY;
      AppMethodBeat.o(197555);
      return localObject;
    case 1: 
    case 3: 
      localObject = k.c.KZ;
      AppMethodBeat.o(197555);
      return localObject;
    case 4: 
      localObject = k.c.Lc;
      AppMethodBeat.o(197555);
      return localObject;
    case 5: 
      localObject = k.c.Ld;
      AppMethodBeat.o(197555);
      return localObject;
    case 6: 
      localObject = k.c.Lb;
      AppMethodBeat.o(197555);
      return localObject;
    }
    localObject = k.c.La;
    AppMethodBeat.o(197555);
    return localObject;
  }
  
  public final k.a gl()
  {
    AppMethodBeat.i(197565);
    Object localObject = (Integer)this.zV.get(CaptureResult.CONTROL_AE_STATE);
    if (localObject == null)
    {
      localObject = k.a.KL;
      AppMethodBeat.o(197565);
      return localObject;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      "Undefined ae state: ".concat(String.valueOf(localObject));
      al.T("C2CameraCaptureResult");
      localObject = k.a.KL;
      AppMethodBeat.o(197565);
      return localObject;
    case 0: 
      localObject = k.a.KM;
      AppMethodBeat.o(197565);
      return localObject;
    case 1: 
    case 5: 
      localObject = k.a.KN;
      AppMethodBeat.o(197565);
      return localObject;
    case 4: 
      localObject = k.a.KO;
      AppMethodBeat.o(197565);
      return localObject;
    case 2: 
      localObject = k.a.KP;
      AppMethodBeat.o(197565);
      return localObject;
    }
    localObject = k.a.KQ;
    AppMethodBeat.o(197565);
    return localObject;
  }
  
  public final k.d gm()
  {
    AppMethodBeat.i(197572);
    Object localObject = (Integer)this.zV.get(CaptureResult.CONTROL_AWB_STATE);
    if (localObject == null)
    {
      localObject = k.d.Lf;
      AppMethodBeat.o(197572);
      return localObject;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      "Undefined awb state: ".concat(String.valueOf(localObject));
      al.T("C2CameraCaptureResult");
      localObject = k.d.Lf;
      AppMethodBeat.o(197572);
      return localObject;
    case 0: 
      localObject = k.d.Lg;
      AppMethodBeat.o(197572);
      return localObject;
    case 1: 
      localObject = k.d.Lh;
      AppMethodBeat.o(197572);
      return localObject;
    case 2: 
      localObject = k.d.Li;
      AppMethodBeat.o(197572);
      return localObject;
    }
    localObject = k.d.Lj;
    AppMethodBeat.o(197572);
    return localObject;
  }
  
  public final k.e gn()
  {
    AppMethodBeat.i(197579);
    Object localObject = (Integer)this.zV.get(CaptureResult.FLASH_STATE);
    if (localObject == null)
    {
      localObject = k.e.Ll;
      AppMethodBeat.o(197579);
      return localObject;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      "Undefined flash state: ".concat(String.valueOf(localObject));
      al.T("C2CameraCaptureResult");
      localObject = k.e.Ll;
      AppMethodBeat.o(197579);
      return localObject;
    case 0: 
    case 1: 
      localObject = k.e.Lm;
      AppMethodBeat.o(197579);
      return localObject;
    case 2: 
      localObject = k.e.Ln;
      AppMethodBeat.o(197579);
      return localObject;
    }
    localObject = k.e.Lo;
    AppMethodBeat.o(197579);
    return localObject;
  }
  
  public final bi go()
  {
    return this.zU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.e
 * JD-Core Version:    0.7.0.1
 */