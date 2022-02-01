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
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ag
  extends ai
{
  private Context mContext;
  public View plj;
  public ViewGroup uoA;
  public ImageView vIK;
  public TextView vJJ;
  public View vJU;
  public View vJc;
  public TextView vJd;
  public MMNeat7extView vMn;
  public TextView vMo;
  public View vMp;
  public View vMq;
  public ImageView vMr;
  public ImageView vMs;
  public View vMt;
  public View vMu;
  private View.OnClickListener vMv;
  
  public ag(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.vMv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        long l = ((com.tencent.mm.plugin.brandservice.api.b)h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).eA(paramAnonymousView);
        paramAnonymousView = af.bHl().aq(l, "msgId");
        if (paramAnonymousView != null) {
          ag.this.vMC.vFK.d(paramAnonymousView, 4);
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
  
  public final void a(ImageView paramImageView, ab paramab, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.api.b)h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(paramImageView, paramab.field_msgId, paramString, paramab.field_content, paramInt);
    paramImageView.setOnClickListener(this.vMv);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, ab paramab, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.vMq.setVisibility(8);
    if (paramv.type == 5)
    {
      this.vMs.setVisibility(0);
      this.vMs.setImageResource(d.d.biz_time_line_item_video_play_selector);
      this.vMs.setOnClickListener(new ag.1(this));
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 48);
      }
      paramv = this.vMs;
      paramab = paramv.getLayoutParams();
      paramab.width = paramInt;
      paramab.height = paramInt;
      paramv.setLayoutParams(paramab);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.vMs.setVisibility(0);
        if (paramBoolean) {
          if ((paramab.field_msgId + "_" + paramInt).equals(d.dhS())) {
            this.vMs.setImageResource(d.d.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          a(this.vMs, paramab, paramInt, paramv.nUM);
          break;
          this.vMs.setImageResource(d.d.chatting_item_biz_music_play_selector);
          continue;
          if ((paramab.field_msgId + "_" + paramInt).equals(d.dhS())) {
            this.vMs.setImageResource(d.h.chatting_item_biz_music_pause_loading_icon);
          } else {
            this.vMs.setImageResource(d.h.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.vMs.setVisibility(8);
        this.vMq.setVisibility(0);
        Drawable localDrawable = this.vMr.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramab.field_msgId + "_" + paramInt).equals(d.dhS()))
        {
          this.vMr.setImageResource(d.d.biz_time_line_item_voice_playing_selector);
          if ((this.vMs.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.vMs.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.vMr, paramab, paramInt, paramv.nUM);
          break;
          this.vMr.setImageResource(d.d.biz_time_line_item_voice_play_selector);
        }
      }
      this.vMs.setVisibility(8);
    }
  }
  
  public void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.vMt.setVisibility(0);
      if (paramv.nVc > 1)
      {
        this.vJJ.setVisibility(0);
        this.vJJ.setText(String.valueOf(paramv.nVc));
      }
      while (paramBoolean)
      {
        this.vMu.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
        AppMethodBeat.o(6007);
        return;
        this.vJJ.setText("");
        this.vJJ.setVisibility(8);
      }
      this.vMu.setBackgroundResource(d.d.mm_trans);
      AppMethodBeat.o(6007);
      return;
    }
    this.vMt.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ag
 * JD-Core Version:    0.7.0.1
 */