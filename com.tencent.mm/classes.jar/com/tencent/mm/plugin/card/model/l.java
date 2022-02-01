package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(112790);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "CardQrCodeDataInfo") };
    AppMethodBeat.o(112790);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "CardQrCodeDataInfo", k.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<k> ajm(String paramString)
  {
    AppMethodBeat.i(112785);
    ArrayList localArrayList = new ArrayList();
    paramString = this.db.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { paramString });
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        if (paramString.moveToNext())
        {
          k localk = new k();
          localk.convertFrom(paramString);
          localArrayList.add(localk);
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", new Object[] { localException.getMessage() });
        for (;;)
        {
          return localArrayList;
          if (paramString != null) {
            paramString.close();
          }
        }
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(112785);
      }
    }
  }
  
  public final k ajn(String paramString)
  {
    AppMethodBeat.i(112786);
    localCursor = this.db.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[] { paramString });
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToPosition(0);
          localObject1 = new k();
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        paramString = null;
        Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[] { localException1.getMessage() });
        localObject2 = paramString;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        localObject2 = paramString;
        continue;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(112786);
      }
      try
      {
        ((k)localObject1).convertFrom(localCursor);
        Log.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        AppMethodBeat.o(112786);
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
  
  public final k ajo(String paramString)
  {
    AppMethodBeat.i(112787);
    localCursor = this.db.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[] { paramString });
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToPosition(0);
          localObject1 = new k();
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        paramString = null;
        Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[] { localException1.getMessage() });
        localObject2 = paramString;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        localObject2 = paramString;
        continue;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(112787);
      }
      try
      {
        ((k)localObject1).convertFrom(localCursor);
        Log.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        AppMethodBeat.o(112787);
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      Log.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
  
  public final boolean fr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112788);
    k localk = new k();
    localk.field_card_id = paramString1;
    localk.field_code_id = paramString2;
    boolean bool = delete(localk, new String[] { "card_id", "code_id" });
    if (!bool) {
      Log.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
    }
    for (;;)
    {
      AppMethodBeat.o(112788);
      return bool;
      Log.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
    }
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(112789);
    k localk = new k();
    localk.field_card_id = paramString;
    boolean bool = delete(localk, new String[] { "card_id" });
    if (!bool) {
      Log.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(112789);
      return bool;
      Log.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.l
 * JD-Core Version:    0.7.0.1
 */