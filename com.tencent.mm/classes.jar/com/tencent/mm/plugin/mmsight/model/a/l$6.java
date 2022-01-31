package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class l$6
  extends ah
{
  l$6(l paraml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.mjO.mjD == -1)
    {
      this.mjO.mjD = Process.myTid();
      y.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(this.mjO.mjD) });
    }
    l locall;
    byte[] arrayOfByte;
    int i3;
    int j;
    int i;
    if (paramMessage.what == 1)
    {
      this.mjO.mjl.bjh();
      locall = this.mjO;
      arrayOfByte = (byte[])paramMessage.obj;
      if (!locall.mhL) {
        break label150;
      }
      paramMessage = locall.mjm;
      i3 = arrayOfByte.length;
      j = locall.mjy;
      i = locall.mjz;
    }
    label150:
    int k;
    for (;;)
    {
      paramMessage.mit = bk.UZ();
      if (paramMessage.mkq >= 0) {
        break;
      }
      y.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
      j.mji.z(arrayOfByte);
      locall.mjH = true;
      return;
      paramMessage = locall.mjm;
      i3 = arrayOfByte.length;
      if ((locall.jWo == 0) || (locall.jWo == 180)) {}
      for (i = locall.mjy;; i = locall.mjz)
      {
        if ((locall.jWo != 0) && (locall.jWo != 180)) {
          break label229;
        }
        k = locall.mjz;
        j = i;
        i = k;
        break;
      }
      label229:
      k = locall.mjy;
      j = i;
      i = k;
    }
    label538:
    label544:
    label681:
    for (;;)
    {
      int i1;
      int m;
      int n;
      int i2;
      boolean bool2;
      try
      {
        paramMessage.frameCount += 1;
        i1 = paramMessage.mkr;
        bool1 = paramMessage.mhL;
        if (bool1) {
          break label544;
        }
        if ((paramMessage.mks == -1) || (paramMessage.mks == paramMessage.mkr)) {
          break label538;
        }
        bool1 = true;
        k = paramMessage.mks;
        if (paramMessage.mkr <= 180)
        {
          k -= paramMessage.mkr;
          i1 = Math.max(0, k);
          if (i1 < 360) {
            break label712;
          }
          k = 0;
          i1 = k;
          SightVideoJNI.setRotateForBufId(paramMessage.mkq, i1);
          if (!bool1) {
            break label579;
          }
          if ((i1 != 0) && (i1 != 180)) {
            break label570;
          }
          k = paramMessage.eIB;
          if (!bool1) {
            break label619;
          }
          if ((i1 != 0) && (i1 != 180)) {
            break label610;
          }
          m = paramMessage.eIC;
          if (!bool1) {
            break label656;
          }
          if ((i1 != 0) && (i1 != 180)) {
            break label650;
          }
          n = j;
          if (!bool1) {
            break label681;
          }
          if (i1 != 0)
          {
            i2 = j;
            if (i1 != 180) {}
          }
          else
          {
            i2 = i;
          }
          if ((n != k) || (i2 != m)) {
            break label706;
          }
          bool2 = false;
          SightVideoJNI.writeYuvDataForMMSight(paramMessage.mkq, arrayOfByte, i3, k, m, bool1, bool2, n, i2);
          y.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(bk.cp(paramMessage.mit)) });
          break;
        }
      }
      finally {}
      k += 360 - paramMessage.mkr;
      continue;
      boolean bool1 = false;
      continue;
      label570:
      label706:
      if (paramMessage.mks == -1)
      {
        k = paramMessage.mkr;
      }
      else
      {
        k = paramMessage.mks;
        continue;
        k = paramMessage.eIC;
        continue;
        label579:
        label712:
        if ((i1 == 0) || (i1 == 180))
        {
          k = paramMessage.eIC;
        }
        else
        {
          k = paramMessage.eIB;
          continue;
          label610:
          m = paramMessage.eIB;
          continue;
          label619:
          if ((i1 == 0) || (i1 == 180))
          {
            m = paramMessage.eIB;
          }
          else
          {
            m = paramMessage.eIC;
            continue;
            n = i;
            continue;
            if ((i1 == 0) || (i1 == 180))
            {
              n = i;
            }
            else
            {
              n = j;
              continue;
              i2 = j;
              if (i1 != 0)
              {
                i2 = j;
                if (i1 != 180)
                {
                  i2 = i;
                  continue;
                  bool2 = true;
                  continue;
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.6
 * JD-Core Version:    0.7.0.1
 */