package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.f;
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
    this.ISw = h.f.HYP;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.ISH.setText(paramc.position);
    Bitmap localBitmap = aHb(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.ISI.setImageBitmap(localBitmap);
      paramb.IRM.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.ICg)) {
        break label236;
      }
      paramb.ISL.setVisibility(8);
      label91:
      if (Util.isNullOrNil(paramc.ICp)) {
        break label258;
      }
      paramb.ISJ.setVisibility(0);
      paramb.ISJ.setText((CharSequence)paramc.ICp.get(0));
    }
    for (;;)
    {
      paramb.ISN.setTextSize(this.IPf);
      paramb.ISM.setOnClickListener(this.IPV);
      paramb.ISN.setOnClickListener(this.IPV);
      paramb.ISM.setTag(paramc);
      paramb.ISN.setTag(paramc);
      this.IPk.a(paramb.ISN, paramb.ISM, paramc, (l)this.ISB.get(paramc.field_appId));
      paramb.ISO.setData(paramc.ICn);
      AppMethodBeat.o(41927);
      return;
      paramb.ISI.setImageResource(h.d.HTo);
      break;
      label236:
      paramb.ISL.setVisibility(0);
      paramb.ISL.setText(paramc.ICg);
      break label91;
      label258:
      if (!Util.isNullOrNil(paramc.ICs))
      {
        paramb.ISJ.setVisibility(0);
        paramb.ISJ.setText(paramc.ICs);
      }
      try
      {
        paramb.ISJ.setBackgroundDrawable(e.gx(Color.parseColor(paramc.ICt), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.ISJ.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */