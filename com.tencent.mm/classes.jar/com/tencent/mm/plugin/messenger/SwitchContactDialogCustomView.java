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
  private TextView Xy;
  private TextView zpj;
  private ImageView zpk;
  private TextView zpl;
  private TextView zpm;
  
  public SwitchContactDialogCustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchContactDialogCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(90742);
    LayoutInflater.from(paramContext).inflate(2131492988, this);
    this.Xy = ((TextView)findViewById(2131309195));
    this.zpj = ((TextView)findViewById(2131299180));
    this.zpk = ((ImageView)findViewById(2131305908));
    this.zpl = ((TextView)findViewById(2131299495));
    this.zpm = ((TextView)findViewById(2131308715));
    AppMethodBeat.o(90742);
  }
  
  public void setContent(String paramString)
  {
    AppMethodBeat.i(90744);
    this.zpj.setText(paramString);
    AppMethodBeat.o(90744);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(90745);
    this.zpl.setText(paramString);
    AppMethodBeat.o(90745);
  }
  
  public void setOnPhotoOnClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(90748);
    if (this.zpk != null) {
      this.zpk.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(90748);
  }
  
  public void setPhoto(String paramString)
  {
    AppMethodBeat.i(90747);
    a.b.c(this.zpk, paramString);
    AppMethodBeat.o(90747);
  }
  
  public void setSubDesc(String paramString)
  {
    AppMethodBeat.i(90746);
    this.zpm.setText(paramString);
    AppMethodBeat.o(90746);
  }
  
  public void setTilte(String paramString)
  {
    AppMethodBeat.i(90743);
    this.Xy.setText(paramString);
    AppMethodBeat.o(90743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView
 * JD-Core Version:    0.7.0.1
 */