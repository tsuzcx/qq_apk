package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;

public final class g
{
  String aVr = "";
  int bcw = -1;
  String cCA = "";
  String cCB = "";
  public long cCs = 0L;
  private String cCt = "";
  int cCz = 0;
  String cMT = "";
  String ffA = "";
  int ffB = 0;
  String ffa = "";
  String ffb = "";
  int sex = 0;
  String signature = "";
  public int status = 0;
  private int type = 0;
  String username = "";
  
  public final String WA()
  {
    if (this.aVr == null) {
      return "";
    }
    return this.aVr;
  }
  
  public final String WI()
  {
    if (this.ffA == null) {
      return "";
    }
    return this.ffA;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.cCs = paramCursor.getLong(0);
    this.ffA = paramCursor.getString(1);
    this.ffB = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.aVr = paramCursor.getString(5);
    this.ffa = paramCursor.getString(6);
    this.ffb = paramCursor.getString(7);
    this.sex = paramCursor.getInt(8);
    this.cCz = paramCursor.getInt(9);
    this.cCA = paramCursor.getString(10);
    this.cCB = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.cMT = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.cCt = paramCursor.getString(15);
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.cCs));
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("fbname", WI());
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.ffB));
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("nickname", WA());
    }
    if ((this.bcw & 0x40) != 0)
    {
      if (this.ffa == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.bcw & 0x80) != 0)
      {
        if (this.ffb != null) {
          break label410;
        }
        str = "";
        label182:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.bcw & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.sex));
      }
      if ((this.bcw & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.cCz));
      }
      if ((this.bcw & 0x400) != 0)
      {
        if (this.cCA != null) {
          break label418;
        }
        str = "";
        label258:
        localContentValues.put("province", str);
      }
      if ((this.bcw & 0x800) != 0)
      {
        if (this.cCB != null) {
          break label426;
        }
        str = "";
        label286:
        localContentValues.put("city", str);
      }
      if ((this.bcw & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label434;
        }
        str = "";
        label314:
        localContentValues.put("signature", str);
      }
      if ((this.bcw & 0x2000) != 0)
      {
        if (this.cMT != null) {
          break label442;
        }
        str = "";
        label342:
        localContentValues.put("alias", str);
      }
      if ((this.bcw & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.bcw & 0x8000) != 0) {
        if (this.cCt != null) {
          break label450;
        }
      }
    }
    label410:
    label418:
    label426:
    label434:
    label442:
    label450:
    for (String str = "";; str = this.cCt)
    {
      localContentValues.put("email", str);
      return localContentValues;
      str = this.ffa;
      break;
      str = this.ffb;
      break label182;
      str = this.cCA;
      break label258;
      str = this.cCB;
      break label286;
      str = this.signature;
      break label314;
      str = this.cMT;
      break label342;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.g
 * JD-Core Version:    0.7.0.1
 */