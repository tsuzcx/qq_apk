package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  extends m
{
  public g(Context paramContext)
  {
    super(paramContext);
    this.lcT = g.f.game_center_list_item;
  }
  
  protected final void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb) {}
  
  protected final void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb, int paramInt)
  {
    paramb.lde.setText(paramd.position);
    Bitmap localBitmap = EX(paramd.field_appId);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.ldf.setImageBitmap(localBitmap);
      paramb.lcg.setText(paramd.field_appName);
      if (!bk.bl(paramd.kNX)) {
        break label226;
      }
      paramb.ldi.setVisibility(8);
      label86:
      if (bk.dk(paramd.kOh)) {
        break label248;
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
      this.kZz.a(paramb.ldk, paramb.ldj, paramd, (l)this.lcY.get(paramd.field_appId));
      paramb.ldl.setData(paramd.kOf);
      return;
      paramb.ldf.setImageResource(g.d.game_default_icon);
      break;
      label226:
      paramb.ldi.setVisibility(0);
      paramb.ldi.setText(paramd.kNX);
      break label86;
      label248:
      if (!bk.bl(paramd.kOk))
      {
        paramb.ldg.setVisibility(0);
        paramb.ldg.setText(paramd.kOk);
      }
      try
      {
        paramb.ldg.setBackgroundDrawable(f.cx(Color.parseColor(paramd.kOl), a.fromDPToPix(this.mContext, 10)));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        y.e("MicroMsg.GameCenterListAdapter", localIllegalArgumentException.getMessage());
        paramb.ldg.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.GameCenterListAdapter", localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.g
 * JD-Core Version:    0.7.0.1
 */