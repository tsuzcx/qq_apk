package com.tencent.mm.plugin.fts.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import java.util.HashSet;
import java.util.LinkedList;

public abstract interface n
  extends com.tencent.mm.kernel.b.d
{
  public abstract void addSOSHistory(String paramString1, String paramString2);
  
  public abstract void cancelSearchTask(a parama);
  
  public abstract e createFTSUIUnit(int paramInt1, Context paramContext, e.b paramb, int paramInt2);
  
  public abstract LinkedList<e> createFTSUIUnitList(HashSet<Integer> paramHashSet, Context paramContext, e.b paramb, int paramInt);
  
  public abstract void deleteSOSHistory();
  
  public abstract void deleteSOSHistory(String paramString);
  
  public abstract c getFTSImageLoader();
  
  public abstract h getFTSIndexDB();
  
  public abstract i getFTSIndexStorage(int paramInt);
  
  public abstract j getFTSMainDB();
  
  public abstract m getFTSTaskDaemon();
  
  public abstract b getItemClickHandler(int paramInt);
  
  public abstract boolean isFTSContextReady();
  
  public abstract boolean isFTSIndexReady();
  
  public abstract void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d paramd);
  
  public abstract void registerIndexStorage(i parami);
  
  public abstract void registerItemClickHandler(int paramInt, b paramb);
  
  public abstract void registerNativeLogic(int paramInt, k paramk);
  
  public abstract a search(int paramInt, com.tencent.mm.plugin.fts.a.a.j paramj);
  
  public abstract int stringCompareUtfBinary(String paramString1, String paramString2);
  
  public abstract void unregisterFTSUILogic(int paramInt);
  
  public abstract void unregisterIndexStorage(int paramInt);
  
  public abstract void unregisterItemClickHandler(int paramInt);
  
  public abstract void unregisterNativeLogic(int paramInt);
  
  public abstract void updateTopHitsRank(String paramString, com.tencent.mm.plugin.fts.a.a.m paramm, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.n
 * JD-Core Version:    0.7.0.1
 */