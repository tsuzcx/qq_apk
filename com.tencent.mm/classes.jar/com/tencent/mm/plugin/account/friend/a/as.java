package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int cSx;
  String iKR;
  String iKS;
  public int iKT;
  public int iKU;
  public long kfN;
  public int kfO;
  int kfP;
  String kfQ;
  String kfR;
  String kfS;
  String kfT;
  String kfU;
  public String kfV;
  String kfW;
  String kfX;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.cSx = -1;
    this.kfN = 0L;
    this.kfO = 0;
    this.kfP = 0;
    this.username = "";
    this.nickname = "";
    this.kfQ = "";
    this.kfR = "";
    this.kfS = "";
    this.kfT = "";
    this.kfU = "";
    this.kfV = "";
    this.kfW = "";
    this.kfX = "";
    this.iKR = "";
    this.iKS = "";
    this.iKT = 0;
    this.iKU = 0;
    AppMethodBeat.o(131159);
  }
  
  public final String boA()
  {
    if (this.kfW == null) {
      return "";
    }
    return this.kfW;
  }
  
  public final String boB()
  {
    if (this.kfX == null) {
      return "";
    }
    return this.kfX;
  }
  
  public final void boC()
  {
    this.iKT |= 0x1;
  }
  
  public final ContentValues bov()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.kfN));
    }
    int i;
    if ((this.cSx & 0x2) != 0)
    {
      i = this.kfO;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.cSx & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.kfP));
      }
      if ((this.cSx & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.cSx & 0x10) != 0) {
        localContentValues.put("nickname", getNickname());
      }
      if ((this.cSx & 0x20) != 0)
      {
        if (this.kfQ != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.cSx & 0x40) != 0)
      {
        if (this.kfR != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.cSx & 0x80) != 0) {
        localContentValues.put("qqnickname", bow());
      }
      if ((this.cSx & 0x100) != 0) {
        localContentValues.put("qqpyinitial", box());
      }
      if ((this.cSx & 0x200) != 0) {
        localContentValues.put("qqquanpin", boy());
      }
      if ((this.cSx & 0x400) != 0) {
        localContentValues.put("qqremark", boz());
      }
      if ((this.cSx & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", boA());
      }
      if ((this.cSx & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", boB());
      }
      if ((this.cSx & 0x4000) != 0) {
        if (this.iKS != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.iKS)
    {
      localContentValues.put("reserved2", str);
      if ((this.cSx & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.iKT));
      }
      if ((this.cSx & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.iKU));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.kfQ;
      break label146;
      str = this.kfR;
      break label173;
    }
  }
  
  public final String bow()
  {
    if (this.kfS == null) {
      return "";
    }
    return this.kfS;
  }
  
  public final String box()
  {
    if (this.kfT == null) {
      return "";
    }
    return this.kfT;
  }
  
  public final String boy()
  {
    if (this.kfU == null) {
      return "";
    }
    return this.kfU;
  }
  
  public final String boz()
  {
    if (this.kfV == null) {
      return "";
    }
    return this.kfV;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.kfN = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.kfO = 0;; this.kfO = i)
    {
      this.kfP = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.kfQ = paramCursor.getString(5);
      this.kfR = paramCursor.getString(6);
      this.kfS = paramCursor.getString(7);
      this.kfT = paramCursor.getString(8);
      this.kfU = paramCursor.getString(9);
      this.kfV = paramCursor.getString(10);
      this.kfW = paramCursor.getString(11);
      this.kfX = paramCursor.getString(12);
      this.iKR = paramCursor.getString(13);
      this.iKS = paramCursor.getString(14);
      this.iKT = paramCursor.getInt(15);
      this.iKU = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((boz() == null) || (boz().length() <= 0))
    {
      str = bow();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = boz();
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
    ((StringBuilder)localObject).append("groupID\t:").append(this.kfP).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.kfN).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.kfO).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.iKT).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.iKU).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */