package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static boolean jAv = false;
  public static boolean jBV = false;
  public byte[] bitmapData;
  public com.tencent.mm.plugin.backup.b.b.d jAq;
  public b.c jBJ;
  public final j.a jBK;
  public LinkedList<String> jBO;
  private com.tencent.mm.plugin.backup.c.b jBP;
  public com.tencent.mm.plugin.backup.c.c jBQ;
  public long jBR;
  public long jBS;
  public boolean jBT;
  public int jBU;
  private int jBW;
  private int jBX;
  private int jBY;
  public final com.tencent.mm.plugin.backup.g.b.d jBZ;
  public boolean jBt;
  public e jCa;
  public b.b jzz;
  
  public d()
  {
    AppMethodBeat.i(17290);
    this.jBR = 0L;
    this.jBS = 0L;
    this.jBT = false;
    this.jBU = 0;
    this.jBt = false;
    this.jBY = 0;
    this.jBZ = new d.1(this);
    this.jzz = new d.2(this);
    this.jBJ = new d.3(this);
    this.jBK = new d.4(this);
    this.jCa = new e(new d.5(this), b.aTr().aSL());
    AppMethodBeat.o(17290);
  }
  
  private void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(17296);
    ab.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.jBO.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.jJw = this.jBO;
    locali.jJx = new LinkedList();
    Iterator localIterator = this.jBO.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.jJx.add(Long.valueOf(paramLong1));
      locali.jJx.add(Long.valueOf(paramLong2));
    }
    try
    {
      ab.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.jBO.size()) });
      com.tencent.mm.plugin.backup.g.b.J(locali.toByteArray(), 11);
      AppMethodBeat.o(17296);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(17296);
    }
  }
  
  public static void aTB()
  {
    AppMethodBeat.i(17297);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.aTr().jyF;
    try
    {
      ab.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.J(locala.toByteArray(), 5);
      AppMethodBeat.o(17297);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(17297);
    }
  }
  
  public static String aTI()
  {
    AppMethodBeat.i(17298);
    String str = com.tencent.mm.plugin.backup.g.b.aUr();
    AppMethodBeat.o(17298);
    return str;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(17292);
    ab.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.aTr();
    SharedPreferences.Editor localEditor = b.aSQ().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
    AppMethodBeat.o(17292);
  }
  
  public final void aTH()
  {
    AppMethodBeat.i(17295);
    ab.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.jBT = false;
    b.aTr().aSL().jyN = 12;
    rl(12);
    com.tencent.mm.plugin.backup.h.d.aUK().aUN();
    if (this.jBO == null)
    {
      AppMethodBeat.o(17295);
      return;
    }
    ab.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.jBO.size()) });
    o localo = new o();
    localo.ID = b.aTr().jyF;
    localo.jJQ = this.jBO.size();
    localo.jJR = b.aTr().aTv().aTq();
    localo.jJS = 0;
    if (this.jBt) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.jyw;; i = com.tencent.mm.plugin.backup.b.c.jyv)
    {
      localo.jJT = i;
      if (jAv) {
        localo.jJP = 3;
      }
      m localm = new m();
      localm.jJD = q.LK();
      localm.jJE = Build.MANUFACTURER;
      localm.jJF = Build.MODEL;
      localm.jJG = "Android";
      localm.jJH = Build.VERSION.RELEASE;
      localm.jJI = com.tencent.mm.protocal.d.whH;
      localm.jJJ = 0L;
      ab.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH) });
      localo.jJN = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.r(localo.toByteArray(), 4, this.jBW);
        C(this.jBR, this.jBS);
        AppMethodBeat.o(17295);
        return;
      }
      catch (IOException localIOException)
      {
        ab.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        ab.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        AppMethodBeat.o(17295);
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(17291);
    ab.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", new Object[] { an.dtg() });
    if (!paramBoolean) {
      aTB();
    }
    if (this.jBQ != null) {
      this.jBQ.cancel();
    }
    if (this.jBP != null)
    {
      this.jBP.cancel();
      this.jBP = null;
    }
    ab.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.aUo();
    com.tencent.mm.plugin.backup.g.b.aUq();
    b.aTr().aSN();
    AppMethodBeat.o(17291);
  }
  
  public final void fz(boolean paramBoolean)
  {
    AppMethodBeat.i(17294);
    if (paramBoolean) {
      switch (this.jBY)
      {
      }
    }
    for (;;)
    {
      w localw = new w();
      localw.jKr = 0;
      localw.ID = b.aTr().jyF;
      localw.Version = com.tencent.mm.plugin.backup.b.c.jyx;
      localw.jJS = 0;
      localw.jKs = this.jBU;
      localw.jJh = new com.tencent.mm.bv.b(l.d(b.aTr().jyH.getBytes(), com.tencent.mm.plugin.backup.b.d.aSP()));
      if (bo.getInt(g.Nq().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.jKt |= com.tencent.mm.plugin.backup.b.c.jyB;
      }
      localw.jKt |= com.tencent.mm.plugin.backup.b.c.jyC;
      localw.jKt |= com.tencent.mm.plugin.backup.b.c.jyD;
      try
      {
        ab.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.r(localw.toByteArray(), 2, this.jBX);
        AppMethodBeat.o(17294);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(17294);
      }
      jBV = false;
      jAv = false;
      this.jBR = 0L;
      this.jBS = 0L;
      continue;
      jBV = false;
      this.jBR = 0L;
      this.jBS = 0L;
      continue;
      jAv = false;
    }
  }
  
  public final void rl(int paramInt)
  {
    AppMethodBeat.i(153499);
    this.jzz.rf(paramInt);
    AppMethodBeat.o(153499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */