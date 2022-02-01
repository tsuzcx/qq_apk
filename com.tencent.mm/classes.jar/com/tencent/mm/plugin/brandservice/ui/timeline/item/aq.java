package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aq
  extends ak
{
  public ImageView sCR;
  public MMNeat7extView sDe;
  public ImageView sGV;
  public TextView sHM;
  public ImageView sHN;
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    label67:
    label85:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.sDe.setVisibility(8);
      if (TextUtils.isEmpty(paramv.lpY)) {
        break label330;
      }
      this.sHM.setVisibility(0);
      this.sHM.setText(paramv.lpY);
      if (paramv.lpZ != 2) {
        break label342;
      }
      this.sHN.setImageResource(d.h.chatting_item_biz_kugou_music_watermark);
      a(this.sGV, paramz, 0, paramv.lpK);
      a(this, paramz, paramv);
      Object localObject1 = this.sHf;
      Object localObject2 = this.sDd;
      if (paramInt1 <= 1) {
        break label355;
      }
      bool = true;
      label127:
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(paramz.field_msgId + "_0").equals(c.cEq())) {
        break label361;
      }
      this.sGV.setImageResource(d.h.chatting_item_biz_music_pause_loading_icon);
      label184:
      this.sCT.setVisibility(8);
      paramu = this.sHf.sAc;
      long l = paramz.field_msgId;
      localObject1 = paramv.lpK;
      localObject2 = this.sCR;
      int i = b.sAs;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          aq.this.sCT.setVisibility(0);
          if ((paramz.field_msgId + "_0").equals(c.cEq())) {
            aq.this.sGV.setImageResource(d.d.chatting_item_biz_music_pause_selector);
          }
          for (;;)
          {
            aq.this.sHf.sAc.p(paramz.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            aq.this.sGV.setImageResource(d.d.chatting_item_biz_music_play_selector);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label374;
      }
      this.sDd.setBackgroundResource(d.d.chatting_item_multi_bottom);
    }
    for (;;)
    {
      paramv = this.sDd;
      if (paramInt1 <= 1) {
        break label387;
      }
      paramInt1 = b.sAu;
      paramInt2 = b.sAu;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.sDe.setVisibility(0);
      this.sDe.aL(paramv.title);
      break;
      label330:
      this.sHM.setVisibility(8);
      break label67;
      label342:
      this.sHN.setImageResource(d.h.chatting_item_biz_qq_music_watermark);
      break label85;
      label355:
      bool = false;
      break label127;
      label361:
      this.sGV.setImageResource(d.h.chatting_item_biz_music_play_loading_icon);
      break label184;
      label374:
      this.sDd.setBackgroundResource(d.d.chatting_item_multi_middle);
    }
    label387:
    paramInt1 = b.sAu;
    paramv.setPadding(paramInt1, paramInt1, b.sAu, b.sAt);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZw);
    if (paramb == null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqL);
    this.sDd = paramView.findViewById(d.e.srx);
    cAo();
    this.sCR = ((ImageView)this.sEi.findViewById(d.e.cover));
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(d.e.title_tv));
    this.sHM = ((TextView)this.sEi.findViewById(d.e.dRi));
    this.sGV = ((ImageView)this.sEi.findViewById(d.e.play_icon));
    this.sHN = ((ImageView)this.sEi.findViewById(d.e.eaw));
    this.sCT = ((ImageView)this.sEi.findViewById(d.e.dCV));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.e(this.sDe);
    }
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aq
 * JD-Core Version:    0.7.0.1
 */