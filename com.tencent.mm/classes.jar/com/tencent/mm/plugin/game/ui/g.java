package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.skl = 2131494273;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.skw.setText(paramc.position);
    Bitmap localBitmap = acO(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.skx.setImageBitmap(localBitmap);
      paramb.sjB.setText(paramc.field_appName);
      if (!bt.isNullOrNil(paramc.rUT)) {
        break label235;
      }
      paramb.skA.setVisibility(8);
      label91:
      if (bt.gL(paramc.rVc)) {
        break label257;
      }
      paramb.sky.setVisibility(0);
      paramb.sky.setText((CharSequence)paramc.rVc.get(0));
    }
    for (;;)
    {
      paramb.skC.setTextSize(this.sgR);
      paramb.skB.setOnClickListener(this.shH);
      paramb.skC.setOnClickListener(this.shH);
      paramb.skB.setTag(paramc);
      paramb.skC.setTag(paramc);
      this.sgW.a(paramb.skC, paramb.skB, paramc, (l)this.skq.get(paramc.field_appId));
      paramb.skD.setData(paramc.rVa);
      AppMethodBeat.o(41927);
      return;
      paramb.skx.setImageResource(2131232498);
      break;
      label235:
      paramb.skA.setVisibility(0);
      paramb.skA.setText(paramc.rUT);
      break label91;
      label257:
      if (!bt.isNullOrNil(paramc.rVf))
      {
        paramb.sky.setVisibility(0);
        paramb.sky.setText(paramc.rVf);
      }
      try
      {
        paramb.sky.setBackgroundDrawable(e.eN(Color.parseColor(paramc.rVg), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ad.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.sky.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */