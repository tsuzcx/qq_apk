package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.h.a.ax;
import com.tencent.mm.h.a.ha;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class t
  extends f.a
  implements a.a, e
{
  byte[] dKa;
  int eNG = 0;
  private long eNH = 0L;
  private long eNI = 0L;
  private long eNJ = 0L;
  private WakerLock eNK = null;
  public a eNL;
  t.a eNM;
  t.b eNN;
  long eNO = 0L;
  int eNP = -1;
  private com.tencent.mm.storage.y eNQ;
  private s eNR;
  g eNS;
  h eNT;
  int ezJ = 0;
  public ah handler;
  
  public t(ah paramah)
  {
    ah localah = paramah;
    if (paramah == null) {
      localah = new ah();
    }
    this.handler = localah;
    this.eNL = new a(this);
    this.eNK = new WakerLock(aa.getContext(), "MicroMsg.AutoAuth");
    this.eNM = new t.a(this, this.eNK);
    this.eNN = new t.b(this, this.eNK);
    this.eNQ = new com.tencent.mm.storage.y(ac.dOP + "autoauth.cfg");
  }
  
  public final boolean KH()
  {
    return this.eNG < 5;
  }
  
  public final i KS()
  {
    return null;
  }
  
  public final void KT() {}
  
  public final void KU()
  {
    StnLogic.startNetworkAnalysis();
  }
  
  public final void TT()
  {
    this.eNK.lock(1000L, "MMAutoAuth.forceUpdateHostCache");
    new t.13(this, Integer.valueOf(-1)).b(this.handler);
  }
  
  public final i TU()
  {
    return aa.Ur();
  }
  
  public final boolean TY()
  {
    if (90000L >= SystemClock.elapsedRealtime() - this.eNI)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", new Object[] { Long.valueOf(this.eNI), Long.valueOf(SystemClock.elapsedRealtime()) });
      return false;
    }
    this.eNI = SystemClock.elapsedRealtime();
    a locala = this.eNL;
    int i = this.eNL.CK();
    locala.w(new byte[0], i);
    return true;
  }
  
  final boolean TZ()
  {
    if ((10001 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ > 0))
    {
      com.tencent.mm.platformtools.ae.eSQ = 0;
      TY();
    }
    if (this.eNL.KN()) {
      return true;
    }
    if (aa.Uv().Ui())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth hasAuthCmd ret false");
      return false;
    }
    if (this.eNP != -1)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
      return false;
    }
    long l = SystemClock.elapsedRealtime();
    if ((60000L >= l - this.eNH) && (this.eNH > 0L))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", new Object[] { Long.valueOf(this.eNH), Long.valueOf(l) });
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
      if (!aa.Uv().Uj())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", new Object[] { Integer.valueOf(Process.myPid()), bk.csb() });
        aa.Us().post(new t.3(this));
      }
      return false;
    }
    r localr = aa.Uv().cn(Ub());
    if (localr != null) {}
    for (;;)
    {
      try
      {
        if (!(localr instanceof r.a)) {
          continue;
        }
        if ((30000L >= l - this.eNJ) && (this.eNJ > 0L))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
          return false;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
        this.eNJ = SystemClock.elapsedRealtime();
        aa.Uw().onPush(5, null);
      }
      catch (RemoteException localRemoteException)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "makeSureAuth exception:%s", new Object[] { bk.j(localRemoteException) });
        continue;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth at last ret false");
      return false;
      this.eNH = SystemClock.elapsedRealtime();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", new Object[] { Long.valueOf(this.eNH) });
      a(localr, 3, 3);
      continue;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "makeSureAuth getAutoAuthRR is null");
    }
  }
  
  public final byte[] Ua()
  {
    if (!this.eNL.KN()) {
      return null;
    }
    w.a locala = new w.a();
    locala.uin = this.eNL.CK();
    locala.esK = bk.ZM(com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
    locala.netType = com.tencent.mm.protocal.a.getNetType(com.tencent.mm.sdk.platformtools.ae.getContext());
    locala.spQ = com.tencent.mm.protocal.a.coN();
    try
    {
      byte[] arrayOfByte = locala.HG();
      this.dKa = locala.dKa;
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final boolean Ub()
  {
    if (this.eNR == null) {
      return false;
    }
    try
    {
      boolean bool = this.eNR.check();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public final int a(r paramr, l paraml)
  {
    try
    {
      this.eNK.lock(1000L, "MMAutoAuth.send");
      int i = ((Integer)new t.7(this, Integer.valueOf(-1), paramr, paraml).b(this.handler)).intValue();
      return i;
    }
    finally
    {
      paramr = finally;
      throw paramr;
    }
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    return MMLogic.getSnsIpsForSceneWithHostName(paramList, paramString, paramBoolean);
  }
  
  public final int a(boolean paramBoolean, List<String> paramList)
  {
    return MMLogic.getSnsIpsForScene(paramList, paramBoolean);
  }
  
  public final void a(final int paramInt1, final String paramString, final int paramInt2, final boolean paramBoolean)
  {
    this.eNK.lock(1000L, "MMAutoAuth.logUtil");
    new bf(paramInt1, paramInt2, paramString)
    {
      protected final Object run()
      {
        Object localObject;
        if (paramInt1 == 3)
        {
          localObject = new Date();
          ((Date)localObject).setTime(bk.UY() - 86400000L * paramInt2);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
          MMLogic.uploadFile(com.tencent.mm.compatible.util.e.dOR + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt", paramString, "");
        }
        for (;;)
        {
          return null;
          if (paramInt1 == 2)
          {
            com.tencent.mm.sdk.platformtools.y.cqL();
            int i = paramInt2;
            boolean bool = paramBoolean;
            localObject = paramString;
            MMLogic.uploadLog(new int[] { i }, bool, (String)localObject, "");
          }
          else
          {
            com.tencent.mm.sdk.platformtools.y.cqL();
          }
        }
      }
    }.b(this.handler);
  }
  
  public final void a(com.tencent.mm.network.a.b paramb)
  {
    aa.Uq().eOX = paramb;
  }
  
  public final void a(g paramg)
  {
    this.eNS = paramg;
  }
  
  public final void a(h paramh)
  {
    this.eNT = paramh;
  }
  
  public final void a(o paramo)
  {
    aa.Uy().eOy = paramo;
  }
  
  final void a(r paramr, int paramInt1, int paramInt2)
  {
    paramr.a(this.eNM, paramInt1, paramInt2);
  }
  
  public final void a(s params)
  {
    this.eNR = params;
  }
  
  public final void a(com.tencent.mm.protocal.x paramx)
  {
    aa.Uv().Uk();
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    this.eNK.lock(1000L, "MMAutoAuth.setIDCHostInfo");
    List localList = n.Xs(paramString2);
    Object localObject2 = n.Xs(paramString1);
    paramInt1 = ((List)localObject2).size();
    paramInt2 = localList.size();
    if (paramBoolean) {}
    for (Object localObject1 = "!!!!!CHANGE IDC NOW";; localObject1 = "false")
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoAuth", "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s", new Object[] { paramString3, paramString1, Integer.valueOf(paramInt1), paramString4, paramString2, Integer.valueOf(paramInt2), localObject1 });
      paramString3 = new HashMap();
      paramString4 = localList.iterator();
      while (paramString4.hasNext())
      {
        localObject1 = (n)paramString4.next();
        paramString2 = (ArrayList)paramString3.get(((n)localObject1).host);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new ArrayList();
          paramString3.put(((n)localObject1).host, paramString1);
        }
        paramString1.add(((n)localObject1).lCF);
      }
    }
    paramString4 = new HashMap();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n)((Iterator)localObject1).next();
      paramString2 = (ArrayList)paramString4.get(((n)localObject2).host);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new ArrayList();
        paramString4.put(((n)localObject2).host, paramString1);
      }
      paramString1.add(((n)localObject2).lCF);
    }
    new t.9(this, Integer.valueOf(-1), paramString3, paramString4, paramArrayOfInt2, paramArrayOfInt1).b(this.handler);
  }
  
  public final void bO(boolean paramBoolean)
  {
    new t.8(this, Integer.valueOf(-1), paramBoolean).b(this.handler);
  }
  
  public final void bP(boolean paramBoolean)
  {
    if (com.tencent.mm.sdk.b.a.udP == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "loginevent but eventpool null, event:" + paramBoolean);
      return;
    }
    if (paramBoolean)
    {
      localObject = new ax();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
    }
    Object localObject = new ha();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.x.initLanguage(com.tencent.mm.sdk.platformtools.ae.getContext());
  }
  
  public final void bR(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoAuth", "summer setMMTLS enable[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    MMLogic.setMmtlsCtrlInfo(paramBoolean);
  }
  
  public final void cancel(int paramInt)
  {
    this.eNK.lock(1000L, String.format("MMAutoAuth.cancel,%d", new Object[] { Integer.valueOf(paramInt) }));
    new t.1(this, paramInt).b(this.handler);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.eNK.lock(1000L, "MMAutoAuth.setFixedHost");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if ((bk.bl(paramString1)) || (bk.bl(paramString3)))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AutoAuth", "dkidc setFixedHost FAILED ! check assist");
      return;
    }
    new t.10(this, Integer.valueOf(-1), paramString1, paramString2, paramString3, paramString4).b(this.handler);
  }
  
  final void f(int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail inErrType=" + paramInt1 + ", inErrCode=" + paramInt2 + ", errMsg=" + paramString + " stack=" + bk.csb());
    if ((paramInt1 == 4) && (paramInt2 == -106)) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
    }
    for (int k = -100;; k = paramInt2)
    {
      int i = k;
      int j = paramInt1;
      if (paramInt1 == 5)
      {
        i = k;
        j = paramInt1;
        if (paramInt2 == -13)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
          j = 4;
          i = -3;
          f.nEG.a(148L, 42L, 1L, false);
        }
      }
      if ((j != 6) || (paramInt2 != -10001))
      {
        k = i;
        paramInt1 = j;
        if (j == 5)
        {
          k = i;
          paramInt1 = j;
          if (paramInt2 == -13) {}
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
        Object localObject = aw.HD();
        String str = ((SharedPreferences)localObject).getString("_auth_key", "");
        localObject = ((SharedPreferences)localObject).getString("server_id", "");
        k = i;
        paramInt1 = j;
        if (bk.bl(str))
        {
          k = i;
          paramInt1 = j;
          if (bk.bl((String)localObject))
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
            k = -104;
            f.nEG.a(148L, 52L, 1L, false);
            paramInt1 = 4;
          }
        }
      }
      aa.Uv().g(paramInt1, k, paramString);
      if ((paramInt1 == 4) && ((k == -100) || (k == -205) || (k == -213)))
      {
        com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
        reset();
      }
      return;
    }
  }
  
  protected final void finalize()
  {
    reset();
    super.finalize();
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    return MMLogic.getHostByName(paramString, paramList);
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    return MMLogic.getIPsString(paramBoolean);
  }
  
  public final String getIspId()
  {
    return MMLogic.getIspId();
  }
  
  public final String getNetworkServerIp()
  {
    return MMLogic.getNetworkServerIp();
  }
  
  public final int h(int paramInt, byte[] paramArrayOfByte)
  {
    return ae.UB().i(paramInt, paramArrayOfByte);
  }
  
  final boolean h(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
    Object localObject1 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("auth_info_key_prefs", 4);
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("key_auth_info_prefs_created", false);
    int i = ((SharedPreferences)localObject1).getInt("key_auth_update_version", 0);
    int j = ((SharedPreferences)localObject1).getInt("_auth_uin", 0);
    String str1 = ((SharedPreferences)localObject1).getString("_auth_key", "");
    String str2 = ((SharedPreferences)localObject1).getString("server_id", "");
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject2).putBoolean("key_auth_info_prefs_created", true);
    ((SharedPreferences.Editor)localObject2).putInt("key_auth_update_version", d.spa);
    ((SharedPreferences.Editor)localObject2).putInt("_auth_uin", paramInt);
    ((SharedPreferences.Editor)localObject2).putString("_auth_key", paramString1);
    ((SharedPreferences.Editor)localObject2).putString("server_id", paramString2);
    if (!((SharedPreferences.Editor)localObject2).commit())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 1th!");
      f.nEG.a(148L, 36L, 1L, false);
      if (!((SharedPreferences.Editor)localObject2).commit())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2nd!");
        f.nEG.a(148L, 37L, 1L, false);
        bool1 = ((SharedPreferences)localObject1).getBoolean("key_auth_info_prefs_created", false);
        k = ((SharedPreferences)localObject1).getInt("key_auth_update_version", 0);
        m = ((SharedPreferences)localObject1).getInt("_auth_uin", 0);
        localObject2 = ((SharedPreferences)localObject1).getString("_auth_key", "");
        localObject1 = ((SharedPreferences)localObject1).getString("server_id", "");
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(d.spa), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramInt), str1, localObject2, paramString1, str2, localObject1, paramString2 });
        com.tencent.mm.sdk.platformtools.y.cqL();
        return false;
      }
    }
    boolean bool3 = ((SharedPreferences)localObject1).getBoolean("key_auth_info_prefs_created", false);
    int k = ((SharedPreferences)localObject1).getInt("key_auth_update_version", 0);
    int m = ((SharedPreferences)localObject1).getInt("_auth_uin", 0);
    localObject2 = ((SharedPreferences)localObject1).getString("_auth_key", "");
    localObject1 = ((SharedPreferences)localObject1).getString("server_id", "");
    if ((!bool3) || (k != d.spa) || (m != paramInt) || (!((String)localObject2).equals(paramString1)) || (!((String)localObject1).equals(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(d.spa), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramInt), str1, localObject2, paramString1, str2, localObject1, paramString2 });
      com.tencent.mm.sdk.platformtools.y.cqL();
      return false;
    }
    this.eNQ.cqu();
    this.eNQ.set(1, Integer.valueOf(d.spa));
    this.eNQ.set(2, Integer.valueOf(paramInt));
    this.eNQ.set(3, paramString1);
    this.eNQ.set(4, paramString2);
    this.eNQ.ctU();
    if (!this.eNQ.unq) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoAuth", "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(true), Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(d.spa), (Integer)this.eNQ.get(1), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramInt), (Integer)this.eNQ.get(2), str1, localObject2, paramString1, (String)this.eNQ.get(3), str2, localObject1, paramString2, (String)this.eNQ.get(4) });
      return true;
    }
  }
  
  public final void keepSignalling() {}
  
  public final void kt(String paramString)
  {
    this.eNK.lock(1000L, "MMAutoAuth.ipxxStatistics");
    new t.2(this, paramString).b(this.handler);
  }
  
  public final void ku(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoAuth", "killPush %s", new Object[] { paramString });
  }
  
  public final void reportFailIp(String paramString)
  {
    MMLogic.reportFailIp(paramString);
  }
  
  public final void reset()
  {
    this.eNK.lock(1000L, "MMAutoAuth.reset");
    new t.6(this).b(this.handler);
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    this.eNK.lock(1000L, "MMAutoAuth.setHostInfo");
    new t.4(this, paramArrayOfString1, paramArrayOfString2, paramArrayOfInt).b(this.handler);
  }
  
  public final void setNewDnsDebugHost(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) && (bk.bl(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoAuth", "setNewDnsDebugHost FAILED ! check assist");
      return;
    }
    new t.11(this, paramString1, paramString2).b(this.handler);
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    StnLogic.setSignallingStrategy(paramLong1, paramLong2);
  }
  
  public final void stopSignalling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.t
 * JD-Core Version:    0.7.0.1
 */