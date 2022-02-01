package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
{
  int eQp;
  public String nickname;
  String osA;
  String osB;
  public int osC;
  public int osD;
  public long pTU;
  public int pTV;
  int pTW;
  String pTX;
  String pTY;
  String pTZ;
  String pUa;
  String pUb;
  public String pUc;
  String pUd;
  String pUe;
  public String username;
  
  public ap()
  {
    AppMethodBeat.i(131159);
    this.eQp = -1;
    this.pTU = 0L;
    this.pTV = 0;
    this.pTW = 0;
    this.username = "";
    this.nickname = "";
    this.pTX = "";
    this.pTY = "";
    this.pTZ = "";
    this.pUa = "";
    this.pUb = "";
    this.pUc = "";
    this.pUd = "";
    this.pUe = "";
    this.osA = "";
    this.osB = "";
    this.osC = 0;
    this.osD = 0;
    AppMethodBeat.o(131159);
  }
  
  public final ContentValues bXs()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.pTU));
    }
    int i;
    if ((this.eQp & 0x2) != 0)
    {
      i = this.pTV;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.eQp & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.pTW));
      }
      if ((this.eQp & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.eQp & 0x10) != 0) {
        localContentValues.put("nickname", getNickname());
      }
      if ((this.eQp & 0x20) != 0)
      {
        if (this.pTX != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.eQp & 0x40) != 0)
      {
        if (this.pTY != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.eQp & 0x80) != 0) {
        localContentValues.put("qqnickname", bXt());
      }
      if ((this.eQp & 0x100) != 0) {
        localContentValues.put("qqpyinitial", bXu());
      }
      if ((this.eQp & 0x200) != 0) {
        localContentValues.put("qqquanpin", bXv());
      }
      if ((this.eQp & 0x400) != 0) {
        localContentValues.put("qqremark", bXw());
      }
      if ((this.eQp & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", bXx());
      }
      if ((this.eQp & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", bXy());
      }
      if ((this.eQp & 0x4000) != 0) {
        if (this.osB != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.osB)
    {
      localContentValues.put("reserved2", str);
      if ((this.eQp & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.osC));
      }
      if ((this.eQp & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.osD));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.pTX;
      break label146;
      str = this.pTY;
      break label173;
    }
  }
  
  public final String bXt()
  {
    if (this.pTZ == null) {
      return "";
    }
    return this.pTZ;
  }
  
  public final String bXu()
  {
    if (this.pUa == null) {
      return "";
    }
    return this.pUa;
  }
  
  public final String bXv()
  {
    if (this.pUb == null) {
      return "";
    }
    return this.pUb;
  }
  
  public final String bXw()
  {
    if (this.pUc == null) {
      return "";
    }
    return this.pUc;
  }
  
  public final String bXx()
  {
    if (this.pUd == null) {
      return "";
    }
    return this.pUd;
  }
  
  public final String bXy()
  {
    if (this.pUe == null) {
      return "";
    }
    return this.pUe;
  }
  
  public final void bXz()
  {
    this.osC |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.pTU = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.pTV = 0;; this.pTV = i)
    {
      this.pTW = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.pTX = paramCursor.getString(5);
      this.pTY = paramCursor.getString(6);
      this.pTZ = paramCursor.getString(7);
      this.pUa = paramCursor.getString(8);
      this.pUb = paramCursor.getString(9);
      this.pUc = paramCursor.getString(10);
      this.pUd = paramCursor.getString(11);
      this.pUe = paramCursor.getString(12);
      this.osA = paramCursor.getString(13);
      this.osB = paramCursor.getString(14);
      this.osC = paramCursor.getInt(15);
      this.osD = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((bXw() == null) || (bXw().length() <= 0))
    {
      str = bXt();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = bXw();
    AppMethodBeat.o(131162);
    return str;
  }
  
  public final String getNickname()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131163);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("groupID\t:").append(this.pTW).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.pTU).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.pTV).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.osC).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.osD).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ap
 * JD-Core Version:    0.7.0.1
 */