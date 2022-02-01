package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] sMy;
  private static final UriMatcher sNf;
  private static final String[] sOY;
  private Context context;
  private String[] sMN;
  private int sOZ = -1;
  
  static
  {
    AppMethodBeat.i(24565);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sNf = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    sNf.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    sNf.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    sMy = new String[] { "retCode" };
    sOY = new String[] { "id", "count" };
    AppMethodBeat.o(24565);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.sMN = paramArrayOfString;
    this.sOZ = paramInt;
    this.context = paramContext;
  }
  
  private Cursor H(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24564);
    Log.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      HF(4);
      AppMethodBeat.o(24564);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      HF(3);
      AppMethodBeat.o(24564);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(sOY);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label264;
        }
        if (Util.isNullOrNil(paramArrayOfString[i])) {
          break label277;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          com.tencent.mm.plugin.extqlauncher.b.cSI();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(0) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.agY(paramArrayOfString[i]);
          if (!Util.isNullOrNil((String)localObject))
          {
            bg.aVF();
            localObject = com.tencent.mm.model.c.aST().bjY((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((bb)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        HF(4);
        localMatrixCursor.close();
        AppMethodBeat.o(24564);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label277;
      label264:
      HF(0);
      AppMethodBeat.o(24564);
      return localMatrixCursor;
      label277:
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
    a(paramUri, this.context, this.sOZ, this.sMN);
    if (paramUri == null)
    {
      HF(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
    {
      HF(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if (!ckf())
    {
      HF(1);
      paramUri = this.pem;
      AppMethodBeat.o(24563);
      return paramUri;
    }
    if (!fe(this.context))
    {
      Log.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      HF(2);
      AppMethodBeat.o(24563);
      return null;
    }
    switch (this.sOZ)
    {
    default: 
      HF(3);
      AppMethodBeat.o(24563);
      return null;
    case 18: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        HF(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      com.tencent.mm.br.c.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(sMy);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      HF(0);
      AppMethodBeat.o(24563);
      return paramUri;
    case 19: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        HF(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      com.tencent.mm.br.c.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(sMy);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      HF(0);
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