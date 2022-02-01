package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int cUP;
  String city;
  public long hDe;
  private String hDf;
  int hDk;
  String idS;
  String mVR;
  int mVS;
  String mVr;
  String mVs;
  String nickName;
  String province;
  int sex;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.cUP = -1;
    this.hDe = 0L;
    this.mVR = "";
    this.mVS = 0;
    this.status = 0;
    this.username = "";
    this.nickName = "";
    this.mVr = "";
    this.mVs = "";
    this.sex = 0;
    this.hDk = 0;
    this.province = "";
    this.city = "";
    this.signature = "";
    this.idS = "";
    this.type = 0;
    this.hDf = "";
    AppMethodBeat.o(130993);
  }
  
  public final String byc()
  {
    if (this.mVR == null) {
      return "";
    }
    return this.mVR;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.hDe = paramCursor.getLong(0);
    this.mVR = paramCursor.getString(1);
    this.mVS = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.nickName = paramCursor.getString(5);
    this.mVr = paramCursor.getString(6);
    this.mVs = paramCursor.getString(7);
    this.sex = paramCursor.getInt(8);
    this.hDk = paramCursor.getInt(9);
    this.province = paramCursor.getString(10);
    this.city = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.idS = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.hDf = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.hDe));
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("fbname", byc());
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.mVS));
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.cUP & 0x40) != 0)
    {
      if (this.mVr == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.cUP & 0x80) != 0)
      {
        if (this.mVs != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.cUP & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.sex));
      }
      if ((this.cUP & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.hDk));
      }
      if ((this.cUP & 0x400) != 0)
      {
        if (this.province != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.cUP & 0x800) != 0)
      {
        if (this.city != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.cUP & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.cUP & 0x2000) != 0)
      {
        if (this.idS != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.cUP & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.cUP & 0x8000) != 0) {
        if (this.hDf != null) {
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
    for (String str = "";; str = this.hDf)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.mVr;
      break;
      str = this.mVs;
      break label187;
      str = this.province;
      break label263;
      str = this.city;
      break label291;
      str = this.signature;
      break label319;
      str = this.idS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */