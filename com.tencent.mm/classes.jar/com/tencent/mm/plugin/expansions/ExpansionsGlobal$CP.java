package com.tencent.mm.plugin.expansions;

import a.f;
import a.h;
import android.arch.a.c.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.Callable;

public class ExpansionsGlobal$CP
  extends ContentProvider
{
  public Bundle call(final String paramString1, String paramString2, final Bundle paramBundle)
  {
    AppMethodBeat.i(152971);
    if ("expansionsWait".equals(paramString1))
    {
      ad.i("MicroMsg.exp.ExpansionsGlobal", "cp receive remote expansions call, request");
      paramString1 = new a() {};
      h.a(new Callable() {}).a(new f() {}, h.aze);
    }
    AppMethodBeat.o(152971);
    return null;
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
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal.CP
 * JD-Core Version:    0.7.0.1
 */