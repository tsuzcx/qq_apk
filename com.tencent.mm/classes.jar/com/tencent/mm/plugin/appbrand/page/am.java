package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;

public final class am
  extends RelativeLayout
{
  TextView mMu;
  ImageView oFa;
  TextView qtT;
  Button qtU;
  ImageView qtV;
  
  public am(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(au.g.app_brand_single_page_mode_footer, this);
    this.oFa = ((ImageView)paramContext.findViewById(au.f.icon));
    this.mMu = ((TextView)paramContext.findViewById(au.f.name));
    this.qtT = ((TextView)paramContext.findViewById(au.f.debug_type_desc));
    this.qtU = ((Button)paramContext.findViewById(au.f.btn));
    this.qtV = ((ImageView)paramContext.findViewById(au.f.original));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.qtU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */