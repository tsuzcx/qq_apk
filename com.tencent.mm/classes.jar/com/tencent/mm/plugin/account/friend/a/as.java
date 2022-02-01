package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int cUP;
  String lAY;
  String lAZ;
  public int lBa;
  public int lBb;
  public long mXm;
  public int mXn;
  int mXo;
  String mXp;
  String mXq;
  String mXr;
  String mXs;
  String mXt;
  public String mXu;
  String mXv;
  String mXw;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.cUP = -1;
    this.mXm = 0L;
    this.mXn = 0;
    this.mXo = 0;
    this.username = "";
    this.nickname = "";
    this.mXp = "";
    this.mXq = "";
    this.mXr = "";
    this.mXs = "";
    this.mXt = "";
    this.mXu = "";
    this.mXv = "";
    this.mXw = "";
    this.lAY = "";
    this.lAZ = "";
    this.lBa = 0;
    this.lBb = 0;
    AppMethodBeat.o(131159);
  }
  
  public final ContentValues byE()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.mXm));
    }
    int i;
    if ((this.cUP & 0x2) != 0)
    {
      i = this.mXn;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.cUP & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.mXo));
      }
      if ((this.cUP & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.cUP & 0x10) != 0) {
        localContentValues.put("nickname", getNickname());
      }
      if ((this.cUP & 0x20) != 0)
      {
        if (this.mXp != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.cUP & 0x40) != 0)
      {
        if (this.mXq != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.cUP & 0x80) != 0) {
        localContentValues.put("qqnickname", byF());
      }
      if ((this.cUP & 0x100) != 0) {
        localContentValues.put("qqpyinitial", byG());
      }
      if ((this.cUP & 0x200) != 0) {
        localContentValues.put("qqquanpin", byH());
      }
      if ((this.cUP & 0x400) != 0) {
        localContentValues.put("qqremark", byI());
      }
      if ((this.cUP & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", byJ());
      }
      if ((this.cUP & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", byK());
      }
      if ((this.cUP & 0x4000) != 0) {
        if (this.lAZ != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.lAZ)
    {
      localContentValues.put("reserved2", str);
      if ((this.cUP & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.lBa));
      }
      if ((this.cUP & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.lBb));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.mXp;
      break label146;
      str = this.mXq;
      break label173;
    }
  }
  
  public final String byF()
  {
    if (this.mXr == null) {
      return "";
    }
    return this.mXr;
  }
  
  public final String byG()
  {
    if (this.mXs == null) {
      return "";
    }
    return this.mXs;
  }
  
  public final String byH()
  {
    if (this.mXt == null) {
      return "";
    }
    return this.mXt;
  }
  
  public final String byI()
  {
    if (this.mXu == null) {
      return "";
    }
    return this.mXu;
  }
  
  public final String byJ()
  {
    if (this.mXv == null) {
      return "";
    }
    return this.mXv;
  }
  
  public final String byK()
  {
    if (this.mXw == null) {
      return "";
    }
    return this.mXw;
  }
  
  public final void byL()
  {
    this.lBa |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.mXm = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.mXn = 0;; this.mXn = i)
    {
      this.mXo = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.mXp = paramCursor.getString(5);
      this.mXq = paramCursor.getString(6);
      this.mXr = paramCursor.getString(7);
      this.mXs = paramCursor.getString(8);
      this.mXt = paramCursor.getString(9);
      this.mXu = paramCursor.getString(10);
      this.mXv = paramCursor.getString(11);
      this.mXw = paramCursor.getString(12);
      this.lAY = paramCursor.getString(13);
      this.lAZ = paramCursor.getString(14);
      this.lBa = paramCursor.getInt(15);
      this.lBb = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((byI() == null) || (byI().length() <= 0))
    {
      str = byF();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = byI();
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
    ((StringBuilder)localObject).append("groupID\t:").append(this.mXo).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.mXm).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.mXn).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.lBa).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.lBb).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */