package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class u
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwj = "deviceId".hashCode();
  private static final int cwk = "sessionName".hashCode();
  private static final int cwl = "moveTime".hashCode();
  private boolean cwg = true;
  private boolean cwh = true;
  private boolean cwi = true;
  public String field_deviceId;
  public fj field_moveTime;
  public String field_sessionName;
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (cwj != k) {
        break label60;
      }
      this.field_deviceId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cwk == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (cwl == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_moveTime = ((fj)new fj().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
        }
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_deviceId == null) {
      this.field_deviceId = "";
    }
    if (this.cwg) {
      localContentValues.put("deviceId", this.field_deviceId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.cwh) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if ((this.cwi) && (this.field_moveTime != null)) {}
    try
    {
      localContentValues.put("moveTime", this.field_moveTime.toByteArray());
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.u
 * JD-Core Version:    0.7.0.1
 */