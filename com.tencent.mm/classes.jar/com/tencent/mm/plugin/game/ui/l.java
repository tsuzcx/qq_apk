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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.tse = 2131494338;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(42203);
    paramb.tsy.removeAllViews();
    if (!bs.isNullOrNil(paramc.tcO))
    {
      View localView = View.inflate(this.mContext, 2131494318, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131300461);
      com.tencent.mm.av.a.a locala = o.aFB();
      paramc = paramc.tcO;
      c.a locala1 = new c.a();
      locala1.hKw = true;
      locala.a(paramc, localImageView, locala1.aFT());
      paramb.tsy.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(42203);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(42202);
    paramb.tsp.setText(paramc.position);
    Object localObject = paramb.tsp;
    int i;
    if (this.tsg)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = ahG(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.tsq.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.tru.setText(paramc.field_appName);
      if (!bs.isNullOrNil(paramc.tcK)) {
        break label336;
      }
      paramb.tss.setVisibility(8);
      label114:
      if (!bs.isNullOrNil(paramc.tcL)) {
        break label358;
      }
      paramb.tst.setVisibility(8);
      label133:
      if (bs.gY(paramc.tcU)) {
        break label380;
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
      this.toQ.a(paramb.tsv, paramb.tsu, paramc, (com.tencent.mm.plugin.game.model.l)this.tsj.get(paramc.field_appId));
      paramb.tsw.setData(paramc.tcS);
      paramb.tsx.removeAllViews();
      paramc = (View)this.tsk.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.tsx.addView(paramc);
      }
      AppMethodBeat.o(42202);
      return;
      i = 8;
      break;
      label323:
      paramb.tsq.setImageResource(2131232498);
      break label84;
      label336:
      paramb.tss.setVisibility(0);
      paramb.tss.setText(paramc.tcK);
      break label114;
      label358:
      paramb.tst.setVisibility(0);
      paramb.tst.setText(paramc.tcL);
      break label133;
      label380:
      if (!bs.isNullOrNil(paramc.tcX))
      {
        paramb.tsr.setVisibility(0);
        paramb.tsr.setText(paramc.tcX);
      }
      try
      {
        paramb.tsr.setBackgroundDrawable(e.eQ(Color.parseColor(paramc.tcY), com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ac.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.tsr.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */