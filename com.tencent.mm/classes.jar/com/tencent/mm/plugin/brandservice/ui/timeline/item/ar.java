package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class ar
  extends ah
{
  TextView vNg;
  MMNeat7extView vNx;
  private LinearLayout vNy;
  
  public final void a(int paramInt1, final v paramv, ab paramab, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    paramab.acFw = g.ajf(paramab.field_talker);
    Object localObject1;
    if (Util.isNullOrNil(paramv.title))
    {
      this.vNx.aZ("");
      this.vNx.setVisibility(8);
      paramInt3 = com.tencent.mm.cd.a.ms(this.mContext);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.vNx.pE(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label421;
      }
    }
    label415:
    label421:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).jQH();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.vNx.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.vNy.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.vNg.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.vNy.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.vNx.setMaxLines(3);
        this.vNx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
        a(this, paramab, paramv);
        localObject1 = this.vMC;
        localObject2 = this.vIV;
        if (paramInt1 <= 1) {
          break label415;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramab, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.vNx.setVisibility(0);
        this.vNx.aZ(p.j(this.mContext, paramv.title, (int)this.vNx.getTextSize()));
        break;
        boolean bool2 = this.vMC.vFS.contains(paramv);
        this.vNg.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.vNy.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.vNx.setMaxLines(2147483647);
          this.vNg.setText(d.i.biz_time_line_item_text_collapse);
        }
        for (;;)
        {
          this.vNg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (ar.this.vMC.vFS.contains(paramv))
              {
                ar.this.vNx.setMaxLines(3);
                ar.this.vNg.setText(d.i.biz_time_line_item_text_expand);
                ar.this.vMC.vFS.remove(paramv);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTopTextSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6059);
                return;
                ar.this.vNx.setMaxLines(2147483647);
                ar.this.vNg.setText(d.i.biz_time_line_item_text_collapse);
                ar.this.vMC.vFS.add(paramv);
              }
            }
          });
          break;
          this.vNx.setMaxLines(3);
          this.vNg.setText(d.i.biz_time_line_item_text_expand);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_text_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.chatting_item_biz_text);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_text_click_view);
    ddp();
    this.vNx = ((MMNeat7extView)paramView.findViewById(d.e.biz_time_line_text));
    this.vNx.setOnTouchListener(new l(this.vNx, new s(this.vNx.getContext())));
    this.vNg = ((TextView)paramView.findViewById(d.e.biz_time_line_text_expand));
    this.vNy = ((LinearLayout)paramView.findViewById(d.e.text_layout));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ar
 * JD-Core Version:    0.7.0.1
 */