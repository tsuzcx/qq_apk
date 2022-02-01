package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  String bLs;
  int drx;
  String eNf;
  int exL;
  public long exN;
  private String exO;
  int exU;
  String exV;
  String exW;
  String iJM;
  String iJN;
  String iKm;
  int iKn;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.drx = -1;
    this.exN = 0L;
    this.iKm = "";
    this.iKn = 0;
    this.status = 0;
    this.username = "";
    this.bLs = "";
    this.iJM = "";
    this.iJN = "";
    this.exL = 0;
    this.exU = 0;
    this.exV = "";
    this.exW = "";
    this.signature = "";
    this.eNf = "";
    this.type = 0;
    this.exO = "";
    AppMethodBeat.o(130993);
  }
  
  public final String aPw()
  {
    if (this.iKm == null) {
      return "";
    }
    return this.iKm;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.exN = paramCursor.getLong(0);
    this.iKm = paramCursor.getString(1);
    this.iKn = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.bLs = paramCursor.getString(5);
    this.iJM = paramCursor.getString(6);
    this.iJN = paramCursor.getString(7);
    this.exL = paramCursor.getInt(8);
    this.exU = paramCursor.getInt(9);
    this.exV = paramCursor.getString(10);
    this.exW = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.eNf = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.exO = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.exN));
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("fbname", aPw());
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.iKn));
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.drx & 0x40) != 0)
    {
      if (this.iJM == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.drx & 0x80) != 0)
      {
        if (this.iJN != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.drx & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.exL));
      }
      if ((this.drx & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.exU));
      }
      if ((this.drx & 0x400) != 0)
      {
        if (this.exV != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.drx & 0x800) != 0)
      {
        if (this.exW != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.drx & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.drx & 0x2000) != 0)
      {
        if (this.eNf != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.drx & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.drx & 0x8000) != 0) {
        if (this.exO != null) {
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
    for (String str = "";; str = this.exO)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.iJM;
      break;
      str = this.iJN;
      break label187;
      str = this.exV;
      break label263;
      str = this.exW;
      break label291;
      str = this.signature;
      break label319;
      str = this.eNf;
      break label347;
    }
  }
  
  public final String getNickName()
  {
    if (this.bLs == null) {
      return "";
    }
    return this.bLs;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */