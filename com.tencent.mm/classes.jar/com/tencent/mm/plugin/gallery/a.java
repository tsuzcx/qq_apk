package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public int sIB;
  public int sIC;
  public int sID;
  private int sIE;
  private int sIF;
  private int sIG;
  private int sIH;
  private int sII;
  public List<String> sIJ;
  public List<String> sIK;
  public List<String> sIL;
  public List<String> sIM;
  public List<String> sIN;
  public HashMap<String, Integer> sIO;
  private int scene;
  
  private a()
  {
    AppMethodBeat.i(111226);
    this.sIJ = new ArrayList(9);
    this.sIK = new ArrayList(9);
    this.sIL = new ArrayList(9);
    this.sIM = new ArrayList(9);
    this.sIN = new ArrayList(9);
    this.sIO = new HashMap(9);
    AppMethodBeat.o(111226);
  }
  
  public final void ae(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(173726);
    if ((paramInt1 < 0) || (paramInt1 > 4))
    {
      ac.e("MicroMsg.GalleryReporter", "type error, %d.", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(173726);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.GalleryReporter", "path is invalid!");
      AppMethodBeat.o(173726);
      return;
    }
    ac.i("MicroMsg.GalleryReporter", "type: %d, path: %s.", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (this.sIJ.contains(paramString))
    {
      this.sIJ.remove(paramString);
      ac.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        this.sIO.remove(paramString);
      }
      AppMethodBeat.o(173726);
      return;
      if (this.sIK.contains(paramString))
      {
        this.sIK.remove(paramString);
        ac.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
        paramInt1 = i;
      }
      else if (this.sIL.contains(paramString))
      {
        this.sIL.remove(paramString);
        ac.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
        paramInt1 = i;
      }
      else if (this.sIM.contains(paramString))
      {
        this.sIM.remove(paramString);
        ac.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
        paramInt1 = i;
      }
      else
      {
        if (!this.sIN.contains(paramString)) {
          break;
        }
        this.sIN.remove(paramString);
        ac.i("MicroMsg.GalleryReporter", "sendCountFromOtherList, remove.");
        paramInt1 = i;
      }
    }
    ac.i("MicroMsg.GalleryReporter", "add!!!");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.sIO.put(paramString, Integer.valueOf(paramInt2));
      paramInt1 = 0;
      break;
      this.sIJ.add(paramString);
      continue;
      this.sIK.add(paramString);
      continue;
      this.sIL.add(paramString);
      continue;
      this.sIM.add(paramString);
      continue;
      this.sIN.add(paramString);
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(173728);
    this.sIE = this.sIJ.size();
    this.sIF = this.sIK.size();
    this.sIG = this.sIL.size();
    this.sIH = this.sIM.size();
    this.sII = this.sIN.size();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.sIO.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Map.Entry)localIterator.next()).getValue()).append("|");
    }
    ac.d("MicroMsg.GalleryReporter", "poiStr: %s.", new Object[] { localStringBuilder });
    h.wUl.f(18077, new Object[] { Integer.valueOf(this.scene), Integer.valueOf(this.sIB), Integer.valueOf(this.sIC), Integer.valueOf(this.sID), Integer.valueOf(this.sIE), Integer.valueOf(this.sIF), Integer.valueOf(this.sIG), Integer.valueOf(this.sIH), Integer.valueOf(this.sII), localStringBuilder });
    reset();
    AppMethodBeat.o(173728);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(173727);
    this.scene = 0;
    this.sIB = 0;
    this.sIC = 0;
    this.sID = 0;
    this.sIE = 0;
    this.sIF = 0;
    this.sIG = 0;
    this.sIH = 0;
    this.sII = 0;
    this.sIJ.clear();
    this.sIK.clear();
    this.sIL.clear();
    this.sIM.clear();
    this.sIN.clear();
    this.sIO.clear();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a
 * JD-Core Version:    0.7.0.1
 */