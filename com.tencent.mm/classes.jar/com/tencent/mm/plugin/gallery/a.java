package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public int BTD;
  public int BTE;
  public int BTF;
  private int BTG;
  private int BTH;
  private int BTI;
  private int BTJ;
  private int BTK;
  private List<String> BTL;
  private List<String> BTM;
  private List<String> BTN;
  private List<String> BTO;
  private List<String> BTP;
  private HashMap<String, Integer> BTQ;
  private int scene;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.BTL = new ArrayList(9);
    this.BTM = new ArrayList(9);
    this.BTN = new ArrayList(9);
    this.BTO = new ArrayList(9);
    this.BTP = new ArrayList(9);
    this.BTQ = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public static a esQ()
  {
    return a.BTR;
  }
  
  public final void aIo(String paramString)
  {
    AppMethodBeat.i(243476);
    Log.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      this.BTL.remove(paramString);
      this.BTM.remove(paramString);
      this.BTN.remove(paramString);
      this.BTO.remove(paramString);
      this.BTP.remove(paramString);
      this.BTQ.remove(paramString);
    }
    AppMethodBeat.o(243476);
  }
  
  public final void an(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(173726);
    if ((paramInt1 < 0) || (paramInt1 > 4))
    {
      Log.e("MicroMsg.GalleryReporter", "type error, %d.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(173726);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GalleryReporter", "path is invalid!");
      AppMethodBeat.o(173726);
      return;
    }
    Log.i("MicroMsg.GalleryReporter", "type: %d, path: %s.", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (this.BTL.contains(paramString))
    {
      this.BTL.remove(paramString);
      Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.BTQ.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.BTM.contains(paramString))
      {
        this.BTM.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.BTN.contains(paramString))
      {
        this.BTN.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.BTO.contains(paramString))
      {
        this.BTO.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.BTP.contains(paramString)) {
          break;
        }
        this.BTP.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromOtherList, remove.");
        paramInt1 = i;
      }
    }
    Log.i("MicroMsg.GalleryReporter", "add!!!");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.BTQ.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.BTL.add(paramString);
      continue;
      this.BTM.add(paramString);
      continue;
      this.BTN.add(paramString);
      continue;
      this.BTO.add(paramString);
      continue;
      this.BTP.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.BTG = this.BTL.size();
    this.BTH = this.BTM.size();
    this.BTI = this.BTN.size();
    this.BTJ = this.BTO.size();
    this.BTK = this.BTP.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.BTQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    Log.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    h.IzE.a(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.BTD), Integer.valueOf(this.BTE), Integer.valueOf(this.BTF), Integer.valueOf(this.BTG), Integer.valueOf(this.BTH), Integer.valueOf(this.BTI), Integer.valueOf(this.BTJ), Integer.valueOf(this.BTK), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.BTD = 0;
    this.BTE = 0;
    this.BTF = 0;
    this.BTG = 0;
    this.BTH = 0;
    this.BTI = 0;
    this.BTJ = 0;
    this.BTK = 0;
    this.BTL.clear();
    this.BTM.clear();
    this.BTN.clear();
    this.BTO.clear();
    this.BTP.clear();
    this.BTQ.clear();
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
    public static a BTR;
    
    static
    {
      AppMethodBeat.i(111225);
      BTR = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */