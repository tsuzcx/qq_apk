package com.tencent.mm.plugin.ipcall.model.h;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b
{
  private static HashMap<String, c> DSH;
  public static final String jkN;
  
  static
  {
    AppMethodBeat.i(25535);
    jkN = new String(Character.toChars(91));
    DSH = new HashMap();
    AppMethodBeat.o(25535);
  }
  
  private static c a(Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(25534);
    if (!com.tencent.mm.pluginsdk.permission.b.o(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS"))
    {
      Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
      AppMethodBeat.o(25534);
      return null;
    }
    c localc = new c();
    localc.DSI = new ArrayList();
    Object localObject1 = paramCursor.getString(paramInt1);
    Object localObject3 = paramCursor.getString(paramInt2);
    paramCursor = paramCursor.getString(paramInt3);
    localc.field_contactId = ((String)localObject1);
    localc.field_systemAddressBookUsername = ((String)localObject3);
    if ((!Util.isNullOrNil(paramCursor)) && (!localc.DSI.contains(paramCursor))) {
      localc.DSI.add(paramCursor);
    }
    if ((Util.isNullOrNil(localc.field_systemAddressBookUsername)) && (localc.DSI.size() > 0)) {
      localc.field_systemAddressBookUsername = ((String)localc.DSI.get(0));
    }
    localObject3 = localc.DSI.iterator();
    paramCursor = null;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = a.aMz((String)((Iterator)localObject3).next());
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramCursor = (Cursor)localObject1;
        if (((String)localObject1).endsWith("@stranger")) {}
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil((String)localObject1)) {
        localc.field_wechatUsername = ((String)localObject1);
      }
      if (!Util.isNullOrNil(localc.field_systemAddressBookUsername)) {}
      for (;;)
      {
        try
        {
          paramCursor = f.ZJ(localc.field_systemAddressBookUsername);
          if (!Util.isNullOrNil(paramCursor)) {
            if (!Character.isLetter(paramCursor.charAt(0)))
            {
              localc.field_sortKey = (jkN + paramCursor.toUpperCase());
              AppMethodBeat.o(25534);
              return localc;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", new Object[] { paramCursor.getMessage(), paramCursor.getClass().getSimpleName() });
          paramCursor = localObject2;
          continue;
          localc.field_sortKey = paramCursor.toUpperCase();
          continue;
          localc.field_sortKey = "";
          continue;
        }
        localc.field_sortKey = "";
      }
      localObject1 = paramCursor;
    }
  }
  
  /* Error */
  public static ArrayList<String> aMb(String paramString)
  {
    // Byte code:
    //   0: sipush 25533
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 74	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 75	java/util/ArrayList:<init>	()V
    //   13: astore_1
    //   14: invokestatic 52	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   17: ldc 54
    //   19: invokestatic 59	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifne +18 -> 40
    //   25: ldc 61
    //   27: ldc 63
    //   29: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: sipush 25533
    //   35: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: invokestatic 52	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   43: invokevirtual 198	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: getstatic 204	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: aconst_null
    //   50: ldc 206
    //   52: iconst_1
    //   53: anewarray 19	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: aload_0
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 212	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_0
    //   65: aload_0
    //   66: ifnonnull +11 -> 77
    //   69: sipush 25533
    //   72: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: areturn
    //   77: aload_0
    //   78: invokeinterface 215 1 0
    //   83: ifeq +84 -> 167
    //   86: aload_0
    //   87: invokeinterface 218 1 0
    //   92: ifne +75 -> 167
    //   95: aload_1
    //   96: aload_0
    //   97: aload_0
    //   98: ldc 220
    //   100: invokeinterface 224 2 0
    //   105: invokeinterface 85 2 0
    //   110: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload_0
    //   115: invokeinterface 227 1 0
    //   120: pop
    //   121: goto -35 -> 86
    //   124: astore_2
    //   125: ldc 61
    //   127: ldc 229
    //   129: iconst_2
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_2
    //   136: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_2
    //   143: invokevirtual 179	java/lang/Object:getClass	()Ljava/lang/Class;
    //   146: invokevirtual 184	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: invokeinterface 234 1 0
    //   159: sipush 25533
    //   162: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_1
    //   166: areturn
    //   167: aload_0
    //   168: invokeinterface 234 1 0
    //   173: goto -14 -> 159
    //   176: astore_1
    //   177: aload_0
    //   178: invokeinterface 234 1 0
    //   183: sipush 25533
    //   186: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   13	153	1	localArrayList	ArrayList
    //   176	14	1	localObject	Object
    //   124	19	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   77	86	124	java/lang/Exception
    //   86	121	124	java/lang/Exception
    //   77	86	176	finally
    //   86	121	176	finally
    //   125	153	176	finally
  }
  
  public static ArrayList<c> eJT()
  {
    AppMethodBeat.i(25531);
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if (!com.tencent.mm.pluginsdk.permission.b.o(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS"))
    {
      Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
      AppMethodBeat.o(25531);
      return localArrayList;
    }
    Cursor localCursor = MMApplicationContext.getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id", "display_name", "data1" }, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
    HashMap localHashMap = new HashMap();
    Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - l1));
    if (localCursor == null)
    {
      AppMethodBeat.o(25531);
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (!localCursor.moveToFirst()) {
          break label476;
        }
        int i = localCursor.getColumnIndex("contact_id");
        int j = localCursor.getColumnIndex("display_name");
        int k = localCursor.getColumnIndex("data1");
        if (localCursor.isAfterLast()) {
          break label476;
        }
        c localc1 = a(localCursor, i, j, k);
        if ((localc1 != null) && (localc1.DSI != null) && (localc1.DSI.size() > 0) && (!Util.isNullOrNil(localc1.field_contactId)))
        {
          if (!localHashMap.containsKey(localc1.field_contactId)) {
            continue;
          }
          c localc2 = (c)localHashMap.get(localc1.field_contactId);
          if ((localc1.DSI.size() > 0) && (!localc2.DSI.contains(localc1.DSI.get(0)))) {
            localc2.DSI.add(localc1.DSI.get(0));
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", new Object[] { localException.getMessage(), localException.getClass().getSimpleName() });
        localCursor.close();
        localArrayList.addAll(localHashMap.values());
        DSH = localHashMap;
        l2 = System.currentTimeMillis();
        Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
        AppMethodBeat.o(25531);
        return localArrayList;
        localHashMap.put(localException.field_contactId, localException);
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(25531);
      }
      localCursor.moveToNext();
    }
    for (;;)
    {
      long l2;
      label476:
      localCursor.close();
    }
  }
  
  public static HashMap<String, c> eJU()
  {
    return DSH;
  }
  
  public static HashMap<String, c> eJV()
  {
    AppMethodBeat.i(25532);
    eJT();
    HashMap localHashMap = DSH;
    AppMethodBeat.o(25532);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.b
 * JD-Core Version:    0.7.0.1
 */