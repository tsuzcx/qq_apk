package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
{
  private static boolean oKK = false;
  private static boolean oMj = false;
  public byte[] bitmapData;
  public b.b oJO;
  public com.tencent.mm.plugin.backup.b.b.d oKF;
  public boolean oLH;
  public b.c oLX;
  public final j.a oLY;
  private LinkedList<String> oMc;
  private com.tencent.mm.plugin.backup.c.b oMd;
  public com.tencent.mm.plugin.backup.c.c oMe;
  private long oMf;
  private long oMg;
  public boolean oMh;
  public int oMi;
  private int oMk;
  private int oMl;
  private int oMm;
  public final com.tencent.mm.plugin.backup.g.b.d oMn;
  public e oMo;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.oMf = 0L;
    this.oMg = 0L;
    this.oMh = false;
    this.oMi = 0;
    this.oLH = false;
    this.oMm = 0;
    this.oMn = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21339);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((paramAnonymousBoolean) && (paramAnonymousArrayOfByte != null) && (10011 == paramAnonymousInt1))
          {
            i = b.cfv().ceM().oJc;
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            }
          }
        }
        Object localObject;
        for (;;)
        {
          if (paramAnonymousInt1 == 1)
          {
            localObject = (v)g.a(new v(), paramAnonymousArrayOfByte);
            if (localObject == null)
            {
              Log.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
              b.cfv().ceM().oJc = -5;
              d.this.xI(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.cfv().cfw().stop();
              b.cfv().ceM().oJc = -100;
              d.this.xI(-100);
              continue;
              b.cfv().cfw().stop();
              continue;
              d.this.cancel(true);
              b.cfv().cfw().stop();
              b.cfv().ceM().oJc = -4;
              d.this.xI(-4);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).oJR == 0L)) {
                continue;
              }
              long l = Util.milliSecondsToNow(d.a(d.this).oJR);
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).cfe()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (Util.isNullOrNil(b.cfv().oIU)) {
              b.cfv().oIU = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.cfv().oIU))
            {
              Log.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.cfv().oIU, ((v)localObject).ID });
              d.this.cancel(false);
              b.cfv().ceM().oJc = -5;
              d.this.xI(-5);
              AppMethodBeat.o(21339);
              return;
            }
            Log.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).oUu) });
            if (((v)localObject).oUu == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).oTm.zy;
              if (!b.cfv().oIV.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.ceQ()))))
              {
                d.Bg(paramAnonymousInt2);
                b.cfv().ceM().oJc = -5;
                d.this.xI(-5);
              }
              if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.oIM)
              {
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 103L, 1L, false);
                b.cfv().ceM().oJc = -12;
                d.this.xI(-12);
                AppMethodBeat.o(21339);
                return;
              }
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if (((v)localObject).oUv == com.tencent.mm.plugin.backup.b.c.oIO)
              {
                paramAnonymousBoolean = d.cfL();
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify client resume move! isResumeDataExist:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                if (paramAnonymousBoolean)
                {
                  b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIO;
                  d.this.G(null);
                  d.this.jB(false);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIN;
              if ((d.bHp()) || (d.oKK))
              {
                if ((d.bHp()) && (d.oKK) && ((((v)localObject).oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0) && ((((v)localObject).oUw & com.tencent.mm.plugin.backup.b.c.oIS) == 0))
                {
                  b.cfv().ceM().oJc = -31;
                  d.this.xI(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.bHp()) && ((((v)localObject).oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0))
                {
                  b.cfv().ceM().oJc = -32;
                  d.this.xI(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.oKK) && ((((v)localObject).oUw & com.tencent.mm.plugin.backup.b.c.oIS) == 0))
                {
                  b.cfv().ceM().oJc = -33;
                  d.this.xI(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.jB(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).oUu == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).oTm.zy;
              if (!b.cfv().oIW.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.ceQ()))))
              {
                Log.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.cfv().ceM().oJc = -5;
                d.this.xI(-5);
              }
              Log.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.cfv().ceM().oJc = 2;
              d.this.xI(2);
            }
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 3)
        {
          localObject = (n)g.a(new n(), paramAnonymousArrayOfByte);
          if (localObject == null) {
            Log.e("MicroMsg.BackupMoveServer", "startReq parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
          }
          for (;;)
          {
            d.c(d.this, paramAnonymousInt2);
            if (!b.cfv().cfz().oLj) {
              break;
            }
            d.this.cfM();
            AppMethodBeat.o(21339);
            return;
            if (((n)localObject).oTR != null)
            {
              localObject = ((n)localObject).oTR.oTI;
              paramAnonymousArrayOfByte = (byte[])localObject;
              if (localObject == null) {
                paramAnonymousArrayOfByte = "";
              }
              Log.i("MicroMsg.BackupMoveServer", "startReq new device is %s", new Object[] { paramAnonymousArrayOfByte });
            }
          }
          d.b(d.this);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 9)
        {
          localObject = (com.tencent.mm.plugin.backup.i.e)g.a(new com.tencent.mm.plugin.backup.i.e(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            Log.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
            AppMethodBeat.o(21339);
            return;
          }
          Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).oPN) });
          paramAnonymousArrayOfByte = (com.tencent.mm.plugin.backup.i.f)g.a(new com.tencent.mm.plugin.backup.i.f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.oPN = ((com.tencent.mm.plugin.backup.i.e)localObject).oPN;
          try
          {
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.D(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify buf to BackupHeartBeatResponse err.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 10)
        {
          localObject = new com.tencent.mm.plugin.backup.i.f();
          try
          {
            ((com.tencent.mm.plugin.backup.i.f)localObject).parseFrom(paramAnonymousArrayOfByte);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify heartbeatResp parse from buf error.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 5)
        {
          Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive command cancel");
          d.this.cancel(true);
          b.cfv().ceM().oJc = -100;
          d.this.xI(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
            b.cfv().ceM().oJc = -5;
            d.this.xI(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = g.b(((j)localObject).oTB, ((j)localObject).oTC);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.cfF();
            b.cfv().ceM().oJc = -21;
            d.this.xI(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.cgs();
          if ((d.a(d.this) == null) || (d.a(d.this).oJN)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.cfv(), 2, d.c(d.this)));
          }
          d.a(d.this).jy(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.cfv().ceM().oJk, d.oKK);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.oJO = new b.b()
    {
      public final void Ba(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        if (d.d(d.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21340);
              if (d.d(d.this) != null) {
                d.d(d.this).Ba(paramAnonymousInt);
              }
              AppMethodBeat.o(21340);
            }
          });
        }
        AppMethodBeat.o(21341);
      }
      
      public final void ceI()
      {
        AppMethodBeat.i(21342);
        b.cfv();
        b.ceR().edit().putStringSet("BACKUP_SELECT_SESSION_LIST", null);
        com.tencent.mm.plugin.backup.g.b.Bn(21);
        AppMethodBeat.o(21342);
      }
      
      public final void ceJ()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
    };
    this.oLX = new b.c()
    {
      public final void cfK()
      {
        AppMethodBeat.i(21344);
        Log.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.cgt();
        b.cfv().ceO();
        AppMethodBeat.o(21344);
      }
    };
    this.oLY = new j.a()
    {
      public final void Bf(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.cfv().ceM().oJc;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            Log.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.cfv().ceM().oJc = 4;
            d.this.xI(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.cfv().ceM().oJc = 14;
          d.this.xI(14);
        }
        AppMethodBeat.o(21346);
      }
      
      public final void cfI()
      {
        AppMethodBeat.i(21345);
        d.this.xI(b.cfv().ceM().oJc);
        AppMethodBeat.o(21345);
      }
      
      public final void cfJ()
      {
        AppMethodBeat.i(21347);
        int i = b.cfv().ceM().oJc;
        Log.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.cfv().cfw().stop();
          b.cfv().ceM().oJc = -4;
          d.this.xI(-4);
        }
        AppMethodBeat.o(21347);
      }
    };
    this.oMo = new e(new e.a()
    {
      public final void n(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.xI(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.cfv().ceM());
    AppMethodBeat.o(21349);
  }
  
  private void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.oMc.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.oTB = this.oMc;
    locali.oTC = new LinkedList();
    Iterator localIterator = this.oMc.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.oTC.add(Long.valueOf(paramLong1));
      locali.oTC.add(Long.valueOf(paramLong2));
    }
    try
    {
      Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.oMc.size()) });
      com.tencent.mm.plugin.backup.g.b.N(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void cfF()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.cfv().oIU;
    try
    {
      Log.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static boolean cfL()
  {
    AppMethodBeat.i(231593);
    b.cfv();
    Set localSet = b.ceR().getStringSet("BACKUP_SELECT_SESSION_LIST", null);
    if ((localSet == null) || (localSet.size() <= 0))
    {
      AppMethodBeat.o(231593);
      return false;
    }
    AppMethodBeat.o(231593);
    return true;
  }
  
  public static String cfN()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.cgw();
    AppMethodBeat.o(21358);
    return str;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21352);
    Log.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.cfv();
    SharedPreferences.Editor localEditor = b.ceR().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
    AppMethodBeat.o(21352);
  }
  
  public final void G(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(231594);
    this.oMc = new LinkedList();
    Object localObject;
    if (Util.isNullOrNil(paramLinkedList))
    {
      b.cfv();
      localObject = b.ceR().getStringSet("BACKUP_SELECT_SESSION_LIST", new HashSet());
      this.oMc.addAll((Collection)localObject);
      b.cfv();
      if (b.ceR().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
        break label284;
      }
      oMj = true;
      label80:
      b.cfv();
      this.oMf = b.ceR().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      b.cfv();
      this.oMg = b.ceR().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      b.cfv();
      if (b.ceR().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label291;
      }
      oKK = true;
      label144:
      if (paramLinkedList != null) {
        break label298;
      }
    }
    label284:
    label291:
    label298:
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(this.oMf), Long.valueOf(this.oMg), Boolean.valueOf(oKK) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZF, Boolean.TRUE);
      AppMethodBeat.o(231594);
      return;
      b.cfv();
      localObject = b.ceR().edit();
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(paramLinkedList);
      ((SharedPreferences.Editor)localObject).putStringSet("BACKUP_SELECT_SESSION_LIST", localHashSet);
      ((SharedPreferences.Editor)localObject).commit();
      this.oMc.addAll(localHashSet);
      break;
      oMj = false;
      break label80;
      oKK = false;
      break label144;
    }
  }
  
  public final void a(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(21350);
    if (paramd.equals(this.oKF)) {
      this.oKF = null;
    }
    AppMethodBeat.o(21350);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    Log.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { MMStack.getCaller() });
    if (!paramBoolean) {
      cfF();
    }
    if (this.oMe != null) {
      this.oMe.cancel();
    }
    if (this.oMd != null)
    {
      this.oMd.cancel();
      this.oMd = null;
    }
    Log.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.cgt();
    com.tencent.mm.plugin.backup.g.b.cgv();
    b.cfv().ceO();
    AppMethodBeat.o(21351);
  }
  
  public final void cfM()
  {
    AppMethodBeat.i(21355);
    Log.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.oMh = false;
    b.cfv().ceM().oJc = 12;
    xI(12);
    com.tencent.mm.plugin.backup.h.d.cgP().cgS();
    if (this.oMc == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    Log.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.oMc.size()) });
    o localo = new o();
    localo.ID = b.cfv().oIU;
    localo.oTU = this.oMc.size();
    localo.oTV = b.cfv().cfz().cfu();
    localo.oTW = 0;
    if (this.oLH) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.oIL;; i = com.tencent.mm.plugin.backup.b.c.oIK)
    {
      localo.oTX = i;
      if (oKK) {
        localo.oTT = 3;
      }
      m localm = new m();
      localm.oTH = q.aoG();
      localm.oTI = Build.MANUFACTURER;
      localm.oTJ = Build.MODEL;
      localm.oTK = "Android";
      localm.oTL = Build.VERSION.RELEASE;
      localm.oTM = com.tencent.mm.protocal.d.KyO;
      localm.oTN = 0L;
      Log.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
      localo.oTR = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.D(localo.toByteArray(), 4, this.oMk);
        J(this.oMf, this.oMg);
        AppMethodBeat.o(21355);
        return;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        Log.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        AppMethodBeat.o(21355);
      }
    }
  }
  
  public final void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.oMm)
      {
      }
    }
    for (;;)
    {
      b.cfv().ceN();
      w localw = new w();
      localw.oUu = 0;
      localw.ID = b.cfv().oIU;
      localw.Version = com.tencent.mm.plugin.backup.b.c.oIM;
      localw.oTW = 0;
      localw.oUv = this.oMi;
      localw.oTm = new com.tencent.mm.bw.b(l.e(b.cfv().oIW.getBytes(), com.tencent.mm.plugin.backup.b.d.ceQ()));
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.oUw |= com.tencent.mm.plugin.backup.b.c.oIQ;
      }
      localw.oUw |= com.tencent.mm.plugin.backup.b.c.oIR;
      localw.oUw |= com.tencent.mm.plugin.backup.b.c.oIS;
      try
      {
        Log.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.D(localw.toByteArray(), 2, this.oMl);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      oMj = false;
      oKK = false;
      this.oMf = 0L;
      this.oMg = 0L;
      continue;
      oMj = false;
      this.oMf = 0L;
      this.oMg = 0L;
      continue;
      oKK = false;
    }
  }
  
  public final void xI(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.oJO.Ba(paramInt);
    AppMethodBeat.o(21353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */