package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class w
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0, VoiceFlag INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )", "CREATE INDEX IF NOT EXISTS voice_unfinish_info_index ON voiceinfo ( Status,User,CreateTime )" };
  public h lvy;
  Map<String, a> mln;
  Map<String, n> mlo;
  Map<String, j> mlp;
  
  public w(h paramh)
  {
    AppMethodBeat.i(148504);
    this.mln = new HashMap();
    this.mlo = new HashMap();
    this.mlp = new HashMap();
    a(paramh);
    this.lvy = paramh;
    AppMethodBeat.o(148504);
  }
  
  public static String YN(String paramString)
  {
    AppMethodBeat.i(148506);
    paramString = x.u(paramString, Util.nowMilliSecond());
    AppMethodBeat.o(148506);
    return paramString;
  }
  
  private static void a(h paramh)
  {
    AppMethodBeat.i(148505);
    Cursor localCursor = paramh.rawQuery("PRAGMA table_info(voiceinfo)", null);
    if (localCursor == null)
    {
      Log.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
      AppMethodBeat.o(148505);
      return;
    }
    int i2 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    String str;
    while (localCursor.moveToNext()) {
      if (i2 >= 0)
      {
        str = localCursor.getString(i2);
        if ("MsgSource".equals(str)) {
          k = 1;
        }
        if ("MsgFlag".equals(str)) {
          m = 1;
        }
        if ("MsgSeq".equals(str)) {
          i1 = 1;
        }
        if ("MasterBufId".equals(str)) {
          n = 1;
        }
        if (!"checksum".equals(str)) {
          break label256;
        }
        i = 1;
      }
    }
    label256:
    for (;;)
    {
      if ("VoiceFlag".equals(str)) {
        j = 1;
      }
      break;
      localCursor.close();
      if (k == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
      }
      if (m == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
      }
      if (i1 == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
      }
      if (n == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
      }
      if (i == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
      }
      if (j == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add VoiceFlag INT DEFAULT 0");
      }
      AppMethodBeat.o(148505);
      return;
    }
  }
  
  public final r GX(long paramLong)
  {
    r localr = null;
    AppMethodBeat.i(148510);
    Object localObject = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE MsgId=" + paramLong;
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localr = new r();
      localr.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(148510);
    return localr;
  }
  
  public final r YO(String paramString)
  {
    AppMethodBeat.i(148512);
    Object localObject1 = null;
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE FileName= ?";
    localObject2 = this.lvy.rawQuery((String)localObject2, new String[] { paramString }, 2);
    paramString = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new r();
      paramString.convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(148512);
    return paramString;
  }
  
  public final boolean a(String paramString, r paramr)
  {
    AppMethodBeat.i(148509);
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramr == null) {
        break label59;
      }
      bool = true;
      label24:
      Assert.assertTrue(bool);
      paramr = paramr.convertTo();
      if (paramr.size() > 0) {
        break label64;
      }
      Log.e("MicroMsg.VoiceStorage", "update failed, no values set");
    }
    label59:
    label64:
    while (this.lvy.update("voiceinfo", paramr, "FileName= ?", new String[] { paramString }) <= 0)
    {
      AppMethodBeat.o(148509);
      return false;
      bool = false;
      break;
      bool = false;
      break label24;
    }
    doNotify();
    AppMethodBeat.o(148509);
    return true;
  }
  
  public final boolean b(r paramr)
  {
    AppMethodBeat.i(148507);
    boolean bool;
    if (paramr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramr = paramr.convertTo();
      if (paramr.size() > 0) {
        break label46;
      }
      Log.e("MicroMsg.VoiceStorage", "insert falied, no values set");
    }
    label46:
    while (this.lvy.insert("voiceinfo", "FileName", paramr) == -1L)
    {
      AppMethodBeat.o(148507);
      return false;
      bool = false;
      break;
    }
    doNotify();
    AppMethodBeat.o(148507);
    return true;
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(148508);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.lvy.delete("voiceinfo", "FileName= ?", new String[] { paramString }) <= 0) {
        Log.w("MicroMsg.VoiceStorage", "delete failed, no such file:".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(148508);
      return true;
    }
  }
  
  public final r xk(int paramInt)
  {
    r localr = null;
    AppMethodBeat.i(148511);
    Object localObject = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE MsgLocalId=" + paramInt;
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localr = new r();
      localr.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(148511);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.w
 * JD-Core Version:    0.7.0.1
 */