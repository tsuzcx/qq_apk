package com.tencent.mm.cg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public class h
  implements com.tencent.mm.sdk.e.f
{
  String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  private long jAB;
  private a yQP;
  public a yQQ;
  private String yQR;
  public e yQS;
  public String yQT;
  final LinkedList<b> yQU;
  private ak yQV;
  protected f yQj;
  
  public h()
  {
    AppMethodBeat.i(59102);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.yQj = null;
    this.yQP = null;
    this.yQQ = new a();
    this.yQR = "";
    this.yQS = null;
    this.yQT = "";
    this.yQU = new LinkedList();
    this.yQV = null;
    this.jAB = 0L;
    AppMethodBeat.o(59102);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(59101);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.yQj = null;
    this.yQP = null;
    this.yQQ = new a();
    this.yQR = "";
    this.yQS = null;
    this.yQT = "";
    this.yQU = new LinkedList();
    this.yQV = null;
    this.jAB = 0L;
    this.yQP = parama;
    AppMethodBeat.o(59101);
  }
  
  private void atd(String paramString)
  {
    AppMethodBeat.i(59107);
    String str1 = ah.getProcessName();
    String str2 = ah.getPackageName();
    ab.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    AppMethodBeat.o(59107);
  }
  
  public static String escape(String paramString)
  {
    AppMethodBeat.i(59113);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59113);
      return "";
    }
    paramString = DatabaseUtils.sqlEscapeString(paramString);
    AppMethodBeat.o(59113);
    return paramString;
  }
  
  public final long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(156571);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(156571);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.RO().dtc();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.yQj.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.jAB);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
      ab.e(this.TAG, "insert Error :" + paramString1.getMessage());
      c.i(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(156571);
    }
  }
  
  public final Cursor a(final String paramString, final String[] paramArrayOfString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(59116);
    if (!bo.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      paramString = d.dzJ();
      AppMethodBeat.o(59116);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.RO().dtc();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.yQj.a(paramString, paramArrayOfString, paramInt);
      if ((b.dsd()) || (b.dsf()))
      {
        if (this.yQV == null)
        {
          localObject = com.tencent.mm.sdk.g.d.aqu("CheckCursor");
          ((HandlerThread)localObject).start();
          this.yQV = new ak(((HandlerThread)localObject).getLooper());
        }
        Object localObject = new c();
        this.yQV.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(59100);
            long l1;
            boolean bool1;
            Object localObject7;
            int i;
            Object localObject8;
            Object localObject9;
            for (;;)
            {
              try
              {
                l1 = bo.aoy();
                if (paramArrayOfString != null)
                {
                  bool1 = paramArrayOfString.isClosed();
                  if (!bool1) {}
                }
                else
                {
                  AppMethodBeat.o(59100);
                  return;
                }
                localObject7 = new HashMap();
                i = 0;
                Object localObject1 = null;
                synchronized (h.this.yQU)
                {
                  localObject8 = h.this.yQU.iterator();
                  if (!((Iterator)localObject8).hasNext()) {
                    break label641;
                  }
                  localObject9 = (h.b)((Iterator)localObject8).next();
                  if (localObject9 == null)
                  {
                    ??? = null;
                    if ((??? != null) && (!((Cursor)???).isClosed())) {
                      break;
                    }
                    ((Iterator)localObject8).remove();
                  }
                }
                ??? = (Cursor)((h.b)localObject9).yQZ.get();
              }
              catch (Exception localException1)
              {
                ab.e(h.this.TAG, "checkCursor table:[%s] e:%s[%s]", new Object[] { paramString, localException1.getMessage(), bo.l(localException1) });
                AppMethodBeat.o(59100);
                return;
              }
            }
            int j;
            if ((l1 - ((h.b)localObject9).lastReportTime) / 1000L > 100L)
            {
              ((h.b)localObject9).lastReportTime = l1;
              if (!((h.b)localObject9).yRc) {
                break label506;
              }
              if (TextUtils.isEmpty(((h.b)localObject9).yRd)) {
                ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).yRb), Integer.valueOf(((h.b)localObject9).yQZ.hashCode()), ((h.b)localObject9).yRa, Boolean.valueOf(((h.b)localObject9).yRc), ((h.b)localObject9).yRd });
              }
            }
            else
            {
              ??? = (Pair)((HashMap)localObject7).get(((h.b)localObject9).yRa);
              if (??? != null) {
                break label580;
              }
              if (l1 - ((h.b)localObject9).yRb <= 30000L) {
                break label1398;
              }
              j = 1;
              label361:
              ??? = new Pair(Integer.valueOf(j), localObject9);
              ((HashMap)localObject7).put(((h.b)localObject9).yRa, ???);
            }
            label389:
            Object localObject3;
            label506:
            long l2;
            for (;;)
            {
              if (i < ((Integer)((Pair)???).first).intValue())
              {
                i = ((Integer)((Pair)???).first).intValue();
                localObject3 = ((h.b)((Pair)???).second).yRe;
                break label1395;
                ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).yRb), Integer.valueOf(((h.b)localObject9).yQZ.hashCode()), ((h.b)localObject9).yRa, Boolean.valueOf(((h.b)localObject9).yRc), ((h.b)localObject9).yRd });
                break;
                ab.w(h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((h.b)localObject9).yRb), Integer.valueOf(((h.b)localObject9).yQZ.hashCode()), ((h.b)localObject9).yRa, Boolean.valueOf(((h.b)localObject9).yRc), ((h.b)localObject9).yRd });
                break;
                label580:
                if (l1 - ((h.b)localObject9).yRb <= 30000L) {
                  break label1392;
                }
                ??? = new Pair(Integer.valueOf(((Integer)((Pair)???).first).intValue() + 1), ((Pair)???).second);
                ((HashMap)localObject7).put(((h.b)localObject9).yRa, ???);
                continue;
                label641:
                ab.d(h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(h.this.yQU.size()), Integer.valueOf(((HashMap)localObject7).size()) });
                if (!b.dsd()) {
                  break label1411;
                }
                j = 20;
                label700:
                if (i <= j)
                {
                  j = h.this.yQU.size();
                  if (!b.dsd()) {
                    break label1417;
                  }
                  i = 50;
                  break label1403;
                }
                label728:
                localObject8 = ((HashMap)localObject7).keySet().iterator();
                Pair localPair;
                for (??? = ""; ((Iterator)localObject8).hasNext(); ??? = (String)??? + (String)localObject9 + "," + localPair.first + "," + ((h.b)localPair.second).yRc + "," + ((h.b)localPair.second).yRd + ";")
                {
                  localObject9 = (String)((Iterator)localObject8).next();
                  localPair = (Pair)((HashMap)localObject7).get(localObject9);
                }
                if (localObject3 != null)
                {
                  ??? = new h.c((String)???);
                  ((h.c)???).setStackTrace(((h.c)localObject3).getStackTrace());
                  AppMethodBeat.o(59100);
                  throw ((Throwable)???);
                }
                localObject3 = new AssertionError(???);
                AppMethodBeat.o(59100);
                throw ((Throwable)localObject3);
                label912:
                l2 = bo.aoy();
                localObject3 = new h.b();
                ((h.b)localObject3).yQZ = new WeakReference(paramArrayOfString);
                ((h.b)localObject3).table = paramString;
                ((h.b)localObject3).yRb = l1;
                ((h.b)localObject3).yRa = "";
                ((h.b)localObject3).yRc = true;
                ((h.b)localObject3).yRe = this.yQX;
                ??? = this.yQX.getStackTrace();
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
                  int k;
                  boolean bool2;
                  label1392:
                  label1395:
                  label1398:
                  label1403:
                  i = 0;
                  label1411:
                  label1417:
                  continue;
                  j += 1;
                }
                if (i != 0) {
                  continue;
                }
                if (TextUtils.isEmpty(((h.b)localObject3).yRa))
                {
                  ((h.b)localObject3).yRa = ((String)localObject7);
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
                    ((h.b)localObject3).yRc = bool2;
                    continue;
                  }
                }
                else
                {
                  if (((h.b)localObject3).yRc)
                  {
                    ??? = ((String)localObject7).toLowerCase();
                    if ((!((String)???).contains("cursor")) && (!((String)???).contains("adapter"))) {
                      continue;
                    }
                    ((h.b)localObject3).yRd = ((String)localObject7);
                    continue;
                  }
                  if (TextUtils.isEmpty(((h.b)localObject3).yRa)) {
                    ((h.b)localObject3).yRa = an.stackTraceToString((StackTraceElement[])???);
                  }
                  synchronized (h.this.yQU)
                  {
                    h.this.yQU.add(localObject3);
                    ab.d(h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(bo.hl(l1)), ((h.b)localObject3).yRa, Boolean.valueOf(((h.b)localObject3).yRc), ((h.b)localObject3).yRd });
                    AppMethodBeat.o(59100);
                    return;
                  }
                  continue;
                  break label389;
                  break;
                  j = 0;
                  break label361;
                  if (j > i)
                  {
                    break label728;
                    j = 50;
                    break label700;
                    i = 100;
                    continue;
                  }
                  break label912;
                }
                i += 1;
                continue;
                i = 0;
              }
            }
          }
        }, 500L);
      }
      c.a(paramString, paramArrayOfString, this.jAB);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 10L, 1L, false);
      ab.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.i(paramString);
      paramString = d.dzJ();
      return paramString;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(59116);
    }
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(59115);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      paramString1 = d.dzJ();
      AppMethodBeat.o(59115);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.RO().dtc();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.yQj.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
        c.a(paramString1, paramArrayOfString1, this.jAB);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 10L, 1L, false);
        ab.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.i(paramString1);
        paramString1 = d.dzJ();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(59115);
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, HashMap<Integer, d> paramHashMap)
  {
    AppMethodBeat.i(59110);
    boolean bool = b(paramString1, paramString2, "", paramLong, paramHashMap, true);
    AppMethodBeat.o(59110);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, DBDumpUtil.ExecuteSqlCallback paramExecuteSqlCallback)
  {
    AppMethodBeat.i(59118);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59118);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.yQj.yQt, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(59118);
    return bool;
  }
  
  public final boolean ate(String paramString)
  {
    AppMethodBeat.i(59126);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59126);
      return false;
    }
    try
    {
      this.yQj.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(59126);
      return false;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
      ab.e(this.TAG, "drop table Error :" + paramString.getMessage());
      c.i(paramString);
      AppMethodBeat.o(59126);
    }
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, d> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(59109);
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    atd(paramString2);
    if ((this.yQQ.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.yQQ.yQj != null))
    {
      this.yQT = this.yQQ.getError();
      this.yQj = this.yQQ.yQj;
      AppMethodBeat.o(59109);
      return true;
    }
    this.yQT = this.yQQ.getError();
    this.yQj = null;
    this.yQQ = null;
    ab.i(this.TAG, "initDB failed. %s", new Object[] { this.yQT });
    AppMethodBeat.o(59109);
    return false;
  }
  
  public final boolean b(String paramString, HashMap<Integer, d> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(59108);
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    atd(paramString);
    if ((this.yQQ.a(paramString, paramHashMap, paramBoolean)) && (this.yQQ.yQj != null))
    {
      this.yQj = this.yQQ.yQj;
      ab.i(this.TAG, "SqliteDB db %s", new Object[] { this.yQj });
      AppMethodBeat.o(59108);
      return true;
    }
    this.yQj = null;
    this.yQQ = null;
    ab.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(59108);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(146162);
    this.yQj.close();
    AppMethodBeat.o(146162);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(59104);
    kr(null);
    AppMethodBeat.o(59104);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(59125);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59125);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.RO().dtc();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.yQj.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.jAB);
      return j;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
      ab.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.i(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(59125);
    }
  }
  
  public final boolean dun()
  {
    AppMethodBeat.i(59106);
    if ((this.yQj == null) || (!this.yQj.isOpen()))
    {
      AppMethodBeat.o(59106);
      return true;
    }
    AppMethodBeat.o(59106);
    return false;
  }
  
  public final f dzU()
  {
    return this.yQj;
  }
  
  public final SQLiteDatabase dzV()
  {
    f localf = this.yQj;
    if (localf.yQt != null) {
      return localf.yQt;
    }
    return localf.yQu;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59120);
    if (!bo.isNullOrNil(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59120);
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.RO().dtc();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.yQj.execSQL(paramString2);
        c.a(paramString2, null, this.jAB);
        return true;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        ab.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label289;
        }
        paramString2 = this.yQQ;
        ab.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.yQk });
        com.tencent.mm.vfs.e.deleteFile(paramString2.yQk);
        if (this.yQS == null) {
          break;
        }
        this.yQS.RE();
        AppMethodBeat.o(59120);
        throw paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(59120);
      }
    }
    label289:
    c.i(paramString1);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
    AppMethodBeat.o(59120);
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(59103);
    kr(null);
    AppMethodBeat.o(59103);
  }
  
  public final String getKey()
  {
    if (this.yQQ == null) {
      return null;
    }
    return this.yQQ.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(59119);
    long l = this.yQj.yQt.getPageSize();
    AppMethodBeat.o(59119);
    return l;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(59112);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59112);
      return null;
    }
    String str = this.yQj.getPath();
    AppMethodBeat.o(59112);
    return str;
  }
  
  /* Error */
  public final boolean inTransaction()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 461
    //   7: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 161	com/tencent/mm/cg/h:isOpen	()Z
    //   14: ifne +32 -> 46
    //   17: aload_0
    //   18: getfield 61	com/tencent/mm/cg/h:TAG	Ljava/lang/String;
    //   21: ldc 163
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: invokestatic 167	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   32: aastore
    //   33: invokestatic 169	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 461
    //   39: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 87	com/tencent/mm/cg/h:jAB	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +14 -> 66
    //   55: ldc_w 461
    //   58: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -21 -> 42
    //   66: ldc_w 461
    //   69: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -30 -> 42
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	h
    //   1	62	1	bool	boolean
    //   75	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	42	75	finally
    //   46	61	75	finally
    //   66	72	75	finally
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(156845);
    long l = a(paramString1, paramString2, paramContentValues);
    AppMethodBeat.o(156845);
    return l;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(59111);
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      AppMethodBeat.o(59111);
      return true;
    }
    Assert.assertTrue("DB has been closed :[" + this.yQR + "]", bo.isNullOrNil(this.yQR));
    AppMethodBeat.o(59111);
    return false;
  }
  
  public final long kr(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        AppMethodBeat.i(59127);
        l2 = Thread.currentThread().getId();
        ab.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.jAB), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
          paramLong = -4L;
          AppMethodBeat.o(59127);
          return paramLong;
        }
        if (this.jAB > 0L)
        {
          ab.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.jAB);
          AppMethodBeat.o(59127);
          paramLong = l1;
          continue;
        }
        if (al.isMainThread()) {
          break label219;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        ab.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
        AppMethodBeat.o(59127);
      }
      else
      {
        try
        {
          label219:
          c.begin();
          this.yQj.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.jAB = (bo.aoy() & 0x7FFFFFFF);
          this.jAB |= (l2 & 0x7FFFFFFF) << 32;
          if (this.yQP != null) {
            this.yQP.RC();
          }
          paramLong = this.jAB;
          AppMethodBeat.o(59127);
        }
        catch (Exception localException)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 8L, 1L, false);
          ab.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.i(localException);
          paramLong = -3L;
          AppMethodBeat.o(59127);
        }
      }
    }
  }
  
  public void kr(String paramString)
  {
    AppMethodBeat.i(59105);
    if (this.yQj == null)
    {
      AppMethodBeat.o(59105);
      return;
    }
    if (this.yQP != null) {
      this.yQP.RB();
    }
    ab.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.jAB), Long.valueOf(Thread.currentThread().getId()), bo.dtY() });
    g.a locala = new g.a();
    if (paramString != null) {
      this.yQR = paramString;
    }
    this.yQj.close();
    this.yQj = null;
    ab.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.Mm()) });
    AppMethodBeat.o(59105);
  }
  
  public final int nY(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        AppMethodBeat.i(59128);
        l1 = bo.aoy();
        l2 = Thread.currentThread().getId();
        ab.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.jAB), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
          i = -4;
          AppMethodBeat.o(59128);
          return i;
        }
        if (paramLong != this.jAB)
        {
          ab.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.jAB);
          i = -1;
          AppMethodBeat.o(59128);
          continue;
        }
        l3 = paramLong >> 32 & 0x7FFFFFFF;
      }
      finally {}
      long l3;
      if (l3 != l2)
      {
        ab.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        AppMethodBeat.o(59128);
      }
      else
      {
        try
        {
          c.begin();
          this.yQj.endTransaction();
          ab.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(bo.hl(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.jAB), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.jAB = 0L;
          if (this.yQP != null) {
            this.yQP.RD();
          }
          AppMethodBeat.o(59128);
        }
        catch (Exception localException)
        {
          ab.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 9L, 1L, false);
          c.i(localException);
          i = -3;
          AppMethodBeat.o(59128);
        }
      }
    }
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(59114);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
    AppMethodBeat.o(59114);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156844);
    paramString = a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(156844);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(59124);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59124);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.RO().dtc();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.yQj.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.jAB);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
      ab.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.i(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(59124);
    }
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59123);
    if (!isOpen())
    {
      ab.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bo.dtY() });
      AppMethodBeat.o(59123);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.RO().dtc();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.yQj.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.jAB);
        return j;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 11L, 1L, false);
        ab.e(this.TAG, "update Error :" + paramString1.getMessage());
        c.i(paramString1);
        return -1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(59123);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void RB();
    
    public abstract void RC();
    
    public abstract void RD();
  }
  
  public static final class b
  {
    public long lastReportTime;
    public String table;
    public WeakReference<Cursor> yQZ;
    public String yRa;
    public long yRb;
    public boolean yRc;
    public String yRd;
    public h.c yRe;
  }
  
  static final class c
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
    public abstract String[] getSQLs();
  }
  
  public static abstract interface e
  {
    public abstract void RE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.h
 * JD-Core Version:    0.7.0.1
 */