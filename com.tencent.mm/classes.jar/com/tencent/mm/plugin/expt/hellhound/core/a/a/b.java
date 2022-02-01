package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.fhg;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  final ReentrantLock bKF;
  final Condition zBe;
  final Condition zBf;
  
  b()
  {
    AppMethodBeat.i(121862);
    czs localczs = dJc();
    if (localczs == null)
    {
      localczs = new czs();
      localczs.cZV = 10;
      a(localczs);
    }
    for (;;)
    {
      this.bKF = new ReentrantLock(true);
      this.zBe = this.bKF.newCondition();
      this.zBf = this.bKF.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localczs.cZV <= 0)
      {
        localczs.cZV = 10;
        a(localczs);
      }
    }
  }
  
  static void a(czs paramczs)
  {
    AppMethodBeat.i(121865);
    if (paramczs == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      paramczs = paramczs.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("key_hellhound_msgQ", paramczs);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException paramczs)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", paramczs, "HellMsgQDao, _write, crash: %s", new Object[] { paramczs.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int dJb()
  {
    AppMethodBeat.i(121864);
    czs localczs = dJc();
    if (localczs == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localczs.aaFi.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static czs dJc()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    czs localczs = new czs();
    try
    {
      localczs.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localczs;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", localIOException, "HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a dJa()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.bKF;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (dJb() == 0) {
        this.zBe.await();
      }
      localObject2 = dJc();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    czr localczr;
    if (localObject2 == null)
    {
      localObject2 = new czs();
      a((czs)localObject2);
      localczr = (czr)((czs)localObject2).aaFi.pollFirst();
      a((czs)localObject2);
      this.zBf.signal();
      if (localczr == null) {
        localObject2 = null;
      }
    }
    for (;;)
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
      return localObject2;
      localObject2 = new a();
      Object localObject3;
      switch (localczr.msgType)
      {
      case 100: 
        localObject3 = new fhg();
        ((fhg)localObject3).aaEZ = new fns();
        if (localczr.aaEZ != null)
        {
          ((fhg)localObject3).aaEZ.AtM = localczr.aaEZ.AtM;
          ((fhg)localObject3).aaEZ.cHb = localczr.aaEZ.cHb;
          ((fhg)localObject3).aaEZ.timestamp = localczr.aaEZ.timestamp;
        }
        ((fhg)localObject3).aaFa = new fns();
        if (localczr.aaFa != null)
        {
          ((fhg)localObject3).aaFa.AtM = localczr.aaFa.AtM;
          ((fhg)localObject3).aaFa.cHb = localczr.aaFa.cHb;
          ((fhg)localObject3).aaFa.timestamp = localczr.aaFa.timestamp;
        }
        ((fhg)localObject3).aajn = localczr.aajn;
        ((fhg)localObject3).aajk = localczr.aajk;
        ((fhg)localObject3).flags = localczr.flags;
        ((fhg)localObject3).aajm = localczr.aajm;
        ((fhg)localObject3).aaFb = localczr.aaFb;
        ((fhg)localObject3).aaFc = localczr.aaFc;
        ((fhg)localObject3).timestamp = localczr.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).zBd = localObject3;
        break;
      case 101: 
        localObject3 = new fns();
        if (localczr.aaFa != null)
        {
          ((fns)localObject3).AtM = localczr.aaFa.AtM;
          ((fns)localObject3).cHb = localczr.aaFa.cHb;
          ((fns)localObject3).timestamp = localczr.aaFa.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).zBd = localObject3;
        break;
      case 102: 
        localObject3 = new drg();
        ((drg)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((drg)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((drg)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((drg)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((drg)localObject3).aaFe = localczr.aaFe;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).zBd = localObject3;
        break;
      case 200: 
        localObject3 = new dwh();
        ((dwh)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((dwh)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((dwh)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((dwh)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((dwh)localObject3).flags = localczr.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).zBd = localObject3;
        break;
      case 201: 
        localObject3 = new dwh();
        ((dwh)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((dwh)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((dwh)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((dwh)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((dwh)localObject3).flags = localczr.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).zBd = localObject3;
        break;
      case 202: 
        localObject3 = new fns();
        if (localczr.aaFa != null)
        {
          ((fns)localObject3).AtM = localczr.aaFa.AtM;
          ((fns)localObject3).cHb = localczr.aaFa.cHb;
          ((fns)localObject3).timestamp = localczr.aaFa.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).zBd = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).zBd = localczr.aajm;
        break;
      case 203: 
        localObject3 = new dwi();
        ((dwi)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((dwi)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((dwi)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((dwi)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((dwi)localObject3).aajn = localczr.aajn;
        ((dwi)localObject3).aaFd = localczr.aaFd;
        ((dwi)localObject3).aajk = localczr.aajk;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).zBd = localObject3;
        break;
      case 204: 
        localObject3 = new fns();
        if (localczr.aaFa != null)
        {
          ((fns)localObject3).AtM = localczr.aaFa.AtM;
          ((fns)localObject3).cHb = localczr.aaFa.cHb;
          ((fns)localObject3).timestamp = localczr.aaFa.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).zBd = localObject3;
        break;
      case 205: 
        localObject3 = new dwi();
        ((dwi)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((dwi)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((dwi)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((dwi)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((dwi)localObject3).aajn = localczr.aajn;
        ((dwi)localObject3).aaFd = localczr.aaFd;
        ((dwi)localObject3).aajk = localczr.aajk;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).zBd = localObject3;
        break;
      case 206: 
        localObject3 = new fns();
        if (localczr.aaFa != null)
        {
          ((fns)localObject3).AtM = localczr.aaFa.AtM;
          ((fns)localObject3).cHb = localczr.aaFa.cHb;
          ((fns)localObject3).timestamp = localczr.aaFa.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).zBd = localObject3;
        break;
      case 207: 
        localObject3 = new fns();
        if (localczr.aaFa != null)
        {
          ((fns)localObject3).AtM = localczr.aaFa.AtM;
          ((fns)localObject3).cHb = localczr.aaFa.cHb;
          ((fns)localObject3).timestamp = localczr.aaFa.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).zBd = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localczr.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = localczr.msgType;
        break;
      case 5: 
        localObject3 = new cah();
        ((cah)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((cah)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((cah)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((cah)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((cah)localObject3).aajm = localczr.aajm;
        ((cah)localObject3).aajn = localczr.aajn;
        ((cah)localObject3).aajk = localczr.aajk;
        ((cah)localObject3).aajl = localczr.aajl;
        ((cah)localObject3).aajo = localczr.aajo;
        ((cah)localObject3).timestamp = localczr.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).zBd = localObject3;
        break;
      case 6: 
        localObject3 = new cag();
        ((cag)localObject3).aajj = new fns();
        if (localczr.aaFa != null)
        {
          ((cag)localObject3).aajj.AtM = localczr.aaFa.AtM;
          ((cag)localObject3).aajj.cHb = localczr.aaFa.cHb;
          ((cag)localObject3).aajj.timestamp = localczr.aaFa.timestamp;
        }
        ((cag)localObject3).aajk = localczr.aajk;
        ((cag)localObject3).aajl = localczr.aajl;
        ((cag)localObject3).timestamp = localczr.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).zBd = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).zBd = Integer.valueOf(localczr.flags);
        ((a)localObject2).msgType = localczr.msgType;
        break;
      case 500: 
        ((a)localObject2).zBd = localczr.aaFf;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).zBd = localczr.aaFf;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 212;
        break;
      case 213: 
        ((a)localObject2).msgType = 213;
        break;
      case 214: 
        ((a)localObject2).msgType = 214;
        break;
      case 215: 
        ((a)localObject2).msgType = 215;
        break;
      case 216: 
        ((a)localObject2).msgType = 216;
        break;
      case 209: 
        ((a)localObject2).msgType = 209;
        break;
      case 210: 
        ((a)localObject2).zBd = Integer.valueOf(localczr.flags);
        ((a)localObject2).msgType = 210;
        break;
      case 700: 
        ((a)localObject2).msgType = 700;
        break;
      case 701: 
        ((a)localObject2).msgType = 701;
        break;
      case 702: 
        ((a)localObject2).msgType = 702;
        break;
      case 703: 
        ((a)localObject2).msgType = 703;
        break;
      case 704: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).zBd = localczr.aaFb;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).zBd = Long.valueOf(localczr.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
      case 800: 
        ((a)localObject2).zBd = localczr.aaFg;
        ((a)localObject2).msgType = 800;
        break;
      case 801: 
        ((a)localObject2).zBd = localczr.aaFh;
        ((a)localObject2).msgType = 801;
        break;
        break label64;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */