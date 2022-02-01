package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.o;
import com.tencent.mm.ag.p;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;

public class aj
  extends a
{
  public ImageView gvv;
  public Context mContext;
  public View ptQ;
  public View puO;
  public TextView pvG;
  public com.tencent.mm.plugin.brandservice.ui.timeline.b pxE;
  public View pxF;
  public View pxG;
  private View.OnClickListener pxx;
  public TextView timeTV;
  
  public aj()
  {
    AppMethodBeat.i(6020);
    this.pxx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(paramAnonymousView);
        paramAnonymousView = ag.ban().R(l, "msgId");
        if (paramAnonymousView != null) {
          aj.this.pxE.pqZ.f(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6019);
          return;
          Log.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    AppMethodBeat.o(6020);
  }
  
  public static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(6024);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6024);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.mContext = paramContext;
    this.pxE = paramb;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6021);
    a(paramView.getContext(), paramb);
    AppMethodBeat.o(6021);
  }
  
  public void a(ImageView paramImageView, z paramz, int paramInt, String paramString)
  {
    AppMethodBeat.i(6027);
    ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramz.field_msgId, paramString, paramz.field_content, paramInt);
    paramImageView.setOnClickListener(this.pxx);
    AppMethodBeat.o(6027);
  }
  
  public void a(z paramz, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, z paramz, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (Util.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(paramz, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahw(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.izY != null) && (!Util.isNullOrNil(localp.izY.izW))) {
      str1 = localp.izY.izW;
    }
    while (!Util.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramz, paramv, paramView, paramTextView, localp.izZ.izT);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.izZ != null)
        {
          str1 = str2;
          if (!Util.isNullOrNil(localp.izZ.izS)) {
            str1 = localp.izZ.izS;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(paramz, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(ai paramai, z paramz, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paramai.ptX, paramai.ptY, paramz, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public void cne()
  {
    AppMethodBeat.i(6022);
    if (this.puO == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.gvv = ((ImageView)this.puO.findViewById(2131297134));
    this.pvG = ((TextView)this.puO.findViewById(2131305433));
    this.pxG = this.puO.findViewById(2131297589);
    this.timeTV = ((TextView)this.puO.findViewById(2131309101));
    this.pxF = this.puO.findViewById(2131297433);
    AppMethodBeat.o(6022);
  }
  
  public void dw(View paramView)
  {
    AppMethodBeat.i(6023);
    W(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b.prq);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
 * JD-Core Version:    0.7.0.1
 */