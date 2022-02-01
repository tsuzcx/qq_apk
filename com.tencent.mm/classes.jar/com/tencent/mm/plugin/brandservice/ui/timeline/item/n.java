package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "coverHeight", "", "getCoverHeight", "()I", "coverIv1", "Landroid/widget/ImageView;", "getCoverIv1", "()Landroid/widget/ImageView;", "setCoverIv1", "(Landroid/widget/ImageView;)V", "coverIv2", "getCoverIv2", "setCoverIv2", "coverIv3", "getCoverIv3", "setCoverIv3", "coverWidth", "getCoverWidth", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "loadCover", "iv", "url", "", "shouldShowMe", "", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends m
{
  private int nQm;
  private final int vGa;
  private ImageView vJF;
  private ImageView vJG;
  private ImageView vJH;
  private final int vJI;
  private int viewId;
  
  public n(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302708);
    this.viewId = d.e.viewstub_top_multi_pic_article_slot;
    this.vJI = ((getWidth() - b.vGm) / 3);
    this.vGa = (b.vGm * 10);
    AppMethodBeat.o(302708);
  }
  
  public final void a(ddb paramddb)
  {
    AppMethodBeat.i(302736);
    s.u(paramddb, "itemInfo");
    super.a(paramddb);
    paramddb = paramddb.YQO;
    if (paramddb != null) {
      ddy().nUM = paramddb;
    }
    AppMethodBeat.o(302736);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302729);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView1 = getItemView();
    if (paramView1 == null) {}
    for (paramView1 = null; paramView1 == null; paramView1 = kotlin.ah.aiuX)
    {
      AppMethodBeat.o(302729);
      return;
      this.vJF = ((ImageView)paramView1.findViewById(d.e.rec_feed_item_cover_1));
      this.vJG = ((ImageView)paramView1.findViewById(d.e.rec_feed_item_cover_2));
      this.vJH = ((ImageView)paramView1.findViewById(d.e.rec_feed_item_cover_3));
    }
    Object localObject1 = ((enp)paramab.acFJ.abrC.get(0)).abse;
    paramView1 = ddw();
    if (paramView1 != null) {
      paramView1.aZ((CharSequence)((ddb)localObject1).hAP);
    }
    ab(this.vJg, -2);
    ddo();
    d.ajs(paramab.getId());
    paramView1 = this.vJF;
    paramView2 = this.vJG;
    ImageView localImageView1 = this.vJH;
    localObject1 = ((ddb)localObject1).aaIF.abiJ;
    s.s(localObject1, "itemInfo.PictureInfo.PictureUrl");
    localObject1 = ((Iterable)p.c((Iterable)localObject1, 3)).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        p.kkW();
      }
      localObject2 = (String)localObject2;
      ddy().nUM = ((String)localObject2);
      ImageView localImageView2 = new ImageView[] { paramView1, paramView2, localImageView1 }[paramInt];
      s.checkNotNull(localImageView2);
      s.s(localObject2, "url");
      ddo().vFN.a(paramab.field_orderFlag, 0, ddy(), (String)localObject2, localImageView2, this.vJI, this.vGa, false, (m.a)new a(), false, paramab.vMB);
      paramInt += 1;
    }
    AppMethodBeat.o(302729);
  }
  
  public final boolean a(enp paramenp)
  {
    AppMethodBeat.i(302743);
    if (paramenp == null)
    {
      AppMethodBeat.o(302743);
      return false;
    }
    boolean bool = com.tencent.mm.storage.ah.b(paramenp);
    AppMethodBeat.o(302743);
    return bool;
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302745);
    View localView = getItemView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302745);
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle$loadCover$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.n
 * JD-Core Version:    0.7.0.1
 */