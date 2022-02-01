package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private int scene;
  public int tQd;
  public int tQe;
  public int tQf;
  private int tQg;
  private int tQh;
  private int tQi;
  private int tQj;
  private int tQk;
  public List<String> tQl;
  public List<String> tQm;
  public List<String> tQn;
  public List<String> tQo;
  public List<String> tQp;
  public HashMap<String, Integer> tQq;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.tQl = new ArrayList(9);
    this.tQm = new ArrayList(9);
    this.tQn = new ArrayList(9);
    this.tQo = new ArrayList(9);
    this.tQp = new ArrayList(9);
    this.tQq = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public final void ai(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(173726);
    if ((paramInt1 < 0) || (paramInt1 > 4))
    {
      ae.e("MicroMsg.GalleryReporter", "type error, %d.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(173726);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.GalleryReporter", "path is invalid!");
      AppMethodBeat.o(173726);
      return;
    }
    ae.i("MicroMsg.GalleryReporter", "type: %d, path: %s.", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (this.tQl.contains(paramString))
    {
      this.tQl.remove(paramString);
      ae.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.tQq.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.tQm.contains(paramString))
      {
        this.tQm.remove(paramString);
        ae.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.tQn.contains(paramString))
      {
        this.tQn.remove(paramString);
        ae.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.tQo.contains(paramString))
      {
        this.tQo.remove(paramString);
        ae.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.tQp.contains(paramString)) {
          break;
        }
        this.tQp.remove(paramString);
        ae.i("MicroMsg.GalleryReporter", "sendCountFromOtherList, remove.");
        paramInt1 = i;
      }
    }
    ae.i("MicroMsg.GalleryReporter", "add!!!");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.tQq.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.tQl.add(paramString);
      continue;
      this.tQm.add(paramString);
      continue;
      this.tQn.add(paramString);
      continue;
      this.tQo.add(paramString);
      continue;
      this.tQp.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.tQg = this.tQl.size();
    this.tQh = this.tQm.size();
    this.tQi = this.tQn.size();
    this.tQj = this.tQo.size();
    this.tQk = this.tQp.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.tQq.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    ae.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    g.yxI.f(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.tQd), Integer.valueOf(this.tQe), Integer.valueOf(this.tQf), Integer.valueOf(this.tQg), Integer.valueOf(this.tQh), Integer.valueOf(this.tQi), Integer.valueOf(this.tQj), Integer.valueOf(this.tQk), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.tQd = 0;
    this.tQe = 0;
    this.tQf = 0;
    this.tQg = 0;
    this.tQh = 0;
    this.tQi = 0;
    this.tQj = 0;
    this.tQk = 0;
    this.tQl.clear();
    this.tQm.clear();
    this.tQn.clear();
    this.tQo.clear();
    this.tQp.clear();
    this.tQq.clear();
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
    public static a tQr;
    
    static
    {
      AppMethodBeat.i(111225);
      tQr = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */