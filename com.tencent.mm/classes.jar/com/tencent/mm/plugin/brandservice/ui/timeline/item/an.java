package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class an
  extends ah
{
  public ImageView vIK;
  public MMNeat7extView vIW;
  public ImageView vMs;
  public TextView vNi;
  public ImageView vNj;
  
  public final void a(int paramInt1, v paramv, final ab paramab, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    label67:
    label85:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.vIW.setVisibility(8);
      if (TextUtils.isEmpty(paramv.nVa)) {
        break label319;
      }
      this.vNi.setVisibility(0);
      this.vNi.setText(paramv.nVa);
      if (paramv.nVb != 2) {
        break label331;
      }
      this.vNj.setImageResource(d.h.chatting_item_biz_kugou_music_watermark);
      a(this.vMs, paramab, 0, paramv.nUM);
      a(this, paramab, paramv);
      Object localObject = this.vMC;
      View localView = this.vIV;
      if (paramInt1 <= 1) {
        break label344;
      }
      bool = true;
      label127:
      ((b)localObject).a(paramv, paramab, paramInt2, paramu, localView, bool, 0);
      if (!(paramab.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.d.dhS())) {
        break label350;
      }
      this.vMs.setImageResource(d.h.chatting_item_biz_music_pause_loading_icon);
      label184:
      this.vIM.setVisibility(8);
      long l = paramab.field_msgId;
      paramu = paramv.nUM;
      localObject = this.vIK;
      int i = b.vGe;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(l, 0, paramv, paramu, (ImageView)localObject, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          an.this.vIM.setVisibility(0);
          if ((paramab.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.d.dhS())) {
            an.this.vMs.setImageResource(d.d.chatting_item_biz_music_pause_selector);
          }
          for (;;)
          {
            an.this.vMC.vFN.y(paramab.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            an.this.vMs.setImageResource(d.d.chatting_item_biz_music_play_selector);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label363;
      }
      this.vIV.setBackgroundResource(d.d.chatting_item_multi_bottom);
    }
    for (;;)
    {
      paramv = this.vIV;
      if (paramInt1 <= 1) {
        break label376;
      }
      paramInt1 = b.vGg;
      paramInt2 = b.vGg;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.vIW.setVisibility(0);
      this.vIW.aZ(paramv.title);
      break;
      label319:
      this.vNi.setVisibility(8);
      break label67;
      label331:
      this.vNj.setImageResource(d.h.chatting_item_biz_qq_music_watermark);
      break label85;
      label344:
      bool = false;
      break label127;
      label350:
      this.vMs.setImageResource(d.h.chatting_item_biz_music_play_loading_icon);
      break label184;
      label363:
      this.vIV.setBackgroundResource(d.d.chatting_item_multi_middle);
    }
    label376:
    paramInt1 = b.vGg;
    paramv.setPadding(paramInt1, paramInt1, b.vGg, b.vGf);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_music_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_music_slot);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_music_click_view);
    ddp();
    this.vIK = ((ImageView)this.vJU.findViewById(d.e.cover));
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(d.e.title_tv));
    this.vNi = ((TextView)this.vJU.findViewById(d.e.player_tv));
    this.vMs = ((ImageView)this.vJU.findViewById(d.e.play_icon));
    this.vNj = ((ImageView)this.vJU.findViewById(d.e.watermark_iv));
    this.vIM = ((ImageView)this.vJU.findViewById(d.e.cover_mask_iv));
    paramView = e.vYK;
    if (e.dhV())
    {
      paramView = e.vYK;
      e.e(this.vIW);
    }
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.an
 * JD-Core Version:    0.7.0.1
 */