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
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private TextPaint ayn;
  private int huY;
  private String mRa;
  private TextView qbV;
  private ImageView rEV;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24183);
    this.huY = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494037, this, true);
    this.ayn = new TextPaint(1);
    this.qbV = ((TextView)paramAttributeSet.findViewById(2131309198));
    this.rEV = ((ImageView)paramAttributeSet.findViewById(2131297120));
    this.rEV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24180);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (Util.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          Log.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24180);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24180);
      }
    });
    this.qbV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24181);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (Util.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          Log.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24181);
          return;
        }
        localObject = new Intent(paramContext, ExdeviceProfileUI.class);
        ((Intent)localObject).putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramAnonymousView = paramContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24181);
      }
    });
    try
    {
      this.huY = paramContext.getResources().getDimensionPixelSize(2131165346);
      if (this.huY <= 0) {
        this.huY = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.huY <= 0) {
          this.huY = 128;
        }
      }
    }
    finally
    {
      if (this.huY > 0) {
        break label199;
      }
      this.huY = 128;
      AppMethodBeat.o(24183);
    }
    Log.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.huY) });
    AppMethodBeat.o(24183);
  }
  
  public final void anT(String paramString)
  {
    AppMethodBeat.i(24184);
    this.mRa = paramString;
    if (this.qbV != null)
    {
      if (Util.isNullOrNil(paramString)) {
        break label168;
      }
      this.qbV.setVisibility(0);
      Object localObject = getContext();
      String str = this.mRa;
      int i = this.huY;
      localObject = ((Context)localObject).getString(2131758796, new Object[] { TextUtils.ellipsize(l.c(getContext(), aa.getDisplayName(str)), this.ayn, i, TextUtils.TruncateAt.END) });
      Log.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { l.c(getContext(), (CharSequence)localObject) });
      this.qbV.setText(l.b(getContext(), (CharSequence)localObject, this.qbV.getTextSize()));
    }
    while (this.rEV != null) {
      if (!Util.isNullOrNil(paramString))
      {
        a.b.d(this.rEV, paramString);
        this.rEV.setVisibility(0);
        AppMethodBeat.o(24184);
        return;
        label168:
        this.qbV.setVisibility(8);
        this.qbV.setText("");
      }
      else
      {
        this.rEV.setVisibility(4);
      }
    }
    AppMethodBeat.o(24184);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(24182);
    this.qbV.setAlpha(paramFloat);
    this.rEV.setAlpha(paramFloat);
    AppMethodBeat.o(24182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */