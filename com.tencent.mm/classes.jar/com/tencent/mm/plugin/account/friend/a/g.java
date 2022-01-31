package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  String blZ;
  int bsY;
  String city;
  String dCJ;
  int dqC;
  public long dqE;
  private String dqF;
  int dqL;
  String gwI;
  String gwJ;
  String gxi;
  int gxj;
  String province;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(108331);
    this.bsY = -1;
    this.dqE = 0L;
    this.gxi = "";
    this.gxj = 0;
    this.status = 0;
    this.username = "";
    this.blZ = "";
    this.gwI = "";
    this.gwJ = "";
    this.dqC = 0;
    this.dqL = 0;
    this.province = "";
    this.city = "";
    this.signature = "";
    this.dCJ = "";
    this.type = 0;
    this.dqF = "";
    AppMethodBeat.o(108331);
  }
  
  public final String aqc()
  {
    if (this.blZ == null) {
      return "";
    }
    return this.blZ;
  }
  
  public final String aqk()
  {
    if (this.gxi == null) {
      return "";
    }
    return this.gxi;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(108332);
    this.dqE = paramCursor.getLong(0);
    this.gxi = paramCursor.getString(1);
    this.gxj = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.blZ = paramCursor.getString(5);
    this.gwI = paramCursor.getString(6);
    this.gwJ = paramCursor.getString(7);
    this.dqC = paramCursor.getInt(8);
    this.dqL = paramCursor.getInt(9);
    this.province = paramCursor.getString(10);
    this.city = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.dCJ = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.dqF = paramCursor.getString(15);
    AppMethodBeat.o(108332);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(108333);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.dqE));
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("fbname", aqk());
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.gxj));
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("nickname", aqc());
    }
    if ((this.bsY & 0x40) != 0)
    {
      if (this.gwI == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.bsY & 0x80) != 0)
      {
        if (this.gwJ != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.bsY & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.dqC));
      }
      if ((this.bsY & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.dqL));
      }
      if ((this.bsY & 0x400) != 0)
      {
        if (this.province != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.bsY & 0x800) != 0)
      {
        if (this.city != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.bsY & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.bsY & 0x2000) != 0)
      {
        if (this.dCJ != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.bsY & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.bsY & 0x8000) != 0) {
        if (this.dqF != null) {
          break label460;
        }
      }
    }
    label420:
    label428:
    label436:
    label444:
    label452:
    label460:
    for (String str = "";; str = this.dqF)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(108333);
      return localContentValues;
      str = this.gwI;
      break;
      str = this.gwJ;
      break label187;
      str = this.province;
      break label263;
      str = this.city;
      break label291;
      str = this.signature;
      break label319;
      str = this.dCJ;
      break label347;
    }
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */