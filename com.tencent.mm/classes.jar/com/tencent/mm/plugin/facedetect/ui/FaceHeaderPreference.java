package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private MMActivity fNT;
  private ImageView fWT;
  private String mTitle;
  private View rtA;
  private View.OnClickListener rtB;
  private String rtC;
  private String rtD;
  private int rty;
  private Button rtz;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.rty = 255;
    this.rtB = null;
    this.rtC = "";
    this.rtD = "";
    this.fNT = ((MMActivity)paramContext);
    setLayoutResource(2131493918);
    AppMethodBeat.o(104020);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.rtB = paramOnClickListener;
    if ((this.rtz == null) || (this.rtA == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.rtz != null) && (this.rtB != null))
    {
      this.rtz.setOnClickListener(paramOnClickListener);
      this.rtz.setVisibility(0);
      this.rtA.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.rtz.setVisibility(8);
    this.rtA.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.rtC = paramString1;
    this.rtD = paramString2;
    if (this.titleTv != null)
    {
      if (!bu.isNullOrNil(this.rtC))
      {
        this.titleTv.setText(this.rtC);
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
    this.fWT = ((ImageView)paramView.findViewById(2131299700));
    this.titleTv = ((TextView)paramView.findViewById(2131299701));
    this.rtz = ((Button)paramView.findViewById(2131304179));
    this.rtA = paramView.findViewById(2131297656);
    if (!bu.isNullOrNil(this.rtC))
    {
      this.titleTv.setText(this.rtC);
      this.titleTv.setVisibility(0);
    }
    while ((this.rtz != null) && (this.rtB != null))
    {
      this.rtz.setOnClickListener(this.rtB);
      this.rtz.setVisibility(0);
      this.rtA.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.rtz != null) {
      this.rtz.setVisibility(8);
    }
    this.rtA.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */