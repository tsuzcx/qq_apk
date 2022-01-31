package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] mdM;
  private static final UriMatcher meo;
  private static final String[] mgg;
  private Context context;
  private String[] mdZ;
  private int mgh = -1;
  
  static
  {
    AppMethodBeat.i(20492);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    meo.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    meo.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    mdM = new String[] { "retCode" };
    mgg = new String[] { "id", "count" };
    AppMethodBeat.o(20492);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.mdZ = paramArrayOfString;
    this.mgh = paramInt;
    this.context = paramContext;
  }
  
  private Cursor y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20491);
    ab.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      vA(4);
      AppMethodBeat.o(20491);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      vA(3);
      AppMethodBeat.o(20491);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(mgg);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label266;
        }
        if (bo.isNullOrNil(paramArrayOfString[i])) {
          break label279;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          com.tencent.mm.plugin.extqlauncher.b.btS();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(com.tencent.mm.plugin.extqlauncher.b.btT()) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.Gz(paramArrayOfString[i]);
          if (!bo.isNullOrNil((String)localObject))
          {
            aw.aaz();
            localObject = c.YF().arH((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((au)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ab.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        vA(4);
        localMatrixCursor.close();
        AppMethodBeat.o(20491);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label279;
      label266:
      vA(0);
      AppMethodBeat.o(20491);
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
    AppMethodBeat.i(20490);
    ab.d("MicroMsg.ExtControlProviderQLauncher", "query()");
    a(paramUri, this.context, this.mgh, this.mdZ);
    if (paramUri == null)
    {
      vA(3);
      AppMethodBeat.o(20490);
      return null;
    }
    if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
    {
      vA(3);
      AppMethodBeat.o(20490);
      return null;
    }
    if (!aVH())
    {
      vA(1);
      paramUri = this.jLW;
      AppMethodBeat.o(20490);
      return paramUri;
    }
    if (!dO(this.context))
    {
      ab.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      vA(2);
      AppMethodBeat.o(20490);
      return null;
    }
    switch (this.mgh)
    {
    default: 
      vA(3);
      AppMethodBeat.o(20490);
      return null;
    case 18: 
      ab.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        vA(4);
        AppMethodBeat.o(20490);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      d.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(mdM);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      vA(0);
      AppMethodBeat.o(20490);
      return paramUri;
    case 19: 
      ab.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        vA(4);
        AppMethodBeat.o(20490);
        return null;
      }
      paramUri = new Intent();
      d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(mdM);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      vA(0);
      AppMethodBeat.o(20490);
      return paramUri;
    }
    paramUri = y(paramArrayOfString2);
    AppMethodBeat.o(20490);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher
 * JD-Core Version:    0.7.0.1
 */