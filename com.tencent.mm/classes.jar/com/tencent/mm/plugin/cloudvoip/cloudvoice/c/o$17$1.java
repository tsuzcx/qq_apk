package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class o$17$1
  implements Runnable
{
  o$17$1(o.17 param17, uu paramuu) {}
  
  public final void run()
  {
    AppMethodBeat.i(135541);
    o.j(this.kMc.kLI);
    e locale = o.k(this.kMc.kLI);
    Object localObject1 = this.kMb;
    if (localObject1 != null)
    {
      locale.mSampleRate = ((uu)localObject1).wMY.wPo;
      locale.mChannels = ((uu)localObject1).wMY.channels;
      locale.kJO = ((uu)localObject1).wMY.wPp;
    }
    locale = o.k(this.kMc.kLI);
    if (locale.kJF == 2) {
      ab.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "dev start already...");
    }
    for (;;)
    {
      o.l(this.kMc.kLI);
      o.a(this.kMc.kLI, this.kMc.kLQ);
      AppMethodBeat.o(135541);
      return;
      localObject1 = locale.kJA;
      g.KC().a((g.a)localObject1);
      ((f)localObject1).kJU = g.KC().KN();
      ((f)localObject1).kJV = g.KC().KH();
      ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(((f)localObject1).kJU), Boolean.valueOf(((f)localObject1).kJV), Integer.valueOf(localObject1.hashCode()) });
      ((f)localObject1).gaP.requestFocus();
      ((f)localObject1).kJT.a(ah.getContext(), (HeadsetPlugReceiver.a)localObject1);
      int n;
      Object localObject2;
      Object localObject3;
      if ((((f)localObject1).kJU) || (((f)localObject1).kJV))
      {
        if (((f)localObject1).kJV)
        {
          n = g.KC().KE();
          if (n != 0)
          {
            ab.e("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "hy: start bluetooth failed %d", new Object[] { Integer.valueOf(n) });
            g.KC().KF();
          }
        }
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "start device......");
        locale.kJF = 2;
        ac.erv.dump();
        localObject2 = new byte[1];
        localObject2[0] = 0;
        localObject1 = new byte[2];
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioCompatHelper", "hy: audio info dump begin");
        ac.erv.dump();
        if (ac.erv.eno < 0) {
          break label1167;
        }
        localObject1[0] = ((byte)ac.erv.eno);
        localObject3 = o.kKN;
        o.f(406, (byte[])localObject1, 1);
        label387:
        if (ac.erv.enr < 0) {
          break label1214;
        }
        localObject3 = new byte[5];
        if ((ac.erv.ens >= 0) && (ac.erv.ent >= 0))
        {
          localObject3[0] = ((byte)ac.erv.ens);
          localObject3[1] = ((byte)ac.erv.ent);
          if (ac.erv.enu < 0) {
            break label1196;
          }
          localObject3[2] = ((byte)ac.erv.enu);
          localObject3[3] = ((byte)ac.erv.enr);
          localObject3[4] = ((byte)ac.erv.env);
          localo = o.kKN;
          o.f(404, (byte[])localObject3, 5);
        }
        label498:
        if (ac.erv.enp < 0) {
          break label1243;
        }
        localObject1[0] = ((byte)ac.erv.enp);
        localObject3 = o.kKN;
        o.f(408, (byte[])localObject1, 1);
      }
      for (;;)
      {
        if ((ac.erv.enA[0] > 0) || (ac.erv.enA[1] > 0))
        {
          localObject1[0] = 0;
          localObject1[1] = 0;
          if ((ac.erv.enA[0] > 0) && (ac.erv.enA[0] < 10000)) {
            localObject1[0] = ((byte)ac.erv.enA[0]);
          }
          if ((ac.erv.enA[1] > 0) && (ac.erv.enA[1] < 10000)) {
            localObject1[1] = ((byte)ac.erv.enA[1]);
          }
          localObject3 = o.kKN;
          o.f(423, (byte[])localObject1, 2);
        }
        if ((ac.erv.emQ >= 0) || (ac.erv.emS >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (ac.erv.emQ >= 0) {
            localObject1[0] = ((byte)ac.erv.emQ);
          }
          if (ac.erv.emS >= 0) {
            localObject1[1] = ((byte)ac.erv.emS);
          }
          localObject3 = o.kKN;
          o.f(414, (byte[])localObject1, 2);
        }
        if ((ac.erv.emR >= 0) || (ac.erv.emT >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (ac.erv.emR >= 0) {
            localObject1[0] = ((byte)ac.erv.emR);
          }
          if (ac.erv.emT >= 0) {
            localObject1[1] = ((byte)ac.erv.emT);
          }
          localObject3 = o.kKN;
          o.f(415, (byte[])localObject1, 2);
        }
        if ((ac.erv.emU >= 0) || (ac.erv.emV >= 0))
        {
          localObject1[0] = -1;
          localObject1[1] = -1;
          if (ac.erv.emU >= 0) {
            localObject1[0] = ((byte)ac.erv.emU);
          }
          if (ac.erv.emV >= 0) {
            localObject1[1] = ((byte)ac.erv.emV);
          }
          localObject3 = o.kKN;
          o.f(422, (byte[])localObject1, 2);
        }
        if (ac.erv.emW >= 0)
        {
          localObject1[0] = ((byte)ac.erv.emW);
          localObject3 = o.kKN;
          o.f(416, (byte[])localObject1, 1);
        }
        if ((ac.erv.emX >= 0) && (ac.erv.emX != 5))
        {
          localObject1[0] = ((byte)ac.erv.emX);
          localObject3 = o.kKN;
          o.f(417, (byte[])localObject1, 1);
        }
        if ((ac.erv.emY >= 0) && (ac.erv.emY != 5))
        {
          localObject1[0] = ((byte)ac.erv.emY);
          localObject3 = o.kKN;
          o.f(418, (byte[])localObject1, 1);
        }
        if (ac.erv.emZ >= 0)
        {
          localObject1[0] = ((byte)ac.erv.emZ);
          localObject3 = o.kKN;
          o.f(419, (byte[])localObject1, 1);
        }
        if (1 != ac.erv.eny) {
          break label1288;
        }
        localObject3 = new byte[30];
        n = 0;
        while (n < 15)
        {
          localObject3[(n * 2)] = ((byte)(ac.erv.enz[n] & 0xFF));
          localObject3[(n * 2 + 1)] = ((byte)(ac.erv.enz[n] >> 8 & 0xFF));
          n += 1;
        }
        ((f)localObject1).kJY &= ((f)localObject1).gi(true);
        break;
        label1167:
        if (ac.erv.eno != -2) {
          break label387;
        }
        localObject3 = o.kKN;
        o.f(407, (byte[])localObject2, 1);
        break label387;
        label1196:
        localo = o.kKN;
        o.f(404, (byte[])localObject3, 2);
        break label498;
        label1214:
        if (ac.erv.enr != -2) {
          break label498;
        }
        localObject3 = o.kKN;
        o.f(405, (byte[])localObject2, 1);
        break label498;
        label1243:
        if (ac.erv.enp == -2)
        {
          localObject3 = o.kKN;
          o.f(409, (byte[])localObject2, 1);
        }
      }
      o localo = o.kKN;
      o.f(420, (byte[])localObject3, 30);
      label1288:
      if (ac.erv.eny == 0)
      {
        localObject3 = o.kKN;
        o.f(421, (byte[])localObject2, 1);
      }
      if (ac.erv.enC > 0)
      {
        localObject1[0] = ((byte)ac.erv.enC);
        localObject2 = o.kKN;
        o.f(424, (byte[])localObject1, 1);
      }
      if (ac.erv.ena > 0)
      {
        localObject1[0] = ((byte)ac.erv.ena);
        localObject2 = o.kKN;
        o.f(431, (byte[])localObject1, 4);
      }
      if (ac.erv.enK >= 0)
      {
        int i = (byte)ac.erv.enK;
        int j = (byte)ac.erv.enL;
        int k = (byte)ac.erv.enM;
        int m = (byte)ac.erv.enN;
        localObject1 = o.kKN;
        o.f(426, new byte[] { i, j, k, m }, 4);
      }
      if (locale.kJG <= 10)
      {
        if (locale.kJG <= 0) {
          locale.kJJ = 1;
        }
        locale.kJG = 92;
      }
      locale.kJB = new c(locale.mSampleRate, locale.mChannels, 1);
      locale.kJB.gA(locale.kJO);
      locale.kJB.bA(true);
      locale.kJB.EB();
      locale.kJB.cjs = -19;
      locale.kJB.t(1, false);
      locale.kJB.bz(true);
      localObject1 = o.kKN;
      o.f(401, new byte[1], 1);
      locale.kJB.cjD = locale.kJP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.17.1
 * JD-Core Version:    0.7.0.1
 */