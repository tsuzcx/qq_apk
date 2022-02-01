package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private ImageView gBZ;
  private MMActivity gte;
  private String mTitle;
  private int sUb;
  private Button sUc;
  private View sUd;
  private View.OnClickListener sUe;
  private String sUf;
  private String sUg;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.sUb = 255;
    this.sUe = null;
    this.sUf = "";
    this.sUg = "";
    this.gte = ((MMActivity)paramContext);
    setLayoutResource(2131494086);
    AppMethodBeat.o(104020);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.sUe = paramOnClickListener;
    if ((this.sUc == null) || (this.sUd == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.sUc != null) && (this.sUe != null))
    {
      this.sUc.setOnClickListener(paramOnClickListener);
      this.sUc.setVisibility(0);
      this.sUd.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.sUc.setVisibility(8);
    this.sUd.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void gD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.sUf = paramString1;
    this.sUg = paramString2;
    if (this.titleTv != null)
    {
      if (!Util.isNullOrNil(this.sUf))
      {
        this.titleTv.setText(this.sUf);
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
    this.gBZ = ((ImageView)paramView.findViewById(2131300365));
    this.titleTv = ((TextView)paramView.findViewById(2131300366));
    this.sUc = ((Button)paramView.findViewById(2131307087));
    this.sUd = paramView.findViewById(2131297921);
    if (!Util.isNullOrNil(this.sUf))
    {
      this.titleTv.setText(this.sUf);
      this.titleTv.setVisibility(0);
    }
    while ((this.sUc != null) && (this.sUe != null))
    {
      this.sUc.setOnClickListener(this.sUe);
      this.sUc.setVisibility(0);
      this.sUd.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.sUc != null) {
      this.sUc.setVisibility(8);
    }
    this.sUd.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */