package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference
  extends Preference
{
  public String gio;
  private String hnV;
  public TextView lCA;
  private int lCB;
  public InputClearablePreference.a lCC;
  public String lCt;
  public String lCu;
  public int lCv;
  private int lCw;
  public boolean lCx;
  public MMEditText lCy;
  private ImageView lCz;
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputClearablePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Gu(String paramString)
  {
    boolean bool = true;
    int i;
    if (!bk.bl(paramString))
    {
      int j = f.aek(paramString);
      if (j <= this.lCv) {
        break label128;
      }
      i = 1;
      int k = f.bi(this.lCv, "");
      int m = f.bj(this.lCv, paramString);
      if (this.lCA != null)
      {
        if (i == 0) {
          break label133;
        }
        this.lCA.setText(String.format(this.gio, new Object[] { Integer.valueOf(k), Integer.valueOf(m) }));
        this.lCA.setVisibility(0);
      }
      label99:
      if (this.lCC != null)
      {
        paramString = this.lCC;
        if (j > this.lCv) {
          break label145;
        }
      }
    }
    for (;;)
    {
      paramString.he(bool);
      return;
      label128:
      i = 0;
      break;
      label133:
      this.lCA.setVisibility(8);
      break label99;
      label145:
      bool = false;
    }
  }
  
  public final void hg(boolean paramBoolean)
  {
    if (this.lCA != null)
    {
      if (paramBoolean)
      {
        this.lCA.setText(this.lCu);
        this.lCA.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.lCA.setVisibility(8);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.lCB = a.aa(this.mContext, R.f.HintTextSize);
    this.lCy = ((MMEditText)paramView.findViewById(R.h.edittext));
    this.lCz = ((ImageView)paramView.findViewById(R.h.delete));
    this.lCA = ((TextView)paramView.findViewById(R.h.err_msg));
    if (this.lCy != null)
    {
      if (this.lCw <= 0) {
        break label265;
      }
      this.lCy.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.lCw), new InputClearablePreference.b(this) });
    }
    for (;;)
    {
      this.lCy.addTextChangedListener(new InputClearablePreference.1(this));
      y.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[] { this.hnV });
      setText(this.hnV);
      if (!bk.bl(this.hnV)) {
        this.lCy.setSelection(this.hnV.length());
      }
      if (this.lCx) {
        new ah().postDelayed(new InputClearablePreference.4(this), 0L);
      }
      this.lCy.setHint(this.lCt);
      this.lCz.setOnClickListener(new InputClearablePreference.2(this));
      if (this.lCA != null) {
        this.lCA.setOnTouchListener(new InputClearablePreference.3(this));
      }
      return;
      label265:
      this.lCy.setFilters(new InputFilter[] { new InputClearablePreference.b(this) });
    }
  }
  
  public final void setText(String paramString)
  {
    this.hnV = paramString;
    if ((this.lCy != null) && (!bk.bl(paramString)))
    {
      paramString = j.b(this.mContext, this.hnV, this.lCB);
      this.lCy.setText(paramString);
      Gu(this.hnV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference
 * JD-Core Version:    0.7.0.1
 */