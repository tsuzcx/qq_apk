package com.tencent.mm.plugin.emoji.ui.v3;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.e.q;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.u;
import com.tencent.threadpool.i;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseDataRepo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "netSceneGetStoreRecListType", "", "(I)V", "STATUS_DISMISS_LOADING", "getSTATUS_DISMISS_LOADING", "()I", "STATUS_REFRESH_ADAPTER_ALL", "getSTATUS_REFRESH_ADAPTER_ALL", "STATUS_UI_CONTENT", "getSTATUS_UI_CONTENT", "STATUS_UI_EMPTY", "getSTATUS_UI_EMPTY", "STATUS_UI_ERROR", "getSTATUS_UI_ERROR", "STATUS_UI_LOADING", "getSTATUS_UI_LOADING", "actionReport", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;", "getActionReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;", "setActionReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "curEmojiStoreTypeRecModel", "Lcom/tencent/mm/plugin/emoji/model/EmojiStoreTypeRecModel;", "googleQueryFinishListener", "Lcom/tencent/mm/pluginsdk/model/GetProductDetailLogic$OnQueryFinishLisener;", "getGoogleQueryFinishListener", "()Lcom/tencent/mm/pluginsdk/model/GetProductDetailLogic$OnQueryFinishLisener;", "mEmoticonPrecedingScence", "mEnterTime", "", "getMEnterTime", "()J", "setMEnterTime", "(J)V", "mExchangeEmotionPackNetScene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneExchangeEmotionPack;", "mGetStoreRecListNetScene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneGetEmotionStoreRecList;", "mIsInitData", "", "mIsLoading", "mbAlreadyInitDate", "statusEventLiveData", "Landroidx/lifecycle/MutableLiveData;", "getStatusEventLiveData", "()Landroidx/lifecycle/MutableLiveData;", "addNetSceneEndListener", "", "type", "dealNetGetStoreRecList", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "dealNetGetStoreRecList$plugin_emoji_release", "dealNetGetStoreRecListErr", "dealNetGetStoreRecListErr$plugin_emoji_release", "dealNetGetStoreRecListOK", "emotionList", "req", "Lcom/tencent/mm/protocal/protobuf/GetStoreRecListResponse;", "dealNetGetStoreRecListOK$plugin_emoji_release", "dealNetGetStoreRecListUnKnow", "dealNetGetStoreRecListUnKnow$plugin_emoji_release", "getCurrentEmojiStoreTypeRecModel", "getNetSceneGetEmotionListScene", "getNetSceneGetEmotionListScene$plugin_emoji_release", "getStatusLiveData", "initeData", "isAlreadyInit", "isDataLoading", "isGetEmotionListRightNet", "isGetEmotionListRightNet$plugin_emoji_release", "loadCache", "loadNetWork", "onSceneEnd", "errMsg", "", "queryGooglePrice", "reqModel", "onFinish", "queryGooglePrice$plugin_emoji_release", "refreshNetSceneExchangeEmotionPack", "productId", "seriesId", "productName", "panelIcon", "refreshNetSceneExchangeEmotionPack$plugin_emoji_release", "refreshNetSceneGetStoreRecList", "refreshNetSceneGetStoreRecList$plugin_emoji_release", "removeNetSceneEndListener", "requestNetExchangeEmotionPack", "requestNetExchangeEmotionPack$plugin_emoji_release", "requestNetGetStoreRecList", "requestNetGetStoreRecList$plugin_emoji_release", "saveCache", "response", "saveCache$plugin_emoji_release", "setDataLoadingState", "state", "setNetSceneGetEmotionListScene", "unInit", "updateAdapterData", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.am.h
{
  public static final b.a xZw;
  private long owx;
  boolean szX;
  private bw xNu;
  int xQc;
  com.tencent.mm.plugin.emoji.e.h xQj;
  private boolean xQk;
  boolean xVJ;
  final x<Integer> xZA;
  final int xZB;
  final int xZC;
  final int xZD;
  final int xZE;
  final int xZF;
  final int xZG;
  private final o.a xZH;
  private final int xZx;
  k xZy;
  private q xZz;
  
  static
  {
    AppMethodBeat.i(270488);
    xZw = new b.a((byte)0);
    AppMethodBeat.o(270488);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(270459);
    this.xZx = paramInt;
    this.xNu = new bw();
    this.xZA = new x();
    this.xZB = 1;
    this.xZC = 2;
    this.xZD = 3;
    this.xZE = 4;
    this.xZF = 5;
    this.xZG = 6;
    this.xZH = ((o.a)new b(this));
    AppMethodBeat.o(270459);
  }
  
  private static final void a(csy paramcsy, b paramb)
  {
    AppMethodBeat.i(270482);
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramcsy != null)
    {
      Log.d("MicroMsg.EmojiStoreV3HomeBaseDataRepo", kotlin.g.b.s.X("save Cache type: ", Integer.valueOf(paramb.xZx)));
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjy.a(paramb.xZx, paramcsy);
    }
    AppMethodBeat.o(270482);
  }
  
  private void dCH()
  {
    AppMethodBeat.i(270470);
    if (!this.xQk) {
      this.xZA.setValue(Integer.valueOf(this.xZE));
    }
    AppMethodBeat.o(270470);
  }
  
  private void dCI()
  {
    AppMethodBeat.i(270475);
    this.xZA.setValue(Integer.valueOf(this.xZB));
    AppMethodBeat.o(270475);
  }
  
  public final void KA(int paramInt)
  {
    AppMethodBeat.i(270524);
    com.tencent.mm.kernel.h.baD().mCm.b(paramInt, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(270524);
  }
  
  public final void Kz(int paramInt)
  {
    AppMethodBeat.i(270522);
    com.tencent.mm.kernel.h.baD().mCm.a(paramInt, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(270522);
  }
  
  public final void dCE()
  {
    AppMethodBeat.i(270500);
    Log.d("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "loadNetWork");
    dCF();
    dCG();
    AppMethodBeat.o(270500);
  }
  
  public final void dCF()
  {
    AppMethodBeat.i(270510);
    Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "[refreshNetSceneGetStoreRecList] request buffer is null.");
    this.xZz = new q();
    AppMethodBeat.o(270510);
  }
  
  public final void dCG()
  {
    AppMethodBeat.i(270515);
    if (this.xZz == null)
    {
      Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "requestNetGetStoreRecList failed, mGetStoreRecListNetScene null");
      AppMethodBeat.o(270515);
      return;
    }
    Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "ready to doScene NetSceneGetEmotionStoreRecList");
    this.szX = true;
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)this.xZz, 0);
    AppMethodBeat.o(270515);
  }
  
  public final void dCf()
  {
    AppMethodBeat.i(270497);
    this.xVJ = true;
    this.owx = System.currentTimeMillis();
    ehf localehf = new ehf();
    localehf.abmu = this.owx;
    this.xNu.iuE = this.owx;
    Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", kotlin.g.b.s.X("initeData sessionid: ", Long.valueOf(localehf.abmu)));
    AppMethodBeat.o(270497);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 0;
    AppMethodBeat.i(270531);
    Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "onSceneEnd errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg:" + paramString);
    this.xZA.setValue(Integer.valueOf(this.xZC));
    if (paramp == null)
    {
      Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "onSceneEnd scene null");
      AppMethodBeat.o(270531);
      return;
    }
    if (paramp.getType() == 6910)
    {
      if (!(paramp instanceof q))
      {
        Log.i("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "sceneType:6910,scene cast NetSceneGetEmotionStoreRecList Failed");
        AppMethodBeat.o(270531);
        return;
      }
      kotlin.g.b.s.u(paramp, "scene");
      this.szX = false;
      if ((paramInt1 == 0) || (paramInt1 == 4)) {
        i = 1;
      }
      if (i != 0)
      {
        this.xZA.setValue(Integer.valueOf(this.xZG));
        paramString = ((q)paramp).dAI();
        if (paramString == null) {
          dCH();
        }
        paramp = new k(paramString);
        this.xZy = paramp;
        if (paramInt2 == 0)
        {
          kotlin.g.b.s.u(paramp, "emotionList");
          dCI();
          com.tencent.threadpool.h.ahAA.bn(new b..ExternalSyntheticLambda0(paramString, this));
          AppMethodBeat.o(270531);
          return;
        }
        this.xZA.setValue(Integer.valueOf(this.xZD));
        AppMethodBeat.o(270531);
        return;
      }
      dCH();
      AppMethodBeat.o(270531);
      return;
    }
    Log.w("MicroMsg.EmojiStoreV3HomeBaseDataRepo", "unknow scene type.");
    AppMethodBeat.o(270531);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseDataRepo$googleQueryFinishListener$1", "Lcom/tencent/mm/pluginsdk/model/GetProductDetailLogic$OnQueryFinishLisener;", "onQueryFinish", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mm/pluginsdk/model/ProductDetailInfo;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements o.a
  {
    b(b paramb) {}
    
    public final void ac(ArrayList<w> paramArrayList)
    {
      AppMethodBeat.i(270449);
      Object localObject = com.tencent.mm.plugin.emoji.ui.v3.a.h.ybM;
      localObject = (com.tencent.mm.plugin.emoji.model.p)this.xZI.xZy;
      if (z.bBh())
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (localObject == null))
        {
          AppMethodBeat.o(270449);
          return;
        }
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          w localw = (w)paramArrayList.next();
          if (localw != null)
          {
            Log.i(com.tencent.mm.plugin.emoji.ui.v3.a.h.TAG, "endSeachV3GoogleMarket: %s", new Object[] { localw });
            bj localbj = ((com.tencent.mm.plugin.emoji.model.p)localObject).anQ(localw.productId);
            if (localbj != null)
            {
              int i;
              if (localw.XRy == 10232)
              {
                localbj.adjh = localw.XRv;
                localbj.adjf = localw.XRw;
                localbj.adjg = new BigDecimal(localw.XRx).divide(new BigDecimal(1000000)).toString();
                localbj.adjd = 12;
                i = localbj.adjb;
                if ((!com.tencent.mm.plugin.emoji.ui.v3.a.h.Kg(i)) && (!com.tencent.mm.plugin.emoji.ui.v3.a.h.Kh(i))) {
                  localbj.ayW(4);
                }
              }
              else
              {
                localbj.adjd = 10;
                localbj.adje = localw.XRy;
                i = localbj.adjb;
                if ((!com.tencent.mm.plugin.emoji.ui.v3.a.h.Kg(i)) && (!com.tencent.mm.plugin.emoji.ui.v3.a.h.Kh(i)) && (!com.tencent.mm.plugin.emoji.ui.v3.a.h.KE(i))) {
                  localbj.ayW(10);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(270449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.b
 * JD-Core Version:    0.7.0.1
 */