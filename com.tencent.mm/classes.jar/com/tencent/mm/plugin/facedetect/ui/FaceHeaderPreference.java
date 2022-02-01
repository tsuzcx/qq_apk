package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private ImageView fxT;
  private MMActivity imP;
  private String mTitle;
  private int pSW;
  private Button pSX;
  private View pSY;
  private View.OnClickListener pSZ;
  private String pTa;
  private String pTb;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.pSW = 255;
    this.pSZ = null;
    this.pTa = "";
    this.pTb = "";
    this.imP = ((MMActivity)paramContext);
    setLayoutResource(2131493918);
    AppMethodBeat.o(104020);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.pSZ = paramOnClickListener;
    if ((this.pSX == null) || (this.pSY == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.pSX != null) && (this.pSZ != null))
    {
      this.pSX.setOnClickListener(paramOnClickListener);
      this.pSX.setVisibility(0);
      this.pSY.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.pSX.setVisibility(8);
    this.pSY.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.pTa = paramString1;
    this.pTb = paramString2;
    if (this.titleTv != null)
    {
      if (!bt.isNullOrNil(this.pTa))
      {
        this.titleTv.setText(this.pTa);
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
    this.fxT = ((ImageView)paramView.findViewById(2131299700));
    this.titleTv = ((TextView)paramView.findViewById(2131299701));
    this.pSX = ((Button)paramView.findViewById(2131304179));
    this.pSY = paramView.findViewById(2131297656);
    if (!bt.isNullOrNil(this.pTa))
    {
      this.titleTv.setText(this.pTa);
      this.titleTv.setVisibility(0);
    }
    while ((this.pSX != null) && (this.pSZ != null))
    {
      this.pSX.setOnClickListener(this.pSZ);
      this.pSX.setVisibility(0);
      this.pSY.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.pSX != null) {
      this.pSX.setVisibility(8);
    }
    this.pSY.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */