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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private k.a toP;
  private l toR;
  private Button tpW;
  private TextProgressBar tpX;
  private d tpY;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42066);
    this.toP = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42065);
        if ((!paramAnonymousBoolean) || (bs.isNullOrNil(paramAnonymousString)))
        {
          AppMethodBeat.o(42065);
          return;
        }
        if ((GameDownloadView.b(GameDownloadView.this) == null) || (GameDownloadView.b(GameDownloadView.this).tdF == null) || (!GameDownloadView.b(GameDownloadView.this).tdF.field_appId.equals(paramAnonymousString)))
        {
          AppMethodBeat.o(42065);
          return;
        }
        GameDownloadView.this.refresh();
        AppMethodBeat.o(42065);
      }
    };
    AppMethodBeat.o(42066);
  }
  
  private void cRr()
  {
    AppMethodBeat.i(42072);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42064);
        GameDownloadView.e(GameDownloadView.this).a(GameDownloadView.c(GameDownloadView.this), GameDownloadView.d(GameDownloadView.this), GameDownloadView.b(GameDownloadView.this).tdF, GameDownloadView.b(GameDownloadView.this));
        AppMethodBeat.o(42064);
      }
    });
    AppMethodBeat.o(42072);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42069);
    super.onAttachedToWindow();
    k.a(this.toP);
    AppMethodBeat.o(42069);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42073);
    this.toR.fu(ai.getContext());
    this.tpY.a(this.toR.tdF, this.toR);
    AppMethodBeat.o(42073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42068);
    super.onDetachedFromWindow();
    k.b(this.toP);
    AppMethodBeat.o(42068);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42067);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494295, this, true);
    this.tpW = ((Button)localView.findViewById(2131300434));
    this.tpX = ((TextProgressBar)localView.findViewById(2131300436));
    this.tpX.setTextSize(14);
    this.tpW.setOnClickListener(this);
    this.tpX.setOnClickListener(this);
    this.tpY = new d(getContext());
    this.tpY.tmD = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(42062);
        GameDownloadView.a(GameDownloadView.this);
        AppMethodBeat.o(42062);
      }
    };
    AppMethodBeat.o(42067);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(42070);
    if (this.toR != null)
    {
      this.toR.fu(ai.getContext());
      this.toR.bYH();
      cRr();
    }
    AppMethodBeat.o(42070);
  }
  
  public void setDownloadInfo(l paraml)
  {
    AppMethodBeat.i(42071);
    this.toR = paraml;
    com.tencent.mm.plugin.game.f.c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42063);
        GameDownloadView.b(GameDownloadView.this).fu(ai.getContext());
        GameDownloadView.b(GameDownloadView.this).bYH();
        GameDownloadView.a(GameDownloadView.this);
        AppMethodBeat.o(42063);
      }
    });
    cRr();
    AppMethodBeat.o(42071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */