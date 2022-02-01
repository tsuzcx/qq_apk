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
import com.tencent.mm.sdk.platformtools.Util;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean ded;
  private boolean edw;
  private String text;
  private ImageView ywk;
  private TextView ywl;
  private Drawable ywm;
  private Drawable ywn;
  private Drawable ywo;
  private boolean ywp;
  private IPCallFuncButton.a ywq;
  private View.OnTouchListener ywr;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.edw = false;
    this.ded = true;
    this.ywr = new View.OnTouchListener()
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
            IPCallFuncButton.g(IPCallFuncButton.this).qA(IPCallFuncButton.e(IPCallFuncButton.this));
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
              IPCallFuncButton.g(IPCallFuncButton.this).qA(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(2131495099, this);
    this.ywk = ((ImageView)findViewById(2131297893));
    this.ywl = ((TextView)findViewById(2131308977));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.a.IPCallFuncButton, 0, 0);
    this.ywm = paramContext.getDrawable(2);
    this.ywn = paramContext.getDrawable(3);
    this.ywp = paramContext.getBoolean(0, false);
    this.ywo = paramContext.getDrawable(1);
    int i = paramContext.getResourceId(4, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!Util.isNullOrNil(this.text)) {
      this.ywl.setText(this.text);
    }
    for (;;)
    {
      if (this.ywm != null) {
        this.ywk.setImageDrawable(this.ywm);
      }
      this.ywk.setClickable(true);
      this.ywk.setOnTouchListener(this.ywr);
      AppMethodBeat.o(25799);
      return;
      this.ywl.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.ywp) {
      return this.edw;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.ywp != paramBoolean)
    {
      this.ywp = paramBoolean;
      this.edw = false;
      if (this.ywm != null) {
        this.ywk.setImageDrawable(this.ywm);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.edw) && (this.ywp))
    {
      this.edw = paramBoolean;
      if (this.edw)
      {
        this.ywk.setImageDrawable(this.ywn);
        AppMethodBeat.o(25803);
        return;
      }
      this.ywk.setImageDrawable(this.ywm);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(IPCallFuncButton.a parama)
  {
    this.ywq = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.ded)
    {
      this.ded = paramBoolean;
      if ((this.ded) || (this.ywo == null)) {
        break label56;
      }
      this.ywk.setImageDrawable(this.ywo);
    }
    for (;;)
    {
      this.edw = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.ywk.setImageDrawable(this.ywm);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.ywl.setText(this.text);
    AppMethodBeat.o(25800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */