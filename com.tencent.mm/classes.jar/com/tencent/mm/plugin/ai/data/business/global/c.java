package com.tencent.mm.plugin.ai.data.business.global;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adq;
import com.tencent.mm.autogen.a.adq.a;
import com.tencent.mm.autogen.a.ii;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  private static c qmk;
  private static final HashMap<String, Integer> qml;
  public IListener<adq> qlj;
  public IListener<ii> qma;
  private HashMap<String, Integer> qmm;
  public HashMap<Integer, adq.a> qmn;
  
  static
  {
    AppMethodBeat.i(267566);
    HashMap localHashMap = new HashMap();
    qml = localHashMap;
    localHashMap.put("album_dyna_photo_ui_title", Integer.valueOf(0));
    qml.put("find_live_friends_by_near", Integer.valueOf(1));
    qml.put("find_friends_by_near", Integer.valueOf(1));
    qml.put("find_friends_by_near_v3", Integer.valueOf(1));
    qml.put("find_friends_by_shake", Integer.valueOf(2));
    qml.put("find_friends_by_qrcode", Integer.valueOf(3));
    qml.put("more_tab_game_recommend", Integer.valueOf(4));
    qml.put("jd_market_entrance", Integer.valueOf(5));
    qml.put("app_brand_entrance", Integer.valueOf(6));
    qml.put("ip_call_entrance", Integer.valueOf(7));
    qml.put("find_friends_by_look", Integer.valueOf(8));
    qml.put("find_friends_by_search", Integer.valueOf(9));
    qml.put("my_life_around", Integer.valueOf(10));
    qml.put("find_friends_by_finder", Integer.valueOf(11));
    qml.put("find_friends_by_finder_live", Integer.valueOf(12));
    AppMethodBeat.o(267566);
  }
  
  private c()
  {
    AppMethodBeat.i(267535);
    this.qmm = new HashMap();
    this.qma = new AiRedDotData.1(this, f.hfK);
    this.qmn = new HashMap();
    this.qlj = new AiRedDotData.2(this, f.hfK);
    AppMethodBeat.o(267535);
  }
  
  public static c caj()
  {
    AppMethodBeat.i(267525);
    if (qmk == null) {
      qmk = new c();
    }
    c localc = qmk;
    AppMethodBeat.o(267525);
    return localc;
  }
  
  public final boolean bZI()
  {
    AppMethodBeat.i(267597);
    adq.a locala = (adq.a)this.qmn.get(Integer.valueOf(2));
    boolean bool;
    if (locala != null) {
      if ((locala.ihQ) || (locala.ihR > 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267597);
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public final int[] cak()
  {
    AppMethodBeat.i(267576);
    int[] arrayOfInt1 = new int[13];
    int i = 0;
    while (i < 13)
    {
      arrayOfInt1[i] = 0;
      i += 1;
    }
    synchronized (this.qmm)
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(this.qmm.keySet());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (qml.containsKey(str)) {
          arrayOfInt1[((Integer)qml.get(str)).intValue()] = ((Integer)this.qmm.get(str)).intValue();
        }
      }
    }
    Log.d("MicroMsg.AiRedDotData", "copyRedDotInfo [%s]", new Object[] { Arrays.toString(arrayOfInt2) });
    AppMethodBeat.o(267576);
    return arrayOfInt2;
  }
  
  public final String cal()
  {
    AppMethodBeat.i(267582);
    Object localObject = cak();
    int j = localObject.length;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      localStringBuilder.append(localObject[i]);
      if (i == j - 1) {
        break;
      }
      localStringBuilder.append("#");
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(267582);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.c
 * JD-Core Version:    0.7.0.1
 */