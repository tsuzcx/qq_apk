package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.cho;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  MMActivity bER;
  String dWH;
  TextView eYn;
  private ar fqH;
  b.a ltc;
  private DialPad ltd;
  TextView lte;
  EditText ltf;
  View ltg;
  private ImageButton lth;
  View lti;
  TextView ltj;
  TextView ltk;
  String ltl;
  String ltm;
  String ltn = "";
  String lto;
  LinkedList<cho> ltp;
  long ltq = 0L;
  boolean ltr = false;
  private Runnable lts = new b.1(this);
  private ai ltt = new ai("IPCallDialQueryPhoneNumber");
  boolean ltu = false;
  private TextWatcher ltv = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      paramAnonymousEditable = b.this.lte.getText().toString().replace("+", "");
      if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
      {
        b.this.lte.setText("+");
        b.this.ltm = "+";
      }
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (b.this.lti.getLayoutParams() != null)
      {
        paramAnonymousCharSequence = b.this.lte.getPaint();
        if ("+".equals(b.this.lte.getText().toString()))
        {
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.lte.getText().toString());
          b.this.ltg.setVisibility(8);
          b.this.ltj.setVisibility(8);
          paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.lti.getLayoutParams();
          paramAnonymousCharSequence.width = paramAnonymousInt1;
          b.this.lti.setLayoutParams(paramAnonymousCharSequence);
        }
      }
      else
      {
        paramAnonymousCharSequence = b.this.lte.getText().toString().replace("+", "");
        if (!a.Gb(paramAnonymousCharSequence)) {
          break label352;
        }
        b.this.ltj.setText(a.FY(paramAnonymousCharSequence));
        if ((b.this.ltp == null) || (b.this.ltp.size() <= 0)) {
          break label375;
        }
        String str = a.FZ(paramAnonymousCharSequence);
        Iterator localIterator = b.this.ltp.iterator();
        while (localIterator.hasNext())
        {
          cho localcho = (cho)localIterator.next();
          if ((localcho != null) && (localcho.ffq.equals(str)))
          {
            paramAnonymousInt1 = 1;
            label249:
            if (paramAnonymousInt1 == 0) {
              break label380;
            }
            b.this.ltk.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        if (b.this.ltc != null) {
          b.this.ltc.FI(paramAnonymousCharSequence);
        }
        return;
        paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.lte.getText() + "+");
        b.this.ltg.setVisibility(0);
        b.this.ltj.setVisibility(0);
        break;
        paramAnonymousInt1 = 0;
        break label249;
        label352:
        b.this.ltj.setText(b.this.bER.getString(R.l.ip_call_dial_country_unknown));
        label375:
        paramAnonymousInt1 = 0;
        break label249;
        label380:
        b.this.ltk.setVisibility(8);
      }
    }
  };
  String ltw = "";
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    this.bER = paramMMActivity;
    this.ltf = paramEditText;
    this.lte = paramTextView1;
    this.ltg = paramView1;
    this.ltd = paramDialPad;
    this.lth = paramImageButton;
    this.eYn = paramTextView2;
    this.lti = paramView2;
    this.ltj = paramTextView3;
    this.ltk = paramTextView4;
    this.fqH = new ar();
    this.ltm = c.bdr();
    paramMMActivity = ae.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bk.bl(paramMMActivity)) {}
    for (;;)
    {
      this.ltl = paramMMActivity;
      this.lte.addTextChangedListener(this.ltv);
      this.lte.setText("+" + this.ltm);
      this.ltd.setDialButtonClickListener(new b.3(this));
      this.ltg.setOnClickListener(new b.4(this));
      this.ltg.setOnLongClickListener(new b.5(this));
      this.lte.setOnClickListener(new b.6(this));
      this.lth.setOnClickListener(new b.7(this));
      this.ltf.setHorizontallyScrolling(true);
      this.ltf.setOnClickListener(new b.8(this));
      this.ltf.addTextChangedListener(new b.9(this));
      if (d.gF(16))
      {
        this.lte.setTypeface(Typeface.create("sans-serif-light", 0));
        this.ltf.setTypeface(Typeface.create("sans-serif-light", 0));
        this.eYn.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      return;
      paramMMActivity = a.FY(a.bdo());
    }
  }
  
  static String dB(String paramString1, String paramString2)
  {
    paramString1 = ar.formatNumber(paramString1, c.Gi(paramString2));
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final void FH(String paramString)
  {
    this.ltm = paramString;
    if (this.lte != null) {
      this.lte.setText("+" + paramString);
    }
  }
  
  public final void aa(LinkedList<cho> paramLinkedList)
  {
    this.ltp = paramLinkedList;
    paramLinkedList = this.lte.getText().toString().replace("+", "");
    if ((a.Gb(paramLinkedList)) && (this.ltp != null) && (this.ltp.size() > 0))
    {
      paramLinkedList = a.FZ(paramLinkedList);
      Iterator localIterator = this.ltp.iterator();
      cho localcho;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localcho = (cho)localIterator.next();
      } while ((localcho == null) || (!localcho.ffq.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ltk.setVisibility(0);
        return;
      }
      this.ltk.setVisibility(8);
      return;
    }
  }
  
  public final void bL(String paramString, int paramInt)
  {
    this.ltf.setText(paramString);
    if (!bk.bl(paramString))
    {
      if (paramInt == -1) {
        break label61;
      }
      if (this.ltu)
      {
        if ((paramInt <= 0) || (paramInt > this.ltf.getText().length())) {
          break label61;
        }
        this.ltf.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.ltn = paramString;
      return;
      label61:
      this.ltf.setSelection(this.ltf.getText().length());
    }
  }
  
  public final void bcQ()
  {
    this.ltt.crf().removeCallbacks(this.lts);
    this.ltt.k(this.lts, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */