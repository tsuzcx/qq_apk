package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  ReentrantLock cHm;
  final Condition pEg;
  final Condition pEh;
  
  b()
  {
    AppMethodBeat.i(121862);
    bga localbga = cbC();
    if (localbga == null)
    {
      localbga = new bga();
      localbga.blz = 10;
      a(localbga);
    }
    for (;;)
    {
      this.cHm = new ReentrantLock(true);
      this.pEg = this.cHm.newCondition();
      this.pEh = this.cHm.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localbga.blz <= 0)
      {
        localbga.blz = 10;
        a(localbga);
      }
    }
  }
  
  static void a(bga parambga)
  {
    AppMethodBeat.i(121865);
    if (parambga == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      parambga = parambga.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("key_hellhound_msgQ", parambga);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException parambga)
    {
      ad.printErrStackTrace("HellMsgQDao", parambga, "HABBYGE-MALI, HellMsgQDao, _write, crash: %s", new Object[] { parambga.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int cbB()
  {
    AppMethodBeat.i(121864);
    bga localbga = cbC();
    if (localbga == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localbga.DDN.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static bga cbC()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    bga localbga = new bga();
    try
    {
      localbga.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localbga;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HellMsgQDao", localIOException, "HABBYGE-MAli, HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a cbA()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.cHm;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (cbB() == 0) {
        this.pEg.await();
      }
      localObject2 = cbC();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    bfz localbfz;
    if (localObject2 == null)
    {
      localObject2 = new bga();
      a((bga)localObject2);
      localbfz = (bfz)((bga)localObject2).DDN.pollFirst();
      if (localbfz != null) {
        ad.i("HellMsgQDao", "HABBYGE-MALI, HellMsgQDao, dequeue, %d", new Object[] { Integer.valueOf(localbfz.msgType) });
      }
      a((bga)localObject2);
      this.pEh.signal();
      if (localbfz == null) {
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
      switch (localbfz.msgType)
      {
      case 100: 
        localObject3 = new cxd();
        ((cxd)localObject3).DDG = new dcm();
        if (localbfz.DDG != null)
        {
          ((cxd)localObject3).DDG.activityName = localbfz.DDG.activityName;
          ((cxd)localObject3).DDG.DnR = localbfz.DDG.DnR;
          ((cxd)localObject3).DDG.timestamp = localbfz.DDG.timestamp;
        }
        ((cxd)localObject3).DDH = new dcm();
        if (localbfz.DDH != null)
        {
          ((cxd)localObject3).DDH.activityName = localbfz.DDH.activityName;
          ((cxd)localObject3).DDH.DnR = localbfz.DDH.DnR;
          ((cxd)localObject3).DDH.timestamp = localbfz.DDH.timestamp;
        }
        ((cxd)localObject3).DnH = localbfz.DnH;
        ((cxd)localObject3).DnF = localbfz.DnF;
        ((cxd)localObject3).flags = localbfz.flags;
        ((cxd)localObject3).DnG = localbfz.DnG;
        ((cxd)localObject3).DDI = localbfz.DDI;
        ((cxd)localObject3).DDJ = localbfz.DDJ;
        ((cxd)localObject3).timestamp = localbfz.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).pEf = localObject3;
        break;
      case 101: 
        localObject3 = new dcm();
        if (localbfz.DDH != null)
        {
          ((dcm)localObject3).activityName = localbfz.DDH.activityName;
          ((dcm)localObject3).DnR = localbfz.DDH.DnR;
          ((dcm)localObject3).timestamp = localbfz.DDH.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).pEf = localObject3;
        break;
      case 102: 
        localObject3 = new bsf();
        ((bsf)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((bsf)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((bsf)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((bsf)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((bsf)localObject3).DDL = localbfz.DDL;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).pEf = localObject3;
        break;
      case 200: 
        localObject3 = new bup();
        ((bup)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((bup)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((bup)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((bup)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((bup)localObject3).flags = localbfz.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).pEf = localObject3;
        break;
      case 201: 
        localObject3 = new bup();
        ((bup)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((bup)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((bup)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((bup)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((bup)localObject3).flags = localbfz.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).pEf = localObject3;
        break;
      case 202: 
        localObject3 = new dcm();
        if (localbfz.DDH != null)
        {
          ((dcm)localObject3).activityName = localbfz.DDH.activityName;
          ((dcm)localObject3).DnR = localbfz.DDH.DnR;
          ((dcm)localObject3).timestamp = localbfz.DDH.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).pEf = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).pEf = localbfz.DnG;
        break;
      case 203: 
        localObject3 = new buq();
        ((buq)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((buq)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((buq)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((buq)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((buq)localObject3).DnH = localbfz.DnH;
        ((buq)localObject3).DDK = localbfz.DDK;
        ((buq)localObject3).DnF = localbfz.DnF;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).pEf = localObject3;
        break;
      case 204: 
        localObject3 = new dcm();
        if (localbfz.DDH != null)
        {
          ((dcm)localObject3).activityName = localbfz.DDH.activityName;
          ((dcm)localObject3).DnR = localbfz.DDH.DnR;
          ((dcm)localObject3).timestamp = localbfz.DDH.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).pEf = localObject3;
        break;
      case 205: 
        localObject3 = new buq();
        ((buq)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((buq)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((buq)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((buq)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((buq)localObject3).DnH = localbfz.DnH;
        ((buq)localObject3).DDK = localbfz.DDK;
        ((buq)localObject3).DnF = localbfz.DnF;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).pEf = localObject3;
        break;
      case 206: 
        localObject3 = new dcm();
        if (localbfz.DDH != null)
        {
          ((dcm)localObject3).activityName = localbfz.DDH.activityName;
          ((dcm)localObject3).DnR = localbfz.DDH.DnR;
          ((dcm)localObject3).timestamp = localbfz.DDH.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).pEf = localObject3;
        break;
      case 207: 
        localObject3 = new dcm();
        if (localbfz.DDH != null)
        {
          ((dcm)localObject3).activityName = localbfz.DDH.activityName;
          ((dcm)localObject3).DnR = localbfz.DDH.DnR;
          ((dcm)localObject3).timestamp = localbfz.DDH.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).pEf = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localbfz.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = localbfz.msgType;
        break;
      case 5: 
        localObject3 = new amo();
        ((amo)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((amo)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((amo)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((amo)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((amo)localObject3).DnG = localbfz.DnG;
        ((amo)localObject3).DnH = localbfz.DnH;
        ((amo)localObject3).DnF = localbfz.DnF;
        ((amo)localObject3).DnI = localbfz.DnI;
        ((amo)localObject3).timestamp = localbfz.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).pEf = localObject3;
        break;
      case 6: 
        localObject3 = new amn();
        ((amn)localObject3).DnE = new dcm();
        if (localbfz.DDH != null)
        {
          ((amn)localObject3).DnE.activityName = localbfz.DDH.activityName;
          ((amn)localObject3).DnE.DnR = localbfz.DDH.DnR;
          ((amn)localObject3).DnE.timestamp = localbfz.DDH.timestamp;
        }
        ((amn)localObject3).DnF = localbfz.DnF;
        ((amn)localObject3).timestamp = localbfz.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).pEf = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).pEf = Integer.valueOf(localbfz.flags);
        ((a)localObject2).msgType = localbfz.msgType;
        break;
      case 500: 
        ((a)localObject2).pEf = localbfz.DDM;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).pEf = localbfz.DDM;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
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
        ((a)localObject2).pEf = Integer.valueOf(localbfz.flags);
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
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).pEf = localbfz.DDI;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).pEf = Long.valueOf(localbfz.timestamp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */