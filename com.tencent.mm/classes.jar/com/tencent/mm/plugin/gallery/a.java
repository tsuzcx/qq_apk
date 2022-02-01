package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
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
  private int scene;
  public int tFm;
  public int tFn;
  public int tFo;
  private int tFp;
  private int tFq;
  private int tFr;
  private int tFs;
  private int tFt;
  public List<String> tFu;
  public List<String> tFv;
  public List<String> tFw;
  public List<String> tFx;
  public List<String> tFy;
  public HashMap<String, Integer> tFz;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.tFu = new ArrayList(9);
    this.tFv = new ArrayList(9);
    this.tFw = new ArrayList(9);
    this.tFx = new ArrayList(9);
    this.tFy = new ArrayList(9);
    this.tFz = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public final void ai(String paramString, int paramInt1, int paramInt2)
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
    if (this.tFu.contains(paramString))
    {
      this.tFu.remove(paramString);
      ad.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.tFz.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.tFv.contains(paramString))
      {
        this.tFv.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.tFw.contains(paramString))
      {
        this.tFw.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.tFx.contains(paramString))
      {
        this.tFx.remove(paramString);
        ad.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.tFy.contains(paramString)) {
          break;
        }
        this.tFy.remove(paramString);
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
      this.tFz.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.tFu.add(paramString);
      continue;
      this.tFv.add(paramString);
      continue;
      this.tFw.add(paramString);
      continue;
      this.tFx.add(paramString);
      continue;
      this.tFy.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.tFp = this.tFu.size();
    this.tFq = this.tFv.size();
    this.tFr = this.tFw.size();
    this.tFs = this.tFx.size();
    this.tFt = this.tFy.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.tFz.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    ad.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    g.yhR.f(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.tFm), Integer.valueOf(this.tFn), Integer.valueOf(this.tFo), Integer.valueOf(this.tFp), Integer.valueOf(this.tFq), Integer.valueOf(this.tFr), Integer.valueOf(this.tFs), Integer.valueOf(this.tFt), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.tFm = 0;
    this.tFn = 0;
    this.tFo = 0;
    this.tFp = 0;
    this.tFq = 0;
    this.tFr = 0;
    this.tFs = 0;
    this.tFt = 0;
    this.tFu.clear();
    this.tFv.clear();
    this.tFw.clear();
    this.tFx.clear();
    this.tFy.clear();
    this.tFz.clear();
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
    public static a tFA;
    
    static
    {
      AppMethodBeat.i(111225);
      tFA = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */