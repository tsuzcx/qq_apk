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
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.protocal.protobuf.gdh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  private Runnable JKA;
  private MMHandler JKB;
  boolean JKC;
  private TextWatcher JKD;
  String JKE;
  a JKk;
  private DialPad JKl;
  TextView JKm;
  EditText JKn;
  View JKo;
  private ImageButton JKp;
  View JKq;
  TextView JKr;
  TextView JKs;
  String JKt;
  String JKu;
  String JKv;
  String JKw;
  LinkedList<gdh> JKx;
  long JKy;
  boolean JKz;
  MMActivity lzt;
  TextView nnW;
  String omb;
  private PhoneFormater qfC;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.JKv = "";
    this.JKy = 0L;
    this.JKz = false;
    this.JKA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.JKy >= 500L)
        {
          b.this.JKw = com.tencent.mm.plugin.ipcall.a.a.bo(b.this.lzt, b.this.JKu + b.this.JKv);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.JKG != null) && (this.JKG.systemRowid != -1L))
              {
                b.this.nnW.setText(this.JKG.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.nnW.setText("");
              AppMethodBeat.o(25584);
            }
          });
          AppMethodBeat.o(25586);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25585);
            b.this.nnW.setText("");
            b.this.JKw = null;
            b.this.omb = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.JKB = new MMHandler("IPCallDialQueryPhoneNumber");
    this.JKC = false;
    this.JKD = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.JKm.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.JKm.setText("+");
          b.this.JKu = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.JKq.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.JKm.getPaint();
          if ("+".equals(b.this.JKm.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.JKm.getText().toString());
            b.this.JKo.setVisibility(8);
            b.this.JKr.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.JKq.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.JKq.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.JKm.getText().toString().replace("+", "");
          if (!com.tencent.mm.plugin.ipcall.a.a.aJy(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.JKr.setText(com.tencent.mm.plugin.ipcall.a.a.aJw(paramAnonymousCharSequence));
          if ((b.this.JKx == null) || (b.this.JKx.size() <= 0)) {
            break label387;
          }
          String str = com.tencent.mm.plugin.ipcall.a.a.aJx(paramAnonymousCharSequence);
          Iterator localIterator = b.this.JKx.iterator();
          while (localIterator.hasNext())
          {
            gdh localgdh = (gdh)localIterator.next();
            if ((localgdh != null) && (localgdh.pSo.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label392;
              }
              b.this.JKs.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.JKk != null) {
            b.this.JKk.aJg(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.JKm.getText() + "+");
          b.this.JKo.setVisibility(0);
          b.this.JKr.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.JKr.setText(b.this.lzt.getString(R.l.gKk));
          label387:
          paramAnonymousInt1 = 0;
          break label255;
          label392:
          b.this.JKs.setVisibility(8);
        }
      }
    };
    this.JKE = "";
    this.lzt = paramMMActivity;
    this.JKn = paramEditText;
    this.JKm = paramTextView1;
    this.JKo = paramView1;
    this.JKl = paramDialPad;
    this.JKp = paramImageButton;
    this.nnW = paramTextView2;
    this.JKq = paramView2;
    this.JKr = paramTextView3;
    this.JKs = paramTextView4;
    this.qfC = new PhoneFormater();
    this.JKu = com.tencent.mm.plugin.ipcall.a.c.fSL();
    paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!Util.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.JKt = paramMMActivity;
      this.JKm.addTextChangedListener(this.JKD);
      this.JKm.setText("+" + this.JKu);
      this.JKl.setDialButtonClickListener(new DialPad.a()
      {
        public final void aJd(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.JKv = b.this.JKn.getText().toString();
          Object localObject1;
          Object localObject2;
          if (b.this.JKz)
          {
            localObject1 = b.this;
            ((b)localObject1).JKu += paramAnonymousString;
            b.this.JKm.setText(b.this.JKu);
            if ((com.tencent.mm.plugin.ipcall.a.a.aJy(b.this.JKu.replace("+", ""))) || (b.this.JKu.replace("+", "").length() >= 4))
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.JKz = false;
              b.this.JKt = com.tencent.mm.plugin.ipcall.a.a.aJw(b.this.JKu.replace("+", ""));
              b.this.JKv = b.this.jJ(b.this.JKu.replace("+", ""), b.this.JKv);
              b.this.fK(b.this.JKv, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            localObject1 = b.this.JKm.getText().toString().replace("+", "");
            if (!b.this.JKC) {
              break label733;
            }
            localObject2 = new StringBuffer(b.this.JKv);
            ((StringBuffer)localObject2).insert(b.this.JKn.getSelectionStart(), paramAnonymousString);
            b.this.JKv = ((StringBuffer)localObject2).toString();
            if (b.this.JKv.equals("00"))
            {
              b.this.JKm.setText("+");
              b.this.JKz = true;
              b.this.JKu = "+";
              b.this.JKv = "";
            }
            if (com.tencent.mm.plugin.ipcall.a.a.aJy(b.this.JKu.replace("+", "") + b.this.JKv))
            {
              b.this.JKm.setText("+" + b.this.JKu.replace("+", "") + b.this.JKv);
              b.this.JKt = com.tencent.mm.plugin.ipcall.a.a.aJw(b.this.JKu.replace("+", ""));
              b.this.JKz = false;
              b.this.JKu = (b.this.JKu.replace("+", "") + b.this.JKv);
              b.this.JKv = "";
            }
            paramAnonymousString = b.this.JKv;
            b.this.JKv = b.this.jJ((String)localObject1, b.this.JKv);
            if (!b.this.JKC) {
              break label874;
            }
            if (paramAnonymousString.length() >= b.this.JKv.length()) {
              break label766;
            }
            b.this.fK(b.this.JKv, b.this.JKn.getSelectionEnd() + 2);
          }
          label733:
          label874:
          for (;;)
          {
            b.this.JKy = System.currentTimeMillis();
            if ((b.this.JKv.length() > com.tencent.mm.plugin.ipcall.a.a.JQU) && (!Util.isNullOrNil(b.this.JKu + b.this.JKv))) {
              b.this.fSb();
            }
            AppMethodBeat.o(25589);
            return;
            localObject2 = b.this;
            ((b)localObject2).JKv += paramAnonymousString;
            break;
            label766:
            if (paramAnonymousString.length() == b.this.JKv.length())
            {
              b.this.fK(b.this.JKv, b.this.JKn.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.JKv.length())
            {
              b.this.fK(b.this.JKv, b.this.JKn.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.JKv.length()));
              continue;
              b.this.fK(b.this.JKv, -1);
            }
          }
        }
        
        public final void aJe(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.JKm.setText("+");
            b.this.JKz = true;
            b.this.JKu = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.JKo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = b.this.JKn.getText().toString();
          if (Util.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.JKm.getText().toString();
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((Util.isNullOrNil(paramAnonymousView)) || (paramAnonymousView.equals("+"))) {
                break label148;
              }
              b.this.JKm.setText(paramAnonymousView);
              b.this.JKu = paramAnonymousView;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25591);
              return;
              label148:
              b.this.JKm.setText("+");
              b.this.JKu = "+";
              b.this.JKz = true;
            }
          }
          int i = b.this.JKn.getSelectionStart();
          if ((b.this.JKC) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.JKn.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            label234:
            if (Util.isNullOrNil(paramAnonymousView)) {
              break label412;
            }
            localObject = b.this.JKm.getText().toString().replace("+", "");
            if (!b.this.JKC) {
              break label377;
            }
            b.this.JKv = b.this.jJ((String)localObject, paramAnonymousView);
            int j = b.this.JKv.length();
            int k = paramAnonymousView.length();
            b.this.fK(b.this.JKv, j - k + (i - 1));
            label331:
            b.this.fSb();
          }
          for (;;)
          {
            b.this.JKw = "";
            b.this.nnW.setText("");
            break;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break label234;
            label377:
            b.this.JKv = b.this.jJ((String)localObject, paramAnonymousView);
            b.this.fK(b.this.JKv, -1);
            break label331;
            label412:
            b.this.JKv = "";
            b.this.fK("", -1);
          }
        }
      });
      this.JKo.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          if (b.this.JKz)
          {
            b.this.JKu = "+";
            b.this.JKm.setText(b.this.JKu);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25592);
            return true;
            b.this.nnW.setText("");
            b.this.JKv = "";
            b.this.fK("", -1);
          }
        }
      });
      this.JKm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25593);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          com.tencent.mm.plugin.report.service.h.OAn.b(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          paramAnonymousView = b.this.JKm.getText().toString().replace("+", "");
          localObject = new Intent(b.this.lzt, IPCallCountryCodeSelectUI.class);
          ((Intent)localObject).putExtra("couttry_code", paramAnonymousView);
          ((Intent)localObject).putExtra("CountryCodeUI_isShowCountryCode", true);
          b.this.lzt.startActivityForResult((Intent)localObject, 100);
          b.this.lzt.overridePendingTransition(R.a.push_up_in, -1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25593);
        }
      });
      this.JKp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          b localb = b.this;
          localb.JKu = localb.JKm.getText().toString();
          localb.JKv = localb.JKn.getText().toString();
          if ((!Util.isNullOrNil(localb.JKu)) && (!Util.isNullOrNil(localb.JKv)))
          {
            localb.JKu = localb.JKm.getText().toString().replace("+", "");
            localb.JKw = com.tencent.mm.plugin.ipcall.a.a.bo(localb.lzt, localb.JKu + localb.JKv);
            localb.omb = com.tencent.mm.plugin.ipcall.a.a.bq(localb.lzt, localb.JKw);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.JKv);
            localObject = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.JKm.getText().toString();
            localObject = localb.JKt;
            if (!Util.isNullOrNil(str))
            {
              paramAnonymousView = (View)localObject;
              if (Util.isNullOrNil((String)localObject)) {
                paramAnonymousView = "";
              }
              localObject = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
              ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramAnonymousView);
              ((SharedPreferences.Editor)localObject).apply();
            }
            if (localb.JKk != null) {
              localb.JKk.C(localb.JKu, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.JKv), localb.JKw, localb.omb);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25594);
            return;
            paramAnonymousView = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramAnonymousView);
              localb.JKv = localb.jJ(localb.JKm.getText().toString().replace("+", ""), paramAnonymousView);
              localb.fK(localb.JKv, -1);
              localb.fSb();
            }
          }
        }
      });
      this.JKn.setHorizontallyScrolling(true);
      this.JKn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25595);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          b.this.JKn.setCursorVisible(true);
          b.this.lzt.hideVKB();
          b.this.JKC = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25595);
        }
      });
      this.JKn.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25596);
          String str = Util.trimPhoneNumber(paramAnonymousCharSequence.toString());
          if (str.contains(" "))
          {
            paramAnonymousCharSequence = str.replace(" ", "");
            b.this.JKn.setText(Util.filterNumber(paramAnonymousCharSequence));
            if (!com.tencent.mm.plugin.ipcall.a.a.aJz(paramAnonymousCharSequence)) {
              break label209;
            }
            str = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(paramAnonymousCharSequence);
            if (!Util.isNullOrNil(str))
            {
              b.this.JKm.setText("+".concat(String.valueOf(str)));
              b.this.JKn.setText(com.tencent.mm.plugin.ipcall.a.a.aJC(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.JKk != null) {
              b.this.JKk.aJh(b.this.JKn.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.JKE.equals(str))
            {
              paramAnonymousCharSequence = str;
              if (paramAnonymousInt3 <= 0) {
                break;
              }
            }
            paramAnonymousCharSequence = str;
            if (!Util.isNullOrNil(str)) {
              break;
            }
            b.this.JKE = str;
            b.this.JKn.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.JKE))
            {
              b.this.JKE = paramAnonymousCharSequence;
              b.this.JKn.setText(paramAnonymousCharSequence);
              if (Util.isNullOrNil(b.this.JKm.getText().toString())) {
                b.this.JKm.setText("+" + com.tencent.mm.plugin.ipcall.a.a.fSI());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.rb(16))
      {
        this.JKm.setTypeface(Typeface.create("sans-serif-light", 0));
        this.JKn.setTypeface(Typeface.create("sans-serif-light", 0));
        this.nnW.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = com.tencent.mm.plugin.ipcall.a.a.aJw(com.tencent.mm.plugin.ipcall.a.a.fSI());
    }
  }
  
  public final void aJf(String paramString)
  {
    AppMethodBeat.i(25598);
    this.JKu = paramString;
    if (this.JKm != null) {
      this.JKm.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void bB(LinkedList<gdh> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.JKx = paramLinkedList;
    paramLinkedList = this.JKm.getText().toString().replace("+", "");
    if ((com.tencent.mm.plugin.ipcall.a.a.aJy(paramLinkedList)) && (this.JKx != null) && (this.JKx.size() > 0))
    {
      paramLinkedList = com.tencent.mm.plugin.ipcall.a.a.aJx(paramLinkedList);
      Iterator localIterator = this.JKx.iterator();
      gdh localgdh;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localgdh = (gdh)localIterator.next();
      } while ((localgdh == null) || (!localgdh.pSo.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.JKs.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.JKs.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void fK(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.JKn.setText(paramString);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.JKC)
      {
        if ((paramInt <= 0) || (paramInt > this.JKn.getText().length())) {
          break label73;
        }
        this.JKn.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.JKv = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.JKn.setSelection(this.JKn.getText().length());
    }
  }
  
  public final void fSb()
  {
    AppMethodBeat.i(25602);
    this.JKB.removeCallbacks(this.JKA);
    this.JKB.postDelayed(this.JKA, 500L);
    AppMethodBeat.o(25602);
  }
  
  final String jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = this.qfC.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString2));
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void C(String paramString1, String paramString2, String paramString3, String paramString4);
    
    public abstract void aJg(String paramString);
    
    public abstract void aJh(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */