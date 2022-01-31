package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  implements View.OnClickListener
{
  int drX;
  private d kOM;
  String lev;
  protected Context mContext;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.lev = null;
  }
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof d))
    {
      y.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
      return;
    }
    this.kOM = ((d)paramView.getTag());
    y.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.kOM.field_appId);
    if (g.o(this.mContext, this.kOM.field_appId))
    {
      y.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.kOM.field_appId + ", pkg = " + this.kOM.field_packageName + ", openId = " + this.kOM.field_openId);
      f.ai(this.mContext, this.kOM.field_appId);
      b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 3, this.kOM.field_appId, this.drX, this.kOM.bGy, this.kOM.kOo);
      return;
    }
    y.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[] { this.lev });
    if (!bk.bl(this.lev))
    {
      c.an(this.mContext, this.lev);
      b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 11, this.kOM.field_appId, this.drX, this.kOM.bGy, this.kOM.kOo);
      return;
    }
    y.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.q
 * JD-Core Version:    0.7.0.1
 */