package com.tencent.mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements b.i
{
  TextView iJG;
  public ImageView iJH;
  IPCDynamicPageView iJI;
  ThreeDotsLoadingView iJJ;
  public ImageView iJK;
  public TextView iJL;
  i.b iJM;
  public boolean iJN;
  private ImageView iJO;
  public ImageView icw;
  public View jU;
  
  public WxaShareMessagePage(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(132757);
    init(paramContext);
    AppMethodBeat.o(132757);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(132758);
    init(paramContext);
    AppMethodBeat.o(132758);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(132759);
    init(paramContext);
    AppMethodBeat.o(132759);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(132760);
    View localView = View.inflate(paramContext, 2130971339, this);
    this.jU = localView.findViewById(2131829605);
    this.icw = ((ImageView)localView.findViewById(2131821891));
    this.iJH = ((ImageView)localView.findViewById(2131822585));
    this.iJI = ((IPCDynamicPageView)localView.findViewById(2131829606));
    this.iJG = ((TextView)localView.findViewById(2131821212));
    this.iJO = ((ImageView)localView.findViewById(2131821939));
    this.iJJ = ((ThreeDotsLoadingView)localView.findViewById(2131821346));
    paramContext = LayoutInflater.from(paramContext).inflate(2130969972, (ViewGroup)localView, false);
    this.iJK = ((ImageView)paramContext.findViewById(2131825400));
    this.iJL = ((TextView)paramContext.findViewById(2131825401));
    ((ViewGroup)localView.findViewById(2131821084)).addView(paramContext);
    setGravity(17);
    AppMethodBeat.o(132760);
  }
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(132762);
    this.iJJ.setVisibility(4);
    this.iJJ.dOW();
    this.icw.setImageBitmap(null);
    this.iJH.setVisibility(0);
    if (this.iJM != null) {
      this.iJM.kP(1);
    }
    AppMethodBeat.o(132762);
  }
  
  public ImageView getCoverImageView()
  {
    return this.icw;
  }
  
  public ImageView getErrorImageView()
  {
    return this.iJH;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.iJJ;
  }
  
  public ImageView getVideoIcon()
  {
    return this.iJO;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(132768);
    int i = com.tencent.mm.plugin.appbrand.s.g.pO(180);
    AppMethodBeat.o(132768);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.iJI;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(132767);
    int i = com.tencent.mm.plugin.appbrand.s.g.pO(224);
    AppMethodBeat.o(132767);
    return i;
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(132765);
    this.icw.setVisibility(0);
    this.iJJ.setVisibility(4);
    this.iJH.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.f localf = ((i)com.tencent.mm.kernel.g.E(i.class)).acn();
      this.icw.setImageBitmap(localf.x(paramBitmap));
      AppMethodBeat.o(132765);
      return;
    }
    this.icw.setImageBitmap(null);
    AppMethodBeat.o(132765);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(132764);
    this.iJJ.setVisibility(0);
    this.iJJ.dOV();
    this.iJH.setVisibility(4);
    this.icw.setVisibility(0);
    if (this.iJN)
    {
      b.acD().a(this, paramString, null, ((i)com.tencent.mm.kernel.g.E(i.class)).a(112, 90, i.a.fpT));
      AppMethodBeat.o(132764);
      return;
    }
    b.acD().a(this, paramString, null, ((i)com.tencent.mm.kernel.g.E(i.class)).cu(112, 90));
    AppMethodBeat.o(132764);
  }
  
  public void setOnLoadImageResult(i.b paramb)
  {
    this.iJM = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(132766);
    this.iJG.setText(paramString);
    AppMethodBeat.o(132766);
  }
  
  public final String tX()
  {
    AppMethodBeat.i(132763);
    String str = n.bt(this);
    AppMethodBeat.o(132763);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(132761);
    this.iJJ.setVisibility(4);
    this.iJJ.dOW();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.icw.setImageBitmap(paramBitmap);
      this.iJH.setVisibility(4);
    }
    for (;;)
    {
      if (this.iJM != null) {
        this.iJM.kP(0);
      }
      AppMethodBeat.o(132761);
      return;
      this.icw.setImageBitmap(null);
      this.iJH.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */