package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.SubCoreExtQLauncher;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.by;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] zOz;
  private static final UriMatcher zPg;
  private static final String[] zQU;
  private Context context;
  private String[] zOO;
  private int zQV = -1;
  
  static
  {
    AppMethodBeat.i(24565);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPg = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    zPg.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    zPg.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    zOz = new String[] { "retCode" };
    zQU = new String[] { "id", "count" };
    AppMethodBeat.o(24565);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.zOO = paramArrayOfString;
    this.zQV = paramInt;
    this.context = paramContext;
  }
  
  private Cursor H(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24564);
    Log.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      Mm(4);
      AppMethodBeat.o(24564);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      Mm(3);
      AppMethodBeat.o(24564);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(zQU);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label266;
        }
        if (Util.isNullOrNil(paramArrayOfString[i])) {
          break label279;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          SubCoreExtQLauncher.dOu();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(SubCoreExtQLauncher.dOv()) });
        }
        else
        {
          localObject = b.aia(paramArrayOfString[i]);
          if (!Util.isNullOrNil((String)localObject))
          {
            bh.bCz();
            localObject = com.tencent.mm.model.c.bzG().bxM((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((bd)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        Mm(4);
        localMatrixCursor.close();
        AppMethodBeat.o(24564);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label279;
      label266:
      Mm(0);
      AppMethodBeat.o(24564);
      return localMatrixCursor;
      label279:
      i += 1;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24563);
    Log.d("MicroMsg.ExtControlProviderQLauncher", "query()");
    a(paramUri, this.context, this.zQV, this.zOO);
    if (paramUri == null)
    {
      Mm(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
    {
      Mm(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if (!dak())
    {
      Mm(1);
      paramUri = this.vsh;
      AppMethodBeat.o(24563);
      return paramUri;
    }
    if (!gh(this.context))
    {
      Log.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      Mm(2);
      AppMethodBeat.o(24563);
      return null;
    }
    switch (this.zQV)
    {
    default: 
      Mm(3);
      AppMethodBeat.o(24563);
      return null;
    case 18: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        Mm(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      com.tencent.mm.br.c.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(zOz);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      Mm(0);
      AppMethodBeat.o(24563);
      return paramUri;
    case 19: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        Mm(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      com.tencent.mm.br.c.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(zOz);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      Mm(0);
      AppMethodBeat.o(24563);
      return paramUri;
    }
    paramUri = H(paramArrayOfString2);
    AppMethodBeat.o(24563);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher
 * JD-Core Version:    0.7.0.1
 */