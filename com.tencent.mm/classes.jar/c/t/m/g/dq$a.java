package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class dq$a
  extends Handler
{
  public dq$a(dq paramdq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      try
      {
        removeMessages(paramMessage.what);
        switch (paramMessage.what)
        {
        case 1101: 
          paramMessage = dq.a(this.a);
          if ((paramMessage != null) && (dq.a(paramMessage)) && (!dq.a(this.a, paramMessage)))
          {
            dq.b(this.a, paramMessage);
            dq.b(this.a);
            dq.a(this.a, dq.c(this.a) | 0x2);
            if ((dq.d(this.a) == -1L) || (dq.d(this.a) == 0L))
            {
              dq.a(this.a, true);
              dq.a(this.a, System.currentTimeMillis());
              return;
            }
          }
          break;
        }
      }
      catch (Throwable paramMessage)
      {
        j.a("TxGpsProvider", "handleMessage error.", paramMessage);
        return;
      }
    }
    dq.b(this.a);
    dq.e(this.a);
    int i;
    if ((dq.f(this.a) != null) && (dq.g(this.a) != null))
    {
      i = dq.g(this.a).size();
      if (i <= 0) {}
    }
    for (;;)
    {
      float[] arrayOfFloat;
      float f;
      try
      {
        paramMessage = dq.h(this.a);
        Object localObject = dq.g(this.a);
        if (((List)localObject).size() >= 5)
        {
          arrayOfFloat = new float[((List)localObject).size()];
          i = 0;
          if (i < arrayOfFloat.length)
          {
            Float localFloat = (Float)((List)localObject).get(i);
            if (localFloat == null)
            {
              f = 0.0F;
              break label640;
            }
            f = localFloat.floatValue();
            break label640;
          }
          Arrays.sort(arrayOfFloat);
          localObject = new float[5];
          f = 0.0F;
          i = 0;
          if (i < 5)
          {
            localObject[i] = arrayOfFloat[(arrayOfFloat.length - 1 - i)];
            f += localObject[i];
            i += 1;
            continue;
          }
          f /= 5.0F;
          if (paramMessage.b < f) {
            paramMessage.b = f;
          }
          if (paramMessage.c > f) {
            paramMessage.c = f;
          }
          paramMessage.a = f;
          if (paramMessage.a - f > 2.0F) {
            paramMessage.d = false;
          }
          if (f > (paramMessage.b + paramMessage.c) / 2.0F) {
            paramMessage.d = true;
          }
        }
        else
        {
          bool = paramMessage.d;
          if (!bool) {
            break label503;
          }
          if ((dq.d(this.a) == -1L) || (dq.d(this.a) == 0L)) {
            dq.a(this.a, bool);
          }
          dq.a(this.a, System.currentTimeMillis());
          return;
        }
        if (f >= 22.0F) {
          continue;
        }
        paramMessage.d = false;
        continue;
        if (dq.d(this.a) == -1L) {
          break label547;
        }
      }
      catch (Throwable paramMessage)
      {
        j.a("TxGpsProvider", "judgeIO Error!", paramMessage);
      }
      label503:
      if ((System.currentTimeMillis() - dq.d(this.a) <= 40000L) || (dq.d(this.a) == 0L)) {
        break;
      }
      label547:
      dq.a(this.a, bool);
      dq.a(this.a, 0L);
      return;
      j.a("TxGpsProvider", 4, "onProviderEnabled: gps is enabled");
      dq.a(this.a, 4);
      dq.i(this.a);
      return;
      j.a("TxGpsProvider", 4, "onProviderDisabled: gps is disabled");
      dq.b(this.a, dq.j(this.a));
      dq.a(this.a, 0);
      dq.k(this.a);
      dq.i(this.a);
      return;
      return;
      label640:
      arrayOfFloat[i] = f;
      i += 1;
      continue;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.dq.a
 * JD-Core Version:    0.7.0.1
 */