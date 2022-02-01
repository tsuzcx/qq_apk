package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  ReentrantLock cPz;
  final Condition qQT;
  final Condition qQU;
  
  b()
  {
    AppMethodBeat.i(121862);
    boa localboa = cnN();
    if (localboa == null)
    {
      localboa = new boa();
      localboa.bwz = 10;
      a(localboa);
    }
    for (;;)
    {
      this.cPz = new ReentrantLock(true);
      this.qQT = this.cPz.newCondition();
      this.qQU = this.cPz.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localboa.bwz <= 0)
      {
        localboa.bwz = 10;
        a(localboa);
      }
    }
  }
  
  static void a(boa paramboa)
  {
    AppMethodBeat.i(121865);
    if (paramboa == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      paramboa = paramboa.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("key_hellhound_msgQ", paramboa);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException paramboa)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", paramboa, "HellMsgQDao, _write, crash: %s", new Object[] { paramboa.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int cnM()
  {
    AppMethodBeat.i(121864);
    boa localboa = cnN();
    if (localboa == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localboa.GIH.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static boa cnN()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    boa localboa = new boa();
    try
    {
      localboa.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localboa;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", localIOException, "HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a cnL()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.cPz;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (cnM() == 0) {
        this.qQT.await();
      }
      localObject2 = cnN();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    bnz localbnz;
    if (localObject2 == null)
    {
      localObject2 = new boa();
      a((boa)localObject2);
      localbnz = (bnz)((boa)localObject2).GIH.pollFirst();
      if (localbnz != null) {
        ad.i("HABBYGE-MALI.HellMsgQDao", "HellMsgQDao, dequeue, %d,", new Object[] { Integer.valueOf(localbnz.msgType) });
      }
      a((boa)localObject2);
      this.qQU.signal();
      if (localbnz == null) {
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
      switch (localbnz.msgType)
      {
      case 100: 
        localObject3 = new dic();
        ((dic)localObject3).GIy = new dno();
        if (localbnz.GIy != null)
        {
          ((dic)localObject3).GIy.activityName = localbnz.GIy.activityName;
          ((dic)localObject3).GIy.aHQ = localbnz.GIy.aHQ;
          ((dic)localObject3).GIy.timestamp = localbnz.GIy.timestamp;
        }
        ((dic)localObject3).GIz = new dno();
        if (localbnz.GIz != null)
        {
          ((dic)localObject3).GIz.activityName = localbnz.GIz.activityName;
          ((dic)localObject3).GIz.aHQ = localbnz.GIz.aHQ;
          ((dic)localObject3).GIz.timestamp = localbnz.GIz.timestamp;
        }
        ((dic)localObject3).Grz = localbnz.Grz;
        ((dic)localObject3).Grw = localbnz.Grw;
        ((dic)localObject3).flags = localbnz.flags;
        ((dic)localObject3).Gry = localbnz.Gry;
        ((dic)localObject3).GIA = localbnz.GIA;
        ((dic)localObject3).GIB = localbnz.GIB;
        ((dic)localObject3).timestamp = localbnz.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).qQS = localObject3;
        break;
      case 101: 
        localObject3 = new dno();
        if (localbnz.GIz != null)
        {
          ((dno)localObject3).activityName = localbnz.GIz.activityName;
          ((dno)localObject3).aHQ = localbnz.GIz.aHQ;
          ((dno)localObject3).timestamp = localbnz.GIz.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).qQS = localObject3;
        break;
      case 102: 
        localObject3 = new cbm();
        ((cbm)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((cbm)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((cbm)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((cbm)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((cbm)localObject3).GID = localbnz.GID;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).qQS = localObject3;
        break;
      case 200: 
        localObject3 = new cdx();
        ((cdx)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((cdx)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((cdx)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((cdx)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((cdx)localObject3).flags = localbnz.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).qQS = localObject3;
        break;
      case 201: 
        localObject3 = new cdx();
        ((cdx)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((cdx)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((cdx)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((cdx)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((cdx)localObject3).flags = localbnz.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).qQS = localObject3;
        break;
      case 202: 
        localObject3 = new dno();
        if (localbnz.GIz != null)
        {
          ((dno)localObject3).activityName = localbnz.GIz.activityName;
          ((dno)localObject3).aHQ = localbnz.GIz.aHQ;
          ((dno)localObject3).timestamp = localbnz.GIz.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).qQS = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).qQS = localbnz.Gry;
        break;
      case 203: 
        localObject3 = new cdy();
        ((cdy)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((cdy)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((cdy)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((cdy)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((cdy)localObject3).Grz = localbnz.Grz;
        ((cdy)localObject3).GIC = localbnz.GIC;
        ((cdy)localObject3).Grw = localbnz.Grw;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).qQS = localObject3;
        break;
      case 204: 
        localObject3 = new dno();
        if (localbnz.GIz != null)
        {
          ((dno)localObject3).activityName = localbnz.GIz.activityName;
          ((dno)localObject3).aHQ = localbnz.GIz.aHQ;
          ((dno)localObject3).timestamp = localbnz.GIz.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).qQS = localObject3;
        break;
      case 205: 
        localObject3 = new cdy();
        ((cdy)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((cdy)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((cdy)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((cdy)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((cdy)localObject3).Grz = localbnz.Grz;
        ((cdy)localObject3).GIC = localbnz.GIC;
        ((cdy)localObject3).Grw = localbnz.Grw;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).qQS = localObject3;
        break;
      case 206: 
        localObject3 = new dno();
        if (localbnz.GIz != null)
        {
          ((dno)localObject3).activityName = localbnz.GIz.activityName;
          ((dno)localObject3).aHQ = localbnz.GIz.aHQ;
          ((dno)localObject3).timestamp = localbnz.GIz.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).qQS = localObject3;
        break;
      case 207: 
        localObject3 = new dno();
        if (localbnz.GIz != null)
        {
          ((dno)localObject3).activityName = localbnz.GIz.activityName;
          ((dno)localObject3).aHQ = localbnz.GIz.aHQ;
          ((dno)localObject3).timestamp = localbnz.GIz.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).qQS = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localbnz.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = localbnz.msgType;
        break;
      case 5: 
        localObject3 = new atl();
        ((atl)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((atl)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((atl)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((atl)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((atl)localObject3).Gry = localbnz.Gry;
        ((atl)localObject3).Grz = localbnz.Grz;
        ((atl)localObject3).Grw = localbnz.Grw;
        ((atl)localObject3).Grx = localbnz.Grx;
        ((atl)localObject3).GrA = localbnz.GrA;
        ((atl)localObject3).timestamp = localbnz.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).qQS = localObject3;
        break;
      case 6: 
        localObject3 = new atk();
        ((atk)localObject3).Grv = new dno();
        if (localbnz.GIz != null)
        {
          ((atk)localObject3).Grv.activityName = localbnz.GIz.activityName;
          ((atk)localObject3).Grv.aHQ = localbnz.GIz.aHQ;
          ((atk)localObject3).Grv.timestamp = localbnz.GIz.timestamp;
        }
        ((atk)localObject3).Grw = localbnz.Grw;
        ((atk)localObject3).Grx = localbnz.Grx;
        ((atk)localObject3).timestamp = localbnz.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).qQS = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).qQS = Integer.valueOf(localbnz.flags);
        ((a)localObject2).msgType = localbnz.msgType;
        break;
      case 500: 
        ((a)localObject2).qQS = localbnz.GIE;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).qQS = localbnz.GIE;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
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
        ((a)localObject2).qQS = Integer.valueOf(localbnz.flags);
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
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).qQS = localbnz.GIA;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).qQS = Long.valueOf(localbnz.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
      case 800: 
        ((a)localObject2).qQS = localbnz.GIF;
        ((a)localObject2).msgType = 800;
        break;
      case 801: 
        ((a)localObject2).qQS = localbnz.GIG;
        ((a)localObject2).msgType = 801;
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