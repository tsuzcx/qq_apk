package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private TextPaint ayp;
  private int gFD;
  private String lEN;
  private TextView oHF;
  private ImageView qhj;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24183);
    this.gFD = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493880, this, true);
    this.ayp = new TextPaint(1);
    this.oHF = ((TextView)paramAttributeSet.findViewById(2131305905));
    this.qhj = ((ImageView)paramAttributeSet.findViewById(2131296997));
    this.qhj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24180);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (bt.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ad.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24180);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24180);
      }
    });
    this.oHF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24181);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (bt.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ad.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24181);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24181);
      }
    });
    try
    {
      this.gFD = paramContext.getResources().getDimensionPixelSize(2131165335);
      if (this.gFD <= 0) {
        this.gFD = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.gFD <= 0) {
          this.gFD = 128;
        }
      }
    }
    finally
    {
      if (this.gFD > 0) {
        break label199;
      }
      this.gFD = 128;
      AppMethodBeat.o(24183);
    }
    ad.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.gFD) });
    AppMethodBeat.o(24183);
  }
  
  public final void acT(String paramString)
  {
    AppMethodBeat.i(24184);
    this.lEN = paramString;
    if (this.oHF != null)
    {
      if (bt.isNullOrNil(paramString)) {
        break label168;
      }
      this.oHF.setVisibility(0);
      Object localObject = getContext();
      String str = this.lEN;
      int i = this.gFD;
      localObject = ((Context)localObject).getString(2131758497, new Object[] { TextUtils.ellipsize(k.c(getContext(), v.zf(str)), this.ayp, i, TextUtils.TruncateAt.END) });
      ad.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { k.c(getContext(), (CharSequence)localObject) });
      this.oHF.setText(k.b(getContext(), (CharSequence)localObject, this.oHF.getTextSize()));
    }
    while (this.qhj != null) {
      if (!bt.isNullOrNil(paramString))
      {
        a.b.d(this.qhj, paramString);
        this.qhj.setVisibility(0);
        AppMethodBeat.o(24184);
        return;
        label168:
        this.oHF.setVisibility(8);
        this.oHF.setText("");
      }
      else
      {
        this.qhj.setVisibility(4);
      }
    }
    AppMethodBeat.o(24184);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(24182);
    this.oHF.setAlpha(paramFloat);
    this.qhj.setAlpha(paramFloat);
    AppMethodBeat.o(24182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */