package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.n;
import com.tencent.mm.sdk.platformtools.Util;

public class IPCallFuncButton
  extends LinearLayout
{
  private ImageView DWo;
  private TextView DWp;
  private Drawable DWq;
  private Drawable DWr;
  private Drawable DWs;
  private boolean DWt;
  private a DWu;
  private View.OnTouchListener DWv;
  private boolean dih;
  private boolean fXF;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.fXF = false;
    this.dih = true;
    this.DWv = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(25798);
        if (!IPCallFuncButton.a(IPCallFuncButton.this))
        {
          AppMethodBeat.o(25798);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 0) {
          if (!IPCallFuncButton.b(IPCallFuncButton.this)) {
            if (IPCallFuncButton.c(IPCallFuncButton.this) != null) {
              IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.c(IPCallFuncButton.this));
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25798);
          return false;
          if (IPCallFuncButton.e(IPCallFuncButton.this))
          {
            IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.f(IPCallFuncButton.this));
            IPCallFuncButton.a(IPCallFuncButton.this, false);
          }
          for (;;)
          {
            if (IPCallFuncButton.g(IPCallFuncButton.this) == null) {
              break label171;
            }
            IPCallFuncButton.g(IPCallFuncButton.this).tC(IPCallFuncButton.e(IPCallFuncButton.this));
            break;
            IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.c(IPCallFuncButton.this));
            IPCallFuncButton.a(IPCallFuncButton.this, true);
          }
          label171:
          continue;
          if (((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) && (!IPCallFuncButton.b(IPCallFuncButton.this)))
          {
            if (IPCallFuncButton.f(IPCallFuncButton.this) != null) {
              IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.f(IPCallFuncButton.this));
            }
            if (IPCallFuncButton.g(IPCallFuncButton.this) != null) {
              IPCallFuncButton.g(IPCallFuncButton.this).tC(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(R.i.ehS, this);
    this.DWo = ((ImageView)findViewById(R.h.button));
    this.DWp = ((TextView)findViewById(R.h.text));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.n.eWD, 0, 0);
    this.DWq = paramContext.getDrawable(R.n.eWG);
    this.DWr = paramContext.getDrawable(R.n.eWH);
    this.DWt = paramContext.getBoolean(R.n.eWE, false);
    this.DWs = paramContext.getDrawable(R.n.eWF);
    int i = paramContext.getResourceId(R.n.eWI, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!Util.isNullOrNil(this.text)) {
      this.DWp.setText(this.text);
    }
    for (;;)
    {
      if (this.DWq != null) {
        this.DWo.setImageDrawable(this.DWq);
      }
      this.DWo.setClickable(true);
      this.DWo.setOnTouchListener(this.DWv);
      AppMethodBeat.o(25799);
      return;
      this.DWp.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.DWt) {
      return this.fXF;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.DWt != paramBoolean)
    {
      this.DWt = paramBoolean;
      this.fXF = false;
      if (this.DWq != null) {
        this.DWo.setImageDrawable(this.DWq);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.fXF) && (this.DWt))
    {
      this.fXF = paramBoolean;
      if (this.fXF)
      {
        this.DWo.setImageDrawable(this.DWr);
        AppMethodBeat.o(25803);
        return;
      }
      this.DWo.setImageDrawable(this.DWq);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(a parama)
  {
    this.DWu = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.dih)
    {
      this.dih = paramBoolean;
      if ((this.dih) || (this.DWs == null)) {
        break label56;
      }
      this.DWo.setImageDrawable(this.DWs);
    }
    for (;;)
    {
      this.fXF = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.DWo.setImageDrawable(this.DWq);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.DWp.setText(this.text);
    AppMethodBeat.o(25800);
  }
  
  public static abstract interface a
  {
    public abstract void tC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */