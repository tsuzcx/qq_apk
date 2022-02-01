package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int dEu;
  String hPK;
  String hPL;
  public int hPM;
  public int hPN;
  public long jhK;
  public int jhL;
  int jhM;
  String jhN;
  String jhO;
  String jhP;
  String jhQ;
  String jhR;
  public String jhS;
  String jhT;
  String jhU;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.dEu = -1;
    this.jhK = 0L;
    this.jhL = 0;
    this.jhM = 0;
    this.username = "";
    this.nickname = "";
    this.jhN = "";
    this.jhO = "";
    this.jhP = "";
    this.jhQ = "";
    this.jhR = "";
    this.jhS = "";
    this.jhT = "";
    this.jhU = "";
    this.hPK = "";
    this.hPL = "";
    this.hPM = 0;
    this.hPN = 0;
    AppMethodBeat.o(131159);
  }
  
  public final String VK()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final ContentValues aTJ()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.jhK));
    }
    int i;
    if ((this.dEu & 0x2) != 0)
    {
      i = this.jhL;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.dEu & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.jhM));
      }
      if ((this.dEu & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.dEu & 0x10) != 0) {
        localContentValues.put("nickname", VK());
      }
      if ((this.dEu & 0x20) != 0)
      {
        if (this.jhN != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.dEu & 0x40) != 0)
      {
        if (this.jhO != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.dEu & 0x80) != 0) {
        localContentValues.put("qqnickname", aTK());
      }
      if ((this.dEu & 0x100) != 0) {
        localContentValues.put("qqpyinitial", aTL());
      }
      if ((this.dEu & 0x200) != 0) {
        localContentValues.put("qqquanpin", aTM());
      }
      if ((this.dEu & 0x400) != 0) {
        localContentValues.put("qqremark", aTN());
      }
      if ((this.dEu & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", aTO());
      }
      if ((this.dEu & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", aTP());
      }
      if ((this.dEu & 0x4000) != 0) {
        if (this.hPL != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.hPL)
    {
      localContentValues.put("reserved2", str);
      if ((this.dEu & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hPM));
      }
      if ((this.dEu & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hPN));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.jhN;
      break label146;
      str = this.jhO;
      break label173;
    }
  }
  
  public final String aTK()
  {
    if (this.jhP == null) {
      return "";
    }
    return this.jhP;
  }
  
  public final String aTL()
  {
    if (this.jhQ == null) {
      return "";
    }
    return this.jhQ;
  }
  
  public final String aTM()
  {
    if (this.jhR == null) {
      return "";
    }
    return this.jhR;
  }
  
  public final String aTN()
  {
    if (this.jhS == null) {
      return "";
    }
    return this.jhS;
  }
  
  public final String aTO()
  {
    if (this.jhT == null) {
      return "";
    }
    return this.jhT;
  }
  
  public final String aTP()
  {
    if (this.jhU == null) {
      return "";
    }
    return this.jhU;
  }
  
  public final void aTQ()
  {
    this.hPM |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.jhK = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.jhL = 0;; this.jhL = i)
    {
      this.jhM = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.jhN = paramCursor.getString(5);
      this.jhO = paramCursor.getString(6);
      this.jhP = paramCursor.getString(7);
      this.jhQ = paramCursor.getString(8);
      this.jhR = paramCursor.getString(9);
      this.jhS = paramCursor.getString(10);
      this.jhT = paramCursor.getString(11);
      this.jhU = paramCursor.getString(12);
      this.hPK = paramCursor.getString(13);
      this.hPL = paramCursor.getString(14);
      this.hPM = paramCursor.getInt(15);
      this.hPN = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((aTN() == null) || (aTN().length() <= 0))
    {
      str = aTK();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = aTN();
    AppMethodBeat.o(131162);
    return str;
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
    ((StringBuilder)localObject).append("groupID\t:").append(this.jhM).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.jhK).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.jhL).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.hPM).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.hPN).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */