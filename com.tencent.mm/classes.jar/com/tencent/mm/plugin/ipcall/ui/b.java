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
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  MMActivity fNT;
  String hJR;
  TextView heI;
  private bb jsg;
  View vaA;
  private ImageButton vaB;
  View vaC;
  TextView vaD;
  TextView vaE;
  String vaF;
  String vaG;
  String vaH;
  String vaI;
  LinkedList<ecc> vaJ;
  long vaK;
  boolean vaL;
  private Runnable vaM;
  private aq vaN;
  boolean vaO;
  private TextWatcher vaP;
  String vaQ;
  a vaw;
  private DialPad vax;
  TextView vay;
  EditText vaz;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.vaH = "";
    this.vaK = 0L;
    this.vaL = false;
    this.vaM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.vaK >= 500L)
        {
          b.this.vaI = com.tencent.mm.plugin.ipcall.a.a.aN(b.this.fNT, b.this.vaG + b.this.vaH);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.vaS != null) && (this.vaS.systemRowid != -1L))
              {
                b.this.heI.setText(this.vaS.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.heI.setText("");
              AppMethodBeat.o(25584);
            }
          });
          AppMethodBeat.o(25586);
          return;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25585);
            b.this.heI.setText("");
            b.this.vaI = null;
            b.this.hJR = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.vaN = new aq("IPCallDialQueryPhoneNumber");
    this.vaO = false;
    this.vaP = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.vay.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.vay.setText("+");
          b.this.vaG = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.vaC.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.vay.getPaint();
          if ("+".equals(b.this.vay.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.vay.getText().toString());
            b.this.vaA.setVisibility(8);
            b.this.vaD.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.vaC.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.vaC.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.vay.getText().toString().replace("+", "");
          if (!com.tencent.mm.plugin.ipcall.a.a.ape(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.vaD.setText(com.tencent.mm.plugin.ipcall.a.a.apb(paramAnonymousCharSequence));
          if ((b.this.vaJ == null) || (b.this.vaJ.size() <= 0)) {
            break label386;
          }
          String str = com.tencent.mm.plugin.ipcall.a.a.apc(paramAnonymousCharSequence);
          Iterator localIterator = b.this.vaJ.iterator();
          while (localIterator.hasNext())
          {
            ecc localecc = (ecc)localIterator.next();
            if ((localecc != null) && (localecc.jge.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label391;
              }
              b.this.vaE.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.vaw != null) {
            b.this.vaw.aoL(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.vay.getText() + "+");
          b.this.vaA.setVisibility(0);
          b.this.vaD.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.vaD.setText(b.this.fNT.getString(2131760439));
          label386:
          paramAnonymousInt1 = 0;
          break label255;
          label391:
          b.this.vaE.setVisibility(8);
        }
      }
    };
    this.vaQ = "";
    this.fNT = paramMMActivity;
    this.vaz = paramEditText;
    this.vay = paramTextView1;
    this.vaA = paramView1;
    this.vax = paramDialPad;
    this.vaB = paramImageButton;
    this.heI = paramTextView2;
    this.vaC = paramView2;
    this.vaD = paramTextView3;
    this.vaE = paramTextView4;
    this.jsg = new bb();
    this.vaG = com.tencent.mm.plugin.ipcall.a.c.dhX();
    paramMMActivity = ak.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bu.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.vaF = paramMMActivity;
      this.vay.addTextChangedListener(this.vaP);
      this.vay.setText("+" + this.vaG);
      this.vax.setDialButtonClickListener(new DialPad.a()
      {
        public final void aoI(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.vaH = b.this.vaz.getText().toString();
          if (b.this.vaL)
          {
            b.this.vaG += paramAnonymousString;
            b.this.vay.setText(b.this.vaG);
            if ((com.tencent.mm.plugin.ipcall.a.a.ape(b.this.vaG.replace("+", ""))) || (b.this.vaG.replace("+", "").length() >= 4))
            {
              g.yxI.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.vaL = false;
              b.this.vaF = com.tencent.mm.plugin.ipcall.a.a.apb(b.this.vaG.replace("+", ""));
              b.this.vaH = b.hE(b.this.vaG.replace("+", ""), b.this.vaH);
              b.this.ed(b.this.vaH, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.vay.getText().toString().replace("+", "");
            if (!b.this.vaO) {
              break label726;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.vaH);
            localStringBuffer.insert(b.this.vaz.getSelectionStart(), paramAnonymousString);
            b.this.vaH = localStringBuffer.toString();
            if (b.this.vaH.equals("00"))
            {
              b.this.vay.setText("+");
              b.this.vaL = true;
              b.this.vaG = "+";
              b.this.vaH = "";
            }
            if (com.tencent.mm.plugin.ipcall.a.a.ape(b.this.vaG.replace("+", "") + b.this.vaH))
            {
              b.this.vay.setText("+" + b.this.vaG.replace("+", "") + b.this.vaH);
              b.this.vaF = com.tencent.mm.plugin.ipcall.a.a.apb(b.this.vaG.replace("+", ""));
              b.this.vaL = false;
              b.this.vaG = (b.this.vaG.replace("+", "") + b.this.vaH);
              b.this.vaH = "";
            }
            paramAnonymousString = b.this.vaH;
            b.this.vaH = b.hE(str, b.this.vaH);
            if (!b.this.vaO) {
              break label868;
            }
            if (paramAnonymousString.length() >= b.this.vaH.length()) {
              break label760;
            }
            b.this.ed(b.this.vaH, b.this.vaz.getSelectionEnd() + 2);
          }
          label726:
          label868:
          for (;;)
          {
            b.this.vaK = System.currentTimeMillis();
            if ((b.this.vaH.length() > com.tencent.mm.plugin.ipcall.a.a.vhv) && (!bu.isNullOrNil(b.this.vaG + b.this.vaH))) {
              b.this.dhj();
            }
            AppMethodBeat.o(25589);
            return;
            b.this.vaH += paramAnonymousString;
            break;
            label760:
            if (paramAnonymousString.length() == b.this.vaH.length())
            {
              b.this.ed(b.this.vaH, b.this.vaz.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.vaH.length())
            {
              b.this.ed(b.this.vaH, b.this.vaz.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.vaH.length()));
              continue;
              b.this.ed(b.this.vaH, -1);
            }
          }
        }
        
        public final void aoJ(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.vay.setText("+");
            b.this.vaL = true;
            b.this.vaG = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.vaA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = b.this.vaz.getText().toString();
          if (bu.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.vay.getText().toString();
            if (!bu.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((bu.isNullOrNil(paramAnonymousView)) || (paramAnonymousView.equals("+"))) {
                break label148;
              }
              b.this.vay.setText(paramAnonymousView);
              b.this.vaG = paramAnonymousView;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25591);
              return;
              label148:
              b.this.vay.setText("+");
              b.this.vaG = "+";
              b.this.vaL = true;
            }
          }
          int i = b.this.vaz.getSelectionStart();
          if ((b.this.vaO) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.vaz.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            label234:
            if (bu.isNullOrNil(paramAnonymousView)) {
              break label404;
            }
            localObject = b.this.vay.getText().toString().replace("+", "");
            if (!b.this.vaO) {
              break label373;
            }
            b.this.vaH = b.hE((String)localObject, paramAnonymousView);
            int j = b.this.vaH.length();
            int k = paramAnonymousView.length();
            b.this.ed(b.this.vaH, j - k + (i - 1));
            label327:
            b.this.dhj();
          }
          for (;;)
          {
            b.this.vaI = "";
            b.this.heI.setText("");
            break;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break label234;
            label373:
            b.this.vaH = b.hE((String)localObject, paramAnonymousView);
            b.this.ed(b.this.vaH, -1);
            break label327;
            label404:
            b.this.vaH = "";
            b.this.ed("", -1);
          }
        }
      });
      this.vaA.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          if (b.this.vaL)
          {
            b.this.vaG = "+";
            b.this.vay.setText(b.this.vaG);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25592);
            return true;
            b.this.heI.setText("");
            b.this.vaH = "";
            b.this.ed("", -1);
          }
        }
      });
      this.vay.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25593);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          g.yxI.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          paramAnonymousView = b.this.vay.getText().toString().replace("+", "");
          localObject = new Intent(b.this.fNT, IPCallCountryCodeSelectUI.class);
          ((Intent)localObject).putExtra("couttry_code", paramAnonymousView);
          ((Intent)localObject).putExtra("CountryCodeUI_isShowCountryCode", true);
          b.this.fNT.startActivityForResult((Intent)localObject, 100);
          b.this.fNT.overridePendingTransition(2130772108, -1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25593);
        }
      });
      this.vaB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          b localb = b.this;
          localb.vaG = localb.vay.getText().toString();
          localb.vaH = localb.vaz.getText().toString();
          if ((!bu.isNullOrNil(localb.vaG)) && (!bu.isNullOrNil(localb.vaH)))
          {
            localb.vaG = localb.vay.getText().toString().replace("+", "");
            localb.vaI = com.tencent.mm.plugin.ipcall.a.a.aN(localb.fNT, localb.vaG + localb.vaH);
            localb.hJR = com.tencent.mm.plugin.ipcall.a.a.aP(localb.fNT, localb.vaI);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.apl(localb.vaH);
            localObject = ak.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.vay.getText().toString();
            localObject = localb.vaF;
            if (!bu.isNullOrNil(str))
            {
              paramAnonymousView = (View)localObject;
              if (bu.isNullOrNil((String)localObject)) {
                paramAnonymousView = "";
              }
              localObject = ak.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramAnonymousView);
              ((SharedPreferences.Editor)localObject).apply();
            }
            if (localb.vaw != null) {
              localb.vaw.q(localb.vaG, com.tencent.mm.plugin.ipcall.a.c.apl(localb.vaH), localb.vaI, localb.hJR);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25594);
            return;
            paramAnonymousView = ak.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bu.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.apl(paramAnonymousView);
              localb.vaH = b.hE(localb.vay.getText().toString().replace("+", ""), paramAnonymousView);
              localb.ed(localb.vaH, -1);
              localb.dhj();
            }
          }
        }
      });
      this.vaz.setHorizontallyScrolling(true);
      this.vaz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25595);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          b.this.vaz.setCursorVisible(true);
          b.this.fNT.hideVKB();
          b.this.vaO = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25595);
        }
      });
      this.vaz.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25596);
          String str = bu.apl(paramAnonymousCharSequence.toString());
          if (str.contains(" "))
          {
            paramAnonymousCharSequence = str.replace(" ", "");
            b.this.vaz.setText(bu.ai(paramAnonymousCharSequence));
            if (!com.tencent.mm.plugin.ipcall.a.a.apf(paramAnonymousCharSequence)) {
              break label209;
            }
            str = com.tencent.mm.plugin.ipcall.a.a.apd(paramAnonymousCharSequence);
            if (!bu.isNullOrNil(str))
            {
              b.this.vay.setText("+".concat(String.valueOf(str)));
              b.this.vaz.setText(com.tencent.mm.plugin.ipcall.a.a.api(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.vaw != null) {
              b.this.vaw.aoM(b.this.vaz.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.vaQ.equals(str))
            {
              paramAnonymousCharSequence = str;
              if (paramAnonymousInt3 <= 0) {
                break;
              }
            }
            paramAnonymousCharSequence = str;
            if (!bu.isNullOrNil(str)) {
              break;
            }
            b.this.vaQ = str;
            b.this.vaz.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.vaQ))
            {
              b.this.vaQ = paramAnonymousCharSequence;
              b.this.vaz.setText(paramAnonymousCharSequence);
              if (bu.isNullOrNil(b.this.vay.getText().toString())) {
                b.this.vay.setText("+" + com.tencent.mm.plugin.ipcall.a.a.dhT());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.lA(16))
      {
        this.vay.setTypeface(Typeface.create("sans-serif-light", 0));
        this.vaz.setTypeface(Typeface.create("sans-serif-light", 0));
        this.heI.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = com.tencent.mm.plugin.ipcall.a.a.apb(com.tencent.mm.plugin.ipcall.a.a.dhT());
    }
  }
  
  static String hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = bb.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.apl(paramString2));
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
  
  public final void aG(LinkedList<ecc> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.vaJ = paramLinkedList;
    paramLinkedList = this.vay.getText().toString().replace("+", "");
    if ((com.tencent.mm.plugin.ipcall.a.a.ape(paramLinkedList)) && (this.vaJ != null) && (this.vaJ.size() > 0))
    {
      paramLinkedList = com.tencent.mm.plugin.ipcall.a.a.apc(paramLinkedList);
      Iterator localIterator = this.vaJ.iterator();
      ecc localecc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localecc = (ecc)localIterator.next();
      } while ((localecc == null) || (!localecc.jge.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.vaE.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.vaE.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void aoK(String paramString)
  {
    AppMethodBeat.i(25598);
    this.vaG = paramString;
    if (this.vay != null) {
      this.vay.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void dhj()
  {
    AppMethodBeat.i(25602);
    this.vaN.removeCallbacks(this.vaM);
    this.vaN.postDelayed(this.vaM, 500L);
    AppMethodBeat.o(25602);
  }
  
  public final void ed(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.vaz.setText(paramString);
    if (!bu.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.vaO)
      {
        if ((paramInt <= 0) || (paramInt > this.vaz.getText().length())) {
          break label73;
        }
        this.vaz.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.vaH = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.vaz.setSelection(this.vaz.getText().length());
    }
  }
  
  public static abstract interface a
  {
    public abstract void aoL(String paramString);
    
    public abstract void aoM(String paramString);
    
    public abstract void q(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */