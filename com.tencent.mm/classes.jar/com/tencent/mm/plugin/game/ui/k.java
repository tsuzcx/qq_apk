package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected int kQh = 0;
  
  private void a(Context paramContext, d paramd)
  {
    int i = 0;
    if (paramd.type == 1) {
      i = c.an(paramContext, paramd.kNZ);
    }
    for (;;)
    {
      b.a(paramContext, paramd.scene, paramd.bXn, paramd.position, i, paramd.field_appId, this.kQh, paramd.bGy, paramd.kOo);
      return;
      if (paramd.type == 0) {
        if ((paramd.aYR()) && (!bk.bl(paramd.kOs.kRP)) && (!g.a(paramContext, paramd)))
        {
          i = c.an(paramContext, paramd.kOs.kRP);
        }
        else
        {
          if ((bk.bl(paramd.cvE)) || (paramd.cvH != 4)) {
            break;
          }
          y.i("MicroMsg.GameItemClickListener", "Download via Google Play");
          q.bk(paramContext, paramd.cvE);
          i = 25;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramd.field_appId);
    if (paramd.bXn == 1601) {
      localBundle.putInt("game_report_from_scene", this.kQh);
    }
    for (;;)
    {
      i = c.b(paramContext, paramd.field_appId, paramd.kNZ, localBundle);
      break;
      localBundle.putInt("game_report_from_scene", paramd.bXn);
    }
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof d))) {
      return;
    }
    d locald = (d)paramView.getTag();
    a(paramView.getContext(), locald);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof d))) {}
    do
    {
      return;
      paramAdapterView = (d)paramAdapterView;
    } while (bk.bl(paramAdapterView.field_appId));
    a(paramView.getContext(), paramAdapterView);
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.k
 * JD-Core Version:    0.7.0.1
 */