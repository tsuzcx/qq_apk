package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.ISw = h.f.HZQ;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.ISQ.removeAllViews();
    if (!Util.isNullOrNil(paramc.ICj))
    {
      View localView = View.inflate(this.mContext, h.f.HZD, null);
      ImageView localImageView = (ImageView)localView.findViewById(h.e.HVA);
      com.tencent.mm.modelimage.loader.a locala = r.bKe();
      paramc = paramc.ICj;
      c.a locala1 = new c.a();
      locala1.oKo = true;
      locala.a(paramc, localImageView, locala1.bKx());
      paramb.ISQ.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.ISH.setText(paramc.position);
    Object localObject = paramb.ISH;
    int i;
    if (this.ISy)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = aHb(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.ISI.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.IRM.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.ICf)) {
        break label336;
      }
      paramb.ISK.setVisibility(8);
      label114:
      if (!Util.isNullOrNil(paramc.ICg)) {
        break label358;
      }
      paramb.ISL.setVisibility(8);
      label133:
      if (Util.isNullOrNil(paramc.ICp)) {
        break label380;
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
      this.IPk.a(paramb.ISN, paramb.ISM, paramc, (com.tencent.mm.plugin.game.model.l)this.ISB.get(paramc.field_appId));
      paramb.ISO.setData(paramc.ICn);
      paramb.ISP.removeAllViews();
      paramc = (View)this.ISC.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.ISP.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.ISI.setImageResource(h.d.HTo);
      break label84;
      label336:
      paramb.ISK.setVisibility(0);
      paramb.ISK.setText(paramc.ICf);
      break label114;
      label358:
      paramb.ISL.setVisibility(0);
      paramb.ISL.setText(paramc.ICg);
      break label133;
      label380:
      if (!Util.isNullOrNil(paramc.ICs))
      {
        paramb.ISJ.setVisibility(0);
        paramb.ISJ.setText(paramc.ICs);
      }
      try
      {
        paramb.ISJ.setBackgroundDrawable(e.gx(Color.parseColor(paramc.ICt), com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.ISJ.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */