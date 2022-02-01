package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class au
  extends ak
{
  TextView sHK;
  MMNeat7extView sIb;
  private LinearLayout sIc;
  
  public final void a(int paramInt1, final v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    paramz.Vec = g.apE(paramz.field_talker);
    Object localObject1;
    if (Util.isNullOrNil(paramv.title))
    {
      this.sIb.setVisibility(8);
      paramInt3 = com.tencent.mm.ci.a.kr(this.mContext);
      int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.sIb.nH(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label412;
      }
    }
    label406:
    label412:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).ikp();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.sIb.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.sIc.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.sHK.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.sIc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.sIb.setMaxLines(3);
        this.sIb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.sDd.setBackgroundResource(d.d.spE);
        a(this, paramz, paramv);
        localObject1 = this.sHf;
        localObject2 = this.sDd;
        if (paramInt1 <= 1) {
          break label406;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.sIb.setVisibility(0);
        this.sIb.aL(l.k(this.mContext, paramv.title, (int)this.sIb.getTextSize()));
        break;
        boolean bool2 = this.sHf.sAh.contains(paramv);
        this.sHK.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.sIc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.sIb.setMaxLines(2147483647);
          this.sHK.setText(d.i.esP);
        }
        for (;;)
        {
          this.sHK.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (au.this.sHf.sAh.contains(paramv))
              {
                au.this.sIb.setMaxLines(3);
                au.this.sHK.setText(d.i.esQ);
                au.this.sHf.sAh.remove(paramv);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6059);
                return;
                au.this.sIb.setMaxLines(2147483647);
                au.this.sHK.setText(d.i.esP);
                au.this.sHf.sAh.add(paramv);
              }
            }
          });
          break;
          this.sIb.setMaxLines(3);
          this.sHK.setText(d.i.esQ);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZz);
    if (paramb == null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.dxP);
    this.sDd = paramView.findViewById(d.e.srz);
    cAo();
    this.sIb = ((MMNeat7extView)paramView.findViewById(d.e.srk));
    this.sIb.setOnTouchListener(new h(this.sIb, new o(this.sIb.getContext())));
    this.sHK = ((TextView)paramView.findViewById(d.e.srl));
    this.sIc = ((LinearLayout)paramView.findViewById(d.e.ste));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.au
 * JD-Core Version:    0.7.0.1
 */