package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ewj;
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
  MMActivity gte;
  TextView hXv;
  String iEB;
  private PhoneFormater kqv;
  b.a ysW;
  private DialPad ysX;
  TextView ysY;
  EditText ysZ;
  View yta;
  private ImageButton ytb;
  View ytc;
  TextView ytd;
  TextView yte;
  String ytf;
  String ytg;
  String yth;
  String yti;
  LinkedList<ewj> ytj;
  long ytk;
  boolean ytl;
  private Runnable ytm;
  private MMHandler ytn;
  boolean yto;
  private TextWatcher ytp;
  String ytq;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.yth = "";
    this.ytk = 0L;
    this.ytl = false;
    this.ytm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.ytk >= 500L)
        {
          b.this.yti = com.tencent.mm.plugin.ipcall.a.a.ba(b.this.gte, b.this.ytg + b.this.yth);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.yts != null) && (this.yts.systemRowid != -1L))
              {
                b.this.hXv.setText(this.yts.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.hXv.setText("");
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
            b.this.hXv.setText("");
            b.this.yti = null;
            b.this.iEB = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.ytn = new MMHandler("IPCallDialQueryPhoneNumber");
    this.yto = false;
    this.ytp = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.ysY.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.ysY.setText("+");
          b.this.ytg = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.ytc.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.ysY.getPaint();
          if ("+".equals(b.this.ysY.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.ysY.getText().toString());
            b.this.yta.setVisibility(8);
            b.this.ytd.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.ytc.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.ytc.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.ysY.getText().toString().replace("+", "");
          if (!com.tencent.mm.plugin.ipcall.a.a.aCx(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.ytd.setText(com.tencent.mm.plugin.ipcall.a.a.aCv(paramAnonymousCharSequence));
          if ((b.this.ytj == null) || (b.this.ytj.size() <= 0)) {
            break label386;
          }
          String str = com.tencent.mm.plugin.ipcall.a.a.aCw(paramAnonymousCharSequence);
          Iterator localIterator = b.this.ytj.iterator();
          while (localIterator.hasNext())
          {
            ewj localewj = (ewj)localIterator.next();
            if ((localewj != null) && (localewj.keh.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label391;
              }
              b.this.yte.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.ysW != null) {
            b.this.ysW.aCf(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.ysY.getText() + "+");
          b.this.yta.setVisibility(0);
          b.this.ytd.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.ytd.setText(b.this.gte.getString(2131761884));
          label386:
          paramAnonymousInt1 = 0;
          break label255;
          label391:
          b.this.yte.setVisibility(8);
        }
      }
    };
    this.ytq = "";
    this.gte = paramMMActivity;
    this.ysZ = paramEditText;
    this.ysY = paramTextView1;
    this.yta = paramView1;
    this.ysX = paramDialPad;
    this.ytb = paramImageButton;
    this.hXv = paramTextView2;
    this.ytc = paramView2;
    this.ytd = paramTextView3;
    this.yte = paramTextView4;
    this.kqv = new PhoneFormater();
    this.ytg = com.tencent.mm.plugin.ipcall.a.c.ebO();
    paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!Util.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.ytf = paramMMActivity;
      this.ysY.addTextChangedListener(this.ytp);
      this.ysY.setText("+" + this.ytg);
      this.ysX.setDialButtonClickListener(new DialPad.a()
      {
        public final void aCc(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.yth = b.this.ysZ.getText().toString();
          if (b.this.ytl)
          {
            b.this.ytg += paramAnonymousString;
            b.this.ysY.setText(b.this.ytg);
            if ((com.tencent.mm.plugin.ipcall.a.a.aCx(b.this.ytg.replace("+", ""))) || (b.this.ytg.replace("+", "").length() >= 4))
            {
              h.CyF.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.ytl = false;
              b.this.ytf = com.tencent.mm.plugin.ipcall.a.a.aCv(b.this.ytg.replace("+", ""));
              b.this.yth = b.this.im(b.this.ytg.replace("+", ""), b.this.yth);
              b.this.es(b.this.yth, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.ysY.getText().toString().replace("+", "");
            if (!b.this.yto) {
              break label734;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.yth);
            localStringBuffer.insert(b.this.ysZ.getSelectionStart(), paramAnonymousString);
            b.this.yth = localStringBuffer.toString();
            if (b.this.yth.equals("00"))
            {
              b.this.ysY.setText("+");
              b.this.ytl = true;
              b.this.ytg = "+";
              b.this.yth = "";
            }
            if (com.tencent.mm.plugin.ipcall.a.a.aCx(b.this.ytg.replace("+", "") + b.this.yth))
            {
              b.this.ysY.setText("+" + b.this.ytg.replace("+", "") + b.this.yth);
              b.this.ytf = com.tencent.mm.plugin.ipcall.a.a.aCv(b.this.ytg.replace("+", ""));
              b.this.ytl = false;
              b.this.ytg = (b.this.ytg.replace("+", "") + b.this.yth);
              b.this.yth = "";
            }
            paramAnonymousString = b.this.yth;
            b.this.yth = b.this.im(str, b.this.yth);
            if (!b.this.yto) {
              break label876;
            }
            if (paramAnonymousString.length() >= b.this.yth.length()) {
              break label768;
            }
            b.this.es(b.this.yth, b.this.ysZ.getSelectionEnd() + 2);
          }
          for (;;)
          {
            b.this.ytk = System.currentTimeMillis();
            if ((b.this.yth.length() > com.tencent.mm.plugin.ipcall.a.a.yzU) && (!Util.isNullOrNil(b.this.ytg + b.this.yth))) {
              b.this.ebd();
            }
            AppMethodBeat.o(25589);
            return;
            label734:
            b.this.yth += paramAnonymousString;
            break;
            label768:
            if (paramAnonymousString.length() == b.this.yth.length())
            {
              b.this.es(b.this.yth, b.this.ysZ.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.yth.length())
            {
              b.this.es(b.this.yth, b.this.ysZ.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.yth.length()));
              continue;
              label876:
              b.this.es(b.this.yth, -1);
            }
          }
        }
        
        public final void aCd(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.ysY.setText("+");
            b.this.ytl = true;
            b.this.ytg = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.yta.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = b.this.ysZ.getText().toString();
          if (Util.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.ysY.getText().toString();
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((Util.isNullOrNil(paramAnonymousView)) || (paramAnonymousView.equals("+"))) {
                break label148;
              }
              b.this.ysY.setText(paramAnonymousView);
              b.this.ytg = paramAnonymousView;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25591);
              return;
              label148:
              b.this.ysY.setText("+");
              b.this.ytg = "+";
              b.this.ytl = true;
            }
          }
          int i = b.this.ysZ.getSelectionStart();
          if ((b.this.yto) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.ysZ.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            label234:
            if (Util.isNullOrNil(paramAnonymousView)) {
              break label412;
            }
            localObject = b.this.ysY.getText().toString().replace("+", "");
            if (!b.this.yto) {
              break label377;
            }
            b.this.yth = b.this.im((String)localObject, paramAnonymousView);
            int j = b.this.yth.length();
            int k = paramAnonymousView.length();
            b.this.es(b.this.yth, j - k + (i - 1));
            label331:
            b.this.ebd();
          }
          for (;;)
          {
            b.this.yti = "";
            b.this.hXv.setText("");
            break;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break label234;
            label377:
            b.this.yth = b.this.im((String)localObject, paramAnonymousView);
            b.this.es(b.this.yth, -1);
            break label331;
            label412:
            b.this.yth = "";
            b.this.es("", -1);
          }
        }
      });
      this.yta.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          if (b.this.ytl)
          {
            b.this.ytg = "+";
            b.this.ysY.setText(b.this.ytg);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25592);
            return true;
            b.this.hXv.setText("");
            b.this.yth = "";
            b.this.es("", -1);
          }
        }
      });
      this.ysY.setOnClickListener(new b.6(this));
      this.ytb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          b localb = b.this;
          localb.ytg = localb.ysY.getText().toString();
          localb.yth = localb.ysZ.getText().toString();
          if ((!Util.isNullOrNil(localb.ytg)) && (!Util.isNullOrNil(localb.yth)))
          {
            localb.ytg = localb.ysY.getText().toString().replace("+", "");
            localb.yti = com.tencent.mm.plugin.ipcall.a.a.ba(localb.gte, localb.ytg + localb.yth);
            localb.iEB = com.tencent.mm.plugin.ipcall.a.a.bc(localb.gte, localb.yti);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.yth);
            localObject = MMApplicationContext.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.ysY.getText().toString();
            localObject = localb.ytf;
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
            if (localb.ysW != null) {
              localb.ysW.u(localb.ytg, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(localb.yth), localb.yti, localb.iEB);
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
              localb.yth = localb.im(localb.ysY.getText().toString().replace("+", ""), paramAnonymousView);
              localb.es(localb.yth, -1);
              localb.ebd();
            }
          }
        }
      });
      this.ysZ.setHorizontallyScrolling(true);
      this.ysZ.setOnClickListener(new b.8(this));
      this.ysZ.addTextChangedListener(new b.9(this));
      if (com.tencent.mm.compatible.util.d.oD(16))
      {
        this.ysY.setTypeface(Typeface.create("sans-serif-light", 0));
        this.ysZ.setTypeface(Typeface.create("sans-serif-light", 0));
        this.hXv.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = com.tencent.mm.plugin.ipcall.a.a.aCv(com.tencent.mm.plugin.ipcall.a.a.ebK());
    }
  }
  
  public final void aCe(String paramString)
  {
    AppMethodBeat.i(25598);
    this.ytg = paramString;
    if (this.ysY != null) {
      this.ysY.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void bb(LinkedList<ewj> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.ytj = paramLinkedList;
    paramLinkedList = this.ysY.getText().toString().replace("+", "");
    if ((com.tencent.mm.plugin.ipcall.a.a.aCx(paramLinkedList)) && (this.ytj != null) && (this.ytj.size() > 0))
    {
      paramLinkedList = com.tencent.mm.plugin.ipcall.a.a.aCw(paramLinkedList);
      Iterator localIterator = this.ytj.iterator();
      ewj localewj;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localewj = (ewj)localIterator.next();
      } while ((localewj == null) || (!localewj.keh.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.yte.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.yte.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void ebd()
  {
    AppMethodBeat.i(25602);
    this.ytn.removeCallbacks(this.ytm);
    this.ytn.postDelayed(this.ytm, 500L);
    AppMethodBeat.o(25602);
  }
  
  public final void es(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.ysZ.setText(paramString);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.yto)
      {
        if ((paramInt <= 0) || (paramInt > this.ysZ.getText().length())) {
          break label73;
        }
        this.ysZ.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.yth = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.ysZ.setSelection(this.ysZ.getText().length());
    }
  }
  
  final String im(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = this.kqv.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString2));
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */