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
  private Drawable JNA;
  private Drawable JNB;
  private boolean JNC;
  private a JND;
  private View.OnTouchListener JNE;
  private ImageView JNx;
  private TextView JNy;
  private Drawable JNz;
  private boolean egk;
  private boolean idG;
  private String text;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.idG = false;
    this.egk = true;
    this.JNE = new View.OnTouchListener()
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
            IPCallFuncButton.g(IPCallFuncButton.this).sK(IPCallFuncButton.e(IPCallFuncButton.this));
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
              IPCallFuncButton.g(IPCallFuncButton.this).sK(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(R.i.gkN, this);
    this.JNx = ((ImageView)findViewById(R.h.button));
    this.JNy = ((TextView)findViewById(R.h.text));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.n.hag, 0, 0);
    this.JNz = paramContext.getDrawable(R.n.haj);
    this.JNA = paramContext.getDrawable(R.n.hak);
    this.JNC = paramContext.getBoolean(R.n.hah, false);
    this.JNB = paramContext.getDrawable(R.n.hai);
    int i = paramContext.getResourceId(R.n.hal, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!Util.isNullOrNil(this.text)) {
      this.JNy.setText(this.text);
    }
    for (;;)
    {
      if (this.JNz != null) {
        this.JNx.setImageDrawable(this.JNz);
      }
      this.JNx.setClickable(true);
      this.JNx.setOnTouchListener(this.JNE);
      AppMethodBeat.o(25799);
      return;
      this.JNy.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.JNC) {
      return this.idG;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.JNC != paramBoolean)
    {
      this.JNC = paramBoolean;
      this.idG = false;
      if (this.JNz != null) {
        this.JNx.setImageDrawable(this.JNz);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.idG) && (this.JNC))
    {
      this.idG = paramBoolean;
      if (this.idG)
      {
        this.JNx.setImageDrawable(this.JNA);
        AppMethodBeat.o(25803);
        return;
      }
      this.JNx.setImageDrawable(this.JNz);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(a parama)
  {
    this.JND = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.egk)
    {
      this.egk = paramBoolean;
      if ((this.egk) || (this.JNB == null)) {
        break label56;
      }
      this.JNx.setImageDrawable(this.JNB);
    }
    for (;;)
    {
      this.idG = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.JNx.setImageDrawable(this.JNz);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.JNy.setText(this.text);
    AppMethodBeat.o(25800);
  }
  
  public static abstract interface a
  {
    public abstract void sK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */