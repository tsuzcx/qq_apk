package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bv
{
  public int cSx;
  private String groupId;
  public String iAo;
  public String iAq;
  public String iFk;
  public String iFl;
  public String iFm;
  public long iFn;
  public String iFo;
  public String iFp;
  public int iFq;
  public int iFr;
  public long iFs;
  public String iFt;
  public String iFu;
  private boolean iFv;
  private int iFw;
  private int iFx;
  public String name;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bv()
  {
    AppMethodBeat.i(91028);
    this.iFv = false;
    this.iFw = 0;
    this.subType = 0;
    this.iFx = 0;
    this.groupId = "";
    this.cSx = -1;
    this.iFk = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.iFl = "";
    this.iFm = "";
    this.iFn = 0L;
    this.iFo = "";
    this.iFp = "";
    this.iFq = 0;
    this.iAo = "";
    this.iAq = "";
    this.iFr = 0;
    this.iFs = 0L;
    this.iFt = "";
    this.iFu = "";
    AppMethodBeat.o(91028);
  }
  
  private void aWi()
  {
    AppMethodBeat.i(91036);
    if ((this.iFv) || (Util.isNullOrNil(this.iFu)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.iFu);
        this.iFw = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.iFx = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.iFv = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String sd(int paramInt)
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
  
  public final String aVZ()
  {
    if (this.iFk == null) {
      return "";
    }
    return this.iFk;
  }
  
  public final String aWa()
  {
    if (this.iFl == null) {
      return "";
    }
    return this.iFl;
  }
  
  public final String aWb()
  {
    if (this.iFo == null) {
      return "";
    }
    return this.iFo;
  }
  
  public final String aWc()
  {
    if (this.iFp == null) {
      return "";
    }
    return this.iFp;
  }
  
  public final String aWd()
  {
    AppMethodBeat.i(91031);
    if (this.iAo != null)
    {
      Object localObject = this.iAo.split("\\|");
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
  
  public final String aWe()
  {
    if (this.iFu == null) {
      return "";
    }
    return this.iFu;
  }
  
  public final int aWf()
  {
    AppMethodBeat.i(91032);
    aWi();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int aWg()
  {
    AppMethodBeat.i(91033);
    aWi();
    int i = this.iFw;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final int aWh()
  {
    AppMethodBeat.i(91035);
    aWi();
    int i = this.iFx;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final String avy()
  {
    AppMethodBeat.i(91034);
    aWi();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.iFk = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.iFl = paramCursor.getString(6);
    this.iFm = paramCursor.getString(7);
    this.iFn = paramCursor.getLong(8);
    this.iFo = paramCursor.getString(9);
    this.iFp = paramCursor.getString(10);
    this.iFq = paramCursor.getInt(11);
    this.iAo = paramCursor.getString(12);
    this.iAq = paramCursor.getString(13);
    this.iFr = paramCursor.getInt(14);
    this.iFs = paramCursor.getLong(15);
    this.iFt = paramCursor.getString(16);
    this.iFu = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.iAq == null) {
      return "";
    }
    return this.iAq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */