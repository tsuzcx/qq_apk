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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.skl = 2131494338;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.skF.removeAllViews();
    if (!bt.isNullOrNil(paramc.rUW))
    {
      View localView = View.inflate(this.mContext, 2131494318, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131300461);
      com.tencent.mm.aw.a.a locala = o.ayJ();
      paramc = paramc.rUW;
      c.a locala1 = new c.a();
      locala1.hjT = true;
      locala.a(paramc, localImageView, locala1.azc());
      paramb.skF.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.skw.setText(paramc.position);
    Object localObject = paramb.skw;
    int i;
    if (this.skn)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = acO(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.skx.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.sjB.setText(paramc.field_appName);
      if (!bt.isNullOrNil(paramc.rUS)) {
        break label336;
      }
      paramb.skz.setVisibility(8);
      label114:
      if (!bt.isNullOrNil(paramc.rUT)) {
        break label358;
      }
      paramb.skA.setVisibility(8);
      label133:
      if (bt.gL(paramc.rVc)) {
        break label380;
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
      this.sgW.a(paramb.skC, paramb.skB, paramc, (com.tencent.mm.plugin.game.model.l)this.skq.get(paramc.field_appId));
      paramb.skD.setData(paramc.rVa);
      paramb.skE.removeAllViews();
      paramc = (View)this.skr.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.skE.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.skx.setImageResource(2131232498);
      break label84;
      label336:
      paramb.skz.setVisibility(0);
      paramb.skz.setText(paramc.rUS);
      break label114;
      label358:
      paramb.skA.setVisibility(0);
      paramb.skA.setText(paramc.rUT);
      break label133;
      label380:
      if (!bt.isNullOrNil(paramc.rVf))
      {
        paramb.sky.setVisibility(0);
        paramb.sky.setText(paramc.rVf);
      }
      try
      {
        paramb.sky.setBackgroundDrawable(e.eN(Color.parseColor(paramc.rVg), com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ad.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.sky.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */