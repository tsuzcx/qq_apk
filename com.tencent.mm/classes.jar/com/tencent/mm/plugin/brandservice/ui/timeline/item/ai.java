package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class ai
  extends y
{
  TextView olJ;
  MMNeat7extView oma;
  private LinearLayout omb;
  
  public final void a(int paramInt1, final v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    paramw.IIE = e.XT(paramw.field_talker);
    Object localObject1;
    if (bu.isNullOrNil(paramv.title))
    {
      this.oma.setVisibility(8);
      paramInt3 = com.tencent.mm.cb.a.iu(this.mContext);
      int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.oma.kR(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label409;
      }
    }
    label403:
    label409:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).fXb();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.oma.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.omb.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.olJ.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.omb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.oma.setMaxLines(3);
        this.oma.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.oio.setBackgroundResource(2131231256);
        a(this, paramw, paramv);
        localObject1 = this.oll;
        localObject2 = this.oio;
        if (paramInt1 <= 1) {
          break label403;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.oma.setVisibility(0);
        this.oma.aq(k.g(this.mContext, paramv.title, (int)this.oma.getTextSize()));
        break;
        boolean bool2 = this.oll.ogt.contains(paramv);
        this.olJ.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.omb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.oma.setMaxLines(2147483647);
          this.olJ.setText(2131756619);
        }
        for (;;)
        {
          this.olJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (ai.this.oll.ogt.contains(paramv))
              {
                ai.this.oma.setMaxLines(3);
                ai.this.olJ.setText(2131756620);
                ai.this.oll.ogt.remove(paramv);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6059);
                return;
                ai.this.oma.setMaxLines(2147483647);
                ai.this.olJ.setText(2131756619);
                ai.this.oll.ogt.add(paramv);
              }
            }
          });
          break;
          this.oma.setMaxLines(3);
          this.olJ.setText(2131756620);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramb);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131298109);
    this.oio = paramView.findViewById(2131298110);
    bPv();
    this.oma = ((MMNeat7extView)paramView.findViewById(2131297361));
    this.oma.setOnTouchListener(new g(this.oma, new n(this.oma.getContext())));
    this.olJ = ((TextView)paramView.findViewById(2131297362));
    this.omb = ((LinearLayout)paramView.findViewById(2131305733));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
 * JD-Core Version:    0.7.0.1
 */