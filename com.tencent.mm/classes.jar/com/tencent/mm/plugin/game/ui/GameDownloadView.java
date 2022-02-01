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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private k.a xQH;
  private l xQJ;
  private Button xRO;
  private TextProgressBar xRP;
  private d xRQ;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42066);
    this.xQH = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42065);
        if ((!paramAnonymousBoolean) || (Util.isNullOrNil(paramAnonymousString)))
        {
          AppMethodBeat.o(42065);
          return;
        }
        if ((GameDownloadView.b(GameDownloadView.this) == null) || (GameDownloadView.b(GameDownloadView.this).xEP == null) || (!GameDownloadView.b(GameDownloadView.this).xEP.field_appId.equals(paramAnonymousString)))
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
  
  private void dWo()
  {
    AppMethodBeat.i(42072);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42064);
        GameDownloadView.e(GameDownloadView.this).a(GameDownloadView.c(GameDownloadView.this), GameDownloadView.d(GameDownloadView.this), GameDownloadView.b(GameDownloadView.this).xEP, GameDownloadView.b(GameDownloadView.this));
        AppMethodBeat.o(42064);
      }
    });
    AppMethodBeat.o(42072);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(42069);
    super.onAttachedToWindow();
    k.a(this.xQH);
    AppMethodBeat.o(42069);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42073);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.xQJ.gi(MMApplicationContext.getContext());
    this.xRQ.a(this.xQJ.xEP, this.xQJ);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42073);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(42068);
    super.onDetachedFromWindow();
    k.b(this.xQH);
    AppMethodBeat.o(42068);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(42067);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494857, this, true);
    this.xRO = ((Button)localView.findViewById(2131301957));
    this.xRP = ((TextProgressBar)localView.findViewById(2131301959));
    this.xRP.setTextSize(14);
    this.xRO.setOnClickListener(this);
    this.xRP.setOnClickListener(this);
    this.xRQ = new d(getContext());
    this.xRQ.xOA = new DialogInterface.OnClickListener()
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
    if (this.xQJ != null)
    {
      this.xQJ.gi(MMApplicationContext.getContext());
      this.xQJ.cCq();
      dWo();
    }
    AppMethodBeat.o(42070);
  }
  
  public void setDownloadInfo(l paraml)
  {
    AppMethodBeat.i(42071);
    this.xQJ = paraml;
    com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42063);
        GameDownloadView.b(GameDownloadView.this).gi(MMApplicationContext.getContext());
        GameDownloadView.b(GameDownloadView.this).cCq();
        GameDownloadView.a(GameDownloadView.this);
        AppMethodBeat.o(42063);
      }
    });
    dWo();
    AppMethodBeat.o(42071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */