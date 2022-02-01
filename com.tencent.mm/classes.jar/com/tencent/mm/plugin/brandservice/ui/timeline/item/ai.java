package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.n;
import com.tencent.mm.message.o;
import com.tencent.mm.message.p;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;

public class ai
  extends a
{
  public ImageView lBC;
  public Context mContext;
  public TextView timeTV;
  public View vIV;
  public View vJU;
  public TextView vKE;
  public com.tencent.mm.plugin.brandservice.ui.timeline.b vMC;
  public View vMD;
  public View vME;
  public View vMF;
  private View.OnClickListener vMv;
  
  public ai()
  {
    AppMethodBeat.i(6020);
    this.vMv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        long l = ((com.tencent.mm.plugin.brandservice.api.b)h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).eA(paramAnonymousView);
        paramAnonymousView = af.bHl().aq(l, "msgId");
        if (paramAnonymousView != null) {
          ai.this.vMC.vFK.d(paramAnonymousView, 4);
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
  
  public static void ac(View paramView, int paramInt)
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
    this.vMC = paramb;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6021);
    a(paramView.getContext(), paramb);
    AppMethodBeat.o(6021);
  }
  
  public void a(ImageView paramImageView, ab paramab, int paramInt, String paramString)
  {
    AppMethodBeat.i(6027);
    ((com.tencent.mm.plugin.brandservice.api.b)h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(paramImageView, paramab.field_msgId, paramString, paramab.field_content, paramInt);
    paramImageView.setOnClickListener(this.vMv);
    AppMethodBeat.o(6027);
  }
  
  public void a(ab paramab, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, ab paramab, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (Util.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(paramab, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((c)h.ax(c.class)).aiz(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.nUw != null) && (!Util.isNullOrNil(localp.nUw.nUu))) {
      str1 = localp.nUw.nUu;
    }
    while (!Util.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramab, paramv, paramView, paramTextView, localp.nUx.nUr);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.nUx != null)
        {
          str1 = str2;
          if (!Util.isNullOrNil(localp.nUx.nUq)) {
            str1 = localp.nUx.nUq;
          }
        }
      }
    }
    paramView.setVisibility(8);
    paramTextView.setText("");
    a(paramab, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(ah paramah, ab paramab, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paramah.vJc, paramah.vJd, paramab, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public void ddU()
  {
    AppMethodBeat.i(6022);
    if (this.vJU == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.lBC = ((ImageView)this.vJU.findViewById(d.e.avatar_iv));
    this.vKE = ((TextView)this.vJU.findViewById(d.e.nick_name_tv));
    this.vME = this.vJU.findViewById(d.e.biz_timeline_more_v);
    this.timeTV = ((TextView)this.vJU.findViewById(d.e.time_tv));
    this.vMD = this.vJU.findViewById(d.e.biz_avatar_layout);
    this.vMF = this.vJU.findViewById(d.e.biz_title_bar_finder_live_click_layout);
    AppMethodBeat.o(6022);
  }
  
  public void eH(View paramView)
  {
    AppMethodBeat.i(6023);
    ac(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGa);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
 * JD-Core Version:    0.7.0.1
 */