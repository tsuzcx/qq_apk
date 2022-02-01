package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends j<e>
  implements n.b
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(182165);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "GroupTools") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS usernameIndex ON GroupTools ( chatroomname )" };
    AppMethodBeat.o(182165);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "GroupTools", INDEX_CREATE);
    this.db = parame;
  }
  
  public final List<e> Yt()
  {
    AppMethodBeat.i(185974);
    Cursor localCursor = this.db.query("GroupTools", e.info.columns, null, null, null, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(185974);
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext())
      {
        e locale = new e();
        locale.convertFrom(localCursor);
        localArrayList.add(locale);
      }
      if (localCursor == null) {
        break label108;
      }
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(185974);
    }
    localCursor.close();
    label108:
    AppMethodBeat.o(185974);
    return localList;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(185975);
    if (!aa.Yh())
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramInt == 2) && (paramn == ((l)g.ab(l.class)).azp()))
    {
      paramn = (String)paramObject;
      if (w.zk(paramn))
      {
        paramObject = new e();
        paramObject.field_chatroomname = paramn;
        paramObject.field_queryState = 1;
        ad.i("MicroMsg.roomtools.GroupToolsStorage", "onNotifyChange username:%s result:%s", new Object[] { paramn, Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramObject)) });
      }
    }
    AppMethodBeat.o(185975);
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(182161);
    if (parame == null)
    {
      AppMethodBeat.o(182161);
      return false;
    }
    boolean bool = super.insert(parame);
    AppMethodBeat.o(182161);
    return bool;
  }
  
  public final boolean a(e parame, String... paramVarArgs)
  {
    AppMethodBeat.i(182162);
    boolean bool = super.updateNotify(parame, true, paramVarArgs);
    if (bool)
    {
      paramVarArgs = new nc();
      paramVarArgs.dBb.dvs = parame.field_chatroomname;
      a.IbL.a(paramVarArgs, Looper.getMainLooper());
    }
    AppMethodBeat.o(182162);
    return bool;
  }
  
  public final e uR(String paramString)
  {
    AppMethodBeat.i(182160);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182160);
      return null;
    }
    paramString = this.db.query("GroupTools", e.info.columns, "chatroomname=?", new String[] { paramString }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(182160);
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        e locale2 = new e();
        locale2.convertFrom(paramString);
        localArrayList.add(locale2);
      }
      i = localObject.size();
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(182160);
    }
    int i;
    if (i == 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(182160);
      return null;
    }
    e locale1 = (e)localObject.get(0);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(182160);
    return locale1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.f
 * JD-Core Version:    0.7.0.1
 */