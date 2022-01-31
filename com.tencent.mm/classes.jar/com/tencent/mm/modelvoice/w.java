package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class w
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )" };
  public h fnw;
  Map<String, a> gaT;
  Map<String, n> gaU;
  Map<String, j> gaV;
  
  public w(h paramh)
  {
    AppMethodBeat.i(116663);
    this.gaT = new HashMap();
    this.gaU = new HashMap();
    this.gaV = new HashMap();
    b(paramh);
    this.fnw = paramh;
    AppMethodBeat.o(116663);
  }
  
  private static void b(h paramh)
  {
    AppMethodBeat.i(116664);
    Cursor localCursor = paramh.a("PRAGMA table_info(voiceinfo)", null, 0);
    if (localCursor == null)
    {
      ab.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
      AppMethodBeat.o(116664);
      return;
    }
    int i1 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    String str;
    while (localCursor.moveToNext()) {
      if (i1 >= 0)
      {
        str = localCursor.getString(i1);
        if ("MsgSource".equals(str)) {
          k = 1;
        }
        if ("MsgFlag".equals(str)) {
          m = 1;
        }
        if ("MsgSeq".equals(str)) {
          n = 1;
        }
        if (!"MasterBufId".equals(str)) {
          break label227;
        }
        i = 1;
      }
    }
    label227:
    for (;;)
    {
      if ("checksum".equals(str)) {
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
      if (n == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
      }
      if (i == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
      }
      if (j == 0) {
        paramh.execSQL("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
      }
      AppMethodBeat.o(116664);
      return;
    }
  }
  
  public static String vV(String paramString)
  {
    AppMethodBeat.i(116665);
    paramString = p.t(paramString, bo.aoy());
    AppMethodBeat.o(116665);
    return paramString;
  }
  
  public final boolean a(String paramString, r paramr)
  {
    AppMethodBeat.i(116668);
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
      ab.e("MicroMsg.VoiceStorage", "update failed, no values set");
    }
    label59:
    label64:
    while (this.fnw.update("voiceinfo", paramr, "FileName= ?", new String[] { paramString }) <= 0)
    {
      AppMethodBeat.o(116668);
      return false;
      bool = false;
      break;
      bool = false;
      break label24;
    }
    doNotify();
    AppMethodBeat.o(116668);
    return true;
  }
  
  public final boolean b(r paramr)
  {
    AppMethodBeat.i(116666);
    boolean bool;
    if (paramr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramr = paramr.convertTo();
      if (paramr.size() > 0) {
        break label46;
      }
      ab.e("MicroMsg.VoiceStorage", "insert falied, no values set");
    }
    label46:
    while (this.fnw.a("voiceinfo", "FileName", paramr) == -1L)
    {
      AppMethodBeat.o(116666);
      return false;
      bool = false;
      break;
    }
    doNotify();
    AppMethodBeat.o(116666);
    return true;
  }
  
  public final r hj(long paramLong)
  {
    r localr = null;
    AppMethodBeat.i(116669);
    Object localObject = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgId=" + paramLong;
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localr = new r();
      localr.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116669);
    return localr;
  }
  
  public final r ms(int paramInt)
  {
    r localr = null;
    AppMethodBeat.i(116670);
    Object localObject = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE MsgLocalId=" + paramInt;
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localr = new r();
      localr.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(116670);
    return localr;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(116667);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.fnw.delete("voiceinfo", "FileName= ?", new String[] { paramString }) <= 0) {
        ab.w("MicroMsg.VoiceStorage", "delete failed, no such file:".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(116667);
      return true;
    }
  }
  
  public final r vW(String paramString)
  {
    AppMethodBeat.i(116671);
    Object localObject1 = null;
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
    localObject2 = this.fnw.a((String)localObject2, new String[] { paramString }, 2);
    paramString = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new r();
      paramString.convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(116671);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.w
 * JD-Core Version:    0.7.0.1
 */