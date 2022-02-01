package com.tencent.mm.media.util;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/FPSComputer;", "", "()V", "REPORT_ID_SROTY_VIDEO", "", "REPORT_KEY_EXECUTE_TIME", "REPORT_KEY_FAIL_COUNT", "TAG", "", "computeMinMaxAvgFps", "", "path", "result", "", "threshold", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nFr;
  
  static
  {
    AppMethodBeat.i(93873);
    nFr = new b();
    AppMethodBeat.o(93873);
  }
  
  public static final List<Long> a(String paramString, double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(93871);
    s.u(paramArrayOfDouble, "result");
    if ((paramString == null) || (!y.ZC(paramString)))
    {
      paramString = (List)ab.aivy;
      AppMethodBeat.o(93871);
      return paramString;
    }
    List localList = (List)new ArrayList();
    long l1 = System.currentTimeMillis();
    int j = 0;
    int n = 2147483647;
    int i1 = 0;
    localc = new c();
    for (;;)
    {
      try
      {
        localc.setDataSource(paramString);
        k = 0;
        m = localc.lZm.getTrackCount();
        i = j;
        Object localObject;
        if (m > 0)
        {
          i = k;
          k = i + 1;
          localObject = localc.getTrackFormat(i);
          s.s(localObject, "mediaExtractor.getTrackFormat(i)");
          localObject = ((MediaFormat)localObject).getString("mime");
          s.checkNotNull(localObject);
          s.s(localObject, "format.getString(MediaFormat.KEY_MIME)!!");
          if (!n.U((String)localObject, "video/", false)) {
            continue;
          }
          j = 1;
          localc.selectTrack(i);
          i = j;
        }
        if (i != 0)
        {
          k = 1000000;
          m = 0;
          localObject = (List)new ArrayList();
          l2 = localc.lZm.getSampleTime();
          j = i1;
          i = n;
          i3 = k;
          int i4 = m;
          if (l2 != -1L)
          {
            localList.add(Long.valueOf(l2));
            if (l2 <= k) {
              continue;
            }
            ((List)localObject).add(Integer.valueOf(m));
            i1 = Math.max(i1, m);
            i2 = Math.min(n, m);
            j = i1;
            i = i2;
            i3 = k;
            i4 = m;
            if (i1 - i2 < paramInt)
            {
              i = 0;
              i3 = k + 1000000;
              j = i1;
              i1 = j;
              n = i2;
              k = i3;
              m = i;
              if (localc.lZm.advance()) {
                continue;
              }
              i4 = i;
              i = i2;
            }
          }
          m = j;
          k = i;
          if (i3 <= 1000000)
          {
            ((List)localObject).add(Integer.valueOf(i4));
            m = Math.max(j, i4);
            k = Math.min(i, i4);
          }
          paramArrayOfDouble[0] = k;
          paramArrayOfDouble[1] = m;
          paramArrayOfDouble[2] = p.B((Iterable)localObject);
        }
        localc.lZm.release();
      }
      catch (Exception localException)
      {
        int k;
        int m;
        int i;
        long l2;
        int i3;
        int i2;
        Log.e("FPSComputer", s.X("compute fps error: ", localException.getLocalizedMessage()));
        h.OAn.p(986L, 103L, 1L);
        localc.lZm.release();
        continue;
      }
      finally
      {
        localc.lZm.release();
        AppMethodBeat.o(93871);
      }
      l2 = System.currentTimeMillis();
      Log.i("FPSComputer", "compute fps for file: " + paramString + ", threshold = " + paramInt + " frames = " + localList.size() + ", execute time = " + (l2 - l1) + "ms, min fps = " + paramArrayOfDouble[0] + ", max fps = " + paramArrayOfDouble[1] + ", avg fps = " + paramArrayOfDouble[2]);
      h.OAn.p(986L, 102L, l2 - l1);
      AppMethodBeat.o(93871);
      return localList;
      i = j;
      if (k < m)
      {
        i = k;
        continue;
        i = m + 1;
        j = i1;
        i2 = n;
        i3 = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.util.b
 * JD-Core Version:    0.7.0.1
 */