package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  final ReentrantLock dgE;
  final Condition szi;
  final Condition szj;
  
  b()
  {
    AppMethodBeat.i(121862);
    cbk localcbk = cNI();
    if (localcbk == null)
    {
      localcbk = new cbk();
      localcbk.bwA = 10;
      a(localcbk);
    }
    for (;;)
    {
      this.dgE = new ReentrantLock(true);
      this.szi = this.dgE.newCondition();
      this.szj = this.dgE.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localcbk.bwA <= 0)
      {
        localcbk.bwA = 10;
        a(localcbk);
      }
    }
  }
  
  static void a(cbk paramcbk)
  {
    AppMethodBeat.i(121865);
    if (paramcbk == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      paramcbk = paramcbk.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("key_hellhound_msgQ", paramcbk);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException paramcbk)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", paramcbk, "HellMsgQDao, _write, crash: %s", new Object[] { paramcbk.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static int cNH()
  {
    AppMethodBeat.i(121864);
    cbk localcbk = cNI();
    if (localcbk == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localcbk.Mhm.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  static cbk cNI()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    cbk localcbk = new cbk();
    try
    {
      localcbk.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localcbk;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", localIOException, "HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  final a cNG()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.dgE;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (cNH() == 0) {
        this.szi.await();
      }
      localObject2 = cNI();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    cbj localcbj;
    if (localObject2 == null)
    {
      localObject2 = new cbk();
      a((cbk)localObject2);
      localcbj = (cbj)((cbk)localObject2).Mhm.pollFirst();
      a((cbk)localObject2);
      this.szj.signal();
      if (localcbj == null) {
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
      switch (localcbj.msgType)
      {
      case 100: 
        localObject3 = new eci();
        ((eci)localObject3).Mhd = new eih();
        if (localcbj.Mhd != null)
        {
          ((eci)localObject3).Mhd.activityName = localcbj.Mhd.activityName;
          ((eci)localObject3).Mhd.aHK = localcbj.Mhd.aHK;
          ((eci)localObject3).Mhd.timestamp = localcbj.Mhd.timestamp;
        }
        ((eci)localObject3).Mhe = new eih();
        if (localcbj.Mhe != null)
        {
          ((eci)localObject3).Mhe.activityName = localcbj.Mhe.activityName;
          ((eci)localObject3).Mhe.aHK = localcbj.Mhe.aHK;
          ((eci)localObject3).Mhe.timestamp = localcbj.Mhe.timestamp;
        }
        ((eci)localObject3).LPb = localcbj.LPb;
        ((eci)localObject3).LOY = localcbj.LOY;
        ((eci)localObject3).flags = localcbj.flags;
        ((eci)localObject3).LPa = localcbj.LPa;
        ((eci)localObject3).Mhf = localcbj.Mhf;
        ((eci)localObject3).Mhg = localcbj.Mhg;
        ((eci)localObject3).timestamp = localcbj.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).szh = localObject3;
        break;
      case 101: 
        localObject3 = new eih();
        if (localcbj.Mhe != null)
        {
          ((eih)localObject3).activityName = localcbj.Mhe.activityName;
          ((eih)localObject3).aHK = localcbj.Mhe.aHK;
          ((eih)localObject3).timestamp = localcbj.Mhe.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).szh = localObject3;
        break;
      case 102: 
        localObject3 = new cri();
        ((cri)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((cri)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((cri)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((cri)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((cri)localObject3).Mhi = localcbj.Mhi;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).szh = localObject3;
        break;
      case 200: 
        localObject3 = new cuy();
        ((cuy)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((cuy)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((cuy)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((cuy)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((cuy)localObject3).flags = localcbj.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).szh = localObject3;
        break;
      case 201: 
        localObject3 = new cuy();
        ((cuy)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((cuy)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((cuy)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((cuy)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((cuy)localObject3).flags = localcbj.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).szh = localObject3;
        break;
      case 202: 
        localObject3 = new eih();
        if (localcbj.Mhe != null)
        {
          ((eih)localObject3).activityName = localcbj.Mhe.activityName;
          ((eih)localObject3).aHK = localcbj.Mhe.aHK;
          ((eih)localObject3).timestamp = localcbj.Mhe.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).szh = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).szh = localcbj.LPa;
        break;
      case 203: 
        localObject3 = new cuz();
        ((cuz)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((cuz)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((cuz)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((cuz)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((cuz)localObject3).LPb = localcbj.LPb;
        ((cuz)localObject3).Mhh = localcbj.Mhh;
        ((cuz)localObject3).LOY = localcbj.LOY;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).szh = localObject3;
        break;
      case 204: 
        localObject3 = new eih();
        if (localcbj.Mhe != null)
        {
          ((eih)localObject3).activityName = localcbj.Mhe.activityName;
          ((eih)localObject3).aHK = localcbj.Mhe.aHK;
          ((eih)localObject3).timestamp = localcbj.Mhe.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).szh = localObject3;
        break;
      case 205: 
        localObject3 = new cuz();
        ((cuz)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((cuz)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((cuz)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((cuz)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((cuz)localObject3).LPb = localcbj.LPb;
        ((cuz)localObject3).Mhh = localcbj.Mhh;
        ((cuz)localObject3).LOY = localcbj.LOY;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).szh = localObject3;
        break;
      case 206: 
        localObject3 = new eih();
        if (localcbj.Mhe != null)
        {
          ((eih)localObject3).activityName = localcbj.Mhe.activityName;
          ((eih)localObject3).aHK = localcbj.Mhe.aHK;
          ((eih)localObject3).timestamp = localcbj.Mhe.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).szh = localObject3;
        break;
      case 207: 
        localObject3 = new eih();
        if (localcbj.Mhe != null)
        {
          ((eih)localObject3).activityName = localcbj.Mhe.activityName;
          ((eih)localObject3).aHK = localcbj.Mhe.aHK;
          ((eih)localObject3).timestamp = localcbj.Mhe.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).szh = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localcbj.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = localcbj.msgType;
        break;
      case 5: 
        localObject3 = new bfk();
        ((bfk)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((bfk)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((bfk)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((bfk)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((bfk)localObject3).LPa = localcbj.LPa;
        ((bfk)localObject3).LPb = localcbj.LPb;
        ((bfk)localObject3).LOY = localcbj.LOY;
        ((bfk)localObject3).LOZ = localcbj.LOZ;
        ((bfk)localObject3).LPc = localcbj.LPc;
        ((bfk)localObject3).timestamp = localcbj.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).szh = localObject3;
        break;
      case 6: 
        localObject3 = new bfj();
        ((bfj)localObject3).LOX = new eih();
        if (localcbj.Mhe != null)
        {
          ((bfj)localObject3).LOX.activityName = localcbj.Mhe.activityName;
          ((bfj)localObject3).LOX.aHK = localcbj.Mhe.aHK;
          ((bfj)localObject3).LOX.timestamp = localcbj.Mhe.timestamp;
        }
        ((bfj)localObject3).LOY = localcbj.LOY;
        ((bfj)localObject3).LOZ = localcbj.LOZ;
        ((bfj)localObject3).timestamp = localcbj.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).szh = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).szh = Integer.valueOf(localcbj.flags);
        ((a)localObject2).msgType = localcbj.msgType;
        break;
      case 500: 
        ((a)localObject2).szh = localcbj.Mhj;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).szh = localcbj.Mhj;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
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
        ((a)localObject2).szh = Integer.valueOf(localcbj.flags);
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
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).szh = localcbj.Mhf;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).szh = Long.valueOf(localcbj.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
      case 800: 
        ((a)localObject2).szh = localcbj.Mhk;
        ((a)localObject2).msgType = 800;
        break;
      case 801: 
        ((a)localObject2).szh = localcbj.Mhl;
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