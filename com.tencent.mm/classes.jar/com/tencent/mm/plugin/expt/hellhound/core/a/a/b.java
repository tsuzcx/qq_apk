package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  ReentrantLock cQj;
  final Condition qYR;
  final Condition qYS;
  
  b()
  {
    AppMethodBeat.i(121862);
    bos localbos = cpp();
    if (localbos == null)
    {
      localbos = new bos();
      localbos.bwz = 10;
      a(localbos);
    }
    for (;;)
    {
      this.cQj = new ReentrantLock(true);
      this.qYR = this.cQj.newCondition();
      this.qYS = this.cQj.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localbos.bwz <= 0)
      {
        localbos.bwz = 10;
        a(localbos);
      }
    }
  }
  
  static void a(bos parambos)
  {
    AppMethodBeat.i(121865);
    if (parambos == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      parambos = parambos.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("key_hellhound_msgQ", parambos);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException parambos)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", parambos, "HellMsgQDao, _write, crash: %s", new Object[] { parambos.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int cpo()
  {
    AppMethodBeat.i(121864);
    bos localbos = cpp();
    if (localbos == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localbos.Hcj.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static bos cpp()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    bos localbos = new bos();
    try
    {
      localbos.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localbos;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", localIOException, "HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a cpn()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.cQj;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (cpo() == 0) {
        this.qYR.await();
      }
      localObject2 = cpp();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    bor localbor;
    if (localObject2 == null)
    {
      localObject2 = new bos();
      a((bos)localObject2);
      localbor = (bor)((bos)localObject2).Hcj.pollFirst();
      if (localbor != null) {
        ae.i("HABBYGE-MALI.HellMsgQDao", "HellMsgQDao, dequeue, %d,", new Object[] { Integer.valueOf(localbor.msgType) });
      }
      a((bos)localObject2);
      this.qYS.signal();
      if (localbor == null) {
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
      switch (localbor.msgType)
      {
      case 100: 
        localObject3 = new dix();
        ((dix)localObject3).Hca = new dol();
        if (localbor.Hca != null)
        {
          ((dix)localObject3).Hca.activityName = localbor.Hca.activityName;
          ((dix)localObject3).Hca.aHQ = localbor.Hca.aHQ;
          ((dix)localObject3).Hca.timestamp = localbor.Hca.timestamp;
        }
        ((dix)localObject3).Hcb = new dol();
        if (localbor.Hcb != null)
        {
          ((dix)localObject3).Hcb.activityName = localbor.Hcb.activityName;
          ((dix)localObject3).Hcb.aHQ = localbor.Hcb.aHQ;
          ((dix)localObject3).Hcb.timestamp = localbor.Hcb.timestamp;
        }
        ((dix)localObject3).GKX = localbor.GKX;
        ((dix)localObject3).GKU = localbor.GKU;
        ((dix)localObject3).flags = localbor.flags;
        ((dix)localObject3).GKW = localbor.GKW;
        ((dix)localObject3).Hcc = localbor.Hcc;
        ((dix)localObject3).Hcd = localbor.Hcd;
        ((dix)localObject3).timestamp = localbor.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 101: 
        localObject3 = new dol();
        if (localbor.Hcb != null)
        {
          ((dol)localObject3).activityName = localbor.Hcb.activityName;
          ((dol)localObject3).aHQ = localbor.Hcb.aHQ;
          ((dol)localObject3).timestamp = localbor.Hcb.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 102: 
        localObject3 = new ccg();
        ((ccg)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((ccg)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((ccg)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((ccg)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((ccg)localObject3).Hcf = localbor.Hcf;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 200: 
        localObject3 = new cer();
        ((cer)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((cer)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((cer)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((cer)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((cer)localObject3).flags = localbor.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 201: 
        localObject3 = new cer();
        ((cer)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((cer)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((cer)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((cer)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((cer)localObject3).flags = localbor.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 202: 
        localObject3 = new dol();
        if (localbor.Hcb != null)
        {
          ((dol)localObject3).activityName = localbor.Hcb.activityName;
          ((dol)localObject3).aHQ = localbor.Hcb.aHQ;
          ((dol)localObject3).timestamp = localbor.Hcb.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).qYQ = localbor.GKW;
        break;
      case 203: 
        localObject3 = new ces();
        ((ces)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((ces)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((ces)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((ces)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((ces)localObject3).GKX = localbor.GKX;
        ((ces)localObject3).Hce = localbor.Hce;
        ((ces)localObject3).GKU = localbor.GKU;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 204: 
        localObject3 = new dol();
        if (localbor.Hcb != null)
        {
          ((dol)localObject3).activityName = localbor.Hcb.activityName;
          ((dol)localObject3).aHQ = localbor.Hcb.aHQ;
          ((dol)localObject3).timestamp = localbor.Hcb.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 205: 
        localObject3 = new ces();
        ((ces)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((ces)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((ces)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((ces)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((ces)localObject3).GKX = localbor.GKX;
        ((ces)localObject3).Hce = localbor.Hce;
        ((ces)localObject3).GKU = localbor.GKU;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 206: 
        localObject3 = new dol();
        if (localbor.Hcb != null)
        {
          ((dol)localObject3).activityName = localbor.Hcb.activityName;
          ((dol)localObject3).aHQ = localbor.Hcb.aHQ;
          ((dol)localObject3).timestamp = localbor.Hcb.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 207: 
        localObject3 = new dol();
        if (localbor.Hcb != null)
        {
          ((dol)localObject3).activityName = localbor.Hcb.activityName;
          ((dol)localObject3).aHQ = localbor.Hcb.aHQ;
          ((dol)localObject3).timestamp = localbor.Hcb.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localbor.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = localbor.msgType;
        break;
      case 5: 
        localObject3 = new aub();
        ((aub)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((aub)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((aub)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((aub)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((aub)localObject3).GKW = localbor.GKW;
        ((aub)localObject3).GKX = localbor.GKX;
        ((aub)localObject3).GKU = localbor.GKU;
        ((aub)localObject3).GKV = localbor.GKV;
        ((aub)localObject3).GKY = localbor.GKY;
        ((aub)localObject3).timestamp = localbor.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 6: 
        localObject3 = new aua();
        ((aua)localObject3).GKT = new dol();
        if (localbor.Hcb != null)
        {
          ((aua)localObject3).GKT.activityName = localbor.Hcb.activityName;
          ((aua)localObject3).GKT.aHQ = localbor.Hcb.aHQ;
          ((aua)localObject3).GKT.timestamp = localbor.Hcb.timestamp;
        }
        ((aua)localObject3).GKU = localbor.GKU;
        ((aua)localObject3).GKV = localbor.GKV;
        ((aua)localObject3).timestamp = localbor.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).qYQ = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).qYQ = Integer.valueOf(localbor.flags);
        ((a)localObject2).msgType = localbor.msgType;
        break;
      case 500: 
        ((a)localObject2).qYQ = localbor.Hcg;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).qYQ = localbor.Hcg;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
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
        ((a)localObject2).qYQ = Integer.valueOf(localbor.flags);
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
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).qYQ = localbor.Hcc;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).qYQ = Long.valueOf(localbor.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
      case 800: 
        ((a)localObject2).qYQ = localbor.Hch;
        ((a)localObject2).msgType = 800;
        break;
      case 801: 
        ((a)localObject2).qYQ = localbor.Hci;
        ((a)localObject2).msgType = 801;
        break;
        break label64;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */