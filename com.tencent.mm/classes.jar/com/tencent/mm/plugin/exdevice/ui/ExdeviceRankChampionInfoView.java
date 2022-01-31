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
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private int eMi;
  private TextPaint hB;
  private String ikj;
  private TextView kvS;
  private ImageView lJJ;
  
  public ExdeviceRankChampionInfoView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20112);
    this.eMi = 0;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2130969468, this, true);
    this.hB = new TextPaint(1);
    this.kvS = ((TextView)paramAttributeSet.findViewById(2131823739));
    this.lJJ = ((ImageView)paramAttributeSet.findViewById(2131823768));
    this.lJJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20109);
        if (bo.isNullOrNil(ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this)))
        {
          ab.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
          AppMethodBeat.o(20109);
          return;
        }
        paramAnonymousView = new Intent(paramContext, ExdeviceProfileUI.class);
        paramAnonymousView.putExtra("username", ExdeviceRankChampionInfoView.a(ExdeviceRankChampionInfoView.this));
        paramContext.startActivity(paramAnonymousView);
        AppMethodBeat.o(20109);
      }
    });
    this.kvS.setOnClickListener(new ExdeviceRankChampionInfoView.2(this, paramContext));
    try
    {
      this.eMi = paramContext.getResources().getDimensionPixelSize(2131427630);
      if (this.eMi <= 0) {
        this.eMi = 128;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.eMi <= 0) {
          this.eMi = 128;
        }
      }
    }
    finally
    {
      if (this.eMi > 0) {
        break label199;
      }
      this.eMi = 128;
      AppMethodBeat.o(20112);
    }
    ab.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.eMi) });
    AppMethodBeat.o(20112);
  }
  
  public final void LS(String paramString)
  {
    AppMethodBeat.i(20113);
    this.ikj = paramString;
    if (this.kvS != null)
    {
      if (bo.isNullOrNil(paramString)) {
        break label168;
      }
      this.kvS.setVisibility(0);
      Object localObject = getContext();
      String str = this.ikj;
      int i = this.eMi;
      localObject = ((Context)localObject).getString(2131299369, new Object[] { TextUtils.ellipsize(j.b(getContext(), s.nE(str)), this.hB, i, TextUtils.TruncateAt.END) });
      ab.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { j.b(getContext(), (CharSequence)localObject) });
      this.kvS.setText(j.b(getContext(), (CharSequence)localObject, this.kvS.getTextSize()));
    }
    while (this.lJJ != null) {
      if (!bo.isNullOrNil(paramString))
      {
        a.b.s(this.lJJ, paramString);
        this.lJJ.setVisibility(0);
        AppMethodBeat.o(20113);
        return;
        label168:
        this.kvS.setVisibility(8);
        this.kvS.setText("");
      }
      else
      {
        this.lJJ.setVisibility(4);
      }
    }
    AppMethodBeat.o(20113);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(20111);
    this.kvS.setAlpha(paramFloat);
    this.lJJ.setAlpha(paramFloat);
    AppMethodBeat.o(20111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */