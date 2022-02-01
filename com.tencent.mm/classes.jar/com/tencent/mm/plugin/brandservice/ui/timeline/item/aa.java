package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;

public class aa
{
  public ImageView fQl;
  public TextView fVV;
  public Context mContext;
  public View oiV;
  public View oio;
  public TextView ojK;
  private View.OnClickListener ola;
  public com.tencent.mm.plugin.brandservice.ui.timeline.b oll;
  public View olm;
  public View oln;
  
  public aa()
  {
    AppMethodBeat.i(6020);
    this.ola = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz(paramAnonymousView);
        paramAnonymousView = ag.aGv().N(l, "msgId");
        if (paramAnonymousView != null) {
          aa.this.oll.ogr.d(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6019);
          return;
          ae.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
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
    paramImageView.setOnClickListener(this.ola);
    AppMethodBeat.o(6027);
  }
  
  public void a(w paramw, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, w paramw, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (bu.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(paramw, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xz(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.hFP != null) && (!bu.isNullOrNil(localp.hFP.hFN))) {
      str1 = localp.hFP.hFN;
    }
    while (!bu.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramw, paramv, paramView, paramTextView, localp.hFQ.hFK);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.hFQ != null)
        {
          str1 = str2;
          if (!bu.isNullOrNil(localp.hFQ.hFJ)) {
            str1 = localp.hFQ.hFJ;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(paramw, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(y paramy, w paramw, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paramy.oiv, paramy.oiw, paramw, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.mContext = paramContext;
    this.oll = paramb;
  }
  
  public void bPJ()
  {
    AppMethodBeat.i(6022);
    if (this.oiV == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.fQl = ((ImageView)this.oiV.findViewById(2131297008));
    this.ojK = ((TextView)this.oiV.findViewById(2131302860));
    this.oln = this.oiV.findViewById(2131297371);
    this.fVV = ((TextView)this.oiV.findViewById(2131305822));
    this.olm = this.oiV.findViewById(2131297276);
    AppMethodBeat.o(6022);
  }
  
  public void dF(View paramView)
  {
    AppMethodBeat.i(6023);
    X(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b.ofT);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aa
 * JD-Core Version:    0.7.0.1
 */