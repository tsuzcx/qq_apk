package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference
  extends Preference
{
  private MMActivity cmc;
  private ImageView iQd;
  private String mTitle;
  private int mml;
  private Button mmm;
  private View mmn;
  private View.OnClickListener mmo;
  private String mmp;
  private String mmq;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(500);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(500);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(501);
    this.mTitle = "";
    this.mml = 255;
    this.mmo = null;
    this.mmp = "";
    this.mmq = "";
    this.cmc = ((MMActivity)paramContext);
    setLayoutResource(2130969505);
    AppMethodBeat.o(501);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(503);
    this.mmo = paramOnClickListener;
    if ((this.mmm == null) || (this.mmn == null))
    {
      AppMethodBeat.o(503);
      return;
    }
    if ((this.mmm != null) && (this.mmo != null))
    {
      this.mmm.setOnClickListener(paramOnClickListener);
      this.mmm.setVisibility(0);
      this.mmn.setVisibility(0);
      AppMethodBeat.o(503);
      return;
    }
    this.mmm.setVisibility(8);
    this.mmn.setVisibility(8);
    AppMethodBeat.o(503);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(502);
    this.mmp = paramString1;
    this.mmq = paramString2;
    if (this.titleTv != null)
    {
      if (!bo.isNullOrNil(this.mmp))
      {
        this.titleTv.setText(this.mmp);
        this.titleTv.setVisibility(0);
        AppMethodBeat.o(502);
        return;
      }
      this.titleTv.setVisibility(8);
    }
    AppMethodBeat.o(502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(504);
    super.onBindView(paramView);
    this.iQd = ((ImageView)paramView.findViewById(2131823906));
    this.titleTv = ((TextView)paramView.findViewById(2131823907));
    this.mmm = ((Button)paramView.findViewById(2131823890));
    this.mmn = paramView.findViewById(2131823908);
    if (!bo.isNullOrNil(this.mmp))
    {
      this.titleTv.setText(this.mmp);
      this.titleTv.setVisibility(0);
    }
    while ((this.mmm != null) && (this.mmo != null))
    {
      this.mmm.setOnClickListener(this.mmo);
      this.mmm.setVisibility(0);
      this.mmn.setVisibility(0);
      AppMethodBeat.o(504);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.mmm != null) {
      this.mmm.setVisibility(8);
    }
    this.mmn.setVisibility(8);
    AppMethodBeat.o(504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */