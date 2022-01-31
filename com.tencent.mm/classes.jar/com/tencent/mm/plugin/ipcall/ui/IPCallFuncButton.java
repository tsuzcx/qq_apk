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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.n;
import com.tencent.mm.sdk.platformtools.bk;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean ilC = false;
  private boolean lwA = true;
  private IPCallFuncButton.a lwB;
  private View.OnTouchListener lwC = new IPCallFuncButton.1(this);
  private ImageView lwu;
  private TextView lwv;
  private Drawable lww;
  private Drawable lwx;
  private Drawable lwy;
  private boolean lwz;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(R.i.ip_call_func_button, this);
    this.lwu = ((ImageView)findViewById(R.h.button));
    this.lwv = ((TextView)findViewById(R.h.text));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.n.IPCallFuncButton, 0, 0);
    this.lww = paramContext.getDrawable(R.n.IPCallFuncButton_drawableNormal);
    this.lwx = paramContext.getDrawable(R.n.IPCallFuncButton_drawablePress);
    this.lwz = paramContext.getBoolean(R.n.IPCallFuncButton_checkBoxMode, false);
    this.lwy = paramContext.getDrawable(R.n.IPCallFuncButton_drawableDisable);
    int i = paramContext.getResourceId(R.n.IPCallFuncButton_funcText, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!bk.bl(this.text)) {
      this.lwv.setText(this.text);
    }
    for (;;)
    {
      if (this.lww != null) {
        this.lwu.setImageDrawable(this.lww);
      }
      this.lwu.setClickable(true);
      this.lwu.setOnTouchListener(this.lwC);
      return;
      this.lwv.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.lwz) {
      return this.ilC;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    if (this.lwz != paramBoolean)
    {
      this.lwz = paramBoolean;
      this.ilC = false;
      if (this.lww != null) {
        this.lwu.setImageDrawable(this.lww);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((paramBoolean != this.ilC) && (this.lwz))
    {
      this.ilC = paramBoolean;
      if (this.ilC) {
        this.lwu.setImageDrawable(this.lwx);
      }
    }
    else
    {
      return;
    }
    this.lwu.setImageDrawable(this.lww);
  }
  
  public void setClickCallback(IPCallFuncButton.a parama)
  {
    this.lwB = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (paramBoolean != this.lwA)
    {
      this.lwA = paramBoolean;
      if ((this.lwA) || (this.lwy == null)) {
        break label44;
      }
      this.lwu.setImageDrawable(this.lwy);
    }
    for (;;)
    {
      this.ilC = false;
      return;
      label44:
      this.lwu.setImageDrawable(this.lww);
    }
  }
  
  public void setFuncText(String paramString)
  {
    this.text = paramString;
    this.lwv.setText(this.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */