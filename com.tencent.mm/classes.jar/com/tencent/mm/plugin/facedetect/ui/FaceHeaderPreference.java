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
  private ImageView lPb;
  private MMActivity lzt;
  private String mTitle;
  private TextView titleTv;
  private int zWi;
  private Button zWj;
  private View zWk;
  private View.OnClickListener zWl;
  private String zWm;
  private String zWn;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.zWi = 255;
    this.zWl = null;
    this.zWm = "";
    this.zWn = "";
    this.lzt = ((MMActivity)paramContext);
    setLayoutResource(a.g.face_print_pref_header);
    AppMethodBeat.o(104020);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.zWl = paramOnClickListener;
    if ((this.zWj == null) || (this.zWk == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.zWj != null) && (this.zWl != null))
    {
      this.zWj.setOnClickListener(paramOnClickListener);
      this.zWj.setVisibility(0);
      this.zWk.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.zWj.setVisibility(8);
    this.zWk.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void hA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.zWm = paramString1;
    this.zWn = paramString2;
    if (this.titleTv != null)
    {
      if (!Util.isNullOrNil(this.zWm))
      {
        this.titleTv.setText(this.zWm);
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
    this.lPb = ((ImageView)paramView.findViewById(a.e.face_print_sucesss_icon));
    this.titleTv = ((TextView)paramView.findViewById(a.e.face_print_title));
    this.zWj = ((Button)paramView.findViewById(a.e.right_btn));
    this.zWk = paramView.findViewById(a.e.button_ll);
    if (!Util.isNullOrNil(this.zWm))
    {
      this.titleTv.setText(this.zWm);
      this.titleTv.setVisibility(0);
    }
    while ((this.zWj != null) && (this.zWl != null))
    {
      this.zWj.setOnClickListener(this.zWl);
      this.zWj.setVisibility(0);
      this.zWk.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.zWj != null) {
      this.zWj.setVisibility(8);
    }
    this.zWk.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */