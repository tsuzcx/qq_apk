package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements f
{
  private Dialog jwv;
  private bj kQL;
  k kXC = new k();
  private boolean kYB = true;
  private boolean laA;
  private String laB = "";
  private View.OnClickListener lcN = new GameOverSeaCenterUI.4(this);
  private GameCenterListView lek;
  private g lel;
  private GameInfoViewForeign lem;
  private GameMessageBubbleView len;
  private GameInstalledView leo;
  private View lep;
  private TextView leq;
  
  protected final int getLayoutId()
  {
    return g.f.game_center_home;
  }
  
  protected final void initView()
  {
    setBackBtn(new GameOverSeaCenterUI.1(this));
    setMMTitle(g.i.game_wechat_game);
    this.lek = ((GameCenterListView)findViewById(g.e.game_center_uninstalled));
    this.lek.setOnItemClickListener(this.kXC);
    this.kXC.setSourceScene(this.kQh);
    this.lel = new g(this);
    this.lel.setSourceScene(this.kQh);
    Object localObject = (LayoutInflater)this.mController.uMN.getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(g.f.game_center_home_info_foreign, this.lek, false);
    this.lem = ((GameInfoViewForeign)localView.findViewById(g.e.game_center_info_foreign));
    this.lek.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(g.f.game_center_bubble_layout, this.lek, false);
    this.len = ((GameMessageBubbleView)localView.findViewById(g.e.game_msg_bubble_view));
    this.lek.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(g.f.game_center_home_installed, this.lek, false);
    this.leo = ((GameInstalledView)localView.findViewById(g.e.game_installed_header));
    this.lek.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(g.f.game_center_home_footer_more2, this.lek, false);
    this.lek.addFooterView((View)localObject);
    this.lep = ((View)localObject).findViewById(g.e.game_home_more_btn);
    this.lep.setOnClickListener(this.lcN);
    this.leq = ((TextView)((View)localObject).findViewById(g.e.game_home_more_btn_text));
    this.lek.setAdapter(this.lel);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.Dk().a(2855, this);
    initView();
    com.tencent.mm.plugin.game.f.c.DS().O(new GameOverSeaCenterUI.2(this));
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    a.a.bau().clearCache();
    com.tencent.mm.kernel.g.Dk().b(2855, this);
    ((com.tencent.mm.plugin.game.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.b.class)).aYc().clearCache();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.kYB)
    {
      if (this.kYc) {
        this.len.bao();
      }
      this.lem.baj();
    }
    this.kYB = false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    y.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    do
    {
      return;
      final long l = System.currentTimeMillis();
      paramString = ((aq)paramm).jvQ.ecF.ecN;
      com.tencent.mm.plugin.game.f.c.DS().O(new Runnable()
      {
        public final void run()
        {
          if (paramString == null) {
            GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new bj());
          }
          for (;;)
          {
            ai.d(new Runnable()
            {
              public final void run()
              {
                try
                {
                  GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.let, 2);
                  if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                  }
                  y.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.dhV) });
                  return;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    y.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
                    GameOverSeaCenterUI.this.finish();
                  }
                }
              }
            });
            return;
            GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, (bj)paramString);
          }
        }
      });
      return;
      if (!com.tencent.mm.plugin.game.b.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        Toast.makeText(this, getString(g.i.game_list_get_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
    } while (this.jwv == null);
    this.jwv.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */