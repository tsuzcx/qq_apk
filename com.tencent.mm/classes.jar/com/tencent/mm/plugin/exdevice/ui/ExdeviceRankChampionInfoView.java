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
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private TextPaint ayp;
  private int gIk;
  private String lJm;
  private TextView oOh;
  private ImageView qnO;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24183);
    this.gIk = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493880, this, true);
    this.ayp = new TextPaint(1);
    this.oOh = ((TextView)paramAttributeSet.findViewById(2131305905));
    this.qnO = ((ImageView)paramAttributeSet.findViewById(2131296997));
    this.qnO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24180);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (bu.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ae.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24180);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24180);
      }
    });
    this.oOh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24181);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (bu.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ae.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24181);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24181);
      }
    });
    try
    {
      this.gIk = paramContext.getResources().getDimensionPixelSize(2131165335);
      if (this.gIk <= 0) {
        this.gIk = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.gIk <= 0) {
          this.gIk = 128;
        }
      }
    }
    finally
    {
      if (this.gIk > 0) {
        break label199;
      }
      this.gIk = 128;
      AppMethodBeat.o(24183);
    }
    ae.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.gIk) });
    AppMethodBeat.o(24183);
  }
  
  public final void adK(String paramString)
  {
    AppMethodBeat.i(24184);
    this.lJm = paramString;
    if (this.oOh != null)
    {
      if (bu.isNullOrNil(paramString)) {
        break label168;
      }
      this.oOh.setVisibility(0);
      Object localObject = getContext();
      String str = this.lJm;
      int i = this.gIk;
      localObject = ((Context)localObject).getString(2131758497, new Object[] { TextUtils.ellipsize(k.c(getContext(), w.zP(str)), this.ayp, i, TextUtils.TruncateAt.END) });
      ae.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { k.c(getContext(), (CharSequence)localObject) });
      this.oOh.setText(k.b(getContext(), (CharSequence)localObject, this.oOh.getTextSize()));
    }
    while (this.qnO != null) {
      if (!bu.isNullOrNil(paramString))
      {
        a.b.d(this.qnO, paramString);
        this.qnO.setVisibility(0);
        AppMethodBeat.o(24184);
        return;
        label168:
        this.oOh.setVisibility(8);
        this.oOh.setText("");
      }
      else
      {
        this.qnO.setVisibility(4);
      }
    }
    AppMethodBeat.o(24184);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(24182);
    this.oOh.setAlpha(paramFloat);
    this.qnO.setAlpha(paramFloat);
    AppMethodBeat.o(24182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */