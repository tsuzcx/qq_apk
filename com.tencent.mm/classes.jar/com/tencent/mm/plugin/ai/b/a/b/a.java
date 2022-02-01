package com.tencent.mm.plugin.ai.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abt;
import com.tencent.mm.f.a.abt.a;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a
{
  private static a noO;
  public static final HashMap<String, Integer> noP;
  public IListener<hx> noK;
  public HashMap<String, Integer> noQ;
  private HashMap<Integer, abt.a> noR;
  public IListener<abt> noc;
  
  static
  {
    AppMethodBeat.i(239844);
    HashMap localHashMap = new HashMap();
    noP = localHashMap;
    localHashMap.put("album_dyna_photo_ui_title", Integer.valueOf(0));
    noP.put("find_live_friends_by_near", Integer.valueOf(1));
    noP.put("find_friends_by_near", Integer.valueOf(1));
    noP.put("find_friends_by_near_v3", Integer.valueOf(1));
    noP.put("find_friends_by_shake", Integer.valueOf(2));
    noP.put("find_friends_by_qrcode", Integer.valueOf(3));
    noP.put("more_tab_game_recommend", Integer.valueOf(4));
    noP.put("jd_market_entrance", Integer.valueOf(5));
    noP.put("app_brand_entrance", Integer.valueOf(6));
    noP.put("ip_call_entrance", Integer.valueOf(7));
    noP.put("find_friends_by_look", Integer.valueOf(8));
    noP.put("find_friends_by_search", Integer.valueOf(9));
    noP.put("my_life_around", Integer.valueOf(10));
    noP.put("find_friends_by_finder", Integer.valueOf(11));
    noP.put("find_friends_by_finder_live", Integer.valueOf(12));
    AppMethodBeat.o(239844);
  }
  
  private a()
  {
    AppMethodBeat.i(239838);
    this.noQ = new HashMap();
    this.noK = new IListener() {};
    this.noR = new HashMap();
    this.noc = new IListener() {};
    AppMethodBeat.o(239838);
  }
  
  public static a bBa()
  {
    AppMethodBeat.i(239834);
    if (noO == null) {
      noO = new a();
    }
    a locala = noO;
    AppMethodBeat.o(239834);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */