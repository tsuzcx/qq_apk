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
  private int scene;
  public List<String> xhA;
  public List<String> xhB;
  public List<String> xhC;
  public HashMap<String, Integer> xhD;
  public int xhq;
  public int xhr;
  public int xhs;
  private int xht;
  private int xhu;
  private int xhv;
  private int xhw;
  private int xhx;
  public List<String> xhy;
  public List<String> xhz;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.xhy = new ArrayList(9);
    this.xhz = new ArrayList(9);
    this.xhA = new ArrayList(9);
    this.xhB = new ArrayList(9);
    this.xhC = new ArrayList(9);
    this.xhD = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public static a dQq()
  {
    return a.xhE;
  }
  
  public final void al(String paramString, int paramInt1, int paramInt2)
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
    if (this.xhy.contains(paramString))
    {
      this.xhy.remove(paramString);
      Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.xhD.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.xhz.contains(paramString))
      {
        this.xhz.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.xhA.contains(paramString))
      {
        this.xhA.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.xhB.contains(paramString))
      {
        this.xhB.remove(paramString);
        Log.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.xhC.contains(paramString)) {
          break;
        }
        this.xhC.remove(paramString);
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
      this.xhD.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.xhy.add(paramString);
      continue;
      this.xhz.add(paramString);
      continue;
      this.xhA.add(paramString);
      continue;
      this.xhB.add(paramString);
      continue;
      this.xhC.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.xht = this.xhy.size();
    this.xhu = this.xhz.size();
    this.xhv = this.xhA.size();
    this.xhw = this.xhB.size();
    this.xhx = this.xhC.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.xhD.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    Log.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    h.CyF.a(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.xhq), Integer.valueOf(this.xhr), Integer.valueOf(this.xhs), Integer.valueOf(this.xht), Integer.valueOf(this.xhu), Integer.valueOf(this.xhv), Integer.valueOf(this.xhw), Integer.valueOf(this.xhx), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.xhq = 0;
    this.xhr = 0;
    this.xhs = 0;
    this.xht = 0;
    this.xhu = 0;
    this.xhv = 0;
    this.xhw = 0;
    this.xhx = 0;
    this.xhy.clear();
    this.xhz.clear();
    this.xhA.clear();
    this.xhB.clear();
    this.xhC.clear();
    this.xhD.clear();
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
    public static a xhE;
    
    static
    {
      AppMethodBeat.i(111225);
      xhE = new a((byte)0);
      AppMethodBeat.o(111225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */