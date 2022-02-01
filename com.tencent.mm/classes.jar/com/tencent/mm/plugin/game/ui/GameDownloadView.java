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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private k.a uyI;
  private l uyK;
  private Button uzP;
  private TextProgressBar uzQ;
  private d uzR;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42066);
    this.uyI = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42065);
        if ((!paramAnonymousBoolean) || (bu.isNullOrNil(paramAnonymousString)))
        {
          AppMethodBeat.o(42065);
          return;
        }
        if ((GameDownloadView.b(GameDownloadView.this) == null) || (GameDownloadView.b(GameDownloadView.this).umx == null) || (!GameDownloadView.b(GameDownloadView.this).umx.field_appId.equals(paramAnonymousString)))
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
  
  private void dcH()
  {
    AppMethodBeat.i(42072);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42064);
        GameDownloadView.e(GameDownloadView.this).a(GameDownloadView.c(GameDownloadView.this), GameDownloadView.d(GameDownloadView.this), GameDownloadView.b(GameDownloadView.this).umx, GameDownloadView.b(GameDownloadView.this));
        AppMethodBeat.o(42064);
      }
    });
    AppMethodBeat.o(42072);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42069);
    super.onAttachedToWindow();
    k.a(this.uyI);
    AppMethodBeat.o(42069);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42073);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.uyK.fC(ak.getContext());
    this.uzR.a(this.uyK.umx, this.uyK);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42068);
    super.onDetachedFromWindow();
    k.b(this.uyI);
    AppMethodBeat.o(42068);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42067);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494295, this, true);
    this.uzP = ((Button)localView.findViewById(2131300434));
    this.uzQ = ((TextProgressBar)localView.findViewById(2131300436));
    this.uzQ.setTextSize(14);
    this.uzP.setOnClickListener(this);
    this.uzQ.setOnClickListener(this);
    this.uzR = new d(getContext());
    this.uzR.uwz = new DialogInterface.OnClickListener()
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
    if (this.uyK != null)
    {
      this.uyK.fC(ak.getContext());
      this.uyK.ceA();
      dcH();
    }
    AppMethodBeat.o(42070);
  }
  
  public void setDownloadInfo(l paraml)
  {
    AppMethodBeat.i(42071);
    this.uyK = paraml;
    com.tencent.mm.plugin.game.f.c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42063);
        GameDownloadView.b(GameDownloadView.this).fC(ak.getContext());
        GameDownloadView.b(GameDownloadView.this).ceA();
        GameDownloadView.a(GameDownloadView.this);
        AppMethodBeat.o(42063);
      }
    });
    dcH();
    AppMethodBeat.o(42071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */