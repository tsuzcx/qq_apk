package com.tencent.mm.plugin.groupsolitaire.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final Long uBG;
  public static final Long uBH;
  private e db;
  
  static
  {
    AppMethodBeat.i(110411);
    uBG = Long.valueOf(86400L);
    uBH = Long.valueOf(3600L);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "GroupSolitatire") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS usernameIndex ON GroupSolitatire ( username )", "CREATE INDEX IF NOT EXISTS usernameKeyIndex ON GroupSolitatire ( username,key )", "CREATE INDEX IF NOT EXISTS usernameKeyActiveIndex ON GroupSolitatire ( username,key,active )" };
    AppMethodBeat.o(110411);
  }
  
  public c(e parame)
  {
    super(parame, a.info, "GroupSolitatire", INDEX_CREATE);
    this.db = parame;
  }
  
  public final List<a> G(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110407);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110407);
      return localArrayList;
    }
    paramString = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime<?", new String[] { paramString, String.valueOf(paramInt), String.valueOf(paramLong) }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(110407);
      return localArrayList;
    }
    while (paramString.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(paramString);
      localArrayList.add(locala);
    }
    AppMethodBeat.o(110407);
    return localArrayList;
  }
  
  public final boolean H(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110408);
    try
    {
      paramInt = this.db.delete("GroupSolitatire", "username=? and lastActiveTime<? and active=?", new String[] { paramString, String.valueOf(paramLong), String.valueOf(paramInt) });
      if (paramInt > 0)
      {
        AppMethodBeat.o(110408);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.groupsolitaire.GroupSolitatireStorage", "deleteExpireData username:%s lastTime:%s Exception:%s", new Object[] { paramString, Long.valueOf(paramLong), localException.getMessage() });
        paramInt = 0;
      }
      AppMethodBeat.o(110408);
    }
    return false;
  }
  
  public final boolean a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(110405);
    if (parama == null)
    {
      AppMethodBeat.o(110405);
      return false;
    }
    if (b.h(parama))
    {
      AppMethodBeat.o(110405);
      return false;
    }
    if (!paramBoolean)
    {
      parama.field_content = b.e(parama);
      if (parama.uBB.size() <= 1) {
        break label101;
      }
      parama.field_active = 1;
    }
    for (;;)
    {
      paramBoolean = update(parama.systemRowid, parama);
      if (paramBoolean) {
        ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ho(parama.field_username, parama.field_key);
      }
      AppMethodBeat.o(110405);
      return paramBoolean;
      label101:
      if (parama.field_active == -1) {
        parama.field_active = 0;
      }
    }
  }
  
  public final List<a> dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(110406);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110406);
      return localArrayList;
    }
    Cursor localCursor = null;
    long l = cf.aCN();
    if (paramInt == 1) {
      localCursor = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime>=?", new String[] { paramString, "1", l - b.dbi() * uBG.longValue() }, null, null, "lastActiveTime DESC ");
    }
    while (localCursor == null)
    {
      AppMethodBeat.o(110406);
      return localArrayList;
      if (paramInt == 0) {
        localCursor = this.db.query("GroupSolitatire", a.info.columns, "username=? and active=? and lastActiveTime>=?", new String[] { paramString, "0", l - b.dbk() * uBH.longValue() }, null, null, "lastActiveTime DESC ");
      }
    }
    while (localCursor.moveToNext())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
      b.f(paramString);
      localArrayList.add(paramString);
    }
    AppMethodBeat.o(110406);
    return localArrayList;
  }
  
  public final a hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110404);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110404);
      return null;
    }
    paramString2 = this.db.query("GroupSolitatire", a.info.columns, "username=? and key=?", new String[] { paramString1, paramString2 }, null, null, "lastActiveTime");
    if (paramString2 == null)
    {
      AppMethodBeat.o(110404);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramString2.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(paramString2);
      b.f(locala);
      localArrayList.add(locala);
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(110404);
      return null;
    }
    paramString2 = (a)localArrayList.get(0);
    paramString1 = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().amS(paramString1);
    if (paramString1 != null)
    {
      if ((paramString2.field_active == 0) && (paramString2.field_lastActiveTime >= paramString1.uAZ))
      {
        AppMethodBeat.o(110404);
        return paramString2;
      }
      if ((paramString2.field_active == 1) && (paramString2.field_lastActiveTime >= paramString1.uAX))
      {
        AppMethodBeat.o(110404);
        return paramString2;
      }
    }
    AppMethodBeat.o(110404);
    return null;
  }
  
  public final boolean i(a parama)
  {
    AppMethodBeat.i(110409);
    if (parama == null)
    {
      AppMethodBeat.o(110409);
      return false;
    }
    if (b.h(parama))
    {
      AppMethodBeat.o(110409);
      return false;
    }
    parama.field_content = b.e(parama);
    if (parama.uBB.size() > 1) {
      parama.field_active = 1;
    }
    for (;;)
    {
      boolean bool = super.insert(parama);
      AppMethodBeat.o(110409);
      return bool;
      if (parama.field_active == -1) {
        parama.field_active = 0;
      }
    }
  }
  
  public final a p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(215782);
    paramString2 = hq(paramString1, paramString2);
    if (!paramBoolean)
    {
      AppMethodBeat.o(215782);
      return paramString2;
    }
    paramString1 = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().amS(paramString1);
    if ((paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(215782);
      return paramString2;
    }
    if (paramString2.field_active == 1)
    {
      if (paramString2.field_lastActiveTime < paramString1.uAX)
      {
        if (paramString1.uAW)
        {
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.a(paramString2, 2);
        }
        while (delete(paramString2.systemRowid))
        {
          AppMethodBeat.o(215782);
          return null;
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.a(paramString2, 1);
        }
      }
    }
    else if ((paramString2.field_active == 0) && (paramString2.field_lastActiveTime < paramString1.uAZ))
    {
      if (paramString1.uAY)
      {
        ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
        d.a(paramString2, 2);
      }
      while (delete(paramString2.systemRowid))
      {
        AppMethodBeat.o(215782);
        return null;
        ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
        d.a(paramString2, 1);
      }
    }
    AppMethodBeat.o(215782);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.c.c
 * JD-Core Version:    0.7.0.1
 */