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
  private MMActivity fLP;
  private ImageView fUN;
  private String mTitle;
  private int rlt;
  private Button rlu;
  private View rlv;
  private View.OnClickListener rlw;
  private String rlx;
  private String rly;
  private TextView titleTv;
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(104019);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(104019);
  }
  
  public FaceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104020);
    this.mTitle = "";
    this.rlt = 255;
    this.rlw = null;
    this.rlx = "";
    this.rly = "";
    this.fLP = ((MMActivity)paramContext);
    setLayoutResource(2131493918);
    AppMethodBeat.o(104020);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(104022);
    this.rlw = paramOnClickListener;
    if ((this.rlu == null) || (this.rlv == null))
    {
      AppMethodBeat.o(104022);
      return;
    }
    if ((this.rlu != null) && (this.rlw != null))
    {
      this.rlu.setOnClickListener(paramOnClickListener);
      this.rlu.setVisibility(0);
      this.rlv.setVisibility(0);
      AppMethodBeat.o(104022);
      return;
    }
    this.rlu.setVisibility(8);
    this.rlv.setVisibility(8);
    AppMethodBeat.o(104022);
  }
  
  public final void gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104021);
    this.rlx = paramString1;
    this.rly = paramString2;
    if (this.titleTv != null)
    {
      if (!bt.isNullOrNil(this.rlx))
      {
        this.titleTv.setText(this.rlx);
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
    this.fUN = ((ImageView)paramView.findViewById(2131299700));
    this.titleTv = ((TextView)paramView.findViewById(2131299701));
    this.rlu = ((Button)paramView.findViewById(2131304179));
    this.rlv = paramView.findViewById(2131297656);
    if (!bt.isNullOrNil(this.rlx))
    {
      this.titleTv.setText(this.rlx);
      this.titleTv.setVisibility(0);
    }
    while ((this.rlu != null) && (this.rlw != null))
    {
      this.rlu.setOnClickListener(this.rlw);
      this.rlu.setVisibility(0);
      this.rlv.setVisibility(0);
      AppMethodBeat.o(104023);
      return;
      this.titleTv.setVisibility(8);
    }
    if (this.rlu != null) {
      this.rlu.setVisibility(8);
    }
    this.rlv.setVisibility(8);
    AppMethodBeat.o(104023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */