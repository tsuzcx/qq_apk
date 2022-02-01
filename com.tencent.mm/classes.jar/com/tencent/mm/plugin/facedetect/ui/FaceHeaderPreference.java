package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private MMActivity iXq;
  private ImageView jmf;
  private String mTitle;
  private TextView titleTv;
  private View.OnClickListener wAa;
  private String wAb;
  private String wAc;
  private int wzX;
  private Button wzY;
  private View wzZ;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.wzX = 255;
    this.wAa = null;
    this.wAb = "";
    this.wAc = "";
    this.iXq = ((MMActivity)paramContext);
    setLayoutResource(a.g.face_print_pref_header);
    AppMethodBeat.o(104020);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.wAa = paramOnClickListener;
    if ((this.wzY == null) || (this.wzZ == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.wzY != null) && (this.wAa != null))
    {
      this.wzY.setOnClickListener(paramOnClickListener);
      this.wzY.setVisibility(0);
      this.wzZ.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.wzY.setVisibility(8);
    this.wzZ.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.wAb = paramString1;
    this.wAc = paramString2;
    if (this.titleTv != null)
    {
      if (!Util.isNullOrNil(this.wAb))
      {
        this.titleTv.setText(this.wAb);
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
    this.jmf = ((ImageView)paramView.findViewById(a.e.face_print_sucesss_icon));
    this.titleTv = ((TextView)paramView.findViewById(a.e.face_print_title));
    this.wzY = ((Button)paramView.findViewById(a.e.right_btn));
    this.wzZ = paramView.findViewById(a.e.button_ll);
    if (!Util.isNullOrNil(this.wAb))
    {
      this.titleTv.setText(this.wAb);
      this.titleTv.setVisibility(0);
    }
    while ((this.wzY != null) && (this.wAa != null))
    {
      this.wzY.setOnClickListener(this.wAa);
      this.wzY.setVisibility(0);
      this.wzZ.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.wzY != null) {
      this.wzY.setVisibility(8);
    }
    this.wzZ.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */