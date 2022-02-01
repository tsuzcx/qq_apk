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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.eal;
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
  MMActivity fLP;
  String hGZ;
  TextView hbU;
  private ba jpn;
  a uOK;
  private DialPad uOL;
  TextView uOM;
  EditText uON;
  View uOO;
  private ImageButton uOP;
  View uOQ;
  TextView uOR;
  TextView uOS;
  String uOT;
  String uOU;
  String uOV;
  String uOW;
  LinkedList<eal> uOX;
  long uOY;
  boolean uOZ;
  private Runnable uPa;
  private ap uPb;
  boolean uPc;
  private TextWatcher uPd;
  String uPe;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(25597);
    this.uOV = "";
    this.uOY = 0L;
    this.uOZ = false;
    this.uPa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25586);
        if (System.currentTimeMillis() - b.this.uOY >= 500L)
        {
          b.this.uOW = com.tencent.mm.plugin.ipcall.a.a.aL(b.this.fLP, b.this.uOU + b.this.uOV);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25584);
              if ((this.uPg != null) && (this.uPg.systemRowid != -1L))
              {
                b.this.hbU.setText(this.uPg.field_systemAddressBookUsername);
                AppMethodBeat.o(25584);
                return;
              }
              b.this.hbU.setText("");
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
            b.this.hbU.setText("");
            b.this.uOW = null;
            b.this.hGZ = null;
            AppMethodBeat.o(25585);
          }
        });
        AppMethodBeat.o(25586);
      }
    };
    this.uPb = new ap("IPCallDialQueryPhoneNumber");
    this.uPc = false;
    this.uPd = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(25588);
        paramAnonymousEditable = b.this.uOM.getText().toString().replace("+", "");
        if ((paramAnonymousEditable.startsWith("0")) || (paramAnonymousEditable.startsWith("*")) || (paramAnonymousEditable.startsWith("#")))
        {
          b.this.uOM.setText("+");
          b.this.uOU = "+";
        }
        AppMethodBeat.o(25588);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(25587);
        if (b.this.uOQ.getLayoutParams() != null)
        {
          paramAnonymousCharSequence = b.this.uOM.getPaint();
          if ("+".equals(b.this.uOM.getText().toString()))
          {
            paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.uOM.getText().toString());
            b.this.uOO.setVisibility(8);
            b.this.uOR.setVisibility(8);
            paramAnonymousCharSequence = (RelativeLayout.LayoutParams)b.this.uOQ.getLayoutParams();
            paramAnonymousCharSequence.width = paramAnonymousInt1;
            b.this.uOQ.setLayoutParams(paramAnonymousCharSequence);
          }
        }
        else
        {
          paramAnonymousCharSequence = b.this.uOM.getText().toString().replace("+", "");
          if (!com.tencent.mm.plugin.ipcall.a.a.aoc(paramAnonymousCharSequence)) {
            break label364;
          }
          b.this.uOR.setText(com.tencent.mm.plugin.ipcall.a.a.anZ(paramAnonymousCharSequence));
          if ((b.this.uOX == null) || (b.this.uOX.size() <= 0)) {
            break label386;
          }
          String str = com.tencent.mm.plugin.ipcall.a.a.aoa(paramAnonymousCharSequence);
          Iterator localIterator = b.this.uOX.iterator();
          while (localIterator.hasNext())
          {
            eal localeal = (eal)localIterator.next();
            if ((localeal != null) && (localeal.jdl.equals(str)))
            {
              paramAnonymousInt1 = 1;
              label255:
              if (paramAnonymousInt1 == 0) {
                break label391;
              }
              b.this.uOS.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (b.this.uOK != null) {
            b.this.uOK.anJ(paramAnonymousCharSequence);
          }
          AppMethodBeat.o(25587);
          return;
          paramAnonymousInt1 = (int)paramAnonymousCharSequence.measureText(b.this.uOM.getText() + "+");
          b.this.uOO.setVisibility(0);
          b.this.uOR.setVisibility(0);
          break;
          paramAnonymousInt1 = 0;
          break label255;
          label364:
          b.this.uOR.setText(b.this.fLP.getString(2131760439));
          label386:
          paramAnonymousInt1 = 0;
          break label255;
          label391:
          b.this.uOS.setVisibility(8);
        }
      }
    };
    this.uPe = "";
    this.fLP = paramMMActivity;
    this.uON = paramEditText;
    this.uOM = paramTextView1;
    this.uOO = paramView1;
    this.uOL = paramDialPad;
    this.uOP = paramImageButton;
    this.hbU = paramTextView2;
    this.uOQ = paramView2;
    this.uOR = paramTextView3;
    this.uOS = paramTextView4;
    this.jpn = new ba();
    this.uOU = com.tencent.mm.plugin.ipcall.a.c.dff();
    paramMMActivity = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bt.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.uOT = paramMMActivity;
      this.uOM.addTextChangedListener(this.uPd);
      this.uOM.setText("+" + this.uOU);
      this.uOL.setDialButtonClickListener(new DialPad.a()
      {
        public final void anG(String paramAnonymousString)
        {
          AppMethodBeat.i(25589);
          b.this.uOV = b.this.uON.getText().toString();
          if (b.this.uOZ)
          {
            b.this.uOU += paramAnonymousString;
            b.this.uOM.setText(b.this.uOU);
            if ((com.tencent.mm.plugin.ipcall.a.a.aoc(b.this.uOU.replace("+", ""))) || (b.this.uOU.replace("+", "").length() >= 4))
            {
              g.yhR.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
              b.this.uOZ = false;
              b.this.uOT = com.tencent.mm.plugin.ipcall.a.a.anZ(b.this.uOU.replace("+", ""));
              b.this.uOV = b.hx(b.this.uOU.replace("+", ""), b.this.uOV);
              b.this.dX(b.this.uOV, -1);
              AppMethodBeat.o(25589);
            }
          }
          else
          {
            String str = b.this.uOM.getText().toString().replace("+", "");
            if (!b.this.uPc) {
              break label726;
            }
            StringBuffer localStringBuffer = new StringBuffer(b.this.uOV);
            localStringBuffer.insert(b.this.uON.getSelectionStart(), paramAnonymousString);
            b.this.uOV = localStringBuffer.toString();
            if (b.this.uOV.equals("00"))
            {
              b.this.uOM.setText("+");
              b.this.uOZ = true;
              b.this.uOU = "+";
              b.this.uOV = "";
            }
            if (com.tencent.mm.plugin.ipcall.a.a.aoc(b.this.uOU.replace("+", "") + b.this.uOV))
            {
              b.this.uOM.setText("+" + b.this.uOU.replace("+", "") + b.this.uOV);
              b.this.uOT = com.tencent.mm.plugin.ipcall.a.a.anZ(b.this.uOU.replace("+", ""));
              b.this.uOZ = false;
              b.this.uOU = (b.this.uOU.replace("+", "") + b.this.uOV);
              b.this.uOV = "";
            }
            paramAnonymousString = b.this.uOV;
            b.this.uOV = b.hx(str, b.this.uOV);
            if (!b.this.uPc) {
              break label868;
            }
            if (paramAnonymousString.length() >= b.this.uOV.length()) {
              break label760;
            }
            b.this.dX(b.this.uOV, b.this.uON.getSelectionEnd() + 2);
          }
          label726:
          label868:
          for (;;)
          {
            b.this.uOY = System.currentTimeMillis();
            if ((b.this.uOV.length() > com.tencent.mm.plugin.ipcall.a.a.uVI) && (!bt.isNullOrNil(b.this.uOU + b.this.uOV))) {
              b.this.der();
            }
            AppMethodBeat.o(25589);
            return;
            b.this.uOV += paramAnonymousString;
            break;
            label760:
            if (paramAnonymousString.length() == b.this.uOV.length())
            {
              b.this.dX(b.this.uOV, b.this.uON.getSelectionEnd() + 1);
            }
            else if (paramAnonymousString.length() > b.this.uOV.length())
            {
              b.this.dX(b.this.uOV, b.this.uON.getSelectionEnd() + 1 - (paramAnonymousString.length() - b.this.uOV.length()));
              continue;
              b.this.dX(b.this.uOV, -1);
            }
          }
        }
        
        public final void anH(String paramAnonymousString)
        {
          AppMethodBeat.i(25590);
          if (paramAnonymousString.equals("0"))
          {
            b.this.uOM.setText("+");
            b.this.uOZ = true;
            b.this.uOU = "+";
          }
          AppMethodBeat.o(25590);
        }
      });
      this.uOO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25591);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = b.this.uON.getText().toString();
          if (bt.isNullOrNil(paramAnonymousView))
          {
            paramAnonymousView = b.this.uOM.getText().toString();
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
              if ((bt.isNullOrNil(paramAnonymousView)) || (paramAnonymousView.equals("+"))) {
                break label148;
              }
              b.this.uOM.setText(paramAnonymousView);
              b.this.uOU = paramAnonymousView;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25591);
              return;
              label148:
              b.this.uOM.setText("+");
              b.this.uOU = "+";
              b.this.uOZ = true;
            }
          }
          int i = b.this.uON.getSelectionStart();
          if ((b.this.uPc) && (i - 1 >= 0))
          {
            paramAnonymousView = b.this.uON.getText();
            paramAnonymousView.delete(i - 1, i);
            paramAnonymousView = paramAnonymousView.toString();
            label234:
            if (bt.isNullOrNil(paramAnonymousView)) {
              break label404;
            }
            localObject = b.this.uOM.getText().toString().replace("+", "");
            if (!b.this.uPc) {
              break label373;
            }
            b.this.uOV = b.hx((String)localObject, paramAnonymousView);
            int j = b.this.uOV.length();
            int k = paramAnonymousView.length();
            b.this.dX(b.this.uOV, j - k + (i - 1));
            label327:
            b.this.der();
          }
          for (;;)
          {
            b.this.uOW = "";
            b.this.hbU.setText("");
            break;
            paramAnonymousView = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);
            break label234;
            label373:
            b.this.uOV = b.hx((String)localObject, paramAnonymousView);
            b.this.dX(b.this.uOV, -1);
            break label327;
            label404:
            b.this.uOV = "";
            b.this.dX("", -1);
          }
        }
      });
      this.uOO.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          if (b.this.uOZ)
          {
            b.this.uOU = "+";
            b.this.uOM.setText(b.this.uOU);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25592);
            return true;
            b.this.hbU.setText("");
            b.this.uOV = "";
            b.this.dX("", -1);
          }
        }
      });
      this.uOM.setOnClickListener(new b.6(this));
      this.uOP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25594);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          b localb = b.this;
          localb.uOU = localb.uOM.getText().toString();
          localb.uOV = localb.uON.getText().toString();
          if ((!bt.isNullOrNil(localb.uOU)) && (!bt.isNullOrNil(localb.uOV)))
          {
            localb.uOU = localb.uOM.getText().toString().replace("+", "");
            localb.uOW = com.tencent.mm.plugin.ipcall.a.a.aL(localb.fLP, localb.uOU + localb.uOV);
            localb.hGZ = com.tencent.mm.plugin.ipcall.a.a.aN(localb.fLP, localb.uOW);
            paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.aoj(localb.uOV);
            localObject = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramAnonymousView);
            ((SharedPreferences.Editor)localObject).apply();
            String str = localb.uOM.getText().toString();
            localObject = localb.uOT;
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
            if (localb.uOK != null) {
              localb.uOK.q(localb.uOU, com.tencent.mm.plugin.ipcall.a.c.aoj(localb.uOV), localb.uOW, localb.hGZ);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25594);
            return;
            paramAnonymousView = aj.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              paramAnonymousView = com.tencent.mm.plugin.ipcall.a.c.aoj(paramAnonymousView);
              localb.uOV = b.hx(localb.uOM.getText().toString().replace("+", ""), paramAnonymousView);
              localb.dX(localb.uOV, -1);
              localb.der();
            }
          }
        }
      });
      this.uON.setHorizontallyScrolling(true);
      this.uON.setOnClickListener(new b.8(this));
      this.uON.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25596);
          String str = bt.aoj(paramAnonymousCharSequence.toString());
          if (str.contains(" "))
          {
            paramAnonymousCharSequence = str.replace(" ", "");
            b.this.uON.setText(bt.aj(paramAnonymousCharSequence));
            if (!com.tencent.mm.plugin.ipcall.a.a.aod(paramAnonymousCharSequence)) {
              break label209;
            }
            str = com.tencent.mm.plugin.ipcall.a.a.aob(paramAnonymousCharSequence);
            if (!bt.isNullOrNil(str))
            {
              b.this.uOM.setText("+".concat(String.valueOf(str)));
              b.this.uON.setText(com.tencent.mm.plugin.ipcall.a.a.aog(paramAnonymousCharSequence));
            }
          }
          for (;;)
          {
            if (b.this.uOK != null) {
              b.this.uOK.anK(b.this.uON.getText().toString());
            }
            AppMethodBeat.o(25596);
            return;
            if (b.this.uPe.equals(str))
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
            b.this.uPe = str;
            b.this.uON.setText("");
            paramAnonymousCharSequence = str;
            break;
            label209:
            if (!paramAnonymousCharSequence.equals(b.this.uPe))
            {
              b.this.uPe = paramAnonymousCharSequence;
              b.this.uON.setText(paramAnonymousCharSequence);
              if (bt.isNullOrNil(b.this.uOM.getText().toString())) {
                b.this.uOM.setText("+" + com.tencent.mm.plugin.ipcall.a.a.dfb());
              }
            }
          }
        }
      });
      if (com.tencent.mm.compatible.util.d.ly(16))
      {
        this.uOM.setTypeface(Typeface.create("sans-serif-light", 0));
        this.uON.setTypeface(Typeface.create("sans-serif-light", 0));
        this.hbU.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(25597);
      return;
      paramMMActivity = com.tencent.mm.plugin.ipcall.a.a.anZ(com.tencent.mm.plugin.ipcall.a.a.dfb());
    }
  }
  
  static String hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25600);
    paramString1 = ba.formatNumber(paramString1, com.tencent.mm.plugin.ipcall.a.c.aoj(paramString2));
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(25600);
      return paramString2;
    }
    AppMethodBeat.o(25600);
    return paramString1;
  }
  
  public final void aG(LinkedList<eal> paramLinkedList)
  {
    AppMethodBeat.i(25599);
    this.uOX = paramLinkedList;
    paramLinkedList = this.uOM.getText().toString().replace("+", "");
    if ((com.tencent.mm.plugin.ipcall.a.a.aoc(paramLinkedList)) && (this.uOX != null) && (this.uOX.size() > 0))
    {
      paramLinkedList = com.tencent.mm.plugin.ipcall.a.a.aoa(paramLinkedList);
      Iterator localIterator = this.uOX.iterator();
      eal localeal;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localeal = (eal)localIterator.next();
      } while ((localeal == null) || (!localeal.jdl.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uOS.setVisibility(0);
        AppMethodBeat.o(25599);
        return;
      }
      this.uOS.setVisibility(8);
      AppMethodBeat.o(25599);
      return;
    }
  }
  
  public final void anI(String paramString)
  {
    AppMethodBeat.i(25598);
    this.uOU = paramString;
    if (this.uOM != null) {
      this.uOM.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(25598);
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(25601);
    this.uON.setText(paramString);
    if (!bt.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.uPc)
      {
        if ((paramInt <= 0) || (paramInt > this.uON.getText().length())) {
          break label73;
        }
        this.uON.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.uOV = paramString;
      AppMethodBeat.o(25601);
      return;
      label73:
      this.uON.setSelection(this.uON.getText().length());
    }
  }
  
  public final void der()
  {
    AppMethodBeat.i(25602);
    this.uPb.removeCallbacks(this.uPa);
    this.uPb.postDelayed(this.uPa, 500L);
    AppMethodBeat.o(25602);
  }
  
  public static abstract interface a
  {
    public abstract void anJ(String paramString);
    
    public abstract void anK(String paramString);
    
    public abstract void q(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */