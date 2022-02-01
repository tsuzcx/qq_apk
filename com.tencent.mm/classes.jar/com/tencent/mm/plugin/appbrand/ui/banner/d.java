package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean lFv = false;
  private View lFp;
  private TextView lFq;
  private ImageView lFr;
  private String lFs;
  private final Runnable lFt;
  private final b.k lFu;
  
  public static void bpa()
  {
    lFv = false;
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(48994);
    if (!lFv)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).boW();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).a(this);
      lFv = true;
    }
    Object localObject2 = BannerModel.bpf();
    if ((localObject2 != null) && (!bt.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).lFM;
      localObject2 = ((BannerModel)localObject2).iVP;
      if (bt.isNullOrNil(str)) {}
      while (bt.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.lFq != null) {
        this.lFq.setText((CharSequence)localObject1);
      }
      if (!bt.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!bt.isNullOrNil(this.lFs)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.aub().vm(this.lFs);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.lFu.E((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(48994);
        return true;
        label193:
        this.lFs = com.tencent.mm.modelappbrand.a.b.aub().a(this.lFu, (String)localObject2, com.tencent.mm.modelappbrand.a.g.gSK);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(48994);
    return false;
  }
  
  public final void bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    aq.f(this.lFt);
    AppMethodBeat.o(48998);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    if (this.lFp != null)
    {
      ((ViewGroup)this.lFp).removeAllViews();
      this.lFp.setVisibility(8);
    }
    this.lFp = null;
    this.lFq = null;
    this.lFr = null;
    ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
    AppMethodBeat.o(48996);
  }
  
  public final int getLayoutId()
  {
    return 2131493383;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48997);
    Object localObject = BannerModel.bpf();
    if (localObject == null)
    {
      AppMethodBeat.o(48997);
      return;
    }
    String str = ((BannerModel)localObject).appId;
    int i = ((BannerModel)localObject).gXn;
    if (bt.isNullOrNil(str))
    {
      boZ();
      AppMethodBeat.o(48997);
      return;
    }
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1022;
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a(paramView.getContext(), null, str, i, -1, null, (AppBrandStatObject)localObject);
    AppMethodBeat.o(48997);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(48995);
    if (this.lFp != null) {
      this.lFp.setVisibility(paramInt);
    }
    AppMethodBeat.o(48995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */