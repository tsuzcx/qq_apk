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
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
{
  private static boolean uXO = false;
  private static boolean uZs = false;
  public byte[] bitmapData;
  public b.b uWR;
  public boolean uYK;
  private Set<com.tencent.mm.plugin.backup.b.b.d> uYW;
  public b.c uZd;
  public final j.a uZe;
  private LinkedList<String> uZl;
  private com.tencent.mm.plugin.backup.c.b uZm;
  public com.tencent.mm.plugin.backup.c.c uZn;
  private long uZo;
  private long uZp;
  public boolean uZq;
  public int uZr;
  private int uZt;
  private int uZu;
  private int uZv;
  public final com.tencent.mm.plugin.backup.g.b.d uZw;
  public e uZx;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.uZo = 0L;
    this.uZp = 0L;
    this.uZq = false;
    this.uZr = 0;
    this.uYK = false;
    this.uZv = 0;
    this.uYW = new HashSet();
    this.uZw = new com.tencent.mm.plugin.backup.g.b.d()
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
            i = b.cVs().cUJ().uWg;
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
            d.this.uZx.stop();
            localObject = (v)g.a(new v(), paramAnonymousArrayOfByte);
            if (localObject == null)
            {
              Log.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
              b.cVs().cUJ().uWg = -5;
              d.this.Bt(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.cVs().cVt().stop();
              b.cVs().cUJ().uWg = -100;
              d.this.Bt(-100);
              continue;
              b.cVs().cVt().stop();
              continue;
              d.this.cancel(true);
              b.cVs().cVt().stop();
              b.cVs().cUJ().uWg = -4;
              d.this.Bt(-4);
              h.OAn.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).uWU == 0L)) {
                continue;
              }
              long l = Util.milliSecondsToNow(d.a(d.this).uWU);
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).cVb()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (Util.isNullOrNil(b.cVs().uVY)) {
              b.cVs().uVY = ((v)localObject).vgy;
            }
            if (!((v)localObject).vgy.equals(b.cVs().uVY))
            {
              Log.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.cVs().uVY, ((v)localObject).vgy });
              d.this.cancel(false);
              b.cVs().cUJ().uWg = -5;
              d.this.Bt(-5);
              AppMethodBeat.o(21339);
              return;
            }
            Log.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).vgy, Integer.valueOf(((v)localObject).vhI) });
            if (((v)localObject).vhI == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).vgA.Op;
              if (!b.cVs().uVZ.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.cUN()))))
              {
                d.Fi(paramAnonymousInt2);
                b.cVs().cUJ().uWg = -5;
                d.this.Bt(-5);
              }
              if (((v)localObject).crz < com.tencent.mm.plugin.backup.b.c.uVQ)
              {
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).crz) });
                h.OAn.idkeyStat(485L, 103L, 1L, false);
                b.cVs().cUJ().uWg = -12;
                d.this.Bt(-12);
                AppMethodBeat.o(21339);
                return;
              }
              Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if (((v)localObject).vhJ == com.tencent.mm.plugin.backup.b.c.uVS)
              {
                paramAnonymousBoolean = d.cVI();
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify client resume move! isResumeDataExist:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                if (paramAnonymousBoolean)
                {
                  b.cVs().cVu().uZr = com.tencent.mm.plugin.backup.b.c.uVS;
                  d.this.K(null);
                  d.this.lZ(false);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              b.cVs().cVu().uZr = com.tencent.mm.plugin.backup.b.c.uVR;
              if ((d.XU()) || (d.uXO))
              {
                if ((d.XU()) && (d.uXO) && ((((v)localObject).vhK & com.tencent.mm.plugin.backup.b.c.uVV) == 0) && ((((v)localObject).vhK & com.tencent.mm.plugin.backup.b.c.uVW) == 0))
                {
                  b.cVs().cUJ().uWg = -31;
                  d.this.Bt(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.XU()) && ((((v)localObject).vhK & com.tencent.mm.plugin.backup.b.c.uVV) == 0))
                {
                  b.cVs().cUJ().uWg = -32;
                  d.this.Bt(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.uXO) && ((((v)localObject).vhK & com.tencent.mm.plugin.backup.b.c.uVW) == 0))
                {
                  b.cVs().cUJ().uWg = -33;
                  d.this.Bt(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.lZ(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).vhI == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).vgA.Op;
              if (!b.cVs().uWa.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.cUN()))))
              {
                Log.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.cVs().cUJ().uWg = -5;
                d.this.Bt(-5);
              }
              Log.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.cVs().cUJ().uWg = 2;
              d.this.Bt(2);
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
            if (!b.cVs().cVw().uYn) {
              break;
            }
            d.this.cVJ();
            AppMethodBeat.o(21339);
            return;
            if (((n)localObject).vhf != null)
            {
              localObject = ((n)localObject).vhf.vgW;
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
          Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).vda) });
          paramAnonymousArrayOfByte = (com.tencent.mm.plugin.backup.i.f)g.a(new com.tencent.mm.plugin.backup.i.f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.vda = ((com.tencent.mm.plugin.backup.i.e)localObject).vda;
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
          b.cVs().cUJ().uWg = -100;
          d.this.Bt(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramAnonymousArrayOfByte)) });
            b.cVs().cUJ().uWg = -5;
            d.this.Bt(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = g.b(((j)localObject).vgP, ((j)localObject).vgQ);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            Log.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.cVC();
            b.cVs().cUJ().uWg = -21;
            d.this.Bt(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.cWo();
          if ((d.a(d.this) == null) || (d.a(d.this).uWQ)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.cVs(), 2, d.c(d.this)));
          }
          d.a(d.this).lW(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.cVs().cUJ().uWo, d.uXO);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.uWR = new b.b()
    {
      public final void Fc(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21340);
            Iterator localIterator = this.uZh.iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.mm.plugin.backup.b.b.d)localIterator.next()).Fc(paramAnonymousInt);
            }
            AppMethodBeat.o(21340);
          }
        });
        AppMethodBeat.o(21341);
      }
      
      public final void cUF()
      {
        AppMethodBeat.i(21342);
        b.cVs();
        b.cUO().edit().putStringSet("BACKUP_SELECT_SESSION_LIST", null);
        com.tencent.mm.plugin.backup.g.b.Fp(21);
        AppMethodBeat.o(21342);
      }
      
      public final void cUG()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
    };
    this.uZd = new b.c()
    {
      public final void cVF()
      {
        AppMethodBeat.i(21344);
        Log.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.cWp();
        b.cVs().cUL();
        AppMethodBeat.o(21344);
      }
    };
    this.uZe = new j.a()
    {
      public final void Fh(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.cVs().cUJ().uWg;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            Log.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.cVs().cUJ().uWg = 4;
            d.this.Bt(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.cVs().cUJ().uWg = 14;
          d.this.Bt(14);
        }
        AppMethodBeat.o(21346);
      }
      
      public final void cVG()
      {
        AppMethodBeat.i(21345);
        d.this.Bt(b.cVs().cUJ().uWg);
        AppMethodBeat.o(21345);
      }
      
      public final void cVH()
      {
        AppMethodBeat.i(21347);
        int i = b.cVs().cUJ().uWg;
        Log.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.cVs().cVt().stop();
          b.cVs().cUJ().uWg = -4;
          d.this.Bt(-4);
        }
        AppMethodBeat.o(21347);
      }
    };
    this.uZx = new e(new e.a()
    {
      public final void o(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.Bt(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.cVs().cUJ());
    AppMethodBeat.o(21349);
  }
  
  private void ai(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.uZl.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    com.tencent.mm.plugin.backup.i.i locali = new com.tencent.mm.plugin.backup.i.i();
    locali.vgP = this.uZl;
    locali.vgQ = new LinkedList();
    Iterator localIterator = this.uZl.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.vgQ.add(Long.valueOf(paramLong1));
      locali.vgQ.add(Long.valueOf(paramLong2));
    }
    try
    {
      Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.uZl.size()) });
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
  
  public static void cVC()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.vgy = b.cVs().uVY;
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
  
  public static boolean cVI()
  {
    AppMethodBeat.i(300751);
    b.cVs();
    Set localSet = b.cUO().getStringSet("BACKUP_SELECT_SESSION_LIST", null);
    if ((localSet == null) || (localSet.size() <= 0))
    {
      AppMethodBeat.o(300751);
      return false;
    }
    AppMethodBeat.o(300751);
    return true;
  }
  
  public static String cVK()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.cWs();
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
    b.cVs();
    SharedPreferences.Editor localEditor = b.cUO().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
    AppMethodBeat.o(21352);
  }
  
  public final void Bt(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.uWR.Fc(paramInt);
    AppMethodBeat.o(21353);
  }
  
  public final void K(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(300778);
    this.uZl = new LinkedList();
    Object localObject;
    if (Util.isNullOrNil(paramLinkedList))
    {
      b.cVs();
      localObject = b.cUO().getStringSet("BACKUP_SELECT_SESSION_LIST", new HashSet());
      this.uZl.addAll((Collection)localObject);
      b.cVs();
      if (b.cUO().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
        break label284;
      }
      uZs = true;
      label80:
      b.cVs();
      this.uZo = b.cUO().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      b.cVs();
      this.uZp = b.cUO().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      b.cVs();
      if (b.cUO().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label291;
      }
      uXO = true;
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
      Log.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(this.uZo), Long.valueOf(this.uZp), Boolean.valueOf(uXO) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acPa, Boolean.TRUE);
      AppMethodBeat.o(300778);
      return;
      b.cVs();
      localObject = b.cUO().edit();
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(paramLinkedList);
      ((SharedPreferences.Editor)localObject).putStringSet("BACKUP_SELECT_SESSION_LIST", localHashSet);
      ((SharedPreferences.Editor)localObject).commit();
      this.uZl.addAll(localHashSet);
      break;
      uZs = false;
      break label80;
      uXO = false;
      break label144;
    }
  }
  
  public final void a(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(300772);
    synchronized (this.uYW)
    {
      this.uYW.add(paramd);
      AppMethodBeat.o(300772);
      return;
    }
  }
  
  public final void b(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(300773);
    synchronized (this.uYW)
    {
      this.uYW.remove(paramd);
      AppMethodBeat.o(300773);
      return;
    }
  }
  
  public final void cVJ()
  {
    AppMethodBeat.i(21355);
    Log.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.uZq = false;
    b.cVs().cUJ().uWg = 12;
    Bt(12);
    com.tencent.mm.plugin.backup.h.d.cWK().cWN();
    if (this.uZl == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    Log.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.uZl.size()) });
    o localo = new o();
    localo.vgy = b.cVs().uVY;
    localo.vhi = this.uZl.size();
    localo.vhj = b.cVs().cVw().cVr();
    localo.vhk = 0;
    if (this.uYK) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.uVP;; i = com.tencent.mm.plugin.backup.b.c.uVO)
    {
      localo.vhl = i;
      if (uXO) {
        localo.vhh = 3;
      }
      m localm = new m();
      localm.vgV = q.aPg();
      localm.vgW = Build.MANUFACTURER;
      localm.vgX = q.aPo();
      localm.vgY = "Android";
      localm.vgZ = Build.VERSION.RELEASE;
      localm.vha = com.tencent.mm.protocal.d.Yxh;
      localm.vhb = 0L;
      Log.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
      localo.vhf = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.D(localo.toByteArray(), 4, this.uZt);
        ai(this.uZo, this.uZp);
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
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    Log.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { MMStack.getCaller() });
    if (!paramBoolean) {
      cVC();
    }
    if (this.uZn != null) {
      this.uZn.cancel();
    }
    if (this.uZm != null)
    {
      this.uZm.cancel();
      this.uZm = null;
    }
    Log.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.cWp();
    com.tencent.mm.plugin.backup.g.b.cWr();
    b.cVs().cUL();
    AppMethodBeat.o(21351);
  }
  
  public final void lZ(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.uZv)
      {
      }
    }
    for (;;)
    {
      b.cVs().cUK();
      w localw = new w();
      localw.vhI = 0;
      localw.vgy = b.cVs().uVY;
      localw.crz = com.tencent.mm.plugin.backup.b.c.uVQ;
      localw.vhk = 0;
      localw.vhJ = this.uZr;
      localw.vgA = new com.tencent.mm.bx.b(l.e(b.cVs().uWa.getBytes(), com.tencent.mm.plugin.backup.b.d.cUN()));
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.vhK |= com.tencent.mm.plugin.backup.b.c.uVU;
      }
      localw.vhK |= com.tencent.mm.plugin.backup.b.c.uVV;
      localw.vhK |= com.tencent.mm.plugin.backup.b.c.uVW;
      try
      {
        Log.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.D(localw.toByteArray(), 2, this.uZu);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      uZs = false;
      uXO = false;
      this.uZo = 0L;
      this.uZp = 0L;
      continue;
      uZs = false;
      this.uZo = 0L;
      this.uZp = 0L;
      continue;
      uXO = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */