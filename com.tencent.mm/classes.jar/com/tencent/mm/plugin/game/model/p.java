package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  public int kQh;
  private Context mContext;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.kQh = paramInt;
  }
  
  public static int a(Context paramContext, o paramo, o.d paramd, String paramString, int paramInt)
  {
    int i = 0;
    switch (paramd.kPV)
    {
    default: 
      y.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + paramd.kPV);
      return 0;
    case 1: 
      if (com.tencent.mm.pluginsdk.model.app.g.o(paramContext, paramString))
      {
        f.ai(paramContext, paramString);
        return 3;
      }
      return g(paramContext, paramString, paramInt);
    case 2: 
      if (com.tencent.mm.pluginsdk.model.app.g.o(paramContext, paramString))
      {
        f.ai(paramContext, paramString);
        return 3;
      }
      return 0;
    case 3: 
      return g(paramContext, paramString, paramInt);
    case 4: 
      if (paramo != null)
      {
        paramo.field_isRead = true;
        ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().c(paramo, new String[0]);
      }
      paramo = new Intent();
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
      paramo.putExtra("game_report_from_scene", paramInt);
      paramContext.startActivity(paramo);
      return 6;
    }
    paramo = paramd.jCY;
    if (bk.bl(paramo)) {}
    for (paramInt = i;; paramInt = com.tencent.mm.plugin.game.f.c.an(paramContext, paramo)) {
      return paramInt;
    }
  }
  
  private static int g(Context paramContext, String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramString);
    localBundle.putInt("game_report_from_scene", paramInt);
    return com.tencent.mm.plugin.game.f.c.b(paramContext, paramString, null, localBundle);
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof p.a))) {
      y.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
    }
    int i;
    do
    {
      return;
      paramView = (p.a)paramView.getTag();
      if (paramView.kQi == null)
      {
        y.e("MicroMsg.GameMessageClickListener", "message is null");
        return;
      }
      if (paramView.kQe == null)
      {
        y.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        return;
      }
      o.d locald = (o.d)paramView.kQi.kPi.get(paramView.kQe);
      if (locald == null)
      {
        y.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
        return;
      }
      i = a(this.mContext, paramView.kQi, locald, paramView.kQi.field_appId, paramView.bXn);
    } while (i == 0);
    b.a(this.mContext, 13, paramView.bXn, paramView.position, i, 0, paramView.kQi.field_appId, this.kQh, paramView.kQi.kPM, paramView.kQi.field_gameMsgId, paramView.kQi.kPN, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */