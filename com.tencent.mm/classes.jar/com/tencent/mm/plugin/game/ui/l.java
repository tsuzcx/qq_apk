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
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.nAO = 2130969780;
  }
  
  protected final void a(c paramc, m.b paramb)
  {
    AppMethodBeat.i(112014);
    paramb.nBi.removeAllViews();
    if (!bo.isNullOrNil(paramc.nlX))
    {
      View localView = View.inflate(this.mContext, 2130969761, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131824650);
      com.tencent.mm.at.a.a locala = o.ahG();
      paramc = paramc.nlX;
      c.a locala1 = new c.a();
      locala1.eNL = true;
      locala.a(paramc, localImageView, locala1.ahY());
      paramb.nBi.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100)));
    }
    AppMethodBeat.o(112014);
  }
  
  protected final void a(c paramc, m.b paramb, int paramInt)
  {
    AppMethodBeat.i(112013);
    paramb.nAZ.setText(paramc.position);
    Object localObject = paramb.nAZ;
    int i;
    if (this.nAQ)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = Qp(paramc.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label323;
      }
      paramb.nBa.setImageBitmap((Bitmap)localObject);
      label84:
      paramb.nAb.setText(paramc.field_appName);
      if (!bo.isNullOrNil(paramc.nlT)) {
        break label336;
      }
      paramb.nBc.setVisibility(8);
      label114:
      if (!bo.isNullOrNil(paramc.nlU)) {
        break label358;
      }
      paramb.nBd.setVisibility(8);
      label133:
      if (bo.es(paramc.nme)) {
        break label380;
      }
      paramb.nBb.setVisibility(0);
      paramb.nBb.setText((CharSequence)paramc.nme.get(0));
    }
    for (;;)
    {
      paramb.nBf.setTextSize(this.nxr);
      paramb.nBe.setOnClickListener(this.nyh);
      paramb.nBf.setOnClickListener(this.nyh);
      paramb.nBe.setTag(paramc);
      paramb.nBf.setTag(paramc);
      this.nxw.a(paramb.nBf, paramb.nBe, paramc, (k)this.nAT.get(paramc.field_appId));
      paramb.nBg.setData(paramc.nmc);
      paramb.nBh.removeAllViews();
      paramc = (View)this.nAU.get(paramInt);
      if (paramc != null)
      {
        if ((paramc.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramc.getParent()).removeAllViews();
        }
        paramb.nBh.addView(paramc);
      }
      AppMethodBeat.o(112013);
      return;
      i = 8;
      break;
      label323:
      paramb.nBa.setImageResource(2130838963);
      break label84;
      label336:
      paramb.nBc.setVisibility(0);
      paramb.nBc.setText(paramc.nlT);
      break label114;
      label358:
      paramb.nBd.setVisibility(0);
      paramb.nBd.setText(paramc.nlU);
      break label133;
      label380:
      if (!bo.isNullOrNil(paramc.nmh))
      {
        paramb.nBb.setVisibility(0);
        paramb.nBb.setText(paramc.nmh);
      }
      try
      {
        paramb.nBb.setBackgroundDrawable(e.dR(Color.parseColor(paramc.nmi), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ab.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.nBb.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */