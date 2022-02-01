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
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private TextPaint avD;
  private int ghn;
  private String kGt;
  private TextView nBl;
  private ImageView pat;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24183);
    this.ghn = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493880, this, true);
    this.avD = new TextPaint(1);
    this.nBl = ((TextView)paramAttributeSet.findViewById(2131305905));
    this.pat = ((ImageView)paramAttributeSet.findViewById(2131296997));
    this.pat.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24180);
        if (bt.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ad.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          AppMethodBeat.o(24180);
          return;
        }
        Object localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24180);
      }
    });
    this.nBl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24181);
        if (bt.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ad.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          AppMethodBeat.o(24181);
          return;
        }
        Object localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24181);
      }
    });
    try
    {
      this.ghn = paramContext.getResources().getDimensionPixelSize(2131165335);
      if (this.ghn <= 0) {
        this.ghn = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.ghn <= 0) {
          this.ghn = 128;
        }
      }
    }
    finally
    {
      if (this.ghn > 0) {
        break label199;
      }
      this.ghn = 128;
      AppMethodBeat.o(24183);
    }
    ad.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.ghn) });
    AppMethodBeat.o(24183);
  }
  
  public final void Vb(String paramString)
  {
    AppMethodBeat.i(24184);
    this.kGt = paramString;
    if (this.nBl != null)
    {
      if (bt.isNullOrNil(paramString)) {
        break label168;
      }
      this.nBl.setVisibility(0);
      Object localObject = getContext();
      String str = this.kGt;
      int i = this.ghn;
      localObject = ((Context)localObject).getString(2131758497, new Object[] { TextUtils.ellipsize(k.c(getContext(), v.sh(str)), this.avD, i, TextUtils.TruncateAt.END) });
      ad.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { k.c(getContext(), (CharSequence)localObject) });
      this.nBl.setText(k.b(getContext(), (CharSequence)localObject, this.nBl.getTextSize()));
    }
    while (this.pat != null) {
      if (!bt.isNullOrNil(paramString))
      {
        a.b.d(this.pat, paramString);
        this.pat.setVisibility(0);
        AppMethodBeat.o(24184);
        return;
        label168:
        this.nBl.setVisibility(8);
        this.nBl.setText("");
      }
      else
      {
        this.pat.setVisibility(4);
      }
    }
    AppMethodBeat.o(24184);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(24182);
    this.nBl.setAlpha(paramFloat);
    this.pat.setAlpha(paramFloat);
    AppMethodBeat.o(24182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */