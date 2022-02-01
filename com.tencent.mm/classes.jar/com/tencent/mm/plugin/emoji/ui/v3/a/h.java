package com.tencent.mm.plugin.emoji.ui.v3.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3GoogleMarketTool;", "", "()V", "TAG", "", "endSeachV3GoogleMarket", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mm/pluginsdk/model/ProductDetailInfo;", "model", "Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;", "handleGoogleMarketDownloadInfo", "info", "downloadInfo", "Lcom/tencent/mm/storage/EmojiDownLoadInfo;", "isDownload", "", "status", "", "isDownloading", "isEnableGoogleMarket", "isWaitForDownload", "preSeachGoogleMarket", "data", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "lisener", "Lcom/tencent/mm/pluginsdk/model/GetProductDetailLogic$OnQueryFinishLisener;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final String TAG;
  public static final h ybM;
  
  static
  {
    AppMethodBeat.i(270705);
    ybM = new h();
    TAG = "MicroMsg.EmojiStoreV3GoogleMarketTool";
    AppMethodBeat.o(270705);
  }
  
  public static boolean KE(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean Kg(int paramInt)
  {
    return paramInt == 7;
  }
  
  public static boolean Kh(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static void a(List<? extends t> paramList, p paramp, o.a parama)
  {
    AppMethodBeat.i(270684);
    kotlin.g.b.s.u(paramp, "model");
    if (!z.bBh())
    {
      AppMethodBeat.o(270684);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()) || (parama == null))
    {
      AppMethodBeat.o(270684);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label180:
    label186:
    while (localIterator.hasNext())
    {
      paramList = (t)localIterator.next();
      if (paramList.getType() == 1)
      {
        if ((paramList instanceof s))
        {
          paramList = (s)paramList;
          label106:
          if (paramList != null) {
            break label180;
          }
        }
        for (paramList = null;; paramList = paramList.ycP)
        {
          if (paramList == null) {
            break label186;
          }
          paramList = paramList.xHE;
          boolean bool1 = e.b(paramList);
          boolean bool2 = e.a(paramList);
          if ((bool1) || (bool2)) {
            break;
          }
          localArrayList.add(paramList.ProductID);
          paramList = paramp.anQ(paramList.ProductID);
          if (paramList == null) {
            break;
          }
          paramList.adjd = 11;
          break;
          paramList = null;
          break label106;
        }
      }
    }
    paramList = MMApplicationContext.getContext();
    if (localArrayList.size() > 0)
    {
      paramp = ((Collection)localArrayList).toArray(new String[0]);
      if (paramp == null)
      {
        paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(270684);
        throw paramList;
      }
      o.a(paramList, (String[])paramp, parama);
    }
    AppMethodBeat.o(270684);
  }
  
  public static final boolean dDc()
  {
    AppMethodBeat.i(270674);
    boolean bool = z.bBh();
    AppMethodBeat.o(270674);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.h
 * JD-Core Version:    0.7.0.1
 */