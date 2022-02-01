package com.tencent.mm.plugin.finder.live.model;

import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "", "()V", "MAX_MUSIC_SIZE", "", "getMAX_MUSIC_SIZE", "()I", "setMAX_MUSIC_SIZE", "(I)V", "UPDATE_SIZE", "getUPDATE_SIZE", "setUPDATE_SIZE", "curPlayPos", "getCurPlayPos", "setCurPlayPos", "lastSearchBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastSearchBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastSearchBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "musicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "getMusicList", "()Ljava/util/ArrayList;", "setMusicList", "(Ljava/util/ArrayList;)V", "prepareSongIdList", "Ljava/util/LinkedList;", "getPrepareSongIdList", "()Ljava/util/LinkedList;", "setPrepareSongIdList", "(Ljava/util/LinkedList;)V", "queryContent", "", "getQueryContent", "()Ljava/lang/String;", "setQueryContent", "(Ljava/lang/String;)V", "searchContinueFlag", "getSearchContinueFlag", "setSearchContinueFlag", "searchList", "getSearchList", "setSearchList", "songIdList", "getSongIdList", "setSongIdList", "addMusicItem", "", "item", "canAddMusic", "", "deleteMusicItem", "index", "findMusicItem", "Lkotlin/Pair;", "songId", "findNextMusicItem", "musicItem", "pos", "getCurMusicItem", "getCurSongId", "getModifyMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "getUpdateSongIdList", "loadAll", "initSongId", "liveStatus", "isMusicInfoComplete", "pauseMusicItem", "playMusicItem", "replaceAnchorMusicData", "resetMusicItem", "resetSelectMusicItems", "resumeMusicItem", "savePrepareSongIdList", "stopMusicItem", "updateMusicInfo", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "updateSearchMusicData", "query", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a CDC;
  public int CDD;
  private int CDE;
  public LinkedList<Integer> CDF;
  public LinkedList<Integer> CDG;
  public ArrayList<at> CDH;
  public ArrayList<at> CDI;
  public String CDJ;
  public com.tencent.mm.bx.b CDK;
  public int CDL;
  public int hKr;
  
  static
  {
    AppMethodBeat.i(359296);
    CDC = new a((byte)0);
    AppMethodBeat.o(359296);
  }
  
  public c()
  {
    AppMethodBeat.i(359277);
    a locala = a.ahiX;
    this.CDD = ((Number)a.jRS().bmg()).intValue();
    this.CDE = 50;
    this.CDF = new LinkedList();
    this.hKr = -1;
    this.CDG = new LinkedList();
    this.CDH = new ArrayList();
    this.CDI = new ArrayList();
    this.CDJ = "";
    AppMethodBeat.o(359277);
  }
  
  public final r<at, Integer> OL(int paramInt)
  {
    AppMethodBeat.i(359379);
    Object localObject1 = (Iterable)this.CDH;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (at)localObject2;
        if (((at)localObject2).CIu.ZTv == paramInt)
        {
          localObject1 = new r(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(359379);
          return localObject1;
        }
      }
      else
      {
        localObject1 = new r(null, Integer.valueOf(-1));
        AppMethodBeat.o(359379);
        return localObject1;
      }
      i += 1;
    }
  }
  
  public final void a(bfr parambfr)
  {
    AppMethodBeat.i(359345);
    s.u(parambfr, "resp");
    for (;;)
    {
      Object localObject1;
      int i;
      boolean bool;
      try
      {
        parambfr = parambfr.ZPz;
        Object localObject2;
        if (parambfr == null)
        {
          localObject1 = null;
          break label397;
          i = ekd();
          localObject2 = ((Iterable)((c)this).CDH).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label391;
          }
          int j = ((at)((Iterator)localObject2).next()).CIu.ZTv;
          if ((parambfr == null) || (j != parambfr.intValue())) {
            continue;
          }
          bool = true;
          label92:
          if ((!bool) && (localObject1 != null)) {
            this.CDH.addAll((Collection)localObject1);
          }
          localObject1 = new StringBuilder("updateMusicInfo respMusicInfo.first songId:").append(parambfr).append(", cur songId:").append(i).append(", songIdExist:").append(bool).append(", curPlayPos:").append(this.hKr).append(", size:");
          parambfr = this.CDG;
          if (parambfr == null)
          {
            parambfr = null;
            label181:
            Log.i("FinderLiveAnchorMusicData", parambfr);
            a.c(this.CDH, "updateMusicInfo", false);
            AppMethodBeat.o(359345);
          }
        }
        else
        {
          localObject1 = (Iterable)parambfr;
          parambfr = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bkh)((Iterator)localObject1).next();
            s.s(localObject2, "it");
            parambfr.add(new at((bkh)localObject2, 0, 0, 24));
            continue;
          }
          localObject1 = (List)parambfr;
        }
      }
      catch (Exception parambfr)
      {
        e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "updateMusicInfo", false, null, false, null, 60);
        localObject1 = aw.Gjk;
        aw.a(parambfr, "FinderLiveAnchorMusicData updateMusicInfo");
        AppMethodBeat.o(359345);
        return;
      }
      label391:
      label397:
      while (localObject1 != null)
      {
        parambfr = (at)p.oL((List)localObject1);
        if (parambfr == null)
        {
          parambfr = null;
          break;
        }
        parambfr = Integer.valueOf(parambfr.CIu.ZTv);
        break;
        i = parambfr.size();
        parambfr = Integer.valueOf(i);
        break label181;
        bool = false;
        break label92;
      }
      parambfr = null;
    }
  }
  
  public final void a(String paramString, bmm parambmm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359403);
    s.u(paramString, "query");
    s.u(parambmm, "resp");
    int i;
    Object localObject1;
    label78:
    Object localObject3;
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if ((i != 0) || (!s.p(paramString, this.CDJ)))
      {
        this.CDI.clear();
        this.CDJ = paramString;
      }
      localObject1 = parambmm.ZPz;
      if (localObject1 != null) {
        break label181;
      }
      localObject1 = null;
      localObject3 = new StringBuilder("updateSearchMusicData last query:").append(this.CDJ).append(", new query:").append(paramString).append(", size:");
      if (localObject1 != null) {
        break label431;
      }
    }
    label270:
    label298:
    label301:
    label431:
    for (paramString = localObject2;; paramString = Integer.valueOf(((List)localObject1).size()))
    {
      Log.i("FinderLiveAnchorMusicData", paramString);
      if (localObject1 != null) {
        this.CDI.addAll((Collection)localObject1);
      }
      this.CDK = parambmm.ZEQ;
      this.CDL = parambmm.BeA;
      AppMethodBeat.o(359403);
      return;
      i = 0;
      break;
      label181:
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        Object localObject5 = (bkh)localObject4;
        if (((bkh)localObject5).playable)
        {
          localObject5 = (CharSequence)((bkh)localObject5).ZTB;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label298;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label301;
          }
          ((Collection)localObject1).add(localObject4);
          break;
          i = 0;
          break label270;
        }
      }
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bkh)((Iterator)localObject3).next();
        s.s(localObject4, "it");
        if (this.CDG.contains(Integer.valueOf(((bkh)localObject4).ZTv))) {}
        for (i = 51;; i = 0)
        {
          ((Collection)localObject1).add(new at((bkh)localObject4, i, 0, 24));
          break;
        }
      }
      localObject1 = (List)localObject1;
      break label78;
    }
  }
  
  public final void aq(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(359301);
    StringBuilder localStringBuilder = new StringBuilder("savePrepareSongIdList size:");
    if (paramLinkedList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramLinkedList.size()))
    {
      Log.i("FinderLiveAnchorMusicData", localObject + ", curPlayPos:" + this.hKr);
      if (paramLinkedList != null) {
        break;
      }
      AppMethodBeat.o(359301);
      return;
    }
    this.CDF = paramLinkedList;
    AppMethodBeat.o(359301);
  }
  
  public final void c(at paramat, int paramInt)
  {
    AppMethodBeat.i(359364);
    s.u(paramat, "item");
    try
    {
      localObject1 = ekc();
      Object localObject2 = this.CDH.get(paramInt);
      s.s(localObject2, "musicList[pos]");
      localObject2 = (at)localObject2;
      if (((at)localObject2).CIu.ZTv == paramat.CIu.ZTv)
      {
        if (localObject1 != null) {
          ((at)localObject1).oYt = 0;
        }
        ((at)localObject2).oYt = 1;
        this.hKr = paramInt;
      }
      Log.i("FinderLiveAnchorMusicData", "playMusicItem item:" + paramat + " songId size:" + this.CDG.size() + ", musicList id size:" + this.CDH.size() + ", pos:" + paramInt + " oriMusicItem:" + localObject1 + " newMusicItem:" + localObject2 + ", curPlayPos:" + this.hKr);
      AppMethodBeat.o(359364);
      return;
    }
    catch (Exception paramat)
    {
      Object localObject1 = aw.Gjk;
      aw.a(paramat, "FinderLiveAnchorMusicData playMusicItem");
      AppMethodBeat.o(359364);
    }
  }
  
  public final void d(at paramat, int paramInt)
  {
    AppMethodBeat.i(359371);
    if (paramat != null) {
      paramat.oYt = 0;
    }
    Log.i("FinderLiveAnchorMusicData", "resetMusicItem " + paramat + " songId size:" + this.CDG.size() + ", musicList id size:" + this.CDH.size() + ", pos:" + paramInt + ", curPlayPos:" + this.hKr);
    AppMethodBeat.o(359371);
  }
  
  public final r<at, Integer> e(at paramat, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(359387);
    s.u(paramat, "musicItem");
    d(paramat, paramInt);
    paramat = (Collection)this.CDH;
    if ((paramat == null) || (paramat.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("FinderLiveAnchorMusicData", "musicList is empty!");
      paramat = new r(null, Integer.valueOf(-1));
      AppMethodBeat.o(359387);
      return paramat;
    }
    i = paramInt + 1;
    if (i >= this.CDH.size()) {
      i = j;
    }
    for (;;)
    {
      paramat = this.CDH.get(i);
      s.s(paramat, "musicList[nextPos]");
      paramat = (at)paramat;
      Log.i("FinderLiveAnchorMusicData", "songId size:" + this.CDG.size() + ", musicList id size:" + this.CDH.size() + ", findNextMusicItem pos:" + paramInt + ", nextPos:" + i + ", curPlayPos:" + this.hKr + ",nextMusicItem:" + paramat);
      paramat = new r(paramat, Integer.valueOf(i));
      AppMethodBeat.o(359387);
      return paramat;
    }
  }
  
  public final at ekc()
  {
    AppMethodBeat.i(359315);
    if ((this.hKr >= 0) && (this.hKr < this.CDH.size()))
    {
      at localat = (at)this.CDH.get(this.hKr);
      AppMethodBeat.o(359315);
      return localat;
    }
    AppMethodBeat.o(359315);
    return null;
  }
  
  public final int ekd()
  {
    AppMethodBeat.i(359322);
    if ((this.hKr >= 0) && (this.hKr < this.CDG.size()))
    {
      Object localObject = this.CDG.get(this.hKr);
      s.s(localObject, "songIdList[curPlayPos]");
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(359322);
      return i;
    }
    AppMethodBeat.o(359322);
    return 0;
  }
  
  public final void eke()
  {
    AppMethodBeat.i(359353);
    Iterator localIterator = ((Iterable)this.CDH).iterator();
    while (localIterator.hasNext()) {
      ((at)localIterator.next()).CIw = false;
    }
    AppMethodBeat.o(359353);
  }
  
  public final bfk ekf()
  {
    AppMethodBeat.i(359394);
    bfk localbfk = new bfk();
    localbfk.ZPo = this.CDG;
    AppMethodBeat.o(359394);
    return localbfk;
  }
  
  public final boolean ekg()
  {
    AppMethodBeat.i(359409);
    Log.i("FinderLiveAnchorMusicData", "isMusicInfoComplete musicSize:" + this.CDH.size() + ", songIdSize:" + this.CDG.size());
    if (this.CDH.size() == this.CDG.size())
    {
      AppMethodBeat.o(359409);
      return true;
    }
    AppMethodBeat.o(359409);
    return false;
  }
  
  public final void h(LinkedList<Integer> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(359309);
    StringBuilder localStringBuilder = new StringBuilder("initSongId liveStatus:").append(paramInt).append(", size:");
    if (paramLinkedList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramLinkedList.size()))
    {
      Log.i("FinderLiveAnchorMusicData", localObject + ", curPlayPos:" + this.hKr);
      if (paramLinkedList != null) {
        break;
      }
      AppMethodBeat.o(359309);
      return;
    }
    this.CDG = paramLinkedList;
    AppMethodBeat.o(359309);
  }
  
  public final LinkedList<Integer> qy(boolean paramBoolean)
  {
    AppMethodBeat.i(359331);
    int i = this.CDG.size();
    int j = this.CDH.size();
    i -= j;
    if (i <= 0)
    {
      AppMethodBeat.o(359331);
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList((Collection)this.CDG.subList(j, i + j));
      AppMethodBeat.o(359331);
      return localLinkedList;
      i = k.qv(this.CDE, i);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData$Companion;", "", "()V", "TAG", "", "printInfo", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "tag", "briefPrint", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void c(ArrayList<at> paramArrayList, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(359295);
      s.u(paramArrayList, "list");
      s.u(paramString, "tag");
      paramString = new StringBuilder(s.X(paramString, ":"));
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        paramArrayList = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        paramArrayList = (at)paramArrayList;
        paramString.append("[第" + i + "首:");
        if (paramBoolean) {}
        for (paramArrayList = paramArrayList.CIu.ZTv + ", " + paramArrayList.oYt + ']';; paramArrayList = paramArrayList + ']')
        {
          paramString.append(paramArrayList);
          i += 1;
          break;
        }
      }
      Log.i("FinderLiveAnchorMusicData", paramString.toString());
      AppMethodBeat.o(359295);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.c
 * JD-Core Version:    0.7.0.1
 */