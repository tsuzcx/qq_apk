package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] qsY;
  private static final UriMatcher qtG;
  private static final String[] qvA;
  private Context context;
  private String[] qto;
  private int qvB = -1;
  
  static
  {
    AppMethodBeat.i(24565);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qtG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    qtG.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    qtG.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    qsY = new String[] { "retCode" };
    qvA = new String[] { "id", "count" };
    AppMethodBeat.o(24565);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.qto = paramArrayOfString;
    this.qvB = paramInt;
    this.context = paramContext;
  }
  
  private Cursor E(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24564);
    ac.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      CN(4);
      AppMethodBeat.o(24564);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      CN(3);
      AppMethodBeat.o(24564);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(qvA);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label266;
        }
        if (bs.isNullOrNil(paramArrayOfString[i])) {
          break label279;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          com.tencent.mm.plugin.extqlauncher.b.cmT();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(com.tencent.mm.plugin.extqlauncher.b.cmU()) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.SV(paramArrayOfString[i]);
          if (!bs.isNullOrNil((String)localObject))
          {
            com.tencent.mm.model.az.ayM();
            localObject = c.awG().aNI((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((com.tencent.mm.g.c.az)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ac.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        CN(4);
        localMatrixCursor.close();
        AppMethodBeat.o(24564);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label279;
      label266:
      CN(0);
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
    ac.d("MicroMsg.ExtControlProviderQLauncher", "query()");
    a(paramUri, this.context, this.qvB, this.qto);
    if (paramUri == null)
    {
      CN(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
    {
      CN(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if (!bIc())
    {
      CN(1);
      paramUri = this.nng;
      AppMethodBeat.o(24563);
      return paramUri;
    }
    if (!eG(this.context))
    {
      ac.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      CN(2);
      AppMethodBeat.o(24563);
      return null;
    }
    switch (this.qvB)
    {
    default: 
      CN(3);
      AppMethodBeat.o(24563);
      return null;
    case 18: 
      ac.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        CN(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      d.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(qsY);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      CN(0);
      AppMethodBeat.o(24563);
      return paramUri;
    case 19: 
      ac.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        CN(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(qsY);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      CN(0);
      AppMethodBeat.o(24563);
      return paramUri;
    }
    paramUri = E(paramArrayOfString2);
    AppMethodBeat.o(24563);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher
 * JD-Core Version:    0.7.0.1
 */