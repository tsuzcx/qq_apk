package com.tencent.mm.plugin.fts.a;

import android.content.Context;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import java.util.HashSet;
import java.util.LinkedList;

public abstract interface n
  extends a
{
  public abstract void addSOSHistory(String paramString1, String paramString2);
  
  public abstract void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.c paramc);
  
  public abstract e createFTSUIUnit(int paramInt1, Context paramContext, e.b paramb, int paramInt2);
  
  public abstract LinkedList<e> createFTSUIUnitList(HashSet<Integer> paramHashSet, Context paramContext, e.b paramb, int paramInt);
  
  public abstract void deleteSOSHistory();
  
  public abstract void deleteSOSHistory(String paramString);
  
  public abstract com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader();
  
  public abstract h getFTSIndexDB();
  
  public abstract i getFTSIndexStorage(int paramInt);
  
  public abstract j getFTSMainDB();
  
  public abstract m getFTSTaskDaemon();
  
  public abstract b getItemClickHandler(int paramInt);
  
  public abstract boolean isFTSContextReady();
  
  public abstract void registerFTSUILogic(d paramd);
  
  public abstract void registerIndexStorage(i parami);
  
  public abstract void registerItemClickHandler(int paramInt, b paramb);
  
  public abstract void registerNativeLogic(int paramInt, k paramk);
  
  public abstract com.tencent.mm.plugin.fts.a.a.c search(int paramInt, l paraml);
  
  public abstract int stringCompareUtfBinary(String paramString1, String paramString2);
  
  public abstract void unregisterFTSUILogic(int paramInt);
  
  public abstract void unregisterIndexStorage(int paramInt);
  
  public abstract void unregisterItemClickHandler(int paramInt);
  
  public abstract void unregisterNativeLogic(int paramInt);
  
  public abstract void updateTopHitsRank(String paramString, o paramo, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.n
 * JD-Core Version:    0.7.0.1
 */