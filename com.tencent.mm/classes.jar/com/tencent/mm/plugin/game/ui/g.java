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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.uBX = 2131494273;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.uCi.setText(paramc.position);
    Bitmap localBitmap = ani(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.uCj.setImageBitmap(localBitmap);
      paramb.uBn.setText(paramc.field_appName);
      if (!bu.isNullOrNil(paramc.ulD)) {
        break label235;
      }
      paramb.uCm.setVisibility(8);
      label91:
      if (bu.ht(paramc.ulM)) {
        break label257;
      }
      paramb.uCk.setVisibility(0);
      paramb.uCk.setText((CharSequence)paramc.ulM.get(0));
    }
    for (;;)
    {
      paramb.uCo.setTextSize(this.uyE);
      paramb.uCn.setOnClickListener(this.uzu);
      paramb.uCo.setOnClickListener(this.uzu);
      paramb.uCn.setTag(paramc);
      paramb.uCo.setTag(paramc);
      this.uyJ.a(paramb.uCo, paramb.uCn, paramc, (l)this.uCc.get(paramc.field_appId));
      paramb.uCp.setData(paramc.ulK);
      AppMethodBeat.o(41927);
      return;
      paramb.uCj.setImageResource(2131232498);
      break;
      label235:
      paramb.uCm.setVisibility(0);
      paramb.uCm.setText(paramc.ulD);
      break label91;
      label257:
      if (!bu.isNullOrNil(paramc.ulP))
      {
        paramb.uCk.setVisibility(0);
        paramb.uCk.setText(paramc.ulP);
      }
      try
      {
        paramb.uCk.setBackgroundDrawable(e.eV(Color.parseColor(paramc.ulQ), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ae.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.uCk.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */