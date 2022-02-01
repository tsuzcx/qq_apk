package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bo
{
  public int drx;
  private String groupId;
  public String hld;
  public String hlf;
  public String hpm;
  public String hpn;
  public String hpo;
  public long hpp;
  public String hpq;
  public String hpr;
  public int hps;
  public int hpt;
  public long hpu;
  public String hpv;
  public String hpw;
  private boolean hpx;
  private int hpy;
  private int hpz;
  public String name;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bo()
  {
    AppMethodBeat.i(91028);
    this.hpx = false;
    this.hpy = 0;
    this.subType = 0;
    this.hpz = 0;
    this.groupId = "";
    this.drx = -1;
    this.hpm = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.hpn = "";
    this.hpo = "";
    this.hpp = 0L;
    this.hpq = "";
    this.hpr = "";
    this.hps = 0;
    this.hld = "";
    this.hlf = "";
    this.hpt = 0;
    this.hpu = 0L;
    this.hpv = "";
    this.hpw = "";
    AppMethodBeat.o(91028);
  }
  
  private void azr()
  {
    AppMethodBeat.i(91036);
    if ((this.hpx) || (bs.isNullOrNil(this.hpw)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.hpw);
        this.hpy = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.hpz = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.hpx = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String nZ(int paramInt)
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
  
  public final String azh()
  {
    if (this.hpm == null) {
      return "";
    }
    return this.hpm;
  }
  
  public final String azi()
  {
    if (this.hpn == null) {
      return "";
    }
    return this.hpn;
  }
  
  public final String azj()
  {
    if (this.hpq == null) {
      return "";
    }
    return this.hpq;
  }
  
  public final String azk()
  {
    if (this.hpr == null) {
      return "";
    }
    return this.hpr;
  }
  
  public final String azl()
  {
    AppMethodBeat.i(91031);
    if (this.hld != null)
    {
      Object localObject = this.hld.split("\\|");
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
  
  public final String azm()
  {
    if (this.hpw == null) {
      return "";
    }
    return this.hpw;
  }
  
  public final int azn()
  {
    AppMethodBeat.i(91032);
    azr();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int azo()
  {
    AppMethodBeat.i(91033);
    azr();
    int i = this.hpy;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final String azp()
  {
    AppMethodBeat.i(91034);
    azr();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final int azq()
  {
    AppMethodBeat.i(91035);
    azr();
    int i = this.hpz;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.hpm = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.hpn = paramCursor.getString(6);
    this.hpo = paramCursor.getString(7);
    this.hpp = paramCursor.getLong(8);
    this.hpq = paramCursor.getString(9);
    this.hpr = paramCursor.getString(10);
    this.hps = paramCursor.getInt(11);
    this.hld = paramCursor.getString(12);
    this.hlf = paramCursor.getString(13);
    this.hpt = paramCursor.getInt(14);
    this.hpu = paramCursor.getLong(15);
    this.hpv = paramCursor.getString(16);
    this.hpw = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.hlf == null) {
      return "";
    }
    return this.hlf;
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
 * Qualified Name:     com.tencent.mm.model.bo
 * JD-Core Version:    0.7.0.1
 */