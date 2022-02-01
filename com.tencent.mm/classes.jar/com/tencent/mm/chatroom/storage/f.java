package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends MAutoStorage<e>
  implements MStorageEx.IOnStorageChange
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(182165);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "GroupTools") };
    INDEX_CREATE = new String[] { "DROP INDEX IF EXISTS usernameIndex", "CREATE INDEX IF NOT EXISTS GroupTools_usernameIndex ON GroupTools ( chatroomname )" };
    AppMethodBeat.o(182165);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.info, "GroupTools", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final e DE(String paramString)
  {
    AppMethodBeat.i(182160);
    if (Util.isNullOrNil(paramString))
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
      paramVarArgs = new nu();
      paramVarArgs.dTV.dOe = parame.field_chatroomname;
      EventCenter.instance.asyncPublish(paramVarArgs, Looper.getMainLooper());
    }
    AppMethodBeat.o(182162);
    return bool;
  }
  
  public final List<e> amp()
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
  
  public final void onNotifyChange(int paramInt, final MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(185975);
    if (!aa.ame())
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(185975);
      return;
    }
    if ((paramInt == 2) && (paramMStorageEx == ((l)g.af(l.class)).aSN()))
    {
      paramMStorageEx = (String)paramObject;
      if (ab.Ix(paramMStorageEx)) {
        h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194061);
            e locale = new e();
            locale.field_chatroomname = paramMStorageEx;
            locale.field_queryState = 1;
            boolean bool = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(locale);
            Log.i("MicroMsg.roomtools.GroupToolsStorage", "onNotifyChange username:%s result:%s", new Object[] { paramMStorageEx, Boolean.valueOf(bool) });
            AppMethodBeat.o(194061);
          }
        });
      }
    }
    AppMethodBeat.o(185975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.f
 * JD-Core Version:    0.7.0.1
 */