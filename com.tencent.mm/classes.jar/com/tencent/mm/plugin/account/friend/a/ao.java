package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;

public final class ao
{
  int bcw = -1;
  String ebN = "";
  String ebO = "";
  public int ebP = 0;
  public int ebQ = 0;
  public long fgW = 0L;
  public int fgX = 0;
  int fgY = 0;
  String fgZ = "";
  String fha = "";
  String fhb = "";
  String fhc = "";
  String fhd = "";
  public String fhe = "";
  String fhf = "";
  String fhg = "";
  public String nickname = "";
  public String username = "";
  
  public final ContentValues Xh()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.fgW));
    }
    int i;
    if ((this.bcw & 0x2) != 0)
    {
      i = this.fgX;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.bcw & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.fgY));
      }
      if ((this.bcw & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.bcw & 0x10) != 0) {
        localContentValues.put("nickname", vm());
      }
      if ((this.bcw & 0x20) != 0)
      {
        if (this.fgZ != null) {
          break label390;
        }
        str = "";
        label141:
        localContentValues.put("pyinitial", str);
      }
      if ((this.bcw & 0x40) != 0)
      {
        if (this.fha != null) {
          break label398;
        }
        str = "";
        label168:
        localContentValues.put("quanpin", str);
      }
      if ((this.bcw & 0x80) != 0) {
        localContentValues.put("qqnickname", Xi());
      }
      if ((this.bcw & 0x100) != 0) {
        localContentValues.put("qqpyinitial", Xj());
      }
      if ((this.bcw & 0x200) != 0) {
        localContentValues.put("qqquanpin", Xk());
      }
      if ((this.bcw & 0x400) != 0) {
        localContentValues.put("qqremark", Xl());
      }
      if ((this.bcw & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", Xm());
      }
      if ((this.bcw & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", Xn());
      }
      if ((this.bcw & 0x4000) != 0) {
        if (this.ebO != null) {
          break label406;
        }
      }
    }
    label390:
    label398:
    label406:
    for (String str = "";; str = this.ebO)
    {
      localContentValues.put("reserved2", str);
      if ((this.bcw & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ebP));
      }
      if ((this.bcw & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
      }
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.fgZ;
      break label141;
      str = this.fha;
      break label168;
    }
  }
  
  public final String Xi()
  {
    if (this.fhb == null) {
      return "";
    }
    return this.fhb;
  }
  
  public final String Xj()
  {
    if (this.fhc == null) {
      return "";
    }
    return this.fhc;
  }
  
  public final String Xk()
  {
    if (this.fhd == null) {
      return "";
    }
    return this.fhd;
  }
  
  public final String Xl()
  {
    if (this.fhe == null) {
      return "";
    }
    return this.fhe;
  }
  
  public final String Xm()
  {
    if (this.fhf == null) {
      return "";
    }
    return this.fhf;
  }
  
  public final String Xn()
  {
    if (this.fhg == null) {
      return "";
    }
    return this.fhg;
  }
  
  public final void Xo()
  {
    this.ebP |= 0x1;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.fgW = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.fgX = 0;; this.fgX = i)
    {
      this.fgY = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.fgZ = paramCursor.getString(5);
      this.fha = paramCursor.getString(6);
      this.fhb = paramCursor.getString(7);
      this.fhc = paramCursor.getString(8);
      this.fhd = paramCursor.getString(9);
      this.fhe = paramCursor.getString(10);
      this.fhf = paramCursor.getString(11);
      this.fhg = paramCursor.getString(12);
      this.ebN = paramCursor.getString(13);
      this.ebO = paramCursor.getString(14);
      this.ebP = paramCursor.getInt(15);
      this.ebQ = paramCursor.getInt(16);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    if ((Xl() == null) || (Xl().length() <= 0)) {
      return Xi();
    }
    return Xl();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupID\t:").append(this.fgY).append("\n");
    localStringBuilder.append("qq\t:").append(this.fgW).append("\n");
    localStringBuilder.append("username\t:").append(this.username).append("\n");
    localStringBuilder.append("nickname\t:").append(this.nickname).append("\n");
    localStringBuilder.append("wexinStatus\t:").append(this.fgX).append("\n");
    localStringBuilder.append("reserved3\t:").append(this.ebP).append("\n");
    localStringBuilder.append("reserved4\t:").append(this.ebQ).append("\n");
    return localStringBuilder.toString();
  }
  
  public final String vm()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ao
 * JD-Core Version:    0.7.0.1
 */