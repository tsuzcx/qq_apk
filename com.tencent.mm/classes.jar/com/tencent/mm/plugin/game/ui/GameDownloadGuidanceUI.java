package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements com.tencent.mm.ah.f
{
  private Dialog jwv;
  private bh kQx;
  private LinearLayout kjd;
  private boolean laA;
  private String laB = "";
  private TextView lax;
  private TextView lay;
  private TextView laz;
  
  public final void a(ac paramac, int paramInt)
  {
    if (isFinishing()) {
      y.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
    }
    label136:
    label269:
    label279:
    for (;;)
    {
      return;
      if ((paramac == null) || (paramac.aZH() == null))
      {
        y.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
        return;
      }
      if ((paramac != null) && (paramac.aZI() != null))
      {
        this.laB = paramac.aZI().kRP;
        if (bk.bl(this.laB)) {
          break label224;
        }
        if (!this.laA)
        {
          addIconOptionMenu(0, g.h.actionbar_setting_icon, new GameDownloadGuidanceUI.4(this));
          this.laA = true;
        }
        label94:
        this.kjd.setVisibility(0);
        paramac = paramac.aZH();
        if (bk.bl(paramac.kSI)) {
          break label245;
        }
        this.lax.setText(paramac.kSI);
        this.lax.setVisibility(0);
        if (bk.bl(paramac.kSJ)) {
          break label257;
        }
        this.lay.setText(paramac.kSJ);
        this.lay.setVisibility(0);
        label165:
        if (bk.bl(paramac.kSK)) {
          break label269;
        }
        this.laz.setText(paramac.kSK);
        this.laz.setVisibility(0);
      }
      for (;;)
      {
        if (paramInt != 2) {
          break label279;
        }
        com.tencent.mm.plugin.game.f.c.DS().O(new Runnable()
        {
          public final void run()
          {
            ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
          }
        });
        return;
        this.laB = "";
        break;
        label224:
        if (!this.laA) {
          break label94;
        }
        removeOptionMenu(0);
        this.laA = false;
        break label94;
        label245:
        this.lax.setVisibility(8);
        break label136;
        this.lay.setVisibility(8);
        break label165;
        this.laz.setVisibility(8);
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_google_play_tips;
  }
  
  protected final void initView()
  {
    setBackBtn(new GameDownloadGuidanceUI.1(this));
    setMMTitle(g.i.game_wechat_game);
    this.kjd = ((LinearLayout)findViewById(g.e.container));
    this.lax = ((TextView)findViewById(g.e.main_content));
    this.lay = ((TextView)findViewById(g.e.secondary_title));
    this.laz = ((TextView)findViewById(g.e.secondary_content));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(2586, this);
    initView();
    com.tencent.mm.plugin.game.f.c.DS().O(new Runnable()
    {
      public final void run()
      {
        Object localObject = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey("pb_download_guidance");
        if (localObject == null) {
          ai.d(new GameDownloadGuidanceUI.2.1(this));
        }
        for (;;)
        {
          localObject = new ap(com.tencent.mm.sdk.platformtools.x.cqJ(), com.tencent.mm.plugin.game.model.f.aYT(), GameDownloadGuidanceUI.this.kYd, GameDownloadGuidanceUI.this.kYe, GameDownloadGuidanceUI.this.kYf, GameDownloadGuidanceUI.this.kYc);
          g.Dk().a((m)localObject, 0);
          com.tencent.mm.plugin.game.model.f.aYY();
          a.a.bau().bas();
          return;
          ai.d(new GameDownloadGuidanceUI.2.2(this, new ac((byte[])localObject)));
        }
      }
    });
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.bau().clearCache();
    g.Dk().b(2586, this);
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYc().clearCache();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    do
    {
      return;
      long l = System.currentTimeMillis();
      paramString = ((ap)paramm).jvQ.ecF.ecN;
      com.tencent.mm.plugin.game.f.c.DS().O(new GameDownloadGuidanceUI.5(this, paramString, l));
      return;
      if (!com.tencent.mm.plugin.game.b.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.game_list_get_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
    } while (this.jwv == null);
    this.jwv.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */