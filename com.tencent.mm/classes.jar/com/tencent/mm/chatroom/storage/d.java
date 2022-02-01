package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends j<c>
  implements n.b
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(182165);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "GroupTools") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS usernameIndex ON GroupTools ( chatroomname )" };
    AppMethodBeat.o(182165);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "GroupTools", INDEX_CREATE);
    this.db = parame;
  }
  
  public final List<c> VZ()
  {
    AppMethodBeat.i(185974);
    Cursor localCursor = this.db.query("GroupTools", c.info.columns, null, null, null, null, null);
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
        c localc = new c();
        localc.convertFrom(localCursor);
        localArrayList.add(localc);
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
    if (!aa.VQ())
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramInt == 2) && (paramn == ((k)g.ab(k.class)).awB()))
    {
      paramn = (String)paramObject;
      if (w.wp(paramn))
      {
        paramObject = new c();
        paramObject.field_chatroomname = paramn;
        paramObject.field_queryState = 1;
        ac.i("MicroMsg.roomtools.GroupToolsStorage", "onNotifyChange username:%s result:%s", new Object[] { paramn, Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(paramObject)) });
      }
    }
    AppMethodBeat.o(185975);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(182161);
    if (paramc == null)
    {
      AppMethodBeat.o(182161);
      return false;
    }
    boolean bool = super.insert(paramc);
    AppMethodBeat.o(182161);
    return bool;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(182162);
    boolean bool = super.updateNotify(paramc, true, paramVarArgs);
    if (bool)
    {
      paramVarArgs = new mu();
      paramVarArgs.dpo.djF = paramc.field_chatroomname;
      a.GpY.a(paramVarArgs, Looper.getMainLooper());
    }
    AppMethodBeat.o(182162);
    return bool;
  }
  
  public final c sb(String paramString)
  {
    AppMethodBeat.i(182160);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(182160);
      return null;
    }
    paramString = this.db.query("GroupTools", c.info.columns, "chatroomname=?", new String[] { paramString }, null, null, null);
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
        c localc2 = new c();
        localc2.convertFrom(paramString);
        localArrayList.add(localc2);
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
    c localc1 = (c)localObject.get(0);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(182160);
    return localc1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.d
 * JD-Core Version:    0.7.0.1
 */