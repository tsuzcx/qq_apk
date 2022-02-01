package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.m;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class at
  extends ah
{
  public MMNeat7extView vIW;
  public MMNeat7extView vJy;
  public ImageView vMs;
  public TextView vNC;
  
  public final void a(int paramInt1, v paramv, ab paramab, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramab, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.vMz = true;
    label121:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.vIW.aZ(this.mContext.getResources().getString(d.i.biz_time_line_item_voice_default_title));
      if ((Util.isNullOrNil(paramv.nUO)) || (this.mCount != 1)) {
        break label401;
      }
      Object localObject = d.ake(paramv.nUO);
      this.vJy.setVisibility(0);
      this.vJy.setMaxLines(2);
      this.vJy.setEllipsize(TextUtils.TruncateAt.END);
      this.vJy.aZ((CharSequence)localObject);
      localObject = m.uD(paramv.nUQ);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label413;
      }
      this.vNC.setVisibility(0);
      this.vNC.setText((CharSequence)localObject);
      label155:
      localObject = this.vMs.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramab.field_msgId + "_0").equals(d.dhS())) {
        break label425;
      }
      this.vMs.setImageResource(d.d.biz_time_line_item_voice_playing_selector);
      if ((this.vMs.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.vMs.getDrawable()).start();
      }
      label258:
      a(this.vMs, paramab, 0, paramv.nUM);
      a(this, paramab, paramv);
      localObject = this.vMC;
      View localView = this.vIV;
      if (this.mCount <= 1) {
        break label438;
      }
      bool = true;
      label303:
      ((b)localObject).a(paramv, paramab, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label444;
      }
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramv.nUO)) {
        break label457;
      }
      this.vIV.setPadding(this.vIV.getPaddingLeft(), 0, this.vIV.getPaddingRight(), b.vGf);
      AppMethodBeat.o(6067);
      return;
      this.vIW.setVisibility(0);
      this.vIW.aZ(paramv.title);
      break;
      label401:
      this.vJy.setVisibility(8);
      break label121;
      label413:
      this.vNC.setVisibility(8);
      break label155;
      label425:
      this.vMs.setImageResource(d.d.biz_time_line_item_voice_play_selector);
      break label258;
      label438:
      bool = false;
      break label303;
      label444:
      this.vIV.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
    }
    label457:
    this.vIV.setPadding(this.vIV.getPaddingLeft(), b.vGi, this.vIV.getPaddingRight(), b.vGf);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramb);
    if (this.vJU != null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.viewstub_top_voice_slot);
    if (paramb == null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb.inflate();
    this.vJU = paramView.findViewById(d.e.biz_time_line_item_voice_slot);
    this.vIV = paramView.findViewById(d.e.chatting_item_biz_voice_click_view);
    ddp();
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(d.e.title_tv));
    this.vNC = ((TextView)this.vJU.findViewById(d.e.play_time_tv));
    this.vMs = ((ImageView)this.vJU.findViewById(d.e.big_play_icon));
    this.vJy = ((MMNeat7extView)this.vJU.findViewById(d.e.biz_time_line_item_voice_digest));
    paramView = e.vYK;
    if (e.dhV())
    {
      paramView = e.vYK;
      e.e(this.vIW);
    }
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.at
 * JD-Core Version:    0.7.0.1
 */