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
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.xTV = 2131494834;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.xUg.setText(paramc.position);
    Bitmap localBitmap = aAz(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.xUh.setImageBitmap(localBitmap);
      paramb.xTl.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.xDV)) {
        break label235;
      }
      paramb.xUk.setVisibility(8);
      label91:
      if (Util.isNullOrNil(paramc.xEe)) {
        break label257;
      }
      paramb.xUi.setVisibility(0);
      paramb.xUi.setText((CharSequence)paramc.xEe.get(0));
    }
    for (;;)
    {
      paramb.xUm.setTextSize(this.xQD);
      paramb.xUl.setOnClickListener(this.xRt);
      paramb.xUm.setOnClickListener(this.xRt);
      paramb.xUl.setTag(paramc);
      paramb.xUm.setTag(paramc);
      this.xQI.a(paramb.xUm, paramb.xUl, paramc, (l)this.xUa.get(paramc.field_appId));
      paramb.xUn.setData(paramc.xEc);
      AppMethodBeat.o(41927);
      return;
      paramb.xUh.setImageResource(2131232887);
      break;
      label235:
      paramb.xUk.setVisibility(0);
      paramb.xUk.setText(paramc.xDV);
      break label91;
      label257:
      if (!Util.isNullOrNil(paramc.xEh))
      {
        paramb.xUi.setVisibility(0);
        paramb.xUi.setText(paramc.xEh);
      }
      try
      {
        paramb.xUi.setBackgroundDrawable(e.fi(Color.parseColor(paramc.xEi), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.xUi.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */