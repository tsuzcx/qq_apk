package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  TextView gIk;
  String hoH;
  MMActivity iMV;
  private az iWe;
  a tLX;
  private DialPad tLY;
  TextView tLZ;
  EditText tMa;
  View tMb;
  private ImageButton tMc;
  View tMd;
  TextView tMe;
  TextView tMf;
  String tMg;
  String tMh;
  String tMi;
  String tMj;
  LinkedList<dur> tMk;
  long tMl;
  boolean tMm;
  private Runnable tMn;
  private ao tMo;
  boolean tMp;
  private TextWatcher tMq;
  String tMr;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.tMi = "";
    this.tMl = 0L;
    this.tMm = false;
    this.tMn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.tMl >= 500L)
        {
          b.this.tMj = a.aI(b.this.iMV, b.this.tMh + b.this.tMi);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.tMt != null) && (this.tMt.systemRowid != -1L))
              {
                b.this.gIk.setText(this.tMt.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.gIk.setText("");
              AppMethodBeat.o(25584);
            }
          });
          AppMethodBeat.o(25586);
          return;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25585);
            b.this.gIk.setText("");
            b.this.tMj = null;
            b.this.hoH = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.tMo = new ao("IPCallDialQueryPhoneNumber");
    this.tMp = false;
    this.tMq = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.tLZ.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.tLZ.setText("+");
          b.this.tMh = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.tMd.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.tLZ.getPaint();
          if ("+".equals(b.this.tLZ.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.tLZ.getText().toString());
            b.this.tMb.setVisibility(8);
            b.this.tMe.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.tMd.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.tMd.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.tLZ.getText().toString().replace("+", "");
          if (!a.ajp(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.tMe.setText(a.ajm(paramAnonymousCharSequence));
          if ((b.this.tMk == null) || (b.this.tMk.size() <= 0)) {
            break label386;
          }
          String str = a.ajn(paramAnonymousCharSequence);
          Iterator localIterator = b.this.tMk.iterator();
          while (localIterator.hasNext())
          {
            dur localdur = (dur)localIterator.next();
            if ((localdur != null) && (localdur.iKc.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label391;
              }
              b.this.tMf.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.tLX != null) {
            b.this.tLX.aiW(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.tLZ.getText() + "+");
          b.this.tMb.setVisibility(0);
          b.this.tMe.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.tMe.setText(b.this.iMV.getString(2131760439));
          label386:
          paramAnonymousInt1 = 0;
          break label255;
          label391:
          b.this.tMf.setVisibility(8);
        }
      }
    };
    this.tMr = "";
    this.iMV = paramMMActivity;
    this.tMa = paramEditText;
    this.tLZ = paramTextView1;
    this.tMb = paramView1;
    this.tLY = paramDialPad;
    this.tMc = paramImageButton;
    this.gIk = paramTextView2;
    this.tMd = paramView2;
    this.tMe = paramTextView3;
    this.tMf = paramTextView4;
    this.iWe = new az();
    this.tMh = com.tencent.mm.plugin.ipcall.a.c.cVU();
    paramMMActivity = ai.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bs.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.tMg = paramMMActivity;
      this.tLZ.addTextChangedListener(this.tMq);
      this.tLZ.setText("+" + this.tMh);
      this.tLY.setDialButtonClickListener(new DialPad.a()
      {
        public final void aiT(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.tMi = b.this.tMa.getText().toString();
          if (b.this.tMm)
          {
            b.this.tMh += paramAnonymousString;
            b.this.tLZ.setText(b.this.tMh);
            if ((a.ajp(b.this.tMh.replace("+", ""))) || (b.this.tMh.replace("+", "").length() >= 4))
            {
              h.wUl.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.tMm = false;
              b.this.tMg = a.ajm(b.this.tMh.replace("+", ""));
              b.this.tMi = b.hl(b.this.tMh.replace("+", ""), b.this.tMi);
              b.this.dG(b.this.tMi, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.tLZ.getText().toString().replace("+", "");
            if (!b.this.tMp) {
              break label726;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.tMi);
            localStringBuffer.insert(b.this.tMa.getSelectionStart(), paramAnonymousString);
            b.this.tMi = localStringBuffer.toString();
            if (b.this.tMi.equals("00"))
            {
              b.this.tLZ.setText("+");
              b.this.tMm = true;
              b.this.tMh = "+";
              b.this.tMi = "";
            }
            if (a.ajp(b.this.tMh.replace("+", "") + b.this.tMi))
            {
              b.this.tLZ.setText("+" + b.this.tMh.replace("+", "") + b.this.tMi);
              b.this.tMg = a.ajm(b.this.tMh.replace("+", ""));
              b.this.tMm = false;
              b.this.tMh = (b.this.tMh.replace("+", "") + b.this.tMi);
              b.this.tMi = "";
            }
            paramAnonymousString = b.this.tMi;
            b.this.tMi = b.hl(str, b.this.tMi);
            if (!b.this.tMp) {
              break label868;
            }
            if (paramAnonymousString.length() >= b.this.tMi.length()) {
              break label760;
            }
            b.this.dG(b.this.tMi, b.this.tMa.getSelectionEnd() + 2);
          }
          label726:
          label868:
          for (;;)
          {
            b.this.tMl = System.currentTimeMillis();
            if ((b.this.tMi.length() > a.tSV) && (!bs.isNullOrNil(b.this.tMh + b.this.tMi))) {
              b.this.cVg();
            }
            AppMethodBeat.o(25589);
            return;
            b.this.tMi += paramAnonymousString;
            break;
            label760:
            if (paramAnonymousString.length() == b.this.tMi.length())
            {
              b.this.dG(b.this.tMi, b.this.tMa.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.tMi.length())
            {
              b.this.dG(b.this.tMi, b.this.tMa.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.tMi.length()));
              continue;
              b.this.dG(b.this.tMi, -1);
            }
          }
        }
        
        public final void aiU(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.tLZ.setText("+");
            b.this.tMm = true;
            b.this.tMh = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.tMb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          paramAnonymousView = b.this.tMa.getText().toString();
          if (bs.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.tLZ.getText().toString();
            if (!bs.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((!bs.isNullOrNil(paramAnonymousView)) && (!paramAnonymousView.equals("+")))
              {
                b.this.tLZ.setText(paramAnonymousView);
                b.this.tMh = paramAnonymousView;
                AppMethodBeat.o(25591);
                return;
              }
              b.this.tLZ.setText("+");
              b.this.tMh = "+";
              b.this.tMm = true;
            }
            AppMethodBeat.o(25591);
            return;
          }
          int i = b.this.tMa.getSelectionStart();
          String str;
          if ((b.this.tMp) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.tMa.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            if (bs.isNullOrNil(paramAnonymousView)) {
              break label368;
            }
            str = b.this.tLZ.getText().toString().replace("+", "");
            if (!b.this.tMp) {
              break label337;
            }
            b.this.tMi = b.hl(str, paramAnonymousView);
            int j = b.this.tMi.length();
            int k = paramAnonymousView.length();
            b.this.dG(b.this.tMi, j - k + (i - 1));
            label287:
            b.this.cVg();
          }
          for (;;)
          {
            b.this.tMj = "";
            b.this.gIk.setText("");
            AppMethodBeat.o(25591);
            return;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break;
            label337:
            b.this.tMi = b.hl(str, paramAnonymousView);
            b.this.dG(b.this.tMi, -1);
            break label287;
            label368:
            b.this.tMi = "";
            b.this.dG("", -1);
          }
        }
      });
      this.tMb.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          if (b.this.tMm)
          {
            b.this.tMh = "+";
            b.this.tLZ.setText(b.this.tMh);
          }
          for (;;)
          {
            AppMethodBeat.o(25592);
            return true;
            b.this.gIk.setText("");
            b.this.tMi = "";
            b.this.dG("", -1);
          }
        }
      });
      this.tLZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25593);
          h.wUl.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          paramAnonymousView = b.this.tLZ.getText().toString().replace("+", "");
          Intent localIntent = new Intent(b.this.iMV, IPCallCountryCodeSelectUI.class);
          localIntent.putExtra("couttry_code", paramAnonymousView);
          localIntent.putExtra("CountryCodeUI_isShowCountryCode", true);
          b.this.iMV.startActivityForResult(localIntent, 100);
          b.this.iMV.overridePendingTransition(2130772108, -1);
          AppMethodBeat.o(25593);
        }
      });
      this.tMc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          b localb = b.this;
          localb.tMh = localb.tLZ.getText().toString();
          localb.tMi = localb.tMa.getText().toString();
          if ((!bs.isNullOrNil(localb.tMh)) && (!bs.isNullOrNil(localb.tMi)))
          {
            localb.tMh = localb.tLZ.getText().toString().replace("+", "");
            localb.tMj = a.aI(localb.iMV, localb.tMh + localb.tMi);
            localb.hoH = a.aK(localb.iMV, localb.tMj);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.ajw(localb.tMi);
            Object localObject = ai.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.tLZ.getText().toString();
            localObject = localb.tMg;
            if (!bs.isNullOrNil(str))
            {
              paramAnonymousView = (View)localObject;
              if (bs.isNullOrNil((String)localObject)) {
                paramAnonymousView = "";
              }
              localObject = ai.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramAnonymousView);
              ((SharedPreferences.Editor)localObject).apply();
            }
            if (localb.tLX != null)
            {
              localb.tLX.q(localb.tMh, com.tencent.mm.plugin.ipcall.a.c.ajw(localb.tMi), localb.tMj, localb.hoH);
              AppMethodBeat.o(25594);
            }
          }
          else
          {
            paramAnonymousView = ai.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bs.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.ajw(paramAnonymousView);
              localb.tMi = b.hl(localb.tLZ.getText().toString().replace("+", ""), paramAnonymousView);
              localb.dG(localb.tMi, -1);
              localb.cVg();
            }
          }
          AppMethodBeat.o(25594);
        }
      });
      this.tMa.setHorizontallyScrolling(true);
      this.tMa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25595);
          b.this.tMa.setCursorVisible(true);
          b.this.iMV.hideVKB();
          b.this.tMp = true;
          AppMethodBeat.o(25595);
        }
      });
      this.tMa.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25596);
          String str = bs.ajw(paramAnonymousCharSequence.toString());
          if (str.contains(" "))
          {
            paramAnonymousCharSequence = str.replace(" ", "");
            b.this.tMa.setText(bs.ak(paramAnonymousCharSequence));
            if (!a.ajq(paramAnonymousCharSequence)) {
              break label209;
            }
            str = a.ajo(paramAnonymousCharSequence);
            if (!bs.isNullOrNil(str))
            {
              b.this.tLZ.setText("+".concat(String.valueOf(str)));
              b.this.tMa.setText(a.ajt(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.tLX != null) {
              b.this.tLX.aiX(b.this.tMa.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.tMr.equals(str))
            {
              paramAnonymousCharSequence = str;
              if (paramAnonymousInt3 <= 0) {
                break;
              }
            }
            paramAnonymousCharSequence = str;
            if (!bs.isNullOrNil(str)) {
              break;
            }
            b.this.tMr = str;
            b.this.tMa.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.tMr))
            {
              b.this.tMr = paramAnonymousCharSequence;
              b.this.tMa.setText(paramAnonymousCharSequence);
              if (bs.isNullOrNil(b.this.tLZ.getText().toString())) {
                b.this.tLZ.setText("+" + a.cVQ());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.kZ(16))
      {
        this.tLZ.setTypeface(Typeface.create("sans-serif-light", 0));
        this.tMa.setTypeface(Typeface.create("sans-serif-light", 0));
        this.gIk.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = a.ajm(a.cVQ());
    }
  }
  
  static String hl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = az.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.ajw(paramString2));
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
  
  public final void aE(LinkedList<dur> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.tMk = paramLinkedList;
    paramLinkedList = this.tLZ.getText().toString().replace("+", "");
    if ((a.ajp(paramLinkedList)) && (this.tMk != null) && (this.tMk.size() > 0))
    {
      paramLinkedList = a.ajn(paramLinkedList);
      Iterator localIterator = this.tMk.iterator();
      dur localdur;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdur = (dur)localIterator.next();
      } while ((localdur == null) || (!localdur.iKc.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.tMf.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.tMf.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void aiV(String paramString)
  {
    AppMethodBeat.i(25598);
    this.tMh = paramString;
    if (this.tLZ != null) {
      this.tLZ.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void cVg()
  {
    AppMethodBeat.i(25602);
    this.tMo.removeCallbacks(this.tMn);
    this.tMo.postDelayed(this.tMn, 500L);
    AppMethodBeat.o(25602);
  }
  
  public final void dG(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.tMa.setText(paramString);
    if (!bs.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.tMp)
      {
        if ((paramInt <= 0) || (paramInt > this.tMa.getText().length())) {
          break label73;
        }
        this.tMa.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.tMi = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.tMa.setSelection(this.tMa.getText().length());
    }
  }
  
  public static abstract interface a
  {
    public abstract void aiW(String paramString);
    
    public abstract void aiX(String paramString);
    
    public abstract void q(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */