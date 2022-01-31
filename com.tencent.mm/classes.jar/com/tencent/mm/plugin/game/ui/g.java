package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.nAO = 2130969721;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(111760);
    paramb.nAZ.setText(paramc.position);
    Bitmap localBitmap = Qp(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.nBa.setImageBitmap(localBitmap);
      paramb.nAb.setText(paramc.field_appName);
      if (!bo.isNullOrNil(paramc.nlU)) {
        break label235;
      }
      paramb.nBd.setVisibility(8);
      label91:
      if (bo.es(paramc.nme)) {
        break label257;
      }
      paramb.nBb.setVisibility(0);
      paramb.nBb.setText((CharSequence)paramc.nme.get(0));
    }
    for (;;)
    {
      paramb.nBf.setTextSize(this.nxr);
      paramb.nBe.setOnClickListener(this.nyh);
      paramb.nBf.setOnClickListener(this.nyh);
      paramb.nBe.setTag(paramc);
      paramb.nBf.setTag(paramc);
      this.nxw.a(paramb.nBf, paramb.nBe, paramc, (k)this.nAT.get(paramc.field_appId));
      paramb.nBg.setData(paramc.nmc);
      AppMethodBeat.o(111760);
      return;
      paramb.nBa.setImageResource(2130838963);
      break;
      label235:
      paramb.nBd.setVisibility(0);
      paramb.nBd.setText(paramc.nlU);
      break label91;
      label257:
      if (!bo.isNullOrNil(paramc.nmh))
      {
        paramb.nBb.setVisibility(0);
        paramb.nBb.setText(paramc.nmh);
      }
      try
      {
        paramb.nBb.setBackgroundDrawable(e.dR(Color.parseColor(paramc.nmi), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ab.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.nBb.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */