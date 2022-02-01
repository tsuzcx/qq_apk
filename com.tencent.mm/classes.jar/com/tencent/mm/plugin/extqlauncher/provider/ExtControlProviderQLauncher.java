package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] rcM;
  private static final UriMatcher rdu;
  private static final String[] rfq;
  private Context context;
  private String[] rdc;
  private int rfr = -1;
  
  static
  {
    AppMethodBeat.i(24565);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rdu = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    rdu.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    rdu.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    rcM = new String[] { "retCode" };
    rfq = new String[] { "id", "count" };
    AppMethodBeat.o(24565);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rdc = paramArrayOfString;
    this.rfr = paramInt;
    this.context = paramContext;
  }
  
  private Cursor F(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24564);
    ad.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      DF(4);
      AppMethodBeat.o(24564);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      DF(3);
      AppMethodBeat.o(24564);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(rfq);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label264;
        }
        if (bt.isNullOrNil(paramArrayOfString[i])) {
          break label277;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          com.tencent.mm.plugin.extqlauncher.b.csy();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(0) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.Ws(paramArrayOfString[i]);
          if (!bt.isNullOrNil((String)localObject))
          {
            com.tencent.mm.model.ba.aBQ();
            localObject = c.azv().aTz((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((com.tencent.mm.g.c.ba)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ad.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        DF(4);
        localMatrixCursor.close();
        AppMethodBeat.o(24564);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label277;
      label264:
      DF(0);
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
    ad.d("MicroMsg.ExtControlProviderQLauncher", "query()");
    a(paramUri, this.context, this.rfr, this.rdc);
    if (paramUri == null)
    {
      DF(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if ((bt.isNullOrNil(this.rdo)) || (bt.isNullOrNil(csj())))
    {
      DF(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if (!bMn())
    {
      DF(1);
      paramUri = this.nNT;
      AppMethodBeat.o(24563);
      return paramUri;
    }
    if (!eG(this.context))
    {
      ad.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      DF(2);
      AppMethodBeat.o(24563);
      return null;
    }
    switch (this.rfr)
    {
    default: 
      DF(3);
      AppMethodBeat.o(24563);
      return null;
    case 18: 
      ad.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        DF(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      d.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(rcM);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      DF(0);
      AppMethodBeat.o(24563);
      return paramUri;
    case 19: 
      ad.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        DF(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(rcM);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      DF(0);
      AppMethodBeat.o(24563);
      return paramUri;
    }
    paramUri = F(paramArrayOfString2);
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