package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.p;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;

public class al
  extends a
{
  public ImageView iZG;
  public Context mContext;
  public View sDd;
  public TextView sEX;
  public View sEi;
  private View.OnClickListener sGY;
  public com.tencent.mm.plugin.brandservice.ui.timeline.b sHf;
  public View sHg;
  public View sHh;
  public View sHi;
  public TextView timeTV;
  
  public al()
  {
    AppMethodBeat.i(6020);
    this.sGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        long l = ((com.tencent.mm.plugin.brandservice.a.b)h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN(paramAnonymousView);
        paramAnonymousView = af.bjB().ad(l, "msgId");
        if (paramAnonymousView != null) {
          al.this.sHf.szZ.g(paramAnonymousView, 4);
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
  
  public static void Y(View paramView, int paramInt)
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
    this.sHf = paramb;
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
    ((com.tencent.mm.plugin.brandservice.a.b)h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramImageView, paramz.field_msgId, paramString, paramz.field_content, paramInt);
    paramImageView.setOnClickListener(this.sGY);
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
    p localp = ((c)h.ae(c.class)).apc(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.lpt != null) && (!Util.isNullOrNil(localp.lpt.lpr))) {
      str1 = localp.lpt.lpr;
    }
    while (!Util.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramz, paramv, paramView, paramTextView, localp.lpu.lpo);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.lpu != null)
        {
          str1 = str2;
          if (!Util.isNullOrNil(localp.lpu.lpn)) {
            str1 = localp.lpu.lpn;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(paramz, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(ak paramak, z paramz, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paramak.sDk, paramak.sDl, paramz, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public void cAQ()
  {
    AppMethodBeat.i(6022);
    if (this.sEi == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.iZG = ((ImageView)this.sEi.findViewById(d.e.avatar_iv));
    this.sEX = ((TextView)this.sEi.findViewById(d.e.nick_name_tv));
    this.sHh = this.sEi.findViewById(d.e.sru);
    this.timeTV = ((TextView)this.sEi.findViewById(d.e.time_tv));
    this.sHg = this.sEi.findViewById(d.e.spQ);
    this.sHi = this.sEi.findViewById(d.e.srv);
    AppMethodBeat.o(6022);
  }
  
  public void dU(View paramView)
  {
    AppMethodBeat.i(6023);
    Y(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAo);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.al
 * JD-Core Version:    0.7.0.1
 */