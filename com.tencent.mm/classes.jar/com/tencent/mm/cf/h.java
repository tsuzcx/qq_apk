package com.tencent.mm.cf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public class h
  implements com.tencent.mm.sdk.e.e
{
  String TAG = "MicroMsg.SqliteDB";
  public int field_MARK_CURSOR_CHECK_IGNORE = 1;
  private long hHf = 0L;
  protected f uDC = null;
  private a uEg = null;
  public a uEh = new a();
  private String uEi = "";
  public e uEj = null;
  public String uEk = "";
  final LinkedList<b> uEl = new LinkedList();
  private ah uEm = null;
  
  public h() {}
  
  public h(a parama)
  {
    this.uEg = parama;
  }
  
  private void acP(String paramString)
  {
    String str1 = ae.getProcessName();
    String str2 = ae.getPackageName();
    y.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
  }
  
  public static String fA(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return DatabaseUtils.sqlEscapeString(paramString);
  }
  
  public final long a(String paramString1, String paramString2, ContentValues paramContentValues, boolean paramBoolean)
  {
    int i = 0;
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.uDC.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.hHf);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
      y.e(this.TAG, "insert Error :" + paramString1.getMessage());
      c.j(paramString1);
      if (paramBoolean) {
        throw paramString1;
      }
    }
    finally
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    }
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    return -1L;
  }
  
  public final Cursor a(final String paramString, final String[] paramArrayOfString, int paramInt)
  {
    int i = 0;
    if (!bk.bl(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return d.cwX();
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.uDC.a(paramString, paramArrayOfString, paramInt);
      if ((b.cqi()) || (b.cqk()))
      {
        if (this.uEm == null)
        {
          localObject = com.tencent.mm.sdk.f.e.aap("CheckCursor");
          ((HandlerThread)localObject).start();
          this.uEm = new ah(((HandlerThread)localObject).getLooper());
        }
        Object localObject = new c();
        this.uEm.postDelayed(new Runnable()
        {
          public final void run()
          {
            long l1;
            Object localObject7;
            int i;
            Object localObject8;
            Object localObject9;
            try
            {
              l1 = bk.UY();
              if (paramArrayOfString == null) {
                break label1327;
              }
              if (paramArrayOfString.isClosed()) {
                return;
              }
              localObject7 = new HashMap();
              i = 0;
              Object localObject1 = null;
              synchronized (h.this.uEl)
              {
                localObject8 = h.this.uEl.iterator();
                if (!((Iterator)localObject8).hasNext()) {
                  break label604;
                }
                localObject9 = (h.b)((Iterator)localObject8).next();
                if ((localObject9 == null) || (((h.b)localObject9).uEq == null) || (((h.b)localObject9).uEq.isClosed())) {
                  ((Iterator)localObject8).remove();
                }
              }
              if ((l1 - ((h.b)localObject9).lastReportTime) / 1000L <= 100L) {
                break label287;
              }
            }
            catch (Exception localException1)
            {
              y.e(h.this.TAG, "checkCursor table:[%s] e:%s[%s]", new Object[] { paramString, localException1.getMessage(), bk.j(localException1) });
              return;
            }
            ((h.b)localObject9).lastReportTime = l1;
            label287:
            int j;
            if (((h.b)localObject9).uEt) {
              if (TextUtils.isEmpty(((h.b)localObject9).uEu))
              {
                y.w(h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).uEs), Integer.valueOf(((h.b)localObject9).uEq.hashCode()), ((h.b)localObject9).uEr, Boolean.valueOf(((h.b)localObject9).uEt), ((h.b)localObject9).uEu });
                ??? = (Pair)((HashMap)localObject7).get(((h.b)localObject9).uEr);
                if (??? != null) {
                  break label543;
                }
                if (l1 - ((h.b)localObject9).uEs <= 30000L) {
                  break label1331;
                }
                j = 1;
                label324:
                ??? = new Pair(Integer.valueOf(j), localObject9);
                ((HashMap)localObject7).put(((h.b)localObject9).uEr, ???);
              }
            }
            label352:
            Object localObject3;
            label543:
            label604:
            label861:
            long l2;
            for (;;)
            {
              if (i < ((Integer)((Pair)???).first).intValue())
              {
                i = ((Integer)((Pair)???).first).intValue();
                localObject3 = ((h.b)((Pair)???).second).uEv;
                break label1328;
                y.w(h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).uEs), Integer.valueOf(((h.b)localObject9).uEq.hashCode()), ((h.b)localObject9).uEr, Boolean.valueOf(((h.b)localObject9).uEt), ((h.b)localObject9).uEu });
                break;
                y.w(h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).uEs), Integer.valueOf(((h.b)localObject9).uEq.hashCode()), ((h.b)localObject9).uEr, Boolean.valueOf(((h.b)localObject9).uEt), ((h.b)localObject9).uEu });
                break;
                if (l1 - ((h.b)localObject9).uEs <= 30000L) {
                  break label1324;
                }
                ??? = new Pair(Integer.valueOf(((Integer)((Pair)???).first).intValue() + 1), ((Pair)???).second);
                ((HashMap)localObject7).put(((h.b)localObject9).uEr, ???);
                continue;
                y.d(h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(h.this.uEl.size()), Integer.valueOf(((HashMap)localObject7).size()) });
                if (!b.cqi()) {
                  break label1344;
                }
                j = 20;
                label663:
                if (i <= j)
                {
                  j = h.this.uEl.size();
                  if (!b.cqi()) {
                    break label1350;
                  }
                  i = 50;
                  break label1336;
                }
                label691:
                localObject8 = ((HashMap)localObject7).keySet().iterator();
                Pair localPair;
                for (??? = ""; ((Iterator)localObject8).hasNext(); ??? = (String)??? + (String)localObject9 + "," + localPair.first + "," + ((h.b)localPair.second).uEt + "," + ((h.b)localPair.second).uEu + ";")
                {
                  localObject9 = (String)((Iterator)localObject8).next();
                  localPair = (Pair)((HashMap)localObject7).get(localObject9);
                }
                if (localObject3 != null)
                {
                  ??? = new h.c((String)???);
                  ((h.c)???).setStackTrace(((h.c)localObject3).getStackTrace());
                  throw ((Throwable)???);
                }
                throw new AssertionError(???);
                l2 = bk.UY();
                localObject3 = new h.b();
                ((h.b)localObject3).uEq = paramArrayOfString;
                ((h.b)localObject3).table = paramString;
                ((h.b)localObject3).uEs = l1;
                ((h.b)localObject3).uEr = "";
                ((h.b)localObject3).uEt = true;
                ((h.b)localObject3).uEv = this.uEo;
                ??? = this.uEo.getStackTrace();
                j = 0;
              }
            }
            for (;;)
            {
              if (j < ???.length)
              {
                localObject8 = ???[j].getClassName();
                ??? = ???[j].getMethodName();
                i = ???[j].getLineNumber();
                localObject7 = ((String)localObject8).replace("com.tencent.mm.", "") + ":" + (String)??? + "(" + i + ")";
                localObject8 = Class.forName((String)localObject8);
              }
              for (;;)
              {
                try
                {
                  localObject9 = ((Class)localObject8).getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE");
                  if (localObject9 == null) {
                    continue;
                  }
                  i = 1;
                }
                catch (Exception localException2)
                {
                  boolean bool1;
                  int k;
                  boolean bool2;
                  label1324:
                  label1327:
                  label1328:
                  label1331:
                  label1336:
                  label1344:
                  label1350:
                  i = 0;
                  continue;
                  j += 1;
                }
                if (i != 0) {
                  continue;
                }
                if (TextUtils.isEmpty(((h.b)localObject3).uEr))
                {
                  ((h.b)localObject3).uEr = ((String)localObject7);
                  localObject7 = ((Class)localObject8).getMethods();
                  bool1 = false;
                  k = localObject7.length;
                  i = 0;
                  bool2 = bool1;
                  if (i < k)
                  {
                    localObject8 = localObject7[i];
                    if (((Method)localObject8).getName().equals(???))
                    {
                      bool1 = ((Method)localObject8).getReturnType().getName().contains(".Cursor");
                      bool2 = bool1;
                      if (bool1 != true) {}
                    }
                  }
                  else
                  {
                    ((h.b)localObject3).uEt = bool2;
                    continue;
                  }
                }
                else
                {
                  if (((h.b)localObject3).uEt)
                  {
                    ??? = ((String)localObject7).toLowerCase();
                    if ((!((String)???).contains("cursor")) && (!((String)???).contains("adapter"))) {
                      continue;
                    }
                    ((h.b)localObject3).uEu = ((String)localObject7);
                    continue;
                  }
                  if (TextUtils.isEmpty(((h.b)localObject3).uEr)) {
                    ((h.b)localObject3).uEr = ak.b((StackTraceElement[])???);
                  }
                  synchronized (h.this.uEl)
                  {
                    h.this.uEl.add(localObject3);
                    y.d(h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(bk.co(l1)), ((h.b)localObject3).uEr, Boolean.valueOf(((h.b)localObject3).uEt), ((h.b)localObject3).uEu });
                    return;
                  }
                  continue;
                  break label352;
                  return;
                  break;
                  j = 0;
                  break label324;
                  if (j > i)
                  {
                    break label691;
                    j = 50;
                    break label663;
                    i = 100;
                    continue;
                  }
                  break label861;
                }
                i += 1;
                continue;
                i = 0;
              }
            }
          }
        }, 500L);
      }
      c.a(paramString, paramArrayOfString, this.hHf);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 10L, 1L, false);
      y.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.j(paramString);
      paramString = d.cwX();
      return paramString;
    }
    finally
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    }
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return d.cwX();
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.DS().crd();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.uDC.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
        c.a(paramString1, paramArrayOfString1, this.hHf);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.f.nEG.a(181L, 10L, 1L, false);
        y.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.j(paramString1);
        paramString1 = d.cwX();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, HashMap<Integer, d> paramHashMap)
  {
    return a(paramString1, paramString2, "", paramLong, paramString3, paramHashMap, true);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HashMap<Integer, d> paramHashMap, boolean paramBoolean)
  {
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    acP(paramString2);
    if ((this.uEh.a(paramString1, paramString2, paramString3, paramLong, paramString4, paramHashMap, paramBoolean)) && (this.uEh.uDC != null))
    {
      this.uEk = this.uEh.getError();
      this.uDC = this.uEh.uDC;
      return true;
    }
    this.uEk = this.uEh.getError();
    this.uDC = null;
    this.uEh = null;
    y.i(this.TAG, "initDB failed. %s", new Object[] { this.uEk });
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, DBDumpUtil.ExecuteSqlCallback paramExecuteSqlCallback)
  {
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return false;
    }
    return DBDumpUtil.doRecoveryDb(this.uDC.uDL, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
  }
  
  public final boolean acQ(String paramString)
  {
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return false;
    }
    try
    {
      this.uDC.execSQL("DROP TABLE " + paramString);
      return false;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
      y.e(this.TAG, "drop table Error :" + paramString.getMessage());
      c.j(paramString);
    }
    return false;
  }
  
  public final boolean b(String paramString, HashMap<Integer, d> paramHashMap, boolean paramBoolean)
  {
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    acP(paramString);
    if ((this.uEh.a(paramString, paramHashMap, paramBoolean)) && (this.uEh.uDC != null))
    {
      this.uDC = this.uEh.uDC;
      y.i(this.TAG, "SqliteDB db %s", new Object[] { this.uDC });
      return true;
    }
    this.uDC = null;
    this.uEh = null;
    y.e(this.TAG, "initDB failed.");
    return false;
  }
  
  public void closeDB()
  {
    ek(null);
  }
  
  public final boolean csp()
  {
    return (this.uDC == null) || (!this.uDC.isOpen());
  }
  
  public final f cxf()
  {
    return this.uDC;
  }
  
  public final SQLiteDatabase cxg()
  {
    f localf = this.uDC;
    if (localf.uDL != null) {
      return localf.uDL;
    }
    return localf.uDM;
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.uDC.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.hHf);
      return j;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
      y.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.j(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    }
  }
  
  public final long eV(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        l2 = Thread.currentThread().getId();
        y.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.hHf), Boolean.valueOf(isOpen()), bk.csb() });
        if (!isOpen())
        {
          y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
          paramLong = -4L;
          return paramLong;
        }
        if (this.hHf > 0L)
        {
          y.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.hHf);
          paramLong = l1;
          continue;
        }
        if (ai.isMainThread()) {
          break label201;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        y.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
      }
      else
      {
        try
        {
          label201:
          c.begin();
          this.uDC.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.hHf = (bk.UY() & 0x7FFFFFFF);
          this.hHf |= (l2 & 0x7FFFFFFF) << 32;
          if (this.uEg != null) {
            this.uEg.DH();
          }
          paramLong = this.hHf;
        }
        catch (Exception localException)
        {
          com.tencent.mm.plugin.report.f.nEG.a(181L, 8L, 1L, false);
          y.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.j(localException);
          paramLong = -3L;
        }
      }
    }
  }
  
  public void ek(String paramString)
  {
    if (this.uDC == null) {
      return;
    }
    if (this.uEg != null) {
      this.uEg.DG();
    }
    y.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.hHf), Long.valueOf(Thread.currentThread().getId()), bk.csb() });
    g.a locala = new g.a();
    if (paramString != null) {
      this.uEi = paramString;
    }
    this.uDC.close();
    this.uDC = null;
    y.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.zJ()) });
  }
  
  protected void finalize()
  {
    ek(null);
  }
  
  public final String getKey()
  {
    if (this.uEh == null) {
      return null;
    }
    return this.uEh.key;
  }
  
  public final long getPageSize()
  {
    return this.uDC.uDL.getPageSize();
  }
  
  public final String getPath()
  {
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return null;
    }
    return this.uDC.getPath();
  }
  
  public final boolean gk(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.DS().crd();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.uDC.execSQL(paramString2);
        c.a(paramString2, null, this.hHf);
        return true;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        y.e(this.TAG, "execSQL Error :" + paramString2);
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label265;
        }
        paramString2 = this.uEh;
        y.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.uDD });
        com.tencent.mm.vfs.e.deleteFile(paramString2.uDD);
        if (this.uEj == null) {
          break;
        }
        this.uEj.DJ();
        throw paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
      }
    }
    label265:
    c.j(paramString1);
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    return false;
  }
  
  public final int hI(long paramLong)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        l1 = bk.UY();
        l2 = Thread.currentThread().getId();
        y.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.hHf), Boolean.valueOf(isOpen()), bk.csb() });
        if (isOpen()) {
          continue;
        }
        y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
        i = -4;
      }
      finally
      {
        try
        {
          long l1;
          long l2;
          long l3;
          c.begin();
          this.uDC.endTransaction();
          y.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", new Object[] { Long.valueOf(bk.co(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.hHf), Boolean.valueOf(isOpen()), bk.csb() });
          c.a("endTrans", null, 0L);
          this.hHf = 0L;
          i = j;
          if (this.uEg == null) {
            continue;
          }
          this.uEg.DI();
          i = j;
        }
        catch (Exception localException)
        {
          y.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          com.tencent.mm.plugin.report.f.nEG.a(181L, 9L, 1L, false);
          c.j(localException);
          int i = -3;
        }
        localObject = finally;
      }
      return i;
      if (paramLong != this.hHf)
      {
        y.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.hHf);
        i = -1;
      }
      else
      {
        l3 = paramLong >> 32 & 0x7FFFFFFF;
        if (l3 != l2)
        {
          y.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
          i = -2;
        }
      }
    }
  }
  
  /* Error */
  public final boolean inTransaction()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 148	com/tencent/mm/cf/h:isOpen	()Z
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: getfield 54	com/tencent/mm/cf/h:TAG	Ljava/lang/String;
    //   15: ldc 150
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: invokestatic 154	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   26: aastore
    //   27: invokestatic 156	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 80	com/tencent/mm/cf/h:hHf	J
    //   38: lstore_2
    //   39: lload_2
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle -12 -> 30
    //   45: iconst_1
    //   46: istore_1
    //   47: goto -17 -> 30
    //   50: astore 4
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 4
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	h
    //   1	46	1	bool	boolean
    //   38	2	2	l	long
    //   50	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	30	50	finally
    //   34	39	50	finally
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return a(paramString1, paramString2, paramContentValues, false);
  }
  
  public final boolean isOpen()
  {
    if ((this.uDC != null) && (this.uDC.isOpen())) {
      return true;
    }
    Assert.assertTrue("DB has been closed :[" + this.uEi + "]", bk.bl(this.uEi));
    return false;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, paramArrayOfString, 0);
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.uDC.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.hHf);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
      y.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.j(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    }
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    if (!isOpen())
    {
      y.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bk.csb() });
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.uDC.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.hHf);
      return j;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.nEG.a(181L, 11L, 1L, false);
      y.e(this.TAG, "update Error :" + paramString1.getMessage());
      c.j(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDBEnable, i);
    }
  }
  
  public static abstract interface a
  {
    public abstract void DG();
    
    public abstract void DH();
    
    public abstract void DI();
  }
  
  public static final class b
  {
    public long lastReportTime;
    public String table;
    public Cursor uEq;
    public String uEr;
    public long uEs;
    public boolean uEt;
    public String uEu;
    public h.c uEv;
  }
  
  private static final class c
    extends AssertionError
  {
    c() {}
    
    c(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface d
  {
    public abstract String[] rK();
  }
  
  public static abstract interface e
  {
    public abstract void DJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.h
 * JD-Core Version:    0.7.0.1
 */