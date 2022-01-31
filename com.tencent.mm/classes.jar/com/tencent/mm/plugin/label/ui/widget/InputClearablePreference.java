package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference
  extends Preference
{
  public String hBF;
  private String mText;
  public String nZF;
  public String nZG;
  public int nZH;
  private int nZI;
  public boolean nZJ;
  public MMEditText nZK;
  private ImageView nZL;
  public TextView nZM;
  private int nZN;
  public InputClearablePreference.a nZO;
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void RX(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(22711);
    if (!bo.isNullOrNil(paramString))
    {
      int i = f.auQ(paramString);
      if (i <= this.nZH) {
        break label90;
      }
      bool1 = true;
      e(bool1, f.bO(this.nZH, ""), f.bP(this.nZH, paramString));
      if (this.nZO != null)
      {
        paramString = this.nZO;
        if (i > this.nZH) {
          break label95;
        }
      }
    }
    label90:
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.iO(bool1);
      AppMethodBeat.o(22711);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22712);
    if (this.nZM != null)
    {
      if (paramBoolean)
      {
        this.nZM.setText(String.format(this.hBF, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        this.nZM.setVisibility(0);
        AppMethodBeat.o(22712);
        return;
      }
      this.nZM.setVisibility(8);
    }
    AppMethodBeat.o(22712);
  }
  
  public final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(22713);
    if (this.nZM != null)
    {
      if (paramBoolean)
      {
        this.nZM.setText(this.nZG);
        this.nZM.setVisibility(0);
        AppMethodBeat.o(22713);
        return;
      }
      this.nZM.setVisibility(8);
    }
    AppMethodBeat.o(22713);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(22710);
    super.onBindView(paramView);
    this.nZN = a.ao(this.mContext, 2131427758);
    this.nZK = ((MMEditText)paramView.findViewById(2131820995));
    this.nZL = ((ImageView)paramView.findViewById(2131823370));
    this.nZM = ((TextView)paramView.findViewById(2131826243));
    if (this.nZK != null)
    {
      if (this.nZI <= 0) {
        break label273;
      }
      this.nZK.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nZI), new InputClearablePreference.b(this) });
    }
    for (;;)
    {
      this.nZK.addTextChangedListener(new InputClearablePreference.1(this));
      ab.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[] { this.mText });
      setText(this.mText);
      if (!bo.isNullOrNil(this.mText)) {
        this.nZK.setSelection(this.mText.length());
      }
      if (this.nZJ) {
        new ak().postDelayed(new InputClearablePreference.4(this), 0L);
      }
      this.nZK.setHint(this.nZF);
      this.nZL.setOnClickListener(new InputClearablePreference.2(this));
      if (this.nZM != null) {
        this.nZM.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(22705);
            if (InputClearablePreference.b(InputClearablePreference.this) != null) {
              InputClearablePreference.b(InputClearablePreference.this).clearFocus();
            }
            AppMethodBeat.o(22705);
            return false;
          }
        });
      }
      AppMethodBeat.o(22710);
      return;
      label273:
      this.nZK.setFilters(new InputFilter[] { new InputClearablePreference.b(this) });
    }
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(22709);
    this.mText = paramString;
    if ((this.nZK != null) && (!bo.isNullOrNil(paramString)))
    {
      paramString = j.b(this.mContext, this.mText, this.nZN);
      this.nZK.setText(paramString);
      RX(this.mText);
    }
    AppMethodBeat.o(22709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference
 * JD-Core Version:    0.7.0.1
 */