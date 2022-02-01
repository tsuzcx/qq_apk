package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bx
{
  public int eQp;
  private String groupId;
  public String nUM;
  public String nUO;
  public String name;
  public String omJ;
  public String omK;
  public String omL;
  public long omM;
  public int omN;
  public int omO;
  public long omP;
  public String omQ;
  public String omR;
  private boolean omS;
  private int omT;
  private int omU;
  public String sourceIcon;
  public String sourceName;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bx()
  {
    AppMethodBeat.i(91028);
    this.omS = false;
    this.omT = 0;
    this.subType = 0;
    this.omU = 0;
    this.groupId = "";
    this.eQp = -1;
    this.omJ = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.omK = "";
    this.omL = "";
    this.omM = 0L;
    this.sourceName = "";
    this.sourceIcon = "";
    this.omN = 0;
    this.nUM = "";
    this.nUO = "";
    this.omO = 0;
    this.omP = 0L;
    this.omQ = "";
    this.omR = "";
    AppMethodBeat.o(91028);
  }
  
  private void bDc()
  {
    AppMethodBeat.i(91036);
    if ((this.omS) || (Util.isNullOrNil(this.omR)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.omR);
        this.omT = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.omU = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.omS = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String vk(int paramInt)
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
  
  public final String aVp()
  {
    AppMethodBeat.i(91034);
    bDc();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final String bCT()
  {
    if (this.omJ == null) {
      return "";
    }
    return this.omJ;
  }
  
  public final String bCU()
  {
    if (this.omK == null) {
      return "";
    }
    return this.omK;
  }
  
  public final String bCV()
  {
    if (this.sourceName == null) {
      return "";
    }
    return this.sourceName;
  }
  
  public final String bCW()
  {
    if (this.sourceIcon == null) {
      return "";
    }
    return this.sourceIcon;
  }
  
  public final String bCX()
  {
    AppMethodBeat.i(91031);
    if (this.nUM != null)
    {
      Object localObject = this.nUM.split("\\|");
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
  
  public final String bCY()
  {
    if (this.omR == null) {
      return "";
    }
    return this.omR;
  }
  
  public final int bCZ()
  {
    AppMethodBeat.i(91032);
    bDc();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int bDa()
  {
    AppMethodBeat.i(91033);
    bDc();
    int i = this.omT;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final int bDb()
  {
    AppMethodBeat.i(91035);
    bDc();
    int i = this.omU;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.omJ = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.omK = paramCursor.getString(6);
    this.omL = paramCursor.getString(7);
    this.omM = paramCursor.getLong(8);
    this.sourceName = paramCursor.getString(9);
    this.sourceIcon = paramCursor.getString(10);
    this.omN = paramCursor.getInt(11);
    this.nUM = paramCursor.getString(12);
    this.nUO = paramCursor.getString(13);
    this.omO = paramCursor.getInt(14);
    this.omP = paramCursor.getLong(15);
    this.omQ = paramCursor.getString(16);
    this.omR = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.nUO == null) {
      return "";
    }
    return this.nUO;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.model.bx
 * JD-Core Version:    0.7.0.1
 */