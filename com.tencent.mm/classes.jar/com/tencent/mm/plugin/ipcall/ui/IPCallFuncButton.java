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
import com.tencent.mm.sdk.platformtools.bt;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean cEP;
  private boolean dAt;
  private ImageView sHE;
  private TextView sHF;
  private Drawable sHG;
  private Drawable sHH;
  private Drawable sHI;
  private boolean sHJ;
  private a sHK;
  private View.OnTouchListener sHL;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.dAt = false;
    this.cEP = true;
    this.sHL = new View.OnTouchListener()
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
            IPCallFuncButton.g(IPCallFuncButton.this).mA(IPCallFuncButton.e(IPCallFuncButton.this));
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
              IPCallFuncButton.g(IPCallFuncButton.this).mA(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(2131494507, this);
    this.sHE = ((ImageView)findViewById(2131297631));
    this.sHF = ((TextView)findViewById(2131305710));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.a.IPCallFuncButton, 0, 0);
    this.sHG = paramContext.getDrawable(2);
    this.sHH = paramContext.getDrawable(3);
    this.sHJ = paramContext.getBoolean(0, false);
    this.sHI = paramContext.getDrawable(1);
    int i = paramContext.getResourceId(4, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!bt.isNullOrNil(this.text)) {
      this.sHF.setText(this.text);
    }
    for (;;)
    {
      if (this.sHG != null) {
        this.sHE.setImageDrawable(this.sHG);
      }
      this.sHE.setClickable(true);
      this.sHE.setOnTouchListener(this.sHL);
      AppMethodBeat.o(25799);
      return;
      this.sHF.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.sHJ) {
      return this.dAt;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.sHJ != paramBoolean)
    {
      this.sHJ = paramBoolean;
      this.dAt = false;
      if (this.sHG != null) {
        this.sHE.setImageDrawable(this.sHG);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.dAt) && (this.sHJ))
    {
      this.dAt = paramBoolean;
      if (this.dAt)
      {
        this.sHE.setImageDrawable(this.sHH);
        AppMethodBeat.o(25803);
        return;
      }
      this.sHE.setImageDrawable(this.sHG);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(a parama)
  {
    this.sHK = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.cEP)
    {
      this.cEP = paramBoolean;
      if ((this.cEP) || (this.sHI == null)) {
        break label56;
      }
      this.sHE.setImageDrawable(this.sHI);
    }
    for (;;)
    {
      this.dAt = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.sHE.setImageDrawable(this.sHG);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.sHF.setText(this.text);
    AppMethodBeat.o(25800);
  }
  
  public static abstract interface a
  {
    public abstract void mA(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */