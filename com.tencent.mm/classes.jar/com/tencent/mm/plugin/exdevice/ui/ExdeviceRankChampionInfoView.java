package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class ExdeviceRankChampionInfoView
  extends LinearLayout
{
  private int dOA = 0;
  private TextPaint gI;
  private String hcm;
  private TextView iuO;
  private ImageView jAk;
  
  public ExdeviceRankChampionInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.exdevice_rank_champion_info_view, this, true);
    this.gI = new TextPaint(1);
    this.iuO = ((TextView)paramAttributeSet.findViewById(R.h.titleTV));
    this.jAk = ((ImageView)paramAttributeSet.findViewById(R.h.avatarIV));
    this.jAk.setOnClickListener(new ExdeviceRankChampionInfoView.1(this, paramContext));
    this.iuO.setOnClickListener(new ExdeviceRankChampionInfoView.2(this, paramContext));
    try
    {
      this.dOA = paramContext.getResources().getDimensionPixelSize(R.f.ExdeviceUserNameWidth);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", paramContext, "", new Object[0]);
        if (this.dOA <= 0) {
          this.dOA = 128;
        }
      }
    }
    finally
    {
      if (this.dOA > 0) {
        break label191;
      }
      this.dOA = 128;
    }
    y.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[] { Integer.valueOf(this.dOA) });
  }
  
  public final void BQ(String paramString)
  {
    this.hcm = paramString;
    if (this.iuO != null)
    {
      if (bk.bl(paramString)) {
        break label164;
      }
      this.iuO.setVisibility(0);
      Object localObject = getContext();
      int i = R.l.exdevice_champion_occupy_cover;
      String str = this.hcm;
      int j = this.dOA;
      localObject = ((Context)localObject).getString(i, new Object[] { TextUtils.ellipsize(j.b(getContext(), r.gV(str)), this.gI, j, TextUtils.TruncateAt.END) });
      y.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[] { j.b(getContext(), (CharSequence)localObject) });
      this.iuO.setText(j.a(getContext(), (CharSequence)localObject, this.iuO.getTextSize()));
    }
    for (;;)
    {
      if (this.jAk != null)
      {
        if (bk.bl(paramString)) {
          break;
        }
        a.b.n(this.jAk, paramString);
        this.jAk.setVisibility(0);
      }
      return;
      label164:
      this.iuO.setVisibility(8);
      this.iuO.setText("");
    }
    this.jAk.setVisibility(4);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.iuO.setAlpha(paramFloat);
    this.jAk.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView
 * JD-Core Version:    0.7.0.1
 */