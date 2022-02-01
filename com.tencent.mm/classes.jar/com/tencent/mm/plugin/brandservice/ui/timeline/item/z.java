package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;

public class z
{
  public ImageView fOf;
  public TextView fTP;
  public Context mContext;
  public View ocz;
  public TextView odU;
  public View odh;
  private View.OnClickListener ofa;
  public com.tencent.mm.plugin.brandservice.ui.timeline.b ofm;
  public View ofn;
  public View ofo;
  
  public z()
  {
    AppMethodBeat.i(6020);
    this.ofa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz(paramAnonymousView);
        paramAnonymousView = ag.aGf().M(l, "msgId");
        if (paramAnonymousView != null) {
          z.this.ofm.oaB.d(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6019);
          return;
          ad.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    AppMethodBeat.o(6020);
  }
  
  public static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(6024);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6024);
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6021);
    b(paramView.getContext(), paramb);
    AppMethodBeat.o(6021);
  }
  
  public void a(ImageView paramImageView, w paramw, int paramInt, String paramString)
  {
    AppMethodBeat.i(6027);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramw.field_msgId, paramString, paramw.field_content, paramInt);
    paramImageView.setOnClickListener(this.ofa);
    AppMethodBeat.o(6027);
  }
  
  public void a(w paramw, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, w paramw, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (bt.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(paramw, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WN(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.hCX != null) && (!bt.isNullOrNil(localp.hCX.hCV))) {
      str1 = localp.hCX.hCV;
    }
    while (!bt.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramw, paramv, paramView, paramTextView, localp.hCY.hCS);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.hCY != null)
        {
          str1 = str2;
          if (!bt.isNullOrNil(localp.hCY.hCR)) {
            str1 = localp.hCY.hCR;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(paramw, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(x paramx, w paramw, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paramx.ocG, paramx.ocH, paramw, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.mContext = paramContext;
    this.ofm = paramb;
  }
  
  public void bOL()
  {
    AppMethodBeat.i(6022);
    if (this.odh == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.fOf = ((ImageView)this.odh.findViewById(2131297008));
    this.odU = ((TextView)this.odh.findViewById(2131302860));
    this.ofo = this.odh.findViewById(2131297371);
    this.fTP = ((TextView)this.odh.findViewById(2131305822));
    this.ofn = this.odh.findViewById(2131297276);
    AppMethodBeat.o(6022);
  }
  
  public void dF(View paramView)
  {
    AppMethodBeat.i(6023);
    X(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b.oad);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.z
 * JD-Core Version:    0.7.0.1
 */