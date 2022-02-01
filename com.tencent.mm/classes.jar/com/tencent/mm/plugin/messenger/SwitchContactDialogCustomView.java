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
  private TextView EUG;
  private ImageView EUH;
  private TextView EUI;
  private TextView EUJ;
  private TextView eM;
  
  public SwitchContactDialogCustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchContactDialogCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(90742);
    LayoutInflater.from(paramContext).inflate(b.c.alert_comfirm_custom_area, this);
    this.eM = ((TextView)findViewById(b.b.title));
    this.EUG = ((TextView)findViewById(b.b.content));
    this.EUH = ((ImageView)findViewById(b.b.photo));
    this.EUI = ((TextView)findViewById(b.b.desc));
    this.EUJ = ((TextView)findViewById(b.b.sub_desc));
    AppMethodBeat.o(90742);
  }
  
  public void setContent(String paramString)
  {
    AppMethodBeat.i(90744);
    this.EUG.setText(paramString);
    AppMethodBeat.o(90744);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(90745);
    this.EUI.setText(paramString);
    AppMethodBeat.o(90745);
  }
  
  public void setOnPhotoOnClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(90748);
    if (this.EUH != null) {
      this.EUH.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(90748);
  }
  
  public void setPhoto(String paramString)
  {
    AppMethodBeat.i(90747);
    a.b.c(this.EUH, paramString);
    AppMethodBeat.o(90747);
  }
  
  public void setSubDesc(String paramString)
  {
    AppMethodBeat.i(90746);
    this.EUJ.setText(paramString);
    AppMethodBeat.o(90746);
  }
  
  public void setTilte(String paramString)
  {
    AppMethodBeat.i(90743);
    this.eM.setText(paramString);
    AppMethodBeat.o(90743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView
 * JD-Core Version:    0.7.0.1
 */