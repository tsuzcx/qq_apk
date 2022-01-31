package com.tencent.mm.ai;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.sdk.e.i<g>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(g.buS, "BizKF") };
  public com.tencent.mm.sdk.e.e dXw;
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, g.buS, "BizKF", null);
    this.dXw = parame;
    parame.gk("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
    parame.gk("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
  }
  
  public static boolean a(g paramg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramg != null)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - paramg.field_updateTime >= 86400000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(g paramg)
  {
    if ((paramg == null) || (bk.bl(paramg.field_openId)) || (bk.bl(paramg.field_brandUsername)))
    {
      y.w("MicroMsg.BizKFStorage", "wrong argument");
      return false;
    }
    ContentValues localContentValues = paramg.vf();
    if (this.dXw.replace("BizKF", g.buS.ujM, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[] { paramg.field_openId, paramg.field_brandUsername, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final int f(LinkedList<g> paramLinkedList)
  {
    if (paramLinkedList.size() <= 0)
    {
      y.e("MicroMsg.BizKFStorage", "null kfs");
      return 0;
    }
    if ((this.dXw instanceof h)) {}
    for (long l = ((h)this.dXw).eV(Thread.currentThread().getId());; l = 0L)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        g localg = (g)paramLinkedList.next();
        if ((localg == null) || (!b(localg))) {
          break label132;
        }
        i += 1;
      }
      label132:
      for (;;)
      {
        break;
        if ((this.dXw instanceof h)) {
          com.tencent.mm.kernel.g.DP().dKu.hI(l);
        }
        y.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(i) });
        return i;
      }
    }
  }
  
  public final g lg(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    Cursor localCursor = this.dXw.a("BizKF", null, "openId=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.BizKFStorage", "get null with openId:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new g();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
  
  public final g lh(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Cursor localCursor = this.dXw.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new g();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.i
 * JD-Core Version:    0.7.0.1
 */