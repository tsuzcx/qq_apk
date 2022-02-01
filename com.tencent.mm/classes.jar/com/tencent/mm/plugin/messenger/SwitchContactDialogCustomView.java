package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;

public class SwitchContactDialogCustomView
  extends LinearLayout
{
  private TextView Vw;
  private TextView uFW;
  private ImageView uFX;
  private TextView uFY;
  private TextView uFZ;
  
  public SwitchContactDialogCustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchContactDialogCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(90742);
    LayoutInflater.from(paramContext).inflate(2131492955, this);
    this.Vw = ((TextView)findViewById(2131305902));
    this.uFW = ((TextView)findViewById(2131298739));
    this.uFX = ((ImageView)findViewById(2131303240));
    this.uFY = ((TextView)findViewById(2131298996));
    this.uFZ = ((TextView)findViewById(2131305506));
    AppMethodBeat.o(90742);
  }
  
  public void setContent(String paramString)
  {
    AppMethodBeat.i(90744);
    this.uFW.setText(paramString);
    AppMethodBeat.o(90744);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(90745);
    this.uFY.setText(paramString);
    AppMethodBeat.o(90745);
  }
  
  public void setOnPhotoOnClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(90748);
    if (this.uFX != null) {
      this.uFX.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(90748);
  }
  
  public void setPhoto(String paramString)
  {
    AppMethodBeat.i(90747);
    a.b.c(this.uFX, paramString);
    AppMethodBeat.o(90747);
  }
  
  public void setSubDesc(String paramString)
  {
    AppMethodBeat.i(90746);
    this.uFZ.setText(paramString);
    AppMethodBeat.o(90746);
  }
  
  public void setTilte(String paramString)
  {
    AppMethodBeat.i(90743);
    this.Vw.setText(paramString);
    AppMethodBeat.o(90743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView
 * JD-Core Version:    0.7.0.1
 */