package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private ImageView fBA;
  private MMActivity iMV;
  private String mTitle;
  private int qBD;
  private Button qBE;
  private View qBF;
  private View.OnClickListener qBG;
  private String qBH;
  private String qBI;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.qBD = 255;
    this.qBG = null;
    this.qBH = "";
    this.qBI = "";
    this.iMV = ((MMActivity)paramContext);
    setLayoutResource(2131493918);
    AppMethodBeat.o(104020);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.qBG = paramOnClickListener;
    if ((this.qBE == null) || (this.qBF == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.qBE != null) && (this.qBG != null))
    {
      this.qBE.setOnClickListener(paramOnClickListener);
      this.qBE.setVisibility(0);
      this.qBF.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.qBE.setVisibility(8);
    this.qBF.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.qBH = paramString1;
    this.qBI = paramString2;
    if (this.titleTv != null)
    {
      if (!bs.isNullOrNil(this.qBH))
      {
        this.titleTv.setText(this.qBH);
        this.titleTv.setVisibility(0);
        AppMethodBeat.o(104021);
        return;
      }
      this.titleTv.setVisibility(8);
    }
    AppMethodBeat.o(104021);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104023);
    super.onBindView(paramView);
    this.fBA = ((ImageView)paramView.findViewById(2131299700));
    this.titleTv = ((TextView)paramView.findViewById(2131299701));
    this.qBE = ((Button)paramView.findViewById(2131304179));
    this.qBF = paramView.findViewById(2131297656);
    if (!bs.isNullOrNil(this.qBH))
    {
      this.titleTv.setText(this.qBH);
      this.titleTv.setVisibility(0);
    }
    while ((this.qBE != null) && (this.qBG != null))
    {
      this.qBE.setOnClickListener(this.qBG);
      this.qBE.setVisibility(0);
      this.qBF.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.qBE != null) {
      this.qBE.setVisibility(8);
    }
    this.qBF.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */