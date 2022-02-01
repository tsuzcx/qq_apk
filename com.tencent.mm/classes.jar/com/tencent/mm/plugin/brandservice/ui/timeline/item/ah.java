package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class ah
  extends x
{
  TextView ofL;
  MMNeat7extView ogc;
  private LinearLayout ogd;
  
  public final void a(int paramInt1, final v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    paramw.Ioo = e.Xh(paramw.field_talker);
    Object localObject1;
    if (bt.isNullOrNil(paramv.title))
    {
      this.ogc.setVisibility(8);
      paramInt3 = com.tencent.mm.cc.a.ip(this.mContext);
      int i = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.ogc.kK(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label409;
      }
    }
    label403:
    label409:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).fSB();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.ogc.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.ogd.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.ofL.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.ogd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.ogc.setMaxLines(3);
        this.ogc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.ocz.setBackgroundResource(2131231256);
        a(this, paramw, paramv);
        localObject1 = this.ofm;
        localObject2 = this.ocz;
        if (paramInt1 <= 1) {
          break label403;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.ogc.setVisibility(0);
        this.ogc.ar(k.g(this.mContext, paramv.title, (int)this.ogc.getTextSize()));
        break;
        boolean bool2 = this.ofm.oaD.contains(paramv);
        this.ofL.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.ogd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.ogc.setMaxLines(2147483647);
          this.ofL.setText(2131756619);
        }
        for (;;)
        {
          this.ofL.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (ah.this.ofm.oaD.contains(paramv))
              {
                ah.this.ogc.setMaxLines(3);
                ah.this.ofL.setText(2131756620);
                ah.this.ofm.oaD.remove(paramv);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6059);
                return;
                ah.this.ogc.setMaxLines(2147483647);
                ah.this.ofL.setText(2131756619);
                ah.this.ofm.oaD.add(paramv);
              }
            }
          });
          break;
          this.ogc.setMaxLines(3);
          this.ofL.setText(2131756620);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306454);
    if (paramb == null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131298109);
    this.ocz = paramView.findViewById(2131298110);
    bOx();
    this.ogc = ((MMNeat7extView)paramView.findViewById(2131297361));
    this.ogc.setOnTouchListener(new g(this.ogc, new n(this.ogc.getContext())));
    this.ofL = ((TextView)paramView.findViewById(2131297362));
    this.ogd = ((LinearLayout)paramView.findViewById(2131305733));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
 * JD-Core Version:    0.7.0.1
 */