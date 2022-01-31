package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;

public class ExtControlProviderQLauncher
  extends ExtContentProviderBase
{
  private static final String[] jJI = { "retCode" };
  private static final UriMatcher jKj;
  private static final String[] jMc = { "id", "count" };
  private Context context;
  private String[] jJU;
  private int jMd = -1;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKj = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
    jKj.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
    jKj.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
  }
  
  public ExtControlProviderQLauncher() {}
  
  public ExtControlProviderQLauncher(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.jJU = paramArrayOfString;
    this.jMd = paramInt;
    this.context = paramContext;
  }
  
  private Cursor u(String[] paramArrayOfString)
  {
    y.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
    if (this.context == null)
    {
      qF(4);
      return null;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
      qF(3);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(jMc);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 10)) {
          break label242;
        }
        if (bk.bl(paramArrayOfString[i])) {
          break label249;
        }
        Object localObject;
        if (paramArrayOfString[i].equals("0"))
        {
          localObject = paramArrayOfString[i];
          com.tencent.mm.plugin.extqlauncher.b.aNP();
          localMatrixCursor.addRow(new Object[] { localObject, Integer.valueOf(com.tencent.mm.plugin.extqlauncher.b.aNQ()) });
        }
        else
        {
          localObject = com.tencent.mm.plugin.base.model.b.xG(paramArrayOfString[i]);
          if (!bk.bl((String)localObject))
          {
            au.Hx();
            localObject = c.FB().abv((String)localObject);
            if (localObject != null) {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(((as)localObject).field_unReadCount) });
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        y.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[] { paramArrayOfString.getMessage() });
        qF(4);
        localMatrixCursor.close();
        return null;
      }
      localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], Integer.valueOf(0) });
      break label249;
      label242:
      qF(0);
      return localMatrixCursor;
      label249:
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
    y.d("MicroMsg.ExtControlProviderQLauncher", "query()");
    a(paramUri, this.context, this.jMd, this.jJU);
    if (paramUri == null)
    {
      qF(3);
      return null;
    }
    if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
    {
      qF(3);
      return null;
    }
    if (!awd())
    {
      qF(1);
      return this.hSn;
    }
    if (!dc(this.context))
    {
      y.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
      qF(2);
      return null;
    }
    switch (this.jMd)
    {
    default: 
      qF(3);
      return null;
    case 18: 
      y.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
      if (this.context == null)
      {
        qF(4);
        return null;
      }
      paramUri = new Intent();
      paramUri.putExtra("BaseScanUI_select_scan_mode", 1);
      paramUri.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      d.b(this.context, "scanner", ".ui.BaseScanUI", paramUri);
      paramUri = new MatrixCursor(jJI);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      qF(0);
      return paramUri;
    case 19: 
      y.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
      if (this.context == null)
      {
        qF(4);
        return null;
      }
      paramUri = new Intent();
      d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", paramUri);
      paramUri = new MatrixCursor(jJI);
      paramUri.addRow(new Object[] { Integer.valueOf(1) });
      qF(0);
      return paramUri;
    }
    return u(paramArrayOfString2);
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