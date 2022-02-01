package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent$Companion$SubInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/content/Context;Landroid/view/LayoutInflater;)V", "subInfoList", "", "Lcom/tencent/mm/protocal/protobuf/RelievedBuySubInfo;", "attachSubInfo", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class l$a$c
  extends RecyclerView.a<RecyclerView.v>
{
  private final Context context;
  private final LayoutInflater pUI;
  List<? extends eph> ucq;
  
  private l$a$c(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(322571);
    this.context = paramContext;
    this.pUI = paramLayoutInflater;
    this.ucq = ((List)ab.aivy);
    AppMethodBeat.o(322571);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(322580);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = this.pUI.inflate(ba.g.app_brand_profile_relieved_buy_half_screen_item, paramViewGroup, false);
      s.s(paramViewGroup, "inflater.inflate(R.layou…reen_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new l.a.d(paramViewGroup);
      AppMethodBeat.o(322580);
      return paramViewGroup;
    case 1: 
      paramViewGroup = (RecyclerView.v)new l.a.b(this.context);
      AppMethodBeat.o(322580);
      return paramViewGroup;
    }
    paramViewGroup = (RecyclerView.v)new l.a.a(this.context);
    AppMethodBeat.o(322580);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(322583);
    s.u(paramv, "holder");
    if (!(paramv instanceof l.a.d))
    {
      AppMethodBeat.o(322583);
      return;
    }
    eph localeph = (eph)this.ucq.get(paramInt - 1);
    String str = localeph.icon;
    ((l.a.d)paramv).tuy.setTag(str);
    b.bEY().a((b.k)new a(str, paramv), localeph.icon, null);
    ((l.a.d)paramv).lzN.setText((CharSequence)localeph.title);
    ((l.a.d)paramv).uck.setText((CharSequence)localeph.desc);
    AppMethodBeat.o(322583);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(322586);
    int i = this.ucq.size();
    AppMethodBeat.o(322586);
    return i + 2;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(322590);
    if (paramInt == 0)
    {
      AppMethodBeat.o(322590);
      return 1;
    }
    if (paramInt == this.ucq.size() + 1)
    {
      AppMethodBeat.o(322590);
      return 2;
    }
    AppMethodBeat.o(322590);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent$Companion$SubInfoAdapter$onBindViewHolder$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.k
  {
    a(String paramString, RecyclerView.v paramv) {}
    
    public final void bFg()
    {
      AppMethodBeat.i(322393);
      Log.d("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", s.X("beforeLoadBitmap, iconUrl: ", this.ucr));
      AppMethodBeat.o(322393);
    }
    
    public final void bFh()
    {
      AppMethodBeat.i(322408);
      Log.d("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", s.X("onLoadFailed, iconUrl: ", this.ucr));
      AppMethodBeat.o(322408);
    }
    
    public final String key()
    {
      AppMethodBeat.i(322388);
      String str = p.el(this);
      AppMethodBeat.o(322388);
      return str;
    }
    
    public final void onBitmapLoaded(Bitmap paramBitmap)
    {
      AppMethodBeat.i(322400);
      Log.d("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", s.X("onBitmapLoaded, iconUrl: ", this.ucr));
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", "onBitmapLoaded, bitmap is null");
        AppMethodBeat.o(322400);
        return;
      }
      if (!s.p(this.ucr, ((l.a.d)paramv).tuy.getTag()))
      {
        Log.i("MicroMsg.AppBrand.AppBrandProfileRelievedBuyHalfScreenComponent", "onBitmapLoaded, imageView already reused");
        AppMethodBeat.o(322400);
        return;
      }
      ((l.a.d)paramv).tuy.setImageBitmap(paramBitmap);
      AppMethodBeat.o(322400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l.a.c
 * JD-Core Version:    0.7.0.1
 */