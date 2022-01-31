package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class j$17$1
  implements Runnable
{
  j$17$1(j.17 param17, rc paramrc) {}
  
  public final void run()
  {
    j.i(this.iGk.iFU);
    c localc = j.j(this.iGk.iFU);
    if (localc.iEu == 2) {
      y.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "dev start already...");
    }
    for (;;)
    {
      localc = j.j(this.iGk.iFU);
      Object localObject1 = this.iGj;
      if (localObject1 != null)
      {
        localc.mSampleRate = ((rc)localObject1).sOL;
        localc.mChannels = ((rc)localObject1).sON;
        localc.iEC = ((rc)localObject1).sOM;
      }
      j.a(this.iGk.iFU, this.iGk.iFY);
      return;
      localObject1 = localc.iEp;
      f.yi().a((f.a)localObject1);
      ((d)localObject1).iEI = f.yi().yt();
      ((d)localObject1).iEJ = f.yi().yn();
      y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(((d)localObject1).iEI), Boolean.valueOf(((d)localObject1).iEJ), Integer.valueOf(localObject1.hashCode()) });
      ((d)localObject1).eLi.requestFocus();
      ((d)localObject1).iEH.a(ae.getContext(), (HeadsetPlugReceiver.a)localObject1);
      int n;
      Object localObject2;
      Object localObject3;
      if ((((d)localObject1).iEI) || (((d)localObject1).iEJ))
      {
        if (((d)localObject1).iEJ)
        {
          n = f.yi().yk();
          if (n != 0)
          {
            y.e("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start bluetooth failed %d", new Object[] { Integer.valueOf(n) });
            f.yi().yl();
          }
        }
        y.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "start device......");
        localc.iEu = 2;
        q.dye.dump();
        localObject2 = new byte[1];
        localObject2[0] = 0;
        localObject1 = new byte[2];
        y.i("MicroMsg.OpenVoice.OpenVoiceAudioCompatHelper", "hy: audio info dump begin");
        q.dye.dump();
        if (q.dye.dvx < 0) {
          break label1137;
        }
        localObject1[0] = ((byte)q.dye.dvx);
        localObject3 = j.iFl;
        j.e(406, (byte[])localObject1, 1);
        label357:
        if (q.dye.dvA < 0) {
          break label1184;
        }
        localObject3 = new byte[5];
        if ((q.dye.dvB >= 0) && (q.dye.dvC >= 0))
        {
          localObject3[0] = ((byte)q.dye.dvB);
          localObject3[1] = ((byte)q.dye.dvC);
          if (q.dye.dvD < 0) {
            break label1166;
          }
          localObject3[2] = ((byte)q.dye.dvD);
          localObject3[3] = ((byte)q.dye.dvA);
          localObject3[4] = ((byte)q.dye.dvE);
          localj = j.iFl;
          j.e(404, (byte[])localObject3, 5);
        }
        label468:
        if (q.dye.dvy < 0) {
          break label1213;
        }
        localObject1[0] = ((byte)q.dye.dvy);
        localObject3 = j.iFl;
        j.e(408, (byte[])localObject1, 1);
      }
      for (;;)
      {
        if ((q.dye.dvJ[0] > 0) || (q.dye.dvJ[1] > 0))
        {
          localObject1[0] = 0;
          localObject1[1] = 0;
          if ((q.dye.dvJ[0] > 0) && (q.dye.dvJ[0] < 10000)) {
            localObject1[0] = ((byte)q.dye.dvJ[0]);
          }
          if ((q.dye.dvJ[1] > 0) && (q.dye.dvJ[1] < 10000)) {
            localObject1[1] = ((byte)q.dye.dvJ[1]);
          }
          localObject3 = j.iFl;
          j.e(423, (byte[])localObject1, 2);
        }
        if ((q.dye.dva >= 0) || (q.dye.dvc >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (q.dye.dva >= 0) {
            localObject1[0] = ((byte)q.dye.dva);
          }
          if (q.dye.dvc >= 0) {
            localObject1[1] = ((byte)q.dye.dvc);
          }
          localObject3 = j.iFl;
          j.e(414, (byte[])localObject1, 2);
        }
        if ((q.dye.dvb >= 0) || (q.dye.dvd >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (q.dye.dvb >= 0) {
            localObject1[0] = ((byte)q.dye.dvb);
          }
          if (q.dye.dvd >= 0) {
            localObject1[1] = ((byte)q.dye.dvd);
          }
          localObject3 = j.iFl;
          j.e(415, (byte[])localObject1, 2);
        }
        if ((q.dye.dve >= 0) || (q.dye.dvf >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (q.dye.dve >= 0) {
            localObject1[0] = ((byte)q.dye.dve);
          }
          if (q.dye.dvf >= 0) {
            localObject1[1] = ((byte)q.dye.dvf);
          }
          localObject3 = j.iFl;
          j.e(422, (byte[])localObject1, 2);
        }
        if (q.dye.dvg >= 0)
        {
          localObject1[0] = ((byte)q.dye.dvg);
          localObject3 = j.iFl;
          j.e(416, (byte[])localObject1, 1);
        }
        if ((q.dye.dvh >= 0) && (q.dye.dvh != 5))
        {
          localObject1[0] = ((byte)q.dye.dvh);
          localObject3 = j.iFl;
          j.e(417, (byte[])localObject1, 1);
        }
        if ((q.dye.dvi >= 0) && (q.dye.dvi != 5))
        {
          localObject1[0] = ((byte)q.dye.dvi);
          localObject3 = j.iFl;
          j.e(418, (byte[])localObject1, 1);
        }
        if (q.dye.dvj >= 0)
        {
          localObject1[0] = ((byte)q.dye.dvj);
          localObject3 = j.iFl;
          j.e(419, (byte[])localObject1, 1);
        }
        if (1 != q.dye.dvH) {
          break label1258;
        }
        localObject3 = new byte[30];
        n = 0;
        while (n < 15)
        {
          localObject3[(n * 2)] = ((byte)(q.dye.dvI[n] & 0xFF));
          localObject3[(n * 2 + 1)] = ((byte)(q.dye.dvI[n] >> 8 & 0xFF));
          n += 1;
        }
        ((d)localObject1).iEM &= ((d)localObject1).eG(true);
        break;
        label1137:
        if (q.dye.dvx != -2) {
          break label357;
        }
        localObject3 = j.iFl;
        j.e(407, (byte[])localObject2, 1);
        break label357;
        label1166:
        localj = j.iFl;
        j.e(404, (byte[])localObject3, 2);
        break label468;
        label1184:
        if (q.dye.dvA != -2) {
          break label468;
        }
        localObject3 = j.iFl;
        j.e(405, (byte[])localObject2, 1);
        break label468;
        label1213:
        if (q.dye.dvy == -2)
        {
          localObject3 = j.iFl;
          j.e(409, (byte[])localObject2, 1);
        }
      }
      j localj = j.iFl;
      j.e(420, (byte[])localObject3, 30);
      label1258:
      if (q.dye.dvH == 0)
      {
        localObject3 = j.iFl;
        j.e(421, (byte[])localObject2, 1);
      }
      if (q.dye.dvL > 0)
      {
        localObject1[0] = ((byte)q.dye.dvL);
        localObject2 = j.iFl;
        j.e(424, (byte[])localObject1, 1);
      }
      if (q.dye.dvk > 0)
      {
        localObject1[0] = ((byte)q.dye.dvk);
        localObject2 = j.iFl;
        j.e(431, (byte[])localObject1, 4);
      }
      if (q.dye.dvT >= 0)
      {
        int i = (byte)q.dye.dvT;
        int j = (byte)q.dye.dvU;
        int k = (byte)q.dye.dvV;
        int m = (byte)q.dye.dvW;
        localObject1 = j.iFl;
        j.e(426, new byte[] { i, j, k, m }, 4);
      }
      if (localc.iEv <= 10)
      {
        if (localc.iEv <= 0) {
          localc.iEy = 1;
        }
        localc.iEv = 92;
      }
      localc.iEq = new com.tencent.mm.f.b.c(localc.mSampleRate, localc.mChannels, 1);
      localc.iEq.ey(localc.iEC);
      localc.iEq.aY(true);
      localc.iEq.up();
      localc.iEq.bCE = -19;
      localc.iEq.t(1, false);
      localc.iEq.aX(true);
      localObject1 = j.iFl;
      j.e(401, new byte[1], 1);
      localc.iEq.bCP = localc.iED;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.17.1
 * JD-Core Version:    0.7.0.1
 */