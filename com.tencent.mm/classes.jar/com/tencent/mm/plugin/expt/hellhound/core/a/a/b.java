package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b
{
  final ReentrantLock eYl;
  final Condition wfe;
  final Condition wff;
  
  b()
  {
    AppMethodBeat.i(121862);
    cjn localcjn = dcA();
    if (localcjn == null)
    {
      localcjn = new cjn();
      localcjn.bgc = 10;
      a(localcjn);
    }
    for (;;)
    {
      this.eYl = new ReentrantLock(true);
      this.wfe = this.eYl.newCondition();
      this.wff = this.eYl.newCondition();
      AppMethodBeat.o(121862);
      return;
      if (localcjn.bgc <= 0)
      {
        localcjn.bgc = 10;
        a(localcjn);
      }
    }
  }
  
  static void a(cjn paramcjn)
  {
    AppMethodBeat.i(121865);
    if (paramcjn == null)
    {
      AppMethodBeat.o(121865);
      return;
    }
    try
    {
      paramcjn = paramcjn.toByteArray();
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("key_hellhound_msgQ", paramcjn);
      AppMethodBeat.o(121865);
      return;
    }
    catch (IOException paramcjn)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", paramcjn, "HellMsgQDao, _write, crash: %s", new Object[] { paramcjn.getMessage() });
      AppMethodBeat.o(121865);
    }
  }
  
  static cjn dcA()
  {
    AppMethodBeat.i(121866);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("key_hellhound_msgQ");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121866);
      return null;
    }
    cjn localcjn = new cjn();
    try
    {
      localcjn.parseFrom(arrayOfByte);
      AppMethodBeat.o(121866);
      return localcjn;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", localIOException, "HellMsgQDao, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(121866);
    }
    return null;
  }
  
  static int dcz()
  {
    AppMethodBeat.i(121864);
    cjn localcjn = dcA();
    if (localcjn == null)
    {
      AppMethodBeat.o(121864);
      return 0;
    }
    int i = localcjn.Tra.size();
    AppMethodBeat.o(121864);
    return i;
  }
  
  final a dcy()
  {
    AppMethodBeat.i(121863);
    ReentrantLock localReentrantLock = this.eYl;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (dcz() == 0) {
        this.wfe.await();
      }
      localObject2 = dcA();
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(121863);
    }
    Object localObject2;
    label64:
    cjm localcjm;
    if (localObject2 == null)
    {
      localObject2 = new cjn();
      a((cjn)localObject2);
      localcjm = (cjm)((cjn)localObject2).Tra.pollFirst();
      a((cjn)localObject2);
      this.wff.signal();
      if (localcjm == null) {
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
      switch (localcjm.msgType)
      {
      case 100: 
        localObject3 = new emj();
        ((emj)localObject3).TqR = new esj();
        if (localcjm.TqR != null)
        {
          ((emj)localObject3).TqR.activityName = localcjm.TqR.activityName;
          ((emj)localObject3).TqR.aNf = localcjm.TqR.aNf;
          ((emj)localObject3).TqR.timestamp = localcjm.TqR.timestamp;
        }
        ((emj)localObject3).TqS = new esj();
        if (localcjm.TqS != null)
        {
          ((emj)localObject3).TqS.activityName = localcjm.TqS.activityName;
          ((emj)localObject3).TqS.aNf = localcjm.TqS.aNf;
          ((emj)localObject3).TqS.timestamp = localcjm.TqS.timestamp;
        }
        ((emj)localObject3).SXv = localcjm.SXv;
        ((emj)localObject3).SXs = localcjm.SXs;
        ((emj)localObject3).flags = localcjm.flags;
        ((emj)localObject3).SXu = localcjm.SXu;
        ((emj)localObject3).TqT = localcjm.TqT;
        ((emj)localObject3).TqU = localcjm.TqU;
        ((emj)localObject3).timestamp = localcjm.timestamp;
        ((a)localObject2).msgType = 100;
        ((a)localObject2).wfd = localObject3;
        break;
      case 101: 
        localObject3 = new esj();
        if (localcjm.TqS != null)
        {
          ((esj)localObject3).activityName = localcjm.TqS.activityName;
          ((esj)localObject3).aNf = localcjm.TqS.aNf;
          ((esj)localObject3).timestamp = localcjm.TqS.timestamp;
        }
        ((a)localObject2).msgType = 101;
        ((a)localObject2).wfd = localObject3;
        break;
      case 102: 
        localObject3 = new czz();
        ((czz)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((czz)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((czz)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((czz)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((czz)localObject3).TqW = localcjm.TqW;
        ((a)localObject2).msgType = 102;
        ((a)localObject2).wfd = localObject3;
        break;
      case 200: 
        localObject3 = new dei();
        ((dei)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((dei)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((dei)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((dei)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((dei)localObject3).flags = localcjm.flags;
        ((a)localObject2).msgType = 200;
        ((a)localObject2).wfd = localObject3;
        break;
      case 201: 
        localObject3 = new dei();
        ((dei)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((dei)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((dei)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((dei)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((dei)localObject3).flags = localcjm.flags;
        ((a)localObject2).msgType = 201;
        ((a)localObject2).wfd = localObject3;
        break;
      case 202: 
        localObject3 = new esj();
        if (localcjm.TqS != null)
        {
          ((esj)localObject3).activityName = localcjm.TqS.activityName;
          ((esj)localObject3).aNf = localcjm.TqS.aNf;
          ((esj)localObject3).timestamp = localcjm.TqS.timestamp;
        }
        ((a)localObject2).msgType = 202;
        ((a)localObject2).wfd = localObject3;
        break;
      case 222: 
        ((a)localObject2).msgType = 222;
        ((a)localObject2).wfd = localcjm.SXu;
        break;
      case 203: 
        localObject3 = new dej();
        ((dej)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((dej)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((dej)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((dej)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((dej)localObject3).SXv = localcjm.SXv;
        ((dej)localObject3).TqV = localcjm.TqV;
        ((dej)localObject3).SXs = localcjm.SXs;
        ((a)localObject2).msgType = 203;
        ((a)localObject2).wfd = localObject3;
        break;
      case 204: 
        localObject3 = new esj();
        if (localcjm.TqS != null)
        {
          ((esj)localObject3).activityName = localcjm.TqS.activityName;
          ((esj)localObject3).aNf = localcjm.TqS.aNf;
          ((esj)localObject3).timestamp = localcjm.TqS.timestamp;
        }
        ((a)localObject2).msgType = 204;
        ((a)localObject2).wfd = localObject3;
        break;
      case 205: 
        localObject3 = new dej();
        ((dej)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((dej)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((dej)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((dej)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((dej)localObject3).SXv = localcjm.SXv;
        ((dej)localObject3).TqV = localcjm.TqV;
        ((dej)localObject3).SXs = localcjm.SXs;
        ((a)localObject2).msgType = 205;
        ((a)localObject2).wfd = localObject3;
        break;
      case 206: 
        localObject3 = new esj();
        if (localcjm.TqS != null)
        {
          ((esj)localObject3).activityName = localcjm.TqS.activityName;
          ((esj)localObject3).aNf = localcjm.TqS.aNf;
          ((esj)localObject3).timestamp = localcjm.TqS.timestamp;
        }
        ((a)localObject2).msgType = 206;
        ((a)localObject2).wfd = localObject3;
        break;
      case 207: 
        localObject3 = new esj();
        if (localcjm.TqS != null)
        {
          ((esj)localObject3).activityName = localcjm.TqS.activityName;
          ((esj)localObject3).aNf = localcjm.TqS.aNf;
          ((esj)localObject3).timestamp = localcjm.TqS.timestamp;
        }
        ((a)localObject2).msgType = 207;
        ((a)localObject2).wfd = localObject3;
        break;
      case 600: 
        ((a)localObject2).msgType = localcjm.msgType;
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 300: 
      case 301: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = localcjm.msgType;
        break;
      case 5: 
        localObject3 = new bmo();
        ((bmo)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((bmo)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((bmo)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((bmo)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((bmo)localObject3).SXu = localcjm.SXu;
        ((bmo)localObject3).SXv = localcjm.SXv;
        ((bmo)localObject3).SXs = localcjm.SXs;
        ((bmo)localObject3).SXt = localcjm.SXt;
        ((bmo)localObject3).SXw = localcjm.SXw;
        ((bmo)localObject3).timestamp = localcjm.timestamp;
        ((a)localObject2).msgType = 5;
        ((a)localObject2).wfd = localObject3;
        break;
      case 6: 
        localObject3 = new bmn();
        ((bmn)localObject3).SXr = new esj();
        if (localcjm.TqS != null)
        {
          ((bmn)localObject3).SXr.activityName = localcjm.TqS.activityName;
          ((bmn)localObject3).SXr.aNf = localcjm.TqS.aNf;
          ((bmn)localObject3).SXr.timestamp = localcjm.TqS.timestamp;
        }
        ((bmn)localObject3).SXs = localcjm.SXs;
        ((bmn)localObject3).SXt = localcjm.SXt;
        ((bmn)localObject3).timestamp = localcjm.timestamp;
        ((a)localObject2).msgType = 6;
        ((a)localObject2).wfd = localObject3;
        break;
      case 400: 
      case 401: 
      case 402: 
      case 403: 
        ((a)localObject2).wfd = Integer.valueOf(localcjm.flags);
        ((a)localObject2).msgType = localcjm.msgType;
        break;
      case 500: 
        ((a)localObject2).wfd = localcjm.TqX;
        ((a)localObject2).msgType = 500;
        break;
      case 501: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 501;
        break;
      case 502: 
        ((a)localObject2).wfd = localcjm.TqX;
        ((a)localObject2).msgType = 502;
        break;
      case 504: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 504;
        break;
      case 503: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 503;
        break;
      case 217: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 217;
        break;
      case 219: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 219;
        break;
      case 218: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 218;
        break;
      case 208: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 208;
        break;
      case 211: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 211;
        break;
      case 212: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
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
        ((a)localObject2).wfd = Integer.valueOf(localcjm.flags);
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
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 704;
        break;
      case 708: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 708;
        break;
      case 712: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 712;
        break;
      case 724: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 724;
        break;
      case 744: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 744;
        break;
      case 728: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 728;
        break;
      case 732: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 732;
        break;
      case 736: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 736;
        break;
      case 740: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 740;
        break;
      case 716: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 716;
        break;
      case 720: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 720;
        break;
      case 705: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 705;
        break;
      case 709: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 709;
        break;
      case 713: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 713;
        break;
      case 725: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 725;
        break;
      case 745: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 745;
        break;
      case 729: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 729;
        break;
      case 733: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 733;
        break;
      case 741: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 741;
        break;
      case 737: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 737;
        break;
      case 717: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 717;
        break;
      case 721: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 721;
        break;
      case 706: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 706;
        break;
      case 710: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 710;
        break;
      case 714: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 714;
        break;
      case 726: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 726;
        break;
      case 746: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 746;
        break;
      case 730: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 730;
        break;
      case 734: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 734;
        break;
      case 738: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 738;
        break;
      case 742: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 742;
        break;
      case 718: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 718;
        break;
      case 722: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 722;
        break;
      case 707: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 707;
        break;
      case 711: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 711;
        break;
      case 715: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 715;
        break;
      case 727: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 727;
        break;
      case 747: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 747;
        break;
      case 731: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 731;
        break;
      case 735: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 735;
        break;
      case 739: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 739;
        break;
      case 743: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 743;
        break;
      case 719: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 719;
        break;
      case 723: 
        ((a)localObject2).wfd = localcjm.TqT;
        ((a)localObject2).msgType = 723;
        break;
      case 220: 
        ((a)localObject2).wfd = Long.valueOf(localcjm.timestamp);
        ((a)localObject2).msgType = 220;
        break;
      case 221: 
        ((a)localObject2).msgType = 221;
        break;
      case 800: 
        ((a)localObject2).wfd = localcjm.TqY;
        ((a)localObject2).msgType = 800;
        break;
      case 801: 
        ((a)localObject2).wfd = localcjm.TqZ;
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