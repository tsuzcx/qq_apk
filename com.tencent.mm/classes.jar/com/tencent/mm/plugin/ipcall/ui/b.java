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
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  String gOh;
  TextView icz;
  MMActivity imP;
  private ba iwa;
  String sEA;
  String sEB;
  String sEC;
  LinkedList<dpa> sED;
  long sEE;
  boolean sEF;
  private Runnable sEG;
  private ap sEH;
  boolean sEI;
  private TextWatcher sEJ;
  String sEK;
  a sEq;
  private DialPad sEr;
  TextView sEs;
  EditText sEt;
  View sEu;
  private ImageButton sEv;
  View sEw;
  TextView sEx;
  TextView sEy;
  String sEz;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.sEB = "";
    this.sEE = 0L;
    this.sEF = false;
    this.sEG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.sEE >= 500L)
        {
          b.this.sEC = a.aH(b.this.imP, b.this.sEA + b.this.sEB);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.sEM != null) && (this.sEM.systemRowid != -1L))
              {
                b.this.icz.setText(this.sEM.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.icz.setText("");
              AppMethodBeat.o(25584);
            }
          });
          AppMethodBeat.o(25586);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25585);
            b.this.icz.setText("");
            b.this.sEC = null;
            b.this.gOh = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.sEH = new ap("IPCallDialQueryPhoneNumber");
    this.sEI = false;
    this.sEJ = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.sEs.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.sEs.setText("+");
          b.this.sEA = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.sEw.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.sEs.getPaint();
          if ("+".equals(b.this.sEs.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.sEs.getText().toString());
            b.this.sEu.setVisibility(8);
            b.this.sEx.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.sEw.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.sEw.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.sEs.getText().toString().replace("+", "");
          if (!a.aex(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.sEx.setText(a.aeu(paramAnonymousCharSequence));
          if ((b.this.sED == null) || (b.this.sED.size() <= 0)) {
            break label386;
          }
          String str = a.aev(paramAnonymousCharSequence);
          Iterator localIterator = b.this.sED.iterator();
          while (localIterator.hasNext())
          {
            dpa localdpa = (dpa)localIterator.next();
            if ((localdpa != null) && (localdpa.ijV.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label391;
              }
              b.this.sEy.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.sEq != null) {
            b.this.sEq.aee(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.sEs.getText() + "+");
          b.this.sEu.setVisibility(0);
          b.this.sEx.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.sEx.setText(b.this.imP.getString(2131760439));
          label386:
          paramAnonymousInt1 = 0;
          break label255;
          label391:
          b.this.sEy.setVisibility(8);
        }
      }
    };
    this.sEK = "";
    this.imP = paramMMActivity;
    this.sEt = paramEditText;
    this.sEs = paramTextView1;
    this.sEu = paramView1;
    this.sEr = paramDialPad;
    this.sEv = paramImageButton;
    this.icz = paramTextView2;
    this.sEw = paramView2;
    this.sEx = paramTextView3;
    this.sEy = paramTextView4;
    this.iwa = new ba();
    this.sEA = com.tencent.mm.plugin.ipcall.a.c.cIJ();
    paramMMActivity = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bt.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.sEz = paramMMActivity;
      this.sEs.addTextChangedListener(this.sEJ);
      this.sEs.setText("+" + this.sEA);
      this.sEr.setDialButtonClickListener(new DialPad.a()
      {
        public final void aeb(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.sEB = b.this.sEt.getText().toString();
          if (b.this.sEF)
          {
            b.this.sEA += paramAnonymousString;
            b.this.sEs.setText(b.this.sEA);
            if ((a.aex(b.this.sEA.replace("+", ""))) || (b.this.sEA.replace("+", "").length() >= 4))
            {
              h.vKh.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.sEF = false;
              b.this.sEz = a.aeu(b.this.sEA.replace("+", ""));
              b.this.sEB = b.gU(b.this.sEA.replace("+", ""), b.this.sEB);
              b.this.dA(b.this.sEB, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.sEs.getText().toString().replace("+", "");
            if (!b.this.sEI) {
              break label726;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.sEB);
            localStringBuffer.insert(b.this.sEt.getSelectionStart(), paramAnonymousString);
            b.this.sEB = localStringBuffer.toString();
            if (b.this.sEB.equals("00"))
            {
              b.this.sEs.setText("+");
              b.this.sEF = true;
              b.this.sEA = "+";
              b.this.sEB = "";
            }
            if (a.aex(b.this.sEA.replace("+", "") + b.this.sEB))
            {
              b.this.sEs.setText("+" + b.this.sEA.replace("+", "") + b.this.sEB);
              b.this.sEz = a.aeu(b.this.sEA.replace("+", ""));
              b.this.sEF = false;
              b.this.sEA = (b.this.sEA.replace("+", "") + b.this.sEB);
              b.this.sEB = "";
            }
            paramAnonymousString = b.this.sEB;
            b.this.sEB = b.gU(str, b.this.sEB);
            if (!b.this.sEI) {
              break label868;
            }
            if (paramAnonymousString.length() >= b.this.sEB.length()) {
              break label760;
            }
            b.this.dA(b.this.sEB, b.this.sEt.getSelectionEnd() + 2);
          }
          label726:
          label868:
          for (;;)
          {
            b.this.sEE = System.currentTimeMillis();
            if ((b.this.sEB.length() > a.sLq) && (!bt.isNullOrNil(b.this.sEA + b.this.sEB))) {
              b.this.cHV();
            }
            AppMethodBeat.o(25589);
            return;
            b.this.sEB += paramAnonymousString;
            break;
            label760:
            if (paramAnonymousString.length() == b.this.sEB.length())
            {
              b.this.dA(b.this.sEB, b.this.sEt.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.sEB.length())
            {
              b.this.dA(b.this.sEB, b.this.sEt.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.sEB.length()));
              continue;
              b.this.dA(b.this.sEB, -1);
            }
          }
        }
        
        public final void aec(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.sEs.setText("+");
            b.this.sEF = true;
            b.this.sEA = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.sEu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          paramAnonymousView = b.this.sEt.getText().toString();
          if (bt.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.sEs.getText().toString();
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((!bt.isNullOrNil(paramAnonymousView)) && (!paramAnonymousView.equals("+")))
              {
                b.this.sEs.setText(paramAnonymousView);
                b.this.sEA = paramAnonymousView;
                AppMethodBeat.o(25591);
                return;
              }
              b.this.sEs.setText("+");
              b.this.sEA = "+";
              b.this.sEF = true;
            }
            AppMethodBeat.o(25591);
            return;
          }
          int i = b.this.sEt.getSelectionStart();
          String str;
          if ((b.this.sEI) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.sEt.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            if (bt.isNullOrNil(paramAnonymousView)) {
              break label368;
            }
            str = b.this.sEs.getText().toString().replace("+", "");
            if (!b.this.sEI) {
              break label337;
            }
            b.this.sEB = b.gU(str, paramAnonymousView);
            int j = b.this.sEB.length();
            int k = paramAnonymousView.length();
            b.this.dA(b.this.sEB, j - k + (i - 1));
            label287:
            b.this.cHV();
          }
          for (;;)
          {
            b.this.sEC = "";
            b.this.icz.setText("");
            AppMethodBeat.o(25591);
            return;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break;
            label337:
            b.this.sEB = b.gU(str, paramAnonymousView);
            b.this.dA(b.this.sEB, -1);
            break label287;
            label368:
            b.this.sEB = "";
            b.this.dA("", -1);
          }
        }
      });
      this.sEu.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          if (b.this.sEF)
          {
            b.this.sEA = "+";
            b.this.sEs.setText(b.this.sEA);
          }
          for (;;)
          {
            AppMethodBeat.o(25592);
            return true;
            b.this.icz.setText("");
            b.this.sEB = "";
            b.this.dA("", -1);
          }
        }
      });
      this.sEs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25593);
          h.vKh.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          paramAnonymousView = b.this.sEs.getText().toString().replace("+", "");
          Intent localIntent = new Intent(b.this.imP, IPCallCountryCodeSelectUI.class);
          localIntent.putExtra("couttry_code", paramAnonymousView);
          localIntent.putExtra("CountryCodeUI_isShowCountryCode", true);
          b.this.imP.startActivityForResult(localIntent, 100);
          b.this.imP.overridePendingTransition(2130772108, -1);
          AppMethodBeat.o(25593);
        }
      });
      this.sEv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          b localb = b.this;
          localb.sEA = localb.sEs.getText().toString();
          localb.sEB = localb.sEt.getText().toString();
          if ((!bt.isNullOrNil(localb.sEA)) && (!bt.isNullOrNil(localb.sEB)))
          {
            localb.sEA = localb.sEs.getText().toString().replace("+", "");
            localb.sEC = a.aH(localb.imP, localb.sEA + localb.sEB);
            localb.gOh = a.aJ(localb.imP, localb.sEC);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.aeE(localb.sEB);
            Object localObject = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.sEs.getText().toString();
            localObject = localb.sEz;
            if (!bt.isNullOrNil(str))
            {
              paramAnonymousView = (View)localObject;
              if (bt.isNullOrNil((String)localObject)) {
                paramAnonymousView = "";
              }
              localObject = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramAnonymousView);
              ((SharedPreferences.Editor)localObject).apply();
            }
            if (localb.sEq != null)
            {
              localb.sEq.o(localb.sEA, com.tencent.mm.plugin.ipcall.a.c.aeE(localb.sEB), localb.sEC, localb.gOh);
              AppMethodBeat.o(25594);
            }
          }
          else
          {
            paramAnonymousView = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.aeE(paramAnonymousView);
              localb.sEB = b.gU(localb.sEs.getText().toString().replace("+", ""), paramAnonymousView);
              localb.dA(localb.sEB, -1);
              localb.cHV();
            }
          }
          AppMethodBeat.o(25594);
        }
      });
      this.sEt.setHorizontallyScrolling(true);
      this.sEt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25595);
          b.this.sEt.setCursorVisible(true);
          b.this.imP.hideVKB();
          b.this.sEI = true;
          AppMethodBeat.o(25595);
        }
      });
      this.sEt.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25596);
          String str = bt.aeE(paramAnonymousCharSequence.toString());
          if (str.contains(" "))
          {
            paramAnonymousCharSequence = str.replace(" ", "");
            b.this.sEt.setText(bt.aj(paramAnonymousCharSequence));
            if (!a.aey(paramAnonymousCharSequence)) {
              break label209;
            }
            str = a.aew(paramAnonymousCharSequence);
            if (!bt.isNullOrNil(str))
            {
              b.this.sEs.setText("+".concat(String.valueOf(str)));
              b.this.sEt.setText(a.aeB(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.sEq != null) {
              b.this.sEq.aef(b.this.sEt.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.sEK.equals(str))
            {
              paramAnonymousCharSequence = str;
              if (paramAnonymousInt3 <= 0) {
                break;
              }
            }
            paramAnonymousCharSequence = str;
            if (!bt.isNullOrNil(str)) {
              break;
            }
            b.this.sEK = str;
            b.this.sEt.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.sEK))
            {
              b.this.sEK = paramAnonymousCharSequence;
              b.this.sEt.setText(paramAnonymousCharSequence);
              if (bt.isNullOrNil(b.this.sEs.getText().toString())) {
                b.this.sEs.setText("+" + a.cIF());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.lf(16))
      {
        this.sEs.setTypeface(Typeface.create("sans-serif-light", 0));
        this.sEt.setTypeface(Typeface.create("sans-serif-light", 0));
        this.icz.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = a.aeu(a.cIF());
    }
  }
  
  static String gU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = ba.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.aeE(paramString2));
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
  
  public final void aed(String paramString)
  {
    AppMethodBeat.i(25598);
    this.sEA = paramString;
    if (this.sEs != null) {
      this.sEs.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void ax(LinkedList<dpa> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.sED = paramLinkedList;
    paramLinkedList = this.sEs.getText().toString().replace("+", "");
    if ((a.aex(paramLinkedList)) && (this.sED != null) && (this.sED.size() > 0))
    {
      paramLinkedList = a.aev(paramLinkedList);
      Iterator localIterator = this.sED.iterator();
      dpa localdpa;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdpa = (dpa)localIterator.next();
      } while ((localdpa == null) || (!localdpa.ijV.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.sEy.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.sEy.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void cHV()
  {
    AppMethodBeat.i(25602);
    this.sEH.removeCallbacks(this.sEG);
    this.sEH.postDelayed(this.sEG, 500L);
    AppMethodBeat.o(25602);
  }
  
  public final void dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.sEt.setText(paramString);
    if (!bt.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.sEI)
      {
        if ((paramInt <= 0) || (paramInt > this.sEt.getText().length())) {
          break label73;
        }
        this.sEt.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.sEB = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.sEt.setSelection(this.sEt.getText().length());
    }
  }
  
  public static abstract interface a
  {
    public abstract void aee(String paramString);
    
    public abstract void aef(String paramString);
    
    public abstract void o(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */