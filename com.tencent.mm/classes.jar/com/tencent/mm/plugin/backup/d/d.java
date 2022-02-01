package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bh;
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
  private static boolean rMB = false;
  private static boolean rOe = false;
  public byte[] bitmapData;
  public b.b rLE;
  private Set<com.tencent.mm.plugin.backup.b.b.d> rNI;
  public b.c rNP;
  public final j.a rNQ;
  private LinkedList<String> rNX;
  private com.tencent.mm.plugin.backup.c.b rNY;
  public com.tencent.mm.plugin.backup.c.c rNZ;
  public boolean rNw;
  private long rOa;
  private long rOb;
  public boolean rOc;
  public int rOd;
  private int rOf;
  private int rOg;
  private int rOh;
  public final com.tencent.mm.plugin.backup.g.b.d rOi;
  public e rOj;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.rOa = 0L;
    this.rOb = 0L;
    this.rOc = false;
    this.rOd = 0;
    this.rNw = false;
    this.rOh = 0;
    this.rNI = new HashSet();
    this.rOi = new com.tencent.mm.plugin.backup.g.b.d()
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
            i = b.csI().crZ().rKS;
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
            d.this.rOj.stop();
            localObject = (v)g.a(new v(), paramAnonymousArrayOfByte);
            if (localObject == null)
            {
              Log.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
              b.csI().crZ().rKS = -5;
              d.this.Bg(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.csI().csJ().stop();
              b.csI().crZ().rKS = -100;
              d.this.Bg(-100);
              continue;
              b.csI().csJ().stop();
              continue;
              d.this.cancel(true);
              b.csI().csJ().stop();
              b.csI().crZ().rKS = -4;
              d.this.Bg(-4);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).rLH == 0L)) {
                continue;
              }
              long l = Util.milliSecondsToNow(d.a(d.this).rLH);
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).csr()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (Util.isNullOrNil(b.csI().rKK)) {
              b.csI().rKK = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.csI().rKK))
            {
              Log.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.csI().rKK, ((v)localObject).ID });
              d.this.cancel(false);
              b.csI().crZ().rKS = -5;
              d.this.Bg(-5);
              AppMethodBeat.o(21339);
              return;
            }
            Log.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).rWs) });
            if (((v)localObject).rWs == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).rVk.UH;
              if (!b.csI().rKL.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.csd()))))
              {
                d.EH(paramAnonymousInt2);
                b.csI().crZ().rKS = -5;
                d.this.Bg(-5);
              }
              if (((v)localObject).rWt < com.tencent.mm.plugin.backup.b.c.rKC)
              {
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).rWt) });
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 103L, 1L, false);
                b.csI().crZ().rKS = -12;
                d.this.Bg(-12);
                AppMethodBeat.o(21339);
                return;
              }
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if (((v)localObject).rWu == com.tencent.mm.plugin.backup.b.c.rKE)
              {
                paramAnonymousBoolean = d.csY();
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify client resume move! isResumeDataExist:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                if (paramAnonymousBoolean)
                {
                  b.csI().csK().rOd = com.tencent.mm.plugin.backup.b.c.rKE;
                  d.this.H(null);
                  d.this.kM(false);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              b.csI().csK().rOd = com.tencent.mm.plugin.backup.b.c.rKD;
              if ((d.bSX()) || (d.rMB))
              {
                if ((d.bSX()) && (d.rMB) && ((((v)localObject).rWv & com.tencent.mm.plugin.backup.b.c.rKH) == 0) && ((((v)localObject).rWv & com.tencent.mm.plugin.backup.b.c.rKI) == 0))
                {
                  b.csI().crZ().rKS = -31;
                  d.this.Bg(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.bSX()) && ((((v)localObject).rWv & com.tencent.mm.plugin.backup.b.c.rKH) == 0))
                {
                  b.csI().crZ().rKS = -32;
                  d.this.Bg(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.rMB) && ((((v)localObject).rWv & com.tencent.mm.plugin.backup.b.c.rKI) == 0))
                {
                  b.csI().crZ().rKS = -33;
                  d.this.Bg(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.kM(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).rWs == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).rVk.UH;
              if (!b.csI().rKM.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.csd()))))
              {
                Log.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.csI().crZ().rKS = -5;
                d.this.Bg(-5);
              }
              Log.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.csI().crZ().rKS = 2;
              d.this.Bg(2);
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
            if (!b.csI().csM().rMZ) {
              break;
            }
            d.this.csZ();
            AppMethodBeat.o(21339);
            return;
            if (((n)localObject).rVP != null)
            {
              localObject = ((n)localObject).rVP.rVG;
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
          Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).rRK) });
          paramAnonymousArrayOfByte = (com.tencent.mm.plugin.backup.i.f)g.a(new com.tencent.mm.plugin.backup.i.f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.rRK = ((com.tencent.mm.plugin.backup.i.e)localObject).rRK;
          try
          {
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.F(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
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
          b.csI().crZ().rKS = -100;
          d.this.Bg(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
            b.csI().crZ().rKS = -5;
            d.this.Bg(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = g.b(((j)localObject).rVz, ((j)localObject).rVA);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.csS();
            b.csI().crZ().rKS = -21;
            d.this.Bg(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.ctE();
          if ((d.a(d.this) == null) || (d.a(d.this).rLD)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.csI(), 2, d.c(d.this)));
          }
          d.a(d.this).kJ(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.csI().crZ().rLa, d.rMB);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.rLE = new b.b()
    {
      public final void EB(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21340);
            Iterator localIterator = this.rNT.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.backup.b.b.d)localIterator.next()).EB(paramAnonymousInt);
            }
            AppMethodBeat.o(21340);
          }
        });
        AppMethodBeat.o(21341);
      }
      
      public final void crV()
      {
        AppMethodBeat.i(21342);
        b.csI();
        b.cse().edit().putStringSet("BACKUP_SELECT_SESSION_LIST", null);
        com.tencent.mm.plugin.backup.g.b.EO(21);
        AppMethodBeat.o(21342);
      }
      
      public final void crW()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
    };
    this.rNP = new b.c()
    {
      public final void csV()
      {
        AppMethodBeat.i(21344);
        Log.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.ctF();
        b.csI().csb();
        AppMethodBeat.o(21344);
      }
    };
    this.rNQ = new j.a()
    {
      public final void EG(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.csI().crZ().rKS;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            Log.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.csI().crZ().rKS = 4;
            d.this.Bg(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.csI().crZ().rKS = 14;
          d.this.Bg(14);
        }
        AppMethodBeat.o(21346);
      }
      
      public final void csW()
      {
        AppMethodBeat.i(21345);
        d.this.Bg(b.csI().crZ().rKS);
        AppMethodBeat.o(21345);
      }
      
      public final void csX()
      {
        AppMethodBeat.i(21347);
        int i = b.csI().crZ().rKS;
        Log.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.csI().csJ().stop();
          b.csI().crZ().rKS = -4;
          d.this.Bg(-4);
        }
        AppMethodBeat.o(21347);
      }
    };
    this.rOj = new e(new e.a()
    {
      public final void o(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.Bg(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.csI().crZ());
    AppMethodBeat.o(21349);
  }
  
  private void K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.rNX.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.rVz = this.rNX;
    locali.rVA = new LinkedList();
    Iterator localIterator = this.rNX.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.rVA.add(Long.valueOf(paramLong1));
      locali.rVA.add(Long.valueOf(paramLong2));
    }
    try
    {
      Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.rNX.size()) });
      com.tencent.mm.plugin.backup.g.b.O(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void csS()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.csI().rKK;
    try
    {
      Log.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.O(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static boolean csY()
  {
    AppMethodBeat.i(248529);
    b.csI();
    Set localSet = b.cse().getStringSet("BACKUP_SELECT_SESSION_LIST", null);
    if ((localSet == null) || (localSet.size() <= 0))
    {
      AppMethodBeat.o(248529);
      return false;
    }
    AppMethodBeat.o(248529);
    return true;
  }
  
  public static String cta()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.ctI();
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
    b.csI();
    SharedPreferences.Editor localEditor = b.cse().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
    AppMethodBeat.o(21352);
  }
  
  public final void Bg(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.rLE.EB(paramInt);
    AppMethodBeat.o(21353);
  }
  
  public final void H(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(248532);
    this.rNX = new LinkedList();
    Object localObject;
    if (Util.isNullOrNil(paramLinkedList))
    {
      b.csI();
      localObject = b.cse().getStringSet("BACKUP_SELECT_SESSION_LIST", new HashSet());
      this.rNX.addAll((Collection)localObject);
      b.csI();
      if (b.cse().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
        break label284;
      }
      rOe = true;
      label80:
      b.csI();
      this.rOa = b.cse().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      b.csI();
      this.rOb = b.cse().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      b.csI();
      if (b.cse().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label291;
      }
      rMB = true;
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
      Log.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(this.rOa), Long.valueOf(this.rOb), Boolean.valueOf(rMB) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnF, Boolean.TRUE);
      AppMethodBeat.o(248532);
      return;
      b.csI();
      localObject = b.cse().edit();
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(paramLinkedList);
      ((SharedPreferences.Editor)localObject).putStringSet("BACKUP_SELECT_SESSION_LIST", localHashSet);
      ((SharedPreferences.Editor)localObject).commit();
      this.rNX.addAll(localHashSet);
      break;
      rOe = false;
      break label80;
      rMB = false;
      break label144;
    }
  }
  
  public final void a(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(248526);
    synchronized (this.rNI)
    {
      this.rNI.add(paramd);
      AppMethodBeat.o(248526);
      return;
    }
  }
  
  public final void b(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(248527);
    synchronized (this.rNI)
    {
      this.rNI.remove(paramd);
      AppMethodBeat.o(248527);
      return;
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    Log.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { MMStack.getCaller() });
    if (!paramBoolean) {
      csS();
    }
    if (this.rNZ != null) {
      this.rNZ.cancel();
    }
    if (this.rNY != null)
    {
      this.rNY.cancel();
      this.rNY = null;
    }
    Log.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.ctF();
    com.tencent.mm.plugin.backup.g.b.ctH();
    b.csI().csb();
    AppMethodBeat.o(21351);
  }
  
  public final void csZ()
  {
    AppMethodBeat.i(21355);
    Log.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.rOc = false;
    b.csI().crZ().rKS = 12;
    Bg(12);
    com.tencent.mm.plugin.backup.h.d.cua().cud();
    if (this.rNX == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    Log.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.rNX.size()) });
    o localo = new o();
    localo.ID = b.csI().rKK;
    localo.rVS = this.rNX.size();
    localo.rVT = b.csI().csM().csH();
    localo.rVU = 0;
    if (this.rNw) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.rKB;; i = com.tencent.mm.plugin.backup.b.c.rKA)
    {
      localo.rVV = i;
      if (rMB) {
        localo.rVR = 3;
      }
      m localm = new m();
      localm.rVF = q.auM();
      localm.rVG = Build.MANUFACTURER;
      localm.rVH = Build.MODEL;
      localm.rVI = "Android";
      localm.rVJ = Build.VERSION.RELEASE;
      localm.rVK = com.tencent.mm.protocal.d.RAD;
      localm.rVL = 0L;
      Log.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.RAD) });
      localo.rVP = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.F(localo.toByteArray(), 4, this.rOf);
        K(this.rOa, this.rOb);
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
  
  public final void kM(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.rOh)
      {
      }
    }
    for (;;)
    {
      b.csI().csa();
      w localw = new w();
      localw.rWs = 0;
      localw.ID = b.csI().rKK;
      localw.rWt = com.tencent.mm.plugin.backup.b.c.rKC;
      localw.rVU = 0;
      localw.rWu = this.rOd;
      localw.rVk = new com.tencent.mm.cd.b(l.e(b.csI().rKM.getBytes(), com.tencent.mm.plugin.backup.b.d.csd()));
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.rWv |= com.tencent.mm.plugin.backup.b.c.rKG;
      }
      localw.rWv |= com.tencent.mm.plugin.backup.b.c.rKH;
      localw.rWv |= com.tencent.mm.plugin.backup.b.c.rKI;
      try
      {
        Log.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.F(localw.toByteArray(), 2, this.rOg);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      rOe = false;
      rMB = false;
      this.rOa = 0L;
      this.rOb = 0L;
      continue;
      rOe = false;
      this.rOa = 0L;
      this.rOb = 0L;
      continue;
      rMB = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */