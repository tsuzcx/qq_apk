package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends MMPluginProvider.a
{
  private static final Map<String, Object> nMW;
  
  static
  {
    AppMethodBeat.i(22176);
    HashMap localHashMap = new HashMap();
    nMW = localHashMap;
    localHashMap.put("_build_info_sdk_int_", Integer.valueOf(d.Fnj));
    nMW.put("_build_info_sdk_name_", "android 6.6.6");
    nMW.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
    AppMethodBeat.o(22176);
  }
  
  public static Cursor b(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(22175);
    paramArrayOfString2 = paramArrayOfString2[0];
    Object localObject = nMW.get(paramArrayOfString2);
    if (localObject == null)
    {
      ad.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: ".concat(String.valueOf(paramArrayOfString2)));
      AppMethodBeat.o(22175);
      return null;
    }
    int i;
    MatrixCursor localMatrixCursor;
    if (localObject == null)
    {
      ad.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
      i = 0;
      localMatrixCursor = new MatrixCursor(paramArrayOfString1);
      if (localObject != null) {
        break label228;
      }
    }
    label228:
    for (paramArrayOfString1 = null;; paramArrayOfString1 = localObject.toString())
    {
      localMatrixCursor.addRow(new Object[] { Integer.valueOf(0), paramArrayOfString2, Integer.valueOf(i), paramArrayOfString1 });
      AppMethodBeat.o(22175);
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
      ad.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject.getClass().toString());
      i = 0;
      break;
    }
  }
  
  public final boolean em(Context paramContext)
  {
    AppMethodBeat.i(22174);
    super.em(paramContext);
    AppMethodBeat.o(22174);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.c
 * JD-Core Version:    0.7.0.1
 */