package com.tencent.mm.plugin.gcm.modelgcm;

import android.os.AsyncTask;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class a$a
  extends AsyncTask<Void, Void, String>
{
  a$a(a parama) {}
  
  private String baK()
  {
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int m = 0;
    f.nEG.a(452L, 5L, 1L, false);
    i = n;
    j = i1;
    k = i2;
    for (;;)
    {
      try
      {
        y.i("GcmRegister", "RegisterAsyncTask doInBackground.");
        i = n;
        j = i1;
        k = i2;
        if (a.a(this.lhr) == null)
        {
          i = n;
          j = i1;
          k = i2;
          a.a(this.lhr, GoogleCloudMessaging.getInstance(a.b(this.lhr)));
        }
        i = n;
        j = i1;
        k = i2;
        String str2 = a.a(this.lhr).register(new String[] { "546136561403" });
        i = n;
        j = i1;
        k = i2;
        str1 = "Device registered, registration ID=" + str2;
        if (str2 == null) {
          continue;
        }
        i = n;
        j = i1;
        k = i2;
        if (str2.length() <= 0) {
          continue;
        }
        i = n;
        j = i1;
        k = i2;
        this.lhr.aq(a.b(this.lhr), str2);
        i = n;
        j = i1;
        k = i2;
        this.lhr.baH();
        i = 1;
        j = 1;
        k = 1;
        m = 1;
        f.nEG.a(452L, 6L, 1L, false);
        i = m;
      }
      catch (IOException localIOException)
      {
        str1 = "Device register Error :" + localIOException.getMessage();
        y.printErrStackTrace("GcmRegister", localIOException, "", new Object[0]);
        h.nFQ.aC(11250, "2,1");
        f.nEG.a(452L, 8L, 1L, false);
        continue;
      }
      catch (SecurityException localSecurityException)
      {
        a.a(this.lhr, 0);
        str1 = "Device register Error :" + localSecurityException.getMessage();
        y.printErrStackTrace("GcmRegister", localSecurityException, "", new Object[0]);
        h.nFQ.aC(11250, "2,1");
        f.nEG.a(452L, 9L, 1L, false);
        i = j;
        continue;
      }
      catch (Exception localException)
      {
        String str1 = "Device register Error :" + localException.getMessage();
        y.printErrStackTrace("GcmRegister", localException, "", new Object[0]);
        h.nFQ.aC(11250, "2,1");
        f.nEG.a(452L, 10L, 1L, false);
        i = k;
        continue;
      }
      y.i("GcmRegister", str1);
      if ((i == 0) && (a.c(this.lhr) > 0))
      {
        a.a(this.lhr, a.c(this.lhr) - 1);
        this.lhr.baC();
      }
      return str1;
      i = n;
      j = i1;
      k = i2;
      h.nFQ.aC(11250, "2,1");
      i = n;
      j = i1;
      k = i2;
      f.nEG.a(452L, 7L, 1L, false);
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.a.a
 * JD-Core Version:    0.7.0.1
 */