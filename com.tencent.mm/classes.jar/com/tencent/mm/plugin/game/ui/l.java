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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
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
    this.CYg = g.f.CnI;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.CYA.removeAllViews();
    if (!Util.isNullOrNil(paramc.CHZ))
    {
      View localView = View.inflate(this.mContext, g.f.Cnv, null);
      ImageView localImageView = (ImageView)localView.findViewById(g.e.Cjs);
      com.tencent.mm.ay.a.a locala = q.bml();
      paramc = paramc.CHZ;
      c.a locala1 = new c.a();
      locala1.lRC = true;
      locala.a(paramc, localImageView, locala1.bmL());
      paramb.CYA.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.CYr.setText(paramc.position);
    Object localObject = paramb.CYr;
    int i;
    if (this.CYi)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = aKl(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.CYs.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.CXw.setText(paramc.field_appName);
      if (!Util.isNullOrNil(paramc.CHV)) {
        break label336;
      }
      paramb.CYu.setVisibility(8);
      label114:
      if (!Util.isNullOrNil(paramc.CHW)) {
        break label358;
      }
      paramb.CYv.setVisibility(8);
      label133:
      if (Util.isNullOrNil(paramc.CIf)) {
        break label380;
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
      this.CUS.a(paramb.CYx, paramb.CYw, paramc, (com.tencent.mm.plugin.game.model.l)this.CYl.get(paramc.field_appId));
      paramb.CYy.setData(paramc.CId);
      paramb.CYz.removeAllViews();
      paramc = (View)this.CYm.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.CYz.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.CYs.setImageResource(g.d.Chf);
      break label84;
      label336:
      paramb.CYu.setVisibility(0);
      paramb.CYu.setText(paramc.CHV);
      break label114;
      label358:
      paramb.CYv.setVisibility(0);
      paramb.CYv.setText(paramc.CHW);
      break label133;
      label380:
      if (!Util.isNullOrNil(paramc.CIi))
      {
        paramb.CYt.setVisibility(0);
        paramb.CYt.setText(paramc.CIi);
      }
      try
      {
        paramb.CYt.setBackgroundDrawable(e.fF(Color.parseColor(paramc.CIj), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.CYt.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */