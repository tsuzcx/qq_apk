package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class as
  extends ai
{
  TextView pyh;
  MMNeat7extView pyy;
  private LinearLayout pyz;
  
  public final void a(int paramInt1, final v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    paramz.NQk = f.ahR(paramz.field_talker);
    Object localObject1;
    if (Util.isNullOrNil(paramv.title))
    {
      this.pyy.setVisibility(8);
      paramInt3 = com.tencent.mm.cb.a.jn(this.mContext);
      int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.pyy.mq(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label409;
      }
    }
    label403:
    label409:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).hiG();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.pyy.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.pyz.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.pyh.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.pyz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.pyy.setMaxLines(3);
        this.pyy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.ptQ.setBackgroundResource(2131231316);
        a(this, paramz, paramv);
        localObject1 = this.pxE;
        localObject2 = this.ptQ;
        if (paramInt1 <= 1) {
          break label403;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.pyy.setVisibility(0);
        this.pyy.aw(l.j(this.mContext, paramv.title, (int)this.pyy.getTextSize()));
        break;
        boolean bool2 = this.pxE.prh.contains(paramv);
        this.pyh.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.pyz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.pyy.setMaxLines(2147483647);
          this.pyh.setText(2131756767);
        }
        for (;;)
        {
          this.pyh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (as.this.pxE.prh.contains(paramv))
              {
                as.this.pyy.setMaxLines(3);
                as.this.pyh.setText(2131756768);
                as.this.pxE.prh.remove(paramv);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6059);
                return;
                as.this.pyy.setMaxLines(2147483647);
                as.this.pyh.setText(2131756767);
                as.this.pxE.prh.add(paramv);
              }
            }
          });
          break;
          this.pyy.setMaxLines(3);
          this.pyh.setText(2131756768);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309897);
    if (paramb == null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131298459);
    this.ptQ = paramView.findViewById(2131298460);
    cmH();
    this.pyy = ((MMNeat7extView)paramView.findViewById(2131297579));
    this.pyy.setOnTouchListener(new h(this.pyy, new o(this.pyy.getContext())));
    this.pyh = ((TextView)paramView.findViewById(2131297580));
    this.pyz = ((LinearLayout)paramView.findViewById(2131309000));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.as
 * JD-Core Version:    0.7.0.1
 */