package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  String bVF;
  int dDp;
  int ePk;
  public long ePm;
  private String ePn;
  int ePt;
  String ePu;
  String ePv;
  String ffB;
  String jcV;
  String jcW;
  String jdv;
  int jdw;
  String signature;
  public int status;
  private int type;
  String username;
  
  public g()
  {
    AppMethodBeat.i(130993);
    this.dDp = -1;
    this.ePm = 0L;
    this.jdv = "";
    this.jdw = 0;
    this.status = 0;
    this.username = "";
    this.bVF = "";
    this.jcV = "";
    this.jcW = "";
    this.ePk = 0;
    this.ePt = 0;
    this.ePu = "";
    this.ePv = "";
    this.signature = "";
    this.ffB = "";
    this.type = 0;
    this.ePn = "";
    AppMethodBeat.o(130993);
  }
  
  public final String aSI()
  {
    if (this.jdv == null) {
      return "";
    }
    return this.jdv;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130994);
    this.ePm = paramCursor.getLong(0);
    this.jdv = paramCursor.getString(1);
    this.jdw = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.bVF = paramCursor.getString(5);
    this.jcV = paramCursor.getString(6);
    this.jcW = paramCursor.getString(7);
    this.ePk = paramCursor.getInt(8);
    this.ePt = paramCursor.getInt(9);
    this.ePu = paramCursor.getString(10);
    this.ePv = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.ffB = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.ePn = paramCursor.getString(15);
    AppMethodBeat.o(130994);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130995);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.ePm));
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("fbname", aSI());
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.jdw));
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dDp & 0x40) != 0)
    {
      if (this.jcV == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.dDp & 0x80) != 0)
      {
        if (this.jcW != null) {
          break label420;
        }
        str = "";
        label187:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.dDp & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.ePk));
      }
      if ((this.dDp & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.ePt));
      }
      if ((this.dDp & 0x400) != 0)
      {
        if (this.ePu != null) {
          break label428;
        }
        str = "";
        label263:
        localContentValues.put("province", str);
      }
      if ((this.dDp & 0x800) != 0)
      {
        if (this.ePv != null) {
          break label436;
        }
        str = "";
        label291:
        localContentValues.put("city", str);
      }
      if ((this.dDp & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label444;
        }
        str = "";
        label319:
        localContentValues.put("signature", str);
      }
      if ((this.dDp & 0x2000) != 0)
      {
        if (this.ffB != null) {
          break label452;
        }
        str = "";
        label347:
        localContentValues.put("alias", str);
      }
      if ((this.dDp & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.dDp & 0x8000) != 0) {
        if (this.ePn != null) {
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
    for (String str = "";; str = this.ePn)
    {
      localContentValues.put("email", str);
      AppMethodBeat.o(130995);
      return localContentValues;
      str = this.jcV;
      break;
      str = this.jcW;
      break label187;
      str = this.ePu;
      break label263;
      str = this.ePv;
      break label291;
      str = this.signature;
      break label319;
      str = this.ffB;
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