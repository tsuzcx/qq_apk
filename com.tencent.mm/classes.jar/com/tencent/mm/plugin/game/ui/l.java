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
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends m
{
  public l(Context paramContext)
  {
    super(paramContext);
    this.lcT = g.f.game_list_item;
  }
  
  protected final void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb)
  {
    paramb.ldn.removeAllViews();
    if (!bk.bl(paramd.kOa))
    {
      View localView = View.inflate(this.mContext, g.f.game_hotad_item, null);
      ImageView localImageView = (ImageView)localView.findViewById(g.e.game_hotad);
      com.tencent.mm.as.a.a locala = o.ON();
      paramd = paramd.kOa;
      c.a locala1 = new c.a();
      locala1.ere = true;
      locala.a(paramd, localImageView, locala1.OV());
      paramb.ldn.addView(localView, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100)));
    }
  }
  
  protected final void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb, int paramInt)
  {
    paramb.lde.setText(paramd.position);
    Object localObject = paramb.lde;
    int i;
    if (this.lcV)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = EX(paramd.field_appId);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label313;
      }
      paramb.ldf.setImageBitmap((Bitmap)localObject);
      label79:
      paramb.lcg.setText(paramd.field_appName);
      if (!bk.bl(paramd.kNW)) {
        break label326;
      }
      paramb.ldh.setVisibility(8);
      label109:
      if (!bk.bl(paramd.kNX)) {
        break label348;
      }
      paramb.ldi.setVisibility(8);
      label128:
      if (bk.dk(paramd.kOh)) {
        break label370;
      }
      paramb.ldg.setVisibility(0);
      paramb.ldg.setText((CharSequence)paramd.kOh.get(0));
    }
    for (;;)
    {
      paramb.ldk.setTextSize(this.kZu);
      paramb.ldj.setOnClickListener(this.lak);
      paramb.ldk.setOnClickListener(this.lak);
      paramb.ldj.setTag(paramd);
      paramb.ldk.setTag(paramd);
      this.kZz.a(paramb.ldk, paramb.ldj, paramd, (com.tencent.mm.plugin.game.model.l)this.lcY.get(paramd.field_appId));
      paramb.ldl.setData(paramd.kOf);
      paramb.ldm.removeAllViews();
      paramd = (View)this.lcZ.get(paramInt);
      if (paramd != null)
      {
        if ((paramd.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramd.getParent()).removeAllViews();
        }
        paramb.ldm.addView(paramd);
      }
      return;
      i = 8;
      break;
      label313:
      paramb.ldf.setImageResource(g.d.game_default_icon);
      break label79;
      label326:
      paramb.ldh.setVisibility(0);
      paramb.ldh.setText(paramd.kNW);
      break label109;
      label348:
      paramb.ldi.setVisibility(0);
      paramb.ldi.setText(paramd.kNX);
      break label128;
      label370:
      if (!bk.bl(paramd.kOk))
      {
        paramb.ldg.setVisibility(0);
        paramb.ldg.setText(paramd.kOk);
      }
      try
      {
        paramb.ldg.setBackgroundDrawable(f.cx(Color.parseColor(paramd.kOl), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        y.e("MicroMsg.GameLibraryListAdapter", localIllegalArgumentException.getMessage());
        paramb.ldg.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.GameLibraryListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.l
 * JD-Core Version:    0.7.0.1
 */