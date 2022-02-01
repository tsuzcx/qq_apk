package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  ReentrantLock cEu;
  final Condition qiT;
  final Condition qiU;
  
  b()
  {
    AppMethodBeat.i(121862);
    bjs localbjs = ciN();
    if (localbjs == null)
    {
      localbjs = new bjs();
      localbjs.bme = 10;
      a(localbjs);
    }
    for (;;)
    {
      this.cEu = new ReentrantLock(true);
      this.qiT = this.cEu.newCondition();
      this.qiU = this.cEu.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localbjs.bme <= 0)
      {
        localbjs.bme = 10;
        a(localbjs);
      }
    }
  }
  
  static void a(bjs parambjs)
  {
    AppMethodBeat.i(121865);
    if (parambjs == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      parambjs = parambjs.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("key_hellhound_msgQ", parambjs);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException parambjs)
    {
      ac.printErrStackTrace("HellMsgQDao", parambjs, "HABBYGE-MALI, HellMsgQDao, _write, crash: %s", new Object[] { parambjs.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int ciM()
  {
    AppMethodBeat.i(121864);
    bjs localbjs = ciN();
    if (localbjs == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localbjs.EZj.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static bjs ciN()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    bjs localbjs = new bjs();
    try
    {
      localbjs.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localbjs;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("HellMsgQDao", localIOException, "HABBYGE-MAli, HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a ciL()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.cEu;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (ciM() == 0) {
        this.qiT.await();
      }
      localObject2 = ciN();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    bjr localbjr;
    if (localObject2 == null)
    {
      localObject2 = new bjs();
      a((bjs)localObject2);
      localbjr = (bjr)((bjs)localObject2).EZj.pollFirst();
      if (localbjr != null) {
        ac.i("HellMsgQDao", "HABBYGE-MALI, HellMsgQDao, dequeue, %d", new Object[] { Integer.valueOf(localbjr.msgType) });
      }
      a((bjs)localObject2);
      this.qiU.signal();
      if (localbjr == null) {
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
      switch (localbjr.msgType)
      {
      case 100: 
        localObject3 = new dcp();
        ((dcp)localObject3).EZc = new dhz();
        if (localbjr.EZc != null)
        {
          ((dcp)localObject3).EZc.activityName = localbjr.EZc.activityName;
          ((dcp)localObject3).EZc.EIR = localbjr.EZc.EIR;
          ((dcp)localObject3).EZc.timestamp = localbjr.EZc.timestamp;
        }
        ((dcp)localObject3).EZd = new dhz();
        if (localbjr.EZd != null)
        {
          ((dcp)localObject3).EZd.activityName = localbjr.EZd.activityName;
          ((dcp)localObject3).EZd.EIR = localbjr.EZd.EIR;
          ((dcp)localObject3).EZd.timestamp = localbjr.EZd.timestamp;
        }
        ((dcp)localObject3).EIH = localbjr.EIH;
        ((dcp)localObject3).EIF = localbjr.EIF;
        ((dcp)localObject3).flags = localbjr.flags;
        ((dcp)localObject3).EIG = localbjr.EIG;
        ((dcp)localObject3).EZe = localbjr.EZe;
        ((dcp)localObject3).EZf = localbjr.EZf;
        ((dcp)localObject3).timestamp = localbjr.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).qiS = localObject3;
        break;
      case 101: 
        localObject3 = new dhz();
        if (localbjr.EZd != null)
        {
          ((dhz)localObject3).activityName = localbjr.EZd.activityName;
          ((dhz)localObject3).EIR = localbjr.EZd.EIR;
          ((dhz)localObject3).timestamp = localbjr.EZd.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).qiS = localObject3;
        break;
      case 102: 
        localObject3 = new bww();
        ((bww)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((bww)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((bww)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((bww)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((bww)localObject3).EZh = localbjr.EZh;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).qiS = localObject3;
        break;
      case 200: 
        localObject3 = new bzg();
        ((bzg)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((bzg)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((bzg)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((bzg)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((bzg)localObject3).flags = localbjr.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).qiS = localObject3;
        break;
      case 201: 
        localObject3 = new bzg();
        ((bzg)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((bzg)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((bzg)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((bzg)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((bzg)localObject3).flags = localbjr.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).qiS = localObject3;
        break;
      case 202: 
        localObject3 = new dhz();
        if (localbjr.EZd != null)
        {
          ((dhz)localObject3).activityName = localbjr.EZd.activityName;
          ((dhz)localObject3).EIR = localbjr.EZd.EIR;
          ((dhz)localObject3).timestamp = localbjr.EZd.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).qiS = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).qiS = localbjr.EIG;
        break;
      case 203: 
        localObject3 = new bzh();
        ((bzh)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((bzh)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((bzh)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((bzh)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((bzh)localObject3).EIH = localbjr.EIH;
        ((bzh)localObject3).EZg = localbjr.EZg;
        ((bzh)localObject3).EIF = localbjr.EIF;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).qiS = localObject3;
        break;
      case 204: 
        localObject3 = new dhz();
        if (localbjr.EZd != null)
        {
          ((dhz)localObject3).activityName = localbjr.EZd.activityName;
          ((dhz)localObject3).EIR = localbjr.EZd.EIR;
          ((dhz)localObject3).timestamp = localbjr.EZd.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).qiS = localObject3;
        break;
      case 205: 
        localObject3 = new bzh();
        ((bzh)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((bzh)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((bzh)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((bzh)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((bzh)localObject3).EIH = localbjr.EIH;
        ((bzh)localObject3).EZg = localbjr.EZg;
        ((bzh)localObject3).EIF = localbjr.EIF;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).qiS = localObject3;
        break;
      case 206: 
        localObject3 = new dhz();
        if (localbjr.EZd != null)
        {
          ((dhz)localObject3).activityName = localbjr.EZd.activityName;
          ((dhz)localObject3).EIR = localbjr.EZd.EIR;
          ((dhz)localObject3).timestamp = localbjr.EZd.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).qiS = localObject3;
        break;
      case 207: 
        localObject3 = new dhz();
        if (localbjr.EZd != null)
        {
          ((dhz)localObject3).activityName = localbjr.EZd.activityName;
          ((dhz)localObject3).EIR = localbjr.EZd.EIR;
          ((dhz)localObject3).timestamp = localbjr.EZd.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).qiS = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localbjr.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = localbjr.msgType;
        break;
      case 5: 
        localObject3 = new apr();
        ((apr)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((apr)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((apr)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((apr)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((apr)localObject3).EIG = localbjr.EIG;
        ((apr)localObject3).EIH = localbjr.EIH;
        ((apr)localObject3).EIF = localbjr.EIF;
        ((apr)localObject3).EII = localbjr.EII;
        ((apr)localObject3).timestamp = localbjr.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).qiS = localObject3;
        break;
      case 6: 
        localObject3 = new apq();
        ((apq)localObject3).EIE = new dhz();
        if (localbjr.EZd != null)
        {
          ((apq)localObject3).EIE.activityName = localbjr.EZd.activityName;
          ((apq)localObject3).EIE.EIR = localbjr.EZd.EIR;
          ((apq)localObject3).EIE.timestamp = localbjr.EZd.timestamp;
        }
        ((apq)localObject3).EIF = localbjr.EIF;
        ((apq)localObject3).timestamp = localbjr.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).qiS = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).qiS = Integer.valueOf(localbjr.flags);
        ((a)localObject2).msgType = localbjr.msgType;
        break;
      case 500: 
        ((a)localObject2).qiS = localbjr.EZi;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).qiS = localbjr.EZi;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
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
        ((a)localObject2).qiS = Integer.valueOf(localbjr.flags);
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
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).qiS = localbjr.EZe;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).qiS = Long.valueOf(localbjr.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
        break label64;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */