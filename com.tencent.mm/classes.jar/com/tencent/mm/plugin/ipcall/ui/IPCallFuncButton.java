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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;

public class IPCallFuncButton
  extends LinearLayout
{
  private boolean cNF;
  private boolean dLH;
  private String text;
  private ImageView vdK;
  private TextView vdL;
  private Drawable vdM;
  private Drawable vdN;
  private Drawable vdO;
  private boolean vdP;
  private a vdQ;
  private View.OnTouchListener vdR;
  
  public IPCallFuncButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25799);
    this.dLH = false;
    this.cNF = true;
    this.vdR = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(25798);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFuncButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (!IPCallFuncButton.a(IPCallFuncButton.this))
        {
          a.a(false, this, "com/tencent/mm/plugin/ipcall/ui/IPCallFuncButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
          a.a(false, this, "com/tencent/mm/plugin/ipcall/ui/IPCallFuncButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
              break label231;
            }
            IPCallFuncButton.g(IPCallFuncButton.this).nR(IPCallFuncButton.e(IPCallFuncButton.this));
            break;
            IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.c(IPCallFuncButton.this));
            IPCallFuncButton.a(IPCallFuncButton.this, true);
          }
          label231:
          continue;
          if (((paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 1)) && (!IPCallFuncButton.b(IPCallFuncButton.this)))
          {
            if (IPCallFuncButton.f(IPCallFuncButton.this) != null) {
              IPCallFuncButton.d(IPCallFuncButton.this).setImageDrawable(IPCallFuncButton.f(IPCallFuncButton.this));
            }
            if (IPCallFuncButton.g(IPCallFuncButton.this) != null) {
              IPCallFuncButton.g(IPCallFuncButton.this).nR(false);
            }
          }
        }
      }
    };
    LayoutInflater.from(getContext()).inflate(2131494507, this);
    this.vdK = ((ImageView)findViewById(2131297631));
    this.vdL = ((TextView)findViewById(2131305710));
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.a.IPCallFuncButton, 0, 0);
    this.vdM = paramContext.getDrawable(2);
    this.vdN = paramContext.getDrawable(3);
    this.vdP = paramContext.getBoolean(0, false);
    this.vdO = paramContext.getDrawable(1);
    int i = paramContext.getResourceId(4, 0);
    if (i != 0) {
      this.text = getContext().getString(i);
    }
    paramContext.recycle();
    if (!bu.isNullOrNil(this.text)) {
      this.vdL.setText(this.text);
    }
    for (;;)
    {
      if (this.vdM != null) {
        this.vdK.setImageDrawable(this.vdM);
      }
      this.vdK.setClickable(true);
      this.vdK.setOnTouchListener(this.vdR);
      AppMethodBeat.o(25799);
      return;
      this.vdL.setVisibility(8);
    }
  }
  
  public String getFuncText()
  {
    return this.text;
  }
  
  public final boolean isChecked()
  {
    if (this.vdP) {
      return this.dLH;
    }
    return false;
  }
  
  public void setCheckBoxMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25801);
    if (this.vdP != paramBoolean)
    {
      this.vdP = paramBoolean;
      this.dLH = false;
      if (this.vdM != null) {
        this.vdK.setImageDrawable(this.vdM);
      }
    }
    AppMethodBeat.o(25801);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(25803);
    if ((paramBoolean != this.dLH) && (this.vdP))
    {
      this.dLH = paramBoolean;
      if (this.dLH)
      {
        this.vdK.setImageDrawable(this.vdN);
        AppMethodBeat.o(25803);
        return;
      }
      this.vdK.setImageDrawable(this.vdM);
    }
    AppMethodBeat.o(25803);
  }
  
  public void setClickCallback(a parama)
  {
    this.vdQ = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(25802);
    if (paramBoolean != this.cNF)
    {
      this.cNF = paramBoolean;
      if ((this.cNF) || (this.vdO == null)) {
        break label56;
      }
      this.vdK.setImageDrawable(this.vdO);
    }
    for (;;)
    {
      this.dLH = false;
      AppMethodBeat.o(25802);
      return;
      label56:
      this.vdK.setImageDrawable(this.vdM);
    }
  }
  
  public void setFuncText(String paramString)
  {
    AppMethodBeat.i(25800);
    this.text = paramString;
    this.vdL.setText(this.text);
    AppMethodBeat.o(25800);
  }
  
  public static abstract interface a
  {
    public abstract void nR(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton
 * JD-Core Version:    0.7.0.1
 */