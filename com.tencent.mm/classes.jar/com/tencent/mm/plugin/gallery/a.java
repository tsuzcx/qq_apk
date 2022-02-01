package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public int rzJ;
  public int rzK;
  public int rzL;
  private int rzM;
  private int rzN;
  private int rzO;
  private int rzP;
  private int rzQ;
  public List<String> rzR;
  public List<String> rzS;
  public List<String> rzT;
  public List<String> rzU;
  public List<String> rzV;
  public HashMap<String, Integer> rzW;
  private int scene;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.rzR = new ArrayList(9);
    this.rzS = new ArrayList(9);
    this.rzT = new ArrayList(9);
    this.rzU = new ArrayList(9);
    this.rzV = new ArrayList(9);
    this.rzW = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public final void af(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(173726);
    if ((paramInt1 < 0) || (paramInt1 > 4))
    {
      ad.e("MicroMsg.GalleryReporter", "type error, %d.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(173726);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.GalleryReporter", "path is invalid!");
      AppMethodBeat.o(173726);
      return;
    }
    ad.i("MicroMsg.GalleryReporter", "type: %d, path: %s.", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (this.rzR.contains(paramString))
    {
      this.rzR.remove(paramString);
      ad.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.rzW.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.rzS.contains(paramString))
      {
        this.rzS.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.rzT.contains(paramString))
      {
        this.rzT.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.rzU.contains(paramString))
      {
        this.rzU.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.rzV.contains(paramString)) {
          break;
        }
        this.rzV.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromOtherList, remove.");
        paramInt1 = i;
      }
    }
    ad.i("MicroMsg.GalleryReporter", "add!!!");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.rzW.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.rzR.add(paramString);
      continue;
      this.rzS.add(paramString);
      continue;
      this.rzT.add(paramString);
      continue;
      this.rzU.add(paramString);
      continue;
      this.rzV.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.rzM = this.rzR.size();
    this.rzN = this.rzS.size();
    this.rzO = this.rzT.size();
    this.rzP = this.rzU.size();
    this.rzQ = this.rzV.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.rzW.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    ad.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    h.vKh.f(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.rzJ), Integer.valueOf(this.rzK), Integer.valueOf(this.rzL), Integer.valueOf(this.rzM), Integer.valueOf(this.rzN), Integer.valueOf(this.rzO), Integer.valueOf(this.rzP), Integer.valueOf(this.rzQ), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.rzJ = 0;
    this.rzK = 0;
    this.rzL = 0;
    this.rzM = 0;
    this.rzN = 0;
    this.rzO = 0;
    this.rzP = 0;
    this.rzQ = 0;
    this.rzR.clear();
    this.rzS.clear();
    this.rzT.clear();
    this.rzU.clear();
    this.rzV.clear();
    this.rzW.clear();
    AppMethodBeat.o(173727);
  }
  
  public final void setScene(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 15: 
    case 23: 
    default: 
      this.scene = paramInt;
      return;
    case 4: 
      this.scene = 2;
      return;
    case 7: 
    case 8: 
      this.scene = 3;
      return;
    case 17: 
      this.scene = 5;
      return;
    case 13: 
      this.scene = 6;
      return;
    case 14: 
    case 22: 
      this.scene = 8;
      return;
    case 18: 
      this.scene = 9;
      return;
    case 16: 
      this.scene = 10;
      return;
    case 5: 
      this.scene = 11;
      return;
    case 11: 
      this.scene = 12;
      return;
    case 19: 
      this.scene = 13;
      return;
    case 20: 
      this.scene = 14;
      return;
    case 21: 
      this.scene = 15;
      return;
    }
    this.scene = 16;
  }
  
  public static final class a
  {
    public static a rzX;
    
    static
    {
      AppMethodBeat.i(111225);
      rzX = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */