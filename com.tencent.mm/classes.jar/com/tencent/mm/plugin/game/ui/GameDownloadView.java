package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private l kZA;
  private k.a kZy = new k.a()
  {
    public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      if ((!paramAnonymousBoolean) || (bk.bl(paramAnonymousString))) {}
      while ((GameDownloadView.b(GameDownloadView.this) == null) || (GameDownloadView.b(GameDownloadView.this).kOM == null) || (!GameDownloadView.b(GameDownloadView.this).kOM.field_appId.equals(paramAnonymousString))) {
        return;
      }
      GameDownloadView.this.refresh();
    }
  };
  private Button laG;
  private TextProgressBar laH;
  private d laI;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bah()
  {
    ai.d(new GameDownloadView.3(this));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    k.a(this.kZy);
  }
  
  public void onClick(View paramView)
  {
    this.kZA.dz(ae.getContext());
    this.laI.a(this.kZA.kOM, this.kZA);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    k.b(this.kZy);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.game_download_view, this, true);
    this.laG = ((Button)localView.findViewById(g.e.game_download_btn));
    this.laH = ((TextProgressBar)localView.findViewById(g.e.game_download_progress));
    this.laH.setTextSize(14);
    this.laG.setOnClickListener(this);
    this.laH.setOnClickListener(this);
    this.laI = new d(getContext());
    this.laI.kXd = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GameDownloadView.a(GameDownloadView.this);
      }
    };
  }
  
  public final void refresh()
  {
    if (this.kZA != null)
    {
      this.kZA.dz(ae.getContext());
      this.kZA.aGu();
      bah();
    }
  }
  
  public void setDownloadInfo(l paraml)
  {
    this.kZA = paraml;
    c.DS().O(new GameDownloadView.2(this));
    bah();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */