package com.tencent.mm.plugin.finder.live.model;

import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "", "()V", "MAX_MUSIC_SIZE", "", "getMAX_MUSIC_SIZE", "()I", "setMAX_MUSIC_SIZE", "(I)V", "UPDATE_SIZE", "getUPDATE_SIZE", "setUPDATE_SIZE", "curPlayPos", "getCurPlayPos", "setCurPlayPos", "lastSearchBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastSearchBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastSearchBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "musicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "getMusicList", "()Ljava/util/ArrayList;", "setMusicList", "(Ljava/util/ArrayList;)V", "prepareSongIdList", "Ljava/util/LinkedList;", "getPrepareSongIdList", "()Ljava/util/LinkedList;", "setPrepareSongIdList", "(Ljava/util/LinkedList;)V", "queryContent", "", "getQueryContent", "()Ljava/lang/String;", "setQueryContent", "(Ljava/lang/String;)V", "searchContinueFlag", "getSearchContinueFlag", "setSearchContinueFlag", "searchList", "getSearchList", "setSearchList", "songIdList", "getSongIdList", "setSongIdList", "addMusicItem", "", "item", "index", "canAddMusic", "", "deleteMusicItem", "findMusicItem", "Lkotlin/Pair;", "songId", "findNextMusicItem", "musicItem", "pos", "getCurMusicItem", "getCurSongId", "getModifyMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "getUpdateSongIdList", "loadAll", "initSongId", "liveStatus", "isMusicInfoComplete", "pauseMusicItem", "playMusicItem", "replaceAnchorMusicData", "resetMusicItem", "resetSelectMusicItems", "resumeMusicItem", "savePrepareSongIdList", "stopMusicItem", "updateMusicInfo", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "updateSearchMusicData", "query", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "Companion", "plugin-finder-base_release"})
public final class b
{
  public static final a ydn;
  public int fFw;
  public int yde;
  private int ydf;
  public LinkedList<Integer> ydg;
  public LinkedList<Integer> ydh;
  public ArrayList<aq> ydi;
  public ArrayList<aq> ydj;
  public String ydk;
  public com.tencent.mm.cd.b ydl;
  public int ydm;
  
  static
  {
    AppMethodBeat.i(262178);
    ydn = new a((byte)0);
    AppMethodBeat.o(262178);
  }
  
  public b()
  {
    AppMethodBeat.i(262177);
    a locala = a.Zlt;
    this.yde = ((Number)a.ilr().aSr()).intValue();
    this.ydf = 50;
    this.ydg = new LinkedList();
    this.fFw = -1;
    this.ydh = new LinkedList();
    this.ydi = new ArrayList();
    this.ydj = new ArrayList();
    this.ydk = "";
    AppMethodBeat.o(262177);
  }
  
  public final o<aq, Integer> Nm(int paramInt)
  {
    AppMethodBeat.i(262169);
    Object localObject1 = (Iterable)this.ydi;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        localObject2 = (aq)localObject2;
        if (((aq)localObject2).yin.SMT == paramInt)
        {
          localObject1 = new o(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(262169);
          return localObject1;
        }
      }
      else
      {
        localObject1 = new o(null, Integer.valueOf(-1));
        AppMethodBeat.o(262169);
        return localObject1;
      }
      i += 1;
    }
  }
  
  public final void a(ayq paramayq)
  {
    AppMethodBeat.i(262165);
    p.k(paramayq, "resp");
    Object localObject1;
    Object localObject2;
    try
    {
      paramayq = paramayq.SKG;
      if (paramayq == null) {
        break label382;
      }
      localObject1 = (Iterable)paramayq;
      paramayq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbg)((Iterator)localObject1).next();
        p.j(localObject2, "it");
        paramayq.add(new aq((bbg)localObject2, 0, 0, 24));
      }
      paramayq = (List)paramayq;
    }
    catch (Exception paramayq)
    {
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "updateMusicInfo", false, false, null, 28);
      localObject1 = ak.AGL;
      ak.a(paramayq, "FinderLiveAnchorMusicData updateMusicInfo");
      AppMethodBeat.o(262165);
      return;
    }
    label187:
    int i;
    if (paramayq != null)
    {
      localObject1 = (aq)j.lp(paramayq);
      if (localObject1 != null)
      {
        localObject1 = ((aq)localObject1).yin;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((bbg)localObject1).SMT);
          i = dxO();
          localObject2 = ((Iterable)((b)this).ydi).iterator();
          int j;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            j = ((aq)((Iterator)localObject2).next()).yin.SMT;
          } while ((localObject1 == null) || (j != ((Integer)localObject1).intValue()));
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (paramayq != null)) {
        this.ydi.addAll((Collection)paramayq);
      }
      localObject1 = new StringBuilder("updateMusicInfo respMusicInfo.first songId:").append(localObject1).append(", cur songId:").append(i).append(", songIdExist:").append(bool).append(", curPlayPos:").append(this.fFw).append(", size:");
      paramayq = this.ydh;
      if (paramayq != null) {}
      for (paramayq = Integer.valueOf(paramayq.size());; paramayq = null)
      {
        Log.i("FinderLiveAnchorMusicData", paramayq.intValue());
        a.c(this.ydi, "updateMusicInfo", false);
        AppMethodBeat.o(262165);
        return;
        label382:
        paramayq = null;
        break;
        localObject1 = null;
        break label187;
      }
    }
  }
  
  public final void a(String paramString, bcl parambcl)
  {
    Object localObject2 = null;
    AppMethodBeat.i(262174);
    p.k(paramString, "query");
    p.k(parambcl, "resp");
    int i;
    Object localObject3;
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if ((i != 0) || (!p.h(paramString, this.ydk)))
      {
        this.ydj.clear();
        this.ydk = paramString;
      }
      localObject1 = parambcl.SKG;
      if (localObject1 != null)
      {
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    else
    {
      label103:
      Object localObject4;
      label164:
      label197:
      label200:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label202;
        }
        localObject4 = ((Iterator)localObject3).next();
        Object localObject5 = (bbg)localObject4;
        if (((bbg)localObject5).playable)
        {
          localObject5 = (CharSequence)((bbg)localObject5).SMZ;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label197;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label200;
          }
          ((Collection)localObject1).add(localObject4);
          break label103;
          i = 0;
          break;
          i = 0;
          break label164;
        }
      }
      label202:
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bbg)((Iterator)localObject3).next();
        p.j(localObject4, "it");
        if (this.ydh.contains(Integer.valueOf(((bbg)localObject4).SMT))) {}
        for (i = 51;; i = 0)
        {
          ((Collection)localObject1).add(new aq((bbg)localObject4, i, 0, 24));
          break;
        }
      }
    }
    for (Object localObject1 = (List)localObject1;; localObject1 = null)
    {
      localObject3 = new StringBuilder("updateSearchMusicData last query:").append(this.ydk).append(", new query:").append(paramString).append(", size:");
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = Integer.valueOf(((List)localObject1).size());
      }
      Log.i("FinderLiveAnchorMusicData", paramString);
      if (localObject1 != null) {
        this.ydj.addAll((Collection)localObject1);
      }
      this.ydl = parambcl.SDI;
      this.ydm = parambcl.xFI;
      AppMethodBeat.o(262174);
      return;
    }
  }
  
  public final void ak(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(262156);
    StringBuilder localStringBuilder = new StringBuilder("savePrepareSongIdList size:");
    if (paramLinkedList != null) {}
    for (Integer localInteger = Integer.valueOf(paramLinkedList.size());; localInteger = null)
    {
      Log.i("FinderLiveAnchorMusicData", localInteger + ", curPlayPos:" + this.fFw);
      if (paramLinkedList != null) {
        break;
      }
      AppMethodBeat.o(262156);
      return;
    }
    this.ydg = paramLinkedList;
    AppMethodBeat.o(262156);
  }
  
  public final void c(aq paramaq, int paramInt)
  {
    AppMethodBeat.i(262168);
    if (paramaq != null) {
      paramaq.mfx = 0;
    }
    Log.i("FinderLiveAnchorMusicData", "resetMusicItem " + paramaq + " songId size:" + this.ydh.size() + ", musicList id size:" + this.ydi.size() + ", pos:" + paramInt + ", curPlayPos:" + this.fFw);
    AppMethodBeat.o(262168);
  }
  
  public final o<aq, Integer> d(aq paramaq, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(262170);
    p.k(paramaq, "musicItem");
    c(paramaq, paramInt);
    paramaq = (Collection)this.ydi;
    if ((paramaq == null) || (paramaq.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("FinderLiveAnchorMusicData", "musicList is empty!");
      paramaq = new o(null, Integer.valueOf(-1));
      AppMethodBeat.o(262170);
      return paramaq;
    }
    i = paramInt + 1;
    if (i >= this.ydi.size()) {
      i = j;
    }
    for (;;)
    {
      paramaq = this.ydi.get(i);
      p.j(paramaq, "musicList[nextPos]");
      paramaq = (aq)paramaq;
      Log.i("FinderLiveAnchorMusicData", "songId size:" + this.ydh.size() + ", musicList id size:" + this.ydi.size() + ", findNextMusicItem pos:" + paramInt + ", nextPos:" + i + ", curPlayPos:" + this.fFw + ",nextMusicItem:" + paramaq);
      paramaq = new o(paramaq, Integer.valueOf(i));
      AppMethodBeat.o(262170);
      return paramaq;
    }
  }
  
  public final aq dxN()
  {
    AppMethodBeat.i(262160);
    if ((this.fFw >= 0) && (this.fFw < this.ydi.size()))
    {
      aq localaq = (aq)this.ydi.get(this.fFw);
      AppMethodBeat.o(262160);
      return localaq;
    }
    AppMethodBeat.o(262160);
    return null;
  }
  
  public final int dxO()
  {
    AppMethodBeat.i(262162);
    if ((this.fFw >= 0) && (this.fFw < this.ydh.size()))
    {
      Object localObject = this.ydh.get(this.fFw);
      p.j(localObject, "songIdList[curPlayPos]");
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(262162);
      return i;
    }
    AppMethodBeat.o(262162);
    return 0;
  }
  
  public final void dxP()
  {
    AppMethodBeat.i(262166);
    Iterator localIterator = ((Iterable)this.ydi).iterator();
    while (localIterator.hasNext()) {
      ((aq)localIterator.next()).yip = false;
    }
    AppMethodBeat.o(262166);
  }
  
  public final ayk dxQ()
  {
    AppMethodBeat.i(262171);
    ayk localayk = new ayk();
    localayk.SKz = this.ydh;
    AppMethodBeat.o(262171);
    return localayk;
  }
  
  public final boolean dxR()
  {
    AppMethodBeat.i(262176);
    Log.i("FinderLiveAnchorMusicData", "isMusicInfoComplete musicSize:" + this.ydi.size() + ", songIdSize:" + this.ydh.size());
    if (this.ydi.size() == this.ydh.size())
    {
      AppMethodBeat.o(262176);
      return true;
    }
    AppMethodBeat.o(262176);
    return false;
  }
  
  public final void f(LinkedList<Integer> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(262158);
    StringBuilder localStringBuilder = new StringBuilder("initSongId liveStatus:").append(paramInt).append(", size:");
    if (paramLinkedList != null) {}
    for (Integer localInteger = Integer.valueOf(paramLinkedList.size());; localInteger = null)
    {
      Log.i("FinderLiveAnchorMusicData", localInteger + ", curPlayPos:" + this.fFw);
      if (paramLinkedList != null) {
        break;
      }
      AppMethodBeat.o(262158);
      return;
    }
    this.ydh = paramLinkedList;
    AppMethodBeat.o(262158);
  }
  
  public final LinkedList<Integer> oI(boolean paramBoolean)
  {
    AppMethodBeat.i(262163);
    int i = this.ydh.size();
    int j = this.ydi.size();
    i -= j;
    if (i <= 0)
    {
      AppMethodBeat.o(262163);
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList((Collection)this.ydh.subList(j, i + j));
      AppMethodBeat.o(262163);
      return localLinkedList;
      i = i.ow(this.ydf, i);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData$Companion;", "", "()V", "TAG", "", "printInfo", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "tag", "briefPrint", "", "plugin-finder-base_release"})
  public static final class a
  {
    public static void c(ArrayList<aq> paramArrayList, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(262054);
      p.k(paramArrayList, "list");
      p.k(paramString, "tag");
      paramString = new StringBuilder(paramString + ':');
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        paramArrayList = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        paramArrayList = (aq)paramArrayList;
        paramString.append("[第" + i + "首:");
        if (paramBoolean) {}
        for (paramArrayList = paramArrayList.yin.SMT + ", " + paramArrayList.mfx + ']';; paramArrayList = paramArrayList + ']')
        {
          paramString.append(paramArrayList);
          i += 1;
          break;
        }
      }
      Log.i("FinderLiveAnchorMusicData", paramString.toString());
      AppMethodBeat.o(262054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.b
 * JD-Core Version:    0.7.0.1
 */