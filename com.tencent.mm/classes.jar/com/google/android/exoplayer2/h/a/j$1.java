package com.google.android.exoplayer2.h.a;

import android.os.ConditionVariable;
import android.util.SparseArray;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;

final class j$1
  extends Thread
{
  j$1(j paramj, String paramString, ConditionVariable paramConditionVariable)
  {
    super(paramString);
  }
  
  public final void run()
  {
    AppMethodBeat.i(151985);
    for (;;)
    {
      j localj2;
      int i;
      synchronized (this.bax)
      {
        this.baw.open();
        try
        {
          localj2 = this.bax;
          if (!localj2.bap.exists())
          {
            localj2.bap.mkdirs();
            AppMethodBeat.o(151985);
            return;
          }
          Object localObject1 = localj2.bas;
          if (((h)localObject1).bal) {
            break label270;
          }
          bool = true;
          a.checkState(bool);
          if (!((h)localObject1).qE())
          {
            localObject4 = ((h)localObject1).bah;
            ((b)localObject4).baB.delete();
            ((b)localObject4).baC.delete();
            ((h)localObject1).baf.clear();
            ((h)localObject1).bag.clear();
          }
          Object localObject4 = localj2.bap.listFiles();
          if (localObject4 == null) {
            continue;
          }
          int j = localObject4.length;
          i = 0;
          if (i < j)
          {
            File localFile = localObject4[i];
            if (localFile.getName().equals("cached_content_index.exi")) {
              break label263;
            }
            if (localFile.length() <= 0L) {
              break label275;
            }
            localObject1 = k.a(localFile, localj2.bas);
            if (localObject1 != null) {
              localj2.a((k)localObject1);
            } else {
              localFile.delete();
            }
          }
        }
        catch (a.a locala)
        {
          this.bax.bav = locala;
          continue;
        }
      }
      localj2.bas.qD();
      localj2.bas.qC();
      continue;
      label263:
      i += 1;
      continue;
      label270:
      boolean bool = false;
      continue;
      label275:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.j.1
 * JD-Core Version:    0.7.0.1
 */