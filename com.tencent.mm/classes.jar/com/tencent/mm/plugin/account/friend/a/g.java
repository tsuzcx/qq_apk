package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int cSx;
  String fMb;
  int fuA;
  public long fuC;
  private String fuD;
  int fuI;
  String fuJ;
  String fuK;
  String kdR;
  String kdS;
  String ker;
  int kes;
  String nickName;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.cSx = -1;
    this.fuC = 0L;
    this.ker = "";
    this.kes = 0;
    this.status = 0;
    this.username = "";
    this.nickName = "";
    this.kdR = "";
    this.kdS = "";
    this.fuA = 0;
    this.fuI = 0;
    this.fuJ = "";
    this.fuK = "";
    this.signature = "";
    this.fMb = "";
    this.type = 0;
    this.fuD = "";
    AppMethodBeat.o(130993);
  }
  
  public final String bnT()
  {
    if (this.ker == null) {
      return "";
    }
    return this.ker;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.fuC = paramCursor.getLong(0);
    this.ker = paramCursor.getString(1);
    this.kes = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.nickName = paramCursor.getString(5);
    this.kdR = paramCursor.getString(6);
    this.kdS = paramCursor.getString(7);
    this.fuA = paramCursor.getInt(8);
    this.fuI = paramCursor.getInt(9);
    this.fuJ = paramCursor.getString(10);
    this.fuK = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.fMb = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.fuD = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.fuC));
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("fbname", bnT());
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.kes));
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.cSx & 0x40) != 0)
    {
      if (this.kdR == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.cSx & 0x80) != 0)
      {
        if (this.kdS != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.cSx & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.fuA));
      }
      if ((this.cSx & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.fuI));
      }
      if ((this.cSx & 0x400) != 0)
      {
        if (this.fuJ != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.cSx & 0x800) != 0)
      {
        if (this.fuK != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.cSx & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.cSx & 0x2000) != 0)
      {
        if (this.fMb != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.cSx & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.cSx & 0x8000) != 0) {
        if (this.fuD != null) {
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
    for (String str = "";; str = this.fuD)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.kdR;
      break;
      str = this.kdS;
      break label187;
      str = this.fuJ;
      break label263;
      str = this.fuK;
      break label291;
      str = this.signature;
      break label319;
      str = this.fMb;
      break label347;
    }
  }
  
  public final String getNickName()
  {
    if (this.nickName == null) {
      return "";
    }
    return this.nickName;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */