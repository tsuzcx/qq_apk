package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(87848);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "CardQrCodeDataInfo") };
    AppMethodBeat.o(87848);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "CardQrCodeDataInfo", k.INDEX_CREATE);
    this.db = parame;
  }
  
  public final List<k> HL(String paramString)
  {
    AppMethodBeat.i(87843);
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
        ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", new Object[] { localException.getMessage() });
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
        AppMethodBeat.o(87843);
      }
    }
  }
  
  public final k HM(String paramString)
  {
    AppMethodBeat.i(87844);
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
        ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[] { localException1.getMessage() });
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
        AppMethodBeat.o(87844);
      }
      try
      {
        ((k)localObject1).convertFrom(localCursor);
        ab.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        AppMethodBeat.o(87844);
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
  
  public final k HN(String paramString)
  {
    AppMethodBeat.i(87845);
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
        ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[] { localException1.getMessage() });
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
        AppMethodBeat.o(87845);
      }
      try
      {
        ((k)localObject1).convertFrom(localCursor);
        ab.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        AppMethodBeat.o(87845);
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      ab.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
  
  public final boolean dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87846);
    k localk = new k();
    localk.field_card_id = paramString1;
    localk.field_code_id = paramString2;
    boolean bool = delete(localk, new String[] { "card_id", "code_id" });
    if (!bool) {
      ab.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
    }
    for (;;)
    {
      AppMethodBeat.o(87846);
      return bool;
      ab.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
    }
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(87847);
    k localk = new k();
    localk.field_card_id = paramString;
    boolean bool = delete(localk, new String[] { "card_id" });
    if (!bool) {
      ab.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(87847);
      return bool;
      ab.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.l
 * JD-Core Version:    0.7.0.1
 */