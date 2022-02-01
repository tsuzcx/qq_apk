package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
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
    this.uqB = 2131494273;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.uqM.setText(paramc.position);
    Bitmap localBitmap = ami(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.uqN.setImageBitmap(localBitmap);
      paramb.upR.setText(paramc.field_appName);
      if (!bt.isNullOrNil(paramc.uaB)) {
        break label235;
      }
      paramb.uqQ.setVisibility(8);
      label91:
      if (bt.hj(paramc.uaK)) {
        break label257;
      }
      paramb.uqO.setVisibility(0);
      paramb.uqO.setText((CharSequence)paramc.uaK.get(0));
    }
    for (;;)
    {
      paramb.uqS.setTextSize(this.uni);
      paramb.uqR.setOnClickListener(this.unY);
      paramb.uqS.setOnClickListener(this.unY);
      paramb.uqR.setTag(paramc);
      paramb.uqS.setTag(paramc);
      this.unn.a(paramb.uqS, paramb.uqR, paramc, (l)this.uqG.get(paramc.field_appId));
      paramb.uqT.setData(paramc.uaI);
      AppMethodBeat.o(41927);
      return;
      paramb.uqN.setImageResource(2131232498);
      break;
      label235:
      paramb.uqQ.setVisibility(0);
      paramb.uqQ.setText(paramc.uaB);
      break label91;
      label257:
      if (!bt.isNullOrNil(paramc.uaN))
      {
        paramb.uqO.setVisibility(0);
        paramb.uqO.setText(paramc.uaN);
      }
      try
      {
        paramb.uqO.setBackgroundDrawable(e.eU(Color.parseColor(paramc.uaO), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ad.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.uqO.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */