package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements Cloneable, Iterable<f>
{
  private HashMap<String, ar> leV;
  protected HashMap<String, ar> leW;
  public boolean leX;
  protected ArrayList<f> mItemList;
  
  public c()
  {
    AppMethodBeat.i(52780);
    this.leV = new HashMap();
    this.leW = new HashMap();
    this.leX = r.ZA();
    AppMethodBeat.o(52780);
  }
  
  public c(e parame) {}
  
  public c(List<f> paramList)
  {
    this();
    AppMethodBeat.i(52781);
    if (paramList == null)
    {
      AppMethodBeat.o(52781);
      return;
    }
    this.mItemList = new ArrayList();
    this.mItemList.addAll(paramList);
    AppMethodBeat.o(52781);
  }
  
  public final f Kj(String paramString)
  {
    AppMethodBeat.i(52784);
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        EmotionSummary localEmotionSummary = localf.lfa;
        if ((localEmotionSummary != null) && (localEmotionSummary.ProductID != null) && (localEmotionSummary.ProductID.equals(paramString)))
        {
          AppMethodBeat.o(52784);
          return localf;
        }
      }
    }
    AppMethodBeat.o(52784);
    return null;
  }
  
  public final void Kk(String paramString)
  {
    AppMethodBeat.i(52787);
    f localf = Kj(paramString);
    if (localf == null)
    {
      AppMethodBeat.o(52787);
      return;
    }
    localf.setStatus(-1);
    localf.a(this.leX, Kn(paramString), Kl(paramString));
    AppMethodBeat.o(52787);
  }
  
  public final boolean Kl(String paramString)
  {
    AppMethodBeat.i(52788);
    if (this.leW == null)
    {
      AppMethodBeat.o(52788);
      return false;
    }
    boolean bool = this.leW.containsKey(paramString);
    AppMethodBeat.o(52788);
    return bool;
  }
  
  public final ar Km(String paramString)
  {
    AppMethodBeat.i(52789);
    ar localar2 = Kn(paramString);
    ar localar1 = localar2;
    if (localar2 == null)
    {
      localar1 = new ar(paramString);
      this.leV.put(paramString, localar1);
    }
    AppMethodBeat.o(52789);
    return localar1;
  }
  
  public final ar Kn(String paramString)
  {
    AppMethodBeat.i(52790);
    paramString = (ar)this.leV.get(paramString);
    AppMethodBeat.o(52790);
    return paramString;
  }
  
  public final void bZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(52792);
    paramString = (ar)this.leV.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(52792);
      return;
    }
    paramString.Nu(paramInt);
    AppMethodBeat.o(52792);
  }
  
  public final c bkI()
  {
    AppMethodBeat.i(52785);
    try
    {
      localc3 = (c)super.clone();
      localc1 = localc3;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      for (;;)
      {
        c localc1;
        label38:
        Object localObject = null;
      }
    }
    try
    {
      if (this.mItemList != null)
      {
        localc3.mItemList = ((ArrayList)this.mItemList.clone());
        localc1 = localc3;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      c localc2 = localc3;
      break label38;
    }
    AppMethodBeat.o(52785);
    return localc1;
  }
  
  public void bkJ()
  {
    AppMethodBeat.i(52793);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(52793);
      return;
    }
    if (i.blu().lhj == null)
    {
      AppMethodBeat.o(52793);
      return;
    }
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject2 = localf.lfa;
      if (localObject2 != null)
      {
        Object localObject1 = i.blu();
        localObject2 = ((EmotionSummary)localObject2).ProductID;
        localObject1 = (Integer)((d)localObject1).lhj.get(localObject2);
        if (localObject1 == null) {}
        for (int i = -1;; i = ((Integer)localObject1).intValue())
        {
          if (i >= 0)
          {
            localf.setStatus(6);
            localf.ym = i;
          }
          if ((i >= 0) || (localf.mStatus != 6)) {
            break;
          }
          localf.setStatus(3);
          break;
        }
      }
    }
    AppMethodBeat.o(52793);
  }
  
  public void clear()
  {
    AppMethodBeat.i(52778);
    if (this.mItemList != null)
    {
      this.mItemList.clear();
      this.mItemList = null;
    }
    if (this.leV != null)
    {
      this.leV.clear();
      this.leV = null;
    }
    if (this.leW != null)
    {
      this.leW.clear();
      this.leW = null;
    }
    AppMethodBeat.o(52778);
  }
  
  public Iterator<f> iterator()
  {
    AppMethodBeat.i(52791);
    c.a locala = new c.a(this, (byte)0);
    AppMethodBeat.o(52791);
    return locala;
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(52786);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(52786);
      return;
    }
    this.leW = i.getEmojiStorageMgr().yNo.dyY();
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.lfa;
      if (localObject != null)
      {
        if (com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject))
        {
          if (com.tencent.mm.plugin.emoji.h.a.bmI()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((EmotionSummary)localObject).ProductID;
        localf.a(this.leX, Kn((String)localObject), Kl((String)localObject));
      }
    }
    bkJ();
    AppMethodBeat.o(52786);
  }
  
  public final int size()
  {
    AppMethodBeat.i(52782);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(52782);
      return 0;
    }
    int i = this.mItemList.size();
    AppMethodBeat.o(52782);
    return i;
  }
  
  public final f un(int paramInt)
  {
    AppMethodBeat.i(52783);
    if ((this.mItemList == null) || (this.mItemList.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(52783);
      return null;
    }
    if (this.mItemList == null)
    {
      AppMethodBeat.o(52783);
      return null;
    }
    f localf = (f)this.mItemList.get(paramInt);
    AppMethodBeat.o(52783);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */