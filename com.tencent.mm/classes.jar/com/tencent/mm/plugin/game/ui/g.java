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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.tse = 2131494273;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.tsp.setText(paramc.position);
    Bitmap localBitmap = ahG(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.tsq.setImageBitmap(localBitmap);
      paramb.tru.setText(paramc.field_appName);
      if (!bs.isNullOrNil(paramc.tcL)) {
        break label235;
      }
      paramb.tst.setVisibility(8);
      label91:
      if (bs.gY(paramc.tcU)) {
        break label257;
      }
      paramb.tsr.setVisibility(0);
      paramb.tsr.setText((CharSequence)paramc.tcU.get(0));
    }
    for (;;)
    {
      paramb.tsv.setTextSize(this.toL);
      paramb.tsu.setOnClickListener(this.tpB);
      paramb.tsv.setOnClickListener(this.tpB);
      paramb.tsu.setTag(paramc);
      paramb.tsv.setTag(paramc);
      this.toQ.a(paramb.tsv, paramb.tsu, paramc, (l)this.tsj.get(paramc.field_appId));
      paramb.tsw.setData(paramc.tcS);
      AppMethodBeat.o(41927);
      return;
      paramb.tsq.setImageResource(2131232498);
      break;
      label235:
      paramb.tst.setVisibility(0);
      paramb.tst.setText(paramc.tcL);
      break label91;
      label257:
      if (!bs.isNullOrNil(paramc.tcX))
      {
        paramb.tsr.setVisibility(0);
        paramb.tsr.setText(paramc.tcX);
      }
      try
      {
        paramb.tsr.setBackgroundDrawable(e.eQ(Color.parseColor(paramc.tcY), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ac.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.tsr.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */