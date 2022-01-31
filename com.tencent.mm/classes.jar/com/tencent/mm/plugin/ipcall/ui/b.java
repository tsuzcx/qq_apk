package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  MMActivity cmc;
  String fmP;
  private av gIk;
  TextView gqe;
  private ImageButton nQA;
  View nQB;
  TextView nQC;
  TextView nQD;
  String nQE;
  String nQF;
  String nQG;
  String nQH;
  LinkedList<cuz> nQI;
  long nQJ;
  boolean nQK;
  private Runnable nQL;
  private al nQM;
  boolean nQN;
  private TextWatcher nQO;
  String nQP;
  b.a nQv;
  private DialPad nQw;
  TextView nQx;
  EditText nQy;
  View nQz;
  
  public b(MMActivity paramMMActivity, EditText paramEditText, TextView paramTextView1, View paramView1, DialPad paramDialPad, ImageButton paramImageButton, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4)
  {
    AppMethodBeat.i(21980);
    this.nQG = "";
    this.nQJ = 0L;
    this.nQK = false;
    this.nQL = new b.1(this);
    this.nQM = new al("IPCallDialQueryPhoneNumber");
    this.nQN = false;
    this.nQO = new b.2(this);
    this.nQP = "";
    this.cmc = paramMMActivity;
    this.nQy = paramEditText;
    this.nQx = paramTextView1;
    this.nQz = paramView1;
    this.nQw = paramDialPad;
    this.nQA = paramImageButton;
    this.gqe = paramTextView2;
    this.nQB = paramView2;
    this.nQC = paramTextView3;
    this.nQD = paramTextView4;
    this.gIk = new av();
    this.nQF = c.bKM();
    paramMMActivity = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
    if (!bo.isNullOrNil(paramMMActivity)) {}
    for (;;)
    {
      this.nQE = paramMMActivity;
      this.nQx.addTextChangedListener(this.nQO);
      this.nQx.setText("+" + this.nQF);
      this.nQw.setDialButtonClickListener(new b.3(this));
      this.nQz.setOnClickListener(new b.4(this));
      this.nQz.setOnLongClickListener(new b.5(this));
      this.nQx.setOnClickListener(new b.6(this));
      this.nQA.setOnClickListener(new b.7(this));
      this.nQy.setHorizontallyScrolling(true);
      this.nQy.setOnClickListener(new b.8(this));
      this.nQy.addTextChangedListener(new b.9(this));
      if (d.fv(16))
      {
        this.nQx.setTypeface(Typeface.create("sans-serif-light", 0));
        this.nQy.setTypeface(Typeface.create("sans-serif-light", 0));
        this.gqe.setTypeface(Typeface.create("sans-serif-light", 0));
      }
      AppMethodBeat.o(21980);
      return;
      paramMMActivity = a.RA(a.bKI());
    }
  }
  
  static String eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21983);
    paramString1 = av.formatNumber(paramString1, c.RK(paramString2));
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(21983);
      return paramString2;
    }
    AppMethodBeat.o(21983);
    return paramString1;
  }
  
  public final void Rj(String paramString)
  {
    AppMethodBeat.i(21981);
    this.nQF = paramString;
    if (this.nQx != null) {
      this.nQx.setText("+".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(21981);
  }
  
  public final void ai(LinkedList<cuz> paramLinkedList)
  {
    AppMethodBeat.i(21982);
    this.nQI = paramLinkedList;
    paramLinkedList = this.nQx.getText().toString().replace("+", "");
    if ((a.RD(paramLinkedList)) && (this.nQI != null) && (this.nQI.size() > 0))
    {
      paramLinkedList = a.RB(paramLinkedList);
      Iterator localIterator = this.nQI.iterator();
      cuz localcuz;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localcuz = (cuz)localIterator.next();
      } while ((localcuz == null) || (!localcuz.gwY.equals(paramLinkedList)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.nQD.setVisibility(0);
        AppMethodBeat.o(21982);
        return;
      }
      this.nQD.setVisibility(8);
      AppMethodBeat.o(21982);
      return;
    }
  }
  
  public final void bJZ()
  {
    AppMethodBeat.i(21985);
    this.nQM.caB().removeCallbacks(this.nQL);
    this.nQM.o(this.nQL, 500L);
    AppMethodBeat.o(21985);
  }
  
  public final void cy(String paramString, int paramInt)
  {
    AppMethodBeat.i(21984);
    this.nQy.setText(paramString);
    if (!bo.isNullOrNil(paramString))
    {
      if (paramInt == -1) {
        break label73;
      }
      if (this.nQN)
      {
        if ((paramInt <= 0) || (paramInt > this.nQy.getText().length())) {
          break label73;
        }
        this.nQy.setSelection(paramInt);
      }
    }
    for (;;)
    {
      this.nQG = paramString;
      AppMethodBeat.o(21984);
      return;
      label73:
      this.nQy.setSelection(this.nQy.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b
 * JD-Core Version:    0.7.0.1
 */