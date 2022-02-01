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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private k.a sgV;
  private l sgX;
  private Button sic;
  private TextProgressBar sid;
  private d sie;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42066);
    this.sgV = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42065);
        if ((!paramAnonymousBoolean) || (bt.isNullOrNil(paramAnonymousString)))
        {
          AppMethodBeat.o(42065);
          return;
        }
        if ((GameDownloadView.b(GameDownloadView.this) == null) || (GameDownloadView.b(GameDownloadView.this).rVN == null) || (!GameDownloadView.b(GameDownloadView.this).rVN.field_appId.equals(paramAnonymousString)))
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
  
  private void cEh()
  {
    AppMethodBeat.i(42072);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42064);
        GameDownloadView.e(GameDownloadView.this).a(GameDownloadView.c(GameDownloadView.this), GameDownloadView.d(GameDownloadView.this), GameDownloadView.b(GameDownloadView.this).rVN, GameDownloadView.b(GameDownloadView.this));
        AppMethodBeat.o(42064);
      }
    });
    AppMethodBeat.o(42072);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42069);
    super.onAttachedToWindow();
    k.a(this.sgV);
    AppMethodBeat.o(42069);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42073);
    this.sgX.fh(aj.getContext());
    this.sie.a(this.sgX.rVN, this.sgX);
    AppMethodBeat.o(42073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42068);
    super.onDetachedFromWindow();
    k.b(this.sgV);
    AppMethodBeat.o(42068);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42067);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494295, this, true);
    this.sic = ((Button)localView.findViewById(2131300434));
    this.sid = ((TextProgressBar)localView.findViewById(2131300436));
    this.sid.setTextSize(14);
    this.sic.setOnClickListener(this);
    this.sid.setOnClickListener(this);
    this.sie = new d(getContext());
    this.sie.seK = new DialogInterface.OnClickListener()
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
    if (this.sgX != null)
    {
      this.sgX.fh(aj.getContext());
      this.sgX.bRs();
      cEh();
    }
    AppMethodBeat.o(42070);
  }
  
  public void setDownloadInfo(l paraml)
  {
    AppMethodBeat.i(42071);
    this.sgX = paraml;
    com.tencent.mm.plugin.game.f.c.bNl().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42063);
        GameDownloadView.b(GameDownloadView.this).fh(aj.getContext());
        GameDownloadView.b(GameDownloadView.this).bRs();
        GameDownloadView.a(GameDownloadView.this);
        AppMethodBeat.o(42063);
      }
    });
    cEh();
    AppMethodBeat.o(42071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */