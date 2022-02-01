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
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fgv;
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
  a DTa;
  private DialPad DTb;
  TextView DTc;
  EditText DTd;
  View DTe;
  private ImageButton DTf;
  View DTg;
  TextView DTh;
  TextView DTi;
  String DTj;
  String DTk;
  String DTl;
  String DTm;
  LinkedList<fgv> DTn;
  long DTo;
  boolean DTp;
  private Runnable DTq;
  private MMHandler DTr;
  boolean DTs;
  private TextWatcher DTt;
  String DTu;
  MMActivity iXq;
  TextView kMa;
  String luD;
  private PhoneFormater nii;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.DTl = "";
    this.DTo = 0L;
    this.DTp = false;
    this.DTq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.DTo >= 500L)
        {
          b.this.DTm = com.tencent.mm.plugin.ipcall.a.a.bm(b.this.iXq, b.this.DTk + b.this.DTl);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.DTw != null) && (this.DTw.systemRowid != -1L))
              {
                b.this.kMa.setText(this.DTw.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.kMa.setText("");
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
            b.this.kMa.setText("");
            b.this.DTm = null;
            b.this.luD = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.DTr = new MMHandler("IPCallDialQueryPhoneNumber");
    this.DTs = false;
    this.DTt = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.DTc.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.DTc.setText("+");
          b.this.DTk = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.DTg.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.DTc.getPaint();
          if ("+".equals(b.this.DTc.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.DTc.getText().toString());
            b.this.DTe.setVisibility(8);
            b.this.DTh.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.DTg.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.DTg.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.DTc.getText().toString().replace("+", "");
          if (!com.tencent.mm.plugin.ipcall.a.a.aME(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.DTh.setText(com.tencent.mm.plugin.ipcall.a.a.aMC(paramAnonymousCharSequence));
          if ((b.this.DTn == null) || (b.this.DTn.size() <= 0)) {
            break label387;
          }
          String str = com.tencent.mm.plugin.ipcall.a.a.aMD(paramAnonymousCharSequence);
          Iterator localIterator = b.this.DTn.iterator();
          while (localIterator.hasNext())
          {
            fgv localfgv = (fgv)localIterator.next();
            if ((localfgv != null) && (localfgv.mVH.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label392;
              }
              b.this.DTi.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.DTa != null) {
            b.this.DTa.aMm(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.DTc.getText() + "+");
          b.this.DTe.setVisibility(0);
          b.this.DTh.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.DTh.setText(b.this.iXq.getString(R.l.eID));
          label387:
          paramAnonymousInt1 = 0;
          break label255;
          label392:
          b.this.DTi.setVisibility(8);
        }
      }
    };
    this.DTu = "";
    this.iXq = paramMMActivity;
    this.DTd = paramEditText;
    this.DTc = paramTextView1;
    this.DTe = paramView1;
    this.DTb = paramDialPad;
    this.DTf = paramImageButton;
    this.kMa = paramTextView2;
    this.DTg = paramView2;
    this.DTh = paramTextView3;
    this.DTi = paramTextView4;
    this.nii = new PhoneFormater();
    this.DTk = com.tencent.mm.plugin.ipcall.a.c.eKM();
    paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!Util.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.DTj = paramMMActivity;
      this.DTc.addTextChangedListener(this.DTt);
      this.DTc.setText("+" + this.DTk);
      this.DTb.setDialButtonClickListener(new DialPad.a()
      {
        public final void aMj(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.DTl = b.this.DTd.getText().toString();
          if (b.this.DTp)
          {
            b.this.DTk += paramAnonymousString;
            b.this.DTc.setText(b.this.DTk);
            if ((com.tencent.mm.plugin.ipcall.a.a.aME(b.this.DTk.replace("+", ""))) || (b.this.DTk.replace("+", "").length() >= 4))
            {
              h.IzE.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.DTp = false;
              b.this.DTj = com.tencent.mm.plugin.ipcall.a.a.aMC(b.this.DTk.replace("+", ""));
              b.this.DTl = b.this.iz(b.this.DTk.replace("+", ""), b.this.DTl);
              b.this.eS(b.this.DTl, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.DTc.getText().toString().replace("+", "");
            if (!b.this.DTs) {
              break label734;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.DTl);
            localStringBuffer.insert(b.this.DTd.getSelectionStart(), paramAnonymousString);
            b.this.DTl = localStringBuffer.toString();
            if (b.this.DTl.equals("00"))
            {
              b.this.DTc.setText("+");
              b.this.DTp = true;
              b.this.DTk = "+";
              b.this.DTl = "";
            }
            if (com.tencent.mm.plugin.ipcall.a.a.aME(b.this.DTk.replace("+", "") + b.this.DTl))
            {
              b.this.DTc.setText("+" + b.this.DTk.replace("+", "") + b.this.DTl);
              b.this.DTj = com.tencent.mm.plugin.ipcall.a.a.aMC(b.this.DTk.replace("+", ""));
              b.this.DTp = false;
              b.this.DTk = (b.this.DTk.replace("+", "") + b.this.DTl);
              b.this.DTl = "";
            }
            paramAnonymousString = b.this.DTl;
            b.this.DTl = b.this.iz(str, b.this.DTl);
            if (!b.this.DTs) {
              break label876;
            }
            if (paramAnonymousString.length() >= b.this.DTl.length()) {
              break label768;
            }
            b.this.eS(b.this.DTl, b.this.DTd.getSelectionEnd() + 2);
          }
          for (;;)
          {
            b.this.DTo = System.currentTimeMillis();
            if ((b.this.DTl.length() > com.tencent.mm.plugin.ipcall.a.a.DZM) && (!Util.isNullOrNil(b.this.DTk + b.this.DTl))) {
              b.this.eKb();
            }
            AppMethodBeat.o(25589);
            return;
            label734:
            b.this.DTl += paramAnonymousString;
            break;
            label768:
            if (paramAnonymousString.length() == b.this.DTl.length())
            {
              b.this.eS(b.this.DTl, b.this.DTd.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.DTl.length())
            {
              b.this.eS(b.this.DTl, b.this.DTd.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.DTl.length()));
              continue;
              label876:
              b.this.eS(b.this.DTl, -1);
            }
          }
        }
        
        public final void aMk(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.DTc.setText("+");
            b.this.DTp = true;
            b.this.DTk = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.DTe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = b.this.DTd.getText().toString();
          if (Util.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.DTc.getText().toString();
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((Util.isNullOrNil(paramAnonymousView)) || (paramAnonymousView.equals("+"))) {
                break label148;
              }
              b.this.DTc.setText(paramAnonymousView);
              b.this.DTk = paramAnonymousView;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25591);
              return;
              label148:
              b.this.DTc.setText("+");
              b.this.DTk = "+";
              b.this.DTp = true;
            }
          }
          int i = b.this.DTd.getSelectionStart();
          if ((b.this.DTs) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.DTd.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            label234:
            if (Util.isNullOrNil(paramAnonymousView)) {
              break label412;
            }
            localObject = b.this.DTc.getText().toString().replace("+", "");
            if (!b.this.DTs) {
              break label377;
            }
            b.this.DTl = b.this.iz((String)localObject, paramAnonymousView);
            int j = b.this.DTl.length();
            int k = paramAnonymousView.length();
            b.this.eS(b.this.DTl, j - k + (i - 1));
            label331:
            b.this.eKb();
          }
          for (;;)
          {
            b.this.DTm = "";
            b.this.kMa.setText("");
            break;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break label234;
            label377:
            b.this.DTl = b.this.iz((String)localObject, paramAnonymousView);
            b.this.eS(b.this.DTl, -1);
            break label331;
            label412:
            b.this.DTl = "";
            b.this.eS("", -1);
          }
        }
      });
      this.DTe.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          if (b.this.DTp)
          {
            b.this.DTk = "+";
            b.this.DTc.setText(b.this.DTk);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25592);
            return true;
            b.this.kMa.setText("");
            b.this.DTl = "";
            b.this.eS("", -1);
          }
        }
      });
      this.DTc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25593);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          h.IzE.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          paramAnonymousView = b.this.DTc.getText().toString().replace("+", "");
          localObject = new Intent(b.this.iXq, IPCallCountryCodeSelectUI.class);
          ((Intent)localObject).putExtra("couttry_code", paramAnonymousView);
          ((Intent)localObject).putExtra("CountryCodeUI_isShowCountryCode", true);
          b.this.iXq.startActivityForResult((Intent)localObject, 100);
          b.this.iXq.overridePendingTransition(R.a.push_up_in, -1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25593);
        }
      });
      this.DTf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          b localb = b.this;
          localb.DTk = localb.DTc.getText().toString();
          localb.DTl = localb.DTd.getText().toString();
          if ((!Util.isNullOrNil(localb.DTk)) && (!Util.isNullOrNil(localb.DTl)))
          {
            localb.DTk = localb.DTc.getText().toString().replace("+", "");
            localb.DTm = com.tencent.mm.plugin.ipcall.a.a.bm(localb.iXq, localb.DTk + localb.DTl);
            localb.luD = com.tencent.mm.plugin.ipcall.a.a.bo(localb.iXq, localb.DTm);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.DTl);
            localObject = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.DTc.getText().toString();
            localObject = localb.DTj;
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
            if (localb.DTa != null) {
              localb.DTa.z(localb.DTk, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.DTl), localb.DTm, localb.luD);
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
              localb.DTl = localb.iz(localb.DTc.getText().toString().replace("+", ""), paramAnonymousView);
              localb.eS(localb.DTl, -1);
              localb.eKb();
            }
          }
        }
      });
      this.DTd.setHorizontallyScrolling(true);
      this.DTd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25595);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.this.DTd.setCursorVisible(true);
          b.this.iXq.hideVKB();
          b.this.DTs = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25595);
        }
      });
      this.DTd.addTextChangedListener(new TextWatcher()
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
            b.this.DTd.setText(Util.filterNumber(paramAnonymousCharSequence));
            if (!com.tencent.mm.plugin.ipcall.a.a.aMF(paramAnonymousCharSequence)) {
              break label209;
            }
            str = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(paramAnonymousCharSequence);
            if (!Util.isNullOrNil(str))
            {
              b.this.DTc.setText("+".concat(String.valueOf(str)));
              b.this.DTd.setText(com.tencent.mm.plugin.ipcall.a.a.aMI(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.DTa != null) {
              b.this.DTa.aMn(b.this.DTd.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.DTu.equals(str))
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
            b.this.DTu = str;
            b.this.DTd.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.DTu))
            {
              b.this.DTu = paramAnonymousCharSequence;
              b.this.DTd.setText(paramAnonymousCharSequence);
              if (Util.isNullOrNil(b.this.DTc.getText().toString())) {
                b.this.DTc.setText("+" + com.tencent.mm.plugin.ipcall.a.a.eKI());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.qV(16))
      {
        this.DTc.setTypeface(Typeface.create("sans-serif-light", 0));
        this.DTd.setTypeface(Typeface.create("sans-serif-light", 0));
        this.kMa.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = com.tencent.mm.plugin.ipcall.a.a.aMC(com.tencent.mm.plugin.ipcall.a.a.eKI());
    }
  }
  
  public final void aMl(String paramString)
  {
    AppMethodBeat.i(25598);
    this.DTk = paramString;
    if (this.DTc != null) {
      this.DTc.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void bu(LinkedList<fgv> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.DTn = paramLinkedList;
    paramLinkedList = this.DTc.getText().toString().replace("+", "");
    if ((com.tencent.mm.plugin.ipcall.a.a.aME(paramLinkedList)) && (this.DTn != null) && (this.DTn.size() > 0))
    {
      paramLinkedList = com.tencent.mm.plugin.ipcall.a.a.aMD(paramLinkedList);
      Iterator localIterator = this.DTn.iterator();
      fgv localfgv;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localfgv = (fgv)localIterator.next();
      } while ((localfgv == null) || (!localfgv.mVH.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.DTi.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.DTi.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void eKb()
  {
    AppMethodBeat.i(25602);
    this.DTr.removeCallbacks(this.DTq);
    this.DTr.postDelayed(this.DTq, 500L);
    AppMethodBeat.o(25602);
  }
  
  public final void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.DTd.setText(paramString);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.DTs)
      {
        if ((paramInt <= 0) || (paramInt > this.DTd.getText().length())) {
          break label73;
        }
        this.DTd.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.DTl = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.DTd.setSelection(this.DTd.getText().length());
    }
  }
  
  final String iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = this.nii.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString2));
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
    public abstract void aMm(String paramString);
    
    public abstract void aMn(String paramString);
    
    public abstract void z(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */