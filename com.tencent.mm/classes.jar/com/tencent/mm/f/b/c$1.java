package com.tencent.mm.f.b;

import com.tencent.mm.f.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements f.a
{
  c$1(c paramc) {}
  
  public final void d(int paramInt, byte[] paramArrayOfByte)
  {
    this.bCX.bCL += 1;
    if ((this.bCX.bCN) && (System.currentTimeMillis() - this.bCX.bCG <= 1000L) && (this.bCX.bCL - 10 > (System.currentTimeMillis() - this.bCX.bCG) / this.bCX.bCz))
    {
      h.nFQ.a(151L, 0L, 1L, false);
      h.nFQ.a(151L, 4L, 1L, false);
      y.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(this.bCX.bCL), Long.valueOf((System.currentTimeMillis() - this.bCX.bCG) / this.bCX.bCz) });
      this.bCX.bCM = true;
    }
    if (this.bCX.bCS != null) {
      this.bCX.bCS.v(paramArrayOfByte, paramInt);
    }
    c localc;
    int m;
    int i;
    int k;
    int n;
    int j;
    if (paramInt > 0)
    {
      localc = this.bCX;
      if ((!localc.bCI) || (-2 != localc.bCv))
      {
        m = paramInt / localc.bCH;
        i = 5;
        if (i <= localc.bCJ + m)
        {
          k = (i - localc.bCJ - 1) * localc.bCH;
          n = localc.bCH + k;
          if (k >= 0)
          {
            j = k;
            if (n <= paramInt) {
              break label626;
            }
          }
          y.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
        }
        localc.bCJ = ((localc.bCJ + m) % 5);
        if (localc.bCv == 20)
        {
          localc.bCt = 6;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
          if ((localc.bCu != -1) || (localc.bCw != -1)) {
            break label671;
          }
          localc.bCt = 11;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
          label377:
          h.nFQ.a(151L, 0L, 1L, false);
          h.nFQ.a(151L, 5L, 1L, false);
          localc.bCv = -2;
          localc.ur();
        }
      }
    }
    if (this.bCX.bCB)
    {
      if (paramInt <= 0) {
        break label787;
      }
      localc = this.bCX;
      if (localc.bCu != -1)
      {
        j = 0;
        i = 0;
        label449:
        if (i < paramInt / 2)
        {
          m = (short)(paramArrayOfByte[(i * 2 + 1)] << 8 | paramArrayOfByte[(i * 2 + 0)] & 0xFF);
          if (m < 32760)
          {
            k = j;
            if (m != -32768) {}
          }
          else
          {
            k = j + 1;
          }
          if (k < 5) {
            break label723;
          }
          localc.bCu += 1;
        }
        if (localc.bCu > 100)
        {
          localc.bCt = 7;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
          if ((localc.bCv != -2) || (localc.bCw != -1)) {
            break label734;
          }
          localc.bCt = 11;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
          label582:
          h.nFQ.a(151L, 0L, 1L, false);
          h.nFQ.a(151L, 6L, 1L, false);
          localc.ur();
          localc.bCu = -1;
        }
      }
    }
    label626:
    do
    {
      do
      {
        return;
        do
        {
          j += 1;
          if (j >= n) {
            break;
          }
        } while (paramArrayOfByte[j] == 0);
        localc.bCv = -1;
        localc.bCI = true;
        localc.bCv += 1;
        i += 5;
        break;
        if (localc.bCu == -1)
        {
          localc.bCt = 8;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
          break label377;
        }
        if (localc.bCw != -1) {
          break label377;
        }
        localc.bCt = 9;
        y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
        break label377;
        i += 1;
        j = k;
        break label449;
        if (localc.bCv == -2)
        {
          localc.bCt = 8;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
          break label582;
        }
        if (localc.bCw != -1) {
          break label582;
        }
        localc.bCt = 10;
        y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
        break label582;
        paramArrayOfByte = this.bCX;
      } while ((paramArrayOfByte.bCw == -1) || (paramInt >= 0));
      paramArrayOfByte.bCw += 1;
    } while (paramArrayOfByte.bCw < 50);
    label671:
    label723:
    label734:
    paramArrayOfByte.bCt = 5;
    label787:
    y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
    if ((paramArrayOfByte.bCv == -2) && (paramArrayOfByte.bCu == -1))
    {
      paramArrayOfByte.bCt = 11;
      y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
    }
    for (;;)
    {
      h.nFQ.a(151L, 0L, 1L, false);
      h.nFQ.a(151L, 7L, 1L, false);
      paramArrayOfByte.ur();
      paramArrayOfByte.bCw = -1;
      return;
      if (paramArrayOfByte.bCv == -2)
      {
        paramArrayOfByte.bCt = 9;
        y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
      }
      else if (paramArrayOfByte.bCu == -1)
      {
        paramArrayOfByte.bCt = 10;
        y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.c.1
 * JD-Core Version:    0.7.0.1
 */