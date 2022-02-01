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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.uBX = 2131494338;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.uCr.removeAllViews();
    if (!bu.isNullOrNil(paramc.ulG))
    {
      View localView = View.inflate(this.mContext, 2131494318, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131300461);
      com.tencent.mm.av.a.a locala = q.aJb();
      paramc = paramc.ulG;
      c.a locala1 = new c.a();
      locala1.igj = true;
      locala.a(paramc, localImageView, locala1.aJu());
      paramb.uCr.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.uCi.setText(paramc.position);
    Object localObject = paramb.uCi;
    int i;
    if (this.uBZ)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = ani(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.uCj.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.uBn.setText(paramc.field_appName);
      if (!bu.isNullOrNil(paramc.ulC)) {
        break label336;
      }
      paramb.uCl.setVisibility(8);
      label114:
      if (!bu.isNullOrNil(paramc.ulD)) {
        break label358;
      }
      paramb.uCm.setVisibility(8);
      label133:
      if (bu.ht(paramc.ulM)) {
        break label380;
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
      this.uyJ.a(paramb.uCo, paramb.uCn, paramc, (com.tencent.mm.plugin.game.model.l)this.uCc.get(paramc.field_appId));
      paramb.uCp.setData(paramc.ulK);
      paramb.uCq.removeAllViews();
      paramc = (View)this.uCd.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.uCq.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.uCj.setImageResource(2131232498);
      break label84;
      label336:
      paramb.uCl.setVisibility(0);
      paramb.uCl.setText(paramc.ulC);
      break label114;
      label358:
      paramb.uCm.setVisibility(0);
      paramb.uCm.setText(paramc.ulD);
      break label133;
      label380:
      if (!bu.isNullOrNil(paramc.ulP))
      {
        paramb.uCk.setVisibility(0);
        paramb.uCk.setText(paramc.ulP);
      }
      try
      {
        paramb.uCk.setBackgroundDrawable(e.eV(Color.parseColor(paramc.ulQ), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ae.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.uCk.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */