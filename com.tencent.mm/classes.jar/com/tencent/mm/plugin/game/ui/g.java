package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.f;
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
    this.CYg = g.f.CmH;
  }
  
  protected final void a(c paramc, m.b paramb) {}
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(41927);
    paramb.CYr.setText(paramc.position);
    Bitmap localBitmap = aKl(paramc.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.CYs.setImageBitmap(localBitmap);
      paramb.CXw.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.CHW)) {
        break label236;
      }
      paramb.CYv.setVisibility(8);
      label91:
      if (Util.isNullOrNil(paramc.CIf)) {
        break label258;
      }
      paramb.CYt.setVisibility(0);
      paramb.CYt.setText((CharSequence)paramc.CIf.get(0));
    }
    for (;;)
    {
      paramb.CYx.setTextSize(this.CUN);
      paramb.CYw.setOnClickListener(this.CVD);
      paramb.CYx.setOnClickListener(this.CVD);
      paramb.CYw.setTag(paramc);
      paramb.CYx.setTag(paramc);
      this.CUS.a(paramb.CYx, paramb.CYw, paramc, (l)this.CYl.get(paramc.field_appId));
      paramb.CYy.setData(paramc.CId);
      AppMethodBeat.o(41927);
      return;
      paramb.CYs.setImageResource(g.d.Chf);
      break;
      label236:
      paramb.CYv.setVisibility(0);
      paramb.CYv.setText(paramc.CHW);
      break label91;
      label258:
      if (!Util.isNullOrNil(paramc.CIi))
      {
        paramb.CYt.setVisibility(0);
        paramb.CYt.setText(paramc.CIi);
      }
      try
      {
        paramb.CYt.setBackgroundDrawable(e.fF(Color.parseColor(paramc.CIj), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.CYt.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */