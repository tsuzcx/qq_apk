package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.sdk.platformtools.bo;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean bTy;
  private boolean cJz;
  private ImageView nTJ;
  private TextView nTK;
  private Drawable nTL;
  private Drawable nTM;
  private Drawable nTN;
  private boolean nTO;
  private a nTP;
  private View.OnTouchListener nTQ;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22181);
    this.cJz = false;
    this.bTy = true;
    this.nTQ = new IPCallFuncButton.1(this);
    LayoutInflater.from(getContext()).inflate(2130969929, this);
    this.nTJ = ((ImageView)findViewById(2131820875));
    this.nTK = ((TextView)findViewById(2131820676));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.a.IPCallFuncButton, 0, 0);
    this.nTL = paramContext.getDrawable(0);
    this.nTM = paramContext.getDrawable(1);
    this.nTO = paramContext.getBoolean(4, false);
    this.nTN = paramContext.getDrawable(2);
    int i = paramContext.getResourceId(3, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!bo.isNullOrNil(this.text)) {
      this.nTK.setText(this.text);
    }
    for (;;)
    {
      if (this.nTL != null) {
        this.nTJ.setImageDrawable(this.nTL);
      }
      this.nTJ.setClickable(true);
      this.nTJ.setOnTouchListener(this.nTQ);
      AppMethodBeat.o(22181);
      return;
      this.nTK.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.nTO) {
      return this.cJz;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(22183);
    if (this.nTO != paramBoolean)
    {
      this.nTO = paramBoolean;
      this.cJz = false;
      if (this.nTL != null) {
        this.nTJ.setImageDrawable(this.nTL);
      }
    }
    AppMethodBeat.o(22183);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(22185);
    if ((paramBoolean != this.cJz) && (this.nTO))
    {
      this.cJz = paramBoolean;
      if (this.cJz)
      {
        this.nTJ.setImageDrawable(this.nTM);
        AppMethodBeat.o(22185);
        return;
      }
      this.nTJ.setImageDrawable(this.nTL);
    }
    AppMethodBeat.o(22185);
  }
  
  public void setClickCallback(a parama)
  {
    this.nTP = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(22184);
    if (paramBoolean != this.bTy)
    {
      this.bTy = paramBoolean;
      if ((this.bTy) || (this.nTN == null)) {
        break label56;
      }
      this.nTJ.setImageDrawable(this.nTN);
    }
    for (;;)
    {
      this.cJz = false;
      AppMethodBeat.o(22184);
      return;
      label56:
      this.nTJ.setImageDrawable(this.nTL);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(22182);
    this.text = paramString;
    this.nTK.setText(this.text);
    AppMethodBeat.o(22182);
  }
  
  public static abstract interface a
  {
    public abstract void iL(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */