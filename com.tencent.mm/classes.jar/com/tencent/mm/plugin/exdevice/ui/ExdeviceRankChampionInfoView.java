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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private TextPaint awy;
  private int glT;
  private String lhM;
  private TextView oel;
  private ImageView pDE;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24183);
    this.glT = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493880, this, true);
    this.awy = new TextPaint(1);
    this.oel = ((TextView)paramAttributeSet.findViewById(2131305905));
    this.pDE = ((ImageView)paramAttributeSet.findViewById(2131296997));
    this.pDE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24180);
        if (bs.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ac.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          AppMethodBeat.o(24180);
          return;
        }
        Object localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24180);
      }
    });
    this.oel.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24181);
        if (bs.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ac.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          AppMethodBeat.o(24181);
          return;
        }
        Object localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24181);
      }
    });
    try
    {
      this.glT = paramContext.getResources().getDimensionPixelSize(2131165335);
      if (this.glT <= 0) {
        this.glT = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.glT <= 0) {
          this.glT = 128;
        }
      }
    }
    finally
    {
      if (this.glT > 0) {
        break label199;
      }
      this.glT = 128;
      AppMethodBeat.o(24183);
    }
    ac.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.glT) });
    AppMethodBeat.o(24183);
  }
  
  public final void Zn(String paramString)
  {
    AppMethodBeat.i(24184);
    this.lhM = paramString;
    if (this.oel != null)
    {
      if (bs.isNullOrNil(paramString)) {
        break label168;
      }
      this.oel.setVisibility(0);
      Object localObject = getContext();
      String str = this.lhM;
      int i = this.glT;
      localObject = ((Context)localObject).getString(2131758497, new Object[] { TextUtils.ellipsize(k.c(getContext(), v.wk(str)), this.awy, i, TextUtils.TruncateAt.END) });
      ac.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { k.c(getContext(), (CharSequence)localObject) });
      this.oel.setText(k.b(getContext(), (CharSequence)localObject, this.oel.getTextSize()));
    }
    while (this.pDE != null) {
      if (!bs.isNullOrNil(paramString))
      {
        a.b.d(this.pDE, paramString);
        this.pDE.setVisibility(0);
        AppMethodBeat.o(24184);
        return;
        label168:
        this.oel.setVisibility(8);
        this.oel.setText("");
      }
      else
      {
        this.pDE.setVisibility(4);
      }
    }
    AppMethodBeat.o(24184);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(24182);
    this.oel.setAlpha(paramFloat);
    this.pDE.setAlpha(paramFloat);
    AppMethodBeat.o(24182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */