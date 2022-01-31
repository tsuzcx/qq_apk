package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class l
  extends i<k>
{
  public static final String[] dXp = { i.a(k.buS, "CardQrCodeDataInfo") };
  public e dXw;
  
  public l(e parame)
  {
    super(parame, k.buS, "CardQrCodeDataInfo", k.cqY);
    this.dXw = parame;
  }
  
  public final boolean cs(String paramString1, String paramString2)
  {
    k localk = new k();
    localk.field_card_id = paramString1;
    localk.field_code_id = paramString2;
    boolean bool = a(localk, new String[] { "card_id", "code_id" });
    if (!bool)
    {
      y.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
      return bool;
    }
    y.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", new Object[] { localk.field_card_id, localk.field_code_id });
    return bool;
  }
  
  public final boolean jJ(String paramString)
  {
    k localk = new k();
    localk.field_card_id = paramString;
    boolean bool = a(localk, new String[] { "card_id" });
    if (!bool)
    {
      y.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", new Object[] { paramString });
      return bool;
    }
    y.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", new Object[] { paramString });
    return bool;
  }
  
  public final List<k> yk(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = this.dXw.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { paramString });
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        if (paramString.moveToNext())
        {
          k localk = new k();
          localk.d(paramString);
          localArrayList.add(localk);
          continue;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", new Object[] { localException.getMessage() });
        return localArrayList;
        return localArrayList;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
  
  public final k yl(String paramString)
  {
    localCursor = this.dXw.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[] { paramString });
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
        y.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[] { localException1.getMessage() });
        localObject2 = paramString;
        return paramString;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      try
      {
        ((k)localObject1).d(localCursor);
        y.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      y.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
  
  public final k ym(String paramString)
  {
    localCursor = this.dXw.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[] { paramString });
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
        y.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[] { localException1.getMessage() });
        localObject2 = paramString;
        return paramString;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      try
      {
        ((k)localObject1).d(localCursor);
        y.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", new Object[] { paramString, ((k)localObject1).field_code_id });
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localCursor != null)
        {
          localCursor.close();
          localObject1 = paramString;
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject2;
        localObject2 = localException2;
        continue;
      }
      y.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", new Object[] { paramString });
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.l
 * JD-Core Version:    0.7.0.1
 */