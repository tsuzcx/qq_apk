package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  String city;
  int eQp;
  String kDc;
  public long kaa;
  private String kab;
  int kag;
  String nickName;
  String pRY;
  String pRZ;
  String pSy;
  int pSz;
  String province;
  int sex;
  String signature;
  public int status;
  private int type;
  String username;
  
  public d()
  {
    AppMethodBeat.i(130993);
    this.eQp = -1;
    this.kaa = 0L;
    this.pSy = "";
    this.pSz = 0;
    this.status = 0;
    this.username = "";
    this.nickName = "";
    this.pRY = "";
    this.pRZ = "";
    this.sex = 0;
    this.kag = 0;
    this.province = "";
    this.city = "";
    this.signature = "";
    this.kDc = "";
    this.type = 0;
    this.kab = "";
    AppMethodBeat.o(130993);
  }
  
  public final String bWR()
  {
    if (this.pSy == null) {
      return "";
    }
    return this.pSy;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.kaa = paramCursor.getLong(0);
    this.pSy = paramCursor.getString(1);
    this.pSz = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.nickName = paramCursor.getString(5);
    this.pRY = paramCursor.getString(6);
    this.pRZ = paramCursor.getString(7);
    this.sex = paramCursor.getInt(8);
    this.kag = paramCursor.getInt(9);
    this.province = paramCursor.getString(10);
    this.city = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.kDc = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.kab = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.kaa));
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("fbname", bWR());
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.pSz));
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.eQp & 0x40) != 0)
    {
      if (this.pRY == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.eQp & 0x80) != 0)
      {
        if (this.pRZ != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.eQp & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.sex));
      }
      if ((this.eQp & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.kag));
      }
      if ((this.eQp & 0x400) != 0)
      {
        if (this.province != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.eQp & 0x800) != 0)
      {
        if (this.city != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.eQp & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.eQp & 0x2000) != 0)
      {
        if (this.kDc != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.eQp & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.eQp & 0x8000) != 0) {
        if (this.kab != null) {
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
    for (String str = "";; str = this.kab)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.pRY;
      break;
      str = this.pRZ;
      break label187;
      str = this.province;
      break label263;
      str = this.city;
      break label291;
      str = this.signature;
      break label319;
      str = this.kDc;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.d
 * JD-Core Version:    0.7.0.1
 */