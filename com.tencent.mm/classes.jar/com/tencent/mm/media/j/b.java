package com.tencent.mm.media.j;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/util/FPSComputer;", "", "()V", "REPORT_ID_SROTY_VIDEO", "", "REPORT_KEY_EXECUTE_TIME", "REPORT_KEY_FAIL_COUNT", "TAG", "", "computeMinMaxAvgFps", "", "path", "result", "", "threshold", "", "plugin-mediaeditor_release"})
public final class b
{
  public static final b gWB;
  
  static
  {
    AppMethodBeat.i(93873);
    gWB = new b();
    AppMethodBeat.o(93873);
  }
  
  public static final List<Long> a(String paramString, double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(93871);
    k.h(paramArrayOfDouble, "result");
    if ((paramString == null) || (!i.eA(paramString)))
    {
      paramString = (List)v.KTF;
      AppMethodBeat.o(93871);
      return paramString;
    }
    List localList = (List)new ArrayList();
    long l1 = System.currentTimeMillis();
    int k = 0;
    int n = 2147483647;
    int i1 = 0;
    localc = new c();
    for (;;)
    {
      try
      {
        localc.setDataSource(paramString);
        i = 0;
        m = localc.getTrackCount();
        j = k;
        Object localObject;
        if (i < m)
        {
          localObject = localc.getTrackFormat(i);
          k.g(localObject, "mediaExtractor.getTrackFormat(i)");
          localObject = ((MediaFormat)localObject).getString("mime");
          k.g(localObject, "format.getString(MediaFormat.KEY_MIME)");
          if (!n.nb((String)localObject, "video/")) {
            continue;
          }
          j = 1;
          localc.selectTrack(i);
        }
        if (j != 0)
        {
          k = 1000000;
          m = 0;
          localObject = (List)new ArrayList();
          l2 = localc.getSampleTime();
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
              if (localc.advance()) {
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
          paramArrayOfDouble[2] = j.u((Iterable)localObject);
        }
        localc.release();
      }
      catch (Exception localException)
      {
        int i;
        int m;
        int j;
        long l2;
        int i3;
        int i2;
        ac.e("FPSComputer", "compute fps error: " + localException.getLocalizedMessage());
        h.wUl.A(986L, 103L);
        localc.release();
        continue;
      }
      finally
      {
        localc.release();
        AppMethodBeat.o(93871);
      }
      l2 = System.currentTimeMillis();
      ac.i("FPSComputer", "compute fps for file: " + paramString + ", threshold = " + paramInt + " frames = " + localList.size() + ", execute time = " + (l2 - l1) + "ms, min fps = " + paramArrayOfDouble[0] + ", max fps = " + paramArrayOfDouble[1] + ", avg fps = " + paramArrayOfDouble[2]);
      h.wUl.n(986L, 102L, l2 - l1);
      AppMethodBeat.o(93871);
      return localList;
      i += 1;
      continue;
      i = m + 1;
      j = i1;
      i2 = n;
      i3 = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.j.b
 * JD-Core Version:    0.7.0.1
 */