package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends MMPluginProvider.a
{
  private static final Map<String, Object> hRT;
  
  static
  {
    HashMap localHashMap = new HashMap();
    hRT = localHashMap;
    localHashMap.put("_build_info_sdk_int_", Integer.valueOf(620824064));
    hRT.put("_build_info_sdk_name_", "android 5.1.6");
    hRT.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
  }
  
  public static Cursor a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    paramArrayOfString2 = paramArrayOfString2[0];
    Object localObject = hRT.get(paramArrayOfString2);
    if (localObject == null)
    {
      y.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: " + paramArrayOfString2);
      return null;
    }
    int i;
    MatrixCursor localMatrixCursor;
    if (localObject == null)
    {
      y.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
      i = 0;
      localMatrixCursor = new MatrixCursor(paramArrayOfString1);
      if (localObject != null) {
        break label217;
      }
    }
    label217:
    for (paramArrayOfString1 = null;; paramArrayOfString1 = localObject.toString())
    {
      localMatrixCursor.addRow(new Object[] { Integer.valueOf(0), paramArrayOfString2, Integer.valueOf(i), paramArrayOfString1 });
      return localMatrixCursor;
      if ((localObject instanceof Integer))
      {
        i = 1;
        break;
      }
      if ((localObject instanceof Long))
      {
        i = 2;
        break;
      }
      if ((localObject instanceof String))
      {
        i = 3;
        break;
      }
      if ((localObject instanceof Boolean))
      {
        i = 4;
        break;
      }
      if ((localObject instanceof Float))
      {
        i = 5;
        break;
      }
      if ((localObject instanceof Double))
      {
        i = 6;
        break;
      }
      y.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject.getClass().toString());
      i = 0;
      break;
    }
  }
  
  public static Uri avX()
  {
    return null;
  }
  
  public static int avY()
  {
    return 0;
  }
  
  public static int avZ()
  {
    return 0;
  }
  
  public final boolean cN(Context paramContext)
  {
    super.cN(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.c
 * JD-Core Version:    0.7.0.1
 */