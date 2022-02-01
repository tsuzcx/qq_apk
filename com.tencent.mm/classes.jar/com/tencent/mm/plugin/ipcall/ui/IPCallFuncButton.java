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
import com.tencent.mm.R.a;
import com.tencent.mm.sdk.platformtools.bs;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean cBX;
  private boolean dyf;
  private ImageView tPl;
  private TextView tPm;
  private Drawable tPn;
  private Drawable tPo;
  private Drawable tPp;
  private boolean tPq;
  private a tPr;
  private View.OnTouchListener tPs;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.dyf = false;
    this.cBX = true;
    this.tPs = new View.OnTouchListener()
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
            IPCallFuncButton.g(IPCallFuncButton.this).nt(IPCallFuncButton.e(IPCallFuncButton.this));
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
              IPCallFuncButton.g(IPCallFuncButton.this).nt(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(2131494507, this);
    this.tPl = ((ImageView)findViewById(2131297631));
    this.tPm = ((TextView)findViewById(2131305710));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.a.IPCallFuncButton, 0, 0);
    this.tPn = paramContext.getDrawable(2);
    this.tPo = paramContext.getDrawable(3);
    this.tPq = paramContext.getBoolean(0, false);
    this.tPp = paramContext.getDrawable(1);
    int i = paramContext.getResourceId(4, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!bs.isNullOrNil(this.text)) {
      this.tPm.setText(this.text);
    }
    for (;;)
    {
      if (this.tPn != null) {
        this.tPl.setImageDrawable(this.tPn);
      }
      this.tPl.setClickable(true);
      this.tPl.setOnTouchListener(this.tPs);
      AppMethodBeat.o(25799);
      return;
      this.tPm.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.tPq) {
      return this.dyf;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.tPq != paramBoolean)
    {
      this.tPq = paramBoolean;
      this.dyf = false;
      if (this.tPn != null) {
        this.tPl.setImageDrawable(this.tPn);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.dyf) && (this.tPq))
    {
      this.dyf = paramBoolean;
      if (this.dyf)
      {
        this.tPl.setImageDrawable(this.tPo);
        AppMethodBeat.o(25803);
        return;
      }
      this.tPl.setImageDrawable(this.tPn);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(a parama)
  {
    this.tPr = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.cBX)
    {
      this.cBX = paramBoolean;
      if ((this.cBX) || (this.tPp == null)) {
        break label56;
      }
      this.tPl.setImageDrawable(this.tPp);
    }
    for (;;)
    {
      this.dyf = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.tPl.setImageDrawable(this.tPn);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.tPm.setText(this.text);
    AppMethodBeat.o(25800);
  }
  
  public static abstract interface a
  {
    public abstract void nt(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */