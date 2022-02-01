package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bp
{
  public int dDp;
  private String groupId;
  public String hDm;
  public String hDo;
  public String hHE;
  public String hHF;
  public String hHG;
  public long hHH;
  public String hHI;
  public String hHJ;
  public int hHK;
  public int hHL;
  public long hHM;
  public String hHN;
  public String hHO;
  private boolean hHP;
  private int hHQ;
  private int hHR;
  public String name;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bp()
  {
    AppMethodBeat.i(91028);
    this.hHP = false;
    this.hHQ = 0;
    this.subType = 0;
    this.hHR = 0;
    this.groupId = "";
    this.dDp = -1;
    this.hHE = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.hHF = "";
    this.hHG = "";
    this.hHH = 0L;
    this.hHI = "";
    this.hHJ = "";
    this.hHK = 0;
    this.hDm = "";
    this.hDo = "";
    this.hHL = 0;
    this.hHM = 0L;
    this.hHN = "";
    this.hHO = "";
    AppMethodBeat.o(91028);
  }
  
  private void aCu()
  {
    AppMethodBeat.i(91036);
    if ((this.hHP) || (bt.isNullOrNil(this.hHO)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.hHO);
        this.hHQ = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.hHR = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.hHP = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String oz(int paramInt)
  {
    AppMethodBeat.i(91030);
    if (paramInt == 20)
    {
      AppMethodBeat.o(91030);
      return "newsapp";
    }
    if (paramInt == 11)
    {
      AppMethodBeat.o(91030);
      return "blogapp";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    AppMethodBeat.o(91030);
    return null;
  }
  
  public final String aCl()
  {
    if (this.hHE == null) {
      return "";
    }
    return this.hHE;
  }
  
  public final String aCm()
  {
    if (this.hHF == null) {
      return "";
    }
    return this.hHF;
  }
  
  public final String aCn()
  {
    if (this.hHI == null) {
      return "";
    }
    return this.hHI;
  }
  
  public final String aCo()
  {
    if (this.hHJ == null) {
      return "";
    }
    return this.hHJ;
  }
  
  public final String aCp()
  {
    AppMethodBeat.i(91031);
    if (this.hDm != null)
    {
      Object localObject = this.hDm.split("\\|");
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = localObject[0];
        AppMethodBeat.o(91031);
        return localObject;
      }
      AppMethodBeat.o(91031);
      return "";
    }
    AppMethodBeat.o(91031);
    return "";
  }
  
  public final String aCq()
  {
    if (this.hHO == null) {
      return "";
    }
    return this.hHO;
  }
  
  public final int aCr()
  {
    AppMethodBeat.i(91032);
    aCu();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int aCs()
  {
    AppMethodBeat.i(91033);
    aCu();
    int i = this.hHQ;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final int aCt()
  {
    AppMethodBeat.i(91035);
    aCu();
    int i = this.hHR;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final String afw()
  {
    AppMethodBeat.i(91034);
    aCu();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.hHE = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.hHF = paramCursor.getString(6);
    this.hHG = paramCursor.getString(7);
    this.hHH = paramCursor.getLong(8);
    this.hHI = paramCursor.getString(9);
    this.hHJ = paramCursor.getString(10);
    this.hHK = paramCursor.getInt(11);
    this.hDm = paramCursor.getString(12);
    this.hDo = paramCursor.getString(13);
    this.hHL = paramCursor.getInt(14);
    this.hHM = paramCursor.getLong(15);
    this.hHN = paramCursor.getString(16);
    this.hHO = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.hDo == null) {
      return "";
    }
    return this.hDo;
  }
  
  public final String getName()
  {
    if (this.name == null) {
      return "";
    }
    return this.name;
  }
  
  public final String getTitle()
  {
    if (this.title == null) {
      return "";
    }
    return this.title;
  }
  
  public final String getUrl()
  {
    if (this.url == null) {
      return "";
    }
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bp
 * JD-Core Version:    0.7.0.1
 */