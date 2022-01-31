package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener, f
{
  private static boolean iQV = false;
  private View iQP;
  private TextView iQQ;
  private ImageView iQR;
  private String iQS;
  private final Runnable iQT;
  private final b.i iQU;
  
  public static void aML()
  {
    iQV = false;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(133275);
    if (!iQV)
    {
      ((e)g.E(e.class)).b(this);
      ((e)g.E(e.class)).aMH();
      ((e)g.E(e.class)).a(this);
      iQV = true;
    }
    Object localObject2 = BannerModel.aMQ();
    if ((localObject2 != null) && (!bo.isNullOrNil(((BannerModel)localObject2).appId)))
    {
      Object localObject1 = ((BannerModel)localObject2).appName;
      String str = ((BannerModel)localObject2).iRl;
      localObject2 = ((BannerModel)localObject2).hcN;
      if (bo.isNullOrNil(str)) {}
      while (bo.isNullOrNil((String)localObject1))
      {
        AppMethodBeat.o(133275);
        return false;
        localObject1 = str;
      }
      setVisibility(0);
      if (this.iQQ != null) {
        this.iQQ.setText((CharSequence)localObject1);
      }
      if (!bo.isNullOrNil((String)localObject2))
      {
        localObject1 = null;
        if (!bo.isNullOrNil(this.iQS)) {
          localObject1 = com.tencent.mm.modelappbrand.a.b.acD().qw(this.iQS);
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label193;
        }
        this.iQU.w((Bitmap)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(133275);
        return true;
        label193:
        this.iQS = com.tencent.mm.modelappbrand.a.b.acD().a(this.iQU, (String)localObject2, com.tencent.mm.modelappbrand.a.f.fqU);
      }
    }
    setVisibility(8);
    AppMethodBeat.o(133275);
    return false;
  }
  
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(133279);
    al.d(this.iQT);
    AppMethodBeat.o(133279);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(133277);
    if (this.iQP != null)
    {
      ((ViewGroup)this.iQP).removeAllViews();
      this.iQP.setVisibility(8);
    }
    this.iQP = null;
    this.iQQ = null;
    this.iQR = null;
    ((e)g.E(e.class)).b(this);
    AppMethodBeat.o(133277);
  }
  
  public final int getLayoutId()
  {
    return 2130969029;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133278);
    Object localObject = BannerModel.aMQ();
    if (localObject == null)
    {
      AppMethodBeat.o(133278);
      return;
    }
    String str = ((BannerModel)localObject).appId;
    int i = ((BannerModel)localObject).hcr;
    if (bo.isNullOrNil(str))
    {
      aMK();
      AppMethodBeat.o(133278);
      return;
    }
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1022;
    ((j)g.E(j.class)).a(paramView.getContext(), null, str, i, -1, null, (AppBrandStatObject)localObject);
    AppMethodBeat.o(133278);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(133276);
    if (this.iQP != null) {
      this.iQP.setVisibility(paramInt);
    }
    AppMethodBeat.o(133276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.d
 * JD-Core Version:    0.7.0.1
 */