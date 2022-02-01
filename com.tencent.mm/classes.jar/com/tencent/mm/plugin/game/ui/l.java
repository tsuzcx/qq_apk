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
import com.tencent.mm.aw.q;
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
    this.uqB = 2131494338;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.uqV.removeAllViews();
    if (!bt.isNullOrNil(paramc.uaE))
    {
      View localView = View.inflate(this.mContext, 2131494318, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131300461);
      com.tencent.mm.aw.a.a locala = q.aIJ();
      paramc = paramc.uaE;
      c.a locala1 = new c.a();
      locala1.idq = true;
      locala.a(paramc, localImageView, locala1.aJc());
      paramb.uqV.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.uqM.setText(paramc.position);
    Object localObject = paramb.uqM;
    int i;
    if (this.uqD)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = ami(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.uqN.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.upR.setText(paramc.field_appName);
      if (!bt.isNullOrNil(paramc.uaA)) {
        break label336;
      }
      paramb.uqP.setVisibility(8);
      label114:
      if (!bt.isNullOrNil(paramc.uaB)) {
        break label358;
      }
      paramb.uqQ.setVisibility(8);
      label133:
      if (bt.hj(paramc.uaK)) {
        break label380;
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
      this.unn.a(paramb.uqS, paramb.uqR, paramc, (com.tencent.mm.plugin.game.model.l)this.uqG.get(paramc.field_appId));
      paramb.uqT.setData(paramc.uaI);
      paramb.uqU.removeAllViews();
      paramc = (View)this.uqH.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.uqU.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.uqN.setImageResource(2131232498);
      break label84;
      label336:
      paramb.uqP.setVisibility(0);
      paramb.uqP.setText(paramc.uaA);
      break label114;
      label358:
      paramb.uqQ.setVisibility(0);
      paramb.uqQ.setText(paramc.uaB);
      break label133;
      label380:
      if (!bt.isNullOrNil(paramc.uaN))
      {
        paramb.uqO.setVisibility(0);
        paramb.uqO.setText(paramc.uaN);
      }
      try
      {
        paramb.uqO.setBackgroundDrawable(e.eU(Color.parseColor(paramc.uaO), com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ad.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.uqO.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */