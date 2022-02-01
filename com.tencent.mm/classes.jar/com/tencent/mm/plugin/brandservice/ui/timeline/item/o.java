package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "coverHeight", "", "getCoverHeight", "()I", "coverIv1", "Landroid/widget/ImageView;", "getCoverIv1", "()Landroid/widget/ImageView;", "setCoverIv1", "(Landroid/widget/ImageView;)V", "coverIv2", "getCoverIv2", "setCoverIv2", "coverIv3", "getCoverIv3", "setCoverIv3", "coverWidth", "getCoverWidth", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "loadCover", "iv", "url", "", "shouldShowMe", "", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "plugin-brandservice_release"})
public final class o
  extends n
{
  private int llp;
  private final int sAo;
  private ImageView sDU;
  private ImageView sDV;
  private ImageView sDW;
  private final int sDX;
  private int viewId;
  
  public o(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(264339);
    this.viewId = d.e.stz;
    this.sDX = ((getWidth() - b.sAA) / 3);
    this.sAo = (b.sAA * 10);
    AppMethodBeat.o(264339);
  }
  
  public final void a(cmo paramcmo)
  {
    AppMethodBeat.i(264336);
    p.k(paramcmo, "itemInfo");
    super.a(paramcmo);
    paramcmo = paramcmo.RTo;
    if (paramcmo != null)
    {
      cAy().lpK = paramcmo;
      AppMethodBeat.o(264336);
      return;
    }
    AppMethodBeat.o(264336);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(264335);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView1 = getItemView();
    if (paramView1 != null)
    {
      this.sDU = ((ImageView)paramView1.findViewById(d.e.ssC));
      this.sDV = ((ImageView)paramView1.findViewById(d.e.ssD));
      this.sDW = ((ImageView)paramView1.findViewById(d.e.ssE));
      Object localObject1 = ((dur)paramz.Ven.UaA.get(0)).UaX;
      paramView1 = cAw();
      if (paramView1 != null) {
        paramView1.aL((CharSequence)((cmo)localObject1).fwr);
      }
      X(this.sDp, -2);
      d.apR(paramz.getId());
      paramView1 = this.sDU;
      paramView2 = this.sDV;
      ImageView localImageView1 = this.sDW;
      localObject1 = ((cmo)localObject1).Tuc.TSl;
      p.j(localObject1, "itemInfo.PictureInfo.PictureUrl");
      localObject1 = ((Iterable)j.c((Iterable)localObject1, 3)).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (paramInt < 0) {
          j.iBO();
        }
        localObject2 = (String)localObject2;
        cAy().lpK = ((String)localObject2);
        ImageView localImageView2 = new ImageView[] { paramView1, paramView2, localImageView1 }[paramInt];
        if (localImageView2 == null) {
          p.iCn();
        }
        p.j(localObject2, "url");
        this.sCg.sAc.a(paramz.field_orderFlag, 0, cAy(), (String)localObject2, localImageView2, this.sDX, this.sAo, false, (m.a)new a(), false, paramz.sHe);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(264335);
    return;
    AppMethodBeat.o(264335);
  }
  
  public final boolean a(dur paramdur)
  {
    AppMethodBeat.i(264337);
    if (paramdur == null)
    {
      AppMethodBeat.o(264337);
      return false;
    }
    boolean bool = af.b(paramdur);
    AppMethodBeat.o(264337);
    return bool;
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(264338);
    View localView = getItemView();
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(264338);
      return;
    }
    AppMethodBeat.o(264338);
  }
  
  public final int getItemShowType()
  {
    return this.llp;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle$loadCover$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.o
 * JD-Core Version:    0.7.0.1
 */