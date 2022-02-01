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
  private List<String> HFA;
  private List<String> HFB;
  private List<String> HFC;
  private HashMap<String, Integer> HFD;
  public int HFq;
  public int HFr;
  public int HFs;
  private int HFt;
  private int HFu;
  private int HFv;
  private int HFw;
  private int HFx;
  private List<String> HFy;
  private List<String> HFz;
  private int scene;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.HFy = new ArrayList(9);
    this.HFz = new ArrayList(9);
    this.HFA = new ArrayList(9);
    this.HFB = new ArrayList(9);
    this.HFC = new ArrayList(9);
    this.HFD = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public final void aEO(String paramString)
  {
    AppMethodBeat.i(289250);
    Log.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      this.HFy.remove(paramString);
      this.HFz.remove(paramString);
      this.HFA.remove(paramString);
      this.HFB.remove(paramString);
      this.HFC.remove(paramString);
      this.HFD.remove(paramString);
    }
    AppMethodBeat.o(289250);
  }
  
  public final void au(String paramString, int paramInt1, int paramInt2)
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
    if (this.HFy.contains(paramString))
    {
      this.HFy.remove(paramString);
      Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.HFD.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.HFz.contains(paramString))
      {
        this.HFz.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.HFA.contains(paramString))
      {
        this.HFA.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.HFB.contains(paramString))
      {
        this.HFB.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.HFC.contains(paramString)) {
          break;
        }
        this.HFC.remove(paramString);
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
      this.HFD.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.HFy.add(paramString);
      continue;
      this.HFz.add(paramString);
      continue;
      this.HFA.add(paramString);
      continue;
      this.HFB.add(paramString);
      continue;
      this.HFC.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.HFt = this.HFy.size();
    this.HFu = this.HFz.size();
    this.HFv = this.HFA.size();
    this.HFw = this.HFB.size();
    this.HFx = this.HFC.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.HFD.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    Log.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    h.OAn.b(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.HFq), Integer.valueOf(this.HFr), Integer.valueOf(this.HFs), Integer.valueOf(this.HFt), Integer.valueOf(this.HFu), Integer.valueOf(this.HFv), Integer.valueOf(this.HFw), Integer.valueOf(this.HFx), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.HFq = 0;
    this.HFr = 0;
    this.HFs = 0;
    this.HFt = 0;
    this.HFu = 0;
    this.HFv = 0;
    this.HFw = 0;
    this.HFx = 0;
    this.HFy.clear();
    this.HFz.clear();
    this.HFA.clear();
    this.HFB.clear();
    this.HFC.clear();
    this.HFD.clear();
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
    public static a HFE;
    
    static
    {
      AppMethodBeat.i(111225);
      HFE = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */