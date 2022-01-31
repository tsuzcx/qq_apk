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
  private TextView Nx;
  private TextView oCR;
  private ImageView oCS;
  private TextView oCT;
  private TextView oCU;
  
  public SwitchContactDialogCustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchContactDialogCustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136912);
    LayoutInflater.from(paramContext).inflate(2130968646, this);
    this.Nx = ((TextView)findViewById(2131820680));
    this.oCR = ((TextView)findViewById(2131820946));
    this.oCS = ((ImageView)findViewById(2131821114));
    this.oCT = ((TextView)findViewById(2131821115));
    this.oCU = ((TextView)findViewById(2131821116));
    AppMethodBeat.o(136912);
  }
  
  public void setContent(String paramString)
  {
    AppMethodBeat.i(136914);
    this.oCR.setText(paramString);
    AppMethodBeat.o(136914);
  }
  
  public void setDesc(String paramString)
  {
    AppMethodBeat.i(136915);
    this.oCT.setText(paramString);
    AppMethodBeat.o(136915);
  }
  
  public void setOnPhotoOnClick(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(136918);
    if (this.oCS != null) {
      this.oCS.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(136918);
  }
  
  public void setPhoto(String paramString)
  {
    AppMethodBeat.i(136917);
    a.b.c(this.oCS, paramString);
    AppMethodBeat.o(136917);
  }
  
  public void setSubDesc(String paramString)
  {
    AppMethodBeat.i(136916);
    this.oCU.setText(paramString);
    AppMethodBeat.o(136916);
  }
  
  public void setTilte(String paramString)
  {
    AppMethodBeat.i(136913);
    this.Nx.setText(paramString);
    AppMethodBeat.o(136913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.SwitchContactDialogCustomView
 * JD-Core Version:    0.7.0.1
 */