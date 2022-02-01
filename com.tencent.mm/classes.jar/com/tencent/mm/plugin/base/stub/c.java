package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends MMPluginProvider.a
{
  private static final Map<String, Object> pdq;
  
  static
  {
    AppMethodBeat.i(22176);
    HashMap localHashMap = new HashMap();
    pdq = localHashMap;
    localHashMap.put("_build_info_sdk_int_", Integer.valueOf(d.KyO));
    pdq.put("_build_info_sdk_name_", "android 6.6.6");
    pdq.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
    AppMethodBeat.o(22176);
  }
  
  public static Cursor b(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(22175);
    paramArrayOfString2 = paramArrayOfString2[0];
    Object localObject2 = pdq.get(paramArrayOfString2);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: ".concat(String.valueOf(paramArrayOfString2)));
      AppMethodBeat.o(22175);
      return null;
    }
    int i = MMPluginProviderConstants.Resolver.getType(localObject2);
    MatrixCursor localMatrixCursor = new MatrixCursor(paramArrayOfString1);
    if (localObject2 == null) {}
    for (paramArrayOfString1 = localObject1;; paramArrayOfString1 = localObject2.toString())
    {
      localMatrixCursor.addRow(new Object[] { Integer.valueOf(0), paramArrayOfString2, Integer.valueOf(i), paramArrayOfString1 });
      AppMethodBeat.o(22175);
      return localMatrixCursor;
    }
  }
  
  public final boolean eI(Context paramContext)
  {
    AppMethodBeat.i(22174);
    super.eI(paramContext);
    AppMethodBeat.o(22174);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.c
 * JD-Core Version:    0.7.0.1
 */