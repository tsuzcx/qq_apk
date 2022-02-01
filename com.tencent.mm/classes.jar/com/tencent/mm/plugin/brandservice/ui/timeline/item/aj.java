package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class aj
  extends al
{
  private Context mContext;
  public View mrE;
  public ViewGroup rgA;
  public ImageView sCR;
  public TextView sDY;
  public View sDk;
  public TextView sDl;
  public View sEi;
  public MMNeat7extView sGQ;
  public TextView sGR;
  public View sGS;
  public View sGT;
  public ImageView sGU;
  public ImageView sGV;
  public View sGW;
  public View sGX;
  private View.OnClickListener sGY;
  
  public aj(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.sGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        long l = ((com.tencent.mm.plugin.brandservice.a.b)h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN(paramAnonymousView);
        paramAnonymousView = af.bjB().ad(l, "msgId");
        if (paramAnonymousView != null) {
          aj.this.sHf.szZ.g(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6002);
          return;
          Log.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    super.a(paramContext, paramb);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  public final void a(ImageView paramImageView, z paramz, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.b)h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramImageView, paramz.field_msgId, paramString, paramz.field_content, paramInt);
    paramImageView.setOnClickListener(this.sGY);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, z paramz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.sGT.setVisibility(8);
    if (paramv.type == 5)
    {
      this.sGV.setVisibility(0);
      this.sGV.setImageResource(d.d.dmx);
      this.sGV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          aj.this.sEi.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6001);
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 48);
      }
      paramv = this.sGV;
      paramz = paramv.getLayoutParams();
      paramz.width = paramInt;
      paramz.height = paramInt;
      paramv.setLayoutParams(paramz);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.sGV.setVisibility(0);
        if (paramBoolean) {
          if ((paramz.field_msgId + "_" + paramInt).equals(c.cEq())) {
            this.sGV.setImageResource(d.d.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          a(this.sGV, paramz, paramInt, paramv.lpK);
          break;
          this.sGV.setImageResource(d.d.chatting_item_biz_music_play_selector);
          continue;
          if ((paramz.field_msgId + "_" + paramInt).equals(c.cEq())) {
            this.sGV.setImageResource(d.h.chatting_item_biz_music_pause_loading_icon);
          } else {
            this.sGV.setImageResource(d.h.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.sGV.setVisibility(8);
        this.sGT.setVisibility(0);
        Drawable localDrawable = this.sGU.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramz.field_msgId + "_" + paramInt).equals(c.cEq()))
        {
          this.sGU.setImageResource(d.d.dmz);
          if ((this.sGV.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.sGV.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.sGU, paramz, paramInt, paramv.lpK);
          break;
          this.sGU.setImageResource(d.d.dmy);
        }
      }
      this.sGV.setVisibility(8);
    }
  }
  
  public void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.sGW.setVisibility(0);
      if (paramv.lqa > 1)
      {
        this.sDY.setVisibility(0);
        this.sDY.setText(String.valueOf(paramv.lqa));
      }
      while (paramBoolean)
      {
        this.sGX.setBackgroundResource(d.d.dmA);
        AppMethodBeat.o(6007);
        return;
        this.sDY.setVisibility(8);
      }
      this.sGX.setBackgroundResource(d.d.mm_trans);
      AppMethodBeat.o(6007);
      return;
    }
    this.sGW.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
 * JD-Core Version:    0.7.0.1
 */