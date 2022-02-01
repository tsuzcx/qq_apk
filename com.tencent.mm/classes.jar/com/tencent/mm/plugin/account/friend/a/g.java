package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  String bNK;
  int dtM;
  String eKn;
  String evA;
  int evp;
  public long evr;
  private String evs;
  int evy;
  String evz;
  String ijF;
  String ijG;
  String ikf;
  int ikg;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.dtM = -1;
    this.evr = 0L;
    this.ikf = "";
    this.ikg = 0;
    this.status = 0;
    this.username = "";
    this.bNK = "";
    this.ijF = "";
    this.ijG = "";
    this.evp = 0;
    this.evy = 0;
    this.evz = "";
    this.evA = "";
    this.signature = "";
    this.eKn = "";
    this.type = 0;
    this.evs = "";
    AppMethodBeat.o(130993);
  }
  
  public final String aIF()
  {
    if (this.ikf == null) {
      return "";
    }
    return this.ikf;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.evr = paramCursor.getLong(0);
    this.ikf = paramCursor.getString(1);
    this.ikg = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.bNK = paramCursor.getString(5);
    this.ijF = paramCursor.getString(6);
    this.ijG = paramCursor.getString(7);
    this.evp = paramCursor.getInt(8);
    this.evy = paramCursor.getInt(9);
    this.evz = paramCursor.getString(10);
    this.evA = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.eKn = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.evs = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.evr));
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("fbname", aIF());
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.ikg));
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dtM & 0x40) != 0)
    {
      if (this.ijF == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.dtM & 0x80) != 0)
      {
        if (this.ijG != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.dtM & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.evp));
      }
      if ((this.dtM & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.evy));
      }
      if ((this.dtM & 0x400) != 0)
      {
        if (this.evz != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.dtM & 0x800) != 0)
      {
        if (this.evA != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.dtM & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.dtM & 0x2000) != 0)
      {
        if (this.eKn != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.dtM & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.dtM & 0x8000) != 0) {
        if (this.evs != null) {
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
    for (String str = "";; str = this.evs)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.ijF;
      break;
      str = this.ijG;
      break label187;
      str = this.evz;
      break label263;
      str = this.evA;
      break label291;
      str = this.signature;
      break label319;
      str = this.eKn;
      break label347;
    }
  }
  
  public final String getNickName()
  {
    if (this.bNK == null) {
      return "";
    }
    return this.bNK;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */