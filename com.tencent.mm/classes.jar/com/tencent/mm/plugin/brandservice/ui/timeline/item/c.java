package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"})
public final class c
  extends e
{
  private ImageView ocn;
  private View oco;
  private ImageView ocp;
  private final com.tencent.mm.ai.v ocq;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(209682);
    this.ocq = new com.tencent.mm.ai.v();
    AppMethodBeat.o(209682);
  }
  
  private final void a(w paramw, ok paramok, final oj paramoj)
  {
    AppMethodBeat.i(209680);
    final y.a locala = new y.a();
    locala.MLQ = false;
    boolean bool;
    switch (paramw.fpm().style)
    {
    default: 
      this.ocq.type = paramoj.hCZ;
      this.ocq.hDm = paramoj.FFY;
      this.ocq.hDD = paramoj.FFY;
      this.ocq.url = paramoj.FFW;
      i = a.ip(this.context);
      j = b.oah;
      this.obC.oas.a(paramw.field_msgId, 0, this.ocq, paramoj.FFY, this.ocn, i - j, b.oad, false, (m.a)new a(this, locala, paramoj), false, paramw.ofe);
      AppMethodBeat.o(209680);
      return;
    case 101: 
      if (paramok.FJV.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        locala.MLQ = bool;
        break;
      }
    }
    paramok = paramw.fpm().HAf.FHP;
    p.g(paramok, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramok = (Iterable)j.b((Iterable)paramok, 2);
    int j = 0;
    paramok = paramok.iterator();
    int i = 0;
    label239:
    if (paramok.hasNext())
    {
      Object localObject = paramok.next();
      if (j < 0) {
        j.gfB();
      }
      if (((ok)localObject).FuX != 0) {
        break label315;
      }
      i += 1;
    }
    label315:
    for (;;)
    {
      j += 1;
      break label239;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        locala.MLQ = bool;
        break;
      }
    }
  }
  
  private static void dC(View paramView)
  {
    AppMethodBeat.i(209681);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = b.oad;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(209681);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(209679);
    p.h(paramView, "parent");
    if (this.auu == null)
    {
      super.V(paramView, paramInt);
      this.ocn = ((ImageView)paramView.findViewById(2131298824));
      this.oco = paramView.findViewById(2131298825);
      this.ocp = ((ImageView)paramView.findViewById(2131298826));
      bOx();
      this.ocz = paramView.findViewById(2131305993);
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (MMNeat7extView)paramView.findViewById(2131305948); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(209679);
        throw paramView;
      }
      this.ocA = paramView;
      paramView = this.auu;
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(2131303387); paramView == null; paramView = null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(209679);
        throw paramView;
      }
      this.ocB = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label288;
      }
      paramView = (LinearLayout)paramView.findViewById(2131297367);
      this.ocC = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label293;
      }
      paramView = (LinearLayout)paramView.findViewById(2131304831);
      label227:
      this.ocD = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label298;
      }
      paramView = (MMNeat7extView)paramView.findViewById(2131304829);
      label252:
      this.ocE = paramView;
      paramView = this.auu;
      if (paramView == null) {
        break label303;
      }
    }
    label288:
    label293:
    label298:
    label303:
    for (paramView = (MMNeat7extView)paramView.findViewById(2131304827);; paramView = null)
    {
      this.ocF = paramView;
      AppMethodBeat.o(209679);
      return;
      paramView = null;
      break;
      paramView = null;
      break label227;
      paramView = null;
      break label252;
    }
  }
  
  public final void a(View paramView, w paramw, ok paramok)
  {
    AppMethodBeat.i(209678);
    p.h(paramView, "parent");
    p.h(paramw, "info");
    p.h(paramok, "bizInfo");
    V(paramView, 2131308227);
    if (this.auu == null)
    {
      AppMethodBeat.o(209678);
      return;
    }
    paramView = this.auu;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (oj)paramok.FJV.get(0);
    p.g(paramView, "appMsg");
    b(paramw, paramok, paramView);
    Object localObject = this.oco;
    if (localObject == null) {
      p.gfZ();
    }
    dC((View)localObject);
    localObject = this.ocn;
    if (localObject == null) {
      p.gfZ();
    }
    dC((View)localObject);
    a(paramw, paramok, paramView);
    c(paramw, paramok, paramView);
    AppMethodBeat.o(209678);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(y.a parama, oj paramoj) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(209677);
      Object localObject = this.ocr.ocH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.ocr.context.getResources().getColor(2131099674));
      }
      localObject = this.ocr.ocB;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!locala.MLQ)
      {
        localObject = this.ocr.ocA;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.ocr.context.getResources().getColor(2131101182));
        }
      }
      this.ocr.a(paramoj);
      AppMethodBeat.o(209677);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.c
 * JD-Core Version:    0.7.0.1
 */