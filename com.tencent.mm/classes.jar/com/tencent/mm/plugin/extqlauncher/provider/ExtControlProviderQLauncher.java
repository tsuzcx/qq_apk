package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] wst;
  private static final UriMatcher wta;
  private static final String[] wuT;
  private Context context;
  private String[] wsI;
  private int wuU = -1;
  
  static
  {
    AppMethodBeat.i(24565);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    wta = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    wta.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    wta.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    wst = new String[] { "retCode" };
    wuT = new String[] { "id", "count" };
    AppMethodBeat.o(24565);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.wsI = paramArrayOfString;
    this.wuU = paramInt;
    this.context = paramContext;
  }
  
  private Cursor G(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24564);
    Log.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      Lp(4);
      AppMethodBeat.o(24564);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      Lp(3);
      AppMethodBeat.o(24564);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(wuT);
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
          com.tencent.mm.plugin.extqlauncher.b.dhK();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(0) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.aoE(paramArrayOfString[i]);
          if (!Util.isNullOrNil((String)localObject))
          {
            bh.beI();
            localObject = com.tencent.mm.model.c.bbR().bwx((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((bb)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        Lp(4);
        localMatrixCursor.close();
        AppMethodBeat.o(24564);
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label277;
      label264:
      Lp(0);
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
    a(paramUri, this.context, this.wuU, this.wsI);
    if (paramUri == null)
    {
      Lp(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if ((Util.isNullOrNil(this.wsU)) || (Util.isNullOrNil(dht())))
    {
      Lp(3);
      AppMethodBeat.o(24563);
      return null;
    }
    if (!cxw())
    {
      Lp(1);
      paramUri = this.sgp;
      AppMethodBeat.o(24563);
      return paramUri;
    }
    if (!fj(this.context))
    {
      Log.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      Lp(2);
      AppMethodBeat.o(24563);
      return null;
    }
    switch (this.wuU)
    {
    default: 
      Lp(3);
      AppMethodBeat.o(24563);
      return null;
    case 18: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        Lp(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      com.tencent.mm.by.c.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(wst);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      Lp(0);
      AppMethodBeat.o(24563);
      return paramUri;
    case 19: 
      Log.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        Lp(4);
        AppMethodBeat.o(24563);
        return null;
      }
      paramUri = new Intent();
      com.tencent.mm.by.c.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(wst);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      Lp(0);
      AppMethodBeat.o(24563);
      return paramUri;
    }
    paramUri = G(paramArrayOfString2);
    AppMethodBeat.o(24563);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher
 * JD-Core Version:    0.7.0.1
 */