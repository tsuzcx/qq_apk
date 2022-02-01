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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
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
    this.xTV = 2131494903;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.xUp.removeAllViews();
    if (!Util.isNullOrNil(paramc.xDY))
    {
      View localView = View.inflate(this.mContext, 2131494882, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131301984);
      com.tencent.mm.av.a.a locala = q.bcV();
      paramc = paramc.xDY;
      c.a locala1 = new c.a();
      locala1.jbe = true;
      locala.a(paramc, localImageView, locala1.bdv());
      paramb.xUp.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.xUg.setText(paramc.position);
    Object localObject = paramb.xUg;
    int i;
    if (this.xTX)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = aAz(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.xUh.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.xTl.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.xDU)) {
        break label336;
      }
      paramb.xUj.setVisibility(8);
      label114:
      if (!Util.isNullOrNil(paramc.xDV)) {
        break label358;
      }
      paramb.xUk.setVisibility(8);
      label133:
      if (Util.isNullOrNil(paramc.xEe)) {
        break label380;
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
      this.xQI.a(paramb.xUm, paramb.xUl, paramc, (com.tencent.mm.plugin.game.model.l)this.xUa.get(paramc.field_appId));
      paramb.xUn.setData(paramc.xEc);
      paramb.xUo.removeAllViews();
      paramc = (View)this.xUb.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.xUo.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.xUh.setImageResource(2131232887);
      break label84;
      label336:
      paramb.xUj.setVisibility(0);
      paramb.xUj.setText(paramc.xDU);
      break label114;
      label358:
      paramb.xUk.setVisibility(0);
      paramb.xUk.setText(paramc.xDV);
      break label133;
      label380:
      if (!Util.isNullOrNil(paramc.xEh))
      {
        paramb.xUi.setVisibility(0);
        paramb.xUi.setText(paramc.xEh);
      }
      try
      {
        paramb.xUi.setBackgroundDrawable(e.fi(Color.parseColor(paramc.xEi), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.xUi.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */