package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class x
  extends aa
{
  public View iFF;
  private Context mContext;
  public View oiV;
  public ImageView oic;
  public View oiv;
  public TextView oiw;
  public View okQ;
  public MMNeat7extView okR;
  public TextView okS;
  public View okT;
  public View okU;
  public ImageView okV;
  public ImageView okW;
  public View okX;
  public View okY;
  public TextView okZ;
  private View.OnClickListener ola;
  
  public x(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.ola = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz(paramAnonymousView);
        paramAnonymousView = ag.aGv().N(l, "msgId");
        if (paramAnonymousView != null) {
          x.this.oll.ogr.d(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6002);
          return;
          ae.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    super.b(paramContext, paramb);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  private static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(6005);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6005);
  }
  
  public final void a(ImageView paramImageView, w paramw, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramw.field_msgId, paramString, paramw.field_content, paramInt);
    paramImageView.setOnClickListener(this.ola);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, w paramw, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.okU.setVisibility(8);
    if (paramv.type == 5)
    {
      this.okW.setVisibility(0);
      this.okW.setImageResource(2131231270);
      this.okW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          x.this.oiV.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6001);
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
      }
      W(this.okW, paramInt);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.okW.setVisibility(0);
        if (paramBoolean) {
          if ((paramw.field_msgId + "_" + paramInt).equals(c.bTw())) {
            this.okW.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(this.okW, paramw, paramInt, paramv.hGe);
          break;
          this.okW.setImageResource(2131231673);
          continue;
          if ((paramw.field_msgId + "_" + paramInt).equals(c.bTw())) {
            this.okW.setImageResource(2131689906);
          } else {
            this.okW.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.okW.setVisibility(8);
        this.okU.setVisibility(0);
        Drawable localDrawable = this.okV.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramw.field_msgId + "_" + paramInt).equals(c.bTw()))
        {
          this.okV.setImageResource(2131231272);
          if ((this.okW.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.okW.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.okV, paramw, paramInt, paramv.hGe);
          break;
          this.okV.setImageResource(2131231271);
        }
      }
      this.okW.setVisibility(8);
    }
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.okX.setVisibility(0);
      if (paramv.hGu > 1)
      {
        this.okZ.setVisibility(0);
        this.okZ.setText(String.valueOf(paramv.hGu));
      }
      while (paramBoolean)
      {
        this.okY.setBackgroundResource(2131231282);
        AppMethodBeat.o(6007);
        return;
        this.okZ.setVisibility(8);
      }
      this.okY.setBackgroundResource(2131233299);
      AppMethodBeat.o(6007);
      return;
    }
    this.okX.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x
 * JD-Core Version:    0.7.0.1
 */