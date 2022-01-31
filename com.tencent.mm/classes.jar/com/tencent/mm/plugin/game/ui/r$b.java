package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.aac;
import java.util.LinkedList;

public final class r$b
{
  public int actionType;
  public String appId;
  public String bGm;
  public long createTime;
  public String dXh;
  public String fGK;
  public String iconUrl;
  public String lfa;
  public aac lfb;
  public String lfc;
  public LinkedList<String> lfd;
  public int lfe;
  public int lff;
  public boolean lfg = false;
  public boolean lfh = false;
  public r.c lfi;
  public String name;
  public int type;
  
  public static b a(aab paramaab)
  {
    b localb = new b();
    localb.type = 2;
    localb.name = paramaab.bGw;
    localb.fGK = paramaab.kRN;
    localb.iconUrl = paramaab.mQp;
    localb.lfc = paramaab.sYY;
    localb.lfe = paramaab.sZt;
    localb.lff = paramaab.sZu;
    localb.appId = paramaab.euK;
    localb.dXh = paramaab.kVn;
    localb.createTime = paramaab.create_time;
    localb.lfi = new r.c(paramaab.sYY, (byte)0);
    return localb;
  }
  
  public static b as(int paramInt, String paramString)
  {
    b localb = new b();
    localb.type = paramInt;
    localb.name = paramString;
    localb.lfi = new r.c();
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.b
 * JD-Core Version:    0.7.0.1
 */