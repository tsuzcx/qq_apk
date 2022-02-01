package com.tencent.d.a.a.a.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cs;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderLiveGiftInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isFansGift", "", "isFullPagGift", "pagFetched", "pagFullFetched", "pagPreFetched", "resetPagFullFetched", "", "toFinderLiveGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends cs
{
  public static final a ahpO;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(216740);
    ahpO = new a((byte)0);
    info = cs.aJm();
    AppMethodBeat.o(216740);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216745);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(216745);
    return localMAutoDBInfo;
  }
  
  public final boolean jWq()
  {
    return this.field_giftType == 2;
  }
  
  public final boolean jWr()
  {
    AppMethodBeat.i(216746);
    boolean bool = com.tencent.mm.ae.d.ee(this.field_state, 1);
    AppMethodBeat.o(216746);
    return bool;
  }
  
  public final boolean jWs()
  {
    AppMethodBeat.i(216747);
    boolean bool = com.tencent.mm.ae.d.ee(this.field_state, 2);
    AppMethodBeat.o(216747);
    return bool;
  }
  
  public final void jWt()
  {
    this.field_state &= 0xFFFFFFFD;
  }
  
  public final bim jWu()
  {
    AppMethodBeat.i(216749);
    bim localbim = new bim();
    localbim.ZOC = this.field_rewardProductId;
    localbim.business_type = this.field_businessType;
    localbim.ZRC = this.field_thumbnailFileUrl;
    localbim.ZRD = this.field_previewPagUrl;
    localbim.ZRE = this.field_animationPagUrl;
    localbim.ZRF = this.field_thumbnailMd5;
    localbim.ZRG = this.field_previewPagMd5;
    localbim.ZRH = this.field_animationPagMd5;
    localbim.ZRJ = this.field_giftType;
    localbim.name = this.field_name;
    localbim.ZRI = this.field_price;
    localbim.eQp = this.field_flag;
    localbim.ZRK = this.field_unlockIntimacyLevel;
    AppMethodBeat.o(216749);
    return localbim;
  }
  
  public final boolean jWv()
  {
    AppMethodBeat.i(216751);
    boolean bool = com.tencent.mm.ae.d.ee(this.field_flag, 1);
    AppMethodBeat.o(216751);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "fromFinderLiveGift", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "finderLiveGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d b(bim parambim)
    {
      AppMethodBeat.i(216729);
      s.u(parambim, "finderLiveGift");
      d locald = new d();
      locald.field_rewardProductId = parambim.ZOC;
      locald.field_businessType = parambim.business_type;
      locald.field_thumbnailFileUrl = parambim.ZRC;
      locald.field_previewPagUrl = parambim.ZRD;
      locald.field_animationPagUrl = parambim.ZRE;
      locald.field_thumbnailMd5 = parambim.ZRF;
      locald.field_previewPagMd5 = parambim.ZRG;
      locald.field_animationPagMd5 = parambim.ZRH;
      locald.field_giftType = parambim.ZRJ;
      locald.field_flag = parambim.eQp;
      locald.field_unlockIntimacyLevel = parambim.ZRK;
      locald.field_name = parambim.name;
      locald.field_price = parambim.ZRI;
      AppMethodBeat.o(216729);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.a.d
 * JD-Core Version:    0.7.0.1
 */