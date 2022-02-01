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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean mhp = false;
  private View mhj;
  private TextView mhk;
  private ImageView mhl;
  private String mhm;
  private final Runnable mhn;
  private final b.k mho;
  
  public static void bvV()
  {
    mhp = false;
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(48994);
    if (!mhp)
    {
      ((e)com.tencent.mm.kernel.g.ab(e.class)).b(this);
      ((e)com.tencent.mm.kernel.g.ab(e.class)).bvR();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).a(this);
      mhp = true;
    }
    Object localObject2 = BannerModel.bwa();
    if ((localObject2 != null) && (!bs.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).mhG;
      localObject2 = ((BannerModel)localObject2).jwf;
      if (bs.isNullOrNil(str)) {}
      while (bs.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(48994);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.mhk != null) {
        this.mhk.setText((CharSequence)localObject1);
      }
      if (!bs.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!bs.isNullOrNil(this.mhm)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.aAS().zs(this.mhm);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.mho.E((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(48994);
        return true;
        label193:
        this.mhm = com.tencent.mm.modelappbrand.a.b.aAS().a(this.mho, (String)localObject2, com.tencent.mm.modelappbrand.a.g.htk);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(48994);
    return false;
  }
  
  public final void bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(48998);
    ap.f(this.mhn);
    AppMethodBeat.o(48998);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(48996);
    if (this.mhj != null)
    {
      ((ViewGroup)this.mhj).removeAllViews();
      this.mhj.setVisibility(8);
    }
    this.mhj = null;
    this.mhk = null;
    this.mhl = null;
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
    Object localObject = BannerModel.bwa();
    if (localObject == null)
    {
      AppMethodBeat.o(48997);
      return;
    }
    String str = ((BannerModel)localObject).appId;
    int i = ((BannerModel)localObject).hxM;
    if (bs.isNullOrNil(str))
    {
      bvU();
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
    if (this.mhj != null) {
      this.mhj.setVisibility(paramInt);
    }
    AppMethodBeat.o(48995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */