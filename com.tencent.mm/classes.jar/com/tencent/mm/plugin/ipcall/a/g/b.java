package com.tencent.mm.plugin.ipcall.a.g;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b
{
  public static final String dse = new String(Character.toChars(91));
  private static HashMap<String, c> lsH = new HashMap();
  
  /* Error */
  public static ArrayList<String> Fz(String paramString)
  {
    // Byte code:
    //   0: new 39	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 40	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: invokestatic 46	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   11: ldc 48
    //   13: invokestatic 54	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   16: ifne +12 -> 28
    //   19: ldc 56
    //   21: ldc 58
    //   23: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: areturn
    //   28: invokestatic 46	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   31: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: getstatic 76	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   37: aconst_null
    //   38: ldc 78
    //   40: iconst_1
    //   41: anewarray 13	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 84	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnonnull +5 -> 59
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: invokeinterface 90 1 0
    //   65: ifeq +78 -> 143
    //   68: aload_0
    //   69: invokeinterface 93 1 0
    //   74: ifne +69 -> 143
    //   77: aload_1
    //   78: aload_0
    //   79: aload_0
    //   80: ldc 95
    //   82: invokeinterface 99 2 0
    //   87: invokeinterface 103 2 0
    //   92: invokevirtual 107	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: invokeinterface 110 1 0
    //   102: pop
    //   103: goto -35 -> 68
    //   106: astore_2
    //   107: ldc 56
    //   109: ldc 112
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_2
    //   118: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_2
    //   125: invokevirtual 120	java/lang/Object:getClass	()Ljava/lang/Class;
    //   128: invokevirtual 125	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_0
    //   136: invokeinterface 131 1 0
    //   141: aload_1
    //   142: areturn
    //   143: aload_0
    //   144: invokeinterface 131 1 0
    //   149: goto -8 -> 141
    //   152: astore_1
    //   153: aload_0
    //   154: invokeinterface 131 1 0
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   7	135	1	localArrayList	ArrayList
    //   152	8	1	localObject	Object
    //   106	19	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   59	68	106	java/lang/Exception
    //   68	103	106	java/lang/Exception
    //   59	68	152	finally
    //   68	103	152	finally
    //   107	135	152	finally
  }
  
  private static c a(Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    if (!com.tencent.mm.pluginsdk.permission.a.j(ae.getContext(), "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
      return null;
    }
    c localc = new c();
    localc.lsI = new ArrayList();
    Object localObject1 = paramCursor.getString(paramInt1);
    Object localObject3 = paramCursor.getString(paramInt2);
    paramCursor = paramCursor.getString(paramInt3);
    localc.field_contactId = ((String)localObject1);
    localc.field_systemAddressBookUsername = ((String)localObject3);
    if ((!bk.bl(paramCursor)) && (!localc.lsI.contains(paramCursor))) {
      localc.lsI.add(paramCursor);
    }
    if ((bk.bl(localc.field_systemAddressBookUsername)) && (localc.lsI.size() > 0)) {
      localc.field_systemAddressBookUsername = ((String)localc.lsI.get(0));
    }
    localObject3 = localc.lsI.iterator();
    paramCursor = null;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = com.tencent.mm.plugin.ipcall.b.a.FV((String)((Iterator)localObject3).next());
      if (!bk.bl((String)localObject1))
      {
        paramCursor = (Cursor)localObject1;
        if (((String)localObject1).endsWith("@stranger")) {}
      }
    }
    for (;;)
    {
      if (!bk.bl((String)localObject1)) {
        localc.field_wechatUsername = ((String)localObject1);
      }
      if (!bk.bl(localc.field_systemAddressBookUsername)) {}
      for (;;)
      {
        try
        {
          paramCursor = g.oY(localc.field_systemAddressBookUsername);
          if (!bk.bl(paramCursor)) {
            if (!Character.isLetter(paramCursor.charAt(0)))
            {
              localc.field_sortKey = (dse + paramCursor.toUpperCase());
              return localc;
            }
          }
        }
        catch (Exception paramCursor)
        {
          y.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", new Object[] { paramCursor.getMessage(), paramCursor.getClass().getSimpleName() });
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
  
  public static ArrayList<c> bcK()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if (!com.tencent.mm.pluginsdk.permission.a.j(ae.getContext(), "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
      return localArrayList;
    }
    Cursor localCursor = ae.getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id", "display_name", "data1" }, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
    HashMap localHashMap = new HashMap();
    y.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - l1));
    if (localCursor == null) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        y.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", new Object[] { Integer.valueOf(localCursor.getCount()) });
        if (!localCursor.moveToFirst()) {
          break label446;
        }
        int i = localCursor.getColumnIndex("contact_id");
        int j = localCursor.getColumnIndex("display_name");
        int k = localCursor.getColumnIndex("data1");
        if (localCursor.isAfterLast()) {
          break label446;
        }
        c localc1 = a(localCursor, i, j, k);
        if ((localc1 != null) && (localc1.lsI != null) && (localc1.lsI.size() > 0) && (!bk.bl(localc1.field_contactId)))
        {
          if (!localHashMap.containsKey(localc1.field_contactId)) {
            continue;
          }
          c localc2 = (c)localHashMap.get(localc1.field_contactId);
          if ((localc1.lsI.size() > 0) && (!localc2.lsI.contains(localc1.lsI.get(0)))) {
            localc2.lsI.add(localc1.lsI.get(0));
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", new Object[] { localException.getMessage(), localException.getClass().getSimpleName() });
        localCursor.close();
        localArrayList.addAll(localHashMap.values());
        lsH = localHashMap;
        l2 = System.currentTimeMillis();
        y.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
        return localArrayList;
        localHashMap.put(localException.field_contactId, localException);
        continue;
      }
      finally
      {
        localCursor.close();
      }
      localCursor.moveToNext();
    }
    for (;;)
    {
      long l2;
      label446:
      localCursor.close();
    }
  }
  
  public static HashMap<String, c> bcL()
  {
    return lsH;
  }
  
  public static HashMap<String, c> bcM()
  {
    bcK();
    return lsH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.b
 * JD-Core Version:    0.7.0.1
 */