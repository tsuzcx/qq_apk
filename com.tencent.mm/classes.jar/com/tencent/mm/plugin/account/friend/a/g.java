package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  String bVF;
  int dEu;
  int eQV;
  public long eQX;
  private String eQY;
  int eRe;
  String eRf;
  String eRg;
  String fhy;
  String jfO;
  String jfP;
  String jgo;
  int jgp;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.dEu = -1;
    this.eQX = 0L;
    this.jgo = "";
    this.jgp = 0;
    this.status = 0;
    this.username = "";
    this.bVF = "";
    this.jfO = "";
    this.jfP = "";
    this.eQV = 0;
    this.eRe = 0;
    this.eRf = "";
    this.eRg = "";
    this.signature = "";
    this.fhy = "";
    this.type = 0;
    this.eQY = "";
    AppMethodBeat.o(130993);
  }
  
  public final String aTh()
  {
    if (this.jgo == null) {
      return "";
    }
    return this.jgo;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.eQX = paramCursor.getLong(0);
    this.jgo = paramCursor.getString(1);
    this.jgp = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.bVF = paramCursor.getString(5);
    this.jfO = paramCursor.getString(6);
    this.jfP = paramCursor.getString(7);
    this.eQV = paramCursor.getInt(8);
    this.eRe = paramCursor.getInt(9);
    this.eRf = paramCursor.getString(10);
    this.eRg = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.fhy = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.eQY = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.eQX));
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("fbname", aTh());
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.jgp));
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dEu & 0x40) != 0)
    {
      if (this.jfO == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.dEu & 0x80) != 0)
      {
        if (this.jfP != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.dEu & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.eQV));
      }
      if ((this.dEu & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.eRe));
      }
      if ((this.dEu & 0x400) != 0)
      {
        if (this.eRf != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.dEu & 0x800) != 0)
      {
        if (this.eRg != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.dEu & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.dEu & 0x2000) != 0)
      {
        if (this.fhy != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.dEu & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.dEu & 0x8000) != 0) {
        if (this.eQY != null) {
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
    for (String str = "";; str = this.eQY)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.jfO;
      break;
      str = this.jfP;
      break label187;
      str = this.eRf;
      break label263;
      str = this.eRg;
      break label291;
      str = this.signature;
      break label319;
      str = this.fhy;
      break label347;
    }
  }
  
  public final String getNickName()
  {
    if (this.bVF == null) {
      return "";
    }
    return this.bVF;
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